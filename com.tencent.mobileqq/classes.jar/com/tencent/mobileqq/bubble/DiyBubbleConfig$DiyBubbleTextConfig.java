package com.tencent.mobileqq.bubble;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public final class DiyBubbleConfig$DiyBubbleTextConfig
  extends DiyBubbleConfig
{
  public int f = -1;
  public int g;
  public String h;
  public int i;
  
  public static DiyBubbleConfig a(JSONObject paramJSONObject)
  {
    DiyBubbleTextConfig localDiyBubbleTextConfig = new DiyBubbleTextConfig();
    Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    localDiyBubbleTextConfig.a = paramJSONObject.optString("align");
    localDiyBubbleTextConfig.g = (DisplayUtil.c(localContext, paramJSONObject.optInt("text_size") / 2) + 1);
    localDiyBubbleTextConfig.h = paramJSONObject.optString("text_align");
    Object localObject2 = paramJSONObject.optString("text_color");
    Object localObject1 = localObject2;
    if (((String)localObject2).startsWith("0x")) {
      localObject1 = ((String)localObject2).substring(2);
    }
    try
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("#");
      ((StringBuilder)localObject2).append((String)localObject1);
      localDiyBubbleTextConfig.f = Color.parseColor(((StringBuilder)localObject2).toString());
    }
    catch (Exception localException)
    {
      label120:
      int j;
      break label120;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DiyBubbleConfig", 2, "diy text_color invalid");
    }
    if (paramJSONObject.has("rect"))
    {
      localObject1 = paramJSONObject.optJSONArray("rect");
      localDiyBubbleTextConfig.b = new int[4];
      j = 0;
      while (j < ((JSONArray)localObject1).length())
      {
        localDiyBubbleTextConfig.b[j] = DisplayUtil.a(localContext, ((JSONArray)localObject1).optInt(j) / 2);
        j += 1;
      }
    }
    localDiyBubbleTextConfig.i = paramJSONObject.optInt("text_max_count");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Resolve DiyBubbleTextConfig json->");
      ((StringBuilder)localObject1).append(paramJSONObject);
      QLog.d("DiyBubbleConfig", 2, ((StringBuilder)localObject1).toString());
    }
    return localDiyBubbleTextConfig;
  }
  
  @TargetApi(11)
  public Rect a(VipBubbleDrawable paramVipBubbleDrawable, Canvas paramCanvas, Paint paramPaint)
  {
    paramCanvas = paramVipBubbleDrawable.getBounds();
    Object localObject = BaseApplicationImpl.getContext().getResources();
    if (d == -1) {
      d = AIOUtils.b(48.0F, (Resources)localObject);
    }
    float f4 = this.b[3];
    int j = paramCanvas.height();
    int k = d;
    float f3 = 1.0F;
    if (j < k)
    {
      j = AIOUtils.b(2.0F, (Resources)localObject);
      k = AIOUtils.b(9.0F, (Resources)localObject);
      int m = AIOUtils.b(7.0F, (Resources)localObject);
      f3 = (paramCanvas.height() - m * 2) * 1.0F / (d - k * 2);
      f4 = this.b[3] * f3;
    }
    else
    {
      j = 0;
    }
    boolean bool = this.a.startsWith("T");
    float f2 = 0.0F;
    float f1;
    if (bool)
    {
      f1 = this.b[1] - j;
    }
    else if (this.a.startsWith("B"))
    {
      f1 = this.b[1] + this.b[3] + paramCanvas.height();
      f1 = j + (f1 - f4);
    }
    else
    {
      f1 = 0.0F;
    }
    if (this.a.endsWith("L")) {}
    for (j = this.b[0];; j = this.b[0] + paramCanvas.width())
    {
      f2 = j;
      break;
      if (!this.a.endsWith("R")) {
        break;
      }
    }
    j = this.b[2];
    k = this.g;
    if (k != 0) {
      paramPaint.setTextSize(k * f3);
    }
    paramPaint.setAntiAlias(true);
    paramPaint.setFakeBoldText(true);
    localObject = BubbleDiyFetcher.a().a(paramVipBubbleDrawable, paramVipBubbleDrawable.c);
    Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
    float f5 = DiyBubbleConfig.a(paramPaint, (String)localObject);
    float f6 = f4 / 2.0F;
    float f7 = (localFontMetrics.bottom - localFontMetrics.top) / 2.0F;
    float f8 = localFontMetrics.top;
    if (this.h.equals("center"))
    {
      f3 = f2 + (j - f5) / 2.0F;
    }
    else
    {
      f3 = f2;
      if (this.h.equals("right")) {
        f3 = f2 + j - f5;
      }
    }
    return DiyBubbleConfig.a(paramVipBubbleDrawable, paramCanvas, f4, f3, f1 + f6 - f7 - f8, j, f5);
  }
  
  public void a(VipBubbleDrawable paramVipBubbleDrawable, Canvas paramCanvas)
  {
    if (paramCanvas != null)
    {
      if (paramVipBubbleDrawable == null) {
        return;
      }
      String str = BubbleDiyFetcher.a().a(paramVipBubbleDrawable, paramVipBubbleDrawable.c);
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(this.a)))
      {
        Paint localPaint = new Paint();
        int j = this.f;
        if (j != -1) {
          localPaint.setColor(j);
        }
        paramVipBubbleDrawable = a(paramVipBubbleDrawable, paramCanvas, localPaint);
        paramCanvas.drawText(str, paramVipBubbleDrawable.left, paramVipBubbleDrawable.top, localPaint);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.DiyBubbleConfig.DiyBubbleTextConfig
 * JD-Core Version:    0.7.0.1
 */