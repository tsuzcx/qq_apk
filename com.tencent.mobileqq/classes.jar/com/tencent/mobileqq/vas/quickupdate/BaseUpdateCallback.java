package com.tencent.mobileqq.vas.quickupdate;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.mobileqq.vas.updatesystem.callback.TagItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class BaseUpdateCallback
  implements QuickUpdateBusinessCallback, QuickUpdateListener
{
  private static final int ERROR_NULL_APP = 10087;
  private static final int ERROR_WRONG_APP = 10088;
  private static final int ERROR_X86 = 10086;
  private static final String TAG = "BaseUpdateCallback";
  private static ListenerMap<QuickUpdateListener> listeners = new ListenerMap();
  private static ListenerMap<WeakReference<QuickUpdateListener>> weakListeners = new ListenerMap();
  
  private static String getKey(long paramLong, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return paramLong + "_" + paramString1;
    }
    return paramLong + "_" + paramString2;
  }
  
  private boolean isDefaultSc(String paramString)
  {
    String str = getScidPrefix();
    return (!TextUtils.isEmpty(str)) && (paramString.startsWith(str));
  }
  
  public boolean canUpdate(long paramLong, String paramString1, String paramString2)
  {
    return true;
  }
  
  public void cleanCache(Context paramContext)
  {
    if (!TextUtils.isEmpty(getRootDir())) {
      VasUpdateUtil.a(new File(paramContext.getFilesDir() + File.separator + getRootDir()));
    }
  }
  
  public boolean deleteFiles(long paramLong, String paramString)
  {
    if (isDefaultSc(paramString)) {
      return VasUpdateUtil.a(new File(getDir(MobileQQ.getContext(), paramString)));
    }
    return false;
  }
  
  public void doOnCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((isZip_KeepZip()) && (paramInt1 == 0) && (isDefaultSc(paramString1)))
    {
      paramString2 = getDir(MobileQQ.getContext(), paramString1);
      paramString1 = getSavePath(MobileQQ.getContext(), paramString1);
    }
    try
    {
      FileUtils.a(paramString1, paramString2, false);
      return;
    }
    catch (IOException paramString1)
    {
      QLog.e("BaseUpdateCallback", 1, "_onCompleted: ", paramString1);
    }
  }
  
  public void doOnProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
  
  public void download(int paramInt, QuickUpdateListener paramQuickUpdateListener, boolean paramBoolean)
  {
    download(getScid(paramInt), paramQuickUpdateListener, paramBoolean);
  }
  
  public void download(long paramLong, String paramString, QuickUpdateListener paramQuickUpdateListener, boolean paramBoolean)
  {
    String str;
    if (paramQuickUpdateListener != null)
    {
      str = getKey(paramLong, paramString, "");
      if (!paramBoolean) {
        break label106;
      }
      weakListeners.a(str, new WeakReference(paramQuickUpdateListener));
    }
    for (;;)
    {
      QLog.e("BaseUpdateCallback", 1, "download: " + paramLong + "_" + paramString + ", " + paramQuickUpdateListener);
      ((IVasQuickUpdateService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(paramLong, paramString, "BaseUpdateCallback");
      return;
      label106:
      listeners.a(str, paramQuickUpdateListener);
    }
  }
  
  public void download(String paramString)
  {
    download(paramString, null, false);
  }
  
  public void download(String paramString, QuickUpdateListener paramQuickUpdateListener, boolean paramBoolean)
  {
    download(getBID(), paramString, paramQuickUpdateListener, paramBoolean);
  }
  
  public abstract long getBID();
  
  public String getDir(Context paramContext, String paramString)
  {
    return new File(paramContext.getFilesDir() + File.separator + getRootDir(), paramString).getAbsolutePath();
  }
  
  public int getId(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString.substring(getScidPrefix().length()));
      return i;
    }
    catch (Exception localException)
    {
      QLog.e("BaseUpdateCallback", 1, "getId error scid: " + paramString, localException);
    }
    return 0;
  }
  
  public TagItemInfo getItemInfo(long paramLong, String paramString)
  {
    if (isDefaultSc(paramString))
    {
      TagItemInfo localTagItemInfo = new TagItemInfo();
      localTagItemInfo.jdField_a_of_type_Boolean = false;
      localTagItemInfo.b = false;
      localTagItemInfo.jdField_a_of_type_JavaLangString = getSavePath(MobileQQ.getContext(), paramString);
      return localTagItemInfo;
    }
    return null;
  }
  
  protected String getRootDir()
  {
    return "";
  }
  
  public String getSavePath(Context paramContext, String paramString)
  {
    String str = getDir(paramContext, paramString);
    paramContext = str;
    if (isZip_KeepZip()) {
      paramContext = str + File.separator + paramString + ".zip";
    }
    return paramContext;
  }
  
  public String getScid(int paramInt)
  {
    return getScidPrefix() + paramInt;
  }
  
  protected String getScidPrefix()
  {
    return "";
  }
  
  public boolean isFileExists(long paramLong, String paramString)
  {
    if (isDefaultSc(paramString)) {
      return new File(getSavePath(MobileQQ.getContext(), paramString)).exists();
    }
    return false;
  }
  
  protected boolean isZip_KeepZip()
  {
    return true;
  }
  
  public final void onCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    doOnCompleted(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
    Object localObject1 = getItemInfo(paramLong, paramString1);
    if (localObject1 == null) {
      QLog.e("BaseUpdateCallback", 1, "onComplete getItemInfo failed: " + paramLong + "_" + paramString1);
    }
    boolean bool;
    int i;
    label82:
    Object localObject2;
    if (localObject1 == null)
    {
      bool = false;
      if ((bool) && (paramInt1 == 0)) {
        break label163;
      }
      i = 1;
      localObject2 = getKey(paramLong, paramString1, paramString2);
      if (i == 0) {
        break label169;
      }
    }
    label163:
    label169:
    for (localObject1 = listeners.b((String)localObject2);; localObject1 = listeners.a((String)localObject2))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((QuickUpdateListener)((Iterator)localObject1).next()).onCompleted(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      }
      bool = ((TagItemInfo)localObject1).jdField_a_of_type_Boolean;
      break;
      i = 0;
      break label82;
    }
    if (i != 0) {}
    for (localObject1 = weakListeners.b((String)localObject2);; localObject1 = weakListeners.a((String)localObject2))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (QuickUpdateListener)((WeakReference)((Iterator)localObject1).next()).get();
        if (localObject2 != null) {
          ((QuickUpdateListener)localObject2).onCompleted(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
        }
      }
    }
  }
  
  public final void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    Object localObject1 = getItemInfo(paramLong1, paramString1);
    if (localObject1 == null) {
      QLog.e("BaseUpdateCallback", 1, "onProgress getItemInfo failed: " + paramLong1 + "_" + paramString1);
    }
    if (localObject1 == null) {}
    Object localObject2;
    for (boolean bool = false;; bool = ((TagItemInfo)localObject1).jdField_a_of_type_Boolean)
    {
      localObject1 = getKey(paramLong1, paramString1, paramString2);
      if (bool) {
        return;
      }
      doOnProgress(paramLong1, paramString1, paramString2, paramLong2, paramLong3);
      localObject2 = listeners.a((String)localObject1).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((QuickUpdateListener)((Iterator)localObject2).next()).onProgress(paramLong1, paramString1, paramString2, paramLong2, paramLong3);
      }
    }
    localObject1 = weakListeners.a((String)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (QuickUpdateListener)((WeakReference)((Iterator)localObject1).next()).get();
      if (localObject2 != null) {
        ((QuickUpdateListener)localObject2).onProgress(paramLong1, paramString1, paramString2, paramLong2, paramLong3);
      }
    }
  }
  
  public void removeListener(long paramLong, String paramString, QuickUpdateListener paramQuickUpdateListener)
  {
    paramString = getKey(paramLong, paramString, "");
    listeners.a(paramString, paramQuickUpdateListener, false);
    weakListeners.a(paramString, paramQuickUpdateListener, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback
 * JD-Core Version:    0.7.0.1
 */