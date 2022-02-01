package com.tencent.mobileqq.weiyun;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.weiyun.api.IWeiyunCallback;
import com.tencent.mobileqq.weiyun.api.download.DownloadServerInfoCallback;
import com.tencent.mobileqq.weiyun.model.DownloadFile;
import com.tencent.mobileqq.weiyun.model.DownloadFile.DownloadServerInfo;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskFileBatchDownloadMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskFileDownloadRspItem;
import com.tencent.mobileqq.weiyun.sdk.download.DownloadHelper;
import java.util.Iterator;
import java.util.List;

class TransmissionHelper$2$1
  implements IWeiyunCallback<WeiyunPB.DiskFileBatchDownloadMsgRsp>
{
  TransmissionHelper$2$1(TransmissionHelper.2 param2, DownloadFile paramDownloadFile, DownloadServerInfoCallback paramDownloadServerInfoCallback, int paramInt) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.DiskFileBatchDownloadMsgRsp paramDiskFileBatchDownloadMsgRsp)
  {
    this.jdField_a_of_type_ComTencentMobileqqWeiyunApiDownloadDownloadServerInfoCallback.a(this.jdField_a_of_type_ComTencentMobileqqWeiyunModelDownloadFile, false, paramInt, paramString);
  }
  
  public void a(WeiyunPB.DiskFileBatchDownloadMsgRsp paramDiskFileBatchDownloadMsgRsp)
  {
    if ((paramDiskFileBatchDownloadMsgRsp != null) && (paramDiskFileBatchDownloadMsgRsp.file_list != null))
    {
      localObject = paramDiskFileBatchDownloadMsgRsp.file_list.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramDiskFileBatchDownloadMsgRsp = (WeiyunPB.DiskFileDownloadRspItem)((Iterator)localObject).next();
        if ((paramDiskFileBatchDownloadMsgRsp != null) && (TextUtils.equals(paramDiskFileBatchDownloadMsgRsp.file_id.get(), this.jdField_a_of_type_ComTencentMobileqqWeiyunModelDownloadFile.jdField_a_of_type_JavaLangString))) {
          break label72;
        }
      }
    }
    paramDiskFileBatchDownloadMsgRsp = null;
    label72:
    if (paramDiskFileBatchDownloadMsgRsp == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWeiyunApiDownloadDownloadServerInfoCallback.a(this.jdField_a_of_type_ComTencentMobileqqWeiyunModelDownloadFile, false, 1828004, HardCodeUtil.a(2131714860));
      return;
    }
    Object localObject = paramDiskFileBatchDownloadMsgRsp.cookie_name.get();
    String str = paramDiskFileBatchDownloadMsgRsp.cookie_value.get();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append('=');
      localStringBuilder.append(str);
      localObject = localStringBuilder.toString();
    }
    else
    {
      localObject = "";
    }
    this.jdField_a_of_type_ComTencentMobileqqWeiyunModelDownloadFile.a(paramDiskFileBatchDownloadMsgRsp.server_name.get(), paramDiskFileBatchDownloadMsgRsp.server_port.get(), (String)localObject, paramDiskFileBatchDownloadMsgRsp.download_url.get(), paramDiskFileBatchDownloadMsgRsp.video_url.get(), "0");
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWeiyunModelDownloadFile.jdField_a_of_type_ComTencentMobileqqWeiyunModelDownloadFile$DownloadServerInfo.c = DownloadHelper.a(this.jdField_a_of_type_ComTencentMobileqqWeiyunModelDownloadFile.jdField_a_of_type_ComTencentMobileqqWeiyunModelDownloadFile$DownloadServerInfo.c);
    }
    this.jdField_a_of_type_ComTencentMobileqqWeiyunApiDownloadDownloadServerInfoCallback.a(this.jdField_a_of_type_ComTencentMobileqqWeiyunModelDownloadFile, true, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.TransmissionHelper.2.1
 * JD-Core Version:    0.7.0.1
 */