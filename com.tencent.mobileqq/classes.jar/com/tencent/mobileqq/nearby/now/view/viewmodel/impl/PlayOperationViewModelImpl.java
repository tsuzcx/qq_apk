package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.now.NowSmallVideoHandler;
import com.tencent.mobileqq.nearby.now.NowSmallVideoObserver;
import com.tencent.mobileqq.nearby.now.model.ImageData;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager;
import com.tencent.mobileqq.nearby.now.share.IShortVideoShareUtil;
import com.tencent.mobileqq.nearby.now.utils.CommentsUtil;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView.OnCloseListener;
import com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel;
import com.tencent.mobileqq.nearby.now.view.widget.LikeAniView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyUserFollowReq;
import com.tencent.pb.now.ilive_short_video_label.FeedInfo;
import com.tencent.pb.now.ilive_short_video_label.GetShortVideoVideoLabelRsp;
import com.tencent.pb.now.ilive_short_video_label.VideoInfo;
import com.tencent.pb.now.ilive_short_video_label.VideoStatus;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.RoundRelativeLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.Object;>;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class PlayOperationViewModelImpl
  implements IPlayOperationViewModel
{
  private static int COLOR_BLUE = -15550475;
  private static int COLOR_WHITE = -1;
  public static int DIALOG_NO_TITLE = 0;
  static final String NOW_LIVE_URL_FORMAT = "nowmqqapi://now/openroom?first=2&roomid=%s&roomtype=0&fromid=qq_smallvideo";
  private static final String TAG = "PlayOperationViewModel";
  public static final String text_end;
  public static final String text_end_1;
  public static final String text_end_2;
  public static final String text_first = HardCodeUtil.a(2131708247);
  public static final String text_first_1 = HardCodeUtil.a(2131708235);
  private int DIALOG_DELETE_FEED = 6;
  private int DIALOG_DELETE_FEED_CONFIRM = 7;
  private int DIALOG_WITH_TITLE = 1;
  private final long DOUBLE_CLICK_INTERVAL = 500L;
  public QQAppInterface app;
  private long currentAnchorNowId;
  private int currentAnchorNowUserType;
  private String extraInfo;
  private long extraInfoUid;
  private String feedsId;
  String headUrl;
  private long headerInfoUid;
  private boolean isAggregation;
  private boolean isCanJump;
  private boolean isClickFollow = false;
  public volatile boolean isDialogShow = false;
  private boolean isFirstTime = true;
  private boolean isFollow;
  private boolean isHasVideoLabel;
  public volatile boolean isJubaoDialogShow = false;
  private boolean isLiked;
  private boolean isLocal;
  private boolean isMine;
  boolean isPlayingAnim = false;
  private boolean isRecord;
  private boolean isRequstingLike = false;
  private boolean isShowFollowAnim;
  private boolean isUseProgressiveMask = true;
  private boolean isUserClickAni = true;
  String jumpUrl;
  private int likes;
  public View mBinding;
  private StuffContainerView.OnCloseListener mCloseListener = null;
  private long mCurrentAnchorUin;
  private Dialog mDeleteConfirmDialog;
  int mFollowBackColor;
  private URLDrawable mForShare;
  private GestureDetector mGestureDetector;
  public View mHeadBinding = null;
  private int mLabelType = 0;
  private long mLastDoubleClickTime;
  private AnimatorSet mLikeAnimationSet;
  private PlayOperationViewModelImpl.LiveVideoLabelInfo mLiveVideoLabelInfo = new PlayOperationViewModelImpl.LiveVideoLabelInfo(this, null);
  private View.OnClickListener mOnCommentClickListener = null;
  private PlayOperationViewModelImpl.RecordVideoLabelInfo mRecordVideoLabelInfo = new PlayOperationViewModelImpl.RecordVideoLabelInfo(this, null);
  private int mRoomid;
  private PlayOperationViewModelImpl.TopicVideoLabelInfo mTopicVideoLabelInfo = new PlayOperationViewModelImpl.TopicVideoLabelInfo(this, null);
  VideoData mVideoData = new VideoData();
  private int mVideoPageSource = -1;
  private String nickName;
  NowSmallVideoObserver observer = new PlayOperationViewModelImpl.16(this);
  private int operatorMode = 0;
  private String recordTime;
  private String recordTitle;
  private String shareUrl;
  private String videoSrc;
  private int watchCount;
  
  static
  {
    text_end = HardCodeUtil.a(2131708227);
    text_end_1 = HardCodeUtil.a(2131708236);
    text_end_2 = HardCodeUtil.a(2131708246);
    DIALOG_NO_TITLE = 2;
  }
  
  private void animateLike()
  {
    this.mLikeAnimationSet.cancel();
    this.mLikeAnimationSet.start();
  }
  
  private AnimatorSet createLikeAnimation(View paramView)
  {
    AnimatorSet localAnimatorSet1 = new AnimatorSet();
    AnimatorSet localAnimatorSet2 = new AnimatorSet();
    localAnimatorSet2.playTogether(new Animator[] { ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.0F, 1.0F }), ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.0F, 1.0F }), ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F }) });
    localAnimatorSet2.setDuration(200L);
    AnimatorSet localAnimatorSet3 = new AnimatorSet();
    localAnimatorSet3.playTogether(new Animator[] { ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F }) });
    localAnimatorSet3.setDuration(350L);
    localAnimatorSet1.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimatorSet1.playSequentially(new Animator[] { localAnimatorSet3, localAnimatorSet2 });
    return localAnimatorSet1;
  }
  
  private void followNearbyUser()
  {
    int i;
    if (this.isFollow) {
      i = 2;
    } else {
      i = 1;
    }
    NowSummaryCard.NearbyUserFollowReq localNearbyUserFollowReq = new NowSummaryCard.NearbyUserFollowReq();
    localNearbyUserFollowReq.from.set(0);
    localNearbyUserFollowReq.id_type.set(0);
    localNearbyUserFollowReq.target_id.set(this.mVideoData.jdField_b_of_type_Long);
    localNearbyUserFollowReq.operation.set(i);
    ProtoUtils.a(this.app, new PlayOperationViewModelImpl.33(this), localNearbyUserFollowReq.toByteArray(), "NowSummaryCard.NearbyUserFollow");
  }
  
  private void followNowUser()
  {
    INowShortVideoProtoManager localINowShortVideoProtoManager = ((INowShortVideoProtoManager)QRoute.api(INowShortVideoProtoManager.class)).init(this.app);
    if (this.isFollow)
    {
      localINowShortVideoProtoManager.follow(this.mVideoData.jdField_h_of_type_Long, this.currentAnchorNowId, this.currentAnchorNowUserType, 11, false, new PlayOperationViewModelImpl.31(this));
      return;
    }
    this.isClickFollow = true;
    localINowShortVideoProtoManager.follow(this.mVideoData.jdField_h_of_type_Long, this.currentAnchorNowId, this.currentAnchorNowUserType, 11, true, new PlayOperationViewModelImpl.32(this));
  }
  
  private Pair<String, String> getShareTitleAndSummary(Map<String, Object> paramMap)
  {
    Object localObject2 = "";
    Object localObject1;
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      int i = ((Integer)paramMap.get("feed_type")).intValue();
      if (i == 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131708223));
        ((StringBuilder)localObject1).append("「");
        ((StringBuilder)localObject1).append(paramMap.get("anchor_nick_name"));
        ((StringBuilder)localObject1).append("」");
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131708233));
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131708222));
        ((StringBuilder)localObject2).append("「");
        ((StringBuilder)localObject2).append(paramMap.get("anchor_nick_name"));
        ((StringBuilder)localObject2).append("」");
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131708248));
        localObject2 = ((StringBuilder)localObject2).toString();
        paramMap = (Map<String, Object>)localObject1;
        localObject1 = localObject2;
      }
      else
      {
        if (i == 4)
        {
          if (!TextUtils.isEmpty((String)paramMap.get("record_title")))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("「");
            ((StringBuilder)localObject1).append(paramMap.get("recorder_nick_name"));
            ((StringBuilder)localObject1).append("」");
            ((StringBuilder)localObject1).append(text_first);
            ((StringBuilder)localObject1).append("【");
            ((StringBuilder)localObject1).append(paramMap.get("record_title"));
            ((StringBuilder)localObject1).append("】");
            ((StringBuilder)localObject1).append(text_end);
            localObject1 = ((StringBuilder)localObject1).toString();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("「");
            ((StringBuilder)localObject2).append(paramMap.get("recorder_nick_name"));
            ((StringBuilder)localObject2).append("」");
            ((StringBuilder)localObject2).append(text_first);
            ((StringBuilder)localObject2).append("【");
            ((StringBuilder)localObject2).append(paramMap.get("record_title"));
            ((StringBuilder)localObject2).append("】");
            ((StringBuilder)localObject2).append(text_end);
            localObject2 = ((StringBuilder)localObject2).toString();
            paramMap = (Map<String, Object>)localObject1;
            localObject1 = localObject2;
            break label720;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("「");
          ((StringBuilder)localObject1).append(paramMap.get("recorder_nick_name"));
          ((StringBuilder)localObject1).append("」");
          ((StringBuilder)localObject1).append(text_end_2);
          paramMap = ((StringBuilder)localObject1).toString();
        }
        else
        {
          if (!TextUtils.isEmpty((String)paramMap.get("record_title")))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("「");
            ((StringBuilder)localObject1).append(paramMap.get("recorder_nick_name"));
            ((StringBuilder)localObject1).append("」");
            ((StringBuilder)localObject1).append(HardCodeUtil.a(2131708229));
            ((StringBuilder)localObject1).append(paramMap.get("record_title"));
            ((StringBuilder)localObject1).append(HardCodeUtil.a(2131708224));
            localObject1 = ((StringBuilder)localObject1).toString();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("「");
            ((StringBuilder)localObject2).append(paramMap.get("recorder_nick_name"));
            ((StringBuilder)localObject2).append("」");
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131708244));
            ((StringBuilder)localObject2).append(paramMap.get("record_title"));
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131708226));
            localObject2 = ((StringBuilder)localObject2).toString();
            paramMap = (Map<String, Object>)localObject1;
            localObject1 = localObject2;
            break label720;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("「");
          ((StringBuilder)localObject1).append(paramMap.get("recorder_nick_name"));
          ((StringBuilder)localObject1).append("」");
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131708241));
          paramMap = ((StringBuilder)localObject1).toString();
        }
        localObject1 = "";
      }
    }
    else
    {
      localObject1 = "";
      paramMap = (Map<String, Object>)localObject2;
    }
    label720:
    return new Pair(paramMap, localObject1);
  }
  
  private void initBottomSelector()
  {
    this.mBinding.findViewById(2131364939).setOnTouchListener(new PlayOperationViewModelImpl.23(this));
    this.mBinding.findViewById(2131370025).setOnTouchListener(new PlayOperationViewModelImpl.24(this));
    this.mBinding.findViewById(2131377374).setOnTouchListener(new PlayOperationViewModelImpl.25(this));
    this.mBinding.findViewById(2131371479).setOnTouchListener(new PlayOperationViewModelImpl.26(this));
  }
  
  private void initLikeAnimation()
  {
    this.mLikeAnimationSet = new AnimatorSet();
    this.mLikeAnimationSet.setInterpolator(new AccelerateDecelerateInterpolator());
    this.mLikeAnimationSet.playTogether(new Animator[] { createLikeAnimation(this.mBinding.findViewById(2131377924)) });
  }
  
  private void initListener()
  {
    this.mHeadBinding.findViewById(2131368087).setOnClickListener(new PlayOperationViewModelImpl.4(this));
    this.mHeadBinding.findViewById(2131371862).setOnClickListener(new PlayOperationViewModelImpl.5(this));
    this.mHeadBinding.findViewById(2131367078).setOnClickListener(new PlayOperationViewModelImpl.6(this));
    this.mHeadBinding.findViewById(2131364719).setOnClickListener(new PlayOperationViewModelImpl.7(this));
    this.mBinding.findViewById(2131364939).setOnClickListener(new PlayOperationViewModelImpl.8(this));
    this.mBinding.findViewById(2131370025).setOnClickListener(new PlayOperationViewModelImpl.9(this));
    this.mBinding.findViewById(2131377374).setOnClickListener(new PlayOperationViewModelImpl.10(this));
    this.mBinding.findViewById(2131371479).setOnClickListener(new PlayOperationViewModelImpl.11(this));
    this.mBinding.findViewById(2131377927).setOnClickListener(new PlayOperationViewModelImpl.12(this));
  }
  
  private void notifyUIFollow(boolean paramBoolean)
  {
    ((NowSmallVideoHandler)this.app.getBusinessHandler(BusinessHandlerFactory.NOW_SMALL_VIDEO_HANDLER)).notifyUI(1000, true, new Object[] { Boolean.valueOf(paramBoolean), String.valueOf(this.mVideoData.jdField_a_of_type_Long) });
  }
  
  private void saveDeleteSuccessInfo(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("feeds_id", paramString);
      paramString = localJSONObject.toString();
      localSharedPreferences.edit().putString("nearby_now_delete_success_js_param", paramString).commit();
      return;
    }
    catch (JSONException paramString) {}
  }
  
  private void setViewBgColor(View paramView, int paramInt)
  {
    paramView = paramView.getBackground();
    if (paramView != null)
    {
      paramView.setColorFilter(new LightingColorFilter(-16777216, paramInt));
      paramView.invalidateSelf();
    }
  }
  
  private void showFollowSuccessAnim()
  {
    if (this.mHeadBinding.findViewById(2131367083) == null) {
      return;
    }
    this.mHeadBinding.findViewById(2131367076).clearAnimation();
    this.mHeadBinding.findViewById(2131367073).clearAnimation();
    int i = (int)UITools.a(this.mHeadBinding.getContext(), 20.0F);
    Object localObject1 = this.mHeadBinding.findViewById(2131367057);
    float f = -i;
    localObject1 = ObjectAnimator.ofFloat(localObject1, "translationY", new float[] { 0.0F, f });
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mHeadBinding.findViewById(2131367077), "translationY", new float[] { 0.0F, f });
    Object localObject2 = ObjectAnimator.ofFloat(this.mHeadBinding.findViewById(2131367083), "translationY", new float[] { i, 0.0F });
    this.mHeadBinding.findViewById(2131367083).setVisibility(0);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObject2, localObject1, localObjectAnimator });
    localAnimatorSet.setDuration(500L);
    localAnimatorSet.start();
    localObject1 = ObjectAnimator.ofFloat(this.mHeadBinding.findViewById(2131367078), "scaleX", new float[] { 1.0F, 0.75F, 0.5F, 0.2F, 0.0F });
    localObjectAnimator = ObjectAnimator.ofFloat(this.mHeadBinding.findViewById(2131367078), "scaleY", new float[] { 1.0F, 0.75F, 0.5F, 0.25F, 0.0F });
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playTogether(new Animator[] { localObject1, localObjectAnimator });
    ((AnimatorSet)localObject2).addListener(new PlayOperationViewModelImpl.30(this));
    ((AnimatorSet)localObject2).setDuration(500L);
    ((AnimatorSet)localObject2).setStartDelay(800L);
    ((AnimatorSet)localObject2).start();
  }
  
  private void showFollowTipsAnim()
  {
    if (this.mHeadBinding.findViewById(2131367057) == null) {
      return;
    }
    this.isShowFollowAnim = true;
    this.isPlayingAnim = false;
    this.mHeadBinding.findViewById(2131367078).setPivotX(UITools.a(this.mHeadBinding.getContext(), 55.0F) / 2.0F);
    this.mHeadBinding.findViewById(2131367078).setPivotY(UITools.a(this.mHeadBinding.getContext(), 20.0F) / 2.0F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.mHeadBinding.findViewById(2131367078), "scaleY", new float[] { 0.52F, 1.0F, 0.72F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.mHeadBinding.findViewById(2131367078), "scaleX", new float[] { 0.52F, 1.0F, 0.72F, 1.0F });
    localObjectAnimator1.setDuration(800L);
    localObjectAnimator2.setDuration(800L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.mHeadBinding.findViewById(2131367073), "translationX", new float[] { 0.0F, UITools.a(this.mHeadBinding.getContext(), 55.0F) });
    localObjectAnimator3.setStartDelay(1500L);
    localObjectAnimator3.setDuration(800L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    localAnimatorSet.addListener(new PlayOperationViewModelImpl.28(this));
    localObjectAnimator3.addListener(new PlayOperationViewModelImpl.29(this));
    localAnimatorSet.start();
    localObjectAnimator3.start();
  }
  
  private void showWhiteHeadBlock()
  {
    ((TextView)this.mHeadBinding.findViewById(2131371862)).setTextColor(Color.parseColor("#000000"));
    ((TextView)this.mHeadBinding.findViewById(2131366395)).setTextColor(Color.parseColor("#bbbbbb"));
    ((TextView)this.mHeadBinding.findViewById(2131367057)).setTextColor(COLOR_WHITE);
    ((TextView)this.mHeadBinding.findViewById(2131367077)).setTextColor(COLOR_WHITE);
    setViewBgColor(this.mHeadBinding.findViewById(2131367083), COLOR_WHITE);
    this.mFollowBackColor = COLOR_BLUE;
    if (!this.isPlayingAnim)
    {
      this.mHeadBinding.findViewById(2131367075).setBackgroundColor(COLOR_BLUE);
      this.mHeadBinding.findViewById(2131367076).setBackgroundDrawable(null);
    }
    else
    {
      setViewBgColor(this.mHeadBinding.findViewById(2131367076), COLOR_BLUE);
    }
    this.mHeadBinding.findViewById(2131368065).setBackgroundColor(-1);
    this.mHeadBinding.findViewById(2131364721).setVisibility(8);
    this.mHeadBinding.findViewById(2131364720).setVisibility(0);
    View localView = this.mHeadBinding.findViewById(2131368065).findViewById(2131363667);
    if (localView.getVisibility() == 8) {
      localView.setVisibility(0);
    }
  }
  
  public void destroy()
  {
    this.mCloseListener = null;
    this.app.removeObserver(this.observer);
    Dialog localDialog = this.mDeleteConfirmDialog;
    if (localDialog != null)
    {
      localDialog.dismiss();
      this.mDeleteConfirmDialog = null;
    }
  }
  
  public AppInterface getApp()
  {
    return this.app;
  }
  
  public String getExtraInfo()
  {
    return this.extraInfo;
  }
  
  public boolean getIsAggregation()
  {
    return this.isAggregation;
  }
  
  public boolean getIsCanJump()
  {
    return this.isCanJump;
  }
  
  public boolean getIsFollow()
  {
    return this.isFollow;
  }
  
  public boolean getIsLiked()
  {
    return this.isLiked;
  }
  
  public boolean getIsLocal()
  {
    return this.isLocal;
  }
  
  public boolean getIsMine()
  {
    return this.isMine;
  }
  
  public boolean getIsRecord()
  {
    return this.isRecord;
  }
  
  public int getLikes()
  {
    return this.likes;
  }
  
  public String getNickName()
  {
    return this.nickName;
  }
  
  public int getOperatorMode()
  {
    return this.operatorMode;
  }
  
  public String getRecordTime()
  {
    return this.recordTime;
  }
  
  public String getRecordTitle()
  {
    return this.recordTitle;
  }
  
  public String getVideoSrc()
  {
    return this.videoSrc;
  }
  
  public int getWatchCount()
  {
    return this.watchCount;
  }
  
  public View getmBinding()
  {
    return this.mBinding;
  }
  
  public View getmHeadBinding()
  {
    return this.mHeadBinding;
  }
  
  public void hideCommentsWidget() {}
  
  public void hideHead()
  {
    View localView = this.mHeadBinding;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public IPlayOperationViewModel init(View paramView, AppInterface paramAppInterface)
  {
    this.mBinding = paramView;
    this.app = ((QQAppInterface)paramAppInterface);
    this.app.addObserver(this.observer);
    this.mBinding.setOnTouchListener(new PlayOperationViewModelImpl.1(this));
    this.mGestureDetector = new GestureDetector(this.mBinding.getContext(), new PlayOperationViewModelImpl.2(this));
    this.mGestureDetector.setOnDoubleTapListener(new PlayOperationViewModelImpl.3(this));
    initLikeAnimation();
    initBottomSelector();
    return this;
  }
  
  public void initCommentsWidget()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initCommentsWidget:mVideoData=");
      localStringBuilder.append(this.mVideoData);
      QLog.i("PlayOperationViewModel", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initCommentsWidget:mRoomid=");
      localStringBuilder.append(this.mRoomid);
      localStringBuilder.append("isHasVideoLabel=");
      localStringBuilder.append(this.isHasVideoLabel);
      QLog.i("PlayOperationViewModel", 2, localStringBuilder.toString());
    }
    this.mRoomid = 0;
    queryVideoState(this.mVideoData.jdField_h_of_type_Long);
    setOpenRoomHeadUrl(this.mVideoData.jdField_f_of_type_JavaLangString);
  }
  
  public boolean isDialogShow()
  {
    return this.isDialogShow;
  }
  
  public boolean isJubaoDialogShow()
  {
    return this.isJubaoDialogShow;
  }
  
  public void onClickClose(View paramView)
  {
    paramView = this.mCloseListener;
    if (paramView != null) {
      paramView.a(this.mVideoData.k);
    }
  }
  
  public void onClickFollow(View paramView)
  {
    if (!NearbyUtils.a(paramView.getContext()))
    {
      QQToast.a(paramView.getContext(), 0, paramView.getContext().getResources().getString(2131694422), 0).a();
      return;
    }
    if (this.mVideoData.jdField_c_of_type_Long > 0L)
    {
      followNowUser();
      return;
    }
    followNearbyUser();
  }
  
  public void onClickHeader(View paramView)
  {
    Object localObject1 = ((INearbyCardManager)this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.mVideoData.jdField_h_of_type_Long);
    ((StringBuilder)localObject2).append("");
    ((ConcurrentHashMap)localObject1).put(((StringBuilder)localObject2).toString(), Integer.valueOf(1));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("&from=3");
    localObject2 = this.app.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.headerInfoUid);
    int i;
    if (((String)localObject2).equals(localStringBuilder.toString())) {
      i = 2;
    } else {
      i = 3;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("&mode=");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("mqq://card/show_pslcard/?source=4&uin=");
    ((StringBuilder)localObject2).append(this.headerInfoUid);
    ((StringBuilder)localObject2).append("&card_type=nearby");
    ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
    ((StringBuilder)localObject2).append("&now_id=");
    ((StringBuilder)localObject2).append(this.mVideoData.jdField_c_of_type_Long);
    ((StringBuilder)localObject2).append("&now_user_type=");
    ((StringBuilder)localObject2).append(this.mVideoData.jdField_d_of_type_Int);
    localObject1 = ((StringBuilder)localObject2).toString();
    paramView.getContext().startActivity(new Intent(paramView.getContext(), JumpActivity.class).setData(Uri.parse((String)localObject1)));
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_post_click").genderInd1().reportByVideo(this.app);
    ThreadManagerV2.excute(new PlayOperationViewModelImpl.17(this, (INearbyCardManager)this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
    ReportController.b(this.app, "dc00899", "grp_lbs", "", "new_thing", "clk_card", 0, 0, "", "", "", "2");
  }
  
  public void onClickLabelJump(View paramView)
  {
    if (!this.isHasVideoLabel) {
      return;
    }
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_label_click").genderInd1().reportByVideo(this.app);
    ThreadManagerV2.excute(new PlayOperationViewModelImpl.13(this, (INearbyCardManager)this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
    int i = this.mLabelType;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("uin", this.app.getCurrentAccountUin());
      ((Intent)localObject).putExtra("url", this.mTopicVideoLabelInfo.jdField_c_of_type_JavaLangString);
      paramView.getContext().startActivity((Intent)localObject);
      return;
    }
    Object localObject = String.format("nowmqqapi://now/openroom?first=2&roomid=%s&roomtype=0&fromid=qq_smallvideo", new Object[] { Integer.valueOf(this.mLiveVideoLabelInfo.jdField_a_of_type_Int) });
    JumpParser.a(this.app, paramView.getContext(), (String)localObject).a();
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_live_click").genderInd1().reportByVideo(this.app);
  }
  
  public void onClickLike(View paramView)
  {
    if (!NetworkUtil.a(this.mBinding.getContext()))
    {
      QQToast.a(this.mBinding.getContext(), 1, HardCodeUtil.a(2131708232), 1).a();
      return;
    }
    this.isRequstingLike = true;
    animateLike();
    paramView = ((INowShortVideoProtoManager)QRoute.api(INowShortVideoProtoManager.class)).init(this.app);
    if (!this.isLiked)
    {
      localVideoData = this.mVideoData;
      View localView = this.mBinding.findViewById(2131372194);
      int j = localView.getWidth() / 2;
      int k = localView.getHeight() / 2;
      int i;
      if (j != 0)
      {
        i = k;
        if (k != 0) {}
      }
      else
      {
        j = UITools.a(this.mBinding.getContext()) / 2;
        i = UITools.b(this.mBinding.getContext()) / 2;
      }
      if ((localVideoData != null) && (localVideoData.jdField_b_of_type_Int != VideoData.jdField_a_of_type_Int)) {
        ((LikeAniView)this.mBinding.findViewById(2131370024)).a(j, i);
      }
      paramView.feedsLike(this.feedsId, new PlayOperationViewModelImpl.14(this, localVideoData), null);
      ReportController.b(this.app, "dc00899", "grp_lbs", "", "new_thing", "clk_like", 0, 0, "", "", "", "2");
      return;
    }
    this.isUserClickAni = true;
    VideoData localVideoData = this.mVideoData;
    paramView.feedsUnLike(this.feedsId, new PlayOperationViewModelImpl.15(this, localVideoData), null);
  }
  
  public void onClickMore(View paramView)
  {
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_more_click").genderInd1().reportByVideo(this.app);
    ThreadManagerV2.excute(new PlayOperationViewModelImpl.19(this, (INearbyCardManager)this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
    paramView = (BaseActivity)this.mBinding.getContext();
    ActionSheet localActionSheet = ActionSheet.create(paramView);
    if (!this.isMine) {
      localActionSheet.addButton(2131717470, 1);
    } else {
      localActionSheet.addButton(HardCodeUtil.a(2131708221), 1);
    }
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new PlayOperationViewModelImpl.20(this, paramView, localActionSheet));
    localActionSheet.setOnDismissListener(new PlayOperationViewModelImpl.21(this));
    localActionSheet.show();
    this.isJubaoDialogShow = true;
  }
  
  public void onClickNickName(View paramView) {}
  
  public void onClickPublishComment(View paramView)
  {
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_com_click").genderInd1().reportByVideo(this.app);
    ThreadManagerV2.excute(new PlayOperationViewModelImpl.22(this, (INearbyCardManager)this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
    View.OnClickListener localOnClickListener = this.mOnCommentClickListener;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
  }
  
  public void onClickShare(View paramView)
  {
    Object localObject = new HashMap();
    if (this.mVideoData.k == 4)
    {
      if (this.mVideoData.jdField_a_of_type_JavaUtilArrayList.get(0) != null) {
        paramView = ((ImageData)this.mVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString;
      } else {
        paramView = "";
      }
    }
    else {
      paramView = this.mVideoData.jdField_c_of_type_JavaLangString;
    }
    ((Map)localObject).put("record_title", this.mVideoData.j);
    ((Map)localObject).put("id", this.feedsId);
    ((Map)localObject).put("anchor_nick_name", this.mVideoData.jdField_g_of_type_JavaLangString);
    ((Map)localObject).put("feed_type", Integer.valueOf(this.mVideoData.k));
    ((Map)localObject).put("recorder_nick_name", this.mVideoData.jdField_h_of_type_JavaLangString);
    ((Map)localObject).put("roomName", this.mVideoData.j);
    ((Map)localObject).put("bNewQZone", Boolean.valueOf(false));
    ((Map)localObject).put("source", Integer.valueOf(6));
    ((Map)localObject).put("play_operatro_view_model", this);
    ((Map)localObject).put("anchor_uin", Long.valueOf(this.mVideoData.jdField_a_of_type_Long));
    ((Map)localObject).put("record_uin", Long.valueOf(this.mVideoData.jdField_d_of_type_Long));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://now.qq.com/h5/view_record.html?_wv=1&_bid=2424&from=6&feeds_id=");
    ((StringBuilder)localObject).append(this.feedsId);
    String str1 = ((StringBuilder)localObject).toString();
    String str2 = HardCodeUtil.a(2131708242);
    localObject = HardCodeUtil.a(2131708240);
    if (!TextUtils.isEmpty(this.mVideoData.jdField_g_of_type_JavaLangString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("“「");
      ((StringBuilder)localObject).append(this.mVideoData.jdField_g_of_type_JavaLangString);
      ((StringBuilder)localObject).append("」”");
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131708237));
      localObject = ((StringBuilder)localObject).toString();
    }
    ((IShortVideoShareUtil)QRoute.api(IShortVideoShareUtil.class)).showShareActionSheet(this.app, (BaseActivity)this.mBinding.getContext(), String.valueOf(this.mVideoData.jdField_a_of_type_Long), "", str1, str2, (String)localObject, paramView, paramView, this.mForShare, new PlayOperationViewModelImpl.18(this));
    this.isDialogShow = true;
  }
  
  public void parseShortVideoVideoLabel(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (ilive_short_video_label.GetShortVideoVideoLabelRsp)paramObject;
    this.mRoomid = paramObject.video_status.root_room_id.get();
    this.mLabelType = paramObject.type.get();
    TextView localTextView = (TextView)this.mBinding.findViewById(2131380657);
    RoundRelativeLayout localRoundRelativeLayout = (RoundRelativeLayout)this.mBinding.findViewById(2131377927);
    localRoundRelativeLayout.a(10);
    localRoundRelativeLayout.requestLayout();
    int i = this.mLabelType;
    boolean bool = true;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          localRoundRelativeLayout.setVisibility(8);
        }
        else
        {
          this.mRecordVideoLabelInfo.jdField_a_of_type_JavaLangString = paramObject.video_info.url.get();
          this.mRecordVideoLabelInfo.b = paramObject.video_info.cover_url.get();
          localTextView.setText(HardCodeUtil.a(2131708228));
          localRoundRelativeLayout.setBackgroundResource(2130845675);
          localRoundRelativeLayout.setVisibility(0);
        }
      }
      else
      {
        this.mTopicVideoLabelInfo.jdField_a_of_type_JavaLangString = paramObject.feed_info.feed_id.get().toStringUtf8();
        this.mTopicVideoLabelInfo.b = paramObject.feed_info.topic.get();
        this.mTopicVideoLabelInfo.jdField_c_of_type_JavaLangString = paramObject.feed_info.url.get();
        localTextView.setText(this.mTopicVideoLabelInfo.b);
        localRoundRelativeLayout.setBackgroundResource(2130845674);
        localRoundRelativeLayout.setVisibility(0);
      }
    }
    else
    {
      this.mLiveVideoLabelInfo.jdField_a_of_type_Int = paramObject.video_status.root_room_id.get();
      localTextView.setText(HardCodeUtil.a(2131708225));
      localRoundRelativeLayout.setBackgroundResource(2130845672);
      localRoundRelativeLayout.setVisibility(0);
    }
    if (this.mLabelType == 0) {
      bool = false;
    }
    this.isHasVideoLabel = bool;
  }
  
  public boolean queryVideoState(long paramLong)
  {
    ((INowShortVideoProtoManager)QRoute.api(INowShortVideoProtoManager.class)).init(this.app).getShortLabel(paramLong, this.feedsId, new PlayOperationViewModelImpl.27(this));
    return true;
  }
  
  public void release() {}
  
  public void reshowOperaView()
  {
    if (!this.isRecord)
    {
      if (this.isLocal) {
        return;
      }
      this.mBinding.findViewById(2131363759).setVisibility(0);
      this.mBinding.findViewById(2131363759).setAlpha(1.0F);
    }
  }
  
  public void setAgeAndGender(int paramInt1, int paramInt2)
  {
    Object localObject = this.mHeadBinding;
    if (localObject != null)
    {
      localObject = (ImageView)((View)localObject).findViewById(2131362297);
      ((ImageView)localObject).setVisibility(0);
      if (paramInt2 == 1) {
        ((ImageView)localObject).setBackgroundDrawable(((ImageView)localObject).getResources().getDrawable(2130845669));
      } else {
        ((ImageView)localObject).setBackgroundDrawable(((ImageView)localObject).getResources().getDrawable(2130845667));
      }
      if ((paramInt2 != 255) && (paramInt2 != 0))
      {
        ((ImageView)localObject).setVisibility(0);
        return;
      }
      ((ImageView)localObject).setVisibility(8);
    }
  }
  
  public void setAggregation(boolean paramBoolean)
  {
    this.isAggregation = paramBoolean;
  }
  
  public void setApp(AppInterface paramAppInterface)
  {
    this.app = ((QQAppInterface)paramAppInterface);
  }
  
  public void setCanJump(boolean paramBoolean)
  {
    this.isCanJump = paramBoolean;
  }
  
  public void setCommentsCount(long paramLong)
  {
    if (paramLong <= 0L)
    {
      ((TextView)this.mBinding.findViewById(2131377914)).setText(HardCodeUtil.a(2131708245));
      return;
    }
    ((TextView)this.mBinding.findViewById(2131377914)).setText(CommentsUtil.c(paramLong));
  }
  
  public void setCurrentAnchorUin(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCurrentAnchorUin,currentAnchorUin:");
      localStringBuilder.append(paramLong);
      QLog.i("PlayOperationViewModel", 2, localStringBuilder.toString());
    }
    this.mCurrentAnchorUin = paramLong;
  }
  
  public void setDialogShow(boolean paramBoolean)
  {
    this.isDialogShow = paramBoolean;
  }
  
  public void setExtraInfo(String paramString)
  {
    this.extraInfo = paramString;
    ((TextView)this.mHeadBinding.findViewById(2131366395)).setText(paramString);
  }
  
  public void setFeedType(int paramInt)
  {
    View localView = this.mHeadBinding;
    if ((localView != null) && (!this.isLocal)) {
      localView.findViewById(2131378833).setVisibility(0);
    }
  }
  
  public void setFollow(boolean paramBoolean)
  {
    this.isFollow = paramBoolean;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("is follow? ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("PlayOperationViewModel", 2, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("is Mine? ");
      ((StringBuilder)localObject).append(this.isMine);
      QLog.i("PlayOperationViewModel", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mHeadBinding;
    if (localObject != null)
    {
      if ((!this.isFollow) && (!this.isMine))
      {
        ((View)localObject).findViewById(2131367078).setVisibility(0);
        return;
      }
      this.mHeadBinding.findViewById(2131367078).setVisibility(8);
    }
  }
  
  public void setHeadBinding(View paramView)
  {
    this.mHeadBinding = paramView;
    ((RoundRelativeLayout)this.mHeadBinding.findViewById(2131367075)).a(16);
    this.mHeadBinding.findViewById(2131367075).requestLayout();
    ((RoundRelativeLayout)this.mHeadBinding.findViewById(2131367074)).a(16);
    this.mHeadBinding.findViewById(2131367074).requestLayout();
    initListener();
  }
  
  public void setHeadInfoMaskWhiteMode()
  {
    showWhiteHeadBlock();
    this.isUseProgressiveMask = false;
    setOperatorMode(1);
  }
  
  public void setHeadUrl(String paramString)
  {
    this.headUrl = paramString;
    if (this.mHeadBinding != null) {
      ((IImageLoader)QRoute.api(IImageLoader.class)).displayImage((ImageView)this.mHeadBinding.findViewById(2131368087), paramString, this.mHeadBinding.getResources().getDrawable(2130845589), this.mHeadBinding.getResources().getDrawable(2130845589), null, true);
    }
  }
  
  public void setIsMine(boolean paramBoolean)
  {
    this.isMine = paramBoolean;
  }
  
  public void setJubaoDialogShow(boolean paramBoolean)
  {
    this.isJubaoDialogShow = paramBoolean;
  }
  
  public void setLiked(boolean paramBoolean)
  {
    this.isLiked = paramBoolean;
    this.mBinding.findViewById(2131377923).setSelected(this.isLiked);
  }
  
  public void setLikes(int paramInt)
  {
    this.likes = paramInt;
    if (paramInt > 0)
    {
      if (this.operatorMode == 1)
      {
        if (this.isLiked) {
          ((ImageView)this.mBinding.findViewById(2131377924)).setImageResource(2130845635);
        } else {
          ((ImageView)this.mBinding.findViewById(2131377924)).setImageResource(2130845653);
        }
      }
      else if (this.isLiked) {
        ((ImageView)this.mBinding.findViewById(2131377924)).setImageResource(2130845635);
      } else {
        ((ImageView)this.mBinding.findViewById(2131377924)).setImageResource(2130845634);
      }
      ((TextView)this.mBinding.findViewById(2131377923)).setText(CommentsUtil.c(paramInt));
      return;
    }
    if (this.operatorMode == 1) {
      ((ImageView)this.mBinding.findViewById(2131377924)).setImageResource(2130845653);
    } else {
      ((ImageView)this.mBinding.findViewById(2131377924)).setImageResource(2130845634);
    }
    ((TextView)this.mBinding.findViewById(2131377923)).setText(HardCodeUtil.a(2131708238));
  }
  
  public void setLocal(boolean paramBoolean)
  {
    this.isLocal = paramBoolean;
    View localView = this.mHeadBinding.findViewById(2131378833);
    int i;
    if ((!this.isRecord) && (!this.isLocal)) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  public void setNickName(String paramString)
  {
    this.nickName = paramString;
    ((TextView)this.mHeadBinding.findViewById(2131371862)).setText(paramString);
  }
  
  public void setOnCloseListener(Object paramObject)
  {
    this.mCloseListener = ((StuffContainerView.OnCloseListener)paramObject);
  }
  
  public void setOnCommentClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnCommentClickListener = paramOnClickListener;
  }
  
  public void setOpenRoomHeadUrl(String paramString) {}
  
  public void setOperatorMode(int paramInt)
  {
    this.operatorMode = paramInt;
    Object localObject = this.mBinding.findViewById(2131363759);
    if (this.operatorMode == 0) {
      paramInt = 2130845711;
    } else {
      paramInt = 2130845712;
    }
    ((View)localObject).setBackgroundResource(paramInt);
    localObject = (ImageView)this.mBinding.findViewById(2131377915);
    if (this.operatorMode == 0) {
      paramInt = 2130845632;
    } else {
      paramInt = 2130845633;
    }
    ((ImageView)localObject).setImageResource(paramInt);
    localObject = (ImageView)this.mBinding.findViewById(2131377929);
    if (this.operatorMode == 0) {
      paramInt = 2130845638;
    } else {
      paramInt = 2130845639;
    }
    ((ImageView)localObject).setImageResource(paramInt);
    localObject = (ImageView)this.mBinding.findViewById(2131377926);
    if (this.operatorMode == 0) {
      paramInt = 2130845636;
    } else {
      paramInt = 2130845637;
    }
    ((ImageView)localObject).setImageResource(paramInt);
    localObject = (TextView)this.mBinding.findViewById(2131377914);
    paramInt = this.operatorMode;
    int i = -1;
    if (paramInt == 0) {
      paramInt = -1;
    } else {
      paramInt = -16777216;
    }
    ((TextView)localObject).setTextColor(paramInt);
    localObject = (TextView)this.mBinding.findViewById(2131377923);
    if (this.operatorMode == 0) {
      paramInt = -1;
    } else {
      paramInt = -16777216;
    }
    ((TextView)localObject).setTextColor(paramInt);
    localObject = (TextView)this.mBinding.findViewById(2131377928);
    if (this.operatorMode == 0) {
      paramInt = -1;
    } else {
      paramInt = -16777216;
    }
    ((TextView)localObject).setTextColor(paramInt);
    localObject = (TextView)this.mBinding.findViewById(2131377925);
    if (this.operatorMode == 0) {
      paramInt = i;
    } else {
      paramInt = -16777216;
    }
    ((TextView)localObject).setTextColor(paramInt);
    setLikes(this.likes);
  }
  
  public void setRecord(boolean paramBoolean)
  {
    this.isRecord = paramBoolean;
    View localView = this.mHeadBinding.findViewById(2131378833);
    int i;
    if ((!this.isRecord) && (!this.isLocal)) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  public void setRecordTime(String paramString)
  {
    this.recordTime = paramString;
  }
  
  public void setRecordTitle(String paramString)
  {
    this.recordTitle = paramString;
  }
  
  public void setTopOperationBkg(int paramInt)
  {
    View localView = this.mHeadBinding;
    if (localView != null)
    {
      if (!this.isUseProgressiveMask) {
        return;
      }
      localView = localView.findViewById(2131368065).findViewById(2131363667);
      Object localObject;
      if ((paramInt > 10) && (paramInt < 70))
      {
        float f = (paramInt - 10) / 60.0F;
        localObject = new ArgbEvaluator();
        paramInt = ((Integer)((ArgbEvaluator)localObject).evaluate(f, Integer.valueOf(-1), Integer.valueOf(-16777216))).intValue();
        int i = ((Integer)((ArgbEvaluator)localObject).evaluate(f, Integer.valueOf(-1), Integer.valueOf(-4473925))).intValue();
        int j = ((Integer)((ArgbEvaluator)localObject).evaluate(f, Integer.valueOf(-637534209), Integer.valueOf(COLOR_BLUE))).intValue();
        ((Integer)((ArgbEvaluator)localObject).evaluate(f, Integer.valueOf(COLOR_BLUE), Integer.valueOf(-1))).intValue();
        ((TextView)this.mHeadBinding.findViewById(2131371862)).setTextColor(paramInt);
        ((TextView)this.mHeadBinding.findViewById(2131366395)).setTextColor(i);
        ((TextView)this.mHeadBinding.findViewById(2131367057)).setTextColor(COLOR_WHITE);
        ((TextView)this.mHeadBinding.findViewById(2131367077)).setTextColor(COLOR_WHITE);
        setViewBgColor(this.mHeadBinding.findViewById(2131367083), COLOR_WHITE);
        this.mFollowBackColor = j;
        if (!this.isPlayingAnim)
        {
          this.mHeadBinding.findViewById(2131367075).setBackgroundColor(COLOR_BLUE);
          this.mHeadBinding.findViewById(2131367076).setBackgroundDrawable(null);
        }
        else
        {
          setViewBgColor(this.mHeadBinding.findViewById(2131367076), COLOR_BLUE);
        }
        this.mHeadBinding.findViewById(2131368065).setBackgroundColor(Color.parseColor("#ffffff"));
        this.mHeadBinding.findViewById(2131368065).getBackground().setAlpha((int)(255.0F * f));
        this.mHeadBinding.findViewById(2131364721).setAlpha(1.0F - f);
        this.mHeadBinding.findViewById(2131364720).setAlpha(f);
        this.mBinding.findViewById(2131377927).setVisibility(8);
        if (localView.getVisibility() == 0) {
          localView.setVisibility(8);
        }
      }
      else
      {
        if (paramInt <= 10)
        {
          ((TextView)this.mHeadBinding.findViewById(2131371862)).setTextColor(Color.parseColor("#ffffff"));
          ((TextView)this.mHeadBinding.findViewById(2131366395)).setTextColor(Color.parseColor("#b3ffffff"));
          ((TextView)this.mHeadBinding.findViewById(2131367057)).setTextColor(COLOR_WHITE);
          ((TextView)this.mHeadBinding.findViewById(2131367077)).setTextColor(COLOR_WHITE);
          setViewBgColor(this.mHeadBinding.findViewById(2131367083), COLOR_WHITE);
          this.mFollowBackColor = -637534209;
          if (!this.isPlayingAnim)
          {
            this.mHeadBinding.findViewById(2131367075).setBackgroundColor(COLOR_BLUE);
            this.mHeadBinding.findViewById(2131367076).setBackgroundDrawable(null);
          }
          else
          {
            setViewBgColor(this.mHeadBinding.findViewById(2131367076), COLOR_BLUE);
          }
          this.mHeadBinding.findViewById(2131368065).setBackgroundResource(2130845713);
          this.mHeadBinding.findViewById(2131364721).setAlpha(1.0F);
          this.mHeadBinding.findViewById(2131364720).setAlpha(0.0F);
          if (localView.getVisibility() == 0) {
            localView.setVisibility(8);
          }
          localView = this.mBinding.findViewById(2131377927);
          if (this.isHasVideoLabel) {
            paramInt = 0;
          } else {
            paramInt = 8;
          }
          localView.setVisibility(paramInt);
          return;
        }
        if (paramInt >= 70)
        {
          ((TextView)this.mHeadBinding.findViewById(2131371862)).setTextColor(Color.parseColor("#000000"));
          ((TextView)this.mHeadBinding.findViewById(2131366395)).setTextColor(Color.parseColor("#bbbbbb"));
          ((TextView)this.mHeadBinding.findViewById(2131367057)).setTextColor(COLOR_WHITE);
          ((TextView)this.mHeadBinding.findViewById(2131367077)).setTextColor(COLOR_WHITE);
          setViewBgColor(this.mHeadBinding.findViewById(2131367083), COLOR_WHITE);
          this.mFollowBackColor = COLOR_BLUE;
          if (!this.isPlayingAnim)
          {
            this.mHeadBinding.findViewById(2131367075).setBackgroundColor(COLOR_BLUE);
            this.mHeadBinding.findViewById(2131367076).setBackgroundDrawable(null);
          }
          else
          {
            localObject = this.mHeadBinding.findViewById(2131367076).getBackground();
            if (localObject != null)
            {
              ((Drawable)localObject).setColorFilter(new LightingColorFilter(-16777216, COLOR_BLUE));
              ((Drawable)localObject).invalidateSelf();
            }
          }
          this.mHeadBinding.findViewById(2131368065).setBackgroundColor(-1);
          this.mHeadBinding.findViewById(2131364721).setAlpha(0.0F);
          this.mHeadBinding.findViewById(2131364720).setAlpha(1.0F);
          if (localView.getVisibility() == 8) {
            localView.setVisibility(0);
          }
        }
      }
    }
  }
  
  public void setVideoPageSource(int paramInt)
  {
    this.mVideoPageSource = paramInt;
  }
  
  public void setVideoSrc(String paramString)
  {
    this.videoSrc = paramString;
  }
  
  public void setWatchCount(int paramInt)
  {
    this.watchCount = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CommentsUtil.d(this.watchCount));
    localStringBuilder.append(HardCodeUtil.a(2131708243));
    setExtraInfo(localStringBuilder.toString());
  }
  
  public void setmBinding(View paramView)
  {
    this.mBinding = paramView;
  }
  
  public void setmHeadBinding(View paramView)
  {
    this.mHeadBinding = paramView;
  }
  
  public void showIfCan(boolean paramBoolean)
  {
    Object localObject = this.mVideoData;
    int i = 8;
    if ((localObject != null) && (((VideoData)localObject).jdField_b_of_type_Int != 1))
    {
      localObject = this.mBinding.findViewById(2131372194);
      if (paramBoolean) {
        i = 0;
      }
      ((View)localObject).setVisibility(i);
      return;
    }
    this.mBinding.findViewById(2131372194).setVisibility(8);
  }
  
  public void updateShowInfo(VideoData paramVideoData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateShowInfo:mVideoData=");
      localStringBuilder.append(this.mVideoData);
      QLog.i("PlayOperationViewModel", 2, localStringBuilder.toString());
    }
    this.feedsId = paramVideoData.jdField_a_of_type_JavaLangString;
    this.mVideoData = paramVideoData;
    if (paramVideoData.jdField_b_of_type_Int == 1)
    {
      showIfCan(false);
      return;
    }
    this.jumpUrl = paramVideoData.jdField_e_of_type_JavaLangString;
    this.currentAnchorNowId = paramVideoData.jdField_c_of_type_Long;
    this.currentAnchorNowUserType = paramVideoData.jdField_d_of_type_Int;
    if (paramVideoData.jdField_h_of_type_Long == paramVideoData.jdField_d_of_type_Long)
    {
      setHeadUrl(paramVideoData.i);
      setNickName(paramVideoData.jdField_h_of_type_JavaLangString);
      this.headerInfoUid = paramVideoData.jdField_d_of_type_Long;
      this.extraInfoUid = paramVideoData.jdField_a_of_type_Long;
    }
    else
    {
      setHeadUrl(paramVideoData.jdField_f_of_type_JavaLangString);
      setNickName(paramVideoData.jdField_g_of_type_JavaLangString);
      this.headerInfoUid = paramVideoData.jdField_a_of_type_Long;
      this.extraInfoUid = paramVideoData.jdField_d_of_type_Long;
    }
    setWatchCount(paramVideoData.jdField_e_of_type_Int);
    setAgeAndGender(paramVideoData.jdField_f_of_type_Int, paramVideoData.jdField_g_of_type_Int);
    boolean bool;
    if (paramVideoData.jdField_b_of_type_Int != 1)
    {
      if (paramVideoData.n == 1) {
        bool = true;
      } else {
        bool = false;
      }
      setIsMine(bool);
      setLiked(paramVideoData.jdField_b_of_type_Boolean);
      setLikes(paramVideoData.jdField_c_of_type_Int);
    }
    if (this.mVideoData.jdField_b_of_type_Int == 3) {
      bool = true;
    } else {
      bool = false;
    }
    setAggregation(bool);
    if (paramVideoData.jdField_b_of_type_Int == 1) {
      bool = true;
    } else {
      bool = false;
    }
    setRecord(bool);
    if (paramVideoData.jdField_b_of_type_Int == 4) {
      bool = true;
    } else {
      bool = false;
    }
    setLocal(bool);
    setFollow(paramVideoData.jdField_a_of_type_Boolean);
    setCanJump(TextUtils.isEmpty(paramVideoData.jdField_e_of_type_JavaLangString) ^ true);
    setFeedType(paramVideoData.k);
    reshowOperaView();
    if (this.mVideoData.k == 4) {
      bool = this.isFirstTime;
    }
    this.isFirstTime = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl
 * JD-Core Version:    0.7.0.1
 */