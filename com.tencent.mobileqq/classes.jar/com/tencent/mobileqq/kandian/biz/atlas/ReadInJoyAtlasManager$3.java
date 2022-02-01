package com.tencent.mobileqq.kandian.biz.atlas;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.RspBody;

class ReadInJoyAtlasManager$3
  extends ProtoUtils.AppProtocolObserver
{
  ReadInJoyAtlasManager$3(ReadInJoyAtlasManager paramReadInJoyAtlasManager, ReadInJoyAtlasManager.AtlasCallbackImpl paramAtlasCallbackImpl, String paramString) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      paramBundle = ReadInJoyAtlasManager.TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fetchAtlas0xbe0 onResult, errorCode=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d(paramBundle, 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt != -1) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      try
      {
        paramBundle = new oidb_cmd0x83e.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoyAtlasManager$AtlasCallbackImpl == null) {
          break label196;
        }
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoyAtlasManager$AtlasCallbackImpl;
        localObject = this.jdField_a_of_type_JavaLangString;
        if (paramBundle.uint32_is_like.get() != 1) {
          break label197;
        }
        bool = true;
        paramArrayOfByte.a(true, (String)localObject, bool, 0);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoyAtlasManager$AtlasCallbackImpl;
        if (paramBundle != null) {
          paramBundle.a(false, this.jdField_a_of_type_JavaLangString, false, 0);
        }
        paramBundle = ReadInJoyAtlasManager.TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fetchAtlas0xbe0 onResult(), exception=");
        ((StringBuilder)localObject).append(paramArrayOfByte.toString());
        QLog.e(paramBundle, 1, ((StringBuilder)localObject).toString());
        return;
      }
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoyAtlasManager$AtlasCallbackImpl;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.a(false, this.jdField_a_of_type_JavaLangString, false, paramInt);
      }
      label196:
      return;
      label197:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager.3
 * JD-Core Version:    0.7.0.1
 */