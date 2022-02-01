package com.tencent.mobileqq.mutualmark.view;

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
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends.BuddyChildTag;
import com.tencent.mobileqq.activity.contacts.friend.FriendItemLayout;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.ViewHolder;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper;
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
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MutualMarkIconItemView localMutualMarkIconItemView = (MutualMarkIconItemView)((Iterator)localObject).next();
        if (localMutualMarkIconItemView != null) {
          localMutualMarkIconItemView.a();
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    int j = 1;
    if (paramLong > 0L)
    {
      i = this.jdField_a_of_type_Int;
      if ((i == 3) || (i == 4) || (i == 2))
      {
        i = this.jdField_a_of_type_Int;
        if ((i != 3) && (i != 4)) {
          i = 1;
        } else {
          i = 0;
        }
        paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.a(i)))
        {
          if (this.jdField_a_of_type_AndroidWidgetTextView == null)
          {
            i = this.jdField_a_of_type_Int;
            if ((i != 3) && (i != 4))
            {
              this.jdField_a_of_type_AndroidWidgetTextView = new BaselineTextView(getContext(), null);
              this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131167056));
              this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
              this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
              this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, AIOUtils.b(2.0F, getResources()));
              paramQQAppInterface = new LinearLayout.LayoutParams(-2, -2);
              paramQQAppInterface.gravity = 80;
              addView(this.jdField_a_of_type_AndroidWidgetTextView, paramQQAppInterface);
            }
            else
            {
              this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
              this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
              if (this.jdField_a_of_type_Int == 4) {
                this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131167056));
              } else {
                this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131167142));
              }
              this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
              this.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
              paramQQAppInterface = new LinearLayout.LayoutParams(-2, this.b);
              addView(this.jdField_a_of_type_AndroidWidgetTextView, paramQQAppInterface);
            }
          }
          long l = paramLong;
          if (paramLong > 9999L) {
            l = 9999L;
          }
          paramQQAppInterface = this.jdField_a_of_type_AndroidWidgetTextView;
          paramString = new StringBuilder();
          paramString.append(l);
          paramString.append(HardCodeUtil.a(2131707079));
          paramQQAppInterface.setText(paramString.toString());
          if (AppSetting.d)
          {
            paramQQAppInterface = String.format(HotReactiveHelper.a(getContext(), 19), new Object[] { Long.valueOf(l) });
            this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramQQAppInterface);
            paramString = this.jdField_a_of_type_JavaLangStringBuilder;
            if (paramString != null) {
              paramString.append(paramQQAppInterface);
            }
          }
          int k = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
          i = k;
          if (k <= 0) {
            i = AIOUtils.b(32.0F, getResources());
          }
          this.e += i;
          i = j;
          break label477;
        }
      }
    }
    int i = 0;
    label477:
    if (i == 0)
    {
      paramQQAppInterface = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramQQAppInterface != null)
      {
        removeView(paramQQAppInterface);
        this.jdField_a_of_type_AndroidWidgetTextView = null;
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo, ExtensionInfo paramExtensionInfo, MutualMarkIconItemView paramMutualMarkIconItemView)
  {
    if (paramMutualMarkForDisplayInfo.c())
    {
      paramMutualMarkIconItemView.setIconResource(paramMutualMarkForDisplayInfo);
      int j = 0;
      paramMutualMarkIconItemView.setVisibility(0);
      if (AppSetting.d)
      {
        paramQQAppInterface = paramMutualMarkForDisplayInfo.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramMutualMarkForDisplayInfo.d)) {
          paramQQAppInterface = paramMutualMarkForDisplayInfo.d;
        }
        paramMutualMarkIconItemView.setContentDescription(paramQQAppInterface);
        StringBuilder localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
        if (localStringBuilder != null) {
          localStringBuilder.append(paramQQAppInterface);
        }
      }
      int i = j;
      if (paramMutualMarkForDisplayInfo.a())
      {
        i = j;
        if (this.jdField_a_of_type_Int == 3)
        {
          i = j;
          if (!paramMutualMarkForDisplayInfo.jdField_a_of_type_Boolean) {
            if ((paramMutualMarkForDisplayInfo.i != 0L) && (System.currentTimeMillis() - paramMutualMarkForDisplayInfo.i > 3500L))
            {
              paramMutualMarkForDisplayInfo.jdField_a_of_type_Boolean = true;
              MutualMarkDataCenter.a(paramMutualMarkForDisplayInfo, paramExtensionInfo);
              i = j;
              if (paramExtensionInfo != null)
              {
                HotReactiveHelper.a(paramExtensionInfo);
                i = j;
              }
            }
            else
            {
              paramMutualMarkForDisplayInfo.i = System.currentTimeMillis();
              MutualMarkDataCenter.a(paramMutualMarkForDisplayInfo, paramExtensionInfo);
              paramMutualMarkIconItemView.a(paramString);
              i = 1;
            }
          }
        }
      }
      if (i == 0) {
        paramMutualMarkIconItemView.setIconAlpha(paramMutualMarkForDisplayInfo.a());
      }
      this.e += paramMutualMarkIconItemView.a();
      return;
    }
    paramMutualMarkIconItemView.setVisibility(8);
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    int j = 0;
    int i = 0;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        MutualMarkIconItemView localMutualMarkIconItemView = (MutualMarkIconItemView)((Iterator)localObject).next();
        if ((localMutualMarkIconItemView != null) && (localMutualMarkIconItemView.getVisibility() == 0)) {
          i += localMutualMarkIconItemView.a();
        }
      }
    }
    this.e = j;
  }
  
  public int a(View paramView, SpecailCareListActivity.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.getLayoutParams();
    int j = 0;
    int i;
    if (localLayoutParams != null) {
      i = localLayoutParams.rightMargin;
    } else {
      i = 0;
    }
    b();
    int k = this.e;
    if (k <= this.d) {
      return k + paramInt1 + i;
    }
    k = paramView.getMeasuredWidth();
    if (k > 0) {
      paramInt2 = k;
    }
    if (paramInt2 <= this.d) {}
    for (paramInt1 = this.e + paramInt1;; paramInt1 = this.e)
    {
      return paramInt1 + i;
      paramInt1 = paramView.getPaddingLeft();
      k = paramView.getPaddingRight();
      int m = a(paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText(), paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getTextSize());
      m = Math.min(getResources().getDimensionPixelSize(2131296810), m);
      int i1 = paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getCompoundPaddingLeft();
      int i2 = paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getCompoundPaddingRight();
      int i3 = paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getPaddingRight();
      int i4 = paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getPaddingLeft();
      int n = AIOUtils.b(72.0F, getResources());
      paramInt2 = paramInt2 - (paramInt1 + k) - n - i - m - (i1 + i2 + i3 + i4);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("getMaybeWidthInSpecialCareList maxMutualMarkWidth:");
        paramView.append(paramInt2);
        paramView.append(" maybeWidth:");
        paramView.append(this.e);
        paramView.append(" nickMinWidth:");
        paramView.append(m);
        paramView.append(" nickRootLeft:");
        paramView.append(n);
        paramView.append(" mutualMarkMarginRight:");
        paramView.append(i);
        QLog.i("MutualMarkIconsView", 2, paramView.toString());
      }
      if (this.e > paramInt2)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          paramInt1 = j;
          while (paramInt1 < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            paramView = (MutualMarkIconItemView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
            if ((paramView != null) && (paramView.getVisibility() == 0))
            {
              this.e -= paramView.a();
              paramView.setVisibility(8);
              if (QLog.isColorLevel())
              {
                paramViewHolder = new StringBuilder();
                paramViewHolder.append("getMaybeWidthInSpecialCareList hide Type:");
                paramViewHolder.append(paramView.a());
                paramViewHolder.append(" width:");
                paramViewHolder.append(paramView.a());
                QLog.i("MutualMarkIconsView", 2, paramViewHolder.toString());
              }
              if (this.e <= paramInt2) {
                break;
              }
            }
            paramInt1 += 1;
          }
        }
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("getMaybeWidthInSpecialCareList after maybeWidth:");
          paramView.append(this.e);
          QLog.i("MutualMarkIconsView", 2, paramView.toString());
        }
      }
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("getMaybeWidthInSpecialCareList return:");
        paramView.append(this.e);
        QLog.i("MutualMarkIconsView", 2, paramView.toString());
      }
    }
  }
  
  public int a(FriendItemLayout paramFriendItemLayout, BuddyListFriends.BuddyChildTag paramBuddyChildTag, int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.getLayoutParams();
    int j = 0;
    int i;
    if (localLayoutParams != null) {
      i = localLayoutParams.rightMargin;
    } else {
      i = 0;
    }
    b();
    int k = this.e;
    if (k <= this.c) {
      return k + paramInt + i;
    }
    k = paramFriendItemLayout.getMeasuredWidth();
    if (k <= this.c) {}
    for (paramInt = this.e + paramInt;; paramInt = this.e)
    {
      return paramInt + i;
      int m = paramFriendItemLayout.getPaddingLeft();
      int n = paramFriendItemLayout.getPaddingRight();
      paramInt = a(paramBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getText(), paramBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getTextSize());
      int i1 = Math.min(getResources().getDimensionPixelSize(2131296810), paramInt);
      int i2 = paramBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getCompoundPaddingLeft();
      int i3 = paramBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getCompoundPaddingRight();
      int i4 = paramBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getPaddingRight();
      int i5 = paramBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getPaddingLeft();
      paramFriendItemLayout = (FrameLayout.LayoutParams)paramBuddyChildTag.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      if (paramFriendItemLayout != null) {
        paramInt = paramFriendItemLayout.leftMargin;
      } else {
        paramInt = 0;
      }
      k = k - (m + n) - paramInt - i1 - (i2 + i3 + i4 + i5) - paramBuddyChildTag.b.getMeasuredWidth() - i;
      if (QLog.isColorLevel())
      {
        paramFriendItemLayout = new StringBuilder();
        paramFriendItemLayout.append("getMaybeWidthInFriendItemLayout maxMutualMarkWidth:");
        paramFriendItemLayout.append(k);
        paramFriendItemLayout.append(" maybeWidth:");
        paramFriendItemLayout.append(this.e);
        paramFriendItemLayout.append(" nickMinWidth:");
        paramFriendItemLayout.append(i1);
        paramFriendItemLayout.append(" mutualMarkMarginRight:");
        paramFriendItemLayout.append(i);
        QLog.i("MutualMarkIconsView", 2, paramFriendItemLayout.toString());
      }
      if (this.e > k)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          paramInt = j;
          while (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            paramFriendItemLayout = (MutualMarkIconItemView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
            if ((paramFriendItemLayout != null) && (paramFriendItemLayout.getVisibility() == 0))
            {
              this.e -= paramFriendItemLayout.a();
              paramFriendItemLayout.setVisibility(8);
              if (QLog.isColorLevel())
              {
                paramBuddyChildTag = new StringBuilder();
                paramBuddyChildTag.append("getMaybeWidthInFriendItemLayout hide Type:");
                paramBuddyChildTag.append(paramFriendItemLayout.a());
                paramBuddyChildTag.append(" width:");
                paramBuddyChildTag.append(paramFriendItemLayout.a());
                QLog.i("MutualMarkIconsView", 2, paramBuddyChildTag.toString());
              }
              if (this.e <= k) {
                break;
              }
            }
            paramInt += 1;
          }
        }
        if (QLog.isColorLevel())
        {
          paramFriendItemLayout = new StringBuilder();
          paramFriendItemLayout.append("getMaybeWidthInFriendItemLayout after maybeWidth:");
          paramFriendItemLayout.append(this.e);
          QLog.i("MutualMarkIconsView", 2, paramFriendItemLayout.toString());
        }
      }
      if (QLog.isColorLevel())
      {
        paramFriendItemLayout = new StringBuilder();
        paramFriendItemLayout.append("getMaybeWidthInFriendItemLayout return:");
        paramFriendItemLayout.append(this.e);
        QLog.i("MutualMarkIconsView", 2, paramFriendItemLayout.toString());
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (AppSetting.d) {
      this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    }
    this.jdField_a_of_type_Int = paramInt;
    int i = 0;
    ArrayList localArrayList = MutualMarkDataCenter.a(paramQQAppInterface, paramString, false, paramInt);
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      paramInt = this.jdField_a_of_type_JavaUtilArrayList.size();
      int j = localArrayList.size();
      if (paramInt < j) {
        while (paramInt < j)
        {
          localObject1 = new MutualMarkIconItemView(getContext());
          addView((View)localObject1, paramInt, new LinearLayout.LayoutParams(-2, this.b));
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
          paramInt += 1;
        }
      }
      if (paramInt > j)
      {
        paramInt -= 1;
        while (paramInt >= j)
        {
          removeView((MutualMarkIconItemView)this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt));
          paramInt -= 1;
        }
      }
      setVisibility(0);
      this.e = 0;
      long l2 = 0L;
      Object localObject2 = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Object localObject1 = null;
      paramInt = i;
      long l1 = l2;
      if (localObject2 != null)
      {
        localObject1 = ((FriendsManager)localObject2).a(paramString, false);
        l1 = l2;
        paramInt = i;
      }
      while (paramInt < localArrayList.size())
      {
        localObject2 = (MutualMarkForDisplayInfo)localArrayList.get(paramInt);
        a(paramQQAppInterface, paramString, (MutualMarkForDisplayInfo)localObject2, (ExtensionInfo)localObject1, (MutualMarkIconItemView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
        if (((MutualMarkForDisplayInfo)localObject2).jdField_a_of_type_Long == 5L) {
          l1 = ((MutualMarkForDisplayInfo)localObject2).c;
        }
        paramInt += 1;
      }
      a(paramQQAppInterface, paramString, l1);
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView
 * JD-Core Version:    0.7.0.1
 */