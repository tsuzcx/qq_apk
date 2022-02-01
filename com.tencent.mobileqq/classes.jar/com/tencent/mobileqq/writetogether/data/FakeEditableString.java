package com.tencent.mobileqq.writetogether.data;

import android.text.Editable;
import android.text.InputFilter;
import androidx.annotation.NonNull;

public class FakeEditableString
  implements Editable
{
  private String a;
  
  public Editable append(char paramChar)
  {
    return null;
  }
  
  public Editable append(CharSequence paramCharSequence)
  {
    return null;
  }
  
  public Editable append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public char charAt(int paramInt)
  {
    return '\000';
  }
  
  public void clear() {}
  
  public void clearSpans() {}
  
  public Editable delete(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3) {}
  
  public InputFilter[] getFilters()
  {
    return new InputFilter[0];
  }
  
  public int getSpanEnd(Object paramObject)
  {
    return 0;
  }
  
  public int getSpanFlags(Object paramObject)
  {
    return 0;
  }
  
  public int getSpanStart(Object paramObject)
  {
    return 0;
  }
  
  public <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    return null;
  }
  
  public Editable insert(int paramInt, CharSequence paramCharSequence)
  {
    return null;
  }
  
  public Editable insert(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  public int length()
  {
    return 0;
  }
  
  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    return 0;
  }
  
  public void removeSpan(Object paramObject) {}
  
  public Editable replace(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    return null;
  }
  
  public Editable replace(int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3, int paramInt4)
  {
    return null;
  }
  
  public void setFilters(InputFilter[] paramArrayOfInputFilter) {}
  
  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3) {}
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  @NonNull
  public String toString()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.data.FakeEditableString
 * JD-Core Version:    0.7.0.1
 */