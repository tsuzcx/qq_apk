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
  private Class jdField_a_of_type_JavaLangClass;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  
  public EarlyXmlParser(Class paramClass)
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
    if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData == null) {
      if (QLog.isColorLevel()) {
        QLog.e("EarlyDown", 2, "endElement() return. data is null.");
      }
    }
    label21:
    label278:
    do
    {
      do
      {
        break label21;
        for (;;)
        {
          return;
          if (!this.jdField_a_of_type_JavaLangClass.getSimpleName().equals(paramString2))
          {
            paramString1 = EarlyDataFactory.a(this.jdField_a_of_type_JavaLangClass, paramString2);
            if (paramString1 == null)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("EarlyDown", 2, "endElement() return.can't find 'Field:" + paramString2);
              return;
            }
            if (!paramString1.isAccessible()) {
              paramString1.setAccessible(true);
            }
            paramString2 = this.jdField_a_of_type_JavaLangStringBuilder.toString();
            try
            {
              paramString3 = paramString1.getType();
              if (paramString3 == String.class)
              {
                paramString1.set(this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData, paramString2);
                return;
              }
            }
            catch (NumberFormatException paramString1)
            {
              if (QLog.isColorLevel())
              {
                QLog.e("EarlyDown", 2, "endElement() throws exception:" + paramString1.getMessage());
                return;
                if (paramString3 == Long.TYPE)
                {
                  long l = Long.parseLong(paramString2);
                  paramString1.setLong(this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData, l);
                  return;
                }
              }
            }
            catch (IllegalArgumentException paramString1)
            {
              if (QLog.isColorLevel())
              {
                QLog.e("EarlyDown", 2, "endElement() throws exception:" + paramString1.getMessage());
                return;
                if (paramString3 != Double.TYPE) {
                  break label278;
                }
                double d = Double.parseDouble(paramString2);
                paramString1.setDouble(this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData, d);
                return;
              }
            }
            catch (IllegalAccessException paramString1) {}
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("EarlyDown", 2, "endElement() throws exception:" + paramString1.getMessage());
      return;
      if (paramString3 == Integer.TYPE)
      {
        int i = Integer.parseInt(paramString2);
        paramString1.setInt(this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData, i);
        return;
      }
      if (paramString3 == Float.TYPE)
      {
        float f = Float.parseFloat(paramString2);
        paramString1.setFloat(this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData, f);
        return;
      }
      if (paramString3 == Short.TYPE)
      {
        short s = Short.parseShort(paramString2);
        paramString1.setShort(this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData, s);
        return;
      }
      if (paramString3 == Byte.TYPE)
      {
        byte b = Byte.parseByte(paramString2);
        paramString1.setByte(this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData, b);
        return;
      }
      if (paramString3 == Boolean.TYPE)
      {
        boolean bool = Boolean.parseBoolean(paramString2);
        paramString1.setBoolean(this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData, bool);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("EarlyDown", 2, "endElement() return. Type:" + paramString3.toString() + " is NOT SUPPORT!");
  }
  
  public void startDocument()
  {
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    if (this.jdField_a_of_type_JavaLangClass.getSimpleName().equals(paramString2)) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData = ((XmlData)this.jdField_a_of_type_JavaLangClass.newInstance());
      return;
    }
    catch (InstantiationException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EarlyDown", 2, "startElement() throw exceptin:" + paramString1.getMessage());
      return;
    }
    catch (IllegalAccessException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EarlyDown", 2, "startElement() throw exceptin:" + paramString1.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.EarlyXmlParser
 * JD-Core Version:    0.7.0.1
 */