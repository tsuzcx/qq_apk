package com.tencent.mobileqq.emoticonview;

import afxj;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import aruy;
import aruz;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class StickerGrayTipLayout
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  public aruz a;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private ArrayList<aruy> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public StickerGrayTipLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public StickerGrayTipLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StickerGrayTipLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        aruy localaruy = (aruy)localIterator.next();
        int j = localaruy.jdField_a_of_type_Int;
        int k = this.jdField_a_of_type_Int;
        int m = (int)((localaruy.jdField_a_of_type_Float - 1.0F) * localaruy.c);
        int i = (int)((localaruy.jdField_a_of_type_Float - 1.0F) * localaruy.d);
        j = j + k + localaruy.e - m / 2;
        i = localaruy.b - i / 2;
        if ((paramFloat1 > j) && (paramFloat1 < j + localaruy.jdField_a_of_type_Float * localaruy.c) && (paramFloat2 > i))
        {
          float f1 = i;
          float f2 = localaruy.jdField_a_of_type_Float;
          if (paramFloat2 < localaruy.d * f2 + f1) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if (paramMotionEvent2.getEventTime() - paramMotionEvent1.getEventTime() > 200L) {}
    int i;
    int j;
    do
    {
      return false;
      i = (int)paramMotionEvent1.getX() - (int)paramMotionEvent2.getX();
      j = (int)paramMotionEvent1.getY() - (int)paramMotionEvent2.getY();
    } while (i * i + j * j >= 10000);
    return true;
  }
  
  private void c()
  {
    boolean bool;
    aruy localaruy;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      bool = false;
      if (localIterator.hasNext())
      {
        localaruy = (aruy)localIterator.next();
        if (localaruy.jdField_a_of_type_Int + this.jdField_a_of_type_Int + localaruy.c / 2 < getMeasuredWidth() / 2) {
          if (Math.abs(localaruy.e) > 200)
          {
            localaruy.e -= EmojiStickerManager.i;
            localaruy.f -= Math.abs(EmojiStickerManager.i / 2);
            localaruy.f = Math.min(255, Math.max(0, localaruy.f));
            label138:
            if (localaruy.e > 0)
            {
              localaruy.e = 0;
              localaruy.f = 255;
              this.jdField_a_of_type_Boolean = false;
              bool = false;
            }
            label164:
            if (localaruy.e < -400)
            {
              localaruy.e = -400;
              localaruy.f = 0;
              this.jdField_a_of_type_Boolean = false;
              bool = true;
            }
            if (localaruy.e <= 400) {
              break label434;
            }
            localaruy.e = 400;
            localaruy.f = 0;
            this.jdField_a_of_type_Boolean = false;
            bool = true;
          }
        }
      }
    }
    label412:
    label434:
    for (;;)
    {
      break;
      localaruy.f += Math.abs(EmojiStickerManager.i / 2);
      localaruy.f = Math.min(255, Math.max(0, localaruy.f));
      localaruy.e += EmojiStickerManager.i;
      break label138;
      if (Math.abs(localaruy.e) < 200)
      {
        localaruy.f += Math.abs(EmojiStickerManager.i / 2);
        localaruy.f = Math.min(255, Math.max(0, localaruy.f));
      }
      for (localaruy.e -= EmojiStickerManager.i;; localaruy.e += EmojiStickerManager.i)
      {
        if (localaruy.e >= 0) {
          break label412;
        }
        localaruy.e = 0;
        localaruy.f = 255;
        this.jdField_a_of_type_Boolean = false;
        bool = false;
        break;
        localaruy.f -= Math.abs(EmojiStickerManager.i / 2);
        localaruy.f = Math.min(255, Math.max(0, localaruy.f));
      }
      break label164;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.stickerHidden = bool;
      }
      invalidate();
      return;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        aruy localaruy = (aruy)localIterator.next();
        localaruy.b += paramInt;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      int i;
      label45:
      aruy localaruy;
      int j;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.stickerHidden))
      {
        i = 1;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break label447;
        }
        localaruy = (aruy)localIterator.next();
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (i != 0))
        {
          if (localaruy.jdField_a_of_type_Int + this.jdField_a_of_type_Int + localaruy.c / 2 >= getMeasuredWidth() / 2) {
            break label279;
          }
          j = -400;
          label110:
          localaruy.e = j;
          localaruy.f = 0;
        }
        if ((paramInt2 != EmojiStickerManager.h) || (localaruy.e != 0))
        {
          if (paramInt2 != EmojiStickerManager.g) {
            break label302;
          }
          if (localaruy.jdField_a_of_type_Int + this.jdField_a_of_type_Int + localaruy.c / 2 >= getMeasuredWidth() / 2) {
            break label287;
          }
          localaruy.e -= paramInt1;
          localaruy.f -= Math.abs(paramInt1 / 2);
          localaruy.f = Math.min(255, Math.max(0, localaruy.f));
        }
      }
      label279:
      label287:
      label302:
      while (paramInt2 != EmojiStickerManager.h) {
        for (;;)
        {
          if (localaruy.e < -400)
          {
            localaruy.e = -400;
            localaruy.f = 0;
          }
          if (localaruy.e <= 400) {
            break label45;
          }
          localaruy.e = 400;
          localaruy.f = 0;
          break label45;
          i = 0;
          break;
          j = 400;
          break label110;
          localaruy.e += paramInt1;
        }
      }
      if (localaruy.jdField_a_of_type_Int + this.jdField_a_of_type_Int + localaruy.c / 2 < getMeasuredWidth() / 2)
      {
        localaruy.e += paramInt1;
        if (localaruy.e > 0)
        {
          localaruy.e = 0;
          localaruy.f = 255;
        }
      }
      for (;;)
      {
        localaruy.f += Math.abs(paramInt1 / 2);
        localaruy.f = Math.min(255, Math.max(0, localaruy.f));
        break;
        localaruy.e -= paramInt1;
        if (localaruy.e < 0)
        {
          localaruy.e = 0;
          localaruy.f = 255;
        }
      }
      label447:
      if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.stickerHidden = false;
      }
      invalidate();
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0);
  }
  
  public boolean a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < EmojiStickerManager.f)
    {
      aruy localaruy = new aruy();
      if (paramDrawable != null)
      {
        localaruy.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable.mutate();
        paramDrawable.setCallback(this);
      }
      localaruy.jdField_a_of_type_Int = paramInt1;
      localaruy.b = paramInt2;
      localaruy.c = paramInt3;
      localaruy.d = paramInt4;
      localaruy.jdField_a_of_type_Double = paramDouble;
      localaruy.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilArrayList.add(localaruy);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    invalidate();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    Object localObject = getParent();
    if (((localObject instanceof ViewGroup)) && ((((ViewGroup)localObject).getTag() instanceof afxj))) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((afxj)((ViewGroup)localObject).getTag()).a;
    }
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      localObject = getChildAt(i);
      if (((View)localObject).getId() == 2131367600) {
        this.jdField_a_of_type_Int = ((View)localObject).getLeft();
      }
      i -= 1;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      i = 0;
      if (i <= this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
      {
        localObject = (aruy)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.stickerHidden)) {
          if (((aruy)localObject).jdField_a_of_type_Int + this.jdField_a_of_type_Int + ((aruy)localObject).c / 2 >= getMeasuredWidth() / 2) {
            break label307;
          }
        }
        label307:
        for (int j = -400;; j = 400)
        {
          ((aruy)localObject).e = j;
          ((aruy)localObject).f = 0;
          j = paramCanvas.getSaveCount();
          paramCanvas.save();
          paramCanvas.translate(((aruy)localObject).jdField_a_of_type_Int + this.jdField_a_of_type_Int + ((aruy)localObject).e, ((aruy)localObject).b);
          paramCanvas.rotate((float)((aruy)localObject).jdField_a_of_type_Double, ((aruy)localObject).c / 2, ((aruy)localObject).d / 2);
          ((aruy)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(((aruy)localObject).f);
          ((aruy)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ((aruy)localObject).c, ((aruy)localObject).d);
          ((aruy)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
          paramCanvas.restoreToCount(j);
          i += 1;
          break;
        }
      }
    }
    c();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidate();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent.getX(), paramMotionEvent.getY())) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_a_of_type_Boolean = false;
      paramInt2 = getMeasuredHeight();
      paramInt1 = 0;
      int j = 0;
      while (paramInt1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        aruy localaruy = (aruy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
        localaruy.f = 255;
        localaruy.e = 0;
        int i = paramInt2;
        if (localaruy.b + localaruy.d > paramInt2)
        {
          j = 1;
          i = localaruy.b + localaruy.d;
        }
        paramInt1 += 1;
        paramInt2 = i;
      }
      if (j != 0)
      {
        setMeasuredDimension(getMeasuredWidth(), paramInt2);
        if (QLog.isColorLevel()) {
          QLog.d("StickerGrayTipLayout", 2, "onMeasure bubbleBottm = " + paramInt2);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      if (paramMotionEvent.getAction() == 0) {
        if ((this.jdField_a_of_type_AndroidViewMotionEvent != null) && (a(this.jdField_a_of_type_AndroidViewMotionEvent, paramMotionEvent)))
        {
          this.b = true;
          if (this.jdField_a_of_type_Aruz != null) {
            this.jdField_a_of_type_Aruz.a(this);
          }
        }
      }
      do
      {
        do
        {
          return true;
        } while (paramMotionEvent.getAction() != 1);
        this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
      } while (!this.b);
      this.b = false;
      this.jdField_a_of_type_AndroidViewMotionEvent = null;
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.StickerGrayTipLayout
 * JD-Core Version:    0.7.0.1
 */