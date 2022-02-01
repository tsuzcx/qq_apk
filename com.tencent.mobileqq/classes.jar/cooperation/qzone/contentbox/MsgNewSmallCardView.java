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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
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
    LayoutInflater.from(this.mContext).inflate(2131562568, this);
    this.bkgRegion = ((RoundCornerImageView)findViewById(2131363428));
    this.titleRegion = ((TextView)findViewById(2131379503));
    this.textContentRegion = ((RelativeLayout)findViewById(2131365979));
    this.userInfoRegion = ((RelativeLayout)findViewById(2131363230));
    this.avatarListRegion = ((FrameLayout)findViewById(2131363224));
    this.actionRegion = ((RelativeLayout)findViewById(2131361961));
    this.textFirstRegion = ((TextView)findViewById(2131379302));
    this.textSecondRegion = ((TextView)findViewById(2131367429));
    this.feedsContainer = ((LinearLayout)findViewById(2131371927));
    this.isNightMode = false;
    initFeedListView();
  }
  
  private void adjustContainerHeight()
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i >= this.mFeedsLV.getAdapter().getCount()) {
        break label95;
      }
      try
      {
        View localView = this.mFeedsLV.getAdapter().getView(i, null, this.mFeedListViewContainer);
        localView.measure(0, 0);
        int k = localView.getMeasuredHeight();
        j += k;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("MsgNewSmallCardView", 1, "adjustContainerHeight error: " + localException);
        }
      }
      i += 1;
    }
    label95:
    ViewGroup.LayoutParams localLayoutParams = this.mFeedListViewContainer.getLayoutParams();
    localLayoutParams.height = (j + this.mFeedsLV.getDividerHeight() * (this.mFeedsLV.getCount() - 1));
    this.mFeedListViewContainer.setLayoutParams(localLayoutParams);
    this.mFeedListViewContainer.setVisibility(0);
    this.mFeedsLV.setVisibility(0);
  }
  
  private void initActionRegion(MQMsg paramMQMsg)
  {
    if ((paramMQMsg == null) || (paramMQMsg.msgInteractData == null)) {
      return;
    }
    TextView localTextView1 = (TextView)findViewById(2131379156);
    ImageView localImageView1 = (ImageView)findViewById(2131368623);
    TextView localTextView2 = (TextView)findViewById(2131379223);
    ImageView localImageView2 = (ImageView)findViewById(2131368644);
    TextView localTextView3 = (TextView)findViewById(2131379243);
    ImageView localImageView3 = (ImageView)findViewById(2131368646);
    int i;
    if (paramMQMsg.msgInteractData.totalView > 0) {
      if (paramMQMsg.msgInteractData.totalView > 9999)
      {
        localTextView1.setText("999+");
        localTextView1.setVisibility(0);
        localImageView1.setVisibility(0);
        setContentTextColor(localTextView1);
        if (!this.isNightMode) {
          break label317;
        }
        i = 2130848863;
        label139:
        localImageView1.setBackgroundResource(i);
        label145:
        if (paramMQMsg.msgInteractData.totalComment <= 0) {
          break label365;
        }
        if (paramMQMsg.msgInteractData.totalComment <= 9999) {
          break label340;
        }
        localTextView2.setText("999+");
        label175:
        localTextView2.setVisibility(0);
        localImageView2.setVisibility(0);
        setContentTextColor(localTextView2);
        if (!this.isNightMode) {
          break label358;
        }
        i = 2130848855;
        label204:
        localImageView2.setBackgroundResource(i);
        label210:
        if ((paramMQMsg.msgInteractData.likeCell == null) || (paramMQMsg.msgInteractData.likeCell.totalLike <= 0)) {
          break label410;
        }
        if (paramMQMsg.msgInteractData.likeCell.totalLike <= 9999) {
          break label382;
        }
        localTextView3.setText("999+");
        label256:
        localTextView3.setVisibility(0);
        localImageView3.setVisibility(0);
        setContentTextColor(localTextView3);
        if (!this.isNightMode) {
          break label403;
        }
        i = 2130848859;
        label285:
        localImageView3.setBackgroundResource(i);
      }
    }
    for (;;)
    {
      this.actionRegion.setVisibility(0);
      return;
      localTextView1.setText(String.valueOf(paramMQMsg.msgInteractData.totalView));
      break;
      label317:
      i = 2130848862;
      break label139;
      localTextView1.setVisibility(8);
      localImageView1.setVisibility(8);
      break label145;
      label340:
      localTextView2.setText(String.valueOf(paramMQMsg.msgInteractData.totalComment));
      break label175;
      label358:
      i = 2130848854;
      break label204;
      label365:
      localTextView2.setVisibility(8);
      localImageView2.setVisibility(8);
      break label210;
      label382:
      localTextView3.setText(String.valueOf(paramMQMsg.msgInteractData.likeCell.totalLike));
      break label256;
      label403:
      i = 2130848858;
      break label285;
      label410:
      localTextView3.setVisibility(8);
      localImageView3.setVisibility(8);
    }
  }
  
  private void initAvatarListRegion(MQMsg paramMQMsg)
  {
    if ((paramMQMsg == null) || (paramMQMsg.msgBody == null) || (paramMQMsg.msgBody.vecUserAvatar == null) || (paramMQMsg.msgBody.vecUserAvatar.size() == 0)) {
      return;
    }
    this.avatarListRegion.setVisibility(0);
    this.avatarListRegion.removeAllViews();
    int j = paramMQMsg.msgBody.vecUserAvatar.size();
    int k = Math.min(5, j);
    int i = 0;
    if (i < k)
    {
      UserListItemView localUserListItemView = new UserListItemView(this.mContext, 1, this.isNightMode, true);
      localUserListItemView.setUin((String)paramMQMsg.msgBody.vecUserAvatar.get(i));
      localUserListItemView.setTranslationX(AVATAR_GAP * i);
      if ((i == 4) && (j > 5)) {}
      for (boolean bool = true;; bool = false)
      {
        localUserListItemView.showCover(bool);
        this.avatarListRegion.addView(localUserListItemView, i);
        i += 1;
        break;
      }
    }
    this.avatarListRegion.setVisibility(0);
  }
  
  private void initBackgroundRegion(MQMsg paramMQMsg)
  {
    if ((paramMQMsg == null) || (paramMQMsg.msgBody == null)) {
      return;
    }
    if (!TextUtils.isEmpty(paramMQMsg.msgBody.coverPicUrl)) {
      this.bkgRegion.setImageDrawable(getUrlDrawable(paramMQMsg.msgBody.coverPicUrl));
    }
    this.bkgRegion.setCorner(CARD_RADIUS, 0, CARD_RADIUS, 0);
    this.bkgRegion.setVisibility(0);
    paramMQMsg = (RelativeLayout)findViewById(2131376044);
    RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)findViewById(2131363425);
    if (this.isNightMode)
    {
      paramMQMsg.setBackgroundResource(2130848838);
      localRoundCornerImageView.setCorner(CARD_RADIUS, 0, CARD_RADIUS, 0);
      localRoundCornerImageView.setVisibility(0);
      return;
    }
    paramMQMsg.setBackgroundResource(2130848837);
    localRoundCornerImageView.setVisibility(8);
  }
  
  private void initFeedListView()
  {
    if (!QzonePublicAccountHelper.isQZonePluginReady(this.mContext, this.app)) {
      return;
    }
    this.mFeedsListViewStub = ((ViewStub)findViewById(2131371930));
    this.mFeedsListViewStub.inflate();
    this.mFeedListViewContainer = ((LinearLayout)findViewById(2131371929));
    this.mFeedsLV = ((FeedListView)findViewById(2131371928));
    this.mFeedsLV.setOverScrollMode(0);
    this.mFeedsLV.setEdgeEffectEnabled(false);
    this.mFeedsLV.setVerticalScrollBarEnabled(false);
    this.mFeedsLV.attach(this.app, (Activity)this.mContext, this.app.getLongAccountUin());
  }
  
  private void initFirstTextExtra(MQMsg paramMQMsg)
  {
    if ((paramMQMsg == null) || (paramMQMsg.msgBody == null)) {
      return;
    }
    this.textFirstRegion.setText(paramMQMsg.msgBody.title);
    setTitleTextColor(this.textFirstRegion);
    this.textFirstRegion.setVisibility(0);
  }
  
  private void initQcircleActionRegion(MQMsg paramMQMsg)
  {
    if ((paramMQMsg == null) || (paramMQMsg.msgInteractData == null)) {
      return;
    }
    TextView localTextView1 = (TextView)findViewById(2131379156);
    ImageView localImageView1 = (ImageView)findViewById(2131368623);
    TextView localTextView2 = (TextView)findViewById(2131379223);
    ImageView localImageView2 = (ImageView)findViewById(2131368644);
    TextView localTextView3 = (TextView)findViewById(2131379243);
    ImageView localImageView3 = (ImageView)findViewById(2131368646);
    int i;
    if ((paramMQMsg.msgInteractData.likeCell != null) && (paramMQMsg.msgInteractData.likeCell.totalLike > 0)) {
      if (paramMQMsg.msgInteractData.likeCell.totalLike > 9999)
      {
        localTextView1.setText("999+");
        localTextView1.setVisibility(0);
        localImageView1.setVisibility(0);
        setContentTextColor(localTextView1);
        if (!this.isNightMode) {
          break label320;
        }
        i = 2130848857;
        label155:
        localImageView1.setBackgroundResource(i);
        label161:
        if (paramMQMsg.msgInteractData.totalComment <= 0) {
          break label368;
        }
        if (paramMQMsg.msgInteractData.totalComment <= 9999) {
          break label343;
        }
        localTextView2.setText("999+");
        label191:
        localTextView2.setVisibility(0);
        localImageView2.setVisibility(0);
        setContentTextColor(localTextView2);
        if (!this.isNightMode) {
          break label361;
        }
        i = 2130848855;
        label220:
        localImageView2.setBackgroundResource(i);
        label226:
        if (paramMQMsg.msgInteractData.pushCount <= 0) {
          break label410;
        }
        if (paramMQMsg.msgInteractData.pushCount <= 9999) {
          break label385;
        }
        localTextView3.setText("999+");
        label256:
        localTextView3.setVisibility(0);
        localImageView3.setVisibility(0);
        setContentTextColor(localTextView3);
        if (!this.isNightMode) {
          break label403;
        }
        i = 2130848861;
        label285:
        localImageView3.setBackgroundResource(i);
      }
    }
    for (;;)
    {
      this.actionRegion.setVisibility(0);
      return;
      localTextView1.setText(String.valueOf(paramMQMsg.msgInteractData.likeCell.totalLike));
      break;
      label320:
      i = 2130848856;
      break label155;
      localTextView1.setVisibility(8);
      localImageView1.setVisibility(8);
      break label161;
      label343:
      localTextView2.setText(String.valueOf(paramMQMsg.msgInteractData.totalComment));
      break label191;
      label361:
      i = 2130848854;
      break label220;
      label368:
      localTextView2.setVisibility(8);
      localImageView2.setVisibility(8);
      break label226;
      label385:
      localTextView3.setText(String.valueOf(paramMQMsg.msgInteractData.pushCount));
      break label256;
      label403:
      i = 2130848860;
      break label285;
      label410:
      localTextView3.setVisibility(8);
      localImageView3.setVisibility(8);
    }
  }
  
  private void initSecondTextExtra(MQMsg paramMQMsg)
  {
    if ((paramMQMsg == null) || (paramMQMsg.msgBody == null)) {
      return;
    }
    this.textSecondRegion.setText(paramMQMsg.msgBody.content);
    setContentTextColor(this.textSecondRegion);
    this.textSecondRegion.setVisibility(0);
  }
  
  private void initTextContentRegion(MQMsg paramMQMsg)
  {
    if ((paramMQMsg == null) || (paramMQMsg.msgBody == null)) {
      return;
    }
    TextView localTextView = (TextView)findViewById(2131367034);
    localTextView.setText(paramMQMsg.msgBody.title);
    localTextView.setVisibility(0);
    setTitleTextColor(localTextView);
    localTextView = (TextView)findViewById(2131377676);
    localTextView.setText(paramMQMsg.msgBody.content);
    localTextView.setVisibility(0);
    setContentTextColor(localTextView);
    this.textContentRegion.setVisibility(0);
  }
  
  private void initUserInfoRegion(MQMsg paramMQMsg)
  {
    if ((paramMQMsg == null) || (TextUtils.isEmpty(paramMQMsg.user_avatar)) || (TextUtils.isEmpty(paramMQMsg.user_nick))) {
      return;
    }
    Object localObject = (FrameLayout)findViewById(2131381041);
    UserListItemView localUserListItemView = new UserListItemView(this.mContext, 1, this.isNightMode, true);
    localUserListItemView.setUin(paramMQMsg.user_avatar);
    localUserListItemView.showCover(false);
    ((FrameLayout)localObject).addView(localUserListItemView);
    ((FrameLayout)localObject).setVisibility(0);
    localObject = (TextView)findViewById(2131381084);
    ((TextView)localObject).setText(paramMQMsg.user_nick);
    setTitleTextColor((TextView)localObject);
    ((TextView)localObject).setVisibility(0);
    this.userInfoRegion.setVisibility(0);
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
    TextView localTextView = (TextView)findViewById(2131371931);
    if (this.isNightMode) {
      localTextView.setBackgroundResource(2130848830);
    }
    for (;;)
    {
      setTitleTextColor(localTextView);
      return localTextView;
      localTextView.setBackgroundResource(2130848829);
    }
  }
  
  public LinearLayout getFeedsContainer()
  {
    if (this.isNightMode) {
      this.feedsContainer.setBackgroundColor(Color.parseColor("#171717"));
    }
    for (;;)
    {
      return this.feedsContainer;
      this.feedsContainer.setBackgroundColor(getResources().getColor(2131167374));
    }
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
    QLog.i("MsgNewSmallCardView", 4, "onLoadOver: " + paramBoolean);
    if ((getFeedTitleTv() == null) || (this.mFeedsLV == null) || (this.mFeedsLV.getFeedCnt() == 0)) {
      return;
    }
    adjustContainerHeight();
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
    if (this.isNightMode)
    {
      this.titleRegion.setTextColor(CONTENT_COLOR_NIGHTMODE);
      this.titleRegion.setVisibility(0);
      initBackgroundRegion(paramMQMsg);
      if (i != 5) {
        break label120;
      }
      initUserInfoRegion(paramMQMsg);
      initAvatarListRegion(paramMQMsg);
      initActionRegion(paramMQMsg);
      initSecondTextExtra(paramMQMsg);
    }
    for (;;)
    {
      setOnClickListener(new MsgNewSmallCardView.1(this, paramMQMsg));
      return;
      this.titleRegion.setTextColor(TITLE_COLOR);
      break;
      label120:
      if (i == 3)
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
      else if ((i == 1) || (i == 4))
      {
        initFirstTextExtra(paramMQMsg);
        initSecondTextExtra(paramMQMsg);
      }
      else if (i == 2)
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
  }
  
  public void setMsgOnClickListener(MsgOnClickListener paramMsgOnClickListener)
  {
    this.msgOnClickListener = paramMsgOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgNewSmallCardView
 * JD-Core Version:    0.7.0.1
 */