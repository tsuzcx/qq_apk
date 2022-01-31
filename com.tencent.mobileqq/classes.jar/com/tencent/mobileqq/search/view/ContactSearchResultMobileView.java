package com.tencent.mobileqq.search.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactSearchResultMobileView
  extends ContactSearchResultView
{
  public Button a;
  
  public ContactSearchResultMobileView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public Button a()
  {
    return this.a;
  }
  
  protected void a()
  {
    this.j = ((TextView)this.d.findViewById(2131362876));
    this.e = ((ImageView)this.d.findViewById(2131366518));
    this.k = ((TextView)this.d.findViewById(2131369905));
    this.m = ((TextView)this.d.findViewById(2131369907));
    this.a = ((Button)this.d.findViewById(2131368907));
    this.a.setText("添加");
    this.l = ((TextView)this.d.findViewById(2131368908));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.ContactSearchResultMobileView
 * JD-Core Version:    0.7.0.1
 */