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
  
  public Button a()
  {
    return this.jdField_a_of_type_AndroidWidgetButton;
  }
  
  protected void a()
  {
    this.d = ((TextView)this.b.findViewById(2131371877));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.b.findViewById(2131361799));
    this.e = ((TextView)this.b.findViewById(2131376487));
    this.g = ((TextView)this.b.findViewById(2131377726));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.b.findViewById(2131376477));
    this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131689589));
    this.f = ((TextView)this.b.findViewById(2131376485));
    if ((this.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
      ((ThemeImageView)this.jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.view.ContactSearchResultMobileView
 * JD-Core Version:    0.7.0.1
 */