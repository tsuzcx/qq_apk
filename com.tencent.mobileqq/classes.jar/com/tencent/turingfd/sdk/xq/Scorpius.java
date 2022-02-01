package com.tencent.turingfd.sdk.xq;

public class Scorpius
  extends case
{
  public static Bagasse ob = new Bagasse();
  public static String pb = new String();
  public Bagasse qb = null;
  public String rb = "";
  public String sb = "";
  public String tb = null;
  
  public void a(byte parambyte)
  {
    parambyte.a(this.qb, 0);
    String str = this.rb;
    if (str != null) {
      parambyte.b(str, 1);
    }
    str = this.sb;
    if (str != null) {
      parambyte.b(str, 2);
    }
    str = this.tb;
    if (str != null) {
      parambyte.b(str, 3);
    }
  }
  
  public void a(try paramtry)
  {
    this.qb = ((Bagasse)paramtry.a(ob, 0, true));
    this.rb = paramtry.a(1, false);
    this.sb = paramtry.a(2, false);
    this.tb = paramtry.a(pb, 3, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Scorpius)) {
      return false;
    }
    paramObject = (Scorpius)paramObject;
    return (char.equals(this.qb, paramObject.qb)) && (char.equals(this.rb, paramObject.rb)) && (char.equals(this.sb, paramObject.sb)) && (char.equals(this.tb, paramObject.tb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Scorpius
 * JD-Core Version:    0.7.0.1
 */