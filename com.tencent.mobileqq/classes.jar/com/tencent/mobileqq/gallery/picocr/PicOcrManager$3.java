package com.tencent.mobileqq.gallery.picocr;

import android.text.TextUtils;
import aqmu;
import aqmx;
import aqmy;
import aqnb;
import aqnc;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class PicOcrManager$3
  implements Runnable
{
  public PicOcrManager$3(aqmu paramaqmu, aqmx paramaqmx, aqmy paramaqmy) {}
  
  public void run()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Aqmx.d)) || (this.jdField_a_of_type_Aqmx.a))
    {
      this.jdField_a_of_type_Aqmx.d = aqnc.a(this.jdField_a_of_type_Aqmx.b);
      this.jdField_a_of_type_Aqmx.a = false;
    }
    if (!aqmu.a(this.this$0).isEmpty())
    {
      aqnb localaqnb = this.this$0.a(this.jdField_a_of_type_Aqmx.d);
      if (localaqnb != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PicOcrManager", 2, "requestOcr cacheRsp:" + localaqnb.toString());
        }
        this.jdField_a_of_type_Aqmy.a(localaqnb);
        return;
      }
    }
    aqmu.a(this.this$0, this.jdField_a_of_type_Aqmy, this.jdField_a_of_type_Aqmx);
    if (this.jdField_a_of_type_Aqmx.a())
    {
      this.this$0.a(this.jdField_a_of_type_Aqmy, this.jdField_a_of_type_Aqmx);
      this.jdField_a_of_type_Aqmy.a();
      return;
    }
    this.jdField_a_of_type_Aqmy.onUpdate(100, false, new aqnb());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrManager.3
 * JD-Core Version:    0.7.0.1
 */