package com.tencent.mobileqq.weiyun.api.impl;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.weiyun.api.IWeiyunCallback;
import com.tencent.mobileqq.weiyun.channel.WySender.ICallback;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.MsgBody;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.RspMsgBody;
import com.tencent.mobileqq.weiyun.utils.WyLog;

class BaseCallback<T>
  implements WySender.ICallback
{
  private static final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131701172);
  private final int jdField_a_of_type_Int;
  private final IWeiyunCallback<T> jdField_a_of_type_ComTencentMobileqqWeiyunApiIWeiyunCallback;
  
  BaseCallback(int paramInt, IWeiyunCallback<T> paramIWeiyunCallback)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWeiyunApiIWeiyunCallback = paramIWeiyunCallback;
  }
  
  public void a(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWeiyunApiIWeiyunCallback == null) {
      return;
    }
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      try
      {
        paramString = (WeiyunPB.MsgBody)new WeiyunPB.MsgBody().mergeFrom(paramArrayOfByte);
        paramString = (WeiyunPB.RspMsgBody)paramString.RspMsg_body.get();
        if (paramString == null)
        {
          WyLog.a().w("BaseCallback", "rspMsgBody is null.");
          paramString = jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentMobileqqWeiyunApiIWeiyunCallback.a(1828003, paramString, null);
          return;
        }
        switch (this.jdField_a_of_type_Int)
        {
        default: 
          paramString = jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentMobileqqWeiyunApiIWeiyunCallback.a(1828001, paramString, null);
          return;
        case 246001: 
          this.jdField_a_of_type_ComTencentMobileqqWeiyunApiIWeiyunCallback.a(paramString.AioPicAndVideoCopyToWeiyunMsgRsp_body);
          return;
        case 246000: 
          this.jdField_a_of_type_ComTencentMobileqqWeiyunApiIWeiyunCallback.a(paramString.QqSdkFileUploadMsgRsp_body);
          return;
        case 245706: 
          this.jdField_a_of_type_ComTencentMobileqqWeiyunApiIWeiyunCallback.a(paramString.CrossBidProxyOfflineFileGetListMsgRsp_body);
          return;
        case 245700: 
          this.jdField_a_of_type_ComTencentMobileqqWeiyunApiIWeiyunCallback.a(paramString.CrossBidProxyCopyFileToOtherBidMsgRsp_body);
          return;
        case 26113: 
          this.jdField_a_of_type_ComTencentMobileqqWeiyunApiIWeiyunCallback.a(paramString.LibInfoListGetMsgRsp_body);
          return;
        case 12102: 
          this.jdField_a_of_type_ComTencentMobileqqWeiyunApiIWeiyunCallback.a(paramString.WeiyunShareAddFromMobileQQMsgRsp_body);
          return;
        case 11005: 
          this.jdField_a_of_type_ComTencentMobileqqWeiyunApiIWeiyunCallback.a(paramString.PwdVerifyMsgRsp_body);
          return;
        case 11001: 
          this.jdField_a_of_type_ComTencentMobileqqWeiyunApiIWeiyunCallback.a(paramString.PwdQueryMsgRsp_body);
          return;
        case 2804: 
          this.jdField_a_of_type_ComTencentMobileqqWeiyunApiIWeiyunCallback.a(paramString.DiskAlbumStatusReportRsp_body);
          return;
        case 2803: 
          this.jdField_a_of_type_ComTencentMobileqqWeiyunApiIWeiyunCallback.a(paramString.DiskPicBackupRsp_body);
          return;
        case 2509: 
          this.jdField_a_of_type_ComTencentMobileqqWeiyunApiIWeiyunCallback.a(paramString.DiskDirFileBatchDeleteExMsgRsp_body);
          return;
        case 2414: 
          this.jdField_a_of_type_ComTencentMobileqqWeiyunApiIWeiyunCallback.a(paramString.DiskFileDocDownloadAbsMsgRsp_body);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqWeiyunApiIWeiyunCallback.a(paramString.DiskFileBatchDownloadMsgRsp_body);
        return;
      }
      catch (Throwable paramString)
      {
        WyLog.a().w("BaseCallback", "decode Rsp Body failed.", paramString);
        paramString = jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqWeiyunApiIWeiyunCallback.a(1828003, paramString, null);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWeiyunApiIWeiyunCallback.a(paramInt, paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.BaseCallback
 * JD-Core Version:    0.7.0.1
 */