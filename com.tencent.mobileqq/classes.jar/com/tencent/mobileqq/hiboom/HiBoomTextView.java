package com.tencent.mobileqq.hiboom;

import adxr;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.etrump.mixlayout.EMEmoticon;
import com.etrump.mixlayout.ETEngine;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nonnull;

public class HiBoomTextView
  extends ImageView
{
  public int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new adxr(this));
  protected EMEmoticon a;
  public HiBoomFont.HiBoomFontDownloader a;
  private HiBoomFontDrawer jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer;
  public HiBoomTextView.OnDoubleClick a;
  private String jdField_a_of_type_JavaLangString;
  public int b;
  private String b;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int d;
  private int e;
  
  public HiBoomTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    setImageResource(2130838599);
    setScaleType(ImageView.ScaleType.CENTER);
  }
  
  public HiBoomTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    setImageResource(2130838599);
    setScaleType(ImageView.ScaleType.CENTER);
  }
  
  public HiBoomTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    setImageResource(2130838599);
    setScaleType(ImageView.ScaleType.CENTER);
  }
  
  public void a()
  {
    if ((a()) && (HiBoomFont.a().a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader).jdField_a_of_type_Int == 1))
    {
      if (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon == null) {
        this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon = new EMEmoticon(ETEngine.getInstanceForHiBoom(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a() + this.jdField_a_of_type_Int + File.separator + ".hy", getMeasuredWidth());
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.a(this.jdField_a_of_type_JavaLangString, 0);
    }
    requestLayout();
    invalidate();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int < 0) || (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader == null)) {
      return false;
    }
    return HiBoomFont.a().a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int < 0) || (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader == null)) {
      return false;
    }
    return HiBoomFont.a().a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader).c.get();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject;
    int i;
    int j;
    if (!a()) {
      if (b())
      {
        if ((getDrawable() instanceof AnimationDrawable)) {
          ((AnimationDrawable)getDrawable()).stop();
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
        paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight()), ScreenUtil.a(4.0F), ScreenUtil.a(4.0F), this.jdField_a_of_type_AndroidGraphicsPaint);
        localObject = new TextPaint();
        ((TextPaint)localObject).setColor(-7829368);
        ((TextPaint)localObject).setTextSize(ViewUtils.a(16.0F));
        localObject = new StaticLayout("字体下载失败，请点击重试", (TextPaint)localObject, getMeasuredWidth(), Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
        i = ((StaticLayout)localObject).getWidth();
        j = ((StaticLayout)localObject).getHeight();
        paramCanvas.translate((getMeasuredWidth() - i) / 2, (getMeasuredHeight() - j) / 2);
        ((StaticLayout)localObject).draw(paramCanvas);
      }
    }
    do
    {
      for (;;)
      {
        return;
        if ((getDrawable() instanceof AnimationDrawable)) {
          ((AnimationDrawable)getDrawable()).start();
        }
        super.onDraw(paramCanvas);
        return;
        if ((getDrawable() instanceof AnimationDrawable)) {
          ((AnimationDrawable)getDrawable()).stop();
        }
        if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.startsWith("#")) && (this.jdField_b_of_type_JavaLangString.length() == 9))
        {
          this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor(this.jdField_b_of_type_JavaLangString));
          paramCanvas.drawRoundRect(new RectF(1.0F, 1.0F, getMeasuredWidth() - 1, getMeasuredHeight() - 1), ScreenUtil.a(4.0F), ScreenUtil.a(4.0F), this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_c_of_type_JavaLangString.startsWith("#")) && (this.jdField_c_of_type_JavaLangString.length() == 9))
        {
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor(this.jdField_c_of_type_JavaLangString));
          this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
          this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
          paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight()), ScreenUtil.a(4.0F), ScreenUtil.a(4.0F), this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        localObject = HiBoomFont.a().a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader);
        i = (getMeasuredWidth() - this.d) / 2;
        j = (getMeasuredHeight() - this.e) / 2;
        if ((i > 0) || (j > 0)) {
          paramCanvas.translate(i, j);
        }
        if (((HiBoomFontDrawer)localObject).jdField_a_of_type_Int == 2) {
          try
          {
            if (((HiBoomFontDrawer)localObject).a(this.jdField_a_of_type_JavaLangString.length()))
            {
              i = Math.max(getMeasuredHeight(), getMeasuredWidth());
              ((HiBoomFontDrawer)localObject).a(this.jdField_a_of_type_JavaLangString, i, paramCanvas);
              return;
            }
          }
          catch (Exception paramCanvas)
          {
            paramCanvas.printStackTrace();
            return;
          }
        }
      }
    } while ((((HiBoomFontDrawer)localObject).jdField_a_of_type_Int != 1) || (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon == null));
    paramCanvas.drawBitmap(this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.a(0), 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 500;
    int m = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (!a()) {
      if (m == 1073741824)
      {
        paramInt1 = i;
        this.d = paramInt1;
        paramInt1 = j;
        if (k == 1073741824) {
          paramInt1 = paramInt2;
        }
        this.e = paramInt1;
        label68:
        break label166;
      }
    }
    Object localObject;
    label166:
    do
    {
      for (;;)
      {
        if (m != 1073741824) {
          i = this.d;
        }
        if (k != 1073741824) {
          paramInt2 = this.e;
        }
        setMeasuredDimension(i, paramInt2);
        return;
        paramInt1 = 500;
        break;
        localObject = HiBoomFont.a().a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader);
        if (((HiBoomFontDrawer)localObject).jdField_a_of_type_Int != 2) {
          break label417;
        }
        if (((HiBoomFontDrawer)localObject).jdField_a_of_type_ComTencentMobileqqHiboomHiBoomInfo.a != null)
        {
          localObject = ((HiBoomFontDrawer)localObject).jdField_a_of_type_ComTencentMobileqqHiboomHiBoomInfo.a.iterator();
          if (((Iterator)localObject).hasNext())
          {
            HiBoomInfo.HiBoomInfoStyle localHiBoomInfoStyle = (HiBoomInfo.HiBoomInfoStyle)((Iterator)localObject).next();
            if (this.jdField_a_of_type_JavaLangString.length() != localHiBoomInfoStyle.jdField_a_of_type_Int) {
              break label68;
            }
            paramInt1 = localHiBoomInfoStyle.jdField_a_of_type_ArrayOfInt[0];
            j = localHiBoomInfoStyle.jdField_a_of_type_ArrayOfInt[1];
            double d1 = paramInt1 / j;
            if ((m == 1073741824) && (k == 1073741824))
            {
              if (i / paramInt2 > d1)
              {
                this.d = ((int)(d1 * paramInt2));
                this.e = paramInt2;
              }
              else
              {
                this.e = ((int)(i / d1));
                this.d = i;
              }
            }
            else if (m == 1073741824)
            {
              this.d = i;
              this.e = ((int)(i / d1));
            }
            else if (k == 1073741824)
            {
              this.e = paramInt2;
              this.d = ((int)(d1 * paramInt2));
            }
            else if (this.jdField_c_of_type_Int > 0)
            {
              if (paramInt1 > j)
              {
                this.e = (j * this.jdField_c_of_type_Int / paramInt1);
                this.d = this.jdField_c_of_type_Int;
              }
              else
              {
                this.d = (paramInt1 * this.jdField_c_of_type_Int / j);
                this.e = this.jdField_c_of_type_Int;
              }
            }
            else
            {
              this.d = paramInt1;
              this.e = j;
            }
          }
        }
      }
    } while ((((HiBoomFontDrawer)localObject).jdField_a_of_type_Int != 1) || (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon == null));
    label417:
    if ((m == 1073741824) && (k == 1073741824)) {
      paramInt1 = Math.min(i, paramInt2);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.a(paramInt1);
      this.d = this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.a();
      this.e = this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.b();
      break;
      if (m == 1073741824)
      {
        paramInt1 = i;
      }
      else if (k == 1073741824)
      {
        paramInt1 = paramInt2;
      }
      else
      {
        paramInt1 = j;
        if (this.jdField_c_of_type_Int > 0) {
          paramInt1 = this.jdField_c_of_type_Int;
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    if (b())
    {
      HiBoomFont.a().a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader).a(true);
      invalidate();
      return true;
    }
    return super.performClick();
  }
  
  public void setBGStrokeColor(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void setBackgroundColor(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setHiBoom(int paramInt1, int paramInt2, @Nonnull HiBoomFont.HiBoomFontDownloader paramHiBoomFontDownloader)
  {
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader = paramHiBoomFontDownloader;
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer = HiBoomFont.a().a(paramInt1, paramInt2, paramHiBoomFontDownloader);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.a(this);
    if (this.jdField_a_of_type_Int != paramInt1)
    {
      this.jdField_a_of_type_Int = paramInt1;
      if (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.jdField_a_of_type_Int == 1)
      {
        paramHiBoomFontDownloader = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a() + this.jdField_a_of_type_Int + File.separator + ".hy";
        if (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon == null) {
          this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon = new EMEmoticon(ETEngine.getInstanceForHiBoom(), this.jdField_a_of_type_Int, paramHiBoomFontDownloader, getMeasuredWidth());
        }
        this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.a(this.jdField_a_of_type_Int, paramHiBoomFontDownloader, getMeasuredWidth());
      }
      requestLayout();
      invalidate();
    }
  }
  
  public void setMaxSize(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    requestLayout();
    invalidate();
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangString = paramCharSequence.toString();
    if (a()) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomTextView
 * JD-Core Version:    0.7.0.1
 */