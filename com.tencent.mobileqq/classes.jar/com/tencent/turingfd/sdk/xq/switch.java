package com.tencent.turingfd.sdk.xq;

import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class switch
{
  public Stack<Node> Yf = new Stack();
  public Document Zf;
  public final DocumentBuilder mBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
  
  public void a(String paramString1, String paramString2, String paramString3, static[] paramArrayOfstatic)
  {
    if ((paramString1 != null) && (!"".equals(paramString1))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      paramString1 = this.Zf.createElement(paramString2);
    } else {
      paramString1 = this.Zf.createElementNS(paramString1, paramString3);
    }
    int k = paramArrayOfstatic.length;
    int i = 0;
    while (i < k)
    {
      paramString2 = paramArrayOfstatic[i];
      paramString3 = paramString2.Xf;
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
        paramString3 = paramString2.Xf;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2.Wf);
        localStringBuilder.append(':');
        localStringBuilder.append(paramString2.mName);
        paramString1.setAttributeNS(paramString3, localStringBuilder.toString(), paramString2.mValue);
      }
      i += 1;
    }
    ((Node)this.Yf.peek()).appendChild(paramString1);
    this.Yf.push(paramString1);
  }
  
  public void b(String paramString1, String paramString2) {}
  
  public void endDocument() {}
  
  public void startPrefixMapping(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.switch
 * JD-Core Version:    0.7.0.1
 */