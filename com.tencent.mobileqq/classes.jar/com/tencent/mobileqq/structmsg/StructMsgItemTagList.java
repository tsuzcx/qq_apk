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
  public ArrayList<AbsStructMsgElement> au = new ArrayList();
  private String av = "";
  
  public StructMsgItemTagList()
  {
    this.b = "taglist";
  }
  
  private LinearLayout a(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.setOrientation(0);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setId(2131428026);
    if (AppSetting.e) {
      paramContext.setContentDescription(this.av);
    }
    return paramContext;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject = paramContext.getResources();
    int i = 0;
    Bundle localBundle;
    if (paramView != null)
    {
      paramBundle = paramView;
      if ((paramView instanceof LinearLayout))
      {
        localObject = (LinearLayout)paramView;
        localBundle = new Bundle();
        for (;;)
        {
          paramBundle = paramView;
          if (i >= this.au.size()) {
            break;
          }
          ((AbsStructMsgElement)this.au.get(i)).a(paramContext, ((LinearLayout)localObject).getChildAt(i), localBundle);
          i += 1;
        }
      }
    }
    else
    {
      paramView = a(paramContext);
      paramView.setPadding(AIOUtils.b(12.0F, (Resources)localObject), 0, AIOUtils.b(12.0F, (Resources)localObject), 0);
      localBundle = new Bundle();
      i = 0;
      int j = 1;
      for (;;)
      {
        paramBundle = paramView;
        if (i >= this.au.size()) {
          break;
        }
        paramBundle = ((AbsStructMsgElement)this.au.get(i)).a(paramContext, null, localBundle);
        if (j == 0)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          localLayoutParams.setMargins(AIOUtils.b(2.0F, (Resources)localObject), 0, 0, 0);
          paramView.addView(paramBundle, localLayoutParams);
        }
        else
        {
          paramView.addView(paramBundle);
          j = 0;
        }
        i += 1;
      }
    }
    return paramBundle;
  }
  
  public void a(AbsStructMsgElement paramAbsStructMsgElement)
  {
    if ((paramAbsStructMsgElement instanceof StructMsgItemTag)) {
      this.au.add(paramAbsStructMsgElement);
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
        localAbsStructMsgElement.as = this.as;
        localAbsStructMsgElement.a(paramObjectInput);
        a(localAbsStructMsgElement);
      }
      i += 1;
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
    paramXmlSerializer.startTag(null, this.b);
    Iterator localIterator = this.au.iterator();
    while (localIterator.hasNext()) {
      ((AbsStructMsgElement)localIterator.next()).a(paramXmlSerializer);
    }
    paramXmlSerializer.endTag(null, this.b);
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    int j = paramStructMsgNode.a();
    int i = 0;
    while (i < j)
    {
      StructMsgNode localStructMsgNode = paramStructMsgNode.a(i);
      if (localStructMsgNode != null)
      {
        AbsStructMsgElement localAbsStructMsgElement = null;
        if ("tag".equals(localStructMsgNode.b)) {
          localAbsStructMsgElement = StructMsgElementFactory.a(localStructMsgNode.b);
        }
        if (localAbsStructMsgElement == null) {
          return false;
        }
        if (localAbsStructMsgElement.a(localStructMsgNode)) {
          a(localAbsStructMsgElement);
        }
      }
      else
      {
        i += 1;
        continue;
      }
      return false;
    }
    return true;
  }
  
  public String b()
  {
    return "taglist";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgItemTagList
 * JD-Core Version:    0.7.0.1
 */