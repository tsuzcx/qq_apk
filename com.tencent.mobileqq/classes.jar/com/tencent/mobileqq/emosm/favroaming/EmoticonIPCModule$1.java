package com.tencent.mobileqq.emosm.favroaming;

import android.os.Bundle;
import eipc.EIPCResult;

class EmoticonIPCModule$1
  implements Runnable
{
  EmoticonIPCModule$1(EmoticonIPCModule paramEmoticonIPCModule, Bundle paramBundle, String paramString, EmoticonFromGroupManager paramEmoticonFromGroupManager, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("pic_md5");
    if ("action_group_emo_big_pic_add_fav".equals(this.jdField_a_of_type_JavaLangString)) {
      if (!this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.b((String)localObject))
      {
        localObject = EIPCResult.createResult(-102, null);
        this.this$0.callbackResult(this.jdField_a_of_type_Int, (EIPCResult)localObject);
      }
    }
    while (!"action_group_emo_big_pic_upload_wy".equals(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a((String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonIPCModule.1
 * JD-Core Version:    0.7.0.1
 */