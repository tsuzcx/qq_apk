package com.tencent.mobileqq.hiboom;

import auzd;
import auze;
import com.Vas.ColorFont.FreeTypeLib;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import l;

class HiBoomFontDrawer$1$1
  implements Runnable
{
  HiBoomFontDrawer$1$1(HiBoomFontDrawer.1 param1) {}
  
  public void run()
  {
    if (!l.a().c.get())
    {
      l.a().a().a();
      l.a().c.set(true);
    }
    if (this.a.this$0.c == -1)
    {
      String str = this.a.this$0.jdField_a_of_type_Auzd.a() + this.a.this$0.jdField_b_of_type_Int + File.separator + this.a.this$0.jdField_b_of_type_Int + ".fz4";
      this.a.this$0.c = l.a().a(this.a.this$0.jdField_b_of_type_Int, str);
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.FontDrawer", 2, "initColorFont: fontid=" + this.a.this$0.jdField_b_of_type_Int + " result=" + this.a.this$0.c);
      }
      this.a.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.a.this$0.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (this.a.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        auze.a(this.a.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFontDrawer.1.1
 * JD-Core Version:    0.7.0.1
 */