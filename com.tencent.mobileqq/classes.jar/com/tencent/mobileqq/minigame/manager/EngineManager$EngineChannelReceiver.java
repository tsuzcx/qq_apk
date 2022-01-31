package com.tencent.mobileqq.minigame.manager;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class EngineManager$EngineChannelReceiver
  implements EngineChannel.Receiver
{
  public EngineManager$EngineChannelReceiver(EngineManager paramEngineManager) {}
  
  public void onReceiveData(int paramInt, Bundle paramBundle)
  {
    paramBundle.setClassLoader(getClass().getClassLoader());
    int i = paramBundle.getInt("baseLibType");
    int j = paramBundle.getInt("enginePid");
    EngineChannel localEngineChannel = (EngineChannel)paramBundle.getParcelable("engineChannel");
    if (localEngineChannel != null)
    {
      if (EngineManager.access$000(this.this$0).indexOfKey(j) > 0) {
        QLog.w("EngineManager", 1, "[MiniEng] channel already exists for pid " + j + " replacing");
      }
      EngineManager.access$000(this.this$0).put(j, localEngineChannel);
    }
    localEngineChannel = (EngineChannel)EngineManager.access$000(this.this$0).get(j);
    if (localEngineChannel == null)
    {
      QLog.e("EngineManager", 1, "[MiniEng]no channel available for pid " + j);
      return;
    }
    QLog.i("EngineManager", 1, "[MiniEng] onReceiveData what=" + paramInt + ",baseLibType=" + i + ",pid=" + j + ",remote=" + localEngineChannel + ",channelCount=" + EngineManager.access$000(this.this$0).size());
    localEngineChannel.send(55, null);
    Object localObject;
    if (paramInt == 1)
    {
      paramBundle = EngineManager.g().getEngineList(i);
      localObject = new Bundle();
      ((Bundle)localObject).putParcelableArrayList("installedEngineList", paramBundle);
      localEngineChannel.send(51, (Bundle)localObject);
      EngineManager.access$100(this.this$0, localEngineChannel);
      QLog.i("EngineManager", 1, "[MiniEng]LiveChannel count " + EngineManager.access$000(this.this$0).size());
      return;
    }
    if (paramInt == 3) {
      if (i == 2)
      {
        paramBundle = this.this$0.getEngineList(i).iterator();
        do
        {
          if (!paramBundle.hasNext()) {
            break;
          }
          localObject = (InstalledEngine)paramBundle.next();
        } while ((!((InstalledEngine)localObject).isPersist) || (!((InstalledEngine)localObject).isVerify) || (!EngineManager.isEngineGTLocalQQVersion(((InstalledEngine)localObject).engineVersion)));
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if ((!LocalGameEngine.g().isDisabled()) && (paramInt == 0))
      {
        ThreadManagerV2.executeOnFileThread(new EngineManager.EngineChannelReceiver.1(this, localEngineChannel));
        return;
      }
      if (LocalGameEngine.g().isWnsConfigModel())
      {
        paramBundle = GameWnsUtils.getGameBaseLibInfo();
        QLog.i("EngineManager", 1, "[MiniEng] QQSpeed INSTALL_LATEST_ENGINE gameEngineLib " + paramBundle);
        if ((paramBundle == null) || (paramBundle.baseLibType != 2)) {
          break;
        }
        EngineManager.access$300(this.this$0, paramBundle, localEngineChannel);
        return;
      }
      MiniAppCmdUtil.getInstance().updateBaseLib("0.0.1", false, true, new EngineManager.EngineChannelReceiver.2(this, i, localEngineChannel));
      return;
      if (paramInt == 5)
      {
        if ((i == 2) && (LocalGameEngine.g().isWnsConfigModel()))
        {
          paramBundle = GameWnsUtils.getGameBaseLibInfo();
          QLog.i("EngineManager", 1, "[MiniEng] QQSpeed UPGRADE_ENGINE gameEngineLib " + paramBundle);
          if ((paramBundle == null) || (paramBundle.baseLibType != 2)) {
            break;
          }
          EngineManager.access$400(this.this$0, paramBundle, localEngineChannel);
          return;
        }
        MiniAppCmdUtil.getInstance().updateBaseLib("0.0.1", false, true, new EngineManager.EngineChannelReceiver.3(this, i, localEngineChannel));
        return;
      }
      if (paramInt != 56) {
        break;
      }
      paramBundle = (InstalledEngine)paramBundle.getParcelable("invalidEngine");
      QLog.i("EngineManager", 1, "[MiniEng] receive delete InstalledEngine from pid:" + j + ", baseLibType:" + i + ", targetEngine:" + paramBundle);
      if (paramBundle == null) {
        break;
      }
      EngineInstaller.removeEngine(paramBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.EngineManager.EngineChannelReceiver
 * JD-Core Version:    0.7.0.1
 */