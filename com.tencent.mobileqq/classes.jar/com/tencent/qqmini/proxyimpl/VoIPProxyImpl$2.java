package com.tencent.qqmini.proxyimpl;

import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qav.controller.multi.QavMultiObserver;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.MultiUserInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class VoIPProxyImpl$2
  extends QavMultiObserver
{
  VoIPProxyImpl$2(VoIPProxyImpl paramVoIPProxyImpl) {}
  
  public void a()
  {
    if (VoIPProxyImpl.a(this.a) != null) {
      VoIPProxyImpl.a(this.a).onEnterRoom();
    }
  }
  
  public void a(int paramInt)
  {
    if (VoIPProxyImpl.a(this.a) != null) {
      VoIPProxyImpl.a(this.a).onError(paramInt);
    }
  }
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    if (VoIPProxyImpl.a(this.a) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (paramMultiUserInfo != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = paramMultiUserInfo.mMicOn;
        localMultiUserInfo.mOpenId = paramMultiUserInfo.mOpenId;
        localMultiUserInfo.mUin = paramMultiUserInfo.mUin;
      }
      VoIPProxyImpl.a(this.a).onUserEnter(localMultiUserInfo);
    }
  }
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    if (VoIPProxyImpl.a(this.a) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (paramMultiUserInfo != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = paramMultiUserInfo.mMicOn;
        localMultiUserInfo.mOpenId = paramMultiUserInfo.mOpenId;
        localMultiUserInfo.mUin = paramMultiUserInfo.mUin;
      }
      VoIPProxyImpl.a(this.a).onUserAudioAvailable(localMultiUserInfo, paramBoolean);
    }
  }
  
  public void a(List<QavDef.MultiUserInfo> paramList)
  {
    if (VoIPProxyImpl.a(this.a) != null)
    {
      Object localObject = null;
      if (paramList != null)
      {
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        for (;;)
        {
          localObject = localArrayList;
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (QavDef.MultiUserInfo)paramList.next();
          if (localObject != null)
          {
            VoIPProxy.MultiUserInfo localMultiUserInfo = new VoIPProxy.MultiUserInfo();
            localMultiUserInfo.mMicOn = ((QavDef.MultiUserInfo)localObject).mMicOn;
            localMultiUserInfo.mOpenId = ((QavDef.MultiUserInfo)localObject).mOpenId;
            localMultiUserInfo.mUin = ((QavDef.MultiUserInfo)localObject).mUin;
            localArrayList.add(localMultiUserInfo);
          }
        }
      }
      VoIPProxyImpl.a(this.a).onUserUpdate((List)localObject);
    }
  }
  
  public void b(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    if (VoIPProxyImpl.a(this.a) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (paramMultiUserInfo != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = paramMultiUserInfo.mMicOn;
        localMultiUserInfo.mOpenId = paramMultiUserInfo.mOpenId;
        localMultiUserInfo.mUin = paramMultiUserInfo.mUin;
      }
      VoIPProxyImpl.a(this.a).onUserExit(localMultiUserInfo);
    }
  }
  
  public void b(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    if (VoIPProxyImpl.a(this.a) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (paramMultiUserInfo != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = paramMultiUserInfo.mMicOn;
        localMultiUserInfo.mOpenId = paramMultiUserInfo.mOpenId;
        localMultiUserInfo.mUin = paramMultiUserInfo.mUin;
      }
      VoIPProxyImpl.a(this.a).onUserSpeaking(localMultiUserInfo, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VoIPProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */