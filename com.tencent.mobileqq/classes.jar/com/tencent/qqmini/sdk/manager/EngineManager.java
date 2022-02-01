package com.tencent.qqmini.sdk.manager;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.util.SparseArray;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.EngineChannel;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EngineManager
{
  public static final String LOG_TAG = "EngineManager";
  private static volatile EngineManager sInstance;
  private SparseArray<EngineChannel> mChannels;
  private SparseArray<EngineInstaller> mEngineInstallers;
  private SparseArray<EngineChannel> mOutChannels;
  
  private EngineManager()
  {
    QMLog.i("EngineManager", "[MiniEng]init start");
    long l = System.currentTimeMillis();
    this.mEngineInstallers = new SparseArray();
    this.mChannels = new SparseArray();
    Object localObject = new EngineChannel();
    ((EngineChannel)localObject).setName("MainGame");
    ((EngineChannel)localObject).setReceiver(new EngineManager.EngineChannelReceiver(this));
    this.mChannels.put(2, localObject);
    localObject = new EngineChannel();
    ((EngineChannel)localObject).setName("MainApp");
    ((EngineChannel)localObject).setReceiver(new EngineManager.EngineChannelReceiver(this));
    this.mChannels.put(3, localObject);
    this.mOutChannels = new SparseArray();
    EngineInstaller.updateInstalledEngine();
    EngineInstaller.removeOutDatedEngine(2);
    EngineInstaller.removeOldEngine(2);
    EngineInstaller.removeOldEngine(3);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MiniEng]init end cost=");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
    QMLog.i("EngineManager", ((StringBuilder)localObject).toString());
  }
  
  public static EngineManager g()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new EngineManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private ArrayList<Integer> getRunningPidList()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = AppLoaderFactory.g().getContext();
    if (localObject == null) {
      return localArrayList;
    }
    localObject = (ActivityManager)((Context)localObject).getSystemService("activity");
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(Integer.valueOf(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).pid));
    }
    return localArrayList;
  }
  
  private void installBaseLibForChannel(BaseLibInfo paramBaseLibInfo, EngineChannel paramEngineChannel)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng] installBaseLibForChannel ");
    localStringBuilder.append(paramBaseLibInfo);
    localStringBuilder.append(",");
    localStringBuilder.append(paramEngineChannel);
    QMLog.i("EngineManager", localStringBuilder.toString());
    installBaseLib(paramBaseLibInfo, new EngineManager.3(this, paramEngineChannel, paramBaseLibInfo));
  }
  
  private void installEngine(BaseLibInfo paramBaseLibInfo, EngineChannel paramEngineChannel)
  {
    if (paramBaseLibInfo != null)
    {
      ThreadManager.executeOnDiskIOThreadPool(new EngineManager.1(this, paramBaseLibInfo, paramEngineChannel));
      return;
    }
    paramEngineChannel.send(54, null);
  }
  
  private void preInstallLocalGameLib()
  {
    Object localObject = getEngineList(2).iterator();
    while (((Iterator)localObject).hasNext())
    {
      InstalledEngine localInstalledEngine = (InstalledEngine)((Iterator)localObject).next();
      if ((localInstalledEngine.isPersist) && (localInstalledEngine.isVerify))
      {
        QMLog.i("EngineManager", "[MiniEng] installLocalLib skip already installed");
        return;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MiniEng] installLocalGameEngine ");
    ((StringBuilder)localObject).append(LocalGameEngine.g().mLocalBaseLibInfo);
    QMLog.i("EngineManager", ((StringBuilder)localObject).toString());
    installBaseLib(LocalGameEngine.g().mLocalBaseLibInfo, null);
  }
  
  private void removeDeadChannelExcept(EngineChannel paramEngineChannel)
  {
    try
    {
      ArrayList localArrayList = getRunningPidList();
      if (this.mOutChannels != null)
      {
        int i = 0;
        while (i < this.mOutChannels.size())
        {
          int j = this.mOutChannels.keyAt(i);
          if (!localArrayList.contains(Integer.valueOf(j)))
          {
            StringBuilder localStringBuilder;
            if (((EngineChannel)this.mOutChannels.valueAt(i)).equals(paramEngineChannel))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[MiniEng] removeDeadChannelExcept error pid=");
              localStringBuilder.append(j);
              QMLog.e("EngineManager", localStringBuilder.toString());
            }
            else
            {
              this.mOutChannels.remove(j);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[MiniEng] removeDeadChannelExcept pid=");
              localStringBuilder.append(j);
              QMLog.i("EngineManager", localStringBuilder.toString());
            }
          }
          i += 1;
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramEngineChannel;
    }
  }
  
  private void upgradeEngine(BaseLibInfo paramBaseLibInfo, EngineChannel paramEngineChannel)
  {
    if (paramBaseLibInfo != null)
    {
      ThreadManager.executeOnDiskIOThreadPool(new EngineManager.2(this, paramBaseLibInfo, paramEngineChannel));
      return;
    }
    paramEngineChannel.send(54, null);
  }
  
  public EngineChannel getChannelForType(int paramInt)
  {
    EngineChannel localEngineChannel = (EngineChannel)this.mChannels.get(paramInt);
    if (localEngineChannel == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MiniEng]getChannelForType error type");
      localStringBuilder.append(paramInt);
      QMLog.e("EngineManager", localStringBuilder.toString());
    }
    return localEngineChannel;
  }
  
  public ArrayList<InstalledEngine> getEngineList(int paramInt)
  {
    return EngineInstaller.getInstalledEngine(paramInt);
  }
  
  public void installBaseLib(BaseLibInfo paramBaseLibInfo, EngineInstaller.Callback paramCallback)
  {
    if (paramBaseLibInfo != null)
    {
      EngineInstaller localEngineInstaller2 = (EngineInstaller)this.mEngineInstallers.get(paramBaseLibInfo.baseLibType);
      EngineInstaller localEngineInstaller1 = localEngineInstaller2;
      if (localEngineInstaller2 == null)
      {
        localEngineInstaller1 = new EngineInstaller();
        this.mEngineInstallers.put(paramBaseLibInfo.baseLibType, localEngineInstaller1);
      }
      localEngineInstaller1.installWithCallback(paramBaseLibInfo, paramCallback);
      return;
    }
    QMLog.i("EngineManager", "[MiniEng] libInfo is null ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.EngineManager
 * JD-Core Version:    0.7.0.1
 */