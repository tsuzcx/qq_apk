package com.tencent.mobileqq.leba.business.mainbiz;

import android.text.TextUtils;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class LebaQzoneAndPluginPart$22
  extends AvatarObserver
{
  LebaQzoneAndPluginPart$22(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.22
 * JD-Core Version:    0.7.0.1
 */