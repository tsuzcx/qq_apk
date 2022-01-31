package com.tencent.mobileqq.mutualmark.view;

import aepi;
import akfw;
import akml;
import alto;
import alud;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ausj;
import autj;
import autp;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.contact.FriendItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BaselineTextView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;

public class MutualMarkIconsView
  extends LinearLayout
{
  int jdField_a_of_type_Int = 0;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public StringBuilder a;
  ArrayList<MutualMarkIconItemView> jdField_a_of_type_JavaUtilArrayList;
  int b = 42;
  int c = 294;
  int d = 294;
  int e = 0;
  
  public MutualMarkIconsView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MutualMarkIconsView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MutualMarkIconsView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(CharSequence paramCharSequence, float paramFloat)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {
      return 0;
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat);
    return (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, this.jdField_a_of_type_AndroidTextTextPaint));
  }
  
  private void a()
  {
    removeAllViews();
    setVisibility(8);
    this.e = 0;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        MutualMarkIconItemView localMutualMarkIconItemView = (MutualMarkIconItemView)localIterator.next();
        if (localMutualMarkIconItemView != null) {
          localMutualMarkIconItemView.a();
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    int k = 0;
    int j = k;
    if (paramLong > 0L) {
      if ((this.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_Int != 4))
      {
        j = k;
        if (this.jdField_a_of_type_Int != 2) {}
      }
      else
      {
        if ((this.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_Int != 4)) {
          break label488;
        }
      }
    }
    label391:
    label488:
    for (int i = 0;; i = 1)
    {
      paramQQAppInterface = (alto)paramQQAppInterface.getManager(51);
      j = k;
      if (paramQQAppInterface != null)
      {
        j = k;
        if (paramQQAppInterface.a(i)) {
          if (this.jdField_a_of_type_AndroidWidgetTextView == null)
          {
            if ((this.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_Int != 4)) {
              break label391;
            }
            this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
            this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
            if (this.jdField_a_of_type_Int != 4) {
              break label372;
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131166903));
            this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
            this.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
            paramQQAppInterface = new LinearLayout.LayoutParams(-2, this.b);
            addView(this.jdField_a_of_type_AndroidWidgetTextView, paramQQAppInterface);
          }
        }
      }
      for (;;)
      {
        long l = paramLong;
        if (paramLong > 9999L) {
          l = 9999L;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(l + alud.a(2131707436));
        if (AppSetting.c)
        {
          paramQQAppInterface = String.format(autp.a(getContext(), 19), new Object[] { Long.valueOf(l) });
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramQQAppInterface);
          if (this.jdField_a_of_type_JavaLangStringBuilder != null) {
            this.jdField_a_of_type_JavaLangStringBuilder.append(paramQQAppInterface);
          }
        }
        j = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
        i = j;
        if (j <= 0) {
          i = aepi.a(32.0F, getResources());
        }
        this.e = (i + this.e);
        j = 1;
        if ((j == 0) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
        {
          removeView(this.jdField_a_of_type_AndroidWidgetTextView);
          this.jdField_a_of_type_AndroidWidgetTextView = null;
        }
        return;
        label372:
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131166981));
        break;
        this.jdField_a_of_type_AndroidWidgetTextView = new BaselineTextView(getContext(), null);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131166903));
        this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, aepi.a(2.0F, getResources()));
        paramQQAppInterface = new LinearLayout.LayoutParams(-2, -2);
        paramQQAppInterface.gravity = 80;
        addView(this.jdField_a_of_type_AndroidWidgetTextView, paramQQAppInterface);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, autj paramautj, ExtensionInfo paramExtensionInfo, MutualMarkIconItemView paramMutualMarkIconItemView)
  {
    int i;
    if (paramautj.d())
    {
      paramMutualMarkIconItemView.setIconResource(paramautj);
      paramMutualMarkIconItemView.setVisibility(0);
      if (AppSetting.c)
      {
        paramQQAppInterface = paramautj.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramautj.d)) {
          paramQQAppInterface = paramautj.d;
        }
        paramMutualMarkIconItemView.setContentDescription(paramQQAppInterface);
        if (this.jdField_a_of_type_JavaLangStringBuilder != null) {
          this.jdField_a_of_type_JavaLangStringBuilder.append(paramQQAppInterface);
        }
      }
      if ((!paramautj.a()) || (this.jdField_a_of_type_Int != 3) || (!paramautj.b()) || (paramautj.jdField_a_of_type_Boolean)) {
        break label206;
      }
      if ((paramautj.h != 0L) && (System.currentTimeMillis() - paramautj.h > 3500L))
      {
        paramautj.jdField_a_of_type_Boolean = true;
        ausj.a(paramautj, paramExtensionInfo);
        if (paramExtensionInfo == null) {
          break label206;
        }
        autp.a(paramExtensionInfo);
        i = 0;
      }
    }
    for (;;)
    {
      if (i == 0) {
        paramMutualMarkIconItemView.setIconAlpha(paramautj.a());
      }
      this.e += paramMutualMarkIconItemView.a();
      return;
      paramautj.h = System.currentTimeMillis();
      ausj.a(paramautj, paramExtensionInfo);
      paramMutualMarkIconItemView.a(paramString);
      i = 1;
      continue;
      paramMutualMarkIconItemView.setVisibility(8);
      return;
      label206:
      i = 0;
    }
  }
  
  private void b()
  {
    int j;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      int i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label65;
      }
      MutualMarkIconItemView localMutualMarkIconItemView = (MutualMarkIconItemView)localIterator.next();
      if ((localMutualMarkIconItemView == null) || (localMutualMarkIconItemView.getVisibility() != 0)) {
        break label71;
      }
      i += localMutualMarkIconItemView.a();
    }
    label65:
    label71:
    for (;;)
    {
      break;
      j = 0;
      this.e = j;
      return;
    }
  }
  
  public int a(View paramView, akfw paramakfw, int paramInt1, int paramInt2)
  {
    int j = 0;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramakfw.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.getLayoutParams();
    if (localLayoutParams != null) {}
    for (int i = localLayoutParams.rightMargin;; i = 0)
    {
      b();
      if (this.e <= this.d) {
        return this.e + paramInt1 + i;
      }
      int k = paramView.getMeasuredWidth();
      if (k <= 0) {}
      for (;;)
      {
        if (paramInt2 <= this.d) {
          return this.e + paramInt1 + i;
        }
        paramInt1 = paramView.getPaddingLeft();
        k = paramView.getPaddingRight();
        int m = a(paramakfw.jdField_a_of_type_AndroidWidgetTextView.getText(), paramakfw.jdField_a_of_type_AndroidWidgetTextView.getTextSize());
        m = Math.min(getResources().getDimensionPixelSize(2131296692), m);
        int i1 = paramakfw.jdField_a_of_type_AndroidWidgetTextView.getCompoundPaddingLeft();
        int i2 = paramakfw.jdField_a_of_type_AndroidWidgetTextView.getCompoundPaddingRight();
        int i3 = paramakfw.jdField_a_of_type_AndroidWidgetTextView.getPaddingRight();
        int i4 = paramakfw.jdField_a_of_type_AndroidWidgetTextView.getPaddingLeft();
        int n = aepi.a(72.0F, getResources());
        paramInt2 = paramInt2 - (paramInt1 + k) - n - i - m - (i1 + i2 + i3 + i4);
        if (QLog.isColorLevel()) {
          QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInSpecialCareList maxMutualMarkWidth:" + paramInt2 + " maybeWidth:" + this.e + " nickMinWidth:" + m + " nickRootLeft:" + n + " mutualMarkMarginRight:" + i);
        }
        if (this.e > paramInt2) {
          if (this.jdField_a_of_type_JavaUtilArrayList != null) {
            paramInt1 = j;
          }
        }
        for (;;)
        {
          if (paramInt1 < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            paramView = (MutualMarkIconItemView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
            if ((paramView != null) && (paramView.getVisibility() == 0))
            {
              this.e -= paramView.a();
              paramView.setVisibility(8);
              if (QLog.isColorLevel()) {
                QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInSpecialCareList hide Type:" + paramView.a() + " width:" + paramView.a());
              }
              if (this.e > paramInt2) {}
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInSpecialCareList after maybeWidth:" + this.e);
            }
            if (QLog.isColorLevel()) {
              QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInSpecialCareList return:" + this.e);
            }
            return this.e + i;
          }
          paramInt1 += 1;
        }
        paramInt2 = k;
      }
    }
  }
  
  public int a(FriendItemLayout paramFriendItemLayout, akml paramakml, int paramInt)
  {
    int j = 0;
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramakml.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.getLayoutParams();
    if (localLayoutParams != null) {}
    for (int i = localLayoutParams.rightMargin;; i = 0)
    {
      b();
      if (this.e <= this.c) {
        return this.e + paramInt + i;
      }
      int k = paramFriendItemLayout.getMeasuredWidth();
      if (k <= this.c) {
        return this.e + paramInt + i;
      }
      int m = paramFriendItemLayout.getPaddingLeft();
      int n = paramFriendItemLayout.getPaddingRight();
      paramInt = a(paramakml.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a(), paramakml.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a());
      int i1 = Math.min(getResources().getDimensionPixelSize(2131296692), paramInt);
      int i2 = paramakml.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a();
      int i3 = paramakml.jdField_a_of_type_ComTencentWidgetSingleLineTextView.b();
      int i4 = paramakml.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getPaddingRight();
      int i5 = paramakml.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getPaddingLeft();
      paramFriendItemLayout = (FrameLayout.LayoutParams)paramakml.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      if (paramFriendItemLayout != null) {}
      for (paramInt = paramFriendItemLayout.leftMargin;; paramInt = 0)
      {
        k = k - (m + n) - paramInt - i1 - (i5 + (i2 + i3 + i4)) - paramakml.b.getMeasuredWidth() - i;
        if (QLog.isColorLevel()) {
          QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInFriendItemLayout maxMutualMarkWidth:" + k + " maybeWidth:" + this.e + " nickMinWidth:" + i1 + " mutualMarkMarginRight:" + i);
        }
        if (this.e > k) {
          if (this.jdField_a_of_type_JavaUtilArrayList != null) {
            paramInt = j;
          }
        }
        for (;;)
        {
          if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            paramFriendItemLayout = (MutualMarkIconItemView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
            if ((paramFriendItemLayout != null) && (paramFriendItemLayout.getVisibility() == 0))
            {
              this.e -= paramFriendItemLayout.a();
              paramFriendItemLayout.setVisibility(8);
              if (QLog.isColorLevel()) {
                QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInFriendItemLayout hide Type:" + paramFriendItemLayout.a() + " width:" + paramFriendItemLayout.a());
              }
              if (this.e > k) {}
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInFriendItemLayout after maybeWidth:" + this.e);
            }
            if (QLog.isColorLevel()) {
              QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInFriendItemLayout return:" + this.e);
            }
            return this.e + i;
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (AppSetting.c) {
      this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    }
    this.jdField_a_of_type_Int = paramInt;
    ArrayList localArrayList = ausj.a(paramQQAppInterface, paramString, false, paramInt);
    if ((localArrayList == null) || (localArrayList.isEmpty()))
    {
      a();
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    paramInt = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = localArrayList.size();
    if (paramInt < i) {
      while (paramInt < i)
      {
        localObject1 = new MutualMarkIconItemView(getContext());
        addView((View)localObject1, paramInt, new LinearLayout.LayoutParams(-2, this.b));
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        paramInt += 1;
      }
    }
    if (paramInt > i)
    {
      paramInt -= 1;
      while (paramInt >= i)
      {
        removeView((MutualMarkIconItemView)this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt));
        paramInt -= 1;
      }
    }
    setVisibility(0);
    this.e = 0;
    Object localObject2 = (alto)paramQQAppInterface.getManager(51);
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((alto)localObject2).a(paramString, false);
    }
    paramInt = 0;
    long l = 0L;
    if (paramInt < localArrayList.size())
    {
      localObject2 = (autj)localArrayList.get(paramInt);
      a(paramQQAppInterface, paramString, (autj)localObject2, (ExtensionInfo)localObject1, (MutualMarkIconItemView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      if (((autj)localObject2).jdField_a_of_type_Long != 5L) {
        break label301;
      }
      l = ((autj)localObject2).c;
    }
    label301:
    for (;;)
    {
      paramInt += 1;
      break;
      a(paramQQAppInterface, paramString, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView
 * JD-Core Version:    0.7.0.1
 */