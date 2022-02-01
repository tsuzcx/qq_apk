package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.TextInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TextItem$5
  implements TextWatcher
{
  TextItem$5(TextItem paramTextItem, TextItem.TextViewHolder paramTextViewHolder, TextInfo paramTextInfo) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    Object localObject;
    if (this.c.b.getSizeLimit() != 0)
    {
      int j = this.c.b.getSizeLimit();
      i = this.c.b.getContentLength();
      j -= i;
      int k = paramInt3 - paramInt2;
      if (k > j)
      {
        QQToast.makeText(TextItem.a(this.c), "最多可以输入500个字", 1).show();
        paramInt2 = j + paramInt2;
        this.a.b.removeTextChangedListener(this);
        j = paramInt1 + paramInt2;
        localObject = paramCharSequence.subSequence(0, j);
        paramCharSequence = paramCharSequence.subSequence(paramInt1 + paramInt3, paramCharSequence.length());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((CharSequence)localObject).toString());
        localStringBuilder.append(paramCharSequence.toString());
        paramCharSequence = localStringBuilder.toString();
        this.a.b.setText(paramCharSequence);
        this.a.b.addTextChangedListener(this);
        this.a.b.setSelection(j);
        this.c.c.a(i, paramInt2 + i);
        localObject = this.b;
        ((TextInfo)localObject).b = j;
        ((TextInfo)localObject).a(paramCharSequence);
      }
      else
      {
        this.c.c.a(i, i + k);
        localObject = this.b;
        ((TextInfo)localObject).b = (paramInt1 + k);
        ((TextInfo)localObject).a(paramCharSequence.toString());
      }
    }
    else
    {
      i = this.c.b.getContentLength();
      this.c.c.a(i, i + paramInt3 - paramInt2);
      localObject = this.b;
      ((TextInfo)localObject).b = (paramInt1 + paramInt3);
      ((TextInfo)localObject).a(paramCharSequence.toString());
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("onTextChanged, mData.position:");
    paramCharSequence.append(this.b.g);
    paramCharSequence.append(", text:");
    paramCharSequence.append(this.b.a);
    paramCharSequence.append(",Listener:");
    paramCharSequence.append(toString());
    QLog.i("xmediaEditor", 1, paramCharSequence.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.5
 * JD-Core Version:    0.7.0.1
 */