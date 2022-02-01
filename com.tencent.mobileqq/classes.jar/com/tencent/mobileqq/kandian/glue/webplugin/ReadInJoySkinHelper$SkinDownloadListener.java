package com.tencent.mobileqq.kandian.glue.webplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class ReadInJoySkinHelper$SkinDownloadListener
  extends DownloadListener
{
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<TroopMemberApiService> jdField_a_of_type_JavaLangRefWeakReference;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public ReadInJoySkinHelper$SkinDownloadListener(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle, TroopMemberApiService paramTroopMemberApiService)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTroopMemberApiService);
  }
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    super.onCancel(paramDownloadTask);
    Object localObject = paramDownloadTask.a().getString("resId");
    paramDownloadTask = (TroopMemberApiService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_JavaLangString))
    {
      ((ReadInJoySkinManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).b(this);
      if (paramDownloadTask != null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("seq", this.jdField_a_of_type_AndroidOsBundle.getInt("seq"));
        ((Bundle)localObject).putInt("retCode", -1);
        ((Bundle)localObject).putString("skinId", this.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject).putInt("rate", 0);
        paramDownloadTask.a(107, (Bundle)localObject);
        if (QLog.isDebugVersion())
        {
          paramDownloadTask = new StringBuilder();
          paramDownloadTask.append("onCancel rsp:");
          paramDownloadTask.append(((Bundle)localObject).toString());
          QLog.d("ReadInJoySkinHelper", 4, paramDownloadTask.toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "SkinDownloadListener onCancel");
    }
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Object localObject = paramDownloadTask.a().getString("resId");
    TroopMemberApiService localTroopMemberApiService = (TroopMemberApiService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_JavaLangString))
    {
      ((ReadInJoySkinManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).b(this);
      if (localTroopMemberApiService != null)
      {
        localObject = new Bundle();
        if (paramDownloadTask.jdField_a_of_type_Int == 0)
        {
          ((Bundle)localObject).putInt("seq", this.jdField_a_of_type_AndroidOsBundle.getInt("seq"));
          ((Bundle)localObject).putInt("retCode", 0);
          ((Bundle)localObject).putString("skinId", this.jdField_a_of_type_JavaLangString);
          ((Bundle)localObject).putInt("rate", 100);
          localTroopMemberApiService.a(107, (Bundle)localObject);
        }
        else
        {
          ((Bundle)localObject).putInt("seq", this.jdField_a_of_type_AndroidOsBundle.getInt("seq"));
          ((Bundle)localObject).putInt("retCode", paramDownloadTask.jdField_a_of_type_Int);
          ((Bundle)localObject).putString("skinId", this.jdField_a_of_type_JavaLangString);
          ((Bundle)localObject).putInt("rate", 0);
          localTroopMemberApiService.a(107, (Bundle)localObject);
        }
        if (QLog.isDebugVersion())
        {
          paramDownloadTask = new StringBuilder();
          paramDownloadTask.append("onDone rsp:");
          paramDownloadTask.append(((Bundle)localObject).toString());
          QLog.d("ReadInJoySkinHelper", 4, paramDownloadTask.toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "SkinDownloadListener onDone");
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    super.onProgress(paramDownloadTask);
    Object localObject = paramDownloadTask.a().getString("resId");
    TroopMemberApiService localTroopMemberApiService = (TroopMemberApiService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_JavaLangString)) && (localTroopMemberApiService != null))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("seq", this.jdField_a_of_type_AndroidOsBundle.getInt("seq"));
      ((Bundle)localObject).putInt("retCode", 0);
      ((Bundle)localObject).putString("skinId", this.jdField_a_of_type_JavaLangString);
      int i = (int)(paramDownloadTask.b * 100L / paramDownloadTask.jdField_a_of_type_Long);
      ((Bundle)localObject).putInt("rate", i);
      if (i != 100) {
        localTroopMemberApiService.a(107, (Bundle)localObject);
      }
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.ReadInJoySkinHelper.SkinDownloadListener
 * JD-Core Version:    0.7.0.1
 */