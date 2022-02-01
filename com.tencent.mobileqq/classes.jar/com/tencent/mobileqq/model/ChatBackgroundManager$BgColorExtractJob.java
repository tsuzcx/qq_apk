package com.tencent.mobileqq.model;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Vector;

class ChatBackgroundManager$BgColorExtractJob
  implements Runnable
{
  private Bitmap a;
  private boolean b;
  private String c;
  private ChatBackgroundManager.BgThemeColorExtractListener d;
  
  public ChatBackgroundManager$BgColorExtractJob(ChatBackgroundManager paramChatBackgroundManager, String paramString, Bitmap paramBitmap, boolean paramBoolean, ChatBackgroundManager.BgThemeColorExtractListener paramBgThemeColorExtractListener)
  {
    this.c = paramString;
    this.a = paramBitmap;
    this.b = paramBoolean;
    this.d = paramBgThemeColorExtractListener;
  }
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = this.this$0.a((Bitmap)localObject);
      if (this.b) {
        this.a.recycle();
      }
      if ((localObject != null) && (!((Vector)localObject).isEmpty()))
      {
        if (this.this$0.g.get(this.c) != null) {
          ((Vector)this.this$0.g.get(this.c)).addAll((Collection)localObject);
        } else {
          this.this$0.g.put(this.c, localObject);
        }
      }
      else {
        this.this$0.g.remove(this.c);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatBackgroundManager", 4, "get Bitmap from Drawable success.");
      }
    }
    else
    {
      this.this$0.g.remove(this.c);
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatBackgroundManager", 4, "get Bitmap from Drawable failed.");
      }
    }
    if (this.d != null)
    {
      localObject = (Vector)this.this$0.g.get(this.c);
      boolean bool;
      if ((localObject != null) && (!((Vector)localObject).isEmpty())) {
        bool = true;
      } else {
        bool = false;
      }
      this.this$0.a.runOnUiThread(new ChatBackgroundManager.BgColorExtractJob.1(this, bool, (Vector)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.model.ChatBackgroundManager.BgColorExtractJob
 * JD-Core Version:    0.7.0.1
 */