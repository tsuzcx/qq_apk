package com.tencent.mobileqq.emosm.favroaming;

import ansx;
import ayvx;
import aywc;
import bbdx;
import bbwu;
import bbww;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class FavroamingManager$7
  implements Runnable
{
  public FavroamingManager$7(ansx paramansx, String[] paramArrayOfString, aywc paramaywc) {}
  
  public void run()
  {
    if (!bbdx.a(this.jdField_a_of_type_ArrayOfJavaLangString[1]))
    {
      Object localObject = new File(this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      localObject = new bbwu(this.jdField_a_of_type_ArrayOfJavaLangString[0], (File)localObject);
      ((bbwu)localObject).n = true;
      if (bbww.a((bbwu)localObject, ansx.r(this.this$0)) != 0) {
        QLog.e("FavroamingManager", 1, "collectEmoji fail to download thumbFile: " + this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      }
    }
    while (this.this$0.a == null) {
      return;
    }
    this.this$0.a.a(this.jdField_a_of_type_Aywc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.7
 * JD-Core Version:    0.7.0.1
 */