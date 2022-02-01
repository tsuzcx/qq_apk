package com.tencent.qqmini.sdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo.ButtonInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TabBar
  extends LinearLayout
{
  public static final int TEXT_DEFAULT_COLOR = DisplayUtil.parseColor("#7F000000");
  private TabBarInfo mInfo;
  public LinkedList<TabBar.ItemHolder> mItemHolders = new LinkedList();
  private TabBar.OnTabItemClickListener mOnTabItemClickListener;
  private boolean needShow = true;
  
  public TabBar(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  private void fillBtnsLayout(List<TabBarInfo.ButtonInfo> paramList)
  {
    removeAllViews();
    this.mItemHolders.clear();
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        View localView = getBtnView((TabBarInfo.ButtonInfo)paramList.get(i), i);
        if (localView != null)
        {
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
          localLayoutParams.weight = 1.0F;
          addView(localView, localLayoutParams);
        }
        i += 1;
      }
    }
  }
  
  public static int getDefaultTabBarHeight(Context paramContext)
  {
    return DisplayUtil.dip2px(paramContext, 54.0F);
  }
  
  private void init()
  {
    setOrientation(0);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
  }
  
  private boolean isWhiteStyle(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = this.mInfo.borderStyle;
    }
    return (str.equals("white")) || (str.equalsIgnoreCase("#FFFFFF")) || (str.equalsIgnoreCase("#FFFFFFFF"));
  }
  
  public View getBtnView(TabBarInfo.ButtonInfo paramButtonInfo, int paramInt)
  {
    if ((paramButtonInfo == null) || (TextUtils.isEmpty(paramButtonInfo.text))) {
      return null;
    }
    View localView = getItemView();
    TabBar.ItemHolder localItemHolder = TabBar.ItemHolder.getItemHolder(localView, paramButtonInfo, this.mInfo);
    localItemHolder.init();
    this.mItemHolders.add(localItemHolder);
    localView.setOnClickListener(new TabBar.1(this, paramInt, paramButtonInfo));
    return localView;
  }
  
  public View getItemView()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    Object localObject1 = new View(getContext());
    ((View)localObject1).setId(R.id.mini_sdk_tab_top_border);
    localRelativeLayout.addView((View)localObject1, new RelativeLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 0.5F)));
    localObject1 = new ImageView(getContext());
    ((ImageView)localObject1).setId(R.id.mini_sdk_tab_icon);
    Object localObject2 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 30.0F), DisplayUtil.dip2px(getContext(), 30.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, R.id.mini_sdk_tab_top_border);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = DisplayUtil.dip2px(getContext(), 2.0F);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new TextView(getContext());
    ((TextView)localObject1).setId(R.id.mini_sdk_tab_badge);
    ((TextView)localObject1).setTextColor(-1);
    ((TextView)localObject1).setTextSize(1, 10.0F);
    ((TextView)localObject1).setPadding(DisplayUtil.dip2px(getContext(), 1.0F), 0, DisplayUtil.dip2px(getContext(), 1.0F), 0);
    ((TextView)localObject1).setBackgroundResource(R.drawable.mini_sdk_red_badge);
    ((TextView)localObject1).setVisibility(4);
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setMaxEms(3);
    ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, R.id.mini_sdk_tab_icon);
    ((RelativeLayout.LayoutParams)localObject2).addRule(1, R.id.mini_sdk_tab_icon);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(getContext());
    ((View)localObject1).setId(R.id.mini_sdk_tab_red_dot);
    ((View)localObject1).setBackgroundResource(R.drawable.mini_sdk_red_dot);
    ((View)localObject1).setVisibility(4);
    localObject2 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 10.0F), DisplayUtil.dip2px(getContext(), 10.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, R.id.mini_sdk_tab_icon);
    ((RelativeLayout.LayoutParams)localObject2).addRule(1, R.id.mini_sdk_tab_icon);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new TextView(getContext());
    ((TextView)localObject1).setId(R.id.mini_sdk_tab_text);
    ((TextView)localObject1).setTextSize(1, 12.0F);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, R.id.mini_sdk_tab_icon);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = DisplayUtil.dip2px(getContext(), 5.0F);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(getContext());
    localObject2 = new RelativeLayout.LayoutParams(-1, 0);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, R.id.mini_sdk_tab_text);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(getContext());
    ((View)localObject1).setId(R.id.mini_sdk_tab_bottom_border);
    localObject2 = new RelativeLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 0.5F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, R.id.mini_sdk_tab_text);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new LinearLayout(getContext());
    ((LinearLayout)localObject1).setOrientation(0);
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(8, R.id.mini_sdk_tab_bottom_border);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new View(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, DisplayUtil.dip2px(getContext(), 2.0F));
    localLayoutParams.weight = 1.0F;
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new View(getContext());
    ((View)localObject2).setId(R.id.mini_sdk_tab_bottom_selected_border);
    ((View)localObject2).setVisibility(8);
    localLayoutParams = new LinearLayout.LayoutParams(0, DisplayUtil.dip2px(getContext(), 2.0F));
    localLayoutParams.weight = 3.0F;
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new View(getContext());
    localLayoutParams = new LinearLayout.LayoutParams(0, DisplayUtil.dip2px(getContext(), 2.0F));
    localLayoutParams.weight = 1.0F;
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
    return localRelativeLayout;
  }
  
  public boolean getNeedShow()
  {
    return this.needShow;
  }
  
  public void hideBadge(int paramInt)
  {
    if ((paramInt != -1) && (paramInt < this.mItemHolders.size()))
    {
      TabBar.ItemHolder localItemHolder = (TabBar.ItemHolder)this.mItemHolders.get(paramInt);
      localItemHolder.redDot.setVisibility(4);
      localItemHolder.badge.setVisibility(4);
    }
  }
  
  public void hideTabBar(boolean paramBoolean)
  {
    if (getVisibility() != 8)
    {
      this.needShow = false;
      if (this.mInfo != null) {
        this.mInfo.setShow(false);
      }
      if ((!paramBoolean) || (this.mInfo == null)) {
        break label108;
      }
      if (!"top".equals(this.mInfo.position)) {
        break label100;
      }
    }
    label100:
    for (int i = -getHeight();; i = getHeight())
    {
      animate().translationY(i).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new TabBar.2(this));
      return;
    }
    label108:
    setVisibility(8);
  }
  
  public void hideTabBarRedDot(int paramInt)
  {
    if ((paramInt != -1) && (paramInt < this.mItemHolders.size())) {
      ((TabBar.ItemHolder)this.mItemHolders.get(paramInt)).redDot.setVisibility(4);
    }
  }
  
  public void removeTabBarBadge(int paramInt)
  {
    if ((paramInt != -1) && (paramInt < this.mItemHolders.size())) {
      ((TabBar.ItemHolder)this.mItemHolders.get(paramInt)).badge.setVisibility(4);
    }
  }
  
  public void setInfo(TabBarInfo paramTabBarInfo)
  {
    this.mInfo = paramTabBarInfo;
    if (this.mInfo != null)
    {
      this.mInfo = paramTabBarInfo.clone();
      fillBtnsLayout(this.mInfo.list);
      if (this.mItemHolders.size() > 0) {
        ((TabBar.ItemHolder)this.mItemHolders.getFirst()).invalidateStatus(true);
      }
    }
  }
  
  public void setItemSelected(TabBar.ItemHolder paramItemHolder)
  {
    if (paramItemHolder != null)
    {
      paramItemHolder.invalidateStatus(true);
      Iterator localIterator = this.mItemHolders.iterator();
      while (localIterator.hasNext())
      {
        TabBar.ItemHolder localItemHolder = (TabBar.ItemHolder)localIterator.next();
        if (localItemHolder != paramItemHolder) {
          localItemHolder.invalidateStatus(false);
        }
      }
    }
  }
  
  public void setOnTabItemClickListener(TabBar.OnTabItemClickListener paramOnTabItemClickListener)
  {
    this.mOnTabItemClickListener = paramOnTabItemClickListener;
  }
  
  public void setTabBarBadge(int paramInt, String paramString)
  {
    String str;
    if ((paramInt != -1) && (paramInt < this.mItemHolders.size()) && (paramString != null))
    {
      str = paramString;
      if (paramString.length() > 3) {
        str = "...";
      }
      paramString = (TabBar.ItemHolder)this.mItemHolders.get(paramInt);
      if (!TextUtils.isEmpty(str)) {
        break label78;
      }
      paramString.badge.setVisibility(4);
    }
    for (;;)
    {
      paramString.badge.setText(str);
      paramString.redDot.setVisibility(4);
      return;
      label78:
      paramString.badge.setVisibility(0);
    }
  }
  
  public void setTabBarItem(int paramInt, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((paramInt != -1) && (paramInt < this.mItemHolders.size()))
    {
      TabBar.ItemHolder localItemHolder = (TabBar.ItemHolder)this.mItemHolders.get(paramInt);
      if (paramString != null) {
        localItemHolder.txt.setText(paramString);
      }
      if (paramBitmap1 != null) {
        localItemHolder.iconDrawable = new BitmapDrawable(getContext().getResources(), paramBitmap1);
      }
      if (paramBitmap2 != null) {
        localItemHolder.selectedDrawable = new BitmapDrawable(getContext().getResources(), paramBitmap2);
      }
      localItemHolder.invalidateStatusSelf();
    }
  }
  
  public void setTabBarStyle(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    TabBarInfo localTabBarInfo = this.mInfo;
    int i;
    if (TextUtils.isEmpty(paramString1))
    {
      i = this.mInfo.color;
      localTabBarInfo.color = i;
      paramString1 = this.mInfo;
      if (!TextUtils.isEmpty(paramString2)) {
        break label146;
      }
      i = this.mInfo.selectedColor;
      label50:
      paramString1.selectedColor = i;
      paramString1 = this.mInfo;
      if (!TextUtils.isEmpty(paramString3)) {
        break label155;
      }
      i = this.mInfo.backgroundColor;
      label77:
      paramString1.backgroundColor = i;
      paramString2 = this.mInfo;
      if (!isWhiteStyle(paramString4)) {
        break label164;
      }
    }
    label146:
    label155:
    label164:
    for (paramString1 = "white";; paramString1 = "black")
    {
      paramString2.borderStyle = paramString1;
      paramString1 = this.mItemHolders.iterator();
      while (paramString1.hasNext()) {
        ((TabBar.ItemHolder)paramString1.next()).invalidateStatusSelf();
      }
      i = DisplayUtil.parseColor(paramString1);
      break;
      i = DisplayUtil.parseColor(paramString2);
      break label50;
      i = DisplayUtil.parseColor(paramString3);
      break label77;
    }
  }
  
  public void setTabSelected(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    TabBar.ItemHolder localItemHolder;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        paramString = AppBrandUtil.getUrlWithoutParams(paramString);
        localIterator = this.mItemHolders.iterator();
      }
      localItemHolder = (TabBar.ItemHolder)localIterator.next();
    } while (!localItemHolder.btnInfo.pagePath.equals(paramString));
    setItemSelected(localItemHolder);
  }
  
  public void showTabBar(boolean paramBoolean)
  {
    if (getVisibility() != 0)
    {
      this.needShow = true;
      if (this.mInfo != null) {
        this.mInfo.setShow(true);
      }
      setVisibility(0);
      if ((!paramBoolean) || (this.mInfo == null)) {
        break label105;
      }
      if (!"top".equals(this.mInfo.position)) {
        break label97;
      }
    }
    label97:
    for (int i = -getHeight();; i = getHeight())
    {
      setTranslationY(i);
      animate().translationY(0.0F).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator());
      return;
    }
    label105:
    setTranslationY(0.0F);
  }
  
  public void showTabBarRedDot(int paramInt)
  {
    if ((paramInt != -1) && (paramInt < this.mItemHolders.size()))
    {
      TabBar.ItemHolder localItemHolder = (TabBar.ItemHolder)this.mItemHolders.get(paramInt);
      localItemHolder.redDot.setVisibility(0);
      localItemHolder.badge.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.TabBar
 * JD-Core Version:    0.7.0.1
 */