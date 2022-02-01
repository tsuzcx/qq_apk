package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.MultiUserInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;

class VoIPManager$2
  implements VoIPProxy.VoIPListener
{
  VoIPManager$2(VoIPManager paramVoIPManager) {}
  
  public void onEnterRoom()
  {
    VoIPManager.access$200(this.this$0);
  }
  
  public void onError(int paramInt)
  {
    VoIPManager.access$300(this.this$0, paramInt);
  }
  
  public void onUserAudioAvailable(VoIPProxy.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    QMLog.d("VoIPManager", String.format("onUserAudioAvailable userInfo=%s available=%s", new Object[] { paramMultiUserInfo, Boolean.valueOf(paramBoolean) }));
  }
  
  public void onUserEnter(VoIPProxy.MultiUserInfo paramMultiUserInfo)
  {
    VoIPManager.access$400(this.this$0, paramMultiUserInfo);
  }
  
  public void onUserExit(VoIPProxy.MultiUserInfo paramMultiUserInfo)
  {
    VoIPManager.access$500(this.this$0, paramMultiUserInfo);
  }
  
  public void onUserSpeaking(VoIPProxy.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    VoIPManager.access$600(this.this$0, paramMultiUserInfo, paramBoolean);
  }
  
  public void onUserUpdate(List<VoIPProxy.MultiUserInfo> paramList)
  {
    VoIPManager.access$700(this.this$0, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.VoIPManager.2
 * JD-Core Version:    0.7.0.1
 */