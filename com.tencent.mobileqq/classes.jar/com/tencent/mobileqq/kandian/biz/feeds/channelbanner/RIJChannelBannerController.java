package com.tencent.mobileqq.kandian.biz.feeds.channelbanner;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelBannerInfo;
import com.tencent.mobileqq.kandian.repo.pts.PTSStyleManager;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/channelbanner/RIJChannelBannerController;", "", "channelId", "", "context", "Landroid/content/Context;", "channelBannerView", "Lcom/tencent/mobileqq/kandian/biz/feeds/channelbanner/RIJChannelBannerView;", "(ILandroid/content/Context;Lcom/tencent/mobileqq/kandian/biz/feeds/channelbanner/RIJChannelBannerView;)V", "channelBannerInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ChannelBannerInfo;", "getChannelBannerView", "()Lcom/tencent/mobileqq/kandian/biz/feeds/channelbanner/RIJChannelBannerView;", "setChannelBannerView", "(Lcom/tencent/mobileqq/kandian/biz/feeds/channelbanner/RIJChannelBannerView;)V", "ptsComposer", "Lcom/tencent/pts/core/PTSComposer;", "ptsUpdateDataListener", "Lcom/tencent/pts/core/PTSComposer$IPTSUpdateDataListener;", "ptsliteEventListener", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "rijChannelBannerReport", "Lcom/tencent/mobileqq/kandian/biz/feeds/channelbanner/RIJChannelBannerReport;", "clickBannerCard", "", "clickBannerItem", "uin", "", "avatarStatus", "destroy", "exposeBannerCard", "exposeBannerItem", "exposeChannelBanner", "init", "rijChannelBannerView", "loadChannelBannerView", "refreshChannelBannerView", "reportData", "requestChannelBannerData", "setChannelBannerVisible", "visible", "", "updateAvatarStatus", "identifier", "newAvatarStatus", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJChannelBannerController
{
  public static final RIJChannelBannerController.Companion a;
  private final int jdField_a_of_type_Int;
  private final RIJChannelBannerReport jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerReport = new RIJChannelBannerReport();
  @Nullable
  private RIJChannelBannerView jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerView;
  private ChannelBannerInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelBannerInfo;
  private final PTSComposer.IPTSUpdateDataListener jdField_a_of_type_ComTencentPtsCorePTSComposer$IPTSUpdateDataListener = (PTSComposer.IPTSUpdateDataListener)new RIJChannelBannerController.ptsUpdateDataListener.1(this);
  private PTSComposer jdField_a_of_type_ComTencentPtsCorePTSComposer;
  private IPTSLiteEventListener jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerController$Companion = new RIJChannelBannerController.Companion(null);
  }
  
  public RIJChannelBannerController(int paramInt, @NotNull Context paramContext, @Nullable RIJChannelBannerView paramRIJChannelBannerView)
  {
    this.jdField_a_of_type_Int = paramInt;
    a(paramInt, paramContext, paramRIJChannelBannerView);
  }
  
  private final void a(int paramInt, Context paramContext, RIJChannelBannerView paramRIJChannelBannerView)
  {
    if (!RIJChannelBannerUtil.a.a(paramInt)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerView = paramRIJChannelBannerView;
    this.jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener = ((IPTSLiteEventListener)new RIJChannelBannerController.init.1(this, paramContext));
    paramContext = ReadInJoyUtils.a();
    if (paramContext != null)
    {
      paramContext = (ReadInJoyLogicManager)((QQAppInterface)paramContext).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (paramContext != null)
      {
        paramContext = paramContext.getReadInJoyLogicEngine();
        if (paramContext != null)
        {
          paramContext = paramContext.a();
          if (paramContext != null)
          {
            paramContext = paramContext.a(paramInt);
            break label87;
          }
        }
      }
      paramContext = null;
      label87:
      if ((paramContext != null) && ((((Collection)paramContext).isEmpty() ^ true))) {
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelBannerInfo = ((ChannelBannerInfo)paramContext.get(0));
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  private final void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      QLog.i("RIJChannelBannerController", 1, "[updateAvatarStatus] identifier is empty.");
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentPtsCorePTSComposer;
    if (localObject != null) {
      localObject = ((PTSComposer)localObject).getJsonData();
    } else {
      localObject = null;
    }
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject1 = new JSONObject((String)localObject);
        JSONArray localJSONArray = localJSONObject1.optJSONArray("subscribers");
        i = 0;
        if (localJSONArray == null) {
          break label235;
        }
        j = localJSONArray.length();
        if (i < j)
        {
          JSONObject localJSONObject2 = localJSONArray.optJSONObject(i);
          CharSequence localCharSequence = (CharSequence)paramString;
          if (localJSONObject2 == null) {
            break label241;
          }
          localObject = localJSONObject2.getString("uin");
          if (!TextUtils.equals(localCharSequence, (CharSequence)localObject)) {
            break label247;
          }
          localJSONObject2.put("avatar_status", paramInt);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[updateAvatarStatus] succeed, identifier = ");
          ((StringBuilder)localObject).append(paramString);
          QLog.i("RIJChannelBannerController", 1, ((StringBuilder)localObject).toString());
        }
        paramString = this.jdField_a_of_type_ComTencentPtsCorePTSComposer;
        if (paramString != null)
        {
          paramString.setData(localJSONObject1.toString());
          return;
        }
      }
      catch (JSONException paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[updateAvatarStatus] failed, e = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("RIJChannelBannerController", 1, ((StringBuilder)localObject).toString());
      }
      return;
      label235:
      int j = 0;
      continue;
      label241:
      localObject = null;
      continue;
      label247:
      i += 1;
    }
  }
  
  private final void a(String paramString1, String paramString2, ChannelBannerInfo paramChannelBannerInfo)
  {
    RIJChannelBannerReport.R5Builder localR5Builder = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerReport.a(paramChannelBannerInfo);
    localR5Builder.a("puin", paramString1);
    paramChannelBannerInfo = (CharSequence)String.valueOf(1);
    CharSequence localCharSequence = (CharSequence)paramString2;
    boolean bool = TextUtils.equals(paramChannelBannerInfo, localCharSequence);
    paramChannelBannerInfo = "1";
    if (bool) {
      paramString2 = "1";
    } else {
      paramString2 = "0";
    }
    localR5Builder.a("is_live", paramString2);
    if (TextUtils.equals((CharSequence)String.valueOf(2), localCharSequence)) {
      paramString2 = paramChannelBannerInfo;
    } else {
      paramString2 = "0";
    }
    localR5Builder.a("is_update", paramString2);
    ((Map)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerReport.c()).put(paramString1, localR5Builder);
  }
  
  private final void b(ChannelBannerInfo paramChannelBannerInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[exposeBannerCard] channelBannerInfo = ");
    localStringBuilder.append(paramChannelBannerInfo);
    QLog.i("RIJChannelBannerController", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty((CharSequence)paramChannelBannerInfo.a())) {
      ((Map)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerReport.a()).put(paramChannelBannerInfo.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerReport.a(paramChannelBannerInfo));
    }
  }
  
  private final void b(String paramString1, String paramString2, ChannelBannerInfo paramChannelBannerInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[clickBannerCard] uin = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", avatarStatus = ");
    ((StringBuilder)localObject).append(paramString2);
    QLog.i("RIJChannelBannerController", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerReport.a(paramChannelBannerInfo);
    ((RIJChannelBannerReport.R5Builder)localObject).a("puin", paramString1);
    paramChannelBannerInfo = (CharSequence)String.valueOf(1);
    CharSequence localCharSequence = (CharSequence)paramString2;
    boolean bool = TextUtils.equals(paramChannelBannerInfo, localCharSequence);
    paramChannelBannerInfo = "1";
    if (bool) {
      paramString2 = "1";
    } else {
      paramString2 = "0";
    }
    ((RIJChannelBannerReport.R5Builder)localObject).a("is_live", paramString2);
    if (TextUtils.equals((CharSequence)String.valueOf(2), localCharSequence)) {
      paramString2 = paramChannelBannerInfo;
    } else {
      paramString2 = "0";
    }
    ((RIJChannelBannerReport.R5Builder)localObject).a("is_update", paramString2);
    ((Map)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerReport.d()).put(paramString1, localObject);
  }
  
  private final void c(ChannelBannerInfo paramChannelBannerInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[clickBannerCard] channelBannerInfo = ");
    localStringBuilder.append(paramChannelBannerInfo);
    QLog.i("RIJChannelBannerController", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty((CharSequence)paramChannelBannerInfo.a())) {
      ((Map)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerReport.b()).put(paramChannelBannerInfo.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerReport.a(paramChannelBannerInfo));
    }
  }
  
  @Nullable
  public final RIJChannelBannerView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerView;
  }
  
  public final void a()
  {
    QLog.i("RIJChannelBannerController", 1, "[RIJChannelBannerController] destroy.");
    PTSComposer localPTSComposer = this.jdField_a_of_type_ComTencentPtsCorePTSComposer;
    if (localPTSComposer != null) {
      localPTSComposer.destroy();
    }
  }
  
  public final void a(@NotNull ChannelBannerInfo paramChannelBannerInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramChannelBannerInfo, "channelBannerInfo");
    if (!RIJChannelBannerUtil.a.a(this.jdField_a_of_type_Int)) {
      return;
    }
    Object localObject1 = paramChannelBannerInfo.b();
    String str = PTSStyleManager.a().a("default_feeds", (String)localObject1);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[refreshChannelBannerView] pageName = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.i("RIJChannelBannerController", 1, ((StringBuilder)localObject2).toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)str)))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelBannerInfo = paramChannelBannerInfo;
      b(paramChannelBannerInfo);
      localObject2 = this.jdField_a_of_type_ComTencentPtsCorePTSComposer;
      if (localObject2 != null) {
        ((PTSComposer)localObject2).destroy();
      }
      paramChannelBannerInfo = PTSComposer.buildComposer((String)localObject1, str, paramChannelBannerInfo.c(), this.jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener, this.jdField_a_of_type_ComTencentPtsCorePTSComposer$IPTSUpdateDataListener);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerView;
      if (localObject1 != null) {
        ((RIJChannelBannerView)localObject1).post((Runnable)new RIJChannelBannerController.refreshChannelBannerView.1(this, paramChannelBannerInfo));
      }
      return;
    }
    QLog.e("RIJChannelBannerController", 1, "[refreshChannelBannerView] pageName or frameTreeJson is empty.");
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[setChannelBannerViewVisibility], visible = ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("RIJChannelBannerController", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerView;
    if (localObject != null)
    {
      localObject = ((RIJChannelBannerView)localObject).a();
      if (localObject != null)
      {
        int i;
        if (paramBoolean) {
          i = 0;
        } else {
          i = 8;
        }
        ((PTSItemView)localObject).setVisibility(i);
      }
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelBannerInfo = ((ChannelBannerInfo)null);
    }
  }
  
  public final void b()
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject != null)
    {
      localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (localObject != null)
      {
        localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine();
        if (localObject != null)
        {
          localObject = ((ReadInJoyLogicEngine)localObject).a();
          if (localObject != null) {
            ((RIJChannelBannerModule)localObject).a(this.jdField_a_of_type_Int, 1);
          }
        }
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public final void c()
  {
    ChannelBannerInfo localChannelBannerInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelBannerInfo;
    if (localChannelBannerInfo != null) {
      a(localChannelBannerInfo);
    }
  }
  
  public final void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerReport.a();
  }
  
  public final void e()
  {
    ChannelBannerInfo localChannelBannerInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelBannerInfo;
    if (localChannelBannerInfo != null) {
      b(localChannelBannerInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelBannerController
 * JD-Core Version:    0.7.0.1
 */