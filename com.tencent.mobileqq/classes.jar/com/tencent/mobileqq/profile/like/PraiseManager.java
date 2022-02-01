package com.tencent.mobileqq.profile.like;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class PraiseManager
  implements Manager
{
  public QQAppInterface a;
  public Context b;
  public QQLruCache<Integer, PraiseInfo> c;
  public final List<WeakReference<PraiseManager.OnPraiseLoadListener>> d;
  public final Vector<Integer> e;
  public final List<String> f;
  
  public PraiseManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = paramQQAppInterface.getApp().getApplicationContext();
    this.c = new QQLruCache(2007, 21, 120000);
    this.e = new Vector();
    this.d = new ArrayList(3);
    this.f = new ArrayList();
  }
  
  public static int a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return 0;
    }
    SharedPreferences localSharedPreferences = paramAppInterface.getApplication().getSharedPreferences("VipPersonalLike", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ProfilePersonalLikeCurrentId_");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("VipPersonalLike", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ProfilePersonalLikeCurrentId_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), paramInt).commit();
  }
  
  public PraiseInfo a(int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramInt <= 0) {
      return null;
    }
    Object localObject = (PraiseInfo)this.c.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get praise info from cache, id=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" from:");
        localStringBuilder.append(paramString);
        QLog.d("PraiseManager", 2, localStringBuilder.toString());
      }
      return localObject;
    }
    if (!this.e.contains(Integer.valueOf(paramInt)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("start create praise info, id=");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("PraiseManager", 2, ((StringBuilder)localObject).toString());
      }
      this.e.add(Integer.valueOf(paramInt));
      ThreadManager.executeOnFileThread(new PraiseManager.1(this, paramInt, paramBoolean, paramString));
    }
    return null;
  }
  
  public File a(int paramInt)
  {
    File localFile = new File(new File(this.b.getFilesDir(), "praise_info"), String.valueOf(paramInt));
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      return;
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("praise.android.");
    ((StringBuilder)???).append(paramInt);
    ((StringBuilder)???).append(".");
    ((StringBuilder)???).append("config.zip");
    String str = ((StringBuilder)???).toString();
    IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)this.a.getRuntimeService(IVasQuickUpdateService.class, "");
    if (localIVasQuickUpdateService != null) {
      synchronized (this.f)
      {
        if (this.f.contains(str))
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append(str);
            paramString.append(" is downloading, remove duplicate download.");
            QLog.d("PraiseManager", 2, paramString.toString());
          }
          return;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append(" is not download, start download.");
          QLog.d("PraiseManager", 2, localStringBuilder.toString());
        }
        this.f.add(str);
        localIVasQuickUpdateService.downloadItem(20L, str, paramString);
        return;
      }
    }
  }
  
  public void a(PraiseManager.OnPraiseLoadListener paramOnPraiseLoadListener)
  {
    synchronized (this.d)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() == paramOnPraiseLoadListener)) {
          return;
        }
      }
      this.d.add(new WeakReference(paramOnPraiseLoadListener));
      return;
    }
    for (;;)
    {
      throw paramOnPraiseLoadListener;
    }
  }
  
  public void a(String paramString1, String arg2, String paramString3, int paramInt1, int paramInt2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("PraiseManager", 2, String.format("onDownloadComplete, scid %s, errorcode %d", new Object[] { paramString1, Integer.valueOf(paramInt1) }));
      }
      if (!TextUtils.isEmpty(paramString1))
      {
        if (!paramString1.startsWith("praise.android.")) {
          return;
        }
        paramInt2 = b(paramString1);
        synchronized (this.f)
        {
          StringBuilder localStringBuilder;
          if (this.f.contains(paramString1))
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramString1);
              localStringBuilder.append(" download completed, remove from download queue.");
              QLog.d("PraiseManager", 2, localStringBuilder.toString());
            }
            this.f.remove(paramString1);
          }
          if (paramInt1 == 0)
          {
            paramString1 = a(paramInt2).getAbsolutePath();
            ??? = AIOUtils.a();
            ???.append(paramString1);
            ???.append(File.separator);
            ???.append("config.json");
            ??? = PraiseInfo.a(paramInt2, ???.toString());
            if (??? != null)
            {
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("createPraiseInfo after download complete, id=");
                localStringBuilder.append(paramInt2);
                QLog.d("PraiseManager", 2, localStringBuilder.toString());
              }
              localStringBuilder = AIOUtils.a();
              localStringBuilder.append(paramString1);
              localStringBuilder.append(File.separator);
              localStringBuilder.append("whiteBlackImg.png");
              ???.e = localStringBuilder.toString();
              localStringBuilder = AIOUtils.a();
              localStringBuilder.append(paramString1);
              localStringBuilder.append(File.separator);
              localStringBuilder.append("colorImg.png");
              ???.g = localStringBuilder.toString();
              localStringBuilder = AIOUtils.a();
              localStringBuilder.append(paramString1);
              localStringBuilder.append(File.separator);
              localStringBuilder.append("goldImg.png");
              ???.i = localStringBuilder.toString();
              if ((b(???)) && (a(???))) {
                this.c.put(Integer.valueOf(paramInt2), ???);
              }
            }
          }
          this.a.runOnUiThread(new PraiseManager.LoadCallback(this, paramInt2, 1, paramString3));
          this.e.removeElement(Integer.valueOf(paramInt2));
          return;
        }
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("PraiseManager", 1, "onDownloadComplete: ", paramString1);
    }
  }
  
  boolean a(PraiseInfo paramPraiseInfo)
  {
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inDensity = 320;
    ((BitmapFactory.Options)localObject1).inTargetDensity = this.b.getResources().getDisplayMetrics().densityDpi;
    Object localObject2 = BubbleManager.a(paramPraiseInfo.e, (BitmapFactory.Options)localObject1);
    if (localObject2 == null) {
      return false;
    }
    paramPraiseInfo.f = ((Bitmap)localObject2);
    localObject2 = BubbleManager.a(paramPraiseInfo.g, (BitmapFactory.Options)localObject1);
    if (localObject2 == null) {
      return false;
    }
    paramPraiseInfo.h = ((Bitmap)localObject2);
    paramPraiseInfo.j = BubbleManager.a(paramPraiseInfo.i, (BitmapFactory.Options)localObject1);
    localObject1 = a(paramPraiseInfo.a).getAbsolutePath();
    localObject2 = AIOUtils.a();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("dynamicImg.png");
    localObject2 = ((StringBuilder)localObject2).toString();
    if (new File((String)localObject2).exists()) {
      paramPraiseInfo.k = ((String)localObject2);
    }
    localObject2 = AIOUtils.a();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("goldDynamicImg.png");
    localObject1 = ((StringBuilder)localObject2).toString();
    if (new File((String)localObject1).exists()) {
      paramPraiseInfo.l = ((String)localObject1);
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scid isFileExists: ");
      localStringBuilder.append(paramString);
      QLog.i("PraiseManager", 2, localStringBuilder.toString());
    }
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      if (!paramString.startsWith("praise.android.")) {
        return false;
      }
      int i = b(paramString);
      bool1 = bool2;
      if (i > 0)
      {
        paramString = a(i);
        bool1 = bool2;
        if (new File(paramString, "config.json").exists())
        {
          bool1 = bool2;
          if (new File(paramString, "whiteBlackImg.png").exists())
          {
            bool1 = bool2;
            if (new File(paramString, "colorImg.png").exists()) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean a(Set<Integer> paramSet, PraiseManager.OnPraiseLoadListener paramOnPraiseLoadListener)
  {
    boolean bool = true;
    if (paramSet != null)
    {
      if (paramSet.isEmpty()) {
        return true;
      }
      PraiseManager.PraiseLoadListener localPraiseLoadListener = new PraiseManager.PraiseLoadListener(this);
      localPraiseLoadListener.b = paramSet.size();
      localPraiseLoadListener.c = paramOnPraiseLoadListener;
      paramOnPraiseLoadListener = paramSet.iterator();
      while (paramOnPraiseLoadListener.hasNext())
      {
        int i = ((Integer)paramOnPraiseLoadListener.next()).intValue();
        if (this.c.get(Integer.valueOf(i)) == null)
        {
          a(localPraiseLoadListener);
          a(i, true, "from_load_all");
        }
        else
        {
          localPraiseLoadListener.a += 1;
        }
      }
      if (localPraiseLoadListener.a == paramSet.size()) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public int b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("\\.");
      if (paramString.length == 5)
      {
        paramString = paramString[2];
        try
        {
          int i = Integer.parseInt(paramString);
          return i;
        }
        catch (NumberFormatException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PraiseManager", 2, "getBubbleIdFromScid: parse bubbleId error", paramString);
          }
        }
      }
    }
    return 0;
  }
  
  void b(int paramInt, boolean paramBoolean, String paramString)
  {
    String str = a(paramInt).getAbsolutePath();
    Object localObject = AIOUtils.a();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("config.json");
    PraiseInfo localPraiseInfo = PraiseInfo.a(paramInt, ((StringBuilder)localObject).toString());
    localObject = Boolean.valueOf(false);
    if (localPraiseInfo != null)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("createPraiseInfo from local, id=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" from:");
        localStringBuilder.append(paramString);
        QLog.d("PraiseManager", 2, localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = AIOUtils.a();
      localStringBuilder.append(str);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("whiteBlackImg.png");
      localPraiseInfo.e = localStringBuilder.toString();
      localStringBuilder = AIOUtils.a();
      localStringBuilder.append(str);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("colorImg.png");
      localPraiseInfo.g = localStringBuilder.toString();
      localStringBuilder = AIOUtils.a();
      localStringBuilder.append(str);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("goldImg.png");
      localPraiseInfo.i = localStringBuilder.toString();
      if (!b(localPraiseInfo))
      {
        if (!paramBoolean) {
          break label310;
        }
        a(paramInt, paramString);
      }
      else
      {
        if (!a(localPraiseInfo)) {
          break label310;
        }
        this.c.put(Integer.valueOf(paramInt), localPraiseInfo);
        localObject = Boolean.valueOf(true);
        break label310;
      }
    }
    else
    {
      if (!paramBoolean) {
        break label310;
      }
      a(paramInt, paramString);
    }
    localObject = null;
    label310:
    if (localObject != null)
    {
      this.a.runOnUiThread(new PraiseManager.LoadCallback(this, paramInt, 0, paramString));
      this.e.removeElement(Integer.valueOf(paramInt));
    }
  }
  
  public void b(PraiseManager.OnPraiseLoadListener paramOnPraiseLoadListener)
  {
    List localList = this.d;
    Object localObject = null;
    try
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() == paramOnPraiseLoadListener)) {
          localObject = localWeakReference;
        }
      }
      this.d.remove(localObject);
      return;
    }
    finally {}
    for (;;)
    {
      throw paramOnPraiseLoadListener;
    }
  }
  
  boolean b(PraiseInfo paramPraiseInfo)
  {
    return (new File(paramPraiseInfo.e).exists()) && (new File(paramPraiseInfo.g).exists());
  }
  
  public void onDestroy()
  {
    this.c.evictAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.like.PraiseManager
 * JD-Core Version:    0.7.0.1
 */