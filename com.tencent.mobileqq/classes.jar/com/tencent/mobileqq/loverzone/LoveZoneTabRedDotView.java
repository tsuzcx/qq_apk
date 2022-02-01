package com.tencent.mobileqq.loverzone;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import avjo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.zipanimate.ZipAnimationDrawable;
import org.json.JSONObject;

public class LoveZoneTabRedDotView
  extends View
{
  public static final String a;
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int = 11;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Drawable.Callback jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback = new avjo(this);
  private ZipAnimationDrawable jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable;
  public boolean a;
  private String b = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("sweet_miniapp", "love_zone_red_dot_frame_ani", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/love_zone_setting_src/setting_me_love_zone_frame_ani.zip");
  }
  
  public LoveZoneTabRedDotView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LoveZoneTabRedDotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo != null) && (paramAppInfo.iNewFlag.get() != 0) && (paramAppInfo.buffer.has()))
    {
      paramAppInfo = paramAppInfo.buffer.get();
      try
      {
        Object localObject = new JSONObject(paramAppInfo);
        paramAppInfo = ((JSONObject)localObject).optJSONObject("param");
        localObject = ((JSONObject)localObject).optString("_show_mission");
        if ((paramAppInfo != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          paramAppInfo = (JSONObject)paramAppInfo.opt((String)localObject);
          if (paramAppInfo != null)
          {
            this.b = paramAppInfo.optString((String)localObject);
            boolean bool = TextUtils.isEmpty(this.b);
            if (!bool) {
              return true;
            }
          }
        }
      }
      catch (Exception paramAppInfo)
      {
        QLog.e("LoveZoneTabRedDotView", 1, "buffer handle exception:" + paramAppInfo);
        paramAppInfo.printStackTrace();
      }
    }
    return false;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Boolean) || (getVisibility() == 0))
    {
      this.jdField_a_of_type_Boolean = false;
      setVisibility(8);
      if (this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable != null)
      {
        this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.stop();
        this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.release();
        this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable = null;
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (getVisibility() == 0))
    {
      if (this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable == null) {
        requestLayout();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.restartAnimation();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidGraphicsRect == null) || (this.jdField_a_of_type_AndroidGraphicsPaint == null) || (TextUtils.isEmpty(this.b))) {
      return;
    }
    paramCanvas.save();
    Drawable localDrawable = getResources().getDrawable(2130845951);
    localDrawable.getBounds();
    localDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    localDrawable.draw(paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    paramCanvas.drawText(this.b, this.jdField_a_of_type_AndroidGraphicsRect.left + ViewUtils.dpToPx(25.0F), this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable == null)
    {
      this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable = new ZipAnimationDrawable();
      this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.setAnimationRes(jdField_a_of_type_JavaLangString, 18);
      this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.setRepeatAnimation(false);
      this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.setShowLastFrameWhenStop(true);
      this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.loadAndShowFirstFrame();
      this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.setCallback(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback);
      this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.start();
    }
    this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top - ViewUtils.dpToPx(2.0F) * 3, this.jdField_a_of_type_AndroidGraphicsRect.left + ViewUtils.dpToPx(25.0F), this.jdField_a_of_type_AndroidGraphicsRect.top + ViewUtils.dpToPx(25.0F) - ViewUtils.dpToPx(2.0F) * 3);
    this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (TextUtils.isEmpty(this.b)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(ViewUtils.dpToPx(11.0F));
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
    }
    int j = View.MeasureSpec.getSize(paramInt2);
    paramInt1 = (int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.b) + ViewUtils.dpToPx(6.0F) + ViewUtils.dpToPx(25.0F);
    Paint.FontMetrics localFontMetrics = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics();
    int i = (int)(localFontMetrics.bottom - localFontMetrics.top);
    j = j / 2 - i / 2 - ViewUtils.dpToPx(2.0F);
    int k = ViewUtils.dpToPx(2.0F);
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    this.jdField_a_of_type_AndroidGraphicsRect.left = 0;
    this.jdField_a_of_type_AndroidGraphicsRect.top = j;
    this.jdField_a_of_type_AndroidGraphicsRect.right = (paramInt1 + 0);
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = (i + k * 2 + j);
    this.jdField_a_of_type_Float = (j + ViewUtils.dpToPx(2.0F) - localFontMetrics.top);
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setRedDotData(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    this.jdField_a_of_type_Boolean = a(paramAppInfo);
    if (!this.jdField_a_of_type_Boolean)
    {
      a();
      setVisibility(8);
    }
    for (;;)
    {
      invalidate();
      return;
      setVisibility(0);
      requestLayout();
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loverzone.LoveZoneTabRedDotView
 * JD-Core Version:    0.7.0.1
 */