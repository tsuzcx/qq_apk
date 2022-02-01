package com.tencent.mobileqq.kandian.biz.hippy.module;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.tencent.hippy.qq.module.QQBaseLifecycleModule;
import com.tencent.mobileqq.kandian.biz.comment.emotion.cache.RIJEmotionCacheManager;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkWrapper;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil;
import com.tencent.mobileqq.kandian.biz.comment.util.api.impl.RIJCommentEmotionUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSUtils;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.ITKDHippyEventDispatcherOwner;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.ITKDHippyEventReceiver;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.app.TKDTuWenHippyEngine;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@HippyNativeModule(init=true, name="TKDCommentBizModule")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/hippy/module/TKDCommentBizModule;", "Lcom/tencent/hippy/qq/module/QQBaseLifecycleModule;", "context", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "commentPublisherPromise", "Lcom/tencent/mtt/hippy/modules/Promise;", "extraParams", "", "hippyCommentEvent", "com/tencent/mobileqq/kandian/biz/hippy/module/TKDCommentBizModule$hippyCommentEvent$1", "Lcom/tencent/mobileqq/kandian/biz/hippy/module/TKDCommentBizModule$hippyCommentEvent$1;", "hippyEventDispatcher", "Lcom/tencent/mobileqq/kandian/biz/hippy/interfaces/dispatcher/ITKDHippyEventDispatcher;", "buildCallbackInfo", "Lcom/tencent/mtt/hippy/common/HippyMap;", "resultCode", "", "errorCode", "comment", "(ILjava/lang/Integer;Ljava/lang/String;)Lcom/tencent/mtt/hippy/common/HippyMap;", "buildCommentEditorIntent", "Landroid/content/Intent;", "params", "closeComment", "", "promise", "closeSubComment", "decodeQQEmotionString", "destroy", "forbidScroll", "getCommentEmotionData", "getCurrentFontScaleFactor", "getShareLine", "", "", "isFirstComment", "", "(Z)[Ljava/util/List;", "handleError", "msg", "t", "", "handleOnActivityResult", "data", "initialize", "onActivityCreated", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResult", "requestCode", "onActivityResumed", "onActivityStarted", "onActivityStopped", "onClickFollow", "onClickLike", "onCommentViewLayout", "onCreateComment", "onDeleteComment", "onLoadStatusChanged", "openComment", "openCommentDetail", "openCommentPublisher", "openMiniApp", "openQQGroup", "openSubComment", "sendEventToJs", "eventName", "hippyMap", "shareComment", "updateCommentCount", "Companion", "MyTKDTuWen2HippyEventReceiver", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class TKDCommentBizModule
  extends QQBaseLifecycleModule
{
  private static final String ARG_ANCHOR_ID = "anchorId";
  private static final String ARG_ANONYMOUS = "anonymous";
  private static final String ARG_COMMENT_INFO = "commentInfo";
  private static final String ARG_COMMENT_NUM = "commentNum";
  private static final String ARG_CONTENT_SRC = "contentSrc";
  private static final String ARG_EXTRA_PARAMS = "extraParam";
  private static final String ARG_FOLLOW_STATUS = "followStatus";
  private static final String ARG_FOLLOW_UIN = "followUin";
  private static final String ARG_FORBID = "forbid";
  private static final String ARG_FORBIDDEN = "forbidden";
  private static final String ARG_HINT = "hint";
  private static final String ARG_IS_LIKE = "isLike";
  private static final String ARG_MAX_TEXT_LIMIT = "maxTextLimit";
  private static final String ARG_MINI_APP_URL = "miniAppUrl";
  private static final String ARG_PUBLISHER_CONFIG = "publisherConfig";
  private static final String ARG_READ_TIME = "readTime";
  private static final String ARG_REPLIED_COMMENT_ID = "repliedCommentId";
  private static final String ARG_REPLY_HAS_LINK = "replyHasLink";
  private static final String ARG_RESULT_CODE = "retCode";
  private static final String ARG_ROW_KEY = "rowKey";
  private static final String ARG_SHOW_AT_ICON = "showAtIcon";
  private static final String ARG_SHOW_BIU_ICON = "showBiuIcon";
  private static final String ARG_STATUS = "status";
  private static final String ARG_SUB_COMMENT = "subComment";
  private static final String ARG_SUB_COMMENT_ID = "subCommentId";
  public static final TKDCommentBizModule.Companion Companion = new TKDCommentBizModule.Companion(null);
  private static final String EVENT_CLOSECOMMENT = "@comment:swipe";
  private static final String EVENT_CLOSECOMMENT_DIRECTION_RIGHT = "right";
  private static final String EVENT_CLOSECOMMENT_KEY_DIRECTION = "direction";
  private static final String EVENT_DELETE_SUB_COMMENT = "@comment:deleteLevel2Comment";
  private static final String EVENT_DEL_MAIN_COMMENT = "@comment:deleteLevel1Comment";
  private static final String EVENT_FONTSCALE = "@comment:onFontScaleChange";
  private static final String EVENT_FONTSCALE_SCALEFACTOR = "scaleFactor";
  private static final String EVENT_INSERT_SUB_COMMENT = "@comment:insertLevel2Comment";
  private static final String EVENT_LIFECYCLE = "@common:lifecycle";
  private static final String EVENT_LIFECYCLE_KEY = "type";
  private static final String EVENT_LIKE_MAIN_COMMENT = "@comment:toggleLevel1PraiseStatus";
  private static final String EVENT_ONACTIVE = "onActive";
  private static final String EVENT_ONDEACTIVE = "onDeactive";
  private static final String EVENT_ONDESTROY = "onDestroy";
  private static final String EVENT_ONSTART = "onStart";
  private static final String EVENT_OPEN_PUBLISHER = "@comment:openPublisher";
  private static final String EVENT_REFRESH_NEW_HOT = "@comment:refreshNewAndHot";
  private static final String EVENT_REPORT_COMMENT_READ_TIME = "@comment:reportCommentReadTime";
  private static final String EVENT_UPDATE_FOLLOW_UI = "@comment:updateFollowUI";
  private static final int REQ_CODE_COMMENT_EDITOR_NATIVE = 117;
  private static final int RET_CODE_CANCELED = -2;
  private static final int RET_CODE_FAILED = -1;
  private static final int RET_CODE_SUCCEED = 0;
  private static final String TAG = "TKDCommentBizModule";
  private Promise commentPublisherPromise;
  private String extraParams;
  private final TKDCommentBizModule.hippyCommentEvent.1 hippyCommentEvent = new TKDCommentBizModule.hippyCommentEvent.1(this);
  private ITKDHippyEventDispatcher hippyEventDispatcher;
  
  public TKDCommentBizModule(@Nullable HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private final HippyMap buildCallbackInfo(int paramInt, Integer paramInteger, String paramString)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("retCode", paramInt);
    int i = 0;
    if ((paramInteger != null) && (paramInteger.intValue() == -4096))
    {
      paramInteger = Integer.valueOf(0);
      paramInt = 1;
    }
    else
    {
      paramInt = 0;
    }
    localHippyMap.pushInt("errorType", paramInt);
    paramInt = i;
    if (paramInteger != null) {
      paramInt = paramInteger.intValue();
    }
    localHippyMap.pushInt("errorCode", paramInt);
    localHippyMap.pushString("comment", paramString);
    return localHippyMap;
  }
  
  private final Intent buildCommentEditorIntent(HippyMap paramHippyMap)
  {
    Object localObject2 = paramHippyMap.getMap("commentInfo");
    Object localObject3 = paramHippyMap.getMap("publisherConfig");
    Assert.assertNotNull("commentInfo cannot be null", localObject2);
    Assert.assertNotNull("publisherConfig cannot be null", localObject3);
    paramHippyMap = ((HippyMap)localObject2).getString("rowKey");
    if (paramHippyMap == null) {
      paramHippyMap = "";
    }
    String str1 = ((HippyMap)localObject2).getString("articleId");
    if (str1 == null) {
      str1 = "";
    }
    Object localObject1 = ((HippyMap)localObject2).getString("firstCommentId");
    if (localObject1 == null) {
      localObject1 = "";
    }
    String str2 = ((HippyMap)localObject2).getString("repliedSubCommentId");
    if (str2 == null) {
      str2 = "";
    }
    long l = ((HippyMap)localObject2).getLong("repliedSubAuthorId");
    int k = ((HippyMap)localObject2).getInt("scene");
    int m = ((HippyMap)localObject2).getInt("contentSrc");
    boolean bool2 = ((HippyMap)localObject3).getBoolean("anonymous");
    localObject2 = ((HippyMap)localObject3).getString("hint");
    if (localObject2 == null) {
      localObject2 = "";
    }
    localObject2 = Base64Util.decode((String)localObject2, 0);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "Base64Util.decode(publis…: \"\", Base64Util.DEFAULT)");
    String str3 = new String((byte[])localObject2, Charsets.UTF_8);
    localObject2 = ((HippyMap)localObject3).getString("defaultTxt");
    if (localObject2 == null) {
      localObject2 = "";
    }
    localObject2 = Base64Util.decode((String)localObject2, 0);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "Base64Util.decode(publis…: \"\", Base64Util.DEFAULT)");
    String str4 = new String((byte[])localObject2, Charsets.UTF_8);
    int j = ((HippyMap)localObject3).getInt("maxTextLimit");
    int i = j;
    if (j == 0) {
      i = -1;
    }
    boolean bool3 = ((HippyMap)localObject3).getBoolean("showAtIcon");
    boolean bool1;
    if (((HippyMap)localObject3).containsKey("showBiuIcon")) {
      bool1 = ((HippyMap)localObject3).getBoolean("showBiuIcon");
    } else {
      bool1 = true;
    }
    boolean bool4 = ((HippyMap)localObject3).getBoolean("isPgcAuthor");
    j = ((HippyMap)localObject3).getInt("replyHasLink");
    int n = ((HippyMap)localObject3).getInt("sourceType");
    int i1 = ((HippyMap)localObject3).getInt("commentType");
    int i2 = ((HippyMap)localObject3).getInt("firstAction");
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("public_fragment_window_feature", 1);
    ((Intent)localObject2).putExtra("comment_type", false);
    ((Intent)localObject2).putExtra("arg_comment_enable_anonymous", bool2);
    ((Intent)localObject2).putExtra("placeholder", str3);
    ((Intent)localObject2).putExtra("defaultTxt", str4);
    ((Intent)localObject2).putExtra("maxLength", i);
    ((Intent)localObject2).putExtra("arg_comment_open_at", bool3);
    ((Intent)localObject2).putExtra("comment_can_biu", bool1);
    if (((HippyMap)localObject3).containsKey("isPgcAuthor")) {
      ((Intent)localObject2).putExtra("isPgcAuthor", bool4);
    }
    ((Intent)localObject2).putExtra("comment_to_reply_contain_link", j);
    ((Intent)localObject2).putExtra("sourceType", n);
    ((Intent)localObject2).putExtra("commentType", i1);
    ((Intent)localObject2).putExtra("firstAction", i2);
    localObject3 = (CharSequence)localObject1;
    if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      localObject1 = new FirstCommentCreateData(m, "");
      ((FirstCommentCreateData)localObject1).b(paramHippyMap);
      ((FirstCommentCreateData)localObject1).c(str1);
      ((FirstCommentCreateData)localObject1).b(k);
      ((Intent)localObject2).putExtra("comment_create_data", (Parcelable)localObject1);
      return localObject2;
    }
    localObject3 = new SubCommentCreateData(m, "");
    ((SubCommentCreateData)localObject3).a((String)localObject1);
    ((SubCommentCreateData)localObject3).b(paramHippyMap);
    ((SubCommentCreateData)localObject3).c(str1);
    ((SubCommentCreateData)localObject3).a(l);
    ((SubCommentCreateData)localObject3).e(str2);
    ((SubCommentCreateData)localObject3).b(k);
    ((Intent)localObject2).putExtra("comment_create_data", (Parcelable)localObject3);
    return localObject2;
  }
  
  private final List<Integer>[] getShareLine(boolean paramBoolean)
  {
    List localList = (List)new ArrayList();
    if (paramBoolean)
    {
      localList.add(Integer.valueOf(2));
      localList.add(Integer.valueOf(3));
    }
    localList.add(Integer.valueOf(9));
    localList.add(Integer.valueOf(10));
    localList.add(Integer.valueOf(12));
    return new List[] { localList };
  }
  
  private final void handleError(String paramString, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(' ');
    if (paramThrowable != null) {
      paramString = paramThrowable.getMessage();
    } else {
      paramString = null;
    }
    localStringBuilder.append(paramString);
    QLog.e("TKDCommentBizModule", 1, localStringBuilder.toString());
  }
  
  @HippyMethod(name="closeComment")
  public final void closeComment(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    UIThreadUtils.runOnUiThread((Runnable)new TKDCommentBizModule.closeComment.1(this, paramHippyMap));
  }
  
  @HippyMethod(name="onSubCommentClose")
  public final void closeSubComment(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    UIThreadUtils.runOnUiThread((Runnable)new TKDCommentBizModule.closeSubComment.1(this, paramHippyMap));
  }
  
  @HippyMethod(name="decodeQQEmotionString")
  public final void decodeQQEmotionString(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    paramHippyMap = paramHippyMap.getString("text");
    if (paramHippyMap == null) {
      paramHippyMap = "";
    }
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("emotionText", EmotionCodecUtils.c(paramHippyMap));
    paramPromise.resolve(localHippyMap);
  }
  
  public void destroy()
  {
    ITKDHippyEventDispatcher localITKDHippyEventDispatcher = this.hippyEventDispatcher;
    if (localITKDHippyEventDispatcher != null) {
      localITKDHippyEventDispatcher.clear();
    }
  }
  
  @HippyMethod(name="forbidScroll")
  public final void forbidScroll(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    UIThreadUtils.runOnUiThread((Runnable)new TKDCommentBizModule.forbidScroll.1(this, paramHippyMap));
  }
  
  @HippyMethod(name="getCommentEmotionData")
  public final void getCommentEmotionData(@NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    String str = RIJCommentEmotionUtil.INSTANCE.getCommentEmotionDataForWeb();
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("emotionData", str);
    paramPromise.resolve(localHippyMap);
  }
  
  @HippyMethod(name="getCurrentFontScaleFactor")
  public final void getCurrentFontScaleFactor(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    paramHippyMap = new HippyMap();
    Float localFloat = FastWebPTSUtils.b();
    if (localFloat != null) {
      paramHippyMap.pushDouble("scaleFactor", ((Number)localFloat).floatValue());
    }
    paramPromise.resolve(paramHippyMap);
  }
  
  public final void handleOnActivityResult(int paramInt, @Nullable Intent paramIntent)
  {
    if ((paramInt == -1) && (paramIntent != null))
    {
      Object localObject3 = paramIntent.getParcelableExtra("comment_create_data");
      Object localObject1 = paramIntent.getStringExtra("arg_result_json");
      paramIntent = new StringBuilder();
      paramIntent.append("handleOnActivityResult() --> commentData:");
      paramIntent.append(localObject3);
      paramIntent.append(" resultJsonStr:");
      paramIntent.append((String)localObject1);
      QLog.d("TKDCommentBizModule", 1, paramIntent.toString());
      paramIntent = (JSONObject)null;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        paramIntent = (Intent)localObject1;
      }
      catch (JSONException localJSONException)
      {
        handleError("handleOnActivityResult() json parse error!", (Throwable)localJSONException);
      }
      if (paramIntent == null) {
        return;
      }
      paramIntent.optInt("feedsType");
      boolean bool2 = false;
      boolean bool1 = false;
      paramInt = paramIntent.optInt("biuAfterComment", 0);
      Object localObject2 = paramIntent.optJSONArray("linkList");
      if (localObject2 != null)
      {
        localObject4 = new TKDCommentBizModule.handleOnActivityResult.linkDataList.1.type.1().getType();
        localObject2 = (List)new Gson().fromJson(((JSONArray)localObject2).toString(), (Type)localObject4);
        if (localObject2 != null) {}
      }
      else
      {
        localObject2 = (List)new ArrayList();
      }
      Object localObject4 = (RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver)new TKDCommentBizModule.handleOnActivityResult.observer.1(this);
      CommentData localCommentData = new CommentData();
      RIJCommentRptDataUtil.a(paramIntent, (BaseCommentData)localCommentData);
      if ((localObject3 instanceof FirstCommentCreateData))
      {
        localObject3 = (FirstCommentCreateData)localObject3;
        ((FirstCommentCreateData)localObject3).b((List)localObject2);
        paramIntent = localCommentData.commentContent;
        Intrinsics.checkExpressionValueIsNotNull(paramIntent, "baseCommentData.commentContent");
        ((FirstCommentCreateData)localObject3).a(paramIntent);
        ((FirstCommentCreateData)localObject3).a(localCommentData.commentRptDataList);
        localObject2 = RIJCommentNetworkWrapper.INSTANCE;
        if (paramInt == 1) {
          bool1 = true;
        }
        paramIntent = this.extraParams;
        if (paramIntent == null) {
          paramIntent = "";
        }
        ((RIJCommentNetworkWrapper)localObject2).createFirstCommentForHippy((FirstCommentCreateData)localObject3, (RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver)localObject4, bool1, paramIntent);
        return;
      }
      if ((localObject3 instanceof SubCommentCreateData))
      {
        localObject3 = (SubCommentCreateData)localObject3;
        ((SubCommentCreateData)localObject3).b((List)localObject2);
        paramIntent = localCommentData.commentContent;
        Intrinsics.checkExpressionValueIsNotNull(paramIntent, "baseCommentData.commentContent");
        ((SubCommentCreateData)localObject3).d(paramIntent);
        ((SubCommentCreateData)localObject3).a(localCommentData.commentRptDataList);
        localObject2 = RIJCommentNetworkWrapper.INSTANCE;
        bool1 = bool2;
        if (paramInt == 1) {
          bool1 = true;
        }
        paramIntent = this.extraParams;
        if (paramIntent == null) {
          paramIntent = "";
        }
        ((RIJCommentNetworkWrapper)localObject2).createSubCommentForHippy((SubCommentCreateData)localObject3, (RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver)localObject4, bool1, paramIntent);
        return;
      }
      paramIntent = new StringBuilder();
      paramIntent.append("handleOnActivityResult: createCommentData=");
      paramIntent.append(localObject3);
      QLog.d("TKDCommentBizModule", 1, paramIntent.toString());
      return;
    }
    paramIntent = this.commentPublisherPromise;
    if (paramIntent != null) {
      paramIntent.resolve(buildCallbackInfo$default(this, -2, null, null, 6, null));
    }
    QLog.d("TKDCommentBizModule", 1, "cancel comment");
  }
  
  public void initialize()
  {
    super.initialize();
    if ((getHippyQQEngine() instanceof ITKDHippyEventDispatcherOwner))
    {
      localObject = getHippyQQEngine();
      if (localObject != null) {
        this.hippyEventDispatcher = ((ITKDHippyEventDispatcherOwner)localObject).getTKDHippyEventDispatcher();
      } else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.hippy.interfaces.ITKDHippyEventDispatcherOwner");
      }
    }
    Object localObject = this.hippyEventDispatcher;
    if (localObject != null) {
      ((ITKDHippyEventDispatcher)localObject).register((ITKDHippyEventReceiver)this.hippyCommentEvent);
    }
    if ((getHippyQQEngine() instanceof TKDTuWenHippyEngine))
    {
      localObject = this.hippyEventDispatcher;
      if (localObject != null) {
        ((ITKDHippyEventDispatcher)localObject).register((ITKDHippyEventReceiver)new TKDCommentBizModule.MyTKDTuWen2HippyEventReceiver(this));
      }
    }
    RIJEmotionCacheManager.b();
  }
  
  public void onActivityCreated(@Nullable Activity paramActivity, @Nullable Bundle paramBundle)
  {
    paramActivity = new HippyMap();
    paramActivity.pushString("type", "onStart");
    sendEventToJs("@common:lifecycle", paramActivity);
  }
  
  public void onActivityDestroyed(@Nullable Activity paramActivity)
  {
    paramActivity = new HippyMap();
    paramActivity.pushString("type", "onDestroy");
    sendEventToJs("@common:lifecycle", paramActivity);
  }
  
  public void onActivityPaused(@Nullable Activity paramActivity)
  {
    paramActivity = new HippyMap();
    paramActivity.pushString("type", "onDeactive");
    sendEventToJs("@common:lifecycle", paramActivity);
  }
  
  public void onActivityResult(@Nullable Activity paramActivity, int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    UIThreadUtils.runOnUiThread((Runnable)new TKDCommentBizModule.onActivityResult.1(this, paramInt1, paramInt2, paramIntent));
  }
  
  public void onActivityResumed(@Nullable Activity paramActivity)
  {
    paramActivity = new HippyMap();
    paramActivity.pushString("type", "onActive");
    sendEventToJs("@common:lifecycle", paramActivity);
  }
  
  public void onActivityStarted(@Nullable Activity paramActivity) {}
  
  public void onActivityStopped(@Nullable Activity paramActivity) {}
  
  @HippyMethod(name="onClickFollow")
  public final void onClickFollow(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    UIThreadUtils.runOnUiThread((Runnable)new TKDCommentBizModule.onClickFollow.1(paramHippyMap));
  }
  
  @HippyMethod(name="onClickLike")
  public final void onClickLike(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    paramPromise = paramHippyMap.getString("rowkey");
    if (paramPromise == null) {
      paramPromise = "";
    }
    String str1 = paramHippyMap.getString("likeType");
    if (str1 == null) {
      str1 = "";
    }
    String str2 = paramHippyMap.getString("firstCommentId");
    if (str2 == null) {
      str2 = "";
    }
    String str3 = paramHippyMap.getString("subCommentId");
    if (str3 == null) {
      str3 = "";
    }
    UIThreadUtils.runOnUiThread((Runnable)new TKDCommentBizModule.onClickLike.1(this, paramHippyMap, paramPromise, str2, str1, str3));
  }
  
  @HippyMethod(name="onCommentViewLayout")
  public final void onCommentViewLayout(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    UIThreadUtils.runOnUiThread((Runnable)new TKDCommentBizModule.onCommentViewLayout.1(this, paramHippyMap));
  }
  
  @HippyMethod(name="onCreateComment")
  public final void onCreateComment(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    paramPromise = paramHippyMap.getString("rowkey");
    if (paramPromise == null) {
      paramPromise = "";
    }
    String str1 = paramHippyMap.getString("firstCommentId");
    if (str1 == null) {
      str1 = "";
    }
    String str2 = paramHippyMap.getString("content");
    if (str2 == null) {
      str2 = "";
    }
    String str3 = paramHippyMap.getString("level");
    if (str3 == null) {
      str3 = "";
    }
    String str4 = paramHippyMap.getString("subCommentId");
    if (str4 == null) {
      str4 = "";
    }
    String str5 = paramHippyMap.getString("repliedCommentId");
    if (str5 == null) {
      str5 = "";
    }
    String str6 = paramHippyMap.getString("commentData");
    if (str6 == null) {
      str6 = "";
    }
    UIThreadUtils.runOnUiThread((Runnable)new TKDCommentBizModule.onCreateComment.1(this, paramHippyMap, paramPromise, str1, str2, str3, str4, str5, str6));
  }
  
  @HippyMethod(name="onDeleteComment")
  public final void onDeleteComment(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    paramPromise = paramHippyMap.getString("rowkey");
    if (paramPromise == null) {
      paramPromise = "";
    }
    String str1 = paramHippyMap.getString("firstCommentId");
    if (str1 == null) {
      str1 = "";
    }
    String str2 = paramHippyMap.getString("subCommentId");
    if (str2 == null) {
      str2 = "";
    }
    String str3 = paramHippyMap.getString("totalDeleteCount");
    if (str3 == null) {
      str3 = "";
    }
    UIThreadUtils.runOnUiThread((Runnable)new TKDCommentBizModule.onDeleteComment.1(this, paramHippyMap, paramPromise, str1, str2, str3));
  }
  
  @HippyMethod(name="onLoadStatusChanged")
  public final void onLoadStatusChanged(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    UIThreadUtils.runOnUiThread((Runnable)new TKDCommentBizModule.onLoadStatusChanged.1(this, paramHippyMap));
  }
  
  @HippyMethod(name="openComment")
  public final void openComment(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    UIThreadUtils.runOnUiThread((Runnable)new TKDCommentBizModule.openComment.1(this, paramHippyMap));
  }
  
  @HippyMethod(name="openCommentDetail")
  public final void openCommentDetail(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    UIThreadUtils.runOnUiThread((Runnable)new TKDCommentBizModule.openCommentDetail.1(this, paramHippyMap));
  }
  
  @HippyMethod(name="openCommentPublisher")
  public final void openCommentPublisher(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    UIThreadUtils.runOnUiThread((Runnable)new TKDCommentBizModule.openCommentPublisher.1(this, paramHippyMap, paramPromise));
  }
  
  @HippyMethod(name="openMiniApp")
  public final void openMiniApp(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    UIThreadUtils.runOnUiThread((Runnable)new TKDCommentBizModule.openMiniApp.1(this, paramHippyMap));
  }
  
  @HippyMethod(name="openQQGroup")
  public final void openQQGroup(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    paramPromise = paramHippyMap.getString("feedType");
    Object localObject = "";
    if (paramPromise == null) {
      paramPromise = "";
    }
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    String str = paramHippyMap.getString("qqGroupUrl");
    if (str != null) {
      localObject = str;
    }
    localObjectRef.element = localObject;
    UIThreadUtils.runOnUiThread((Runnable)new TKDCommentBizModule.openQQGroup.1(this, paramHippyMap, localObjectRef, paramPromise));
  }
  
  @HippyMethod(name="onSubCommentOpen")
  public final void openSubComment(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    UIThreadUtils.runOnUiThread((Runnable)new TKDCommentBizModule.openSubComment.1(this, paramHippyMap));
  }
  
  public final void sendEventToJs(@NotNull String paramString, @NotNull HippyMap paramHippyMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventName");
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "hippyMap");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("eventName:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",params:");
    ((StringBuilder)localObject).append(paramHippyMap);
    QLog.d("TKDCommentBizModule", 1, ((StringBuilder)localObject).toString());
    localObject = this.mContext;
    if (localObject != null)
    {
      localObject = ((HippyEngineContext)localObject).getModuleManager();
      if (localObject != null)
      {
        localObject = (EventDispatcher)((HippyModuleManager)localObject).getJavaScriptModule(EventDispatcher.class);
        if (localObject != null) {
          ((EventDispatcher)localObject).receiveNativeEvent(paramString, paramHippyMap);
        }
      }
    }
  }
  
  @HippyMethod(name="shareComment")
  public final void shareComment(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    UIThreadUtils.runOnUiThread((Runnable)new TKDCommentBizModule.shareComment.1(this, paramHippyMap));
  }
  
  @HippyMethod(name="updateCommentCount")
  public final void updateCommentCount(@NotNull HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    UIThreadUtils.runOnUiThread((Runnable)new TKDCommentBizModule.updateCommentCount.1(this, paramHippyMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDCommentBizModule
 * JD-Core Version:    0.7.0.1
 */