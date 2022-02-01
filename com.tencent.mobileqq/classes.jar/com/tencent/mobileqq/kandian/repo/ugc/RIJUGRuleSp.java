package com.tencent.mobileqq.kandian.repo.ugc;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.ugc.srt.BackOffGroup;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqChannelPara;

public class RIJUGRuleSp
{
  public static String a = "readinjoy_sp_clcik_times_one_day";
  public static String b = "readinjoy_sp_update_one_day";
  public static String c = "readinjoy_sp_remain_times_one_day";
  
  public static long a(int paramInt)
  {
    if (paramInt != 0) {}
    for (;;)
    {
      try
      {
        if (DailyModeConfigHandler.b(paramInt))
        {
          Object localObject = TimeSliceHelper.b(String.valueOf(paramInt));
          if (localObject == null) {
            break label279;
          }
          l1 = ((TimeSliceHelper)localObject).a(false);
          localObject = (String)RIJSPUtils.b(c, "");
          boolean bool = TextUtils.isEmpty((CharSequence)localObject);
          if (bool)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("getNowRemainTime time is");
            ((StringBuilder)localObject).append(l1 / 1000L);
            QLog.d("RIJUGRuleSp", 1, ((StringBuilder)localObject).toString());
            return l1 / 1000L;
          }
          localObject = new JSONObject((String)localObject);
          String str = ((JSONObject)localObject).optString("time", "");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("remainTime");
          localStringBuilder.append(paramInt);
          long l2 = ((JSONObject)localObject).optLong(localStringBuilder.toString(), 0L);
          if (!str.equals(TimeSliceHelper.a()))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("getNowRemainTime time is");
            ((StringBuilder)localObject).append(l1 / 1000L);
            QLog.d("RIJUGRuleSp", 1, ((StringBuilder)localObject).toString());
            return l1 / 1000L;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getNowRemainTime time is");
          l1 += l2;
          ((StringBuilder)localObject).append(l1 / 1000L);
          QLog.d("RIJUGRuleSp", 1, ((StringBuilder)localObject).toString());
          l1 /= 1000L;
          return l1;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return 0L;
      label279:
      long l1 = 0L;
    }
  }
  
  public static void a(BackOffGroup paramBackOffGroup, String paramString1, String paramString2)
  {
    try
    {
      Object localObject1 = (String)RIJSPUtils.b(a, "");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("start saveChannelClickToSP :");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("RIJUGRuleSp", 1, ((StringBuilder)localObject2).toString());
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = new JSONObject();
      } else {
        localObject1 = new JSONObject((String)localObject1);
      }
      localObject2 = ((JSONObject)localObject1).optString("time", "");
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("clickTimes");
      ((StringBuilder)localObject3).append(paramString2);
      ((StringBuilder)localObject3).append(paramString1);
      int j = ((JSONObject)localObject1).optInt(((StringBuilder)localObject3).toString(), 0);
      localObject3 = TimeSliceHelper.a();
      int i = j;
      if (j == 0) {
        i = paramBackOffGroup.d;
      }
      if (!((String)localObject2).equals(localObject3))
      {
        localObject1 = new JSONObject();
        i = 0;
      }
      i += 1;
      paramBackOffGroup.d = i;
      ((JSONObject)localObject1).put("time", localObject3);
      paramBackOffGroup = new StringBuilder();
      paramBackOffGroup.append("clickTimes");
      paramBackOffGroup.append(paramString2);
      paramBackOffGroup.append(paramString1);
      ((JSONObject)localObject1).put(paramBackOffGroup.toString(), i);
      paramBackOffGroup = new StringBuilder();
      paramBackOffGroup.append("end saveChannelClickToSP :");
      paramBackOffGroup.append(((JSONObject)localObject1).toString());
      QLog.d("RIJUGRuleSp", 1, paramBackOffGroup.toString());
      RIJSPUtils.a(a, ((JSONObject)localObject1).toString());
      return;
    }
    catch (JSONException paramBackOffGroup)
    {
      paramBackOffGroup.printStackTrace();
    }
  }
  
