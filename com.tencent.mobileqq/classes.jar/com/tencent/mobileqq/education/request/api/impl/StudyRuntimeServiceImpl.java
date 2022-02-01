package com.tencent.mobileqq.education.request.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.education.config.AnswerSearchConfigBean;
import com.tencent.mobileqq.education.request.IStudyCmdHandler;
import com.tencent.mobileqq.education.request.IStudyMainProcessAbility;
import com.tencent.mobileqq.education.request.StudyCmdHandler;
import com.tencent.mobileqq.education.request.StudyMainProcessAbility;
import com.tencent.mobileqq.education.request.api.IStudyRuntimeService;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/education/request/api/impl/StudyRuntimeServiceImpl;", "Lcom/tencent/mobileqq/education/request/api/IStudyRuntimeService;", "()V", "abilityInit", "", "answerPicData", "Ljava/lang/ref/WeakReference;", "", "app", "Lmqq/app/AppRuntime;", "cmdHandler", "Lcom/tencent/mobileqq/education/request/IStudyCmdHandler;", "mainProcessAbility", "Lcom/tencent/mobileqq/education/request/StudyMainProcessAbility;", "getMainProcessAbility", "()Lcom/tencent/mobileqq/education/request/StudyMainProcessAbility;", "mainProcessAbility$delegate", "Lkotlin/Lazy;", "getAnswerSearchPicData", "clear", "getCmdHandler", "Lcom/tencent/mobileqq/education/request/IStudyMainProcessAbility;", "getPicViewerAnswerSearchSwitch", "getScanAnswerSearchSwitch", "getShowScanAnswerSearchTip", "onCreate", "", "appRuntime", "onDestroy", "saveShowScanAnswerSearchTip", "value", "setAnswerSearchPicData", "data", "qq_education_impl_release"}, k=1, mv={1, 1, 16})
public final class StudyRuntimeServiceImpl
  implements IStudyRuntimeService
{
  private boolean abilityInit;
  private WeakReference<String> answerPicData;
  private AppRuntime app;
  private IStudyCmdHandler cmdHandler;
  private final Lazy mainProcessAbility$delegate = LazyKt.lazy((Function0)new StudyRuntimeServiceImpl.mainProcessAbility.2(this));
  
  private final StudyMainProcessAbility getMainProcessAbility()
  {
    return (StudyMainProcessAbility)this.mainProcessAbility$delegate.getValue();
  }
  
  @NotNull
  public String getAnswerSearchPicData(boolean paramBoolean)
  {
    Object localObject = this.answerPicData;
    if (localObject != null)
    {
      localObject = (String)((WeakReference)localObject).get();
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject, "answerPicData?.get() ?: \"\"");
    if (paramBoolean)
    {
      WeakReference localWeakReference = this.answerPicData;
      if (localWeakReference != null) {
        localWeakReference.clear();
      }
      this.answerPicData = ((WeakReference)null);
    }
    return localObject;
  }
  
  @NotNull
  public IStudyCmdHandler getCmdHandler()
  {
    IStudyCmdHandler localIStudyCmdHandler = this.cmdHandler;
    if (localIStudyCmdHandler == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cmdHandler");
    }
    return localIStudyCmdHandler;
  }
  
  @NotNull
  public IStudyMainProcessAbility getMainProcessAbility()
  {
    return (IStudyMainProcessAbility)getMainProcessAbility();
  }
  
  public boolean getPicViewerAnswerSearchSwitch()
  {
    return false;
  }
  
  public boolean getScanAnswerSearchSwitch()
  {
    AnswerSearchConfigBean localAnswerSearchConfigBean = (AnswerSearchConfigBean)QConfigManager.b().b(752);
    if (localAnswerSearchConfigBean != null) {
      return localAnswerSearchConfigBean.a;
    }
    return false;
  }
  
  public boolean getShowScanAnswerSearchTip()
  {
    return MobileQQ.sMobileQQ.getSharedPreferences("answer_search_shared_key", 4).getBoolean("ANSWER_SEARCH_SHARED_SCAN_TIP_KEY", false) ^ true;
  }
  
  public void onCreate(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "appRuntime");
    this.app = paramAppRuntime;
    paramAppRuntime = this.app;
    if (paramAppRuntime == null) {
      Intrinsics.throwUninitializedPropertyAccessException("app");
    }
    this.cmdHandler = ((IStudyCmdHandler)new StudyCmdHandler(paramAppRuntime));
  }
  
  public void onDestroy()
  {
    if (this.abilityInit) {
      getMainProcessAbility().a();
    }
  }
  
  public void saveShowScanAnswerSearchTip(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = MobileQQ.sMobileQQ.getSharedPreferences("answer_search_shared_key", 4).edit();
    localEditor.putBoolean("ANSWER_SEARCH_SHARED_SCAN_TIP_KEY", paramBoolean);
    localEditor.apply();
  }
  
  public void setAnswerSearchPicData(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "data");
    if (this.answerPicData == null) {
      this.answerPicData = new WeakReference(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.request.api.impl.StudyRuntimeServiceImpl
 * JD-Core Version:    0.7.0.1
 */