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
import bekj;
import bena;
import benb;
import benc;
import bend;
import berw;
import berx;
import bffu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TabBar
  extends LinearLayout
{
  public static final int a;
  private bend jdField_a_of_type_Bend;
  private berw jdField_a_of_type_Berw;
  public LinkedList<benc> a;
  private boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_Int = bffu.a("#7F000000");
  }
  
  public TabBar(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    a();
  }
  
  public static int a(Context paramContext)
  {
    return bffu.a(paramContext, 54.0F);
  }
  
  private void a()
  {
    setOrientation(0);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
  }
  
  private void a(List<berx> paramList)
  {
    removeAllViews();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        View localView = a((berx)paramList.get(i), i);
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
      str = this.jdField_a_of_type_Berw.jdField_a_of_type_JavaLangString;
    }
    return (str.equals("white")) || (str.equalsIgnoreCase("#FFFFFF")) || (str.equalsIgnoreCase("#FFFFFFFF"));
  }
  
  public View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    Object localObject1 = new View(getContext());
    ((View)localObject1).setId(2131370295);
    localRelativeLayout.addView((View)localObject1, new RelativeLayout.LayoutParams(-1, bffu.a(getContext(), 0.5F)));
    localObject1 = new ImageView(getContext());
    ((ImageView)localObject1).setId(2131367679);
    Object localObject2 = new RelativeLayout.LayoutParams(bffu.a(getContext(), 30.0F), bffu.a(getContext(), 30.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131370295);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = bffu.a(getContext(), 2.0F);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new TextView(getContext());
    ((TextView)localObject1).setId(2131370290);
    ((TextView)localObject1).setTextColor(-1);
    ((TextView)localObject1).setTextSize(1, 10.0F);
    ((TextView)localObject1).setPadding(bffu.a(getContext(), 1.0F), 0, bffu.a(getContext(), 1.0F), 0);
    ((TextView)localObject1).setBackgroundResource(2130840826);
    ((TextView)localObject1).setVisibility(4);
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setMaxEms(3);
    ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131367679);
    ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131367679);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(getContext());
    ((View)localObject1).setId(2131370294);
    ((View)localObject1).setBackgroundResource(2130840827);
    ((View)localObject1).setVisibility(4);
    localObject2 = new RelativeLayout.LayoutParams(bffu.a(getContext(), 10.0F), bffu.a(getContext(), 10.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131367679);
    ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131367679);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new TextView(getContext());
    ((TextView)localObject1).setId(2131377030);
    ((TextView)localObject1).setTextSize(1, 12.0F);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131367679);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = bffu.a(getContext(), 5.0F);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(getContext());
    localObject2 = new RelativeLayout.LayoutParams(-1, 0);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131377030);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(getContext());
    ((View)localObject1).setId(2131370292);
    localObject2 = new RelativeLayout.LayoutParams(-1, bffu.a(getContext(), 0.5F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131377030);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new LinearLayout(getContext());
    ((LinearLayout)localObject1).setOrientation(0);
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131370292);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new View(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, bffu.a(getContext(), 2.0F));
    localLayoutParams.weight = 1.0F;
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new View(getContext());
    ((View)localObject2).setId(2131370293);
    ((View)localObject2).setVisibility(8);
    localLayoutParams = new LinearLayout.LayoutParams(0, bffu.a(getContext(), 2.0F));
    localLayoutParams.weight = 3.0F;
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new View(getContext());
    localLayoutParams = new LinearLayout.LayoutParams(0, bffu.a(getContext(), 2.0F));
    localLayoutParams.weight = 1.0F;
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
    return localRelativeLayout;
  }
  
  public View a(berx paramberx, int paramInt)
  {
    if ((paramberx == null) || (TextUtils.isEmpty(paramberx.jdField_b_of_type_JavaLangString))) {
      return null;
    }
    View localView = a();
    benc localbenc = benc.a(localView, paramberx, this.jdField_a_of_type_Berw);
    localbenc.a();
    this.jdField_a_of_type_JavaUtilLinkedList.add(localbenc);
    localView.setOnClickListener(new bena(this, paramInt, paramberx));
    return localView;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != -1) && (paramInt < this.jdField_a_of_type_JavaUtilLinkedList.size()))
    {
      benc localbenc = (benc)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
      localbenc.e.setVisibility(0);
      localbenc.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (getVisibility() != 0)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Berw != null) {
        this.jdField_a_of_type_Berw.a(true);
      }
      setVisibility(0);
      if ((!paramBoolean) || (this.jdField_a_of_type_Berw == null)) {
        break label104;
      }
      if (!"top".equals(this.jdField_a_of_type_Berw.jdField_b_of_type_JavaLangString)) {
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
      ((benc)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt)).e.setVisibility(4);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (getVisibility() != 8)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Berw != null) {
        this.jdField_a_of_type_Berw.a(false);
      }
      if ((!paramBoolean) || (this.jdField_a_of_type_Berw == null)) {
        break label107;
      }
      if (!"top".equals(this.jdField_a_of_type_Berw.jdField_b_of_type_JavaLangString)) {
        break label99;
      }
    }
    label99:
    for (int i = -getHeight();; i = getHeight())
    {
      animate().translationY(i).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new benb(this));
      return;
    }
    label107:
    setVisibility(8);
  }
  
  public void c(int paramInt)
  {
    if ((paramInt != -1) && (paramInt < this.jdField_a_of_type_JavaUtilLinkedList.size()))
    {
      benc localbenc = (benc)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
      localbenc.e.setVisibility(4);
      localbenc.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void d(int paramInt)
  {
    if ((paramInt != -1) && (paramInt < this.jdField_a_of_type_JavaUtilLinkedList.size())) {
      ((benc)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt)).jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void setInfo(berw paramberw)
  {
    this.jdField_a_of_type_Berw = paramberw;
    if (this.jdField_a_of_type_Berw != null)
    {
      this.jdField_a_of_type_Berw = paramberw.a();
      a(this.jdField_a_of_type_Berw.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
        ((benc)this.jdField_a_of_type_JavaUtilLinkedList.getFirst()).a(true);
      }
    }
  }
  
  public void setItemSelected(benc parambenc)
  {
    if (parambenc != null)
    {
      parambenc.a(true);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (localIterator.hasNext())
      {
        benc localbenc = (benc)localIterator.next();
        if (localbenc != parambenc) {
          localbenc.a(false);
        }
      }
    }
  }
  
  public void setOnTabItemClickListener(bend parambend)
  {
    this.jdField_a_of_type_Bend = parambend;
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
      paramString = (benc)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
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
      benc localbenc = (benc)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
      if (paramString != null) {
        localbenc.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      }
      if (paramBitmap1 != null) {
        localbenc.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(getContext().getResources(), paramBitmap1);
      }
      if (paramBitmap2 != null) {
        localbenc.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(getContext().getResources(), paramBitmap2);
      }
      localbenc.b();
    }
  }
  
  public void setTabBarStyle(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    berw localberw = this.jdField_a_of_type_Berw;
    int i;
    if (TextUtils.isEmpty(paramString1))
    {
      i = this.jdField_a_of_type_Berw.jdField_a_of_type_Int;
      localberw.jdField_a_of_type_Int = i;
      paramString1 = this.jdField_a_of_type_Berw;
      if (!TextUtils.isEmpty(paramString2)) {
        break label146;
      }
      i = this.jdField_a_of_type_Berw.jdField_b_of_type_Int;
      label50:
      paramString1.jdField_b_of_type_Int = i;
      paramString1 = this.jdField_a_of_type_Berw;
      if (!TextUtils.isEmpty(paramString3)) {
        break label155;
      }
      i = this.jdField_a_of_type_Berw.c;
      label77:
      paramString1.c = i;
      paramString2 = this.jdField_a_of_type_Berw;
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
        ((benc)paramString1.next()).b();
      }
      i = bffu.a(paramString1);
      break;
      i = bffu.a(paramString2);
      break label50;
      i = bffu.a(paramString3);
      break label77;
    }
  }
  
  public void setTabSelected(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    benc localbenc;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        paramString = bekj.a(paramString);
        localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      }
      localbenc = (benc)localIterator.next();
    } while (!localbenc.jdField_a_of_type_Berx.jdField_a_of_type_JavaLangString.equals(paramString));
    setItemSelected(localbenc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.TabBar
 * JD-Core Version:    0.7.0.1
 */