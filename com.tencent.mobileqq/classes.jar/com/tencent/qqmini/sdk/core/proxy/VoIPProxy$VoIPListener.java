package com.tencent.qqmini.sdk.core.proxy;

import java.util.List;

public abstract interface VoIPProxy$VoIPListener
{
  public abstract void onEnterRoom();
  
  public abstract void onError(int paramInt);
  
  public abstract void onUserAudioAvailable(VoIPProxy.MultiUserInfo paramMultiUserInfo, boolean paramBoolean);
  
  public abstract void onUserEnter(VoIPProxy.MultiUserInfo paramMultiUserInfo);
  
  public abstract void onUserExit(VoIPProxy.MultiUserInfo paramMultiUserInfo);
  
  public abstract void onUserSpeaking(VoIPProxy.MultiUserInfo paramMultiUserInfo, boolean paramBoolean);
  
  public abstract void onUserUpdate(List<VoIPProxy.MultiUserInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.VoIPProxy.VoIPListener
 * JD-Core Version:    0.7.0.1
 */