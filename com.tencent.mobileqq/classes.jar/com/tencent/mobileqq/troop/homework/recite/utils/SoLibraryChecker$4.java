package com.tencent.mobileqq.troop.homework.recite.utils;

import android.os.Bundle;
import baas;
import bbwt;
import bbwu;
import bbwz;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class SoLibraryChecker$4
  implements Runnable
{
  public SoLibraryChecker$4(baas parambaas, JSONObject paramJSONObject, String paramString, bbwt parambbwt) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_OrgJsonJSONObject.optString("url");
    Object localObject = new File(this.jdField_a_of_type_JavaLangString);
    Bundle localBundle = new Bundle();
    localObject = new bbwu(str, (File)localObject);
    ((bbwu)localObject).b = 3;
    baas.a(this.this$0).a((bbwu)localObject, this.jdField_a_of_type_Bbwt, localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "start Download url = " + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.utils.SoLibraryChecker.4
 * JD-Core Version:    0.7.0.1
 */