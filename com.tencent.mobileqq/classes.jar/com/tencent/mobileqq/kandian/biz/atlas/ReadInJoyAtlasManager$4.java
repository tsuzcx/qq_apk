package com.tencent.mobileqq.kandian.biz.atlas;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyAtlasManager$4
  extends ProtoUtils.AppProtocolObserver
{
  ReadInJoyAtlasManager$4(ReadInJoyAtlasManager paramReadInJoyAtlasManager, ReadInJoyAtlasManager.AtlasCallbackImpl paramAtlasCallbackImpl) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      paramBundle = ReadInJoyAtlasManager.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportGalleryExposed0xbe1 onResult, errorCode=");
      localStringBuilder.append(paramInt);
      QLog.d(paramBundle, 2, localStringBuilder.toString());
    }
    if ((paramInt != -1) && (paramArrayOfByte != null)) {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoyAtlasManager$AtlasCallbackImpl != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoyAtlasManager$AtlasCallbackImpl.a(true, 0);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoyAtlasManager$AtlasCallbackImpl;
        if (paramBundle != null) {
          paramBundle.a(true, paramInt);
        }
        paramBundle = ReadInJoyAtlasManager.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportGalleryExposed0xbe1 onResult(), exception=");
        localStringBuilder.append(paramArrayOfByte.toString());
        QLog.e(paramBundle, 1, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager.4
 * JD-Core Version:    0.7.0.1
 */