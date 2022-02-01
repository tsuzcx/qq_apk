package com.tencent.mobileqq.location.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.location.LocationShareViewModel;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.widget.QQUIDelegate;
import com.tencent.qphone.base.util.BaseApplication;

public class VenueHolder
{
  TextView a;
  TextView b;
  TextView c;
  View d;
  View e;
  View f;
  LocationShareController g;
  LocationShareViewModel h;
  
  VenueHolder(LocationShareController paramLocationShareController, LocationShareViewModel paramLocationShareViewModel, View paramView)
  {
    this.g = paramLocationShareController;
    this.h = paramLocationShareViewModel;
    a(paramView);
  }
  
  private void a(View paramView)
  {
    this.d = paramView.findViewById(2131449339);
    this.a = ((TextView)paramView.findViewById(2131449341));
    this.b = ((TextView)paramView.findViewById(2131449338));
    this.c = ((TextView)paramView.findViewById(2131449343));
    this.e = paramView.findViewById(2131449340);
    this.f = paramView.findViewById(2131449342);
    if (QQUIDelegate.c())
    {
      this.f.setBackgroundResource(2130846996);
      this.e.setBackgroundResource(2130846994);
      paramView = this.e;
      if ((paramView instanceof TextView)) {
        ((TextView)paramView).setTextColor(-1);
      }
      this.a.setTextColor(-1);
      this.b.setTextColor(-1);
      ((TextView)this.e).setTextColor(-1);
    }
  }
  
  void a()
  {
    this.d.setVisibility(0);
  }
  
  void a(LocationRoom.Venue paramVenue)
  {
    LocationRoom.Venue localVenue = paramVenue;
    if (paramVenue == null) {
      localVenue = this.g.a.getVenue();
    }
    this.a.setText(String.format(BaseApplication.getContext().getResources().getString(2131891410), new Object[] { localVenue.c }));
    this.b.setText(localVenue.d);
    MapUtils.a(this.h.b(localVenue.b), BaseApplication.getContext().getResources().getString(2131891411), this.c);
    this.e.setOnClickListener(new VenueHolder.1(this));
    this.f.setOnClickListener(new VenueHolder.2(this));
  }
  
  void b()
  {
    this.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.VenueHolder
 * JD-Core Version:    0.7.0.1
 */