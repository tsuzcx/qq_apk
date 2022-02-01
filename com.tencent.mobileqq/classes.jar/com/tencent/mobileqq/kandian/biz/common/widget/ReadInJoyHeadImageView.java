package com.tencent.mobileqq.kandian.biz.common.widget;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.image.imageloader.DrawableController;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.base.utils.api.IImageUtil;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class ReadInJoyHeadImageView
  extends NativeReadInjoyImageView
  implements IView, IReadInJoyHeadImageView, IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  private long jdField_a_of_type_Long;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(BitmapFactory.decodeResource(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getApplication().getResources(), 2130841788));
  private WeakReference<IReadInJoyUserInfoModule.RefreshUserInfoCallBack> jdField_a_of_type_MqqUtilWeakReference;
  
  public ReadInJoyHeadImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ReadInJoyHeadImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ReadInJoyHeadImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setRound(true);
    setImagePlaceHolder(((IImageUtil)QRoute.api(IImageUtil.class)).getDefaultFaceDrawable140_140());
    this.mController.a(false);
  }
  
  private void a(ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (paramReadInJoyUserInfo == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" [setHeadImg] load avatar from 0xb81 userinfo, uin:");
    localStringBuilder.append(paramReadInJoyUserInfo.uin);
    QLog.d("ReadInJoyHeadImageView", 1, localStringBuilder.toString());
    setImageSrc(((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getResultFaceUrl(paramReadInJoyUserInfo));
  }
  
  private void b(ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (paramReadInJoyUserInfo != null)
    {
      if (RIJThreadHandler.a())
      {
        a(paramReadInJoyUserInfo);
        return;
      }
      RIJThreadHandler.b().post(new ReadInJoyHeadImageView.2(this, paramReadInJoyUserInfo));
    }
  }
  
  public View a()
  {
    return this;
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uin: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" onLoadUserInfoFailed:");
    ((StringBuilder)localObject).append(paramString2);
    QLog.d("ReadInJoyHeadImageView", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      ((IReadInJoyUserInfoModule.RefreshUserInfoCallBack)this.jdField_a_of_type_MqqUtilWeakReference.get()).onLoadUserInfoFailed(paramString1, paramString2);
    }
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("load uin success: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramReadInJoyUserInfo);
    QLog.d("ReadInJoyHeadImageView", 2, ((StringBuilder)localObject).toString());
    if (TextUtils.equals(paramString, String.valueOf(this.jdField_a_of_type_Long)))
    {
      if (paramReadInJoyUserInfo == null) {
        return;
      }
      ThreadManager.getUIHandler().post(new ReadInJoyHeadImageView.1(this, paramReadInJoyUserInfo));
      localObject = this.jdField_a_of_type_MqqUtilWeakReference;
      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
        ((IReadInJoyUserInfoModule.RefreshUserInfoCallBack)this.jdField_a_of_type_MqqUtilWeakReference.get()).onLoadUserInfoSucceed(paramString, paramReadInJoyUserInfo);
      }
    }
  }
  
  public void setHeadImgByUin(long paramLong)
  {
    setHeadImgByUin(paramLong, true);
  }
  
  public void setHeadImgByUin(long paramLong, boolean paramBoolean)
  {
    setHeadImgByUin(paramLong, paramBoolean, null);
  }
  
  public void setHeadImgByUin(long paramLong, boolean paramBoolean, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    setHeadImgByUin(paramLong, paramBoolean, paramRefreshUserInfoCallBack, false);
  }
  
  public void setHeadImgByUin(long paramLong, boolean paramBoolean1, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack, boolean paramBoolean2)
  {
    if (paramLong <= 0L)
    {
      QLog.d("ReadInJoyHeadImageView", 2, "Uin is illegal");
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
    if (paramBoolean1) {
      setImagePlaceHolder(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    if (paramRefreshUserInfoCallBack != null) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramRefreshUserInfoCallBack);
    }
    paramRefreshUserInfoCallBack = ((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getSingleKDUserInfo(this.jdField_a_of_type_Long, this, paramBoolean2);
    b(paramRefreshUserInfoCallBack);
    if ((paramRefreshUserInfoCallBack != null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setHeadImgByUin faceFlag:");
      localStringBuilder.append(paramRefreshUserInfoCallBack.faceFlag);
      QLog.d("ReadInJoyHeadImageView", 2, localStringBuilder.toString());
    }
  }
  
  public void setHeadImgByUin(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ReadInJoyHeadImageView", 2, "UinStr is illegal");
      return;
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException paramString)
    {
      QLog.d("ReadInJoyHeadImageView", 2, paramString.getMessage());
    }
    setHeadImgByUin(l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView
 * JD-Core Version:    0.7.0.1
 */