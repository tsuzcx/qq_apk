package com.tencent.mobileqq.weiyun;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.weiyun.api.download.DownloadServerInfoCallback;
import com.tencent.mobileqq.weiyun.api.download.IFetchListener;
import com.tencent.mobileqq.weiyun.model.DownloadFile;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskFileBatchDownloadMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskSimpleFileItem;
import com.tencent.mobileqq.weiyun.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

final class TransmissionHelper$2
  implements IFetchListener
{
  public void a(DownloadFile paramDownloadFile, int paramInt, DownloadServerInfoCallback paramDownloadServerInfoCallback)
  {
    Object localObject2 = new WeiyunPB.DiskSimpleFileItem();
    ((WeiyunPB.DiskSimpleFileItem)localObject2).file_id.set(paramDownloadFile.a);
    if (paramDownloadFile.e != null) {
      ((WeiyunPB.DiskSimpleFileItem)localObject2).pdir_key.set(StringUtils.a(paramDownloadFile.e));
    }
    ((WeiyunPB.DiskSimpleFileItem)localObject2).filename.set(paramDownloadFile.b);
    boolean bool = true;
    Object localObject1 = new ArrayList(1);
    ((List)localObject1).add(localObject2);
    localObject2 = new WeiyunPB.DiskFileBatchDownloadMsgReq();
    ((WeiyunPB.DiskFileBatchDownloadMsgReq)localObject2).file_list.set((List)localObject1);
    ((WeiyunPB.DiskFileBatchDownloadMsgReq)localObject2).download_type.set(paramInt);
    localObject1 = ((WeiyunPB.DiskFileBatchDownloadMsgReq)localObject2).need_thumb;
    if (paramInt != 1) {
      bool = false;
    }
    ((PBBoolField)localObject1).set(bool);
    if ((!TextUtils.isEmpty(paramDownloadFile.d)) && (TextUtils.isDigitsOnly(paramDownloadFile.d))) {
      ((WeiyunPB.DiskFileBatchDownloadMsgReq)localObject2).file_owner.set(Long.parseLong(paramDownloadFile.d));
    }
    ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).fetchDownloadAddress((WeiyunPB.DiskFileBatchDownloadMsgReq)localObject2, new TransmissionHelper.2.1(this, paramDownloadFile, paramDownloadServerInfoCallback, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.TransmissionHelper.2
 * JD-Core Version:    0.7.0.1
 */