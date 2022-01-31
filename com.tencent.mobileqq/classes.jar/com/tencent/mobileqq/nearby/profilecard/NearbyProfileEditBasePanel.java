package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;

public abstract class NearbyProfileEditBasePanel
  extends NearbyProfileAbsPanel
{
  public boolean a;
  
  public NearbyProfileEditBasePanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract boolean a();
  
  public abstract boolean a(PicInfo paramPicInfo);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditBasePanel
 * JD-Core Version:    0.7.0.1
 */