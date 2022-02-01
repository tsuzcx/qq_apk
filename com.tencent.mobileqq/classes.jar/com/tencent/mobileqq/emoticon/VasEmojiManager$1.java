package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

class VasEmojiManager$1
  implements Runnable
{
  VasEmojiManager$1(VasEmojiManager paramVasEmojiManager, String paramString, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    Object localObject = this.this$0.a();
    if ((!new File(VasEmojiManager.b(this.jdField_a_of_type_JavaLangString)).exists()) || (!((EmojiManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, true, false)))
    {
      localObject = (IVasQuickUpdateService)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
      if (localObject != null)
      {
        EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
        ((IVasQuickUpdateService)localObject).downloadItem(1004L, this.jdField_a_of_type_JavaLangString, "VasEmojiManager");
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.this$0.a();
        ((EmojiManager)localObject).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        ((EmojiManager)localObject).a((Bundle)this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId), null, false, 0, "nomatch", 0L, 0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.VasEmojiManager.1
 * JD-Core Version:    0.7.0.1
 */