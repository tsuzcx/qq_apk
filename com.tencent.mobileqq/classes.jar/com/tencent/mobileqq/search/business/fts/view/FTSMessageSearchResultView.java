package com.tencent.mobileqq.search.business.fts.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.SearchResultView;

public class FTSMessageSearchResultView
  extends SearchResultView
{
  private TextView a;
  private TextView b;
  private TextView c;
  private TextView d;
  
  public FTSMessageSearchResultView(View paramView)
  {
    super(paramView);
  }
  
  public FTSMessageSearchResultView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    super.a();
    this.a = ((TextView)this.e.findViewById(2131445632));
    this.b = ((TextView)this.e.findViewById(2131445631));
    this.c = ((TextView)this.e.findViewById(2131445630));
    this.d = ((TextView)this.e.findViewById(2131445485));
  }
  
  public TextView j()
  {
    return this.a;
  }
  
  public TextView k()
  {
    return this.b;
  }
  
  public TextView l()
  {
    return this.c;
  }
  
  public TextView m()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.fts.view.FTSMessageSearchResultView
 * JD-Core Version:    0.7.0.1
 */