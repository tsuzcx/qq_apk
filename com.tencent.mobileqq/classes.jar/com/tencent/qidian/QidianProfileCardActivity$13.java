package com.tencent.qidian;

import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

class QidianProfileCardActivity$13
  extends AvatarObserver
{
  QidianProfileCardActivity$13(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    super.onUpdateCustomHead(paramBoolean, paramString);
    if (paramBoolean)
    {
      if (paramString.equals(this.a.e.allInOne.uin))
      {
        QidianProfileCardActivity localQidianProfileCardActivity;
        if (SimpleUIUtil.e())
        {
          localQidianProfileCardActivity = this.a;
          localQidianProfileCardActivity.f = localQidianProfileCardActivity.app.getFaceBitmap(paramString, (byte)2, false);
        }
        else
        {
          localQidianProfileCardActivity = this.a;
          localQidianProfileCardActivity.f = localQidianProfileCardActivity.app.getFaceBitmap(paramString, false);
        }
        this.a.d();
        return;
      }
      paramString = (QidianProfileCardActivity.PaGroupStruct)this.a.h.get(paramString);
      if (paramString != null) {
        this.a.a(paramString.b, (URLImageView)paramString.a.get(), paramString.c, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.13
 * JD-Core Version:    0.7.0.1
 */