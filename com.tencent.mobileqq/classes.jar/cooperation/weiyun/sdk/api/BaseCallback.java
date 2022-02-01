package cooperation.weiyun.sdk.api;

import com.tencent.mobileqq.app.HardCodeUtil;
import cooperation.weiyun.channel.WySender.ICallback;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgBody;
import cooperation.weiyun.channel.pb.WeiyunPB.RspMsgBody;
import cooperation.weiyun.utils.WyLog;

class BaseCallback<T>
  implements WySender.ICallback
{
  private static final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131701029);
  private final int jdField_a_of_type_Int;
  private final IWeiyunCallback<T> jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback;
  
  BaseCallback(int paramInt, IWeiyunCallback<T> paramIWeiyunCallback)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback = paramIWeiyunCallback;
  }
  
  public void a(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback == null) {
      return;
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramInt, paramString, null);
      return;
    }
    try
    {
      paramString = (WeiyunPB.MsgBody)new WeiyunPB.MsgBody().mergeFrom(paramArrayOfByte);
      paramString = (WeiyunPB.RspMsgBody)paramString.RspMsg_body.get();
      if (paramString == null)
      {
        WyLog.a().w("BaseCallback", "rspMsgBody is null.");
        paramString = jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(1828003, paramString, null);
        return;
      }
    }
    catch (Throwable paramString)
    {
      WyLog.a().w("BaseCallback", "decode Rsp Body failed.", paramString);
      paramString = jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(1828003, paramString, null);
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      paramString = jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(1828001, paramString, null);
      return;
    case 26113: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.LibInfoListGetMsgRsp_body);
      return;
    case 2402: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.DiskFileBatchDownloadMsgRsp_body);
      return;
    case 2414: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.DiskFileDocDownloadAbsMsgRsp_body);
      return;
    case 2509: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.DiskDirFileBatchDeleteExMsgRsp_body);
      return;
    case 2803: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.DiskPicBackupRsp_body);
      return;
    case 2804: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.DiskAlbumStatusReportRsp_body);
      return;
    case 11001: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.PwdQueryMsgRsp_body);
      return;
    case 11005: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.PwdVerifyMsgRsp_body);
      return;
    case 245700: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.CrossBidProxyCopyFileToOtherBidMsgRsp_body);
      return;
    case 245706: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.CrossBidProxyOfflineFileGetListMsgRsp_body);
      return;
    case 246000: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.QqSdkFileUploadMsgRsp_body);
      return;
    case 246001: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.AioPicAndVideoCopyToWeiyunMsgRsp_body);
      return;
    }
    this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.WeiyunShareAddFromMobileQQMsgRsp_body);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.sdk.api.BaseCallback
 * JD-Core Version:    0.7.0.1
 */