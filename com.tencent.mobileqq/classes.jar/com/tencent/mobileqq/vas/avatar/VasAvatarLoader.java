package com.tencent.mobileqq.vas.avatar;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.lang.ref.WeakReference;
import java.net.URL;
import mqq.os.MqqHandler;

public class VasAvatarLoader
  implements VasManager.CompleteListener<String>
{
  private static IdleGetDynamic i = new IdleGetDynamic();
  private static final Drawable j = new ColorDrawable(16777215);
  public int a;
  public String b;
  public long c;
  public String d;
  public int e;
  public boolean f;
  public Drawable g = j;
  public WeakReference<VasAvatar> h;
  
  public VasAvatarLoader(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.f = paramBoolean;
    this.d = paramString;
    this.e = paramInt2;
  }
  
  public VasAvatarLoader(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    this.b = paramString1;
    this.c = paramLong;
    this.d = paramString2;
    this.e = paramInt;
  }
  
  private void a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("Q.qqhead.VasFaceManager", 1, "VasAvatar get null path");
      return;
    }
    if ((this.e == -1) && (DeviceInfoUtils.isLowPerfDevice())) {
      return;
    }
    Object localObject = (VasAvatar)this.h.get();
    if (localObject != null)
    {
      if (((VasAvatar)localObject).b != this) {
        return;
      }
      try
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
        localObject = URLDrawable.getFileDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
        ThreadManager.getUIHandler().post(new VasAvatarLoader.2(this, (URLDrawable)localObject));
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getGifDrawable GifImage err, path:");
        localStringBuilder.append(paramString);
        QLog.e("Q.qqhead.VasFaceManager", 1, localStringBuilder.toString(), localException);
      }
    }
  }
  
  void a(VasAvatar paramVasAvatar)
  {
    this.h = new WeakReference(paramVasAvatar);
    if (this.e == -1)
    {
      if (QLog.isColorLevel())
      {
        paramVasAvatar = new StringBuilder();
        paramVasAvatar.append("delay getAvatar uin: ");
        paramVasAvatar.append(this.b);
        QLog.i("Q.qqhead.VasFaceManager", 2, paramVasAvatar.toString());
      }
      i.a(this);
      return;
    }
    a(false);
  }
  
  public void a(VasAvatar paramVasAvatar, int paramInt1, int paramInt2)
  {
    this.h = new WeakReference(paramVasAvatar);
    if (this.e == -1)
    {
      if (QLog.isColorLevel())
      {
        paramVasAvatar = new StringBuilder();
        paramVasAvatar.append("delay getAvatar uin: ");
        paramVasAvatar.append(this.b);
        QLog.i("Q.qqhead.VasFaceManager", 2, paramVasAvatar.toString());
      }
      i.a(this);
      return;
    }
    a(((IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class)).getGifFilePath(paramInt1, paramInt2, this.b));
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramObject == j)
    {
      a(true);
      return;
    }
    if (paramString == null)
    {
      QLog.e("Q.qqhead.VasFaceManager", 1, "VasAvatar get null path");
      return;
    }
    if ((this.e == -1) && (DeviceInfoUtils.isLowPerfDevice())) {
      return;
    }
    Object localObject2 = (VasAvatar)this.h.get();
    if (localObject2 != null)
    {
      if (((VasAvatar)localObject2).b != this) {
        return;
      }
      try
      {
        paramObject = new URL("vasapngdownloader", paramString, "-vas-face-");
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mUseApngImage = true;
        ((URLDrawable.URLDrawableOptions)localObject1).mUseMemoryCache = true;
        ((URLDrawable.URLDrawableOptions)localObject1).mMemoryCacheKeySuffix = Long.toString(this.c);
        localObject2 = ((VasAvatar)localObject2).a;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = VasFaceManager.a(this.f);
        VasFaceManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(paramObject, (URLDrawable.URLDrawableOptions)localObject1);
        paramObject = URLDrawable.getDrawable(paramObject, (URLDrawable.URLDrawableOptions)localObject1);
        ThreadManager.getUIHandler().post(new VasAvatarLoader.1(this, paramObject));
        return;
      }
      catch (Exception paramObject)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getApngDrawable ApngImage err, path:");
        ((StringBuilder)localObject1).append(paramString);
        QLog.e("Q.qqhead.VasFaceManager", 1, ((StringBuilder)localObject1).toString(), paramObject);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = (VasAvatar)this.h.get();
    if (localObject1 != null)
    {
      if (((VasAvatar)localObject1).b != this) {
        return;
      }
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 instanceof QQAppInterface))
      {
        Object localObject2 = (QQAppInterface)localObject1;
        localObject1 = ((VasExtensionManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).c;
        int k = this.a;
        if (k > 0)
        {
          ((VasFaceManager)localObject1).a(k, this.d, this, null);
          return;
        }
        localObject2 = ((QQAppInterface)localObject2).getExtensionInfo(this.b, paramBoolean);
        if ((localObject2 != null) && (((ExtensionInfo)localObject2).faceIdUpdateTime != 0L))
        {
          if (((ExtensionInfo)localObject2).faceId > 0) {
            ((VasFaceManager)localObject1).a(((ExtensionInfo)localObject2).faceId, this.d, this, null);
          }
        }
        else {
          ((VasFaceManager)localObject1).b(this.b, this, j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasAvatarLoader
 * JD-Core Version:    0.7.0.1
 */