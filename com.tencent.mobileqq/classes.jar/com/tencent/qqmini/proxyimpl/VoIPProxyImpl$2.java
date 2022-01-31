package com.tencent.qqmini.proxyimpl;

import bfqt;
import bfrf;
import com.tencent.qqmini.sdk.core.proxy.VoIPProxy.MultiUserInfo;
import com.tencent.qqmini.sdk.core.proxy.VoIPProxy.VoIPListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class VoIPProxyImpl$2
  extends bfrf
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
  
  public void onUserAudioAvailable(bfqt parambfqt, boolean paramBoolean)
  {
    if (VoIPProxyImpl.access$000(this.this$0) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (parambfqt != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = parambfqt.jdField_a_of_type_Boolean;
        localMultiUserInfo.mOpenId = parambfqt.jdField_a_of_type_JavaLangString;
        localMultiUserInfo.mUin = parambfqt.jdField_a_of_type_Long;
      }
      VoIPProxyImpl.access$000(this.this$0).onUserAudioAvailable(localMultiUserInfo, paramBoolean);
    }
  }
  
  public void onUserEnter(bfqt parambfqt)
  {
    if (VoIPProxyImpl.access$000(this.this$0) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (parambfqt != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = parambfqt.jdField_a_of_type_Boolean;
        localMultiUserInfo.mOpenId = parambfqt.jdField_a_of_type_JavaLangString;
        localMultiUserInfo.mUin = parambfqt.jdField_a_of_type_Long;
      }
      VoIPProxyImpl.access$000(this.this$0).onUserEnter(localMultiUserInfo);
    }
  }
  
  public void onUserExit(bfqt parambfqt)
  {
    if (VoIPProxyImpl.access$000(this.this$0) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (parambfqt != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = parambfqt.jdField_a_of_type_Boolean;
        localMultiUserInfo.mOpenId = parambfqt.jdField_a_of_type_JavaLangString;
        localMultiUserInfo.mUin = parambfqt.jdField_a_of_type_Long;
      }
      VoIPProxyImpl.access$000(this.this$0).onUserExit(localMultiUserInfo);
    }
  }
  
  public void onUserSpeaking(bfqt parambfqt, boolean paramBoolean)
  {
    if (VoIPProxyImpl.access$000(this.this$0) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (parambfqt != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = parambfqt.jdField_a_of_type_Boolean;
        localMultiUserInfo.mOpenId = parambfqt.jdField_a_of_type_JavaLangString;
        localMultiUserInfo.mUin = parambfqt.jdField_a_of_type_Long;
      }
      VoIPProxyImpl.access$000(this.this$0).onUserSpeaking(localMultiUserInfo, paramBoolean);
    }
  }
  
  public void onUserUpdate(List<bfqt> paramList)
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
          bfqt localbfqt = (bfqt)paramList.next();
          if (localbfqt != null)
          {
            VoIPProxy.MultiUserInfo localMultiUserInfo = new VoIPProxy.MultiUserInfo();
            localMultiUserInfo.mMicOn = localbfqt.jdField_a_of_type_Boolean;
            localMultiUserInfo.mOpenId = localbfqt.jdField_a_of_type_JavaLangString;
            localMultiUserInfo.mUin = localbfqt.jdField_a_of_type_Long;
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