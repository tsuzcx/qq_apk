package cooperation.qzone.contentbox;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.FeedListView;
import cooperation.qzone.api.FeedListView.LoadFeedCallback;
import cooperation.qzone.contentbox.model.MQLikeCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgBody;
import cooperation.qzone.contentbox.model.MQMsgInteractData;
import cooperation.qzone.contentbox.model.MsgOnClickListener;
import cooperation.qzone.util.QzonePublicAccountHelper;
import java.util.ArrayList;

public class MsgNewSmallCardView
  extends RelativeLayout
  implements FeedListView.LoadFeedCallback
{
  private static final int AVATAR_GAP;
  private static final int BACKGROUND_HEIGHT;
  private static final int BACKGROUND_WIDTH = ViewUtils.b(128.0F);
  private static final int CARD_RADIUS;
  private static final int CONTENT_COLOR = Color.parseColor("#7A7A8D");
  private static final int CONTENT_COLOR_NIGHTMODE = Color.parseColor("#8D8D93");
  private static final String COUNT_OVERFLOW_STRING = "999+";
  private static final int HOUR_OF_ONE_DAY = 24;
  private static final int LARGE_PHOTO_HEIGHT;
  private static final int LIST_AVATAR_LENGTH;
  private static final int LIST_ITEM_MARGIN_BOTTOM;
  private static final int LIST_ITEM_MARGIN_TOP;
  private static final int LIST_MARGIN_LEFT;
  private static final int LIST_MARGIN_RIGHT;
  private static final int LIST_MARGIN_TOP;
  private static final int MAX_PAGE_ITEM = 9;
  private static final long ONE_HOUR = 3600000L;
  private static final String TAG = "MsgNewSmallCardView";
  private static final int TITLE_COLOR;
  private static final int TITLE_COLOR_NIGHTMODE;
  private RelativeLayout actionRegion;
  private QQAppInterface app;
  private FrameLayout avatarListRegion;
  private RoundCornerImageView bkgRegion;
  private LinearLayout feedsContainer;
  private boolean isNightMode;
  private Context mContext;
  private LinearLayout mFeedListViewContainer;
  private FeedListView mFeedsLV;
  private ViewStub mFeedsListViewStub;
  private MsgOnClickListener msgOnClickListener;
  private RelativeLayout textContentRegion;
  private TextView textFirstRegion;
  private TextView textSecondRegion;
  private TextView titleRegion;
  private RelativeLayout userInfoRegion;
  
  static
  {
    BACKGROUND_HEIGHT = ViewUtils.b(128.0F);
    LIST_AVATAR_LENGTH = ViewUtils.b(40.0F);
    AVATAR_GAP = ViewUtils.b(28.0F);
    LIST_MARGIN_TOP = ViewUtils.b(35.0F);
    LIST_MARGIN_LEFT = ViewUtils.b(12.0F);
    LIST_MARGIN_RIGHT = ViewUtils.b(12.0F);
    LIST_ITEM_MARGIN_TOP = ViewUtils.b(10.0F);
    LIST_ITEM_MARGIN_BOTTOM = ViewUtils.b(18.0F);
    LARGE_PHOTO_HEIGHT = ViewUtils.b(230.0F);
    CARD_RADIUS = ViewUtils.b(8.0F);
    TITLE_COLOR = Color.parseColor("#000000");
    TITLE_COLOR_NIGHTMODE = Color.parseColor("#FFFFFF");
  }
  
  public MsgNewSmallCardView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.app = paramQQAppInterface;
    LayoutInflater.from(this.mContext).inflate(2080636943, this);
    this.bkgRegion = ((RoundCornerImageView)findViewById(2080571410));
    this.titleRegion = ((TextView)findViewById(2080571529));
    this.textContentRegion = ((RelativeLayout)findViewById(2080571441));
    this.userInfoRegion = ((RelativeLayout)findViewById(2080571405));
    this.avatarListRegion = ((FrameLayout)findViewById(2080571404));
    this.actionRegion = ((RelativeLayout)findViewById(2080571393));
    this.textFirstRegion = ((TextView)findViewById(2080571523));
    this.textSecondRegion = ((TextView)findViewById(2080571453));
    this.feedsContainer = ((LinearLayout)findViewById(2080571471));
    this.isNightMode = false;
    initFeedListView();
  }
  
  private void adjustContainerHeight()
  {
    int i = 0;
    int j = 0;
    while (i < this.mFeedsLV.getAdapter().getCount())
    {
      try
      {
        View localView = this.mFeedsLV.getAdapter().getView(i, null, this.mFeedListViewContainer);
        localView.measure(0, 0);
        int k = localView.getMeasuredHeight();
        j += k;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("adjustContainerHeight error: ");
        localStringBuilder.append(localException);
        QLog.e("MsgNewSmallCardView", 1, localStringBuilder.toString());
      }
      i += 1;
    }
    ViewGroup.LayoutParams localLayoutParams = this.mFeedListViewContainer.getLayoutParams();
    localLayoutParams.height = (this.mFeedsLV.getDividerHeight() * (this.mFeedsLV.getCount() - 1) + j);
    this.mFeedListViewContainer.setLayoutParams(localLayoutParams);
    this.mFeedListViewContainer.setVisibility(0);
    this.mFeedsLV.setVisibility(0);
  }
  
  private void initActionRegion(MQMsg paramMQMsg)
  {
    if (paramMQMsg != null)
    {
      if (paramMQMsg.msgInteractData == null) {
        return;
      }
      TextView localTextView1 = (TextView)findViewById(2080571517);
      ImageView localImageView1 = (ImageView)findViewById(2080571455);
      TextView localTextView2 = (TextView)findViewById(2080571518);
      ImageView localImageView2 = (ImageView)findViewById(2080571456);
      TextView localTextView3 = (TextView)findViewById(2080571519);
      ImageView localImageView3 = (ImageView)findViewById(2080571457);
      int i;
      if (paramMQMsg.msgInteractData.totalView > 0)
      {
        if (paramMQMsg.msgInteractData.totalView > 9999) {
          localTextView1.setText("999+");
        } else {
          localTextView1.setText(String.valueOf(paramMQMsg.msgInteractData.totalView));
        }
        localTextView1.setVisibility(0);
        localImageView1.setVisibility(0);
        setContentTextColor(localTextView1);
        if (this.isNightMode) {
          i = 2130848743;
        } else {
          i = 2130848742;
        }
        localImageView1.setBackgroundResource(i);
      }
      else
      {
        localTextView1.setVisibility(8);
        localImageView1.setVisibility(8);
      }
      if (paramMQMsg.msgInteractData.totalComment > 0)
      {
        if (paramMQMsg.msgInteractData.totalComment > 9999) {
          localTextView2.setText("999+");
        } else {
          localTextView2.setText(String.valueOf(paramMQMsg.msgInteractData.totalComment));
        }
        localTextView2.setVisibility(0);
        localImageView2.setVisibility(0);
        setContentTextColor(localTextView2);
        if (this.isNightMode) {
          i = 2130848735;
        } else {
          i = 2130848734;
        }
        localImageView2.setBackgroundResource(i);
      }
      else
      {
        localTextView2.setVisibility(8);
        localImageView2.setVisibility(8);
      }
      if ((paramMQMsg.msgInteractData.likeCell != null) && (paramMQMsg.msgInteractData.likeCell.totalLike > 0))
      {
        if (paramMQMsg.msgInteractData.likeCell.totalLike > 9999) {
          localTextView3.setText("999+");
        } else {
          localTextView3.setText(String.valueOf(paramMQMsg.msgInteractData.likeCell.totalLike));
        }
        localTextView3.setVisibility(0);
        localImageView3.setVisibility(0);
        setContentTextColor(localTextView3);
        if (this.isNightMode) {
          i = 2130848739;
        } else {
          i = 2130848738;
        }
        localImageView3.setBackgroundResource(i);
      }
      else
      {
        localTextView3.setVisibility(8);
        localImageView3.setVisibility(8);
      }
      this.actionRegion.setVisibility(0);
    }
  }
  
  private void initAvatarListRegion(MQMsg paramMQMsg)
  {
    if ((paramMQMsg != null) && (paramMQMsg.msgBody != null) && (paramMQMsg.msgBody.vecUserAvatar != null))
    {
      if (paramMQMsg.msgBody.vecUserAvatar.size() == 0) {
        return;
      }
      this.avatarListRegion.setVisibility(0);
      this.avatarListRegion.removeAllViews();
      int j = paramMQMsg.msgBody.vecUserAvatar.size();
      int k = Math.min(5, j);
      int i = 0;
      while (i < k)
      {
        Object localObject = this.mContext;
        boolean bool2 = this.isNightMode;
        boolean bool1 = true;
        localObject = new UserListItemView((Context)localObject, 1, bool2, true);
        ((UserListItemView)localObject).setUin((String)paramMQMsg.msgBody.vecUserAvatar.get(i));
        ((UserListItemView)localObject).setTranslationX(AVATAR_GAP * i);
        if ((i != 4) || (j <= 5)) {
          bool1 = false;
        }
        ((UserListItemView)localObject).showCover(bool1);
        this.avatarListRegion.addView((View)localObject, i);
        i += 1;
      }
      this.avatarListRegion.setVisibility(0);
    }
  }
  
  private void initBackgroundRegion(MQMsg paramMQMsg)
  {
    if (paramMQMsg != null)
    {
      if (paramMQMsg.msgBody == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramMQMsg.msgBody.coverPicUrl)) {
        this.bkgRegion.setImageDrawable(getUrlDrawable(paramMQMsg.msgBody.coverPicUrl));
      }
      paramMQMsg = this.bkgRegion;
      int i = CARD_RADIUS;
      paramMQMsg.setCorner(i, 0, i, 0);
      this.bkgRegion.setVisibility(0);
      paramMQMsg = (RelativeLayout)findViewById(2080571497);
      RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)findViewById(2080571408);
      if (this.isNightMode)
      {
        paramMQMsg.setBackgroundResource(2130848718);
        i = CARD_RADIUS;
        localRoundCornerImageView.setCorner(i, 0, i, 0);
        localRoundCornerImageView.setVisibility(0);
        return;
      }
      paramMQMsg.setBackgroundResource(2130848717);
      localRoundCornerImageView.setVisibility(8);
    }
  }
  
  private void initFeedListView()
  {
    if (!QzonePublicAccountHelper.isQZonePluginReady(this.mContext, this.app)) {
      return;
    }
    this.mFeedsListViewStub = ((ViewStub)findViewById(2080571474));
    this.mFeedsListViewStub.inflate();
    this.mFeedListViewContainer = ((LinearLayout)findViewById(2080571473));
    this.mFeedsLV = ((FeedListView)findViewById(2080571472));
    this.mFeedsLV.setOverScrollMode(0);
    this.mFeedsLV.setEdgeEffectEnabled(false);
    this.mFeedsLV.setVerticalScrollBarEnabled(false);
    FeedListView localFeedListView = this.mFeedsLV;
    QQAppInterface localQQAppInterface = this.app;
    localFeedListView.attach(localQQAppInterface, (Activity)this.mContext, localQQAppInterface.getLongAccountUin());
  }
  
  private void initFirstTextExtra(MQMsg paramMQMsg)
  {
    if (paramMQMsg != null)
    {
      if (paramMQMsg.msgBody == null) {
        return;
      }
      this.textFirstRegion.setText(paramMQMsg.msgBody.title);
      setTitleTextColor(this.textFirstRegion);
      this.textFirstRegion.setVisibility(0);
    }
  }
  
  private void initQcircleActionRegion(MQMsg paramMQMsg)
  {
    if (paramMQMsg != null)
    {
      if (paramMQMsg.msgInteractData == null) {
        return;
      }
      TextView localTextView1 = (TextView)findViewById(2080571517);
      ImageView localImageView1 = (ImageView)findViewById(2080571455);
      TextView localTextView2 = (TextView)findViewById(2080571518);
      ImageView localImageView2 = (ImageView)findViewById(2080571456);
      TextView localTextView3 = (TextView)findViewById(2080571519);
      ImageView localImageView3 = (ImageView)findViewById(2080571457);
      int i;
      if ((paramMQMsg.msgInteractData.likeCell != null) && (paramMQMsg.msgInteractData.likeCell.totalLike > 0))
      {
        if (paramMQMsg.msgInteractData.likeCell.totalLike > 9999) {
          localTextView1.setText("999+");
        } else {
          localTextView1.setText(String.valueOf(paramMQMsg.msgInteractData.likeCell.totalLike));
        }
        localTextView1.setVisibility(0);
        localImageView1.setVisibility(0);
        setContentTextColor(localTextView1);
        if (this.isNightMode) {
          i = 2130848737;
        } else {
          i = 2130848736;
        }
        localImageView1.setBackgroundResource(i);
      }
      else
      {
        localTextView1.setVisibility(8);
        localImageView1.setVisibility(8);
      }
      if (paramMQMsg.msgInteractData.totalComment > 0)
      {
        if (paramMQMsg.msgInteractData.totalComment > 9999) {
          localTextView2.setText("999+");
        } else {
          localTextView2.setText(String.valueOf(paramMQMsg.msgInteractData.totalComment));
        }
        localTextView2.setVisibility(0);
        localImageView2.setVisibility(0);
        setContentTextColor(localTextView2);
        if (this.isNightMode) {
          i = 2130848735;
        } else {
          i = 2130848734;
        }
        localImageView2.setBackgroundResource(i);
      }
      else
      {
        localTextView2.setVisibility(8);
        localImageView2.setVisibility(8);
      }
      if (paramMQMsg.msgInteractData.pushCount > 0)
      {
        if (paramMQMsg.msgInteractData.pushCount > 9999) {
          localTextView3.setText("999+");
        } else {
          localTextView3.setText(String.valueOf(paramMQMsg.msgInteractData.pushCount));
        }
        localTextView3.setVisibility(0);
        localImageView3.setVisibility(0);
        setContentTextColor(localTextView3);
        if (this.isNightMode) {
          i = 2130848741;
        } else {
          i = 2130848740;
        }
        localImageView3.setBackgroundResource(i);
      }
      else
      {
        localTextView3.setVisibility(8);
        localImageView3.setVisibility(8);
      }
      this.actionRegion.setVisibility(0);
    }
  }
  
  private void initSecondTextExtra(MQMsg paramMQMsg)
  {
    if (paramMQMsg != null)
    {
      if (paramMQMsg.msgBody == null) {
        return;
      }
      this.textSecondRegion.setText(paramMQMsg.msgBody.content);
      setContentTextColor(this.textSecondRegion);
      this.textSecondRegion.setVisibility(0);
    }
  }
  
  private void initTextContentRegion(MQMsg paramMQMsg)
  {
    if (paramMQMsg != null)
    {
      if (paramMQMsg.msgBody == null) {
        return;
      }
      TextView localTextView = (TextView)findViewById(2080571451);
      localTextView.setText(paramMQMsg.msgBody.title);
      localTextView.setVisibility(0);
      setTitleTextColor(localTextView);
      localTextView = (TextView)findViewById(2080571508);
      localTextView.setText(paramMQMsg.msgBody.content);
      localTextView.setVisibility(0);
      setContentTextColor(localTextView);
      this.textContentRegion.setVisibility(0);
    }
  }
  
  private void initUserInfoRegion(MQMsg paramMQMsg)
  {
    if ((paramMQMsg != null) && (!TextUtils.isEmpty(paramMQMsg.user_avatar)))
    {
      if (TextUtils.isEmpty(paramMQMsg.user_nick)) {
        return;
      }
      Object localObject = (FrameLayout)findViewById(2080571535);
      UserListItemView localUserListItemView = new UserListItemView(this.mContext, 1, this.isNightMode, true);
      localUserListItemView.setUin(paramMQMsg.user_avatar);
      localUserListItemView.showCover(false);
      ((FrameLayout)localObject).addView(localUserListItemView);
      ((FrameLayout)localObject).setVisibility(0);
      localObject = (TextView)findViewById(2080571536);
      ((TextView)localObject).setText(paramMQMsg.user_nick);
      setTitleTextColor((TextView)localObject);
      ((TextView)localObject).setVisibility(0);
      this.userInfoRegion.setVisibility(0);
    }
  }
  
  private void resetAllRegion()
  {
    this.bkgRegion.setVisibility(8);
    this.titleRegion.setVisibility(8);
    this.textContentRegion.setVisibility(8);
    this.userInfoRegion.setVisibility(8);
    this.avatarListRegion.setVisibility(8);
    this.actionRegion.setVisibility(8);
    this.textFirstRegion.setVisibility(8);
    this.textSecondRegion.setVisibility(8);
  }
  
  private void setContentTextColor(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    if (this.isNightMode)
    {
      paramTextView.setTextColor(CONTENT_COLOR_NIGHTMODE);
      return;
    }
    paramTextView.setTextColor(CONTENT_COLOR);
  }
  
  private void setTitleTextColor(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    if (this.isNightMode)
    {
      paramTextView.setTextColor(TITLE_COLOR_NIGHTMODE);
      return;
    }
    paramTextView.setTextColor(TITLE_COLOR);
  }
  
  public TextView getFeedTitleTv()
  {
    TextView localTextView = (TextView)findViewById(2080571475);
    if (this.isNightMode) {
      localTextView.setBackgroundResource(2130848710);
    } else {
      localTextView.setBackgroundResource(2130848709);
    }
    setTitleTextColor(localTextView);
    return localTextView;
  }
  
  public LinearLayout getFeedsContainer()
  {
    if (this.isNightMode) {
      this.feedsContainer.setBackgroundColor(Color.parseColor("#171717"));
    } else {
      this.feedsContainer.setBackgroundColor(getResources().getColor(2131167394));
    }
    return this.feedsContainer;
  }
  
  public FeedListView getFeedsListView()
  {
    return this.mFeedsLV;
  }
  
  protected URLDrawable getUrlDrawable(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = BACKGROUND_WIDTH;
    localURLDrawableOptions.mRequestHeight = BACKGROUND_HEIGHT;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  public void onLoadOver(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLoadOver: ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("MsgNewSmallCardView", 4, ((StringBuilder)localObject).toString());
    if (getFeedTitleTv() != null)
    {
      localObject = this.mFeedsLV;
      if (localObject != null)
      {
        if (((FeedListView)localObject).getFeedCnt() == 0) {
          return;
        }
        adjustContainerHeight();
      }
    }
  }
  
  public void setData(MQMsg paramMQMsg)
  {
    resetAllRegion();
    if (paramMQMsg == null) {
      return;
    }
    int i = paramMQMsg.msgType;
    this.isNightMode = ThemeUtil.isNowThemeIsNight(this.app, false, null);
    this.titleRegion.setText(paramMQMsg.title);
    if (this.isNightMode) {
      this.titleRegion.setTextColor(CONTENT_COLOR_NIGHTMODE);
    } else {
      this.titleRegion.setTextColor(TITLE_COLOR);
    }
    this.titleRegion.setVisibility(0);
    initBackgroundRegion(paramMQMsg);
    if (i == 5)
    {
      initUserInfoRegion(paramMQMsg);
      initAvatarListRegion(paramMQMsg);
      initActionRegion(paramMQMsg);
      initSecondTextExtra(paramMQMsg);
    }
    else if (i == 3)
    {
      initAvatarListRegion(paramMQMsg);
      initSecondTextExtra(paramMQMsg);
    }
    else if (i == 10)
    {
      initUserInfoRegion(paramMQMsg);
      initActionRegion(paramMQMsg);
      initSecondTextExtra(paramMQMsg);
    }
    else if ((i != 1) && (i != 4))
    {
      if (i == 2)
      {
        initFirstTextExtra(paramMQMsg);
        initActionRegion(paramMQMsg);
        initSecondTextExtra(paramMQMsg);
      }
      else if (i == 12)
      {
        initUserInfoRegion(paramMQMsg);
        initQcircleActionRegion(paramMQMsg);
      }
      else
      {
        initTextContentRegion(paramMQMsg);
      }
    }
    else
    {
      initFirstTextExtra(paramMQMsg);
      initSecondTextExtra(paramMQMsg);
    }
    setOnClickListener(new MsgNewSmallCardView.1(this, paramMQMsg));
  }
  
  public void setMsgOnClickListener(MsgOnClickListener paramMsgOnClickListener)
  {
    this.msgOnClickListener = paramMsgOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgNewSmallCardView
 * JD-Core Version:    0.7.0.1
 */