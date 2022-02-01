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
  public Button a;
  private View b;
  
  public TroopAddFrdsSrchResultView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    this.f = ((TextView)this.e.findViewById(2131439320));
    this.j = ((ImageView)this.e.findViewById(2131427337));
    this.g = ((TextView)this.e.findViewById(2131444728));
    this.a = ((Button)this.e.findViewById(2131444718));
    this.a.setText(HardCodeUtil.a(2131886199));
    this.i = ((TextView)this.e.findViewById(2131446184));
    this.h = ((TextView)this.e.findViewById(2131444726));
    this.b = this.e.findViewById(2131448716);
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.b;
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
  
  public Button j()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.troop.view.TroopAddFrdsSrchResultView
 * JD-Core Version:    0.7.0.1
 */