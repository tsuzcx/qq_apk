package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.IRequestCallback;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.ImageFilterResponse;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import yqg;
import yqi;

class ArtFilterUploadProcessor$2
  implements IRequestCallback
{
  ArtFilterUploadProcessor$2(ArtFilterUploadProcessor paramArtFilterUploadProcessor) {}
  
  public void onFailed(int paramInt)
  {
    this.this$0.endFilterTime = SystemClock.uptimeMillis();
    this.this$0.returnResult(paramInt, "getFilterTimeoutError");
  }
  
  public void onResponse(HwResponse paramHwResponse)
  {
    long l1 = 0L;
    this.this$0.endFilterTime = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "<BDH_LOG>getFilterResponse  retCode : " + paramHwResponse.retCode + " htCost:" + paramHwResponse.htCost + " front:" + paramHwResponse.cacheCost + " onResponse" + paramHwResponse);
    }
    Object localObject;
    if (paramHwResponse.retCode == 0)
    {
      if (!this.this$0.artFilterModule.b.equals(this.this$0.mFilterUploadInfo.jdField_a_of_type_JavaLangString)) {
        return;
      }
      this.this$0.artFilterModule.jdField_a_of_type_Long = this.this$0.endFilterTime;
      localObject = paramHwResponse.mBuExtendinfo;
      if ((localObject == null) || (localObject.length <= 0)) {
        break label493;
      }
    }
    for (;;)
    {
      try
      {
        localImageFilterResponse = new CSDataHighwayHead.ImageFilterResponse();
        localImageFilterResponse.mergeFrom((byte[])localObject);
        localObject = localImageFilterResponse.image_data.get();
        i = localImageFilterResponse.cost_time.get();
        l4 = i;
        l3 = l1;
        l2 = l3;
      }
      catch (InvalidProtocolBufferMicroException paramHwResponse)
      {
        try
        {
          l2 = paramHwResponse.cacheCost;
          l3 = l1;
          l2 = paramHwResponse.htCost + l2;
          l3 = l2;
          this.this$0.sendDownLoadRequest(((ByteStringMicro)localObject).toStringUtf8());
          l1 = l4;
          this.this$0.mReportInfo.put("teg_Costtime", String.valueOf(l1));
          this.this$0.mReportInfo.put("detailPic_Costtime", String.valueOf(l2));
          return;
        }
        catch (InvalidProtocolBufferMicroException paramHwResponse)
        {
          CSDataHighwayHead.ImageFilterResponse localImageFilterResponse;
          int i;
          long l4;
          long l3;
          long l2;
          break label270;
        }
        paramHwResponse = paramHwResponse;
        l4 = 0L;
        l3 = l1;
      }
      label270:
      l1 = l4;
      if (QLog.isColorLevel())
      {
        QLog.e("ArtFilterUploadProcessor", 2, "sendAckToBDHServer onResponse ", paramHwResponse);
        l2 = l3;
        l1 = l4;
        continue;
        this.this$0.returnResult(paramHwResponse.buzRetCode, "getFilterError");
        if (paramHwResponse.retCode == 222)
        {
          if (this.this$0.artFilterModule.b.equals(this.this$0.mFilterUploadInfo.jdField_a_of_type_JavaLangString))
          {
            this.this$0.artFilterModule.jdField_a_of_type_Long = 0L;
            this.this$0.artFilterModule.jdField_a_of_type_JavaLangString = null;
            l3 = 0L;
            l2 = l1;
            l1 = l3;
          }
        }
        else if (paramHwResponse.retCode == 221)
        {
          paramHwResponse = paramHwResponse.mBuExtendinfo;
          if ((paramHwResponse != null) && (paramHwResponse.length > 0)) {
            try
            {
              localImageFilterResponse = new CSDataHighwayHead.ImageFilterResponse();
              localImageFilterResponse.mergeFrom(paramHwResponse);
              i = localImageFilterResponse.ret_code.get();
              if (QLog.isColorLevel()) {
                QLog.e("ArtFilterUploadProcessor", 2, "teg pocess error" + i);
              }
              l3 = 0L;
              l2 = l1;
              l1 = l3;
            }
            catch (InvalidProtocolBufferMicroException paramHwResponse)
            {
              if (QLog.isColorLevel()) {
                QLog.e("ArtFilterUploadProcessor", 2, "sendAckToBDHServer onResponse ", paramHwResponse);
              }
            }
          }
        }
        label493:
        l3 = 0L;
        l2 = l1;
        l1 = l3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ArtFilterUploadProcessor.2
 * JD-Core Version:    0.7.0.1
 */