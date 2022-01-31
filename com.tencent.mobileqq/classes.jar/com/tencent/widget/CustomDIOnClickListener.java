package com.tencent.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.lang.ref.WeakReference;

public class CustomDIOnClickListener
  implements DialogInterface.OnClickListener
{
  private final WeakReference a;
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DialogInterface.OnClickListener localOnClickListener = (DialogInterface.OnClickListener)this.a.get();
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.widget.CustomDIOnClickListener
 * JD-Core Version:    0.7.0.1
 */