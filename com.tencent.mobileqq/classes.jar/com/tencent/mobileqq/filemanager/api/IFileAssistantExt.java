package com.tencent.mobileqq.filemanager.api;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import mqq.app.AppRuntime;

public abstract interface IFileAssistantExt
{
  public abstract int a();
  
  public abstract void a(Activity paramActivity, View paramView);
  
  public abstract void a(Activity paramActivity, BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean, BaseQQAppInterface paramBaseQQAppInterface, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public abstract void a(View paramView, int paramInt1, int paramInt2);
  
  public abstract void a(AppRuntime paramAppRuntime);
  
  public abstract void a(AppRuntime paramAppRuntime, Handler paramHandler);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IFileAssistantExt
 * JD-Core Version:    0.7.0.1
 */