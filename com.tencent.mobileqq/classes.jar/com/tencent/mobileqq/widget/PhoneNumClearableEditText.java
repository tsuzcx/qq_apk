package com.tencent.mobileqq.widget;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;

public class PhoneNumClearableEditText
  extends ConfigClearableEditText
{
  public PhoneNumClearableEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public PhoneNumClearableEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private String a(Context paramContext)
  {
    Object localObject1 = (ClipboardManager)paramContext.getSystemService("clipboard");
    if (localObject1 == null) {
      return "";
    }
    ClipboardMonitor.getPrimaryClip((ClipboardManager)localObject1);
    localObject1 = ((ClipboardManager)localObject1).getPrimaryClip();
    if (localObject1 == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < ((ClipData)localObject1).getItemCount())
    {
      Object localObject2 = ((ClipData)localObject1).getItemAt(i).coerceToText(paramContext).toString();
      if (localObject2 != null)
      {
        localObject2 = ((String)localObject2).toCharArray();
        int k = localObject2.length;
        int j = 0;
        while (j < k)
        {
          char c = localObject2[j];
          if (Character.isDigit(c)) {
            localStringBuilder.append(c);
          }
          j += 1;
        }
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    if (paramInt == 16908322)
    {
      String str = a(getContext());
      if (str.length() == 0)
      {
        QQToast.a(getContext(), 1, 2131694705, 0).a();
        return true;
      }
      setText(str);
      setSelection(getText().length());
      return true;
    }
    return super.onTextContextMenuItem(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PhoneNumClearableEditText
 * JD-Core Version:    0.7.0.1
 */