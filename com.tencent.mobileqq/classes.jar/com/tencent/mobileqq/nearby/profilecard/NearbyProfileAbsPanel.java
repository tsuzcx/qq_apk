package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.data.NearbyPeopleCard;

public abstract class NearbyProfileAbsPanel
{
  public Context a;
  protected View a;
  
  public NearbyProfileAbsPanel(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  protected abstract int a();
  
  public View a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return this.jdField_a_of_type_AndroidViewView;
    }
    int i = a();
    if (i > 0)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(i, null);
      a(this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidViewView;
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  protected void a(View paramView) {}
  
  public abstract void a(NearbyPeopleCard paramNearbyPeopleCard);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileAbsPanel
 * JD-Core Version:    0.7.0.1
 */