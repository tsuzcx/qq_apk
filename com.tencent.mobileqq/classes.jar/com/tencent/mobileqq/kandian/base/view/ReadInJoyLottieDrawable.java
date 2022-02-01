package com.tencent.mobileqq.kandian.base.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

public class ReadInJoyLottieDrawable
  extends LottieDrawable
{
  private static LruCache<String, Bitmap> jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(5242880);
  private static final String jdField_a_of_type_JavaLangString;
  private static LruCache<String, LottieComposition> jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(1048576);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private boolean jdField_a_of_type_Boolean = true;
  private boolean jdField_b_of_type_Boolean = true;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".readInjoy/resource/lottie_background_res");
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  private static long a(String paramString)
  {
    long l = 0L;
    int i = 0;
    while (i < paramString.length())
    {
      l = (l + paramString.charAt(i)) * 131L % 53497342331L;
      i += 1;
    }
    return l;
  }
  
  public static ReadInJoyLottieDrawable a(String paramString)
  {
    ReadInJoyLottieDrawable localReadInJoyLottieDrawable = new ReadInJoyLottieDrawable();
    long l = a(paramString);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append(l);
    String str = ((StringBuilder)localObject1).toString();
    localObject1 = new File(str);
    if (a((File)localObject1))
    {
      localReadInJoyLottieDrawable.a((File)localObject1);
      return localReadInJoyLottieDrawable;
    }
    Object localObject2 = (DownloaderFactory)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.DOWNLOADER_FACTORY);
    boolean bool = true;
    localObject2 = ((DownloaderFactory)localObject2).a(1);
    Object localObject3 = new File(jdField_a_of_type_JavaLangString);
    if (!((File)localObject3).exists()) {
      bool = ((File)localObject3).mkdirs();
    }
    if (bool)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(str);
      ((StringBuilder)localObject3).append(".zip");
      str = ((StringBuilder)localObject3).toString();
      localObject3 = new File(str);
      paramString = new DownloadTask(paramString, (File)localObject3);
      paramString.b = 3;
      paramString.d = 60L;
      Bundle localBundle = new Bundle();
      localBundle.putLong("bgLottieResId", l);
      localBundle.putString("bgLottieResPath", str);
      ((DownloaderInterface)localObject2).startDownload(paramString, new ReadInJoyLottieDrawable.5(l, str, (File)localObject3, (File)localObject1, new WeakReference(localReadInJoyLottieDrawable)), localBundle);
    }
    return localReadInJoyLottieDrawable;
  }
  
  @Nullable
  private File a(File[] paramArrayOfFile, String paramString)
  {
    int j = paramArrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = paramArrayOfFile[i];
      if (localFile.getName().equals(paramString)) {
        return localFile;
      }
      i += 1;
    }
    return null;
  }
  
  private void a(File paramFile)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("loadLottieAnimation ");
      ((StringBuilder)localObject1).append(paramFile.getName());
      QLog.e("ReadInJoyLottieDrawable", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = paramFile.listFiles(new ReadInJoyLottieDrawable.1(this));
    Object localObject2 = paramFile.listFiles(new ReadInJoyLottieDrawable.2(this));
    if ((localObject1 != null) && (localObject2 != null))
    {
      if (localObject2.length == 0) {
        return;
      }
      localObject2 = new ReadInJoyLottieDrawable.3(this, paramFile, (File[])localObject2);
      if (localObject1.length > 0)
      {
        if ((LottieComposition)jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramFile.getAbsolutePath()) == null)
        {
          ThreadManager.excute(new ReadInJoyLottieDrawable.4(this, (File[])localObject1, paramFile, (Runnable)localObject2), 64, null, true);
          return;
        }
        ((Runnable)localObject2).run();
      }
    }
  }
  
  private static boolean a(File paramFile)
  {
    boolean bool3 = paramFile.exists();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramFile = paramFile.listFiles(new ReadInJoyLottieDrawable.6());
      bool1 = bool2;
      if (paramFile != null)
      {
        bool1 = bool2;
        if (paramFile.length > 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void playAnimation()
  {
    super.playAnimation();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLottieDrawable", 2, "playAnimation: ");
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (this.jdField_a_of_type_Boolean)) {
      cancelAnimation();
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void start()
  {
    super.start();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLottieDrawable", 2, "start: ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.ReadInJoyLottieDrawable
 * JD-Core Version:    0.7.0.1
 */