package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemTag
  extends AbsStructMsgElement
{
  protected String aA;
  public String aB;
  public int au = 1;
  String av;
  String aw;
  int ax = 10;
  protected String ay;
  protected String az;
  
  public StructMsgItemTag()
  {
    this(null);
  }
  
  public StructMsgItemTag(String paramString)
  {
    this(paramString, "tag");
  }
  
  public StructMsgItemTag(String paramString1, String paramString2)
  {
    this.b = paramString2;
    this.aB = paramString1;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources = paramContext.getResources();
    Object localObject1;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramContext = (LinearLayout)paramView;
      paramBundle = (URLImageView)paramContext.findViewById(2131435571);
      paramView = (TextView)paramContext.findViewById(2131448793);
    }
    else
    {
      localObject1 = new LinearLayout(paramContext);
      ((LinearLayout)localObject1).setOrientation(0);
      ((LinearLayout)localObject1).setMinimumHeight(AIOUtils.b(14.0F, localResources));
      ((LinearLayout)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
      ((LinearLayout)localObject1).setGravity(16);
      ((LinearLayout)localObject1).setPadding(AIOUtils.b(5.0F, localResources), AIOUtils.b(2.0F, localResources), AIOUtils.b(5.0F, localResources), AIOUtils.b(2.0F, localResources));
      paramBundle = new URLImageView(paramContext);
      paramBundle.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView = new LinearLayout.LayoutParams(AIOUtils.b(9.0F, localResources), AIOUtils.b(9.0F, localResources));
      paramBundle.setId(2131435571);
      ((LinearLayout)localObject1).addView(paramBundle, paramView);
      paramView = new TextView(paramContext);
      paramContext = new LinearLayout.LayoutParams(-2, -1);
      paramContext.setMargins(AIOUtils.b(2.0F, localResources), 0, 0, 0);
      paramView.setSingleLine(true);
      paramView.setMaxLines(1);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setGravity(16);
      paramView.setId(2131448793);
      ((LinearLayout)localObject1).addView(paramView, paramContext);
      paramContext = (Context)localObject1;
    }
    if (!TextUtils.isEmpty(this.av)) {
      try
      {
        localObject1 = new GradientDrawable();
        ((GradientDrawable)localObject1).setColor(Color.parseColor(this.av));
        if (this.ax > 0) {
          ((GradientDrawable)localObject1).setCornerRadius(this.ax);
        }
        ((GradientDrawable)localObject1).setGradientType(0);
        paramContext.setBackgroundDrawable((Drawable)localObject1);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q..troop.faceScore.StructMsgItemTag", 2, "StructMsgItemTag fromXml bgColor is not a color value.", localIllegalArgumentException);
        }
      }
    }
    if (!TextUtils.isEmpty(this.aw))
    {
      Object localObject2 = new ColorDrawable(2131168376);
      localObject2 = URLDrawable.getDrawable(this.aw, (Drawable)localObject2, (Drawable)localObject2);
      if (((URLDrawable)localObject2).getStatus() != 1) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramBundle.setImageDrawable((Drawable)localObject2);
      paramBundle.setVisibility(0);
    }
    else
    {
      paramBundle.setVisibility(8);
    }
    if (!TextUtils.isEmpty(this.aB)) {
      paramView.setText(this.aB);
    }
    try
    {
      paramView.setTextColor(Color.parseColor(this.ay));
    }
    catch (Exception paramBundle)
    {
      label430:
      label453:
      break label430;
    }
    paramView.setTextColor(c());
    try
    {
      paramView.setTextSize(Integer.parseInt(this.aA));
    }
    catch (Exception paramBundle)
    {
      break label453;
    }
    paramView.setTextSize(d());
    paramView.setVisibility(0);
    return paramContext;
    paramView.setVisibility(8);
    return paramContext;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.ay = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.aA = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.aB = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.av = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.aw = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.ax = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    String str2 = this.ay;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    str2 = this.aA;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    str1 = this.aB;
    if (str1 == null) {
      str1 = "";
    } else {
      str1 = MessageUtils.a(str1, false);
    }
    paramObjectOutput.writeUTF(str1);
    str2 = this.av;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    str2 = this.aw;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    int j = this.ax;
    int i = j;
    if (j <= 0) {
      i = 10;
    }
    paramObjectOutput.writeInt(i);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.b);
    if (this.aB != null)
    {
      if (!TextUtils.isEmpty(this.aA)) {
        paramXmlSerializer.attribute(null, "size", this.aA);
      }
      if (!TextUtils.isEmpty(this.ay)) {
        paramXmlSerializer.attribute(null, "color", this.ay);
      }
      if (!TextUtils.isEmpty(this.az)) {
        paramXmlSerializer.attribute(null, "style", this.az);
      }
      paramXmlSerializer.text(this.aB);
      if (!TextUtils.isEmpty(this.av)) {
        paramXmlSerializer.attribute(null, "bgColor", this.av);
      }
      if (!TextUtils.isEmpty(this.aw)) {
        paramXmlSerializer.attribute(null, "icon", this.aw);
      }
      if (this.ax > 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.ax);
        localStringBuilder.append("");
        paramXmlSerializer.attribute(null, "radius", localStringBuilder.toString());
      }
    }
    paramXmlSerializer.endTag(null, this.b);
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.ay = paramStructMsgNode.a("color");
    this.az = paramStructMsgNode.a("style");
    this.aA = paramStructMsgNode.a("size");
    this.aB = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    this.av = paramStructMsgNode.a("bgColor");
    this.aw = paramStructMsgNode.a("icon");
    paramStructMsgNode = paramStructMsgNode.a("radius");
    try
    {
      this.ax = Integer.valueOf(paramStructMsgNode).intValue();
      return true;
    }
    catch (NumberFormatException paramStructMsgNode)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q..troop.faceScore.StructMsgItemTag", 2, "StructMsgItemTag fromXml radius is not a integer value.", paramStructMsgNode);
      }
    }
    return true;
  }
  
  public String b()
  {
    return "tag";
  }
  
  public int c()
  {
    return -1;
  }
  
  public int d()
  {
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgItemTag
 * JD-Core Version:    0.7.0.1
 */