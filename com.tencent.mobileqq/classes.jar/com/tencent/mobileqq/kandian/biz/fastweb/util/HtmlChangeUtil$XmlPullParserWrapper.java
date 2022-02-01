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
  HtmlChangeUtil.TextStyleInfo a;
  XmlPullParser b;
  
  public HtmlChangeUtil$XmlPullParserWrapper(XmlPullParser paramXmlPullParser, HtmlChangeUtil.TextStyleInfo paramTextStyleInfo)
  {
    this.b = paramXmlPullParser;
    this.a = paramTextStyleInfo;
  }
  
  public int a()
  {
    return this.b.getDepth();
  }
  
  public String a(int paramInt)
  {
    return this.b.getAttributeName(paramInt);
  }
  
  public void a(Reader paramReader)
  {
    this.b.setInput(paramReader);
  }
  
  public String b()
  {
    return this.b.getText();
  }
  
  public String b(int paramInt)
  {
    return this.b.getAttributeValue(paramInt);
  }
  
  public String c()
  {
    return this.b.getName();
  }
  
  public int d()
  {
    return this.b.getAttributeCount();
  }
  
  public int e()
  {
    return this.b.getEventType();
  }
  
  public void f()
  {
    int j = this.b.getEventType();
    int m = this.b.getDepth();
    int i = 0;
    if (j != 2)
    {
      if (j != 3) {
        return;
      }
      QLog.d("fast_web", 2, new Object[] { "【remove】 depth : ", Integer.valueOf(m), ", name : ", this.b.getName(), " size : ", Integer.valueOf(this.a.b.size()) });
      if (!this.a.c.isEmpty())
      {
        this.a.c.pop();
        this.a.b.remove(m);
        this.a.a.remove(m);
        return;
      }
      throw new RuntimeException("tag is not close !");
    }
    String str = this.b.getName();
    this.a.c.push(str);
    QLog.d("fast_web", 2, new Object[] { "【start】 depth : ", Integer.valueOf(m), ", name : ", str });
    if (HtmlChangeUtil.c().equals(str)) {
      while (i < this.b.getAttributeCount())
      {
        if (this.b.getAttributeName(i).trim().equals("style"))
        {
          this.a.b.put(m, HtmlChangeUtil.a(this.b.getAttributeValue(i).trim()));
          return;
        }
        i += 1;
      }
    }
    if (HtmlChangeUtil.d().equals(str))
    {
      this.a.b.put(m, HtmlChangeUtil.SpanBuilder.a(4, new Object[] { Integer.valueOf(1) }));
      return;
    }
    if (HtmlChangeUtil.e().equals(str))
    {
      this.a.b.put(m, HtmlChangeUtil.SpanBuilder.a(3, new Object[0]));
      return;
    }
    if (HtmlChangeUtil.f().equals(str))
    {
      this.a.b.put(m, HtmlChangeUtil.SpanBuilder.a(4, new Object[] { Integer.valueOf(2) }));
      return;
    }
    if ((HtmlChangeUtil.g().equals(str)) || (HtmlChangeUtil.h().equals(str)))
    {
      j = 0;
      for (int k = 0; j < this.b.getAttributeCount(); k = i)
      {
        if (!this.b.getAttributeName(j).trim().equals("style"))
        {
          i = k;
        }
        else
        {
          str = (String)HtmlChangeUtil.b(this.b.getAttributeValue(j)).get("text-align");
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
      this.a.a.put(m, Integer.valueOf(k));
    }
  }
  
  public int g()
  {
    int i = this.b.next();
    f();
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.HtmlChangeUtil.XmlPullParserWrapper
 * JD-Core Version:    0.7.0.1
 */