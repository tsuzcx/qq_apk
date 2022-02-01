package com.tencent.weui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.preference.Preference;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class d
{
  private static final Class<?>[] a = { Context.class, AttributeSet.class };
  private static HashMap<String, Constructor<?>> b = new HashMap();
  private final Context c;
  private final Object[] d = new Object[2];
  
  public d(Context paramContext)
  {
    this.c = paramContext;
  }
  
  private Preference a(String paramString1, String paramString2, AttributeSet paramAttributeSet)
  {
    Object localObject3 = (Constructor)b.get(paramString1);
    Object localObject2 = localObject3;
    Object localObject1;
    if (localObject3 == null) {
      localObject1 = localObject3;
    }
    for (;;)
    {
      try
      {
        ClassLoader localClassLoader = this.c.getClassLoader();
        if (paramString2 != null)
        {
          localObject1 = localObject3;
          localObject2 = new StringBuilder();
          localObject1 = localObject3;
          ((StringBuilder)localObject2).append(paramString2);
          localObject1 = localObject3;
          ((StringBuilder)localObject2).append(paramString1);
          localObject1 = localObject3;
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject1 = localObject3;
          localObject2 = localClassLoader.loadClass((String)localObject2).getConstructor(a);
          localObject1 = localObject2;
          b.put(paramString1, localObject2);
          localObject1 = localObject2;
          localObject3 = this.d;
          localObject3[1] = paramAttributeSet;
          localObject1 = localObject2;
          localObject2 = (Preference)((Constructor)localObject2).newInstance((Object[])localObject3);
          return localObject2;
        }
      }
      catch (Exception paramString2)
      {
        if (paramAttributeSet == null)
        {
          paramString1 = new StringBuilder();
          paramString1.append("(null): Error inflating class ");
          paramString1.append(localObject1);
          if (paramString1.toString() != null) {
            paramString1 = localObject1.getClass().getName();
          } else {
            paramString1 = "(null)";
          }
        }
        else
        {
          paramString1 = paramAttributeSet.getPositionDescription();
        }
        paramString1 = new InflateException(paramString1);
        paramString1.initCause(paramString2);
        throw paramString1;
      }
      catch (ClassNotFoundException paramString1)
      {
        throw paramString1;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramAttributeSet.getPositionDescription());
        ((StringBuilder)localObject2).append(": Error inflating class ");
        paramAttributeSet = paramString1;
        if (paramString2 != null)
        {
          paramAttributeSet = new StringBuilder();
          paramAttributeSet.append(paramString2);
          paramAttributeSet.append(paramString1);
          paramAttributeSet = paramAttributeSet.toString();
        }
        ((StringBuilder)localObject2).append(paramAttributeSet);
        paramString1 = new InflateException(((StringBuilder)localObject2).toString());
        paramString1.initCause(localNoSuchMethodException);
        throw paramString1;
      }
      localObject2 = paramString1;
    }
  }
  
  private Preference a(XmlPullParser paramXmlPullParser, String paramString, AttributeSet paramAttributeSet)
  {
    try
    {
      if (-1 == paramString.indexOf('.')) {
        return a(paramString, "android.preference.", paramAttributeSet);
      }
      paramXmlPullParser = a(paramString, null, paramAttributeSet);
      return paramXmlPullParser;
    }
    catch (Exception paramXmlPullParser)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAttributeSet.getPositionDescription());
      localStringBuilder.append(": Error inflating class ");
      localStringBuilder.append(paramString);
      paramString = new InflateException(localStringBuilder.toString());
      paramString.initCause(paramXmlPullParser);
      throw paramString;
    }
    catch (ClassNotFoundException paramXmlPullParser)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAttributeSet.getPositionDescription());
      localStringBuilder.append(": Error inflating class ");
      localStringBuilder.append(paramString);
      paramString = new InflateException(localStringBuilder.toString());
      paramString.initCause(paramXmlPullParser);
      throw paramString;
    }
    catch (InflateException paramXmlPullParser)
    {
      throw paramXmlPullParser;
    }
  }
  
  private void a(XmlPullParser paramXmlPullParser, IPreferenceScreen paramIPreferenceScreen, AttributeSet paramAttributeSet)
  {
    int j = paramXmlPullParser.getDepth();
    int i = paramXmlPullParser.next();
    while (((i != 3) || (paramXmlPullParser.getDepth() > j)) && (i != 1)) {
      if (i != 2)
      {
        i = paramXmlPullParser.next();
      }
      else
      {
        paramIPreferenceScreen.addPreference(a(paramXmlPullParser, paramXmlPullParser.getName(), paramAttributeSet), -1);
        i = paramXmlPullParser.next();
      }
    }
  }
  
  public void a(int paramInt, IPreferenceScreen paramIPreferenceScreen)
  {
    boolean bool;
    if (paramIPreferenceScreen != null) {
      bool = true;
    } else {
      bool = false;
    }
    a(paramInt, paramIPreferenceScreen, bool);
  }
  
  public void a(int paramInt, IPreferenceScreen paramIPreferenceScreen, boolean paramBoolean)
  {
    XmlResourceParser localXmlResourceParser = this.c.getResources().getXml(paramInt);
    if (localXmlResourceParser == null) {
      return;
    }
    try
    {
      a(localXmlResourceParser, paramIPreferenceScreen, paramBoolean);
      return;
    }
    finally
    {
      localXmlResourceParser.close();
    }
  }
  
  public void a(XmlPullParser paramXmlPullParser, IPreferenceScreen paramIPreferenceScreen, boolean paramBoolean)
  {
    synchronized (this.d)
    {
      Object localObject = Xml.asAttributeSet(paramXmlPullParser);
      this.d[0] = this.c;
      try
      {
        for (int i = paramXmlPullParser.next(); (i != 2) && (i != 1); i = paramXmlPullParser.next()) {}
        if (i == 2)
        {
          a(paramXmlPullParser, paramXmlPullParser.getName(), (AttributeSet)localObject);
          a(paramXmlPullParser, paramIPreferenceScreen, (AttributeSet)localObject);
          return;
        }
        paramIPreferenceScreen = new StringBuilder();
        paramIPreferenceScreen.append(paramXmlPullParser.getPositionDescription());
        paramIPreferenceScreen.append(": No start tag found!");
        throw new InflateException(paramIPreferenceScreen.toString());
      }
      catch (IOException paramIPreferenceScreen)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramXmlPullParser.getPositionDescription());
        ((StringBuilder)localObject).append(": ");
        ((StringBuilder)localObject).append(paramIPreferenceScreen.getMessage());
        paramXmlPullParser = new InflateException(((StringBuilder)localObject).toString());
        paramXmlPullParser.initCause(paramIPreferenceScreen);
        throw paramXmlPullParser;
      }
      catch (XmlPullParserException paramXmlPullParser)
      {
        paramIPreferenceScreen = new InflateException(paramXmlPullParser.getMessage());
        paramIPreferenceScreen.initCause(paramXmlPullParser);
        throw paramIPreferenceScreen;
      }
      catch (InflateException paramXmlPullParser)
      {
        throw paramXmlPullParser;
      }
    }
    for (;;)
    {
      throw paramXmlPullParser;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weui.base.preference.d
 * JD-Core Version:    0.7.0.1
 */