package com.tencent.mobileqq.gallery.picocr;

import android.text.TextUtils;
import avik;
import avin;
import avio;
import avir;
import avis;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class PicOcrManager$3
  implements Runnable
{
  public PicOcrManager$3(avik paramavik, avin paramavin, avio paramavio) {}
  
  public void run()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Avin.d)) || (this.jdField_a_of_type_Avin.a))
    {
      this.jdField_a_of_type_Avin.d = avis.a(this.jdField_a_of_type_Avin.b);
      this.jdField_a_of_type_Avin.a = false;
    }
    if (!avik.a(this.this$0).isEmpty())
    {
      avir localavir = this.this$0.a(this.jdField_a_of_type_Avin.d);
      if (localavir != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PicOcrManager", 2, "requestOcr cacheRsp:" + localavir.toString());
        }
        this.jdField_a_of_type_Avio.a(localavir);
        return;
      }
    }
    avik.a(this.this$0, this.jdField_a_of_type_Avio, this.jdField_a_of_type_Avin);
    if (this.jdField_a_of_type_Avin.a())
    {
      this.this$0.a(this.jdField_a_of_type_Avio, this.jdField_a_of_type_Avin);
      this.jdField_a_of_type_Avio.a();
      return;
    }
    this.jdField_a_of_type_Avio.onUpdate(100, false, new avir());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrManager.3
 * JD-Core Version:    0.7.0.1
 */