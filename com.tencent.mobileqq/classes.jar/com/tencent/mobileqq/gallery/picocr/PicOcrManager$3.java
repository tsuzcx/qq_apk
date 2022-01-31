package com.tencent.mobileqq.gallery.picocr;

import android.text.TextUtils;
import asjt;
import asjw;
import asjx;
import aska;
import askb;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class PicOcrManager$3
  implements Runnable
{
  public PicOcrManager$3(asjt paramasjt, asjw paramasjw, asjx paramasjx) {}
  
  public void run()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Asjw.d)) || (this.jdField_a_of_type_Asjw.a))
    {
      this.jdField_a_of_type_Asjw.d = askb.a(this.jdField_a_of_type_Asjw.b);
      this.jdField_a_of_type_Asjw.a = false;
    }
    if (!asjt.a(this.this$0).isEmpty())
    {
      aska localaska = this.this$0.a(this.jdField_a_of_type_Asjw.d);
      if (localaska != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PicOcrManager", 2, "requestOcr cacheRsp:" + localaska.toString());
        }
        this.jdField_a_of_type_Asjx.a(localaska);
        return;
      }
    }
    asjt.a(this.this$0, this.jdField_a_of_type_Asjx, this.jdField_a_of_type_Asjw);
    if (this.jdField_a_of_type_Asjw.a())
    {
      this.this$0.a(this.jdField_a_of_type_Asjx, this.jdField_a_of_type_Asjw);
      this.jdField_a_of_type_Asjx.a();
      return;
    }
    this.jdField_a_of_type_Asjx.onUpdate(100, false, new aska());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrManager.3
 * JD-Core Version:    0.7.0.1
 */