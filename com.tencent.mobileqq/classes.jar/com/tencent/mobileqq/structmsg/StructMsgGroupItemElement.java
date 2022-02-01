package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgGroupItemElement
  extends AbsStructMsgElement
{
  Context jdField_a_of_type_AndroidContentContext = null;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  List<AbsStructMsgElement> jdField_a_of_type_JavaUtilList = null;
  boolean jdField_a_of_type_Boolean = false;
  boolean b;
  long c;
  int o;
  
  public StructMsgGroupItemElement()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = "groupitem";
  }
  
  private View a(View paramView)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramView.getContext());
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(16);
    Object localObject = new ImageView(paramView.getContext());
    ((ImageView)localObject).setImageResource(2130844493);
    int i = AIOUtils.b(9.0F, paramView.getResources());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(AIOUtils.b(8.0F, paramView.getResources()), i);
    localLayoutParams.leftMargin = AIOUtils.b(24.0F, paramView.getResources());
    localLayoutParams.rightMargin = AIOUtils.b(4.0F, paramView.getResources());
    localLinearLayout.addView((View)localObject, localLayoutParams);
    paramView.setPadding(0, 0, 0, 0);
    localObject = paramView.findViewById(2131379906);
    if (localObject != null) {
      ((View)localObject).setPadding(0, ((View)localObject).getPaddingTop(), 0, ((View)localObject).getPaddingBottom());
    }
    localLinearLayout.addView(paramView);
    return localLinearLayout;
  }
  
  private void a(Resources paramResources, ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    if (this.o == 0)
    {
      paramImageView.setBackgroundDrawable(null);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramImageView.setBackgroundResource(2130843451);
      return;
    }
    paramImageView.setBackgroundResource(2130843450);
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    else
    {
      this.jdField_a_of_type_AndroidViewViewGroup = new LinearLayout(paramContext);
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup).setOrientation(1);
    Resources localResources = paramContext.getResources();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject2 = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilList.get(i);
      paramView = ((AbsStructMsgElement)localObject2).jdField_a_of_type_JavaLangString;
      Object localObject1;
      Object localObject3;
      if ("summary".equals(paramView))
      {
        paramView = new LinearLayout(paramContext);
        paramView.setId(2131377973);
        paramView.setOrientation(0);
        localObject1 = new LinearLayout.LayoutParams(-1, AIOUtils.b(42.0F, localResources));
        ((LinearLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(13.0F, localResources);
        ((LinearLayout.LayoutParams)localObject1).rightMargin = AIOUtils.b(13.0F, localResources);
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        localObject3 = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377974);
        if (localObject3 == null) {
          this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, (ViewGroup.LayoutParams)localObject1);
        } else {
          ((LinearLayout)localObject3).addView(paramView, (ViewGroup.LayoutParams)localObject1);
        }
        localObject1 = ((AbsStructMsgElement)localObject2).a(paramContext, null, paramBundle);
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        localObject1 = new ImageView(paramContext);
        ((ImageView)localObject1).setId(2131377972);
        a(localResources, (ImageView)localObject1);
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramView.addView((View)localObject1);
      }
      else if ("hr".equals(paramView))
      {
        paramView = ((AbsStructMsgElement)localObject2).a(paramContext, null, paramBundle);
        localObject1 = new LinearLayout.LayoutParams(-1, 1);
        ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        localObject2 = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377974);
        if (localObject2 == null) {
          this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, (ViewGroup.LayoutParams)localObject1);
        } else {
          ((LinearLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
        }
      }
      else if ("item".equals(paramView))
      {
        localObject1 = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377974);
        paramView = (View)localObject1;
        if (localObject1 == null)
        {
          paramView = new LinearLayout(paramContext);
          paramView.setOrientation(1);
          paramView.setId(2131377974);
          if (this.jdField_a_of_type_Boolean) {
            paramView.setVisibility(0);
          } else {
            paramView.setVisibility(8);
          }
          localObject1 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject1).gravity = 16;
          paramView.setGravity(16);
          paramView.setBackgroundColor(localResources.getColor(2131167239));
          ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
          ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
          ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
          this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, (ViewGroup.LayoutParams)localObject1);
        }
        localObject3 = ((AbsStructMsgElement)localObject2).a(paramContext, null, paramBundle);
        localObject1 = a((View)localObject3);
        ((View)localObject3).setBackgroundDrawable(null);
        ((View)localObject1).setOnClickListener((View.OnClickListener)localObject2);
        ((View)localObject1).setTag(localObject2);
        localObject2 = new LinearLayout.LayoutParams(-1, AIOUtils.b(48.0F, localResources));
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        this.o += 1;
      }
      i += 1;
    }
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public String a()
  {
    return "groupitem";
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject == null) {
      return;
    }
    localObject = (LinearLayout)((ViewGroup)localObject).findViewById(2131377974);
    if (localObject == null) {
      return;
    }
    ((LinearLayout)localObject).setVisibility(8);
    this.jdField_a_of_type_Boolean = false;
    a(this.jdField_a_of_type_AndroidContentContext.getResources(), (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377972));
  }
  
  void a(AbsStructMsgElement paramAbsStructMsgElement)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramAbsStructMsgElement);
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.jdField_b_of_type_JavaLangString = paramObjectInput.readUTF();
    this.jdField_c_of_type_JavaLangString = paramObjectInput.readUTF();
    this.d = paramObjectInput.readUTF();
    this.e = paramObjectInput.readUTF();
    this.f = paramObjectInput.readUTF();
    Object localObject = paramObjectInput.readUTF();
    if ((localObject != null) && (((String)localObject).toLowerCase().equals("true"))) {
      this.jdField_a_of_type_Boolean = true;
    }
    localObject = paramObjectInput.readUTF();
    int k = 0;
    if ((localObject != null) && (((String)localObject).toLowerCase().equals("false"))) {
      this.jdField_b_of_type_Boolean = false;
    }
    this.jdField_c_of_type_Long = paramObjectInput.readLong();
    int m = paramObjectInput.readInt();
    this.o = 0;
    int i = 1;
    while (k < m)
    {
      String str = paramObjectInput.readUTF();
      if ("item".equals(str))
      {
        localObject = StructMsgElementFactory.a(paramObjectInput.readInt());
        this.o += 1;
      }
      else
      {
        localObject = StructMsgElementFactory.a(str);
        int j = i;
        if ("button".equals(str))
        {
          ((AbsStructMsgElement)localObject).aa = String.valueOf(i);
          ((AbsStructMsgElement)localObject).ab = this.ab;
          j = i + 1;
        }
        if ((localObject != null) && (AbsStructMsgItem.class.isInstance(localObject))) {
          paramObjectInput.readInt();
        }
        i = j;
      }
      if (localObject != null)
      {
        ((AbsStructMsgElement)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
        ((AbsStructMsgElement)localObject).a(paramObjectInput);
        a((AbsStructMsgElement)localObject);
      }
      k += 1;
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    Object localObject = this.jdField_b_of_type_JavaLangString;
    String str = "";
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = this.jdField_b_of_type_JavaLangString;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.jdField_c_of_type_JavaLangString == null) {
      localObject = "";
    } else {
      localObject = this.jdField_c_of_type_JavaLangString;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.d == null) {
      localObject = "";
    } else {
      localObject = this.d;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.e == null) {
      localObject = "";
    } else {
      localObject = this.e;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.f == null) {
      localObject = str;
    } else {
      localObject = this.f;
    }
    paramObjectOutput.writeUTF((String)localObject);
    boolean bool = this.jdField_a_of_type_Boolean;
    str = "true";
    if (bool) {
      localObject = "true";
    } else {
      localObject = "false";
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.jdField_b_of_type_Boolean) {
      localObject = str;
    } else {
      localObject = "false";
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeLong(this.jdField_c_of_type_Long);
    paramObjectOutput.writeInt(this.jdField_a_of_type_JavaUtilList.size());
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramObjectOutput);
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "groupitem");
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "action", this.jdField_c_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.d)) {
      paramXmlSerializer.attribute(null, "actionData", this.d);
    }
    if (!TextUtils.isEmpty(this.e)) {
      paramXmlSerializer.attribute(null, "a_actionData", this.e);
    }
    if (!TextUtils.isEmpty(this.f)) {
      paramXmlSerializer.attribute(null, "i_actionData", this.f);
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "url", this.jdField_b_of_type_JavaLangString);
    }
    boolean bool = this.jdField_a_of_type_Boolean;
    String str2 = "true";
    String str1;
    if (bool) {
      str1 = "true";
    } else {
      str1 = "false";
    }
    paramXmlSerializer.attribute(null, "expand", str1);
    if (this.jdField_b_of_type_Boolean) {
      str1 = str2;
    } else {
      str1 = "false";
    }
    paramXmlSerializer.attribute(null, "expand", str1);
    paramXmlSerializer.attribute(null, "expand", String.valueOf(this.jdField_c_of_type_Long));
    paramXmlSerializer.endTag(null, "groupitem");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.jdField_c_of_type_JavaLangString = paramStructMsgNode.a("action");
    this.d = paramStructMsgNode.a("actionData");
    this.e = paramStructMsgNode.a("a_actionData");
    this.f = paramStructMsgNode.a("i_actionData");
    this.jdField_b_of_type_JavaLangString = paramStructMsgNode.a("url");
    this.o = 0;
    Object localObject = paramStructMsgNode.a("expand");
    if ((localObject != null) && (((String)localObject).toLowerCase().equals("true"))) {
      this.jdField_a_of_type_Boolean = true;
    }
    localObject = paramStructMsgNode.a("animation");
    if ((localObject != null) && (((String)localObject).toLowerCase().equals("false"))) {
      this.jdField_b_of_type_Boolean = false;
    }
    localObject = paramStructMsgNode.a("duration");
    if (localObject != null) {}
    try
    {
      this.jdField_c_of_type_Long = Long.parseLong((String)localObject);
    }
    catch (Exception localException)
    {
      label147:
      Iterator localIterator;
      label284:
      label334:
      break label147;
    }
    if ((paramStructMsgNode.jdField_a_of_type_JavaUtilList != null) && (paramStructMsgNode.a() > 0))
    {
      localObject = null;
      localIterator = paramStructMsgNode.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        StructMsgNode localStructMsgNode = (StructMsgNode)localIterator.next();
        if ((!"summary".equals(localStructMsgNode.jdField_b_of_type_JavaLangString)) && (!"hr".equals(localStructMsgNode.jdField_b_of_type_JavaLangString)))
        {
          paramStructMsgNode = (StructMsgNode)localObject;
          if (!"item".equals(localStructMsgNode.jdField_b_of_type_JavaLangString)) {
            break label334;
          }
          paramStructMsgNode = localStructMsgNode.a("layout");
        }
        try
        {
          int i;
          if (!TextUtils.isEmpty(paramStructMsgNode)) {
            i = Integer.parseInt(paramStructMsgNode);
          } else {
            i = 0;
          }
          paramStructMsgNode = StructMsgElementFactory.a(i);
          this.o += 1;
        }
        catch (NumberFormatException paramStructMsgNode)
        {
          break label284;
        }
        if (QLog.isColorLevel())
        {
          paramStructMsgNode = new StringBuilder();
          paramStructMsgNode.append("Item layout value is ");
          paramStructMsgNode.append(0);
          QLog.i("StructMsg", 2, paramStructMsgNode.toString());
        }
        return false;
        paramStructMsgNode = StructMsgElementFactory.a(localStructMsgNode.jdField_b_of_type_JavaLangString);
        localObject = paramStructMsgNode;
        if (paramStructMsgNode != null)
        {
          localObject = paramStructMsgNode;
          if (paramStructMsgNode.a(localStructMsgNode))
          {
            a(paramStructMsgNode);
            localObject = paramStructMsgNode;
          }
        }
      }
    }
    else
    {
      return true;
    }
  }
  
  public void b()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject1 == null) {
      return;
    }
    localObject1 = (LinearLayout)((ViewGroup)localObject1).findViewById(2131377974);
    if (localObject1 == null) {
      return;
    }
    Object localObject2;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        localObject2 = new StructMsgGroupItemElement.ReduceAnimation((ViewGroup)localObject1);
        ((StructMsgGroupItemElement.ReduceAnimation)localObject2).setDuration(this.jdField_c_of_type_Long);
        ((StructMsgGroupItemElement.ReduceAnimation)localObject2).setInterpolator(new DecelerateInterpolator());
        ((LinearLayout)localObject1).startAnimation((Animation)localObject2);
      }
      else
      {
        ((LinearLayout)localObject1).setVisibility(8);
      }
      this.jdField_a_of_type_Boolean = false;
    }
    else
    {
      if (this.jdField_b_of_type_Boolean)
      {
        localObject2 = new StructMsgGroupItemElement.ExpandAnimation((ViewGroup)localObject1);
        ((StructMsgGroupItemElement.ExpandAnimation)localObject2).setDuration(this.jdField_c_of_type_Long);
        ((StructMsgGroupItemElement.ExpandAnimation)localObject2).setInterpolator(new AccelerateInterpolator());
        ((LinearLayout)localObject1).startAnimation((Animation)localObject2);
      }
      else
      {
        ((LinearLayout)localObject1).setVisibility(0);
      }
      this.jdField_a_of_type_Boolean = true;
    }
    a(this.jdField_a_of_type_AndroidContentContext.getResources(), (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377972));
    localObject1 = this.jdField_a_of_type_AndroidContentContext;
    if ((localObject1 instanceof BaseActivity))
    {
      localObject2 = ((BaseActivity)localObject1).getChatFragment().a();
      if ((localObject2 != null) && (!TextUtils.isEmpty(this.d)))
      {
        localObject1 = Pattern.compile("((?:isNeedReply|isNeedLbs|QidianKfUin|isExt|FromStaff|cqq))=([^\\?&=]+)").matcher(this.d);
        while (((Matcher)localObject1).find()) {
          if ("QidianKfUin".equals(((Matcher)localObject1).group(1)))
          {
            localObject1 = ((Matcher)localObject1).group(2);
            break label250;
          }
        }
        localObject1 = "";
        label250:
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = (QidianHandler)((QQAppInterface)localObject2).getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.d);
          localStringBuilder.append("&expand=");
          localStringBuilder.append(this.jdField_a_of_type_Boolean);
          ((QidianHandler)localObject2).a(localStringBuilder.toString(), 1, false, 0.0D, 0.0D, (String)localObject1, 1, "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgGroupItemElement
 * JD-Core Version:    0.7.0.1
 */