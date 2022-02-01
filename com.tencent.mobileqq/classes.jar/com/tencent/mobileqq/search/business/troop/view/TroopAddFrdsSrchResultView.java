package com.tencent.mobileqq.search.business.troop.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.business.contact.view.ContactSearchResultView;

public class TroopAddFrdsSrchResultView
  extends ContactSearchResultView
{
  private View a;
  public Button a;
  
  public TroopAddFrdsSrchResultView(ViewGroup paramViewGroup, int paramInt)
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
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.b.findViewById(2131376477));
    this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131689589));
    this.g = ((TextView)this.b.findViewById(2131377726));
    this.f = ((TextView)this.b.findViewById(2131376485));
    this.jdField_a_of_type_AndroidViewView = this.b.findViewById(2131379859);
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.troop.view.TroopAddFrdsSrchResultView
 * JD-Core Version:    0.7.0.1
 */