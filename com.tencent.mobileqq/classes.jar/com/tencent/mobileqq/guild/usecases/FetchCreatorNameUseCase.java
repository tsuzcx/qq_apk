package com.tencent.mobileqq.guild.usecases;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class FetchCreatorNameUseCase
  extends GPServiceObserver
  implements Handler.Callback
{
  private final String a;
  private final FetchCreatorNameUseCase.ResultCallback b;
  private final AtomicBoolean c = new AtomicBoolean(false);
  private final Handler d = new Handler(Looper.getMainLooper(), this);
  private final IGPSService e;
  
  public FetchCreatorNameUseCase(@NonNull String paramString, @NonNull FetchCreatorNameUseCase.ResultCallback paramResultCallback)
  {
    this.a = paramString;
    this.b = paramResultCallback;
    this.e = ((IGPSService)QQGuildUtil.a(IGPSService.class, ""));
  }
  
  public static void a(@NonNull String paramString, @NonNull FetchCreatorNameUseCase.ResultCallback paramResultCallback)
  {
    new FetchCreatorNameUseCase(paramString, paramResultCallback).c();
  }
  
  private void i(String paramString)
  {
    this.d.removeMessages(1);
    this.e.deleteObserver(this);
    if (!this.c.compareAndSet(false, true)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FetchCreatorNameUserCase", 2, new Object[] { "dispatchResult, tinyId= ", this.a, " nickName= ", paramString });
    }
    this.d.post(new FetchCreatorNameUseCase.1(this, paramString));
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (TextUtils.equals(paramString1, this.a)) {
      i(paramString2);
    }
  }
  
  public void c()
  {
    this.e.deleteObserver(this);
    this.e.addObserver(this);
    this.d.removeMessages(1);
    this.d.sendEmptyMessageDelayed(1, 3000L);
    String str = this.e.getGuildUserNick(this.a);
    if (!TextUtils.isEmpty(str)) {
      i(str);
    }
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      i(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.usecases.FetchCreatorNameUseCase
 * JD-Core Version:    0.7.0.1
 */