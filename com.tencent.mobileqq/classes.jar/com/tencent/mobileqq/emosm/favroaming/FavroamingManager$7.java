package com.tencent.mobileqq.emosm.favroaming;

import anss;
import ayvv;
import aywa;
import bbdj;
import bbwg;
import bbwi;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class FavroamingManager$7
  implements Runnable
{
  public FavroamingManager$7(anss paramanss, String[] paramArrayOfString, aywa paramaywa) {}
  
  public void run()
  {
    if (!bbdj.a(this.jdField_a_of_type_ArrayOfJavaLangString[1]))
    {
      Object localObject = new File(this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      localObject = new bbwg(this.jdField_a_of_type_ArrayOfJavaLangString[0], (File)localObject);
      ((bbwg)localObject).n = true;
      if (bbwi.a((bbwg)localObject, anss.r(this.this$0)) != 0) {
        QLog.e("FavroamingManager", 1, "collectEmoji fail to download thumbFile: " + this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      }
    }
    while (this.this$0.a == null) {
      return;
    }
    this.this$0.a.a(this.jdField_a_of_type_Aywa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.7
 * JD-Core Version:    0.7.0.1
 */