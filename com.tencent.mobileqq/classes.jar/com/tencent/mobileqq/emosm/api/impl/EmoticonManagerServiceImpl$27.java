package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import java.io.File;
import mqq.app.MobileQQ;

class EmoticonManagerServiceImpl$27
  implements Runnable
{
  EmoticonManagerServiceImpl$27(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl, int paramInt, EmosmPb.SubCmd0x5RspBQRecommend paramSubCmd0x5RspBQRecommend) {}
  
  public void run()
  {
    File localFile = this.this$0.app.getApplication().getFilesDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recommemd_emotion_file__");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(this.this$0.app.getCurrentUin());
    FileUtils.pushData2File(new File(localFile, localStringBuilder.toString()).getAbsolutePath(), this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend.toByteArray(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.27
 * JD-Core Version:    0.7.0.1
 */