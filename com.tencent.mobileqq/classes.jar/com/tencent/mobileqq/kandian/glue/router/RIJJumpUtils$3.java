package com.tencent.mobileqq.kandian.glue.router;

import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.NativeWebVideoCoverGetCallback;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

final class RIJJumpUtils$3
  implements Runnable
{
  RIJJumpUtils$3(String paramString1, String paramString2, String paramString3, String paramString4, NativeWebVideoCoverGetCallback paramNativeWebVideoCoverGetCallback) {}
  
  public void run()
  {
    Object localObject4 = null;
    JSONArray localJSONArray = null;
    Object localObject2 = localObject4;
    Object localObject1;
    int i;
    int j;
    try
    {
      localObject1 = new StringBuilder();
      localObject2 = localObject4;
      ((StringBuilder)localObject1).append("https://union.video.qq.com/fcgi-bin/data?otype=json&tid=");
      localObject2 = localObject4;
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      localObject2 = localObject4;
      ((StringBuilder)localObject1).append("&appid=");
      localObject2 = localObject4;
      ((StringBuilder)localObject1).append(this.b);
      localObject2 = localObject4;
      ((StringBuilder)localObject1).append("&appkey=");
      localObject2 = localObject4;
      ((StringBuilder)localObject1).append(this.c);
      localObject2 = localObject4;
      ((StringBuilder)localObject1).append("&idlist=");
      localObject2 = localObject4;
      ((StringBuilder)localObject1).append(this.d);
      localObject2 = localObject4;
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = localObject4;
      String str = new String(HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), (String)localObject1, "GET", null, null));
      localObject1 = localJSONArray;
      localObject2 = localObject4;
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = localJSONArray;
        localObject2 = localObject4;
        if (str.contains("pic_496_280"))
        {
          localObject2 = localObject4;
          localObject1 = str.substring(str.indexOf("pic")).split(",")[0].split("\"")[2];
        }
      }
      localObject2 = localObject1;
      localJSONArray = new JSONObject(str.split("=")[1]).getJSONArray("results");
      localObject2 = localObject1;
      if (localJSONArray.length() > 0)
      {
        localObject2 = localObject1;
        localJSONArray = localJSONArray.getJSONObject(0).getJSONObject("fields").getJSONArray("vWH");
        localObject2 = localObject1;
        if (localJSONArray.length() >= 2)
        {
          localObject2 = localObject1;
          i = localJSONArray.getInt(0);
          try
          {
            j = localJSONArray.getInt(1);
          }
          catch (Exception localException1)
          {
            j = 0;
            break label365;
          }
        }
      }
      j = 0;
      i = 0;
      try
      {
        new URL((String)localObject1);
        bool = true;
      }
      catch (Exception localException2) {}
      ((Exception)localObject3).printStackTrace();
    }
    catch (Exception localException3)
    {
      j = 0;
      i = 0;
      localObject1 = localException2;
      localObject3 = localException3;
    }
    label365:
    boolean bool = false;
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsNativeWebVideoCoverGetCallback;
    if (localObject3 != null) {
      ((NativeWebVideoCoverGetCallback)localObject3).a(bool, this.d, (String)localObject1, i, j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.3
 * JD-Core Version:    0.7.0.1
 */