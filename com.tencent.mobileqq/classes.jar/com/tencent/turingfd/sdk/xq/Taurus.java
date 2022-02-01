package com.tencent.turingfd.sdk.xq;

public class Taurus
  extends case
{
  public static UrsaMajor Bb = new UrsaMajor();
  public static Triangulum Cb = new Triangulum();
  public static Solar Db = new Solar();
  public int Eb = 0;
  public int Fb = 0;
  public UrsaMajor Gb = null;
  public Triangulum Hb = null;
  public Solar Ib = null;
  public int ba = 0;
  
  public void a(byte parambyte)
  {
    parambyte.b(this.ba, 0);
    parambyte.b(this.Eb, 1);
    parambyte.b(this.Fb, 2);
    Object localObject = this.Gb;
    if (localObject != null) {
      parambyte.a((case)localObject, 3);
    }
    localObject = this.Hb;
    if (localObject != null) {
      parambyte.a((case)localObject, 4);
    }
    localObject = this.Ib;
    if (localObject != null) {
      parambyte.a((case)localObject, 5);
    }
  }
  
  public void a(try paramtry)
  {
    this.ba = paramtry.a(this.ba, 0, true);
    this.Eb = paramtry.a(this.Eb, 1, false);
    this.Fb = paramtry.a(this.Fb, 2, false);
    this.Gb = ((UrsaMajor)paramtry.a(Bb, 3, false));
    this.Hb = ((Triangulum)paramtry.a(Cb, 4, false));
    this.Ib = ((Solar)paramtry.a(Db, 5, false));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Taurus)) {
      return false;
    }
    paramObject = (Taurus)paramObject;
    return (char.equals(this.ba, paramObject.ba)) && (char.equals(this.Eb, paramObject.Eb)) && (char.equals(this.Fb, paramObject.Fb)) && (char.equals(this.Gb, paramObject.Gb)) && (char.equals(this.Hb, paramObject.Hb)) && (char.equals(this.Ib, paramObject.Ib));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Taurus
 * JD-Core Version:    0.7.0.1
 */