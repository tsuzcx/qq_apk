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
  protected TextView h;
  protected TextView i;
  protected TextView j;
  protected TextView k;
  
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
        localView.setBackgroundColor(localResources.getColor(2131492948));
      }
    }
    for (;;)
    {
      localView = paramView.findViewById(2131363985);
      if (localView != null)
      {
        if (!bool) {
          break;
        }
        localView.setBackgroundColor(localResources.getColor(2131492950));
      }
      return paramView;
      localView.setBackgroundResource(2130838586);
      continue;
      if (!b(this.b)) {
        localView.setBackgroundColor(localResources.getColor(2131492969));
      } else {
        localView.setBackgroundResource(2130838585);
      }
    }
    localView.setBackgroundColor(localResources.getColor(2131492949));
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
    return this.d.findViewById(2131366333);
  }
  
  public ImageView a()
  {
    return this.jdField_e_of_type_AndroidWidgetImageView;
  }
  
  protected void a()
  {
    View localView = this.d.findViewById(2131363397);
    if (localView != null)
    {
      this.h = ((TextView)localView);
      this.h.setEditableFactory(QQTextBuilder.a);
    }
    localView = this.d.findViewById(2131363557);
    if (localView != null) {
      this.i = ((TextView)localView);
    }
    localView = this.d.findViewById(2131365664);
    if (localView != null) {
      this.j = ((TextView)localView);
    }
    localView = this.d.findViewById(2131366401);
    if (localView != null) {
      this.k = ((TextView)localView);
    }
    localView = this.d.findViewById(2131361846);
    if (localView != null) {
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)localView);
    }
    localView = this.d.findViewById(2131365691);
    if (localView != null) {
      this.f = ((ImageView)localView);
    }
    this.jdField_e_of_type_AndroidViewView = this.d.findViewById(2131363953);
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
    case 2130969384: 
    case 2130969385: 
    default: 
      return true;
    }
    return false;
  }
  
  public TextView e()
  {
    return this.h;
  }
  
  public TextView f()
  {
    return this.i;
  }
  
  public TextView g()
  {
    return this.j;
  }
  
  public TextView h()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.SearchResultView
 * JD-Core Version:    0.7.0.1
 */