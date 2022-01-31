package com.tencent.mobileqq.emosm.favroaming;

import anch;
import axvo;
import axvt;
import bace;
import batm;
import bato;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class FavroamingManager$7
  implements Runnable
{
  public FavroamingManager$7(anch paramanch, String[] paramArrayOfString, axvt paramaxvt) {}
  
  public void run()
  {
    if (!bace.a(this.jdField_a_of_type_ArrayOfJavaLangString[1]))
    {
      Object localObject = new File(this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      localObject = new batm(this.jdField_a_of_type_ArrayOfJavaLangString[0], (File)localObject);
      ((batm)localObject).n = true;
      if (bato.a((batm)localObject, anch.r(this.this$0)) != 0) {
        QLog.e("FavroamingManager", 1, "collectEmoji fail to download thumbFile: " + this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      }
    }
    while (this.this$0.a == null) {
      return;
    }
    this.this$0.a.a(this.jdField_a_of_type_Axvt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.7
 * JD-Core Version:    0.7.0.1
 */