package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.detail.web.IReadInJoyWebViewPlugin;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef.RepUtil;
import java.io.IOException;
import java.util.Map;
import mqq.app.AppRuntime;

class ReadInjoyWebShareHelper$5
  implements Runnable
{
  ReadInjoyWebShareHelper$5(ReadInjoyWebShareHelper paramReadInjoyWebShareHelper, String paramString1, boolean paramBoolean1, Map paramMap, Runnable paramRunnable, boolean paramBoolean2, String paramString2) {}
  
  public void run()
  {
    int i = 1;
    try
    {
      localObject1 = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.jdField_a_of_type_JavaLangString), "GET", null, null);
      if (localObject1 != null)
      {
        localObject2 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
        if (localObject2 != null)
        {
          int k = ((Bitmap)localObject2).getWidth();
          int j = ((Bitmap)localObject2).getHeight();
          double d1 = k * j;
          localObject1 = localObject2;
          if (d1 > 8000.0D)
          {
            boolean bool = this.jdField_a_of_type_Boolean;
            localObject1 = localObject2;
            if (!bool)
            {
              Double.isNaN(d1);
              d1 = 8000.0D / d1;
              d1 = Math.sqrt(d1);
              double d2 = k;
              Double.isNaN(d2);
              k = (int)(d2 * d1);
              d2 = j;
              Double.isNaN(d2);
              j = (int)(d2 * d1);
              localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, k, j, true);
              ((Bitmap)localObject2).recycle();
            }
          }
          this.jdField_a_of_type_JavaUtilMap.put("image", localObject1);
        }
      }
    }
    catch (IOException|OutOfMemoryError localIOException)
    {
      Object localObject1;
      Object localObject2;
      label173:
      break label173;
    }
    if (ReadInjoyWebShareHelper.a(this.this$0).a().getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity")) {
      ReadInjoyWebShareHelper.a(this.this$0).a().runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
    } else {
      ReadInjoyWebShareHelper.a(this.this$0).a().runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("report_type", "102");
    ((Bundle)localObject1).putString("act_type", "96");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    if (this.jdField_a_of_type_JavaUtilMap.get("image") != null) {
      i = 0;
    }
    ((StringBuilder)localObject2).append(i);
    ((Bundle)localObject1).putString("intext_1", ((StringBuilder)localObject2).toString());
    ((Bundle)localObject1).putString("intext_4", "0");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    if (this.jdField_b_of_type_Boolean) {
      i = 3;
    } else {
      i = 4;
    }
    ((StringBuilder)localObject2).append(ReportDef.RepUtil.b(i));
    ((Bundle)localObject1).putString("intext_3", ((StringBuilder)localObject2).toString());
    ((Bundle)localObject1).putString("stringext_1", this.jdField_b_of_type_JavaLangString);
    ReportCenter.a().a((Bundle)localObject1, "", ReadInjoyWebShareHelper.a(this.this$0).a().getAccount(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ReadInjoyWebShareHelper.5
 * JD-Core Version:    0.7.0.1
 */