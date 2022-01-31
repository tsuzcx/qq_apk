package com.tencent.mobileqq.magicface.service;

import argl;
import argq;
import arhc;
import arhf;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class MagicfaceActionManager$2
  implements Runnable
{
  public MagicfaceActionManager$2(arhf paramarhf, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      bool1 = this.this$0.c;
      if (bool1) {
        return;
      }
      this.this$0.a(this.a);
      localObject1 = null;
      if (this.b != 0) {
        break label277;
      }
      localObject1 = this.this$0.jdField_a_of_type_Arhc.a("send.xml");
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceActionManager", 2, "func doAction. step 1");
      }
      if (localObject1 == null) {
        break label248;
      }
      this.this$0.jdField_a_of_type_Argn = this.this$0.jdField_a_of_type_Argq.a((String)localObject1);
      if (this.b == 1) {
        this.this$0.e();
      }
      this.this$0.a(this.this$0.jdField_a_of_type_Argn);
      this.this$0.jdField_a_of_type_JavaUtilList = this.this$0.jdField_a_of_type_Argq.a((String)localObject1);
      this.this$0.d();
      localObject1 = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool1;
        Object localObject1;
        argl localargl;
        boolean bool2;
        label248:
        if (QLog.isColorLevel()) {
          QLog.d("MagicfaceActionManager", 2, "doaction=Exception=" + localException.toString());
        }
        label277:
        label301:
        return;
        label383:
        if (bool1)
        {
          bool1 = this.this$0.b;
          if (!bool1) {}
        }
      }
    }
    finally
    {
      if (!QLog.isColorLevel()) {
        break label417;
      }
      QLog.d("MagicfaceActionManager", 2, "func doAction, 【magic end】");
      label417:
      this.this$0.b(this.this$0.jdField_a_of_type_Argn);
    }
    if (((Iterator)localObject1).hasNext())
    {
      localargl = (argl)((Iterator)localObject1).next();
      this.this$0.jdField_a_of_type_Argl = localargl;
      localargl.jdField_a_of_type_Arhn = this.this$0.jdField_a_of_type_Arhn;
      localargl.jdField_a_of_type_Argn = this.this$0.jdField_a_of_type_Argn;
      bool1 = localargl.a();
      bool2 = this.this$0.b;
      if (!bool2) {
        break label301;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceActionManager", 2, "func doAction, 【magic end】");
      }
      this.this$0.b(this.this$0.jdField_a_of_type_Argn);
      return;
      if (this.b != 1) {
        break;
      }
      localObject1 = this.this$0.jdField_a_of_type_Arhc.a("receive.xml");
      break;
      if (!localargl.d) {
        break label383;
      }
      this.this$0.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.service.MagicfaceActionManager.2
 * JD-Core Version:    0.7.0.1
 */