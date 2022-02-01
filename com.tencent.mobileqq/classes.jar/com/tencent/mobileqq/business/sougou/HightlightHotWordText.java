package com.tencent.mobileqq.business.sougou;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class HightlightHotWordText
  extends ClickableSpan
{
  String jdField_a_of_type_JavaLangString;
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  String b = "https://m.sogou.com/web/searchList.jsp?pid=sogou-appi-4fc28b7093b135c2&keyword=";
  
  HightlightHotWordText(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public static SpannableStringBuilder a(QQAppInterface paramQQAppInterface, String paramString, WordMatchManager.HotWordItem[] paramArrayOfHotWordItem)
  {
    SpannableStringBuilder localSpannableStringBuilder1;
    int j;
    SpannableStringBuilder localSpannableStringBuilder2;
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfHotWordItem != null))
    {
      localSpannableStringBuilder1 = new SpannableStringBuilder(paramString);
      j = -1;
      localSpannableStringBuilder2 = localSpannableStringBuilder1;
    }
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = paramString.getBytes("GB2312");
        i = 0;
        localObject = localSpannableStringBuilder1;
        localSpannableStringBuilder2 = localSpannableStringBuilder1;
        if (i < paramArrayOfHotWordItem.length)
        {
          localSpannableStringBuilder2 = localSpannableStringBuilder1;
          localObject = new String(arrayOfByte, 0, paramArrayOfHotWordItem[i].offset, "GB2312");
          localSpannableStringBuilder2 = localSpannableStringBuilder1;
          if (a(paramString, (String)localObject))
          {
            localObject = localSpannableStringBuilder1;
            localSpannableStringBuilder2 = localSpannableStringBuilder1;
            if (QLog.isColorLevel())
            {
              localSpannableStringBuilder2 = localSpannableStringBuilder1;
              QLog.d("HotWord", 2, "转换到gbk的时候出现了乱码字符。不添加span了");
              localObject = localSpannableStringBuilder1;
            }
          }
          else
          {
            localSpannableStringBuilder2 = localSpannableStringBuilder1;
            if (j != ((String)localObject).length())
            {
              localSpannableStringBuilder2 = localSpannableStringBuilder1;
              j = ((String)localObject).length() + paramArrayOfHotWordItem[i].hotWord.length();
              localSpannableStringBuilder2 = localSpannableStringBuilder1;
              localSpannableStringBuilder1.setSpan(new HightlightHotWordText(paramQQAppInterface, paramArrayOfHotWordItem[i].hotWord), ((String)localObject).length(), j, 33);
              if (paramQQAppInterface != null)
              {
                localSpannableStringBuilder2 = localSpannableStringBuilder1;
                localObject = paramArrayOfHotWordItem[i].hotWord;
              }
            }
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        int i;
        Object localObject = localSpannableStringBuilder2;
        continue;
      }
      try
      {
        ReportController.b(paramQQAppInterface, "P_CliOper", "aio_search", "", "aio_hotword", "view_hotword", 0, 0, "", "", (String)localObject, "");
        i += 1;
      }
      catch (Exception paramQQAppInterface) {}
    }
    return localObject;
    return null;
    return localSpannableStringBuilder1;
  }
  
  private void a(Context paramContext)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramContext, null);
    localActionSheet.addButton(2131697279, 5);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new HightlightHotWordText.1(this, paramContext, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (paramString1.length() < paramString2.length()) {
      return true;
    }
    int i = 0;
    while (i < paramString2.length())
    {
      char c1 = paramString1.charAt(i);
      char c2 = paramString2.charAt(i);
      if ((c2 == '?') && (c1 != c2))
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("isErrorCharAfterGBKConvert temp1=");
          paramString1.append(c1);
          paramString1.append(" temp2=");
          paramString1.append(c2);
          QLog.d("HotWord", 2, paramString1.toString());
        }
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = paramView.getContext();
    if (paramView == null) {
      return;
    }
    a(paramView);
    paramView = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((paramView != null) && (paramView.get() != null)) {
      ReportController.b((AppRuntime)this.jdField_a_of_type_JavaLangRefWeakReference.get(), "P_CliOper", "aio_search", "", "aio_hotword", "click_hotword", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.HightlightHotWordText
 * JD-Core Version:    0.7.0.1
 */