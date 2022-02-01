package com.tencent.mobileqq.vas;

import android.graphics.drawable.Drawable;
import android.os.Message;
import bgks;
import bgmg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

class PendantInfo$2
  implements Runnable
{
  PendantInfo$2(PendantInfo paramPendantInfo, int paramInt, long paramLong, Drawable paramDrawable) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PendantInfo", 2, "getDrawable, Runnable in");
    }
    Object localObject = bgks.b(this.this$0.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
    if (2 == this.jdField_a_of_type_Int) {
      localObject = bgks.b(this.this$0.jdField_a_of_type_Long, 8);
    }
    if (bgmg.a((String)localObject))
    {
      if (2 == this.jdField_a_of_type_Int)
      {
        this.this$0.a();
        if (this.this$0.jdField_a_of_type_ArrayOfJavaLangString == null) {
          this.this$0.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
        }
        label248:
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if ((this.this$0.n == -1) || (this.this$0.p == -1)) {
                  break;
                }
              } while ((this.this$0.n == 0) || (this.this$0.jdField_a_of_type_MqqOsMqqHandler == null));
              localObject = this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(20);
            } while (!PendantInfo.a((Message)localObject, this.jdField_a_of_type_Long));
            this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
            return;
            localObject = new File(bgks.b(this.this$0.jdField_a_of_type_Long, 4));
            if (this.this$0.a((File)localObject, this.jdField_a_of_type_Int) > -1) {}
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label295;
              }
              if (this.this$0.n != 0) {
                break label248;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("PendantInfo", 2, "static type request dynamic resources");
              return;
            }
          } while (this.this$0.jdField_a_of_type_MqqOsMqqHandler == null);
          localObject = this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(20);
        } while (!PendantInfo.a((Message)localObject, this.jdField_a_of_type_Long));
        this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
        return;
        label295:
        this.this$0.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
        return;
      }
      this.this$0.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, false, this.jdField_a_of_type_Long);
      return;
    }
    this.this$0.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PendantInfo.2
 * JD-Core Version:    0.7.0.1
 */