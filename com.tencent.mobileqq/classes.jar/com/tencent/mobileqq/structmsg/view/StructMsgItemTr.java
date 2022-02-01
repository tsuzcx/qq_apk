package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemTr
  extends AbsStructMsgElement
{
  public final ArrayList<AbsStructMsgElement> a;
  public boolean a;
  public int o = AIOUtils.b(2.5F, BaseApplicationImpl.getContext().getResources());
  public int p = this.o;
  private int q = 0;
  
  public StructMsgItemTr()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "tr";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if ((paramView != null) && ((paramView instanceof ViewGroup)))
      {
        paramView = (ViewGroup)paramView;
        paramView.removeAllViews();
      }
      else
      {
        paramView = new LinearLayout(paramContext);
      }
      int i = 0;
      for (;;)
      {
        localObject = paramView;
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break;
        }
        localObject = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localObject instanceof StructMsgItemTd))
        {
          StructMsgItemTd localStructMsgItemTd = (StructMsgItemTd)localObject;
          View localView = localStructMsgItemTd.a(paramContext, null, paramBundle);
          if ((localView instanceof TextView))
          {
            int j;
            if (localStructMsgItemTd.r == 0) {
              j = 1;
            } else {
              j = localStructMsgItemTd.r;
            }
            if (this.q != 1) {
              localObject = new LinearLayout.LayoutParams(0, -1, j);
            } else {
              localObject = new LinearLayout.LayoutParams(-2, -1);
            }
            ((TextView)localView).setGravity(localStructMsgItemTd.p);
            paramView.addView(localView, (ViewGroup.LayoutParams)localObject);
          }
        }
        i += 1;
      }
    }
    Object localObject = null;
    return localObject;
  }
  
  public String a()
  {
    return "tr";
  }
  
  void a(AbsStructMsgElement paramAbsStructMsgElement)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramAbsStructMsgElement);
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.q = paramObjectInput.readInt();
    this.o = paramObjectInput.readInt();
    this.p = paramObjectInput.readInt();
    int j = paramObjectInput.readInt();
    Object localObject = paramObjectInput.readUTF();
    if ((localObject != null) && (((String)localObject).toLowerCase().equals("true"))) {
      this.jdField_a_of_type_Boolean = true;
    }
    int i = 0;
    while (i < j)
    {
      localObject = paramObjectInput.readUTF();
      if ("td".equals(localObject))
      {
        localObject = StructMsgElementFactory.a((String)localObject);
        if (localObject != null)
        {
          ((AbsStructMsgElement)localObject).a(paramObjectInput);
          a((AbsStructMsgElement)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.q);
    paramObjectOutput.writeInt(this.o);
    paramObjectOutput.writeInt(this.p);
    paramObjectOutput.writeInt(this.jdField_a_of_type_JavaUtilArrayList.size());
    if (this.jdField_a_of_type_Boolean) {
      localObject = "true";
    } else {
      localObject = "false";
    }
    paramObjectOutput.writeUTF((String)localObject);
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramObjectOutput);
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "tr");
    paramXmlSerializer.endTag(null, "tr");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    String str = paramStructMsgNode.a("mode");
    if (!TextUtils.isEmpty(str)) {
      try
      {
        this.q = Integer.valueOf(str).intValue();
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("StructMsgItemTr", 2, "mode must be a numeric ", localNumberFormatException1);
        }
      }
    }
    Object localObject1 = paramStructMsgNode.a("margin");
    Object localObject3;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = ((String)localObject1).split(",");
      if ((localObject1 != null) && (localObject1.length >= 2)) {
        try
        {
          localObject3 = BaseApplicationImpl.getContext().getResources();
          this.o = AIOUtils.b(Float.valueOf(localObject1[0]).floatValue(), (Resources)localObject3);
          this.p = AIOUtils.b(Float.valueOf(localObject1[1]).floatValue(), (Resources)localObject3);
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          if (QLog.isColorLevel()) {
            QLog.w("StructMsgItemTr", 2, "h must be a numeric ", localNumberFormatException2);
          }
          this.o = 0;
          this.p = 0;
        }
      }
    }
    Object localObject2 = paramStructMsgNode.a("hidden");
    if ((localObject2 != null) && (((String)localObject2).toLowerCase().equals("true"))) {
      this.jdField_a_of_type_Boolean = true;
    }
    int i = 0;
    while (i < paramStructMsgNode.a())
    {
      localObject2 = paramStructMsgNode.a(i);
      if ((localObject2 != null) && ("td".equals(((StructMsgNode)localObject2).b)))
      {
        localObject3 = StructMsgElementFactory.a(((StructMsgNode)localObject2).b);
        if ((localObject3 != null) && (((AbsStructMsgElement)localObject3).a((StructMsgNode)localObject2))) {
          a((AbsStructMsgElement)localObject3);
        } else {
          return false;
        }
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTr
 * JD-Core Version:    0.7.0.1
 */