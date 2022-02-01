package com.tencent.mobileqq.troop.filemanager;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.CheckConErroObserver;

public class TroopFileProtoReqMgr$CheckConErroObserverImp
  extends CheckConErroObserver
{
  TroopFileProtoReqMgr.ProtoRequest jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest;
  TroopFileProtoReqMgr.ProtoResponse jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse;
  
  public TroopFileProtoReqMgr$CheckConErroObserverImp(TroopFileProtoReqMgr paramTroopFileProtoReqMgr, TroopFileProtoReqMgr.ProtoResponse paramProtoResponse, TroopFileProtoReqMgr.ProtoRequest paramProtoRequest)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse = paramProtoResponse;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest = paramProtoRequest;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1 = "";
    if (paramBundle != null)
    {
      localObject1 = paramBundle.getString("msf_con_erro");
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopFileProtoReqMgr", 2, "CheckConErroObserverImp.onReceive -> msfConErro: " + paramBundle);
      }
      localObject1 = paramBundle;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
        localObject1 = paramBundle;
        if (localObject2 != null)
        {
          ((FromServiceMsg)localObject2).addAttribute("_tag_socket_connerror", paramBundle);
          localObject1 = paramBundle;
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest.jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver != null))
    {
      paramBundle = new Bundle();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest.jdField_a_of_type_AndroidOsBundle != null) {
        paramBundle.putAll(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest.jdField_a_of_type_AndroidOsBundle);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg != null))
      {
        paramBundle.putString("data_error_msg", this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailMsg());
        paramBundle.putInt("data_error_code", this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailCode());
        TroopFileTransferUtil.Log.a("TroopFileProtoReqMgr", TroopFileTransferUtil.Log.a, "cookie<" + this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest.b + "> onProtoResponse fail end. failCode:" + this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getBusinessFailCode() + " retryCount:" + this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse.jdField_a_of_type_ComTencentMobileqqAppStatictisInfo.c + " msfConErro:" + (String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest.jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver.a(-1, null, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest.jdField_a_of_type_AndroidOsBundle);
      }
    }
    else
    {
      return;
    }
    paramInt = TroopFileTransferUtil.Log.a;
    Object localObject2 = new StringBuilder().append("cookie<");
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest != null)) {}
    for (paramBundle = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest.b);; paramBundle = "")
    {
      TroopFileTransferUtil.Log.a("TroopFileProtoReqMgr", paramInt, paramBundle + "> onProtoResponse fail end. msfConErro:" + (String)localObject1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr.CheckConErroObserverImp
 * JD-Core Version:    0.7.0.1
 */