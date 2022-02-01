package com.tencent.mobileqq.profile.stickynote.publish.ui;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.stickynote.publish.StickyNotePublishUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.publishInterface.QzonePublishMoodCallback;

class StickyNotePublishFragment$10
  implements QzonePublishMoodCallback
{
  StickyNotePublishFragment$10(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void onResult(boolean paramBoolean, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickyNotePublishFragment", 2, String.format("publishStickyNote onResult success=%s resultCode=%s resultMsg=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString }));
    }
    if ((StickyNotePublishFragment.i(this.a) != null) && (StickyNotePublishFragment.i(this.a).isShowing())) {
      StickyNotePublishFragment.i(this.a).dismiss();
    }
    if (paramBoolean)
    {
      QQToast.makeText(BaseApplication.context, 2, 2131897178, 0).show();
      if (this.a.getBaseActivity() != null)
      {
        StickyNotePublishFragment.b(this.a, false);
        paramString = this.a;
        paramString.b(paramString.getBaseActivity().app);
        this.a.getBaseActivity().setResult(-1);
        this.a.getBaseActivity().finish();
      }
    }
    else
    {
      int i = 2131897176;
      if (paramInt == StickyNotePublishUtils.b) {
        i = 2131897177;
      }
      QQToast.makeText(BaseApplication.context, 1, i, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment.10
 * JD-Core Version:    0.7.0.1
 */