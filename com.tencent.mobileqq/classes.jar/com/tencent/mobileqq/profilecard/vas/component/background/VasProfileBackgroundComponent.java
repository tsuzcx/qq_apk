package com.tencent.mobileqq.profilecard.vas.component.background;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.vas.VasCardData;
import com.tencent.mobileqq.profilecard.vas.VasProfileData;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableWraper;
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
      } else if (GLDrawableWraper.a(localDrawable)) {
        GLDrawableWraper.a().a(localDrawable);
      }
    }
    this.mNeedToRecycleBgList.clear();
  }
  
  private boolean initProfileCardBackground(VasCardData paramVasCardData)
  {
    if (QLog.isColorLevel()) {
      QLog.d(getTAG(), 2, String.format("initProfileCardBackground styleId=%s bgId=%s url=%s strZipUrl=%s heroUrl=%s", new Object[] { Long.valueOf(paramVasCardData.getLCurrentStyleId()), Long.valueOf(paramVasCardData.getLCurrentBgId()), paramVasCardData.getBackgroundUrl(), paramVasCardData.getStrZipUrl(), paramVasCardData.getStrWzryHeroUrl() }));
    }
    if (!TextUtils.isEmpty(paramVasCardData.getBackgroundUrl())) {
      try
      {
        Object localObject;
        if ((paramVasCardData.getLCurrentBgId() == 160L) || (paramVasCardData.getLCurrentBgId() == 1600L))
        {
          localObject = ProfileCardUtil.a(this.mActivity, paramVasCardData.getBackgroundUrl());
          if (!TextUtils.isEmpty(paramVasCardData.getStrZipUrl())) {
            break label259;
          }
        }
        for (String str = "";; str = ProfileCardManager.a(this.mActivity, paramVasCardData.getLCurrentBgId()) + ".dynamic")
        {
          if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, String.format("initProfileCardBackground fileName=%s dynamicFileDirectory=%s", new Object[] { localObject, str }));
          }
          File localFile = new File((String)localObject);
          boolean bool1 = localFile.isFile();
          boolean bool2 = localFile.exists();
          if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, String.format("initProfileCardBackground isFile=%s exists=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
          }
          if ((!bool1) || (!bool2)) {
            break label355;
          }
          return loadBackground(paramVasCardData.getLCurrentBgId(), (String)localObject, str, localFile);
          localObject = ProfileCardManager.a(this.mActivity, paramVasCardData.getLCurrentStyleId(), paramVasCardData.getLCurrentBgId());
          break;
          label259:
          str = ProfileCardManager.a(this.mActivity, paramVasCardData.getLCurrentBgId()) + "dynamicBottom.jpg";
          if (new File(str).exists()) {
            localObject = str;
          }
        }
        return false;
      }
      catch (Throwable paramVasCardData)
      {
        QLog.e(getTAG(), 1, "initProfileCardBackground fail.", paramVasCardData);
      }
    }
  }
  
  private boolean loadBackground(long paramLong, String paramString1, String paramString2, File paramFile)
  {
    Object localObject = (Boolean)ProfileCardManager.b.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      localObject = "profilecard:" + paramString1;
      GlobalImageCache.a.remove(localObject);
      ProfileCardManager.b.remove(Long.valueOf(paramLong));
    }
    localObject = new VasProfileBackgroundComponent.UserGldrawable(this, paramLong, paramString2, null).invoke();
    if (((VasProfileBackgroundComponent.UserGldrawable)localObject).is()) {}
    do
    {
      do
      {
        return true;
        paramFile = new VasProfileBackgroundComponent.UseEtcDrawable(this, paramString2, paramFile, ((VasProfileBackgroundComponent.UserGldrawable)localObject).getBgDrawable()).invoke();
      } while (paramFile.is());
      localObject = paramFile.getBgDrawable();
      paramFile = (File)localObject;
      if (localObject != null) {
        break;
      }
      this.mCurBgFile = null;
      paramString1 = ProfileCardUtil.a(this.mActivity.getResources(), paramString2, paramString1);
      paramFile = paramString1;
      if (this.mCurBgDrawable == null) {
        break;
      }
      paramFile = paramString1;
      if (!(this.mCurBgDrawable instanceof FriendProfileCardBgDrawable)) {
        break;
      }
      paramString2 = ((FriendProfileCardBgDrawable)paramString1).a();
      localObject = ((FriendProfileCardBgDrawable)this.mCurBgDrawable).a();
      paramFile = paramString1;
      if (localObject == null) {
        break;
      }
      paramFile = paramString1;
      if (localObject != paramString2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(getTAG(), 2, "initProfileCardBackground newBitmap == currentBitmap");
    return true;
    if (this.mCurBgDrawable != null) {
      this.mNeedToRecycleBgList.add(this.mCurBgDrawable);
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
    if (this.mCurBgDrawable != null)
    {
      if ((this.mCurBgDrawable instanceof FriendProfileCardBgDrawable)) {
        ((FriendProfileCardBgDrawable)this.mCurBgDrawable).a();
      }
      if (GLDrawableWraper.a(this.mCurBgDrawable)) {
        GLDrawableWraper.a().a(this.mCurBgDrawable);
      }
    }
  }
  
  public void onCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    this.mBackgroundView = new ImageView(paramBaseActivity);
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
    if (paramVasProfileData.getCurrentTemplate() == null) {
      this.mBackgroundView.setBackgroundResource(getDefaultResourceID());
    }
    while ((paramVasProfileData.getCardData().equals(this.mCardData)) && (isBackgroundShow())) {
      return true;
    }
    this.mCardData = paramVasProfileData.getCardData();
    boolean bool = initProfileCardBackground(this.mCardData);
    if (QLog.isColorLevel()) {
      QLog.d(getTAG(), 2, "onCardUpdate initConfigResult=" + bool);
    }
    if (this.mCurBgDrawable != null)
    {
      this.mBackgroundView.setBackgroundDrawable(this.mCurBgDrawable);
      if (GLDrawableWraper.b(this.mCurBgDrawable)) {
        setAbFactor("card-video");
      }
      for (;;)
      {
        setBackgroundShow(true);
        return true;
        if (GLDrawableWraper.c(this.mCurBgDrawable)) {
          setAbFactor("card-etc");
        } else if ((this.mCurBgDrawable instanceof FriendProfileCardBgDrawable)) {
          if (((FriendProfileCardBgDrawable)this.mCurBgDrawable).d) {
            setAbFactor("card-dynamic");
          } else {
            setAbFactor("card-static");
          }
        }
      }
    }
    this.mBackgroundView.setBackgroundResource(getDefaultResourceID());
    setAbFactor("card-default");
    setBackgroundShow(false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.background.VasProfileBackgroundComponent
 * JD-Core Version:    0.7.0.1
 */