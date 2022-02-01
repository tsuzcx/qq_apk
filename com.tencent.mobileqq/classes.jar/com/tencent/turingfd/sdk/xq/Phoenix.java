package com.tencent.turingfd.sdk.xq;

public class Phoenix
  extends case
{
  public static Arbutus bb = new Arbutus();
  public static Avocado cb = new Avocado();
  public Arbutus db = null;
  public Avocado eb = null;
  public int fb = 0;
  public String gb = "";
  public String hb = "";
  
  public void a(byte parambyte)
  {
    Object localObject = this.db;
    if (localObject != null) {
      parambyte.a((case)localObject, 0);
    }
    localObject = this.eb;
    if (localObject != null) {
      parambyte.a((case)localObject, 1);
    }
    parambyte.b(this.fb, 2);
    localObject = this.gb;
    if (localObject != null) {
      parambyte.b((String)localObject, 3);
    }
    localObject = this.hb;
    if (localObject != null) {
      parambyte.b((String)localObject, 4);
    }
  }
  
  public void a(try paramtry)
  {
    this.db = ((Arbutus)paramtry.a(bb, 0, false));
    this.eb = ((Avocado)paramtry.a(cb, 1, false));
    this.fb = paramtry.a(this.fb, 2, false);
    this.gb = paramtry.a(3, false);
    this.hb = paramtry.a(4, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Phoenix)) {
      return false;
    }
    paramObject = (Phoenix)paramObject;
    return (char.equals(this.db, paramObject.db)) && (char.equals(this.eb, paramObject.eb)) && (char.equals(this.fb, paramObject.fb)) && (char.equals(this.gb, paramObject.gb)) && (char.equals(this.hb, paramObject.hb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Phoenix
 * JD-Core Version:    0.7.0.1
 */