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
  protected IColorNoteController a;
  public PostTable b;
  private boolean c = false;
  private WeakReference<Activity> d;
  private TouchStateDetector e;
  private ColorNoteCurd f;
  private IServiceInfo g;
  private QQCustomDialog h;
  private boolean i = true;
  private Vibrator j;
  private boolean k;
  private MiniAppInfo l;
  private IMiniAppContext m;
  private String n = null;
  
  private void a(Activity paramActivity)
  {
    if (TextUtils.isEmpty(BaseApplicationImpl.getApplication().getRuntime().getAccount()))
    {
      QLog.e("PageGuestureProxyImpl", 1, "initColorNote() fail, because of null account");
      return;
    }
    this.a = ((IColorNoteController)QRoute.api(IColorNoteController.class));
    this.a.init(paramActivity, false, true);
    this.a.attachToActivity(paramActivity);
    this.a.setServiceInfo(this);
    this.a.setOnColorNoteAnimFinishListener(new PageGestureProxyImpl.1(this, paramActivity));
    this.a.setOnColorNoteCurdListener(new PageGestureProxyImpl.2(this, paramActivity));
    this.b = new PostTable(paramActivity);
    ((ViewGroup)paramActivity.getWindow().getDecorView()).addView(this.b);
    this.b.setVisibility(4);
    this.b.a(0.0D);
    this.j = ((Vibrator)paramActivity.getSystemService("vibrator"));
  }
  
  private ColorNote b()
  {
    IServiceInfo localIServiceInfo = this.g;
    if (localIServiceInfo != null) {
      return localIServiceInfo.getColorNote();
    }
    return null;
  }
  
  private void c()
  {
    this.f = new ColorNoteCurd();
    this.f.a(new PageGestureProxyImpl.3(this));
  }
  
  private void d()
  {
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    QQCustomDialog localQQCustomDialog = this.h;
    if (localQQCustomDialog == null)
    {
      localObject = (Activity)((WeakReference)localObject).get();
      if (localObject == null) {
        return;
      }
      this.h = new QQCustomDialog((Context)localObject, 2131953338);
      this.h.setContentView(2131624611);
      this.h.setCanceledOnTouchOutside(false);
      this.h.setTitle(((Activity)localObject).getString(2131887844));
      this.h.setNegativeButton(((Activity)localObject).getString(2131887843), new PageGestureProxyImpl.4(this, (Activity)localObject));
    }
    else if (localQQCustomDialog.isShowing())
    {
      this.h.dismiss();
    }
    this.h.show();
    localObject = this.h.getTitleTextView();
    ((View)localObject).setClickable(true);
    ((View)localObject).setFocusable(true);
    ((View)localObject).setFocusableInTouchMode(true);
    AccessibilityUtil.a((View)localObject, true);
  }
  
  public IColorNoteController a()
  {
    return this.a;
  }
  
  public void a(IServiceInfo paramIServiceInfo)
  {
    this.g = paramIServiceInfo;
    c();
  }
  
  public ColorNote getColorNote()
  {
    MiniAppInfo localMiniAppInfo = this.l;
    byte[] arrayOfByte = null;
    if (localMiniAppInfo != null)
    {
      Object localObject = this.m;
      if (localObject != null) {
        this.n = ActionBridge.PageActionBridge.getPageUrl((IMiniAppContext)localObject);
      }
      localObject = this.n;
      if (localObject != null) {
        arrayOfByte = ((String)localObject).getBytes();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getColorNote, appId: ");
      ((StringBuilder)localObject).append(localMiniAppInfo.appId);
      ((StringBuilder)localObject).append(", name: ");
      ((StringBuilder)localObject).append(localMiniAppInfo.name);
      ((StringBuilder)localObject).append(", curPagePath: ");
      ((StringBuilder)localObject).append(this.n);
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
    this.d = new WeakReference(paramActivity);
    a(paramActivity);
  }
  
  public void onActivityDestroy(Activity paramActivity)
  {
    paramActivity = this.a;
    if (paramActivity != null) {
      paramActivity.onDestroy();
    }
  }
  
  public void onActivityFinish(Activity paramActivity) {}
  
  public void onActivityPause(Activity paramActivity)
  {
    paramActivity = this.a;
    if (paramActivity != null) {
      paramActivity.onPause();
    }
  }
  
  public void onActivityResume(Activity paramActivity)
  {
    paramActivity = this.a;
    if (paramActivity != null) {
      paramActivity.onResume();
    }
  }
  
  public void onActivityStop(Activity paramActivity)
  {
    QLog.d("PageGuestureProxyImpl", 1, "onActivityStop");
    paramActivity = this.a;
    if (paramActivity != null) {
      paramActivity.onPause();
    }
  }
  
  public void onCreateMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.l = paramMiniAppInfo;
  }
  
  public void onLoadUrl(IMiniAppContext paramIMiniAppContext)
  {
    if (paramIMiniAppContext != null)
    {
      this.m = paramIMiniAppContext;
      this.l = this.m.getMiniAppInfo();
    }
    a(this);
  }
  
  public void onMoveTaskToBack(Activity paramActivity)
  {
    paramActivity = this.a;
    if ((paramActivity != null) && (paramActivity.isColorNoteExist())) {
      this.a.exitAnimation();
    }
  }
  
  public void onPageWebViewInit()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = (Activity)((WeakReference)localObject).get();
      if (localObject != null) {
        this.e = new TouchStateDetector((Context)localObject);
      }
    }
    c();
  }
  
  public void onProcessTouchEvent(MotionEvent paramMotionEvent)
  {
    QLog.d("PageGuestureProxyImpl", 1, "onProcessTouchEvent");
    Object localObject = this.f;
    if ((localObject != null) && (((ColorNoteCurd)localObject).c()))
    {
      localObject = this.e;
      if ((localObject != null) && (this.b != null))
      {
        double d1 = ((TouchStateDetector)localObject).a(paramMotionEvent);
        this.f.b();
        localObject = this.g.getColorNote();
        boolean bool1;
        if (localObject != null) {
          bool1 = this.f.a(((ColorNote)localObject).getServiceType(), ((ColorNote)localObject).getSubType());
        } else {
          bool1 = false;
        }
        localObject = this.l;
        boolean bool2;
        if (localObject != null) {
          bool2 = ((MiniAppInfo)localObject).isLimitedAccessApp();
        } else {
          bool2 = false;
        }
        if ((d1 > 0.0D) && (!bool1) && (!bool2) && (this.d != null))
        {
          if (!this.c)
          {
            this.b.setVisibility(0);
            this.c = true;
          }
          localObject = (Activity)this.d.get();
          if ((this.f.b()) && (localObject != null))
          {
            if (this.e.a(paramMotionEvent, (Context)localObject))
            {
              this.b.b();
              if (!this.k)
              {
                localObject = this.j;
                if (localObject != null)
                {
                  ((Vibrator)localObject).vibrate(20L);
                  this.k = true;
                }
              }
            }
            else
            {
              this.b.a();
              this.k = false;
            }
          }
          else {
            this.b.c();
          }
          this.b.a(d1);
          if (this.i)
          {
            ReportController.b(null, "dc00898", "", "", "0X800A741", "0X800A741", ColorNoteConstants.a(this.g.getColorNote().mServiceType), 0, "", "", "", "");
            this.i = false;
          }
        }
        else if ((d1 < 1.0E-008D) || (bool1))
        {
          this.b.setVisibility(4);
          this.c = false;
        }
        if (paramMotionEvent.getActionMasked() == 1)
        {
          paramMotionEvent = this.b;
          if (paramMotionEvent != null)
          {
            paramMotionEvent.setVisibility(4);
            this.c = false;
          }
        }
      }
    }
  }
  
  public boolean onViewReleasedAndNeedScrollOriginPosition(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    QLog.d("PageGuestureProxyImpl", 1, "onViewReleased");
    Object localObject = this.l;
    if (localObject != null) {
      bool1 = ((MiniAppInfo)localObject).isLimitedAccessApp();
    } else {
      bool1 = false;
    }
    if (bool1) {
      return false;
    }
    ColorNote localColorNote = b();
    if (localColorNote != null) {
      bool1 = this.f.a(localColorNote.getServiceType(), localColorNote.getSubType());
    } else {
      bool1 = false;
    }
    this.i = true;
    localObject = this.d;
    if (localObject != null) {
      localObject = (Activity)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    TouchStateDetector localTouchStateDetector = this.e;
    if ((localTouchStateDetector != null) && (localTouchStateDetector.a(paramMotionEvent, (Context)localObject)) && (!bool1) && (localColorNote != null)) {
      if (this.f.b())
      {
        paramMotionEvent = localColorNote.parseBundle();
        paramMotionEvent.putInt("color_note_curd_from_type", 1);
        this.f.a(paramMotionEvent);
        ReportController.b(null, "dc00898", "", "", "0X800A742", "0X800A742", ColorNoteConstants.a(this.g.getColorNote().mServiceType), 0, "", "", "", "");
      }
      else
      {
        this.b.a(0.0D);
        d();
        ReportController.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 1, 0, "", "", "", "");
        bool1 = bool2;
        break label270;
      }
    }
    boolean bool1 = false;
    label270:
    paramMotionEvent = this.b;
    if (paramMotionEvent != null)
    {
      paramMotionEvent.setVisibility(4);
      this.c = false;
    }
    return bool1;
  }
  
  public void updateColorSignPath(String paramString)
  {
    this.n = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.PageGestureProxyImpl
 * JD-Core Version:    0.7.0.1
 */