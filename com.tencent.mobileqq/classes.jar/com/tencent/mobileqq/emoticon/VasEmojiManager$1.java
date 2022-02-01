package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import asig;
import asih;
import asjs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class VasEmojiManager$1
  implements Runnable
{
  public VasEmojiManager$1(asjs paramasjs, String paramString, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    Object localObject = this.this$0.a();
    if ((!new File(asjs.b(this.jdField_a_of_type_JavaLangString)).exists()) || (!((asih)localObject).b(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, true, false)))
    {
      localObject = (VasQuickUpdateManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER);
      if (localObject != null)
      {
        asih.jdField_a_of_type_Asig.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
        ((VasQuickUpdateManager)localObject).downloadItem(1004L, this.jdField_a_of_type_JavaLangString, "VasEmojiManager");
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.this$0.a();
        ((asih)localObject).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        ((asih)localObject).a((Bundle)this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId), null, false, 0, "nomatch", 0L, 0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.VasEmojiManager.1
 * JD-Core Version:    0.7.0.1
 */