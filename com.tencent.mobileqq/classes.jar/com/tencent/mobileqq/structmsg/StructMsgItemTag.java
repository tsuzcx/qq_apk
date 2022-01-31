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
  public int e = 1;
  int f = 10;
  String u;
  String v;
  protected String w;
  protected String x;
  protected String y;
  public String z;
  
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
    this.z = paramString1;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      paramBundle = (URLImageView)paramView.findViewById(2131361924);
      paramContext = (TextView)paramView.findViewById(2131361928);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.u)) {}
      try
      {
        localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setColor(Color.parseColor(this.u));
        if (this.f > 0) {
          ((GradientDrawable)localObject).setCornerRadius(this.f);
        }
        ((GradientDrawable)localObject).setGradientType(0);
        paramView.setBackgroundDrawable((Drawable)localObject);
        if (!TextUtils.isEmpty(this.v))
        {
          localObject = new ColorDrawable(2131492923);
          localObject = URLDrawable.getDrawable(this.v, (Drawable)localObject, (Drawable)localObject);
          if (((URLDrawable)localObject).getStatus() != 1) {
            ((URLDrawable)localObject).restartDownload();
          }
          paramBundle.setImageDrawable((Drawable)localObject);
          paramBundle.setVisibility(0);
          if (TextUtils.isEmpty(this.z)) {
            break label465;
          }
          paramContext.setText(this.z);
        }
      }
      catch (IllegalArgumentException paramBundle)
      {
        try
        {
          paramContext.setTextColor(Color.parseColor(this.w));
        }
        catch (Exception paramBundle)
        {
          try
          {
            for (;;)
            {
              paramContext.setTextSize(Integer.parseInt(this.y));
              paramContext.setVisibility(0);
              return paramView;
              paramView = new LinearLayout(paramContext);
              paramView.setOrientation(0);
              paramView.setMinimumHeight(AIOUtils.a(14.0F, (Resources)localObject));
              paramView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
              paramView.setGravity(16);
              paramView.setPadding(AIOUtils.a(5.0F, (Resources)localObject), AIOUtils.a(2.0F, (Resources)localObject), AIOUtils.a(5.0F, (Resources)localObject), AIOUtils.a(2.0F, (Resources)localObject));
              paramBundle = new URLImageView(paramContext);
              paramBundle.setScaleType(ImageView.ScaleType.CENTER_CROP);
              LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(AIOUtils.a(9.0F, (Resources)localObject), AIOUtils.a(9.0F, (Resources)localObject));
              paramBundle.setId(2131361924);
              paramView.addView(paramBundle, localLayoutParams);
              paramContext = new TextView(paramContext);
              localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
              localLayoutParams.setMargins(AIOUtils.a(2.0F, (Resources)localObject), 0, 0, 0);
              paramContext.setSingleLine(true);
              paramContext.setMaxLines(1);
              paramContext.setEllipsize(TextUtils.TruncateAt.END);
              paramContext.setGravity(16);
              paramContext.setId(2131361928);
              paramView.addView(paramContext, localLayoutParams);
              break;
              localIllegalArgumentException = localIllegalArgumentException;
              if (QLog.isColorLevel())
              {
                QLog.e("Q..troop.faceScore.StructMsgItemTag", 2, "StructMsgItemTag fromXml bgColor is not a color value.", localIllegalArgumentException);
                continue;
                paramBundle.setVisibility(8);
                continue;
                paramBundle = paramBundle;
                paramContext.setTextColor(b());
              }
            }
          }
          catch (Exception paramBundle)
          {
            for (;;)
            {
              paramContext.setTextSize(c());
            }
          }
        }
        label465:
        paramContext.setVisibility(8);
      }
    }
    return paramView;
  }
  
  public String a()
  {
    return "tag";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.w = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.y = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.z = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.u = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.v = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.f = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    String str;
    if (this.w == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.y != null) {
        break label116;
      }
      str = "";
      label32:
      paramObjectOutput.writeUTF(str);
      if (this.z != null) {
        break label124;
      }
      str = "";
      label49:
      paramObjectOutput.writeUTF(str);
      if (this.u != null) {
        break label136;
      }
      str = "";
      label66:
      paramObjectOutput.writeUTF(str);
      if (this.v != null) {
        break label144;
      }
      str = "";
      label83:
      paramObjectOutput.writeUTF(str);
      if (this.f > 0) {
        break label152;
      }
    }
    label136:
    label144:
    label152:
    for (int i = 10;; i = this.f)
    {
      paramObjectOutput.writeInt(i);
      return;
      str = this.w;
      break;
      label116:
      str = this.y;
      break label32;
      label124:
      str = MessageUtils.a(this.z, false);
      break label49;
      str = this.u;
      break label66;
      str = this.v;
      break label83;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.a);
    if (this.z != null)
    {
      if (!TextUtils.isEmpty(this.y)) {
        paramXmlSerializer.attribute(null, "size", this.y);
      }
      if (!TextUtils.isEmpty(this.w)) {
        paramXmlSerializer.attribute(null, "color", this.w);
      }
      if (!TextUtils.isEmpty(this.x)) {
        paramXmlSerializer.attribute(null, "style", this.x);
      }
      paramXmlSerializer.text(this.z);
      if (!TextUtils.isEmpty(this.u)) {
        paramXmlSerializer.attribute(null, "bgColor", this.u);
      }
      if (!TextUtils.isEmpty(this.v)) {
        paramXmlSerializer.attribute(null, "icon", this.v);
      }
      if (this.f > 0) {
        paramXmlSerializer.attribute(null, "radius", this.f + "");
      }
    }
    paramXmlSerializer.endTag(null, this.a);
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {}
    do
    {
      return true;
      this.w = paramStructMsgNode.a("color");
      this.x = paramStructMsgNode.a("style");
      this.y = paramStructMsgNode.a("size");
      this.z = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
      this.u = paramStructMsgNode.a("bgColor");
      this.v = paramStructMsgNode.a("icon");
      paramStructMsgNode = paramStructMsgNode.a("radius");
      try
      {
        this.f = Integer.valueOf(paramStructMsgNode).intValue();
        return true;
      }
      catch (NumberFormatException paramStructMsgNode) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q..troop.faceScore.StructMsgItemTag", 2, "StructMsgItemTag fromXml radius is not a integer value.", paramStructMsgNode);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgItemTag
 * JD-Core Version:    0.7.0.1
 */