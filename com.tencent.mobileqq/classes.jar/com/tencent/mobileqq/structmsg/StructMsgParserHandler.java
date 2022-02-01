package com.tencent.mobileqq.structmsg;

import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class StructMsgParserHandler
  extends DefaultHandler
  implements StructMsgConstants
{
  Stack<StructMsgNode> a = new Stack();
  StructMsgNode b;
  private boolean c = false;
  private String d;
  private boolean e;
  
  public AbsStructMsg a()
  {
    Object localObject = this.b;
    if (localObject == null) {
      return null;
    }
    if (((StructMsgNode)localObject).a() > 0) {
      localObject = this.b.a(0);
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return null;
    }
    int i = Integer.parseInt(this.b.a("serviceID"));
    if (i == 2) {
      return new StructMsgForAudioShare(this.b);
    }
    if ((i != 3) && (i != 82) && (i != 120))
    {
      if ((i != 5) && (i != 137))
      {
        if (i == 150)
        {
          localObject = new StructMsgSubImageVideo(this.b);
          if (((StructMsgSubImageVideo)localObject).isValid()) {
            return localObject;
          }
        }
        return new StructMsgForGeneralShare(this.b);
      }
      return new StructMsgForImageShare(this.b);
    }
    return new StructMsgForHypertext(this.b, i);
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    super.characters(paramArrayOfChar, paramInt1, paramInt2);
    paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
    if (!this.a.isEmpty())
    {
      StructMsgNode localStructMsgNode = (StructMsgNode)this.a.peek();
      if (localStructMsgNode != null)
      {
        if (localStructMsgNode.a != null) {
          paramArrayOfChar = localStructMsgNode.a.concat(paramArrayOfChar);
        }
        localStructMsgNode.a = paramArrayOfChar;
        localStructMsgNode.a = EmotcationConstants.afterXml(localStructMsgNode.a, this.d, this.e);
      }
    }
  }
  
  public void endDocument()
  {
    super.endDocument();
    this.a.clear();
    this.a = null;
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    super.endElement(paramString1, paramString2, paramString3);
    if (!this.a.isEmpty())
    {
      paramString1 = (StructMsgNode)this.a.pop();
      if (this.a.isEmpty()) {
        this.b = paramString1;
      }
      if (this.c)
      {
        if ((paramString1 != null) && (!"".equals(paramString1.a))) {
          paramString1.f = 3;
        }
        this.c = false;
      }
    }
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    super.startElement(paramString1, paramString2, paramString3, paramAttributes);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramAttributes.getLength())
    {
      localHashMap.put(paramAttributes.getLocalName(i), EmotcationConstants.afterXml(paramAttributes.getValue(i), this.d, this.e));
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      paramAttributes = new StringBuilder();
      paramAttributes.append("StructMsgParserHandler startElement uri = ");
      paramAttributes.append(paramString1);
      paramAttributes.append(", localName = ");
      paramAttributes.append(paramString2);
      paramAttributes.append(", qName = ");
      paramAttributes.append(paramString3);
      paramAttributes.append(", map = ");
      paramAttributes.append(localHashMap);
      QLog.e("StructMsg", 2, paramAttributes.toString());
    }
    paramString1 = new StructMsgNode(paramString2, localHashMap);
    if (!this.a.isEmpty())
    {
      paramString2 = (StructMsgNode)this.a.peek();
      if (paramString2 != null)
      {
        paramString1.e = paramString2;
        paramString2.a(paramString1);
      }
    }
    this.a.push(paramString1);
    this.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgParserHandler
 * JD-Core Version:    0.7.0.1
 */