package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.TextInfo;
import com.tencent.qphone.base.util.QLog;

class TextItem$4
  implements View.OnFocusChangeListener
{
  TextItem$4(TextItem paramTextItem, TextInfo paramTextInfo, TextItem.TextViewHolder paramTextViewHolder) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    paramView = new StringBuilder();
    paramView.append("mData.position:");
    paramView.append(this.a.g);
    paramView.append(", text:");
    paramView.append(this.a.a);
    paramView.append(",onFocusChange:");
    paramView.append(paramBoolean);
    QLog.i("xmediaEditor", 1, paramView.toString());
    if (paramBoolean)
    {
      this.b.b.setCursorVisible(true);
      this.c.c.c(this.b);
      this.a.c = true;
    }
    else
    {
      this.b.b.setCursorVisible(false);
      this.c.c.d(this.b);
    }
    this.b.b.setFocusable(paramBoolean);
    this.b.b.setFocusableInTouchMode(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.4
 * JD-Core Version:    0.7.0.1
 */