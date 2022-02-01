package com.tencent.mobileqq.emosm.api.impl;

import android.os.Message;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService.AddCustomEmotionsCallback;
import com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback.UploadListener;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import mqq.os.MqqHandler;

class FavroamingManagerServiceImpl$8$1
  implements EmoAddedAuthCallback.UploadListener
{
  private int c;
  
  FavroamingManagerServiceImpl$8$1(FavroamingManagerServiceImpl.8 param8, List paramList) {}
  
  public void a(int paramInt, String paramString)
  {
    this.a.add(Integer.valueOf(paramInt));
    this.c += 1;
    if (this.c <= this.b.a)
    {
      this.b.this$0.notifyFavEmoticonUploaded();
      if (this.b.b != null) {
        this.b.b.a(this.c / this.b.a, this.a);
      }
    }
    if (this.c < this.b.a)
    {
      if (!FavroamingManagerServiceImpl.access$1800(this.b.this$0))
      {
        paramString = (String)this.b.c.get(this.c);
        FavroamingManagerServiceImpl.access$1900(this.b.this$0, paramString, FavroamingManagerServiceImpl.access$1700(this.b.this$0));
      }
    }
    else
    {
      paramString = FavroamingManagerServiceImpl.access$2000(this.b.this$0).getHandler(((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityClass());
      if (paramString != null) {
        paramString.obtainMessage(10).sendToTarget();
      }
      if (this.b.b != null) {
        this.b.b.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.8.1
 * JD-Core Version:    0.7.0.1
 */