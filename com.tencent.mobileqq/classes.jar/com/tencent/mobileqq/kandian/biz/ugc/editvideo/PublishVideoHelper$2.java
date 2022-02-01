package com.tencent.mobileqq.kandian.biz.ugc.editvideo;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.qphone.base.util.QLog;

final class PublishVideoHelper$2
  extends ProtoUtils.TroopProtocolObserver
{
  PublishVideoHelper$2(PublishVideoHelper.IMoveUgcVideoCallback paramIMoveUgcVideoCallback, int paramInt) {}
  
  public boolean onError(int paramInt, String paramString, Bundle paramBundle)
  {
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEditvideoPublishVideoHelper$IMoveUgcVideoCallback;
    if (paramBundle != null) {
      paramBundle.a(paramInt, paramString);
    }
    paramBundle = new StringBuilder();
    paramBundle.append("moveVideo: columnId = ");
    paramBundle.append(this.jdField_a_of_type_Int);
    paramBundle.append("errorCode = ");
    paramBundle.append(paramInt);
    paramBundle.append(",errorMsg =");
    paramBundle.append(paramString);
    QLog.e("RIJUGC.PublishVideoHelper", 1, paramBundle.toString());
    return true;
  }
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEditvideoPublishVideoHelper$IMoveUgcVideoCallback;
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte.a(paramInt, "");
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("moveVideo: errorCode = ");
        paramArrayOfByte.append(paramInt);
        paramArrayOfByte.append("callback =");
        paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEditvideoPublishVideoHelper$IMoveUgcVideoCallback);
        QLog.d("RIJUGC.PublishVideoHelper", 2, paramArrayOfByte.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("moveVideo: errorCode = ");
      paramArrayOfByte.append(paramInt);
      paramArrayOfByte.append("callback is null.");
      QLog.d("RIJUGC.PublishVideoHelper", 2, paramArrayOfByte.toString());
    }
    ReadInJoyLogicEngineEventDispatcher.a().d(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.editvideo.PublishVideoHelper.2
 * JD-Core Version:    0.7.0.1
 */