package com.tencent.qqmini.sdk.auth.parser;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.qqmini.sdk.R.string;
import com.tencent.qqmini.sdk.R.xml;
import com.tencent.qqmini.sdk.auth.EventInfo;
import com.tencent.qqmini.sdk.auth.PermissionInfo;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class LocalPermissionParser
  extends AbstractPermissionParser
{
  private static final int PERMISSION_XML = R.xml.mini_sdk_permissions;
  private Context mContext;
  
  public LocalPermissionParser(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void appendRequestPermission(EventInfo paramEventInfo, String paramString)
  {
    if (paramEventInfo != null)
    {
      if (paramString == null) {
        return;
      }
      if (paramEventInfo.requestPermissions == null) {
        paramEventInfo.requestPermissions = new ArrayList();
      }
      paramEventInfo.requestPermissions.add(paramString);
    }
  }
  
  private void doParse()
  {
    clear();
    XmlResourceParser localXmlResourceParser = this.mContext.getResources().getXml(PERMISSION_XML);
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject6;
    for (Object localObject1 = localObject2; localXmlResourceParser.getEventType() != 1; localObject1 = localObject6)
    {
      String str = localXmlResourceParser.getName();
      int i = localXmlResourceParser.getEventType();
      Object localObject4;
      Object localObject5;
      if (i != 2)
      {
        if (i != 3)
        {
          localObject4 = localObject3;
          localObject5 = localObject2;
          localObject6 = localObject1;
        }
        else if ("permission".equals(str))
        {
          addPermission((PermissionInfo)localObject3);
          localObject4 = localObject3;
          localObject5 = localObject2;
          localObject6 = localObject1;
        }
        else if ("event".equals(str))
        {
          addEvent((EventInfo)localObject2);
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
            appendRequestPermission((EventInfo)localObject2, localObject1);
            localObject4 = localObject3;
            localObject5 = localObject2;
            localObject6 = localObject1;
          }
        }
      }
      else if ("permission".equals(str))
      {
        localObject4 = parsePermission(localXmlResourceParser);
        localObject5 = localObject2;
        localObject6 = localObject1;
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
          localObject6 = parseRequestPermission(localXmlResourceParser);
          localObject5 = localObject2;
          localObject4 = localObject3;
        }
      }
      localXmlResourceParser.next();
      localObject3 = localObject4;
      localObject2 = localObject5;
    }
  }
  
  private String getStringByAttribute(String paramString)
  {
    String str = paramString;
    if (!StringUtil.isEmpty(paramString))
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
      while (i < paramXmlPullParser.getAttributeCount())
      {
        String str1 = paramXmlPullParser.getAttributeName(i);
        String str2 = paramXmlPullParser.getAttributeValue(i);
        if ("name".equals(str1)) {
          localEventInfo.name = str2;
        }
        i += 1;
      }
      return localEventInfo;
    }
    catch (Exception paramXmlPullParser)
    {
      QMLog.e("PermissionParser", paramXmlPullParser.getMessage(), paramXmlPullParser);
    }
    return null;
  }
  
  private PermissionInfo parsePermission(XmlPullParser paramXmlPullParser)
  {
    for (;;)
    {
      int i;
      try
      {
        PermissionInfo localPermissionInfo = new PermissionInfo();
        i = 0;
        if (i < paramXmlPullParser.getAttributeCount())
        {
          String str1 = paramXmlPullParser.getAttributeName(i);
          String str2 = paramXmlPullParser.getAttributeValue(i);
          if ("id".equals(str1))
          {
            localPermissionInfo.id = str2;
            break label306;
          }
          if ("name".equals(str1))
          {
            localPermissionInfo.name = getStringByAttribute(str2);
            break label306;
          }
          if ("description".equals(str1))
          {
            localPermissionInfo.description = getStringByAttribute(str2);
            break label306;
          }
          if ("description-reject".equals(str1))
          {
            localPermissionInfo.rejectDescription = getStringByAttribute(str2);
            break label306;
          }
          if ("built-in".equals(str1))
          {
            localPermissionInfo.builtIn = Boolean.parseBoolean(str2);
            break label306;
          }
          if ("min-sdk-version".equals(str1))
          {
            if (isNumeric(str2))
            {
              j = Integer.parseInt(str2);
              if (Build.VERSION.SDK_INT >= j) {
                break label306;
              }
              paramXmlPullParser = new StringBuilder();
              paramXmlPullParser.append("Ignore permission ");
              paramXmlPullParser.append(localPermissionInfo);
              paramXmlPullParser.append(". Required min-sdk-version is ");
              paramXmlPullParser.append(j);
              Log.i("PermissionParser", paramXmlPullParser.toString());
              return null;
            }
          }
          else
          {
            if (!"report_sub_action".endsWith(str1)) {
              break label306;
            }
            localPermissionInfo.reportSubAction = getStringByAttribute(str2);
            break label306;
          }
        }
        else
        {
          if (StringUtil.isEmpty(localPermissionInfo.rejectDescription)) {
            localPermissionInfo.rejectDescription = this.mContext.getString(R.string.mini_sdk_perm_desc_default_reject);
          }
          return localPermissionInfo;
        }
      }
      catch (Exception paramXmlPullParser)
      {
        QMLog.e("PermissionParser", paramXmlPullParser.getMessage(), paramXmlPullParser);
        return null;
      }
      int j = 1;
      continue;
      label306:
      i += 1;
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
    catch (Exception localException)
    {
      QMLog.e("PermissionParser", localException.getMessage(), localException);
    }
    catch (IOException localIOException)
    {
      QMLog.e("PermissionParser", localIOException.getMessage(), localIOException);
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      QMLog.e("PermissionParser", localXmlPullParserException.getMessage(), localXmlPullParserException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.auth.parser.LocalPermissionParser
 * JD-Core Version:    0.7.0.1
 */