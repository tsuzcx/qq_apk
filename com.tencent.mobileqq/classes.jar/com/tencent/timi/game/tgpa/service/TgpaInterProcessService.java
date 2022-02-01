package com.tencent.timi.game.tgpa.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.ihoc.mgpa.dataforwardsdk.IDataForward.Stub;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.tgpa.helper.TGPAInnerHelper;
import com.tencent.timi.game.utils.Logger;

public class TgpaInterProcessService
  extends Service
{
  private IDataForward.Stub a = new TgpaInterProcessService.1(this);
  
  public static void a(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopTgpaService ");
    localStringBuilder.append(paramContext);
    Logger.a("TgpaInterProcessService", localStringBuilder.toString());
    paramContext.stopService(new Intent(paramContext, TgpaInterProcessService.class));
    Logger.a("TgpaInterProcessService", "stopTgpaService END");
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startTgpaService ");
    localStringBuilder.append(paramContext);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramBoolean);
    Logger.a("TgpaInterProcessService", localStringBuilder.toString());
    if (paramBoolean) {
      try
      {
        paramContext.startService(new Intent(paramContext, TgpaInterProcessService.class));
      }
      catch (Exception paramContext)
      {
        Logger.a("TgpaInterProcessService", "startTgpaService exception", paramContext);
      }
    } else {
      Logger.a("TgpaInterProcessService", "startTgpaService BACKGROUND!", new Exception());
    }
    Logger.a("TgpaInterProcessService", "startTgpaService END");
  }
  
  public static void b(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendBindServiceRequestWhenLaunch ");
    localStringBuilder.append(paramContext);
    Logger.a("TgpaInterProcessService", localStringBuilder.toString());
    paramContext.sendBroadcast(new Intent("com.ihoc.mgpa.ACTION_DATAFORWARD_REQUEST"));
    Logger.a("TgpaInterProcessService", "sendBindServiceRequestWhenLaunch END");
  }
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBind ");
    localStringBuilder.append(paramIntent);
    Logger.a("TgpaInterProcessService", localStringBuilder.toString());
    TGPAInnerHelper.a().b();
    return this.a;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStartCommand - flags: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" startId: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramIntent);
    Logger.a("TgpaInterProcessService", localStringBuilder.toString());
    b(Env.a());
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUnbind ");
    localStringBuilder.append(paramIntent);
    Logger.a("TgpaInterProcessService", localStringBuilder.toString());
    TGPAInnerHelper.a().c();
    b(Env.a());
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tgpa.service.TgpaInterProcessService
 * JD-Core Version:    0.7.0.1
 */