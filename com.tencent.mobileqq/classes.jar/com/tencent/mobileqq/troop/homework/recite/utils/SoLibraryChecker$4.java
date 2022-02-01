package com.tencent.mobileqq.troop.homework.recite.utils;

import android.os.Bundle;
import bfdy;
import bhhe;
import bhhf;
import bhhk;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class SoLibraryChecker$4
  implements Runnable
{
  public SoLibraryChecker$4(bfdy parambfdy, JSONObject paramJSONObject, String paramString, bhhe parambhhe) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_OrgJsonJSONObject.optString("url");
    Object localObject = new File(this.jdField_a_of_type_JavaLangString);
    Bundle localBundle = new Bundle();
    localObject = new bhhf(str, (File)localObject);
    ((bhhf)localObject).b = 3;
    bfdy.a(this.this$0).a((bhhf)localObject, this.jdField_a_of_type_Bhhe, localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "start Download url = " + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.utils.SoLibraryChecker.4
 * JD-Core Version:    0.7.0.1
 */