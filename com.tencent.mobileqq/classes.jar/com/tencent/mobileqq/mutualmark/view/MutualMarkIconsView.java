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
  int a = 0;
  TextView b;
  ArrayList<MutualMarkIconItemView> c;
  int d = 42;
  int e = 294;
  int f = 294;
  int g = 0;
  public StringBuilder h;
  private TextPaint i = new TextPaint();
  
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
    this.i.setTextSize(paramFloat);
    return (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, this.i));
  }
  
  private void a()
  {
    removeAllViews();
    setVisibility(8);
    this.g = 0;
    this.b = null;
    Object localObject = this.c;
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
    this.c = null;
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    int k = 1;
    if (paramLong > 0L)
    {
      j = this.a;
      if ((j == 3) || (j == 4) || (j == 2))
      {
        j = this.a;
        if ((j != 3) && (j != 4)) {
          j = 1;
        } else {
          j = 0;
        }
        paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.a(j)))
        {
          if (this.b == null)
          {
            j = this.a;
            if ((j != 3) && (j != 4))
            {
              this.b = new BaselineTextView(getContext(), null);
              this.b.setTextColor(getResources().getColorStateList(2131167993));
              this.b.setSingleLine();
              this.b.setTextSize(1, 14.0F);
              this.b.setPadding(0, 0, 0, AIOUtils.b(2.0F, getResources()));
              paramQQAppInterface = new LinearLayout.LayoutParams(-2, -2);
              paramQQAppInterface.gravity = 80;
              addView(this.b, paramQQAppInterface);
            }
            else
            {
              this.b = new TextView(getContext());
              this.b.setTextSize(1, 12.0F);
              if (this.a == 4) {
                this.b.setTextColor(getResources().getColorStateList(2131167993));
              } else {
                this.b.setTextColor(getResources().getColorStateList(2131168122));
              }
              this.b.setSingleLine();
              this.b.setGravity(16);
              paramQQAppInterface = new LinearLayout.LayoutParams(-2, this.d);
              addView(this.b, paramQQAppInterface);
            }
          }
          long l = paramLong;
          if (paramLong > 9999L) {
            l = 9999L;
          }
          paramQQAppInterface = this.b;
          paramString = new StringBuilder();
          paramString.append(l);
          paramString.append(HardCodeUtil.a(2131904917));
          paramQQAppInterface.setText(paramString.toString());
          if (AppSetting.e)
          {
            paramQQAppInterface = String.format(HotReactiveHelper.a(getContext(), 19), new Object[] { Long.valueOf(l) });
            this.b.setContentDescription(paramQQAppInterface);
            paramString = this.h;
            if (paramString != null) {
              paramString.append(paramQQAppInterface);
            }
          }
          int m = this.b.getMeasuredWidth();
          j = m;
          if (m <= 0) {
            j = AIOUtils.b(32.0F, getResources());
          }
          this.g += j;
          j = k;
          break label477;
        }
      }
    }
    int j = 0;
    label477:
    if (j == 0)
    {
      paramQQAppInterface = this.b;
      if (paramQQAppInterface != null)
      {
        removeView(paramQQAppInterface);
        this.b = null;
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo, ExtensionInfo paramExtensionInfo, MutualMarkIconItemView paramMutualMarkIconItemView)
  {
    if (paramMutualMarkForDisplayInfo.c())
    {
      paramMutualMarkIconItemView.setIconResource(paramMutualMarkForDisplayInfo);
      int k = 0;
      paramMutualMarkIconItemView.setVisibility(0);
      if (AppSetting.e)
      {
        paramQQAppInterface = paramMutualMarkForDisplayInfo.o;
        if (!TextUtils.isEmpty(paramMutualMarkForDisplayInfo.t)) {
          paramQQAppInterface = paramMutualMarkForDisplayInfo.t;
        }
        paramMutualMarkIconItemView.setContentDescription(paramQQAppInterface);
        StringBuilder localStringBuilder = this.h;
        if (localStringBuilder != null) {
          localStringBuilder.append(paramQQAppInterface);
        }
      }
      int j = k;
      if (paramMutualMarkForDisplayInfo.a())
      {
        j = k;
        if (this.a == 3)
        {
          j = k;
          if (!paramMutualMarkForDisplayInfo.j) {
            if ((paramMutualMarkForDisplayInfo.k != 0L) && (System.currentTimeMillis() - paramMutualMarkForDisplayInfo.k > 3500L))
            {
              paramMutualMarkForDisplayInfo.j = true;
              MutualMarkDataCenter.a(paramMutualMarkForDisplayInfo, paramExtensionInfo);
              j = k;
              if (paramExtensionInfo != null)
              {
                HotReactiveHelper.a(paramExtensionInfo);
                j = k;
              }
            }
            else
            {
              paramMutualMarkForDisplayInfo.k = System.currentTimeMillis();
              MutualMarkDataCenter.a(paramMutualMarkForDisplayInfo, paramExtensionInfo);
              paramMutualMarkIconItemView.a(paramString);
              j = 1;
            }
          }
        }
      }
      if (j == 0) {
        paramMutualMarkIconItemView.setIconAlpha(paramMutualMarkForDisplayInfo.d());
      }
      this.g += paramMutualMarkIconItemView.getMaybeWidth();
      return;
    }
    paramMutualMarkIconItemView.setVisibility(8);
  }
  
  private void b()
  {
    Object localObject = this.c;
    int k = 0;
    int j = 0;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      for (;;)
      {
        k = j;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        MutualMarkIconItemView localMutualMarkIconItemView = (MutualMarkIconItemView)((Iterator)localObject).next();
        if ((localMutualMarkIconItemView != null) && (localMutualMarkIconItemView.getVisibility() == 0)) {
          j += localMutualMarkIconItemView.getMaybeWidth();
        }
      }
    }
    this.g = k;
  }
  
  public int a(View paramView, SpecailCareListActivity.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewHolder.n.getLayoutParams();
    int k = 0;
    int j;
    if (localLayoutParams != null) {
      j = localLayoutParams.rightMargin;
    } else {
      j = 0;
    }
    b();
    int m = this.g;
    if (m <= this.f) {
      return m + paramInt1 + j;
    }
    m = paramView.getMeasuredWidth();
    if (m > 0) {
      paramInt2 = m;
    }
    if (paramInt2 <= this.f) {}
    for (paramInt1 = this.g + paramInt1;; paramInt1 = this.g)
    {
      return paramInt1 + j;
      paramInt1 = paramView.getPaddingLeft();
      m = paramView.getPaddingRight();
      int n = a(paramViewHolder.c.getText(), paramViewHolder.c.getTextSize());
      n = Math.min(getResources().getDimensionPixelSize(2131297141), n);
      int i2 = paramViewHolder.c.getCompoundPaddingLeft();
      int i3 = paramViewHolder.c.getCompoundPaddingRight();
      int i4 = paramViewHolder.c.getPaddingRight();
      int i5 = paramViewHolder.c.getPaddingLeft();
      int i1 = AIOUtils.b(72.0F, getResources());
      paramInt2 = paramInt2 - (paramInt1 + m) - i1 - j - n - (i2 + i3 + i4 + i5);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("getMaybeWidthInSpecialCareList maxMutualMarkWidth:");
        paramView.append(paramInt2);
        paramView.append(" maybeWidth:");
        paramView.append(this.g);
        paramView.append(" nickMinWidth:");
        paramView.append(n);
        paramView.append(" nickRootLeft:");
        paramView.append(i1);
        paramView.append(" mutualMarkMarginRight:");
        paramView.append(j);
        QLog.i("MutualMarkIconsView", 2, paramView.toString());
      }
      if (this.g > paramInt2)
      {
        if (this.c != null)
        {
          paramInt1 = k;
          while (paramInt1 < this.c.size())
          {
            paramView = (MutualMarkIconItemView)this.c.get(paramInt1);
            if ((paramView != null) && (paramView.getVisibility() == 0))
            {
              this.g -= paramView.getMaybeWidth();
              paramView.setVisibility(8);
              if (QLog.isColorLevel())
              {
                paramViewHolder = new StringBuilder();
                paramViewHolder.append("getMaybeWidthInSpecialCareList hide Type:");
                paramViewHolder.append(paramView.getMutualMarkType());
                paramViewHolder.append(" width:");
                paramViewHolder.append(paramView.getMaybeWidth());
                QLog.i("MutualMarkIconsView", 2, paramViewHolder.toString());
              }
              if (this.g <= paramInt2) {
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
          paramView.append(this.g);
          QLog.i("MutualMarkIconsView", 2, paramView.toString());
        }
      }
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("getMaybeWidthInSpecialCareList return:");
        paramView.append(this.g);
        QLog.i("MutualMarkIconsView", 2, paramView.toString());
      }
    }
  }
  
  public int a(FriendItemLayout paramFriendItemLayout, BuddyListFriends.BuddyChildTag paramBuddyChildTag, int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramBuddyChildTag.k.getLayoutParams();
    int k = 0;
    int j;
    if (localLayoutParams != null) {
      j = localLayoutParams.rightMargin;
    } else {
      j = 0;
    }
    b();
    int m = this.g;
    if (m <= this.e) {
      return m + paramInt + j;
    }
    m = paramFriendItemLayout.getMeasuredWidth();
    if (m <= this.e) {}
    for (paramInt = this.g + paramInt;; paramInt = this.g)
    {
      return paramInt + j;
      int n = paramFriendItemLayout.getPaddingLeft();
      int i1 = paramFriendItemLayout.getPaddingRight();
      paramInt = a(paramBuddyChildTag.a.getText(), paramBuddyChildTag.a.getTextSize());
      int i2 = Math.min(getResources().getDimensionPixelSize(2131297141), paramInt);
      int i3 = paramBuddyChildTag.a.getCompoundPaddingLeft();
      int i4 = paramBuddyChildTag.a.getCompoundPaddingRight();
      int i5 = paramBuddyChildTag.a.getPaddingRight();
      int i6 = paramBuddyChildTag.a.getPaddingLeft();
      paramFriendItemLayout = (FrameLayout.LayoutParams)paramBuddyChildTag.i.getLayoutParams();
      if (paramFriendItemLayout != null) {
        paramInt = paramFriendItemLayout.leftMargin;
      } else {
        paramInt = 0;
      }
      m = m - (n + i1) - paramInt - i2 - (i3 + i4 + i5 + i6) - paramBuddyChildTag.j.getMeasuredWidth() - j;
      if (QLog.isColorLevel())
      {
        paramFriendItemLayout = new StringBuilder();
        paramFriendItemLayout.append("getMaybeWidthInFriendItemLayout maxMutualMarkWidth:");
        paramFriendItemLayout.append(m);
        paramFriendItemLayout.append(" maybeWidth:");
        paramFriendItemLayout.append(this.g);
        paramFriendItemLayout.append(" nickMinWidth:");
        paramFriendItemLayout.append(i2);
        paramFriendItemLayout.append(" mutualMarkMarginRight:");
        paramFriendItemLayout.append(j);
        QLog.i("MutualMarkIconsView", 2, paramFriendItemLayout.toString());
      }
      if (this.g > m)
      {
        if (this.c != null)
        {
          paramInt = k;
          while (paramInt < this.c.size())
          {
            paramFriendItemLayout = (MutualMarkIconItemView)this.c.get(paramInt);
            if ((paramFriendItemLayout != null) && (paramFriendItemLayout.getVisibility() == 0))
            {
              this.g -= paramFriendItemLayout.getMaybeWidth();
              paramFriendItemLayout.setVisibility(8);
              if (QLog.isColorLevel())
              {
                paramBuddyChildTag = new StringBuilder();
                paramBuddyChildTag.append("getMaybeWidthInFriendItemLayout hide Type:");
                paramBuddyChildTag.append(paramFriendItemLayout.getMutualMarkType());
                paramBuddyChildTag.append(" width:");
                paramBuddyChildTag.append(paramFriendItemLayout.getMaybeWidth());
                QLog.i("MutualMarkIconsView", 2, paramBuddyChildTag.toString());
              }
              if (this.g <= m) {
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
          paramFriendItemLayout.append(this.g);
          QLog.i("MutualMarkIconsView", 2, paramFriendItemLayout.toString());
        }
      }
      if (QLog.isColorLevel())
      {
        paramFriendItemLayout = new StringBuilder();
        paramFriendItemLayout.append("getMaybeWidthInFriendItemLayout return:");
        paramFriendItemLayout.append(this.g);
        QLog.i("MutualMarkIconsView", 2, paramFriendItemLayout.toString());
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (AppSetting.e) {
      this.h = new StringBuilder();
    }
    this.a = paramInt;
    int j = 0;
    ArrayList localArrayList = MutualMarkDataCenter.a(paramQQAppInterface, paramString, false, paramInt);
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      if (this.c == null) {
        this.c = new ArrayList();
      }
      paramInt = this.c.size();
      int k = localArrayList.size();
      if (paramInt < k) {
        while (paramInt < k)
        {
          localObject1 = new MutualMarkIconItemView(getContext());
          addView((View)localObject1, paramInt, new LinearLayout.LayoutParams(-2, this.d));
          this.c.add(localObject1);
          paramInt += 1;
        }
      }
      if (paramInt > k)
      {
        paramInt -= 1;
        while (paramInt >= k)
        {
          removeView((MutualMarkIconItemView)this.c.remove(paramInt));
          paramInt -= 1;
        }
      }
      setVisibility(0);
      this.g = 0;
      long l2 = 0L;
      Object localObject2 = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Object localObject1 = null;
      paramInt = j;
      long l1 = l2;
      if (localObject2 != null)
      {
        localObject1 = ((FriendsManager)localObject2).d(paramString, false);
        l1 = l2;
        paramInt = j;
      }
      while (paramInt < localArrayList.size())
      {
        localObject2 = (MutualMarkForDisplayInfo)localArrayList.get(paramInt);
        a(paramQQAppInterface, paramString, (MutualMarkForDisplayInfo)localObject2, (ExtensionInfo)localObject1, (MutualMarkIconItemView)this.c.get(paramInt));
        if (((MutualMarkForDisplayInfo)localObject2).a == 5L) {
          l1 = ((MutualMarkForDisplayInfo)localObject2).d;
        }
        paramInt += 1;
      }
      a(paramQQAppInterface, paramString, l1);
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView
 * JD-Core Version:    0.7.0.1
 */