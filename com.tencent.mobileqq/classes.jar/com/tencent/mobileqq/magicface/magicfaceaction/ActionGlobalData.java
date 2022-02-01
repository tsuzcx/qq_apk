package com.tencent.mobileqq.magicface.magicfaceaction;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.Timer;
import java.util.TimerTask;

public class ActionGlobalData
{
  public int A;
  public boolean B;
  public int C;
  public int D;
  public int E;
  public String F;
  TimerTask G = new ActionGlobalData.1(this);
  ActionGlobalData.ActionCountdownOver a;
  public boolean b = true;
  public String c = "send";
  public boolean d = false;
  public boolean e = true;
  public String f = "non-ver";
  public int g = 0;
  public String h;
  public int i;
  public String j;
  public String k;
  public String l;
  public MagicfacebackText m;
  public boolean n = false;
  public int o;
  public float p;
  public int q;
  public int r;
  public int s = 50;
  public int t = 30;
  public boolean u = true;
  public String v;
  int w = 0;
  public int x;
  public int y;
  public boolean z;
  
  public void a()
  {
    this.p = this.o;
    ThreadManager.getTimer().schedule(this.G, 0L, 100L);
  }
  
  public void a(ActionGlobalData.ActionCountdownOver paramActionCountdownOver)
  {
    this.a = paramActionCountdownOver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData
 * JD-Core Version:    0.7.0.1
 */