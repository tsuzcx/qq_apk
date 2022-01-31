package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.mini.apkg.TabBarInfo;
import com.tencent.mobileqq.mini.apkg.TabBarInfo.ButtonInfo;
import com.tencent.mobileqq.mini.util.DisplayUtil;

public class TabBarView$ItemHolder
{
  public TextView badge;
  public View bottomBorder;
  public View bottomSelectedBorder;
  public TabBarInfo.ButtonInfo btnInfo;
  public View btnView;
  public ImageView icon;
  public Drawable iconDrawable;
  public boolean isSelected;
  public View redDot;
  public Drawable selectedDrawable;
  public TabBarInfo tabBarInfo;
  public View topBorder;
  public TextView txt;
  
  public static ItemHolder getItemHolder(View paramView, TabBarInfo.ButtonInfo paramButtonInfo, TabBarInfo paramTabBarInfo)
  {
    ItemHolder localItemHolder = new ItemHolder();
    localItemHolder.txt = ((TextView)paramView.findViewById(2131377606));
    localItemHolder.icon = ((ImageView)paramView.findViewById(2131367819));
    localItemHolder.topBorder = paramView.findViewById(2131378137);
    localItemHolder.bottomBorder = paramView.findViewById(2131363367);
    localItemHolder.bottomSelectedBorder = paramView.findViewById(2131363372);
    localItemHolder.redDot = paramView.findViewById(2131375548);
    localItemHolder.badge = ((TextView)paramView.findViewById(2131363051));
    localItemHolder.badge.setEllipsize(TextUtils.TruncateAt.END);
    localItemHolder.badge.setMaxEms(3);
    localItemHolder.badge.setSingleLine();
    localItemHolder.btnView = paramView;
    localItemHolder.tabBarInfo = paramTabBarInfo;
    localItemHolder.btnInfo = paramButtonInfo;
    return localItemHolder;
  }
  
  public void init()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if ("top".equals(this.tabBarInfo.position))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.txt.getLayoutParams();
      localLayoutParams.bottomMargin = DisplayUtil.dip2px(this.btnView.getContext(), 15.0F);
      localLayoutParams.topMargin = DisplayUtil.dip2px(this.btnView.getContext(), 15.0F);
      this.txt.setLayoutParams(localLayoutParams);
      this.txt.setTextSize(1, 15.0F);
      this.icon.setVisibility(8);
      this.topBorder.setVisibility(8);
      this.bottomBorder.setVisibility(0);
      this.txt.setText(this.btnInfo.text);
      if (!"top".equals(this.tabBarInfo.position)) {
        break label225;
      }
    }
    for (;;)
    {
      invalidateStatus(false);
      return;
      localLayoutParams = (RelativeLayout.LayoutParams)this.txt.getLayoutParams();
      localLayoutParams.bottomMargin = DisplayUtil.dip2px(this.btnView.getContext(), 5.0F);
      localLayoutParams.topMargin = DisplayUtil.dip2px(this.btnView.getContext(), 0.0F);
      this.txt.setLayoutParams(localLayoutParams);
      this.txt.setTextSize(1, 12.0F);
      this.bottomBorder.setVisibility(8);
      this.topBorder.setVisibility(0);
      this.icon.setVisibility(0);
      break;
      label225:
      this.iconDrawable = new BitmapDrawable(this.btnView.getContext().getResources(), this.btnInfo.iconBitmap);
      this.selectedDrawable = new BitmapDrawable(this.btnView.getContext().getResources(), this.btnInfo.selectedBitmap);
    }
  }
  
  public void invalidateStatus(boolean paramBoolean)
  {
    int j = 855638016;
    this.isSelected = paramBoolean;
    this.btnView.setBackgroundColor(this.tabBarInfo.backgroundColor);
    if (!paramBoolean)
    {
      localObject = this.txt;
      if (this.tabBarInfo.color == 0)
      {
        i = TabBarView.TEXT_DEFAULT_COLOR;
        ((TextView)localObject).setTextColor(i);
        if (!"top".equals(this.tabBarInfo.position)) {
          break label147;
        }
        this.bottomSelectedBorder.setVisibility(8);
        label76:
        if (!"top".equals(this.tabBarInfo.position)) {
          break label244;
        }
        localObject = this.bottomBorder;
        if (!"black".equals(this.tabBarInfo.borderStyle)) {
          break label238;
        }
      }
    }
    label147:
    label224:
    label238:
    for (int i = 855638016;; i = 872415231)
    {
      ((View)localObject).setBackgroundColor(i);
      this.bottomSelectedBorder.setBackgroundColor(this.tabBarInfo.selectedColor);
      return;
      i = this.tabBarInfo.color;
      break;
      this.icon.setImageDrawable(this.iconDrawable);
      break label76;
      localObject = this.txt;
      if (this.tabBarInfo.selectedColor == 0) {}
      for (i = TabBarView.TEXT_DEFAULT_COLOR;; i = this.tabBarInfo.selectedColor)
      {
        ((TextView)localObject).setTextColor(i);
        if (!"top".equals(this.tabBarInfo.position)) {
          break label224;
        }
        this.bottomSelectedBorder.setVisibility(0);
        break;
      }
      this.icon.setImageDrawable(this.selectedDrawable);
      break label76;
    }
    label244:
    Object localObject = this.topBorder;
    if ("black".equals(this.tabBarInfo.borderStyle)) {}
    for (i = j;; i = 872415231)
    {
      ((View)localObject).setBackgroundColor(i);
      return;
    }
  }
  
  public void invalidateStatusSelf()
  {
    invalidateStatus(this.isSelected);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.TabBarView.ItemHolder
 * JD-Core Version:    0.7.0.1
 */