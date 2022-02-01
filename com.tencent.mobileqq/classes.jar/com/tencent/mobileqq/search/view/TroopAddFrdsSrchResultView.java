package com.tencent.mobileqq.search.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;

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
    this.h = ((TextView)this.b.findViewById(2131372288));
    this.e = ((ImageView)this.b.findViewById(2131361796));
    this.i = ((TextView)this.b.findViewById(2131377005));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.b.findViewById(2131376990));
    this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131689557));
    this.k = ((TextView)this.b.findViewById(2131378318));
    this.j = ((TextView)this.b.findViewById(2131377001));
    this.jdField_a_of_type_AndroidViewView = this.b.findViewById(2131380575);
  }
  
  public void a(boolean paramBoolean)
  {
    View localView;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localView = this.jdField_a_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.TroopAddFrdsSrchResultView
 * JD-Core Version:    0.7.0.1
 */