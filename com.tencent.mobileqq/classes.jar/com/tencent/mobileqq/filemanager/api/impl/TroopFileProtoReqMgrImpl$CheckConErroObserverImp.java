package com.tencent.mobileqq.filemanager.api.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.CheckConErroObserver;

public class TroopFileProtoReqMgrImpl$CheckConErroObserverImp
  extends CheckConErroObserver
{
  TroopFileProtoReqMgrImpl.ProtoRequest jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequest;
  TroopFileProtoReqMgrImpl.ProtoResponse jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoResponse;
  
  public TroopFileProtoReqMgrImpl$CheckConErroObserverImp(TroopFileProtoReqMgrImpl paramTroopFileProtoReqMgrImpl, TroopFileProtoReqMgrImpl.ProtoResponse paramProtoResponse, TroopFileProtoReqMgrImpl.ProtoRequest paramProtoRequest)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoResponse = paramProtoResponse;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequest = paramProtoRequest;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    String str = "";
    Object localObject1;
    Object localObject2;
    if (paramBundle != null)
    {
      localObject1 = paramBundle.getString("msf_con_erro");
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("CheckConErroObserverImp.onReceive -> msfConErro: ");
        ((StringBuilder)localObject1).append(paramBundle);
        QLog.d("TroopFileProtoReqMgr", 2, ((StringBuilder)localObject1).toString());
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoResponse;
      localObject1 = paramBundle;
      if (localObject2 != null)
      {
        localObject2 = ((TroopFileProtoReqMgrImpl.ProtoResponse)localObject2).jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
        localObject1 = paramBundle;
        if (localObject2 != null)
        {
          ((FromServiceMsg)localObject2).addAttribute("_tag_socket_connerror", paramBundle);
          localObject1 = paramBundle;
        }
      }
    }
    else
    {
      localObject1 = "";
    }
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequest;
    if ((paramBundle != null) && (paramBundle.jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver != null))
    {
      paramBundle = new Bundle();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequest.jdField_a_of_type_AndroidOsBundle != null) {
        paramBundle.putAll(this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequest.jdField_a_of_type_AndroidOsBundle);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoResponse;
      if ((localObject2 != null) && (((TroopFileProtoReqMgrImpl.ProtoResponse)localObject2).jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg != null))
      {
        paramBundle.putString("data_error_msg", this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoResponse.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailMsg());
        paramBundle.putInt("data_error_code", this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoResponse.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailCode());
        paramBundle = new StringBuilder();
        paramBundle.append("cookie<");
        paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoResponse.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequest.b);
        paramBundle.append("> onProtoResponse fail end. failCode:");
        paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoResponse.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailCode());
        paramBundle.append(" retryCount:");
        paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoResponse.jdField_a_of_type_ComTencentMobileqqAppStatictisInfo.c);
        paramBundle.append(" msfConErro:");
        paramBundle.append((String)localObject1);
        QLog.e("TroopFileProtoReqMgr", 1, paramBundle.toString());
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("cookie<");
        TroopFileProtoReqMgrImpl.ProtoResponse localProtoResponse = this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoResponse;
        paramBundle = str;
        if (localProtoResponse != null)
        {
          paramBundle = str;
          if (localProtoResponse.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequest != null) {
            paramBundle = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoResponse.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequest.b);
          }
        }
        ((StringBuilder)localObject2).append(paramBundle);
        ((StringBuilder)localObject2).append("> onProtoResponse fail end. msfConErro:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.e("TroopFileProtoReqMgr", 1, ((StringBuilder)localObject2).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequest.jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver.onResult(-1, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequest.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.TroopFileProtoReqMgrImpl.CheckConErroObserverImp
 * JD-Core Version:    0.7.0.1
 */