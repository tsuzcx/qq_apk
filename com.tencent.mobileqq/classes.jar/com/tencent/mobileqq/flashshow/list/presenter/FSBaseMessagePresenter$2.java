package com.tencent.mobileqq.flashshow.list.presenter;

import com.tencent.mobileqq.flashshow.api.bean.FSPersonalDetailBean;
import com.tencent.mobileqq.flashshow.launcher.FSNativeLauncher;
import com.tencent.mobileqq.flashshow.widgets.common.FSAsyncTextView;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener;

class FSBaseMessagePresenter$2
  implements RFWAsyncRichTextView.OnClickAtTextListener
{
  FSBaseMessagePresenter$2(FSBaseMessagePresenter paramFSBaseMessagePresenter) {}
  
  public void onClick(String paramString)
  {
    FSPersonalDetailBean localFSPersonalDetailBean = new FSPersonalDetailBean(this.a.e());
    localFSPersonalDetailBean.setUin(paramString);
    FSNativeLauncher.a(this.a.h.getContext(), localFSPersonalDetailBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSBaseMessagePresenter.2
 * JD-Core Version:    0.7.0.1
 */