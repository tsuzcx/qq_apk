package com.tencent.mobileqq.kandian.biz.diandian.entryview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.diandian.entryview.report.RIJEntryViewReport;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.kandian.biz.ugc.selecttopic.SlidingUpDialog;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.account.UserLevelInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.ColumnInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.JumpInfo;
import com.tencent.mobileqq.kandian.repo.ugc.DeliverData;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.adapter.entryview.BizEntryDialogView;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/diandian/entryview/RIJEntryViewUtils;", "", "()V", "ENABLE_UPLOAD_IMAGE_TEXT", "", "ENABLE_UPLOAD_VIDEO", "SHOW_ENTRY_VIEW", "TAG", "UPLOAD_AUTH_IMAGE_TEXT", "UPLOAD_AUTH_VIDEO", "assembleDataToJson", "Lorg/json/JSONObject;", "resultCode", "", "type", "isDeliverStart", "", "multiBiuStruct", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo;", "Lkotlin/collections/ArrayList;", "photos", "", "data", "Lcom/tencent/mobileqq/kandian/repo/ugc/DeliverData;", "kdCommunityInfo", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "position", "Lcom/tencent/mobileqq/tribe/data/TroopBarPOI;", "rowkey", "callEntryViewClickAction", "", "activity", "Landroid/app/Activity;", "from", "requestCode", "columnInfo", "Lcom/tencent/mobileqq/kandian/repo/db/struct/ColumnInfo;", "callback", "getConfigFromAladdin", "nameSpace", "keyString", "getMainTLAladdinConfig", "getPersonalCenterAladdinConfig", "jumpUGCPublisherActivity", "Landroid/os/Bundle;", "communityInfo", "parseMultiBiuStruct2Json", "originMultiBiuStruct", "shouldShowEntryView", "showEntryDialog", "leftIconClickListener", "Lkotlin/Function0;", "rightIconClickListener", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJEntryViewUtils
{
  public static final RIJEntryViewUtils a = new RIJEntryViewUtils();
  
  @JvmStatic
  @NotNull
  public static final JSONObject a(int paramInt1, int paramInt2, boolean paramBoolean, @NotNull ArrayList<BiuCommentInfo> paramArrayList, @NotNull List<? extends Object> paramList, @NotNull DeliverData paramDeliverData, @Nullable CommunityInfo paramCommunityInfo, @Nullable TroopBarPOI paramTroopBarPOI, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "multiBiuStruct");
    Intrinsics.checkParameterIsNotNull(paramList, "photos");
    Intrinsics.checkParameterIsNotNull(paramDeliverData, "data");
    Intrinsics.checkParameterIsNotNull(paramString, "rowkey");
    JSONArray localJSONArray = new JSONArray();
    int j = ((Collection)CollectionsKt.filterNotNull((Iterable)paramList)).size();
    int i = 0;
    while (i < j)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("coverUrl", paramList.get(i));
      localJSONObject.put("width", paramDeliverData.b()[i]);
      localJSONObject.put("height", paramDeliverData.c()[i]);
      localJSONArray.put(localJSONObject);
      i += 1;
    }
    paramDeliverData = new JSONObject();
    paramDeliverData.put("resultCode", paramInt1);
    paramDeliverData.put("rowkey", paramString);
    paramDeliverData.put("type", paramInt2);
    paramDeliverData.put("isDeliverStart", paramBoolean);
    paramDeliverData.put("pictures", localJSONArray);
    paramDeliverData.put("textLevel", a(paramArrayList));
    paramList = null;
    if (paramCommunityInfo != null) {
      paramArrayList = paramCommunityInfo.getCommunityId();
    } else {
      paramArrayList = null;
    }
    paramDeliverData.put("kdCommunityId", paramArrayList);
    paramArrayList = paramList;
    if (paramTroopBarPOI != null) {
      paramArrayList = paramTroopBarPOI.a();
    }
    paramDeliverData.put("location", paramArrayList);
    return paramDeliverData;
  }
  
  @JvmStatic
  @NotNull
  public static final JSONObject a(@NotNull ArrayList<BiuCommentInfo> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "originMultiBiuStruct");
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).addAll((Collection)paramArrayList);
    String str;
    if (((BiuCommentInfo)((ArrayList)localObject1).get(0)).jumpInfo == null)
    {
      str = ((BiuCommentInfo)((ArrayList)localObject1).get(0)).mBiuComment;
      Intrinsics.checkExpressionValueIsNotNull(str, "multiBiuStruct[0].mBiuComment");
      paramArrayList = new StringBuilder();
      paramArrayList.append("");
      paramArrayList.append(str);
      paramArrayList = paramArrayList.toString();
      ((ArrayList)localObject1).remove(0);
    }
    else
    {
      str = "";
      paramArrayList = str;
    }
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = ((ArrayList)localObject1).iterator();
    while (localIterator.hasNext())
    {
      BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)localIterator.next();
      JSONObject localJSONObject = new JSONObject();
      localObject1 = localBiuCommentInfo.jumpInfo;
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = ((JumpInfo)localObject1).getWording();
      } else {
        localObject1 = null;
      }
      localJSONObject.put("wording", localObject1);
      localObject1 = localBiuCommentInfo.jumpInfo;
      if (localObject1 != null) {
        localObject1 = Long.valueOf(((JumpInfo)localObject1).getId());
      } else {
        localObject1 = null;
      }
      localJSONObject.put("key", localObject1);
      localJSONObject.put("type", localBiuCommentInfo.mOpType);
      localJSONObject.put("text", localBiuCommentInfo.mBiuComment);
      JumpInfo localJumpInfo = localBiuCommentInfo.jumpInfo;
      localObject1 = localObject2;
      if (localJumpInfo != null) {
        localObject1 = localJumpInfo.getJumpUrl();
      }
      localJSONObject.put("href", localObject1);
      localJSONArray.put(localJSONObject);
      if ((localBiuCommentInfo.mOpType != 4) && (localBiuCommentInfo.mBiuComment != null))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramArrayList);
        paramArrayList = localBiuCommentInfo.jumpInfo;
        if (paramArrayList != null)
        {
          paramArrayList = paramArrayList.getWording();
          if (paramArrayList != null) {}
        }
        else
        {
          paramArrayList = "";
        }
        ((StringBuilder)localObject1).append(paramArrayList);
        ((StringBuilder)localObject1).append(localBiuCommentInfo.mBiuComment);
        paramArrayList = ((StringBuilder)localObject1).toString();
      }
    }
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("originText", paramArrayList);
    ((JSONObject)localObject1).put("text", str);
    ((JSONObject)localObject1).put("textLevelList", localJSONArray);
    return localObject1;
  }
  
  @JvmStatic
  public static final boolean a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(469);
    long l = RIJUserLevelModule.getInstance().getCurrentUserLevelInfo(7).level;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAladdinConfig.getIntegerFromString("enable_publisher_entrance", 0) == 1)
    {
      bool1 = bool2;
      if (l > 0L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private final boolean a(int paramInt, String paramString)
  {
    return Aladdin.getConfig(paramInt).getIntegerFromString(paramString, 0) == 1;
  }
  
  @JvmStatic
  public static final int b()
  {
    boolean bool1 = a.a(469, "enable_upload_video");
    boolean bool2 = a.a(469, "enable_upload_image_text");
    if ((bool1) && (bool2)) {
      return 3;
    }
    if (bool2) {
      return 2;
    }
    if (bool1) {
      return 1;
    }
    return 0;
  }
  
  public final void a(int paramInt, @NotNull Bundle paramBundle, @Nullable String paramString, @Nullable CommunityInfo paramCommunityInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "data");
    Intent localIntent = new Intent((Context)BaseApplicationImpl.getContext(), ReadInJoyDeliverUGCActivity.class);
    if (paramBundle.containsKey("extra")) {
      try
      {
        paramBundle = new JSONObject(paramBundle.getString("extra"));
        if (paramBundle.has("originTextInfo"))
        {
          paramBundle = paramBundle.getJSONObject("originTextInfo").getJSONArray("textLevelList");
          Intrinsics.checkExpressionValueIsNotNull(paramBundle, "extra.getJSONObject(Cons…ts.J_KEY_TEXT_LEVEL_LIST)");
        }
        else
        {
          paramBundle = new JSONArray();
        }
        int i = paramBundle.length();
        if (i > 0)
        {
          paramBundle = new JSONObject(paramBundle.get(0).toString());
          localIntent.putExtra("has_default_topic", true);
          localIntent.putExtra("allow_delete_topic", false);
          localIntent.putExtra("support_multi_topic", false);
          localIntent.putExtra("arg_topic_id", paramBundle.getString("key"));
          localIntent.putExtra("arg_topic_name", paramBundle.getString("wording"));
        }
        else
        {
          localIntent.putExtra("has_default_topic", false);
        }
      }
      catch (JSONException paramBundle)
      {
        QLog.e("RIJEntryViewUtils", 1, (Throwable)paramBundle, new Object[] { "error in json when get extra data" });
      }
    }
    if (paramCommunityInfo != null)
    {
      localIntent.putExtra("arg_community_id", paramCommunityInfo.getCommunityId());
      localIntent.putExtra("arg_community_title", paramCommunityInfo.getTitle());
      localIntent.putExtra("allow_select_community", false);
    }
    localIntent.putExtra("arg_callback", paramString);
    localIntent.putExtra("is_from_kan_dian", true);
    localIntent.putExtra("support_topic", true);
    localIntent.putExtra("ugcPushType", 1);
    localIntent.putExtra("key_from", paramInt);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public final void a(@NotNull Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, @Nullable ColumnInfo paramColumnInfo, @Nullable CommunityInfo paramCommunityInfo, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          QLog.e("RIJEntryViewUtils", 1, "No Permission for publisher");
          return;
        }
        a(paramActivity, (Function0)new RIJEntryViewUtils.callEntryViewClickAction.1(paramActivity, paramColumnInfo, paramCommunityInfo, paramInt2, paramString, paramInt3), (Function0)new RIJEntryViewUtils.callEntryViewClickAction.2(paramInt2, paramString, paramCommunityInfo), paramInt2);
        return;
      }
      a(paramInt2, new Bundle(), paramString, paramCommunityInfo);
      return;
    }
    RIJUgcUtils.a(paramActivity, paramColumnInfo, paramCommunityInfo, paramInt2, paramString, paramInt3);
  }
  
  public final void a(@NotNull Activity paramActivity, @NotNull Function0<Unit> paramFunction01, @NotNull Function0<Unit> paramFunction02, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramFunction01, "leftIconClickListener");
    Intrinsics.checkParameterIsNotNull(paramFunction02, "rightIconClickListener");
    Object localObject = (Context)paramActivity;
    int i = 2;
    localObject = new BizEntryDialogView((Context)localObject, false, 2, null);
    paramActivity = new SlidingUpDialog(paramActivity, (View)localObject, false, new RelativeLayout.LayoutParams(-1, paramActivity.getResources().getDimensionPixelOffset(2131299532)));
    ((BizEntryDialogView)localObject).setLeftClickListener((Function0)new RIJEntryViewUtils.showEntryDialog..inlined.let.lambda.1(paramFunction01, paramActivity, paramFunction02));
    ((BizEntryDialogView)localObject).setRightClickListener((Function0)new RIJEntryViewUtils.showEntryDialog..inlined.let.lambda.2(paramFunction01, paramActivity, paramFunction02));
    ((BizEntryDialogView)localObject).setCancelClickListener((Function0)new RIJEntryViewUtils.showEntryDialog..inlined.let.lambda.3(paramFunction01, paramActivity, paramFunction02));
    paramActivity.show();
    RIJEntryViewReport.a("0X800BBD2", paramInt);
    if (paramInt != 8) {
      if (paramInt != 9) {
        i = 0;
      } else {
        i = 3;
      }
    }
    RIJEntryViewReport.b("0X800BBD3", i);
    RIJEntryViewReport.b("0X800BBCF", i);
  }
  
  public final int c()
  {
    boolean bool1 = a(446, "upload_auth_video");
    boolean bool2 = a(446, "upload_auth_image_text");
    if ((bool1) && (bool2)) {
      return 3;
    }
    if (bool2) {
      return 2;
    }
    if (bool1) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJEntryViewUtils
 * JD-Core Version:    0.7.0.1
 */