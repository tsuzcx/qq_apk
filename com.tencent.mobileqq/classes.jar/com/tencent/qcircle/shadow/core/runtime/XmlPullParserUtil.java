package com.tencent.qcircle.shadow.core.runtime;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.view.InflateException;
import org.xmlpull.v1.XmlPullParserException;

public class XmlPullParserUtil
{
  public static String getLayoutStartTagName(Resources paramResources, int paramInt)
  {
    try
    {
      paramResources = paramResources.getLayout(paramInt);
      if (paramResources == null) {
        return null;
      }
      do
      {
        paramInt = paramResources.next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt == 2) {
        return paramResources.getName();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramResources.getPositionDescription());
      localStringBuilder.append(": No start tag found!");
      throw new InflateException(localStringBuilder.toString());
    }
    catch (Exception paramResources)
    {
      paramResources = new InflateException(paramResources.getMessage(), paramResources);
      paramResources.setStackTrace(new StackTraceElement[0]);
      throw paramResources;
    }
    catch (XmlPullParserException paramResources)
    {
      paramResources = new InflateException(paramResources.getMessage(), paramResources);
      paramResources.setStackTrace(new StackTraceElement[0]);
    }
    for (;;)
    {
      throw paramResources;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.XmlPullParserUtil
 * JD-Core Version:    0.7.0.1
 */