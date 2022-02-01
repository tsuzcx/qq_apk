package com.tencent.mobileqq.kandian.repo.aladdin;

import android.util.Xml;
import com.tencent.qphone.base.util.QLog;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class AladdinParseUtils
{
  public static Map<String, String> a(String paramString)
  {
    localHashMap = new HashMap();
    try
    {
      XmlPullParser localXmlPullParser = Xml.newPullParser();
      localXmlPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
      localXmlPullParser.setInput(new StringReader(paramString));
      for (int i = localXmlPullParser.getEventType(); i != 1; i = localXmlPullParser.next()) {
        if (localXmlPullParser.getEventType() == 0)
        {
          QLog.d("AladdinParseUtils", 2, "[parseContentXml] START_DOCUMENT");
        }
        else if (localXmlPullParser.getEventType() == 2)
        {
          QLog.d("AladdinParseUtils", 2, "[parseContentXml] START_TAG");
          paramString = localXmlPullParser.getName();
          if ("configs".equals(paramString))
          {
            a(localXmlPullParser, localHashMap);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[parseContentXml] unknown tag: ");
            localStringBuilder.append(paramString);
            QLog.e("AladdinParseUtils", 1, localStringBuilder.toString());
          }
        }
      }
      return localHashMap;
    }
    catch (Exception paramString)
    {
      QLog.e("AladdinParseUtils", 1, "[parseContentXml] ", paramString);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("[parseContentXml] result=");
        paramString.append(localHashMap);
        QLog.d("AladdinParseUtils", 2, paramString.toString());
      }
    }
  }
  
  private static void a(XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser.getEventType() == 2)
    {
      int i = 1;
      while (i != 0)
      {
        int j = paramXmlPullParser.next();
        if (j != 1)
        {
          if (j != 2)
          {
            if (j == 3) {
              i -= 1;
            }
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[skip] ");
            localStringBuilder.append(paramXmlPullParser.getName());
            QLog.d("AladdinParseUtils", 2, localStringBuilder.toString());
            i += 1;
          }
        }
        else {
          throw new IllegalStateException();
        }
      }
      return;
    }
    paramXmlPullParser = new IllegalStateException();
    for (;;)
    {
      throw paramXmlPullParser;
    }
  }
  
  private static void a(XmlPullParser paramXmlPullParser, Map<String, String> paramMap)
  {
    paramXmlPullParser.require(2, null, "configs");
    for (int i = paramXmlPullParser.next(); (i != 3) && (i != 1); i = paramXmlPullParser.next()) {
      if (i == 2)
      {
        b(paramXmlPullParser, paramMap);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[readConfigs] unknown event type: ");
        localStringBuilder.append(i);
        QLog.e("AladdinParseUtils", 1, localStringBuilder.toString());
      }
    }
    paramXmlPullParser.require(3, null, "configs");
  }
  
  private static void b(XmlPullParser paramXmlPullParser, Map<String, String> paramMap)
  {
    if (paramXmlPullParser.getEventType() == 2)
    {
      String str = paramXmlPullParser.getName();
      for (int i = paramXmlPullParser.next(); (i != 3) && (i != 1); i = paramXmlPullParser.next()) {
        if (i == 4)
        {
          paramMap.put(str, paramXmlPullParser.getText());
        }
        else if (i == 2)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[readTag] unexpected nested tag: ");
          localStringBuilder.append(paramXmlPullParser.getName());
          localStringBuilder.append(", skip.");
          QLog.d("AladdinParseUtils", 2, localStringBuilder.toString());
          a(paramXmlPullParser);
        }
      }
      return;
    }
    paramXmlPullParser = new IllegalStateException();
    for (;;)
    {
      throw paramXmlPullParser;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils
 * JD-Core Version:    0.7.0.1
 */