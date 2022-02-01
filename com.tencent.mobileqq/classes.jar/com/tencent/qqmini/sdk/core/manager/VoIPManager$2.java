package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.MultiUserInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

class VoIPManager$2
  implements VoIPProxy.VoIPListener
{
  VoIPManager$2(VoIPManager paramVoIPManager) {}
  
  public void onEnterRoom()
  {
    QMLog.d("VoIPManager", "onEnterRoom");
    VoIPManager.access$200(this.this$0).set(true);
    if (VoIPManager.access$300(this.this$0) != null) {
      this.this$0.updateMuteConfig(VoIPManager.access$300(this.this$0), null);
    }
    VoIPManager.access$400(this.this$0).updateRoomInfo();
    VoIPManager.access$000(this.this$0);
  }
  
  public void onError(int paramInt)
  {
    QMLog.d("VoIPManager", String.format("onEnterRoom errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    if ((paramInt == 2) || (paramInt == 1)) {
      if (VoIPManager.access$500(this.this$0) != null)
      {
        VoIPManager.access$500(this.this$0).onError(paramInt);
        VoIPManager.access$502(this.this$0, null);
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt != 4) {
          break;
        }
      } while (VoIPManager.access$600(this.this$0) == null);
      VoIPManager.access$600(this.this$0).onInterrupt(4, "第三方通话中断");
      return;
    } while ((paramInt != 3) || (VoIPManager.access$600(this.this$0) == null));
    VoIPManager.access$600(this.this$0).onInterrupt(3, "网络原因中断");
  }
  
  public void onUserAudioAvailable(VoIPProxy.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    QMLog.d("VoIPManager", String.format("onUserAudioAvailable userInfo=%s available=%s", new Object[] { paramMultiUserInfo, Boolean.valueOf(paramBoolean) }));
  }
  
  public void onUserEnter(VoIPProxy.MultiUserInfo paramMultiUserInfo)
  {
    QMLog.d("VoIPManager", String.format("onUserEnter userInfo=%s", new Object[] { paramMultiUserInfo }));
    if ((VoIPManager.access$500(this.this$0) == null) && (VoIPManager.access$700(this.this$0, paramMultiUserInfo.mUin) == null))
    {
      VoIPManager.UserModel localUserModel = new VoIPManager.UserModel(this.this$0, null);
      localUserModel.mUin = paramMultiUserInfo.mUin;
      localUserModel.mOpenId = paramMultiUserInfo.mOpenId;
      localUserModel.mMicStat = 1;
      VoIPManager.access$900(this.this$0, localUserModel);
      if (VoIPManager.access$600(this.this$0) != null) {
        VoIPManager.access$600(this.this$0).onRoomMemberChange(VoIPManager.access$1000(this.this$0));
      }
    }
  }
  
  public void onUserExit(VoIPProxy.MultiUserInfo paramMultiUserInfo)
  {
    QMLog.d("VoIPManager", String.format("onUserExit userInfo=%s", new Object[] { paramMultiUserInfo }));
    if (VoIPManager.access$500(this.this$0) == null)
    {
      VoIPManager.access$1100(this.this$0, paramMultiUserInfo.mUin);
      if (VoIPManager.access$600(this.this$0) != null) {
        VoIPManager.access$600(this.this$0).onRoomMemberChange(VoIPManager.access$1000(this.this$0));
      }
    }
  }
  
  public void onUserSpeaking(VoIPProxy.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    QMLog.d("VoIPManager", String.format("onUserSpeaking userInfo=%s speaking=%s", new Object[] { paramMultiUserInfo, Boolean.valueOf(paramBoolean) }));
    paramMultiUserInfo = VoIPManager.access$700(this.this$0, paramMultiUserInfo.mUin);
    if (paramMultiUserInfo != null)
    {
      paramMultiUserInfo.mSpeaking = paramBoolean;
      if (VoIPManager.access$600(this.this$0) != null) {
        VoIPManager.access$600(this.this$0).onRoomMemberSpeaking(VoIPManager.access$1200(this.this$0));
      }
      return;
    }
    QMLog.e("VoIPManager", "onUserSpeaking userModel==null");
  }
  
  public void onUserUpdate(List<VoIPProxy.MultiUserInfo> paramList)
  {
    if ((VoIPManager.access$500(this.this$0) != null) && (paramList != null))
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        VoIPProxy.MultiUserInfo localMultiUserInfo = (VoIPProxy.MultiUserInfo)localIterator.next();
        if (localMultiUserInfo.mUin != 0L) {
          localJSONArray.put(localMultiUserInfo.mOpenId);
        }
      }
      VoIPManager.access$500(this.this$0).onJoinRoom(localJSONArray);
      VoIPManager.access$1300(this.this$0, paramList);
      VoIPManager.access$502(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.VoIPManager.2
 * JD-Core Version:    0.7.0.1
 */