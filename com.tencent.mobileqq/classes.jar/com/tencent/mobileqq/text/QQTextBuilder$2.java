package com.tencent.mobileqq.text;

import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.mobileqq.qqemoticon.api.IChatTextSizeApi;
import com.tencent.mobileqq.qroute.QRoute;

final class QQTextBuilder$2
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new QQTextBuilder(paramCharSequence, 3, ((IChatTextSizeApi)QRoute.api(IChatTextSizeApi.class)).getChatTextSizeWithDP() + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQTextBuilder.2
 * JD-Core Version:    0.7.0.1
 */