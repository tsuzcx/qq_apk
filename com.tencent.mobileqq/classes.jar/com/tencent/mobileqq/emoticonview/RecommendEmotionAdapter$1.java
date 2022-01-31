package com.tencent.mobileqq.emoticonview;

import apyf;
import apyk;
import bdrk;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class RecommendEmotionAdapter$1
  implements Runnable
{
  public RecommendEmotionAdapter$1(apyf paramapyf, apyk paramapyk) {}
  
  public void run()
  {
    for (int i = 1;; i = -1) {
      synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
      {
        File localFile = VasQuickUpdateManager.getFileFromLocal(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1003L, "emotionRecommendEffect", null, this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true), this.this$0.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
        if (localFile == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect effectFile = null, id:" + this.a.jdField_a_of_type_Bdrk.a + ", index:" + this.a.jdField_a_of_type_Int);
          }
          if (this.this$0.b == null) {
            this.this$0.b = new ArrayList();
          }
          if (this.this$0.b.size() <= 0) {
            continue;
          }
          i = ((apyk)this.this$0.b.get(0)).jdField_a_of_type_Int;
          if (this.a.jdField_a_of_type_Int < i)
          {
            this.this$0.b.add(0, this.a);
            i = 0;
          }
        }
        else
        {
          if (i != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect postShow, id:" + this.a.jdField_a_of_type_Bdrk.a + ", index:" + this.a.jdField_a_of_type_Int);
            }
            this.a.jdField_a_of_type_JavaIoFile = localFile;
            this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(102, this.a));
          }
          return;
        }
        this.this$0.b.add(this.a);
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter.1
 * JD-Core Version:    0.7.0.1
 */