  public static void a(oidb_cmd0x68b.ReqChannelPara paramReqChannelPara, String paramString)
  {
    try
    {
      Object localObject1 = (String)RIJSPUtils.b(b, "");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("start addFreshTimesToUGAndSaveToSp : ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("RIJUGRuleSp", 1, ((StringBuilder)localObject2).toString());
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = new JSONObject();
      } else {
        localObject1 = new JSONObject((String)localObject1);
      }
      localObject2 = ((JSONObject)localObject1).optString("time", "");
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("freshTimes");
      ((StringBuilder)localObject3).append(paramString);
      int i = ((JSONObject)localObject1).optInt(((StringBuilder)localObject3).toString(), 0);
      localObject3 = TimeSliceHelper.a();
      if (!((String)localObject2).equals(localObject3))
      {
        localObject1 = new JSONObject();
        i = 0;
      }
      i += 1;
      ((JSONObject)localObject1).put("time", localObject3);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("freshTimes");
      ((StringBuilder)localObject2).append(paramString);
      ((JSONObject)localObject1).put(((StringBuilder)localObject2).toString(), i);
      paramString = new StringBuilder();
      paramString.append("end addFreshTimesToUGAndSaveToSp : ");
      paramString.append(((JSONObject)localObject1).toString());
      QLog.d("RIJUGRuleSp", 1, paramString.toString());
      RIJSPUtils.a(b, ((JSONObject)localObject1).toString());
      paramReqChannelPara.uint32_update_times_one_day.set(i);
      return;
    }
    catch (JSONException paramReqChannelPara)
    {
      paramReqChannelPara.printStackTrace();
    }
  }
  
  public static int b(BackOffGroup paramBackOffGroup, String paramString1, String paramString2)
  {
    try
    {
      Object localObject = (String)RIJSPUtils.b(a, "");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return paramBackOffGroup.d;
      }
      localObject = new JSONObject((String)localObject);
      String str = ((JSONObject)localObject).optString("time", "");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clickTimes");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1);
      int j = ((JSONObject)localObject).optInt(localStringBuilder.toString(), 0);
      if (!str.equals(TimeSliceHelper.a())) {
        return paramBackOffGroup.d;
      }
      int i = j;
      if (j == 0) {
        i = paramBackOffGroup.d;
      }
      paramString1 = new StringBuilder();
      paramString1.append("getChannelClickTimes :");
      paramString1.append(i);
      QLog.d("RIJUGRuleSp", 1, paramString1.toString());
      return i;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramBackOffGroup.d;
  }
  
  public static void b(int paramInt)
  {
    if (paramInt != 0) {}
    for (;;)
    {
      long l3;
      try
      {
        if (DailyModeConfigHandler.b(paramInt))
        {
          Object localObject1 = TimeSliceHelper.b(String.valueOf(paramInt));
          l2 = 0L;
          if (localObject1 == null) {
            break label299;
          }
          l1 = ((TimeSliceHelper)localObject1).a(false);
          localObject1 = (String)RIJSPUtils.b(c, "");
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("start saveRemainTimeToSP string is ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("RIJUGRuleSp", 1, ((StringBuilder)localObject2).toString());
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject1 = new JSONObject();
          } else {
            localObject1 = new JSONObject((String)localObject1);
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("remainTime");
          ((StringBuilder)localObject2).append(paramInt);
          l3 = ((JSONObject)localObject1).optLong(((StringBuilder)localObject2).toString(), 0L);
          String str = ((JSONObject)localObject1).optString("time", "");
          localObject2 = TimeSliceHelper.a();
          if (str.equals(localObject2)) {
            break label304;
          }
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("time", localObject2);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("remainTime");
          ((StringBuilder)localObject2).append(paramInt);
          ((JSONObject)localObject1).put(((StringBuilder)localObject2).toString(), l2 + l1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("end saveRemainTimeToSP string is ");
          ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
          QLog.d("RIJUGRuleSp", 1, ((StringBuilder)localObject2).toString());
          RIJSPUtils.a(c, ((JSONObject)localObject1).toString());
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return;
      label299:
      long l1 = 0L;
      continue;
      label304:
      long l2 = l3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.ugc.RIJUGRuleSp
 * JD-Core Version:    0.7.0.1
 */