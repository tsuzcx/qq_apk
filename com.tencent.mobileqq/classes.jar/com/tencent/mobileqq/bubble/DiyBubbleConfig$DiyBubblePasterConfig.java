package com.tencent.mobileqq.bubble;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public final class DiyBubbleConfig$DiyBubblePasterConfig
  extends DiyBubbleConfig
{
  public boolean a;
  public int c;
  public String c = "";
  
  public DiyBubbleConfig$DiyBubblePasterConfig()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static DiyBubbleConfig a(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optString("type");
    if (("diy_chartlet".equalsIgnoreCase((String)localObject)) || ("static".equalsIgnoreCase((String)localObject)))
    {
      DiyBubblePasterConfig localDiyBubblePasterConfig = new DiyBubblePasterConfig();
      localDiyBubblePasterConfig.jdField_b_of_type_JavaLangString = ((String)localObject);
      localObject = BaseApplicationImpl.getApplication().getApplicationContext();
      localDiyBubblePasterConfig.jdField_a_of_type_JavaLangString = paramJSONObject.optString("align").toUpperCase();
      if (paramJSONObject.has("rect"))
      {
        JSONArray localJSONArray = paramJSONObject.optJSONArray("rect");
        localDiyBubblePasterConfig.jdField_a_of_type_ArrayOfInt = new int[4];
        int i = 0;
        while (i < localJSONArray.length())
        {
          localDiyBubblePasterConfig.jdField_a_of_type_ArrayOfInt[i] = DisplayUtil.a((Context)localObject, localJSONArray.optInt(i) / 2);
          i += 1;
        }
      }
      localDiyBubblePasterConfig.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("mirror", true);
      if (QLog.isColorLevel()) {
        QLog.d("DiyBubbleConfig", 2, "Resolve DiyBubblePasterConfig json->" + paramJSONObject);
      }
      return localDiyBubblePasterConfig;
    }
    QLog.e("DiyBubbleConfig", 1, "error! paster type: " + (String)localObject);
    return null;
  }
  
  @TargetApi(11)
  public Rect a(VipBubbleDrawable paramVipBubbleDrawable, Canvas paramCanvas)
  {
    int i1 = 0;
    paramCanvas = paramVipBubbleDrawable.getBounds();
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    if (jdField_b_of_type_Int == -1) {
      jdField_b_of_type_Int = AIOUtils.a(57.0F, localResources);
    }
    int j = this.jdField_a_of_type_ArrayOfInt[3];
    int i = this.jdField_a_of_type_ArrayOfInt[2];
    int m;
    int n;
    int k;
    if (paramCanvas.height() >= jdField_b_of_type_Int)
    {
      AIOUtils.a(10.0F, localResources);
      AIOUtils.a(9.0F, localResources);
      m = 0;
      n = 0;
      k = j;
      j = n;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaLangString.startsWith("T")) {
        n = m + this.jdField_a_of_type_ArrayOfInt[1];
      }
      for (;;)
      {
        label111:
        if (this.jdField_a_of_type_JavaLangString.endsWith("L")) {
          m = this.jdField_a_of_type_ArrayOfInt[0] + j;
        }
        for (;;)
        {
          j = m;
          if (paramVipBubbleDrawable.b)
          {
            j = m;
            if (!this.jdField_a_of_type_Boolean) {
              j = paramCanvas.width() - m - i;
            }
          }
          return new Rect(j, n, i + j, k + n);
          n = AIOUtils.a(10.0F, localResources);
          m = AIOUtils.a(7.0F, localResources);
          if ("static".equalsIgnoreCase(this.jdField_b_of_type_JavaLangString))
          {
            m = -AIOUtils.a(2.0F, localResources);
            k = j;
            j = 0;
            break;
          }
          k = j;
          if (j <= m * 2) {
            break label407;
          }
          m *= 2;
          j = this.jdField_a_of_type_ArrayOfInt[2] * m / this.jdField_a_of_type_ArrayOfInt[3];
          i = j;
          k = m;
          if (j >= n * 2) {
            break label407;
          }
          int i2 = j / 2;
          k = m;
          i = j;
          j = n - i2;
          m = 0;
          break;
          if (!this.jdField_a_of_type_JavaLangString.startsWith("B")) {
            break label401;
          }
          n = this.jdField_a_of_type_ArrayOfInt[1] + this.jdField_a_of_type_ArrayOfInt[3] + paramCanvas.height() - k - m;
          break label111;
          m = i1;
          if (this.jdField_a_of_type_JavaLangString.endsWith("R")) {
            m = this.jdField_a_of_type_ArrayOfInt[0] + this.jdField_a_of_type_ArrayOfInt[2] + paramCanvas.width() - i - j;
          }
        }
        label401:
        n = 0;
      }
      label407:
      m = 0;
      j = 0;
    }
  }
  
  public void a(VipBubbleDrawable paramVipBubbleDrawable, Canvas paramCanvas)
  {
    if ((paramCanvas == null) || (paramVipBubbleDrawable == null)) {
      return;
    }
    Bitmap localBitmap = null;
    label34:
    int i;
    Paint localPaint;
    if ("diy_chartlet".equalsIgnoreCase(this.jdField_b_of_type_JavaLangString))
    {
      localBitmap = BubbleDiyFetcher.a().b(paramVipBubbleDrawable, this);
      if (localBitmap == null) {
        break label211;
      }
      i = paramCanvas.save();
      if ((paramVipBubbleDrawable.b) && (this.jdField_a_of_type_Boolean)) {
        paramCanvas.scale(-1.0F, 1.0F, paramVipBubbleDrawable.getBounds().centerX(), paramVipBubbleDrawable.getBounds().centerY());
      }
      localPaint = new Paint();
      paramVipBubbleDrawable = a(paramVipBubbleDrawable, paramCanvas);
      if (paramCanvas.getHeight() >= jdField_b_of_type_Int) {
        break label213;
      }
      localBitmap = Bitmap.createScaledBitmap(localBitmap, paramVipBubbleDrawable.width(), paramVipBubbleDrawable.height(), true);
      if (QLog.isColorLevel()) {
        QLog.i("DiyBubbleConfig", 2, String.format("canvas draw scale bitmap, width %d, height %d", new Object[] { Integer.valueOf(paramVipBubbleDrawable.width()), Integer.valueOf(paramVipBubbleDrawable.height()) }));
      }
      paramCanvas.drawBitmap(localBitmap, paramVipBubbleDrawable.left, paramVipBubbleDrawable.top, localPaint);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(i);
      return;
      if (!"static".equalsIgnoreCase(this.jdField_b_of_type_JavaLangString)) {
        break label34;
      }
      localBitmap = BubbleDiyFetcher.a().a(paramVipBubbleDrawable, this);
      break label34;
      label211:
      break;
      label213:
      paramCanvas.drawBitmap(localBitmap, paramVipBubbleDrawable.left, paramVipBubbleDrawable.top, localPaint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.DiyBubbleConfig.DiyBubblePasterConfig
 * JD-Core Version:    0.7.0.1
 */