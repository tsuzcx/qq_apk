package com.tencent.mobileqq.gallery.picocr;

import android.text.TextUtils;
import asfk;
import asfn;
import asfo;
import asfr;
import asfs;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class PicOcrManager$3
  implements Runnable
{
  public PicOcrManager$3(asfk paramasfk, asfn paramasfn, asfo paramasfo) {}
  
  public void run()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Asfn.d)) || (this.jdField_a_of_type_Asfn.a))
    {
      this.jdField_a_of_type_Asfn.d = asfs.a(this.jdField_a_of_type_Asfn.b);
      this.jdField_a_of_type_Asfn.a = false;
    }
    if (!asfk.a(this.this$0).isEmpty())
    {
      asfr localasfr = this.this$0.a(this.jdField_a_of_type_Asfn.d);
      if (localasfr != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PicOcrManager", 2, "requestOcr cacheRsp:" + localasfr.toString());
        }
        this.jdField_a_of_type_Asfo.a(localasfr);
        return;
      }
    }
    asfk.a(this.this$0, this.jdField_a_of_type_Asfo, this.jdField_a_of_type_Asfn);
    if (this.jdField_a_of_type_Asfn.a())
    {
      this.this$0.a(this.jdField_a_of_type_Asfo, this.jdField_a_of_type_Asfn);
      this.jdField_a_of_type_Asfo.a();
      return;
    }
    this.jdField_a_of_type_Asfo.onUpdate(100, false, new asfr());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrManager.3
 * JD-Core Version:    0.7.0.1
 */