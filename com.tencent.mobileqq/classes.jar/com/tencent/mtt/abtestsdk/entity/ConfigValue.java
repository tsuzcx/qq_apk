package com.tencent.mtt.abtestsdk.entity;

import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigValue
{
  static final Pattern FALSE_REGEX = Pattern.compile("^(0|false|f|no|n|off|)$", 2);
  private static final String ILLEGAL_ARGUMENT_STRING_FORMAT = "[Value: %s] cannot be converted to a %s.";
  static final Pattern TRUE_REGEX = Pattern.compile("^(1|true|t|yes|y|on)$", 2);
  private final String value;
  
  public ConfigValue(String paramString)
  {
    this.value = paramString;
  }
  
  private String asTrimmedString()
  {
    return asString().trim();
  }
  
  private void throwIfNullValue()
  {
    if (this.value != null) {
      return;
    }
    throw new IllegalArgumentException("value is null, and cannot be converted to the desired type");
  }
  
  public boolean asBoolean()
  {
    String str = asTrimmedString();
    if (TRUE_REGEX.matcher(str).matches()) {
      return true;
    }
    if (FALSE_REGEX.matcher(str).matches()) {
      return false;
    }
    throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", new Object[] { str, "boolean" }));
  }
  
  public byte[] asByteArray()
  {
    return this.value.getBytes(Charset.forName("UTF-8"));
  }
  
  public double asDouble()
  {
    String str = asTrimmedString();
    try
    {
      double d = Double.valueOf(str).doubleValue();
      return d;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", new Object[] { str, "double" }), localNumberFormatException);
    }
  }
  
  public int asInt()
  {
    String str = asTrimmedString();
    try
    {
      int i = Integer.valueOf(str).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", new Object[] { str, "int" }), localNumberFormatException);
    }
  }
  
  public long asLong()
  {
    String str = asTrimmedString();
    try
    {
      long l = Long.valueOf(str).longValue();
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", new Object[] { str, "long" }), localNumberFormatException);
    }
  }
  
  public String asString()
  {
    throwIfNullValue();
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.entity.ConfigValue
 * JD-Core Version:    0.7.0.1
 */