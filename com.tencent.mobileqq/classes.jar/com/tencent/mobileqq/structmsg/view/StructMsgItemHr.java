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
  public boolean au = false;
  public int av = 0;
  
  public StructMsgItemHr()
  {
    this.b = "hr";
    this.a = 9;
  }
  
  @TargetApi(11)
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (!this.au)
    {
      paramBundle = paramView;
      if (paramView == null) {
        paramBundle = new View(paramContext);
      }
      int i = this.av;
      if (i == 0)
      {
        paramBundle.setBackgroundColor(-2170912);
        return paramBundle;
      }
      paramContext = paramBundle;
      if (i == 1)
      {
        paramBundle.setBackgroundResource(2130849368);
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
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    if (this.a > 4)
    {
      String str = paramObjectInput.readUTF();
      if ((str != null) && (str.toLowerCase().equals("true"))) {
        this.au = true;
      }
    }
    if (this.a >= 9) {
      this.av = paramObjectInput.readInt();
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    String str;
    if (this.au) {
      str = "true";
    } else {
      str = "false";
    }
    paramObjectOutput.writeUTF(str);
    paramObjectOutput.writeInt(this.av);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "hr");
    if (this.a > 4)
    {
      String str;
      if (this.au) {
        str = "true";
      } else {
        str = "false";
      }
      paramXmlSerializer.attribute(null, "hidden", str);
    }
    if (this.a >= 9) {
      paramXmlSerializer.attribute(null, "style", String.valueOf(this.av));
    }
    paramXmlSerializer.endTag(null, "hr");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    if (this.a > 4)
    {
      String str = paramStructMsgNode.a("hidden");
      if ((str != null) && (str.toLowerCase().equals("true"))) {
        this.au = true;
      }
    }
    if (this.a >= 9)
    {
      paramStructMsgNode = paramStructMsgNode.a("style");
      if (!TextUtils.isEmpty(paramStructMsgNode)) {
        try
        {
          this.av = Integer.parseInt(paramStructMsgNode);
          if (QLog.isColorLevel())
          {
            paramStructMsgNode = new StringBuilder();
            paramStructMsgNode.append("type=");
            paramStructMsgNode.append(this.av);
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
  
  public String b()
  {
    return "Hr";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemHr
 * JD-Core Version:    0.7.0.1
 */