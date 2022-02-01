package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.picbrowser.PicInfo;

public abstract class NearbyProfileEditBasePanel
  extends NearbyProfileAbsPanel
{
  public boolean c = false;
  
  public NearbyProfileEditBasePanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract boolean a(PicInfo paramPicInfo);
  
  public abstract void c();
  
  public abstract boolean d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
  
  public boolean h()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditBasePanel
 * JD-Core Version:    0.7.0.1
 */