package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemMore
  extends AbsStructMsgElement
{
  String u = "";
  
  public StructMsgItemMore()
  {
    this.a = "more";
  }
  
  public StructMsgItemMore(String paramString)
  {
    this();
    this.u = paramString;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    paramBundle = paramView;
    if (paramView == null) {
      paramBundle = LayoutInflater.from(paramContext).inflate(2130971594, null);
    }
    paramContext = (TextView)paramBundle.findViewById(2131375172);
    if (TextUtils.isEmpty(this.u)) {
      this.u = "阅读全文";
    }
    paramContext.setText(this.u);
    return paramBundle;
  }
  
  public String a()
  {
    return "More";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.u = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.u == null) {}
    for (String str = "";; str = MessageUtils.a(this.u, false))
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "title");
    paramXmlSerializer.text(this.u);
    paramXmlSerializer.endTag(null, "title");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    this.u = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemMore
 * JD-Core Version:    0.7.0.1
 */