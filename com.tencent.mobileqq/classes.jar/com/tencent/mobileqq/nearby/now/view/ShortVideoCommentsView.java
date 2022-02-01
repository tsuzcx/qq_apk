package com.tencent.mobileqq.nearby.now.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.IModelUtil.IMediaInfoListener;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.model.MedalInfo;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.nearby.now.utils.IStoryRelayoutUtil;
import com.tencent.mobileqq.nearby.now.view.presenter.impl.CommentsPresenter;
import com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel;
import com.tencent.mobileqq.nearby.now.view.widget.HorizontalBallLoadingView;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import com.tencent.mobileqq.nearby.now.view.widget.TopicLabelListView;
import com.tencent.mobileqq.newnearby.INearbyReportHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.ProfileCardUtil.ReportBundleBuilder;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TopicHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class ShortVideoCommentsView
  extends LinearLayout
  implements View.OnLayoutChangeListener, CommentsView, IShortVideoCommentsView
{
  private static final int COMMENT_DELETE = 5;
  public static final int COMMENT_DELETE_ADMIN = 2;
  public static final int COMMENT_DELETE_ANCHOR = 4;
  public static final int COMMENT_DELETE_RECORDER = 3;
  public static final int COMMENT_DELETE_SELF = 1;
  private static int COMMENT_ITEM_HEIGHT = 0;
  private static final int COMMENT_TOP_OR_DELETE = 3;
  private static final int COMMENT_UNTOP_OR_DELETE = 4;
  private static final int JOIN_FANS_REQUEST_CODE = 301;
  private static final int MAX_INPUT_LENGTH = 140;
  private static final int OPEN_NOBEL_REQUEST_CODE = 300;
  private static final int REQUEST_FOR_BIND_PHONE = 302;
  private static final String TAG = "ShortVideoComments";
  public QQAppInterface app;
  private ShortVideoCommentsView.BottomAreaRunnable bottomAreaRunnable;
  private TextView btnPermissionDeniedJump;
  private TextView btnSend;
  private TextView commentCountTextView;
  private View commentCountView;
  private boolean commentVisibleReport = false;
  private View coverView;
  private View dividerView;
  private boolean downScrollReport = false;
  private EditText etInput;
  private ShortVideoCommentsView.FocusInputRunnable focusInputRunnable;
  private boolean hasPermission = false;
  private LinearLayout headerContainer;
  private boolean isEnd = false;
  private boolean isKeyboardShow = false;
  private boolean isLoading = false;
  private int lastScrollY = 0;
  private Map<Integer, Integer> listViewItemHeights = new HashMap();
  private LinearLayout llInut;
  private ListView lvComments;
  private CommentsAdapter mAdapter;
  public Comments mComments;
  public ImageView mEmptyCloseBtn;
  private FrameLayout mFooterView;
  private View mHeadInfoMask;
  private View mHeadOperater;
  private String mHintText = "";
  private HorizontalBallLoadingView mHorizontalBallLoadingView;
  private IModelUtil.IMediaInfoListener mIMediaInfoListener = new ShortVideoCommentsView.27(this);
  private boolean mIsDestroy = false;
  private int mKeyboardHeight;
  private TextView mLocationText;
  private MedalInfo mMedalInfo;
  private int mNameMaxWidth;
  private boolean mOpenMedalPage = false;
  private IPlayOperationViewModel mPlayOperationViewModel;
  private CommentsPresenter mPresenter;
  private Comments.Comment mReplyObject;
  private View mRootView;
  private long mSelfUin;
  private Paint mTextPaint;
  private VideoData mVideoData;
  private boolean needToOpenKeyboard;
  private String noPermissionJumpUrl;
  public View playerView;
  private TextView recoderEndTextView;
  private TextView recoderFromTextView;
  private View recoderInfoView;
  private TextView recoderNameTextView;
  private TextView recoderTimeTextView;
  private TextView recoderTitleTextView;
  private TopicLabelListView recoderTopicLabelListView;
  private View recorderTopDivider;
  private RelativeLayout rlInputBlock;
  private RelativeLayout rlNoPermission;
  private boolean scrollToTop = false;
  private TextView tvPermissionDeniedReason;
  private boolean userInput;
  private VideoPlayerPagerAdapter.VideoViewHolder videoViewHolder;
  private boolean waitForScrollToTop;
  
  public ShortVideoCommentsView(Context paramContext)
  {
    super(paramContext);
    COMMENT_ITEM_HEIGHT = (int)UITools.a(getContext(), 60.0F);
  }
  
  private void addCommentDirectly(Comments.Comment paramComment)
  {
    int i = 0;
    while (i < this.mComments.c.size())
    {
      if (((Comments.Comment)this.mComments.c.get(i)).d != 2)
      {
        this.mComments.c.add(i, paramComment);
        break;
      }
      i += 1;
    }
    if (!this.mComments.c.contains(paramComment)) {
      this.mComments.c.add(paramComment);
    }
    this.mAdapter.notifyDataSetChanged();
    paramComment = this.commentCountTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    Comments localComments = this.mComments;
    long l = localComments.a + 1L;
    localComments.a = l;
    localStringBuilder.append(String.valueOf(l));
    localStringBuilder.append(")");
    paramComment.setText(localStringBuilder.toString());
    paramComment = this.mPlayOperationViewModel;
    if (paramComment != null) {
      paramComment.setCommentsCount(this.mComments.a);
    }
    clearInput();
    if ((getContext() instanceof Activity))
    {
      paramComment = (Activity)getContext();
      UITools.b(getContext());
      postDelayed(new ShortVideoCommentsView.18(this), 100L);
    }
  }
  
  private void clearInput()
  {
    this.mReplyObject = null;
    this.etInput.setText("");
    this.etInput.clearFocus();
    if (!TextUtils.isEmpty(this.mHintText)) {
      this.etInput.setHint(this.mHintText);
    } else {
      this.etInput.setHint(getContext().getResources().getString(2131894146));
    }
    hideInputKeyboard();
  }
  
  private void deleteReport(int paramInt) {}
  
  private void deleteReportResult(int paramInt, boolean paramBoolean) {}
  
  private void ensureBottomAreaLineCorrent()
  {
    if (((this.mComments.c.isEmpty()) || (this.mAdapter.a)) && (this.rlNoPermission.getVisibility() == 0) && ((this.tvPermissionDeniedReason.getText() == null) || (this.tvPermissionDeniedReason.getText().length() == 0)))
    {
      this.dividerView.setVisibility(8);
      return;
    }
    this.dividerView.setVisibility(0);
  }
  
  private void ensureInputFocused()
  {
    if (this.focusInputRunnable != null) {
      ThreadManager.getUIHandler().post(this.focusInputRunnable);
    }
    this.focusInputRunnable = new ShortVideoCommentsView.FocusInputRunnable(this, System.currentTimeMillis());
    ThreadManager.getUIHandler().postDelayed(this.focusInputRunnable, 100L);
  }
  
  private int getDeleteType(Comments.Comment paramComment)
  {
    if (paramComment.f == this.app.getLongAccountUin()) {
      return 1;
    }
    if (this.app.getLongAccountUin() == this.mVideoData.i) {
      return 4;
    }
    if (this.app.getLongAccountUin() == this.mVideoData.u) {
      return 3;
    }
    return 2;
  }
  
  private int getVerticalScroll()
  {
    Object localObject = this.lvComments;
    int i = 0;
    if ((localObject != null) && (((ListView)localObject).getChildCount() > 0))
    {
      localObject = this.lvComments.getChildAt(0);
      int j = -((View)localObject).getTop();
      this.listViewItemHeights.put(Integer.valueOf(this.lvComments.getFirstVisiblePosition()), Integer.valueOf(((View)localObject).getHeight()));
      while (i < this.lvComments.getFirstVisiblePosition())
      {
        int k = j;
        if (this.listViewItemHeights.get(Integer.valueOf(i)) != null) {
          k = j + ((Integer)this.listViewItemHeights.get(Integer.valueOf(i))).intValue();
        }
        i += 1;
        j = k;
      }
      return j;
    }
    return 0;
  }
  
  private void handleDeleteFail(Comments.Comment paramComment)
  {
    if (this.mAdapter.a(paramComment)) {
      showToast(getResources().getString(2131894148));
    }
  }
  
  private void inputWidgetRegisterListener()
  {
    this.etInput.addTextChangedListener(new ShortVideoCommentsView.7(this));
    this.etInput.setOnTouchListener(new ShortVideoCommentsView.8(this));
    registerCommentsListViewListener();
    this.llInut.setOnClickListener(new ShortVideoCommentsView.9(this));
  }
  
  private void loadMore()
  {
    this.isLoading = true;
    this.mPresenter.b();
  }
  
  private void onCommentsDeleteClick(Comments.Comment paramComment)
  {
    this.mPresenter.b(paramComment);
  }
  
  private void onScrollToTop(boolean paramBoolean)
  {
    if (this.waitForScrollToTop) {
      return;
    }
    this.scrollToTop = paramBoolean;
    int i = getVerticalScroll();
    if (!this.commentVisibleReport)
    {
      localObject = this.headerContainer;
      if ((localObject != null) && (((LinearLayout)localObject).getMeasuredHeight() > 0) && ((getContext() instanceof Activity)))
      {
        localObject = (Activity)getContext();
        int j = UITools.b(getContext());
        if ((this.headerContainer.getMeasuredHeight() <= j - ViewUtils.getStatusBarHeight((Context)localObject)) || (this.headerContainer.getMeasuredHeight() - i <= j - ViewUtils.getStatusBarHeight((Context)localObject) - UITools.a(getContext(), 50.0F)))
        {
          this.commentVisibleReport = true;
          ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_com_exp").LvInd1().reportByVideo(this.app);
          ThreadManagerV2.excute(new ShortVideoCommentsView.28(this, (INearbyCardManager)this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
        }
      }
    }
    Object localObject = this.mPlayOperationViewModel;
    if (localObject != null) {
      ((IPlayOperationViewModel)localObject).setTopOperationBkg(i);
    }
  }
  
  private String parseTopicTitle(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.indexOf("#");
    if (i == -1) {
      return paramString;
    }
    paramString = paramString.split("#");
    if (i > 0) {
      return paramString[0];
    }
    return "";
  }
  
  private void postBottomAreaRunnable(int paramInt)
  {
    if (this.bottomAreaRunnable != null) {
      ThreadManager.getUIHandler().post(this.bottomAreaRunnable);
    }
    this.bottomAreaRunnable = new ShortVideoCommentsView.BottomAreaRunnable(this, paramInt);
    ThreadManager.getUIHandler().post(this.bottomAreaRunnable);
  }
  
  private void registerCommentsListViewListener()
  {
    this.lvComments.setOnScrollListener(new ShortVideoCommentsView.10(this));
    this.lvComments.setOnItemClickListener(new ShortVideoCommentsView.11(this));
    this.lvComments.setLongClickable(true);
    this.lvComments.setOnItemLongClickListener(new ShortVideoCommentsView.12(this));
  }
  
  private void removeFailedComment(Comments.Comment paramComment)
  {
    this.mComments.c.remove(paramComment);
    this.mAdapter.notifyDataSetChanged();
    paramComment = this.commentCountTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    Comments localComments = this.mComments;
    long l = localComments.a - 1L;
    localComments.a = l;
    localStringBuilder.append(String.valueOf(l));
    localStringBuilder.append(")");
    paramComment.setText(localStringBuilder.toString());
    paramComment = this.mPlayOperationViewModel;
    if (paramComment != null) {
      paramComment.setCommentsCount(this.mComments.a);
    }
  }
  
  private void showDeleteConfirmDialog(Comments.Comment paramComment)
  {
    String str = getResources().getString(2131894147);
    DialogUtil.a(getContext(), 232, null, str, new ShortVideoCommentsView.31(this, paramComment), new ShortVideoCommentsView.32(this)).show();
  }
  
  public void addCommentInView(Comments.Comment paramComment)
  {
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_com_suc").LvInd1().reportByVideo(this.app);
    ThreadManagerV2.excute(new ShortVideoCommentsView.19(this, (INearbyCardManager)this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
  }
  
  public void addLoadingErrorView(Object paramObject) {}
  
  public boolean canPlayNext()
  {
    return (this.scrollToTop) && (this.rlInputBlock.getVisibility() != 0) && (this.rlNoPermission.getVisibility() != 0) && (!this.mPlayOperationViewModel.isDialogShow()) && (!this.mPlayOperationViewModel.isJubaoDialogShow());
  }
  
  public AppInterface getApp()
  {
    return this.app;
  }
  
  public View getPlayerView()
  {
    return this.playerView;
  }
  
  public Comments getmComments()
  {
    return this.mComments;
  }
  
  public ImageView getmEmptyCloseBtn()
  {
    return this.mEmptyCloseBtn;
  }
  
  public void hideInputKeyboard()
  {
    if (this.etInput == null) {
      return;
    }
    if ((this.isKeyboardShow) && (getContext() != null))
    {
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.etInput.getWindowToken(), 0);
      this.isKeyboardShow = false;
    }
    this.userInput = false;
    this.etInput.clearFocus();
    this.coverView.setVisibility(8);
    if (this.focusInputRunnable != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.focusInputRunnable);
    }
  }
  
  public void hideLoading()
  {
    if (this.mPresenter.d() > 0)
    {
      HorizontalBallLoadingView localHorizontalBallLoadingView = this.mHorizontalBallLoadingView;
      if (localHorizontalBallLoadingView != null) {
        localHorizontalBallLoadingView.setVisibility(8);
      }
    }
    this.isLoading = false;
  }
  
  public void init(Object paramObject, VideoData paramVideoData)
  {
    this.videoViewHolder = ((VideoPlayerPagerAdapter.VideoViewHolder)paramObject);
    this.mVideoData = paramVideoData;
    this.needToOpenKeyboard = false;
    onCreate();
    onCreateView();
    onActivityCreated(null, 0);
    initRecorderInfoView();
    initLocationView();
  }
  
  public void initLocationView()
  {
    if (this.mVideoData.J == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoComments", 2, "initLocationView: lbsInfo null!");
      }
      this.mLocationText.setVisibility(8);
      return;
    }
    LocationInfo localLocationInfo = this.mVideoData.J;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initLocationView:");
      ((StringBuilder)localObject).append(localLocationInfo.toString());
      QLog.i("ShortVideoComments", 2, ((StringBuilder)localObject).toString());
    }
    if ((localLocationInfo.isCityEmpty()) && (localLocationInfo.isNameEmpty())) {
      return;
    }
    this.mLocationText.setVisibility(0);
    String str = localLocationInfo.getName();
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = localLocationInfo.getCity();
    }
    this.mLocationText.setText((CharSequence)localObject);
    if ((!TextUtils.isEmpty(localLocationInfo.getName())) && (!localLocationInfo.name.endsWith(HardCodeUtil.a(2131911492))))
    {
      if (this.mVideoData.b != VideoData.a)
      {
        this.mLocationText.setCompoundDrawablesWithIntrinsicBounds(2130847093, 0, 0, 0);
        this.mLocationText.setTextColor(Color.parseColor("#576B95"));
      }
      this.mLocationText.setEnabled(true);
      this.mLocationText.setOnClickListener(new ShortVideoCommentsView.1(this, localLocationInfo));
      return;
    }
    if (this.mVideoData.b != VideoData.a)
    {
      this.mLocationText.setCompoundDrawablesWithIntrinsicBounds(2130847161, 0, 0, 0);
      this.mLocationText.setTextColor(Color.parseColor("#777777"));
    }
    this.mLocationText.setOnClickListener(null);
  }
  
  public void initRecorderInfoView()
  {
    Object localObject1 = this.mVideoData;
    if ((localObject1 != null) && (!((VideoData)localObject1).a()))
    {
      String str = this.mVideoData.A;
      Object localObject2 = "";
      localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = localObject2;
        if (!this.mVideoData.A.isEmpty()) {
          localObject1 = this.mVideoData.A.replace("\n", "").replace("\r", "").trim();
        }
      }
      localObject1 = parseTopicTitle((String)localObject1);
      localObject1 = TopicHelper.b(getContext(), this.mVideoData.N, (String)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoComments", 2, "topicTitle is null or the length is 0");
        }
        this.recoderTitleTextView.setVisibility(8);
        this.recoderTopicLabelListView.setVisibility(8);
        this.recorderTopDivider.setVisibility(8);
      }
      else
      {
        this.recoderTopicLabelListView.setVisibility(8);
        this.recoderTitleTextView.setVisibility(0);
        if ((localObject1 instanceof SpannableString)) {
          this.recoderTitleTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.recoderTitleTextView.setText((CharSequence)localObject1);
      }
      if (this.mVideoData.i == this.mVideoData.u)
      {
        this.recoderFromTextView.setVisibility(8);
        this.recoderEndTextView.setVisibility(8);
        this.recoderNameTextView.setVisibility(8);
      }
      else if ((this.mVideoData.C == this.mVideoData.u) && (this.mVideoData.G != 4))
      {
        this.recoderFromTextView.setText(HardCodeUtil.a(2131911454));
        this.recoderEndTextView.setText(HardCodeUtil.a(2131911447));
        this.recoderEndTextView.setVisibility(0);
        localObject2 = this.mVideoData.s;
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > 6)
          {
            localObject1 = ((String)localObject2).substring(0, 6);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("...");
            localObject1 = ((StringBuilder)localObject2).toString();
          }
        }
        this.recoderNameTextView.setText((CharSequence)localObject1);
      }
      else
      {
        this.recoderFromTextView.setText(HardCodeUtil.a(2131911482));
        this.recoderEndTextView.setVisibility(8);
        localObject2 = this.mVideoData.t;
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > 6)
          {
            localObject1 = ((String)localObject2).substring(0, 6);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("...");
            localObject1 = ((StringBuilder)localObject2).toString();
          }
        }
        this.recoderNameTextView.setText((CharSequence)localObject1);
      }
      this.recoderNameTextView.setOnTouchListener(new ShortVideoCommentsView.17(this));
      long l = NetConnInfoCenter.getServerTimeMillis() - this.mVideoData.y * 1000L;
      if (l < 0L)
      {
        localObject1 = "1分钟前";
      }
      else if (l < 3600000L)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(l / 60L / 1000L + 1L);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131911456));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else if (l < 86400000L)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(l / 60L / 60L / 1000L);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131911503));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else if (l < 31536000000L)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(l / 24L / 60L / 60L / 1000L);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131911463));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(l / 365L / 24L / 60L / 60L / 1000L);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131911449));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      this.recoderTimeTextView.setText((CharSequence)localObject1);
      this.recoderInfoView.setVisibility(0);
      return;
    }
    this.recoderInfoView.setVisibility(8);
  }
  
  public boolean isScrollTop()
  {
    return this.scrollToTop;
  }
  
  public void jump2Report(Comments.Comment paramComment)
  {
    Object localObject = getContext();
    if ((paramComment.f > 0L) && ((localObject instanceof BaseActivity)))
    {
      Bundle localBundle = new ProfileCardUtil.ReportBundleBuilder().a(paramComment.b).a();
      localObject = (BaseActivity)localObject;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramComment.f);
      localStringBuilder.append("");
      ProfileCardUtil.a((BaseActivity)localObject, 0L, localStringBuilder.toString(), null, 20006, "", localBundle);
      return;
    }
    QQToast.makeText((Context)localObject, 2, HardCodeUtil.a(2131911439), 0).show();
  }
  
  public void onActivityCreated(Comments paramComments, int paramInt)
  {
    if (this.mVideoData.b != 4) {
      this.mPresenter.a();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 != 300) && (paramInt1 != 301))
    {
      if ((paramInt1 == 302) && (QLog.isColorLevel()))
      {
        paramIntent = new StringBuilder();
        paramIntent.append("shortVideoComments onActivityResult, requestCode=");
        paramIntent.append(paramInt1);
        paramIntent.append(", resultCode=");
        paramIntent.append(paramInt2);
        QLog.d("nearby.bindphone", 2, paramIntent.toString());
      }
    }
    else {
      onPermissionGranted("", "");
    }
  }
  
  public void onCreate()
  {
    this.mComments = new Comments();
    this.mComments.c = new ArrayList();
    this.mPresenter = new CommentsPresenter(this, this.mVideoData, this.app);
    this.mSelfUin = this.app.getLongAccountUin();
    this.mNameMaxWidth = ((int)(UITools.a(getContext()) - UITools.a(getContext(), 85.0F)));
    this.mTextPaint = new Paint();
    this.mTextPaint.setTextSize(UITools.a(getContext(), 12.0F));
  }
  
  public View onCreateView()
  {
    this.mRootView = LayoutInflater.from(getContext()).inflate(2131627562, this, true);
    this.mKeyboardHeight = (UITools.b(getContext()) / 3);
    this.mRootView.setOnClickListener(new ShortVideoCommentsView.2(this));
    this.lvComments = ((ListView)this.mRootView.findViewById(2131437774));
    Object localObject = this.mVideoData;
    if ((localObject == null) || (((VideoData)localObject).b == 1) || (this.mVideoData.a())) {
      this.lvComments.setOnTouchListener(new ShortVideoCommentsView.3(this));
    }
    this.mAdapter = new CommentsAdapter(getContext(), this.mComments, this.mVideoData, this.mPresenter, this.mTextPaint, this.mNameMaxWidth);
    this.playerView = LayoutInflater.from(getContext()).inflate(2131627561, this, false);
    localObject = this.videoViewHolder;
    View localView = this.playerView;
    ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).b = ((ViewGroup)localView);
    ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).c = ((RelativeLayout)localView.findViewById(2131440394));
    this.videoViewHolder.e = ((ImageDisplayView)this.playerView.findViewById(2131435464));
    this.videoViewHolder.d = ((OperationView)this.playerView.findViewById(2131439676));
    this.videoViewHolder.d.c = this.app;
    this.videoViewHolder.d.a();
    this.videoViewHolder.f = ((QQStoryVideoPlayerErrorView)this.playerView.findViewById(2131439731));
    localObject = (FrameLayout.LayoutParams)this.videoViewHolder.f.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).height = UITools.b(this.videoViewHolder.f.getContext());
    ((FrameLayout.LayoutParams)localObject).width = UITools.a(this.videoViewHolder.f.getContext());
    this.videoViewHolder.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.videoViewHolder.f.requestLayout();
    this.videoViewHolder.f.setOnClickListener(new ShortVideoCommentsView.4(this));
    if (this.mVideoData.G == VideoData.a)
    {
      this.videoViewHolder.c.setVisibility(8);
      this.videoViewHolder.e.setVisibility(8);
    }
    else if (this.mVideoData.G == 4)
    {
      this.videoViewHolder.e.setVisibility(0);
      this.videoViewHolder.c.setVisibility(8);
    }
    else
    {
      this.videoViewHolder.c.setVisibility(0);
      this.videoViewHolder.e.setVisibility(8);
    }
    this.videoViewHolder.f.setVisibility(8);
    this.mPlayOperationViewModel = this.videoViewHolder.d.getPlayOperationViewModel();
    this.recoderInfoView = LayoutInflater.from(getContext()).inflate(2131627563, this, false);
    this.recorderTopDivider = this.recoderInfoView.findViewById(2131444505);
    this.recoderTitleTextView = ((TextView)this.recoderInfoView.findViewById(2131448814));
    this.recoderTopicLabelListView = ((TopicLabelListView)this.recoderInfoView.findViewById(2131448827));
    this.recoderTimeTextView = ((TextView)this.recoderInfoView.findViewById(2131448805));
    this.recoderFromTextView = ((TextView)this.recoderInfoView.findViewById(2131448477));
    this.recoderNameTextView = ((TextView)this.recoderInfoView.findViewById(2131448598));
    this.recoderEndTextView = ((TextView)this.recoderInfoView.findViewById(2131448428));
    if (this.mVideoData.G == VideoData.a) {
      this.mLocationText = ((TextView)this.recoderInfoView.findViewById(2131448379));
    } else {
      this.mLocationText = ((TextView)this.recoderInfoView.findViewById(2131448378));
    }
    this.recoderInfoView.setVisibility(0);
    this.commentCountView = LayoutInflater.from(getContext()).inflate(2131627553, this, false);
    this.commentCountTextView = ((TextView)this.commentCountView.findViewById(2131448344));
    this.headerContainer = new LinearLayout(getContext());
    this.headerContainer.setBackgroundColor(Color.parseColor("#00000000"));
    int i = ViewUtils.getStatusBarHeight((Activity)this.videoViewHolder.e.getContext());
    float f1 = UITools.b(this.videoViewHolder.e.getContext()) - i;
    float f2 = UITools.a(this.videoViewHolder.e.getContext());
    if (this.mVideoData.b == 4)
    {
      this.headerContainer.setBackgroundColor(Color.parseColor("#000000"));
      localObject = new AbsListView.LayoutParams(-1, -1);
      ((AbsListView.LayoutParams)localObject).width = ((int)f2);
      ((AbsListView.LayoutParams)localObject).height = ((int)f1);
      this.headerContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.headerContainer.requestLayout();
    }
    this.recoderInfoView.setBackgroundColor(Color.parseColor("#ffffff"));
    this.commentCountView.setBackgroundColor(Color.parseColor("#ffffff"));
    this.headerContainer.setOrientation(1);
    if (this.mVideoData.b != 1)
    {
      if (this.mVideoData.b == VideoData.a) {
        localObject = LayoutInflater.from(getContext()).inflate(2131627558, this.headerContainer, true);
      } else {
        localObject = LayoutInflater.from(getContext()).inflate(2131627558, (ViewGroup)this.mRootView.findViewById(2131437908), true);
      }
      this.mPlayOperationViewModel.setHeadBinding((View)localObject);
      this.videoViewHolder.g = ((View)localObject);
      if (this.mVideoData.b == VideoData.a)
      {
        this.mPlayOperationViewModel.setHeadInfoMaskWhiteMode();
        this.recoderInfoView.findViewById(2131444504).setVisibility(8);
      }
    }
    if (this.mVideoData.b == VideoData.a)
    {
      this.headerContainer.addView(this.recoderInfoView);
      this.headerContainer.addView(this.playerView, (int)f2, -2);
      this.headerContainer.addView(this.commentCountView);
      this.commentCountView.findViewById(2131447724).setVisibility(0);
    }
    else
    {
      this.headerContainer.addView(this.playerView, (int)f2, -2);
      this.headerContainer.addView(this.recoderInfoView);
      this.headerContainer.addView(this.commentCountView);
    }
    this.lvComments.addHeaderView(this.headerContainer);
    this.lvComments.setAdapter(this.mAdapter);
    if (this.mVideoData.b == 4)
    {
      showEmptyCloseBtn();
      this.lvComments.setOnTouchListener(new ShortVideoCommentsView.5(this));
    }
    else
    {
      ((IStoryRelayoutUtil)QRoute.api(IStoryRelayoutUtil.class)).dynamicChangeStoryContainerView(this.videoViewHolder, this.mVideoData.I, this.mVideoData.H);
      this.mFooterView = ((FrameLayout)LayoutInflater.from(getContext()).inflate(2131627548, null, false));
      localObject = new AbsListView.LayoutParams(-1, (int)UITools.a(getContext(), 50.0F));
      this.mFooterView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mHorizontalBallLoadingView = ((HorizontalBallLoadingView)this.mFooterView.findViewById(2131442450));
      this.lvComments.addFooterView(this.mFooterView);
    }
    if (this.mVideoData.a())
    {
      this.recoderInfoView.setVisibility(8);
      this.commentCountView.setVisibility(8);
    }
    this.coverView = this.mRootView.findViewById(2131449813);
    this.coverView.setOnClickListener(new ShortVideoCommentsView.6(this));
    this.btnSend = ((TextView)this.mRootView.findViewById(2131430013));
    this.llInut = ((LinearLayout)this.mRootView.findViewById(2131437547));
    this.etInput = ((EditText)this.mRootView.findViewById(2131432614));
    inputWidgetRegisterListener();
    this.rlNoPermission = ((RelativeLayout)this.mRootView.findViewById(2131444988));
    this.tvPermissionDeniedReason = ((TextView)this.mRootView.findViewById(2131436832));
    this.btnPermissionDeniedJump = ((TextView)this.mRootView.findViewById(2131429945));
    this.rlInputBlock = ((RelativeLayout)this.mRootView.findViewById(2131444921));
    hideInputKeyboard();
    this.dividerView = this.mRootView.findViewById(2131449815);
    ((INearbyReportHelper)QRoute.api(INearbyReportHelper.class)).reportTrendDetailExp(this.app, String.valueOf(this.mVideoData.i));
    return this.mRootView;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    hideInputKeyboard();
    this.mPresenter.c();
    this.mIsDestroy = true;
    CommentsAdapter localCommentsAdapter = this.mAdapter;
    if (localCommentsAdapter != null) {
      localCommentsAdapter.a(this.mIsDestroy);
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt8 != 0) && (paramInt4 != 0))
    {
      paramInt1 = this.mKeyboardHeight;
      if (paramInt8 - paramInt4 > paramInt1) {
        ThreadManager.getUIHandler().post(new ShortVideoCommentsView.29(this));
      } else if (paramInt4 - paramInt8 > paramInt1) {
        ThreadManager.getUIHandler().post(new ShortVideoCommentsView.30(this));
      }
    }
    if (this.lastScrollY == 0) {
      this.lastScrollY = getVerticalScroll();
    }
  }
  
  public void onPause()
  {
    hideInputKeyboard();
    this.mRootView.removeOnLayoutChangeListener(this);
  }
  
  public void onPermissionDenied(int paramInt1, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPermissionDenied() called with: code = [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], uin = [");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], text = [");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], btnText = [");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("], bindPhoneUrl = [");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("], noCredit = [");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("]");
      QLog.w("ShortVideoComments", 2, localStringBuilder.toString());
    }
  }
  
  public void onPermissionGranted(String paramString1, String paramString2)
  {
    if ((this.rlNoPermission.getVisibility() == 0) || (this.rlInputBlock.getVisibility() == 0)) {
      postBottomAreaRunnable(0);
    }
    this.hasPermission = true;
    if (!TextUtils.isEmpty(paramString1))
    {
      EditText localEditText = this.etInput;
      if (localEditText != null)
      {
        localEditText.setHint(paramString1);
        this.mHintText = paramString1;
        break label109;
      }
    }
    if (this.etInput != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoComments", 2, "onPermissionGranted text ie empty! etinput use defualt hint ");
      }
      this.mHintText = getContext().getResources().getString(2131894146);
      this.etInput.setHint(this.mHintText);
    }
    label109:
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = this.btnSend;
      if (paramString1 != null)
      {
        paramString1.setText(paramString2);
        break label175;
      }
    }
    if (this.btnSend != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoComments", 2, "onPermissionGranted btnText ie empty! btnSend use defualt text ");
      }
      this.btnSend.setText(getContext().getResources().getString(2131894154));
    }
    label175:
    if (this.needToOpenKeyboard) {
      showInputKeyboard();
    }
  }
  
  public void onResume()
  {
    this.mRootView.addOnLayoutChangeListener(this);
    if (this.mVideoData.b != 4) {
      onPermissionGranted("", "");
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (paramInt == 0)
    {
      onResume();
      return;
    }
    onPause();
  }
  
  public void publishCommentFailed(Comments.Comment paramComment, int paramInt, String paramString)
  {
    if (paramComment != null)
    {
      if (paramInt == 10003) {
        showToast(getContext().getResources().getString(2131894153));
      } else if (paramInt == 10009) {
        showBindPhone(paramString);
      } else {
        showToast(getContext().getResources().getString(2131894155));
      }
      this.etInput.requestFocus();
      removeFailedComment(paramComment);
      ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_com_fail").LvInd1().reportByVideo(this.app);
    }
  }
  
  public void removeCommentDirectly(Comments.Comment paramComment)
  {
    if (this.mComments.c.contains(paramComment))
    {
      this.mComments.c.remove(paramComment);
      this.mAdapter.notifyDataSetChanged();
      paramComment = this.mComments;
      paramComment.a -= 1L;
      paramComment = this.commentCountTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(String.valueOf(this.mComments.a));
      localStringBuilder.append(")");
      paramComment.setText(localStringBuilder.toString());
      paramComment = this.mPlayOperationViewModel;
      if (paramComment != null) {
        paramComment.setCommentsCount(this.mComments.a);
      }
    }
  }
  
  /* Error */
  public void reportBindPhoneAction(AppInterface paramAppInterface, String paramString)
  {
    // Byte code:
    //   0: ldc 160
    //   2: astore 7
    //   4: aload_0
    //   5: getfield 186	com/tencent/mobileqq/nearby/now/view/ShortVideoCommentsView:mVideoData	Lcom/tencent/mobileqq/nearby/now/model/VideoData;
    //   8: ifnull +216 -> 224
    //   11: new 342	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   18: astore 4
    //   20: aload 4
    //   22: aload_0
    //   23: getfield 186	com/tencent/mobileqq/nearby/now/view/ShortVideoCommentsView:mVideoData	Lcom/tencent/mobileqq/nearby/now/model/VideoData;
    //   26: getfield 1333	com/tencent/mobileqq/nearby/now/model/VideoData:r	I
    //   29: invokevirtual 1015	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 4
    //   35: ldc 160
    //   37: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 4
    //   43: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: astore 4
    //   48: new 342	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   55: astore 5
    //   57: aload 5
    //   59: aload_0
    //   60: getfield 186	com/tencent/mobileqq/nearby/now/view/ShortVideoCommentsView:mVideoData	Lcom/tencent/mobileqq/nearby/now/model/VideoData;
    //   63: getfield 1336	com/tencent/mobileqq/nearby/now/model/VideoData:q	I
    //   66: invokevirtual 1015	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 5
    //   72: ldc 160
    //   74: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 5
    //   80: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore 5
    //   85: new 342	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   92: astore 6
    //   94: aload 6
    //   96: aload_0
    //   97: getfield 186	com/tencent/mobileqq/nearby/now/view/ShortVideoCommentsView:mVideoData	Lcom/tencent/mobileqq/nearby/now/model/VideoData;
    //   100: getfield 497	com/tencent/mobileqq/nearby/now/model/VideoData:i	J
    //   103: invokevirtual 960	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 6
    //   109: ldc 160
    //   111: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 6
    //   117: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: astore 6
    //   122: invokestatic 1342	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   125: astore 7
    //   127: new 342	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   134: astore 8
    //   136: aload 8
    //   138: ldc_w 1344
    //   141: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 8
    //   147: aload_1
    //   148: invokevirtual 1349	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   151: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 7
    //   157: aload 8
    //   159: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: iconst_4
    //   163: invokevirtual 1353	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   166: ldc_w 1355
    //   169: iconst_0
    //   170: invokeinterface 1361 3 0
    //   175: istore_3
    //   176: iload_3
    //   177: invokestatic 1363	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   180: astore 8
    //   182: aload 6
    //   184: astore 7
    //   186: goto +50 -> 236
    //   189: astore 8
    //   191: ldc 160
    //   193: astore_1
    //   194: aload 6
    //   196: astore 7
    //   198: aload 8
    //   200: astore 6
    //   202: goto +98 -> 300
    //   205: astore 6
    //   207: ldc 160
    //   209: astore_1
    //   210: goto +90 -> 300
    //   213: astore 6
    //   215: ldc 160
    //   217: astore_1
    //   218: aload_1
    //   219: astore 5
    //   221: goto +79 -> 300
    //   224: ldc 160
    //   226: astore 8
    //   228: aload 8
    //   230: astore 4
    //   232: aload 4
    //   234: astore 5
    //   236: aload_1
    //   237: checkcast 489	com/tencent/mobileqq/app/QQAppInterface
    //   240: ldc_w 1365
    //   243: ldc_w 1367
    //   246: aload 7
    //   248: ldc_w 599
    //   251: aload_2
    //   252: iconst_0
    //   253: iconst_0
    //   254: aload 8
    //   256: aload 4
    //   258: aload 5
    //   260: ldc 160
    //   262: invokestatic 1372	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   265: aload 7
    //   267: astore 9
    //   269: aload 4
    //   271: astore 10
    //   273: aload 5
    //   275: astore 11
    //   277: goto +100 -> 377
    //   280: astore 6
    //   282: aload 8
    //   284: astore_1
    //   285: goto +15 -> 300
    //   288: astore 6
    //   290: ldc 160
    //   292: astore_1
    //   293: aload_1
    //   294: astore 4
    //   296: aload 4
    //   298: astore 5
    //   300: aload 7
    //   302: astore 9
    //   304: aload_1
    //   305: astore 8
    //   307: aload 4
    //   309: astore 10
    //   311: aload 5
    //   313: astore 11
    //   315: invokestatic 792	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   318: ifeq +59 -> 377
    //   321: new 342	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   328: astore 8
    //   330: aload 8
    //   332: ldc_w 1374
    //   335: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload 8
    //   341: aload 6
    //   343: invokevirtual 1375	java/lang/Exception:toString	()Ljava/lang/String;
    //   346: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: ldc_w 1019
    //   353: iconst_2
    //   354: aload 8
    //   356: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 1377	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: aload 5
    //   364: astore 11
    //   366: aload 4
    //   368: astore 10
    //   370: aload_1
    //   371: astore 8
    //   373: aload 7
    //   375: astore 9
    //   377: invokestatic 792	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   380: ifeq +96 -> 476
    //   383: new 342	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   390: astore_1
    //   391: aload_1
    //   392: ldc_w 1379
    //   395: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload_1
    //   400: aload_2
    //   401: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload_1
    //   406: ldc_w 1381
    //   409: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload_1
    //   414: aload 9
    //   416: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload_1
    //   421: ldc_w 1383
    //   424: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload_1
    //   429: aload 10
    //   431: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload_1
    //   436: ldc_w 1385
    //   439: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload_1
    //   444: aload 11
    //   446: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload_1
    //   451: ldc_w 1387
    //   454: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload_1
    //   459: aload 8
    //   461: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: ldc_w 1019
    //   468: iconst_2
    //   469: aload_1
    //   470: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 1021	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	477	0	this	ShortVideoCommentsView
    //   0	477	1	paramAppInterface	AppInterface
    //   0	477	2	paramString	String
    //   175	2	3	i	int
    //   18	349	4	localObject1	Object
    //   55	308	5	localObject2	Object
    //   92	109	6	localObject3	Object
    //   205	1	6	localException1	java.lang.Exception
    //   213	1	6	localException2	java.lang.Exception
    //   280	1	6	localException3	java.lang.Exception
    //   288	54	6	localException4	java.lang.Exception
    //   2	372	7	localObject4	Object
    //   134	47	8	localObject5	Object
    //   189	10	8	localException5	java.lang.Exception
    //   226	234	8	localObject6	Object
    //   267	148	9	localObject7	Object
    //   271	159	10	localObject8	Object
    //   275	170	11	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   122	176	189	java/lang/Exception
    //   85	122	205	java/lang/Exception
    //   48	85	213	java/lang/Exception
    //   236	265	280	java/lang/Exception
    //   4	48	288	java/lang/Exception
  }
  
  public void scrollToComment()
  {
    if (this.hasPermission)
    {
      this.rlNoPermission.setVisibility(8);
      this.rlInputBlock.setVisibility(0);
    }
    else
    {
      this.rlInputBlock.setVisibility(8);
      VideoData localVideoData = this.mVideoData;
      if ((localVideoData != null) && (localVideoData.b != 4)) {
        this.rlNoPermission.setVisibility(0);
      }
      ensureBottomAreaLineCorrent();
    }
    postDelayed(new ShortVideoCommentsView.25(this), 100L);
    postDelayed(new ShortVideoCommentsView.26(this), 200L);
  }
  
  public void scrollToTop()
  {
    hideInputKeyboard();
    this.coverView.setVisibility(8);
    this.rlInputBlock.setVisibility(8);
    this.rlNoPermission.setVisibility(8);
    this.lvComments.setSelection(0);
    this.lastScrollY = 0;
    ThreadManager.getUIHandler().postDelayed(new ShortVideoCommentsView.22(this), 10L);
  }
  
  public void setApp(AppInterface paramAppInterface)
  {
    this.app = ((QQAppInterface)paramAppInterface);
  }
  
  public void setPlayerView(View paramView)
  {
    this.playerView = paramView;
  }
  
  public void setVideoData(VideoData paramVideoData)
  {
    this.mVideoData = paramVideoData;
  }
  
  public void setmComments(Comments paramComments)
  {
    this.mComments = paramComments;
  }
  
  public void setmEmptyCloseBtn(ImageView paramImageView)
  {
    this.mEmptyCloseBtn = paramImageView;
  }
  
  public void showBadNetworkConnection()
  {
    this.mAdapter.a = true;
  }
  
  public void showBindPhone(String paramString)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shortVideoComments showBindPhone, tip=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", activity=");
      localStringBuilder.append(localBaseActivity);
      QLog.d("nearby.bindphone", 2, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (localBaseActivity != null))
    {
      DialogUtil.a(localBaseActivity, paramString, 2131887648, 2131897030, new ShortVideoCommentsView.20(this, localBaseActivity), new ShortVideoCommentsView.21(this)).show();
      reportBindPhoneAction(this.app, "playpage_phone_exp");
    }
  }
  
  public void showBottomeArea()
  {
    if (this.hasPermission)
    {
      postBottomAreaRunnable(0);
      return;
    }
    postBottomAreaRunnable(1);
  }
  
  public void showComment()
  {
    if (this.hasPermission)
    {
      this.userInput = true;
      this.rlNoPermission.setVisibility(8);
      this.rlInputBlock.setVisibility(0);
      showInputKeyboard();
      ensureInputFocused();
      return;
    }
    this.rlInputBlock.setVisibility(8);
    this.rlNoPermission.setVisibility(0);
    ensureBottomAreaLineCorrent();
    postDelayed(new ShortVideoCommentsView.23(this), 100L);
    postDelayed(new ShortVideoCommentsView.24(this), 200L);
  }
  
  public void showDataInView(Comments paramComments)
  {
    this.mAdapter.a = false;
    if ((paramComments.a != 0L) || (!paramComments.b)) {
      this.mComments.a = paramComments.a;
    }
    this.mComments.b = paramComments.b;
    if ((paramComments.c != null) && (paramComments.c.size() > 0))
    {
      this.mComments.c.addAll(paramComments.c);
      this.mAdapter.notifyDataSetChanged();
    }
    this.isEnd = paramComments.b;
    this.isLoading = false;
    paramComments = this.commentCountTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append(String.valueOf(this.mComments.a));
    localStringBuilder.append(")");
    paramComments.setText(localStringBuilder.toString());
    paramComments = this.mPlayOperationViewModel;
    if (paramComments != null) {
      paramComments.setCommentsCount(this.mComments.a);
    }
  }
  
  public void showDelAndReportSheet(Comments.Comment paramComment)
  {
    ActionSheet localActionSheet = ActionSheet.create(getContext());
    localActionSheet.addButton(HardCodeUtil.a(2131911461), 1);
    localActionSheet.addButton(HardCodeUtil.a(2131911464), 1);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new ShortVideoCommentsView.15(this, paramComment, localActionSheet));
    localActionSheet.show();
  }
  
  public void showDelSheet(Comments.Comment paramComment)
  {
    ActionSheet localActionSheet = ActionSheet.create(getContext());
    localActionSheet.addButton(HardCodeUtil.a(2131911474), 1);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new ShortVideoCommentsView.13(this, paramComment, localActionSheet));
    localActionSheet.show();
  }
  
  public void showEmptyCloseBtn()
  {
    this.mEmptyCloseBtn = ((ImageView)this.mRootView.findViewById(2131432499));
    this.mEmptyCloseBtn.setOnClickListener(new ShortVideoCommentsView.16(this));
    this.mEmptyCloseBtn.setVisibility(0);
  }
  
  public void showInputKeyboard()
  {
    Object localObject = this.etInput;
    if (localObject == null) {
      return;
    }
    ((EditText)localObject).requestFocus();
    if ((!this.isKeyboardShow) && (getContext() != null))
    {
      localObject = (InputMethodManager)getContext().getSystemService("input_method");
      this.etInput.getWindowToken();
      ((InputMethodManager)localObject).showSoftInput(this.etInput, 0);
      this.isKeyboardShow = true;
    }
    this.coverView.setVisibility(0);
  }
  
  public void showLoading()
  {
    if (this.mPresenter.d() > 0)
    {
      HorizontalBallLoadingView localHorizontalBallLoadingView = this.mHorizontalBallLoadingView;
      if (localHorizontalBallLoadingView != null) {
        localHorizontalBallLoadingView.setVisibility(0);
      }
    }
  }
  
  public void showReportSheet(Comments.Comment paramComment)
  {
    ActionSheet localActionSheet = ActionSheet.create(getContext());
    localActionSheet.addButton(HardCodeUtil.a(2131911478), 1);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new ShortVideoCommentsView.14(this, paramComment, localActionSheet));
    localActionSheet.show();
  }
  
  public void showToast(String paramString)
  {
    if (getContext() != null) {
      QQToast.makeText(getContext(), 0, paramString, 1).show();
    }
  }
  
  public void showToast(String paramString, int paramInt)
  {
    if (getContext() != null) {
      QQToast.makeText(getContext(), paramInt, paramString, 1).show();
    }
  }
  
  protected void updateUIForTextFeeds() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView
 * JD-Core Version:    0.7.0.1
 */