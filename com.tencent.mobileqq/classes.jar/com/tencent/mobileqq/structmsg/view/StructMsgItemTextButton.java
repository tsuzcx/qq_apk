package com.tencent.mobileqq.structmsg.view;

import ahvp;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemTextButton
  extends AbsStructMsgElement
  implements View.OnClickListener
{
  public int e;
  public int f;
  public String u;
  public String v;
  public String w;
  
  public StructMsgItemTextButton()
  {
    this.a = "textButton";
    b(32);
    c(32);
  }
  
  private LinearLayout a(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(0);
    paramContext.setGravity(16);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    paramContext.setId(2131361931);
    return paramContext;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (paramView != null) {
      paramContext = (ahvp)paramView.getTag();
    }
    for (;;)
    {
      paramContext.jdField_a_of_type_AndroidWidgetTextView.setTag(this);
      paramContext.jdField_a_of_type_AndroidWidgetTextView.setTextColor(c());
      paramContext.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      paramContext.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.DEFAULT, d());
      paramContext.jdField_a_of_type_AndroidWidgetTextView.setTextSize(b() / 2);
      if (!TextUtils.isEmpty(this.u)) {
        paramContext.jdField_a_of_type_AndroidWidgetTextView.setText(this.u);
      }
      if (!TextUtils.isEmpty(this.v))
      {
        paramBundle = URLDrawable.getDrawable(this.v, this.e, this.e, null, null);
        paramBundle.setAutoDownload(true);
        paramContext.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
      }
      if (!TextUtils.isEmpty(this.w))
      {
        paramBundle = URLDrawable.getDrawable(this.w, this.f, this.f, null, null);
        paramBundle.setAutoDownload(true);
        paramContext.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
      }
      if ((this.c != null) && (!this.c.equals("")))
      {
        paramView.setClickable(true);
        paramView.setOnClickListener(this);
      }
      return paramView;
      paramView = new ahvp(this);
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout = a(paramContext);
      paramView.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
      paramView.b = new ImageView(paramContext);
      paramView.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
      paramContext = new LinearLayout.LayoutParams(-2, -2);
      paramContext.gravity = 16;
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView.jdField_a_of_type_AndroidWidgetImageView, paramContext);
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView.jdField_a_of_type_AndroidWidgetTextView, paramContext);
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView.b, paramContext);
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramView);
      paramBundle = paramView.jdField_a_of_type_AndroidWidgetLinearLayout;
      paramContext = paramView;
      paramView = paramBundle;
    }
  }
  
  public String a()
  {
    return "TextButton";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.u = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.v = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.w = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.b = MessageUtils.a(paramObjectInput.readUTF(), false);
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.u == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.v != null) {
        break label86;
      }
      str = "";
      label32:
      paramObjectOutput.writeUTF(str);
      if (this.w != null) {
        break label94;
      }
      str = "";
      label49:
      paramObjectOutput.writeUTF(str);
      if (this.b != null) {
        break label102;
      }
    }
    label86:
    label94:
    label102:
    for (String str = "";; str = this.b)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = MessageUtils.a(this.u, false);
      break;
      str = this.v;
      break label32;
      str = this.w;
      break label49;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.a);
    if (!TextUtils.isEmpty(this.u)) {
      paramXmlSerializer.attribute(null, "text", this.u);
    }
    if (!TextUtils.isEmpty(this.v)) {
      paramXmlSerializer.attribute(null, "leftImage", this.v);
    }
    if (!TextUtils.isEmpty(this.w)) {
      paramXmlSerializer.attribute(null, "rightImage", this.w);
    }
    if (!TextUtils.isEmpty(this.b)) {
      paramXmlSerializer.attribute(null, "url", this.b);
    }
    paramXmlSerializer.endTag(null, this.a);
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.b = paramStructMsgNode.a("url");
    this.v = paramStructMsgNode.a("leftImage");
    this.w = paramStructMsgNode.a("rightImage");
    this.u = MessageUtils.a(paramStructMsgNode.a("text"), false);
    return true;
  }
  
  public int b()
  {
    return 26;
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public int c()
  {
    return -16777216;
  }
  
  public void c(int paramInt)
  {
    this.f = paramInt;
  }
  
  public int d()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTextButton
 * JD-Core Version:    0.7.0.1
 */