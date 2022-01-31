package com.tencent.mobileqq.minigame.manager;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
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
    paramBundle = (EngineChannel)paramBundle.getParcelable("engineChannel");
    if (paramBundle != null)
    {
      if (EngineManager.access$000(this.this$0).indexOfKey(j) > 0) {
        QLog.w("EngineManager", 1, "[MiniEng] channel already exists for pid " + j + " replacing");
      }
      EngineManager.access$000(this.this$0).put(j, paramBundle);
    }
    paramBundle = (EngineChannel)EngineManager.access$000(this.this$0).get(j);
    if (paramBundle == null)
    {
      QLog.e("EngineManager", 1, "[MiniEng]no channel available for pid " + j);
      return;
    }
    QLog.i("EngineManager", 1, "[MiniEng] onReceiveData what=" + paramInt + ",baseLibType=" + i + ",pid=" + j + ",remote=" + paramBundle + ",channelCount=" + EngineManager.access$000(this.this$0).size());
    paramBundle.send(55, null);
    Object localObject1;
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = EngineManager.g().getEngineList(i);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putParcelableArrayList("installedEngineList", (ArrayList)localObject1);
      paramBundle.send(51, (Bundle)localObject2);
      EngineManager.access$100(this.this$0, paramBundle);
      QLog.i("EngineManager", 1, "[MiniEng]LiveChannel count " + EngineManager.access$000(this.this$0).size());
      return;
    }
    if (paramInt == 3) {
      if (i == 2)
      {
        localObject1 = this.this$0.getEngineList(i).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (InstalledEngine)((Iterator)localObject1).next();
        } while ((!((InstalledEngine)localObject2).isPersist) || (!((InstalledEngine)localObject2).isVerify) || (!EngineManager.isEngineGTLocalQQVersion(((InstalledEngine)localObject2).engineVersion)));
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if ((!LocalGameEngine.g().isDisabled()) && (paramInt == 0))
      {
        ThreadManagerV2.executeOnFileThread(new EngineManager.EngineChannelReceiver.1(this, paramBundle));
        return;
      }
      if (LocalGameEngine.g().isWnsConfigModel())
      {
        localObject1 = GameWnsUtils.getGameBaseLibInfo();
        QLog.i("EngineManager", 1, "[MiniEng] QQSpeed INSTALL_LATEST_ENGINE gameEngineLib " + localObject1);
        if ((localObject1 == null) || (((BaseLibInfo)localObject1).baseLibType != 2)) {
          break;
        }
        EngineManager.access$300(this.this$0, (BaseLibInfo)localObject1, paramBundle);
        return;
      }
      MiniAppCmdUtil.getInstance().updateBaseLib("0.0.1", false, true, new EngineManager.EngineChannelReceiver.2(this, i, paramBundle));
      return;
      if (paramInt != 5) {
        break;
      }
      if ((i == 2) && (LocalGameEngine.g().isWnsConfigModel()))
      {
        localObject1 = GameWnsUtils.getGameBaseLibInfo();
        QLog.i("EngineManager", 1, "[MiniEng] QQSpeed UPGRADE_ENGINE gameEngineLib " + localObject1);
        if ((localObject1 == null) || (((BaseLibInfo)localObject1).baseLibType != 2)) {
          break;
        }
        EngineManager.access$400(this.this$0, (BaseLibInfo)localObject1, paramBundle);
        return;
      }
      MiniAppCmdUtil.getInstance().updateBaseLib("0.0.1", false, true, new EngineManager.EngineChannelReceiver.3(this, i, paramBundle));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.EngineManager.EngineChannelReceiver
 * JD-Core Version:    0.7.0.1
 */