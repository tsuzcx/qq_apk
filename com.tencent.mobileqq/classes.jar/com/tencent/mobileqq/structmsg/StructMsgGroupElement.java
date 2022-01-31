package com.tencent.mobileqq.structmsg;

import ahue;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgGroupElement
  extends AbsStructMsgElement
{
  public SparseArray a;
  View.OnClickListener a;
  public ViewGroup a;
  public List a;
  
  public StructMsgGroupElement()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahue(this);
    this.jdField_a_of_type_JavaLangString = "group";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    int j;
    int i;
    label62:
    Object localObject;
    View localView;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
      ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup).setOrientation(1);
      ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup).setGravity(16);
      j = 0;
      i = 1;
      if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label459;
      }
      localObject = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilList.get(j);
      paramView = ((AbsStructMsgElement)localObject).jdField_a_of_type_JavaLangString;
      if (!"groupitem".equals(paramView)) {
        break label280;
      }
      paramView = ((AbsStructMsgElement)localObject).a(paramContext, null, paramBundle);
      localView = paramView.findViewById(2131362367);
      if (localView != null)
      {
        if ((LinearLayout)paramView.findViewById(2131362365) != null) {
          break label258;
        }
        localView.setOnClickListener((View.OnClickListener)localObject);
        localView.setTag(localObject);
        localObject = (ImageView)paramView.findViewById(2131362366);
        if (localObject != null) {
          ((ImageView)localObject).setBackgroundResource(2130841686);
        }
      }
      label178:
      localObject = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
      ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
      this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidUtilSparseArray.append(j, paramView);
    }
    for (;;)
    {
      j += 1;
      break label62;
      this.jdField_a_of_type_AndroidViewViewGroup = new LinearLayout(paramContext);
      break;
      label258:
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localView.setTag(Integer.valueOf(j));
      break label178;
      label280:
      if ("hr".equals(paramView))
      {
        paramView = ((AbsStructMsgElement)localObject).a(paramContext, null, paramBundle);
        localObject = new LinearLayout.LayoutParams(-1, 1);
        ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
        if (i != 0)
        {
          this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, 0, (ViewGroup.LayoutParams)localObject);
          i = 0;
        }
        for (;;)
        {
          break;
          this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, (ViewGroup.LayoutParams)localObject);
        }
      }
      if ("title".equals(paramView))
      {
        paramView = ((AbsStructMsgElement)localObject).a(paramContext, null, paramBundle);
        localObject = new LinearLayout.LayoutParams(-1, AIOUtils.a(50.0F, paramContext.getResources()));
        ((TextView)paramView).setGravity(16);
        ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(12.0F, paramContext.getResources());
        ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
        this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, (ViewGroup.LayoutParams)localObject);
      }
    }
    label459:
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
    if (k < m)
    {
      String str = paramObjectInput.readUTF();
      Object localObject;
      if ("item".equals(str)) {
        localObject = StructMsgElementFactory.a(paramObjectInput.readInt());
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((AbsStructMsgElement)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
          ((AbsStructMsgElement)localObject).a(paramObjectInput);
          if (("groupitem".equals(str)) || ("hr".equals(str)) || ("title".equals(str))) {
            a((AbsStructMsgElement)localObject);
          }
        }
        k += 1;
        break;
        AbsStructMsgElement localAbsStructMsgElement = StructMsgElementFactory.a(str);
        int j = i;
        if ("button".equals(str))
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
    if ((paramStructMsgNode.jdField_a_of_type_JavaUtilList != null) && (paramStructMsgNode.a() > 0))
    {
      paramStructMsgNode = paramStructMsgNode.jdField_a_of_type_JavaUtilList.iterator();
      while (paramStructMsgNode.hasNext())
      {
        StructMsgNode localStructMsgNode = (StructMsgNode)paramStructMsgNode.next();
        if (("groupitem".equals(localStructMsgNode.b)) || ("hr".equals(localStructMsgNode.b)) || ("title".equals(localStructMsgNode.b)))
        {
          AbsStructMsgElement localAbsStructMsgElement = StructMsgElementFactory.a(localStructMsgNode.b);
          if ((localAbsStructMsgElement != null) && (localAbsStructMsgElement.a(localStructMsgNode))) {
            a(localAbsStructMsgElement);
          } else {
            return false;
          }
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgGroupElement
 * JD-Core Version:    0.7.0.1
 */