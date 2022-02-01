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
  private String aP;
  
  public StructMsgItemPrice()
  {
    this.b = "price";
  }
  
  public StructMsgItemPrice(String paramString)
  {
    this();
    this.aA = paramString;
  }
  
  public StructMsgItemPrice(String paramString1, String paramString2)
  {
    this(paramString1);
    this.aP = paramString2;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramContext = (LinearLayout)paramView;
      ((TextView)paramContext.findViewById(2131448654)).setText(this.aA);
      ((TextView)paramContext.findViewById(2131448656)).setText(this.aP);
      return paramContext;
    }
    paramView = new LinearLayout(paramContext);
    paramView.setOrientation(0);
    paramBundle = new TextView(paramContext);
    paramBundle.setId(2131448654);
    paramBundle.setText(this.aA);
    paramBundle.setTextColor(-65536);
    paramBundle.setTextSize(14.0F);
    paramBundle.setSingleLine();
    paramBundle.setEllipsize(g());
    paramBundle.setGravity(3);
    paramContext = new TextView(paramContext);
    paramContext.setId(2131448656);
    paramContext.setText(this.aP);
    paramContext.setSingleLine();
    paramContext.setEllipsize(g());
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
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.aP = MessageUtils.a(paramObjectInput.readUTF(), false);
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    String str2 = this.aP;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "price");
    if (!TextUtils.isEmpty(this.aP)) {
      paramXmlSerializer.attribute(null, "unit", this.aP);
    }
    paramXmlSerializer.text(this.aA);
    paramXmlSerializer.endTag(null, "price");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.aP = MessageUtils.a(paramStructMsgNode.a("unit"), false);
    this.aA = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    return true;
  }
  
  public String b()
  {
    return "Price";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemPrice
 * JD-Core Version:    0.7.0.1
 */