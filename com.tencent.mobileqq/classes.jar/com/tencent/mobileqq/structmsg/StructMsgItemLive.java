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
  public View.OnClickListener a;
  public String ac = null;
  public String ad = null;
  public String ae = null;
  public String af = null;
  public String ag = null;
  public String ah = null;
  public int o = 0;
  public int p = 0;
  public int q = 1;
  
  public StructMsgItemLive()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new StructMsgItemLive.2(this);
    this.jdField_a_of_type_JavaLangString = "live";
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
      paramView.setId(2131377987);
      paramBundle.jdField_a_of_type_ComTencentBizNowNowVideoLayout = paramView;
      localLinearLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
      paramView = new LinearLayout(paramContext);
      paramView.setOrientation(1);
      localObject = new LinearLayout.LayoutParams(AIOUtils.b(156.0F, localResources), -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
      paramView.setPadding(AIOUtils.b(7.0F, localResources), AIOUtils.b(8.0F, localResources), AIOUtils.b(7.0F, localResources), AIOUtils.b(8.0F, localResources));
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramView.setBackgroundResource(2130843845);
      localLinearLayout.addView(paramView);
      localObject = new TextView(paramContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      ((TextView)localObject).setBackgroundColor(localResources.getColor(2131167333));
      ((TextView)localObject).setPadding(0, 0, 0, 0);
      ((TextView)localObject).setTextColor(-16777216);
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject).setTextSize(0, AIOUtils.b(12.0F, localResources));
      ((TextView)localObject).setSingleLine();
      localLayoutParams.setMargins(0, 0, 0, 0);
      paramBundle.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
      ((TextView)localObject).setId(2131379926);
      paramView.addView((View)localObject, localLayoutParams);
      paramContext = new TextView(paramContext);
      localObject = new LinearLayout.LayoutParams(-1, -2);
      paramContext.setBackgroundColor(localResources.getColor(2131167333));
      paramContext.setPadding(0, AIOUtils.b(3.0F, localResources), 0, 0);
      paramContext.setTextColor(-16777216);
      paramContext.setEllipsize(TextUtils.TruncateAt.END);
      paramContext.setTextSize(0, AIOUtils.b(12.0F, localResources));
      paramContext.setSingleLine();
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
      paramBundle.b = paramContext;
      paramContext.setId(2131379930);
      paramView.addView(paramContext, (ViewGroup.LayoutParams)localObject);
    }
    if (localLinearLayout != null) {
      localLinearLayout.setTag(paramBundle);
    }
    paramBundle.jdField_a_of_type_ComTencentBizNowNowVideoLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramBundle.jdField_a_of_type_ComTencentBizNowNowVideoLayout.setOnLongClickListener(new StructMsgItemLive.1(this));
    return localLinearLayout;
  }
  
  public String a()
  {
    return "live";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.ad = paramObjectInput.readUTF();
    this.ae = paramObjectInput.readUTF();
    this.af = paramObjectInput.readUTF();
    this.o = paramObjectInput.readInt();
    this.p = paramObjectInput.readInt();
    this.q = paramObjectInput.readInt();
    this.ag = paramObjectInput.readUTF();
    this.ac = paramObjectInput.readUTF();
    this.ah = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    String str = this.ad;
    if (str == null) {
      str = "";
    }
    paramObjectOutput.writeUTF(str);
    str = this.ae;
    if (str == null) {
      str = "";
    }
    paramObjectOutput.writeUTF(str);
    str = this.af;
    if (str == null) {
      str = "";
    }
    paramObjectOutput.writeUTF(str);
    paramObjectOutput.writeInt(this.o);
    paramObjectOutput.writeInt(this.p);
    paramObjectOutput.writeInt(this.q);
    str = this.ag;
    if (str == null) {
      str = "";
    }
    paramObjectOutput.writeUTF(str);
    str = this.ac;
    if (str == null) {
      str = "";
    }
    paramObjectOutput.writeUTF(str);
    str = this.ah;
    if (str == null) {
      str = "";
    }
    paramObjectOutput.writeUTF(str);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "live");
    paramXmlSerializer.attribute(null, "cover", this.ad);
    paramXmlSerializer.attribute(null, "src", this.ae);
    paramXmlSerializer.attribute(null, "video_info", this.af);
    paramXmlSerializer.attribute(null, "preWidth", String.valueOf(this.o));
    paramXmlSerializer.attribute(null, "preHeight", String.valueOf(this.p));
    paramXmlSerializer.attribute(null, "busiType", String.valueOf(this.q));
    paramXmlSerializer.attribute(null, "recordID", String.valueOf(this.ag));
    paramXmlSerializer.attribute(null, "roomID", String.valueOf(this.ac));
    paramXmlSerializer.attribute(null, "title", String.valueOf(this.ah));
    paramXmlSerializer.endTag(null, "live");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.ad = paramStructMsgNode.a("cover");
    this.ae = paramStructMsgNode.a("src");
    this.af = paramStructMsgNode.a("video_info");
    this.ag = paramStructMsgNode.a("recordID");
    this.ac = paramStructMsgNode.a("roomID");
    this.ah = paramStructMsgNode.a("title");
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
      this.o = i;
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
      this.p = i;
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
      this.q = i;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgItemLive
 * JD-Core Version:    0.7.0.1
 */