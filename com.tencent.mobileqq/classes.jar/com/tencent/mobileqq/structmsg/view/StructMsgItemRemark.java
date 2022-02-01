package com.tencent.mobileqq.structmsg.view;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemRemark
  extends AbsStructMsgTextElement
{
  String aM;
  
  public StructMsgItemRemark()
  {
    this(null);
  }
  
  public StructMsgItemRemark(String paramString)
  {
    super(paramString, "remark");
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.aM = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    String str2 = this.aM;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    super.a(paramXmlSerializer);
    if (!TextUtils.isEmpty(this.aM)) {
      paramXmlSerializer.attribute(null, "url", this.aM);
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.aM = paramStructMsgNode.a("bgColor");
    return super.a(paramStructMsgNode);
  }
  
  public String b()
  {
    return "Remark";
  }
  
  public int d()
  {
    return 1;
  }
  
  public int f()
  {
    return 2131448702;
  }
  
  public int i()
  {
    return Color.rgb(128, 128, 128);
  }
  
  public int j()
  {
    return 24;
  }
  
  public String q()
  {
    return this.aM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemRemark
 * JD-Core Version:    0.7.0.1
 */