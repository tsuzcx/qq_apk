package com.tencent.qzonehub.api.impl;

import android.text.Editable;
import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.qzone.api.text.QzoneTextBuilder;
import com.tencent.qzonehub.api.IQzoneTextApi;

public class QzoneTextApiImpl
  implements IQzoneTextApi
{
  public SpannableStringBuilder createQzoneTextBuilder(String paramString)
  {
    return new QzoneTextBuilder(paramString, 3);
  }
  
  public Editable.Factory getEmoctationFacory()
  {
    return QzoneTextBuilder.a;
  }
  
  public String toPlainText(Editable paramEditable)
  {
    String str2 = "";
    String str1 = str2;
    if (paramEditable != null)
    {
      if (!(paramEditable instanceof QzoneTextBuilder)) {
        break label37;
      }
      paramEditable = (QzoneTextBuilder)paramEditable;
      str1 = str2;
      if (paramEditable != null) {
        str1 = paramEditable.toPlainText();
      }
    }
    return str1;
    label37:
    return paramEditable.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzoneTextApiImpl
 * JD-Core Version:    0.7.0.1
 */