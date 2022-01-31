package com.tencent.qqmini.sdk.core.auth.parser;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.Log;
import bglo;
import com.tencent.qqmini.sdk.core.auth.EventInfo;
import com.tencent.qqmini.sdk.core.auth.PermissionInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class LocalPermissionParser
  extends AbstractPermissionParser
{
  private static final int PERMISSION_XML = 2131886085;
  private Context mContext;
  
  public LocalPermissionParser(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void appendRequestPermission(EventInfo paramEventInfo, String paramString)
  {
    if ((paramEventInfo == null) || (paramString == null)) {
      return;
    }
    if (paramEventInfo.requestPermissions == null) {
      paramEventInfo.requestPermissions = new ArrayList();
    }
    paramEventInfo.requestPermissions.add(paramString);
  }
  
  private void doParse()
  {
    Object localObject3 = null;
    clear();
    XmlResourceParser localXmlResourceParser = this.mContext.getResources().getXml(2131886085);
    Object localObject2 = null;
    Object localObject1 = null;
    if (localXmlResourceParser.getEventType() != 1)
    {
      String str = localXmlResourceParser.getName();
      Object localObject6;
      Object localObject5;
      Object localObject4;
      switch (localXmlResourceParser.getEventType())
      {
      default: 
        localObject6 = localObject1;
        localObject5 = localObject2;
        localObject4 = localObject3;
      }
      for (;;)
      {
        localXmlResourceParser.next();
        localObject3 = localObject4;
        localObject2 = localObject5;
        localObject1 = localObject6;
        break;
        if ("permission".equals(str))
        {
          localObject6 = parsePermission(localXmlResourceParser);
          localObject4 = localObject3;
          localObject5 = localObject2;
        }
        else if ("event".equals(str))
        {
          localObject5 = parseEvent(localXmlResourceParser);
          localObject4 = localObject3;
          localObject6 = localObject1;
        }
        else
        {
          localObject4 = localObject3;
          localObject5 = localObject2;
          localObject6 = localObject1;
          if ("request-permission".equals(str))
          {
            localObject4 = parseRequestPermission(localXmlResourceParser);
            localObject5 = localObject2;
            localObject6 = localObject1;
            continue;
            if ("permission".equals(str))
            {
              addPermission(localObject1);
              localObject4 = localObject3;
              localObject5 = localObject2;
              localObject6 = localObject1;
            }
            else if ("event".equals(str))
            {
              addEvent(localObject2);
              localObject4 = localObject3;
              localObject5 = localObject2;
              localObject6 = localObject1;
            }
            else
            {
              localObject4 = localObject3;
              localObject5 = localObject2;
              localObject6 = localObject1;
              if ("request-permission".equals(str))
              {
                appendRequestPermission(localObject2, localObject3);
                localObject4 = localObject3;
                localObject5 = localObject2;
                localObject6 = localObject1;
              }
            }
          }
        }
      }
    }
  }
  
  private String getStringByAttribute(String paramString)
  {
    String str = paramString;
    if (!bglo.a(paramString))
    {
      str = paramString;
      if ('@' == paramString.charAt(0))
      {
        paramString = paramString.substring(1);
        str = paramString;
        if (isNumeric(paramString)) {
          str = this.mContext.getString(Integer.parseInt(paramString));
        }
      }
    }
    return str;
  }
  
  private static boolean isNumeric(String paramString)
  {
    return paramString.matches("\\d+(\\.\\d+)?");
  }
  
  private EventInfo parseEvent(XmlPullParser paramXmlPullParser)
  {
    try
    {
      EventInfo localEventInfo = new EventInfo();
      int i = 0;
      Object localObject;
      for (;;)
      {
        localObject = localEventInfo;
        if (i >= paramXmlPullParser.getAttributeCount()) {
          break;
        }
        localObject = paramXmlPullParser.getAttributeName(i);
        String str = paramXmlPullParser.getAttributeValue(i);
        if ("name".equals(localObject)) {
          localEventInfo.name = str;
        }
        i += 1;
      }
      return localObject;
    }
    catch (Exception paramXmlPullParser)
    {
      QMLog.e("PermissionParser", paramXmlPullParser.getMessage(), paramXmlPullParser);
      localObject = null;
    }
  }
  
  private PermissionInfo parsePermission(XmlPullParser paramXmlPullParser)
  {
    PermissionInfo localPermissionInfo;
    int i;
    String str1;
    String str2;
    try
    {
      localPermissionInfo = new PermissionInfo();
      i = 0;
      if (i >= paramXmlPullParser.getAttributeCount()) {
        break label235;
      }
      str1 = paramXmlPullParser.getAttributeName(i);
      str2 = paramXmlPullParser.getAttributeValue(i);
      if ("id".equals(str1)) {
        localPermissionInfo.id = str2;
      } else if ("name".equals(str1)) {
        localPermissionInfo.name = getStringByAttribute(str2);
      }
    }
    catch (Exception paramXmlPullParser)
    {
      QMLog.e("PermissionParser", paramXmlPullParser.getMessage(), paramXmlPullParser);
      return null;
    }
    if ("description".equals(str1)) {
      localPermissionInfo.description = getStringByAttribute(str2);
    } else if ("description-reject".equals(str1)) {
      localPermissionInfo.rejectDescription = getStringByAttribute(str2);
    } else if ("built-in".equals(str1)) {
      localPermissionInfo.builtIn = Boolean.parseBoolean(str2);
    } else if ("min-sdk-version".equals(str1)) {
      if (!isNumeric(str2)) {
        break label270;
      }
    }
    label270:
    for (int j = Integer.parseInt(str2);; j = 1)
    {
      if (Build.VERSION.SDK_INT < j)
      {
        Log.i("PermissionParser", "Ignore permission " + localPermissionInfo + ". Required min-sdk-version is " + j);
        return null;
        label235:
        if (bglo.a(localPermissionInfo.rejectDescription)) {
          localPermissionInfo.rejectDescription = this.mContext.getString(2131694359);
        }
        return localPermissionInfo;
      }
      i += 1;
      break;
    }
  }
  
  private String parseRequestPermission(XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser.next() == 4) {
      return paramXmlPullParser.getText();
    }
    return null;
  }
  
  public boolean parse()
  {
    try
    {
      doParse();
      return true;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      QMLog.e("PermissionParser", localXmlPullParserException.getMessage(), localXmlPullParserException);
      return false;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QMLog.e("PermissionParser", localIOException.getMessage(), localIOException);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.e("PermissionParser", localException.getMessage(), localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.auth.parser.LocalPermissionParser
 * JD-Core Version:    0.7.0.1
 */