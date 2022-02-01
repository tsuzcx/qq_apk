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
  String as;
  
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
    this.as = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.as == null) {}
    for (String str = "";; str = this.as)
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    super.a(paramXmlSerializer);
    if (!TextUtils.isEmpty(this.as)) {
      paramXmlSerializer.attribute(null, "url", this.as);
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.as = paramStructMsgNode.a("bgColor");
    return super.a(paramStructMsgNode);
  }
  
  public int b()
  {
    return 1;
  }
  
  public int c()
  {
    return 2131380562;
  }
  
  public int e()
  {
    return Color.rgb(128, 128, 128);
  }
  
  public int f()
  {
    return 24;
  }
  
  public String g()
  {
    return this.as;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemRemark
 * JD-Core Version:    0.7.0.1
 */