package com.tencent.mobileqq.guild.mainframe.joinchannel;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.base.BaseGuildViewModel;
import com.tencent.mobileqq.guild.base.BaseGuildViewModel.ToastEvent;
import com.tencent.mobileqq.guild.setting.QQGuildInfoRepository;
import com.tencent.mobileqq.guild.source.QQGuildJumpSource;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.AddGuildOption;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceId;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class JoinChannelViewModel
  extends BaseGuildViewModel<QQGuildInfoRepository>
{
  private MutableLiveData<Integer> b = new MutableLiveData();
  private MutableLiveData<AddGuildOption> c = new MutableLiveData();
  private JoinChannelViewModel.JoinChannelParams d;
  private IResultWithSecurityCallback e;
  
  public JoinChannelViewModel()
  {
    super(new QQGuildInfoRepository());
    if (QLog.isDebugVersion()) {
      QLog.d("JoinChannelViewModel", 4, " create");
    }
  }
  
  private void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    IResultWithSecurityCallback localIResultWithSecurityCallback = this.e;
    if (localIResultWithSecurityCallback != null)
    {
      localIResultWithSecurityCallback.a(paramInt, paramString, paramIGProSecurityResult);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("handleResult callback is null error:");
    paramString.append(paramInt);
    QLog.w("JoinChannelViewModel", 1, paramString.toString());
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 22006) || (paramInt == 22008);
  }
  
  public LiveData<Integer> a()
  {
    return this.b;
  }
  
  public void a(Context paramContext, String paramString)
  {
    if ((this.b.getValue() != null) && (((Integer)this.b.getValue()).intValue() == 1))
    {
      this.b.setValue(Integer.valueOf(2));
      return;
    }
    Object localObject = (AddGuildOption)this.c.getValue();
    if (this.d != null)
    {
      if (localObject == null) {
        return;
      }
      if ((((AddGuildOption)localObject).a != 2) && (((AddGuildOption)localObject).a != 5))
      {
        localObject = paramString;
        paramString = "";
      }
      else
      {
        localObject = "";
      }
      IGPSService localIGPSService = (IGPSService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "");
      QLog.d("QQGuildJumpSource", 1, new Object[] { "JoinGuildSource: ", QQGuildJumpSource.a(), " - ", QQGuildJumpSource.b(), " - ", Integer.valueOf(QQGuildJumpSource.c()) });
      localIGPSService.addGuildWithOption(this.d.a, new GuildSourceId(QQGuildJumpSource.a(), QQGuildJumpSource.b(), QQGuildJumpSource.c()), this.d.b, paramString, (String)localObject, new JoinChannelViewModel.1(this, paramContext));
    }
  }
  
  public void a(@NonNull JoinChannelViewModel.JoinChannelParams paramJoinChannelParams, @NonNull AddGuildOption paramAddGuildOption)
  {
    this.d = paramJoinChannelParams;
    this.c.setValue(paramAddGuildOption);
  }
  
  public void a(IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    this.e = paramIResultWithSecurityCallback;
  }
  
  public LiveData<AddGuildOption> b()
  {
    return this.c;
  }
  
  public LiveData<BaseGuildViewModel.ToastEvent> c()
  {
    return this.a;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    if (QLog.isDebugVersion()) {
      QLog.d("JoinChannelViewModel", 4, "onCleared");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.joinchannel.JoinChannelViewModel
 * JD-Core Version:    0.7.0.1
 */