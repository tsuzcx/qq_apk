package com.tencent.open.base.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class AvatarUpdateService
  implements HttpImageDownloadAsyncTask.TaskCompleteCallback
{
  private static AvatarUpdateService a;
  protected SharedPreferences a;
  protected HashMap<String, AvatarUpdateService.AvatarUpdateTask> a;
  
  protected AvatarUpdateService()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("uin_avatarurl", 0);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static AvatarUpdateService a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenBaseHttpAvatarUpdateService == null) {
        jdField_a_of_type_ComTencentOpenBaseHttpAvatarUpdateService = new AvatarUpdateService();
      }
      return jdField_a_of_type_ComTencentOpenBaseHttpAvatarUpdateService;
    }
    finally {}
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, HttpImageDownloadAsyncTask.TaskCompleteCallback paramTaskCompleteCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->updateAvatar--uin = ");
    ((StringBuilder)localObject).append(AuthorityUtil.a(paramString1));
    QLog.d("AvatarUpdateService", 1, ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://openmobile.qq.com/getface?appid=716027609&imgtype=3&encrytype=0&devtype=0&keytype=0&uin=");
    ((StringBuilder)localObject).append(paramString1);
    String str1 = ((StringBuilder)localObject).toString();
    String str2 = OpenSdkVirtualUtil.a(paramString1);
    for (localObject = paramString1; ((String)localObject).length() < 10; localObject = localStringBuilder.toString())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("0");
      localStringBuilder.append((String)localObject);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("o");
    localStringBuilder.append((String)localObject);
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("; skey=");
    localStringBuilder.append(paramString2);
    ThreadManager.post(new AvatarUpdateService.1(this, str1, localStringBuilder.toString(), paramString1, str2, paramContext, paramTaskCompleteCallback), 5, null, true);
  }
  
  protected void a(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap == null) {
      return;
    }
    paramString = BaseImageUtil.a(paramString);
    if (paramString == null) {
      return;
    }
    paramString = new FileOutputStream(paramString);
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramString);
    paramString.flush();
    paramString.close();
  }
  
  public void a(String paramString, Bitmap arg2)
  {
    Object localObject1;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localObject1 = (AvatarUpdateService.AvatarUpdateTask)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("-->onTaskCompleted--identifier = ");
        ((StringBuilder)???).append(paramString);
        ((StringBuilder)???).append(", bitmap = null ? ");
        boolean bool2 = true;
        boolean bool1;
        if (??? == null) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((StringBuilder)???).append(bool1);
        ((StringBuilder)???).append(", task = null ? ");
        if (localObject1 == null) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        ((StringBuilder)???).append(bool1);
        QLog.d("AvatarUpdateService", 2, ((StringBuilder)???).toString());
      }
      if (localObject1 == null) {
        return;
      }
      ??? = (Context)((AvatarUpdateService.AvatarUpdateTask)localObject1).jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((??? != null) && (??? != null))
      {
        ??? = AuthorityUtil.a((Context)???, ???, 63, 63);
        if (??? == null) {}
      }
    }
    try
    {
      a(???, ((AvatarUpdateService.AvatarUpdateTask)localObject1).jdField_b_of_type_JavaLangString);
      ??? = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      ((SharedPreferences.Editor)???).putString(((AvatarUpdateService.AvatarUpdateTask)localObject1).jdField_a_of_type_JavaLangString, ((AvatarUpdateService.AvatarUpdateTask)localObject1).c);
      ((SharedPreferences.Editor)???).commit();
      label213:
      localObject1 = (HttpImageDownloadAsyncTask.TaskCompleteCallback)((AvatarUpdateService.AvatarUpdateTask)localObject1).jdField_b_of_type_JavaLangRefWeakReference.get();
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarUpdateService", 2, "-->onTaskCompleted--callback not null, invoke it");
        }
        ((HttpImageDownloadAsyncTask.TaskCompleteCallback)localObject1).a(paramString, ???);
      }
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        return;
      }
      paramString = finally;
      throw paramString;
    }
    catch (IOException localIOException)
    {
      break label213;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.http.AvatarUpdateService
 * JD-Core Version:    0.7.0.1
 */