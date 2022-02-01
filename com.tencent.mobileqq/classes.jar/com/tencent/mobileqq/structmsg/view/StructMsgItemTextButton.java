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
  public String au = null;
  public String av = null;
  public String aw = null;
  public int ax = 0;
  public int ay = 0;
  
  public StructMsgItemTextButton()
  {
    this.b = "textButton";
    c(32);
    d(32);
  }
  
  private LinearLayout a(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(0);
    paramContext.setGravity(16);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    paramContext.setId(2131448802);
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
      paramView.a = a(paramContext);
      paramView.b = new ImageView(paramContext);
      paramView.c = new ImageView(paramContext);
      paramView.d = new TextView(paramContext);
      paramContext = new LinearLayout.LayoutParams(-2, -2);
      paramContext.gravity = 16;
      paramView.a.addView(paramView.b, paramContext);
      paramView.a.addView(paramView.d, paramContext);
      paramView.a.addView(paramView.c, paramContext);
      paramView.a.setTag(paramView);
      paramBundle = paramView.a;
      paramContext = paramView;
      paramView = paramBundle;
    }
    paramContext.d.setTag(this);
    paramContext.d.setTextColor(d());
    paramContext.d.requestLayout();
    paramContext.d.setTypeface(Typeface.DEFAULT, e());
    paramContext.d.setTextSize(c() / 2);
    if (!TextUtils.isEmpty(this.au)) {
      paramContext.d.setText(this.au);
    }
    try
    {
      if (!TextUtils.isEmpty(this.av))
      {
        paramBundle = URLDrawable.getDrawable(this.av, this.ax, this.ax, null, null);
        paramBundle.setAutoDownload(true);
        paramContext.b.setImageDrawable(paramBundle);
      }
      if (!TextUtils.isEmpty(this.aw))
      {
        paramBundle = URLDrawable.getDrawable(this.aw, this.ay, this.ay, null, null);
        paramBundle.setAutoDownload(true);
        paramContext.b.setImageDrawable(paramBundle);
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
    if ((this.e != null) && (!this.e.equals("")))
    {
      paramView.setClickable(true);
      paramView.setOnClickListener(this);
    }
    return paramView;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.au = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.av = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.aw = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.d = MessageUtils.a(paramObjectInput.readUTF(), false);
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    Object localObject = this.au;
    String str1 = "";
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = MessageUtils.a((String)localObject, false);
    }
    paramObjectOutput.writeUTF((String)localObject);
    String str2 = this.av;
    localObject = str2;
    if (str2 == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    str2 = this.aw;
    localObject = str2;
    if (str2 == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.d == null) {
      localObject = str1;
    } else {
      localObject = this.d;
    }
    paramObjectOutput.writeUTF((String)localObject);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.b);
    if (!TextUtils.isEmpty(this.au)) {
      paramXmlSerializer.attribute(null, "text", this.au);
    }
    if (!TextUtils.isEmpty(this.av)) {
      paramXmlSerializer.attribute(null, "leftImage", this.av);
    }
    if (!TextUtils.isEmpty(this.aw)) {
      paramXmlSerializer.attribute(null, "rightImage", this.aw);
    }
    if (!TextUtils.isEmpty(this.d)) {
      paramXmlSerializer.attribute(null, "url", this.d);
    }
    paramXmlSerializer.endTag(null, this.b);
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.d = paramStructMsgNode.a("url");
    this.av = paramStructMsgNode.a("leftImage");
    this.aw = paramStructMsgNode.a("rightImage");
    this.au = MessageUtils.a(paramStructMsgNode.a("text"), false);
    return true;
  }
  
  public String b()
  {
    return "TextButton";
  }
  
  public int c()
  {
    return 26;
  }
  
  public void c(int paramInt)
  {
    this.ax = paramInt;
  }
  
  public int d()
  {
    return -16777216;
  }
  
  public void d(int paramInt)
  {
    this.ay = paramInt;
  }
  
  public int e()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTextButton
 * JD-Core Version:    0.7.0.1
 */