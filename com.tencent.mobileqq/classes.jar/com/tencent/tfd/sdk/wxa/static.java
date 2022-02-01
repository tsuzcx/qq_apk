package com.tencent.tfd.sdk.wxa;

import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class static
{
  public final DocumentBuilder mBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
  public Stack<Node> pc = new Stack();
  public Document qc;
  
  public void a(String paramString1, String paramString2, String paramString3, return[] paramArrayOfreturn)
  {
    if ((paramString1 != null) && (!"".equals(paramString1))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      paramString1 = this.qc.createElement(paramString2);
    } else {
      paramString1 = this.qc.createElementNS(paramString1, paramString3);
    }
    int k = paramArrayOfreturn.length;
    int i = 0;
    while (i < k)
    {
      paramString2 = paramArrayOfreturn[i];
      paramString3 = paramString2.oc;
      int j;
      if ((paramString3 != null) && (!"".equals(paramString3))) {
        j = 0;
      } else {
        j = 1;
      }
      if (j != 0)
      {
        paramString1.setAttribute(paramString2.mName, paramString2.mValue);
      }
      else
      {
        paramString3 = paramString2.oc;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2.nc);
        localStringBuilder.append(':');
        localStringBuilder.append(paramString2.mName);
        paramString1.setAttributeNS(paramString3, localStringBuilder.toString(), paramString2.mValue);
      }
      i += 1;
    }
    ((Node)this.pc.peek()).appendChild(paramString1);
    this.pc.push(paramString1);
  }
  
  public void b(String paramString1, String paramString2) {}
  
  public void endDocument() {}
  
  public void startPrefixMapping(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.static
 * JD-Core Version:    0.7.0.1
 */