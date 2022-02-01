package com.tencent.mobileqq.gallery.picocr;

import android.text.TextUtils;
import atvq;
import atvt;
import atvu;
import atvx;
import atvy;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class PicOcrManager$3
  implements Runnable
{
  public PicOcrManager$3(atvq paramatvq, atvt paramatvt, atvu paramatvu) {}
  
  public void run()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Atvt.d)) || (this.jdField_a_of_type_Atvt.a))
    {
      this.jdField_a_of_type_Atvt.d = atvy.a(this.jdField_a_of_type_Atvt.b);
      this.jdField_a_of_type_Atvt.a = false;
    }
    if (!atvq.a(this.this$0).isEmpty())
    {
      atvx localatvx = this.this$0.a(this.jdField_a_of_type_Atvt.d);
      if (localatvx != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PicOcrManager", 2, "requestOcr cacheRsp:" + localatvx.toString());
        }
        this.jdField_a_of_type_Atvu.a(localatvx);
        return;
      }
    }
    atvq.a(this.this$0, this.jdField_a_of_type_Atvu, this.jdField_a_of_type_Atvt);
    if (this.jdField_a_of_type_Atvt.a())
    {
      this.this$0.a(this.jdField_a_of_type_Atvu, this.jdField_a_of_type_Atvt);
      this.jdField_a_of_type_Atvu.a();
      return;
    }
    this.jdField_a_of_type_Atvu.onUpdate(100, false, new atvx());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrManager.3
 * JD-Core Version:    0.7.0.1
 */