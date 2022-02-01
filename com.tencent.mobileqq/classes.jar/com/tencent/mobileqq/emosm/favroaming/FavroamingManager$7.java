package com.tencent.mobileqq.emosm.favroaming;

import ashd;
import beyb;
import beyg;
import bhmi;
import bihu;
import bihw;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class FavroamingManager$7
  implements Runnable
{
  public FavroamingManager$7(ashd paramashd, String[] paramArrayOfString, beyg parambeyg) {}
  
  public void run()
  {
    if (!bhmi.a(this.jdField_a_of_type_ArrayOfJavaLangString[1]))
    {
      Object localObject = new File(this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      localObject = new bihu(this.jdField_a_of_type_ArrayOfJavaLangString[0], (File)localObject);
      ((bihu)localObject).n = true;
      if (bihw.a((bihu)localObject, ashd.o(this.this$0)) != 0) {
        QLog.e("FavroamingManager", 1, "collectEmoji fail to download thumbFile: " + this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      }
    }
    while (this.this$0.a == null) {
      return;
    }
    this.this$0.a.a(this.jdField_a_of_type_Beyg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.7
 * JD-Core Version:    0.7.0.1
 */