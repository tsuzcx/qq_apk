package cooperation.weiyun;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskFileBatchDownloadMsgRsp;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskFileDownloadRspItem;
import cooperation.weiyun.sdk.api.IWeiyunCallback;
import cooperation.weiyun.sdk.download.DownloadFile;
import cooperation.weiyun.sdk.download.DownloadFile.DownloadServerInfo;
import cooperation.weiyun.sdk.download.DownloadHelper;
import cooperation.weiyun.sdk.download.WyDownloader.DownloadServerInfoCallback;
import java.util.Iterator;
import java.util.List;

class TransmissionHelper$2$1
  implements IWeiyunCallback<WeiyunPB.DiskFileBatchDownloadMsgRsp>
{
  TransmissionHelper$2$1(TransmissionHelper.2 param2, DownloadFile paramDownloadFile, WyDownloader.DownloadServerInfoCallback paramDownloadServerInfoCallback, int paramInt) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.DiskFileBatchDownloadMsgRsp paramDiskFileBatchDownloadMsgRsp)
  {
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$DownloadServerInfoCallback.a(this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadFile, false, paramInt, paramString);
  }
  
  public void a(WeiyunPB.DiskFileBatchDownloadMsgRsp paramDiskFileBatchDownloadMsgRsp)
  {
    Object localObject;
    if ((paramDiskFileBatchDownloadMsgRsp != null) && (paramDiskFileBatchDownloadMsgRsp.file_list != null))
    {
      localObject = paramDiskFileBatchDownloadMsgRsp.file_list.get().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramDiskFileBatchDownloadMsgRsp = (WeiyunPB.DiskFileDownloadRspItem)((Iterator)localObject).next();
      } while ((paramDiskFileBatchDownloadMsgRsp == null) || (!TextUtils.equals(paramDiskFileBatchDownloadMsgRsp.file_id.get(), this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadFile.jdField_a_of_type_JavaLangString)));
    }
    for (;;)
    {
      if (paramDiskFileBatchDownloadMsgRsp == null)
      {
        this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$DownloadServerInfoCallback.a(this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadFile, false, 1828004, HardCodeUtil.a(2131714930));
        return;
      }
      localObject = paramDiskFileBatchDownloadMsgRsp.cookie_name.get();
      String str = paramDiskFileBatchDownloadMsgRsp.cookie_value.get();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str))) {}
      for (localObject = "";; localObject = (String)localObject + '=' + str)
      {
        this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadFile.a(paramDiskFileBatchDownloadMsgRsp.server_name.get(), paramDiskFileBatchDownloadMsgRsp.server_port.get(), (String)localObject, paramDiskFileBatchDownloadMsgRsp.download_url.get(), paramDiskFileBatchDownloadMsgRsp.video_url.get(), "0");
        if (this.jdField_a_of_type_Int == 0) {
          this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadFile.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadFile$DownloadServerInfo.c = DownloadHelper.a(this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadFile.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadFile$DownloadServerInfo.c);
        }
        this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$DownloadServerInfoCallback.a(this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadFile, true, 0, null);
        return;
      }
      paramDiskFileBatchDownloadMsgRsp = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.TransmissionHelper.2.1
 * JD-Core Version:    0.7.0.1
 */