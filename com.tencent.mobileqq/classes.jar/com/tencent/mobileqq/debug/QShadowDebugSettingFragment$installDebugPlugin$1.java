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
    this.jdField_a_of_type_AndroidAppAlertDialog.dismiss();
    if (paramInt == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a((CharSequence)"插件正在运行，请重启手Q");
    }
    else
    {
      QQToast localQQToast = this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("插件安装失败: ");
      localStringBuilder.append(paramString);
      localQQToast.a((CharSequence)localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
  }
  
  public void onInstallFinish(@Nullable String paramString)
  {
    this.jdField_a_of_type_AndroidAppAlertDialog.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a((CharSequence)"插件安装成功！");
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
    paramString = (EditText)this.jdField_a_of_type_ComTencentMobileqqDebugQShadowDebugSettingFragment.a(R.id.pluginIdEditText);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "pluginIdEditText");
    paramString = paramString.getText().toString();
    Object localObject = (EditText)this.jdField_a_of_type_ComTencentMobileqqDebugQShadowDebugSettingFragment.a(R.id.pluginBranchEditText);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "pluginBranchEditText");
    localObject = ((EditText)localObject).getText().toString();
    QShadowDebugSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqDebugQShadowDebugSettingFragment, paramString, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.debug.QShadowDebugSettingFragment.installDebugPlugin.1
 * JD-Core Version:    0.7.0.1
 */