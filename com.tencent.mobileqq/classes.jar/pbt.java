import android.util.Xml;
import com.tencent.qphone.base.util.QLog;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class pbt
{
  public static Map<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    label159:
    for (;;)
    {
      try
      {
        XmlPullParser localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        localXmlPullParser.setInput(new StringReader(paramString));
        int i = localXmlPullParser.getEventType();
        if (i != 1)
        {
          if (localXmlPullParser.getEventType() == 0)
          {
            QLog.d("AladdinParseUtils", 2, "[parseContentXml] START_DOCUMENT");
            i = localXmlPullParser.next();
            continue;
          }
          if (localXmlPullParser.getEventType() != 2) {
            continue;
          }
          QLog.d("AladdinParseUtils", 2, "[parseContentXml] START_TAG");
          paramString = localXmlPullParser.getName();
          if (!"configs".equals(paramString)) {
            break label159;
          }
          a(localXmlPullParser, localHashMap);
          continue;
        }
        QLog.e("AladdinParseUtils", 1, "[parseContentXml] unknown tag: " + paramString);
      }
      catch (Exception paramString)
      {
        QLog.e("AladdinParseUtils", 1, "[parseContentXml] ", paramString);
        if (QLog.isColorLevel()) {
          QLog.d("AladdinParseUtils", 2, "[parseContentXml] result=" + localHashMap);
        }
        return localHashMap;
      }
    }
  }
  
  private static void a(XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser.getEventType() != 2) {
      throw new IllegalStateException();
    }
    int i = 1;
    while (i != 0) {
      switch (paramXmlPullParser.next())
      {
      default: 
        break;
      case 1: 
        throw new IllegalStateException();
      case 3: 
        i -= 1;
        break;
      case 2: 
        QLog.d("AladdinParseUtils", 2, "[skip] " + paramXmlPullParser.getName());
        i += 1;
      }
    }
  }
  
  private static void a(XmlPullParser paramXmlPullParser, Map<String, String> paramMap)
  {
    paramXmlPullParser.require(2, null, "configs");
    int i = paramXmlPullParser.next();
    if ((i != 3) && (i != 1))
    {
      if (i == 2) {
        b(paramXmlPullParser, paramMap);
      }
      for (;;)
      {
        i = paramXmlPullParser.next();
        break;
        QLog.e("AladdinParseUtils", 1, "[readConfigs] unknown event type: " + i);
      }
    }
    paramXmlPullParser.require(3, null, "configs");
  }
  
  private static void b(XmlPullParser paramXmlPullParser, Map<String, String> paramMap)
  {
    if (paramXmlPullParser.getEventType() != 2) {
      throw new IllegalStateException();
    }
    String str = paramXmlPullParser.getName();
    int i = paramXmlPullParser.next();
    if ((i != 3) && (i != 1))
    {
      if (i == 4) {
        paramMap.put(str, paramXmlPullParser.getText());
      }
      for (;;)
      {
        i = paramXmlPullParser.next();
        break;
        if (i == 2)
        {
          QLog.d("AladdinParseUtils", 2, "[readTag] unexpected nested tag: " + paramXmlPullParser.getName() + ", skip.");
          a(paramXmlPullParser);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pbt
 * JD-Core Version:    0.7.0.1
 */