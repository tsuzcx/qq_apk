package com.tencent.mobileqq.jsp;

import android.app.Activity;
import arne;
import bcdp;
import com.tencent.common.app.AppInterface;
import java.util.HashMap;
import naj;
import org.json.JSONObject;

public class QQApiPlugin$1
  implements Runnable
{
  public QQApiPlugin$1(arne paramarne, HashMap paramHashMap, String paramString1, String paramString2, String paramString3, String paramString4, JSONObject paramJSONObject, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt1, String paramString11, int paramInt2, Activity paramActivity) {}
  
  public void run()
  {
    Object localObject2 = naj.a(this.jdField_a_of_type_JavaUtilHashMap);
    Object localObject1 = (String)((HashMap)localObject2).get("share_url");
    if (localObject1 == null) {
      localObject1 = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      String str1 = (String)((HashMap)localObject2).get("image_url");
      if (str1 == null) {
        str1 = this.jdField_b_of_type_JavaLangString;
      }
      for (;;)
      {
        String str2 = (String)((HashMap)localObject2).get("flash_url");
        localObject2 = str2;
        if (str2 == null) {
          localObject2 = this.c;
        }
        localObject1 = new QQApiPlugin.1.1(this, (String)localObject1, str1, (String)localObject2);
        if (this.jdField_a_of_type_AndroidAppActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
        {
          this.jdField_a_of_type_AndroidAppActivity.runOnUiThread((Runnable)localObject1);
          return;
        }
        this.this$0.mRuntime.a().runOnUiThread((Runnable)localObject1);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.QQApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */