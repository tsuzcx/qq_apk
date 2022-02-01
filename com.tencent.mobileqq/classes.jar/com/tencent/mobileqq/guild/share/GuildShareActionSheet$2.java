package com.tencent.mobileqq.guild.share;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.error.GuildError;
import com.tencent.mobileqq.guild.usecases.FetchCreatorNameUseCase.ResultCallback;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil.ProgressDialog;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import mqq.util.WeakReference;

class GuildShareActionSheet$2
  implements FetchCreatorNameUseCase.ResultCallback
{
  GuildShareActionSheet$2(GuildShareActionSheet paramGuildShareActionSheet) {}
  
  public void a(@NonNull GuildError paramGuildError, @Nullable String paramString)
  {
    Context localContext = (Context)GuildShareActionSheet.a(this.a).get();
    if (localContext == null) {
      return;
    }
    GuildShareActionSheet.b(this.a).b();
    if (paramGuildError.a == 0)
    {
      GuildShareActionSheet.a(this.a, paramString);
      GuildShareActionSheet.b(this.a, true);
      paramGuildError = this.a;
      paramGuildError.a(GuildShareActionSheet.c(paramGuildError));
      return;
    }
    QQGuildUtil.a(localContext, paramGuildError.a, paramGuildError.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.share.GuildShareActionSheet.2
 * JD-Core Version:    0.7.0.1
 */