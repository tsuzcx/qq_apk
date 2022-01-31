package com.tencent.mobileqq.emoticonview;

import aeqz;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import aprx;
import apry;
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
  public apry a;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private ArrayList<aprx> jdField_a_of_type_JavaUtilArrayList;
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
        aprx localaprx = (aprx)localIterator.next();
        int j = localaprx.jdField_a_of_type_Int;
        int k = this.jdField_a_of_type_Int;
        int m = (int)((localaprx.jdField_a_of_type_Float - 1.0F) * localaprx.c);
        int i = (int)((localaprx.jdField_a_of_type_Float - 1.0F) * localaprx.d);
        j = j + k + localaprx.e - m / 2;
        i = localaprx.b - i / 2;
        if ((paramFloat1 > j) && (paramFloat1 < j + localaprx.jdField_a_of_type_Float * localaprx.c) && (paramFloat2 > i))
        {
          float f1 = i;
          float f2 = localaprx.jdField_a_of_type_Float;
          if (paramFloat2 < localaprx.d * f2 + f1) {
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
    aprx localaprx;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      bool = false;
      if (localIterator.hasNext())
      {
        localaprx = (aprx)localIterator.next();
        if (localaprx.jdField_a_of_type_Int + this.jdField_a_of_type_Int + localaprx.c / 2 < getMeasuredWidth() / 2) {
          if (Math.abs(localaprx.e) > 200)
          {
            localaprx.e -= EmojiStickerManager.i;
            localaprx.f -= Math.abs(EmojiStickerManager.i / 2);
            localaprx.f = Math.min(255, Math.max(0, localaprx.f));
            label138:
            if (localaprx.e > 0)
            {
              localaprx.e = 0;
              localaprx.f = 255;
              this.jdField_a_of_type_Boolean = false;
              bool = false;
            }
            label164:
            if (localaprx.e < -400)
            {
              localaprx.e = -400;
              localaprx.f = 0;
              this.jdField_a_of_type_Boolean = false;
              bool = true;
            }
            if (localaprx.e <= 400) {
              break label434;
            }
            localaprx.e = 400;
            localaprx.f = 0;
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
      localaprx.f += Math.abs(EmojiStickerManager.i / 2);
      localaprx.f = Math.min(255, Math.max(0, localaprx.f));
      localaprx.e += EmojiStickerManager.i;
      break label138;
      if (Math.abs(localaprx.e) < 200)
      {
        localaprx.f += Math.abs(EmojiStickerManager.i / 2);
        localaprx.f = Math.min(255, Math.max(0, localaprx.f));
      }
      for (localaprx.e -= EmojiStickerManager.i;; localaprx.e += EmojiStickerManager.i)
      {
        if (localaprx.e >= 0) {
          break label412;
        }
        localaprx.e = 0;
        localaprx.f = 255;
        this.jdField_a_of_type_Boolean = false;
        bool = false;
        break;
        localaprx.f -= Math.abs(EmojiStickerManager.i / 2);
        localaprx.f = Math.min(255, Math.max(0, localaprx.f));
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
        aprx localaprx = (aprx)localIterator.next();
        localaprx.b += paramInt;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      int i;
      label45:
      aprx localaprx;
      int j;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.stickerHidden))
      {
        i = 1;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break label447;
        }
        localaprx = (aprx)localIterator.next();
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (i != 0))
        {
          if (localaprx.jdField_a_of_type_Int + this.jdField_a_of_type_Int + localaprx.c / 2 >= getMeasuredWidth() / 2) {
            break label279;
          }
          j = -400;
          label110:
          localaprx.e = j;
          localaprx.f = 0;
        }
        if ((paramInt2 != EmojiStickerManager.h) || (localaprx.e != 0))
        {
          if (paramInt2 != EmojiStickerManager.g) {
            break label302;
          }
          if (localaprx.jdField_a_of_type_Int + this.jdField_a_of_type_Int + localaprx.c / 2 >= getMeasuredWidth() / 2) {
            break label287;
          }
          localaprx.e -= paramInt1;
          localaprx.f -= Math.abs(paramInt1 / 2);
          localaprx.f = Math.min(255, Math.max(0, localaprx.f));
        }
      }
      label279:
      label287:
      label302:
      while (paramInt2 != EmojiStickerManager.h) {
        for (;;)
        {
          if (localaprx.e < -400)
          {
            localaprx.e = -400;
            localaprx.f = 0;
          }
          if (localaprx.e <= 400) {
            break label45;
          }
          localaprx.e = 400;
          localaprx.f = 0;
          break label45;
          i = 0;
          break;
          j = 400;
          break label110;
          localaprx.e += paramInt1;
        }
      }
      if (localaprx.jdField_a_of_type_Int + this.jdField_a_of_type_Int + localaprx.c / 2 < getMeasuredWidth() / 2)
      {
        localaprx.e += paramInt1;
        if (localaprx.e > 0)
        {
          localaprx.e = 0;
          localaprx.f = 255;
        }
      }
      for (;;)
      {
        localaprx.f += Math.abs(paramInt1 / 2);
        localaprx.f = Math.min(255, Math.max(0, localaprx.f));
        break;
        localaprx.e -= paramInt1;
        if (localaprx.e < 0)
        {
          localaprx.e = 0;
          localaprx.f = 255;
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
      aprx localaprx = new aprx();
      if (paramDrawable != null)
      {
        localaprx.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable.mutate();
        paramDrawable.setCallback(this);
      }
      localaprx.jdField_a_of_type_Int = paramInt1;
      localaprx.b = paramInt2;
      localaprx.c = paramInt3;
      localaprx.d = paramInt4;
      localaprx.jdField_a_of_type_Double = paramDouble;
      localaprx.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilArrayList.add(localaprx);
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
    if (((localObject instanceof ViewGroup)) && ((((ViewGroup)localObject).getTag() instanceof aeqz))) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((aeqz)((ViewGroup)localObject).getTag()).a;
    }
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      localObject = getChildAt(i);
      if (((View)localObject).getId() == 2131367292) {
        this.jdField_a_of_type_Int = ((View)localObject).getLeft();
      }
      i -= 1;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      i = 0;
      if (i <= this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
      {
        localObject = (aprx)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.stickerHidden)) {
          if (((aprx)localObject).jdField_a_of_type_Int + this.jdField_a_of_type_Int + ((aprx)localObject).c / 2 >= getMeasuredWidth() / 2) {
            break label307;
          }
        }
        label307:
        for (int j = -400;; j = 400)
        {
          ((aprx)localObject).e = j;
          ((aprx)localObject).f = 0;
          j = paramCanvas.getSaveCount();
          paramCanvas.save();
          paramCanvas.translate(((aprx)localObject).jdField_a_of_type_Int + this.jdField_a_of_type_Int + ((aprx)localObject).e, ((aprx)localObject).b);
          paramCanvas.rotate((float)((aprx)localObject).jdField_a_of_type_Double, ((aprx)localObject).c / 2, ((aprx)localObject).d / 2);
          ((aprx)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(((aprx)localObject).f);
          ((aprx)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ((aprx)localObject).c, ((aprx)localObject).d);
          ((aprx)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
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
        aprx localaprx = (aprx)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
        localaprx.f = 255;
        localaprx.e = 0;
        int i = paramInt2;
        if (localaprx.b + localaprx.d > paramInt2)
        {
          j = 1;
          i = localaprx.b + localaprx.d;
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
          if (this.jdField_a_of_type_Apry != null) {
            this.jdField_a_of_type_Apry.a(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.StickerGrayTipLayout
 * JD-Core Version:    0.7.0.1
 */