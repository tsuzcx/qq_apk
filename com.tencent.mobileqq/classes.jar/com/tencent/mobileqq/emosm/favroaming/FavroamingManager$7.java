package com.tencent.mobileqq.emosm.favroaming;

import apoo;
import bayf;
import bayk;
import bdhb;
import beae;
import beag;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class FavroamingManager$7
  implements Runnable
{
  public FavroamingManager$7(apoo paramapoo, String[] paramArrayOfString, bayk parambayk) {}
  
  public void run()
  {
    if (!bdhb.a(this.jdField_a_of_type_ArrayOfJavaLangString[1]))
    {
      Object localObject = new File(this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      localObject = new beae(this.jdField_a_of_type_ArrayOfJavaLangString[0], (File)localObject);
      ((beae)localObject).n = true;
      if (beag.a((beae)localObject, apoo.r(this.this$0)) != 0) {
        QLog.e("FavroamingManager", 1, "collectEmoji fail to download thumbFile: " + this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      }
    }
    while (this.this$0.a == null) {
      return;
    }
    this.this$0.a.a(this.jdField_a_of_type_Bayk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.7
 * JD-Core Version:    0.7.0.1
 */