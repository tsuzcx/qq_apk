package io.flutter.plugin.editing;

import android.text.Editable;
import android.text.Selection;
import android.view.inputmethod.BaseInputConnection;

class InputConnectionAdaptor$TextEditingValue
{
  public int composingEnd;
  public int composingStart;
  public int selectionEnd;
  public int selectionStart;
  public String text;
  
  public InputConnectionAdaptor$TextEditingValue(InputConnectionAdaptor paramInputConnectionAdaptor, Editable paramEditable)
  {
    this.selectionStart = Selection.getSelectionStart(paramEditable);
    this.selectionEnd = Selection.getSelectionEnd(paramEditable);
    this.composingStart = BaseInputConnection.getComposingSpanStart(paramEditable);
    this.composingEnd = BaseInputConnection.getComposingSpanEnd(paramEditable);
    this.text = paramEditable.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof TextEditingValue)) {
        return false;
      }
      paramObject = (TextEditingValue)paramObject;
    } while ((this.selectionStart == paramObject.selectionStart) && (this.selectionEnd == paramObject.selectionEnd) && (this.composingStart == paramObject.composingStart) && (this.composingEnd == paramObject.composingEnd) && (this.text.equals(paramObject.text)));
    return false;
  }
  
  public int hashCode()
  {
    return ((((this.selectionStart + 31) * 31 + this.selectionEnd) * 31 + this.composingStart) * 31 + this.composingEnd) * 31 + this.text.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugin.editing.InputConnectionAdaptor.TextEditingValue
 * JD-Core Version:    0.7.0.1
 */