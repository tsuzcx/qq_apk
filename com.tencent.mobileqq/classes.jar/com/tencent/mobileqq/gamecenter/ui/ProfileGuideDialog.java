package com.tencent.mobileqq.gamecenter.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class ProfileGuideDialog
  extends ReportDialog
{
  private String a = "";
  
  public ProfileGuideDialog(Context paramContext)
  {
    this(paramContext, 2131953338);
  }
  
  public ProfileGuideDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a();
  }
  
  private void a()
  {
    super.getWindow().setWindowAnimations(2131951986);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.7F);
    }
  }
  
  private void b()
  {
    findViewById(2131447117).setOnClickListener(new ProfileGuideDialog.1(this));
  }
  
  public ProfileGuideDialog a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.a = str;
    return this;
  }
  
  public void dismiss()
  {
    try
    {
      if (isShowing())
      {
        super.dismiss();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dismiss e:");
      localStringBuilder.append(localThrowable);
      QLog.e("ProfileGuideDialog", 1, localStringBuilder.toString());
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2131624097);
    b();
    setCancelable(false);
    setCanceledOnTouchOutside(false);
  }
  
  public void show()
  {
    super.show();
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.a, "1", "145", "920", "92005", "208813", "", "", "8", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.ui.ProfileGuideDialog
 * JD-Core Version:    0.7.0.1
 */