package com.tencent.mobileqq.structmsg.view;

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
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemTextButton
  extends AbsStructMsgElement
  implements View.OnClickListener
{
  public String ac = null;
  public String ad = null;
  public String ae = null;
  public int o = 0;
  public int p = 0;
  
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
    paramContext.setId(2131379921);
    return paramContext;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (paramView != null)
    {
      paramContext = (StructMsgItemTextButton.ViewHolder)paramView.getTag();
    }
    else
    {
      paramView = new StructMsgItemTextButton.ViewHolder(this);
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
    paramContext.jdField_a_of_type_AndroidWidgetTextView.setTag(this);
    paramContext.jdField_a_of_type_AndroidWidgetTextView.setTextColor(c());
    paramContext.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
    paramContext.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.DEFAULT, d());
    paramContext.jdField_a_of_type_AndroidWidgetTextView.setTextSize(b() / 2);
    if (!TextUtils.isEmpty(this.ac)) {
      paramContext.jdField_a_of_type_AndroidWidgetTextView.setText(this.ac);
    }
    try
    {
      if (!TextUtils.isEmpty(this.ad))
      {
        paramBundle = URLDrawable.getDrawable(this.ad, this.o, this.o, null, null);
        paramBundle.setAutoDownload(true);
        paramContext.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
      }
      if (!TextUtils.isEmpty(this.ae))
      {
        paramBundle = URLDrawable.getDrawable(this.ae, this.p, this.p, null, null);
        paramBundle.setAutoDownload(true);
        paramContext.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append(" URLDrawable.exception illegal url : ");
        paramBundle.append(paramContext.getMessage());
        QLog.d("StructMsg", 2, paramBundle.toString());
      }
    }
    if ((this.c != null) && (!this.c.equals("")))
    {
      paramView.setClickable(true);
      paramView.setOnClickListener(this);
    }
    return paramView;
  }
  
  public String a()
  {
    return "TextButton";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.ac = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.ad = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.ae = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.b = MessageUtils.a(paramObjectInput.readUTF(), false);
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    Object localObject = this.ac;
    String str1 = "";
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = MessageUtils.a((String)localObject, false);
    }
    paramObjectOutput.writeUTF((String)localObject);
    String str2 = this.ad;
    localObject = str2;
    if (str2 == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    str2 = this.ae;
    localObject = str2;
    if (str2 == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.b == null) {
      localObject = str1;
    } else {
      localObject = this.b;
    }
    paramObjectOutput.writeUTF((String)localObject);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.a);
    if (!TextUtils.isEmpty(this.ac)) {
      paramXmlSerializer.attribute(null, "text", this.ac);
    }
    if (!TextUtils.isEmpty(this.ad)) {
      paramXmlSerializer.attribute(null, "leftImage", this.ad);
    }
    if (!TextUtils.isEmpty(this.ae)) {
      paramXmlSerializer.attribute(null, "rightImage", this.ae);
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
    this.ad = paramStructMsgNode.a("leftImage");
    this.ae = paramStructMsgNode.a("rightImage");
    this.ac = MessageUtils.a(paramStructMsgNode.a("text"), false);
    return true;
  }
  
  public int b()
  {
    return 26;
  }
  
  public void b(int paramInt)
  {
    this.o = paramInt;
  }
  
  public int c()
  {
    return -16777216;
  }
  
  public void c(int paramInt)
  {
    this.p = paramInt;
  }
  
  public int d()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTextButton
 * JD-Core Version:    0.7.0.1
 */