package com.tencent.mobileqq.hiboom;

import android.graphics.Typeface;
import android.text.TextUtils;
import aqxb;
import aqxc;
import aqxd;
import aqxe;
import bbdx;
import com.etrump.mixlayout.ETEngine;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import g;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class HiBoomFontDrawer$1
  implements Runnable
{
  public HiBoomFontDrawer$1(aqxd paramaqxd, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Int = this.this$0.a(this.a);
    Object localObject;
    boolean bool1;
    if ((this.this$0.jdField_a_of_type_Int == 1) || (this.this$0.jdField_a_of_type_Int == 3))
    {
      if (!aqxb.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        aqxb.a().b();
      }
      if (aqxb.a().jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("HiBoomFont.FontDrawer", 2, "initHiBoomInfo HYEngine Ready");
        }
        localObject = ".hy3";
        if (this.this$0.jdField_a_of_type_Int == 1) {
          localObject = ".hy";
        }
        localObject = this.this$0.jdField_a_of_type_Aqxc.a() + this.this$0.jdField_b_of_type_Int + File.separator + this.this$0.jdField_b_of_type_Int + (String)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("HiBoomFont.FontDrawer", 2, "initHiboom: path= " + (String)localObject + " fontId=" + this.this$0.jdField_b_of_type_Int);
        }
        if (!new File((String)localObject).exists()) {
          break label371;
        }
        boolean bool2 = aqxb.a().jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_isFontLoaded(this.this$0.jdField_b_of_type_Int);
        boolean bool3 = aqxb.a().jdField_b_of_type_ComEtrumpMixlayoutETEngine.native_isFontLoaded(this.this$0.jdField_b_of_type_Int);
        bool1 = bool2;
        if (!bool2) {
          bool1 = aqxb.a().jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont((String)localObject, this.this$0.jdField_b_of_type_Int, false);
        }
        bool2 = bool3;
        if (!bool3) {
          bool2 = aqxb.a().jdField_b_of_type_ComEtrumpMixlayoutETEngine.native_loadFont((String)localObject, this.this$0.jdField_b_of_type_Int, false);
        }
        localObject = this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
        if ((!bool1) || (!bool2)) {
          break label366;
        }
        bool1 = true;
        ((AtomicBoolean)localObject).set(bool1);
      }
    }
    label686:
    for (;;)
    {
      if (this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        aqxd.a(this.this$0);
      }
      this.this$0.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
      label366:
      bool1 = false;
      break;
      label371:
      if (this.a)
      {
        this.this$0.c.set(false);
        this.this$0.jdField_a_of_type_Aqxc.a(this.this$0.jdField_b_of_type_Int);
        continue;
        if (this.this$0.jdField_a_of_type_Int == 2)
        {
          localObject = new File(this.this$0.jdField_a_of_type_Aqxc.a() + this.this$0.jdField_b_of_type_Int + File.separator + this.this$0.jdField_b_of_type_Int + ".hb");
          String str = bbdx.a((File)localObject, -1);
          if (!TextUtils.isEmpty(str))
          {
            this.this$0.jdField_a_of_type_Aqxe = aqxe.a(str);
            if (this.this$0.jdField_a_of_type_AndroidGraphicsTypeface == null)
            {
              localObject = this.this$0.jdField_a_of_type_Aqxc.a() + this.this$0.jdField_b_of_type_Int + File.separator + this.this$0.jdField_b_of_type_Int + ".fz";
              if (!bbdx.a((String)localObject)) {
                break label686;
              }
            }
            for (;;)
            {
              try
              {
                this.this$0.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile((String)localObject);
                this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
              }
              catch (Exception localException)
              {
                QLog.e("HiBoomFont.FontDrawer", 2, "file error:" + (String)localObject, localException);
                bbdx.a(this.this$0.jdField_a_of_type_Aqxc.a() + this.this$0.jdField_b_of_type_Int);
                return;
              }
              QLog.e("HiBoomFont.FontDrawer", 2, "file is not exist, path=" + (String)localObject);
            }
          }
          if ((!((File)localObject).exists()) && (this.a))
          {
            this.this$0.c.set(false);
            this.this$0.jdField_a_of_type_Aqxc.a(this.this$0.jdField_b_of_type_Int);
          }
        }
        else if (this.this$0.jdField_a_of_type_Int == 4)
        {
          if (!g.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            aqxb.a().c();
            QLog.d("HiBoomFont.FontDrawer", 2, "run: initFZEngine");
          }
          if (g.a().jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            if (QLog.isColorLevel()) {
              QLog.d("HiBoomFont.FontDrawer", 2, "initHiBoomInfo: initFont");
            }
            ThreadManager.getUIHandler().post(new HiBoomFontDrawer.1.1(this));
          }
          else
          {
            this.this$0.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFontDrawer.1
 * JD-Core Version:    0.7.0.1
 */