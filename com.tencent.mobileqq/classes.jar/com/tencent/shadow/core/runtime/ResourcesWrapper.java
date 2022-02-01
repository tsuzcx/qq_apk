package com.tencent.shadow.core.runtime;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.InputStream;

public class ResourcesWrapper
  extends Resources
{
  private Resources mBase;
  
  public ResourcesWrapper(Resources paramResources)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    this.mBase = paramResources;
  }
  
  public XmlResourceParser getAnimation(int paramInt)
  {
    return this.mBase.getAnimation(paramInt);
  }
  
  public boolean getBoolean(int paramInt)
  {
    return this.mBase.getBoolean(paramInt);
  }
  
  public int getColor(int paramInt)
  {
    return this.mBase.getColor(paramInt);
  }
  
  @TargetApi(23)
  public int getColor(int paramInt, Resources.Theme paramTheme)
  {
    return this.mBase.getColor(paramInt, paramTheme);
  }
  
  public ColorStateList getColorStateList(int paramInt)
  {
    return this.mBase.getColorStateList(paramInt);
  }
  
  @TargetApi(23)
  public ColorStateList getColorStateList(int paramInt, Resources.Theme paramTheme)
  {
    return this.mBase.getColorStateList(paramInt, paramTheme);
  }
  
  public Configuration getConfiguration()
  {
    return this.mBase.getConfiguration();
  }
  
  public float getDimension(int paramInt)
  {
    return this.mBase.getDimension(paramInt);
  }
  
  public int getDimensionPixelOffset(int paramInt)
  {
    return this.mBase.getDimensionPixelOffset(paramInt);
  }
  
  public int getDimensionPixelSize(int paramInt)
  {
    return this.mBase.getDimensionPixelSize(paramInt);
  }
  
  public DisplayMetrics getDisplayMetrics()
  {
    return this.mBase.getDisplayMetrics();
  }
  
  public Drawable getDrawable(int paramInt)
  {
    return this.mBase.getDrawable(paramInt);
  }
  
  @TargetApi(21)
  public Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    return this.mBase.getDrawable(paramInt, paramTheme);
  }
  
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 15) {
      return this.mBase.getDrawableForDensity(paramInt1, paramInt2);
    }
    return null;
  }
  
  @TargetApi(21)
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    return this.mBase.getDrawableForDensity(paramInt1, paramInt2, paramTheme);
  }
  
  @TargetApi(26)
  public Typeface getFont(int paramInt)
  {
    return this.mBase.getFont(paramInt);
  }
  
  public float getFraction(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.mBase.getFraction(paramInt1, paramInt2, paramInt3);
  }
  
  public int getIdentifier(String paramString1, String paramString2, String paramString3)
  {
    return this.mBase.getIdentifier(paramString1, paramString2, paramString3);
  }
  
  public int[] getIntArray(int paramInt)
  {
    return this.mBase.getIntArray(paramInt);
  }
  
  public int getInteger(int paramInt)
  {
    return this.mBase.getInteger(paramInt);
  }
  
  public XmlResourceParser getLayout(int paramInt)
  {
    return this.mBase.getLayout(paramInt);
  }
  
  public Movie getMovie(int paramInt)
  {
    return this.mBase.getMovie(paramInt);
  }
  
  public String getQuantityString(int paramInt1, int paramInt2)
  {
    return this.mBase.getQuantityString(paramInt1, paramInt2);
  }
  
  public String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    return this.mBase.getQuantityString(paramInt1, paramInt2, paramVarArgs);
  }
  
  public CharSequence getQuantityText(int paramInt1, int paramInt2)
  {
    return this.mBase.getQuantityText(paramInt1, paramInt2);
  }
  
  public String getResourceEntryName(int paramInt)
  {
    return this.mBase.getResourceEntryName(paramInt);
  }
  
  public String getResourceName(int paramInt)
  {
    return this.mBase.getResourceName(paramInt);
  }
  
  public String getResourcePackageName(int paramInt)
  {
    return this.mBase.getResourcePackageName(paramInt);
  }
  
  public String getResourceTypeName(int paramInt)
  {
    return this.mBase.getResourceTypeName(paramInt);
  }
  
  public String getString(int paramInt)
  {
    return this.mBase.getString(paramInt);
  }
  
  public String getString(int paramInt, Object... paramVarArgs)
  {
    return this.mBase.getString(paramInt, paramVarArgs);
  }
  
  public String[] getStringArray(int paramInt)
  {
    return this.mBase.getStringArray(paramInt);
  }
  
  public CharSequence getText(int paramInt)
  {
    return this.mBase.getText(paramInt);
  }
  
  public CharSequence getText(int paramInt, CharSequence paramCharSequence)
  {
    return this.mBase.getText(paramInt, paramCharSequence);
  }
  
  public CharSequence[] getTextArray(int paramInt)
  {
    return this.mBase.getTextArray(paramInt);
  }
  
  public void getValue(int paramInt, TypedValue paramTypedValue, boolean paramBoolean)
  {
    this.mBase.getValue(paramInt, paramTypedValue, paramBoolean);
  }
  
  public void getValue(String paramString, TypedValue paramTypedValue, boolean paramBoolean)
  {
    this.mBase.getValue(paramString, paramTypedValue, paramBoolean);
  }
  
  public void getValueForDensity(int paramInt1, int paramInt2, TypedValue paramTypedValue, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 15) {
      this.mBase.getValueForDensity(paramInt1, paramInt2, paramTypedValue, paramBoolean);
    }
  }
  
  public XmlResourceParser getXml(int paramInt)
  {
    return this.mBase.getXml(paramInt);
  }
  
  public TypedArray obtainAttributes(AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    return this.mBase.obtainAttributes(paramAttributeSet, paramArrayOfInt);
  }
  
  public TypedArray obtainTypedArray(int paramInt)
  {
    return this.mBase.obtainTypedArray(paramInt);
  }
  
  public InputStream openRawResource(int paramInt)
  {
    return this.mBase.openRawResource(paramInt);
  }
  
  public InputStream openRawResource(int paramInt, TypedValue paramTypedValue)
  {
    return this.mBase.openRawResource(paramInt, paramTypedValue);
  }
  
  public AssetFileDescriptor openRawResourceFd(int paramInt)
  {
    return this.mBase.openRawResourceFd(paramInt);
  }
  
  public void parseBundleExtra(String paramString, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    this.mBase.parseBundleExtra(paramString, paramAttributeSet, paramBundle);
  }
  
  public void parseBundleExtras(XmlResourceParser paramXmlResourceParser, Bundle paramBundle)
  {
    this.mBase.parseBundleExtras(paramXmlResourceParser, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.ResourcesWrapper
 * JD-Core Version:    0.7.0.1
 */