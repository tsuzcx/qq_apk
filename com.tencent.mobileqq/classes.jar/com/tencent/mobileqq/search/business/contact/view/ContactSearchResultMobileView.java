package com.tencent.mobileqq.search.business.contact.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.widget.ThemeImageView;

public class ContactSearchResultMobileView
  extends ContactSearchResultView
{
  public Button a;
  
  public ContactSearchResultMobileView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    this.f = ((TextView)this.e.findViewById(2131439320));
    this.j = ((ImageView)this.e.findViewById(2131427337));
    this.g = ((TextView)this.e.findViewById(2131444728));
    this.i = ((TextView)this.e.findViewById(2131446184));
    this.a = ((Button)this.e.findViewById(2131444718));
    this.a.setText(HardCodeUtil.a(2131886199));
    this.h = ((TextView)this.e.findViewById(2131444726));
    if ((this.j instanceof ThemeImageView)) {
      ((ThemeImageView)this.j).setSupportMaskView(true);
    }
  }
  
  public Button j()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.view.ContactSearchResultMobileView
 * JD-Core Version:    0.7.0.1
 */