package com.tencent.mobileqq.kandian.biz.viola.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.kandian.biz.feeds.entity.SerializableMap;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentPresenter;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentPresenterFactory;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentView;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaInitDelegate;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegate;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegateConstants;
import com.tencent.mobileqq.kandian.biz.viola.api.OnTitleChangeListener;
import com.tencent.mobileqq.kandian.biz.viola.contract.IViolaFragmentCommonContract;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class ViolaFragment
  extends ViolaLazyFragment
  implements IViolaFragmentView, IViolaFragmentCommonContract
{
  public static String BUNDLE_PAGE_CONFIG_DATA = "pageConfigParams";
  public static final int COLOR_NOTE_NO_EXIST = 0;
  public static final int COLOR_NOTE_NO_SUPPORT = -1;
  public static final int COLOR_NOTE_STATE_EXIST = 1;
  public static final String DISABLE_COLOR_NOTE = "disable_color_note";
  public static final String DISABLE_FPS_BALL = "disable_fps_ball";
  public static final String IS_CHANNEL = "is_channel";
  public static final String SHOULD_FINISH_ACTIVITY = "should_finish_activity";
  protected static final String TAG = "ViolaFragment";
  private IColorNoteController colorNoteController;
  private boolean enableColorSwipeRightFlag = true;
  private boolean hasInitFragment = false;
  private boolean hasPlayAnimation = false;
  protected HippyQQEngine mHippyQQEngine;
  protected IViolaFragmentPresenter mPresenter = ((IViolaFragmentPresenterFactory)QRoute.api(IViolaFragmentPresenterFactory.class)).createViolaFragmentPresenter(this);
  private ViolaFragment.ViolaGestureLayoutListener mViolaGestureLayoutListener;
  
  private void finishActivity()
  {
    if (getQBaseActivity() != null) {
      getQBaseActivity().finish();
    }
  }
  
  private void handleTopGestureEvent(boolean paramBoolean)
  {
    this.mPresenter.b(paramBoolean);
  }
  
  private void initBaseUI(ViewGroup paramViewGroup)
  {
    this.mPresenter.a().a(paramViewGroup);
  }
  
  private void initDataFromBundle(Bundle paramBundle)
  {
    this.mPresenter.a().a(paramBundle);
  }
  
  private void initViola(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    this.mPresenter.a(paramBundle, paramViewGroup);
  }
  
  protected static ViolaFragment newInstance(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new ViolaFragment();
    paramBundle.setArguments(localBundle);
    return paramBundle;
  }
  
  public static ViolaFragment newInstance(String paramString, SerializableMap paramSerializableMap, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localBundle.putSerializable(BUNDLE_PAGE_CONFIG_DATA, paramSerializableMap);
    if (paramBoolean) {
      localBundle.putInt(IViolaUiDelegateConstants.b, 1);
    }
    return newInstance(localBundle);
  }
  
  private void playColorNoteAnimation()
  {
    this.hasPlayAnimation = true;
    IColorNoteController localIColorNoteController = this.colorNoteController;
    if (localIColorNoteController != null) {
      localIColorNoteController.exitAnimation();
    }
    this.mPresenter.g();
  }
  
  public void addToColorBall()
  {
    IColorNoteController localIColorNoteController = this.colorNoteController;
    if (localIColorNoteController == null) {
      return;
    }
    if (localIColorNoteController.canAddColorNote())
    {
      this.colorNoteController.insertColorNote();
      QQToast.a(getContext(), 2, getContext().getResources().getString(2131690892), 5000).a();
    }
    else
    {
      this.colorNoteController.onCannotAdd();
    }
    if (!this.colorNoteController.shouldDisplayColorNote()) {
      QLog.e("ViolaFragment", 1, "[addToColorBall]: ColorNote Not Ready");
    }
  }
  
  public int colorBallState()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void dealFlingEnableWhenSwitcher(int paramInt)
  {
    this.mPresenter.a().a(paramInt);
    if (paramInt != 0)
    {
      IColorNoteController localIColorNoteController = this.colorNoteController;
      if (localIColorNoteController == null) {
        return;
      }
      localIColorNoteController.disableSwipe();
      handleTopGestureEvent(true);
      return;
    }
    QLog.e("ViolaFragment", 1, "dealFlingEnableWhenSwitcher");
    enableColorNoteSwipeRight(this.enableColorSwipeRightFlag);
  }
  
  public boolean disableFPSBall()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null) {
      return false;
    }
    return localBundle.getBoolean("disable_fps_ball", false);
  }
  
  public void disableSwitcher()
  {
    this.mPresenter.a().a();
  }
  
  public void doOnBackPressed()
  {
    this.mPresenter.e();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      return this.mPresenter.a(paramInt, paramKeyEvent);
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void enableColorNoteSwipeAndFlingGesture(boolean paramBoolean1, boolean paramBoolean2)
  {
    IColorNoteController localIColorNoteController = this.colorNoteController;
    if (localIColorNoteController != null) {
      if (paramBoolean1) {
        localIColorNoteController.enableSwipe();
      } else {
        localIColorNoteController.disableSwipe();
      }
    }
    this.mPresenter.b(paramBoolean2);
  }
  
  public void enableColorNoteSwipeRight(boolean paramBoolean)
  {
    if (this.colorNoteController == null)
    {
      QLog.e("ViolaFragment", 1, "[ViolaFragment.enableColorNoteSwipeRight]: colorController is null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[ViolaFragment.enableColorNoteSwipeRight]: enable: ");
    localStringBuilder.append(paramBoolean);
    QLog.e("ViolaFragment", 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      this.colorNoteController.enableSwipe();
      handleTopGestureEvent(false);
    }
    else
    {
      this.colorNoteController.disableSwipe();
      handleTopGestureEvent(true);
    }
    this.enableColorSwipeRightFlag = paramBoolean;
  }
  
  public void enableFlingGesture(boolean paramBoolean)
  {
    this.mPresenter.a(paramBoolean);
  }
  
  public void enableFlingRight(boolean paramBoolean)
  {
    this.mPresenter.a().b(paramBoolean);
  }
  
  public Object getCommonSuspensionGestureLayout()
  {
    return this.mPresenter.a().a();
  }
  
  public int getContentViewId()
  {
    return this.mPresenter.a();
  }
  
  public HashMap<String, Long> getPerformanceData()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.mPresenter.a());
    localHashMap.put("pageCreateStart", Long.valueOf(this.createViewStartTime));
    localHashMap.put("loadHippyStart", Long.valueOf(this.loadHippyStartTime));
    Bundle localBundle = getArguments();
    if (localBundle != null) {
      localHashMap.put("openPageStart", Long.valueOf(localBundle.getLong("openPageStart")));
    }
    return localHashMap;
  }
  
  public HippyMap getPropsMap()
  {
    return new HippyMap();
  }
  
  public QBaseFragment getQBaseFragment()
  {
    return this;
  }
  
  public HashMap getSusConfigMap()
  {
    return this.mPresenter.a().a();
  }
  
  public OnTitleChangeListener getTtileChangelistener()
  {
    return this.mPresenter.a().a();
  }
  
  public String getUrl()
  {
    return this.mPresenter.a().a();
  }
  
  public ViolaFragment.ViolaGestureLayoutListener getViolaGestureLayoutListener()
  {
    return this.mViolaGestureLayoutListener;
  }
  
  public void initAfterVisible(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    initDataFromBundle(paramBundle);
    initBaseUI(paramViewGroup);
    String str = getUrl();
    if ((!TextUtils.isEmpty(str)) && (str.contains("v_bundleName")))
    {
      str = Uri.parse(str).getQueryParameter("v_bundleName");
      if (!TextUtils.isEmpty(str))
      {
        i = this.mPresenter.a(str);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Hippy: moduleName=");
        localStringBuilder.append(str);
        localStringBuilder.append(", hippyOnlineConfig=");
        localStringBuilder.append(i);
        QLog.d("Hippy", 1, localStringBuilder.toString());
        if (i == 1)
        {
          this.loadHippyStartTime = System.currentTimeMillis();
          this.mHippyQQEngine = this.mPresenter.a(paramBundle, paramViewGroup, str);
          break label168;
        }
        if (!onHippyPageLoad(false, "hippyConfig is 0")) {
          break label168;
        }
        return;
      }
    }
    int i = 0;
    label168:
    if (i != 1) {
      initViola(paramBundle, paramViewGroup);
    }
    initSuspension(paramViewGroup);
    initFPS();
  }
  
  public void initBeforeVisible(Bundle paramBundle)
  {
    this.mPresenter.a().a(paramBundle);
  }
  
  protected void initFPS()
  {
    this.mPresenter.a();
  }
  
  protected void initFragmentLazy(ViewGroup paramViewGroup)
  {
    this.hasInitFragment = true;
    super.initFragmentLazy(paramViewGroup);
  }
  
  public void initSuspension(ViewGroup paramViewGroup)
  {
    this.mPresenter.a(paramViewGroup);
  }
  
  public boolean isSuspension()
  {
    return this.mPresenter.a().a();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mPresenter.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mPresenter.a(paramActivity);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mPresenter.d();
  }
  
  public void onFinish()
  {
    super.onFinish();
    this.mPresenter.f();
  }
  
  public boolean onHippyPageLoad(boolean paramBoolean, String paramString)
  {
    return false;
  }
  
  public void onPause()
  {
    this.mPresenter.c();
    super.onPause();
    IColorNoteController localIColorNoteController = this.colorNoteController;
    if (localIColorNoteController != null) {
      localIColorNoteController.onPause();
    }
  }
  
  public void onResume()
  {
    this.mPresenter.b();
    super.onResume();
    if (this.colorNoteController == null) {
      tryInitColorNote(getArguments());
    }
    IColorNoteController localIColorNoteController = this.colorNoteController;
    if (localIColorNoteController != null) {
      localIColorNoteController.onResume();
    }
  }
  
  public void openFrameDropUpload(String paramString)
  {
    IViolaFragmentPresenter localIViolaFragmentPresenter = this.mPresenter;
    if (localIViolaFragmentPresenter != null) {
      localIViolaFragmentPresenter.a(paramString);
    }
  }
  
  public boolean overrideFinish()
  {
    if ((this.colorNoteController != null) && (!this.hasPlayAnimation))
    {
      playColorNoteAnimation();
      return true;
    }
    return false;
  }
  
  public void removeColorBall()
  {
    IColorNoteController localIColorNoteController = this.colorNoteController;
    if (localIColorNoteController != null)
    {
      if (!localIColorNoteController.isColorNoteExist()) {
        return;
      }
      this.colorNoteController.deleteColorNote();
      QQToast.a(getContext(), 2, getContext().getResources().getString(2131690896), 5000).a();
    }
  }
  
  public void setCanCloseFromBottom(boolean paramBoolean)
  {
    this.mPresenter.a().b(paramBoolean);
  }
  
  public void setColorBallData(JSONObject paramJSONObject)
  {
    this.mPresenter.a(paramJSONObject);
  }
  
  public void setTitleConf(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup)
  {
    this.mPresenter.a().a(paramHashMap, paramViewGroup);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    this.mPresenter.a().a(paramBoolean);
  }
  
  public void setViolaGestureLayoutListener(ViolaFragment.ViolaGestureLayoutListener paramViolaGestureLayoutListener)
  {
    this.mViolaGestureLayoutListener = paramViolaGestureLayoutListener;
  }
  
  public boolean shouldFinishActivity()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null) {
      return localBundle.getBoolean("should_finish_activity", true);
    }
    return true;
  }
  
  public void tryInitColorNote(Bundle paramBundle)
  {
    if (this.mPresenter.a(paramBundle))
    {
      this.colorNoteController = ((IColorNoteController)QRoute.api(IColorNoteController.class));
      this.colorNoteController.init(getQBaseActivity(), true, false, true, true, 0);
      this.colorNoteController.setLeftSwipeScope(ViewUtils.a());
      this.colorNoteController.attachToActivity(getQBaseActivity());
      this.colorNoteController.setServiceInfo(new ViolaFragment.1(this, paramBundle));
      this.colorNoteController.setOnColorNoteAnimFinishListener(new ViolaFragment.2(this));
      this.colorNoteController.setOnColorNoteCurdListener(new ViolaFragment.3(this));
      this.colorNoteController.setOnPageSwipeListener(new ViolaFragment.4(this));
      this.colorNoteController.disableSwipe();
    }
  }
  
  public void updateColorBallData(JSONObject paramJSONObject)
  {
    this.mPresenter.b(paramJSONObject);
  }
  
  public void updateViolaPage(String paramString, JSONObject paramJSONObject)
  {
    if (this.hasInitFragment)
    {
      if ((getArguments() != null) && (TextUtils.isEmpty(getArguments().getString("url")))) {
        getArguments().putString("url", paramString);
      }
      this.mPresenter.a().a(paramString, paramJSONObject);
      return;
    }
    if (getArguments() != null) {
      getArguments().putString("url", paramString);
    }
  }
  
  public void updateViolaPageByData(JSONObject paramJSONObject)
  {
    this.mPresenter.c(paramJSONObject);
  }
  
  public void updateViolaPageWhenScroll(String paramString)
  {
    this.mPresenter.a().a(paramString);
  }
  
  public void useNightMode()
  {
    if ((getTitleRootView() != null) && (!TextUtils.isEmpty(getUrl())) && ("1".equals(this.mPresenter.a(getUrl(), "support_night"))))
    {
      boolean bool = ThemeUtil.isInNightMode(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime());
      FrameLayout localFrameLayout = new FrameLayout(getContentView().getContext());
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
      localFrameLayout.setBackgroundColor(Color.parseColor("#77000000"));
      getTitleRootView().addView(localFrameLayout, localLayoutParams);
      if (bool)
      {
        localFrameLayout.setVisibility(0);
        setStatusBarColor("#ff888888", true);
        return;
      }
      localFrameLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment
 * JD-Core Version:    0.7.0.1
 */