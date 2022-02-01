package com.tencent.shadow.core.runtime;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.TypedValue;
import java.io.InputStream;

public class MixResources
  extends ResourcesWrapper
{
  private Resources mHostResources;
  
  public MixResources(Resources paramResources1, Resources paramResources2)
  {
    super(paramResources2);
    this.mHostResources = paramResources1;
  }
  
  public XmlResourceParser getAnimation(int paramInt)
  {
    try
    {
      XmlResourceParser localXmlResourceParser = super.getAnimation(paramInt);
      return localXmlResourceParser;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label8:
      break label8;
    }
    return this.mHostResources.getAnimation(paramInt);
  }
  
  public boolean getBoolean(int paramInt)
  {
    try
    {
      boolean bool = super.getBoolean(paramInt);
      return bool;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label8:
      break label8;
    }
    return this.mHostResources.getBoolean(paramInt);
  }
  
  public int getColor(int paramInt)
  {
    try
    {
      int i = super.getColor(paramInt);
      return i;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label8:
      break label8;
    }
    return this.mHostResources.getColor(paramInt);
  }
  
  @TargetApi(23)
  public int getColor(int paramInt, Resources.Theme paramTheme)
  {
    try
    {
      int i = super.getColor(paramInt, paramTheme);
      return i;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label9:
      break label9;
    }
    return this.mHostResources.getColor(paramInt, paramTheme);
  }
  
  public ColorStateList getColorStateList(int paramInt)
  {
    try
    {
      ColorStateList localColorStateList = super.getColorStateList(paramInt);
      return localColorStateList;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label8:
      break label8;
    }
    return this.mHostResources.getColorStateList(paramInt);
  }
  
  @TargetApi(23)
  public ColorStateList getColorStateList(int paramInt, Resources.Theme paramTheme)
  {
    try
    {
      ColorStateList localColorStateList = super.getColorStateList(paramInt, paramTheme);
      return localColorStateList;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label9:
      break label9;
    }
    return this.mHostResources.getColorStateList(paramInt, paramTheme);
  }
  
  public float getDimension(int paramInt)
  {
    try
    {
      float f = super.getDimension(paramInt);
      return f;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label8:
      break label8;
    }
    return this.mHostResources.getDimension(paramInt);
  }
  
  public int getDimensionPixelOffset(int paramInt)
  {
    try
    {
      int i = super.getDimensionPixelOffset(paramInt);
      return i;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label8:
      break label8;
    }
    return this.mHostResources.getDimensionPixelOffset(paramInt);
  }
  
  public int getDimensionPixelSize(int paramInt)
  {
    try
    {
      int i = super.getDimensionPixelSize(paramInt);
      return i;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label8:
      break label8;
    }
    return this.mHostResources.getDimensionPixelSize(paramInt);
  }
  
  public Drawable getDrawable(int paramInt)
  {
    try
    {
      Drawable localDrawable = super.getDrawable(paramInt);
      return localDrawable;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label8:
      break label8;
    }
    return this.mHostResources.getDrawable(paramInt);
  }
  
  @TargetApi(21)
  public Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    try
    {
      Drawable localDrawable = super.getDrawable(paramInt, paramTheme);
      return localDrawable;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label9:
      break label9;
    }
    return this.mHostResources.getDrawable(paramInt, paramTheme);
  }
  
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2)
  {
    try
    {
      Drawable localDrawable = super.getDrawableForDensity(paramInt1, paramInt2);
      return localDrawable;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label9:
      break label9;
    }
    if (Build.VERSION.SDK_INT >= 15) {
      return this.mHostResources.getDrawableForDensity(paramInt1, paramInt2);
    }
    return null;
  }
  
  @TargetApi(21)
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    try
    {
      Drawable localDrawable = super.getDrawableForDensity(paramInt1, paramInt2, paramTheme);
      return localDrawable;
    }
    catch (Exception localException)
    {
      label12:
      break label12;
    }
    return this.mHostResources.getDrawableForDensity(paramInt1, paramInt2, paramTheme);
  }
  
  @TargetApi(26)
  public Typeface getFont(int paramInt)
  {
    try
    {
      Typeface localTypeface = super.getFont(paramInt);
      return localTypeface;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label8:
      break label8;
    }
    return this.mHostResources.getFont(paramInt);
  }
  
  public int getInteger(int paramInt)
  {
    try
    {
      int i = super.getInteger(paramInt);
      return i;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label8:
      break label8;
    }
    return this.mHostResources.getInteger(paramInt);
  }
  
  public XmlResourceParser getLayout(int paramInt)
  {
    try
    {
      XmlResourceParser localXmlResourceParser = super.getLayout(paramInt);
      return localXmlResourceParser;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label8:
      break label8;
    }
    return this.mHostResources.getLayout(paramInt);
  }
  
  public Movie getMovie(int paramInt)
  {
    try
    {
      Movie localMovie = super.getMovie(paramInt);
      return localMovie;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label8:
      break label8;
    }
    return this.mHostResources.getMovie(paramInt);
  }
  
  public String getResourceName(int paramInt)
  {
    try
    {
      String str = super.getResourceName(paramInt);
      return str;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label8:
      break label8;
    }
    return this.mHostResources.getResourceName(paramInt);
  }
  
  public String getString(int paramInt)
  {
    try
    {
      String str = super.getString(paramInt);
      return str;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label8:
      break label8;
    }
    return this.mHostResources.getString(paramInt);
  }
  
  public String getString(int paramInt, Object... paramVarArgs)
  {
    try
    {
      String str = super.getString(paramInt, paramVarArgs);
      return str;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label9:
      break label9;
    }
    return this.mHostResources.getString(paramInt, paramVarArgs);
  }
  
  public CharSequence getText(int paramInt)
  {
    try
    {
      CharSequence localCharSequence = super.getText(paramInt);
      return localCharSequence;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label8:
      break label8;
    }
    return this.mHostResources.getText(paramInt);
  }
  
  public CharSequence getText(int paramInt, CharSequence paramCharSequence)
  {
    try
    {
      CharSequence localCharSequence = super.getText(paramInt, paramCharSequence);
      return localCharSequence;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label9:
      break label9;
    }
    return this.mHostResources.getText(paramInt, paramCharSequence);
  }
  
  public XmlResourceParser getXml(int paramInt)
  {
    try
    {
      XmlResourceParser localXmlResourceParser = super.getXml(paramInt);
      return localXmlResourceParser;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label8:
      break label8;
    }
    return this.mHostResources.getXml(paramInt);
  }
  
  public InputStream openRawResource(int paramInt)
  {
    try
    {
      InputStream localInputStream = super.openRawResource(paramInt);
      return localInputStream;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label8:
      break label8;
    }
    return this.mHostResources.openRawResource(paramInt);
  }
  
  public InputStream openRawResource(int paramInt, TypedValue paramTypedValue)
  {
    try
    {
      InputStream localInputStream = super.openRawResource(paramInt, paramTypedValue);
      return localInputStream;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label9:
      break label9;
    }
    return this.mHostResources.openRawResource(paramInt, paramTypedValue);
  }
  
  public AssetFileDescriptor openRawResourceFd(int paramInt)
  {
    try
    {
      AssetFileDescriptor localAssetFileDescriptor = super.openRawResourceFd(paramInt);
      return localAssetFileDescriptor;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label8:
      break label8;
    }
    return this.mHostResources.openRawResourceFd(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.MixResources
 * JD-Core Version:    0.7.0.1
 */