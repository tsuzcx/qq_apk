package com.tencent.qqmini.proxyimpl;

import bfvc;
import bfvo;
import com.tencent.qqmini.sdk.core.proxy.VoIPProxy.MultiUserInfo;
import com.tencent.qqmini.sdk.core.proxy.VoIPProxy.VoIPListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class VoIPProxyImpl$2
  extends bfvo
{
  VoIPProxyImpl$2(VoIPProxyImpl paramVoIPProxyImpl) {}
  
  public void onEnterRoom()
  {
    if (VoIPProxyImpl.access$000(this.this$0) != null) {
      VoIPProxyImpl.access$000(this.this$0).onEnterRoom();
    }
  }
  
  public void onError(int paramInt)
  {
    if (VoIPProxyImpl.access$000(this.this$0) != null) {
      VoIPProxyImpl.access$000(this.this$0).onError(paramInt);
    }
  }
  
  public void onUserAudioAvailable(bfvc parambfvc, boolean paramBoolean)
  {
    if (VoIPProxyImpl.access$000(this.this$0) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (parambfvc != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = parambfvc.jdField_a_of_type_Boolean;
        localMultiUserInfo.mOpenId = parambfvc.jdField_a_of_type_JavaLangString;
        localMultiUserInfo.mUin = parambfvc.jdField_a_of_type_Long;
      }
      VoIPProxyImpl.access$000(this.this$0).onUserAudioAvailable(localMultiUserInfo, paramBoolean);
    }
  }
  
  public void onUserEnter(bfvc parambfvc)
  {
    if (VoIPProxyImpl.access$000(this.this$0) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (parambfvc != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = parambfvc.jdField_a_of_type_Boolean;
        localMultiUserInfo.mOpenId = parambfvc.jdField_a_of_type_JavaLangString;
        localMultiUserInfo.mUin = parambfvc.jdField_a_of_type_Long;
      }
      VoIPProxyImpl.access$000(this.this$0).onUserEnter(localMultiUserInfo);
    }
  }
  
  public void onUserExit(bfvc parambfvc)
  {
    if (VoIPProxyImpl.access$000(this.this$0) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (parambfvc != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = parambfvc.jdField_a_of_type_Boolean;
        localMultiUserInfo.mOpenId = parambfvc.jdField_a_of_type_JavaLangString;
        localMultiUserInfo.mUin = parambfvc.jdField_a_of_type_Long;
      }
      VoIPProxyImpl.access$000(this.this$0).onUserExit(localMultiUserInfo);
    }
  }
  
  public void onUserSpeaking(bfvc parambfvc, boolean paramBoolean)
  {
    if (VoIPProxyImpl.access$000(this.this$0) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (parambfvc != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = parambfvc.jdField_a_of_type_Boolean;
        localMultiUserInfo.mOpenId = parambfvc.jdField_a_of_type_JavaLangString;
        localMultiUserInfo.mUin = parambfvc.jdField_a_of_type_Long;
      }
      VoIPProxyImpl.access$000(this.this$0).onUserSpeaking(localMultiUserInfo, paramBoolean);
    }
  }
  
  public void onUserUpdate(List<bfvc> paramList)
  {
    if (VoIPProxyImpl.access$000(this.this$0) != null)
    {
      ArrayList localArrayList = null;
      if (paramList != null)
      {
        localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          bfvc localbfvc = (bfvc)paramList.next();
          if (localbfvc != null)
          {
            VoIPProxy.MultiUserInfo localMultiUserInfo = new VoIPProxy.MultiUserInfo();
            localMultiUserInfo.mMicOn = localbfvc.jdField_a_of_type_Boolean;
            localMultiUserInfo.mOpenId = localbfvc.jdField_a_of_type_JavaLangString;
            localMultiUserInfo.mUin = localbfvc.jdField_a_of_type_Long;
            localArrayList.add(localMultiUserInfo);
          }
        }
      }
      VoIPProxyImpl.access$000(this.this$0).onUserUpdate(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VoIPProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */