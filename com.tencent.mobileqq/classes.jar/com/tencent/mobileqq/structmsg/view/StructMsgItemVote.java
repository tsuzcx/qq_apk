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
  public ArrayList a;
  public int e;
  public int f;
  public int g;
  
  public StructMsgItemVote()
  {
    this.jdField_a_of_type_JavaLangString = "checklist";
    c("12");
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Drawable localDrawable;
    int i;
    label75:
    int k;
    if (paramView == null)
    {
      paramView = new LinearLayout(paramContext);
      paramView.setId(2131361935);
      paramView.setOrientation(1);
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break label320;
      }
      localDrawable = paramContext.getResources().getDrawable(2130846101);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      if (!TextUtils.isEmpty(this.x)) {
        break label184;
      }
      i = e();
      k = i / 2;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != paramView.getChildCount()) {
        break label196;
      }
      i = 1;
      label98:
      if ((i == 0) && (paramView.getChildCount() > 0)) {
        paramView.removeAllViews();
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 2) {
        break label202;
      }
    }
    int j;
    StructMsgItemVote.OptionItem localOptionItem;
    label184:
    label196:
    label202:
    for (paramBundle = this.jdField_a_of_type_JavaUtilArrayList.subList(0, 2);; paramBundle = this.jdField_a_of_type_JavaUtilArrayList)
    {
      j = 0;
      for (;;)
      {
        if (j >= paramBundle.size()) {
          break label320;
        }
        localOptionItem = (StructMsgItemVote.OptionItem)paramBundle.get(j);
        if (localOptionItem != null) {
          break;
        }
        j += 1;
      }
      paramView = (LinearLayout)paramView;
      break;
      i = Integer.parseInt(this.x);
      break label75;
      i = 0;
      break label98;
    }
    if (i != 0) {}
    for (TextView localTextView = (TextView)paramView.getChildAt(j);; localTextView = new TextView(paramContext))
    {
      localTextView.setSingleLine();
      localTextView.setEllipsize(a());
      localTextView.setGravity(16);
      localTextView.setTextSize(k);
      localTextView.setCompoundDrawables(localDrawable, null, null, null);
      localTextView.setText(" " + localOptionItem.b);
      if (i != 0) {
        break;
      }
      paramView.addView(localTextView);
      break;
    }
    label320:
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
    this.f = paramObjectInput.readInt();
    this.e = paramObjectInput.readInt();
    this.g = paramObjectInput.readInt();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.g);
    int i = 0;
    while (i < this.g)
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
    paramObjectOutput.writeInt(this.f);
    paramObjectOutput.writeInt(this.e);
    paramObjectOutput.writeInt(this.g);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() == this.g))
    {
      int i = 0;
      if (i < this.g)
      {
        StructMsgItemVote.OptionItem localOptionItem = (StructMsgItemVote.OptionItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localOptionItem != null)
        {
          if (localOptionItem.jdField_a_of_type_JavaLangString != null) {
            break label127;
          }
          str = "";
          label95:
          paramObjectOutput.writeUTF(str);
          if (localOptionItem.b != null) {
            break label136;
          }
        }
        label136:
        for (String str = "";; str = localOptionItem.b)
        {
          paramObjectOutput.writeUTF(str);
          i += 1;
          break;
          label127:
          str = localOptionItem.jdField_a_of_type_JavaLangString;
          break label95;
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("StructMsg", 2, "StructMsgItemVote writeExternal() mOptions is null, or size is error!");
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "checklist");
    paramXmlSerializer.attribute(null, "min", String.valueOf(this.f));
    paramXmlSerializer.attribute(null, "max", String.valueOf(this.e));
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        StructMsgItemVote.OptionItem localOptionItem = (StructMsgItemVote.OptionItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localOptionItem != null)
        {
          paramXmlSerializer.startTag(null, localOptionItem.jdField_a_of_type_JavaLangString);
          if (localOptionItem.b != null) {
            break label147;
          }
        }
        label147:
        for (String str = "";; str = localOptionItem.b)
        {
          paramXmlSerializer.attribute(null, "min", str);
          paramXmlSerializer.endTag(null, localOptionItem.jdField_a_of_type_JavaLangString);
          i += 1;
          break;
        }
      }
    }
    paramXmlSerializer.endTag(null, "checklist");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {}
    for (;;)
    {
      return true;
      Object localObject = paramStructMsgNode.a("min");
      String str = paramStructMsgNode.a("max");
      try
      {
        this.f = Integer.parseInt((String)localObject);
        this.e = Integer.parseInt(str);
        this.g = paramStructMsgNode.a();
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.g);
        int i = 0;
        while (i < this.g)
        {
          localObject = paramStructMsgNode.a(i);
          if (localObject != null) {
            this.jdField_a_of_type_JavaUtilArrayList.add(new StructMsgItemVote.OptionItem(this, (StructMsgNode)localObject));
          }
          i += 1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, localNumberFormatException.getMessage());
          }
        }
      }
    }
  }
  
  protected int c()
  {
    return 2131361936;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVote
 * JD-Core Version:    0.7.0.1
 */