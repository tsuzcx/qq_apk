package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemVote
  extends AbsStructMsgTextElement
{
  public ArrayList<StructMsgItemVote.OptionItem> a;
  public int o = 0;
  public int p = 0;
  public int q = 0;
  
  public StructMsgItemVote()
  {
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_JavaLangString = "checklist";
    c("12");
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    int k = 1;
    if (paramView == null)
    {
      paramView = new LinearLayout(paramContext);
      paramView.setId(2131379570);
      paramView.setOrientation(1);
    }
    else
    {
      paramView = (LinearLayout)paramView;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Drawable localDrawable = paramContext.getResources().getDrawable(2130850840);
      int i = localDrawable.getIntrinsicWidth();
      int m = localDrawable.getIntrinsicHeight();
      int j = 0;
      localDrawable.setBounds(0, 0, i, m);
      if (TextUtils.isEmpty(this.af)) {
        i = f();
      } else {
        i = Integer.parseInt(this.af);
      }
      m = i / 2;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == paramView.getChildCount()) {
        i = k;
      } else {
        i = 0;
      }
      if ((i == 0) && (paramView.getChildCount() > 0)) {
        paramView.removeAllViews();
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 2) {
        paramBundle = this.jdField_a_of_type_JavaUtilArrayList.subList(0, 2);
      } else {
        paramBundle = this.jdField_a_of_type_JavaUtilArrayList;
      }
      while (j < paramBundle.size())
      {
        StructMsgItemVote.OptionItem localOptionItem = (StructMsgItemVote.OptionItem)paramBundle.get(j);
        if (localOptionItem != null)
        {
          TextView localTextView;
          if (i != 0) {
            localTextView = (TextView)paramView.getChildAt(j);
          } else {
            localTextView = new TextView(paramContext);
          }
          localTextView.setSingleLine();
          localTextView.setEllipsize(a());
          localTextView.setGravity(16);
          localTextView.setTextSize(m);
          localTextView.setCompoundDrawables(localDrawable, null, null, null);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" ");
          localStringBuilder.append(localOptionItem.b);
          localTextView.setText(localStringBuilder.toString());
          if (i == 0) {
            paramView.addView(localTextView);
          }
        }
        j += 1;
      }
    }
    paramView.setTag(this);
    return paramView;
  }
  
  public String a()
  {
    return "Vote";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.p = paramObjectInput.readInt();
    this.o = paramObjectInput.readInt();
    this.q = paramObjectInput.readInt();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.q);
    int i = 0;
    while (i < this.q)
    {
      String str1 = paramObjectInput.readUTF();
      String str2 = paramObjectInput.readUTF();
      this.jdField_a_of_type_JavaUtilArrayList.add(new StructMsgItemVote.OptionItem(this, str1, str2));
      i += 1;
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.p);
    paramObjectOutput.writeInt(this.o);
    paramObjectOutput.writeInt(this.q);
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    int i;
    if ((localObject != null) && (((ArrayList)localObject).size() == this.q)) {
      i = 0;
    }
    while (i < this.q)
    {
      StructMsgItemVote.OptionItem localOptionItem = (StructMsgItemVote.OptionItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localOptionItem != null)
      {
        localObject = localOptionItem.jdField_a_of_type_JavaLangString;
        String str = "";
        if (localObject == null) {
          localObject = "";
        } else {
          localObject = localOptionItem.jdField_a_of_type_JavaLangString;
        }
        paramObjectOutput.writeUTF((String)localObject);
        if (localOptionItem.b == null) {
          localObject = str;
        } else {
          localObject = localOptionItem.b;
        }
        paramObjectOutput.writeUTF((String)localObject);
      }
      i += 1;
      continue;
      if (QLog.isColorLevel()) {
        QLog.e("StructMsg", 2, "StructMsgItemVote writeExternal() mOptions is null, or size is error!");
      }
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "checklist");
    paramXmlSerializer.attribute(null, "min", String.valueOf(this.p));
    paramXmlSerializer.attribute(null, "max", String.valueOf(this.o));
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        StructMsgItemVote.OptionItem localOptionItem = (StructMsgItemVote.OptionItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localOptionItem != null)
        {
          paramXmlSerializer.startTag(null, localOptionItem.jdField_a_of_type_JavaLangString);
          if (localOptionItem.b == null) {
            localObject = "";
          } else {
            localObject = localOptionItem.b;
          }
          paramXmlSerializer.attribute(null, "min", (String)localObject);
          paramXmlSerializer.endTag(null, localOptionItem.jdField_a_of_type_JavaLangString);
        }
        i += 1;
      }
    }
    paramXmlSerializer.endTag(null, "checklist");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    String str1 = paramStructMsgNode.a("min");
    String str2 = paramStructMsgNode.a("max");
    try
    {
      this.p = Integer.parseInt(str1);
      this.o = Integer.parseInt(str2);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, localNumberFormatException.getMessage());
      }
    }
    this.q = paramStructMsgNode.a();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.q);
    int i = 0;
    while (i < this.q)
    {
      StructMsgNode localStructMsgNode = paramStructMsgNode.a(i);
      if (localStructMsgNode != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new StructMsgItemVote.OptionItem(this, localStructMsgNode));
      }
      i += 1;
    }
    return true;
  }
  
  protected int c()
  {
    return 2131379977;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVote
 * JD-Core Version:    0.7.0.1
 */