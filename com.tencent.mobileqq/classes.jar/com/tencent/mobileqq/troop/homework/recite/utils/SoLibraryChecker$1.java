package com.tencent.mobileqq.troop.homework.recite.utils;

import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class SoLibraryChecker$1
  implements AsyncBack
{
  SoLibraryChecker$1(SoLibraryChecker paramSoLibraryChecker) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "checkUp loaded json = " + paramString + " code = " + paramInt);
    }
    if (paramInt == 0) {}
    while (SoLibraryChecker.a(SoLibraryChecker.a(this.a), SoLibraryChecker.b(this.a)))
    {
      do
      {
        String str;
        try
        {
          paramString = new JSONObject(paramString).optJSONArray("data").optJSONObject(0);
          str = paramString.optString("url");
          paramInt = paramString.optInt("filesize");
          if ((str != null) && (str.endsWith("patch")))
          {
            FileUtils.a(OfflineEnvHelper.a(SoLibraryChecker.a(this.a)) + SoLibraryChecker.a(this.a));
            SoLibraryChecker.a(this.a);
            return;
          }
        }
        catch (Exception paramString)
        {
          do
          {
            paramString.printStackTrace();
          } while (SoLibraryChecker.a(SoLibraryChecker.a(this.a), SoLibraryChecker.b(this.a)));
          SoLibraryChecker.b(this.a);
          return;
        }
        if ((!TextUtils.isEmpty(str)) && (paramInt != 0))
        {
          SoLibraryChecker.a(this.a, paramString);
          return;
        }
      } while (SoLibraryChecker.a(SoLibraryChecker.a(this.a), SoLibraryChecker.b(this.a)));
      SoLibraryChecker.b(this.a);
      return;
    }
    SoLibraryChecker.b(this.a);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.utils.SoLibraryChecker.1
 * JD-Core Version:    0.7.0.1
 */