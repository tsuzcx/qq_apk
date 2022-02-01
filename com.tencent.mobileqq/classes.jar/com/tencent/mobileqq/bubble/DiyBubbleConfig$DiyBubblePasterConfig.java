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
  public String c;
  
  public DiyBubbleConfig$DiyBubblePasterConfig()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  private int a(VipBubbleDrawable paramVipBubbleDrawable, Rect paramRect, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_JavaLangString.endsWith("L")) {
      paramInt3 = this.jdField_a_of_type_ArrayOfInt[0] + paramInt2;
    } else if (this.jdField_a_of_type_JavaLangString.endsWith("R")) {
      paramInt3 = this.jdField_a_of_type_ArrayOfInt[0] + this.jdField_a_of_type_ArrayOfInt[2] + paramRect.width() - paramInt1 - paramInt2;
    }
    paramInt2 = paramInt3;
    if (paramVipBubbleDrawable.b)
    {
      paramInt2 = paramInt3;
      if (!this.jdField_a_of_type_Boolean) {
        paramInt2 = paramRect.width() - paramInt3 - paramInt1;
      }
    }
    return paramInt2;
  }
  
  public static DiyBubbleConfig a(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optString("type");
    if ((!"diy_chartlet".equalsIgnoreCase((String)localObject)) && (!"static".equalsIgnoreCase((String)localObject)))
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("error! paster type: ");
      paramJSONObject.append((String)localObject);
      QLog.e("DiyBubbleConfig", 1, paramJSONObject.toString());
      return null;
    }
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Resolve DiyBubblePasterConfig json->");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.d("DiyBubbleConfig", 2, ((StringBuilder)localObject).toString());
    }
    return localDiyBubblePasterConfig;
  }
  
  @TargetApi(11)
  public Rect a(VipBubbleDrawable paramVipBubbleDrawable, Canvas paramCanvas)
  {
    paramCanvas = paramVipBubbleDrawable.getBounds();
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    if (jdField_b_of_type_Int == -1) {
      jdField_b_of_type_Int = AIOUtils.b(48.0F, localResources);
    }
    int j = this.jdField_a_of_type_ArrayOfInt[3];
    int i = this.jdField_a_of_type_ArrayOfInt[2];
    int k = paramCanvas.height();
    int m = jdField_b_of_type_Int;
    int i1 = 0;
    if (k >= m)
    {
      AIOUtils.b(10.0F, localResources);
      AIOUtils.b(9.0F, localResources);
    }
    else
    {
      m = AIOUtils.b(10.0F, localResources);
      k = AIOUtils.b(7.0F, localResources);
      if ("static".equalsIgnoreCase(this.jdField_b_of_type_JavaLangString))
      {
        m = -AIOUtils.b(2.0F, localResources);
        k = i;
        i = j;
        j = k;
        k = m;
        break label226;
      }
      k *= 2;
      if (j > k)
      {
        i = this.jdField_a_of_type_ArrayOfInt[2] * k / this.jdField_a_of_type_ArrayOfInt[3];
        if (i < m * 2)
        {
          n = i / 2;
          j = k;
          k = i;
          m -= n;
          n = 0;
          break label240;
        }
        j = i;
        i = k;
        break label223;
      }
    }
    k = j;
    j = i;
    i = k;
    label223:
    k = 0;
    label226:
    m = 0;
    int n = k;
    k = j;
    j = i;
    label240:
    if (this.jdField_a_of_type_JavaLangString.startsWith("T"))
    {
      i = this.jdField_a_of_type_ArrayOfInt[1] + n;
    }
    else
    {
      i = i1;
      if (this.jdField_a_of_type_JavaLangString.startsWith("B")) {
        i = this.jdField_a_of_type_ArrayOfInt[1] + this.jdField_a_of_type_ArrayOfInt[3] + paramCanvas.height() - j - n;
      }
    }
    m = a(paramVipBubbleDrawable, paramCanvas, k, m, 0);
    return new Rect(m, i, k + m, j + i);
  }
  
  public void a(VipBubbleDrawable paramVipBubbleDrawable, Canvas paramCanvas)
  {
    if (paramCanvas != null)
    {
      if (paramVipBubbleDrawable == null) {
        return;
      }
      Bitmap localBitmap;
      if ("diy_chartlet".equalsIgnoreCase(this.jdField_b_of_type_JavaLangString)) {
        localBitmap = BubbleDiyFetcher.a().b(paramVipBubbleDrawable, this);
      } else if ("static".equalsIgnoreCase(this.jdField_b_of_type_JavaLangString)) {
        localBitmap = BubbleDiyFetcher.a().a(paramVipBubbleDrawable, this);
      } else {
        localBitmap = null;
      }
      if (localBitmap == null) {
        return;
      }
      int i = paramCanvas.save();
      if ((paramVipBubbleDrawable.b) && (this.jdField_a_of_type_Boolean)) {
        paramCanvas.scale(-1.0F, 1.0F, paramVipBubbleDrawable.getBounds().centerX(), paramVipBubbleDrawable.getBounds().centerY());
      }
      Paint localPaint = new Paint();
      paramVipBubbleDrawable = a(paramVipBubbleDrawable, paramCanvas);
      if (paramCanvas.getHeight() < jdField_b_of_type_Int) {
        paramCanvas.drawBitmap(localBitmap, null, paramVipBubbleDrawable, localPaint);
      } else {
        paramCanvas.drawBitmap(localBitmap, paramVipBubbleDrawable.left, paramVipBubbleDrawable.top, localPaint);
      }
      paramCanvas.restoreToCount(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.DiyBubbleConfig.DiyBubblePasterConfig
 * JD-Core Version:    0.7.0.1
 */