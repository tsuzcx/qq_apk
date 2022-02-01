package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
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
  String au = "";
  
  public StructMsgItemMore()
  {
    this.b = "more";
  }
  
  public StructMsgItemMore(String paramString)
  {
    this();
    this.au = paramString;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    paramBundle = paramView;
    if (paramView == null) {
      paramBundle = LayoutInflater.from(paramContext).inflate(2131629317, null);
    }
    paramContext = (TextView)paramBundle.findViewById(2131446471);
    if (TextUtils.isEmpty(this.au)) {
      this.au = HardCodeUtil.a(2131911925);
    }
    paramContext.setText(this.au);
    return paramBundle;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.au = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    String str = this.au;
    if (str == null) {
      str = "";
    } else {
      str = MessageUtils.a(str, false);
    }
    paramObjectOutput.writeUTF(str);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "title");
    paramXmlSerializer.text(this.au);
    paramXmlSerializer.endTag(null, "title");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    this.au = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    return true;
  }
  
  public String b()
  {
    return "More";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemMore
 * JD-Core Version:    0.7.0.1
 */