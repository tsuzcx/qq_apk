package com.tencent.mobileqq.redtouch;

import android.app.Activity;
import android.text.TextUtils;
import auqh;
import bbac;
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
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class RedTouchWebviewHandler$1
  implements Runnable
{
  RedTouchWebviewHandler$1(RedTouchWebviewHandler paramRedTouchWebviewHandler, String paramString, long paramLong) {}
  
  public void run()
  {
    localObject2 = "";
    localObject3 = "callback";
    localObject1 = "";
    BusinessInfoCheckUpdate.AppInfo localAppInfo = null;
    localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    ArrayList localArrayList = new ArrayList();
    int n = -2;
    int i2 = 0;
    m = 0;
    j = i2;
    localObject4 = localObject3;
    localObject6 = localAppInfo;
    i = n;
    localObject7 = localObject2;
    localObject8 = localObject1;
    for (;;)
    {
      try
      {
        localObject9 = new JSONObject(this.jdField_a_of_type_JavaLangString);
        j = i2;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = n;
        localObject7 = localObject2;
        localObject8 = localObject1;
        localObject3 = ((JSONObject)localObject9).getString("callback");
        j = i2;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = n;
        localObject7 = localObject2;
        localObject8 = localObject1;
        localObject2 = ((JSONObject)localObject9).getString("path");
        j = i2;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = n;
        localObject7 = localObject2;
        localObject8 = localObject1;
        if (((JSONObject)localObject9).has("serial"))
        {
          j = i2;
          localObject4 = localObject3;
          localObject6 = localAppInfo;
          i = n;
          localObject7 = localObject2;
          localObject8 = localObject1;
          localObject1 = ((JSONObject)localObject9).getString("serial");
          j = i2;
          localObject4 = localObject3;
          localObject6 = localAppInfo;
          i = n;
          localObject7 = localObject2;
          localObject8 = localObject1;
          localAppInfo = RedTouchWebviewHandler.access$000(this.this$0, (String)localObject2);
          if (localAppInfo != null) {
            continue;
          }
          j = i2;
          localObject4 = localObject3;
          localObject6 = localAppInfo;
          i = n;
          localObject7 = localObject2;
          localObject8 = localObject1;
          localJSONObject1.put("code", -3);
          j = i2;
          localObject4 = localObject3;
          localObject6 = localAppInfo;
          i = n;
          localObject7 = localObject2;
          localObject8 = localObject1;
          localJSONObject1.put("errorMessage", "not red info");
          j = i2;
          localObject4 = localObject3;
          localObject6 = localAppInfo;
          i = n;
          localObject7 = localObject2;
          localObject8 = localObject1;
          localJSONObject1.put("jsStartTime", this.jdField_a_of_type_Long);
          j = i2;
          localObject4 = localObject3;
          localObject6 = localAppInfo;
          i = n;
          localObject7 = localObject2;
          localObject8 = localObject1;
          localJSONObject1.put("jsEndTime", System.currentTimeMillis());
          i = -3;
          j = 0;
          m = j;
          localObject4 = localObject3;
          localObject6 = localAppInfo;
          k = i;
          localObject7 = localObject2;
          localObject8 = localObject1;
        }
      }
      catch (Exception localException2)
      {
        Object localObject9;
        int k;
        int i1;
        JSONArray localJSONArray;
        JSONObject localJSONObject3;
        localObject1 = localObject8;
        localObject2 = localObject7;
        localObject3 = localObject4;
        localObject4 = localException2;
        ((Exception)localObject4).printStackTrace();
        try
        {
          localJSONObject1.put("code", -1);
          localJSONObject1.put("errorMessage", "jsonexception");
          localJSONObject1.put("jsStart", this.jdField_a_of_type_Long);
          localJSONObject1.put("jsEnd", System.currentTimeMillis());
          k = -1;
          m = j;
          localObject4 = localObject3;
          localObject7 = localObject2;
          localObject8 = localObject1;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          m = j;
          Object localObject5 = localObject3;
          k = i;
          localObject7 = localObject2;
          localObject8 = localObject1;
        }
        continue;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.i(RedTouchWebviewHandler.TAG, 2, "getAppInfo:" + localJSONObject1.toString());
          localObject8 = localObject1;
          localObject7 = localObject2;
          k = i;
          localObject6 = localAppInfo;
          localObject4 = localObject3;
          m = j;
        }
        if (QLog.isColorLevel()) {
          QLog.i(RedTouchWebviewHandler.TAG, 2, "getAppInfo:" + localJSONObject1.toString());
        }
        if ((this.this$0.mRuntime == null) || (this.this$0.mRuntime.a() == null)) {
          break label1789;
        }
        localObject1 = new auqh(this.this$0.mRuntime.a());
        if (localObject1 == null) {
          break label1789;
        }
        localObject1 = ((auqh)localObject1).a();
        if ((TextUtils.isEmpty(localObject7)) || (!localObject7.equals(localObject1))) {
          break label1789;
        }
        i = 1;
      }
      catch (Exception localException1)
      {
        localObject6 = localException2;
        continue;
        i = m;
        continue;
      }
      if (this.this$0.mRuntime != null)
      {
        localObject1 = this.this$0.mRuntime.a();
        if (localObject1 != null) {
          ((Activity)localObject1).runOnUiThread(new RedTouchWebviewHandler.1.1(this, (String)localObject4, localJSONObject1, (BusinessInfoCheckUpdate.AppInfo)localObject6, k, i, localArrayList, localObject7, localObject8));
        }
      }
      return;
      localObject1 = "";
      continue;
      k = n;
      j = i2;
      localObject4 = localObject3;
      localObject6 = localAppInfo;
      i = n;
      localObject7 = localObject2;
      localObject8 = localObject1;
      if (localAppInfo.red_display_info.get() != null)
      {
        j = i2;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = n;
        localObject7 = localObject2;
        localObject8 = localObject1;
        localObject9 = localAppInfo.red_display_info.red_type_info.get();
        i1 = 0;
        n = 0;
        j = i2;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = i1;
        localObject7 = localObject2;
        localObject8 = localObject1;
        localJSONObject1.put("code", 0);
        j = i2;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = i1;
        localObject7 = localObject2;
        localObject8 = localObject1;
        localJSONObject2.put("appID", localAppInfo.uiAppId.get());
        j = i2;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = i1;
        localObject7 = localObject2;
        localObject8 = localObject1;
        localJSONObject2.put("iNewFlag", localAppInfo.iNewFlag.get());
        j = i2;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = i1;
        localObject7 = localObject2;
        localObject8 = localObject1;
        m = localAppInfo.iNewFlag.get();
        j = m;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = i1;
        localObject7 = localObject2;
        localObject8 = localObject1;
        localJSONArray = new JSONArray();
        k = 0;
        j = m;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = i1;
        localObject7 = localObject2;
        localObject8 = localObject1;
        if (k < localAppInfo.missions.size())
        {
          j = m;
          localObject4 = localObject3;
          localObject6 = localAppInfo;
          i = i1;
          localObject7 = localObject2;
          localObject8 = localObject1;
          localJSONArray.put(localAppInfo.missions.get(k));
          j = m;
          localObject4 = localObject3;
          localObject6 = localAppInfo;
          i = i1;
          localObject7 = localObject2;
          localObject8 = localObject1;
          localArrayList.add(localAppInfo.missions.get(k));
          k += 1;
          continue;
        }
        j = m;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = i1;
        localObject7 = localObject2;
        localObject8 = localObject1;
        localJSONObject3 = new JSONObject();
        if (localObject9 != null)
        {
          k = 0;
          j = m;
          localObject4 = localObject3;
          localObject6 = localAppInfo;
          i = i1;
          localObject7 = localObject2;
          localObject8 = localObject1;
          if (k < ((List)localObject9).size())
          {
            j = m;
            localObject4 = localObject3;
            localObject6 = localAppInfo;
            i = i1;
            localObject7 = localObject2;
            localObject8 = localObject1;
            localJSONObject3.put("red_type", ((BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject9).get(k)).red_type.get());
            j = m;
            localObject4 = localObject3;
            localObject6 = localAppInfo;
            i = i1;
            localObject7 = localObject2;
            localObject8 = localObject1;
            localJSONObject3.put("red_content", ((BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject9).get(k)).red_content.get());
            j = m;
            localObject4 = localObject3;
            localObject6 = localAppInfo;
            i = i1;
            localObject7 = localObject2;
            localObject8 = localObject1;
            localJSONObject3.put("red_desc", ((BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject9).get(k)).red_desc.get());
            k += 1;
            continue;
          }
        }
        j = m;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = i1;
        localObject7 = localObject2;
        localObject8 = localObject1;
        localJSONObject2.put("redInfo", localJSONObject3);
        j = m;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = i1;
        localObject7 = localObject2;
        localObject8 = localObject1;
        localJSONObject2.put("missions", localJSONArray);
        j = m;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = i1;
        localObject7 = localObject2;
        localObject8 = localObject1;
        localJSONObject2.put("type", localAppInfo.type.get());
        j = m;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = i1;
        localObject7 = localObject2;
        localObject8 = localObject1;
        localJSONObject2.put("buffer", localAppInfo.buffer.get());
        j = m;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = i1;
        localObject7 = localObject2;
        localObject8 = localObject1;
        localJSONObject2.put("path", localAppInfo.path.get());
        j = m;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = i1;
        localObject7 = localObject2;
        localObject8 = localObject1;
        localJSONObject2.put("appset", localAppInfo.appset.get());
        j = m;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = i1;
        localObject7 = localObject2;
        localObject8 = localObject1;
        localJSONObject2.put("modify_ts", localAppInfo.modify_ts.get());
        j = m;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = i1;
        localObject7 = localObject2;
        localObject8 = localObject1;
        localJSONObject2.put("num", localAppInfo.num.get());
        j = m;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = i1;
        localObject7 = localObject2;
        localObject8 = localObject1;
        localJSONObject2.put("push_red_ts", localAppInfo.push_red_ts.get());
        j = m;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = i1;
        localObject7 = localObject2;
        localObject8 = localObject1;
        localJSONObject1.put("data", localJSONObject2);
        j = m;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = i1;
        localObject7 = localObject2;
        localObject8 = localObject1;
        localJSONObject1.put("jsStart", this.jdField_a_of_type_Long);
        j = m;
        localObject4 = localObject3;
        localObject6 = localAppInfo;
        i = i1;
        localObject7 = localObject2;
        localObject8 = localObject1;
        localJSONObject1.put("jsEnd", System.currentTimeMillis());
        k = n;
      }
      j = m;
      i = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchWebviewHandler.1
 * JD-Core Version:    0.7.0.1
 */