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
    Object localObject;
    if (paramInt == 2)
    {
      localObject = this.this$0.getEngineList(paramInt).iterator();
      InstalledEngine localInstalledEngine;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localInstalledEngine = (InstalledEngine)((Iterator)localObject).next();
      } while ((!localInstalledEngine.isPersist) || (!localInstalledEngine.isVerify));
    }
    for (int i = 1;; i = 0)
    {
      localObject = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      if ((!LocalGameEngine.g().isDisabled()) && (i == 0) && ((QUAUtil.isQQMainApp()) || (QUAUtil.isDemoApp()) || (!TextUtils.isEmpty(((MiniAppProxy)localObject).getSoPath())))) {
        ThreadManager.executeOnDiskIOThreadPool(new EngineManager.EngineChannelReceiver.2(this, paramEngineChannel));
      }
      do
      {
        return;
        if (!LocalGameEngine.g().isWnsConfigModel()) {
          break;
        }
        localObject = WnsUtil.getGameBaseLibInfo();
        QMLog.i("EngineManager", "[MiniEng] QQSpeed INSTALL_LATEST_ENGINE gameEngineLib " + localObject);
      } while ((localObject == null) || (((BaseLibInfo)localObject).baseLibType != 2));
      EngineManager.access$500(this.this$0, (BaseLibInfo)localObject, paramEngineChannel);
      return;
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBaseLib("0,0,1", false, true, new EngineManager.EngineChannelReceiver.3(this, paramInt, paramEngineChannel));
      return;
    }
  }
  
  private void doUpgradeEngine(int paramInt, EngineChannel paramEngineChannel)
  {
    if ((paramInt == 2) && (LocalGameEngine.g().isWnsConfigModel()))
    {
      BaseLibInfo localBaseLibInfo = WnsUtil.getGameBaseLibInfo();
      QMLog.i("EngineManager", "[MiniEng] QQSpeed UPGRADE_ENGINE gameEngineLib " + localBaseLibInfo);
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
    EngineChannel localEngineChannel = (EngineChannel)paramBundle.getParcelable("engineChannel");
    if (localEngineChannel != null)
    {
      if (EngineManager.access$200(this.this$0).indexOfKey(j) > 0) {
        QMLog.w("EngineManager", "[MiniEng] channel already exists for pid " + j + " replacing");
      }
      EngineManager.access$200(this.this$0).put(j, localEngineChannel);
    }
    localEngineChannel = (EngineChannel)EngineManager.access$200(this.this$0).get(j);
    if (localEngineChannel == null) {
      QMLog.e("EngineManager", "[MiniEng]no channel available for pid " + j);
    }
    do
    {
      do
      {
        return;
        QMLog.i("EngineManager", "[MiniEng] onReceiveData what=" + paramInt + ",baseLibType=" + i + ",pid=" + j + ",remote=" + localEngineChannel + ",channelCount=" + EngineManager.access$200(this.this$0).size());
        localEngineChannel.send(55, null);
        if (paramInt == 1)
        {
          paramBundle = EngineManager.g().getEngineList(i);
          Bundle localBundle = new Bundle();
          localBundle.putParcelableArrayList("installedEngineList", paramBundle);
          localEngineChannel.send(51, localBundle);
          EngineManager.access$300(this.this$0, localEngineChannel);
          QMLog.i("EngineManager", "[MiniEng]LiveChannel count " + EngineManager.access$200(this.this$0).size());
          return;
        }
        if (paramInt == 3)
        {
          doInstallEngine(i, localEngineChannel);
          return;
        }
        if (paramInt == 5)
        {
          doUpgradeEngine(i, localEngineChannel);
          return;
        }
      } while (paramInt != 56);
      paramBundle = (InstalledEngine)paramBundle.getParcelable("invalidEngine");
      QMLog.i("EngineManager", "[MiniEng] receive delete InstalledEngine from pid:" + j + ", baseLibType:" + i + ", targetEngine:" + paramBundle);
    } while (paramBundle == null);
    EngineInstaller.removeEngine(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.EngineManager.EngineChannelReceiver
 * JD-Core Version:    0.7.0.1
 */