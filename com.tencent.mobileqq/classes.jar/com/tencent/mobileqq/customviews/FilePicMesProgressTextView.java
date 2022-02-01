package com.tencent.mobileqq.customviews;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.item.AIOSendMask;

public class FilePicMesProgressTextView
  extends MessageProgressTextView
{
  int a;
  public boolean a;
  int b;
  private boolean d;
  
  public void setDisplayInTextView(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void setProgress(int paramInt)
  {
    if ((this.d) && (this.jdField_a_of_type_Boolean))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("%");
      setText(((StringBuilder)localObject).toString());
    }
    else
    {
      setText("");
    }
    Object localObject = getBackground();
    if (localObject != null)
    {
      ((Drawable)localObject).setLevel((100 - paramInt) * 100);
      if (((localObject instanceof AIOSendMask)) && (!this.jdField_a_of_type_Boolean)) {
        ((AIOSendMask)localObject).a(this.jdField_a_of_type_Int, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.FilePicMesProgressTextView
 * JD-Core Version:    0.7.0.1
 */