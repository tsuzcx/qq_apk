package com.tencent.mobileqq.earlydownload;

import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class EarlyXmlParser
  extends DefaultHandler
{
  private XmlData jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData;
  private Class<? extends XmlData> jdField_a_of_type_JavaLangClass;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  
  public EarlyXmlParser(Class<? extends XmlData> paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
  }
  
  public XmlData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void endDocument()
  {
    this.jdField_a_of_type_JavaLangStringBuilder = null;
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EarlyDown", 2, "endElement() return. data is null.");
      }
      return;
    }
    if (this.jdField_a_of_type_JavaLangClass.getSimpleName().equals(paramString2)) {
      return;
    }
    paramString1 = EarlyDataFactory.a(this.jdField_a_of_type_JavaLangClass, paramString2);
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
    paramString3 = this.jdField_a_of_type_JavaLangStringBuilder.toString();
    try
    {
      paramString2 = paramString1.getType();
      if (paramString2 == String.class)
      {
        paramString1.set(this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData, paramString3);
        return;
      }
      if (paramString2 == Long.TYPE)
      {
        long l = Long.parseLong(paramString3);
        paramString1.setLong(this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData, l);
        return;
      }
      if (paramString2 == Double.TYPE)
      {
        double d = Double.parseDouble(paramString3);
        paramString1.setDouble(this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData, d);
        return;
      }
      if (paramString2 == Integer.TYPE)
      {
        int i = Integer.parseInt(paramString3);
        paramString1.setInt(this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData, i);
        return;
      }
      if (paramString2 == Float.TYPE)
      {
        float f = Float.parseFloat(paramString3);
        paramString1.setFloat(this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData, f);
        return;
      }
      if (paramString2 == Short.TYPE)
      {
        short s = Short.parseShort(paramString3);
        paramString1.setShort(this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData, s);
        return;
      }
      if (paramString2 == Byte.TYPE)
      {
        byte b = Byte.parseByte(paramString3);
        paramString1.setByte(this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData, b);
        return;
      }
      if (paramString2 == Boolean.TYPE)
      {
        boolean bool = Boolean.parseBoolean(paramString3);
        paramString1.setBoolean(this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData, bool);
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
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    if (this.jdField_a_of_type_JavaLangClass.getSimpleName().equals(paramString2)) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData = ((XmlData)this.jdField_a_of_type_JavaLangClass.newInstance());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.EarlyXmlParser
 * JD-Core Version:    0.7.0.1
 */