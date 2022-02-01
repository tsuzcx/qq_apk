package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.kandian.biz.flutter.FlutterPageSetting;
import com.tencent.mobileqq.kandian.biz.flutter.RIJFlutterUtils;
import com.tencent.mobileqq.kandian.biz.publisher.TKDPublisherUtils;
import com.tencent.mobileqq.kandian.biz.publisher.config.PublisherRemoteConfig;
import com.tencent.mobileqq.kandian.biz.publisher.ktx.PublishArticleInfoExtKt;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.coverselect.CoverSelectTabFragment;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.kandian.biz.ugc.selectmember.ReadInJoySelectMemberFragment;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.ugc.ResultRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.bean.LocationInfo;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.coverselect.CoverSelectData;
import com.tencent.tkd.topicsdk.coverselect.CoverSelectPage;
import com.tencent.tkd.topicsdk.coverselect.CoverSelectPage.Companion;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEventObserver;
import com.tencent.tkd.topicsdk.interfaces.IAccount;
import com.tencent.tkd.topicsdk.interfaces.IStorageConfig;
import com.tencent.tkd.topicsdk.interfaces.IUserActionHandler;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import com.tencent.tkd.weibo.tweetTopic.TweetTopicView;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/UserActionHandlerImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IUserActionHandler;", "()V", "atContractCallback", "Lkotlin/Function2;", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/weibo/bean/EditObject;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "editObjects", "Landroid/os/Bundle;", "outputBundle", "", "coverChangeObserver", "com/tencent/mobileqq/kandian/biz/publisher/impls/UserActionHandlerImpl$coverChangeObserver$1", "Lcom/tencent/mobileqq/kandian/biz/publisher/impls/UserActionHandlerImpl$coverChangeObserver$1;", "coverSelectData", "Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectData;", "observer", "com/tencent/mobileqq/kandian/biz/publisher/impls/UserActionHandlerImpl$observer$1", "Lcom/tencent/mobileqq/kandian/biz/publisher/impls/UserActionHandlerImpl$observer$1;", "positionContractCallback", "Lkotlin/Function1;", "Lcom/tencent/tkd/topicsdk/bean/LocationInfo;", "locationInfo", "topicCoverClickCallback", "", "coverPath", "videoCoverSelectCallback", "checkAndAskLocationPermission", "activity", "Landroid/app/Activity;", "originLocationInfo", "closeViewFromOtherEntry", "columnId", "", "from", "", "violaCallback", "publishArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "closeViewFromPersonalCenter", "handleAtContractData", "data", "Landroid/content/Intent;", "handleCoverSelectData", "handlePosContractData", "handleTopicCoverData", "path", "onAtButtonClicked", "inputBundle", "callback", "onLocationButtonClicked", "newLocationInfo", "onPublishButtonClicked", "onRelease", "onTopicButtonClicked", "editObject", "onTopicCoverChangeClicked", "onVideoCoverSelectClicked", "result", "startSelectPage", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UserActionHandlerImpl
  implements IUserActionHandler
{
  public static final UserActionHandlerImpl.Companion a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private final UserActionHandlerImpl.coverChangeObserver.1 jdField_a_of_type_ComTencentMobileqqKandianBizPublisherImplsUserActionHandlerImpl$coverChangeObserver$1 = new UserActionHandlerImpl.coverChangeObserver.1(this);
  private final UserActionHandlerImpl.observer.1 jdField_a_of_type_ComTencentMobileqqKandianBizPublisherImplsUserActionHandlerImpl$observer$1 = new UserActionHandlerImpl.observer.1(this);
  private CoverSelectData jdField_a_of_type_ComTencentTkdTopicsdkCoverselectCoverSelectData;
  private Function1<? super LocationInfo, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private Function2<? super ArrayList<EditObject>, ? super Bundle, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction2;
  private Function1<? super CoverSelectData, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction1;
  private Function2<? super String, ? super Bundle, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction2;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizPublisherImplsUserActionHandlerImpl$Companion = new UserActionHandlerImpl.Companion(null);
  }
  
  public UserActionHandlerImpl()
  {
    DispatchManager.a.a(ClickActionEvent.class, (IEventObserver)this.jdField_a_of_type_ComTencentMobileqqKandianBizPublisherImplsUserActionHandlerImpl$observer$1);
    DispatchManager.a.a(TopicCoverChangeEvent.class, (IEventObserver)this.jdField_a_of_type_ComTencentMobileqqKandianBizPublisherImplsUserActionHandlerImpl$coverChangeObserver$1);
  }
  
  private final void a(Activity paramActivity, long paramLong, int paramInt, String paramString, PublishArticleInfo paramPublishArticleInfo)
  {
    int k = 1;
    int i;
    if (paramLong != 0L) {
      i = 1;
    } else {
      i = 0;
    }
    int j = k;
    if (paramInt != 3) {
      if (paramInt == 4) {
        j = k;
      } else {
        j = 0;
      }
    }
    if ((i != 0) && (j == 0))
    {
      paramActivity.finish();
      if (RIJUgcUtils.i() == 2)
      {
        paramString = new StringBuilder();
        paramString.append(RIJUgcUtils.a());
        paramString.append(paramLong);
        paramString = paramString.toString();
        ViolaAccessHelper.a((Context)paramActivity, "", paramString, new Bundle(), false);
      }
    }
    else
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_column_id", paramLong);
      localIntent.putExtra("arg_callback", paramString);
      paramActivity.setResult(3, localIntent);
      paramActivity.finish();
      RIJUgcUtils.a(PublishArticleInfoExtKt.a(paramPublishArticleInfo));
    }
  }
  
  private final void a(Activity paramActivity, LocationInfo paramLocationInfo)
  {
    int i;
    if (ContextCompat.checkSelfPermission((Context)paramActivity, "android.permission.ACCESS_FINE_LOCATION") != -1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      if (!(paramActivity instanceof AppActivity)) {
        localObject = null;
      } else {
        localObject = paramActivity;
      }
      Object localObject = (AppActivity)localObject;
      if (localObject != null) {
        ((AppActivity)localObject).requestPermissions(new UserActionHandlerImpl.checkAndAskLocationPermission.1(this, paramActivity, paramLocationInfo), 50001, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      }
    }
    else
    {
      b(paramActivity, paramLocationInfo);
    }
  }
  
  private final void a(Intent paramIntent)
  {
    paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
    Intrinsics.checkExpressionValueIsNotNull(paramIntent, "data.getParcelableArrayL…nstants.PARAM_RESULT_SET)");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramIntent.iterator();
    while (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      Intrinsics.checkExpressionValueIsNotNull(localResultRecord, "i");
      if (!TextUtils.isEmpty((CharSequence)localResultRecord.b())) {
        paramIntent = localResultRecord.b();
      } else {
        paramIntent = ((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getDefaultNickName();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('@');
      localStringBuilder.append(paramIntent);
      localStringBuilder.append(' ');
      paramIntent = new EditObject(localStringBuilder.toString(), EditObject.EditObjectType.TYPE_AT);
      paramIntent.setKey(localResultRecord.a().toString());
      paramIntent.setAtType(localResultRecord.a());
      localArrayList.add(paramIntent);
    }
    paramIntent = this.jdField_a_of_type_KotlinJvmFunctionsFunction2;
    if (paramIntent != null) {
      paramIntent = (Unit)paramIntent.invoke(localArrayList, this.jdField_a_of_type_AndroidOsBundle);
    }
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = ((Function2)null);
    this.jdField_a_of_type_AndroidOsBundle = ((Bundle)null);
  }
  
  private final void a(String paramString)
  {
    Function2 localFunction2 = this.jdField_b_of_type_KotlinJvmFunctionsFunction2;
    if (localFunction2 != null) {
      paramString = (Unit)localFunction2.invoke(paramString, this.jdField_a_of_type_AndroidOsBundle);
    }
    this.jdField_b_of_type_KotlinJvmFunctionsFunction2 = ((Function2)null);
    this.jdField_a_of_type_AndroidOsBundle = ((Bundle)null);
  }
  
  private final void b(Activity paramActivity, LocationInfo paramLocationInfo)
  {
    Intent localIntent = new Intent((Context)paramActivity, TroopBarPublishLocationSelectActivity.class);
    if (paramLocationInfo != null) {
      localIntent.putExtra("key_selected_poi", (Parcelable)new TroopBarPOI(paramLocationInfo.getUid(), "", paramLocationInfo.getName(), (int)paramLocationInfo.getLongitude(), paramLocationInfo.getAddr(), (int)paramLocationInfo.getLatitude(), ""));
    }
    ActivityCompat.startActivityForResult(paramActivity, localIntent, 50001, null);
  }
  
  private final void b(Activity paramActivity, PublishArticleInfo paramPublishArticleInfo)
  {
    Object localObject = Aladdin.getConfig(462);
    if ((localObject != null) && (((AladdinConfig)localObject).getIntegerFromString("intro_after_publish", 0) == 1))
    {
      int i = ((AladdinConfig)localObject).getIntegerFromString("intro_type", 0);
      String str1 = ((AladdinConfig)localObject).getString("intro_title", "");
      String str2 = ((AladdinConfig)localObject).getString("segue_button_left_title", "");
      String str3 = ((AladdinConfig)localObject).getString("segue_button_left_url", "");
      String str4 = ((AladdinConfig)localObject).getString("segue_button_right_title", "");
      String str5 = ((AladdinConfig)localObject).getString("segue_button_right_url", "");
      HashMap localHashMap = new HashMap();
      localHashMap.put("page", "RIJPublisherSuccessPage");
      localObject = paramPublishArticleInfo.getVideoInfo();
      if (localObject != null)
      {
        localObject = ((VideoInfo)localObject).getBackupCoverPath();
        if (localObject != null) {
          localObject = (String)localHashMap.put("intro_video_cover_local_url", localObject);
        }
      }
      localObject = paramPublishArticleInfo.getVideoInfo();
      if (localObject != null)
      {
        localObject = ((VideoInfo)localObject).getCoverUrl();
        if (localObject != null) {
          localObject = (String)localHashMap.put("intro_video_cover_network_url", localObject);
        }
      }
      localObject = paramPublishArticleInfo.getVideoInfo();
      FlutterPageSetting localFlutterPageSetting = null;
      if (localObject != null) {
        localObject = Integer.valueOf(((VideoInfo)localObject).getCoverWidth());
      } else {
        localObject = null;
      }
      localHashMap.put("cover_width", String.valueOf(localObject));
      VideoInfo localVideoInfo = paramPublishArticleInfo.getVideoInfo();
      localObject = localFlutterPageSetting;
      if (localVideoInfo != null) {
        localObject = Integer.valueOf(localVideoInfo.getCoverHeight());
      }
      localHashMap.put("cover_height", String.valueOf(localObject));
      localHashMap.put("title", paramPublishArticleInfo.getContent());
      localHashMap.put("intro_text", str1);
      localHashMap.put("segue_button_left_title", str2);
      localHashMap.put("segue_button_left_url", str3);
      localHashMap.put("segue_button_right_title", str4);
      localObject = Uri.parse(URLDecoder.decode(str5, "utf-8")).buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter("id", paramPublishArticleInfo.getCommunityId());
      localHashMap.put("segue_button_right_url", ((Uri.Builder)localObject).toString());
      paramPublishArticleInfo = RIJFlutterUtils.a;
      localObject = (Context)paramActivity;
      boolean bool;
      if (i == 1) {
        bool = true;
      } else {
        bool = false;
      }
      localFlutterPageSetting = new FlutterPageSetting();
      localFlutterPageSetting.a(true);
      localFlutterPageSetting.b(false);
      localFlutterPageSetting.c(false);
      paramPublishArticleInfo.a((Context)localObject, localHashMap, bool, localFlutterPageSetting);
    }
    paramActivity.finish();
  }
  
  private final void b(Intent paramIntent)
  {
    TroopBarPOI localTroopBarPOI = (TroopBarPOI)paramIntent.getParcelableExtra("key_selected_poi");
    if (localTroopBarPOI == null)
    {
      paramIntent = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
      if (paramIntent != null) {
        paramIntent = (Unit)paramIntent.invoke(null);
      }
    }
    else
    {
      Function1 localFunction1 = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
      if (localFunction1 != null)
      {
        LocationInfo localLocationInfo = new LocationInfo();
        if (TextUtils.isEmpty((CharSequence)localTroopBarPOI.c))
        {
          paramIntent = localTroopBarPOI.d;
          Intrinsics.checkExpressionValueIsNotNull(paramIntent, "mCurrentPOI.addr");
        }
        else
        {
          paramIntent = localTroopBarPOI.c;
          Intrinsics.checkExpressionValueIsNotNull(paramIntent, "mCurrentPOI.name");
        }
        localLocationInfo.setName(paramIntent);
        localLocationInfo.setLatitude(localTroopBarPOI.b);
        localLocationInfo.setLongitude(localTroopBarPOI.jdField_a_of_type_Int);
        paramIntent = localTroopBarPOI.d;
        Intrinsics.checkExpressionValueIsNotNull(paramIntent, "mCurrentPOI.addr");
        localLocationInfo.setAddr(paramIntent);
        paramIntent = localTroopBarPOI.jdField_a_of_type_JavaLangString;
        Intrinsics.checkExpressionValueIsNotNull(paramIntent, "mCurrentPOI.uid");
        localLocationInfo.setUid(paramIntent);
        localLocationInfo.setUserSelect(1);
        paramIntent = (Unit)localFunction1.invoke(localLocationInfo);
      }
    }
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = ((Function1)null);
    this.jdField_a_of_type_AndroidOsBundle = ((Bundle)null);
  }
  
  private final void c(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("ARG_SELECTED_COVER");
    int i = paramIntent.getIntExtra("ARG_SELECTED_ITEM", 0);
    float f = paramIntent.getFloatExtra("ARG_INITIAL_PROGRESS", 0.0F);
    paramIntent = this.jdField_a_of_type_ComTencentTkdTopicsdkCoverselectCoverSelectData;
    if (paramIntent != null)
    {
      if (!TextUtils.isEmpty((CharSequence)str))
      {
        Function1 localFunction1 = this.jdField_b_of_type_KotlinJvmFunctionsFunction1;
        if (localFunction1 != null)
        {
          paramIntent.setCoverFrom(i);
          paramIntent.setInitialProgress(f);
          Intrinsics.checkExpressionValueIsNotNull(str, "resultCoverPath");
          paramIntent.setCoverPath(str);
          paramIntent = (Unit)localFunction1.invoke(paramIntent);
        }
      }
      this.jdField_b_of_type_KotlinJvmFunctionsFunction1 = ((Function1)null);
    }
  }
  
  public void a()
  {
    Function2 localFunction2 = (Function2)null;
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = localFunction2;
    Function1 localFunction1 = (Function1)null;
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = localFunction1;
    this.jdField_b_of_type_KotlinJvmFunctionsFunction2 = localFunction2;
    this.jdField_b_of_type_KotlinJvmFunctionsFunction1 = localFunction1;
  }
  
  public void a(@NotNull Activity paramActivity, @Nullable Bundle paramBundle, @NotNull Function2<? super ArrayList<EditObject>, ? super Bundle, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "callback");
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = paramFunction2;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    paramBundle = new Intent();
    paramBundle.putExtra("param_only_friends", true);
    paramBundle.putExtra("param_min", 1);
    paramBundle.putExtra("param_max", 10);
    PublicFragmentActivity.a(paramActivity, paramBundle, ReadInJoySelectMemberFragment.class, 30001);
  }
  
  public void a(@NotNull Activity paramActivity, @Nullable LocationInfo paramLocationInfo, @NotNull Function1<? super LocationInfo, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
    a(paramActivity, paramLocationInfo);
  }
  
  public void a(@NotNull Activity paramActivity, @NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "publishArticleInfo");
    int i;
    if (((CharSequence)paramPublishArticleInfo.getScene()).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      try
      {
        Object localObject = new JSONObject(paramPublishArticleInfo.getScene());
        i = ((JSONObject)localObject).optInt("key_from");
        localObject = ((JSONObject)localObject).optString("key_callback", "");
        if (i != 1)
        {
          if (i != 5)
          {
            long l = paramPublishArticleInfo.getTopicId();
            Intrinsics.checkExpressionValueIsNotNull(localObject, "callback");
            a(paramActivity, l, i, (String)localObject, paramPublishArticleInfo);
            return;
          }
          paramActivity.finish();
          return;
        }
        b(paramActivity, paramPublishArticleInfo);
        return;
      }
      catch (JSONException paramActivity)
      {
        QLog.d("UserActionHandlerImpl", 2, paramActivity.toString());
      }
    }
  }
  
  public void a(@NotNull Activity paramActivity, @NotNull CoverSelectData paramCoverSelectData, @NotNull Function1<? super CoverSelectData, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramCoverSelectData, "coverSelectData");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    if (new PublisherRemoteConfig().a())
    {
      CoverSelectPage.a.a(paramActivity, 2, paramCoverSelectData);
      return;
    }
    this.jdField_b_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
    this.jdField_a_of_type_ComTencentTkdTopicsdkCoverselectCoverSelectData = paramCoverSelectData;
    paramFunction1 = new UgcVideo();
    paramFunction1.filePath = paramCoverSelectData.getVideoPath();
    paramFunction1.width = paramCoverSelectData.getVideoWidth();
    paramFunction1.height = paramCoverSelectData.getVideoHeight();
    CoverSelectTabFragment.a(paramActivity, 60001, paramCoverSelectData.getCoverFrom(), paramCoverSelectData.getInitialProgress(), paramCoverSelectData.getCoverPath(), paramFunction1);
  }
  
  public void a(@NotNull Activity paramActivity, @NotNull Function2<? super String, ? super Bundle, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "callback");
    this.jdField_b_of_type_KotlinJvmFunctionsFunction2 = paramFunction2;
    paramFunction2 = new ActivityURIRequest((Context)paramActivity, "/base/album/photolist");
    paramFunction2.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    paramFunction2.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramFunction2.extra().putBoolean("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    paramFunction2.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", true);
    paramFunction2.extra().putBoolean("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    paramFunction2.extra().putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    paramFunction2.extra().putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(TKDPublisherUtils.a.a().b());
    ((StringBuilder)localObject).append(TKDPublisherUtils.a.a().a());
    ((StringBuilder)localObject).append('/');
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".jpg");
    localObject = localStringBuilder.toString();
    paramFunction2.extra().putString("PhotoConst.TARGET_PATH", (String)localObject);
    paramFunction2.extra().putInt("PhotoConst.CLIP_WIDTH", 640);
    paramFunction2.extra().putInt("PhotoConst.CLIP_HEIGHT", 640);
    paramFunction2.extra().putInt("PhotoConst.TARGET_WIDTH", 640);
    paramFunction2.extra().putInt("PhotoConst.TARGET_HEIGHT", 640);
    QRoute.startUri((URIRequest)paramFunction2);
    AlbumUtil.anim(paramActivity, false, true);
  }
  
  public void b(@NotNull Activity paramActivity, @Nullable Bundle paramBundle, @NotNull Function2<? super EditObject, ? super Bundle, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "callback");
    Object localObject = paramActivity.getWindow();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView().findViewById(16908290);
    if (localObject != null)
    {
      paramActivity = new TweetTopicView((ViewGroup)localObject, (Context)paramActivity, null);
      boolean bool;
      if (paramBundle != null) {
        bool = paramBundle.getBoolean("allow_create_tweet_topic");
      } else {
        bool = false;
      }
      paramActivity.setAllowCreateNewTopic(bool);
      paramActivity.setDismissListener((Function2)new UserActionHandlerImpl.onTopicButtonClicked..inlined.apply.lambda.1(paramBundle, paramFunction2));
      paramActivity.a(paramBundle);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.UserActionHandlerImpl
 * JD-Core Version:    0.7.0.1
 */