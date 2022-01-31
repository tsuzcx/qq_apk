package com.tencent.qqmini.sdk.core.widget;

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
import bgkl;
import bgns;
import bgnt;
import bgnu;
import bgnv;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo.ButtonInfo;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TabBar
  extends LinearLayout
{
  public static final int a;
  private bgnv jdField_a_of_type_Bgnv;
  private TabBarInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo;
  public LinkedList<bgnu> a;
  private boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_Int = DisplayUtil.parseColor("#7F000000");
  }
  
  public TabBar(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    a();
  }
  
  public static int a(Context paramContext)
  {
    return DisplayUtil.dip2px(paramContext, 54.0F);
  }
  
  private void a()
  {
    setOrientation(0);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
  }
  
  private void a(List<TabBarInfo.ButtonInfo> paramList)
  {
    removeAllViews();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        View localView = a((TabBarInfo.ButtonInfo)paramList.get(i), i);
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
  
  private boolean a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.borderStyle;
    }
    return (str.equals("white")) || (str.equalsIgnoreCase("#FFFFFF")) || (str.equalsIgnoreCase("#FFFFFFFF"));
  }
  
  public View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    Object localObject1 = new View(getContext());
    ((View)localObject1).setId(2131370591);
    localRelativeLayout.addView((View)localObject1, new RelativeLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 0.5F)));
    localObject1 = new ImageView(getContext());
    ((ImageView)localObject1).setId(2131367808);
    Object localObject2 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 30.0F), DisplayUtil.dip2px(getContext(), 30.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131370591);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = DisplayUtil.dip2px(getContext(), 2.0F);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new TextView(getContext());
    ((TextView)localObject1).setId(2131370586);
    ((TextView)localObject1).setTextColor(-1);
    ((TextView)localObject1).setTextSize(1, 10.0F);
    ((TextView)localObject1).setPadding(DisplayUtil.dip2px(getContext(), 1.0F), 0, DisplayUtil.dip2px(getContext(), 1.0F), 0);
    ((TextView)localObject1).setBackgroundResource(2130840935);
    ((TextView)localObject1).setVisibility(4);
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setMaxEms(3);
    ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131367808);
    ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131367808);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(getContext());
    ((View)localObject1).setId(2131370590);
    ((View)localObject1).setBackgroundResource(2130840936);
    ((View)localObject1).setVisibility(4);
    localObject2 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 10.0F), DisplayUtil.dip2px(getContext(), 10.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131367808);
    ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131367808);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new TextView(getContext());
    ((TextView)localObject1).setId(2131377552);
    ((TextView)localObject1).setTextSize(1, 12.0F);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131367808);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = DisplayUtil.dip2px(getContext(), 5.0F);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(getContext());
    localObject2 = new RelativeLayout.LayoutParams(-1, 0);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131377552);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(getContext());
    ((View)localObject1).setId(2131370588);
    localObject2 = new RelativeLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 0.5F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131377552);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new LinearLayout(getContext());
    ((LinearLayout)localObject1).setOrientation(0);
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131370588);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new View(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, DisplayUtil.dip2px(getContext(), 2.0F));
    localLayoutParams.weight = 1.0F;
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new View(getContext());
    ((View)localObject2).setId(2131370589);
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
  
  public View a(TabBarInfo.ButtonInfo paramButtonInfo, int paramInt)
  {
    if ((paramButtonInfo == null) || (TextUtils.isEmpty(paramButtonInfo.text))) {
      return null;
    }
    View localView = a();
    bgnu localbgnu = bgnu.a(localView, paramButtonInfo, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo);
    localbgnu.a();
    this.jdField_a_of_type_JavaUtilLinkedList.add(localbgnu);
    localView.setOnClickListener(new bgns(this, paramInt, paramButtonInfo));
    return localView;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != -1) && (paramInt < this.jdField_a_of_type_JavaUtilLinkedList.size()))
    {
      bgnu localbgnu = (bgnu)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
      localbgnu.e.setVisibility(0);
      localbgnu.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (getVisibility() != 0)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo != null) {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.setShow(true);
      }
      setVisibility(0);
      if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo == null)) {
        break label104;
      }
      if (!"top".equals(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.position)) {
        break label96;
      }
    }
    label96:
    for (int i = -getHeight();; i = getHeight())
    {
      setTranslationY(i);
      animate().translationY(0.0F).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator());
      return;
    }
    label104:
    setTranslationY(0.0F);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(int paramInt)
  {
    if ((paramInt != -1) && (paramInt < this.jdField_a_of_type_JavaUtilLinkedList.size())) {
      ((bgnu)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt)).e.setVisibility(4);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (getVisibility() != 8)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo != null) {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.setShow(false);
      }
      if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo == null)) {
        break label107;
      }
      if (!"top".equals(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.position)) {
        break label99;
      }
    }
    label99:
    for (int i = -getHeight();; i = getHeight())
    {
      animate().translationY(i).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new bgnt(this));
      return;
    }
    label107:
    setVisibility(8);
  }
  
  public void c(int paramInt)
  {
    if ((paramInt != -1) && (paramInt < this.jdField_a_of_type_JavaUtilLinkedList.size()))
    {
      bgnu localbgnu = (bgnu)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
      localbgnu.e.setVisibility(4);
      localbgnu.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void d(int paramInt)
  {
    if ((paramInt != -1) && (paramInt < this.jdField_a_of_type_JavaUtilLinkedList.size())) {
      ((bgnu)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt)).jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void setInfo(TabBarInfo paramTabBarInfo)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo = paramTabBarInfo;
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo != null)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo = paramTabBarInfo.clone();
      a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.list);
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
        ((bgnu)this.jdField_a_of_type_JavaUtilLinkedList.getFirst()).a(true);
      }
    }
  }
  
  public void setItemSelected(bgnu parambgnu)
  {
    if (parambgnu != null)
    {
      parambgnu.a(true);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (localIterator.hasNext())
      {
        bgnu localbgnu = (bgnu)localIterator.next();
        if (localbgnu != parambgnu) {
          localbgnu.a(false);
        }
      }
    }
  }
  
  public void setOnTabItemClickListener(bgnv parambgnv)
  {
    this.jdField_a_of_type_Bgnv = parambgnv;
  }
  
  public void setTabBarBadge(int paramInt, String paramString)
  {
    String str;
    if ((paramInt != -1) && (paramInt < this.jdField_a_of_type_JavaUtilLinkedList.size()) && (paramString != null))
    {
      str = paramString;
      if (paramString.length() > 3) {
        str = "...";
      }
      paramString = (bgnu)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
      if (!TextUtils.isEmpty(str)) {
        break label78;
      }
      paramString.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    for (;;)
    {
      paramString.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      paramString.e.setVisibility(4);
      return;
      label78:
      paramString.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void setTabBarItem(int paramInt, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((paramInt != -1) && (paramInt < this.jdField_a_of_type_JavaUtilLinkedList.size()))
    {
      bgnu localbgnu = (bgnu)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
      if (paramString != null) {
        localbgnu.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      }
      if (paramBitmap1 != null) {
        localbgnu.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(getContext().getResources(), paramBitmap1);
      }
      if (paramBitmap2 != null) {
        localbgnu.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(getContext().getResources(), paramBitmap2);
      }
      localbgnu.b();
    }
  }
  
  public void setTabBarStyle(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    TabBarInfo localTabBarInfo = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo;
    int i;
    if (TextUtils.isEmpty(paramString1))
    {
      i = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.color;
      localTabBarInfo.color = i;
      paramString1 = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo;
      if (!TextUtils.isEmpty(paramString2)) {
        break label146;
      }
      i = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.selectedColor;
      label50:
      paramString1.selectedColor = i;
      paramString1 = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo;
      if (!TextUtils.isEmpty(paramString3)) {
        break label155;
      }
      i = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.backgroundColor;
      label77:
      paramString1.backgroundColor = i;
      paramString2 = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo;
      if (!a(paramString4)) {
        break label164;
      }
    }
    label146:
    label155:
    label164:
    for (paramString1 = "white";; paramString1 = "black")
    {
      paramString2.borderStyle = paramString1;
      paramString1 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (paramString1.hasNext()) {
        ((bgnu)paramString1.next()).b();
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
    bgnu localbgnu;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        paramString = bgkl.a(paramString);
        localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      }
      localbgnu = (bgnu)localIterator.next();
    } while (!localbgnu.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo$ButtonInfo.pagePath.equals(paramString));
    setItemSelected(localbgnu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.TabBar
 * JD-Core Version:    0.7.0.1
 */