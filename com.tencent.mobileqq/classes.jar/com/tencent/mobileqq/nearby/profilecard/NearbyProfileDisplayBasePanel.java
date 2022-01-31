package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import java.util.List;

public abstract class NearbyProfileDisplayBasePanel
  extends NearbyProfileAbsPanel
{
  public boolean a;
  
  public NearbyProfileDisplayBasePanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, int paramInt, List paramList);
  
  public abstract boolean a();
  
  public abstract int b();
  
  public abstract void b();
  
  public abstract void b(NearbyPeopleCard paramNearbyPeopleCard);
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract void h();
  
  public abstract void i();
  
  public abstract void j();
  
  public abstract void k();
  
  public abstract void l();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayBasePanel
 * JD-Core Version:    0.7.0.1
 */