package com.tencent.mobileqq.text;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import bhcw;
import bhfp;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QQText$LinkSpan
  extends ClickableSpan
{
  public String mUrl;
  
  public QQText$LinkSpan(QQText paramQQText, String paramString)
  {
    this.mUrl = paramString;
  }
  
  public void onClick(View paramView)
  {
    if (bhcw.a) {
      if (QLog.isColorLevel()) {
        QLog.e("LinkSpan", 2, "LinkSpan.onCLick is invoked by LongClick misstake");
      }
    }
    Object localObject;
    do
    {
      return;
      localObject = paramView.getTag();
      if ((localObject instanceof String)) {
        QQText.access$102((String)localObject);
      }
      localObject = this.mUrl;
      boolean bool2 = bhfp.d.matcher((CharSequence)localObject).find();
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = bhfp.c.matcher((CharSequence)localObject).find();
      }
      if (bool1)
      {
        if (QQTextParseLinkUtil.QQ_MAIL_PATTERN.matcher((CharSequence)localObject).find())
        {
          this.this$0.showDialog(paramView.getContext(), (String)localObject, 2, QQText.access$200(this.this$0));
          QQText.access$300("1", null);
          return;
        }
        this.this$0.onURLLinkClicked(paramView, (String)localObject);
        QQText.access$300("0", null);
        return;
      }
      if (QQTextParseLinkUtil.MEETING_PHONE_PATTERN.matcher((CharSequence)localObject).find())
      {
        this.this$0.showDialog(paramView.getContext(), (String)localObject, 3, QQText.access$200(this.this$0));
        QQText.access$300("2", null);
        return;
      }
      Matcher localMatcher = QQTextParseLinkUtil.QQ_NUMBER_PATTERN.matcher((CharSequence)localObject);
      if ((localMatcher.find()) && (localMatcher.start() == 0) && (localMatcher.end() == ((String)localObject).length()))
      {
        this.this$0.showDialog(paramView.getContext(), (String)localObject, 0, QQText.access$200(this.this$0));
        QQText.access$300("1", null);
        return;
      }
    } while (!QQTextParseLinkUtil.QQ_PHONE_PATTERN.matcher((CharSequence)localObject).find());
    this.this$0.showDialog(paramView.getContext(), (String)localObject, 1, QQText.access$200(this.this$0));
    QQText.access$300("2", null);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText.LinkSpan
 * JD-Core Version:    0.7.0.1
 */