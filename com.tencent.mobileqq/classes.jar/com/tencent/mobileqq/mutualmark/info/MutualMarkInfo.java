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
  public float a;
  public long a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public long c;
  public String c;
  public long d;
  public long e;
  public long f;
  public long g;
  public long h;
  public long i;
  
  public MutualMarkInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
  }
  
  private static MutualMarkInfo a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    MutualMarkInfo localMutualMarkInfo = new MutualMarkInfo();
    localMutualMarkInfo.jdField_a_of_type_Long = paramJSONObject.optLong("type");
    localMutualMarkInfo.jdField_b_of_type_Long = paramJSONObject.optLong("level");
    localMutualMarkInfo.jdField_a_of_type_Float = ((float)paramJSONObject.optDouble("count", 0.0D));
    localMutualMarkInfo.jdField_c_of_type_Long = paramJSONObject.optLong("continue_days");
    localMutualMarkInfo.jdField_d_of_type_Long = paramJSONObject.optLong("last_action_time");
    localMutualMarkInfo.e = paramJSONObject.optLong("last_change_time");
    localMutualMarkInfo.f = paramJSONObject.optLong("icon_status");
    localMutualMarkInfo.jdField_g_of_type_Long = paramJSONObject.optLong("icon_status_end_time");
    localMutualMarkInfo.h = paramJSONObject.optLong("sub_level");
    localMutualMarkInfo.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("hasRemindInContact");
    localMutualMarkInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("icon_static_url");
    localMutualMarkInfo.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon_dynamic_url");
    localMutualMarkInfo.jdField_c_of_type_JavaLangString = paramJSONObject.optString("icon_name");
    localMutualMarkInfo.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("user_close_flag");
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
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkInfo", 1, "parseFrom json_str:" + paramString);
    }
    localConcurrentHashMap = new ConcurrentHashMap();
    try
    {
      paramString = new JSONArray(paramString);
      int j = 0;
      while (j < paramString.length())
      {
        MutualMarkInfo localMutualMarkInfo = a(paramString.getJSONObject(j));
        if (localMutualMarkInfo != null) {
          localConcurrentHashMap.put(Long.valueOf(localMutualMarkInfo.jdField_a_of_type_Long), localMutualMarkInfo);
        }
        j += 1;
      }
      return localConcurrentHashMap;
    }
    catch (JSONException paramString)
    {
      QLog.e("MutualMarkInfo", 1, "toJsonString error:" + paramString.getMessage());
    }
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", this.jdField_a_of_type_Long);
      localJSONObject.put("level", this.jdField_b_of_type_Long);
      localJSONObject.put("count", this.jdField_a_of_type_Float);
      localJSONObject.put("continue_days", this.jdField_c_of_type_Long);
      localJSONObject.put("last_action_time", this.jdField_d_of_type_Long);
      localJSONObject.put("last_change_time", this.e);
      localJSONObject.put("icon_status", this.f);
      localJSONObject.put("icon_status_end_time", this.jdField_g_of_type_Long);
      localJSONObject.put("sub_level", this.h);
      localJSONObject.put("hasRemindInContact", this.jdField_b_of_type_Boolean);
      localJSONObject.put("icon_static_url", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("icon_dynamic_url", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("icon_name", this.jdField_c_of_type_JavaLangString);
      localJSONObject.put("user_close_flag", this.jdField_a_of_type_Boolean);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("MutualMarkInfo", 1, "toJsonForStore error:" + localJSONException.getMessage());
    }
    return localJSONObject;
  }
  
  public boolean a(ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo paramRelationalChainPushInfo, long paramLong)
  {
    boolean bool2 = true;
    if (paramRelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo != null)
    {
      if (((paramLong == 11002L) || (paramLong == 11001L)) && (this.jdField_d_of_type_Long > 0L) && (paramRelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_c_of_type_Long < this.jdField_d_of_type_Long))
      {
        QLog.i("MutualMarkInfo", 1, "ignore mergeFrom now.last_action_time:" + paramRelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_c_of_type_Long + " last_action_time:" + this.jdField_d_of_type_Long);
        return false;
      }
      this.jdField_a_of_type_Long = paramRelationalChainPushInfo.jdField_a_of_type_Int;
      this.jdField_b_of_type_Long = paramRelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_b_of_type_Long;
      if (paramRelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_c_of_type_Long > 0L) {
        this.jdField_d_of_type_Long = paramRelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_c_of_type_Long;
      }
      if (paramRelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_d_of_type_Long > 0L) {
        this.e = paramRelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_d_of_type_Long;
      }
      this.jdField_c_of_type_Long = paramRelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_a_of_type_Int;
      this.f = paramRelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.f;
      if (paramLong == 11002L) {
        this.jdField_g_of_type_Long = paramRelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_g_of_type_Long;
      }
      if (this.f != 2L) {
        this.jdField_g_of_type_Long = 0L;
      }
      this.h = paramRelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.h;
      this.jdField_a_of_type_JavaLangString = paramRelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_c_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = paramRelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_d_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = paramRelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_g_of_type_JavaLangString;
      this.jdField_a_of_type_Boolean = paramRelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_a_of_type_Boolean;
      bool1 = bool2;
      if (this.jdField_a_of_type_Long == 17L)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_Long > 0L)
        {
          bool1 = bool2;
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            QLog.i("MutualMarkInfo", 1, "mergeFrom push info resource invalid: " + this);
          }
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean a(MutualMarkPullInfo paramMutualMarkPullInfo)
  {
    this.jdField_a_of_type_Long = paramMutualMarkPullInfo.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = paramMutualMarkPullInfo.jdField_b_of_type_Long;
    this.jdField_a_of_type_Float = paramMutualMarkPullInfo.jdField_a_of_type_Float;
    this.jdField_c_of_type_Long = paramMutualMarkPullInfo.jdField_c_of_type_Long;
    this.jdField_d_of_type_Long = paramMutualMarkPullInfo.jdField_d_of_type_Long;
    this.f = paramMutualMarkPullInfo.f;
    this.jdField_g_of_type_Long = paramMutualMarkPullInfo.jdField_g_of_type_Long;
    this.h = paramMutualMarkPullInfo.h;
    this.jdField_a_of_type_JavaLangString = paramMutualMarkPullInfo.jdField_c_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramMutualMarkPullInfo.jdField_d_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramMutualMarkPullInfo.jdField_g_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = paramMutualMarkPullInfo.jdField_a_of_type_Boolean;
    if ((this.jdField_a_of_type_Long == 17L) && (this.jdField_b_of_type_Long > 0L) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      QLog.i("MutualMarkInfo", 1, "mergeFrom pull info resource invalid: " + this);
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutualMarkInfo{");
    localStringBuilder.append("type=").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", level=").append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", count=").append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", continue_days=").append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", last_action_time=").append(this.jdField_d_of_type_Long);
    localStringBuilder.append(", last_change_time=").append(this.e);
    localStringBuilder.append(", icon_status=").append(this.f);
    localStringBuilder.append(", icon_status_end_time=").append(this.jdField_g_of_type_Long);
    localStringBuilder.append(", sub_level=").append(this.h);
    localStringBuilder.append(", hasRemindInContact=").append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", remindAnimStartTime=").append(this.i);
    localStringBuilder.append(", icon_static_url='").append(this.jdField_a_of_type_JavaLangString).append("'");
    localStringBuilder.append(", icon_dynamic_url='").append(this.jdField_b_of_type_JavaLangString).append("'");
    localStringBuilder.append(", icon_name='").append(this.jdField_c_of_type_JavaLangString).append("'");
    localStringBuilder.append(", user_close_flag=").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.info.MutualMarkInfo
 * JD-Core Version:    0.7.0.1
 */