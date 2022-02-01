package com.tencent.tav.asset;

import com.tencent.tav.coremedia.CMTime;
import java.util.Date;
import java.util.Locale;

public class MetadataItem
{
  protected String dataType;
  private byte[] dataValue;
  private Date dateValue;
  protected CMTime duration;
  protected String extendedLanguageTag;
  protected String identifier;
  protected Locale locale;
  private Integer numberValue;
  private Date startDate;
  private String stringValue;
  protected CMTime time;
  protected Object value;
  
  public String getDataType()
  {
    return this.dataType;
  }
  
  public CMTime getDuration()
  {
    return this.duration;
  }
  
  public String getExtendedLanguageTag()
  {
    return this.extendedLanguageTag;
  }
  
  public String getIdentifier()
  {
    return this.identifier;
  }
  
  public Locale getLocale()
  {
    return this.locale;
  }
  
  public CMTime getTime()
  {
    return this.time;
  }
  
  public Object getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.asset.MetadataItem
 * JD-Core Version:    0.7.0.1
 */