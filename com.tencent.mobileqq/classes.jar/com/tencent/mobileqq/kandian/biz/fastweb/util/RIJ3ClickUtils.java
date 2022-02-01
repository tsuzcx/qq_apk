package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager;
import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager.Companion;
import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager.RIJRewardData;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher.ForEachObserverJob;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/fastweb/util/RIJ3ClickUtils;", "", "()V", "COIN_ICON", "", "FAVOURITE_ICON", "FIRST_3CLICK_KEY", "", "LIKE_ICON", "REQUEST_COUNT", "SUCCESS_CODE", "SWITCH_3CLICK_KEY", "SWITCH_SCENE_ARTICLE", "SWITCH_SCENE_VIDEO", "TAG", "TRIGGER_ICON", "absBaseArticleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "clickRespObserver", "Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "getClickRespObserver", "()Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "setClickRespObserver", "(Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;)V", "fastWebArticleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/FastWebArticleInfo;", "imageViewRef", "Lmqq/util/WeakReference;", "Landroid/widget/ImageView;", "isCoinInsuffcient", "", "isRequestIng", "requestCountFlag", "addAnimationView", "", "v", "Landroid/view/View;", "fastWebActivity", "Lcom/tencent/mobileqq/kandian/biz/fastweb/FastWebActivity;", "container", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;", "addLongClickListener", "itemData", "Lcom/tencent/mobileqq/kandian/repo/pts/entity/ProteusItemData;", "calculatePosition", "context", "Landroid/content/Context;", "location", "", "changeRequestFlag", "type", "resultCode", "data", "destroy", "getToastMsg", "isSuccess", "hasClicked", "scene", "init", "isAllRequestBack", "isAllSuccess", "webInfo", "isSwitchOpen", "playAnimation", "playFinalAnimation", "playStartAnimation", "view", "playSuccess", "playSuccessAnimation", "refreshWebInfo", "report3Click", "report3ClickCoin", "success", "request", "requestCoin", "articleInfo", "fastWebInfo", "requestFavourite", "requestLike", "reset3ClickStatus", "showTipsWindow", "showToast", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJ3ClickUtils
{
  private static int jdField_a_of_type_Int;
  public static final RIJ3ClickUtils a;
  @NotNull
  private static ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = (ReadInJoyObserver)new RIJ3ClickUtils.clickRespObserver.1();
  private static AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private static FastWebArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
  private static WeakReference<ImageView> jdField_a_of_type_MqqUtilWeakReference;
  private static boolean jdField_a_of_type_Boolean;
  private static boolean b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilRIJ3ClickUtils = new RIJ3ClickUtils();
  }
  
  private final String a(Context paramContext, boolean paramBoolean)
  {
    Object localObject = null;
    String str = (String)null;
    if ((!paramBoolean) || (paramContext != null))
    {
      try
      {
        localObject = paramContext.getString(2131699847);
      }
      catch (Exception paramContext)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getToastMsg error!  s={");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append('}');
        QLog.d("RIJ3ClickUtils", 1, ((StringBuilder)localObject).toString());
        return str;
      }
      if (jdField_a_of_type_Boolean)
      {
        if (paramContext != null) {
          localObject = paramContext.getString(2131699845);
        }
      }
      else if (paramContext != null) {
        localObject = paramContext.getString(2131699846);
      }
    }
    return localObject;
  }
  
  private final void a(int paramInt)
  {
    Object localObject = jdField_a_of_type_MqqUtilWeakReference;
    if (localObject != null) {
      localObject = (ImageView)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      RIJCoinAnimationUtils localRIJCoinAnimationUtils = RIJCoinAnimationUtils.a;
      View localView = (View)localObject;
      if (paramInt == 3) {
        localObject = "https://pub.idqqimg.com/pc/misc/files/20210222/409c497bc02c461ca3ddce295ff82051.png";
      } else {
        localObject = "https://pub.idqqimg.com/pc/misc/files/20210222/787ce77f35814d6d85dace5ce3a871e3.png";
      }
      localRIJCoinAnimationUtils.a(localView, (String)localObject, paramInt);
    }
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    FastWebArticleInfo localFastWebArticleInfo = jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
    if (localFastWebArticleInfo != null)
    {
      boolean bool;
      if (paramInt2 == 0) {
        bool = true;
      } else {
        bool = false;
      }
      if (paramInt1 == 6)
      {
        if (bool)
        {
          localFastWebArticleInfo.jdField_e_of_type_Boolean = true;
          localFastWebArticleInfo.jdField_e_of_type_Int += 1;
        }
        else if (paramInt2 == 1034)
        {
          jdField_a_of_type_Boolean = true;
        }
        c(bool);
      }
      if (!bool) {
        return;
      }
      if (paramInt1 != 5)
      {
        if (paramInt1 != 7) {
          return;
        }
        if (!localFastWebArticleInfo.jdField_a_of_type_Boolean)
        {
          localFastWebArticleInfo.jdField_a_of_type_Boolean = true;
          localFastWebArticleInfo.jdField_a_of_type_Int += 1;
        }
      }
      else
      {
        localFastWebArticleInfo.a(true);
      }
    }
  }
  
  private final void a(int paramInt1, int paramInt2, Object paramObject)
  {
    jdField_a_of_type_Int += 1;
  }
  
  private final void a(Context paramContext, FastWebActivity paramFastWebActivity, Container paramContainer, int[] paramArrayOfInt)
  {
    paramFastWebActivity = paramFastWebActivity.b;
    if (paramFastWebActivity != null)
    {
      int[] arrayOfInt1 = new int[2];
      paramContainer.getLocationOnScreen(arrayOfInt1);
      int[] arrayOfInt2 = new int[2];
      paramFastWebActivity.getLocationOnScreen(arrayOfInt2);
      float f3 = paramContext.getResources().getDimension(2131298842);
      float f2 = paramContext.getResources().getDimension(2131298841);
      float f1 = paramContainer.getWidth() / 2;
      f3 /= 2;
      float f4 = arrayOfInt1[1] - arrayOfInt2[1];
      f2 = f2 * 4 / 5;
      if (paramArrayOfInt.length >= 2)
      {
        paramArrayOfInt[0] = ((int)(f1 - f3));
        paramArrayOfInt[1] = ((int)(f4 - f2));
      }
    }
  }
  
  private final void a(View paramView)
  {
    Object localObject1 = paramView.getTag();
    paramView = jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if ((paramView != null) && ((localObject1 instanceof Integer)))
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("touin", paramView.getSubscribeUin());
        ((JSONObject)localObject2).put("rowkey", paramView.innerUniqueID);
        ((JSONObject)localObject2).put("channel_id", paramView.mChannelID);
        ((JSONObject)localObject2).put("page_type", 2);
        ((JSONObject)localObject2).put("trigger_icon ", ((Number)localObject1).intValue());
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800BAFD", "0X800BAFD", 0, 0, "", "", "", ((JSONObject)localObject2).toString(), false);
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("report error! e={");
        ((StringBuilder)localObject2).append(localException);
        ((StringBuilder)localObject2).append('}');
        QLog.d("RIJ3ClickUtils", 1, ((StringBuilder)localObject2).toString());
      }
      RIJUniteReportUtils.a.a(paramView, 2, 2);
    }
  }
  
  private final void a(View paramView, FastWebActivity paramFastWebActivity, Container paramContainer)
  {
    if ((paramFastWebActivity.a instanceof ViewGroup))
    {
      Context localContext = paramView.getContext();
      paramView = jdField_a_of_type_MqqUtilWeakReference;
      if (paramView != null) {
        paramView = (ImageView)paramView.get();
      } else {
        paramView = null;
      }
      Object localObject = paramView;
      if (paramView == null)
      {
        localObject = new ImageView(localContext);
        jdField_a_of_type_MqqUtilWeakReference = new WeakReference(localObject);
        paramView = paramFastWebActivity.a;
        if (paramView != null) {
          ((ViewGroup)paramView).addView((View)localObject);
        } else {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
      }
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      float f1 = localContext.getResources().getDimension(2131298842);
      float f2 = localContext.getResources().getDimension(2131298841);
      paramView = new int[2];
      a(localContext, paramFastWebActivity, paramContainer, paramView);
      if ((paramView[0] > 0) && (paramView[1] > 0))
      {
        paramFastWebActivity = new RelativeLayout.LayoutParams((int)f1, (int)f2);
        paramFastWebActivity.topMargin = paramView[1];
        paramFastWebActivity.leftMargin = paramView[0];
        ((ImageView)localObject).setLayoutParams((ViewGroup.LayoutParams)paramFastWebActivity);
      }
    }
  }
  
  private final void a(FastWebActivity paramFastWebActivity, View paramView, Container paramContainer)
  {
    a(paramView, paramFastWebActivity, paramContainer);
    a(2);
  }
  
  private final void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ReadInJoyLogicEngineEventDispatcher.a().a((ReadInJoyLogicEngineEventDispatcher.ForEachObserverJob)new RIJ3ClickUtils.requestFavourite.1(paramAbsBaseArticleInfo));
  }
  
  private final void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("request_scene_type", 6);
    ReadInJoyLogicEngine localReadInJoyLogicEngine = ReadInJoyLogicEngine.a();
    paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.getSubscribeUin();
    long l;
    if (paramAbsBaseArticleInfo != null) {
      l = Long.parseLong(paramAbsBaseArticleInfo);
    } else {
      l = 0L;
    }
    localReadInJoyLogicEngine.a(l, 1, paramFastWebArticleInfo.j, (Bundle)localObject);
    paramAbsBaseArticleInfo = jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
    if (paramAbsBaseArticleInfo != null)
    {
      paramFastWebArticleInfo = RIJVideoRewardCoinManager.a;
      localObject = paramAbsBaseArticleInfo.j;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it.rowKey");
      int i;
      if (paramAbsBaseArticleInfo.jdField_e_of_type_Boolean) {
        i = 3;
      } else {
        i = 1;
      }
      paramFastWebArticleInfo.a("0X800B2EB", new RIJVideoRewardCoinManager.RIJRewardData((String)localObject, i), 6);
    }
  }
  
  private final void a(FastWebArticleInfo paramFastWebArticleInfo)
  {
    ReadInJoyLogicEngine.a().a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin(), true, paramFastWebArticleInfo, 7);
    paramFastWebArticleInfo = jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (paramFastWebArticleInfo != null) {
      ReportUtil.b(paramFastWebArticleInfo, "0X8009764", "2");
    }
  }
  
  private final boolean a()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    try
    {
      String str = Aladdin.getConfig(460).getString("rij_sanlian_switch", null);
      if (str != null)
      {
        bool2 = bool3;
        localObject = (CharSequence)str;
        bool2 = bool3;
        localObject = ((Collection)new Regex("|").split((CharSequence)localObject, 0)).toArray(new String[0]);
        if (localObject != null)
        {
          bool2 = bool3;
          bool1 = ArraysKt.contains((String[])localObject, "2");
        }
        else
        {
          bool2 = bool3;
          throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
      }
      bool2 = bool1;
      localObject = new StringBuilder();
      bool2 = bool1;
      ((StringBuilder)localObject).append("isSwitchOpen content={");
      bool2 = bool1;
      ((StringBuilder)localObject).append(str);
      bool2 = bool1;
      ((StringBuilder)localObject).append('}');
      bool2 = bool1;
      QLog.d("RIJ3ClickUtils", 1, ((StringBuilder)localObject).toString());
      return bool1;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSwitchOpen error! e={");
      ((StringBuilder)localObject).append(localException);
      ((StringBuilder)localObject).append('}');
      QLog.d("RIJ3ClickUtils", 1, ((StringBuilder)localObject).toString());
    }
    return bool2;
  }
  
  private final boolean a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("first_3click_Key");
    ((StringBuilder)localObject).append(paramInt);
    localObject = (Boolean)RIJSPUtils.a(((StringBuilder)localObject).toString(), Boolean.valueOf(false));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("first_3click_Key");
    localStringBuilder.append(paramInt);
    RIJSPUtils.a(localStringBuilder.toString(), Boolean.valueOf(true));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "hasClicked");
    return ((Boolean)localObject).booleanValue();
  }
  
  private final boolean a(FastWebArticleInfo paramFastWebArticleInfo)
  {
    return (paramFastWebArticleInfo.jdField_a_of_type_Boolean) && (paramFastWebArticleInfo.jdField_e_of_type_Boolean) && (paramFastWebArticleInfo.c);
  }
  
  private final void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c();
    }
    else
    {
      a(false);
      RIJCoinAnimationUtils.a.b();
      RIJCoinAnimationUtils.a.a();
    }
    d();
  }
  
  private final boolean b()
  {
    boolean bool;
    if (jdField_a_of_type_Int == 3) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isAllRequestBack,  requestCountFlag={");
    localStringBuilder.append(jdField_a_of_type_Int);
    localStringBuilder.append('}');
    QLog.d("RIJ3ClickUtils", 1, localStringBuilder.toString());
    return bool;
  }
  
  private final void c()
  {
    QLog.d("RIJ3ClickUtils", 1, "playSuccessAnimation!");
    a(3);
  }
  
  private final void c(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("video_mode", 6);
        Object localObject1 = jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
        localStringBuilder = null;
        if (localObject1 != null)
        {
          localObject1 = ((AbsBaseArticleInfo)localObject1).innerUniqueID;
          localJSONObject.put("rowkey", localObject1);
          localJSONObject.put("number", 1);
          if (!paramBoolean) {
            break label202;
          }
          i = 1;
          localJSONObject.put("result", i);
          localJSONObject.put("click_type", 2);
          IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
          AbsBaseArticleInfo localAbsBaseArticleInfo = jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
          localObject1 = localStringBuilder;
          if (localAbsBaseArticleInfo != null) {
            localObject1 = localAbsBaseArticleInfo.innerUniqueID;
          }
          localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X800B2EC", "0X800B2EC", 0, 0, (String)localObject1, "", "", localJSONObject.toString(), false);
          return;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("report error! e={");
        localStringBuilder.append(localException);
        localStringBuilder.append('}');
        QLog.d("RIJ3ClickUtils", 1, localStringBuilder.toString());
        return;
      }
      Object localObject2 = null;
      continue;
      label202:
      int i = 2;
    }
  }
  
  private final void d()
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_Int = 0;
    b = false;
  }
  
  private final void e()
  {
    FastWebArticleInfo localFastWebArticleInfo = jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
    Object localObject = jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if ((localFastWebArticleInfo != null) && (localObject != null))
    {
      try
      {
        d();
        b = true;
        a(localFastWebArticleInfo);
        a((AbsBaseArticleInfo)localObject, localFastWebArticleInfo);
        a((AbsBaseArticleInfo)localObject);
      }
      catch (Exception localException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("request,error! msg={");
        ((StringBuilder)localObject).append(localException);
        ((StringBuilder)localObject).append('}');
        QLog.d("RIJ3ClickUtils", 1, ((StringBuilder)localObject).toString());
      }
      QLog.d("RIJ3ClickUtils", 1, "request!");
      return;
    }
    QLog.d("RIJ3ClickUtils", 1, "request error!");
  }
  
  public final void a()
  {
    jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = (AbsBaseArticleInfo)null;
    jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo = (FastWebArticleInfo)null;
    jdField_a_of_type_MqqUtilWeakReference = (WeakReference)null;
    d();
    ReadInJoyLogicEngineEventDispatcher.a().b(jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public final void a(@Nullable View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    if (!a()) {
      return;
    }
    if (a(paramInt))
    {
      QLog.d("RIJ3ClickUtils", 1, "hasClicked!");
      return;
    }
    BaseApplication localBaseApplication = BaseApplication.context;
    if (localBaseApplication != null)
    {
      paramInt = (int)localBaseApplication.getResources().getDimension(2131298805);
      int i = (int)localBaseApplication.getResources().getDimension(2131298804);
      PopupWindow localPopupWindow = new PopupWindow(paramInt, i);
      localPopupWindow.setContentView(LayoutInflater.from((Context)localBaseApplication).inflate(2131560108, null));
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      localPopupWindow.setBackgroundDrawable((Drawable)new ColorDrawable());
      localPopupWindow.setOutsideTouchable(true);
      localPopupWindow.setAnimationStyle(2131756314);
      Runnable localRunnable = (Runnable)new RIJ3ClickUtils.showTipsWindow.1.runnable.1(localPopupWindow);
      paramView.postDelayed(localRunnable, 4000L);
      localPopupWindow.setOnDismissListener((PopupWindow.OnDismissListener)new RIJ3ClickUtils.showTipsWindow..inlined.let.lambda.1(localRunnable, localBaseApplication, paramView));
      localPopupWindow.showAtLocation(paramView, 51, arrayOfInt[0] - (paramInt / 2 - paramView.getWidth() / 2), arrayOfInt[1] - i);
    }
  }
  
  public final void a(@Nullable ProteusItemData paramProteusItemData, @Nullable Container paramContainer, @NotNull FastWebActivity paramFastWebActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramFastWebActivity, "fastWebActivity");
    if ((paramProteusItemData != null) && (paramContainer != null)) {
      try
      {
        jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramProteusItemData.b;
        jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo = paramProteusItemData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
        b(paramProteusItemData, paramContainer, paramFastWebActivity);
        ReadInJoyLogicEngineEventDispatcher.a().a(jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
        return;
      }
      catch (Throwable paramProteusItemData)
      {
        paramContainer = new StringBuilder();
        paramContainer.append("init error!  msg={");
        paramContainer.append(paramProteusItemData);
        paramContainer.append('}');
        QLog.d("RIJ3ClickUtils", 1, paramContainer.toString());
        return;
      }
    }
    QLog.d("RIJ3ClickUtils", 1, "init error!");
  }
  
  public final void a(boolean paramBoolean)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str = a((Context)localBaseApplication, paramBoolean);
    if (str != null) {
      ThreadManager.getUIHandler().post((Runnable)new RIJ3ClickUtils.showToast..inlined.let.lambda.1(str, localBaseApplication, paramBoolean));
    }
  }
  
  public final void b()
  {
    QLog.d("RIJ3ClickUtils", 1, "playSuccessAnimation!");
    Object localObject = jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
    if (localObject != null)
    {
      if (!b) {
        return;
      }
      boolean bool1 = a((FastWebArticleInfo)localObject);
      boolean bool2 = b();
      if (bool1) {
        b(bool1);
      } else if (bool2) {
        b(bool1);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playSuccessAnimation! isAllSuccess={");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append("}, isAllRequestBack={");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append('}');
      QLog.d("RIJ3ClickUtils", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public final void b(@Nullable ProteusItemData paramProteusItemData, @Nullable Container paramContainer, @NotNull FastWebActivity paramFastWebActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramFastWebActivity, "fastWebActivity");
    if (paramContainer != null)
    {
      Object localObject = paramContainer.getVirtualView();
      if (localObject != null)
      {
        paramProteusItemData = FastWebPTSUtils.a((ViewBase)localObject, "id_like");
        View localView = FastWebPTSUtils.a((ViewBase)localObject, "id_coin");
        localObject = FastWebPTSUtils.a((ViewBase)localObject, "id_favourite");
        if ((paramProteusItemData != null) && (localView != null) && (localObject != null))
        {
          if (!a()) {
            return;
          }
          paramContainer = (View.OnLongClickListener)new RIJ3ClickUtils.addLongClickListener.longClickListener.1(paramFastWebActivity, paramContainer);
          paramProteusItemData.setLongClickable(true);
          localView.setLongClickable(true);
          ((View)localObject).setLongClickable(true);
          paramProteusItemData.setTag(Integer.valueOf(1));
          ((View)localObject).setTag(Integer.valueOf(2));
          localView.setTag(Integer.valueOf(3));
          paramProteusItemData.setOnLongClickListener(paramContainer);
          localView.setOnLongClickListener(paramContainer);
          ((View)localObject).setOnLongClickListener(paramContainer);
          return;
        }
        QLog.d("RIJ3ClickUtils", 1, "addLongClickListener error!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.RIJ3ClickUtils
 * JD-Core Version:    0.7.0.1
 */