package com.tencent.mobileqq.kandian.biz.viola.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.utils.HippyCommonUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.biz.colornote.api.IColorNoteReportUtil;
import com.tencent.mobileqq.kandian.biz.hippy.TKDHippyEngine;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentPresenter;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentView;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaInitDelegate;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegate;
import com.tencent.mobileqq.kandian.biz.viola.contract.ViolaFragmentCommonLogicContract;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.glue.viola.ViolaColorNote;
import com.tencent.mobileqq.kandian.glue.viola.ViolaColorNote.OnEnterMiniAioEvent;
import com.tencent.mobileqq.kandian.glue.viola.delegate.ViolaInitDelegate;
import com.tencent.mobileqq.kandian.glue.viola.delegate.ViolaUiDelegate;
import com.tencent.mobileqq.kandian.glue.viola.event.ViolaEvent;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.utils.QRUtils;
import com.tencent.mobileqq.swipe.SwipeLayoutUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class ViolaFragmentPresenter
  implements SimpleEventReceiver<ViolaEvent>, IViolaFragmentPresenter, ViolaColorNote.OnEnterMiniAioEvent
{
  public HippyQQEngine a;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private IViolaFragmentView jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaFragmentView;
  private ViolaFragmentCommonLogicContract jdField_a_of_type_ComTencentMobileqqKandianBizViolaContractViolaFragmentCommonLogicContract = new ViolaFragmentCommonLogicContract();
  private ViolaFragmentPresenter.ViolaTopGestureLayoutListener jdField_a_of_type_ComTencentMobileqqKandianBizViolaPresenterViolaFragmentPresenter$ViolaTopGestureLayoutListener;
  private ViolaColorNote jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViolaColorNote;
  public ViolaInitDelegate a;
  public ViolaUiDelegate a;
  private boolean jdField_a_of_type_Boolean = false;
  
  public ViolaFragmentPresenter(@NotNull IViolaFragmentView paramIViolaFragmentView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaFragmentView = paramIViolaFragmentView;
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaFragmentView.getQBaseFragment() instanceof ViolaFragment))
    {
      paramIViolaFragmentView = (ViolaFragment)this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaFragmentView.getQBaseFragment();
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate = new ViolaInitDelegate(paramIViolaFragmentView);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate = new ViolaUiDelegate(paramIViolaFragmentView);
    }
  }
  
  private ViewGroup a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaFragmentView.getContentView();
  }
  
  private ViolaFragmentPresenter.ViolaTopGestureLayoutListener a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaPresenterViolaFragmentPresenter$ViolaTopGestureLayoutListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaPresenterViolaFragmentPresenter$ViolaTopGestureLayoutListener = new ViolaFragmentPresenter.ViolaTopGestureLayoutListener(this, null);
    }
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaPresenterViolaFragmentPresenter$ViolaTopGestureLayoutListener;
  }
  
  private String a()
  {
    return a().a();
  }
  
  private void a(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject.put(paramString, 1);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.b(paramJSONObject.toString());
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("ViolaFragment", 1, paramJSONObject.getMessage());
    }
  }
  
  private boolean a()
  {
    Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaFragmentView.getQBaseFragment().getArguments();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localBundle != null)
    {
      bool1 = bool2;
      if (localBundle.getBoolean("is_channel", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int a()
  {
    return 2131558494;
  }
  
  public int a(@Nullable Bundle paramBundle, boolean paramBoolean)
  {
    int i = paramBundle.getInt("color_note_curd_from_type");
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViolaColorNote;
    if (paramBundle != null)
    {
      paramBundle.a(i);
      ((IColorNoteReportUtil)QRoute.api(IColorNoteReportUtil.class)).reportInsertColorNoteForViola(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViolaColorNote.a());
    }
    return i;
  }
  
  public int a(@Nullable String paramString)
  {
    return HippyCommonUtils.getModuleOnlineConfig(paramString);
  }
  
  public HippyQQEngine a(@Nullable Bundle paramBundle, @Nullable ViewGroup paramViewGroup, @Nullable String paramString)
  {
    if (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine == null)
    {
      this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine = a(paramString);
      this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.setPropsMap(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaFragmentView.getPropsMap());
    }
    Object localObject = new JSONObject();
    paramString = (String)localObject;
    if (paramBundle != null)
    {
      paramString = (String)localObject;
      if (!paramBundle.containsKey("param")) {}
    }
    try
    {
      paramString = new JSONObject(paramBundle.getString("param"));
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.b(paramViewGroup);
      if (!this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.isReady()) {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.c();
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.a(paramViewGroup, new ViolaFragmentPresenter.1(this, paramBundle, paramViewGroup), new ViolaFragmentPresenter.2(this));
      localObject = (ViewGroup)a().findViewById(2131380915);
      this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.initHippyInContainer((ViewGroup)localObject, paramString, this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.a(), new ViolaFragmentPresenter.3(this, paramBundle, paramViewGroup));
      return this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString = (String)localObject;
      }
    }
  }
  
  @Nullable
  public HippyQQEngine a(@Nullable String paramString)
  {
    if (paramString.equals("TKDMiniGame")) {
      return (HippyQQEngine)((IRIJAdService)QRoute.api(IRIJAdService.class)).createTkdAdHippyEngine(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaFragmentView.getQBaseFragment(), paramString, a());
    }
    return new TKDHippyEngine(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaFragmentView.getQBaseFragment(), paramString, a());
  }
  
  @Nullable
  public ColorNote a(@Nullable Bundle paramBundle, @Nullable IColorNoteController paramIColorNoteController)
  {
    ViolaColorNote localViolaColorNote = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViolaColorNote;
    if (localViolaColorNote != null) {
      return localViolaColorNote.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViolaColorNote = new ViolaColorNote(a()).a(paramBundle.getString("param")).a(paramBundle.getBoolean("useTransParentFragment")).a(paramIColorNoteController).a(this);
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViolaColorNote.a();
  }
  
  @NotNull
  public IViolaInitDelegate a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate;
  }
  
  @NotNull
  public IViolaUiDelegate a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate;
  }
  
  public ViolaBaseView a()
  {
    ViolaInitDelegate localViolaInitDelegate = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate;
    if (localViolaInitDelegate != null) {
      return localViolaInitDelegate.a();
    }
    return null;
  }
  
  @Nullable
  public String a(@Nullable String paramString1, @Nullable String paramString2)
  {
    return ViolaAccessHelper.a(paramString1, paramString2);
  }
  
  @Nullable
  public HashMap<String, Long> a()
  {
    HippyQQEngine localHippyQQEngine = this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine;
    if (localHippyQQEngine != null) {
      return localHippyQQEngine.getLoadStepsTime();
    }
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(@Nullable Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaFragmentView.getQBaseFragment().getQBaseActivity();
  }
  
  public void a(@NotNull Bundle paramBundle, @NotNull ViewGroup paramViewGroup)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramBundle != null) && (paramBundle.containsKey("param"))) {}
    try
    {
      paramBundle = new JSONObject(paramBundle.getString("param"));
    }
    catch (JSONException paramBundle)
    {
      label38:
      break label38;
    }
    paramBundle = localJSONObject;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.c(paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.b(paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.a(paramViewGroup, new ViolaFragmentPresenter.4(this), new ViolaFragmentPresenter.5(this));
    if (a() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.a(a(), paramBundle, this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.a(), a(), new ViolaFragmentPresenter.6(this));
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void a(@Nullable ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.a(paramViewGroup);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.a(new ViolaFragmentPresenter.7(this));
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.a(a());
    }
  }
  
  public void a(@Nullable String paramString)
  {
    ViolaFragmentCommonLogicContract localViolaFragmentCommonLogicContract = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaContractViolaFragmentCommonLogicContract;
    if (localViolaFragmentCommonLogicContract != null) {
      localViolaFragmentCommonLogicContract.openFrameDropUpload(paramString);
    }
  }
  
  public void a(@Nullable JSONObject paramJSONObject)
  {
    ViolaColorNote localViolaColorNote = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViolaColorNote;
    if (localViolaColorNote == null) {
      return;
    }
    localViolaColorNote.a(paramJSONObject);
  }
  
  public void a(boolean paramBoolean)
  {
    ViolaUiDelegate localViolaUiDelegate = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate;
    if (localViolaUiDelegate == null) {
      return;
    }
    localViolaUiDelegate.b(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.a(a());
  }
  
  public boolean a(int paramInt, @Nullable KeyEvent paramKeyEvent)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.b();
    if (bool) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.a(a(), true);
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.c())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.g();
      return true;
    }
    return bool;
  }
  
  public boolean a(@Nullable Bundle paramBundle)
  {
    if (paramBundle == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.a()) {
      return false;
    }
    if (SwipeLayoutUtils.a())
    {
      if (paramBundle.getBoolean("disable_color_note", false)) {
        return false;
      }
      return ViolaBizUtils.b(a());
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.c();
  }
  
  public void b(@Nullable JSONObject paramJSONObject)
  {
    ViolaColorNote localViolaColorNote = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViolaColorNote;
    if (localViolaColorNote == null) {
      return;
    }
    localViolaColorNote.b(paramJSONObject);
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate;
    if (localObject == null) {
      return;
    }
    localObject = ((ViolaUiDelegate)localObject).a();
    if (localObject == null) {
      return;
    }
    ((TopGestureLayout)localObject).setInterceptScrollLRFlag(paramBoolean);
    ((TopGestureLayout)localObject).setIsInterceptChildEventWhenScroll(paramBoolean);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.d();
  }
  
  public void c(@Nullable JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.c(true);
    if (!this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.a()) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.a(a());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.b();
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.a(paramJSONObject);
  }
  
  public void d()
  {
    Object localObject;
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaFragmentView.shouldFinishActivity()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      if (localObject != null) {
        ((QBaseActivity)localObject).finishAndRemoveTask();
      } else if (QBaseActivity.sTopActivity != null) {
        QBaseActivity.sTopActivity.finishAndRemoveTask();
      } else {
        QLog.w("ViolaFragment", 1, "onDestroy do nothing.");
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.e();
      ThreadManager.getUIHandler().postDelayed(new ViolaFragmentPresenter.9(this), 300L);
      label85:
      QRUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViolaColorNote;
      if (localObject != null) {
        ((ViolaColorNote)localObject).c();
      }
      SimpleEventBus.getInstance().unRegisterReceiver(this);
      return;
    }
    catch (Exception localException)
    {
      break label85;
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.f();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.a(a(), true);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.c())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.g();
      return;
    }
    QBaseActivity localQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (localQBaseActivity != null) {
      localQBaseActivity.doOnBackPressed();
    }
  }
  
  public void f()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.a())
    {
      QBaseActivity localQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      if (localQBaseActivity != null) {
        localQBaseActivity.overridePendingTransition(0, 2130772025);
      }
    }
  }
  
  public void g()
  {
    ViolaColorNote localViolaColorNote = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViolaColorNote;
    if (localViolaColorNote != null) {
      localViolaColorNote.a();
    }
  }
  
  public ArrayList<Class<ViolaEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ViolaEvent.class);
    return localArrayList;
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "reload viola Page");
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.c();
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.a(new ViolaFragmentPresenter.8(this));
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.a(a(), true);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate.c())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.g();
      return;
    }
    QBaseActivity localQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (localQBaseActivity != null) {
      localQBaseActivity.doOnBackPressed();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate != null)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("enterAIOFromMiniAIO", 1);
      }
      catch (JSONException localJSONException)
      {
        QLog.e("ViolaFragment", 1, localJSONException.getMessage());
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate.b(localJSONObject.toString());
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof ViolaEvent))
    {
      ArrayList localArrayList = new ArrayList(5);
      localArrayList.add("onCommentEditorClose");
      localArrayList.add("openCommentEditor");
      localArrayList.add("onCommentEditorResume");
      localArrayList.add("onCommentEditorPause");
      localArrayList.add("onCommentEditorWillClose");
      paramSimpleBaseEvent = (ViolaEvent)paramSimpleBaseEvent;
      if (localArrayList.contains(paramSimpleBaseEvent.eventName)) {
        a(paramSimpleBaseEvent.data, paramSimpleBaseEvent.eventName);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.presenter.ViolaFragmentPresenter
 * JD-Core Version:    0.7.0.1
 */