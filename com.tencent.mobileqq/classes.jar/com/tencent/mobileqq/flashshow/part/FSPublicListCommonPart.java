package com.tencent.mobileqq.flashshow.part;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.flashshow.api.bean.FSPageListBean;
import com.tencent.mobileqq.flashshow.list.blocks.FSBaseListBlock;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class FSPublicListCommonPart
  extends Part
  implements View.OnClickListener
{
  private FrameLayout a;
  private ImageView b;
  private TextView c;
  private LinearLayout d;
  private final ArrayList<FSBaseListBlock> e;
  private ViewPager f;
  private int g;
  
  public FSPublicListCommonPart(ArrayList<FSBaseListBlock> paramArrayList)
  {
    this.e = paramArrayList;
  }
  
  private void a(int paramInt)
  {
    int i = 0;
    while (i < this.e.size())
    {
      localObject = (FSBaseListBlock)this.e.get(i);
      View localView = this.d.getChildAt(paramInt);
      boolean bool;
      if (i == paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      ((FSBaseListBlock)localObject).onTitleTabSelectedChanged(localView, bool);
      i += 1;
    }
    Object localObject = this.f;
    if (localObject != null) {
      ((ViewPager)localObject).setCurrentItem(paramInt);
    }
  }
  
  private void b(View paramView)
  {
    if ((c().getIntent() != null) && (c().getIntent().hasExtra("key_bundle_common_init_bean"))) {
      this.g = ((FSPageListBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean")).getLaunchTo();
    }
    this.f.addOnPageChangeListener(new FSPublicListCommonPart.2(this));
    this.f.setCurrentItem(this.g);
    a(this.g);
  }
  
  private void d()
  {
    Object localObject1 = this.e;
    if (localObject1 != null)
    {
      int j = ((ArrayList)localObject1).size();
      int i = 0;
      Object localObject2;
      if ((j == 1) && (this.e.get(0) != null))
      {
        localObject2 = this.c;
        if (!TextUtils.isEmpty(((FSBaseListBlock)this.e.get(0)).getTitle())) {
          localObject1 = ((FSBaseListBlock)this.e.get(0)).getTitle();
        } else {
          localObject1 = "";
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((FSBaseListBlock)this.e.get(0)).initTitleBar(this.a);
        this.d.setVisibility(8);
      }
      if (this.e.size() > 1)
      {
        this.d.removeAllViews();
        while (i < this.e.size())
        {
          localObject1 = (FSBaseListBlock)this.e.get(i);
          localObject2 = ((FSBaseListBlock)localObject1).getTitleTabView(this.d);
          if (localObject2 != null)
          {
            ((View)localObject2).setOnClickListener(new FSPublicListCommonPart.1(this, i, (View)localObject2, (FSBaseListBlock)localObject1));
            this.d.addView((View)localObject2);
          }
          i += 1;
        }
      }
    }
  }
  
  public String a()
  {
    return "PublicListCommonPart";
  }
  
  public void a(View paramView)
  {
    if (paramView != null)
    {
      this.a = ((FrameLayout)paramView.findViewById(2131433304));
      this.b = ((ImageView)paramView.findViewById(2131436275));
      this.c = ((TextView)paramView.findViewById(2131448814));
      this.d = ((LinearLayout)paramView.findViewById(2131437574));
      this.f = ((ViewPager)paramView.findViewById(2131450004));
      this.b.setOnClickListener(this);
      this.c.setOnClickListener(this);
      d();
      b(paramView);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131436275)
    {
      if ((!j().onBackEvent()) && (c() != null)) {
        c().finish();
      }
    }
    else if ((i == 2131448814) && (FastClickUtils.a("PublicListCommonPart")))
    {
      ArrayList localArrayList = this.e;
      if ((localArrayList != null) && (localArrayList.get(0) != null)) {
        ((FSBaseListBlock)this.e.get(0)).onDoubleClickTitle();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSPublicListCommonPart
 * JD-Core Version:    0.7.0.1
 */