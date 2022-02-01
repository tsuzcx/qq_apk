package com.tencent.mobileqq.troop.homework.recite.utils;

import android.os.Bundle;
import bfud;
import bhyn;
import bhyo;
import bhyt;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class SoLibraryChecker$4
  implements Runnable
{
  public SoLibraryChecker$4(bfud parambfud, JSONObject paramJSONObject, String paramString, bhyn parambhyn) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_OrgJsonJSONObject.optString("url");
    Object localObject = new File(this.jdField_a_of_type_JavaLangString);
    Bundle localBundle = new Bundle();
    localObject = new bhyo(str, (File)localObject);
    ((bhyo)localObject).b = 3;
    bfud.a(this.this$0).a((bhyo)localObject, this.jdField_a_of_type_Bhyn, localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "start Download url = " + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.utils.SoLibraryChecker.4
 * JD-Core Version:    0.7.0.1
 */