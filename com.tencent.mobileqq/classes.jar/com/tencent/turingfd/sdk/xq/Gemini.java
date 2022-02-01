package com.tencent.turingfd.sdk.xq;

public class Gemini
  extends case
{
  public static Lacerta wb = new Lacerta();
  public static Hydra xb = new Hydra();
  public static GalacticCore yb = new GalacticCore();
  public int Ab = 0;
  public Lacerta Bb = null;
  public Hydra Cb = null;
  public GalacticCore Db = null;
  public int R = 0;
  public int zb = 0;
  
  public void a(byte parambyte)
  {
    parambyte.a(this.R, 0);
    parambyte.a(this.zb, 1);
    parambyte.a(this.Ab, 2);
    Object localObject = this.Bb;
    if (localObject != null) {
      parambyte.a((case)localObject, 3);
    }
    localObject = this.Cb;
    if (localObject != null) {
      parambyte.a((case)localObject, 4);
    }
    localObject = this.Db;
    if (localObject != null) {
      parambyte.a((case)localObject, 5);
    }
  }
  
  public void a(try paramtry)
  {
    this.R = paramtry.a(this.R, 0, true);
    this.zb = paramtry.a(this.zb, 1, false);
    this.Ab = paramtry.a(this.Ab, 2, false);
    this.Bb = ((Lacerta)paramtry.a(wb, 3, false));
    this.Cb = ((Hydra)paramtry.a(xb, 4, false));
    this.Db = ((GalacticCore)paramtry.a(yb, 5, false));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof Gemini)) {
        return false;
      }
      paramObject = (Gemini)paramObject;
    } while ((char.equals(this.R, paramObject.R)) && (char.equals(this.zb, paramObject.zb)) && (char.equals(this.Ab, paramObject.Ab)) && (char.equals(this.Bb, paramObject.Bb)) && (char.equals(this.Cb, paramObject.Cb)) && (char.equals(this.Db, paramObject.Db)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Gemini
 * JD-Core Version:    0.7.0.1
 */