package com.tencent.mobileqq.model;

import android.os.Handler;
import awyr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.app.MobileQQ;

public class EmoticonManager$26
  implements Runnable
{
  public EmoticonManager$26(awyr paramawyr, int paramInt) {}
  
  public void run()
  {
    Object localObject = new File(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), "recommemd_emotion_file__" + this.a + this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    if (!((File)localObject).exists()) {}
    for (;;)
    {
      try
      {
        if (!((File)localObject).createNewFile())
        {
          QLog.e("EmoticonManager", 1, "writeRecommendInfoFromFileToCache, create file fail");
          return;
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
      byte[] arrayOfByte = FileUtils.fileToBytes((File)localObject);
      localObject = new EmosmPb.SubCmd0x5RspBQRecommend();
      if (arrayOfByte == null) {
        continue;
      }
      try
      {
        ((EmosmPb.SubCmd0x5RspBQRecommend)localObject).mergeFrom(arrayOfByte);
        if (localObject == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonManager", 2, "writeRecommendInfoFromFileToCache post to uithread");
        }
        this.this$0.jdField_a_of_type_AndroidOsHandler.post(new EmoticonManager.26.1(this, (EmosmPb.SubCmd0x5RspBQRecommend)localObject));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject = null;
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.26
 * JD-Core Version:    0.7.0.1
 */