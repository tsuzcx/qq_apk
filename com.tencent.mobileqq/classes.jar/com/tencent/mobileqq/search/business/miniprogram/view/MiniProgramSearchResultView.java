package com.tencent.mobileqq.search.business.miniprogram.view;

import android.view.View;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.search.base.view.SearchResultView;

public class MiniProgramSearchResultView
  extends SearchResultView
{
  protected TextView a;
  protected URLImageView b;
  
  public MiniProgramSearchResultView(View paramView)
  {
    super(paramView);
  }
  
  protected void a()
  {
    super.a();
    this.a = ((TextView)this.e.findViewById(2131446045));
    this.b = ((URLImageView)this.e.findViewById(2131447560));
  }
  
  public TextView j()
  {
    return this.a;
  }
  
  public URLImageView k()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.miniprogram.view.MiniProgramSearchResultView
 * JD-Core Version:    0.7.0.1
 */