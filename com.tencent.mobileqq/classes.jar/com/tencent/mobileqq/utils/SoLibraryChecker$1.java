package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class SoLibraryChecker$1
  implements AsyncBack
{
  SoLibraryChecker$1(SoLibraryChecker paramSoLibraryChecker) {}
  
  public void loaded(String paramString, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkUp loaded json = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" code = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SoLibraryLoader", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 0) {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("data").optJSONObject(0);
        localObject = paramString.optString("url");
        paramInt = paramString.optInt("filesize");
        if ((localObject != null) && (((String)localObject).endsWith("patch")))
        {
          paramString = new StringBuilder();
          paramString.append(OfflineEnvHelper.a(SoLibraryChecker.a(this.a)));
          paramString.append(SoLibraryChecker.a(this.a));
          FileUtils.deleteDirectory(paramString.toString());
          SoLibraryChecker.a(this.a);
          return;
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramInt != 0))
        {
          SoLibraryChecker.a(this.a, paramString);
          return;
        }
        if (SoLibraryChecker.a(SoLibraryChecker.a(this.a), SoLibraryChecker.b(this.a))) {
          return;
        }
        SoLibraryChecker.b(this.a);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (!SoLibraryChecker.a(SoLibraryChecker.a(this.a), SoLibraryChecker.b(this.a))) {
          SoLibraryChecker.b(this.a);
        }
        return;
      }
    } else if (!SoLibraryChecker.a(SoLibraryChecker.a(this.a), SoLibraryChecker.b(this.a))) {
      SoLibraryChecker.b(this.a);
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SoLibraryChecker.1
 * JD-Core Version:    0.7.0.1
 */