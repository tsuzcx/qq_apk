package cooperation.qzone.contentbox;

import NS_QZONE_MQMSG.PostBar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.api.FeedViewHolderInterface;
import cooperation.qzone.contentbox.model.MQLikeCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgBody;
import cooperation.qzone.contentbox.model.MQMsgInteractData;
import cooperation.qzone.contentbox.model.MsgNewGuideCardView;
import cooperation.qzone.contentbox.model.MsgOnClickListener;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class QZoneMsgAdapter
  extends BaseAdapter
{
  public static final int FROM_DB = 2;
  public static final int FROM_PRELOAD = 1;
  public static final int FROM_REFRESH = 0;
  public static final int[] MSG_CARD_TYPE = { 0, 1, 2, 3 };
  public static final int TYPE_NEW_GUIDE = 3;
  public static final int TYPE_NEW_LARGE = 1;
  public static final int TYPE_NEW_SMALL = 2;
  public static final int TYPE_NORMAL = 0;
  private ArrayList<MQMsg> MQMsgs = new ArrayList();
  private boolean isNightMode;
  private BaseActivity mActivity;
  private FeedViewHolderInterface mFeedHolder;
  private boolean mShowFeeds;
  private boolean mUseNewUI;
  private MsgOnClickListener msgOnClickListener;
  private QZoneMsgAdapter.OnGetViewLinstener onGetViewLinstener;
  
  public QZoneMsgAdapter(BaseActivity paramBaseActivity)
  {
    this.mActivity = paramBaseActivity;
  }
  
  private void reportExpose(MQMsg paramMQMsg, int paramInt)
  {
    LpReportInfo_dc02880 localLpReportInfo_dc028801;
    if ((paramMQMsg != null) && (paramInt == 0))
    {
      if (!paramMQMsg.isRecommGuideCard()) {
        break label65;
      }
      LpReportInfo_dc02880 localLpReportInfo_dc028802 = new LpReportInfo_dc02880(9, 1);
      localLpReportInfo_dc028801 = localLpReportInfo_dc028802;
      if (paramMQMsg.postGuide != null)
      {
        localLpReportInfo_dc028802.reserves8 = String.valueOf(paramMQMsg.postGuide.leadType);
        localLpReportInfo_dc028801 = localLpReportInfo_dc028802;
      }
    }
    for (;;)
    {
      LpReportManager.getInstance().reportToDC02880(localLpReportInfo_dc028801, false, true);
      return;
      label65:
      localLpReportInfo_dc028801 = new LpReportInfo_dc02880(8, 1, null, paramMQMsg.reportValue);
      localLpReportInfo_dc028801.reserves6 = paramMQMsg.getReportRev6();
      if ((paramMQMsg.expand != null) && (paramMQMsg.expand.containsKey("feedid"))) {
        localLpReportInfo_dc028801.reserves3 = ((String)paramMQMsg.expand.get("feedid"));
      }
    }
  }
  
  public void addMQMsgs(ArrayList<MQMsg> paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.MQMsgs.addAll(paramArrayList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.MQMsgs.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.MQMsgs == null) || (paramInt < 0) || (paramInt >= this.MQMsgs.size())) {
      return null;
    }
    return this.MQMsgs.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    MQMsg localMQMsg = (MQMsg)getItem(paramInt);
    if (!localMQMsg.isNewStyleCard()) {
      return 0;
    }
    if (localMQMsg.isRecommGuideCard()) {
      return 3;
    }
    if (localMQMsg.isNewSmallCard()) {
      return 2;
    }
    return 1;
  }
  
  public MQMsg getLastMQMsg()
  {
    if (this.MQMsgs.isEmpty()) {
      return null;
    }
    Iterator localIterator = this.MQMsgs.iterator();
    Object localObject1 = null;
    if (localIterator.hasNext())
    {
      MQMsg localMQMsg = (MQMsg)localIterator.next();
      Object localObject2;
      if (localObject1 == null) {
        localObject2 = localMQMsg;
      }
      for (;;)
      {
        localObject1 = localObject2;
        break;
        localObject2 = localMQMsg;
        if (localObject1.pushTime > localMQMsg.pushTime) {
          localObject2 = localObject1;
        }
      }
    }
    return localObject1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int k = 0;
    int m = 0;
    int j = 0;
    int i = getItemViewType(paramInt);
    if (paramView == null) {
      switch (i)
      {
      default: 
        switch (i)
        {
        }
        break;
      }
    }
    for (;;)
    {
      if (this.onGetViewLinstener != null) {
        this.onGetViewLinstener.onGetView(paramInt, paramView, paramViewGroup);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = new MsgCardView(this.mActivity, this.mActivity.app);
      paramView.setMsgOnClickListener(this.msgOnClickListener);
      paramView.setData(paramInt, (MQMsg)getItem(paramInt), this.isNightMode, this.mUseNewUI);
      break;
      paramView = new MsgNewSmallCardView(this.mActivity, this.mActivity.app);
      paramView.setData((MQMsg)getItem(paramInt));
      paramView.setMsgOnClickListener(this.msgOnClickListener);
      break;
      paramView = new MsgNewLargeCardView(this.mActivity, this.mActivity.app);
      paramView.initDateRegion((MQMsg)getItem(paramInt), paramInt);
      paramView.setData((MQMsg)getItem(paramInt));
      paramView.setMsgOnClickListener(this.msgOnClickListener);
      break;
      paramView = new MsgNewGuideCardView(this.mActivity, this.mActivity.app);
      paramView.initDateRegion((MQMsg)getItem(paramInt), paramInt);
      paramView.setData((MQMsg)getItem(paramInt));
      paramView.setMsgOnClickListener(this.msgOnClickListener);
      break;
      switch (i)
      {
      }
      for (;;)
      {
        break;
        ((MsgCardView)paramView).setMsgOnClickListener(this.msgOnClickListener);
        ((MsgCardView)paramView).setData(paramInt, (MQMsg)getItem(paramInt), this.isNightMode, this.mUseNewUI);
        break;
        ((MsgNewSmallCardView)paramView).setMsgOnClickListener(this.msgOnClickListener);
        ((MsgNewSmallCardView)paramView).setData((MQMsg)getItem(paramInt));
        break;
        ((MsgNewLargeCardView)paramView).setMsgOnClickListener(this.msgOnClickListener);
        ((MsgNewLargeCardView)paramView).initDateRegion((MQMsg)getItem(paramInt), paramInt);
        ((MsgNewLargeCardView)paramView).setData((MQMsg)getItem(paramInt));
        break;
        ((MsgNewGuideCardView)paramView).setMsgOnClickListener(this.msgOnClickListener);
        ((MsgNewGuideCardView)paramView).initDateRegion((MQMsg)getItem(paramInt), paramInt);
        ((MsgNewGuideCardView)paramView).setData((MQMsg)getItem(paramInt));
      }
      boolean bool;
      Object localObject;
      if ((paramInt == 0) && (this.mFeedHolder != null))
      {
        bool = this.mFeedHolder.addFeedViewToGroup(((MsgCardView)paramView).getFeedsContainer(), (MQMsg)getItem(paramInt));
        localObject = ((MsgCardView)paramView).getFeedTitleTv();
        if (bool)
        {
          i = 0;
          label566:
          ((TextView)localObject).setVisibility(i);
          localObject = ((MsgCardView)paramView).getFeedsContainer();
          if (!bool) {
            break label608;
          }
        }
        label608:
        for (i = j;; i = 8)
        {
          ((LinearLayout)localObject).setVisibility(i);
          break;
          i = 8;
          break label566;
        }
      }
      ((MsgCardView)paramView).getFeedTitleTv().setVisibility(8);
      ((MsgCardView)paramView).getFeedsContainer().setVisibility(8);
      continue;
      if ((this.mFeedHolder != null) && (paramInt == getCount() - 1))
      {
        bool = this.mFeedHolder.addFeedViewToGroup(((MsgNewLargeCardView)paramView).getFeedsContainer(), (MQMsg)getItem(paramInt));
        localObject = ((MsgNewLargeCardView)paramView).getFeedTitleTv();
        if (bool)
        {
          i = 0;
          label702:
          ((TextView)localObject).setVisibility(i);
          localObject = ((MsgNewLargeCardView)paramView).getFeedsContainer();
          if (!bool) {
            break label744;
          }
        }
        label744:
        for (i = k;; i = 8)
        {
          ((LinearLayout)localObject).setVisibility(i);
          break;
          i = 8;
          break label702;
        }
      }
      ((MsgNewLargeCardView)paramView).getFeedTitleTv().setVisibility(8);
      ((MsgNewLargeCardView)paramView).getFeedsContainer().setVisibility(8);
      continue;
      if ((this.mFeedHolder != null) && (paramInt == getCount() - 1))
      {
        bool = this.mFeedHolder.addFeedViewToGroup(((MsgNewSmallCardView)paramView).getFeedsContainer(), (MQMsg)getItem(paramInt));
        localObject = ((MsgNewSmallCardView)paramView).getFeedTitleTv();
        if (bool)
        {
          i = 0;
          label838:
          ((TextView)localObject).setVisibility(i);
          localObject = ((MsgNewSmallCardView)paramView).getFeedsContainer();
          if (!bool) {
            break label880;
          }
        }
        label880:
        for (i = m;; i = 8)
        {
          ((LinearLayout)localObject).setVisibility(i);
          break;
          i = 8;
          break label838;
        }
      }
      ((MsgNewSmallCardView)paramView).getFeedTitleTv().setVisibility(8);
      ((MsgNewSmallCardView)paramView).getFeedsContainer().setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return MSG_CARD_TYPE.length;
  }
  
  public void removeFirstMQMsg()
  {
    if ((this.MQMsgs != null) && (!this.MQMsgs.isEmpty())) {
      this.MQMsgs.remove(0);
    }
  }
  
  public boolean removeLastEmptyMQMsg()
  {
    MQMsg localMQMsg = getLastMQMsg();
    if ((localMQMsg == null) || (localMQMsg.msgBody == null) || (localMQMsg.msgBody.photolist == null) || (localMQMsg.msgBody.photolist.isEmpty()))
    {
      boolean bool = this.MQMsgs.remove(localMQMsg);
      if ((bool) && (this.mFeedHolder != null)) {
        this.mFeedHolder.clearCache();
      }
      return bool;
    }
    return false;
  }
  
  public void setFeedHolder(FeedViewHolderInterface paramFeedViewHolderInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mFeedHolder = paramFeedViewHolderInterface;
    this.mShowFeeds = paramBoolean1;
    this.mUseNewUI = paramBoolean2;
  }
  
  public void setMQMsgs(ArrayList<MQMsg> paramArrayList, int paramInt)
  {
    if (this.mFeedHolder != null) {
      this.mFeedHolder.clearCache();
    }
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.MQMsgs.clear();
      this.MQMsgs.addAll(paramArrayList);
      notifyDataSetChanged();
      reportExpose((MQMsg)paramArrayList.get(0), paramInt);
      return;
    }
    this.MQMsgs.clear();
    notifyDataSetChanged();
  }
  
  public void setMsgOnClickListener(MsgOnClickListener paramMsgOnClickListener)
  {
    this.msgOnClickListener = paramMsgOnClickListener;
  }
  
  public void setNightMode(boolean paramBoolean)
  {
    this.isNightMode = paramBoolean;
  }
  
  public void setOnGetViewLinstener(QZoneMsgAdapter.OnGetViewLinstener paramOnGetViewLinstener)
  {
    this.onGetViewLinstener = paramOnGetViewLinstener;
  }
  
  public void updateLike(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = this.MQMsgs.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (MQMsg)localIterator.next();
      if ((localObject != null) && (((MQMsg)localObject).pushTime == paramLong) && (((MQMsg)localObject).msgInteractData != null) && (((MQMsg)localObject).msgInteractData.likeCell != null) && (((MQMsg)localObject).msgInteractData.likeCell.liked != paramBoolean))
      {
        ((MQMsg)localObject).msgInteractData.likeCell.liked = paramBoolean;
        if (paramBoolean)
        {
          localObject = ((MQMsg)localObject).msgInteractData.likeCell;
          ((MQLikeCell)localObject).totalLike += 1;
        }
        else
        {
          localObject = ((MQMsg)localObject).msgInteractData.likeCell;
          ((MQLikeCell)localObject).totalLike -= 1;
        }
      }
    }
    notifyDataSetChanged();
  }
  
  public void updateMQMsgs(MQMsg paramMQMsg)
  {
    int i;
    MQMsg localMQMsg;
    if ((this.MQMsgs != null) && (paramMQMsg != null))
    {
      i = 0;
      if (i >= this.MQMsgs.size()) {
        break label131;
      }
      localMQMsg = (MQMsg)this.MQMsgs.get(i);
      if ((localMQMsg == null) || (localMQMsg.pushTime != paramMQMsg.pushTime)) {
        break label86;
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        this.MQMsgs.add(0, paramMQMsg);
        if (this.mFeedHolder != null) {
          this.mFeedHolder.clearCache();
        }
      }
      for (;;)
      {
        notifyDataSetChanged();
        return;
        label86:
        i += 1;
        break;
        if (paramMQMsg != localMQMsg)
        {
          this.MQMsgs.set(i, paramMQMsg);
          if ((i == 0) && (this.mFeedHolder != null)) {
            this.mFeedHolder.clearCache();
          }
        }
      }
      label131:
      localMQMsg = null;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgAdapter
 * JD-Core Version:    0.7.0.1
 */