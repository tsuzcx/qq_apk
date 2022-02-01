package com.tencent.mobileqq.kandian.repo.feeds.pts;

import android.text.TextUtils;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyProteusFamilyUtil$4
  implements Runnable
{
  ReadInJoyProteusFamilyUtil$4(ReadInJoyProteusFamilyUtil paramReadInJoyProteusFamilyUtil) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject2 = (String)RIJSPUtils.a(ReadInJoyProteusFamilyUtil.c(), "");
        Object localObject1 = ReadInJoyProteusFamilyUtil.a();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("local card data str ");
        ((StringBuilder)localObject3).append((String)localObject2);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
        boolean bool = NetworkUtil.a(BaseApplicationImpl.context);
        int j = 0;
        localObject1 = localObject2;
        if (bool)
        {
          localObject3 = ReadInJoyProteusFamilyUtil.b(null);
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject1 = new JSONObject();
            localObject2 = new JSONArray((String)localObject3);
            int k = ((JSONArray)localObject2).length();
            i = 0;
            if (i < k)
            {
              localObject3 = ((JSONArray)localObject2).optJSONObject(i);
              if (localObject3 == null) {
                break label389;
              }
              ((JSONObject)localObject1).put(((JSONObject)localObject3).optString(ReadInJoyProteusFamilyUtil.d()), ((JSONObject)localObject3).optString(ReadInJoyProteusFamilyUtil.e()));
              break label389;
            }
            if (((JSONObject)localObject1).length() > 0)
            {
              localObject1 = ((JSONObject)localObject1).toString();
              localObject2 = ReadInJoyProteusFamilyUtil.a();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("loadProteusFamilyData | update local cardDataStr ");
              ((StringBuilder)localObject3).append((String)localObject1);
              QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
              RIJSPUtils.a(ReadInJoyProteusFamilyUtil.c(), localObject1);
            }
            else
            {
              localObject1 = (String)RIJSPUtils.a(ReadInJoyProteusFamilyUtil.c(), "");
              localObject2 = ReadInJoyProteusFamilyUtil.a();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("loadProteusFamilyData | no need to update just use local cardDataStr ");
              ((StringBuilder)localObject3).append((String)localObject1);
              QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
            }
          }
        }
        ReadInJoyProteusFamilyUtil.a(this.this$0, ReadInJoyProteusFamilyUtil.a((String)localObject1));
        if (ReadInJoyProteusFamilyUtil.a(this.this$0) != null) {
          ReadInJoyProteusFamilyUtil.a(this.this$0).a(true, ReadInJoyProteusFamilyUtil.a(this.this$0));
        }
        localObject1 = ReadInJoyProteusFamilyUtil.a();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadProteusFamilyData | proteus family members updated ");
        i = j;
        if (ReadInJoyProteusFamilyUtil.a() != null) {
          i = ReadInJoyProteusFamilyUtil.a().size();
        }
        ((StringBuilder)localObject2).append(i);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        return;
      }
      label389:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.pts.ReadInJoyProteusFamilyUtil.4
 * JD-Core Version:    0.7.0.1
 */