package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
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
import asmr;
import aspq;
import aspt;
import aspy;
import assh;
import assj;
import assm;
import asso;
import bhtq;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.List;

public class SystemAndEmojiUniversalPanel
  extends RelativeLayout
  implements View.OnClickListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new assm(this);
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private asmr jdField_a_of_type_Asmr;
  private aspt jdField_a_of_type_Aspt;
  private assh jdField_a_of_type_Assh;
  private asso jdField_a_of_type_Asso;
  private EmotionPanelListView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
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
    int j = this.jdField_a_of_type_Aspt.jdField_b_of_type_Int;
    int i = j;
    if (this.jdField_a_of_type_Boolean)
    {
      j = Math.max(1, j * 4 / 7);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("EmoticonUniversalPanel", 2, "multiWindowMode: " + this.jdField_a_of_type_Aspt.jdField_b_of_type_Int + "->" + j);
        i = j;
      }
    }
    return i;
  }
  
  private void a(int paramInt)
  {
    ThreadManager.post(new SystemAndEmojiUniversalPanel.1(this, paramInt), 5, null, true);
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
      this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidWidgetImageButton.getLeft();
      this.jdField_b_of_type_Int = arrayOfInt[1];
      b(paramAbsListView);
    }
  }
  
  private void a(List<aspq> paramList, ListView paramListView)
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
        paramListView = (aspq)paramList.get(i);
        if ((paramListView instanceof assj))
        {
          paramListView = (assj)paramListView;
          if ((paramListView.jdField_c_of_type_Int != 3) && (paramListView.jdField_b_of_type_Int != -1))
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
        paramListView = (aspq)paramList.get(i);
        if ((paramListView instanceof assj))
        {
          paramListView = (assj)paramListView;
          if ((paramListView.jdField_c_of_type_Int != 3) && (paramListView.jdField_b_of_type_Int != -1))
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
            if ((this.jdField_c_of_type_Int > 0) && (this.jdField_a_of_type_ArrayOfInt[0] + localView2.getWidth() * 2.0F / 3.0F > this.jdField_c_of_type_Int) && (this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_ArrayOfInt[1] + localView2.getWidth() - this.d > this.jdField_b_of_type_Int)) {
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
  
  public void a()
  {
    setBackgroundColor(getResources().getColor(2131165623));
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.d = bhtq.a(5.0F);
    this.jdField_a_of_type_Aspt = new aspt(7, 7, null);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131365369));
    ImageButton localImageButton;
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      Editable localEditable = this.jdField_a_of_type_AndroidWidgetEditText.getText();
      localImageButton = this.jdField_a_of_type_AndroidWidgetImageButton;
      if (TextUtils.isEmpty(localEditable)) {
        break label255;
      }
    }
    label255:
    for (boolean bool = true;; bool = false)
    {
      localImageButton.setEnabled(bool);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView = ((EmotionPanelListView)findViewById(2131365998));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setDivider(null);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setEdgeEffectEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setSelector(2130850683);
      int i = a();
      this.jdField_a_of_type_Assh = new assh(null, getContext(), i, 1, this.jdField_a_of_type_Aspt.jdField_a_of_type_Int, this.jdField_a_of_type_Asmr, null, 0);
      this.jdField_a_of_type_Assh.b(b());
      this.jdField_a_of_type_Assh.d = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Assh.jdField_a_of_type_Aspt = this.jdField_a_of_type_Aspt;
      this.jdField_a_of_type_Assh.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setAdapter(this.jdField_a_of_type_Assh);
      a(i);
      return;
    }
  }
  
  public void b() {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_Asso != null) && (this.jdField_a_of_type_Asso.a(paramKeyEvent))) {
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
    if ((paramView.getId() == 2131365369) && (this.jdField_a_of_type_Asmr != null)) {
      this.jdField_a_of_type_Asmr.b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
      aspy.a().a();
      aspy.jdField_a_of_type_Int = paramInt1;
      if (paramInt1 / localDisplayMetrics.widthPixels >= 0.66F) {
        break label140;
      }
    }
    label140:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Int = paramInt1;
      if ((this.jdField_a_of_type_Assh != null) && (this.jdField_a_of_type_AndroidWidgetImageButton != null)) {
        ThreadManagerV2.getUIHandlerV2().post(new SystemAndEmojiUniversalPanel.2(this));
      }
      return;
    }
  }
  
  public void setDispatchKeyEventListener(asso paramasso)
  {
    this.jdField_a_of_type_Asso = paramasso;
  }
  
  public void setEmoticonCallback(asmr paramasmr)
  {
    this.jdField_a_of_type_Asmr = paramasmr;
  }
  
  public void setFilterSysFaceBeyond255Enable(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel
 * JD-Core Version:    0.7.0.1
 */