package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class ApolloLottieAnim
  implements Handler.Callback
{
  protected int a = 0;
  private boolean b = false;
  private boolean c = false;
  private String d;
  private String e;
  private boolean f;
  private WeakReferenceHandler g = new WeakReferenceHandler(paramContext.getMainLooper(), this);
  private WeakReference<Context> h;
  private WeakReference<DiniFlyAnimationView> i;
  private ApolloLottieAnim.DecoderRunnable j = new ApolloLottieAnim.DecoderRunnable();
  
  public ApolloLottieAnim(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.h = new WeakReference(paramContext);
  }
  
  private void a(File paramFile, String paramString)
  {
    if ((paramFile.exists()) && (!TextUtils.isEmpty(paramString))) {
      ZipUtils.unZipFile(paramFile, paramString);
    }
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    this.f = paramBoolean;
    if (!paramString2.equals(this.d))
    {
      this.d = paramString2;
      this.a = 0;
    }
    paramString2 = c(this.d);
    new File(paramString2).mkdirs();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloLottieAnim", 2, new Object[] { "setZipData mState:", Integer.valueOf(this.a), ",zipUrl:", paramString1, ",localZipPath:", this.d });
    }
    paramBoolean = a(paramString2);
    if (!paramBoolean)
    {
      QLog.w("ApolloLottieAnim", 1, "setZipData Lottie Anim data.json not exit");
      this.a = 0;
    }
    int k = this.a;
    if ((k != 2) && (k != 0))
    {
      if (k == 3) {
        a(false, null, paramString2);
      }
    }
    else
    {
      this.b = false;
      File localFile = new File(this.d);
      if (paramBoolean)
      {
        a(false, localFile, paramString2);
        return;
      }
      if (localFile.exists())
      {
        a(true, localFile, paramString2);
        return;
      }
      a(paramString1, this.d, paramString2);
    }
  }
  
  private void a(boolean paramBoolean, File paramFile, String paramString)
  {
    if (paramBoolean) {}
    try
    {
      a(paramFile, paramString);
      if (!a(paramString))
      {
        QLog.e("ApolloLottieAnim", 1, "Lottie Anim data.json not exit");
        return;
      }
      this.a = 3;
      b();
      b(paramString);
      return;
    }
    catch (Exception paramFile)
    {
      QLog.e("ApolloLottieAnim", 2, paramFile.getMessage());
      this.a = 2;
    }
  }
  
  private void b(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("folder", paramString);
    localMessage.setData(localBundle);
    this.g.sendMessage(localMessage);
  }
  
  private String c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int k = paramString.lastIndexOf(".zip");
      String str = paramString;
      if (k > 0) {
        str = paramString.substring(0, k);
      }
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(File.separator);
      return paramString.toString();
    }
    return "";
  }
  
  protected MQLruCache<String, Object> a()
  {
    return GlobalImageCache.a;
  }
  
  public void a(Context paramContext, @NonNull DiniFlyAnimationView paramDiniFlyAnimationView, String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLottieAnim", 2, new Object[] { "fromFileWithCacheBitmap animPathFolder:", paramString });
      }
      if (paramDiniFlyAnimationView.isAnimating()) {
        return;
      }
      if ((this.b) && (paramBoolean))
      {
        paramDiniFlyAnimationView.playAnimation();
        return;
      }
      try
      {
        ApolloLottieAnim.1 local1 = new ApolloLottieAnim.1(this, paramDiniFlyAnimationView, paramBoolean);
        Bundle localBundle = new Bundle();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("apollo://lottie_");
        if (TextUtils.isEmpty(this.e)) {
          localObject = paramString;
        } else {
          localObject = this.e;
        }
        localStringBuilder.append(Utils.Crc64String((String)localObject));
        localBundle.putString("key", localStringBuilder.toString());
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("images/");
        localBundle.putString("path", ((StringBuilder)localObject).toString());
        LottieComposition.Factory.fromInputStreamWithCacheBitmap(paramContext, paramInputStream, paramDiniFlyAnimationView.getLottieDrawable(), local1, localBundle, a());
        return;
      }
      catch (Exception paramContext)
      {
        paramDiniFlyAnimationView = new StringBuilder();
        paramDiniFlyAnimationView.append("playApolloGameBoxLottieAnim:");
        paramDiniFlyAnimationView.append(paramContext);
        QLog.e("ApolloLottieAnim", 1, paramDiniFlyAnimationView.toString());
      }
    }
  }
  
  public void a(Context paramContext, @NonNull DiniFlyAnimationView paramDiniFlyAnimationView, String paramString, boolean paramBoolean)
  {
    try
    {
      if (this.i == null) {
        this.i = new WeakReference(paramDiniFlyAnimationView);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("data.json");
      a(paramContext, paramDiniFlyAnimationView, paramString, new FileInputStream(localStringBuilder.toString()), paramBoolean);
      return;
    }
    catch (Exception paramContext)
    {
      paramDiniFlyAnimationView = new StringBuilder();
      paramDiniFlyAnimationView.append("fromFileWithCacheBitmap:");
      paramDiniFlyAnimationView.append(paramContext);
      QLog.e("ApolloLottieAnim", 1, paramDiniFlyAnimationView.toString());
    }
  }
  
  public void a(@NonNull DiniFlyAnimationView paramDiniFlyAnimationView, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    this.i = new WeakReference(paramDiniFlyAnimationView);
    this.e = paramString1;
    this.j.a(this, paramString1, paramString2, paramBoolean);
    ThreadManager.removeJobFromThreadPool(this.j, 16);
    ThreadManager.excute(this.j, 16, null, true);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    int m = 1;
    this.a = 1;
    DownloadTask localDownloadTask = new DownloadTask(paramString1, new File(paramString2));
    localDownloadTask.N = true;
    localDownloadTask.J = true;
    localDownloadTask.L = "apollo_lottie";
    localDownloadTask.e = 1;
    localDownloadTask.P = true;
    localDownloadTask.Q = true;
    localDownloadTask.a(new ApolloLottieAnim.2(this, paramString1, paramString2, paramString3));
    paramString1 = BaseApplicationImpl.getApplication();
    if (paramString1 != null)
    {
      paramString1 = paramString1.getRuntime();
      if ((paramString1 instanceof QQAppInterface))
      {
        paramString1 = (QQAppInterface)paramString1;
        break label110;
      }
    }
    paramString1 = null;
    label110:
    int k = m;
    if (paramString1 != null)
    {
      paramString1 = (DownloaderFactory)paramString1.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
      k = m;
      if (paramString1 != null)
      {
        paramString1 = paramString1.a(3);
        k = m;
        if (paramString1 != null)
        {
          paramString1.startDownload(localDownloadTask, localDownloadTask.a(), null);
          k = 0;
        }
      }
    }
    if (k != 0) {
      ThreadManager.executeOnNetWorkThread(new ApolloLottieAnim.3(this, localDownloadTask));
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadFinish，result:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" url:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" zipFile:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" folder:");
      localStringBuilder.append(paramString3);
      QLog.d("ApolloLottieAnim", 2, localStringBuilder.toString());
    }
    paramString1 = this.d;
    if ((paramString1 != null) && (!paramString1.equals(paramString2)))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("onDownloadFinish，zipFile unEqual mLocalZipPath:");
        paramString1.append(this.d);
        QLog.d("ApolloLottieAnim", 2, paramString1.toString());
      }
      return;
    }
    if (paramBoolean)
    {
      paramString1 = new File(paramString2);
      if (paramString1.exists())
      {
        a(true, paramString1, paramString3);
        return;
      }
      this.a = 2;
      return;
    }
    this.a = 2;
  }
  
  public boolean a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("data.json");
    return new File(localStringBuilder.toString()).exists();
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new ApolloLottieAnim.4(this));
    WeakReferenceHandler localWeakReferenceHandler = this.g;
    if (localWeakReferenceHandler != null) {
      localWeakReferenceHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      WeakReference localWeakReference = this.h;
      if ((localWeakReference != null) && (localWeakReference.get() != null))
      {
        localWeakReference = this.i;
        if ((localWeakReference != null) && (localWeakReference.get() != null))
        {
          paramMessage = paramMessage.getData().getString("folder");
          a((Context)this.h.get(), (DiniFlyAnimationView)this.i.get(), paramMessage, this.f);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ApolloLottieAnim
 * JD-Core Version:    0.7.0.1
 */