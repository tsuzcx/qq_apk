package com.tencent.mobileqq.structmsg.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemHr
  extends AbsStructMsgElement
{
  public boolean a;
  public int o = 0;
  
  public StructMsgItemHr()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "hr";
    this.jdField_a_of_type_Int = 9;
  }
  
  @TargetApi(11)
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      paramBundle = paramView;
      if (paramView == null) {
        paramBundle = new View(paramContext);
      }
      int i = this.o;
      if (i == 0)
      {
        paramBundle.setBackgroundColor(-2170912);
        return paramBundle;
      }
      paramContext = paramBundle;
      if (i == 1)
      {
        paramBundle.setBackgroundResource(2130847707);
        paramContext = paramBundle;
        if (Build.VERSION.SDK_INT >= 11)
        {
          paramBundle.setLayerType(1, null);
          return paramBundle;
        }
      }
    }
    else
    {
      paramContext = null;
    }
    return paramContext;
  }
  
  public String a()
  {
    return "Hr";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    if (this.jdField_a_of_type_Int > 4)
    {
      String str = paramObjectInput.readUTF();
      if ((str != null) && (str.toLowerCase().equals("true"))) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    if (this.jdField_a_of_type_Int >= 9) {
      this.o = paramObjectInput.readInt();
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    String str;
    if (this.jdField_a_of_type_Boolean) {
      str = "true";
    } else {
      str = "false";
    }
    paramObjectOutput.writeUTF(str);
    paramObjectOutput.writeInt(this.o);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "hr");
    if (this.jdField_a_of_type_Int > 4)
    {
      String str;
      if (this.jdField_a_of_type_Boolean) {
        str = "true";
      } else {
        str = "false";
      }
      paramXmlSerializer.attribute(null, "hidden", str);
    }
    if (this.jdField_a_of_type_Int >= 9) {
      paramXmlSerializer.attribute(null, "style", String.valueOf(this.o));
    }
    paramXmlSerializer.endTag(null, "hr");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    if (this.jdField_a_of_type_Int > 4)
    {
      String str = paramStructMsgNode.a("hidden");
      if ((str != null) && (str.toLowerCase().equals("true"))) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    if (this.jdField_a_of_type_Int >= 9)
    {
      paramStructMsgNode = paramStructMsgNode.a("style");
      if (!TextUtils.isEmpty(paramStructMsgNode)) {
        try
        {
          this.o = Integer.parseInt(paramStructMsgNode);
          if (QLog.isColorLevel())
          {
            paramStructMsgNode = new StringBuilder();
            paramStructMsgNode.append("type=");
            paramStructMsgNode.append(this.o);
            QLog.i("StructMsg", 2, paramStructMsgNode.toString());
            return true;
          }
        }
        catch (NumberFormatException paramStructMsgNode)
        {
          if (QLog.isColorLevel()) {
            QLog.e("StructMsg", 2, "", paramStructMsgNode);
          }
          return false;
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemHr
 * JD-Core Version:    0.7.0.1
 */