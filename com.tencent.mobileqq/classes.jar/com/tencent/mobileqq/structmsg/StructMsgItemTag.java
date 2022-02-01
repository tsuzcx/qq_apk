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
  String ac;
  String ad;
  protected String ae;
  protected String af;
  protected String ag;
  public String ah;
  public int o = 1;
  int p = 10;
  
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
    this.a = paramString2;
    this.ah = paramString1;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources = paramContext.getResources();
    Object localObject1;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramContext = (LinearLayout)paramView;
      paramBundle = (URLImageView)paramContext.findViewById(2131368658);
      paramView = (TextView)paramContext.findViewById(2131379918);
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
      paramBundle.setId(2131368658);
      ((LinearLayout)localObject1).addView(paramBundle, paramView);
      paramView = new TextView(paramContext);
      paramContext = new LinearLayout.LayoutParams(-2, -1);
      paramContext.setMargins(AIOUtils.b(2.0F, localResources), 0, 0, 0);
      paramView.setSingleLine(true);
      paramView.setMaxLines(1);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setGravity(16);
      paramView.setId(2131379918);
      ((LinearLayout)localObject1).addView(paramView, paramContext);
      paramContext = (Context)localObject1;
    }
    if (!TextUtils.isEmpty(this.ac)) {
      try
      {
        localObject1 = new GradientDrawable();
        ((GradientDrawable)localObject1).setColor(Color.parseColor(this.ac));
        if (this.p > 0) {
          ((GradientDrawable)localObject1).setCornerRadius(this.p);
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
    if (!TextUtils.isEmpty(this.ad))
    {
      Object localObject2 = new ColorDrawable(2131167333);
      localObject2 = URLDrawable.getDrawable(this.ad, (Drawable)localObject2, (Drawable)localObject2);
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
    if (!TextUtils.isEmpty(this.ah)) {
      paramView.setText(this.ah);
    }
    try
    {
      paramView.setTextColor(Color.parseColor(this.ae));
    }
    catch (Exception paramBundle)
    {
      label430:
      label453:
      break label430;
    }
    paramView.setTextColor(b());
    try
    {
      paramView.setTextSize(Integer.parseInt(this.ag));
    }
    catch (Exception paramBundle)
    {
      break label453;
    }
    paramView.setTextSize(c());
    paramView.setVisibility(0);
    return paramContext;
    paramView.setVisibility(8);
    return paramContext;
  }
  
  public String a()
  {
    return "tag";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.ae = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.ag = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.ah = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.ac = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.ad = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.p = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    String str2 = this.ae;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    str2 = this.ag;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    str1 = this.ah;
    if (str1 == null) {
      str1 = "";
    } else {
      str1 = MessageUtils.a(str1, false);
    }
    paramObjectOutput.writeUTF(str1);
    str2 = this.ac;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    str2 = this.ad;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    int j = this.p;
    int i = j;
    if (j <= 0) {
      i = 10;
    }
    paramObjectOutput.writeInt(i);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.a);
    if (this.ah != null)
    {
      if (!TextUtils.isEmpty(this.ag)) {
        paramXmlSerializer.attribute(null, "size", this.ag);
      }
      if (!TextUtils.isEmpty(this.ae)) {
        paramXmlSerializer.attribute(null, "color", this.ae);
      }
      if (!TextUtils.isEmpty(this.af)) {
        paramXmlSerializer.attribute(null, "style", this.af);
      }
      paramXmlSerializer.text(this.ah);
      if (!TextUtils.isEmpty(this.ac)) {
        paramXmlSerializer.attribute(null, "bgColor", this.ac);
      }
      if (!TextUtils.isEmpty(this.ad)) {
        paramXmlSerializer.attribute(null, "icon", this.ad);
      }
      if (this.p > 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.p);
        localStringBuilder.append("");
        paramXmlSerializer.attribute(null, "radius", localStringBuilder.toString());
      }
    }
    paramXmlSerializer.endTag(null, this.a);
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.ae = paramStructMsgNode.a("color");
    this.af = paramStructMsgNode.a("style");
    this.ag = paramStructMsgNode.a("size");
    this.ah = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    this.ac = paramStructMsgNode.a("bgColor");
    this.ad = paramStructMsgNode.a("icon");
    paramStructMsgNode = paramStructMsgNode.a("radius");
    try
    {
      this.p = Integer.valueOf(paramStructMsgNode).intValue();
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
  
  public int b()
  {
    return -1;
  }
  
  public int c()
  {
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgItemTag
 * JD-Core Version:    0.7.0.1
 */