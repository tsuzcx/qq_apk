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
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  Stack<Object> jdField_a_of_type_JavaUtilStack = new Stack();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  
  public HashMap<String, Object> a()
  {
    return (HashMap)this.jdField_a_of_type_JavaLangObject;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    System.out.println("characters:");
    if (paramInt2 > 0)
    {
      Object localObject1;
      Object localObject2;
      if (this.b)
      {
        this.jdField_a_of_type_JavaLangString = new String(paramArrayOfChar, paramInt1, paramInt2);
        localObject1 = System.out;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("key:");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
      }
      if (this.c)
      {
        if (HashMap.class.equals(this.jdField_a_of_type_JavaUtilStack.peek().getClass()))
        {
          localObject1 = (HashMap)this.jdField_a_of_type_JavaUtilStack.peek();
          localObject2 = new String(paramArrayOfChar, paramInt1, paramInt2);
          ((HashMap)localObject1).put(this.jdField_a_of_type_JavaLangString, localObject2);
        }
        else if (ArrayList.class.equals(this.jdField_a_of_type_JavaUtilStack.peek().getClass()))
        {
          ((ArrayList)this.jdField_a_of_type_JavaUtilStack.peek()).add(new String(paramArrayOfChar, paramInt1, paramInt2));
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
    System.out.println(QQFileManagerUtilImpl.a(2131704656));
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    "plist".equals(paramString3);
    if ("key".equals(paramString3)) {
      this.b = false;
    }
    if ("string".equals(paramString3)) {
      this.c = false;
    }
    if ("integer".equals(paramString3)) {
      this.c = false;
    }
    if ("array".equals(paramString3)) {
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_JavaUtilStack.pop();
    }
    if ("dict".equals(paramString3)) {
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_JavaUtilStack.pop();
    }
  }
  
  public void startDocument()
  {
    System.out.println(QQFileManagerUtilImpl.a(2131704646));
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if ("plist".equals(paramString3)) {
      this.jdField_a_of_type_Boolean = true;
    }
    if ("dict".equals(paramString3)) {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilStack.push(new HashMap());
        this.jdField_a_of_type_Boolean ^= true;
      }
      else
      {
        paramString1 = this.jdField_a_of_type_JavaUtilStack.peek();
        paramString2 = new HashMap();
        if ((paramString1 instanceof ArrayList)) {
          ((ArrayList)paramString1).add(paramString2);
        } else if ((paramString1 instanceof HashMap)) {
          ((HashMap)paramString1).put(this.jdField_a_of_type_JavaLangString, paramString2);
        }
        this.jdField_a_of_type_JavaUtilStack.push(paramString2);
      }
    }
    if ("key".equals(paramString3)) {
      this.b = true;
    }
    if ("true".equals(paramString3)) {
      ((HashMap)this.jdField_a_of_type_JavaUtilStack.peek()).put(this.jdField_a_of_type_JavaLangString, Boolean.valueOf(true));
    }
    if ("false".equals(paramString3)) {
      ((HashMap)this.jdField_a_of_type_JavaUtilStack.peek()).put(this.jdField_a_of_type_JavaLangString, Boolean.valueOf(false));
    }
    if ("array".equals(paramString3)) {
      if (this.jdField_a_of_type_Boolean)
      {
        paramString1 = new ArrayList();
        this.jdField_a_of_type_JavaUtilStack.push(paramString1);
        this.jdField_a_of_type_Boolean ^= true;
      }
      else
      {
        paramString1 = (HashMap)this.jdField_a_of_type_JavaUtilStack.peek();
        paramString2 = new ArrayList();
        this.jdField_a_of_type_JavaUtilStack.push(paramString2);
        paramString1.put(this.jdField_a_of_type_JavaLangString, paramString2);
      }
    }
    if ("string".equals(paramString3)) {
      this.c = true;
    }
    if ("integer".equals(paramString3)) {
      this.c = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.PreViewDataHandler
 * JD-Core Version:    0.7.0.1
 */