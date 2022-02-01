package com.tencent.mobileqq.writetogether.data;

import android.text.Editable;
import android.text.TextWatcher;

public class InsertDeleteWatcher
  implements TextWatcher
{
  private InsertDeleteWatcher.OnTextInsertDelete a;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  private String e = "";
  private String f = "";
  private int g = 0;
  private int h = 0;
  private int i = 0;
  
  private void a()
  {
    this.b = false;
    this.c = false;
    this.d = false;
    this.e = "";
    this.f = "";
    this.g = 0;
    this.h = 0;
    this.i = 0;
  }
  
  public void a(InsertDeleteWatcher.OnTextInsertDelete paramOnTextInsertDelete)
  {
    this.a = paramOnTextInsertDelete;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.a == null) {
      return;
    }
    if ((!this.b) && (!this.c)) {
      this.d = true;
    }
    paramEditable = paramEditable.toString();
    String str1;
    int j;
    if (this.b)
    {
      str1 = this.f;
      j = this.g;
      str1 = str1.substring(j, this.h + j);
      this.a.a(this.g, this.h, str1, this.e, paramEditable);
    }
    else if (this.c)
    {
      str1 = this.e;
      j = this.g;
      str1 = str1.substring(j, this.i + j);
      this.a.b(this.g, this.i, str1, this.e, paramEditable);
    }
    else if (this.d)
    {
      str1 = this.e;
      j = this.g;
      str1 = str1.substring(j, this.i + j);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.e.substring(0, this.g));
      ((StringBuilder)localObject).append(this.e.substring(this.g + this.i));
      localObject = ((StringBuilder)localObject).toString();
      String str2 = this.f;
      j = this.g;
      str2 = str2.substring(j, this.h + j);
      this.a.b(this.g, this.i, str1, this.e, (String)localObject);
      this.a.a(this.g, this.h, str2, this.e, paramEditable);
    }
    a();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.e = paramCharSequence.toString();
    this.g = paramInt1;
    this.h = paramInt3;
    if (paramInt2 == 0) {
      this.b = true;
    }
    if (paramInt3 == 0) {
      this.c = true;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = paramCharSequence.toString();
    this.i = paramInt2;
    if (paramInt2 == 0) {
      this.b = true;
    }
    if (paramInt3 == 0) {
      this.c = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.data.InsertDeleteWatcher
 * JD-Core Version:    0.7.0.1
 */