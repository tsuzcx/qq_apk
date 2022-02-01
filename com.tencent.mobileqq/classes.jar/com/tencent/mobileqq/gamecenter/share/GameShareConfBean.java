package com.tencent.mobileqq.gamecenter.share;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameShareConfBean
{
  public static GameShareConfBean a = new GameShareConfBean();
  private Set<String> b = new HashSet();
  
  static GameShareConfBean a(String paramString)
  {
    localGameShareConfBean = new GameShareConfBean();
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("appid_arr");
        int i = 0;
        while (i < paramString.length())
        {
          String str = paramString.optString(i);
          if (!TextUtils.isEmpty(str)) {
            localGameShareConfBean.b.add(str);
          }
          i += 1;
        }
        return localGameShareConfBean;
      }
      catch (Throwable paramString)
      {
        QLog.e("GameShare.confBean", 1, paramString, new Object[0]);
      }
    }
  }
  
  public boolean b(String paramString)
  {
    return this.b.contains(paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NGConfBean{appidArr=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.share.GameShareConfBean
 * JD-Core Version:    0.7.0.1
 */