package com.tencent.mobileqq.gallery.picocr;

import android.text.TextUtils;
import avaq;
import avat;
import avau;
import avaw;
import avax;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class PicOcrManager$3
  implements Runnable
{
  public PicOcrManager$3(avaq paramavaq, avat paramavat, avau paramavau) {}
  
  public void run()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Avat.d)) || (this.jdField_a_of_type_Avat.a))
    {
      this.jdField_a_of_type_Avat.d = avax.a(this.jdField_a_of_type_Avat.b);
      this.jdField_a_of_type_Avat.a = false;
    }
    if (!avaq.a(this.this$0).isEmpty())
    {
      avaw localavaw = this.this$0.a(this.jdField_a_of_type_Avat.d);
      if (localavaw != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PicOcrManager", 2, "requestOcr cacheRsp:" + localavaw.toString());
        }
        this.jdField_a_of_type_Avau.a(localavaw);
        return;
      }
    }
    avaq.a(this.this$0, this.jdField_a_of_type_Avau, this.jdField_a_of_type_Avat);
    if (this.jdField_a_of_type_Avat.a())
    {
      this.this$0.a(this.jdField_a_of_type_Avau, this.jdField_a_of_type_Avat);
      this.jdField_a_of_type_Avau.a();
      return;
    }
    this.jdField_a_of_type_Avau.onUpdate(100, false, new avaw());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrManager.3
 * JD-Core Version:    0.7.0.1
 */