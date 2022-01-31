package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

public class XEditText
  extends EditText
{
  public XEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public XEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    if ((localInputConnection != null) && ((getInputType() & 0x20000) == 131072) && (getImeOptions() != 0))
    {
      paramEditorInfo.imeOptions &= 0xBFFFFFFF;
      paramEditorInfo.inputType &= 0xFFFDFFFF;
    }
    return localInputConnection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.XEditText
 * JD-Core Version:    0.7.0.1
 */