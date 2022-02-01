package com.tencent.mobileqq.flashshow.widgets.comment;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.mobileqq.flashshow.widgets.comment.dialog.CommentEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig.TextImageSpanConfig;
import com.tencent.richframework.text.rich.parser.RichTextAtParser;
import com.tencent.richframework.text.rich.parser.RichTextEmojiParser;

class FSCommentInputPopupWindow$6
  implements TextWatcher
{
  private int b = 0;
  private int c = 0;
  
  FSCommentInputPopupWindow$6(FSCommentInputPopupWindow paramFSCommentInputPopupWindow) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    this.a.c.removeTextChangedListener(this);
    int i;
    Object localObject1;
    String str;
    Object localObject3;
    try
    {
      if ((FSCommentInputPopupWindow.d(this.a) == null) || (TextUtils.isEmpty(FSCommentInputPopupWindow.d(this.a).getText().toString()))) {
        break label403;
      }
      i = Integer.parseInt(FSCommentInputPopupWindow.d(this.a).getText().toString());
      if (i >= 100)
      {
        this.a.c.setText(paramEditable.toString().substring(0, i));
        this.a.c.setSelection(this.a.c.getText().toString().length());
        this.a.c.addTextChangedListener(this);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject1 = paramEditable.toString();
      i = this.b;
      localObject1 = ((String)localObject1).substring(i, this.c + i);
      str = RichTextAtParser.a(paramEditable.toString());
      i = ((String)localObject1).indexOf('/');
      if ((i >= 0) && (i < ((String)localObject1).length() - 1))
      {
        localObject1 = new SpannableStringBuilder(str);
        localObject3 = new RichTextPreloadConfig.TextImageSpanConfig();
        double d = this.a.c.getContext().getResources().getDisplayMetrics().density;
        Double.isNaN(d);
        RichTextEmojiParser.a(((RichTextPreloadConfig.TextImageSpanConfig)localObject3).a((int)(d * 22.0D + 0.5D)).a(0), (SpannableStringBuilder)localObject1, null);
      }
      else
      {
        localObject1 = null;
      }
      if (localObject1 != null) {
        break label303;
      }
    }
    if (!TextUtils.equals(paramEditable.toString(), str)) {}
    for (;;)
    {
      try
      {
        label303:
        localObject3 = this.a.c;
        if (localObject1 == null) {
          break label409;
        }
        ((CommentEditText)localObject3).setText((CharSequence)localObject1);
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        continue;
      }
      this.a.c.setText(paramEditable.toString());
      this.a.c.setSelection(this.a.c.getText().length());
      this.c = 0;
      this.b = 0;
      this.a.c.addTextChangedListener(this);
      FSCommentInputPopupWindow.e(this.a);
      return;
      label403:
      i = 0;
      break;
      label409:
      Object localObject2 = str;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence == null) {
      return;
    }
    if ((this.a.f) && (paramInt3 == 1) && (paramInt2 == 0)) {
      if (paramCharSequence.toString().substring(paramInt1, paramInt1 + 1).equals("@"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FSBaseInputPopupWindow", 2, "输入@呼起好友选择器");
        }
        paramCharSequence = this.a;
        paramCharSequence.m = true;
        paramCharSequence.j();
      }
      else
      {
        this.a.m = false;
      }
    }
    this.b = paramInt1;
    this.c = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSCommentInputPopupWindow.6
 * JD-Core Version:    0.7.0.1
 */