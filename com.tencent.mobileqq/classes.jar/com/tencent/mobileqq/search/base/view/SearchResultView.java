package com.tencent.mobileqq.search.base.view;

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
  protected View e;
  protected TextView f;
  protected TextView g;
  protected TextView h;
  protected TextView i;
  protected ImageView j;
  protected ImageView k;
  protected View l;
  public int m;
  
  protected SearchResultView() {}
  
  public SearchResultView(View paramView)
  {
    this.e = paramView;
    a();
  }
  
  public SearchResultView(ViewGroup paramViewGroup, int paramInt)
  {
    this.m = paramInt;
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    if (a(paramInt)) {
      this.e = localLayoutInflater.inflate(paramInt, null, false);
    } else {
      this.e = localLayoutInflater.inflate(paramInt, paramViewGroup, false);
    }
    a();
  }
  
  public View a(String paramString)
  {
    return null;
  }
  
  protected void a()
  {
    Object localObject = this.e.findViewById(2131447463);
    if (localObject != null)
    {
      this.f = ((TextView)localObject);
      this.f.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    }
    localObject = this.e.findViewById(2131446539);
    if (localObject != null) {
      this.g = ((TextView)localObject);
    }
    localObject = this.e.findViewById(2131431757);
    if (localObject != null) {
      this.h = ((TextView)localObject);
    }
    localObject = this.e.findViewById(2131433138);
    if (localObject != null) {
      this.i = ((TextView)localObject);
    }
    localObject = this.e.findViewById(2131435357);
    if (localObject != null) {
      this.j = ((ImageView)localObject);
    }
    localObject = this.j;
    if ((localObject instanceof ThemeImageView)) {
      ((ThemeImageView)localObject).setSupportMaskView(false);
    } else if ((localObject instanceof ThemeURLImageView)) {
      ((ThemeURLImageView)localObject).setSupportMaskView(false);
    }
    localObject = this.e.findViewById(2131444798);
    if (localObject != null) {
      this.k = ((ImageView)localObject);
    }
    this.l = this.e.findViewById(2131432033);
    i();
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt != 2131629236) && (paramInt != 2131627372) && (paramInt != 2131629235);
  }
  
  public View b(int paramInt)
  {
    if ((paramInt != 2131625843) && (paramInt != 2131625836) && (paramInt != 2131625875) && (paramInt != 2131625860)) {
      return this.e;
    }
    return this.e.findViewById(2131445450);
  }
  
  public TextView b()
  {
    return this.f;
  }
  
  public TextView c()
  {
    return this.g;
  }
  
  public TextView d()
  {
    return this.h;
  }
  
  public TextView e()
  {
    return this.i;
  }
  
  public ImageView f()
  {
    return this.k;
  }
  
  public ImageView g()
  {
    return this.j;
  }
  
  public View h()
  {
    return this.e;
  }
  
  public void i()
  {
    a(this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.view.SearchResultView
 * JD-Core Version:    0.7.0.1
 */