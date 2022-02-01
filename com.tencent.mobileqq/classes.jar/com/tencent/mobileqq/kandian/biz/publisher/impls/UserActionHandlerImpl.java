package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.app.ActivityCompat;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.flutter.JumpToRIJPublisherSuccessPageUtils;
import com.tencent.mobileqq.kandian.biz.publisher.TroopBarPublishLocationSelectActivity;
import com.tencent.mobileqq.kandian.biz.publisher.config.PublisherRemoteConfig;
import com.tencent.mobileqq.kandian.biz.publisher.ktx.PublishArticleInfoExtKt;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.coverselect.CoverSelectTabFragment;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.kandian.biz.ugc.selectmember.ReadInJoySelectMemberFragment;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.ugc.ResultRecord;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.bean.LocationInfo;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.common.PermissionUtils;
import com.tencent.tkd.topicsdk.coverselect.CoverSelectData;
import com.tencent.tkd.topicsdk.coverselect.CoverSelectPage;
import com.tencent.tkd.topicsdk.coverselect.CoverSelectPage.Companion;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEventObserver;
import com.tencent.tkd.topicsdk.interfaces.IUserActionHandler;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import com.tencent.tkd.weibo.tweetTopic.TweetTopicView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/UserActionHandlerImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IUserActionHandler;", "()V", "atContractCallback", "Lkotlin/Function2;", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/weibo/bean/EditObject;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "editObjects", "Landroid/os/Bundle;", "outputBundle", "", "coverChangeObserver", "com/tencent/mobileqq/kandian/biz/publisher/impls/UserActionHandlerImpl$coverChangeObserver$1", "Lcom/tencent/mobileqq/kandian/biz/publisher/impls/UserActionHandlerImpl$coverChangeObserver$1;", "coverSelectData", "Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectData;", "observer", "com/tencent/mobileqq/kandian/biz/publisher/impls/UserActionHandlerImpl$observer$1", "Lcom/tencent/mobileqq/kandian/biz/publisher/impls/UserActionHandlerImpl$observer$1;", "positionContractCallback", "Lkotlin/Function1;", "Lcom/tencent/tkd/topicsdk/bean/LocationInfo;", "locationInfo", "topicCoverClickCallback", "", "coverPath", "videoCoverSelectCallback", "closeViewAndGotoPublishResultPage", "activity", "Landroid/app/Activity;", "publishArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "closeViewFromOtherEntry", "columnId", "", "from", "", "violaCallback", "handleAtContractData", "data", "Landroid/content/Intent;", "handleCoverSelectData", "handlePosContractData", "handleTopicCoverData", "path", "onAtButtonClicked", "inputBundle", "callback", "onLocationButtonClicked", "originLocationInfo", "newLocationInfo", "onPublishButtonClicked", "onRelease", "onTopicButtonClicked", "editObject", "onTopicCoverChangeClicked", "onVideoCoverSelectClicked", "result", "startSelectPage", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UserActionHandlerImpl
  implements IUserActionHandler
{
  public static final UserActionHandlerImpl.Companion a = new UserActionHandlerImpl.Companion(null);
  private Function2<? super ArrayList<EditObject>, ? super Bundle, Unit> c;
  private Function1<? super LocationInfo, Unit> d;
  private Function2<? super String, ? super Bundle, Unit> e;
  private Function1<? super CoverSelectData, Unit> f;
  private final UserActionHandlerImpl.observer.1 g = new UserActionHandlerImpl.observer.1(this);
  private final UserActionHandlerImpl.coverChangeObserver.1 h = new UserActionHandlerImpl.coverChangeObserver.1(this);
  private CoverSelectData i;
  private Bundle j;
  
  public UserActionHandlerImpl()
  {
    DispatchManager.a.a(ClickActionEvent.class, (IEventObserver)this.g);
    DispatchManager.a.a(TopicCoverChangeEvent.class, (IEventObserver)this.h);
  }
  
  private final void a(Activity paramActivity, long paramLong, int paramInt, String paramString, PublishArticleInfo paramPublishArticleInfo)
  {
    int n = 1;
    int k;
    if (paramLong != 0L) {
      k = 1;
    } else {
      k = 0;
    }
    int m = n;
    if (paramInt != 3) {
      if (paramInt == 4) {
        m = n;
      } else {
        m = 0;
      }
    }
    if ((k != 0) && (m == 0))
    {
      paramActivity.finish();
      if (RIJUgcUtils.r() == 2)
      {
        paramString = new StringBuilder();
        paramString.append(RIJUgcUtils.s());
        paramString.append(paramLong);
        paramString = paramString.toString();
        ViolaAccessHelper.a((Context)paramActivity, "", paramString, new Bundle(), false);
      }
    }
    else
    {
      JSONObject localJSONObject = null;
      Object localObject1 = (TroopBarPOI)null;
      Object localObject2 = paramPublishArticleInfo.getLocationInfo();
      if (localObject2 != null) {
        localObject1 = new TroopBarPOI(((LocationInfo)localObject2).getUid(), "", ((LocationInfo)localObject2).getName(), (int)((LocationInfo)localObject2).getLongitude(), ((LocationInfo)localObject2).getAddr(), (int)((LocationInfo)localObject2).getLatitude(), "");
      }
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("key_column_id", paramLong);
      if (localObject1 != null) {
        localJSONObject = ((TroopBarPOI)localObject1).a();
      }
      ((JSONObject)localObject2).put("video_location", localJSONObject);
      ((JSONObject)localObject2).put("kdCommunityId", paramPublishArticleInfo.getCommunityId());
      localObject1 = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication()");
      localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication().runtime");
      ((JSONObject)localObject2).put("account", ((AppRuntime)localObject1).getAccount());
      ((JSONObject)localObject2).put("title", paramPublishArticleInfo.getContent());
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("arg_callback", paramString);
      ((Intent)localObject1).putExtra("publisherExtra", ((JSONObject)localObject2).toString());
      paramActivity.setResult(3, (Intent)localObject1);
      paramActivity.finish();
      RIJUgcUtils.c(PublishArticleInfoExtKt.a(paramPublishArticleInfo));
    }
  }
  
  private final void a(Activity paramActivity, LocationInfo paramLocationInfo)
  {
    Intent localIntent = new Intent((Context)paramActivity, TroopBarPublishLocationSelectActivity.class);
    if (paramLocationInfo != null) {
      localIntent.putExtra("key_selected_poi", (Parcelable)new TroopBarPOI(paramLocationInfo.getUid(), "", paramLocationInfo.getName(), (int)paramLocationInfo.getLongitude(), paramLocationInfo.getAddr(), (int)paramLocationInfo.getLatitude(), ""));
    }
    ActivityCompat.startActivityForResult(paramActivity, localIntent, 50001, null);
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
      if (!TextUtils.isEmpty((CharSequence)localResultRecord.b()))
      {
        paramIntent = localResultRecord.b();
      }
      else
      {
        paramIntent = localResultRecord.a();
        Intrinsics.checkExpressionValueIsNotNull(paramIntent, "i.uin");
        paramIntent = ReadInJoyUserInfoModule.a(Long.parseLong(paramIntent), null);
        if (paramIntent != null)
        {
          paramIntent = paramIntent.nick;
          if (paramIntent != null) {}
        }
        else
        {
          paramIntent = ReadInJoyUserInfoModule.d();
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('@');
      localStringBuilder.append(paramIntent);
      localStringBuilder.append(' ');
      paramIntent = new EditObject(localStringBuilder.toString(), EditObject.EditObjectType.TYPE_AT);
      paramIntent.setKey(localResultRecord.a().toString());
      paramIntent.setAtType(localResultRecord.c());
      localArrayList.add(paramIntent);
    }
    paramIntent = this.c;
    if (paramIntent != null) {
      paramIntent = (Unit)paramIntent.invoke(localArrayList, this.j);
    }
    this.c = ((Function2)null);
    this.j = ((Bundle)null);
  }
  
  private final void a(String paramString)
  {
    Function2 localFunction2 = this.e;
    if (localFunction2 != null) {
      paramString = (Unit)localFunction2.invoke(paramString, this.j);
    }
    this.e = ((Function2)null);
    this.j = ((Bundle)null);
  }
  
  private final void b(Intent paramIntent)
  {
    TroopBarPOI localTroopBarPOI = (TroopBarPOI)paramIntent.getParcelableExtra("key_selected_poi");
    if (localTroopBarPOI == null)
    {
      paramIntent = this.d;
      if (paramIntent != null) {
        paramIntent = (Unit)paramIntent.invoke(null);
      }
    }
    else
    {
      Function1 localFunction1 = this.d;
      if (localFunction1 != null)
      {
        LocationInfo localLocationInfo = new LocationInfo();
        if (TextUtils.isEmpty((CharSequence)localTroopBarPOI.c))
        {
          paramIntent = localTroopBarPOI.e;
          Intrinsics.checkExpressionValueIsNotNull(paramIntent, "mCurrentPOI.addr");
        }
        else
        {
          paramIntent = localTroopBarPOI.c;
          Intrinsics.checkExpressionValueIsNotNull(paramIntent, "mCurrentPOI.name");
        }
        localLocationInfo.setName(paramIntent);
        localLocationInfo.setLatitude(localTroopBarPOI.f);
        localLocationInfo.setLongitude(localTroopBarPOI.d);
        paramIntent = localTroopBarPOI.e;
        Intrinsics.checkExpressionValueIsNotNull(paramIntent, "mCurrentPOI.addr");
        localLocationInfo.setAddr(paramIntent);
        paramIntent = localTroopBarPOI.a;
        Intrinsics.checkExpressionValueIsNotNull(paramIntent, "mCurrentPOI.uid");
        localLocationInfo.setUid(paramIntent);
        localLocationInfo.setUserSelect(1);
        paramIntent = (Unit)localFunction1.invoke(localLocationInfo);
      }
    }
    this.d = ((Function1)null);
    this.j = ((Bundle)null);
  }
  
  private final void c(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("ARG_SELECTED_COVER");
    int k = paramIntent.getIntExtra("ARG_SELECTED_ITEM", 0);
    float f1 = paramIntent.getFloatExtra("ARG_INITIAL_PROGRESS", 0.0F);
    paramIntent = this.i;
    if (paramIntent != null)
    {
      if (!TextUtils.isEmpty((CharSequence)str))
      {
        Function1 localFunction1 = this.f;
        if (localFunction1 != null)
        {
          paramIntent.setCoverFrom(k);
          paramIntent.setInitialProgress(f1);
          Intrinsics.checkExpressionValueIsNotNull(str, "resultCoverPath");
          paramIntent.setCoverPath(str);
          paramIntent = (Unit)localFunction1.invoke(paramIntent);
        }
      }
      this.f = ((Function1)null);
    }
  }
  
  public void a()
  {
    Function2 localFunction2 = (Function2)null;
    this.c = localFunction2;
    Function1 localFunction1 = (Function1)null;
    this.d = localFunction1;
    this.e = localFunction2;
    this.f = localFunction1;
  }
  
  public void a(@NotNull Activity paramActivity, @Nullable Bundle paramBundle, @NotNull Function2<? super ArrayList<EditObject>, ? super Bundle, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "callback");
    this.c = paramFunction2;
    this.j = paramBundle;
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
    this.d = paramFunction1;
    PermissionUtils.a.b(paramActivity, (Function1)new UserActionHandlerImpl.onLocationButtonClicked.1(this, paramActivity, paramLocationInfo));
  }
  
  public void a(@NotNull Activity paramActivity, @NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "publishArticleInfo");
    int k;
    if (((CharSequence)paramPublishArticleInfo.getScene()).length() > 0) {
      k = 1;
    } else {
      k = 0;
    }
    if (k != 0) {
      try
      {
        Object localObject = new JSONObject(paramPublishArticleInfo.getScene());
        k = ((JSONObject)localObject).optInt("key_from");
        localObject = ((JSONObject)localObject).optString("key_callback", "");
        if (!ReadInJoyHelper.v(RIJQQAppInterfaceUtil.e())) {
          return;
        }
        if (k != 1) {
          if (k != 5)
          {
            if ((k != 8) && (k != 9))
            {
              long l = paramPublishArticleInfo.getTopicId();
              Intrinsics.checkExpressionValueIsNotNull(localObject, "callback");
              a(paramActivity, l, k, (String)localObject, paramPublishArticleInfo);
            }
          }
          else
          {
            paramActivity.finish();
            return;
          }
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
    this.f = paramFunction1;
    this.i = paramCoverSelectData;
    paramFunction1 = new UgcVideo();
    paramFunction1.filePath = paramCoverSelectData.getVideoPath();
    paramFunction1.width = paramCoverSelectData.getVideoWidth();
    paramFunction1.height = paramCoverSelectData.getVideoHeight();
    CoverSelectTabFragment.a(paramActivity, 60001, paramCoverSelectData.getCoverFrom(), paramCoverSelectData.getInitialProgress(), paramCoverSelectData.getCoverPath(), paramFunction1);
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
  
  public final void b(@NotNull Activity paramActivity, @NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "publishArticleInfo");
    boolean bool2 = true;
    QLog.d("UserActionHandlerImpl", 1, "#closeViewAndGotoPublishResultPage: begin");
    Object localObject = Aladdin.getConfig(462);
    if ((localObject != null) && (((AladdinConfig)localObject).getIntegerFromString("intro_after_publish", 0) == 1))
    {
      JumpToRIJPublisherSuccessPageUtils localJumpToRIJPublisherSuccessPageUtils = new JumpToRIJPublisherSuccessPageUtils();
      localJumpToRIJPublisherSuccessPageUtils.a(((AladdinConfig)localObject).getIntegerFromString("intro_type", 0));
      String str = ((AladdinConfig)localObject).getString("intro_title", "");
      Intrinsics.checkExpressionValueIsNotNull(str, "config.getString(KEY_INTRO_TITLE, \"\")");
      localJumpToRIJPublisherSuccessPageUtils.a(str);
      str = ((AladdinConfig)localObject).getString("intro_text", "");
      Intrinsics.checkExpressionValueIsNotNull(str, "config.getString(KEY_INTRO_TEXT, \"\")");
      localJumpToRIJPublisherSuccessPageUtils.b(str);
      str = ((AladdinConfig)localObject).getString("segue_button_left_title", "");
      Intrinsics.checkExpressionValueIsNotNull(str, "config.getString(KEY_SEGUE_BUTTON_LEFT_TITLE, \"\")");
      localJumpToRIJPublisherSuccessPageUtils.c(str);
      str = ((AladdinConfig)localObject).getString("segue_button_left_url", "");
      Intrinsics.checkExpressionValueIsNotNull(str, "config.getString(KEY_SEGUE_BUTTON_LEFT_URL, \"\")");
      localJumpToRIJPublisherSuccessPageUtils.d(str);
      str = ((AladdinConfig)localObject).getString("segue_button_right_title", "");
      Intrinsics.checkExpressionValueIsNotNull(str, "config.getString(KEY_SEGUE_BUTTON_RIGHT_TITLE, \"\")");
      localJumpToRIJPublisherSuccessPageUtils.e(str);
      str = ((AladdinConfig)localObject).getString("segue_button_right_url", "");
      Intrinsics.checkExpressionValueIsNotNull(str, "config.getString(KEY_SEGUE_BUTTON_RIGHT_URL, \"\")");
      localJumpToRIJPublisherSuccessPageUtils.f(str);
      str = ((AladdinConfig)localObject).getString("mx_default_url", "");
      Intrinsics.checkExpressionValueIsNotNull(str, "config.getString(KEY_MX_DEFAULT_URL, \"\")");
      localJumpToRIJPublisherSuccessPageUtils.l(str);
      boolean bool1;
      if (((AladdinConfig)localObject).getInteger("mx_default_url_need_copy_params", 0) == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localJumpToRIJPublisherSuccessPageUtils.a(bool1);
      str = ((AladdinConfig)localObject).getString("mx_bid_id", "");
      Intrinsics.checkExpressionValueIsNotNull(str, "config.getString(\"mx_bid_id\", \"\")");
      localJumpToRIJPublisherSuccessPageUtils.m(str);
      str = ((AladdinConfig)localObject).getString("mx_jswidget_name", "");
      Intrinsics.checkExpressionValueIsNotNull(str, "config.getString(\"mx_jswidget_name\", \"\")");
      localJumpToRIJPublisherSuccessPageUtils.n(str);
      if (((AladdinConfig)localObject).getIntegerFromString("mx_is_dart2js", 0) == 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localJumpToRIJPublisherSuccessPageUtils.b(bool1);
      localJumpToRIJPublisherSuccessPageUtils.j(paramPublishArticleInfo.getCommunityId());
      localObject = paramPublishArticleInfo.getVideoInfo();
      if (localObject != null)
      {
        localObject = ((VideoInfo)localObject).getBackupCoverPath();
        if (localObject != null) {
          localJumpToRIJPublisherSuccessPageUtils.h((String)localObject);
        }
      }
      localObject = paramPublishArticleInfo.getVideoInfo();
      if (localObject != null)
      {
        localObject = ((VideoInfo)localObject).getCoverUrl();
        if (localObject != null) {
          localJumpToRIJPublisherSuccessPageUtils.g((String)localObject);
        }
      }
      localObject = paramPublishArticleInfo.getVideoInfo();
      if (localObject != null) {
        localJumpToRIJPublisherSuccessPageUtils.b(((VideoInfo)localObject).getCoverWidth());
      }
      localObject = paramPublishArticleInfo.getVideoInfo();
      if (localObject != null) {
        localJumpToRIJPublisherSuccessPageUtils.c(((VideoInfo)localObject).getCoverHeight());
      }
      localJumpToRIJPublisherSuccessPageUtils.i(paramPublishArticleInfo.getContent());
      localJumpToRIJPublisherSuccessPageUtils.k("1");
      localJumpToRIJPublisherSuccessPageUtils.a((Context)paramActivity);
    }
    paramActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.UserActionHandlerImpl
 * JD-Core Version:    0.7.0.1
 */