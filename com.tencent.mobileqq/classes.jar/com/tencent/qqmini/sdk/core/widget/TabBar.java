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
import bdgj;
import bdix;
import bdiy;
import bdiz;
import bdja;
import bdni;
import bdnj;
import bdyn;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TabBar
  extends LinearLayout
{
  public static final int a;
  private bdja jdField_a_of_type_Bdja;
  private bdni jdField_a_of_type_Bdni;
  public LinkedList<bdiz> a;
  private boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_Int = bdyn.a("#7F000000");
  }
  
  public TabBar(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    a();
  }
  
  public static int a(Context paramContext)
  {
    return bdyn.a(paramContext, 54.0F);
  }
  
  private void a()
  {
    setOrientation(0);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
  }
  
  private void a(List<bdnj> paramList)
  {
    removeAllViews();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        View localView = a((bdnj)paramList.get(i), i);
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
      str = this.jdField_a_of_type_Bdni.jdField_a_of_type_JavaLangString;
    }
    return (str.equals("white")) || (str.equalsIgnoreCase("#FFFFFF")) || (str.equalsIgnoreCase("#FFFFFFFF"));
  }
  
  public View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    Object localObject1 = new View(getContext());
    ((View)localObject1).setId(2131304610);
    localRelativeLayout.addView((View)localObject1, new RelativeLayout.LayoutParams(-1, bdyn.a(getContext(), 0.5F)));
    localObject1 = new ImageView(getContext());
    ((ImageView)localObject1).setId(2131302061);
    Object localObject2 = new RelativeLayout.LayoutParams(bdyn.a(getContext(), 30.0F), bdyn.a(getContext(), 30.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131304610);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = bdyn.a(getContext(), 2.0F);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new TextView(getContext());
    ((TextView)localObject1).setId(2131304605);
    ((TextView)localObject1).setTextColor(-1);
    ((TextView)localObject1).setTextSize(1, 10.0F);
    ((TextView)localObject1).setPadding(bdyn.a(getContext(), 1.0F), 0, bdyn.a(getContext(), 1.0F), 0);
    ((TextView)localObject1).setBackgroundResource(2130840776);
    ((TextView)localObject1).setVisibility(4);
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setMaxEms(3);
    ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131302061);
    ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131302061);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(getContext());
    ((View)localObject1).setId(2131304609);
    ((View)localObject1).setBackgroundResource(2130840777);
    ((View)localObject1).setVisibility(4);
    localObject2 = new RelativeLayout.LayoutParams(bdyn.a(getContext(), 10.0F), bdyn.a(getContext(), 10.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131302061);
    ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131302061);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new TextView(getContext());
    ((TextView)localObject1).setId(2131311220);
    ((TextView)localObject1).setTextSize(1, 12.0F);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131302061);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = bdyn.a(getContext(), 5.0F);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(getContext());
    localObject2 = new RelativeLayout.LayoutParams(-1, 0);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131311220);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(getContext());
    ((View)localObject1).setId(2131304607);
    localObject2 = new RelativeLayout.LayoutParams(-1, bdyn.a(getContext(), 0.5F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131311220);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new LinearLayout(getContext());
    ((LinearLayout)localObject1).setOrientation(0);
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131304607);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new View(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, bdyn.a(getContext(), 2.0F));
    localLayoutParams.weight = 1.0F;
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new View(getContext());
    ((View)localObject2).setId(2131304608);
    ((View)localObject2).setVisibility(8);
    localLayoutParams = new LinearLayout.LayoutParams(0, bdyn.a(getContext(), 2.0F));
    localLayoutParams.weight = 3.0F;
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new View(getContext());
    localLayoutParams = new LinearLayout.LayoutParams(0, bdyn.a(getContext(), 2.0F));
    localLayoutParams.weight = 1.0F;
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
    return localRelativeLayout;
  }
  
  public View a(bdnj parambdnj, int paramInt)
  {
    if ((parambdnj == null) || (TextUtils.isEmpty(parambdnj.jdField_b_of_type_JavaLangString))) {
      return null;
    }
    View localView = a();
    bdiz localbdiz = bdiz.a(localView, parambdnj, this.jdField_a_of_type_Bdni);
    localbdiz.a();
    this.jdField_a_of_type_JavaUtilLinkedList.add(localbdiz);
    localView.setOnClickListener(new bdix(this, paramInt, parambdnj));
    return localView;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != -1) && (paramInt < this.jdField_a_of_type_JavaUtilLinkedList.size()))
    {
      bdiz localbdiz = (bdiz)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
      localbdiz.e.setVisibility(0);
      localbdiz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (getVisibility() != 0)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Bdni != null) {
        this.jdField_a_of_type_Bdni.a(true);
      }
      setVisibility(0);
      if ((!paramBoolean) || (this.jdField_a_of_type_Bdni == null)) {
        break label104;
      }
      if (!"top".equals(this.jdField_a_of_type_Bdni.jdField_b_of_type_JavaLangString)) {
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
      ((bdiz)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt)).e.setVisibility(4);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (getVisibility() != 8)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Bdni != null) {
        this.jdField_a_of_type_Bdni.a(false);
      }
      if ((!paramBoolean) || (this.jdField_a_of_type_Bdni == null)) {
        break label107;
      }
      if (!"top".equals(this.jdField_a_of_type_Bdni.jdField_b_of_type_JavaLangString)) {
        break label99;
      }
    }
    label99:
    for (int i = -getHeight();; i = getHeight())
    {
      animate().translationY(i).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new bdiy(this));
      return;
    }
    label107:
    setVisibility(8);
  }
  
  public void c(int paramInt)
  {
    if ((paramInt != -1) && (paramInt < this.jdField_a_of_type_JavaUtilLinkedList.size()))
    {
      bdiz localbdiz = (bdiz)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
      localbdiz.e.setVisibility(4);
      localbdiz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void d(int paramInt)
  {
    if ((paramInt != -1) && (paramInt < this.jdField_a_of_type_JavaUtilLinkedList.size())) {
      ((bdiz)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt)).jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void setInfo(bdni parambdni)
  {
    this.jdField_a_of_type_Bdni = parambdni;
    if (this.jdField_a_of_type_Bdni != null)
    {
      this.jdField_a_of_type_Bdni = parambdni.a();
      a(this.jdField_a_of_type_Bdni.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
        ((bdiz)this.jdField_a_of_type_JavaUtilLinkedList.getFirst()).a(true);
      }
    }
  }
  
  public void setItemSelected(bdiz parambdiz)
  {
    if (parambdiz != null)
    {
      parambdiz.a(true);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (localIterator.hasNext())
      {
        bdiz localbdiz = (bdiz)localIterator.next();
        if (localbdiz != parambdiz) {
          localbdiz.a(false);
        }
      }
    }
  }
  
  public void setOnTabItemClickListener(bdja parambdja)
  {
    this.jdField_a_of_type_Bdja = parambdja;
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
      paramString = (bdiz)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
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
      bdiz localbdiz = (bdiz)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
      if (paramString != null) {
        localbdiz.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      }
      if (paramBitmap1 != null) {
        localbdiz.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(getContext().getResources(), paramBitmap1);
      }
      if (paramBitmap2 != null) {
        localbdiz.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(getContext().getResources(), paramBitmap2);
      }
      localbdiz.b();
    }
  }
  
  public void setTabBarStyle(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    bdni localbdni = this.jdField_a_of_type_Bdni;
    int i;
    if (TextUtils.isEmpty(paramString1))
    {
      i = this.jdField_a_of_type_Bdni.jdField_a_of_type_Int;
      localbdni.jdField_a_of_type_Int = i;
      paramString1 = this.jdField_a_of_type_Bdni;
      if (!TextUtils.isEmpty(paramString2)) {
        break label146;
      }
      i = this.jdField_a_of_type_Bdni.jdField_b_of_type_Int;
      label50:
      paramString1.jdField_b_of_type_Int = i;
      paramString1 = this.jdField_a_of_type_Bdni;
      if (!TextUtils.isEmpty(paramString3)) {
        break label155;
      }
      i = this.jdField_a_of_type_Bdni.c;
      label77:
      paramString1.c = i;
      paramString2 = this.jdField_a_of_type_Bdni;
      if (!a(paramString4)) {
        break label164;
      }
    }
    label146:
    label155:
    label164:
    for (paramString1 = "white";; paramString1 = "black")
    {
      paramString2.jdField_a_of_type_JavaLangString = paramString1;
      paramString1 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (paramString1.hasNext()) {
        ((bdiz)paramString1.next()).b();
      }
      i = bdyn.a(paramString1);
      break;
      i = bdyn.a(paramString2);
      break label50;
      i = bdyn.a(paramString3);
      break label77;
    }
  }
  
  public void setTabSelected(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    bdiz localbdiz;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        paramString = bdgj.a(paramString);
        localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      }
      localbdiz = (bdiz)localIterator.next();
    } while (!localbdiz.jdField_a_of_type_Bdnj.jdField_a_of_type_JavaLangString.equals(paramString));
    setItemSelected(localbdiz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.TabBar
 * JD-Core Version:    0.7.0.1
 */