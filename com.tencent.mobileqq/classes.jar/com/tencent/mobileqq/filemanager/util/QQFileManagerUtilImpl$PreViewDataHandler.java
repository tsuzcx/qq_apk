package com.tencent.mobileqq.filemanager.util;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class QQFileManagerUtilImpl$PreViewDataHandler
  extends DefaultHandler
{
  Stack<Object> a = new Stack();
  private boolean b = false;
  private boolean c = false;
  private String d;
  private boolean e = false;
  private Object f;
  
  public HashMap<String, Object> a()
  {
    return (HashMap)this.f;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    System.out.println("characters:");
    if (paramInt2 > 0)
    {
      Object localObject1;
      Object localObject2;
      if (this.c)
      {
        this.d = new String(paramArrayOfChar, paramInt1, paramInt2);
        localObject1 = System.out;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("key:");
        ((StringBuilder)localObject2).append(this.d);
        ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
      }
      if (this.e)
      {
        if (HashMap.class.equals(this.a.peek().getClass()))
        {
          localObject1 = (HashMap)this.a.peek();
          localObject2 = new String(paramArrayOfChar, paramInt1, paramInt2);
          ((HashMap)localObject1).put(this.d, localObject2);
        }
        else if (ArrayList.class.equals(this.a.peek().getClass()))
        {
          ((ArrayList)this.a.peek()).add(new String(paramArrayOfChar, paramInt1, paramInt2));
        }
        localObject1 = System.out;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("value:");
        ((StringBuilder)localObject2).append(new String(paramArrayOfChar, paramInt1, paramInt2));
        ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public void endDocument()
  {
    System.out.println(QQFileManagerUtilImpl.a(2131902560));
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    "plist".equals(paramString3);
    if ("key".equals(paramString3)) {
      this.c = false;
    }
    if ("string".equals(paramString3)) {
      this.e = false;
    }
    if ("integer".equals(paramString3)) {
      this.e = false;
    }
    if ("array".equals(paramString3)) {
      this.f = this.a.pop();
    }
    if ("dict".equals(paramString3)) {
      this.f = this.a.pop();
    }
  }
  
  public void startDocument()
  {
    System.out.println(QQFileManagerUtilImpl.a(2131902550));
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if ("plist".equals(paramString3)) {
      this.b = true;
    }
    if ("dict".equals(paramString3)) {
      if (this.b)
      {
        this.a.push(new HashMap());
        this.b ^= true;
      }
      else
      {
        paramString1 = this.a.peek();
        paramString2 = new HashMap();
        if ((paramString1 instanceof ArrayList)) {
          ((ArrayList)paramString1).add(paramString2);
        } else if ((paramString1 instanceof HashMap)) {
          ((HashMap)paramString1).put(this.d, paramString2);
        }
        this.a.push(paramString2);
      }
    }
    if ("key".equals(paramString3)) {
      this.c = true;
    }
    if ("true".equals(paramString3)) {
      ((HashMap)this.a.peek()).put(this.d, Boolean.valueOf(true));
    }
    if ("false".equals(paramString3)) {
      ((HashMap)this.a.peek()).put(this.d, Boolean.valueOf(false));
    }
    if ("array".equals(paramString3)) {
      if (this.b)
      {
        paramString1 = new ArrayList();
        this.a.push(paramString1);
        this.b ^= true;
      }
      else
      {
        paramString1 = (HashMap)this.a.peek();
        paramString2 = new ArrayList();
        this.a.push(paramString2);
        paramString1.put(this.d, paramString2);
      }
    }
    if ("string".equals(paramString3)) {
      this.e = true;
    }
    if ("integer".equals(paramString3)) {
      this.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.PreViewDataHandler
 * JD-Core Version:    0.7.0.1
 */