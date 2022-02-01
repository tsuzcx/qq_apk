package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.now.NowVideoLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemLive
  extends AbsStructMsgElement
{
  public int aA = 0;
  public int aB = 1;
  public String aC = null;
  public View.OnClickListener aD = new StructMsgItemLive.2(this);
  public String au = null;
  public String av = null;
  public String aw = null;
  public String ax = null;
  public String ay = null;
  public int az = 0;
  
  public StructMsgItemLive()
  {
    this.b = "live";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources = paramContext.getResources();
    LinearLayout localLinearLayout = null;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = paramView.getTag();
      if ((paramView != null) && ((paramView instanceof StructMsgItemLive.ViewHolder)))
      {
        paramView = (StructMsgItemLive.ViewHolder)paramView;
        break label46;
      }
    }
    paramView = null;
    label46:
    paramBundle = paramView;
    if (paramView == null)
    {
      paramBundle = new StructMsgItemLive.ViewHolder();
      localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setGravity(17);
      paramView = new LinearLayout.LayoutParams(-2, -2);
      paramView.gravity = 1;
      paramView.setMargins(0, AIOUtils.b(10.0F, localResources), 0, AIOUtils.b(20.0F, localResources));
      localLinearLayout.setLayoutParams(paramView);
      paramView = new NowVideoLayout(paramContext);
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      paramView.setId(2131446474);
      paramBundle.a = paramView;
      localLinearLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
      paramView = new LinearLayout(paramContext);
      paramView.setOrientation(1);
      localObject = new LinearLayout.LayoutParams(AIOUtils.b(156.0F, localResources), -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
      paramView.setPadding(AIOUtils.b(7.0F, localResources), AIOUtils.b(8.0F, localResources), AIOUtils.b(7.0F, localResources), AIOUtils.b(8.0F, localResources));
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramView.setBackgroundResource(2130844799);
      localLinearLayout.addView(paramView);
      localObject = new TextView(paramContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      ((TextView)localObject).setBackgroundColor(localResources.getColor(2131168376));
      ((TextView)localObject).setPadding(0, 0, 0, 0);
      ((TextView)localObject).setTextColor(-16777216);
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject).setTextSize(0, AIOUtils.b(12.0F, localResources));
      ((TextView)localObject).setSingleLine();
      localLayoutParams.setMargins(0, 0, 0, 0);
      paramBundle.b = ((TextView)localObject);
      ((TextView)localObject).setId(2131448810);
      paramView.addView((View)localObject, localLayoutParams);
      paramContext = new TextView(paramContext);
      localObject = new LinearLayout.LayoutParams(-1, -2);
      paramContext.setBackgroundColor(localResources.getColor(2131168376));
      paramContext.setPadding(0, AIOUtils.b(3.0F, localResources), 0, 0);
      paramContext.setTextColor(-16777216);
      paramContext.setEllipsize(TextUtils.TruncateAt.END);
      paramContext.setTextSize(0, AIOUtils.b(12.0F, localResources));
      paramContext.setSingleLine();
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
      paramBundle.c = paramContext;
      paramContext.setId(2131448814);
      paramView.addView(paramContext, (ViewGroup.LayoutParams)localObject);
    }
    if (localLinearLayout != null) {
      localLinearLayout.setTag(paramBundle);
    }
    paramBundle.a.setOnClickListener(this.aD);
    paramBundle.a.setOnLongClickListener(new StructMsgItemLive.1(this));
    return localLinearLayout;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.av = paramObjectInput.readUTF();
    this.aw = paramObjectInput.readUTF();
    this.ax = paramObjectInput.readUTF();
    this.az = paramObjectInput.readInt();
    this.aA = paramObjectInput.readInt();
    this.aB = paramObjectInput.readInt();
    this.ay = paramObjectInput.readUTF();
    this.au = paramObjectInput.readUTF();
    this.aC = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    String str = this.av;
    if (str == null) {
      str = "";
    }
    paramObjectOutput.writeUTF(str);
    str = this.aw;
    if (str == null) {
      str = "";
    }
    paramObjectOutput.writeUTF(str);
    str = this.ax;
    if (str == null) {
      str = "";
    }
    paramObjectOutput.writeUTF(str);
    paramObjectOutput.writeInt(this.az);
    paramObjectOutput.writeInt(this.aA);
    paramObjectOutput.writeInt(this.aB);
    str = this.ay;
    if (str == null) {
      str = "";
    }
    paramObjectOutput.writeUTF(str);
    str = this.au;
    if (str == null) {
      str = "";
    }
    paramObjectOutput.writeUTF(str);
    str = this.aC;
    if (str == null) {
      str = "";
    }
    paramObjectOutput.writeUTF(str);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "live");
    paramXmlSerializer.attribute(null, "cover", this.av);
    paramXmlSerializer.attribute(null, "src", this.aw);
    paramXmlSerializer.attribute(null, "video_info", this.ax);
    paramXmlSerializer.attribute(null, "preWidth", String.valueOf(this.az));
    paramXmlSerializer.attribute(null, "preHeight", String.valueOf(this.aA));
    paramXmlSerializer.attribute(null, "busiType", String.valueOf(this.aB));
    paramXmlSerializer.attribute(null, "recordID", String.valueOf(this.ay));
    paramXmlSerializer.attribute(null, "roomID", String.valueOf(this.au));
    paramXmlSerializer.attribute(null, "title", String.valueOf(this.aC));
    paramXmlSerializer.endTag(null, "live");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.av = paramStructMsgNode.a("cover");
    this.aw = paramStructMsgNode.a("src");
    this.ax = paramStructMsgNode.a("video_info");
    this.ay = paramStructMsgNode.a("recordID");
    this.au = paramStructMsgNode.a("roomID");
    this.aC = paramStructMsgNode.a("title");
    int j = 0;
    int i;
    try
    {
      String str1 = paramStructMsgNode.a("preWidth");
      if (str1 == null) {
        i = 0;
      } else {
        i = Integer.valueOf(str1).intValue();
      }
      this.az = i;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.", 2, "try to parse video width in StructMsgItemLive error", localNumberFormatException1);
      }
    }
    try
    {
      String str2 = paramStructMsgNode.a("preHeight");
      if (str2 == null) {
        i = 0;
      } else {
        i = Integer.valueOf(str2).intValue();
      }
      this.aA = i;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.", 2, "try to parse video heiht in StructMsgItemLive error", localNumberFormatException2);
      }
    }
    try
    {
      paramStructMsgNode = paramStructMsgNode.a("busiType");
      if (paramStructMsgNode == null) {
        i = j;
      } else {
        i = Integer.valueOf(paramStructMsgNode).intValue();
      }
      this.aB = i;
      return true;
    }
    catch (NumberFormatException paramStructMsgNode)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.", 2, "try to parse video sourceType in StructMsgItemLive error", paramStructMsgNode);
      }
    }
    return true;
  }
  
  public String b()
  {
    return "live";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgItemLive
 * JD-Core Version:    0.7.0.1
 */