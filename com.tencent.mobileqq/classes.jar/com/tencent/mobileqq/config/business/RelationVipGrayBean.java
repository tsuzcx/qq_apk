package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class RelationVipGrayBean
{
  public String a = "";
  public int b = 0;
  public HashMap<String, String> c = new HashMap();
  public String d = "";
  
  public static RelationVipGrayBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      RelationVipGrayBean localRelationVipGrayBean = new RelationVipGrayBean();
      localRelationVipGrayBean.a = paramString;
      paramString = new JSONObject(paramString);
      localRelationVipGrayBean.b = paramString.optInt("isShowEntry");
      localRelationVipGrayBean.d = paramString.optString("iconUrl");
      if (!TextUtils.isEmpty(localRelationVipGrayBean.d)) {
        localRelationVipGrayBean.d = localRelationVipGrayBean.d.trim();
      }
      paramString = paramString.optJSONObject("grayTips");
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localRelationVipGrayBean.c.put(str, paramString.optString(str));
      }
      paramString = new StringBuilder();
      paramString.append("confBean = ");
      paramString.append(localRelationVipGrayBean.toString());
      QLog.d("ConfBean", 0, paramString.toString());
      return localRelationVipGrayBean;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ConfBean", 1, "parse e:", paramString);
      }
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("configContent:");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.RelationVipGrayBean
 * JD-Core Version:    0.7.0.1
 */