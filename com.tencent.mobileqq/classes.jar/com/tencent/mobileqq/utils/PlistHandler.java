package com.tencent.mobileqq.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class PlistHandler
  extends DefaultHandler
{
  Stack<Object> a = new Stack();
  private boolean b = false;
  private String c;
  private Object d;
  private StringBuilder e = new StringBuilder();
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      this.e.append(new String(paramArrayOfChar, paramInt1, paramInt2).trim());
    }
  }
  
  public void endDocument() {}
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    if (!"plist".equals(paramString2)) {
      if ("array".equals(paramString2)) {
        this.d = this.a.pop();
      } else if ("dict".equals(paramString2)) {
        this.d = this.a.pop();
      } else if ("key".equals(paramString2)) {
        this.c = this.e.toString();
      } else if (("string".equals(paramString2)) || ("integer".equals(paramString2))) {
        if ((this.a.peek() instanceof HashMap)) {
          ((HashMap)this.a.peek()).put(this.c, this.e.toString());
        } else if ((this.a.peek() instanceof ArrayList)) {
          ((ArrayList)this.a.peek()).add(this.e.toString());
        }
      }
    }
    paramString1 = this.e;
    paramString1.delete(0, paramString1.length());
  }
  
  public void startDocument() {}
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if ("plist".equals(paramString2))
    {
      this.b = true;
      return;
    }
    if ("array".equals(paramString2))
    {
      if (this.b)
      {
        paramString1 = new ArrayList();
        this.a.push(paramString1);
        this.b = false;
        return;
      }
      paramString1 = this.a.peek();
      paramString2 = new ArrayList();
      if ((paramString1 instanceof ArrayList)) {
        ((ArrayList)paramString1).add(paramString2);
      } else if ((paramString1 instanceof HashMap)) {
        ((HashMap)paramString1).put(this.c, paramString2);
      }
      this.a.push(paramString2);
      return;
    }
    if ("dict".equals(paramString2))
    {
      if (this.b)
      {
        this.a.push(new HashMap());
        this.b = false;
        return;
      }
      paramString1 = this.a.peek();
      paramString2 = new HashMap();
      if ((paramString1 instanceof ArrayList)) {
        ((ArrayList)paramString1).add(paramString2);
      } else if ((paramString1 instanceof HashMap)) {
        ((HashMap)paramString1).put(this.c, paramString2);
      }
      this.a.push(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PlistHandler
 * JD-Core Version:    0.7.0.1
 */