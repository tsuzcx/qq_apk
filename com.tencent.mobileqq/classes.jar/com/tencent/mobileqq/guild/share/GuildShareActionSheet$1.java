package com.tencent.mobileqq.guild.share;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.error.GuildError;
import com.tencent.mobileqq.guild.usecases.FetchShareInfoUseCase.ResultCallback;
import com.tencent.mobileqq.guild.usecases.FetchShareInfoUseCase.ShareUrlInfo;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil.ProgressDialog;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import mqq.util.WeakReference;

class GuildShareActionSheet$1
  implements FetchShareInfoUseCase.ResultCallback
{
  GuildShareActionSheet$1(GuildShareActionSheet paramGuildShareActionSheet) {}
  
  public void a(@NonNull GuildError paramGuildError, @Nullable FetchShareInfoUseCase.ShareUrlInfo paramShareUrlInfo)
  {
    Context localContext = (Context)GuildShareActionSheet.a(this.a).get();
    if (localContext == null) {
      return;
    }
    GuildShareActionSheet.b(this.a).b();
    if (paramGuildError.a == -200)
    {
      GuildShareActionSheet.a(paramGuildError, localContext);
      return;
    }
    if ((paramGuildError.a == 0) && (paramShareUrlInfo != null))
    {
      GuildShareActionSheet.a(this.a, paramShareUrlInfo);
      GuildShareActionSheet.a(this.a, true);
      paramGuildError = this.a;
      paramGuildError.a(GuildShareActionSheet.c(paramGuildError));
      return;
    }
    QQGuildUtil.a(localContext, paramGuildError.a, paramGuildError.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.share.GuildShareActionSheet.1
 * JD-Core Version:    0.7.0.1
 */