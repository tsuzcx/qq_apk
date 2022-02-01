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
  public int aM = 0;
  public int aN = 0;
  public int aO = 0;
  public ArrayList<StructMsgItemVote.OptionItem> aP = null;
  
  public StructMsgItemVote()
  {
    this.b = "checklist";
    d("12");
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    int k = 1;
    if (paramView == null)
    {
      paramView = new LinearLayout(paramContext);
      paramView.setId(2131448326);
      paramView.setOrientation(1);
    }
    else
    {
      paramView = (LinearLayout)paramView;
    }
    if (this.aP != null)
    {
      Drawable localDrawable = paramContext.getResources().getDrawable(2130852675);
      int i = localDrawable.getIntrinsicWidth();
      int m = localDrawable.getIntrinsicHeight();
      int j = 0;
      localDrawable.setBounds(0, 0, i, m);
      if (TextUtils.isEmpty(this.ax)) {
        i = j();
      } else {
        i = Integer.parseInt(this.ax);
      }
      m = i / 2;
      if (this.aP.size() == paramView.getChildCount()) {
        i = k;
      } else {
        i = 0;
      }
      if ((i == 0) && (paramView.getChildCount() > 0)) {
        paramView.removeAllViews();
      }
      if (this.aP.size() > 2) {
        paramBundle = this.aP.subList(0, 2);
      } else {
        paramBundle = this.aP;
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
          localTextView.setEllipsize(g());
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
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.aN = paramObjectInput.readInt();
    this.aM = paramObjectInput.readInt();
    this.aO = paramObjectInput.readInt();
    this.aP = new ArrayList(this.aO);
    int i = 0;
    while (i < this.aO)
    {
      String str1 = paramObjectInput.readUTF();
      String str2 = paramObjectInput.readUTF();
      this.aP.add(new StructMsgItemVote.OptionItem(this, str1, str2));
      i += 1;
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.aN);
    paramObjectOutput.writeInt(this.aM);
    paramObjectOutput.writeInt(this.aO);
    Object localObject = this.aP;
    int i;
    if ((localObject != null) && (((ArrayList)localObject).size() == this.aO)) {
      i = 0;
    }
    while (i < this.aO)
    {
      StructMsgItemVote.OptionItem localOptionItem = (StructMsgItemVote.OptionItem)this.aP.get(i);
      if (localOptionItem != null)
      {
        localObject = localOptionItem.a;
        String str = "";
        if (localObject == null) {
          localObject = "";
        } else {
          localObject = localOptionItem.a;
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
    paramXmlSerializer.attribute(null, "min", String.valueOf(this.aN));
    paramXmlSerializer.attribute(null, "max", String.valueOf(this.aM));
    Object localObject = this.aP;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      int i = 0;
      while (i < this.aP.size())
      {
        StructMsgItemVote.OptionItem localOptionItem = (StructMsgItemVote.OptionItem)this.aP.get(i);
        if (localOptionItem != null)
        {
          paramXmlSerializer.startTag(null, localOptionItem.a);
          if (localOptionItem.b == null) {
            localObject = "";
          } else {
            localObject = localOptionItem.b;
          }
          paramXmlSerializer.attribute(null, "min", (String)localObject);
          paramXmlSerializer.endTag(null, localOptionItem.a);
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
      this.aN = Integer.parseInt(str1);
      this.aM = Integer.parseInt(str2);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, localNumberFormatException.getMessage());
      }
    }
    this.aO = paramStructMsgNode.a();
    this.aP = new ArrayList(this.aO);
    int i = 0;
    while (i < this.aO)
    {
      StructMsgNode localStructMsgNode = paramStructMsgNode.a(i);
      if (localStructMsgNode != null) {
        this.aP.add(new StructMsgItemVote.OptionItem(this, localStructMsgNode));
      }
      i += 1;
    }
    return true;
  }
  
  public String b()
  {
    return "Vote";
  }
  
  protected int f()
  {
    return 2131448876;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVote
 * JD-Core Version:    0.7.0.1
 */