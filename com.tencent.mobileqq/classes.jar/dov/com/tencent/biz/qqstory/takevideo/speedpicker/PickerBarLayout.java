package dov.com.tencent.biz.qqstory.takevideo.speedpicker;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bnqm;
import bnqx;
import bnrd;
import bnrj;
import bnrl;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class PickerBarLayout
  extends RelativeLayout
  implements bnqx, bnrj
{
  private float jdField_a_of_type_Float = 38.0F;
  private int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private bnqm jdField_a_of_type_Bnqm;
  private bnrd jdField_a_of_type_Bnrd;
  private PickerBarLayout.CheckForLongPress jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout$CheckForLongPress;
  private WeakReference<bnrl> jdField_a_of_type_JavaLangRefWeakReference;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 50.0F;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private float c = 18.0F;
  private float d = 146.0F;
  private float e = 102.0F;
  private float f = 22.0F;
  private float g = 22.0F;
  private float h = 4.0F;
  private float i = 36.0F;
  private float j;
  
  public PickerBarLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public PickerBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PickerBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private float a()
  {
    return Math.round(this.c) - this.c - (Math.round(this.h) - this.h) + (Math.round(this.jdField_b_of_type_Float) - this.jdField_b_of_type_Float);
  }
  
  private int a(float paramFloat)
  {
    this.j = paramFloat;
    int k = b(paramFloat);
    if (QLog.isColorLevel()) {
      QLog.d("PickerBarLayout", 2, "movemark posY:" + paramFloat + " markindex:" + k + "  curIndex:" + this.jdField_b_of_type_Int);
    }
    if (k != this.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_Int = k;
      a(this.jdField_b_of_type_Int, false, false);
    }
    setMarkText(this.jdField_b_of_type_Int);
    float f1 = paramFloat;
    if (this.jdField_a_of_type_Boolean) {
      f1 = paramFloat - this.i;
    }
    c(f1);
    invalidate();
    return this.jdField_b_of_type_Int;
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      bnrl localbnrl = (bnrl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbnrl != null) {
        localbnrl.a(paramInt, (String)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramBoolean1, paramBoolean2);
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Float = PickerContainer.a(paramContext, this.jdField_a_of_type_Float);
    this.jdField_b_of_type_Float = PickerContainer.a(paramContext, this.jdField_b_of_type_Float);
    this.c = PickerContainer.a(paramContext, this.c);
    this.d = PickerContainer.a(paramContext, this.d);
    this.e = PickerContainer.a(paramContext, this.e);
    this.h = PickerContainer.a(paramContext, this.h);
    this.f = PickerContainer.a(paramContext, this.f);
    this.g = PickerContainer.a(paramContext, this.g);
    this.i = PickerContainer.a(paramContext, this.i);
  }
  
  private boolean a(float paramFloat)
  {
    return getWidth() - this.c - this.jdField_b_of_type_Float <= paramFloat;
  }
  
  private int b(float paramFloat)
  {
    if (this.jdField_a_of_type_Bnqm != null) {
      return this.jdField_a_of_type_Bnqm.a(paramFloat);
    }
    return -1;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = new View(getContext());
    this.jdField_a_of_type_Bnrd = new bnrd();
    this.jdField_a_of_type_Bnrd.a(getContext(), 2130839646, 2130839645, 2130839647, this);
    this.jdField_a_of_type_AndroidViewView.setBackground(this.jdField_a_of_type_Bnrd);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(Math.round(this.d), Math.round(this.e));
    localLayoutParams.addRule(11);
    localLayoutParams.setMargins(0, 0, Math.round(this.h), 0);
    addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
  }
  
  private void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    bnrl localbnrl;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localbnrl = (bnrl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbnrl != null)
      {
        if (!paramBoolean1) {
          break label50;
        }
        if (!paramBoolean2) {
          break label41;
        }
        localbnrl.a(paramInt);
      }
    }
    return;
    label41:
    localbnrl.b(paramInt);
    return;
    label50:
    if (paramBoolean2)
    {
      localbnrl.c(paramInt);
      return;
    }
    localbnrl.d(paramInt);
  }
  
  private void c()
  {
    this.jdField_b_of_type_AndroidViewView = new View(getContext());
    this.jdField_a_of_type_Bnqm = new bnqm();
    float f1 = a();
    this.jdField_a_of_type_Bnqm.a(getContext(), this.jdField_a_of_type_JavaUtilList.size(), (Math.round(this.jdField_b_of_type_Float) - this.jdField_a_of_type_Float) / 2.0F + f1, (Math.round(this.jdField_b_of_type_Float) - this.jdField_a_of_type_Float) / 2.0F - f1, this);
    this.jdField_b_of_type_AndroidViewView.setBackground(this.jdField_a_of_type_Bnqm);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(Math.round(this.jdField_b_of_type_Float), -1);
    localLayoutParams.addRule(11);
    localLayoutParams.setMargins(0, 0, Math.round(this.c), 0);
    addView(this.jdField_b_of_type_AndroidViewView, localLayoutParams);
  }
  
  private void c(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    float f1;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      if (localLayoutParams != null)
      {
        if (paramFloat >= this.e / 2.0F + this.f) {
          break label82;
        }
        f1 = this.e / 2.0F + this.f;
      }
    }
    for (;;)
    {
      localLayoutParams.topMargin = Math.round(f1 - this.e / 2.0F);
      localLayoutParams.bottomMargin = Math.round(-this.e);
      requestLayout();
      return;
      label82:
      f1 = paramFloat;
      if (paramFloat > getHeight() - this.e / 2.0F - this.g) {
        f1 = getHeight() - this.e / 2.0F - this.g;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_Bnqm != null) {
      this.jdField_a_of_type_Bnqm.stop();
    }
    if (this.jdField_a_of_type_Bnrd != null) {
      this.jdField_a_of_type_Bnrd.stop();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidViewView = null;
    if (this.jdField_a_of_type_Bnrd != null)
    {
      this.jdField_a_of_type_Bnrd.a();
      this.jdField_a_of_type_Bnrd = null;
    }
    this.jdField_b_of_type_AndroidViewView = null;
    if (this.jdField_a_of_type_Bnqm != null)
    {
      this.jdField_a_of_type_Bnqm.a();
      this.jdField_a_of_type_Bnqm = null;
    }
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PickerBarLayout", 2, "startenter:" + paramFloat);
    }
    this.j = paramFloat;
    this.jdField_b_of_type_Int = b(paramFloat);
    a(this.jdField_b_of_type_Int, true, false);
    int k;
    int m;
    if ((this.jdField_a_of_type_Bnrd != null) && (this.jdField_a_of_type_Bnqm != null))
    {
      k = this.jdField_a_of_type_Bnrd.a();
      boolean bool1 = this.jdField_a_of_type_Bnrd.isRunning();
      m = this.jdField_a_of_type_Bnqm.a();
      boolean bool2 = this.jdField_a_of_type_Bnqm.isRunning();
      if (QLog.isColorLevel()) {
        QLog.d("PickerBarLayout", 2, "drawable state, markdrawble:" + k + " isrun:" + bool1 + "  groundrawable:" + m + " isrun:" + bool2);
      }
      if ((k != 1) || (m != 0)) {
        break label223;
      }
      this.jdField_a_of_type_Bnrd.stop();
      this.jdField_a_of_type_Bnrd.a(6);
      this.jdField_a_of_type_Bnrd.start();
      this.jdField_a_of_type_Bnqm.stop();
      this.jdField_a_of_type_Bnqm.a(1);
      this.jdField_a_of_type_Bnqm.start();
    }
    label223:
    do
    {
      return;
      if (k == 4)
      {
        this.jdField_a_of_type_Bnrd.stop();
        this.jdField_a_of_type_Bnrd.a(2);
        this.jdField_a_of_type_Bnrd.start();
        return;
      }
      if (m == 3)
      {
        this.jdField_a_of_type_Bnqm.stop();
        this.jdField_a_of_type_Bnqm.a(1);
        this.jdField_a_of_type_Bnqm.start();
        return;
      }
      if (k == 5)
      {
        this.jdField_a_of_type_Bnrd.stop();
        this.jdField_a_of_type_Bnrd.a(6);
        this.jdField_a_of_type_Bnrd.start();
        this.jdField_a_of_type_Bnqm.stop();
        this.jdField_a_of_type_Bnqm.a(1);
        this.jdField_a_of_type_Bnqm.start();
        return;
      }
      if (m == 4)
      {
        this.jdField_a_of_type_Bnqm.stop();
        this.jdField_a_of_type_Bnqm.a(1);
        this.jdField_a_of_type_Bnqm.start();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PickerBarLayout", 2, "startenter: state not process!!");
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {}
    for (;;)
    {
      b(paramInt, true, true);
      return;
      if ((paramInt != 4) && (this.jdField_a_of_type_Bnrd != null)) {
        this.jdField_a_of_type_Bnrd.stop();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 != 4) || (this.jdField_a_of_type_Bnqm == null) || (paramInt3 == 0)) {}
    RectF localRectF;
    do
    {
      return;
      localRectF = this.jdField_a_of_type_Bnqm.a(this.j);
    } while (localRectF == null);
    c((localRectF.centerY() - this.j + this.i) * (paramInt2 + 1) / paramInt3 + (this.j - this.i));
  }
  
  public void a(int paramInt1, int paramInt2, RectF paramRectF)
  {
    if ((this.jdField_a_of_type_Bnqm != null) && (paramRectF != null)) {
      c(paramRectF.centerY());
    }
  }
  
  public void a(int paramInt, RectF paramRectF)
  {
    if (((paramInt == 1) || (paramInt == 4)) && (paramRectF != null)) {
      c(paramRectF.centerY());
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_b_of_type_Int = paramInt;
    setMarkText(this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_Bnqm != null) {
      this.jdField_a_of_type_Bnqm.a(this.jdField_b_of_type_Int, true, paramBoolean);
    }
    invalidate();
  }
  
  public boolean a(EditVideoParams paramEditVideoParams, Context paramContext, bnrl parambnrl)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambnrl);
    a(paramContext);
    this.jdField_a_of_type_JavaUtilList.add("4x");
    this.jdField_a_of_type_JavaUtilList.add("2x");
    this.jdField_a_of_type_JavaUtilList.add("1x");
    if (paramEditVideoParams.f())
    {
      this.jdField_a_of_type_JavaUtilList.add("1/2");
      this.jdField_a_of_type_JavaUtilList.add("1/4");
    }
    if (paramEditVideoParams.e()) {
      this.jdField_a_of_type_JavaUtilList.add(PickerContainer.a);
    }
    c();
    b();
    return true;
  }
  
  public void b(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PickerBarLayout", 2, "startleave:" + paramFloat);
    }
    this.j = paramFloat;
    int k = a(this.j);
    if (k != this.jdField_b_of_type_Int) {
      this.jdField_b_of_type_Int = k;
    }
    a(this.jdField_b_of_type_Int, false, true);
    int m;
    if ((this.jdField_a_of_type_Bnrd != null) && (this.jdField_a_of_type_Bnqm != null))
    {
      this.jdField_a_of_type_Bnqm.a(this.jdField_b_of_type_Int, false, false);
      k = this.jdField_a_of_type_Bnrd.a();
      boolean bool1 = this.jdField_a_of_type_Bnrd.isRunning();
      m = this.jdField_a_of_type_Bnqm.a();
      boolean bool2 = this.jdField_a_of_type_Bnqm.isRunning();
      if (QLog.isColorLevel()) {
        QLog.d("PickerBarLayout", 2, "drawable state, markdrawble:" + k + " isrun:" + bool1 + "  groundrawable:" + m + " isrun:" + bool2);
      }
      if ((k != 3) || (m != 2)) {
        break label228;
      }
      this.jdField_a_of_type_Bnrd.stop();
      this.jdField_a_of_type_Bnrd.a(4);
      this.jdField_a_of_type_Bnrd.start();
    }
    label228:
    do
    {
      return;
      if (m == 1)
      {
        this.jdField_a_of_type_Bnqm.stop();
        this.jdField_a_of_type_Bnqm.a(3);
        this.jdField_a_of_type_Bnqm.start();
        return;
      }
      if (k == 2)
      {
        this.jdField_a_of_type_Bnrd.stop();
        this.jdField_a_of_type_Bnrd.a(4);
        this.jdField_a_of_type_Bnrd.start();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PickerBarLayout", 2, "startleave: state not process!!");
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_a_of_type_Bnqm.a(this.j) != null) {
        c(this.j - this.i);
      }
      if (this.jdField_a_of_type_Bnrd != null)
      {
        setMarkText(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_Bnrd.stop();
        this.jdField_a_of_type_Bnrd.a(2);
        this.jdField_a_of_type_Bnrd.start();
      }
    }
    for (;;)
    {
      b(paramInt, true, false);
      return;
      if (paramInt == 3)
      {
        if (this.jdField_a_of_type_Bnqm != null)
        {
          RectF localRectF = this.jdField_a_of_type_Bnqm.a();
          if (localRectF != null) {
            c(localRectF.centerY());
          }
        }
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        if (this.jdField_a_of_type_Bnrd != null)
        {
          this.jdField_a_of_type_Bnrd.stop();
          this.jdField_a_of_type_Bnrd.a(5);
          this.jdField_a_of_type_Bnrd.start();
        }
      }
      else if ((paramInt != 4) && (paramInt == 0) && (this.jdField_a_of_type_Bnrd != null))
      {
        this.jdField_a_of_type_Bnrd.stop();
        this.jdField_a_of_type_Bnrd.a(1);
        this.jdField_a_of_type_Bnrd.start();
      }
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Bnrd != null) {
      this.jdField_a_of_type_Bnrd.stop();
    }
  }
  
  public void d(int paramInt)
  {
    b(paramInt, false, true);
  }
  
  public void e(int paramInt)
  {
    if (paramInt == 2) {}
    for (;;)
    {
      b(paramInt, false, false);
      return;
      if (paramInt == 4)
      {
        if (this.jdField_a_of_type_Bnqm != null)
        {
          this.jdField_a_of_type_Bnqm.stop();
          this.jdField_a_of_type_Bnqm.a(3);
          this.jdField_a_of_type_Bnqm.start();
        }
      }
      else if (paramInt == 6) {
        c(this.j);
      }
    }
  }
  
  public void f(int paramInt) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
      if (!a(paramMotionEvent.getX())) {
        return false;
      }
      this.j = paramMotionEvent.getY();
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout$CheckForLongPress == null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout$CheckForLongPress = new PickerBarLayout.CheckForLongPress(this);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout$CheckForLongPress.a();
      postDelayed(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout$CheckForLongPress, ViewConfiguration.getLongPressTimeout());
      continue;
      int k = paramMotionEvent.findPointerIndex(this.jdField_a_of_type_Int);
      if (k != -1)
      {
        float f1 = paramMotionEvent.getY(k);
        if (this.jdField_a_of_type_Boolean)
        {
          a(f1);
          continue;
          k = paramMotionEvent.findPointerIndex(this.jdField_a_of_type_Int);
          if (k == -1) {
            if (QLog.isColorLevel()) {
              QLog.d("PickerBarLayout", 2, "ACTION_UP with activePointerIndex = -1");
            }
          }
          for (f1 = paramMotionEvent.getY();; f1 = paramMotionEvent.getY(k))
          {
            if (this.jdField_a_of_type_Boolean) {
              break label270;
            }
            if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout$CheckForLongPress != null) {
              removeCallbacks(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout$CheckForLongPress);
            }
            if (this.jdField_a_of_type_Bnqm == null) {
              break;
            }
            paramMotionEvent = this.jdField_a_of_type_Bnqm.a(f1);
            if (paramMotionEvent == null) {
              break;
            }
            a(paramMotionEvent.centerY());
            a(this.jdField_b_of_type_Int, true);
            break;
          }
          label270:
          b(f1);
          this.jdField_a_of_type_Int = -1;
          this.jdField_a_of_type_Boolean = false;
          continue;
          k = paramMotionEvent.findPointerIndex(this.jdField_a_of_type_Int);
          if (k != -1)
          {
            paramMotionEvent.getY(k);
            b(paramMotionEvent.getY());
            this.jdField_a_of_type_Int = -1;
            this.jdField_a_of_type_Boolean = false;
          }
        }
      }
    }
  }
  
  public void setMarkText(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilList.size())) {}
    while (this.jdField_a_of_type_Bnrd == null) {
      return;
    }
    this.jdField_a_of_type_Bnrd.a((String)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerBarLayout
 * JD-Core Version:    0.7.0.1
 */