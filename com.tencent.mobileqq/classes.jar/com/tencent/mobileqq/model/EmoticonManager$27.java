package com.tencent.mobileqq.model;

import awyr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import java.io.File;
import mqq.app.MobileQQ;

public class EmoticonManager$27
  implements Runnable
{
  public EmoticonManager$27(awyr paramawyr, int paramInt, EmosmPb.SubCmd0x5RspBQRecommend paramSubCmd0x5RspBQRecommend) {}
  
  public void run()
  {
    FileUtils.pushData2File(new File(this.this$0.a.getApplication().getFilesDir(), "recommemd_emotion_file__" + this.jdField_a_of_type_Int + this.this$0.a.getCurrentUin()).getAbsolutePath(), this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend.toByteArray(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.27
 * JD-Core Version:    0.7.0.1
 */