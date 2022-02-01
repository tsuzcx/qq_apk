package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public final class BaseGuildPicBuilder$GuildRefreshURLDrawableListener
  implements URLDrawableDownListener
{
  private int a = 0;
  private Boolean b = Boolean.valueOf(false);
  private long c = System.currentTimeMillis();
  private MessageForPic d;
  
  void a(View paramView, URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == null) {
      return;
    }
    if (!this.b.booleanValue()) {
      return;
    }
    if ((paramView instanceof ChatThumbView))
    {
      ((ChatThumbView)paramView).b = false;
      paramURLDrawable.setFadeInImage(true);
    }
    paramView = paramURLDrawable.getFileInLocal();
    if ((paramView != null) && (!TextUtils.isEmpty(paramView.getPath())))
    {
      if (!paramView.getPath().contains("chatthumb"))
      {
        a("refreshDrawable", paramURLDrawable, "noNeedRefresh");
        this.b = Boolean.valueOf(false);
        return;
      }
      ThreadManager.getSubThreadHandler().post(new -..Lambda.BaseGuildPicBuilder.GuildRefreshURLDrawableListener.5lMRYA_H5EIg275bTYsNDzr6QIQ(this, paramURLDrawable));
      return;
    }
    a("refreshDrawable", paramURLDrawable, "need But Not, error params");
  }
  
  public void a(MessageForPic paramMessageForPic)
  {
    this.a = 0;
    this.b = Boolean.valueOf(true);
    this.c = System.currentTimeMillis();
    this.d = paramMessageForPic;
  }
  
  void a(String paramString1, URLDrawable paramURLDrawable, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("step:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" url:");
    localStringBuilder.append(paramURLDrawable.getURL());
    localStringBuilder.append(" file:");
    localStringBuilder.append(paramURLDrawable.getFileInLocal());
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString2);
    QLog.i("BaseGuildPicBuilder<gld>", 1, localStringBuilder.toString());
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    a("onLoadCancelled", paramURLDrawable, "");
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = new StringBuilder();
    paramView.append(" t:");
    paramView.append(paramThrowable);
    a("onLoadCancelled", paramURLDrawable, paramView.toString());
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    paramView = new StringBuilder();
    paramView.append(" e:");
    paramView.append(paramInterruptedException);
    a("onLoadInterrupted", paramURLDrawable, paramView.toString());
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if ((paramInt > this.a) || (paramInt == 10000))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("i:");
      localStringBuilder.append(paramInt);
      a("onLoadProgressed ", paramURLDrawable, localStringBuilder.toString());
      this.a += 3000;
      if (paramInt == 10000)
      {
        a(paramView, paramURLDrawable);
        paramView = new StringBuilder();
        paramView.append(" time:");
        paramView.append(System.currentTimeMillis() - this.c);
        a("timeStep", paramURLDrawable, paramView.toString());
      }
    }
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" time:");
    localStringBuilder.append(System.currentTimeMillis() - this.c);
    a("onLoadSuccessed", paramURLDrawable, localStringBuilder.toString());
    a(paramView, paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildPicBuilder.GuildRefreshURLDrawableListener
 * JD-Core Version:    0.7.0.1
 */