package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.colornote.ColorNoteConstants;
import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.mobileqq.colornote.share.ColorNoteStateNotice;
import com.tencent.mobileqq.colornote.swipeback.PostTable;
import com.tencent.mobileqq.colornote.swipeback.TouchStateDetector;
import com.tencent.mobileqq.miniapp.MiniAppColorNoteData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.PageActionBridge;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import mqq.util.WeakReference;

@ProxyService(proxy=PageGestureProxy.class)
public class PageGestureProxyImpl
  implements IServiceInfo, PageGestureProxy
{
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  protected ColorNoteController a;
  private ColorNoteCurd jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd;
  private IServiceInfo jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo;
  private ColorNoteStateNotice jdField_a_of_type_ComTencentMobileqqColornoteShareColorNoteStateNotice;
  public PostTable a;
  private TouchStateDetector jdField_a_of_type_ComTencentMobileqqColornoteSwipebackTouchStateDetector;
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
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo.getColorNote();
    }
    return null;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteShareColorNoteStateNotice == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd = new ColorNoteCurd();
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(new PageGestureProxyImpl.3(this));
      this.jdField_a_of_type_ComTencentMobileqqColornoteShareColorNoteStateNotice = new ColorNoteStateNotice();
      this.jdField_a_of_type_ComTencentMobileqqColornoteShareColorNoteStateNotice.a(this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd);
    }
  }
  
  private void a(Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController = new ColorNoteController(paramActivity, false, true);
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(this);
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(new PageGestureProxyImpl.1(this, paramActivity));
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(new PageGestureProxyImpl.2(this, paramActivity));
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable = new PostTable(paramActivity);
    ((ViewGroup)paramActivity.getWindow().getDecorView()).addView(this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable);
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.a(0.0D);
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)paramActivity.getSystemService("vibrator"));
  }
  
  private byte[] a(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    paramString = new MiniAppColorNoteData(paramMiniAppInfo, paramString);
    paramMiniAppInfo = Parcel.obtain();
    paramString.writeToParcel(paramMiniAppInfo, 0);
    paramString = paramMiniAppInfo.marshall();
    paramMiniAppInfo.recycle();
    return paramString;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    Object localObject;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
        break;
      }
      localObject = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    } while (localObject == null);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = new QQCustomDialog((Context)localObject, 2131755842);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setContentView(2131559084);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(((Activity)localObject).getString(2131690985));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(((Activity)localObject).getString(2131690984), new PageGestureProxyImpl.4(this, (Activity)localObject));
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getTitleTextView();
      ((View)localObject).setClickable(true);
      ((View)localObject).setFocusable(true);
      ((View)localObject).setFocusableInTouchMode(true);
      AccessibilityUtil.a((View)localObject, true);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
    }
  }
  
  public ColorNoteController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController;
  }
  
  public void a(IServiceInfo paramIServiceInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo = paramIServiceInfo;
    a();
    this.jdField_a_of_type_ComTencentMobileqqColornoteShareColorNoteStateNotice.a(paramIServiceInfo);
  }
  
  public ColorNote getColorNote()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null)
    {
      MiniAppInfo localMiniAppInfo = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext != null) {
        this.jdField_a_of_type_JavaLangString = ActionBridge.PageActionBridge.getPageUrl(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext);
      }
      byte[] arrayOfByte = a(localMiniAppInfo, this.jdField_a_of_type_JavaLangString);
      QLog.d("PageGuestureProxyImpl", 2, "getColorNote, appId: " + localMiniAppInfo.appId + ", name: " + localMiniAppInfo.name + ", curPagePath: " + this.jdField_a_of_type_JavaLangString + ", miniAppInfo.verType:" + localMiniAppInfo.verType);
      return new ColorNote.Builder().a(16842752).a(localMiniAppInfo.appId + "###" + localMiniAppInfo.verType).b(localMiniAppInfo.name).a(arrayOfByte).c(localMiniAppInfo.desc).d(localMiniAppInfo.iconUrl).a();
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
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.c();
  }
  
  public void onActivityFinish(Activity paramActivity) {}
  
  public void onActivityPause(Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.b();
  }
  
  public void onActivityResume(Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a();
  }
  
  public void onActivityStop(Activity paramActivity)
  {
    QLog.d("PageGuestureProxyImpl", 1, "onActivityStop");
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.b();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null) && (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.c())) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.d();
    }
  }
  
  public void onPageWebViewInit()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null)
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localActivity != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackTouchStateDetector = new TouchStateDetector(localActivity);
      }
    }
    a();
  }
  
  public void onProcessTouchEvent(MotionEvent paramMotionEvent)
  {
    QLog.d("PageGuestureProxyImpl", 1, "onProcessTouchEvent");
    double d;
    Object localObject;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd != null) && (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.b()) && (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackTouchStateDetector != null) && (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable != null))
    {
      d = this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackTouchStateDetector.a(paramMotionEvent);
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a();
      localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo.getColorNote();
      if (localObject == null) {
        break label323;
      }
      bool1 = this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(((ColorNote)localObject).getServiceType(), ((ColorNote)localObject).getSubType());
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null) {
        break label383;
      }
    }
    label227:
    label383:
    for (boolean bool2 = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.isLimitedAccessApp();; bool2 = false)
    {
      if ((d > 0.0D) && (!bool1) && (!bool2) && (this.jdField_a_of_type_MqqUtilWeakReference != null))
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.setVisibility(0);
          this.jdField_a_of_type_Boolean = true;
        }
        localObject = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
        if ((this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a()) && (localObject != null)) {
          if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackTouchStateDetector.a(paramMotionEvent, (Context)localObject))
          {
            this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.b();
            if ((!this.c) && (this.jdField_a_of_type_AndroidOsVibrator != null))
            {
              this.jdField_a_of_type_AndroidOsVibrator.vibrate(20L);
              this.c = true;
            }
            this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.a(d);
            if (this.b)
            {
              ReportController.b(null, "dc00898", "", "", "0X800A741", "0X800A741", ColorNoteConstants.a(this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo.getColorNote().mServiceType), 0, "", "", "", "");
              this.b = false;
            }
          }
        }
      }
      for (;;)
      {
        if ((paramMotionEvent.getActionMasked() == 1) && (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.setVisibility(4);
          this.jdField_a_of_type_Boolean = false;
        }
        return;
        bool1 = false;
        break;
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.a();
        this.c = false;
        break label227;
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.c();
        break label227;
        if ((d < 1.0E-008D) || (bool1))
        {
          this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.setVisibility(4);
          this.jdField_a_of_type_Boolean = false;
        }
      }
    }
  }
  
  public boolean onViewReleasedAndNeedScrollOriginPosition(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    QLog.d("PageGuestureProxyImpl", 1, "onViewReleased");
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) {}
    for (boolean bool1 = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.isLimitedAccessApp();; bool1 = false)
    {
      if (bool1) {
        return false;
      }
      ColorNote localColorNote = a();
      Activity localActivity;
      if (localColorNote != null)
      {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(localColorNote.getServiceType(), localColorNote.getSubType());
        this.b = true;
        if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
          break label222;
        }
        localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
        label85:
        if ((this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackTouchStateDetector == null) || (!this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackTouchStateDetector.a(paramMotionEvent, localActivity)) || (bool1) || (localColorNote == null)) {
          break label278;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a()) {
          break label228;
        }
        paramMotionEvent = localColorNote.parseBundle();
        paramMotionEvent.putInt("color_note_curd_from_type", 1);
        this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(paramMotionEvent);
        ReportController.b(null, "dc00898", "", "", "0X800A742", "0X800A742", ColorNoteConstants.a(this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo.getColorNote().mServiceType), 0, "", "", "", "");
        bool1 = false;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.setVisibility(4);
          this.jdField_a_of_type_Boolean = false;
        }
        return bool1;
        bool1 = false;
        break;
        label222:
        localActivity = null;
        break label85;
        label228:
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.a(0.0D);
        b();
        ReportController.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 1, 0, "", "", "", "");
        bool1 = bool2;
        continue;
        label278:
        bool1 = false;
      }
    }
  }
  
  public void updateColorSignPath(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.PageGestureProxyImpl
 * JD-Core Version:    0.7.0.1
 */