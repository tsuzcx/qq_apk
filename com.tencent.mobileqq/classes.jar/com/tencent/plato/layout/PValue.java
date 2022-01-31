package com.tencent.plato.layout;

public class PValue
{
  static final PValue AUTO = new PValue((0.0F / 0.0F), PUnit.AUTO);
  static final PValue UNDEFINED = new PValue((0.0F / 0.0F), PUnit.UNDEFINED);
  static final PValue ZERO = new PValue(0.0F, PUnit.POINT);
  public final String strValue;
  public final PUnit unit;
  public final float value;
  
  public PValue(float paramFloat, PUnit paramPUnit)
  {
    this(paramFloat, null, paramPUnit);
  }
  
  public PValue(float paramFloat, String paramString, int paramInt)
  {
    this(paramFloat, paramString, PUnit.fromInt(paramInt));
  }
  
  public PValue(float paramFloat, String paramString, PUnit paramPUnit)
  {
    this.value = paramFloat;
    this.strValue = paramString;
    this.unit = paramPUnit;
  }
  
  public static PValue parse(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if ("undefined".equals(paramString)) {
      return UNDEFINED;
    }
    if ("auto".equals(paramString)) {
      return AUTO;
    }
    if (paramString.endsWith("%")) {
      return new PValue(Float.parseFloat(paramString.substring(0, paramString.length() - 1)), PUnit.PERCENT);
    }
    return new PValue(Float.parseFloat(paramString), PUnit.POINT);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof PValue))
    {
      paramObject = (PValue)paramObject;
      bool1 = bool2;
      if (this.unit == paramObject.unit) {
        if (this.unit != PUnit.UNDEFINED)
        {
          bool1 = bool2;
          if (Float.compare(this.value, paramObject.value) != 0) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return Float.floatToIntBits(this.value) + this.unit.intValue();
  }
  
  public String toString()
  {
    switch (1.$SwitchMap$com$tencent$plato$layout$PUnit[this.unit.ordinal()])
    {
    default: 
      throw new IllegalStateException();
    case 1: 
      return "undefined";
    case 2: 
      return Float.toString(this.value);
    case 3: 
      return this.value + "%";
    }
    return "auto";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.layout.PValue
 * JD-Core Version:    0.7.0.1
 */