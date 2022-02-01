package com.tencent.mobileqq.emoticon.api.impl;

import com.tencent.mobileqq.data.EmoticonPackage;

class EmojiManagerServiceImpl$5
  implements Runnable
{
  EmojiManagerServiceImpl$5(EmojiManagerServiceImpl paramEmojiManagerServiceImpl, EmoticonPackage paramEmoticonPackage, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType != 2)
    {
      EmojiManagerServiceImpl localEmojiManagerServiceImpl = this.this$0;
      localEmojiManagerServiceImpl.handleEmoticonPackageDownload(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, localEmojiManagerServiceImpl.emotionDownloadListener, this.jdField_a_of_type_Boolean, this.b, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */