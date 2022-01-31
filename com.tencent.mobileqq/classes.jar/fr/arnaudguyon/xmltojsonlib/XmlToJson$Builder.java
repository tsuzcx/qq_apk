package fr.arnaudguyon.xmltojsonlib;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.InputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.HashSet;

public class XmlToJson$Builder
{
  private HashMap<String, String> mAttributeNameReplacements = new HashMap();
  private HashMap<String, String> mContentNameReplacements = new HashMap();
  private HashMap<String, Class> mForceClassForPath = new HashMap();
  private HashSet<String> mForceListPaths = new HashSet();
  private String mInputEncoding = "utf-8";
  private InputStream mInputStreamSource;
  private HashSet<String> mSkippedAttributes = new HashSet();
  private HashSet<String> mSkippedTags = new HashSet();
  private StringReader mStringSource;
  
  public XmlToJson$Builder(@NonNull InputStream paramInputStream, @Nullable String paramString)
  {
    this.mInputStreamSource = paramInputStream;
    if (paramString != null) {}
    for (;;)
    {
      this.mInputEncoding = paramString;
      return;
      paramString = "utf-8";
    }
  }
  
  public XmlToJson$Builder(@NonNull String paramString)
  {
    this.mStringSource = new StringReader(paramString);
  }
  
  public XmlToJson build()
  {
    return new XmlToJson(this, null);
  }
  
  public Builder forceBooleanForPath(@NonNull String paramString)
  {
    this.mForceClassForPath.put(paramString, Boolean.class);
    return this;
  }
  
  public Builder forceDoubleForPath(@NonNull String paramString)
  {
    this.mForceClassForPath.put(paramString, Double.class);
    return this;
  }
  
  public Builder forceIntegerForPath(@NonNull String paramString)
  {
    this.mForceClassForPath.put(paramString, Integer.class);
    return this;
  }
  
  public Builder forceList(@NonNull String paramString)
  {
    this.mForceListPaths.add(paramString);
    return this;
  }
  
  public Builder forceLongForPath(@NonNull String paramString)
  {
    this.mForceClassForPath.put(paramString, Long.class);
    return this;
  }
  
  public Builder setAttributeName(@NonNull String paramString1, @NonNull String paramString2)
  {
    this.mAttributeNameReplacements.put(paramString1, paramString2);
    return this;
  }
  
  public Builder setContentName(@NonNull String paramString1, @NonNull String paramString2)
  {
    this.mContentNameReplacements.put(paramString1, paramString2);
    return this;
  }
  
  public Builder skipAttribute(@NonNull String paramString)
  {
    this.mSkippedAttributes.add(paramString);
    return this;
  }
  
  public Builder skipTag(@NonNull String paramString)
  {
    this.mSkippedTags.add(paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     fr.arnaudguyon.xmltojsonlib.XmlToJson.Builder
 * JD-Core Version:    0.7.0.1
 */