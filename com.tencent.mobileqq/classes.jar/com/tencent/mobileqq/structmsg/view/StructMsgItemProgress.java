package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemProgress
  extends AbsStructMsgElement
{
  private int au = 0;
  
  public StructMsgItemProgress()
  {
    this.b = "progress";
  }
  
  public StructMsgItemProgress(int paramInt)
  {
    this.au = paramInt;
    this.b = "progress";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof ProgressBar)))
    {
      paramContext = (ProgressBar)paramView;
    }
    else
    {
      paramView = new ProgressBar(paramContext, null, 16842872);
      paramView.setId(2131446454);
      paramView.setMax(100);
      paramView.setProgressDrawable(paramContext.getResources().getDrawable(2130838011));
      paramContext = paramView;
    }
    paramContext.setTag(this);
    paramContext.setProgress(this.au);
    if (this.au == paramContext.getMax()) {
      paramContext.setVisibility(8);
    }
    return paramContext;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.au = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.au);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "progress");
    paramXmlSerializer.text(String.valueOf(this.au));
    paramXmlSerializer.endTag(null, "progress");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    paramStructMsgNode = StructMsgFactory.a(paramStructMsgNode);
    try
    {
      this.au = Integer.valueOf(paramStructMsgNode).intValue();
    }
    catch (NumberFormatException paramStructMsgNode)
    {
      label19:
      break label19;
    }
    this.au = 0;
    return true;
  }
  
  public String b()
  {
    return "Progress";
  }
  
  public int c()
  {
    return this.au;
  }
  
  public void c(int paramInt)
  {
    this.au = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemProgress
 * JD-Core Version:    0.7.0.1
 */