package com.tencent.mobileqq.earlydownload;

import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class EarlyXmlParser
  extends DefaultHandler
{
  private StringBuilder a;
  private XmlData b;
  private Class<? extends XmlData> c;
  
  public EarlyXmlParser(Class<? extends XmlData> paramClass)
  {
    this.c = paramClass;
  }
  
  public XmlData a()
  {
    return this.b;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.a.append(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void endDocument()
  {
    this.a = null;
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    if (this.b == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EarlyDown", 2, "endElement() return. data is null.");
      }
      return;
    }
    if (this.c.getSimpleName().equals(paramString2)) {
      return;
    }
    paramString1 = EarlyDataFactory.a(this.c, paramString2);
    if (paramString1 == null)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("endElement() return.can't find 'Field:");
        paramString1.append(paramString2);
        QLog.e("EarlyDown", 2, paramString1.toString());
      }
      return;
    }
    if (!paramString1.isAccessible()) {
      paramString1.setAccessible(true);
    }
    paramString3 = this.a.toString();
    try
    {
      paramString2 = paramString1.getType();
      if (paramString2 == String.class)
      {
        paramString1.set(this.b, paramString3);
        return;
      }
      if (paramString2 == Long.TYPE)
      {
        long l = Long.parseLong(paramString3);
        paramString1.setLong(this.b, l);
        return;
      }
      if (paramString2 == Double.TYPE)
      {
        double d = Double.parseDouble(paramString3);
        paramString1.setDouble(this.b, d);
        return;
      }
      if (paramString2 == Integer.TYPE)
      {
        int i = Integer.parseInt(paramString3);
        paramString1.setInt(this.b, i);
        return;
      }
      if (paramString2 == Float.TYPE)
      {
        float f = Float.parseFloat(paramString3);
        paramString1.setFloat(this.b, f);
        return;
      }
      if (paramString2 == Short.TYPE)
      {
        short s = Short.parseShort(paramString3);
        paramString1.setShort(this.b, s);
        return;
      }
      if (paramString2 == Byte.TYPE)
      {
        byte b1 = Byte.parseByte(paramString3);
        paramString1.setByte(this.b, b1);
        return;
      }
      if (paramString2 == Boolean.TYPE)
      {
        boolean bool = Boolean.parseBoolean(paramString3);
        paramString1.setBoolean(this.b, bool);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("endElement() return. Type:");
        paramString1.append(paramString2.toString());
        paramString1.append(" is NOT SUPPORT!");
        QLog.e("EarlyDown", 2, paramString1.toString());
      }
      return;
    }
    catch (IllegalAccessException paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("endElement() throws exception:");
        paramString2.append(paramString1.getMessage());
        QLog.e("EarlyDown", 2, paramString2.toString());
        return;
      }
    }
    catch (IllegalArgumentException paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("endElement() throws exception:");
        paramString2.append(paramString1.getMessage());
        QLog.e("EarlyDown", 2, paramString2.toString());
        return;
      }
    }
    catch (NumberFormatException paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("endElement() throws exception:");
        paramString2.append(paramString1.getMessage());
        QLog.e("EarlyDown", 2, paramString2.toString());
      }
    }
  }
  
  public void startDocument()
  {
    this.a = new StringBuilder();
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    this.a.setLength(0);
    if (this.c.getSimpleName().equals(paramString2)) {
      try
      {
        this.b = ((XmlData)this.c.newInstance());
        return;
      }
      catch (IllegalAccessException paramString1)
      {
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("startElement() throw exceptin:");
          paramString2.append(paramString1.getMessage());
          QLog.e("EarlyDown", 2, paramString2.toString());
          return;
        }
      }
      catch (InstantiationException paramString1)
      {
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("startElement() throw exceptin:");
          paramString2.append(paramString1.getMessage());
          QLog.e("EarlyDown", 2, paramString2.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.EarlyXmlParser
 * JD-Core Version:    0.7.0.1
 */