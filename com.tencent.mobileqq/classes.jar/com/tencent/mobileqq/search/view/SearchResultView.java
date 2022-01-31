package com.tencent.mobileqq.search.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;

public class SearchResultView
  implements ISearchResultView
{
  public int b;
  protected View d;
  protected View e;
  protected ImageView e;
  protected ImageView f;
  protected TextView j;
  protected TextView k;
  protected TextView l;
  protected TextView m;
  
  protected SearchResultView() {}
  
  public SearchResultView(View paramView)
  {
    this.d = paramView;
    a();
  }
  
  public SearchResultView(ViewGroup paramViewGroup, int paramInt)
  {
    this.b = paramInt;
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    if (a(paramInt)) {}
    for (this.d = localLayoutInflater.inflate(paramInt, null, false);; this.d = localLayoutInflater.inflate(paramInt, paramViewGroup, false))
    {
      a();
      return;
    }
  }
  
  private View a(View paramView)
  {
    Resources localResources = paramView.getResources();
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    View localView = a(this.b);
    if (bool) {
      if (!b(this.b)) {
        localView.setBackgroundColor(localResources.getColor(2131492947));
      }
    }
    for (;;)
    {
      localView = paramView.findViewById(2131363937);
      if (localView != null)
      {
        if (!bool) {
          break;
        }
        localView.setBackgroundColor(localResources.getColor(2131492949));
      }
      return paramView;
      localView.setBackgroundResource(2130838576);
      continue;
      if (!b(this.b)) {
        localView.setBackgroundColor(localResources.getColor(2131492968));
      } else {
        localView.setBackgroundResource(2130838575);
      }
    }
    localView.setBackgroundColor(localResources.getColor(2131492948));
    return paramView;
  }
  
  public View a()
  {
    return this.d;
  }
  
  public View a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.d;
    }
    return this.d.findViewById(2131366301);
  }
  
  public ImageView a()
  {
    return this.jdField_e_of_type_AndroidWidgetImageView;
  }
  
  protected void a()
  {
    View localView = this.d.findViewById(2131363360);
    if (localView != null)
    {
      this.j = ((TextView)localView);
      this.j.setEditableFactory(QQTextBuilder.a);
    }
    localView = this.d.findViewById(2131363520);
    if (localView != null) {
      this.k = ((TextView)localView);
    }
    localView = this.d.findViewById(2131365632);
    if (localView != null) {
      this.l = ((TextView)localView);
    }
    localView = this.d.findViewById(2131366376);
    if (localView != null) {
      this.m = ((TextView)localView);
    }
    localView = this.d.findViewById(2131361846);
    if (localView != null) {
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)localView);
    }
    localView = this.d.findViewById(2131365659);
    if (localView != null) {
      this.f = ((ImageView)localView);
    }
    this.jdField_e_of_type_AndroidViewView = this.d.findViewById(2131363905);
    b();
  }
  
  public boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  public View b()
  {
    return this.jdField_e_of_type_AndroidViewView;
  }
  
  public ImageView b()
  {
    return this.f;
  }
  
  public void b()
  {
    if (a(this.b)) {
      a(this.d);
    }
  }
  
  public boolean b(int paramInt)
  {
    switch (paramInt)
    {
    case 2130969385: 
    case 2130969386: 
    default: 
      return true;
    }
    return false;
  }
  
  public TextView e()
  {
    return this.j;
  }
  
  public TextView f()
  {
    return this.k;
  }
  
  public TextView g()
  {
    return this.l;
  }
  
  public TextView h()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.SearchResultView
 * JD-Core Version:    0.7.0.1
 */