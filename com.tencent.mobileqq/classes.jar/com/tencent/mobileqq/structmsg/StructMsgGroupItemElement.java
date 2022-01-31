package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
  List jdField_a_of_type_JavaUtilList = null;
  boolean jdField_a_of_type_Boolean = false;
  boolean b;
  long c;
  
  public StructMsgGroupItemElement()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = "groupitem";
  }
  
  private void a(Resources paramResources, ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramImageView.setBackgroundResource(2130841752);
      return;
    }
    paramImageView.setBackgroundResource(2130841751);
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources;
    int i;
    label51:
    Object localObject1;
    Object localObject2;
    LinearLayout localLinearLayout;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup).setOrientation(1);
      localResources = paramContext.getResources();
      i = 0;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label659;
      }
      localObject1 = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilList.get(i);
      paramView = ((AbsStructMsgElement)localObject1).jdField_a_of_type_JavaLangString;
      if (!"summary".equals(paramView)) {
        break label334;
      }
      paramView = new LinearLayout(paramContext);
      paramView.setId(2131362370);
      paramView.setOrientation(0);
      localObject2 = new LinearLayout.LayoutParams(-1, AIOUtils.a(46.0F, localResources));
      ((LinearLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(12.0F, localResources);
      ((LinearLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(12.0F, localResources);
      ((LinearLayout.LayoutParams)localObject2).topMargin = 0;
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = 0;
      localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362368);
      if (localLinearLayout != null) {
        break label323;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, (ViewGroup.LayoutParams)localObject2);
      label198:
      localObject1 = ((AbsStructMsgElement)localObject1).a(paramContext, null, paramBundle);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject1 = new ImageView(paramContext);
      ((ImageView)localObject1).setId(2131362369);
      a(localResources, (ImageView)localObject1);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramView.addView((View)localObject1);
    }
    label323:
    label334:
    do
    {
      for (;;)
      {
        i += 1;
        break label51;
        this.jdField_a_of_type_AndroidViewViewGroup = new LinearLayout(paramContext);
        break;
        localLinearLayout.addView(paramView, (ViewGroup.LayoutParams)localObject2);
        break label198;
        if (!"hr".equals(paramView)) {
          break label430;
        }
        paramView = ((AbsStructMsgElement)localObject1).a(paramContext, null, paramBundle);
        localObject1 = new LinearLayout.LayoutParams(-1, 1);
        ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        localObject2 = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362368);
        if (localObject2 == null) {
          this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, (ViewGroup.LayoutParams)localObject1);
        } else {
          ((LinearLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
        }
      }
    } while (!"item".equals(paramView));
    label430:
    paramView = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362368);
    if (paramView == null)
    {
      paramView = new LinearLayout(paramContext);
      paramView.setOrientation(1);
      paramView.setId(2131362368);
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.setVisibility(0);
        label488:
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        paramView.setGravity(16);
        paramView.setBackgroundColor(localResources.getColor(2131493361));
        ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject2).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject2).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = 0;
        this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, (ViewGroup.LayoutParams)localObject2);
      }
    }
    for (;;)
    {
      localObject2 = ((AbsStructMsgElement)localObject1).a(paramContext, null, paramBundle);
      ((View)localObject2).setOnClickListener((View.OnClickListener)localObject1);
      ((View)localObject2).setTag(localObject1);
      ((View)localObject2).setPadding(AIOUtils.a(20.0F, localResources), 0, 0, 0);
      if ((localObject2 instanceof LinearLayout)) {
        ((LinearLayout)localObject2).setGravity(16);
      }
      localObject1 = new LinearLayout.LayoutParams(-1, AIOUtils.a(48.0F, localResources));
      ((LinearLayout.LayoutParams)localObject1).gravity = 16;
      paramView.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      break;
      paramView.setVisibility(8);
      break label488;
      label659:
      return this.jdField_a_of_type_AndroidViewViewGroup;
    }
  }
  
  public String a()
  {
    return "groupitem";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    LinearLayout localLinearLayout;
    do
    {
      return;
      localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362368);
    } while (localLinearLayout == null);
    localLinearLayout.setVisibility(8);
    this.jdField_a_of_type_Boolean = false;
    a(this.jdField_a_of_type_AndroidContentContext.getResources(), (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362369));
  }
  
  void a(AbsStructMsgElement paramAbsStructMsgElement)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramAbsStructMsgElement);
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    int i = 1;
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
    if ((localObject != null) && (((String)localObject).toLowerCase().equals("false"))) {
      this.jdField_b_of_type_Boolean = false;
    }
    this.jdField_c_of_type_Long = paramObjectInput.readLong();
    int m = paramObjectInput.readInt();
    int k = 0;
    if (k < m)
    {
      localObject = paramObjectInput.readUTF();
      if ("item".equals(localObject)) {
        localObject = StructMsgElementFactory.a(paramObjectInput.readInt());
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((AbsStructMsgElement)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
          ((AbsStructMsgElement)localObject).a(paramObjectInput);
          a((AbsStructMsgElement)localObject);
        }
        k += 1;
        break;
        AbsStructMsgElement localAbsStructMsgElement = StructMsgElementFactory.a((String)localObject);
        int j = i;
        if ("button".equals(localObject))
        {
          localAbsStructMsgElement.s = String.valueOf(i);
          localAbsStructMsgElement.t = this.t;
          j = i + 1;
        }
        localObject = localAbsStructMsgElement;
        i = j;
        if (localAbsStructMsgElement != null)
        {
          localObject = localAbsStructMsgElement;
          i = j;
          if (AbsStructMsgItem.class.isInstance(localAbsStructMsgElement))
          {
            paramObjectInput.readInt();
            localObject = localAbsStructMsgElement;
            i = j;
          }
        }
      }
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_c_of_type_JavaLangString != null) {
        break label197;
      }
      localObject = "";
      label34:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.d != null) {
        break label205;
      }
      localObject = "";
      label52:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.e != null) {
        break label213;
      }
      localObject = "";
      label70:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.f != null) {
        break label221;
      }
      localObject = "";
      label88:
      paramObjectOutput.writeUTF((String)localObject);
      if (!this.jdField_a_of_type_Boolean) {
        break label229;
      }
      localObject = "true";
      label105:
      paramObjectOutput.writeUTF((String)localObject);
      if (!this.jdField_b_of_type_Boolean) {
        break label235;
      }
    }
    label197:
    label205:
    label213:
    label221:
    label229:
    label235:
    for (Object localObject = "true";; localObject = "false")
    {
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.jdField_c_of_type_Long);
      paramObjectOutput.writeInt(this.jdField_a_of_type_JavaUtilList.size());
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramObjectOutput);
      }
      localObject = this.jdField_b_of_type_JavaLangString;
      break;
      localObject = this.jdField_c_of_type_JavaLangString;
      break label34;
      localObject = this.d;
      break label52;
      localObject = this.e;
      break label70;
      localObject = this.f;
      break label88;
      localObject = "false";
      break label105;
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
    if (this.jdField_a_of_type_Boolean)
    {
      str = "true";
      paramXmlSerializer.attribute(null, "expand", str);
      if (!this.jdField_b_of_type_Boolean) {
        break label214;
      }
    }
    label214:
    for (String str = "true";; str = "false")
    {
      paramXmlSerializer.attribute(null, "expand", str);
      paramXmlSerializer.attribute(null, "expand", String.valueOf(this.jdField_c_of_type_Long));
      paramXmlSerializer.endTag(null, "groupitem");
      return;
      str = "false";
      break;
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    boolean bool = false;
    if (paramStructMsgNode == null) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      this.jdField_c_of_type_JavaLangString = paramStructMsgNode.a("action");
      this.d = paramStructMsgNode.a("actionData");
      this.e = paramStructMsgNode.a("a_actionData");
      this.f = paramStructMsgNode.a("i_actionData");
      this.jdField_b_of_type_JavaLangString = paramStructMsgNode.a("url");
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
        label152:
        if ((paramStructMsgNode.jdField_a_of_type_JavaUtilList != null) && (paramStructMsgNode.a() > 0))
        {
          Iterator localIterator = paramStructMsgNode.jdField_a_of_type_JavaUtilList.iterator();
          localObject = null;
          if (localIterator.hasNext())
          {
            StructMsgNode localStructMsgNode = (StructMsgNode)localIterator.next();
            if (("summary".equals(localStructMsgNode.jdField_b_of_type_JavaLangString)) || ("hr".equals(localStructMsgNode.jdField_b_of_type_JavaLangString))) {
              paramStructMsgNode = StructMsgElementFactory.a(localStructMsgNode.jdField_b_of_type_JavaLangString);
            }
            do
            {
              localObject = paramStructMsgNode;
              if (paramStructMsgNode == null) {
                break;
              }
              localObject = paramStructMsgNode;
              if (!paramStructMsgNode.a(localStructMsgNode)) {
                break;
              }
              a(paramStructMsgNode);
              localObject = paramStructMsgNode;
              break;
              paramStructMsgNode = (StructMsgNode)localObject;
            } while (!"item".equals(localStructMsgNode.jdField_b_of_type_JavaLangString));
            paramStructMsgNode = localStructMsgNode.a("layout");
            try
            {
              if (!TextUtils.isEmpty(paramStructMsgNode)) {}
              for (int i = Integer.parseInt(paramStructMsgNode);; i = 0)
              {
                paramStructMsgNode = StructMsgElementFactory.a(i);
                break;
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
            }
            catch (NumberFormatException paramStructMsgNode) {}
            QLog.i("StructMsg", 2, "Item layout value is " + 0);
            return false;
          }
        }
        return true;
      }
      catch (Exception localException)
      {
        break label152;
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362368);
    } while (localObject1 == null);
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
      for (;;)
      {
        this.jdField_a_of_type_Boolean = false;
        a(this.jdField_a_of_type_AndroidContentContext.getResources(), (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362369));
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {
          break;
        }
        Object localObject3 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
        if ((localObject3 == null) || (TextUtils.isEmpty(this.d))) {
          break;
        }
        localObject2 = "";
        Matcher localMatcher = Pattern.compile("((?:isNeedReply|isNeedLbs|QidianKfUin|isExt|FromStaff|cqq))=([^\\?&=]+)").matcher(this.d);
        do
        {
          localObject1 = localObject2;
          if (!localMatcher.find()) {
            break;
          }
        } while (!"QidianKfUin".equals(localMatcher.group(1)));
        localObject1 = localMatcher.group(2);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localObject2 = (QidianHandler)((QQAppInterface)localObject3).a(85);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.d).append("&expand=").append(this.jdField_a_of_type_Boolean);
        ((QidianHandler)localObject2).a(((StringBuilder)localObject3).toString(), 1, false, 0.0D, 0.0D, (String)localObject1, 1, "", "", "");
        return;
        ((LinearLayout)localObject1).setVisibility(8);
      }
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localObject2 = new StructMsgGroupItemElement.ExpandAnimation((ViewGroup)localObject1);
      ((StructMsgGroupItemElement.ExpandAnimation)localObject2).setDuration(this.jdField_c_of_type_Long);
      ((StructMsgGroupItemElement.ExpandAnimation)localObject2).setInterpolator(new AccelerateInterpolator());
      ((LinearLayout)localObject1).startAnimation((Animation)localObject2);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      break;
      ((LinearLayout)localObject1).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgGroupItemElement
 * JD-Core Version:    0.7.0.1
 */