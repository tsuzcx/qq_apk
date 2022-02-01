package com.tencent.mobileqq.dating;

import android.text.TextUtils;
import appoint.define.appoint_define.StrangerInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DatingStranger
{
  public long a = 0L;
  public String b;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public String f = "";
  public int g = 0;
  public int h = 0;
  public int i = 0;
  public String j = "";
  
  public static DatingStranger a(appoint_define.StrangerInfo paramStrangerInfo)
  {
    if ((paramStrangerInfo != null) && (paramStrangerInfo.uint64_tinyid.get() != 0L))
    {
      DatingStranger localDatingStranger = new DatingStranger();
      if (paramStrangerInfo.uint64_tinyid.has()) {
        localDatingStranger.a = paramStrangerInfo.uint64_tinyid.get();
      }
      if (paramStrangerInfo.uint32_age.has()) {
        localDatingStranger.c = paramStrangerInfo.uint32_age.get();
      }
      if (paramStrangerInfo.uint32_gender.has()) {
        localDatingStranger.d = paramStrangerInfo.uint32_gender.get();
      }
      if (paramStrangerInfo.bytes_nickname.has()) {
        localDatingStranger.b = paramStrangerInfo.bytes_nickname.get().toStringUtf8();
      }
      if (paramStrangerInfo.uint32_dating.has()) {
        localDatingStranger.e = paramStrangerInfo.uint32_dating.get();
      }
      if (paramStrangerInfo.uint32_list_idx.has()) {
        localDatingStranger.i = paramStrangerInfo.uint32_list_idx.get();
      }
      if (paramStrangerInfo.str_constellation.has()) {
        localDatingStranger.f = paramStrangerInfo.str_constellation.get();
      }
      if (paramStrangerInfo.uint32_profession.has()) {
        localDatingStranger.g = paramStrangerInfo.uint32_profession.get();
      }
      if (paramStrangerInfo.uint32_marriage.has()) {
        localDatingStranger.h = paramStrangerInfo.uint32_marriage.get();
      }
      if (paramStrangerInfo.str_vipinfo.has()) {
        localDatingStranger.j = paramStrangerInfo.str_vipinfo.get();
      }
      return localDatingStranger;
    }
    return null;
  }
  
  public static DatingStranger a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    DatingStranger localDatingStranger = new DatingStranger();
    try
    {
      localDatingStranger.a = paramJSONObject.getLong("open_id");
      localDatingStranger.b = paramJSONObject.getString("nickname");
      localDatingStranger.c = paramJSONObject.getInt("age");
      localDatingStranger.d = paramJSONObject.getInt("gender");
      localDatingStranger.e = paramJSONObject.getInt("state");
      try
      {
        localDatingStranger.f = paramJSONObject.getString("constellation");
        localDatingStranger.g = paramJSONObject.getInt("profession");
        localDatingStranger.h = paramJSONObject.getInt("emotion");
        localDatingStranger.i = paramJSONObject.getInt("listIdx");
        localDatingStranger.j = paramJSONObject.getString("vip");
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      return localDatingStranger;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public static String a(List<DatingStranger> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      JSONArray localJSONArray = new JSONArray();
      int k = 0;
      paramList = paramList.iterator();
      int m;
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        JSONObject localJSONObject = a((DatingStranger)paramList.next());
        m = k;
        if (localJSONObject != null)
        {
          localJSONArray.put(localJSONObject);
          m = k + 1;
        }
        k = m;
      } while (m < 20);
      return localJSONArray.toString();
    }
    return "";
  }
  
  public static JSONObject a(DatingStranger paramDatingStranger)
  {
    if (paramDatingStranger == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("open_id", paramDatingStranger.a);
      localJSONObject.put("nickname", paramDatingStranger.b);
      localJSONObject.put("age", paramDatingStranger.c);
      localJSONObject.put("gender", paramDatingStranger.d);
      localJSONObject.put("state", paramDatingStranger.e);
      localJSONObject.put("constellation", paramDatingStranger.f);
      localJSONObject.put("profession", paramDatingStranger.g);
      localJSONObject.put("emotion", paramDatingStranger.h);
      localJSONObject.put("listIdx", paramDatingStranger.i);
      localJSONObject.put("vip", paramDatingStranger.j);
      return localJSONObject;
    }
    catch (JSONException paramDatingStranger)
    {
      paramDatingStranger.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a(List<DatingStranger> paramList, String paramString)
  {
    if (paramList != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        paramString = new JSONArray(paramString);
        int m = paramString.length();
        int k = 0;
        while (k < m)
        {
          DatingStranger localDatingStranger = a(paramString.getJSONObject(k));
          if (localDatingStranger != null) {
            paramList.add(localDatingStranger);
          }
          k += 1;
        }
        return;
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (paramObject == null) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    if (paramObject.getClass() != getClass()) {
      return false;
    }
    if (((DatingStranger)paramObject).a == this.a) {
      bool = true;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return Long.valueOf(this.a).hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",");
    localStringBuilder.append(this.h);
    localStringBuilder.append(",");
    localStringBuilder.append(this.i);
    localStringBuilder.append(",");
    localStringBuilder.append(this.j);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingStranger
 * JD-Core Version:    0.7.0.1
 */