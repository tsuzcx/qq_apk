package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import appt;
import apsj;
import apsm;
import apsr;
import apup;
import apur;
import apuu;
import apuv;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.List;

public class SystemAndEmojiUniversalPanel
  extends RelativeLayout
  implements View.OnClickListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new apuu(this);
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private appt jdField_a_of_type_Appt;
  private apsm jdField_a_of_type_Apsm;
  private apup jdField_a_of_type_Apup;
  private apuv jdField_a_of_type_Apuv;
  private EmotionPanelListView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  
  public SystemAndEmojiUniversalPanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SystemAndEmojiUniversalPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SystemAndEmojiUniversalPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a()
  {
    int j = this.jdField_a_of_type_Apsm.jdField_b_of_type_Int;
    int i = j;
    if (this.jdField_a_of_type_Boolean)
    {
      j = Math.max(1, j * 4 / 7);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("EmoticonUniversalPanel", 2, "multiWindowMode: " + this.jdField_a_of_type_Apsm.jdField_b_of_type_Int + "->" + j);
        i = j;
      }
    }
    return i;
  }
  
  private void a(View paramView)
  {
    if ((paramView instanceof URLImageView))
    {
      int i = this.jdField_a_of_type_ArrayOfInt[1] + paramView.getWidth() - this.d - this.jdField_b_of_type_Int;
      float f = paramView.getWidth() / 2.0F;
      if (i < f)
      {
        paramView.setAlpha((f - i) * 1.0F / f);
        return;
      }
      paramView.setAlpha(0.0F);
      return;
    }
    paramView.setAlpha(1.0F);
  }
  
  private void a(AbsListView paramAbsListView)
  {
    if (a())
    {
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_AndroidWidgetImageButton.getLocationOnScreen(arrayOfInt);
      this.c = this.jdField_a_of_type_AndroidWidgetImageButton.getLeft();
      this.jdField_b_of_type_Int = arrayOfInt[1];
      b(paramAbsListView);
    }
  }
  
  private void a(List<apsj> paramList, ListView paramListView)
  {
    if ((paramListView != null) && (paramList != null) && (paramList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonUniversalPanel", 2, "onScrollStateChanged preload systemEmotion");
      }
      int k = paramListView.getFirstVisiblePosition();
      int j = (paramListView.getLastVisiblePosition() + 1) * 7;
      int i = j;
      while ((i < j + 35) && (i < paramList.size()))
      {
        paramListView = (apsj)paramList.get(i);
        if ((paramListView instanceof apur))
        {
          paramListView = (apur)paramListView;
          if ((paramListView.c != 3) && (paramListView.jdField_b_of_type_Int != -1))
          {
            paramListView = paramListView.a(false);
            if ((paramListView instanceof URLDrawable))
            {
              paramListView = (URLDrawable)paramListView;
              if ((paramListView != null) && (paramListView.getStatus() != 1)) {
                paramListView.startDownload();
              }
            }
          }
        }
        i += 1;
      }
      j = k * 7 - 1;
      i = j;
      while ((i >= 0) && (i > j - 35) && (i < paramList.size()))
      {
        paramListView = (apsj)paramList.get(i);
        if ((paramListView instanceof apur))
        {
          paramListView = (apur)paramListView;
          if ((paramListView.c != 3) && (paramListView.jdField_b_of_type_Int != -1))
          {
            paramListView = paramListView.a(getContext(), this.jdField_a_of_type_Float);
            if ((paramListView instanceof URLDrawable))
            {
              paramListView = (URLDrawable)paramListView;
              if ((paramListView != null) && (paramListView.getStatus() != 1)) {
                paramListView.startDownload();
              }
            }
          }
        }
        i -= 1;
      }
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_AndroidWidgetImageButton != null) && (this.jdField_a_of_type_AndroidWidgetImageButton.getVisibility() == 0);
  }
  
  private int b()
  {
    if (a()) {
      return this.jdField_a_of_type_AndroidWidgetImageButton.getMeasuredHeight();
    }
    return 0;
  }
  
  private void b(AbsListView paramAbsListView)
  {
    if (paramAbsListView != null)
    {
      int k = paramAbsListView.getChildCount();
      int i = 0;
      while (i < k)
      {
        View localView1 = paramAbsListView.getChildAt(i);
        if ((localView1 instanceof ViewGroup))
        {
          int m = ((ViewGroup)localView1).getChildCount();
          int j = m - 1;
          if (j >= 0)
          {
            View localView2 = ((ViewGroup)localView1).getChildAt(m - 1);
            localView2.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
            this.jdField_a_of_type_ArrayOfInt[0] = localView2.getLeft();
            if ((this.c > 0) && (this.jdField_a_of_type_ArrayOfInt[0] + localView2.getWidth() * 2.0F / 3.0F > this.c) && (this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_ArrayOfInt[1] + localView2.getWidth() - this.d > this.jdField_b_of_type_Int)) {
              a(localView2);
            }
            for (;;)
            {
              j -= 1;
              break;
              localView2.setAlpha(1.0F);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_Apuv != null) && (this.jdField_a_of_type_Apuv.a(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131365086) && (this.jdField_a_of_type_Appt != null)) {
      this.jdField_a_of_type_Appt.b();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      try
      {
        i = paramMotionEvent.getAction() & 0xFF;
        if (i != 0) {
          continue;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      catch (Exception localException)
      {
        int i;
        QLog.e("EmoticonUniversalPanel", 1, "onInterceptTouchEvent failed", localException);
        continue;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    paramInt2 = this.jdField_a_of_type_Int;
    if (paramInt1 != paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonUniversalPanel", 2, "onMeasure: oldWidth=" + paramInt2 + " newWidth=" + paramInt1);
      }
      apsr.a().a();
      apsr.jdField_a_of_type_Int = paramInt1;
      if (paramInt1 / localDisplayMetrics.widthPixels >= 0.66F) {
        break label140;
      }
    }
    label140:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Int = paramInt1;
      if ((this.jdField_a_of_type_Apup != null) && (this.jdField_a_of_type_AndroidWidgetImageButton != null)) {
        ThreadManagerV2.getUIHandlerV2().post(new SystemAndEmojiUniversalPanel.2(this));
      }
      return;
    }
  }
  
  public void setDispatchKeyEventListener(apuv paramapuv)
  {
    this.jdField_a_of_type_Apuv = paramapuv;
  }
  
  public void setEmoticonCallback(appt paramappt)
  {
    this.jdField_a_of_type_Appt = paramappt;
  }
  
  public void setShowCommonUsedSystemEmoji(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setShowDeleteButton(EditText paramEditText)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel
 * JD-Core Version:    0.7.0.1
 */