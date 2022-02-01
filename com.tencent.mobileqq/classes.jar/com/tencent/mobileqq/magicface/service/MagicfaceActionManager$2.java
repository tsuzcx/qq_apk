package com.tencent.mobileqq.magicface.service;

import awxz;
import awye;
import awyq;
import awyt;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class MagicfaceActionManager$2
  implements Runnable
{
  public MagicfaceActionManager$2(awyt paramawyt, int paramInt1, int paramInt2) {}
  
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
      localObject1 = this.this$0.jdField_a_of_type_Awyq.a("send.xml");
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceActionManager", 2, "func doAction. step 1");
      }
      if (localObject1 == null) {
        break label248;
      }
      this.this$0.jdField_a_of_type_Awyb = this.this$0.jdField_a_of_type_Awye.a((String)localObject1);
      if (this.b == 1) {
        this.this$0.e();
      }
      this.this$0.a(this.this$0.jdField_a_of_type_Awyb);
      this.this$0.jdField_a_of_type_JavaUtilList = this.this$0.jdField_a_of_type_Awye.a((String)localObject1);
      this.this$0.d();
      localObject1 = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool1;
        Object localObject1;
        awxz localawxz;
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
      this.this$0.b(this.this$0.jdField_a_of_type_Awyb);
    }
    if (((Iterator)localObject1).hasNext())
    {
      localawxz = (awxz)((Iterator)localObject1).next();
      this.this$0.jdField_a_of_type_Awxz = localawxz;
      localawxz.jdField_a_of_type_Awzb = this.this$0.jdField_a_of_type_Awzb;
      localawxz.jdField_a_of_type_Awyb = this.this$0.jdField_a_of_type_Awyb;
      bool1 = localawxz.a();
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
      this.this$0.b(this.this$0.jdField_a_of_type_Awyb);
      return;
      if (this.b != 1) {
        break;
      }
      localObject1 = this.this$0.jdField_a_of_type_Awyq.a("receive.xml");
      break;
      if (!localawxz.d) {
        break label383;
      }
      this.this$0.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.service.MagicfaceActionManager.2
 * JD-Core Version:    0.7.0.1
 */