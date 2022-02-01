package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.data.NearbyPeopleCard;

public abstract class NearbyProfileAbsPanel
{
  protected View a;
  protected Context b;
  
  public NearbyProfileAbsPanel(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public View a()
  {
    View localView = this.a;
    if (localView != null) {
      return localView;
    }
    int i = b();
    if (i > 0)
    {
      this.a = LayoutInflater.from(this.b).inflate(i, null);
      a(this.a);
    }
    else
    {
      this.a = null;
    }
    return this.a;
  }
  
  protected void a(View paramView) {}
  
  protected abstract void a(NearbyPeopleCard paramNearbyPeopleCard);
  
  protected abstract int b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileAbsPanel
 * JD-Core Version:    0.7.0.1
 */