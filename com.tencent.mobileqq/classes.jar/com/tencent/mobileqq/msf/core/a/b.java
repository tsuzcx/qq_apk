package com.tencent.mobileqq.msf.core.a;

import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.util.Map;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class b
{
  public static void a(InputStream paramInputStream, Map paramMap, String paramString)
  {
    try
    {
      SAXParserFactory.newInstance().newSAXParser().parse(paramInputStream, new h(paramString, paramMap));
      paramInputStream.close();
      return;
    }
    catch (Exception paramInputStream)
    {
      paramMap = new StringBuilder();
      paramMap.append(" ");
      paramMap.append(paramInputStream);
      QLog.d("MSF.C.ConfigManager", 1, paramMap.toString(), paramInputStream);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a.b
 * JD-Core Version:    0.7.0.1
 */