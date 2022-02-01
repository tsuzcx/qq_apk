package com.tencent.mobileqq.troop.troopapps;

class TroopAppShortcutContainer$LoadingInfo
{
  private int a;
  private boolean b;
  private boolean c;
  
  public TroopAppShortcutContainer$LoadingInfo()
  {
    a();
  }
  
  public LoadingInfo a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public LoadingInfo a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public void a()
  {
    this.a = 0;
    this.b = false;
    this.c = true;
  }
  
  public boolean b()
  {
    return (!this.c) && (!this.b) && (this.a != 0);
  }
  
  public int c()
  {
    return this.a;
  }
  
  public LoadingInfo d()
  {
    this.b = true;
    return this;
  }
  
  public LoadingInfo e()
  {
    this.b = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer.LoadingInfo
 * JD-Core Version:    0.7.0.1
 */