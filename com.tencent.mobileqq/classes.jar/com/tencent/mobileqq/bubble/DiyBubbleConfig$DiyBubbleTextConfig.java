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
      localDiyBubbleTextConfig.jdField_c_of_type_Int = Color.parseColor(((StringBuilder)localObject2).toString());
    }
    catch (Exception localException)
    {
      label120:
      int i;
      break label120;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DiyBubbleConfig", 2, "diy text_color invalid");
    }
    if (paramJSONObject.has("rect"))
    {
      localObject1 = paramJSONObject.optJSONArray("rect");
      localDiyBubbleTextConfig.jdField_a_of_type_ArrayOfInt = new int[4];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localDiyBubbleTextConfig.jdField_a_of_type_ArrayOfInt[i] = DisplayUtil.a(localContext, ((JSONArray)localObject1).optInt(i) / 2);
        i += 1;
      }
    }
    localDiyBubbleTextConfig.e = paramJSONObject.optInt("text_max_count");
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
    if (b == -1) {
      b = AIOUtils.b(48.0F, (Resources)localObject);
    }
    float f4 = this.jdField_a_of_type_ArrayOfInt[3];
    int i = paramCanvas.height();
    int j = b;
    float f3 = 1.0F;
    if (i < j)
    {
      i = AIOUtils.b(2.0F, (Resources)localObject);
      j = AIOUtils.b(9.0F, (Resources)localObject);
      int k = AIOUtils.b(7.0F, (Resources)localObject);
      f3 = (paramCanvas.height() - k * 2) * 1.0F / (b - j * 2);
      f4 = this.jdField_a_of_type_ArrayOfInt[3] * f3;
    }
    else
    {
      i = 0;
    }
    boolean bool = this.jdField_a_of_type_JavaLangString.startsWith("T");
    float f2 = 0.0F;
    float f1;
    if (bool)
    {
      f1 = this.jdField_a_of_type_ArrayOfInt[1] - i;
    }
    else if (this.jdField_a_of_type_JavaLangString.startsWith("B"))
    {
      f1 = this.jdField_a_of_type_ArrayOfInt[1] + this.jdField_a_of_type_ArrayOfInt[3] + paramCanvas.height();
      f1 = i + (f1 - f4);
    }
    else
    {
      f1 = 0.0F;
    }
    if (this.jdField_a_of_type_JavaLangString.endsWith("L")) {}
    for (i = this.jdField_a_of_type_ArrayOfInt[0];; i = this.jdField_a_of_type_ArrayOfInt[0] + paramCanvas.width())
    {
      f2 = i;
      break;
      if (!this.jdField_a_of_type_JavaLangString.endsWith("R")) {
        break;
      }
    }
    i = this.jdField_a_of_type_ArrayOfInt[2];
    j = this.d;
    if (j != 0) {
      paramPaint.setTextSize(j * f3);
    }
    paramPaint.setAntiAlias(true);
    paramPaint.setFakeBoldText(true);
    localObject = BubbleDiyFetcher.a().a(paramVipBubbleDrawable, paramVipBubbleDrawable.jdField_a_of_type_JavaLangString);
    Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
    float f5 = DiyBubbleConfig.a(paramPaint, (String)localObject);
    float f6 = f4 / 2.0F;
    float f7 = (localFontMetrics.bottom - localFontMetrics.top) / 2.0F;
    float f8 = localFontMetrics.top;
    if (this.jdField_c_of_type_JavaLangString.equals("center"))
    {
      f3 = f2 + (i - f5) / 2.0F;
    }
    else
    {
      f3 = f2;
      if (this.jdField_c_of_type_JavaLangString.equals("right")) {
        f3 = f2 + i - f5;
      }
    }
    return DiyBubbleConfig.a(paramVipBubbleDrawable, paramCanvas, f4, f3, f1 + f6 - f7 - f8, i, f5);
  }
  
  public void a(VipBubbleDrawable paramVipBubbleDrawable, Canvas paramCanvas)
  {
    if (paramCanvas != null)
    {
      if (paramVipBubbleDrawable == null) {
        return;
      }
      String str = BubbleDiyFetcher.a().a(paramVipBubbleDrawable, paramVipBubbleDrawable.jdField_a_of_type_JavaLangString);
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        Paint localPaint = new Paint();
        int i = this.jdField_c_of_type_Int;
        if (i != -1) {
          localPaint.setColor(i);
        }
        paramVipBubbleDrawable = a(paramVipBubbleDrawable, paramCanvas, localPaint);
        paramCanvas.drawText(str, paramVipBubbleDrawable.left, paramVipBubbleDrawable.top, localPaint);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.DiyBubbleConfig.DiyBubbleTextConfig
 * JD-Core Version:    0.7.0.1
 */