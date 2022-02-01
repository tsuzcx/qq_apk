package cooperation.qzone.contentbox;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.qqdaily.ArkCollector;
import com.tencent.mobileqq.app.qqdaily.QQDailyArkView;
import com.tencent.mobileqq.app.qqdaily.QQDailyUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import cooperation.qzone.api.FeedListView;
import cooperation.qzone.api.FeedListView.LoadFeedCallback;
import cooperation.qzone.contentbox.model.MQBottomCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MsgOnClickListener;
import cooperation.qzone.util.QzonePublicAccountHelper;
import cooperation.qzone.widget.RoundCornerLinearLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class MsgCardView
  extends LinearLayout
  implements FeedListView.LoadFeedCallback
{
  private static final int CARD_RADIUS = ViewUtils.b(8.0F);
  private static final int HOUR_OF_ONE_DAY = 24;
  private static final int LARGE_PHOTO_HEIGHT;
  private static final int LIST_ITEM_MARGIN_BOTTOM;
  private static final int LIST_ITEM_MARGIN_TOP;
  private static final int LIST_MARGIN_LEFT;
  private static final int LIST_MARGIN_RIGHT;
  private static final int LIST_MARGIN_TOP = ViewUtils.b(35.0F);
  private static final int MAX_PAGE_ITEM = 9;
  private static final long ONE_HOUR = 3600000L;
  private static final String TAG = "MsgCardView";
  private QQAppInterface app;
  private Context mContext;
  private TextView mDateTv;
  private LinearLayout mFeedListViewContainer;
  private TextView mFeedTitleTv;
  private LinearLayout mFeedsContainer;
  private FeedListView mFeedsLV;
  private ViewStub mFeedsListViewStub;
  private int mLastPos = -1;
  private FrameLayout mMoreContainer;
  private RoundCornerLinearLayout mMoreView;
  private ViewGroup mPicContainer;
  private RoundCornerLinearLayout mPicView;
  public QQDailyArkView mQQDailyArkView;
  private ImageView mQcircleBG;
  private RelativeLayout mTitleContainer;
  private TextView mTitleDes;
  private TextView mTitleTime;
  private MsgOnClickListener msgOnClickListener;
  private MsgPhotoView msgPhotoView;
  
  static
  {
    LIST_MARGIN_LEFT = ViewUtils.b(12.0F);
    LIST_MARGIN_RIGHT = ViewUtils.b(12.0F);
    LIST_ITEM_MARGIN_TOP = ViewUtils.b(10.0F);
    LIST_ITEM_MARGIN_BOTTOM = ViewUtils.b(18.0F);
    LARGE_PHOTO_HEIGHT = ViewUtils.b(230.0F);
  }
  
  public MsgCardView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.app = paramQQAppInterface;
    LayoutInflater.from(this.mContext).inflate(2131562555, this);
    this.mTitleContainer = ((RelativeLayout)findViewById(2131379471));
    this.mTitleTime = ((TextView)findViewById(2131379530));
    this.mTitleDes = ((TextView)findViewById(2131379473));
    this.mPicContainer = ((ViewGroup)findViewById(2131371920));
    this.mPicView = ((RoundCornerLinearLayout)findViewById(2131371919));
    this.mPicView.setRadius(CARD_RADIUS);
    this.mMoreView = ((RoundCornerLinearLayout)findViewById(2131371939));
    this.mMoreView.setRadius(CARD_RADIUS);
    this.mMoreContainer = ((FrameLayout)findViewById(2131371940));
    this.mFeedTitleTv = ((TextView)findViewById(2131371931));
    this.mFeedsContainer = ((LinearLayout)findViewById(2131371927));
    this.mDateTv = ((TextView)findViewById(2131371964));
    this.mQQDailyArkView = ((QQDailyArkView)findViewById(2131363012));
    this.mQcircleBG = ((ImageView)findViewById(2131371921));
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
    ((ViewGroup.LayoutParams)localObject).height = (j + this.mFeedsLV.getDividerHeight() * (this.mFeedsLV.getCount() - 1));
    this.mFeedListViewContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.mFeedListViewContainer.setVisibility(0);
    this.mFeedsLV.setVisibility(0);
  }
  
  private BaseMsgView getFirstChild()
  {
    return this.msgPhotoView;
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
  
  private void updateTimeText(long paramLong)
  {
    long l = System.currentTimeMillis() - paramLong;
    if (l < 3600000L)
    {
      this.mTitleTime.setText(HardCodeUtil.a(2131706956));
      return;
    }
    l /= 3600000L;
    if (l < 24L)
    {
      this.mTitleTime.setText(String.format("%d小时前", new Object[] { Long.valueOf(l) }));
      return;
    }
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(paramLong));
    this.mTitleTime.setText(str);
  }
  
  public TextView getFeedTitleTv()
  {
    return this.mFeedTitleTv;
  }
  
  public LinearLayout getFeedsContainer()
  {
    return this.mFeedsContainer;
  }
  
  public FeedListView getFeedsListView()
  {
    return this.mFeedsLV;
  }
  
  public boolean isLargePhotoTotalVisible()
  {
    BaseMsgView localBaseMsgView = getFirstChild();
    if ((localBaseMsgView == null) || (!localBaseMsgView.isLargePhoto())) {}
    label95:
    for (;;)
    {
      return false;
      if (this.mTitleContainer != null) {
        i = this.mTitleContainer.getMeasuredHeight();
      }
      for (int i = ((LinearLayout.LayoutParams)this.mTitleContainer.getLayoutParams()).topMargin + i;; i = 0)
      {
        if (i + LIST_ITEM_MARGIN_TOP + getTop() < 0) {
          break label95;
        }
        i = ((ListView)getParent()).getMeasuredHeight();
        if (getTop() + getMeasuredHeight() - LIST_ITEM_MARGIN_BOTTOM > i) {
          break;
        }
        return true;
      }
    }
  }
  
  public void onDestroy()
  {
    this.mQQDailyArkView.a();
  }
  
  public void onLoadOver(boolean paramBoolean)
  {
    QLog.i("MsgCardView", 4, "onLoadOver: " + paramBoolean);
    if ((this.mFeedTitleTv == null) || (this.mFeedsLV == null) || (this.mFeedsLV.getFeedCnt() == 0)) {
      return;
    }
    adjustContainerHeight();
  }
  
  public void recycle()
  {
    if (this.msgPhotoView != null) {
      this.msgPhotoView.recycle();
    }
  }
  
  public void setData(int paramInt, MQMsg paramMQMsg, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramMQMsg == null)
    {
      this.mTitleContainer.setVisibility(8);
      this.mPicView.removeAllViews();
      this.mMoreView.removeAllViews();
      this.msgPhotoView = null;
    }
    label1164:
    for (;;)
    {
      return;
      Object localObject;
      label117:
      int i;
      if (paramBoolean2)
      {
        String str = new SimpleDateFormat("MM月dd日").format(new Date(paramMQMsg.pushTime * 1000L));
        localObject = str;
        if (str.startsWith("0")) {
          localObject = str.substring(1);
        }
        this.mDateTv.setText((CharSequence)localObject);
        this.mDateTv.setVisibility(0);
        this.mTitleContainer.setVisibility(8);
        if (!paramBoolean1) {
          break label755;
        }
        this.mTitleDes.setTextColor(-1);
        this.mDateTv.setTextColor(-1);
        this.mTitleTime.setTextColor(-11580352);
        this.mFeedsContainer.setBackgroundColor(-15263977);
        if (this.mFeedsLV != null) {
          this.mFeedsLV.setBackgroundColor(-15263977);
        }
        this.mPicContainer.setBackgroundResource(2130848877);
        this.mMoreContainer.setBackgroundResource(2130848877);
        this.mFeedTitleTv.setTextColor(-5723992);
        this.mFeedTitleTv.setBackgroundResource(2130848830);
        this.mQcircleBG.setImageDrawable(getResources().getDrawable(2130844227));
        label231:
        this.mPicContainer.setPadding(ViewUtils.a(5.0F), ViewUtils.a(5.0F), ViewUtils.a(5.0F), ViewUtils.a(5.0F));
        this.mPicView.removeAllViews();
        if (paramMQMsg.msgType != 12) {
          break label876;
        }
        localObject = new MsgTitleView(this.mContext);
        ((MsgTitleView)localObject).setData(paramMQMsg, paramBoolean1);
        ((MsgTitleView)localObject).setMsgOnClickListener(this.msgOnClickListener);
        this.mPicView.addView((View)localObject);
        localObject = new View(this.mContext);
        if (!paramBoolean1) {
          break label868;
        }
        i = -15066598;
        label338:
        ((View)localObject).setBackgroundColor(i);
        this.mPicView.addView((View)localObject, new LinearLayout.LayoutParams(-1, 1));
        findViewById(2131371921).setVisibility(0);
        label373:
        this.msgPhotoView = new MsgPhotoView(this.mContext);
        this.msgPhotoView.setApp(this.app);
        localObject = this.msgPhotoView;
        if (this.mLastPos != paramInt) {
          break label1062;
        }
        paramBoolean2 = true;
        label416:
        ((MsgPhotoView)localObject).setData(paramBoolean2, paramMQMsg, paramBoolean1);
        this.msgPhotoView.setMsgOnClickListener(this.msgOnClickListener);
        this.mPicView.addView(this.msgPhotoView);
        this.mLastPos = paramInt;
        if (paramMQMsg.msgType != 12) {
          break label1068;
        }
        localObject = new MsgMoreViewV2(this.mContext, this.app);
        ((MsgMoreViewV2)localObject).setData(paramMQMsg, paramBoolean1);
        ((MsgMoreViewV2)localObject).setMsgOnClickListener(this.msgOnClickListener);
        this.mPicView.addView((View)localObject);
        this.mMoreContainer.setVisibility(8);
      }
      for (;;)
      {
        if ((!QQDailyUtils.a(paramMQMsg.expand)) || (!QQDailyUtils.a(paramMQMsg.pushTime))) {
          break label1164;
        }
        this.mQQDailyArkView.setVisibility(0);
        this.mQQDailyArkView.setDarkMode(paramBoolean1);
        paramMQMsg = paramMQMsg.expand;
        localObject = QQDailyUtils.a((String)paramMQMsg.get("metaData"));
        if (this.mQQDailyArkView.a()) {
          break;
        }
        this.mQQDailyArkView.a((String)paramMQMsg.get("appname"), (String)paramMQMsg.get("appview"), (String)paramMQMsg.get("appversion"), (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("MsgCardView", 1, "QQDailyArkView exposed");
        }
        ReportController.b(null, "dc00898", "", "", "0X800AC01", "0X800AC01", 0, 0, "", "", "", "");
        this.mQQDailyArkView.setExpReported(true);
        if (!(this.mContext instanceof QZoneMsgActivity)) {
          break;
        }
        ((QZoneMsgActivity)this.mContext).arkCollector.a(this.mQQDailyArkView.a);
        return;
        this.mDateTv.setVisibility(8);
        this.mTitleDes.setText(paramMQMsg.title);
        updateTimeText(paramMQMsg.pushTime * 1000L);
        this.mTitleContainer.setVisibility(0);
        break label117;
        label755:
        this.mTitleDes.setTextColor(-16777216);
        this.mDateTv.setTextColor(-16777216);
        this.mTitleTime.setTextColor(-5196865);
        this.mFeedsContainer.setBackgroundColor(-1);
        if (this.mFeedsLV != null) {
          this.mFeedsLV.setBackgroundColor(-1);
        }
        this.mPicContainer.setBackgroundResource(2130848876);
        this.mMoreContainer.setBackgroundResource(2130848876);
        this.mFeedTitleTv.setTextColor(-16578534);
        this.mFeedTitleTv.setBackgroundResource(2130848829);
        this.mQcircleBG.setImageDrawable(getResources().getDrawable(2130844228));
        break label231;
        label868:
        i = -1315339;
        break label338;
        label876:
        if (!paramBoolean2) {
          break label373;
        }
        localObject = new TextView(this.mContext);
        ((TextView)localObject).setPadding(ViewUtils.a(12.0F), 0, 0, 0);
        ((TextView)localObject).setGravity(16);
        ((TextView)localObject).setTextSize(17.0F);
        if (paramBoolean1)
        {
          i = -198683;
          label931:
          ((TextView)localObject).setTextColor(i);
          if ((paramMQMsg.msgType == 10) || (paramMQMsg.msgType == 11)) {
            ((TextView)localObject).setTypeface(Typeface.DEFAULT_BOLD);
          }
          ((TextView)localObject).setText(paramMQMsg.title);
          this.mPicView.addView((View)localObject, new LinearLayout.LayoutParams(-1, ViewUtils.a(51.0F)));
          localObject = new View(this.mContext);
          if (!paramBoolean1) {
            break label1054;
          }
        }
        label1054:
        for (i = -15066598;; i = -1315339)
        {
          ((View)localObject).setBackgroundColor(i);
          this.mPicView.addView((View)localObject, new LinearLayout.LayoutParams(-1, 1));
          break;
          i = -16578534;
          break label931;
        }
        label1062:
        paramBoolean2 = false;
        break label416;
        label1068:
        if ((paramMQMsg.bottomCell != null) && (paramMQMsg.bottomCell.userAvatar != null) && (paramMQMsg.bottomCell.userAvatar.size() > 0))
        {
          this.mMoreView.removeAllViews();
          localObject = new MsgMoreView(this.mContext);
          ((MsgMoreView)localObject).setData(paramMQMsg, paramBoolean1);
          ((MsgMoreView)localObject).setMsgOnClickListener(this.msgOnClickListener);
          this.mMoreView.setVisibility(0);
          this.mMoreView.addView((View)localObject);
        }
        else
        {
          this.mMoreContainer.setVisibility(8);
        }
      }
    }
  }
  
  public void setMsgOnClickListener(MsgOnClickListener paramMsgOnClickListener)
  {
    this.msgOnClickListener = paramMsgOnClickListener;
  }
  
  public void startPlay()
  {
    BaseMsgView localBaseMsgView = getFirstChild();
    if ((localBaseMsgView == null) || (!localBaseMsgView.isLargePhoto())) {
      return;
    }
    localBaseMsgView.startPlay();
  }
  
  public void stopPlay()
  {
    BaseMsgView localBaseMsgView = getFirstChild();
    if ((localBaseMsgView == null) || (!localBaseMsgView.isLargePhoto())) {
      return;
    }
    localBaseMsgView.stopPlay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgCardView
 * JD-Core Version:    0.7.0.1
 */