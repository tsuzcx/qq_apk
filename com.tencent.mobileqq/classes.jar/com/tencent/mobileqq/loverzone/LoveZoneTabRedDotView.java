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
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import common.config.service.QzoneConfig;
import org.json.JSONObject;

public class LoveZoneTabRedDotView
  extends View
{
  public static final String a;
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int = 11;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Drawable.Callback jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback = new LoveZoneTabRedDotView.1(this);
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public boolean a;
  private String b = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("sweet_miniapp", "love_zone_red_dot_frame_ani", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/love_zone_setting_src/setting_me_love_zone_frame_ani.zip");
  }
  
  public LoveZoneTabRedDotView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public LoveZoneTabRedDotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private boolean a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo != null) && (paramAppInfo.iNewFlag.get() != 0) && (paramAppInfo.buffer.has()))
    {
      paramAppInfo = paramAppInfo.buffer.get();
      try
      {
        localObject = new JSONObject(paramAppInfo);
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
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("buffer handle exception:");
        ((StringBuilder)localObject).append(paramAppInfo);
        QLog.e("LoveZoneTabRedDotView", 1, ((StringBuilder)localObject).toString());
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
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).stop(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).release(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (getVisibility() == 0))
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        requestLayout();
        return;
      }
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).restartAnimation(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsRect != null) && (this.jdField_a_of_type_AndroidGraphicsPaint != null))
    {
      if (TextUtils.isEmpty(this.b)) {
        return;
      }
      paramCanvas.save();
      Drawable localDrawable = getResources().getDrawable(2130846232);
      localDrawable.getBounds();
      localDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
      localDrawable.draw(paramCanvas);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      paramCanvas.drawText(this.b, this.jdField_a_of_type_AndroidGraphicsRect.left + ViewUtils.b(25.0F), this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
        ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, jdField_a_of_type_JavaLangString, 18);
        ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, false);
        ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, true);
        ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).loadAndShowFirstFrame(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback);
        ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).start(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top - ViewUtils.b(2.0F) * 3, this.jdField_a_of_type_AndroidGraphicsRect.left + ViewUtils.b(25.0F), this.jdField_a_of_type_AndroidGraphicsRect.top + ViewUtils.b(25.0F) - ViewUtils.b(2.0F) * 3);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
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
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(ViewUtils.b(11.0F));
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
    }
    int j = View.MeasureSpec.getSize(paramInt2);
    paramInt1 = (int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.b) + ViewUtils.b(6.0F) + ViewUtils.b(25.0F);
    Paint.FontMetrics localFontMetrics = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics();
    int i = (int)(localFontMetrics.bottom - localFontMetrics.top);
    j = j / 2 - i / 2 - ViewUtils.b(2.0F);
    int k = ViewUtils.b(2.0F);
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    localRect.left = 0;
    localRect.top = j;
    localRect.right = (paramInt1 + 0);
    localRect.bottom = (i + k * 2 + j);
    this.jdField_a_of_type_Float = (j + ViewUtils.b(2.0F) - localFontMetrics.top);
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
    else
    {
      setVisibility(0);
      requestLayout();
      b();
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loverzone.LoveZoneTabRedDotView
 * JD-Core Version:    0.7.0.1
 */