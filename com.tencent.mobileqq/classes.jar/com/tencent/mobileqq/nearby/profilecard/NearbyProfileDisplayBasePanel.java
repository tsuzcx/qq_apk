package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import java.util.List;

public abstract class NearbyProfileDisplayBasePanel
  extends NearbyProfileAbsPanel
{
  public boolean c = false;
  
  public NearbyProfileDisplayBasePanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, int paramInt, List<ShowExternalTroop> paramList);
  
  public boolean a(Intent paramIntent)
  {
    return false;
  }
  
  public abstract void b(NearbyPeopleCard paramNearbyPeopleCard);
  
  public void b(boolean paramBoolean) {}
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract int e();
  
  public abstract boolean f();
  
  public abstract void g();
  
  public abstract void h();
  
  public abstract void i();
  
  public abstract void j();
  
  public abstract void k();
  
  public abstract void l();
  
  public abstract void m();
  
  public abstract void n();
  
  public abstract void o();
  
  public abstract void p();
  
  public void q() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayBasePanel
 * JD-Core Version:    0.7.0.1
 */