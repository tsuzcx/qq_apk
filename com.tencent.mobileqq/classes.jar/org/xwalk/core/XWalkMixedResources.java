package org.xwalk.core;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

class XWalkMixedResources
  extends Resources
{
  private Resources mLibraryResource;
  
  XWalkMixedResources(Resources paramResources1, Resources paramResources2)
  {
    super(paramResources1.getAssets(), paramResources1.getDisplayMetrics(), paramResources1.getConfiguration());
    this.mLibraryResource = paramResources2;
  }
  
  private boolean isCalledInLibrary()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfStackTraceElement[i].getClassName();
      if ((!str.startsWith("org.chromium")) && (!str.startsWith("org.xwalk.core.internal")))
      {
        if ((str.startsWith("org.xwalk.core")) && (!str.endsWith("XWalkMixedResources"))) {
          return false;
        }
        i += 1;
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  public Drawable getDrawable(int paramInt)
  {
    boolean bool = isCalledInLibrary();
    if (bool) {}
    try
    {
      return this.mLibraryResource.getDrawable(paramInt);
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Drawable localDrawable;
      break label26;
    }
    localDrawable = super.getDrawable(paramInt);
    return localDrawable;
    label26:
    if (bool) {
      return super.getDrawable(paramInt);
    }
    return this.mLibraryResource.getDrawable(paramInt);
  }
  
  public int getIdentifier(String paramString1, String paramString2, String paramString3)
  {
    if (isCalledInLibrary())
    {
      i = this.mLibraryResource.getIdentifier(paramString1, paramString2, paramString3);
      if (i != 0) {
        return i;
      }
      return super.getIdentifier(paramString1, paramString2, paramString3);
    }
    int i = super.getIdentifier(paramString1, paramString2, paramString3);
    if (i != 0) {
      return i;
    }
    return this.mLibraryResource.getIdentifier(paramString1, paramString2, paramString3);
  }
  
  public XmlResourceParser getLayout(int paramInt)
  {
    boolean bool = isCalledInLibrary();
    if (bool) {}
    try
    {
      return this.mLibraryResource.getLayout(paramInt);
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      XmlResourceParser localXmlResourceParser;
      break label26;
    }
    localXmlResourceParser = super.getLayout(paramInt);
    return localXmlResourceParser;
    label26:
    if (bool) {
      return super.getLayout(paramInt);
    }
    return this.mLibraryResource.getLayout(paramInt);
  }
  
  public CharSequence getText(int paramInt)
  {
    boolean bool = isCalledInLibrary();
    if (bool) {}
    try
    {
      return this.mLibraryResource.getText(paramInt);
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      CharSequence localCharSequence;
      break label26;
    }
    localCharSequence = super.getText(paramInt);
    return localCharSequence;
    label26:
    if (bool) {
      return super.getText(paramInt);
    }
    return this.mLibraryResource.getText(paramInt);
  }
  
  public void getValue(int paramInt, TypedValue paramTypedValue, boolean paramBoolean)
  {
    boolean bool = isCalledInLibrary();
    if (bool) {}
    try
    {
      this.mLibraryResource.getValue(paramInt, paramTypedValue, paramBoolean);
      return;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      break label30;
    }
    super.getValue(paramInt, paramTypedValue, paramBoolean);
    return;
    label30:
    if (bool)
    {
      super.getValue(paramInt, paramTypedValue, paramBoolean);
      return;
    }
    this.mLibraryResource.getValue(paramInt, paramTypedValue, paramBoolean);
  }
  
  public void getValueForDensity(int paramInt1, int paramInt2, TypedValue paramTypedValue, boolean paramBoolean)
  {
    boolean bool = isCalledInLibrary();
    if (bool) {}
    try
    {
      this.mLibraryResource.getValueForDensity(paramInt1, paramInt2, paramTypedValue, paramBoolean);
      return;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      break label34;
    }
    super.getValueForDensity(paramInt1, paramInt2, paramTypedValue, paramBoolean);
    return;
    label34:
    if (bool)
    {
      super.getValueForDensity(paramInt1, paramInt2, paramTypedValue, paramBoolean);
      return;
    }
    this.mLibraryResource.getValueForDensity(paramInt1, paramInt2, paramTypedValue, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkMixedResources
 * JD-Core Version:    0.7.0.1
 */