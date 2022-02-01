package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.io.Reader;
import java.util.Map;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;

class HtmlChangeUtil$XmlPullParserWrapper
{
  HtmlChangeUtil.TextStyleInfo jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilHtmlChangeUtil$TextStyleInfo;
  XmlPullParser jdField_a_of_type_OrgXmlpullV1XmlPullParser;
  
  public HtmlChangeUtil$XmlPullParserWrapper(XmlPullParser paramXmlPullParser, HtmlChangeUtil.TextStyleInfo paramTextStyleInfo)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlPullParser = paramXmlPullParser;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilHtmlChangeUtil$TextStyleInfo = paramTextStyleInfo;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getDepth();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getText();
  }
  
  public String a(int paramInt)
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeName(paramInt);
  }
  
  public void a()
  {
    int j = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getEventType();
    int m = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getDepth();
    int i = 0;
    if (j != 2)
    {
      if (j != 3) {
        return;
      }
      QLog.d("fast_web", 2, new Object[] { "【remove】 depth : ", Integer.valueOf(m), ", name : ", this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName(), " size : ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilHtmlChangeUtil$TextStyleInfo.b.size()) });
      if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilHtmlChangeUtil$TextStyleInfo.jdField_a_of_type_JavaUtilStack.isEmpty())
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilHtmlChangeUtil$TextStyleInfo.jdField_a_of_type_JavaUtilStack.pop();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilHtmlChangeUtil$TextStyleInfo.b.remove(m);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilHtmlChangeUtil$TextStyleInfo.jdField_a_of_type_AndroidUtilSparseArray.remove(m);
        return;
      }
      throw new RuntimeException("tag is not close !");
    }
    String str = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilHtmlChangeUtil$TextStyleInfo.jdField_a_of_type_JavaUtilStack.push(str);
    QLog.d("fast_web", 2, new Object[] { "【start】 depth : ", Integer.valueOf(m), ", name : ", str });
    if (HtmlChangeUtil.c().equals(str)) {
      while (i < this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeCount())
      {
        if (this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeName(i).trim().equals("style"))
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilHtmlChangeUtil$TextStyleInfo.b.put(m, HtmlChangeUtil.a(this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeValue(i).trim()));
          return;
        }
        i += 1;
      }
    }
    if (HtmlChangeUtil.d().equals(str))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilHtmlChangeUtil$TextStyleInfo.b.put(m, HtmlChangeUtil.SpanBuilder.a(4, new Object[] { Integer.valueOf(1) }));
      return;
    }
    if (HtmlChangeUtil.e().equals(str))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilHtmlChangeUtil$TextStyleInfo.b.put(m, HtmlChangeUtil.SpanBuilder.a(3, new Object[0]));
      return;
    }
    if (HtmlChangeUtil.f().equals(str))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilHtmlChangeUtil$TextStyleInfo.b.put(m, HtmlChangeUtil.SpanBuilder.a(4, new Object[] { Integer.valueOf(2) }));
      return;
    }
    if ((HtmlChangeUtil.g().equals(str)) || (HtmlChangeUtil.h().equals(str)))
    {
      j = 0;
      for (int k = 0; j < this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeCount(); k = i)
      {
        if (!this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeName(j).trim().equals("style"))
        {
          i = k;
        }
        else
        {
          str = (String)HtmlChangeUtil.a(this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeValue(j)).get("text-align");
          i = k;
          if (!TextUtils.isEmpty(str)) {
            if ("right".equals(str))
            {
              i = 2;
            }
            else if ("left".equals(str))
            {
              i = 0;
            }
            else
            {
              i = k;
              if ("center".equals(str)) {
                i = 1;
              }
            }
          }
        }
        j += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilHtmlChangeUtil$TextStyleInfo.jdField_a_of_type_AndroidUtilSparseArray.put(m, Integer.valueOf(k));
    }
  }
  
  public void a(Reader paramReader)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.setInput(paramReader);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeCount();
  }
  
  public String b()
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName();
  }
  
  public String b(int paramInt)
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeValue(paramInt);
  }
  
  public int c()
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getEventType();
  }
  
  public int d()
  {
    int i = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.next();
    a();
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.HtmlChangeUtil.XmlPullParserWrapper
 * JD-Core Version:    0.7.0.1
 */