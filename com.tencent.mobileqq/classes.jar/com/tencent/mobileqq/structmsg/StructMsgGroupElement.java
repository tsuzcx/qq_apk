package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgGroupElement
  extends AbsStructMsgElement
{
  public List<AbsStructMsgElement> au = null;
  View.OnClickListener av = new StructMsgGroupElement.1(this);
  private SparseArray<View> aw = null;
  private ViewGroup ax = null;
  
  public StructMsgGroupElement()
  {
    this.b = "group";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      this.ax = ((ViewGroup)paramView);
      this.ax.removeAllViews();
    }
    else
    {
      this.ax = new LinearLayout(paramContext);
    }
    this.aw.clear();
    ((LinearLayout)this.ax).setOrientation(1);
    ((LinearLayout)this.ax).setGravity(16);
    int i = 0;
    int k;
    for (int j = 1; i < this.au.size(); j = k)
    {
      paramView = (AbsStructMsgElement)this.au.get(i);
      Object localObject = paramView.b;
      if ("groupitem".equals(localObject))
      {
        localObject = paramView.a(paramContext, null, paramBundle);
        View localView = ((View)localObject).findViewById(2131446460);
        if (localView != null) {
          if ((LinearLayout)((View)localObject).findViewById(2131446461) == null)
          {
            localView.setOnClickListener(paramView);
            localView.setTag(paramView);
          }
          else
          {
            localView.setOnClickListener(this.av);
            localView.setTag(Integer.valueOf(i));
          }
        }
        paramView = new LinearLayout.LayoutParams(-1, -2);
        paramView.leftMargin = 0;
        paramView.rightMargin = 0;
        paramView.topMargin = 0;
        paramView.bottomMargin = 0;
        this.ax.addView((View)localObject, paramView);
        this.aw.append(i, localObject);
        k = j;
      }
      else if ("hr".equals(localObject))
      {
        paramView = paramView.a(paramContext, null, paramBundle);
        localObject = new LinearLayout.LayoutParams(-1, 1);
        ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
        if (j != 0)
        {
          this.ax.addView(paramView, 0, (ViewGroup.LayoutParams)localObject);
          k = 0;
        }
        else
        {
          this.ax.addView(paramView, (ViewGroup.LayoutParams)localObject);
          k = j;
        }
      }
      else if ("title".equals(localObject))
      {
        paramView = paramView.a(paramContext, null, paramBundle);
        localObject = new LinearLayout.LayoutParams(-1, AIOUtils.b(50.0F, paramContext.getResources()));
        ((TextView)paramView).setGravity(16);
        ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(12.0F, paramContext.getResources());
        ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
        this.ax.addView(paramView, (ViewGroup.LayoutParams)localObject);
        k = j;
      }
      else
      {
        k = j;
        if ("item".equals(localObject))
        {
          paramView = paramView.a(paramContext, null, paramBundle);
          localObject = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
          ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
          ((LinearLayout.LayoutParams)localObject).topMargin = 0;
          ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
          this.ax.addView(paramView, (ViewGroup.LayoutParams)localObject);
          k = j;
        }
      }
      i += 1;
    }
    return this.ax;
  }
  
  void a(AbsStructMsgElement paramAbsStructMsgElement)
  {
    this.au.add(paramAbsStructMsgElement);
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    int m = paramObjectInput.readInt();
    int i = 1;
    int k = 0;
    while (k < m)
    {
      String str = paramObjectInput.readUTF();
      Object localObject;
      if ("item".equals(str))
      {
        localObject = StructMsgElementFactory.a(paramObjectInput.readInt());
      }
      else
      {
        AbsStructMsgElement localAbsStructMsgElement = StructMsgElementFactory.a(str);
        int j = i;
        if ("button".equals(str))
        {
          localAbsStructMsgElement.an = String.valueOf(i);
          localAbsStructMsgElement.ap = this.ap;
          j = i + 1;
        }
        i = j;
        localObject = localAbsStructMsgElement;
        if (localAbsStructMsgElement != null)
        {
          i = j;
          localObject = localAbsStructMsgElement;
          if (AbsStructMsgItem.class.isInstance(localAbsStructMsgElement))
          {
            paramObjectInput.readInt();
            localObject = localAbsStructMsgElement;
            i = j;
          }
        }
      }
      if (localObject != null)
      {
        ((AbsStructMsgElement)localObject).as = this.as;
        ((AbsStructMsgElement)localObject).a(paramObjectInput);
        if (("groupitem".equals(str)) || ("hr".equals(str)) || ("title".equals(str)) || ("item".equals(str))) {
          a((AbsStructMsgElement)localObject);
        }
      }
      k += 1;
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.au.size());
    Iterator localIterator = this.au.iterator();
    while (localIterator.hasNext()) {
      ((AbsStructMsgElement)localIterator.next()).a(paramObjectOutput);
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "group");
    paramXmlSerializer.endTag(null, "group");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    int k = paramStructMsgNode.a();
    int i = 0;
    while (i < k)
    {
      StructMsgNode localStructMsgNode = paramStructMsgNode.a(i);
      if (localStructMsgNode != null) {
        if ("item".equals(localStructMsgNode.b)) {
          localObject = localStructMsgNode.a("layout");
        }
      }
      try
      {
        int j;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          j = Integer.parseInt((String)localObject);
        } else {
          j = 0;
        }
        localObject = StructMsgElementFactory.a(j);
      }
      catch (NumberFormatException paramStructMsgNode)
      {
        label86:
        break label86;
      }
      if (QLog.isColorLevel())
      {
        paramStructMsgNode = new StringBuilder();
        paramStructMsgNode.append("Item layout value is ");
        paramStructMsgNode.append(0);
        QLog.i("StructMsgGroupElement", 2, paramStructMsgNode.toString());
      }
      return false;
      Object localObject = StructMsgElementFactory.a(localStructMsgNode.b);
      if (localObject == null) {
        return false;
      }
      if (((AbsStructMsgElement)localObject).a(localStructMsgNode))
      {
        a((AbsStructMsgElement)localObject);
        i += 1;
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public String b()
  {
    return "group";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgGroupElement
 * JD-Core Version:    0.7.0.1
 */