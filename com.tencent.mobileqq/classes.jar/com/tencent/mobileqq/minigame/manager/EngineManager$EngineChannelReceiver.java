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
    Object localObject1 = (EngineChannel)paramBundle.getParcelable("engineChannel");
    if (localObject1 != null)
    {
      if (EngineManager.access$000(this.this$0).indexOfKey(j) > 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[MiniEng] channel already exists for pid ");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(" replacing");
        QLog.w("EngineManager", 1, ((StringBuilder)localObject2).toString());
      }
      EngineManager.access$000(this.this$0).put(j, localObject1);
    }
    localObject1 = (EngineChannel)EngineManager.access$000(this.this$0).get(j);
    if (localObject1 == null)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("[MiniEng]no channel available for pid ");
      paramBundle.append(j);
      QLog.e("EngineManager", 1, paramBundle.toString());
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
    ((StringBuilder)localObject2).append(EngineManager.access$000(this.this$0).size());
    QLog.i("EngineManager", 1, ((StringBuilder)localObject2).toString());
    ((EngineChannel)localObject1).send(55, null);
    if (paramInt == 1)
    {
      paramBundle = EngineManager.g().getEngineList(i);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putParcelableArrayList("installedEngineList", paramBundle);
      ((EngineChannel)localObject1).send(51, (Bundle)localObject2);
      EngineManager.access$100(this.this$0, (EngineChannel)localObject1);
      paramBundle = new StringBuilder();
      paramBundle.append("[MiniEng]LiveChannel count ");
      paramBundle.append(EngineManager.access$000(this.this$0).size());
      QLog.i("EngineManager", 1, paramBundle.toString());
      return;
    }
    if (paramInt == 3)
    {
      if (i == 2)
      {
        paramBundle = this.this$0.getEngineList(i).iterator();
        while (paramBundle.hasNext())
        {
          localObject2 = (InstalledEngine)paramBundle.next();
          if ((((InstalledEngine)localObject2).isPersist) && (((InstalledEngine)localObject2).isVerify) && (EngineManager.isEngineGTLocalQQVersion(((InstalledEngine)localObject2).engineVersion)))
          {
            paramInt = 1;
            break label451;
          }
        }
        paramInt = 0;
        label451:
        if ((!LocalGameEngine.g().isDisabled()) && (paramInt == 0))
        {
          ThreadManagerV2.executeOnFileThread(new EngineManager.EngineChannelReceiver.1(this, (EngineChannel)localObject1));
          return;
        }
        if (LocalGameEngine.g().isWnsConfigModel())
        {
          paramBundle = GameWnsUtils.getGameBaseLibInfo();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[MiniEng] QQSpeed INSTALL_LATEST_ENGINE gameEngineLib ");
          ((StringBuilder)localObject2).append(paramBundle);
          QLog.i("EngineManager", 1, ((StringBuilder)localObject2).toString());
          if ((paramBundle != null) && (paramBundle.baseLibType == 2)) {
            EngineManager.access$300(this.this$0, paramBundle, (EngineChannel)localObject1);
          }
          return;
        }
      }
      MiniAppCmdUtil.getInstance().updateBaseLib("0.0.1", false, true, new EngineManager.EngineChannelReceiver.2(this, i, (EngineChannel)localObject1));
      return;
    }
    if (paramInt == 5)
    {
      if ((i == 2) && (LocalGameEngine.g().isWnsConfigModel()))
      {
        paramBundle = GameWnsUtils.getGameBaseLibInfo();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[MiniEng] QQSpeed UPGRADE_ENGINE gameEngineLib ");
        ((StringBuilder)localObject2).append(paramBundle);
        QLog.i("EngineManager", 1, ((StringBuilder)localObject2).toString());
        if ((paramBundle != null) && (paramBundle.baseLibType == 2)) {
          EngineManager.access$400(this.this$0, paramBundle, (EngineChannel)localObject1);
        }
        return;
      }
      MiniAppCmdUtil.getInstance().updateBaseLib("0.0.1", false, true, new EngineManager.EngineChannelReceiver.3(this, i, (EngineChannel)localObject1));
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
      QLog.i("EngineManager", 1, ((StringBuilder)localObject1).toString());
      if (paramBundle != null) {
        EngineInstaller.removeEngine(paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.EngineManager.EngineChannelReceiver
 * JD-Core Version:    0.7.0.1
 */