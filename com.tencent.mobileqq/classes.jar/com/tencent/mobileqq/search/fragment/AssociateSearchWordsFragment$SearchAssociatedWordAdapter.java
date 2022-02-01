package com.tencent.mobileqq.search.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class AssociateSearchWordsFragment$SearchAssociatedWordAdapter
  extends BaseAdapter
{
  private List<AssociateSearchWordsFragment.AssociateItem> b = new ArrayList();
  
  public AssociateSearchWordsFragment$SearchAssociatedWordAdapter(List<AssociateSearchWordsFragment.AssociateItem> paramList)
  {
    Object localObject;
    this.b = localObject;
  }
  
  public void a(List<AssociateSearchWordsFragment.AssociateItem> paramList)
  {
    this.b = paramList;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.b;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.b;
    if (localList == null) {
      return null;
    }
    return localList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    switch (((AssociateSearchWordsFragment.AssociateItem)this.b.get(paramInt)).a)
    {
    default: 
      return 0;
    case 6: 
      return 5;
    case 3: 
      return 2;
    case 2: 
    case 4: 
    case 5: 
      return 3;
    case 1: 
      return 4;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AssociateSearchWordsFragment.AssociateItem localAssociateItem = (AssociateSearchWordsFragment.AssociateItem)this.b.get(paramInt);
    Object localObject2 = this.a.getBaseActivity();
    boolean bool1 = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    Object localObject3;
    if (paramView == null)
    {
      localObject3 = new AssociateSearchWordsFragment.ViewHolder(this.a);
      localObject1 = new LinearLayout((Context)localObject2);
      ((LinearLayout)localObject1).setPadding(DisplayUtil.a((Context)localObject2, 12.0F), 0, DisplayUtil.a((Context)localObject2, 12.0F), 0);
      ((LinearLayout)localObject1).setOrientation(1);
      i = getItemViewType(paramInt);
      if (i != 0)
      {
        Object localObject4;
        if (i != 1)
        {
          if (i != 2) {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i != 5) {
                  break label1011;
                }
              }
              else
              {
                paramView = new TextView((Context)localObject2);
                paramView.setHeight(1);
                ((LinearLayout)localObject1).addView(paramView);
                ((LinearLayout)localObject1).setPadding(DisplayUtil.a((Context)localObject2, 12.0F), 0, 0, 0);
                ((AssociateSearchWordsFragment.ViewHolder)localObject3).c = paramView;
                ((LinearLayout)localObject1).setClickable(false);
                ((LinearLayout)localObject1).setFocusable(false);
                paramView = (View)localObject1;
                break label1011;
              }
            }
            else
            {
              paramView = new TextView((Context)localObject2);
              paramView.setTextColor(((Context)localObject2).getResources().getColor(2131167993));
              paramView.setTextSize(1, 18.0F);
              paramView.setIncludeFontPadding(false);
              ((LinearLayout)localObject1).addView(paramView);
              ((AssociateSearchWordsFragment.ViewHolder)localObject3).a = paramView;
              paramView = new TextView((Context)localObject2);
              paramView.setTextColor(((Context)localObject2).getResources().getColor(2131168118));
              paramView.setTextSize(1, 14.0F);
              paramView.setIncludeFontPadding(false);
              ((LinearLayout)localObject1).addView(paramView);
              ((AssociateSearchWordsFragment.ViewHolder)localObject3).b = paramView;
              ((View)localObject1).setOnClickListener(this.a.e);
              paramView = (View)localObject1;
              break label1011;
            }
          }
          paramView = new TextView((Context)localObject2);
          paramView.setGravity(19);
          paramView.setTextColor(((Context)localObject2).getResources().getColor(2131167993));
          if (getItemViewType(paramInt) == 5) {
            paramView.setTextSize(1, 16.0F);
          } else {
            paramView.setTextSize(1, 18.0F);
          }
          paramView.setSingleLine();
          paramView.setEllipsize(TextUtils.TruncateAt.END);
          paramView.setIncludeFontPadding(false);
          if (getItemViewType(paramInt) == 5)
          {
            localObject4 = new LinearLayout((Context)localObject2);
            ((LinearLayout)localObject4).setOrientation(0);
            ((LinearLayout)localObject1).addView((View)localObject4, new LinearLayout.LayoutParams(-1, DisplayUtil.a((Context)localObject2, 52.0F)));
            if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, ""))
            {
              localObject5 = ((Context)localObject2).getResources().getDrawable(2130852494);
              ((Drawable)localObject5).setColorFilter(BaseApplicationImpl.sApplication.getResources().getColor(2131167906), PorterDuff.Mode.SRC_ATOP);
              paramView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject5, null, null, null);
            }
            else
            {
              paramView.setCompoundDrawablesWithIntrinsicBounds(((Context)localObject2).getResources().getDrawable(2130852494), null, null, null);
            }
            paramView.setCompoundDrawablePadding(DisplayUtil.a((Context)localObject2, 8.0F));
            Object localObject5 = new LinearLayout.LayoutParams(-1, -1);
            ((LinearLayout.LayoutParams)localObject5).weight = 1.0F;
            ((LinearLayout)localObject4).addView(paramView, (ViewGroup.LayoutParams)localObject5);
            localObject5 = new ImageView((Context)localObject2);
            if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, ""))
            {
              ((ImageView)localObject5).setImageResource(2130852501);
              ((ImageView)localObject5).setColorFilter(BaseApplicationImpl.sApplication.getResources().getColor(2131167906));
            }
            else
            {
              ((ImageView)localObject5).setImageResource(2130852501);
            }
            ((LinearLayout)localObject4).addView((View)localObject5, new LinearLayout.LayoutParams(-2, -1));
            ((ImageView)localObject5).setOnClickListener(new AssociateSearchWordsFragment.SearchAssociatedWordAdapter.1(this, localAssociateItem.b, paramInt));
            boolean bool2 = ThemeUtil.isNowThemeIsDefault(BaseApplicationImpl.getApplication().getRuntime(), false, null);
            if ((!bool1) && (!bool2))
            {
              localObject4 = new TextView((Context)localObject2);
              ((TextView)localObject4).setPadding(DisplayUtil.a((Context)localObject2, 12.0F), 0, 0, 0);
              ((TextView)localObject4).setBackgroundColor(((Context)localObject2).getResources().getColor(2131167918));
              ((TextView)localObject4).setHeight(1);
              localObject5 = new LinearLayout.LayoutParams(-1, -2);
              ((AssociateSearchWordsFragment.ViewHolder)localObject3).c = ((TextView)localObject4);
              ((LinearLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
            }
          }
          else
          {
            paramView.setCompoundDrawablesWithIntrinsicBounds(((Context)localObject2).getResources().getDrawable(2130852493), null, null, null);
            paramView.setCompoundDrawablePadding(DisplayUtil.a((Context)localObject2, 4.0F));
            localObject4 = new LinearLayout.LayoutParams(-1, -2);
            ((LinearLayout.LayoutParams)localObject4).setMargins(0, DisplayUtil.a((Context)localObject2, 16.0F), 0, DisplayUtil.a((Context)localObject2, 16.0F));
            ((LinearLayout)localObject1).addView(paramView, (ViewGroup.LayoutParams)localObject4);
          }
          ((AssociateSearchWordsFragment.ViewHolder)localObject3).a = paramView;
          ((View)localObject1).setOnClickListener(this.a.e);
          paramView = (View)localObject1;
        }
        else
        {
          paramView = new TextView((Context)localObject2);
          paramView.setBackgroundColor(Color.parseColor("#F7F7F9"));
          paramView.setHeight(DisplayUtil.a((Context)localObject2, 10.0F));
          localObject4 = new LinearLayout.LayoutParams(-1, -2);
          ((AssociateSearchWordsFragment.ViewHolder)localObject3).c = paramView;
          ((LinearLayout)localObject1).addView(paramView, (ViewGroup.LayoutParams)localObject4);
          paramView = new TextView((Context)localObject2);
          paramView.setTextColor(((Context)localObject2).getResources().getColor(2131168118));
          paramView.setTextSize(1, 15.0F);
          paramView.setGravity(16);
          paramView.setIncludeFontPadding(false);
          paramView.setHeight(((Context)localObject2).getResources().getDimensionPixelSize(2131299262));
          paramView.setPadding(DisplayUtil.a((Context)localObject2, 12.0F), 0, DisplayUtil.a((Context)localObject2, 12.0F), 0);
          ((LinearLayout)localObject1).addView(paramView, new LinearLayout.LayoutParams(-1, -2));
          ((LinearLayout)localObject1).setClickable(false);
          ((LinearLayout)localObject1).setFocusable(false);
          ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
          ((AssociateSearchWordsFragment.ViewHolder)localObject3).a = paramView;
          paramView = (View)localObject1;
        }
        label1011:
        paramView.setTag(localObject3);
        paramView.setBackgroundResource(2130843372);
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("SearchAssociatedWordAdapter.getView() itemType not support. value=");
          ((StringBuilder)localObject1).append(getItemViewType(paramInt));
          QLog.e("Q.uniteSearch.AssociateSearchWordsFragment", 2, ((StringBuilder)localObject1).toString());
        }
        localAssociateItem = null;
        localObject1 = paramView;
        paramView = localAssociateItem;
        break label1595;
      }
    }
    Object localObject1 = (AssociateSearchWordsFragment.ViewHolder)paramView.getTag();
    int i = getItemViewType(paramInt);
    if (i != 1)
    {
      if (i != 2) {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              break label1550;
            }
          }
          else
          {
            if (bool1)
            {
              ((AssociateSearchWordsFragment.ViewHolder)localObject1).c.setBackgroundColor(((Context)localObject2).getResources().getColor(2131167919));
              break label1550;
            }
            ((AssociateSearchWordsFragment.ViewHolder)localObject1).c.setBackgroundColor(((Context)localObject2).getResources().getColor(2131167918));
            break label1550;
          }
        }
        else
        {
          ((AssociateSearchWordsFragment.ViewHolder)localObject1).a.setText(localAssociateItem.b);
          ((AssociateSearchWordsFragment.ViewHolder)localObject1).b.setText(localAssociateItem.h);
          if (TextUtils.isEmpty(localAssociateItem.b))
          {
            ((AssociateSearchWordsFragment.ViewHolder)localObject1).a.setVisibility(8);
            ((LinearLayout.LayoutParams)((AssociateSearchWordsFragment.ViewHolder)localObject1).b.getLayoutParams()).setMargins(0, DisplayUtil.a((Context)localObject2, 16.0F), 0, DisplayUtil.a((Context)localObject2, 16.0F));
            break label1550;
          }
          ((AssociateSearchWordsFragment.ViewHolder)localObject1).a.setVisibility(0);
          localObject3 = (LinearLayout.LayoutParams)((AssociateSearchWordsFragment.ViewHolder)localObject1).a.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject3).setMargins(0, DisplayUtil.a((Context)localObject2, 12.0F), 0, 0);
          ((AssociateSearchWordsFragment.ViewHolder)localObject1).a.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject3 = (LinearLayout.LayoutParams)((AssociateSearchWordsFragment.ViewHolder)localObject1).b.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject3).setMargins(0, DisplayUtil.a((Context)localObject2, 5.0F), 0, DisplayUtil.a((Context)localObject2, 12.0F));
          ((AssociateSearchWordsFragment.ViewHolder)localObject1).b.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          break label1550;
        }
      }
      if (this.a.c)
      {
        if (getItemViewType(paramInt) == 2)
        {
          localObject2 = SearchUtils.a(((AssociateSearchWordsFragment.ViewHolder)localObject1).a, 2.147484E+009F, 1, localAssociateItem.b, this.a.d, false, false, true);
          ((AssociateSearchWordsFragment.ViewHolder)localObject1).a.setText((CharSequence)localObject2);
        }
        else
        {
          localObject2 = SearchUtils.a(localAssociateItem.b, this.a.d, false);
          ((AssociateSearchWordsFragment.ViewHolder)localObject1).a.setText((CharSequence)localObject2);
        }
      }
      else {
        ((AssociateSearchWordsFragment.ViewHolder)localObject1).a.setText(localAssociateItem.b);
      }
    }
    else
    {
      if (paramInt == 0)
      {
        ((AssociateSearchWordsFragment.ViewHolder)localObject1).c.setVisibility(8);
      }
      else
      {
        ((AssociateSearchWordsFragment.ViewHolder)localObject1).c.setVisibility(0);
        if (bool1) {
          ((AssociateSearchWordsFragment.ViewHolder)localObject1).c.setBackgroundColor(((Context)localObject2).getResources().getColor(2131167919));
        } else {
          ((AssociateSearchWordsFragment.ViewHolder)localObject1).c.setBackgroundColor(((Context)localObject2).getResources().getColor(2131167918));
        }
      }
      ((AssociateSearchWordsFragment.ViewHolder)localObject1).a.setText(localAssociateItem.b);
    }
    label1550:
    if (bool1) {
      paramView.setBackgroundResource(2130839569);
    } else {
      paramView.setBackgroundResource(2130839568);
    }
    paramView.setTag(2131449868, Integer.valueOf(paramInt));
    paramView.setTag(2131449867, localAssociateItem);
    localObject1 = paramView;
    label1595:
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.SearchAssociatedWordAdapter
 * JD-Core Version:    0.7.0.1
 */