package com.tencent.mobileqq.mutualmark.info;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo;
import com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo.MutualMarkPushInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MutualMarkInfo
{
  public long a;
  public long b;
  public float c;
  public long d;
  public long e;
  public long f;
  public long g;
  public long h;
  public long i;
  public String j = "";
  public String k = "";
  public String l = "";
  public boolean m = false;
  public boolean n;
  public long o;
  
  private static MutualMarkInfo a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    MutualMarkInfo localMutualMarkInfo = new MutualMarkInfo();
    localMutualMarkInfo.a = paramJSONObject.optLong("type");
    localMutualMarkInfo.b = paramJSONObject.optLong("level");
    localMutualMarkInfo.c = ((float)paramJSONObject.optDouble("count", 0.0D));
    localMutualMarkInfo.d = paramJSONObject.optLong("continue_days");
    localMutualMarkInfo.e = paramJSONObject.optLong("last_action_time");
    localMutualMarkInfo.f = paramJSONObject.optLong("last_change_time");
    localMutualMarkInfo.g = paramJSONObject.optLong("icon_status");
    localMutualMarkInfo.h = paramJSONObject.optLong("icon_status_end_time");
    localMutualMarkInfo.i = paramJSONObject.optLong("sub_level");
    localMutualMarkInfo.n = paramJSONObject.optBoolean("hasRemindInContact");
    localMutualMarkInfo.j = paramJSONObject.optString("icon_static_url");
    localMutualMarkInfo.k = paramJSONObject.optString("icon_dynamic_url");
    localMutualMarkInfo.l = paramJSONObject.optString("icon_name");
    localMutualMarkInfo.m = paramJSONObject.optBoolean("user_close_flag");
    return localMutualMarkInfo;
  }
  
  public static String a(ConcurrentHashMap<Long, MutualMarkInfo> paramConcurrentHashMap)
  {
    JSONArray localJSONArray = new JSONArray();
    paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramConcurrentHashMap.next();
      if (localEntry.getValue() != null) {
        localJSONArray.put(((MutualMarkInfo)localEntry.getValue()).a());
      }
    }
    if (localJSONArray.length() > 0) {
      return localJSONArray.toString();
    }
    return "";
  }
  
  public static ConcurrentHashMap<Long, MutualMarkInfo> a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parseFrom json_str:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("MutualMarkInfo", 1, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new ConcurrentHashMap();
    try
    {
      paramString = new JSONArray(paramString);
      int i1 = 0;
      Object localObject2;
      while (i1 < paramString.length())
      {
        localObject2 = a(paramString.getJSONObject(i1));
        if (localObject2 != null) {
          ((ConcurrentHashMap)localObject1).put(Long.valueOf(((MutualMarkInfo)localObject2).a), localObject2);
        }
        i1 += 1;
      }
      return localObject1;
    }
    catch (JSONException paramString)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("toJsonString error:");
      ((StringBuilder)localObject2).append(paramString.getMessage());
      QLog.e("MutualMarkInfo", 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", this.a);
      localJSONObject.put("level", this.b);
      localJSONObject.put("count", this.c);
      localJSONObject.put("continue_days", this.d);
      localJSONObject.put("last_action_time", this.e);
      localJSONObject.put("last_change_time", this.f);
      localJSONObject.put("icon_status", this.g);
      localJSONObject.put("icon_status_end_time", this.h);
      localJSONObject.put("sub_level", this.i);
      localJSONObject.put("hasRemindInContact", this.n);
      localJSONObject.put("icon_static_url", this.j);
      localJSONObject.put("icon_dynamic_url", this.k);
      localJSONObject.put("icon_name", this.l);
      localJSONObject.put("user_close_flag", this.m);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("toJsonForStore error:");
      localStringBuilder.append(localJSONException.getMessage());
      QLog.e("MutualMarkInfo", 1, localStringBuilder.toString());
    }
    return localJSONObject;
  }
  
  public boolean a(ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo paramRelationalChainPushInfo, long paramLong)
  {
    Object localObject = paramRelationalChainPushInfo.b;
    boolean bool = false;
    if (localObject != null)
    {
      if (((paramLong == 11002L) || (paramLong == 11001L)) && (this.e > 0L) && (paramRelationalChainPushInfo.b.c < this.e))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ignore mergeFrom now.last_action_time:");
        ((StringBuilder)localObject).append(paramRelationalChainPushInfo.b.c);
        ((StringBuilder)localObject).append(" last_action_time:");
        ((StringBuilder)localObject).append(this.e);
        QLog.i("MutualMarkInfo", 1, ((StringBuilder)localObject).toString());
        return false;
      }
      this.a = paramRelationalChainPushInfo.a;
      this.b = paramRelationalChainPushInfo.b.b;
      if (paramRelationalChainPushInfo.b.c > 0L) {
        this.e = paramRelationalChainPushInfo.b.c;
      }
      if (paramRelationalChainPushInfo.b.d > 0L) {
        this.f = paramRelationalChainPushInfo.b.d;
      }
      this.d = paramRelationalChainPushInfo.b.e;
      this.g = paramRelationalChainPushInfo.b.i;
      if (paramLong == 11002L) {
        this.h = paramRelationalChainPushInfo.b.j;
      }
      if (this.g != 2L) {
        this.h = 0L;
      }
      this.i = paramRelationalChainPushInfo.b.k;
      this.j = paramRelationalChainPushInfo.b.m;
      this.k = paramRelationalChainPushInfo.b.n;
      this.l = paramRelationalChainPushInfo.b.q;
      this.m = paramRelationalChainPushInfo.b.r;
      if ((this.a == 17L) && (this.b > 0L) && (TextUtils.isEmpty(this.j)))
      {
        paramRelationalChainPushInfo = new StringBuilder();
        paramRelationalChainPushInfo.append("mergeFrom push info resource invalid: ");
        paramRelationalChainPushInfo.append(this);
        QLog.i("MutualMarkInfo", 1, paramRelationalChainPushInfo.toString());
      }
      bool = true;
    }
    return bool;
  }
  
  public boolean a(MutualMarkPullInfo paramMutualMarkPullInfo)
  {
    this.a = paramMutualMarkPullInfo.a;
    this.b = paramMutualMarkPullInfo.b;
    this.c = paramMutualMarkPullInfo.c;
    this.d = paramMutualMarkPullInfo.d;
    this.e = paramMutualMarkPullInfo.e;
    this.g = paramMutualMarkPullInfo.g;
    this.h = paramMutualMarkPullInfo.h;
    this.i = paramMutualMarkPullInfo.i;
    this.j = paramMutualMarkPullInfo.l;
    this.k = paramMutualMarkPullInfo.m;
    this.l = paramMutualMarkPullInfo.p;
    this.m = paramMutualMarkPullInfo.q;
    if ((this.a == 17L) && (this.b > 0L) && (TextUtils.isEmpty(this.j)))
    {
      paramMutualMarkPullInfo = new StringBuilder();
      paramMutualMarkPullInfo.append("mergeFrom pull info resource invalid: ");
      paramMutualMarkPullInfo.append(this);
      QLog.i("MutualMarkInfo", 1, paramMutualMarkPullInfo.toString());
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutualMarkInfo{");
    localStringBuilder.append("type=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", level=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", count=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", continue_days=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", last_action_time=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", last_change_time=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", icon_status=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", icon_status_end_time=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", sub_level=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", hasRemindInContact=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", remindAnimStartTime=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", icon_static_url='");
    localStringBuilder.append(this.j);
    localStringBuilder.append("'");
    localStringBuilder.append(", icon_dynamic_url='");
    localStringBuilder.append(this.k);
    localStringBuilder.append("'");
    localStringBuilder.append(", icon_name='");
    localStringBuilder.append(this.l);
    localStringBuilder.append("'");
    localStringBuilder.append(", user_close_flag=");
    localStringBuilder.append(this.m);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.info.MutualMarkInfo
 * JD-Core Version:    0.7.0.1
 */