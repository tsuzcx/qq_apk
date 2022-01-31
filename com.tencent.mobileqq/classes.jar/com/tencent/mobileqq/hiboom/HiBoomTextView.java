package com.tencent.mobileqq.hiboom;

import adpj;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.etrump.mixlayout.EMEmoticon;
import com.etrump.mixlayout.ETEngine;
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
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new adpj(this));
  protected EMEmoticon a;
  public HiBoomFont.HiBoomFontDownloader a;
  private HiBoomFontDrawer jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer;
  public HiBoomTextView.OnDoubleClick a;
  private String jdField_a_of_type_JavaLangString;
  public int b = -1;
  private int c;
  
  public HiBoomTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    setImageResource(2130838593);
    setScaleType(ImageView.ScaleType.CENTER);
  }
  
  public HiBoomTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    setImageResource(2130838593);
    setScaleType(ImageView.ScaleType.CENTER);
  }
  
  public HiBoomTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    setImageResource(2130838593);
    setScaleType(ImageView.ScaleType.CENTER);
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.b < 0) || (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader == null)) {
      return false;
    }
    return HiBoomFont.a().a(this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void a()
  {
    if (HiBoomFont.a().a(this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader).jdField_a_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon == null) {
        this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon = new EMEmoticon(ETEngine.getInstanceForHiBoom(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a() + this.jdField_a_of_type_Int + File.separator + ".hy", getMeasuredWidth());
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.a(this.jdField_a_of_type_JavaLangString, 0);
    }
    requestLayout();
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!a())
    {
      if ((getDrawable() instanceof AnimationDrawable)) {
        ((AnimationDrawable)getDrawable()).start();
      }
      super.onDraw(paramCanvas);
    }
    HiBoomFontDrawer localHiBoomFontDrawer;
    do
    {
      for (;;)
      {
        return;
        if ((getDrawable() instanceof AnimationDrawable)) {
          ((AnimationDrawable)getDrawable()).stop();
        }
        localHiBoomFontDrawer = HiBoomFont.a().a(this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader);
        if (localHiBoomFontDrawer.jdField_a_of_type_Int == 2) {
          try
          {
            if (localHiBoomFontDrawer.a(this.jdField_a_of_type_JavaLangString.length()))
            {
              System.currentTimeMillis();
              int i = Math.max(getMeasuredHeight(), getMeasuredWidth());
              localHiBoomFontDrawer.a(this.jdField_a_of_type_JavaLangString.toString(), i, paramCanvas);
              System.currentTimeMillis();
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
    } while ((localHiBoomFontDrawer.jdField_a_of_type_Int != 1) || (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon == null));
    paramCanvas.drawBitmap(this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.a(0), 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int k = 500;
    int i1 = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int i;
    int j;
    if (!a()) {
      if (i1 == 1073741824)
      {
        i = k;
        if (n == 1073741824) {
          i = paramInt2;
        }
        j = paramInt1;
      }
    }
    do
    {
      setMeasuredDimension(j, i);
      return;
      paramInt1 = 500;
      break;
      localObject = HiBoomFont.a().a(this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader);
      if (((HiBoomFontDrawer)localObject).jdField_a_of_type_Int != 2) {
        break label271;
      }
      i = paramInt2;
      j = paramInt1;
    } while (((HiBoomFontDrawer)localObject).jdField_a_of_type_ComTencentMobileqqHiboomHiBoomInfo.a == null);
    Object localObject = ((HiBoomFontDrawer)localObject).jdField_a_of_type_ComTencentMobileqqHiboomHiBoomInfo.a.iterator();
    int m;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        HiBoomInfo.HiBoomInfoStyle localHiBoomInfoStyle = (HiBoomInfo.HiBoomInfoStyle)((Iterator)localObject).next();
        if (this.jdField_a_of_type_JavaLangString.length() == localHiBoomInfoStyle.jdField_a_of_type_Int)
        {
          k = localHiBoomInfoStyle.jdField_a_of_type_ArrayOfInt[0];
          m = localHiBoomInfoStyle.jdField_a_of_type_ArrayOfInt[1];
          i = m;
          j = k;
          if (this.c > 0)
          {
            if (k > m)
            {
              i = m * this.c / k;
              j = this.c;
            }
          }
          else
          {
            label224:
            if (i1 != 1073741824) {
              paramInt1 = j;
            }
            if (n != 1073741824) {
              paramInt2 = i;
            }
          }
        }
      }
    }
    for (;;)
    {
      i = paramInt2;
      j = paramInt1;
      break;
      j = k * this.c / m;
      i = this.c;
      break label224;
      label271:
      i = paramInt2;
      j = paramInt1;
      if (((HiBoomFontDrawer)localObject).jdField_a_of_type_Int != 1) {
        break;
      }
      i = paramInt2;
      j = paramInt1;
      if (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon == null) {
        break;
      }
      i = k;
      if (this.c > 0) {
        i = this.c;
      }
      localObject = this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon;
      if (i1 == 1073741824) {
        i = paramInt1;
      }
      ((EMEmoticon)localObject).a(i);
      if (i1 != 1073741824) {
        paramInt1 = this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.a();
      }
      i = paramInt2;
      j = paramInt1;
      if (n == 1073741824) {
        break;
      }
      i = this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.b();
      j = paramInt1;
      break;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setHiBoom(int paramInt1, int paramInt2, @Nonnull HiBoomFont.HiBoomFontDownloader paramHiBoomFontDownloader)
  {
    this.b = paramInt2;
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
    this.c = paramInt;
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