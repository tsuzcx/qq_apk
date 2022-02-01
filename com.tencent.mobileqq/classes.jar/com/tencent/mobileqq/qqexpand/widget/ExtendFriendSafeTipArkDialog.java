package com.tencent.mobileqq.qqexpand.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkAppInfo.Size;
import com.tencent.ark.open.ArkView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import org.json.JSONException;
import org.json.JSONObject;

public class ExtendFriendSafeTipArkDialog
  extends ReportDialog
{
  private ArkView a;
  
  public ExtendFriendSafeTipArkDialog(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    super.getWindow().setWindowAnimations(2131951986);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
  }
  
  public static View a(ArkView paramArkView, ArkViewImplement.LoadCallback paramLoadCallback, int paramInt)
  {
    int i = ViewUtils.getScreenWidth();
    Object localObject1 = new ArkAppInfo.Size(i, (int)(i / 0.641921F));
    paramArkView.setSize((ArkAppInfo.Size)localObject1, (ArkAppInfo.Size)localObject1, (ArkAppInfo.Size)localObject1);
    paramArkView.setBorderType(1);
    localObject1 = new JSONObject();
    Object localObject2 = new JSONObject();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      ((JSONObject)localObject2).put("matchSrc", localStringBuilder.toString());
      ((JSONObject)localObject1).put("metadata", localObject2);
    }
    catch (JSONException localJSONException)
    {
      label104:
      break label104;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("metaObject transform json failed! ");
    ((StringBuilder)localObject2).append(paramInt);
    QLog.e("ExtendFriendArkDialog", 1, ((StringBuilder)localObject2).toString());
    paramArkView.load("com.tencent.mobileqq.expand.aiosafe", "expand_aio_safetip", "1.0.0.0", ((JSONObject)localObject1).toString(), "", paramLoadCallback);
    return paramArkView;
  }
  
  private void e()
  {
    getWindow().getDecorView().setPadding(0, 0, 0, 0);
  }
  
  public void a()
  {
    try
    {
      getWindow().setFlags(16777216, 16777216);
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendArkDialog", 1, localException.getMessage());
    }
    super.setContentView(2131627415);
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131428766);
    if (this.a == null)
    {
      QLog.w("ExtendFriendArkDialog", 1, "arkView is null!");
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localFrameLayout.addView(this.a, localLayoutParams);
    this.a.setVisibility(0);
  }
  
  public void a(ArkView paramArkView)
  {
    this.a = paramArkView;
  }
  
  public void b()
  {
    ArkView localArkView = this.a;
    if (localArkView != null) {
      localArkView.onResume();
    }
  }
  
  public void c()
  {
    ArkView localArkView = this.a;
    if (localArkView != null) {
      localArkView.onPause();
    }
  }
  
  public void d()
  {
    ArkView localArkView = this.a;
    if (localArkView != null)
    {
      localArkView.onDestroy();
      this.a = null;
    }
  }
  
  public void dismiss()
  {
    if (isShowing())
    {
      ArkView localArkView = this.a;
      if (localArkView != null)
      {
        localArkView.onPause();
        this.a.onDestroy();
        this.a = null;
      }
      super.dismiss();
    }
  }
  
  public void show()
  {
    super.show();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendSafeTipArkDialog
 * JD-Core Version:    0.7.0.1
 */