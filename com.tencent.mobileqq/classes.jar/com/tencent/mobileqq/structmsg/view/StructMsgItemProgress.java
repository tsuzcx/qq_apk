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
  private int o = 0;
  
  public StructMsgItemProgress()
  {
    this.a = "progress";
  }
  
  public StructMsgItemProgress(int paramInt)
  {
    this.o = paramInt;
    this.a = "progress";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof ProgressBar))) {}
    for (paramContext = (ProgressBar)paramView;; paramContext = paramView)
    {
      paramContext.setTag(this);
      paramContext.setProgress(this.o);
      if (this.o == paramContext.getMax()) {
        paramContext.setVisibility(8);
      }
      return paramContext;
      paramView = new ProgressBar(paramContext, null, 16842872);
      paramView.setId(2131378556);
      paramView.setMax(100);
      paramView.setProgressDrawable(paramContext.getResources().getDrawable(2130838138));
    }
  }
  
  public String a()
  {
    return "Progress";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.o = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.o);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "progress");
    paramXmlSerializer.text(String.valueOf(this.o));
    paramXmlSerializer.endTag(null, "progress");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    paramStructMsgNode = StructMsgFactory.a(paramStructMsgNode);
    try
    {
      this.o = Integer.valueOf(paramStructMsgNode).intValue();
      return true;
    }
    catch (NumberFormatException paramStructMsgNode)
    {
      for (;;)
      {
        this.o = 0;
      }
    }
  }
  
  public int b()
  {
    return this.o;
  }
  
  public void b(int paramInt)
  {
    this.o = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemProgress
 * JD-Core Version:    0.7.0.1
 */