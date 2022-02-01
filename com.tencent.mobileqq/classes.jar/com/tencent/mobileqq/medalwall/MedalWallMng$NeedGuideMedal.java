package com.tencent.mobileqq.medalwall;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class MedalWallMng$NeedGuideMedal
{
  public MedalInfo a;
  public String b = null;
  public String c = null;
  public String d = null;
  public boolean e = false;
  public int f = 0;
  public int g = 0;
  public boolean h = false;
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.b)) {
      try
      {
        JSONArray localJSONArray = new JSONArray(this.a.strResJson);
        JSONObject localJSONObject = null;
        i = localJSONArray.length();
        if ((this.a.iLevelCount > 1) && (i > this.a.iLevel)) {
          localJSONObject = localJSONArray.getJSONObject(this.a.iLevel);
        } else if (i > 1) {
          localJSONObject = localJSONArray.getJSONObject(1);
        }
        if ((localJSONObject != null) && (localJSONObject.has("owned3d"))) {
          this.b = MedalWallMng.a(localJSONObject.getString("owned3d"));
        }
        if ((localJSONObject != null) && (localJSONObject.has("share"))) {
          this.d = MedalWallMng.a(localJSONObject.getString("share"));
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("MedalWallMng", 2, "parse res json fail", localException);
        }
      }
    }
    if ((!TextUtils.isEmpty(this.b)) && (TextUtils.isEmpty(this.c)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(MedalWallMng.b);
      localStringBuilder.append(MD5Utils.toMD5(this.b));
      this.c = localStringBuilder.toString();
    }
    int i = this.f;
    if (i == 2) {
      this.e = true;
    } else if (i == 1) {
      this.e = true;
    } else if (FileUtils.fileExistsAndNotEmpty(this.c)) {
      this.e = true;
    }
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalWallMng.NeedGuideMedal
 * JD-Core Version:    0.7.0.1
 */