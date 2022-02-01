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
  public static final String a = QzoneConfig.getInstance().getConfig("sweet_miniapp", "love_zone_red_dot_frame_ani", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/love_zone_setting_src/setting_me_love_zone_frame_ani.zip");
  public boolean b = false;
  private String c = "";
  private final int d = 11;
  private Drawable e;
  private Paint f;
  private Rect g;
  private float h;
  private Drawable.Callback i = new LoveZoneTabRedDotView.1(this);
  
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
        localObject = new JSONObject(paramAppInfo);
        paramAppInfo = ((JSONObject)localObject).optJSONObject("param");
        localObject = ((JSONObject)localObject).optString("_show_mission");
        if ((paramAppInfo != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          paramAppInfo = (JSONObject)paramAppInfo.opt((String)localObject);
          if (paramAppInfo != null)
          {
            this.c = paramAppInfo.optString((String)localObject);
            boolean bool = TextUtils.isEmpty(this.c);
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
    if ((this.b) || (getVisibility() == 0))
    {
      this.b = false;
      setVisibility(8);
      if (this.e != null)
      {
        ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).stop(this.e);
        ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).release(this.e);
        this.e = null;
      }
    }
  }
  
  public void b()
  {
    if ((this.b) && (getVisibility() == 0))
    {
      if (this.e == null)
      {
        requestLayout();
        return;
      }
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).restartAnimation(this.e);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.b) && (this.g != null) && (this.f != null))
    {
      if (TextUtils.isEmpty(this.c)) {
        return;
      }
      paramCanvas.save();
      Drawable localDrawable = getResources().getDrawable(2130847702);
      localDrawable.getBounds();
      localDrawable.setBounds(this.g.left, this.g.top, this.g.right, this.g.bottom);
      localDrawable.draw(paramCanvas);
      this.f.setColor(-1);
      paramCanvas.drawText(this.c, this.g.left + ViewUtils.dpToPx(25.0F), this.h, this.f);
      if (this.e == null)
      {
        this.e = ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
        ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(this.e, a, 18);
        ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(this.e, false);
        ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(this.e, true);
        ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).loadAndShowFirstFrame(this.e);
        this.e.setCallback(this.i);
        ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).start(this.e);
      }
      this.e.setBounds(this.g.left, this.g.top - ViewUtils.dpToPx(2.0F) * 3, this.g.left + ViewUtils.dpToPx(25.0F), this.g.top + ViewUtils.dpToPx(25.0F) - ViewUtils.dpToPx(2.0F) * 3);
      this.e.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (TextUtils.isEmpty(this.c)) {
      return;
    }
    if (this.f == null)
    {
      this.f = new Paint(1);
      this.f.setTextSize(ViewUtils.dpToPx(11.0F));
      this.f.setTextAlign(Paint.Align.LEFT);
    }
    int k = View.MeasureSpec.getSize(paramInt2);
    paramInt1 = (int)this.f.measureText(this.c) + ViewUtils.dpToPx(6.0F) + ViewUtils.dpToPx(25.0F);
    Paint.FontMetrics localFontMetrics = this.f.getFontMetrics();
    int j = (int)(localFontMetrics.bottom - localFontMetrics.top);
    k = k / 2 - j / 2 - ViewUtils.dpToPx(2.0F);
    int m = ViewUtils.dpToPx(2.0F);
    if (this.g == null) {
      this.g = new Rect();
    }
    Rect localRect = this.g;
    localRect.left = 0;
    localRect.top = k;
    localRect.right = (paramInt1 + 0);
    localRect.bottom = (j + m * 2 + k);
    this.h = (k + ViewUtils.dpToPx(2.0F) - localFontMetrics.top);
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setRedDotData(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    this.b = a(paramAppInfo);
    if (!this.b)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loverzone.LoveZoneTabRedDotView
 * JD-Core Version:    0.7.0.1
 */