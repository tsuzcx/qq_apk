package com.tencent.mobileqq.mutualmark.info;

import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class MutualMarkConfigIRType$TypeItem
{
  public String a;
  public String b;
  public boolean c = true;
  public long d;
  public long e;
  public String f;
  public MutualMarkConfigIRType g;
  public ArrayList<MutualMarkConfigIRType.SubLevelInfo> h;
  
  public static TypeItem a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    Object localObject = new TypeItem();
    try
    {
      ((TypeItem)localObject).a = paramJSONObject.optString("id");
      ((TypeItem)localObject).d = MutualMarkUtils.b(((TypeItem)localObject).a);
      ((TypeItem)localObject).e = MutualMarkUtils.a(((TypeItem)localObject).a);
      ((TypeItem)localObject).b = paramJSONObject.optString("name");
      ((TypeItem)localObject).f = paramJSONObject.optString("Android_iconPath");
      ((TypeItem)localObject).c = true;
      if (paramJSONObject.has("subLevelInfo"))
      {
        paramJSONObject = paramJSONObject.optJSONArray("subLevelInfo");
        ((TypeItem)localObject).h = new ArrayList();
        int i = 0;
        while (i < paramJSONObject.length())
        {
          MutualMarkConfigIRType.SubLevelInfo localSubLevelInfo = MutualMarkConfigIRType.SubLevelInfo.a(paramJSONObject.getJSONObject(i));
          if (localSubLevelInfo != null) {
            ((TypeItem)localObject).h.add(localSubLevelInfo);
          }
          i += 1;
        }
      }
      return localObject;
    }
    catch (Exception paramJSONObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse error->");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.e("MutualMarkConfigIRType", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append("type=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("|");
    localStringBuilder.append("level=");
    localStringBuilder.append(this.e);
    localStringBuilder.append("|");
    localStringBuilder.append("name=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append("iconPath=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("|");
    localStringBuilder.append("enable=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuilder.append("subLevelInfoArrayList=");
    localStringBuilder.append(this.h);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.info.MutualMarkConfigIRType.TypeItem
 * JD-Core Version:    0.7.0.1
 */