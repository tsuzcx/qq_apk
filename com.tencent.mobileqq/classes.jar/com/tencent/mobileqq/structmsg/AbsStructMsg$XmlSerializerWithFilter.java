package com.tencent.mobileqq.structmsg;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.OutputStream;
import java.io.Writer;
import org.xmlpull.v1.XmlSerializer;

public class AbsStructMsg$XmlSerializerWithFilter
  implements XmlSerializer
{
  XmlSerializer a;
  
  public AbsStructMsg$XmlSerializerWithFilter(AbsStructMsg paramAbsStructMsg, XmlSerializer paramXmlSerializer)
  {
    this.a = paramXmlSerializer;
  }
  
  public XmlSerializer attribute(String paramString1, String paramString2, String paramString3)
  {
    return this.a.attribute(paramString1, paramString2, paramString3);
  }
  
  public void cdsect(String paramString)
  {
    this.a.cdsect(paramString);
  }
  
  public void comment(String paramString)
  {
    this.a.comment(paramString);
  }
  
  public void docdecl(String paramString)
  {
    this.a.docdecl(paramString);
  }
  
  public void endDocument()
  {
    this.a.endDocument();
  }
  
  public XmlSerializer endTag(String paramString1, String paramString2)
  {
    return this.a.endTag(paramString1, paramString2);
  }
  
  public void entityRef(String paramString)
  {
    this.a.entityRef(paramString);
  }
  
  public void flush()
  {
    this.a.flush();
  }
  
  public int getDepth()
  {
    return this.a.getDepth();
  }
  
  public boolean getFeature(String paramString)
  {
    return this.a.getFeature(paramString);
  }
  
  public String getName()
  {
    return this.a.getName();
  }
  
  public String getNamespace()
  {
    return this.a.getNamespace();
  }
  
  public String getPrefix(String paramString, boolean paramBoolean)
  {
    return this.a.getPrefix(paramString, paramBoolean);
  }
  
  public Object getProperty(String paramString)
  {
    return this.a.getProperty(paramString);
  }
  
  public void ignorableWhitespace(String paramString)
  {
    this.a.ignorableWhitespace(paramString);
  }
  
  public void processingInstruction(String paramString)
  {
    this.a.processingInstruction(paramString);
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
  {
    this.a.setFeature(paramString, paramBoolean);
  }
  
  public void setOutput(OutputStream paramOutputStream, String paramString)
  {
    this.a.setOutput(paramOutputStream, paramString);
  }
  
  public void setOutput(Writer paramWriter)
  {
    this.a.setOutput(paramWriter);
  }
  
  public void setPrefix(String paramString1, String paramString2)
  {
    this.a.setPrefix(paramString1, paramString2);
  }
  
  public void setProperty(String paramString, Object paramObject)
  {
    this.a.setProperty(paramString, paramObject);
  }
  
  public void startDocument(String paramString, Boolean paramBoolean)
  {
    this.a.startDocument(paramString, paramBoolean);
  }
  
  public XmlSerializer startTag(String paramString1, String paramString2)
  {
    return this.a.startTag(paramString1, paramString2);
  }
  
  public XmlSerializer text(@NonNull String paramString)
  {
    try
    {
      paramString = this.a.text(MessageUtils.a(paramString, false));
      return paramString;
    }
    catch (Exception paramString)
    {
      label17:
      break label17;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("StructMsg", 4, "XmlSerializer . text  IllegalArgumentException。。。。。");
    }
    return this.a.text("");
  }
  
  public XmlSerializer text(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    return this.a.text(paramArrayOfChar, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsg.XmlSerializerWithFilter
 * JD-Core Version:    0.7.0.1
 */