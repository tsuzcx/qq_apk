package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemVoice
  extends AbsStructMsgElement
{
  public int au;
  
  public StructMsgItemVoice()
  {
    this.b = "voice";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return null;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.au = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.au);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "voice");
    paramXmlSerializer.attribute(null, "length", String.valueOf(this.au));
    paramXmlSerializer.endTag(null, "voice");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    paramStructMsgNode = paramStructMsgNode.a("length");
    if (!TextUtils.isEmpty(paramStructMsgNode)) {
      this.au = Integer.parseInt(paramStructMsgNode);
    }
    return true;
  }
  
  public String b()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgItemVoice
 * JD-Core Version:    0.7.0.1
 */