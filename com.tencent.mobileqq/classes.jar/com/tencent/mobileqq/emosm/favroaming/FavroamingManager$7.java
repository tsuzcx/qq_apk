package com.tencent.mobileqq.emosm.favroaming;

import arrp;
import bdzi;
import bdzn;
import bgmg;
import bhhf;
import bhhh;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class FavroamingManager$7
  implements Runnable
{
  public FavroamingManager$7(arrp paramarrp, String[] paramArrayOfString, bdzn parambdzn) {}
  
  public void run()
  {
    if (!bgmg.a(this.jdField_a_of_type_ArrayOfJavaLangString[1]))
    {
      Object localObject = new File(this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      localObject = new bhhf(this.jdField_a_of_type_ArrayOfJavaLangString[0], (File)localObject);
      ((bhhf)localObject).n = true;
      if (bhhh.a((bhhf)localObject, arrp.o(this.this$0)) != 0) {
        QLog.e("FavroamingManager", 1, "collectEmoji fail to download thumbFile: " + this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      }
    }
    while (this.this$0.a == null) {
      return;
    }
    this.this$0.a.a(this.jdField_a_of_type_Bdzn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.7
 * JD-Core Version:    0.7.0.1
 */