package com.tencent.mobileqq.redtouch;

import android.app.Activity;
import android.text.TextUtils;
import avps;
import bcdp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class RedTouchWebviewHandler$2
  implements Runnable
{
  RedTouchWebviewHandler$2(RedTouchWebviewHandler paramRedTouchWebviewHandler, String paramString, long paramLong) {}
  
  public void run()
  {
    localObject4 = null;
    Object localObject1 = "callback";
    localObject3 = "";
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray1 = new JSONArray();
    ArrayList localArrayList = new ArrayList();
    int m = 0;
    j = 0;
    int n = 0;
    k = 0;
    Object localObject5 = localObject1;
    localObject7 = localObject3;
    try
    {
      localObject8 = new JSONObject(this.jdField_a_of_type_JavaLangString);
      localObject5 = localObject1;
      localObject7 = localObject3;
      localObject1 = ((JSONObject)localObject8).getString("callback");
      localObject5 = localObject1;
      localObject7 = localObject3;
      localObject9 = ((JSONObject)localObject8).getJSONArray("pathList");
      localObject5 = localObject1;
      localObject7 = localObject3;
      if (!((JSONObject)localObject8).has("serial")) {
        break label1351;
      }
      localObject5 = localObject1;
      localObject7 = localObject3;
      localObject3 = ((JSONObject)localObject8).getString("serial");
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject8;
        Object localObject9;
        localObject4 = localObject6;
        k = -2;
        localObject6 = localException1;
        localObject2 = null;
        int i = j;
        j = k;
        localObject3 = localObject7;
        continue;
        i += 1;
        continue;
        localObject3 = "";
      }
    }
    if (localObject9 != null)
    {
      localObject5 = localObject1;
      localObject7 = localObject3;
      localObject8 = new ArrayList();
      i = 0;
      localObject4 = localObject8;
      localObject5 = localObject1;
      localObject7 = localObject3;
      if (i < ((JSONArray)localObject9).length())
      {
        localObject5 = localObject1;
        localObject7 = localObject3;
        localObject4 = ((JSONArray)localObject9).optString(i, "");
        localObject5 = localObject1;
        localObject7 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          break label1344;
        }
        localObject5 = localObject1;
        localObject7 = localObject3;
        ((List)localObject8).add(localObject4);
        break label1344;
      }
    }
    localObject5 = localObject1;
    localObject7 = localObject3;
    localObject4 = RedTouchWebviewHandler.access$200(this.this$0, (List)localObject4);
    if (localObject4 != null) {
      j = n;
    }
    try
    {
      if (!((List)localObject4).isEmpty()) {
        break label627;
      }
      j = n;
      localJSONObject.put("code", -3);
      j = n;
      localJSONObject.put("errorMessage", "not find red info");
      j = n;
      localJSONObject.put("jsStartTime", this.jdField_a_of_type_Long);
      j = n;
      localJSONObject.put("jsEndTime", System.currentTimeMillis());
      j = -3;
      i = k;
      localObject5 = localObject1;
      localObject1 = localObject4;
      localObject4 = localObject5;
      label347:
      if (QLog.isColorLevel()) {
        QLog.i(RedTouchWebviewHandler.TAG, 2, "getAppInfoList:" + localJSONObject.toString());
      }
      if ((this.this$0.mRuntime == null) || (this.this$0.mRuntime.a() == null) || (localObject1 == null) || (((List)localObject1).isEmpty())) {
        break label1338;
      }
      localObject5 = new avps(this.this$0.mRuntime.a());
      if (localObject5 == null) {
        break label1338;
      }
      localObject5 = ((avps)localObject5).a();
      localObject7 = ((BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(0)).path.get();
      if ((TextUtils.isEmpty((CharSequence)localObject7)) || (!((String)localObject7).equals(localObject5))) {
        break label1338;
      }
      i = 1;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        label519:
        label538:
        label627:
        localObject6 = localObject2;
        label1236:
        label1252:
        k = -2;
        localObject2 = localObject4;
        i = j;
        localObject4 = localObject6;
        localObject6 = localException3;
        j = k;
        continue;
      }
    }
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject5 = (BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(0);
      if (!localArrayList.isEmpty()) {
        break label1236;
      }
      localObject7 = new ArrayList();
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        break label1252;
      }
    }
    for (localObject1 = ((BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(0)).path.get();; localObject1 = "")
    {
      for (;;)
      {
        for (;;)
        {
          if (this.this$0.mRuntime != null)
          {
            localObject8 = this.this$0.mRuntime.a();
            if (localObject8 != null) {
              ((Activity)localObject8).runOnUiThread(new RedTouchWebviewHandler.2.1(this, (String)localObject4, localJSONObject, (BusinessInfoCheckUpdate.AppInfo)localObject5, j, i, (ArrayList)localObject7, (String)localObject1, (String)localObject3));
            }
          }
          return;
          j = n;
          localObject5 = ((List)localObject4).iterator();
          i = m;
          for (;;)
          {
            j = i;
            Object localObject10;
            if (((Iterator)localObject5).hasNext())
            {
              j = i;
              localObject7 = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject5).next();
              j = i;
              if (((BusinessInfoCheckUpdate.AppInfo)localObject7).red_display_info.get() == null) {
                break label1341;
              }
              j = i;
              localObject8 = new JSONObject();
              j = i;
              localObject10 = new ArrayList();
              j = i;
              localObject9 = ((BusinessInfoCheckUpdate.AppInfo)localObject7).red_display_info.red_type_info.get();
              j = i;
              ((JSONObject)localObject8).put("appID", ((BusinessInfoCheckUpdate.AppInfo)localObject7).uiAppId.get());
              j = i;
              ((JSONObject)localObject8).put("iNewFlag", ((BusinessInfoCheckUpdate.AppInfo)localObject7).iNewFlag.get());
              j = i;
              i = ((BusinessInfoCheckUpdate.AppInfo)localObject7).iNewFlag.get();
            }
            try
            {
              JSONArray localJSONArray2 = new JSONArray();
              j = 0;
              while (j < ((BusinessInfoCheckUpdate.AppInfo)localObject7).missions.size())
              {
                localJSONArray2.put(((BusinessInfoCheckUpdate.AppInfo)localObject7).missions.get(j));
                ((ArrayList)localObject10).add(((BusinessInfoCheckUpdate.AppInfo)localObject7).missions.get(j));
                j += 1;
              }
              localArrayList.add(localObject10);
              localObject10 = new JSONObject();
              if (localObject9 != null)
              {
                j = 0;
                while (j < ((List)localObject9).size())
                {
                  ((JSONObject)localObject10).put("red_type", ((BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject9).get(j)).red_type.get());
                  ((JSONObject)localObject10).put("red_content", ((BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject9).get(j)).red_content.get());
                  ((JSONObject)localObject10).put("red_desc", ((BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject9).get(j)).red_desc.get());
                  j += 1;
                }
              }
              ((JSONObject)localObject8).put("redInfo", localObject10);
              ((JSONObject)localObject8).put("missions", localJSONArray2);
              ((JSONObject)localObject8).put("type", ((BusinessInfoCheckUpdate.AppInfo)localObject7).type.get());
              ((JSONObject)localObject8).put("buffer", ((BusinessInfoCheckUpdate.AppInfo)localObject7).buffer.get());
              ((JSONObject)localObject8).put("path", ((BusinessInfoCheckUpdate.AppInfo)localObject7).path.get());
              ((JSONObject)localObject8).put("appset", ((BusinessInfoCheckUpdate.AppInfo)localObject7).appset.get());
              ((JSONObject)localObject8).put("modify_ts", ((BusinessInfoCheckUpdate.AppInfo)localObject7).modify_ts.get());
              ((JSONObject)localObject8).put("num", ((BusinessInfoCheckUpdate.AppInfo)localObject7).num.get());
              ((JSONObject)localObject8).put("push_red_ts", ((BusinessInfoCheckUpdate.AppInfo)localObject7).push_red_ts.get());
              localJSONArray1.put(localObject8);
            }
            catch (Exception localException4)
            {
              for (;;)
              {
                Object localObject6 = localObject2;
                j = -2;
                Object localObject2 = localObject4;
                localObject4 = localObject6;
                localObject6 = localException4;
              }
            }
          }
          j = 0;
          try
          {
            localJSONObject.put("code", 0);
            localJSONObject.put("data", localJSONArray1);
            localJSONObject.put("jsStart", this.jdField_a_of_type_Long);
            localJSONObject.put("jsEnd", System.currentTimeMillis());
          }
          catch (Exception localException2)
          {
            j = 0;
            localObject7 = localObject4;
            localObject4 = localObject1;
            localObject1 = localObject7;
          }
        }
        localException2.printStackTrace();
        try
        {
          localJSONObject.put("code", -1);
          localJSONObject.put("errorMessage", "jsonexception");
          localJSONObject.put("jsStart", this.jdField_a_of_type_Long);
          localJSONObject.put("jsEnd", System.currentTimeMillis());
          j = -1;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      break label347;
      localObject6 = null;
      break label519;
      localObject7 = (ArrayList)localArrayList.get(0);
      break label538;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchWebviewHandler.2
 * JD-Core Version:    0.7.0.1
 */