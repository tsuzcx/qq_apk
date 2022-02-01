package com.tencent.mobileqq.troop.troopcatalog;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class GroupCatalogXmlHandler
  extends DefaultHandler
{
  protected GroupCatalogBean a;
  protected String b;
  protected boolean c = false;
  protected ArrayList<GroupCatalogBean> d = new ArrayList();
  protected GroupCatalogBean e;
  
  public GroupCatalogXmlHandler(String paramString)
  {
    this.b = paramString;
  }
  
  public GroupCatalogBean a()
  {
    return this.a;
  }
  
  public ArrayList<GroupCatalogBean> b()
  {
    return this.d;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2) {}
  
  public void endDocument() {}
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = this.e;
    if (paramString1 != null) {
      this.e = paramString1.e;
    }
  }
  
  public void startDocument() {}
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    int k = paramAttributes.getLength();
    int j = 0;
    paramString1 = null;
    paramString3 = paramString1;
    int i = 0;
    while (i < k)
    {
      String str3 = paramAttributes.getLocalName(i);
      String str1 = paramAttributes.getValue(str3);
      String str2;
      if ("id".equals(str3))
      {
        str2 = str1;
      }
      else
      {
        str2 = paramString1;
        if ("value".equals(str3))
        {
          paramString3 = str1;
          str2 = paramString1;
        }
      }
      i += 1;
      paramString1 = str2;
    }
    if (!"0".equals(paramString1))
    {
      if (paramString1 == null) {
        return;
      }
      paramAttributes = this.e;
      if (!paramString2.startsWith("L")) {
        return;
      }
      paramString2 = paramString2.substring(1);
      try
      {
        i = Integer.parseInt(paramString2);
      }
      catch (NumberFormatException paramString2)
      {
        paramString2.printStackTrace();
        i = j;
      }
      if (i == 0) {
        return;
      }
      paramString2 = new GroupCatalogBean(i, paramString1, paramString3);
      this.e = paramString2;
      if (paramString2.a(paramAttributes)) {
        paramAttributes.b(this.e);
      } else {
        this.d.add(this.e);
      }
      if ((!this.c) && (String.valueOf(this.b).equals(paramString1)))
      {
        this.c = true;
        this.a = paramString2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcatalog.GroupCatalogXmlHandler
 * JD-Core Version:    0.7.0.1
 */