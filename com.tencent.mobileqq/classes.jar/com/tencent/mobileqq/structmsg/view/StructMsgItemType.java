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
  public int au;
  
  public StructMsgItemType()
  {
    this.b = "type";
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
    paramXmlSerializer.startTag(null, "type");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.au);
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
      this.au = Integer.valueOf(MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false)).intValue();
    }
    catch (Exception paramStructMsgNode)
    {
      if (QLog.isColorLevel()) {
        QLog.e("StructMsgItemType", 2, paramStructMsgNode, new Object[0]);
      }
    }
    return true;
  }
  
  public String b()
  {
    return "type";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemType
 * JD-Core Version:    0.7.0.1
 */