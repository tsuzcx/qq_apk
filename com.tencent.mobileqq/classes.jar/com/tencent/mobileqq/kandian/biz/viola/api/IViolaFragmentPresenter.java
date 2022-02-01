package com.tencent.mobileqq.kandian.biz.viola.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaFragmentPresenter;", "", "createHippyQQEngine", "Lcom/tencent/hippy/qq/app/HippyQQEngine;", "moduleName", "", "doOnBackPressed", "", "doOnKeyDown", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "enableFlingGesture", "enable", "getColorNote", "Lcom/tencent/mobileqq/colornote/data/ColorNote;", "bundle", "Landroid/os/Bundle;", "colorNoteController", "Lcom/tencent/mobileqq/colornote/api/IColorNoteController;", "getContentViewId", "getModuleOnlineConfig", "getPerformanceData", "Ljava/util/HashMap;", "", "getUriParamValue", "schema", "key", "getViolaInitDelegate", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaInitDelegate;", "getViolaUiDelegate", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaUiDelegate;", "handleTopGestureEvent", "initFPS", "initHippy", "contentView", "Landroid/view/ViewGroup;", "initSuspension", "initViola", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAddColorNote", "colorNote", "result", "onAttach", "activity", "Landroid/app/Activity;", "onDestroy", "onFinish", "onPause", "onResume", "openFrameDropUpload", "scene", "playColorNoteAnimation", "setColorBallData", "jsonObject", "Lorg/json/JSONObject;", "tryInitColorNote", "updateColorBallData", "updateViolaPageByData", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IViolaFragmentPresenter
{
  public abstract int a();
  
  public abstract int a(@Nullable Bundle paramBundle, boolean paramBoolean);
  
  public abstract int a(@Nullable String paramString);
  
  @NotNull
  public abstract HippyQQEngine a(@Nullable Bundle paramBundle, @Nullable ViewGroup paramViewGroup, @Nullable String paramString);
  
  @Nullable
  public abstract ColorNote a(@Nullable Bundle paramBundle, @Nullable IColorNoteController paramIColorNoteController);
  
  @NotNull
  public abstract IViolaInitDelegate a();
  
  @NotNull
  public abstract IViolaUiDelegate a();
  
  @Nullable
  public abstract String a(@Nullable String paramString1, @Nullable String paramString2);
  
  @Nullable
  public abstract HashMap<String, Long> a();
  
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent);
  
  public abstract void a(@Nullable Activity paramActivity);
  
  public abstract void a(@NotNull Bundle paramBundle, @NotNull ViewGroup paramViewGroup);
  
  public abstract void a(@Nullable ViewGroup paramViewGroup);
  
  public abstract void a(@Nullable String paramString);
  
  public abstract void a(@Nullable JSONObject paramJSONObject);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a(int paramInt, @Nullable KeyEvent paramKeyEvent);
  
  public abstract boolean a(@Nullable Bundle paramBundle);
  
  public abstract void b();
  
  public abstract void b(@Nullable JSONObject paramJSONObject);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void c();
  
  public abstract void c(@Nullable JSONObject paramJSONObject);
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentPresenter
 * JD-Core Version:    0.7.0.1
 */