package com.tencent.mobileqq.gallery.picocr;

import android.text.TextUtils;
import aqmw;
import aqmz;
import aqna;
import aqnd;
import aqne;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class PicOcrManager$3
  implements Runnable
{
  public PicOcrManager$3(aqmw paramaqmw, aqmz paramaqmz, aqna paramaqna) {}
  
  public void run()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Aqmz.d)) || (this.jdField_a_of_type_Aqmz.a))
    {
      this.jdField_a_of_type_Aqmz.d = aqne.a(this.jdField_a_of_type_Aqmz.b);
      this.jdField_a_of_type_Aqmz.a = false;
    }
    if (!aqmw.a(this.this$0).isEmpty())
    {
      aqnd localaqnd = this.this$0.a(this.jdField_a_of_type_Aqmz.d);
      if (localaqnd != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PicOcrManager", 2, "requestOcr cacheRsp:" + localaqnd.toString());
        }
        this.jdField_a_of_type_Aqna.a(localaqnd);
        return;
      }
    }
    aqmw.a(this.this$0, this.jdField_a_of_type_Aqna, this.jdField_a_of_type_Aqmz);
    if (this.jdField_a_of_type_Aqmz.a())
    {
      this.this$0.a(this.jdField_a_of_type_Aqna, this.jdField_a_of_type_Aqmz);
      this.jdField_a_of_type_Aqna.a();
      return;
    }
    this.jdField_a_of_type_Aqna.onUpdate(100, false, new aqnd());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrManager.3
 * JD-Core Version:    0.7.0.1
 */