package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeURLImageView;

public class SearchResultView
  implements ISearchResultView
{
  protected View b;
  public int c;
  protected View c;
  protected View d;
  protected ImageView e;
  protected ImageView f;
  protected TextView h;
  protected TextView i;
  protected TextView j;
  protected TextView k;
  
  protected SearchResultView() {}
  
  public SearchResultView(View paramView)
  {
    this.b = paramView;
    a();
  }
  
  public SearchResultView(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    if (a(paramInt)) {}
    for (this.b = localLayoutInflater.inflate(paramInt, null, false);; this.b = localLayoutInflater.inflate(paramInt, paramViewGroup, false))
    {
      a();
      return;
    }
  }
  
  public View a()
  {
    return this.b;
  }
  
  public View a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.b;
    }
    return this.b.findViewById(2131377641);
  }
  
  public View a(String paramString)
  {
    return null;
  }
  
  public ImageView a()
  {
    return this.f;
  }
  
  public TextView a()
  {
    return this.h;
  }
  
  protected void a()
  {
    View localView = this.b.findViewById(2131379432);
    if (localView != null)
    {
      this.h = ((TextView)localView);
      this.h.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    }
    localView = this.b.findViewById(2131378646);
    if (localView != null) {
      this.i = ((TextView)localView);
    }
    localView = this.b.findViewById(2131365699);
    if (localView != null) {
      this.j = ((TextView)localView);
    }
    localView = this.b.findViewById(2131366954);
    if (localView != null) {
      this.k = ((TextView)localView);
    }
    localView = this.b.findViewById(2131368729);
    if (localView != null) {
      this.e = ((ImageView)localView);
    }
    if ((this.e instanceof ThemeImageView)) {
      ((ThemeImageView)this.e).setSupportMaskView(false);
    }
    for (;;)
    {
      localView = this.b.findViewById(2131377070);
      if (localView != null) {
        this.f = ((ImageView)localView);
      }
      this.jdField_c_of_type_AndroidViewView = this.b.findViewById(2131365939);
      this.d = this.b.findViewById(2131377084);
      b();
      return;
      if ((this.e instanceof ThemeURLImageView)) {
        ((ThemeURLImageView)this.e).setSupportMaskView(false);
      }
    }
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
    return this.e;
  }
  
  public TextView b()
  {
    return this.i;
  }
  
  public void b()
  {
    if (a(this.jdField_c_of_type_Int)) {}
  }
  
  public TextView c()
  {
    return this.j;
  }
  
  public TextView d()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.SearchResultView
 * JD-Core Version:    0.7.0.1
 */