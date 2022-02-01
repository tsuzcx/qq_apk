package com.tencent.mobileqq.jsp;

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

class ShareMsgImpl$4
  implements Runnable
{
  ShareMsgImpl$4(ShareMsgImpl paramShareMsgImpl, String paramString1, Map paramMap, Runnable paramRunnable, String paramString2, String paramString3) {}
  
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
          int m = k * j;
          localObject1 = localObject2;
          if (m > 8000)
          {
            double d1 = m;
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
          this.b.put("image", localObject1);
        }
      }
    }
    catch (IOException|OutOfMemoryError localIOException)
    {
      Object localObject1;
      Object localObject2;
      label162:
      break label162;
    }
    if (this.this$0.n.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity")) {
      this.this$0.n.runOnUiThread(this.c);
    } else {
      this.this$0.o.runOnUiThread(this.c);
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("report_type", "102");
    ((Bundle)localObject1).putString("act_type", "96");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    if (this.b.get("image") != null) {
      i = 0;
    }
    ((StringBuilder)localObject2).append(i);
    ((Bundle)localObject1).putString("intext_1", ((StringBuilder)localObject2).toString());
    ((Bundle)localObject1).putString("intext_4", "0");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    if ("2".equals(this.d)) {
      i = 3;
    } else {
      i = 4;
    }
    ((StringBuilder)localObject2).append(ReportDef.RepUtil.b(i));
    ((Bundle)localObject1).putString("intext_3", ((StringBuilder)localObject2).toString());
    ((Bundle)localObject1).putString("stringext_1", this.e);
    ReportCenter.a().a((Bundle)localObject1, "", this.this$0.o.getAccount(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.ShareMsgImpl.4
 * JD-Core Version:    0.7.0.1
 */