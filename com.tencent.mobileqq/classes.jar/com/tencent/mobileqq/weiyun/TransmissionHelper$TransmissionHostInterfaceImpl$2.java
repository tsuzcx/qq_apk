package com.tencent.mobileqq.weiyun;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunCallback;
import com.tencent.mobileqq.weiyun.api.IWeiyunHelper;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.QqSdkFileUploadMsgRsp;
import com.tencent.mobileqq.weiyun.utils.StringUtils;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.UploadServerInfoCallback;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.utils.Utils;

class TransmissionHelper$TransmissionHostInterfaceImpl$2
  implements IWeiyunCallback<WeiyunPB.QqSdkFileUploadMsgRsp>
{
  TransmissionHelper$TransmissionHostInterfaceImpl$2(TransmissionHelper.TransmissionHostInterfaceImpl paramTransmissionHostInterfaceImpl, WeiyunTransmissionGlobal.UploadServerInfoCallback paramUploadServerInfoCallback, UploadFile paramUploadFile) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.QqSdkFileUploadMsgRsp paramQqSdkFileUploadMsgRsp)
  {
    this.jdField_a_of_type_ComTencentWeiyunTransmissionWeiyunTransmissionGlobal$UploadServerInfoCallback.onResult(this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile, false, paramInt, paramString);
  }
  
  public void a(WeiyunPB.QqSdkFileUploadMsgRsp paramQqSdkFileUploadMsgRsp)
  {
    if (paramQqSdkFileUploadMsgRsp == null)
    {
      this.jdField_a_of_type_ComTencentWeiyunTransmissionWeiyunTransmissionGlobal$UploadServerInfoCallback.onResult(this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile, false, 1828004, HardCodeUtil.a(2131714862));
      return;
    }
    Object localObject1 = paramQqSdkFileUploadMsgRsp.pdir_key.get();
    Object localObject3 = paramQqSdkFileUploadMsgRsp.ppdir_key.get();
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = StringUtils.a((ByteStringMicro)localObject1);
    }
    if (localObject3 == null) {
      localObject2 = null;
    } else {
      localObject2 = StringUtils.a((ByteStringMicro)localObject3);
    }
    if ((localObject1 != null) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile.pDirKey))) {
      this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile.pDirKey = ((String)localObject1);
    }
    if ((localObject3 != null) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile.pPDirKey))) {
      this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile.pPDirKey = ((String)localObject2);
    }
    ((IWeiyunHelper)QRoute.api(IWeiyunHelper.class)).saveDefaultUploadDirKey((String)localObject2, (String)localObject1);
    Object localObject2 = this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile;
    boolean bool = paramQqSdkFileUploadMsgRsp.file_exist.get();
    localObject3 = paramQqSdkFileUploadMsgRsp.file_id.get();
    String str = paramQqSdkFileUploadMsgRsp.server_name.get();
    if (WeiyunTransmissionGlobal.getInstance().isNativeUpload()) {
      localObject1 = paramQqSdkFileUploadMsgRsp.inside_upload_ip;
    } else {
      localObject1 = paramQqSdkFileUploadMsgRsp.outside_upload_ip;
    }
    ((UploadFile)localObject2).setServerInfo(bool, (String)localObject3, str, ((PBStringField)localObject1).get(), paramQqSdkFileUploadMsgRsp.server_port.get(), Utils.bytes2HexStr(paramQqSdkFileUploadMsgRsp.check_key.get().toByteArray()).toLowerCase(), paramQqSdkFileUploadMsgRsp.channel_count.get(), Integer.toString(paramQqSdkFileUploadMsgRsp.file_version.get()));
    this.jdField_a_of_type_ComTencentWeiyunTransmissionWeiyunTransmissionGlobal$UploadServerInfoCallback.onResult(this.jdField_a_of_type_ComTencentWeiyunTransmissionUploadUploadFile, true, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.TransmissionHelper.TransmissionHostInterfaceImpl.2
 * JD-Core Version:    0.7.0.1
 */