package com.tencent.qqmini.sdk.manager;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.action.EngineChannel;
import com.tencent.qqmini.sdk.launcher.action.EngineChannel.Receiver;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.utils.WnsUtil;
import java.util.Iterator;
import java.util.List;

public class EngineManager$EngineChannelReceiver
  implements EngineChannel.Receiver
{
  public EngineManager$EngineChannelReceiver(EngineManager paramEngineManager) {}
  
  private void doInstallEngine(int paramInt, EngineChannel paramEngineChannel)
  {
    if (paramInt == 2)
    {
      Object localObject1 = this.this$0.getEngineList(paramInt).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (InstalledEngine)((Iterator)localObject1).next();
        if ((((InstalledEngine)localObject2).isPersist) && (((InstalledEngine)localObject2).isVerify))
        {
          i = 1;
          break label65;
        }
      }
      int i = 0;
      label65:
      localObject1 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      if ((!LocalGameEngine.g().isDisabled()) && (i == 0) && ((QUAUtil.isQQMainApp()) || (QUAUtil.isDemoApp()) || (!TextUtils.isEmpty(((MiniAppProxy)localObject1).getSoPath()))))
      {
        ThreadManager.executeOnDiskIOThreadPool(new EngineManager.EngineChannelReceiver.2(this, paramEngineChannel));
        return;
      }
      if (LocalGameEngine.g().isWnsConfigModel())
      {
        localObject1 = WnsUtil.getGameBaseLibInfo();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[MiniEng] QQSpeed INSTALL_LATEST_ENGINE gameEngineLib ");
        ((StringBuilder)localObject2).append(localObject1);
        QMLog.i("EngineManager", ((StringBuilder)localObject2).toString());
        if ((localObject1 != null) && (((BaseLibInfo)localObject1).baseLibType == 2)) {
          EngineManager.access$500(this.this$0, (BaseLibInfo)localObject1, paramEngineChannel);
        }
        return;
      }
    }
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBaseLib("0,0,1", false, true, new EngineManager.EngineChannelReceiver.3(this, paramInt, paramEngineChannel));
  }
  
  private void doUpgradeEngine(int paramInt, EngineChannel paramEngineChannel)
  {
    if ((paramInt == 2) && (LocalGameEngine.g().isWnsConfigModel()))
    {
      BaseLibInfo localBaseLibInfo = WnsUtil.getGameBaseLibInfo();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MiniEng] QQSpeed UPGRADE_ENGINE gameEngineLib ");
      localStringBuilder.append(localBaseLibInfo);
      QMLog.i("EngineManager", localStringBuilder.toString());
      if ((localBaseLibInfo != null) && (localBaseLibInfo.baseLibType == 2)) {
        EngineManager.access$400(this.this$0, localBaseLibInfo, paramEngineChannel);
      }
      return;
    }
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBaseLib("0,0,1", false, true, new EngineManager.EngineChannelReceiver.1(this, paramInt, paramEngineChannel));
  }
  
  public void onReceiveData(int paramInt, Bundle paramBundle)
  {
    paramBundle.setClassLoader(getClass().getClassLoader());
    int i = paramBundle.getInt("baseLibType");
    int j = paramBundle.getInt("enginePid");
    Object localObject1 = (EngineChannel)paramBundle.getParcelable("engineChannel");
    if (localObject1 != null)
    {
      if (EngineManager.access$200(this.this$0).indexOfKey(j) > 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[MiniEng] channel already exists for pid ");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(" replacing");
        QMLog.w("EngineManager", ((StringBuilder)localObject2).toString());
      }
      EngineManager.access$200(this.this$0).put(j, localObject1);
    }
    localObject1 = (EngineChannel)EngineManager.access$200(this.this$0).get(j);
    if (localObject1 == null)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("[MiniEng]no channel available for pid ");
      paramBundle.append(j);
      QMLog.e("EngineManager", paramBundle.toString());
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[MiniEng] onReceiveData what=");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(",baseLibType=");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(",pid=");
    ((StringBuilder)localObject2).append(j);
    ((StringBuilder)localObject2).append(",remote=");
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append(",channelCount=");
    ((StringBuilder)localObject2).append(EngineManager.access$200(this.this$0).size());
    QMLog.i("EngineManager", ((StringBuilder)localObject2).toString());
    ((EngineChannel)localObject1).send(55, null);
    if (paramInt == 1)
    {
      paramBundle = EngineManager.g().getEngineList(i);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putParcelableArrayList("installedEngineList", paramBundle);
      ((EngineChannel)localObject1).send(51, (Bundle)localObject2);
      EngineManager.access$300(this.this$0, (EngineChannel)localObject1);
      paramBundle = new StringBuilder();
      paramBundle.append("[MiniEng]LiveChannel count ");
      paramBundle.append(EngineManager.access$200(this.this$0).size());
      QMLog.i("EngineManager", paramBundle.toString());
      return;
    }
    if (paramInt == 3)
    {
      doInstallEngine(i, (EngineChannel)localObject1);
      return;
    }
    if (paramInt == 5)
    {
      doUpgradeEngine(i, (EngineChannel)localObject1);
      return;
    }
    if (paramInt == 56)
    {
      paramBundle = (InstalledEngine)paramBundle.getParcelable("invalidEngine");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[MiniEng] receive delete InstalledEngine from pid:");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(", baseLibType:");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(", targetEngine:");
      ((StringBuilder)localObject1).append(paramBundle);
      QMLog.i("EngineManager", ((StringBuilder)localObject1).toString());
      if (paramBundle != null) {
        EngineInstaller.removeEngine(paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.EngineManager.EngineChannelReceiver
 * JD-Core Version:    0.7.0.1
 */