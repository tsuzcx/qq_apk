package com.tencent.mobileqq.emosm.api.impl;

import android.os.Handler;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.app.MobileQQ;

class EmoticonManagerServiceImpl$26
  implements Runnable
{
  EmoticonManagerServiceImpl$26(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.this$0.app.getApplication().getFilesDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recommemd_emotion_file__");
    localStringBuilder.append(this.a);
    localStringBuilder.append(this.this$0.app.getCurrentUin());
    localObject = new File((File)localObject, localStringBuilder.toString());
    if (!((File)localObject).exists()) {
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
    }
    byte[] arrayOfByte = FileUtils.fileToBytes((File)localObject);
    localObject = new EmosmPb.SubCmd0x5RspBQRecommend();
    if (arrayOfByte != null)
    {
      try
      {
        ((EmosmPb.SubCmd0x5RspBQRecommend)localObject).mergeFrom(arrayOfByte);
      }
      catch (Exception localException)
      {
        localObject = null;
        localException.printStackTrace();
      }
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonManager", 2, "writeRecommendInfoFromFileToCache post to uithread");
        }
        this.this$0.uiHandler.post(new EmoticonManagerServiceImpl.26.1(this, (EmosmPb.SubCmd0x5RspBQRecommend)localObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.26
 * JD-Core Version:    0.7.0.1
 */