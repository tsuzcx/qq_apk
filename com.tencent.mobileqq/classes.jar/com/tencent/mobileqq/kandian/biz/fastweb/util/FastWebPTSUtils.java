package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJJsonUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.item.WebProteusViewCreator.ProteusItemViewOnClickListener;
import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager;
import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager.Companion;
import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager.RIJRewardInfo;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.AuthorData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.follow.FollowingMember;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class FastWebPTSUtils
{
  public static int a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getResources();
      if (paramContext != null) {
        return paramContext.getDisplayMetrics().widthPixels;
      }
    }
    return 0;
  }
  
  public static int a(String paramString, Map<Long, FollowingMember> paramMap)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static View a(ViewBase paramViewBase, int paramInt)
  {
    String str;
    if (paramInt == 6) {
      str = "id_interaction_coin";
    } else {
      str = "id_operation_coin";
    }
    return a(paramViewBase, str);
  }
  
  public static View a(ViewBase paramViewBase, String paramString)
  {
    if (paramViewBase != null)
    {
      paramViewBase = paramViewBase.findViewBaseByName(paramString);
      if (paramViewBase != null) {
        return paramViewBase.getNativeView();
      }
    }
    return null;
  }
  
  public static String a()
  {
    return String.valueOf(b().floatValue());
  }
  
  public static String a(long paramLong, String paramString)
  {
    String str = paramString;
    if (paramLong > 0L) {
      str = ReadInJoyHelper.a(paramLong, 99990000L, "9999万+", paramString);
    }
    return str;
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    if ((paramContext != null) && (paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramFastWebArticleInfo == null) {
        return;
      }
      ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(Long.parseLong(paramString), null);
      paramFastWebArticleInfo = b(paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramAbsBaseArticleInfo.mChannelID);
      if ((localReadInJoyUserInfo != null) && (localReadInJoyUserInfo.isLiving()))
      {
        ReadInJoyUtils.a(paramContext, localReadInJoyUserInfo.getLiveUrl());
        RIJJsonUtils.a(paramFastWebArticleInfo, "live_circle_from_page", Integer.valueOf(1));
        ReportUtil.a(paramAbsBaseArticleInfo, "", paramFastWebArticleInfo.toString());
        paramContext = "0X800B17E";
      }
      else
      {
        RIJJumpUtils.c(paramString, paramAbsBaseArticleInfo);
        RIJJsonUtils.a(paramFastWebArticleInfo, "is_intensify", Integer.valueOf(paramInt));
        paramContext = "0X800898A";
      }
      ReportUtil.a(paramAbsBaseArticleInfo, paramContext, paramFastWebArticleInfo.toString());
    }
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    AnimatorSet localAnimatorSet1 = new AnimatorSet();
    AnimatorSet localAnimatorSet2 = new AnimatorSet();
    localAnimatorSet1.playTogether(new Animator[] { ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 1.0F, 0.0F }).setDuration(200L), ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 1.0F, 0.0F }).setDuration(200L) });
    localAnimatorSet2.playTogether(new Animator[] { ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.0F, 1.1F, 1.0F }).setDuration(200L), ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.0F, 1.1F, 1.0F }).setDuration(200L) });
    localAnimatorSet1.addListener(new FastWebPTSUtils.6(localAnimatorSet2));
    localAnimatorSet1.start();
  }
  
  public static void a(ViewBase paramViewBase, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    ThreadManager.a().post(new FastWebPTSUtils.4(paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramInt, paramViewBase));
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, long paramLong, String paramString, boolean paramBoolean)
  {
    if (paramAbsBaseArticleInfo != null) {
      if (paramFastWebArticleInfo == null) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        ReadinjoyReportUtils.c(paramAbsBaseArticleInfo, ReadinjoyReportUtils.d, paramBoolean, "");
        Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().c();
        localObject = ((QQAppInterface)localObject).getAccount();
        paramFastWebArticleInfo = new FastWebPTSUtils.1(paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramBoolean);
        if (!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) {
          break label121;
        }
        i = 2;
        localUserOperationModule.request0x978((String)localObject, paramLong, true, paramString, paramFastWebArticleInfo, i);
        return;
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        paramFastWebArticleInfo = new StringBuilder();
        paramFastWebArticleInfo.append("followButtonClick error! msg=");
        paramFastWebArticleInfo.append(paramAbsBaseArticleInfo);
        QLog.d("FastWebPTSUtils", 1, paramFastWebArticleInfo.toString());
      }
      return;
      label121:
      int i = 1;
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, RIJVideoRewardCoinManager paramRIJVideoRewardCoinManager, int paramInt)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramFastWebArticleInfo == null) {
        return;
      }
      if (paramFastWebArticleInfo.N)
      {
        RIJVideoRewardCoinManager.a.a();
        return;
      }
      if (paramRIJVideoRewardCoinManager == null) {
        return;
      }
      paramRIJVideoRewardCoinManager.a(new RIJVideoRewardCoinManager.RIJRewardInfo(paramFastWebArticleInfo.q, paramAbsBaseArticleInfo.getSubscribeUin(), null), paramInt);
    }
  }
  
  public static void a(FastWebArticleInfo paramFastWebArticleInfo, boolean paramBoolean, View paramView, int paramInt)
  {
    if (paramFastWebArticleInfo != null)
    {
      paramFastWebArticleInfo.N = paramBoolean;
      paramFastWebArticleInfo.M += paramInt;
    }
  }
  
  private static void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errorUrl!! detail:");
    localStringBuilder.append(paramString);
    QLog.e("FastWebPTSUtils", 1, localStringBuilder.toString());
    throw new IllegalArgumentException(paramString);
  }
  
  public static void a(List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (BaseData)paramList.next();
      if ((localObject instanceof ProteusItemData))
      {
        localObject = (ProteusItemData)localObject;
        if ((((ProteusItemData)localObject).bf == 1) && (!((ProteusItemData)localObject).bg))
        {
          if (((ProteusItemData)localObject).bb != null) {
            paramList = ((ProteusItemData)localObject).bb.toString();
          } else {
            paramList = "data error!!";
          }
          a(paramList);
        }
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      paramJSONObject.put("attribute_text_size_ratio", a());
      return;
    }
    catch (Exception paramJSONObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addTextSizeRatio error! msg=");
      localStringBuilder.append(paramJSONObject);
      QLog.d("FastWebPTSUtils", 1, localStringBuilder.toString());
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (Build.VERSION.SDK_INT > 23) && ((paramInt == 6) || (paramInt == 7));
  }
  
  public static boolean a(int paramInt, List<BaseData> paramList)
  {
    int j = b(paramList);
    paramList = Aladdin.getConfig(374);
    boolean bool2 = false;
    int i;
    if (paramList.getIntegerFromString("should_show_navbar_account_info", 0) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (paramInt > j) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(BaseData paramBaseData)
  {
    boolean bool;
    if ((paramBaseData.aP == 26) && ((paramBaseData instanceof ProteusItemData)) && (((ProteusItemData)paramBaseData).bf == 1)) {
      bool = true;
    } else {
      bool = false;
    }
    if ((paramBaseData.aP == 18) || (paramBaseData.aP == 22) || (paramBaseData.aP == 0)) {
      bool = true;
    }
    return bool;
  }
  
  protected static int b(List<BaseData> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      while (i < paramList.size())
      {
        if ((paramList.get(i) instanceof AuthorData)) {
          return i;
        }
        i += 1;
      }
    }
    return 2147483647;
  }
  
  public static View b(ViewBase paramViewBase, int paramInt)
  {
    String str;
    if (paramInt == 6) {
      str = "id_interaction_coin_txt";
    } else {
      str = "id_operation_coin_txt";
    }
    return a(paramViewBase, str);
  }
  
  public static Float b()
  {
    return (Float)RIJSPUtils.b("readinjoy_font_size_ratio_sp", Float.valueOf(1.0F));
  }
  
  private static JSONObject b(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, long paramLong)
  {
    int i = (int)paramLong;
    if (paramFastWebArticleInfo.a()) {
      paramFastWebArticleInfo = "2";
    } else {
      paramFastWebArticleInfo = "1";
    }
    return RIJTransMergeKanDianReport.a(paramContext, paramAbsBaseArticleInfo, i, paramFastWebArticleInfo);
  }
  
  public static void b(ViewBase paramViewBase, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    ThreadManager.a().post(new FastWebPTSUtils.5(paramViewBase, paramInt, paramAbsBaseArticleInfo, paramFastWebArticleInfo));
  }
  
  public static void b(BaseData paramBaseData)
  {
    if ((paramBaseData instanceof ProteusItemData)) {
      a(((ProteusItemData)paramBaseData).bb);
    }
  }
  
  public static float c()
  {
    return 16.0F;
  }
  
  public static WebProteusViewCreator.ProteusItemViewOnClickListener d()
  {
    return new FastWebPTSUtils.2();
  }
  
  public static WebProteusViewCreator.ProteusItemViewOnClickListener e()
  {
    return new FastWebPTSUtils.3();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSUtils
 * JD-Core Version:    0.7.0.1
 */