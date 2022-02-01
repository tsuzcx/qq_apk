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
import cooperation.qzone.contentbox.model.MQBottomCell;
import cooperation.qzone.contentbox.model.MQLikeCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgBody;
import cooperation.qzone.contentbox.model.MQMsgInteractData;
import cooperation.qzone.contentbox.model.MsgOnClickListener;
import cooperation.qzone.util.QzonePublicAccountHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MsgNewLargeCardView
  extends RelativeLayout
  implements FeedListView.LoadFeedCallback
{
  private static final int AVATAR_GAP;
  private static final int BACKGROUND_HEIGHT;
  private static final int BACKGROUND_WIDTH = ;
  private static final int CARD_RADIUS = ViewUtils.b(8.0F);
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
  private static final String TAG = "MsgNewLargeCardView";
  private static final int TITLE_COLOR = Color.parseColor("#000000");
  private static final int TITLE_COLOR_NIGHTMODE = Color.parseColor("#FFFFFF");
  private RelativeLayout actionRegion;
  private LinearLayout allTextRegion;
  private QQAppInterface app;
  private RoundCornerImageView bkgRegion;
  private RelativeLayout bottomCellRegion;
  private TextView dateRegion;
  private RelativeLayout feedContentRegion;
  private LinearLayout feedsContainer;
  private boolean isNightMode;
  private Context mContext;
  private LinearLayout mFeedListViewContainer;
  private FeedListView mFeedsLV;
  private ViewStub mFeedsListViewStub;
  private MsgOnClickListener msgOnClickListener;
  private TextView titleRegion;
  private RelativeLayout userInfoRegion;
  
  static
  {
    BACKGROUND_HEIGHT = ViewUtils.b(197.0F);
    LIST_AVATAR_LENGTH = ViewUtils.b(40.0F);
    AVATAR_GAP = ViewUtils.b(30.0F);
    LIST_MARGIN_TOP = ViewUtils.b(35.0F);
    LIST_MARGIN_LEFT = ViewUtils.b(12.0F);
    LIST_MARGIN_RIGHT = ViewUtils.b(12.0F);
    LIST_ITEM_MARGIN_TOP = ViewUtils.b(10.0F);
    LIST_ITEM_MARGIN_BOTTOM = ViewUtils.b(18.0F);
    LARGE_PHOTO_HEIGHT = ViewUtils.b(230.0F);
  }
  
  public MsgNewLargeCardView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.app = paramQQAppInterface;
    LayoutInflater.from(this.mContext).inflate(2080636942, this);
    this.dateRegion = ((TextView)findViewById(2080571423));
    this.bkgRegion = ((RoundCornerImageView)findViewById(2080571410));
    this.titleRegion = ((TextView)findViewById(2080571529));
    this.allTextRegion = ((LinearLayout)findViewById(2080571441));
    this.userInfoRegion = ((RelativeLayout)findViewById(2080571405));
    this.actionRegion = ((RelativeLayout)findViewById(2080571393));
    this.feedContentRegion = ((RelativeLayout)findViewById(2080571443));
    this.bottomCellRegion = ((RelativeLayout)findViewById(2080571413));
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
      localObject = this.mFeedsLV.getAdapter().getView(i, null, this.mFeedListViewContainer);
      ((View)localObject).measure(0, 0);
      j += ((View)localObject).getMeasuredHeight();
      i += 1;
    }
    Object localObject = this.mFeedListViewContainer.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (this.mFeedsLV.getDividerHeight() * (this.mFeedsLV.getCount() - 1) + j);
    this.mFeedListViewContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
      TextView localTextView1 = (TextView)findViewById(2080571394);
      TextView localTextView2 = (TextView)findViewById(2080571517);
      ImageView localImageView1 = (ImageView)findViewById(2080571455);
      TextView localTextView3 = (TextView)findViewById(2080571518);
      ImageView localImageView2 = (ImageView)findViewById(2080571456);
      TextView localTextView4 = (TextView)findViewById(2080571519);
      ImageView localImageView3 = (ImageView)findViewById(2080571457);
      TextView localTextView5 = (TextView)findViewById(2080571392);
      localTextView1.setText(paramMQMsg.msgBody.title);
      if (paramMQMsg.msgInteractData.totalView > 0)
      {
        localTextView2.setText(String.valueOf(paramMQMsg.msgInteractData.totalView));
        localTextView2.setVisibility(0);
        localImageView1.setVisibility(0);
      }
      else
      {
        localTextView2.setVisibility(8);
        localImageView1.setVisibility(8);
      }
      if (paramMQMsg.msgInteractData.totalComment > 0)
      {
        localTextView3.setText(String.valueOf(paramMQMsg.msgInteractData.totalComment));
        localTextView3.setVisibility(0);
        localImageView2.setVisibility(0);
      }
      else
      {
        localTextView3.setVisibility(8);
        localImageView2.setVisibility(8);
      }
      if ((paramMQMsg.msgInteractData.likeCell != null) && (paramMQMsg.msgInteractData.likeCell.totalLike > 0))
      {
        localTextView4.setText(String.valueOf(paramMQMsg.msgInteractData.likeCell.totalLike));
        localTextView4.setVisibility(0);
        localImageView3.setVisibility(0);
      }
      else
      {
        localTextView4.setVisibility(8);
        localImageView3.setVisibility(8);
      }
      if ((paramMQMsg.msgBody != null) && (!TextUtils.isEmpty(paramMQMsg.msgBody.content)))
      {
        localTextView5.setText(paramMQMsg.msgBody.content);
        localTextView5.setVisibility(0);
      }
      else
      {
        localTextView5.setVisibility(8);
      }
      this.actionRegion.setVisibility(0);
    }
  }
  
  private void initAllTextRegion(MQMsg paramMQMsg)
  {
    if (paramMQMsg == null) {
      return;
    }
    Object localObject;
    if ((paramMQMsg.bottomCell != null) && (paramMQMsg.bottomCell.userAvatar != null))
    {
      localObject = (FrameLayout)findViewById(2080571401);
      initAvatarListArea(paramMQMsg, (FrameLayout)localObject);
      ((FrameLayout)localObject).setVisibility(0);
    }
    if (paramMQMsg.msgBody != null)
    {
      localObject = (TextView)findViewById(2080571451);
      TextView localTextView = (TextView)findViewById(2080571508);
      ((TextView)localObject).setText(paramMQMsg.msgBody.title);
      localTextView.setText(paramMQMsg.msgBody.content);
      ((TextView)localObject).setVisibility(0);
      localTextView.setVisibility(0);
    }
    this.allTextRegion.setVisibility(0);
  }
  
  private void initAvatarListArea(MQMsg paramMQMsg, FrameLayout paramFrameLayout)
  {
    if ((paramMQMsg != null) && (paramMQMsg.msgBody != null) && (paramMQMsg.msgBody.vecUserAvatar != null) && (paramMQMsg.msgBody.vecUserAvatar.size() != 0))
    {
      if (paramFrameLayout == null) {
        return;
      }
      paramFrameLayout.setVisibility(0);
      paramFrameLayout.removeAllViews();
      int j = paramMQMsg.msgBody.vecUserAvatar.size();
      int k = Math.min(5, j);
      int i = 0;
      while (i < k)
      {
        Object localObject = this.mContext;
        boolean bool = true;
        localObject = new UserListItemView((Context)localObject, 0, false, true);
        ((UserListItemView)localObject).setUin((String)paramMQMsg.msgBody.vecUserAvatar.get(i));
        ((UserListItemView)localObject).setTranslationX(AVATAR_GAP * i);
        if ((i != 4) || (j <= 5)) {
          bool = false;
        }
        ((UserListItemView)localObject).showCover(bool);
        paramFrameLayout.addView((View)localObject, i);
        i += 1;
      }
      paramFrameLayout.setVisibility(0);
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
      paramMQMsg.setCorner(i, i, i, i);
      this.bkgRegion.setVisibility(0);
      paramMQMsg = (RoundCornerImageView)findViewById(2080571409);
      i = CARD_RADIUS;
      paramMQMsg.setCorner(i, i, 0, 0);
      paramMQMsg = (RoundCornerImageView)findViewById(2080571407);
      i = CARD_RADIUS;
      paramMQMsg.setCorner(0, 0, i, i);
      paramMQMsg = (RoundCornerImageView)findViewById(2080571408);
      if (this.isNightMode)
      {
        paramMQMsg.setVisibility(0);
        i = CARD_RADIUS;
        paramMQMsg.setCorner(i, i, i, i);
        return;
      }
      paramMQMsg.setVisibility(8);
    }
  }
  
  private void initBottomCellRegion(MQMsg paramMQMsg)
  {
    if (paramMQMsg != null)
    {
      if (paramMQMsg.bottomCell == null) {
        return;
      }
      initAvatarListArea(paramMQMsg, (FrameLayout)findViewById(2080571402));
      if ((!TextUtils.isEmpty(paramMQMsg.bottomCell.content)) && (!TextUtils.isEmpty(paramMQMsg.bottomCell.jumpUrl)))
      {
        TextView localTextView = (TextView)findViewById(2080571415);
        localTextView.setText(paramMQMsg.bottomCell.content);
        localTextView.setVisibility(0);
        ((RelativeLayout)findViewById(2080571414)).setOnClickListener(new MsgNewLargeCardView.2(this, paramMQMsg));
        this.bottomCellRegion.setVisibility(0);
      }
    }
  }
  
  private void initFeedContentRegion(MQMsg paramMQMsg)
  {
    if ((paramMQMsg != null) && (paramMQMsg.msgBody != null))
    {
      if (TextUtils.isEmpty(paramMQMsg.msgBody.content)) {
        return;
      }
      ((TextView)findViewById(2080571447)).setText(paramMQMsg.msgBody.content);
      this.feedContentRegion.setVisibility(0);
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
  
  private void initUserRegion(MQMsg paramMQMsg)
  {
    if ((paramMQMsg != null) && (!TextUtils.isEmpty(paramMQMsg.user_avatar)))
    {
      if (TextUtils.isEmpty(paramMQMsg.user_nick)) {
        return;
      }
      Object localObject1 = (FrameLayout)findViewById(2080571535);
      Object localObject2 = new UserListItemView(this.mContext, 0, false, true);
      ((UserListItemView)localObject2).setUin(paramMQMsg.user_avatar);
      ((UserListItemView)localObject2).showCover(false);
      ((FrameLayout)localObject1).addView((View)localObject2);
      ((FrameLayout)localObject1).setVisibility(0);
      if (!TextUtils.isEmpty(paramMQMsg.content))
      {
        localObject2 = (TextView)findViewById(2080571446);
        localObject1 = (TextView)findViewById(2080571536);
        ((TextView)localObject2).setText(paramMQMsg.content);
        ((TextView)localObject2).setVisibility(0);
      }
      else
      {
        localObject1 = (TextView)findViewById(2080571537);
      }
      ((TextView)localObject1).setText(paramMQMsg.user_nick);
      ((TextView)localObject1).setVisibility(0);
      this.userInfoRegion.setVisibility(0);
    }
  }
  
  private void resetAllRegion()
  {
    this.bkgRegion.setVisibility(8);
    this.titleRegion.setVisibility(8);
    this.allTextRegion.setVisibility(8);
    this.userInfoRegion.setVisibility(8);
    this.actionRegion.setVisibility(8);
    this.feedContentRegion.setVisibility(8);
    this.bottomCellRegion.setVisibility(8);
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
    return URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
  }
  
  public void initDateRegion(MQMsg paramMQMsg, int paramInt)
  {
    this.isNightMode = ThemeUtil.isNowThemeIsNight(this.app, false, null);
    if (paramInt == 0)
    {
      String str = new SimpleDateFormat("MM月dd日").format(new Date(paramMQMsg.pushTime * 1000L));
      paramMQMsg = str;
      if (str.startsWith("0")) {
        paramMQMsg = str.substring(1);
      }
      this.dateRegion.setText(paramMQMsg);
      setTitleTextColor(this.dateRegion);
      this.dateRegion.setVisibility(0);
      return;
    }
    this.dateRegion.setVisibility(8);
  }
  
  public void onLoadOver(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLoadOver: ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("MsgNewLargeCardView", 4, ((StringBuilder)localObject).toString());
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
    this.isNightMode = ThemeUtil.isNowThemeIsNight(this.app, false, null);
    int i = paramMQMsg.msgType;
    this.titleRegion.setText(paramMQMsg.title);
    this.titleRegion.setVisibility(0);
    initBackgroundRegion(paramMQMsg);
    if ((i != 12) && (i != 10))
    {
      if (i == 2)
      {
        initActionRegion(paramMQMsg);
      }
      else if (i == 5)
      {
        initBottomCellRegion(paramMQMsg);
        initUserRegion(paramMQMsg);
      }
      else
      {
        initAllTextRegion(paramMQMsg);
      }
    }
    else {
      initUserRegion(paramMQMsg);
    }
    setOnClickListener(new MsgNewLargeCardView.1(this, paramMQMsg));
  }
  
  public void setMsgOnClickListener(MsgOnClickListener paramMsgOnClickListener)
  {
    this.msgOnClickListener = paramMsgOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgNewLargeCardView
 * JD-Core Version:    0.7.0.1
 */