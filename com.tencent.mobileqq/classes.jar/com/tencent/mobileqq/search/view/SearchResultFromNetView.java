package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.SearchResultView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;

public class SearchResultFromNetView
  extends SearchResultView
{
  public Button a;
  public ImageView b;
  public ImageView c;
  private int d;
  private TroopLabelLayout n;
  private TextView o;
  private ImageView p;
  private TextView q;
  private TroopLabelLayout r;
  private TextView s;
  private View t;
  private View u;
  private View v;
  private TroopActiveLayout w;
  private FolderTextView x;
  
  public SearchResultFromNetView(ViewGroup paramViewGroup, int paramInt)
  {
    this.d = paramInt;
    paramInt = this.d;
    if (paramInt != 3)
    {
      if (paramInt != 1107) {
        if (paramInt != 268435456)
        {
          if (paramInt != 1001)
          {
            if (paramInt != 1002)
            {
              this.m = 2131625874;
              break label88;
            }
          }
          else
          {
            this.m = 2131627594;
            break label88;
          }
        }
        else
        {
          this.m = 2131625840;
          break label88;
        }
      }
      this.m = 2131627595;
    }
    else
    {
      this.m = 2131626493;
    }
    label88:
    paramViewGroup.getResources();
    LinearLayout localLinearLayout = new LinearLayout(paramViewGroup.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(LayoutInflater.from(paramViewGroup.getContext()).inflate(this.m, null, false), new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.setClickable(true);
    localLinearLayout.setFocusable(true);
    this.e = localLinearLayout;
    a();
  }
  
  public View a(String paramString)
  {
    if ("ActiveEntitySearchResultPresenter_add_troop".equals(paramString)) {
      return this.t;
    }
    if ("ActiveEntitySearchResultPresenter_pay_troop".equals(paramString)) {
      return this.u;
    }
    if ("ActiveEntitySearchResultPresenter_hot_troop".equals(paramString)) {
      return this.w;
    }
    if ("ActiveEntitySearchResultPresenter_expand_desc".equals(paramString)) {
      return this.x;
    }
    return super.a(paramString);
  }
  
  protected void a()
  {
    super.a();
    this.o = ((TextView)this.e.findViewById(2131435219));
    this.p = ((ImageView)this.e.findViewById(2131431472));
    int i = this.d;
    if (i != 1001)
    {
      if (i != 1002)
      {
        if (i == 1107)
        {
          this.b = ((ImageView)this.e.findViewById(2131447913));
          this.b.setVisibility(8);
          localObject = (LinearLayout)this.e.findViewById(2131447506);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
          localLayoutParams.addRule(15, -1);
          localLayoutParams.addRule(10, 0);
          ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
          this.t = this.e.findViewById(2131431377);
          localObject = (RelativeLayout.LayoutParams)this.t.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
          ((RelativeLayout.LayoutParams)localObject).addRule(10, 0);
          this.t.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      else
      {
        this.b = ((ImageView)this.e.findViewById(2131447913));
        this.c = ((ImageView)this.e.findViewById(2131447875));
        this.n = ((TroopLabelLayout)this.e.findViewById(2131448010));
        if (this.f != null)
        {
          localObject = this.f;
          int j = ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(187.0F);
          i = j;
          if (j <= 0) {
            i = ScreenUtil.dip2px(220.0F);
          }
          ((TextView)localObject).setMaxWidth(i);
        }
      }
    }
    else
    {
      this.a = ((Button)this.e.findViewById(2131444718));
      this.q = ((TextView)this.e.findViewById(2131444726));
      this.r = ((TroopLabelLayout)this.e.findViewById(2131448010));
      this.s = ((TextView)this.e.findViewById(2131438023));
      this.v = this.e.findViewById(2131448716);
    }
    this.t = this.e.findViewById(2131431377);
    Object localObject = this.t;
    if (localObject != null) {
      ((View)localObject).setTag("ActiveEntitySearchResultPresenter_add_troop");
    }
    this.u = this.e.findViewById(2131440656);
    localObject = this.u;
    if (localObject != null)
    {
      ((View)localObject).setTag("ActiveEntitySearchResultPresenter_pay_troop");
      localObject = this.u;
      if ((localObject instanceof ThemeImageView)) {
        ((ThemeImageView)localObject).setMaskShape(ThemeImageWrapper.MODE_OTHER);
      }
    }
    this.w = ((TroopActiveLayout)this.e.findViewById(2131427602));
    localObject = this.w;
    if (localObject != null) {
      ((TroopActiveLayout)localObject).setTag("ActiveEntitySearchResultPresenter_hot_troop");
    }
    this.x = ((FolderTextView)this.e.findViewById(2131433503));
    localObject = this.x;
    if (localObject != null) {
      ((FolderTextView)localObject).setTag("ActiveEntitySearchResultPresenter_expand_desc");
    }
  }
  
  public ImageView j()
  {
    return this.p;
  }
  
  public TroopLabelLayout k()
  {
    return this.n;
  }
  
  public TextView l()
  {
    return this.o;
  }
  
  public View m()
  {
    return this.v;
  }
  
  public TextView n()
  {
    return this.a;
  }
  
  public TroopLabelLayout o()
  {
    return this.r;
  }
  
  public TextView p()
  {
    return this.q;
  }
  
  public TextView q()
  {
    return this.s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.SearchResultFromNetView
 * JD-Core Version:    0.7.0.1
 */