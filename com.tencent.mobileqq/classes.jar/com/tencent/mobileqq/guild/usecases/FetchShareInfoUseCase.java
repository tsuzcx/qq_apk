package com.tencent.mobileqq.guild.usecases;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.error.GuildError;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchShareInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;

public class FetchShareInfoUseCase
  implements IFetchShareInfoCallback
{
  private final IGProGuildInfo a;
  private final IGProChannelInfo b;
  private final FetchShareInfoUseCase.ResultCallback c;
  
  public FetchShareInfoUseCase(@NonNull IGProGuildInfo paramIGProGuildInfo, @Nullable IGProChannelInfo paramIGProChannelInfo, @NonNull FetchShareInfoUseCase.ResultCallback paramResultCallback)
  {
    this.a = paramIGProGuildInfo;
    this.b = paramIGProChannelInfo;
    this.c = paramResultCallback;
  }
  
  private void a(@NonNull GuildError paramGuildError, @NonNull FetchShareInfoUseCase.ShareUrlInfo paramShareUrlInfo)
  {
    if (paramGuildError.a != 0) {
      QLog.w("FetchShareInfoUseCase", 1, String.format("onFetchGuildShareUrl,  error=%s, result=%s", new Object[] { paramGuildError, paramShareUrlInfo }));
    } else if (QLog.isColorLevel()) {
      QLog.d("FetchShareInfoUseCase", 2, String.format("onFetchGuildShareUrl,  error=%s, result=%s", new Object[] { paramGuildError, paramShareUrlInfo }));
    }
    this.c.a(paramGuildError, paramShareUrlInfo);
  }
  
  public static void a(@NonNull IGProGuildInfo paramIGProGuildInfo, @NonNull IGProChannelInfo paramIGProChannelInfo, FetchShareInfoUseCase.ResultCallback paramResultCallback)
  {
    new FetchShareInfoUseCase(paramIGProGuildInfo, paramIGProChannelInfo, paramResultCallback).a();
  }
  
  public void a()
  {
    IGPSService localIGPSService = (IGPSService)QQGuildUtil.a(IGPSService.class, "");
    IGProChannelInfo localIGProChannelInfo = this.b;
    if ((localIGProChannelInfo != null) && (localIGProChannelInfo.getType() == 2))
    {
      localIGPSService.fetchChanelShareInfo(this.a.getGuildID(), this.b.getChannelUin(), this);
      return;
    }
    localIGProChannelInfo = this.b;
    if ((localIGProChannelInfo != null) && (localIGProChannelInfo.getType() == 5))
    {
      localIGPSService.fetchChanelShareInfo(this.a.getGuildID(), this.b.getChannelUin(), this);
      return;
    }
    localIGPSService.fetchShareInfo(this.a.getGuildID(), this);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, IGProSecurityResult paramIGProSecurityResult)
  {
    QLog.d("FetchShareInfoUseCase", 1, new Object[] { "onFetchGuildShareUrl,  errCode=", Integer.valueOf(paramInt), ", errMsg=", paramString1, ", shareUrl=", paramString2, ", shareInfo=", paramString3 });
    paramString2 = new FetchShareInfoUseCase.ShareUrlInfo(paramString2, paramString3);
    if (!QQGuildUtil.a(paramIGProSecurityResult))
    {
      a(GuildError.a(-200, "安全错误", paramIGProSecurityResult), paramString2);
      return;
    }
    a(GuildError.a(paramInt, paramString1), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.usecases.FetchShareInfoUseCase
 * JD-Core Version:    0.7.0.1
 */