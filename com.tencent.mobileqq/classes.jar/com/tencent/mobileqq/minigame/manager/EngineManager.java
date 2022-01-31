package com.tencent.mobileqq.minigame.manager;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.mobileqq.minigame.utils.thread.TTHandleThread;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"WrongConstant"})
public class EngineManager
{
  public static final String LOG_TAG = "EngineManager";
  private static volatile EngineManager sInstance;
  private SparseArray<EngineChannel> mChannels;
  private SparseArray<EngineInstaller> mEngineInstallers;
  private SparseArray<EngineChannel> mOutChannels;
  
  private EngineManager()
  {
    QLog.i("EngineManager", 1, "[MiniEng]init start");
    long l = System.currentTimeMillis();
    this.mEngineInstallers = new SparseArray();
    this.mChannels = new SparseArray();
    EngineChannel localEngineChannel = new EngineChannel();
    localEngineChannel.setName("MainGame");
    localEngineChannel.setReceiver(new EngineManager.EngineChannelReceiver(this));
    this.mChannels.put(2, localEngineChannel);
    localEngineChannel = new EngineChannel();
    localEngineChannel.setName("MainApp");
    localEngineChannel.setReceiver(new EngineManager.EngineChannelReceiver(this));
    this.mChannels.put(3, localEngineChannel);
    this.mOutChannels = new SparseArray();
    EngineInstaller.updateInstalledEngine();
    EngineInstaller.removeOutDatedEngine(2);
    EngineInstaller.removeOldEngine(2);
    EngineInstaller.removeOldEngine(3);
    QLog.i("EngineManager", 1, "[MiniEng]init end cost=" + (System.currentTimeMillis() - l));
  }
  
  public static EngineManager g()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new EngineManager();
      }
      if (!AppUtil.isMainProcess()) {
        QLog.e("EngineManager", 1, "[MiniEng]EngineManager can not be called at " + BaseApplicationImpl.getApplication().getQQProcessName());
      }
      return sInstance;
    }
    finally {}
  }
  
  private ArrayList<Integer> getRunningPidList()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = BaseApplicationImpl.getContext();
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
    QLog.i("EngineManager", 1, "[MiniEng] installBaseLibForChannel " + paramBaseLibInfo + "," + paramEngineChannel);
    installBaseLib(paramBaseLibInfo, new EngineManager.3(this, paramEngineChannel, paramBaseLibInfo));
  }
  
  private void installEngine(BaseLibInfo paramBaseLibInfo, EngineChannel paramEngineChannel)
  {
    if (paramBaseLibInfo != null)
    {
      ThreadManagerV2.executeOnFileThread(new EngineManager.1(this, paramBaseLibInfo, paramEngineChannel));
      return;
    }
    paramEngineChannel.send(54, null);
  }
  
  private void preInstallLocalGameLib()
  {
    Iterator localIterator = getEngineList(2).iterator();
    while (localIterator.hasNext())
    {
      InstalledEngine localInstalledEngine = (InstalledEngine)localIterator.next();
      if ((localInstalledEngine.isPersist) && (localInstalledEngine.isVerify))
      {
        QLog.i("EngineManager", 1, "[MiniEng] installLocalLib skip already installed");
        return;
      }
    }
    QLog.i("EngineManager", 1, "[MiniEng] installLocalGameEngine " + LocalGameEngine.g().mLocalBaseLibInfo);
    installBaseLib(LocalGameEngine.g().mLocalBaseLibInfo, null);
  }
  
  private void removeDeadChannelExcept(EngineChannel paramEngineChannel)
  {
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList = getRunningPidList();
        if (this.mOutChannels != null)
        {
          i = 0;
          if (i < this.mOutChannels.size())
          {
            int j = this.mOutChannels.keyAt(i);
            if (localArrayList.contains(Integer.valueOf(j))) {
              break label141;
            }
            if (((EngineChannel)this.mOutChannels.valueAt(i)).equals(paramEngineChannel))
            {
              QLog.e("EngineManager", 1, "[MiniEng] removeDeadChannelExcept error pid=" + j);
            }
            else
            {
              this.mOutChannels.remove(j);
              QLog.i("EngineManager", 1, "[MiniEng] removeDeadChannelExcept pid=" + j);
            }
          }
        }
      }
      finally {}
      return;
      label141:
      i += 1;
    }
  }
  
  private void upgradeEngine(BaseLibInfo paramBaseLibInfo, EngineChannel paramEngineChannel)
  {
    if (paramBaseLibInfo != null)
    {
      ThreadManagerV2.executeOnFileThread(new EngineManager.2(this, paramBaseLibInfo, paramEngineChannel));
      return;
    }
    paramEngineChannel.send(54, null);
  }
  
  public EngineChannel getChannelForType(int paramInt)
  {
    EngineChannel localEngineChannel = (EngineChannel)this.mChannels.get(paramInt);
    if (localEngineChannel == null) {
      QLog.e("EngineManager", 1, "[MiniEng]getChannelForType error type" + paramInt);
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
        localEngineInstaller1 = new EngineInstaller(new DefaultDownloader());
        this.mEngineInstallers.put(paramBaseLibInfo.baseLibType, localEngineInstaller1);
      }
      localEngineInstaller1.installWithCallback(paramBaseLibInfo, paramCallback);
      return;
    }
    QLog.i("EngineManager", 1, "[MiniEng] libInfo is null ");
  }
  
  public void preInstallLocalGameLibWithDelay()
  {
    if (LocalGameEngine.g().isDisabled())
    {
      QLog.i("EngineManager", 1, "[MiniEng] installLocalLib skip disabled");
      return;
    }
    TTHandleThread.getInstance().postDelayed(new EngineManager.4(this), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.EngineManager
 * JD-Core Version:    0.7.0.1
 */