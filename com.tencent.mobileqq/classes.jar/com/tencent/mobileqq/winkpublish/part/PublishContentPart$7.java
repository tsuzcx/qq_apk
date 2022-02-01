package com.tencent.mobileqq.winkpublish.part;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.biz.qcircleshadow.lib.QCircleHostTextBuilder;
import com.tencent.biz.qcircleshadow.lib.variation.HostEmotionUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.IPublishLauncher;
import com.tencent.mobileqq.winkpublish.view.edittext.ExtendEditText;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishViewModel;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;

class PublishContentPart$7
  implements TextWatcher
{
  PublishContentPart$7(PublishContentPart paramPublishContentPart) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str;
    Object localObject;
    if (QLog.isColorLevel())
    {
      str = PublishContentPart.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("afterTextChanged s:");
      ((StringBuilder)localObject).append(paramEditable.toString());
      QLog.e(str, 1, ((StringBuilder)localObject).toString());
    }
    if ((paramEditable != null) && (paramEditable.toString().equals(PublishContentPart.e(this.a)))) {
      return;
    }
    PublishContentPart.b(this.a, paramEditable.toString());
    if (paramEditable != null)
    {
      str = HostEmotionUtil.splash2Emo(QCircleHostTextBuilder.toPlainText(paramEditable).replaceAll(HardCodeUtil.a(2131903750), HardCodeUtil.a(2131903752)).replaceAll(HardCodeUtil.a(2131903749), "/MM").replaceAll(HardCodeUtil.a(2131914654), "/chigua"));
      localObject = this.a;
      str = ((PublishContentPart)localObject).a(str, ((PublishContentPart)localObject).o);
      PublishContentPart.k(this.a).a(str, PublishContentPart.j(this.a));
    }
    else
    {
      PublishContentPart.k(this.a).a(null, PublishContentPart.j(this.a));
    }
    this.a.a(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      String str = PublishContentPart.a;
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
    if (((paramInt2 == 1) || (paramInt2 == 2)) && (paramInt3 == 0)) {}
    try
    {
      PublishContentPart.b(this.a, PublishContentPart.a(this.a, paramCharSequence, paramInt1 + paramInt2));
      if (PublishContentPart.h(this.a) == -1)
      {
        PublishContentPart.f(this.a);
      }
      else
      {
        PublishContentPart.c(this.a, paramInt1);
        PublishContentPart.a(this.a, paramCharSequence.toString().substring(PublishContentPart.h(this.a), PublishContentPart.i(this.a) + paramInt2));
      }
      if (this.a.h == null) {
        break label232;
      }
      this.a.h.setBeforeChangeLineCount(this.a.h.getLineCount());
      return;
    }
    catch (Exception paramCharSequence)
    {
      label225:
      label232:
      break label225;
    }
    PublishContentPart.f(this.a);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      String str = PublishContentPart.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTextChanged s:");
      localStringBuilder.append(paramCharSequence.toString());
      localStringBuilder.append(" start:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" count:");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" before:");
      localStringBuilder.append(paramInt2);
      QLog.e(str, 1, localStringBuilder.toString());
    }
    if ((paramCharSequence != null) && (paramCharSequence.toString().equals(PublishContentPart.e(this.a)))) {
      return;
    }
    if (paramCharSequence == null)
    {
      PublishContentPart.f(this.a);
      return;
    }
    if (!TextUtils.isEmpty(this.a.n))
    {
      this.a.n = null;
      return;
    }
    if ((this.a.t()) && (paramInt3 == 1) && (paramInt2 == 0) && (paramCharSequence.toString().substring(paramInt1, paramInt1 + 1).equals("@")))
    {
      this.a.q = true;
      ((IPublishLauncher)QRoute.api(IPublishLauncher.class)).onPublishClick(this.a.c(), true, 1, QCircleConfigHelper.ak(), 1001);
    }
    paramCharSequence = this.a;
    if (PublishContentPart.a(paramCharSequence, PublishContentPart.g(paramCharSequence), true)) {
      this.a.h.getEditableText().delete(PublishContentPart.h(this.a), PublishContentPart.i(this.a));
    }
    PublishContentPart.f(this.a);
    this.a.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishContentPart.7
 * JD-Core Version:    0.7.0.1
 */