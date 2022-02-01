package com.tencent.mobileqq.filemanageraux.link;

import android.widget.TextView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class LinkByWeiyunFragment$1
  implements Runnable
{
  LinkByWeiyunFragment$1(LinkByWeiyunFragment paramLinkByWeiyunFragment, TextView paramTextView, String paramString) {}
  
  public void run()
  {
    TextView localTextView = this.a;
    localTextView.setText(FileManagerUtil.a(this.b, true, localTextView.getMeasuredWidth(), this.a.getPaint(), 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.link.LinkByWeiyunFragment.1
 * JD-Core Version:    0.7.0.1
 */