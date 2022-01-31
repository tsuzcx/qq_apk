package com.tencent.mobileqq.emoticonview;

import aemk;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import apno;
import apnp;
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
  public apnp a;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private ArrayList<apno> jdField_a_of_type_JavaUtilArrayList;
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
        apno localapno = (apno)localIterator.next();
        int j = localapno.jdField_a_of_type_Int;
        int k = this.jdField_a_of_type_Int;
        int m = (int)((localapno.jdField_a_of_type_Float - 1.0F) * localapno.c);
        int i = (int)((localapno.jdField_a_of_type_Float - 1.0F) * localapno.d);
        j = j + k + localapno.e - m / 2;
        i = localapno.b - i / 2;
        if ((paramFloat1 > j) && (paramFloat1 < j + localapno.jdField_a_of_type_Float * localapno.c) && (paramFloat2 > i))
        {
          float f1 = i;
          float f2 = localapno.jdField_a_of_type_Float;
          if (paramFloat2 < localapno.d * f2 + f1) {
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
    apno localapno;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      bool = false;
      if (localIterator.hasNext())
      {
        localapno = (apno)localIterator.next();
        if (localapno.jdField_a_of_type_Int + this.jdField_a_of_type_Int + localapno.c / 2 < getMeasuredWidth() / 2) {
          if (Math.abs(localapno.e) > 200)
          {
            localapno.e -= EmojiStickerManager.i;
            localapno.f -= Math.abs(EmojiStickerManager.i / 2);
            localapno.f = Math.min(255, Math.max(0, localapno.f));
            label138:
            if (localapno.e > 0)
            {
              localapno.e = 0;
              localapno.f = 255;
              this.jdField_a_of_type_Boolean = false;
              bool = false;
            }
            label164:
            if (localapno.e < -400)
            {
              localapno.e = -400;
              localapno.f = 0;
              this.jdField_a_of_type_Boolean = false;
              bool = true;
            }
            if (localapno.e <= 400) {
              break label434;
            }
            localapno.e = 400;
            localapno.f = 0;
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
      localapno.f += Math.abs(EmojiStickerManager.i / 2);
      localapno.f = Math.min(255, Math.max(0, localapno.f));
      localapno.e += EmojiStickerManager.i;
      break label138;
      if (Math.abs(localapno.e) < 200)
      {
        localapno.f += Math.abs(EmojiStickerManager.i / 2);
        localapno.f = Math.min(255, Math.max(0, localapno.f));
      }
      for (localapno.e -= EmojiStickerManager.i;; localapno.e += EmojiStickerManager.i)
      {
        if (localapno.e >= 0) {
          break label412;
        }
        localapno.e = 0;
        localapno.f = 255;
        this.jdField_a_of_type_Boolean = false;
        bool = false;
        break;
        localapno.f -= Math.abs(EmojiStickerManager.i / 2);
        localapno.f = Math.min(255, Math.max(0, localapno.f));
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
        apno localapno = (apno)localIterator.next();
        localapno.b += paramInt;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      int i;
      label45:
      apno localapno;
      int j;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.stickerHidden))
      {
        i = 1;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break label447;
        }
        localapno = (apno)localIterator.next();
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (i != 0))
        {
          if (localapno.jdField_a_of_type_Int + this.jdField_a_of_type_Int + localapno.c / 2 >= getMeasuredWidth() / 2) {
            break label279;
          }
          j = -400;
          label110:
          localapno.e = j;
          localapno.f = 0;
        }
        if ((paramInt2 != EmojiStickerManager.h) || (localapno.e != 0))
        {
          if (paramInt2 != EmojiStickerManager.g) {
            break label302;
          }
          if (localapno.jdField_a_of_type_Int + this.jdField_a_of_type_Int + localapno.c / 2 >= getMeasuredWidth() / 2) {
            break label287;
          }
          localapno.e -= paramInt1;
          localapno.f -= Math.abs(paramInt1 / 2);
          localapno.f = Math.min(255, Math.max(0, localapno.f));
        }
      }
      label279:
      label287:
      label302:
      while (paramInt2 != EmojiStickerManager.h) {
        for (;;)
        {
          if (localapno.e < -400)
          {
            localapno.e = -400;
            localapno.f = 0;
          }
          if (localapno.e <= 400) {
            break label45;
          }
          localapno.e = 400;
          localapno.f = 0;
          break label45;
          i = 0;
          break;
          j = 400;
          break label110;
          localapno.e += paramInt1;
        }
      }
      if (localapno.jdField_a_of_type_Int + this.jdField_a_of_type_Int + localapno.c / 2 < getMeasuredWidth() / 2)
      {
        localapno.e += paramInt1;
        if (localapno.e > 0)
        {
          localapno.e = 0;
          localapno.f = 255;
        }
      }
      for (;;)
      {
        localapno.f += Math.abs(paramInt1 / 2);
        localapno.f = Math.min(255, Math.max(0, localapno.f));
        break;
        localapno.e -= paramInt1;
        if (localapno.e < 0)
        {
          localapno.e = 0;
          localapno.f = 255;
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
      apno localapno = new apno();
      if (paramDrawable != null)
      {
        localapno.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable.mutate();
        paramDrawable.setCallback(this);
      }
      localapno.jdField_a_of_type_Int = paramInt1;
      localapno.b = paramInt2;
      localapno.c = paramInt3;
      localapno.d = paramInt4;
      localapno.jdField_a_of_type_Double = paramDouble;
      localapno.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilArrayList.add(localapno);
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
    if (((localObject instanceof ViewGroup)) && ((((ViewGroup)localObject).getTag() instanceof aemk))) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((aemk)((ViewGroup)localObject).getTag()).a;
    }
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      localObject = getChildAt(i);
      if (((View)localObject).getId() == 2131367282) {
        this.jdField_a_of_type_Int = ((View)localObject).getLeft();
      }
      i -= 1;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      i = 0;
      if (i <= this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
      {
        localObject = (apno)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.stickerHidden)) {
          if (((apno)localObject).jdField_a_of_type_Int + this.jdField_a_of_type_Int + ((apno)localObject).c / 2 >= getMeasuredWidth() / 2) {
            break label307;
          }
        }
        label307:
        for (int j = -400;; j = 400)
        {
          ((apno)localObject).e = j;
          ((apno)localObject).f = 0;
          j = paramCanvas.getSaveCount();
          paramCanvas.save();
          paramCanvas.translate(((apno)localObject).jdField_a_of_type_Int + this.jdField_a_of_type_Int + ((apno)localObject).e, ((apno)localObject).b);
          paramCanvas.rotate((float)((apno)localObject).jdField_a_of_type_Double, ((apno)localObject).c / 2, ((apno)localObject).d / 2);
          ((apno)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(((apno)localObject).f);
          ((apno)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ((apno)localObject).c, ((apno)localObject).d);
          ((apno)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
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
        apno localapno = (apno)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
        localapno.f = 255;
        localapno.e = 0;
        int i = paramInt2;
        if (localapno.b + localapno.d > paramInt2)
        {
          j = 1;
          i = localapno.b + localapno.d;
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
          if (this.jdField_a_of_type_Apnp != null) {
            this.jdField_a_of_type_Apnp.a(this);
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