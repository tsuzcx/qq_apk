package com.tencent.mobileqq.redtouch;

import android.app.Activity;
import bhod;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
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
    localObject2 = "callback";
    String str = "";
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray1 = new JSONArray();
    Object localObject8 = new ArrayList();
    m = -2;
    int k = 0;
    j = 0;
    int n = 0;
    i = 0;
    Object localObject6 = localObject2;
    Object localObject4 = str;
    for (;;)
    {
      try
      {
        localJSONObject2 = new JSONObject(this.jdField_a_of_type_JavaLangString);
        localObject6 = localObject2;
        localObject4 = str;
        localObject2 = localJSONObject2.getString("callback");
        localObject6 = localObject2;
        localObject4 = str;
        localObject3 = localJSONObject2.getJSONArray("pathList");
        localObject6 = localObject2;
        localObject4 = str;
        if (localJSONObject2.has("serial"))
        {
          localObject6 = localObject2;
          localObject4 = str;
          str = localJSONObject2.getString("serial");
          localObject6 = localObject2;
          localObject4 = str;
          localObject3 = RedTouchWebviewHandler.access$300(this.this$0, null, (JSONArray)localObject3);
          localObject6 = localObject2;
          localObject4 = str;
          localObject3 = RedTouchWebviewHandler.access$400(this.this$0, (List)localObject3);
          if (localObject3 != null) {
            j = n;
          }
        }
      }
      catch (Exception localException1)
      {
        JSONObject localJSONObject2;
        localObject2 = null;
        localObject3 = localObject7;
        Object localObject7 = localException1;
        i = j;
        j = m;
        Object localObject1 = localObject5;
        continue;
      }
      try
      {
        if (((List)localObject3).isEmpty())
        {
          j = n;
          localJSONObject1.put("code", -3);
          j = n;
          localJSONObject1.put("errorMessage", "not find red info");
          j = n;
          localJSONObject1.put("jsStartTime", this.jdField_a_of_type_Long);
          j = n;
          localJSONObject1.put("jsEndTime", System.currentTimeMillis());
          j = -3;
          localObject4 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject4;
          if (QLog.isColorLevel()) {
            QLog.i(RedTouchWebviewHandler.TAG, 2, "getAppInfoList:" + localJSONObject1.toString());
          }
          i = RedTouchWebviewHandler.access$600(this.this$0, (List)localObject2, i);
          if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
            continue;
          }
          localObject4 = (BusinessInfoCheckUpdate.AppInfo)((List)localObject2).get(0);
          if (!((List)localObject8).isEmpty()) {
            continue;
          }
          localObject6 = new ArrayList();
          if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
            continue;
          }
          localObject2 = ((BusinessInfoCheckUpdate.AppInfo)((List)localObject2).get(0)).path.get();
          if (this.this$0.mRuntime != null)
          {
            localObject8 = this.this$0.mRuntime.a();
            if (localObject8 != null) {
              ((Activity)localObject8).runOnUiThread(new RedTouchWebviewHandler.2.1(this, (String)localObject3, localJSONObject1, (BusinessInfoCheckUpdate.AppInfo)localObject4, j, i, (ArrayList)localObject6, (String)localObject2, str));
            }
          }
          return;
          str = "";
          continue;
        }
        j = n;
        localObject4 = ((List)localObject3).iterator();
        i = k;
        j = i;
        if (((Iterator)localObject4).hasNext())
        {
          j = i;
          localObject6 = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject4).next();
          k = i;
          j = i;
          if (((BusinessInfoCheckUpdate.AppInfo)localObject6).red_display_info.get() != null)
          {
            j = i;
            localJSONObject2 = new JSONObject();
            j = i;
            ArrayList localArrayList = new ArrayList();
            j = i;
            List localList = ((BusinessInfoCheckUpdate.AppInfo)localObject6).red_display_info.red_type_info.get();
            j = i;
            localJSONObject2.put("appID", ((BusinessInfoCheckUpdate.AppInfo)localObject6).uiAppId.get());
            j = i;
            localJSONObject2.put("iNewFlag", ((BusinessInfoCheckUpdate.AppInfo)localObject6).iNewFlag.get());
            j = i;
            k = ((BusinessInfoCheckUpdate.AppInfo)localObject6).iNewFlag.get();
            j = k;
            JSONArray localJSONArray2 = new JSONArray();
            i = 0;
            j = k;
            if (i < ((BusinessInfoCheckUpdate.AppInfo)localObject6).missions.size())
            {
              j = k;
              localJSONArray2.put(((BusinessInfoCheckUpdate.AppInfo)localObject6).missions.get(i));
              j = k;
              localArrayList.add(((BusinessInfoCheckUpdate.AppInfo)localObject6).missions.get(i));
              i += 1;
              continue;
            }
            j = k;
            ((List)localObject8).add(localArrayList);
            j = k;
            localJSONObject2.put("redInfo", RedTouchWebviewHandler.access$500(this.this$0, localList));
            j = k;
            localJSONObject2.put("missions", localJSONArray2);
            j = k;
            localJSONObject2.put("type", ((BusinessInfoCheckUpdate.AppInfo)localObject6).type.get());
            j = k;
            localJSONObject2.put("buffer", ((BusinessInfoCheckUpdate.AppInfo)localObject6).buffer.get());
            j = k;
            localJSONObject2.put("path", ((BusinessInfoCheckUpdate.AppInfo)localObject6).path.get());
            j = k;
            localJSONObject2.put("appset", ((BusinessInfoCheckUpdate.AppInfo)localObject6).appset.get());
            j = k;
            localJSONObject2.put("modify_ts", ((BusinessInfoCheckUpdate.AppInfo)localObject6).modify_ts.get());
            j = k;
            localJSONObject2.put("num", ((BusinessInfoCheckUpdate.AppInfo)localObject6).num.get());
            j = k;
            localJSONObject2.put("push_red_ts", ((BusinessInfoCheckUpdate.AppInfo)localObject6).push_red_ts.get());
            j = k;
            localJSONArray1.put(localJSONObject2);
          }
          i = k;
          continue;
        }
        j = 0;
        try
        {
          localJSONObject1.put("code", 0);
          localJSONObject1.put("data", localJSONArray1);
          localJSONObject1.put("jsStart", this.jdField_a_of_type_Long);
          localJSONObject1.put("jsEnd", System.currentTimeMillis());
        }
        catch (Exception localException2)
        {
          j = 0;
          localObject4 = localObject3;
          localObject3 = localObject2;
          localObject2 = localObject4;
        }
      }
      catch (Exception localException3)
      {
        localObject5 = localObject2;
        localObject2 = localObject3;
        i = j;
        localObject3 = localObject5;
        j = m;
        continue;
      }
      localException2.printStackTrace();
      try
      {
        localJSONObject1.put("code", -1);
        localJSONObject1.put("errorMessage", "jsonexception");
        localJSONObject1.put("jsStart", this.jdField_a_of_type_Long);
        localJSONObject1.put("jsEnd", System.currentTimeMillis());
        j = -1;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      continue;
      localObject5 = null;
      continue;
      localObject7 = (ArrayList)((List)localObject8).get(0);
      continue;
      localObject2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchWebviewHandler.2
 * JD-Core Version:    0.7.0.1
 */