package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemPrice
  extends StructMsgItemSummary
{
  private String E;
  
  public StructMsgItemPrice()
  {
    this.a = "price";
  }
  
  public StructMsgItemPrice(String paramString)
  {
    this();
    this.A = paramString;
  }
  
  public StructMsgItemPrice(String paramString1, String paramString2)
  {
    this(paramString1);
    this.E = paramString2;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramContext = (LinearLayout)paramView;
      ((TextView)paramContext.findViewById(2131361949)).setText(this.A);
      ((TextView)paramContext.findViewById(2131361950)).setText(this.E);
      return paramContext;
    }
    paramView = new LinearLayout(paramContext);
    paramView.setOrientation(0);
    paramBundle = new TextView(paramContext);
    paramBundle.setId(2131361949);
    paramBundle.setText(this.A);
    paramBundle.setTextColor(-65536);
    paramBundle.setTextSize(14.0F);
    paramBundle.setSingleLine();
    paramBundle.setEllipsize(a());
    paramBundle.setGravity(3);
    paramContext = new TextView(paramContext);
    paramContext.setId(2131361950);
    paramContext.setText(this.E);
    paramContext.setSingleLine();
    paramContext.setEllipsize(a());
    paramContext.setTextSize(10.0F);
    paramContext.setTextColor(-65536);
    paramContext.setGravity(80);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(5, 0, 0, 0);
    paramContext.setLayoutParams(localLayoutParams);
    paramView.addView(paramBundle);
    paramView.addView(paramContext);
    paramView.setTag(this);
    return paramView;
  }
  
  public String a()
  {
    return "Price";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.E = MessageUtils.a(paramObjectInput.readUTF(), false);
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
    paramXmlSerializer.startTag(null, "price");
    if (!TextUtils.isEmpty(this.E)) {
      paramXmlSerializer.attribute(null, "unit", this.E);
    }
    paramXmlSerializer.text(this.A);
    paramXmlSerializer.endTag(null, "price");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.E = MessageUtils.a(paramStructMsgNode.a("unit"), false);
    this.A = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemPrice
 * JD-Core Version:    0.7.0.1
 */