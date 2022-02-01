package com.tencent.mobileqq.debug;

import android.app.AlertDialog;
import android.os.IBinder;
import android.widget.EditText;
import com.tencent.mobileqq.R.id;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/debug/QShadowDebugSettingFragment$installDebugPlugin$1", "Lcom/tencent/mobileqq/pluginsdk/OnPluginInstallListener;", "asBinder", "Landroid/os/IBinder;", "onInstallBegin", "", "p0", "", "onInstallDownloadProgress", "p1", "", "p2", "onInstallError", "onInstallFinish", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QShadowDebugSettingFragment$installDebugPlugin$1
  implements OnPluginInstallListener
{
  QShadowDebugSettingFragment$installDebugPlugin$1(AlertDialog paramAlertDialog, QQToast paramQQToast) {}
  
  @Nullable
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(@Nullable String paramString) {}
  
  public void onInstallDownloadProgress(@Nullable String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(@Nullable String paramString, int paramInt)
  {
    this.b.dismiss();
    if (paramInt == 2)
    {
      this.c.setToastMsg((CharSequence)"插件正在运行，请重启手Q");
    }
    else
    {
      QQToast localQQToast = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("插件安装失败: ");
      localStringBuilder.append(paramString);
      localQQToast.setToastMsg((CharSequence)localStringBuilder.toString());
    }
    this.c.show();
  }
  
  public void onInstallFinish(@Nullable String paramString)
  {
    this.b.dismiss();
    this.c.setToastMsg((CharSequence)"插件安装成功！");
    this.c.show();
    paramString = (EditText)this.a.a(R.id.pluginIdEditText);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "pluginIdEditText");
    paramString = paramString.getText().toString();
    Object localObject = (EditText)this.a.a(R.id.pluginBranchEditText);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "pluginBranchEditText");
    localObject = ((EditText)localObject).getText().toString();
    QShadowDebugSettingFragment.a(this.a, paramString, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.debug.QShadowDebugSettingFragment.installDebugPlugin.1
 * JD-Core Version:    0.7.0.1
 */