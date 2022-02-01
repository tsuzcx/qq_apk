package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef.RepUtil;
import java.io.IOException;
import java.util.Map;

class AbstractReadInjoyWebShareHelper$5
  implements Runnable
{
  AbstractReadInjoyWebShareHelper$5(AbstractReadInjoyWebShareHelper paramAbstractReadInjoyWebShareHelper, String paramString1, boolean paramBoolean1, Map paramMap, Runnable paramRunnable, boolean paramBoolean2, String paramString2) {}
  
  public void run()
  {
    int i = 1;
    try
    {
      localObject1 = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.a), "GET", null, null);
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
            boolean bool = this.b;
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
          this.c.put("image", localObject1);
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
    if (this.this$0.b().getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity")) {
      this.this$0.b().runOnUiThread(this.d);
    } else {
      this.this$0.c().runOnUiThread(this.d);
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("report_type", "102");
    ((Bundle)localObject1).putString("act_type", "96");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    if (this.c.get("image") != null) {
      i = 0;
    }
    ((StringBuilder)localObject2).append(i);
    ((Bundle)localObject1).putString("intext_1", ((StringBuilder)localObject2).toString());
    ((Bundle)localObject1).putString("intext_4", "0");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    if (this.e) {
      i = 3;
    } else {
      i = 4;
    }
    ((StringBuilder)localObject2).append(ReportDef.RepUtil.b(i));
    ((Bundle)localObject1).putString("intext_3", ((StringBuilder)localObject2).toString());
    ((Bundle)localObject1).putString("stringext_1", this.f);
    ReportCenter.a().a((Bundle)localObject1, "", this.this$0.c().getAccount(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper.5
 * JD-Core Version:    0.7.0.1
 */