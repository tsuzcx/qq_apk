package com.tencent.turingfd.sdk.xq;

import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class return
{
  public Stack<Node> Ff = new Stack();
  public Document Gf;
  public final DocumentBuilder mBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
  
  public void a(String paramString1, String paramString2, String paramString3, public[] paramArrayOfpublic)
  {
    int i;
    label32:
    label40:
    int j;
    if ((paramString1 == null) || ("".equals(paramString1)))
    {
      i = 1;
      if (i == 0) {
        break label108;
      }
      paramString1 = this.Gf.createElement(paramString2);
      int k = paramArrayOfpublic.length;
      i = 0;
      if (i >= k) {
        break label175;
      }
      paramString2 = paramArrayOfpublic[i];
      paramString3 = paramString2.Ef;
      if ((paramString3 != null) && (!"".equals(paramString3))) {
        break label123;
      }
      j = 1;
      label74:
      if (j == 0) {
        break label129;
      }
      paramString1.setAttribute(paramString2.mName, paramString2.mValue);
    }
    for (;;)
    {
      i += 1;
      break label40;
      i = 0;
      break;
      label108:
      paramString1 = this.Gf.createElementNS(paramString1, paramString3);
      break label32;
      label123:
      j = 0;
      break label74;
      label129:
      paramString1.setAttributeNS(paramString2.Ef, paramString2.Df + ':' + paramString2.mName, paramString2.mValue);
    }
    label175:
    ((Node)this.Ff.peek()).appendChild(paramString1);
    this.Ff.push(paramString1);
  }
  
  public void b(String paramString1, String paramString2) {}
  
  public void endDocument() {}
  
  public void startPrefixMapping(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.return
 * JD-Core Version:    0.7.0.1
 */