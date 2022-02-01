package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.ColorNoteConstants;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.swipe.PostTable;
import com.tencent.mobileqq.swipe.TouchStateDetector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.PageActionBridge;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

@ProxyService(proxy=PageGestureProxy.class)
public class PageGestureProxyImpl
  implements IServiceInfo, PageGestureProxy
{
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  private ColorNoteCurd jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd;
  private IServiceInfo jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo;
  protected IColorNoteController a;
  public PostTable a;
  private TouchStateDetector jdField_a_of_type_ComTencentMobileqqSwipeTouchStateDetector;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private IMiniAppContext jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private String jdField_a_of_type_JavaLangString = null;
  private WeakReference<Activity> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = true;
  private boolean c;
  
  private ColorNote a()
  {
    IServiceInfo localIServiceInfo = this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo;
    if (localIServiceInfo != null) {
      return localIServiceInfo.getColorNote();
    }
    return null;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd = new ColorNoteCurd();
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(new PageGestureProxyImpl.3(this));
  }
  
  private void a(Activity paramActivity)
  {
    if (TextUtils.isEmpty(BaseApplicationImpl.getApplication().getRuntime().getAccount()))
    {
      QLog.e("PageGuestureProxyImpl", 1, "initColorNote() fail, because of null account");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController = ((IColorNoteController)QRoute.api(IColorNoteController.class));
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.init(paramActivity, false, true);
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.attachToActivity(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setServiceInfo(this);
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setOnColorNoteAnimFinishListener(new PageGestureProxyImpl.1(this, paramActivity));
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setOnColorNoteCurdListener(new PageGestureProxyImpl.2(this, paramActivity));
    this.jdField_a_of_type_ComTencentMobileqqSwipePostTable = new PostTable(paramActivity);
    ((ViewGroup)paramActivity.getWindow().getDecorView()).addView(this.jdField_a_of_type_ComTencentMobileqqSwipePostTable);
    this.jdField_a_of_type_ComTencentMobileqqSwipePostTable.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqSwipePostTable.a(0.0D);
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)paramActivity.getSystemService("vibrator"));
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localObject == null) {
      return;
    }
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog == null)
    {
      localObject = (Activity)((WeakReference)localObject).get();
      if (localObject == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = new QQCustomDialog((Context)localObject, 2131756189);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setContentView(2131558978);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(((Activity)localObject).getString(2131690905));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(((Activity)localObject).getString(2131690904), new PageGestureProxyImpl.4(this, (Activity)localObject));
    }
    else if (localQQCustomDialog.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getTitleTextView();
    ((View)localObject).setClickable(true);
    ((View)localObject).setFocusable(true);
    ((View)localObject).setFocusableInTouchMode(true);
    AccessibilityUtil.a((View)localObject, true);
  }
  
  public IColorNoteController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
  }
  
  public void a(IServiceInfo paramIServiceInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo = paramIServiceInfo;
    a();
  }
  
  public ColorNote getColorNote()
  {
    MiniAppInfo localMiniAppInfo = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
    byte[] arrayOfByte = null;
    if (localMiniAppInfo != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext;
      if (localObject != null) {
        this.jdField_a_of_type_JavaLangString = ActionBridge.PageActionBridge.getPageUrl((IMiniAppContext)localObject);
      }
      localObject = this.jdField_a_of_type_JavaLangString;
      if (localObject != null) {
        arrayOfByte = ((String)localObject).getBytes();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getColorNote, appId: ");
      ((StringBuilder)localObject).append(localMiniAppInfo.appId);
      ((StringBuilder)localObject).append(", name: ");
      ((StringBuilder)localObject).append(localMiniAppInfo.name);
      ((StringBuilder)localObject).append(", curPagePath: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", miniAppInfo.verType:");
      ((StringBuilder)localObject).append(localMiniAppInfo.verType);
      QLog.d("PageGuestureProxyImpl", 2, ((StringBuilder)localObject).toString());
      localObject = new ColorNote.Builder().a(16842752);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localMiniAppInfo.appId);
      localStringBuilder.append("#@#");
      localStringBuilder.append(localMiniAppInfo.verType);
      return ((ColorNote.Builder)localObject).a(localStringBuilder.toString()).b(localMiniAppInfo.name).a(arrayOfByte).c(localMiniAppInfo.desc).d(localMiniAppInfo.iconUrl).a();
    }
    return null;
  }
  
  public void onActivityCreate(Activity paramActivity)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
    a(paramActivity);
  }
  
  public void onActivityDestroy(Activity paramActivity)
  {
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (paramActivity != null) {
      paramActivity.onDestroy();
    }
  }
  
  public void onActivityFinish(Activity paramActivity) {}
  
  public void onActivityPause(Activity paramActivity)
  {
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (paramActivity != null) {
      paramActivity.onPause();
    }
  }
  
  public void onActivityResume(Activity paramActivity)
  {
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (paramActivity != null) {
      paramActivity.onResume();
    }
  }
  
  public void onActivityStop(Activity paramActivity)
  {
    QLog.d("PageGuestureProxyImpl", 1, "onActivityStop");
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (paramActivity != null) {
      paramActivity.onPause();
    }
  }
  
  public void onCreateMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
  }
  
  public void onLoadUrl(IMiniAppContext paramIMiniAppContext)
  {
    if (paramIMiniAppContext != null)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext = paramIMiniAppContext;
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getMiniAppInfo();
    }
    a(this);
  }
  
  public void onMoveTaskToBack(Activity paramActivity)
  {
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if ((paramActivity != null) && (paramActivity.isColorNoteExist())) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.exitAnimation();
    }
  }
  
  public void onPageWebViewInit()
  {
    Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localObject != null)
    {
      localObject = (Activity)((WeakReference)localObject).get();
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqSwipeTouchStateDetector = new TouchStateDetector((Context)localObject);
      }
    }
    a();
  }
  
  public void onProcessTouchEvent(MotionEvent paramMotionEvent)
  {
    QLog.d("PageGuestureProxyImpl", 1, "onProcessTouchEvent");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd;
    if ((localObject != null) && (((ColorNoteCurd)localObject).b()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqSwipeTouchStateDetector;
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqSwipePostTable != null))
      {
        double d = ((TouchStateDetector)localObject).a(paramMotionEvent);
        this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a();
        localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo.getColorNote();
        boolean bool1;
        if (localObject != null) {
          bool1 = this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(((ColorNote)localObject).getServiceType(), ((ColorNote)localObject).getSubType());
        } else {
          bool1 = false;
        }
        localObject = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
        boolean bool2;
        if (localObject != null) {
          bool2 = ((MiniAppInfo)localObject).isLimitedAccessApp();
        } else {
          bool2 = false;
        }
        if ((d > 0.0D) && (!bool1) && (!bool2) && (this.jdField_a_of_type_MqqUtilWeakReference != null))
        {
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqSwipePostTable.setVisibility(0);
            this.jdField_a_of_type_Boolean = true;
          }
          localObject = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
          if ((this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a()) && (localObject != null))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqSwipeTouchStateDetector.a(paramMotionEvent, (Context)localObject))
            {
              this.jdField_a_of_type_ComTencentMobileqqSwipePostTable.b();
              if (!this.c)
              {
                localObject = this.jdField_a_of_type_AndroidOsVibrator;
                if (localObject != null)
                {
                  ((Vibrator)localObject).vibrate(20L);
                  this.c = true;
                }
              }
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqSwipePostTable.a();
              this.c = false;
            }
          }
          else {
            this.jdField_a_of_type_ComTencentMobileqqSwipePostTable.c();
          }
          this.jdField_a_of_type_ComTencentMobileqqSwipePostTable.a(d);
          if (this.b)
          {
            ReportController.b(null, "dc00898", "", "", "0X800A741", "0X800A741", ColorNoteConstants.a(this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo.getColorNote().mServiceType), 0, "", "", "", "");
            this.b = false;
          }
        }
        else if ((d < 1.0E-008D) || (bool1))
        {
          this.jdField_a_of_type_ComTencentMobileqqSwipePostTable.setVisibility(4);
          this.jdField_a_of_type_Boolean = false;
        }
        if (paramMotionEvent.getActionMasked() == 1)
        {
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqSwipePostTable;
          if (paramMotionEvent != null)
          {
            paramMotionEvent.setVisibility(4);
            this.jdField_a_of_type_Boolean = false;
          }
        }
      }
    }
  }
  
  public boolean onViewReleasedAndNeedScrollOriginPosition(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    QLog.d("PageGuestureProxyImpl", 1, "onViewReleased");
    Object localObject = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
    if (localObject != null) {
      bool1 = ((MiniAppInfo)localObject).isLimitedAccessApp();
    } else {
      bool1 = false;
    }
    if (bool1) {
      return false;
    }
    ColorNote localColorNote = a();
    if (localColorNote != null) {
      bool1 = this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(localColorNote.getServiceType(), localColorNote.getSubType());
    } else {
      bool1 = false;
    }
    this.b = true;
    localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localObject != null) {
      localObject = (Activity)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    TouchStateDetector localTouchStateDetector = this.jdField_a_of_type_ComTencentMobileqqSwipeTouchStateDetector;
    if ((localTouchStateDetector != null) && (localTouchStateDetector.a(paramMotionEvent, (Context)localObject)) && (!bool1) && (localColorNote != null)) {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a())
      {
        paramMotionEvent = localColorNote.parseBundle();
        paramMotionEvent.putInt("color_note_curd_from_type", 1);
        this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(paramMotionEvent);
        ReportController.b(null, "dc00898", "", "", "0X800A742", "0X800A742", ColorNoteConstants.a(this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo.getColorNote().mServiceType), 0, "", "", "", "");
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqSwipePostTable.a(0.0D);
        b();
        ReportController.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 1, 0, "", "", "", "");
        bool1 = bool2;
        break label270;
      }
    }
    boolean bool1 = false;
    label270:
    paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqSwipePostTable;
    if (paramMotionEvent != null)
    {
      paramMotionEvent.setVisibility(4);
      this.jdField_a_of_type_Boolean = false;
    }
    return bool1;
  }
  
  public void updateColorSignPath(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.PageGestureProxyImpl
 * JD-Core Version:    0.7.0.1
 */