package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyTopicSelectionFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.CoverSelectTabFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.publisher.TKDPublisherUtils;
import com.tencent.mobileqq.kandian.biz.publisher.config.PublisherRemoteConfig;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.tkd.topicsdk.bean.LocationInfo;
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
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/UserActionHandlerImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IUserActionHandler;", "()V", "atContractCallback", "Lkotlin/Function2;", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/weibo/bean/EditObject;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "editObjects", "Landroid/os/Bundle;", "outputBundle", "", "coverChangeObserver", "com/tencent/mobileqq/kandian/biz/publisher/impls/UserActionHandlerImpl$coverChangeObserver$1", "Lcom/tencent/mobileqq/kandian/biz/publisher/impls/UserActionHandlerImpl$coverChangeObserver$1;", "coverSelectData", "Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectData;", "observer", "com/tencent/mobileqq/kandian/biz/publisher/impls/UserActionHandlerImpl$observer$1", "Lcom/tencent/mobileqq/kandian/biz/publisher/impls/UserActionHandlerImpl$observer$1;", "positionContractCallback", "Lkotlin/Function1;", "Lcom/tencent/tkd/topicsdk/bean/LocationInfo;", "locationInfo", "topicContractCallback", "editObject", "topicCoverClickCallback", "", "coverPath", "videoCoverSelectCallback", "closeViewFromMainTab", "activity", "Landroid/app/Activity;", "columnId", "", "from", "", "closeViewFromOtherEntry", "violaCallback", "handleAtContractData", "data", "Landroid/content/Intent;", "handleCoverSelectData", "handlePosContractData", "handleTopicContractData", "intent", "handleTopicCoverData", "path", "onAtButtonClicked", "inputBundle", "callback", "onLocationButtonClicked", "originLocationInfo", "newLocationInfo", "onPublishButtonClicked", "scene", "onRelease", "onTopicButtonClicked", "onTopicCoverChangeClicked", "onVideoCoverSelectClicked", "result", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
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
  private Function2<? super EditObject, ? super Bundle, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction2;
  private Function2<? super String, ? super Bundle, Unit> c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizPublisherImplsUserActionHandlerImpl$Companion = new UserActionHandlerImpl.Companion(null);
  }
  
  public UserActionHandlerImpl()
  {
    DispatchManager.a.a(ClickActionEvent.class, (IEventObserver)this.jdField_a_of_type_ComTencentMobileqqKandianBizPublisherImplsUserActionHandlerImpl$observer$1);
    DispatchManager.a.a(TopicCoverChangeEvent.class, (IEventObserver)this.jdField_a_of_type_ComTencentMobileqqKandianBizPublisherImplsUserActionHandlerImpl$coverChangeObserver$1);
  }
  
  private final void a(Activity paramActivity, long paramLong, int paramInt)
  {
    paramInt = RIJUgcUtils.b();
    if (paramLong != 0L)
    {
      paramActivity.finish();
      if (RIJUgcUtils.j() == 2)
      {
        localObject = RIJUgcUtils.a() + paramLong;
        ViolaAccessHelper.a((Context)paramActivity, "", (String)localObject, new Bundle(), false);
      }
      return;
    }
    if (paramInt == 2)
    {
      QLog.d("UserActionHandlerImpl", 0, "closeView | publish video without column ");
      ThreadManager.getUIHandler().postDelayed((Runnable)new UserActionHandlerImpl.closeViewFromMainTab.1(paramActivity), 500L);
      return;
    }
    paramActivity.finish();
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    ReadInJoyActivityHelper.a((QQAppInterface)localObject, (Context)paramActivity, 0, 0, null);
  }
  
  private final void a(Activity paramActivity, long paramLong, int paramInt, String paramString)
  {
    int k = 1;
    int i;
    if (paramLong != 0L)
    {
      i = 1;
      j = k;
      if (paramInt != 3) {
        if (paramInt != 4) {
          break label101;
        }
      }
    }
    label101:
    for (int j = k;; j = 0)
    {
      if ((i == 0) || (j != 0)) {
        break label107;
      }
      paramActivity.finish();
      if (RIJUgcUtils.j() == 2)
      {
        paramString = RIJUgcUtils.a() + paramLong;
        ViolaAccessHelper.a((Context)paramActivity, "", paramString, new Bundle(), false);
      }
      return;
      i = 0;
      break;
    }
    label107:
    Intent localIntent = new Intent();
    localIntent.putExtra("key_column_id", paramLong);
    localIntent.putExtra("arg_callback", paramString);
    paramActivity.setResult(3, localIntent);
    paramActivity.finish();
  }
  
  private final void a(Intent paramIntent)
  {
    Object localObject = (TopicInfo)paramIntent.getParcelableExtra("EXTRA_SELECTED_TOPIC");
    int i;
    if (localObject != null)
    {
      paramIntent = ((TopicInfo)localObject).a();
      Intrinsics.checkExpressionValueIsNotNull(paramIntent, "topicInfo.topicTitle");
      paramIntent = new EditObject(paramIntent, EditObject.EditObjectType.TYPE_TOPIC);
      paramIntent.setKey(String.valueOf(((TopicInfo)localObject).b()));
      CharSequence localCharSequence = (CharSequence)((TopicInfo)localObject).d();
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label136;
      }
      i = 1;
      if (i != 0) {
        break label141;
      }
      localObject = ((TopicInfo)localObject).d();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "topicInfo.topicJumpUrl");
      paramIntent.setHref((String)localObject);
    }
    for (;;)
    {
      localObject = this.jdField_b_of_type_KotlinJvmFunctionsFunction2;
      if (localObject != null) {
        paramIntent = (Unit)((Function2)localObject).invoke(paramIntent, this.jdField_a_of_type_AndroidOsBundle);
      }
      this.jdField_b_of_type_KotlinJvmFunctionsFunction2 = ((Function2)null);
      this.jdField_a_of_type_AndroidOsBundle = ((Bundle)null);
      return;
      label136:
      i = 0;
      break;
      label141:
      QLog.e("UserActionHandlerImpl", 0, "topicInfo has empty url " + localObject);
    }
  }
  
  private final void a(String paramString)
  {
    Function2 localFunction2 = this.c;
    if (localFunction2 != null) {
      paramString = (Unit)localFunction2.invoke(paramString, this.jdField_a_of_type_AndroidOsBundle);
    }
    this.c = ((Function2)null);
    this.jdField_a_of_type_AndroidOsBundle = ((Bundle)null);
  }
  
  private final void b(Intent paramIntent)
  {
    paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
    Intrinsics.checkExpressionValueIsNotNull(paramIntent, "data.getParcelableArrayL…ctivity.PARAM_RESULT_SET)");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramIntent.iterator();
    if (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      Intrinsics.checkExpressionValueIsNotNull(localResultRecord, "i");
      if (!TextUtils.isEmpty((CharSequence)localResultRecord.b())) {}
      for (paramIntent = localResultRecord.b();; paramIntent = ReadInJoyUserInfoModule.a())
      {
        paramIntent = new EditObject('@' + paramIntent + ' ', EditObject.EditObjectType.TYPE_AT);
        paramIntent.setKey(localResultRecord.a().toString());
        paramIntent.setAtType(localResultRecord.a());
        localArrayList.add(paramIntent);
        break;
      }
    }
    paramIntent = this.jdField_a_of_type_KotlinJvmFunctionsFunction2;
    if (paramIntent != null) {
      paramIntent = (Unit)paramIntent.invoke(localArrayList, this.jdField_a_of_type_AndroidOsBundle);
    }
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = ((Function2)null);
    this.jdField_a_of_type_AndroidOsBundle = ((Bundle)null);
  }
  
  private final void c(Intent paramIntent)
  {
    TroopBarPOI localTroopBarPOI = (TroopBarPOI)paramIntent.getParcelableExtra("key_selected_poi");
    if (localTroopBarPOI == null)
    {
      paramIntent = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
      if (paramIntent != null) {
        paramIntent = (Unit)paramIntent.invoke(null);
      }
    }
    Function1 localFunction1;
    do
    {
      this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = ((Function1)null);
      this.jdField_a_of_type_AndroidOsBundle = ((Bundle)null);
      return;
      localFunction1 = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
    } while (localFunction1 == null);
    LocationInfo localLocationInfo = new LocationInfo();
    if (TextUtils.isEmpty((CharSequence)localTroopBarPOI.c))
    {
      paramIntent = localTroopBarPOI.d;
      Intrinsics.checkExpressionValueIsNotNull(paramIntent, "mCurrentPOI.addr");
    }
    for (;;)
    {
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
      break;
      paramIntent = localTroopBarPOI.c;
      Intrinsics.checkExpressionValueIsNotNull(paramIntent, "mCurrentPOI.name");
    }
  }
  
  private final void d(Intent paramIntent)
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
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = ((Function2)null);
    this.jdField_b_of_type_KotlinJvmFunctionsFunction2 = ((Function2)null);
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = ((Function1)null);
    this.c = ((Function2)null);
    this.jdField_b_of_type_KotlinJvmFunctionsFunction1 = ((Function1)null);
  }
  
  public void a(@NotNull Activity paramActivity, long paramLong, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString, "scene");
    if (((CharSequence)paramString).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        for (;;)
        {
          try
          {
            paramString = new JSONObject(paramString);
            i = paramString.optInt("key_from");
            paramString = paramString.optString("key_callback", "");
            switch (i)
            {
            case 1: 
              Intrinsics.checkExpressionValueIsNotNull(paramString, "callback");
              a(paramActivity, paramLong, i, paramString);
              return;
            }
          }
          catch (JSONException paramActivity)
          {
            QLog.d("UserActionHandlerImpl", 0, paramActivity.toString());
            return;
          }
          a(paramActivity, paramLong, i);
          return;
          paramActivity.finish();
          return;
        }
      }
      return;
    }
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
    paramFunction1 = new Intent((Context)paramActivity, TroopBarPublishLocationSelectActivity.class);
    if (paramLocationInfo != null) {
      paramFunction1.putExtra("key_selected_poi", (Parcelable)new TroopBarPOI(paramLocationInfo.getUid(), "", paramLocationInfo.getName(), (int)paramLocationInfo.getLongitude(), paramLocationInfo.getAddr(), (int)paramLocationInfo.getLatitude(), ""));
    }
    ActivityCompat.startActivityForResult(paramActivity, paramFunction1, 50001, null);
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
    this.c = paramFunction2;
    paramFunction2 = new Intent((Context)paramActivity, NewPhotoListActivity.class);
    paramFunction2.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    paramFunction2.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramFunction2.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    paramFunction2.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    paramFunction2.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    paramFunction2.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    paramFunction2.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    String str = TKDPublisherUtils.a.a().b() + TKDPublisherUtils.a.a().a() + '/';
    paramFunction2.putExtra("PhotoConst.TARGET_PATH", str + System.currentTimeMillis() + ".jpg");
    paramFunction2.putExtra("PhotoConst.CLIP_WIDTH", 640);
    paramFunction2.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    paramFunction2.putExtra("PhotoConst.TARGET_WIDTH", 640);
    paramFunction2.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    paramActivity.startActivity(paramFunction2);
    AlbumUtil.anim(paramActivity, false, true);
  }
  
  public void b(@NotNull Activity paramActivity, @Nullable Bundle paramBundle, @NotNull Function2<? super EditObject, ? super Bundle, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "callback");
    this.jdField_b_of_type_KotlinJvmFunctionsFunction2 = paramFunction2;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    PublicFragmentActivity.a(paramActivity, new Intent(), ReadInJoyTopicSelectionFragment.class, 40001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.UserActionHandlerImpl
 * JD-Core Version:    0.7.0.1
 */