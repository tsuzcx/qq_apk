package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemType
  extends AbsStructMsgElement
{
  public int o;
  
  public StructMsgItemType()
  {
    this.a = "type";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return null;
  }
  
  public String a()
  {
    return "type";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.o = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.o);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "type");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.o);
    localStringBuilder.append("");
    paramXmlSerializer.text(localStringBuilder.toString());
    paramXmlSerializer.endTag(null, "type");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return false;
    }
    try
    {
      this.o = Integer.valueOf(MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false)).intValue();
    }
    catch (Exception paramStructMsgNode)
    {
      if (QLog.isColorLevel()) {
        QLog.e("StructMsgItemType", 2, paramStructMsgNode, new Object[0]);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemType
 * JD-Core Version:    0.7.0.1
 */