package com.tencent.mobileqq.winkpublish.part;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.winkpublish.view.edittext.ExtendEditText;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishLabelViewModel;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishViewModel;
import com.tencent.qphone.base.util.QLog;

class PublishLabelPart$4
  implements TextWatcher
{
  PublishLabelPart$4(PublishLabelPart paramPublishLabelPart) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (QLog.isColorLevel())
    {
      String str = PublishLabelPart.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("afterTextChanged s:");
      localStringBuilder.append(paramEditable.toString());
      QLog.e(str, 1, localStringBuilder.toString());
    }
    if (paramEditable == null) {
      return;
    }
    try
    {
      if (paramEditable.toString().equals(PublishLabelPart.h(this.a))) {
        return;
      }
      PublishLabelPart.d(this.a, paramEditable.toString());
      PublishLabelPart.i(this.a);
      return;
    }
    catch (Exception paramEditable)
    {
      QLog.e(PublishLabelPart.a, 1, paramEditable, new Object[0]);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      String str = PublishLabelPart.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("beforeTextChanged: s:");
      localStringBuilder.append(paramCharSequence.toString());
      localStringBuilder.append(" start:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" count:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" after:");
      localStringBuilder.append(paramInt3);
      QLog.e(str, 1, localStringBuilder.toString());
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = PublishLabelPart.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTextChanged s:");
      localStringBuilder.append(paramCharSequence.toString());
      localStringBuilder.append(" start:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" count:");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" before:");
      localStringBuilder.append(paramInt2);
      QLog.e((String)localObject, 1, localStringBuilder.toString());
    }
    if (paramCharSequence == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (paramCharSequence.toString().equals(PublishLabelPart.c(this.a))) {
          return;
        }
        PublishLabelPart.b(this.a, paramCharSequence.toString());
        if ((paramInt3 != 1) || (!paramCharSequence.subSequence(paramInt1, paramInt1 + 1).toString().equals("#"))) {
          break label438;
        }
        PublishLabelPart.a(this.a, paramInt1);
        if (!PublishViewModel.l()) {
          break label432;
        }
        PublishLabelPart.a(this.a).d();
      }
      catch (Exception paramCharSequence)
      {
        QLog.e(PublishLabelPart.a, 1, paramCharSequence, new Object[0]);
      }
      paramInt1 = this.a.a(paramCharSequence, paramInt1, paramInt2, paramInt3);
      if (paramInt1 != -1)
      {
        if (this.a.a(paramCharSequence.subSequence(paramInt1, PublishLabelPart.d(this.a).getSelectionStart()).toString()))
        {
          PublishLabelPart.c(this.a, paramCharSequence.subSequence(paramInt1 + 1, PublishLabelPart.d(this.a).getSelectionStart()).toString());
          PublishLabelPart.a(this.a, paramInt1);
        }
        else
        {
          PublishLabelPart.c(this.a, null);
        }
      }
      else {
        PublishLabelPart.c(this.a, null);
      }
      if ((PublishLabelPart.e(this.a) == null) && (!bool)) {
        PublishLabelPart.f(this.a);
      }
      if (QLog.isColorLevel())
      {
        paramCharSequence = PublishLabelPart.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mInputTag:");
        ((StringBuilder)localObject).append(PublishLabelPart.e(this.a));
        ((StringBuilder)localObject).append(" mTagStartPos:");
        ((StringBuilder)localObject).append(PublishLabelPart.g(this.a));
        ((StringBuilder)localObject).append(" isInsertJing:");
        ((StringBuilder)localObject).append(bool);
        QLog.e(paramCharSequence, 1, ((StringBuilder)localObject).toString());
        return;
      }
      return;
      label432:
      boolean bool = true;
      continue;
      label438:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLabelPart.4
 * JD-Core Version:    0.7.0.1
 */