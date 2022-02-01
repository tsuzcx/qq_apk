package com.tencent.mobileqq.studyroom.utils;

import android.os.Handler;
import com.tencent.mobileqq.qroute.module.IQRoutePluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$installPlugin$3", "Lcom/tencent/mobileqq/qroute/module/IQRoutePluginInstallListener;", "onInstallBegin", "", "var1", "", "onInstallDownloadProgress", "progress", "", "total", "onInstallError", "var2", "onInstallFinish", "qqstudyroom_impl_release"}, k=1, mv={1, 1, 16})
public final class StudyRoomQShadowLauncher$installPlugin$3
  implements IQRoutePluginInstallListener
{
  StudyRoomQShadowLauncher$installPlugin$3(Ref.ObjectRef paramObjectRef, CountDownLatch paramCountDownLatch) {}
  
  public void onInstallBegin(@Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInstallBegin ");
    localStringBuilder.append(paramString);
    QLog.i("studyroom.QShadowLauncher", 1, localStringBuilder.toString());
  }
  
  public void onInstallDownloadProgress(@Nullable String paramString, int paramInt1, int paramInt2)
  {
    StudyRoomQShadowLauncher.a(this.jdField_a_of_type_ComTencentMobileqqStudyroomUtilsStudyRoomQShadowLauncher).post((Runnable)new StudyRoomQShadowLauncher.installPlugin.3.onInstallDownloadProgress.1(this, paramInt1, paramInt2));
  }
  
  public void onInstallError(@Nullable String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInstallError ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt);
    QLog.i("studyroom.QShadowLauncher", 1, localStringBuilder.toString());
    this.jdField_a_of_type_KotlinJvmInternalRef$ObjectRef.element = Boolean.valueOf(false);
    StudyRoomQShadowLauncher.a(this.jdField_a_of_type_ComTencentMobileqqStudyroomUtilsStudyRoomQShadowLauncher, 4, "加载失败，请重试!", "请检查网络设置后重试", "重新加载", null, 16, null);
    StudyRoomQShadowLauncher.a(this.jdField_a_of_type_ComTencentMobileqqStudyroomUtilsStudyRoomQShadowLauncher, 3);
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
  
  public void onInstallFinish(@Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInstallFinish ");
    localStringBuilder.append(paramString);
    QLog.i("studyroom.QShadowLauncher", 1, localStringBuilder.toString());
    this.jdField_a_of_type_KotlinJvmInternalRef$ObjectRef.element = Boolean.valueOf(true);
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.StudyRoomQShadowLauncher.installPlugin.3
 * JD-Core Version:    0.7.0.1
 */