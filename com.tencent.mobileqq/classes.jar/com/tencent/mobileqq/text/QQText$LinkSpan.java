package com.tencent.mobileqq.text;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QQText$LinkSpan
  extends ClickableSpan
{
  public String a;
  
  public QQText$LinkSpan(QQText paramQQText, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof String)) {
      QQText.a((String)localObject);
    }
    localObject = this.jdField_a_of_type_JavaLangString;
    boolean bool2 = Patterns.d.matcher((CharSequence)localObject).find();
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = Patterns.c.matcher((CharSequence)localObject).find();
    }
    if (bool1) {
      if (BubbleContextMenu.a) {
        if (QLog.isColorLevel()) {
          QLog.e("LinkSpan", 2, "LinkSpan.onCLick is invoked by LongClick misstake");
        }
      }
    }
    do
    {
      return;
      if (QQText.f.matcher((CharSequence)localObject).find())
      {
        QQText.a(paramView.getContext(), (String)localObject, 2);
        QQText.a("1", null);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTextQQText.a(paramView, (String)localObject);
      QQText.a("0", null);
      return;
      Matcher localMatcher = QQText.b.matcher((CharSequence)localObject);
      if ((localMatcher.find()) && (localMatcher.start() == 0) && (localMatcher.end() == ((String)localObject).length()))
      {
        QQText.a(paramView.getContext(), (String)localObject, 0);
        QQText.a("1", null);
        return;
      }
    } while (!QQText.e.matcher((CharSequence)localObject).find());
    QQText.a(paramView.getContext(), (String)localObject, 1);
    QQText.a("2", null);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText.LinkSpan
 * JD-Core Version:    0.7.0.1
 */