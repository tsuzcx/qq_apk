package com.tencent.mobileqq.search.view;

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
  
  public Button a()
  {
    return this.a;
  }
  
  protected void a()
  {
    this.h = ((TextView)this.b.findViewById(2131372288));
    this.e = ((ImageView)this.b.findViewById(2131361796));
    this.i = ((TextView)this.b.findViewById(2131377005));
    this.k = ((TextView)this.b.findViewById(2131378318));
    this.a = ((Button)this.b.findViewById(2131376990));
    this.a.setText(HardCodeUtil.a(2131689557));
    this.j = ((TextView)this.b.findViewById(2131377001));
    if ((this.e instanceof ThemeImageView)) {
      ((ThemeImageView)this.e).setSupportMaskView(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.ContactSearchResultMobileView
 * JD-Core Version:    0.7.0.1
 */