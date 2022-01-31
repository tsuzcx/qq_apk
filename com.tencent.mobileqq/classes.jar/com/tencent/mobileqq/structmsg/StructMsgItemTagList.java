package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemTagList
  extends AbsStructMsgElement
{
  public ArrayList a;
  private String u = "";
  
  public StructMsgItemTagList()
  {
    this.jdField_a_of_type_JavaLangString = "taglist";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private LinearLayout a(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.setOrientation(0);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setId(2131361994);
    if (AppSetting.b) {
      paramContext.setContentDescription(this.u);
    }
    return paramContext;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject = paramContext.getResources();
    int i;
    if (paramView != null)
    {
      paramBundle = paramView;
      if ((paramView instanceof LinearLayout))
      {
        localObject = (LinearLayout)paramView;
        i = 0;
        for (;;)
        {
          paramBundle = paramView;
          if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break;
          }
          ((AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramContext, ((LinearLayout)localObject).getChildAt(i), null);
          i += 1;
        }
      }
    }
    else
    {
      paramView = a(paramContext);
      paramView.setPadding(AIOUtils.a(12.0F, (Resources)localObject), 0, AIOUtils.a(12.0F, (Resources)localObject), 0);
      i = 0;
      int j = 1;
      paramBundle = paramView;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramBundle = ((AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramContext, null, null);
        if (j == 0)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          localLayoutParams.setMargins(AIOUtils.a(2.0F, (Resources)localObject), 0, 0, 0);
          paramView.addView(paramBundle, localLayoutParams);
        }
        for (;;)
        {
          i += 1;
          break;
          paramView.addView(paramBundle);
          j = 0;
        }
      }
    }
    return paramBundle;
  }
  
  public String a()
  {
    return "taglist";
  }
  
  public void a(AbsStructMsgElement paramAbsStructMsgElement)
  {
    if ((paramAbsStructMsgElement instanceof StructMsgItemTag)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramAbsStructMsgElement);
    }
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    int j = paramObjectInput.readInt();
    int i = 0;
    while (i < j)
    {
      AbsStructMsgElement localAbsStructMsgElement = StructMsgElementFactory.a(paramObjectInput.readUTF());
      if (localAbsStructMsgElement != null)
      {
        localAbsStructMsgElement.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
        localAbsStructMsgElement.a(paramObjectInput);
        a(localAbsStructMsgElement);
      }
      i += 1;
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.jdField_a_of_type_JavaUtilArrayList.size());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsStructMsgElement)localIterator.next()).a(paramObjectOutput);
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.jdField_a_of_type_JavaLangString);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsStructMsgElement)localIterator.next()).a(paramXmlSerializer);
    }
    paramXmlSerializer.endTag(null, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    int j = paramStructMsgNode.a();
    int i = 0;
    label13:
    StructMsgNode localStructMsgNode;
    if (i < j)
    {
      localStructMsgNode = paramStructMsgNode.a(i);
      if (localStructMsgNode != null) {
        break label37;
      }
    }
    for (;;)
    {
      i += 1;
      break label13;
      break;
      label37:
      AbsStructMsgElement localAbsStructMsgElement = null;
      if ("tag".equals(localStructMsgNode.b)) {
        localAbsStructMsgElement = StructMsgElementFactory.a(localStructMsgNode.b);
      }
      if (localAbsStructMsgElement == null) {
        return false;
      }
      if (!localAbsStructMsgElement.a(localStructMsgNode)) {
        break label89;
      }
      a(localAbsStructMsgElement);
    }
    label89:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgItemTagList
 * JD-Core Version:    0.7.0.1
 */