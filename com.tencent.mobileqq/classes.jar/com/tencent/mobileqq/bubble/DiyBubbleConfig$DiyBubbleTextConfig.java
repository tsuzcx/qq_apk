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
  public int c;
  public String c;
  public int d;
  public int e;
  
  public DiyBubbleConfig$DiyBubbleTextConfig()
  {
    this.jdField_c_of_type_Int = -1;
  }
  
  public static DiyBubbleConfig a(JSONObject paramJSONObject)
  {
    DiyBubbleTextConfig localDiyBubbleTextConfig = new DiyBubbleTextConfig();
    Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    localDiyBubbleTextConfig.jdField_a_of_type_JavaLangString = paramJSONObject.optString("align");
    localDiyBubbleTextConfig.d = (DisplayUtil.c(localContext, paramJSONObject.optInt("text_size") / 2) + 1);
    localDiyBubbleTextConfig.jdField_c_of_type_JavaLangString = paramJSONObject.optString("text_align");
    String str = paramJSONObject.optString("text_color");
    Object localObject = str;
    if (str.startsWith("0x")) {
      localObject = str.substring(2);
    }
    try
    {
      localDiyBubbleTextConfig.jdField_c_of_type_Int = Color.parseColor("#" + (String)localObject);
      if (paramJSONObject.has("rect"))
      {
        localObject = paramJSONObject.optJSONArray("rect");
        localDiyBubbleTextConfig.jdField_a_of_type_ArrayOfInt = new int[4];
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localDiyBubbleTextConfig.jdField_a_of_type_ArrayOfInt[i] = DisplayUtil.a(localContext, ((JSONArray)localObject).optInt(i) / 2);
          i += 1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DiyBubbleConfig", 2, "diy text_color invalid");
        }
      }
      localDiyBubbleTextConfig.e = paramJSONObject.optInt("text_max_count");
      if (QLog.isColorLevel()) {
        QLog.d("DiyBubbleConfig", 2, "Resolve DiyBubbleTextConfig json->" + paramJSONObject);
      }
    }
    return localDiyBubbleTextConfig;
  }
  
  @TargetApi(11)
  public Rect a(VipBubbleDrawable paramVipBubbleDrawable, Canvas paramCanvas, Paint paramPaint)
  {
    float f1 = 0.0F;
    paramCanvas = paramVipBubbleDrawable.getBounds();
    Object localObject = BaseApplicationImpl.getContext().getResources();
    if (b == -1) {
      b = AIOUtils.a(48.0F, (Resources)localObject);
    }
    float f4 = 1.0F;
    float f3 = this.jdField_a_of_type_ArrayOfInt[3];
    int i;
    if (paramCanvas.height() < b)
    {
      i = AIOUtils.a(2.0F, (Resources)localObject);
      int j = AIOUtils.a(9.0F, (Resources)localObject);
      int k = AIOUtils.a(7.0F, (Resources)localObject);
      f4 = (paramCanvas.height() - k * 2) * 1.0F / (b - j * 2);
      f3 = this.jdField_a_of_type_ArrayOfInt[3] * f4;
    }
    for (;;)
    {
      float f2;
      if (this.jdField_a_of_type_JavaLangString.startsWith("T")) {
        f2 = this.jdField_a_of_type_ArrayOfInt[1] - i;
      }
      for (;;)
      {
        label162:
        float f5;
        if (this.jdField_a_of_type_JavaLangString.endsWith("L"))
        {
          f1 = this.jdField_a_of_type_ArrayOfInt[0];
          i = this.jdField_a_of_type_ArrayOfInt[2];
          if (this.d != 0) {
            paramPaint.setTextSize(f4 * this.d);
          }
          paramPaint.setAntiAlias(true);
          paramPaint.setFakeBoldText(true);
          localObject = BubbleDiyFetcher.a().a(paramVipBubbleDrawable, paramVipBubbleDrawable.jdField_a_of_type_JavaLangString);
          Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
          f4 = DiyBubbleConfig.a(paramPaint, (String)localObject);
          f5 = f2 + f3 / 2.0F - (localFontMetrics.bottom - localFontMetrics.top) / 2.0F - localFontMetrics.top;
          if (!this.jdField_c_of_type_JavaLangString.equals("center")) {
            break label403;
          }
          f2 = f1 + (i - f4) / 2.0F;
        }
        for (;;)
        {
          if (!paramVipBubbleDrawable.b) {
            break label433;
          }
          f1 = paramCanvas.width() - f2 - f4;
          return new Rect((int)f1, (int)f5, (int)(i + f1), (int)(f3 + f5));
          if (!this.jdField_a_of_type_JavaLangString.startsWith("B")) {
            break label460;
          }
          f2 = this.jdField_a_of_type_ArrayOfInt[1] + this.jdField_a_of_type_ArrayOfInt[3] + paramCanvas.height();
          f2 = i + (f2 - f3);
          break;
          if (!this.jdField_a_of_type_JavaLangString.endsWith("R")) {
            break label162;
          }
          f1 = this.jdField_a_of_type_ArrayOfInt[0] + paramCanvas.width();
          break label162;
          label403:
          f2 = f1;
          if (this.jdField_c_of_type_JavaLangString.equals("right")) {
            f2 = f1 + i - f4;
          }
        }
        label433:
        return new Rect((int)f2, (int)f5, (int)(i + f2), (int)(f3 + f5));
        label460:
        f2 = 0.0F;
      }
      i = 0;
    }
  }
  
  public void a(VipBubbleDrawable paramVipBubbleDrawable, Canvas paramCanvas)
  {
    if ((paramCanvas == null) || (paramVipBubbleDrawable == null)) {}
    String str;
    do
    {
      return;
      str = BubbleDiyFetcher.a().a(paramVipBubbleDrawable, paramVipBubbleDrawable.jdField_a_of_type_JavaLangString);
    } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)));
    Paint localPaint = new Paint();
    if (this.jdField_c_of_type_Int != -1) {
      localPaint.setColor(this.jdField_c_of_type_Int);
    }
    paramVipBubbleDrawable = a(paramVipBubbleDrawable, paramCanvas, localPaint);
    paramCanvas.drawText(str, paramVipBubbleDrawable.left, paramVipBubbleDrawable.top, localPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.DiyBubbleConfig.DiyBubbleTextConfig
 * JD-Core Version:    0.7.0.1
 */