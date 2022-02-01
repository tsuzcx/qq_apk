package com.tencent.mobileqq.kandian.biz.feedspopup;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.kandian.base.automator.BasePopupStep;
import com.tencent.mobileqq.kandian.base.automator.RIJPopupAutomator;
import com.tencent.mobileqq.kandian.base.image.ImageManager;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteSwitchManager;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils.RIJUGCAccountStatusCheckCallback;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class RIJUGCAccountPopupStep
  extends BasePopupStep
{
  private static final String[] a = { "https://pub.idqqimg.com/pc/misc/files/20200416/3c376048a60b488d998e1ef31153db5e.png", "https://pub.idqqimg.com/pc/misc/files/20200416/54aaad879a4042899540fafd969395f6.png", "https://pub.idqqimg.com/pc/misc/files/20200416/8b787675714740eeb21c7fc5b15712c0.png", "https://pub.idqqimg.com/pc/misc/files/20200416/1263e35cec174f0db53e0fc3bb8e7df2.png", "https://pub.idqqimg.com/pc/misc/files/20200430/21b88f2ba3bd43919173a767982d649d.png", "https://pub.idqqimg.com/pc/misc/files/20201030/894f73da508f4e45b4defab92dfa40c2.png", "https://pub.idqqimg.com/pc/misc/files/20200430/eb40275894c9455f9ab438dd91081678.png" };
  private Activity b;
  private boolean c = false;
  
  public RIJUGCAccountPopupStep(@NonNull RIJPopupAutomator paramRIJPopupAutomator, Activity paramActivity)
  {
    super(paramRIJPopupAutomator, "RIJUGCAccountPopupStep");
    this.b = paramActivity;
    m();
  }
  
  public static void j()
  {
    if (!RIJUgcUtils.a()) {
      return;
    }
    ReadInJoyUserInfoModule.a(RIJQQAppInterfaceUtil.c(), null);
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = arrayOfString[i];
      Object localObject3;
      Object localObject2;
      try
      {
        localObject1 = new URL((String)localObject1);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[preload] error, e = ");
        ((StringBuilder)localObject3).append(localMalformedURLException);
        QLog.e("RIJUGCAccountPopupStep", 1, ((StringBuilder)localObject3).toString());
        localObject2 = null;
      }
      if (localObject2 != null)
      {
        localObject3 = new ImageRequest();
        ((ImageRequest)localObject3).a = localObject2;
        ((ImageRequest)localObject3).e = true;
        ImageManager.get().loadImage((ImageRequest)localObject3, null);
        if ((QLog.isDebugVersion()) || (QLog.isColorLevel()))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[preload] url = ");
          ((StringBuilder)localObject3).append(localObject2);
          QLog.i("RIJUGCAccountPopupStep", 2, ((StringBuilder)localObject3).toString());
        }
      }
      i += 1;
    }
  }
  
  private boolean l()
  {
    boolean bool2 = StudyModeManager.h();
    boolean bool3 = RIJUgcUtils.a();
    boolean bool4 = PTSLiteSwitchManager.a().b();
    boolean bool1;
    if ((!bool2) && (bool3) && (bool4)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[handleUGCAccountCreate], isStudyMode = ");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append("isPopupEnable = ");
    ((StringBuilder)localObject).append(bool3);
    ((StringBuilder)localObject).append(", isPtsLiteEnable = ");
    ((StringBuilder)localObject).append(bool4);
    QLog.i("RIJUGCAccountPopupStep", 2, ((StringBuilder)localObject).toString());
    if (bool1)
    {
      localObject = this.b;
      RIJUgcUtils.a((Activity)localObject, new RIJUgcUtils.RIJUGCAccountStatusCheckCallback((Activity)localObject, 0));
    }
    return bool1;
  }
  
  private void m()
  {
    if (!RIJUgcUtils.a()) {
      return;
    }
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = arrayOfString[i];
      Object localObject3;
      Object localObject2;
      try
      {
        localObject1 = new URL((String)localObject1);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[preloadResources] error, e = ");
        ((StringBuilder)localObject3).append(localMalformedURLException);
        QLog.i("RIJUGCAccountPopupStep", 1, ((StringBuilder)localObject3).toString());
        localObject2 = null;
      }
      if ((QLog.isDebugVersion()) || (QLog.isColorLevel()))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[preloadResources] url = ");
        ((StringBuilder)localObject3).append(localObject2);
        QLog.i("RIJUGCAccountPopupStep", 2, ((StringBuilder)localObject3).toString());
      }
      if (localObject2 != null)
      {
        localObject3 = new ImageRequest();
        ((ImageRequest)localObject3).a = localObject2;
        ImageManager.get().loadImage((ImageRequest)localObject3, null);
      }
      i += 1;
    }
  }
  
  protected void h()
  {
    a(this.c);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[doStepFromOnResume], needShow = ");
    localStringBuilder.append(this.c);
    QLog.i("RIJUGCAccountPopupStep", 1, localStringBuilder.toString());
  }
  
  protected void i()
  {
    this.c = l();
    a(this.c);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[doStepFromOnShowSelf], needShow = ");
    localStringBuilder.append(this.c);
    QLog.i("RIJUGCAccountPopupStep", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feedspopup.RIJUGCAccountPopupStep
 * JD-Core Version:    0.7.0.1
 */