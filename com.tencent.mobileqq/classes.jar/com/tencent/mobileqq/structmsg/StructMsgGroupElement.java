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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgGroupElement
  extends AbsStructMsgElement
{
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray = null;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new StructMsgGroupElement.1(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  public List<AbsStructMsgElement> a;
  
  public StructMsgGroupElement()
  {
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_JavaLangString = "group";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
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
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup).setOrientation(1);
    ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup).setGravity(16);
    int i = 0;
    int k;
    for (int j = 1; i < this.jdField_a_of_type_JavaUtilList.size(); j = k)
    {
      paramView = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilList.get(i);
      Object localObject = paramView.jdField_a_of_type_JavaLangString;
      if ("groupitem".equals(localObject))
      {
        localObject = paramView.a(paramContext, null, paramBundle);
        View localView = ((View)localObject).findViewById(2131377973);
        if (localView != null) {
          if ((LinearLayout)((View)localObject).findViewById(2131377974) == null)
          {
            localView.setOnClickListener(paramView);
            localView.setTag(paramView);
          }
          else
          {
            localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            localView.setTag(Integer.valueOf(i));
          }
        }
        paramView = new LinearLayout.LayoutParams(-1, -2);
        paramView.leftMargin = 0;
        paramView.rightMargin = 0;
        paramView.topMargin = 0;
        paramView.bottomMargin = 0;
        this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject, paramView);
        this.jdField_a_of_type_AndroidUtilSparseArray.append(i, localObject);
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
          this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, 0, (ViewGroup.LayoutParams)localObject);
          k = 0;
        }
        else
        {
          this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, (ViewGroup.LayoutParams)localObject);
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
        this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, (ViewGroup.LayoutParams)localObject);
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
          this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, (ViewGroup.LayoutParams)localObject);
          k = j;
        }
      }
      i += 1;
    }
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public String a()
  {
    return "group";
  }
  
  void a(AbsStructMsgElement paramAbsStructMsgElement)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramAbsStructMsgElement);
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
          localAbsStructMsgElement.aa = String.valueOf(i);
          localAbsStructMsgElement.ab = this.ab;
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
        ((AbsStructMsgElement)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
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
    paramObjectOutput.writeInt(this.jdField_a_of_type_JavaUtilList.size());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
        label85:
        break label85;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgGroupElement
 * JD-Core Version:    0.7.0.1
 */