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
  public final ArrayList a;
  public boolean a;
  public int e = AIOUtils.a(2.5F, BaseApplicationImpl.getContext().getResources());
  public int f = this.e;
  private int g;
  
  public StructMsgItemTr()
  {
    this.jdField_a_of_type_JavaLangString = "tr";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    label30:
    Object localObject;
    if (!this.jdField_a_of_type_Boolean)
    {
      int i;
      StructMsgItemTd localStructMsgItemTd;
      View localView;
      int j;
      if ((paramView != null) && ((paramView instanceof ViewGroup)))
      {
        paramView = (ViewGroup)paramView;
        paramView.removeAllViews();
        i = 0;
        localObject = paramView;
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label195;
        }
        localObject = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localObject instanceof StructMsgItemTd))
        {
          localStructMsgItemTd = (StructMsgItemTd)localObject;
          localView = localStructMsgItemTd.a(paramContext, null, paramBundle);
          if ((localView instanceof TextView))
          {
            if (localStructMsgItemTd.h != 0) {
              break label167;
            }
            j = 1;
            label103:
            if (this.g == 1) {
              break label177;
            }
          }
        }
      }
      label167:
      label177:
      for (localObject = new LinearLayout.LayoutParams(0, -1, j);; localObject = new LinearLayout.LayoutParams(-2, -1))
      {
        ((TextView)localView).setGravity(localStructMsgItemTd.f);
        paramView.addView(localView, (ViewGroup.LayoutParams)localObject);
        i += 1;
        break label30;
        paramView = new LinearLayout(paramContext);
        break;
        j = localStructMsgItemTd.h;
        break label103;
      }
    }
    else
    {
      localObject = null;
    }
    label195:
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
    this.g = paramObjectInput.readInt();
    this.e = paramObjectInput.readInt();
    this.f = paramObjectInput.readInt();
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
    paramObjectOutput.writeInt(this.g);
    paramObjectOutput.writeInt(this.e);
    paramObjectOutput.writeInt(this.f);
    paramObjectOutput.writeInt(this.jdField_a_of_type_JavaUtilArrayList.size());
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = "true";; localObject = "false")
    {
      paramObjectOutput.writeUTF((String)localObject);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramObjectOutput);
      }
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "tr");
    paramXmlSerializer.endTag(null, "tr");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    boolean bool2 = false;
    Object localObject1 = paramStructMsgNode.a("mode");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    boolean bool1;
    try
    {
      this.g = Integer.valueOf((String)localObject1).intValue();
      localObject1 = paramStructMsgNode.a("margin");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split(",");
        if ((localObject1 == null) || (localObject1.length < 2)) {}
      }
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        do
        {
          Object localObject2 = BaseApplicationImpl.getContext().getResources();
          this.e = AIOUtils.a(Float.valueOf(localObject1[0]).floatValue(), (Resources)localObject2);
          this.f = AIOUtils.a(Float.valueOf(localObject1[1]).floatValue(), (Resources)localObject2);
          localObject1 = paramStructMsgNode.a("hidden");
          if ((localObject1 != null) && (((String)localObject1).toLowerCase().equals("true"))) {
            this.jdField_a_of_type_Boolean = true;
          }
          int i = 0;
          while (i < paramStructMsgNode.a())
          {
            localObject1 = paramStructMsgNode.a(i);
            if ((localObject1 != null) && ("td".equals(((StructMsgNode)localObject1).b)))
            {
              localObject2 = StructMsgElementFactory.a(((StructMsgNode)localObject1).b);
              bool1 = bool2;
              if (localObject2 == null) {
                return bool1;
              }
              bool1 = bool2;
              if (!((AbsStructMsgElement)localObject2).a((StructMsgNode)localObject1)) {
                return bool1;
              }
              a((AbsStructMsgElement)localObject2);
            }
            i += 1;
          }
          localNumberFormatException1 = localNumberFormatException1;
        } while (!QLog.isColorLevel());
        QLog.w("StructMsgItemTr", 2, "mode must be a numeric ", localNumberFormatException1);
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("StructMsgItemTr", 2, "h must be a numeric ", localNumberFormatException2);
          }
          this.e = 0;
          this.f = 0;
        }
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTr
 * JD-Core Version:    0.7.0.1
 */