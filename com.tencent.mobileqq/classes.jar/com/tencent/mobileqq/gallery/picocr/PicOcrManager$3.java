package com.tencent.mobileqq.gallery.picocr;

import android.text.TextUtils;
import auqk;
import auqn;
import auqo;
import auqr;
import auqs;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class PicOcrManager$3
  implements Runnable
{
  public PicOcrManager$3(auqk paramauqk, auqn paramauqn, auqo paramauqo) {}
  
  public void run()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Auqn.d)) || (this.jdField_a_of_type_Auqn.a))
    {
      this.jdField_a_of_type_Auqn.d = auqs.a(this.jdField_a_of_type_Auqn.b);
      this.jdField_a_of_type_Auqn.a = false;
    }
    if (!auqk.a(this.this$0).isEmpty())
    {
      auqr localauqr = this.this$0.a(this.jdField_a_of_type_Auqn.d);
      if (localauqr != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PicOcrManager", 2, "requestOcr cacheRsp:" + localauqr.toString());
        }
        this.jdField_a_of_type_Auqo.a(localauqr);
        return;
      }
    }
    auqk.a(this.this$0, this.jdField_a_of_type_Auqo, this.jdField_a_of_type_Auqn);
    if (this.jdField_a_of_type_Auqn.a())
    {
      this.this$0.a(this.jdField_a_of_type_Auqo, this.jdField_a_of_type_Auqn);
      this.jdField_a_of_type_Auqo.a();
      return;
    }
    this.jdField_a_of_type_Auqo.onUpdate(100, false, new auqr());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrManager.3
 * JD-Core Version:    0.7.0.1
 */