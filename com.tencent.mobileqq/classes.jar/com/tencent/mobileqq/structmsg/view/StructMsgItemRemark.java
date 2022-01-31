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
  String E;
  
  public StructMsgItemRemark()
  {
    this(null);
  }
  
  public StructMsgItemRemark(String paramString)
  {
    super(paramString, "remark");
  }
  
  public String a()
  {
    return "Remark";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.E = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.E == null) {}
    for (String str = "";; str = this.E)
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    super.a(paramXmlSerializer);
    if (!TextUtils.isEmpty(this.E)) {
      paramXmlSerializer.attribute(null, "url", this.E);
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.E = paramStructMsgNode.a("bgColor");
    return super.a(paramStructMsgNode);
  }
  
  public int b()
  {
    return 1;
  }
  
  public int c()
  {
    return 2131361933;
  }
  
  public int d()
  {
    return Color.rgb(128, 128, 128);
  }
  
  public int e()
  {
    return 24;
  }
  
  public String g()
  {
    return this.E;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemRemark
 * JD-Core Version:    0.7.0.1
 */