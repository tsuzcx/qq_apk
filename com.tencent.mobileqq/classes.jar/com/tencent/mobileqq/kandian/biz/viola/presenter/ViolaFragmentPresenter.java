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
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;
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
  public ViolaInitDelegate a;
  public ViolaUiDelegate b;
  public HippyQQEngine c;
  private IViolaFragmentView d;
  private ViolaColorNote e;
  private ViolaFragmentPresenter.ViolaTopGestureLayoutListener f;
  private QBaseActivity g;
  private boolean h = false;
  private ViolaFragmentCommonLogicContract i = new ViolaFragmentCommonLogicContract();
  
  public ViolaFragmentPresenter(@NotNull IViolaFragmentView paramIViolaFragmentView)
  {
    this.d = paramIViolaFragmentView;
    if ((this.d.getQBaseFragment() instanceof ViolaFragment))
    {
      paramIViolaFragmentView = (ViolaFragment)this.d.getQBaseFragment();
      this.a = new ViolaInitDelegate(paramIViolaFragmentView);
      this.b = new ViolaUiDelegate(paramIViolaFragmentView);
    }
    this.i.a(ViolaFragment.getCurrentJSUrl());
  }
  
  private void a(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject.put(paramString, 1);
      this.a.c(paramJSONObject.toString());
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("ViolaFragment", 1, paramJSONObject.getMessage());
    }
  }
  
  private String q()
  {
    return j().a();
  }
  
  private ViewGroup r()
  {
    return this.d.getContentView();
  }
  
  private boolean s()
  {
    Bundle localBundle = this.d.getQBaseFragment().getArguments();
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
  
  private ViolaFragmentPresenter.ViolaTopGestureLayoutListener t()
  {
    if (this.f == null) {
      this.f = new ViolaFragmentPresenter.ViolaTopGestureLayoutListener(this, null);
    }
    return this.f;
  }
  
  public int a(@Nullable Bundle paramBundle, boolean paramBoolean)
  {
    int j = paramBundle.getInt("color_note_curd_from_type");
    paramBundle = this.e;
    if (paramBundle != null)
    {
      paramBundle.a(j);
      ReportUtil.c(this.e.a());
    }
    return j;
  }
  
  public int a(@Nullable String paramString)
  {
    return HippyCommonUtils.getModuleOnlineConfig(paramString);
  }
  
  public HippyQQEngine a(@Nullable Bundle paramBundle, @Nullable ViewGroup paramViewGroup, @Nullable String paramString)
  {
    if (this.c == null)
    {
      this.c = c(paramString);
      this.c.setPropsMap(this.d.getPropsMap());
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
      this.b.b(paramViewGroup);
      if (!this.c.isReady()) {
        this.b.g();
      }
      this.b.a(paramViewGroup, new ViolaFragmentPresenter.1(this, paramBundle, paramViewGroup), new ViolaFragmentPresenter.2(this));
      localObject = (ViewGroup)r().findViewById(2131449905);
      this.c.initHippyInContainer((ViewGroup)localObject, paramString, this.b.d(), new ViolaFragmentPresenter.3(this, paramBundle, paramViewGroup));
      return this.c;
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
  public ColorNote a(@Nullable Bundle paramBundle, @Nullable IColorNoteController paramIColorNoteController)
  {
    ViolaColorNote localViolaColorNote = this.e;
    if (localViolaColorNote != null) {
      return localViolaColorNote.a();
    }
    this.e = new ViolaColorNote(q()).a(paramBundle.getString("param")).a(paramBundle.getBoolean("useTransParentFragment")).a(paramIColorNoteController).a(this);
    return this.e.a();
  }
  
  @Nullable
  public String a(@Nullable String paramString1, @Nullable String paramString2)
  {
    return ViolaAccessHelper.a(paramString1, paramString2);
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    this.a.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(@Nullable Activity paramActivity)
  {
    this.g = this.d.getQBaseFragment().getQBaseActivity();
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
    this.b.c(paramViewGroup);
    this.b.b(paramViewGroup);
    this.b.a(paramViewGroup, new ViolaFragmentPresenter.4(this), new ViolaFragmentPresenter.5(this));
    if (r() == null) {
      return;
    }
    this.i.b();
    this.i.a(paramBundle);
    this.a.a(r(), paramBundle, this.b.d(), s(), new ViolaFragmentPresenter.6(this));
    SimpleEventBus.getInstance().registerReceiver(this);
    this.i.a(q());
  }
  
  public void a(@Nullable ViewGroup paramViewGroup)
  {
    if (this.b.d())
    {
      this.a.a(paramViewGroup);
      this.a.a(new ViolaFragmentPresenter.7(this));
      this.b.a(t());
    }
  }
  
  public void a(@Nullable JSONObject paramJSONObject)
  {
    ViolaColorNote localViolaColorNote = this.e;
    if (localViolaColorNote == null) {
      return;
    }
    localViolaColorNote.a(paramJSONObject);
  }
  
  public void a(boolean paramBoolean)
  {
    ViolaUiDelegate localViolaUiDelegate = this.b;
    if (localViolaUiDelegate == null) {
      return;
    }
    localViolaUiDelegate.b(paramBoolean);
    this.b.a(t());
  }
  
  public boolean a(int paramInt, @Nullable KeyEvent paramKeyEvent)
  {
    boolean bool = this.a.j();
    if (bool) {
      return true;
    }
    if (this.b.d())
    {
      this.a.a(r(), true);
      return true;
    }
    if (this.b.j())
    {
      this.a.m();
      return true;
    }
    return bool;
  }
  
  public boolean a(@Nullable Bundle paramBundle)
  {
    if (paramBundle == null) {
      return false;
    }
    if (this.b.d()) {
      return false;
    }
    if (SwipeLayoutUtils.a())
    {
      if (paramBundle.getBoolean("disable_color_note", false)) {
        return false;
      }
      return ViolaBizUtils.e(q());
    }
    return false;
  }
  
  public void b()
  {
    this.a.g();
  }
  
  public void b(@Nullable String paramString)
  {
    ViolaFragmentCommonLogicContract localViolaFragmentCommonLogicContract = this.i;
    if (localViolaFragmentCommonLogicContract != null) {
      localViolaFragmentCommonLogicContract.openFrameDropUpload(paramString);
    }
  }
  
  public void b(@Nullable JSONObject paramJSONObject)
  {
    ViolaColorNote localViolaColorNote = this.e;
    if (localViolaColorNote == null) {
      return;
    }
    localViolaColorNote.b(paramJSONObject);
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    localObject = ((ViolaUiDelegate)localObject).i();
    if (localObject == null) {
      return;
    }
    ((TopGestureLayout)localObject).setInterceptScrollLRFlag(paramBoolean);
    ((TopGestureLayout)localObject).setIsInterceptChildEventWhenScroll(paramBoolean);
  }
  
  @Nullable
  public HippyQQEngine c(@Nullable String paramString)
  {
    if (paramString.equals("TKDMiniGame")) {
      return (HippyQQEngine)((IRIJAdService)QRoute.api(IRIJAdService.class)).createTkdAdHippyEngine(this.d.getQBaseFragment(), paramString, q());
    }
    return new TKDHippyEngine(this.d.getQBaseFragment(), paramString, q());
  }
  
  public void c()
  {
    this.a.h();
  }
  
  public void c(@Nullable JSONObject paramJSONObject)
  {
    this.b.c(true);
    if (!this.a.e()) {
      this.b.a(t());
    }
    this.a.f();
    this.a.a(paramJSONObject);
  }
  
  public void d()
  {
    Object localObject;
    if ((Build.VERSION.SDK_INT >= 21) && (this.d.shouldFinishActivity()))
    {
      localObject = this.g;
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
      this.a.i();
      ThreadManager.getUIHandler().postDelayed(new ViolaFragmentPresenter.9(this), 300L);
      label85:
      QRUtils.a(this.g);
      localObject = this.e;
      if (localObject != null) {
        ((ViolaColorNote)localObject).d();
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
    this.a.k();
    if (this.b.d())
    {
      this.a.a(r(), true);
      return;
    }
    if (this.b.j())
    {
      this.a.m();
      return;
    }
    QBaseActivity localQBaseActivity = this.g;
    if (localQBaseActivity != null) {
      localQBaseActivity.doOnBackPressed();
    }
  }
  
  public void f()
  {
    if (!this.b.d())
    {
      QBaseActivity localQBaseActivity = this.g;
      if (localQBaseActivity != null) {
        localQBaseActivity.overridePendingTransition(0, 2130772030);
      }
    }
  }
  
  public void g()
  {
    ViolaColorNote localViolaColorNote = this.e;
    if (localViolaColorNote != null) {
      localViolaColorNote.b();
    }
  }
  
  public ArrayList<Class<ViolaEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ViolaEvent.class);
    return localArrayList;
  }
  
  public int h()
  {
    return 2131624045;
  }
  
  @NotNull
  public IViolaUiDelegate i()
  {
    return this.b;
  }
  
  @NotNull
  public IViolaInitDelegate j()
  {
    return this.a;
  }
  
  @Nullable
  public HashMap<String, Long> k()
  {
    HippyQQEngine localHippyQQEngine = this.c;
    if (localHippyQQEngine != null) {
      return localHippyQQEngine.getLoadStepsTime();
    }
    return null;
  }
  
  @NotNull
  public String l()
  {
    return this.i.a();
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "reload viola Page");
    }
    this.b.g();
    this.a.a(new ViolaFragmentPresenter.8(this));
  }
  
  public ViolaBaseView n()
  {
    ViolaInitDelegate localViolaInitDelegate = this.a;
    if (localViolaInitDelegate != null) {
      return localViolaInitDelegate.d();
    }
    return null;
  }
  
  public void o()
  {
    if (this.b.d())
    {
      this.a.a(r(), true);
      return;
    }
    if (this.b.j())
    {
      this.a.m();
      return;
    }
    QBaseActivity localQBaseActivity = this.g;
    if (localQBaseActivity != null) {
      localQBaseActivity.doOnBackPressed();
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
  
  public void p()
  {
    if (this.a != null)
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
      this.a.c(localJSONObject.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.presenter.ViolaFragmentPresenter
 * JD-Core Version:    0.7.0.1
 */