package cooperation.qzone.contentbox;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anvx;
import aoyr;
import aoza;
import bdla;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.qqdaily.QQDailyArkView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import cooperation.qzone.contentbox.model.MQBottomCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MsgOnClickListener;
import cooperation.qzone.widget.RoundCornerLinearLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class MsgCardView
  extends LinearLayout
{
  private static final int CARD_RADIUS = ViewUtils.dpToPx(8.0F);
  private static final int HOUR_OF_ONE_DAY = 24;
  private static final int LARGE_PHOTO_HEIGHT;
  private static final int LIST_ITEM_MARGIN_BOTTOM;
  private static final int LIST_ITEM_MARGIN_TOP;
  private static final int LIST_MARGIN_LEFT;
  private static final int LIST_MARGIN_RIGHT;
  private static final int LIST_MARGIN_TOP = ViewUtils.dpToPx(35.0F);
  private static final int MAX_PAGE_ITEM = 9;
  private static final long ONE_HOUR = 3600000L;
  private static final String TAG = "MsgCardView";
  private QQAppInterface app;
  private Context mContext;
  private TextView mDateTv;
  private TextView mFeedTitleTv;
  private LinearLayout mFeedsContainer;
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
    LIST_MARGIN_LEFT = ViewUtils.dpToPx(12.0F);
    LIST_MARGIN_RIGHT = ViewUtils.dpToPx(12.0F);
    LIST_ITEM_MARGIN_TOP = ViewUtils.dpToPx(10.0F);
    LIST_ITEM_MARGIN_BOTTOM = ViewUtils.dpToPx(18.0F);
    LARGE_PHOTO_HEIGHT = ViewUtils.dpToPx(230.0F);
  }
  
  public MsgCardView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.app = paramQQAppInterface;
    LayoutInflater.from(this.mContext).inflate(2131562415, this);
    this.mTitleContainer = ((RelativeLayout)findViewById(2131379040));
    this.mTitleTime = ((TextView)findViewById(2131379096));
    this.mTitleDes = ((TextView)findViewById(2131379042));
    this.mPicContainer = ((ViewGroup)findViewById(2131371610));
    this.mPicView = ((RoundCornerLinearLayout)findViewById(2131371609));
    this.mPicView.setRadius(CARD_RADIUS);
    this.mMoreView = ((RoundCornerLinearLayout)findViewById(2131371628));
    this.mMoreView.setRadius(CARD_RADIUS);
    this.mMoreContainer = ((FrameLayout)findViewById(2131371629));
    this.mFeedTitleTv = ((TextView)findViewById(2131371618));
    this.mFeedsContainer = ((LinearLayout)findViewById(2131371617));
    this.mDateTv = ((TextView)findViewById(2131371651));
    this.mQQDailyArkView = ((QQDailyArkView)findViewById(2131362971));
    this.mQcircleBG = ((ImageView)findViewById(2131371611));
  }
  
  private BaseMsgView getFirstChild()
  {
    return this.msgPhotoView;
  }
  
  private void updateTimeText(long paramLong)
  {
    long l = System.currentTimeMillis() - paramLong;
    if (l < 3600000L)
    {
      this.mTitleTime.setText(anvx.a(2131706415));
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
    label214:
    label356:
    label1132:
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
          break label738;
        }
        this.mTitleDes.setTextColor(-1);
        this.mDateTv.setTextColor(-1);
        this.mTitleTime.setTextColor(-11580352);
        this.mFeedsContainer.setBackgroundColor(-15263977);
        this.mPicContainer.setBackgroundResource(2130848499);
        this.mMoreContainer.setBackgroundResource(2130848499);
        this.mFeedTitleTv.setTextColor(-5723992);
        this.mFeedTitleTv.setBackgroundResource(2130848473);
        this.mQcircleBG.setImageDrawable(getResources().getDrawable(2130844046));
        this.mPicContainer.setPadding(ViewUtils.dip2px(5.0F), ViewUtils.dip2px(5.0F), ViewUtils.dip2px(5.0F), ViewUtils.dip2px(5.0F));
        this.mPicView.removeAllViews();
        if (paramMQMsg.msgType != 12) {
          break label844;
        }
        localObject = new MsgTitleView(this.mContext);
        ((MsgTitleView)localObject).setData(paramMQMsg, paramBoolean1);
        ((MsgTitleView)localObject).setMsgOnClickListener(this.msgOnClickListener);
        this.mPicView.addView((View)localObject);
        localObject = new View(this.mContext);
        if (!paramBoolean1) {
          break label836;
        }
        i = -15066598;
        ((View)localObject).setBackgroundColor(i);
        this.mPicView.addView((View)localObject, new LinearLayout.LayoutParams(-1, 1));
        findViewById(2131371611).setVisibility(0);
        this.msgPhotoView = new MsgPhotoView(this.mContext);
        this.msgPhotoView.setApp(this.app);
        localObject = this.msgPhotoView;
        if (this.mLastPos != paramInt) {
          break label1030;
        }
        paramBoolean2 = true;
        ((MsgPhotoView)localObject).setData(paramBoolean2, paramMQMsg, paramBoolean1);
        this.msgPhotoView.setMsgOnClickListener(this.msgOnClickListener);
        this.mPicView.addView(this.msgPhotoView);
        this.mLastPos = paramInt;
        if (paramMQMsg.msgType != 12) {
          break label1036;
        }
        localObject = new MsgMoreViewV2(this.mContext, this.app);
        ((MsgMoreViewV2)localObject).setData(paramMQMsg, paramBoolean1);
        ((MsgMoreViewV2)localObject).setMsgOnClickListener(this.msgOnClickListener);
        this.mPicView.addView((View)localObject);
        this.mMoreContainer.setVisibility(8);
      }
      for (;;)
      {
        if ((!aoza.a(paramMQMsg.expand)) || (!aoza.a(paramMQMsg.pushTime))) {
          break label1132;
        }
        this.mQQDailyArkView.setVisibility(0);
        this.mQQDailyArkView.setDarkMode(paramBoolean1);
        paramMQMsg = paramMQMsg.expand;
        localObject = aoza.a((String)paramMQMsg.get("metaData"));
        if (this.mQQDailyArkView.a()) {
          break;
        }
        this.mQQDailyArkView.a((String)paramMQMsg.get("appname"), (String)paramMQMsg.get("appview"), (String)paramMQMsg.get("appversion"), (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("MsgCardView", 1, "QQDailyArkView exposed");
        }
        bdla.b(null, "dc00898", "", "", "0X800AC01", "0X800AC01", 0, 0, "", "", "", "");
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
        this.mTitleDes.setTextColor(-16777216);
        this.mDateTv.setTextColor(-16777216);
        this.mTitleTime.setTextColor(-5196865);
        this.mFeedsContainer.setBackgroundColor(-1);
        this.mPicContainer.setBackgroundResource(2130848498);
        this.mMoreContainer.setBackgroundResource(2130848498);
        this.mFeedTitleTv.setTextColor(-16578534);
        this.mFeedTitleTv.setBackgroundResource(2130848472);
        this.mQcircleBG.setImageDrawable(getResources().getDrawable(2130844047));
        break label214;
        i = -1315339;
        break label321;
        if (!paramBoolean2) {
          break label356;
        }
        localObject = new TextView(this.mContext);
        ((TextView)localObject).setPadding(ViewUtils.dip2px(12.0F), 0, 0, 0);
        ((TextView)localObject).setGravity(16);
        ((TextView)localObject).setTextSize(17.0F);
        if (paramBoolean1)
        {
          i = -198683;
          ((TextView)localObject).setTextColor(i);
          if ((paramMQMsg.msgType == 10) || (paramMQMsg.msgType == 11)) {
            ((TextView)localObject).setTypeface(Typeface.DEFAULT_BOLD);
          }
          ((TextView)localObject).setText(paramMQMsg.title);
          this.mPicView.addView((View)localObject, new LinearLayout.LayoutParams(-1, ViewUtils.dip2px(51.0F)));
          localObject = new View(this.mContext);
          if (!paramBoolean1) {
            break label1022;
          }
        }
        label1022:
        for (i = -15066598;; i = -1315339)
        {
          ((View)localObject).setBackgroundColor(i);
          this.mPicView.addView((View)localObject, new LinearLayout.LayoutParams(-1, 1));
          break;
          i = -16578534;
          break label899;
        }
        paramBoolean2 = false;
        break label399;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgCardView
 * JD-Core Version:    0.7.0.1
 */