package com.tencent.mobileqq.profilecard.vas.component.background;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.vas.VasCardData;
import com.tencent.mobileqq.profilecard.vas.VasProfileData;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class VasProfileBackgroundComponent
  extends AbsVasProfileBackgroundComponent
{
  private ImageView mBackgroundView;
  private VasCardData mCardData = null;
  private Drawable mCurBgDrawable = null;
  private String mCurBgFile = null;
  private Vector<Drawable> mNeedToRecycleBgList = new Vector();
  
  public VasProfileBackgroundComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super("VasProfileBackgroundComponent", paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void clearBackgroundCache()
  {
    if (QLog.isColorLevel()) {
      QLog.d(getTAG(), 2, String.format("clearBGCache size=%s", new Object[] { Integer.valueOf(this.mNeedToRecycleBgList.size()) }));
    }
    Iterator localIterator = this.mNeedToRecycleBgList.iterator();
    while (localIterator.hasNext())
    {
      Drawable localDrawable = (Drawable)localIterator.next();
      if ((localDrawable instanceof FriendProfileCardBgDrawable)) {
        ((FriendProfileCardBgDrawable)localDrawable).a();
      } else if ((localDrawable instanceof IGLDrawable)) {
        ((IGLDrawable)localDrawable).recycle();
      }
    }
    this.mNeedToRecycleBgList.clear();
  }
  
  private boolean iniProfileCaardBackground(FriendProfileCardBgDrawable paramFriendProfileCardBgDrawable)
  {
    Object localObject = this.mCurBgDrawable;
    if ((localObject != null) && ((localObject instanceof FriendProfileCardBgDrawable)))
    {
      paramFriendProfileCardBgDrawable = paramFriendProfileCardBgDrawable.a();
      localObject = ((FriendProfileCardBgDrawable)this.mCurBgDrawable).a();
      if ((localObject != null) && (localObject == paramFriendProfileCardBgDrawable))
      {
        if (QLog.isColorLevel()) {
          QLog.i(getTAG(), 2, "initProfileCardBackground newBitmap == currentBitmap");
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean initProfileCardBackground(VasCardData paramVasCardData)
  {
    if (QLog.isColorLevel()) {
      QLog.d(getTAG(), 2, String.format("initProfileCardBackground styleId=%s bgId=%s url=%s strZipUrl=%s heroUrl=%s", new Object[] { Long.valueOf(paramVasCardData.getLCurrentStyleId()), Long.valueOf(paramVasCardData.getLCurrentBgId()), paramVasCardData.getBackgroundUrl(), paramVasCardData.getStrZipUrl(), paramVasCardData.getStrWzryHeroUrl() }));
    }
    if (!TextUtils.isEmpty(paramVasCardData.getBackgroundUrl())) {}
    for (;;)
    {
      try
      {
        if ((paramVasCardData.getLCurrentBgId() != 160L) && (paramVasCardData.getLCurrentBgId() != 1600L)) {
          localObject1 = ProfileCardManager.a(this.mActivity, paramVasCardData.getLCurrentStyleId(), paramVasCardData.getLCurrentBgId());
        } else {
          localObject1 = ProfileCardUtil.a(paramVasCardData.getBackgroundUrl());
        }
        if (TextUtils.isEmpty(paramVasCardData.getStrZipUrl()))
        {
          localObject2 = "";
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(ProfileCardManager.a(this.mActivity, paramVasCardData.getLCurrentBgId()));
          ((StringBuilder)localObject2).append("dynamicBottom.jpg");
          localObject2 = ((StringBuilder)localObject2).toString();
          if (new File((String)localObject2).exists()) {
            localObject1 = localObject2;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(ProfileCardManager.a(this.mActivity, paramVasCardData.getLCurrentBgId()));
          ((StringBuilder)localObject2).append(".dynamic");
          localObject2 = ((StringBuilder)localObject2).toString();
        }
      }
      catch (Throwable paramVasCardData)
      {
        Object localObject1;
        Object localObject2;
        File localFile;
        boolean bool1;
        boolean bool2;
        QLog.e(getTAG(), 1, "initProfileCardBackground fail.", paramVasCardData);
      }
      if (QLog.isColorLevel()) {
        QLog.d(getTAG(), 2, String.format("initProfileCardBackground fileName=%s dynamicFileDirectory=%s", new Object[] { localObject1, localObject2 }));
      }
      localFile = new File((String)localObject1);
      bool1 = localFile.isFile();
      bool2 = localFile.exists();
      if (QLog.isColorLevel()) {
        QLog.d(getTAG(), 2, String.format("initProfileCardBackground isFile=%s exists=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      if ((bool1) && (bool2))
      {
        bool1 = loadBackground(paramVasCardData.getLCurrentBgId(), (String)localObject1, (String)localObject2, localFile);
        return bool1;
      }
      return false;
    }
  }
  
  private boolean loadBackground(long paramLong, String paramString1, String paramString2, File paramFile)
  {
    Object localObject = (Boolean)ProfileCardManager.b.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("profilecard:");
      ((StringBuilder)localObject).append(paramString1);
      localObject = ((StringBuilder)localObject).toString();
      GlobalImageCache.a.remove(localObject);
      ProfileCardManager.b.remove(Long.valueOf(paramLong));
    }
    localObject = new VasProfileBackgroundComponent.UserGldrawable(this, paramLong, paramString2, null).invoke();
    if (((VasProfileBackgroundComponent.UserGldrawable)localObject).is()) {
      return true;
    }
    paramFile = new VasProfileBackgroundComponent.UseEtcDrawable(this, paramString2, paramFile, ((VasProfileBackgroundComponent.UserGldrawable)localObject).getBgDrawable()).invoke();
    if (paramFile.is()) {
      return true;
    }
    localObject = paramFile.getBgDrawable();
    paramFile = (File)localObject;
    if (localObject == null)
    {
      this.mCurBgFile = null;
      paramString1 = ProfileCardUtil.a(this.mActivity.getResources(), paramString2, paramString1);
      paramFile = paramString1;
      if (iniProfileCaardBackground((FriendProfileCardBgDrawable)paramString1)) {
        return true;
      }
    }
    paramString1 = this.mCurBgDrawable;
    if (paramString1 != null) {
      this.mNeedToRecycleBgList.add(paramString1);
    }
    if (QLog.isColorLevel()) {
      QLog.d(getTAG(), 2, String.format("initProfileCardBackground bgDrawable=%s", new Object[] { paramFile }));
    }
    this.mCurBgDrawable = paramFile;
    return true;
  }
  
  private void releaseBackground()
  {
    if (QLog.isColorLevel()) {
      QLog.d(getTAG(), 2, "releaseBackground");
    }
    Drawable localDrawable = this.mCurBgDrawable;
    if (localDrawable != null)
    {
      if ((localDrawable instanceof FriendProfileCardBgDrawable)) {
        ((FriendProfileCardBgDrawable)localDrawable).a();
      }
      localDrawable = this.mCurBgDrawable;
      if ((localDrawable instanceof IGLDrawable)) {
        ((IGLDrawable)localDrawable).recycle();
      }
    }
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    this.mBackgroundView = new ImageView(paramQBaseActivity);
    this.mBackgroundView.setContentDescription("qqvip_bg");
    ((FrameLayout)this.mViewContainer).addView(this.mBackgroundView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    clearBackgroundCache();
    releaseBackground();
    ((FrameLayout)this.mViewContainer).removeView(this.mBackgroundView);
    this.mBackgroundView = null;
  }
  
  public boolean onVasDataUpdate(VasProfileData paramVasProfileData)
  {
    if (paramVasProfileData.getCurrentTemplate() == null)
    {
      this.mBackgroundView.setBackgroundResource(getDefaultResourceID());
      return true;
    }
    if ((paramVasProfileData.getCardData().equals(this.mCardData)) && (isBackgroundShow())) {
      return true;
    }
    this.mCardData = paramVasProfileData.getCardData();
    boolean bool = initProfileCardBackground(this.mCardData);
    if (QLog.isColorLevel())
    {
      paramVasProfileData = getTAG();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCardUpdate initConfigResult=");
      localStringBuilder.append(bool);
      QLog.d(paramVasProfileData, 2, localStringBuilder.toString());
    }
    paramVasProfileData = this.mCurBgDrawable;
    if (paramVasProfileData != null)
    {
      this.mBackgroundView.setBackgroundDrawable(paramVasProfileData);
      paramVasProfileData = this.mCurBgDrawable;
      if ((paramVasProfileData instanceof IGLDrawable))
      {
        if (((IGLDrawable)paramVasProfileData).getResID().startsWith("video")) {
          setAbFactor("card-video");
        } else if (((IGLDrawable)this.mCurBgDrawable).getResID().startsWith("aetc")) {
          setAbFactor("card-etc");
        }
      }
      else if ((paramVasProfileData instanceof FriendProfileCardBgDrawable)) {
        if (((FriendProfileCardBgDrawable)paramVasProfileData).d) {
          setAbFactor("card-dynamic");
        } else {
          setAbFactor("card-static");
        }
      }
      setBackgroundShow(true);
      return true;
    }
    this.mBackgroundView.setBackgroundResource(getDefaultResourceID());
    setAbFactor("card-default");
    setBackgroundShow(false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.background.VasProfileBackgroundComponent
 * JD-Core Version:    0.7.0.1
 */