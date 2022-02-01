package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import amtj;
import biin;
import biiw;
import biiz;
import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

class VoIPManager$3
  extends biiz
{
  VoIPManager$3(VoIPManager paramVoIPManager) {}
  
  public void onEnterRoom()
  {
    QLog.d("VoIPManager", 1, "onEnterRoom");
    VoIPManager.access$200(this.this$0).set(true);
    biiw localbiiw = biin.a().a();
    if (VoIPManager.access$300(this.this$0) != null) {
      this.this$0.updateMuteConfig(VoIPManager.access$300(this.this$0), null);
    }
    if (localbiiw != null) {
      localbiiw.f();
    }
    VoIPManager.access$000(this.this$0);
  }
  
  public void onError(int paramInt)
  {
    QLog.d("VoIPManager", 1, String.format("onEnterRoom errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    if ((paramInt == 2) || (paramInt == 1)) {
      if (VoIPManager.access$400(this.this$0) != null)
      {
        VoIPManager.access$400(this.this$0).onError(paramInt);
        VoIPManager.access$402(this.this$0, null);
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
      } while (VoIPManager.access$500(this.this$0) == null);
      VoIPManager.access$500(this.this$0).onInterrupt(4, amtj.a(2131715876));
      return;
    } while ((paramInt != 3) || (VoIPManager.access$500(this.this$0) == null));
    VoIPManager.access$500(this.this$0).onInterrupt(3, amtj.a(2131715875));
  }
  
  public void onUserAudioAvailable(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    QLog.d("VoIPManager", 1, String.format("onUserAudioAvailable userInfo=%s available=%s", new Object[] { paramMultiUserInfo, Boolean.valueOf(paramBoolean) }));
  }
  
  public void onUserEnter(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    QLog.d("VoIPManager", 1, String.format("onUserEnter userInfo=%s", new Object[] { paramMultiUserInfo }));
    if ((VoIPManager.access$400(this.this$0) == null) && (VoIPManager.access$600(this.this$0, paramMultiUserInfo.mUin) == null))
    {
      VoIPManager.UserModel localUserModel = new VoIPManager.UserModel(this.this$0, null);
      localUserModel.mUin = paramMultiUserInfo.mUin;
      localUserModel.mOpenId = paramMultiUserInfo.mOpenId;
      localUserModel.mMicStat = 1;
      VoIPManager.access$800(this.this$0, localUserModel);
      if (VoIPManager.access$500(this.this$0) != null) {
        VoIPManager.access$500(this.this$0).onRoomMemberChange(VoIPManager.access$900(this.this$0));
      }
    }
  }
  
  public void onUserExit(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    QLog.d("VoIPManager", 1, String.format("onUserExit userInfo=%s", new Object[] { paramMultiUserInfo }));
    if (VoIPManager.access$400(this.this$0) == null)
    {
      VoIPManager.access$1000(this.this$0, paramMultiUserInfo.mUin);
      if (VoIPManager.access$500(this.this$0) != null) {
        VoIPManager.access$500(this.this$0).onRoomMemberChange(VoIPManager.access$900(this.this$0));
      }
    }
  }
  
  public void onUserSpeaking(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    QLog.d("VoIPManager", 1, String.format("onUserSpeaking userInfo=%s speaking=%s", new Object[] { paramMultiUserInfo, Boolean.valueOf(paramBoolean) }));
    paramMultiUserInfo = VoIPManager.access$600(this.this$0, paramMultiUserInfo.mUin);
    if (paramMultiUserInfo != null)
    {
      paramMultiUserInfo.mSpeaking = paramBoolean;
      if (VoIPManager.access$500(this.this$0) != null) {
        VoIPManager.access$500(this.this$0).onRoomMemberSpeaking(VoIPManager.access$1100(this.this$0));
      }
      return;
    }
    QLog.e("VoIPManager", 1, "onUserSpeaking userModel==null");
  }
  
  public void onUserUpdate(List<QavDef.MultiUserInfo> paramList)
  {
    if ((VoIPManager.access$400(this.this$0) != null) && (paramList != null))
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        QavDef.MultiUserInfo localMultiUserInfo = (QavDef.MultiUserInfo)localIterator.next();
        if (localMultiUserInfo.mUin != 0L) {
          localJSONArray.put(localMultiUserInfo.mOpenId);
        }
      }
      VoIPManager.access$400(this.this$0).onJoinRoom(localJSONArray);
      VoIPManager.access$1200(this.this$0, paramList);
      VoIPManager.access$402(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VoIPManager.3
 * JD-Core Version:    0.7.0.1
 */