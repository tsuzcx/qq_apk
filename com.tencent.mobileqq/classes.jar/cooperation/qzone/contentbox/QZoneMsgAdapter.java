package cooperation.qzone.contentbox;

import NS_QZONE_MQMSG.PostBar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qzonehub.api.contentbox.IFeedViewHolderInterface;
import com.tencent.qzonehub.api.contentbox.IMQMsg;
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
  private ArrayList<IMQMsg> MQMsgs = new ArrayList();
  private boolean isNightMode;
  private BaseActivity mActivity;
  private IFeedViewHolderInterface mFeedHolder;
  private boolean mShowFeeds;
  private boolean mUseNewUI;
  private MsgOnClickListener msgOnClickListener;
  private QZoneMsgAdapter.OnGetViewLinstener onGetViewLinstener;
  
  public QZoneMsgAdapter(BaseActivity paramBaseActivity)
  {
    this.mActivity = paramBaseActivity;
  }
  
  private void reportExpose(ArrayList<IMQMsg> paramArrayList, int paramInt)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && (paramInt == 0))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        MQMsg localMQMsg = QZoneMsgManager.getMqMsg((IMQMsg)localIterator.next());
        if (localMQMsg != null)
        {
          LpReportInfo_dc02880 localLpReportInfo_dc02880;
          if (localMQMsg.isRecommGuideCard())
          {
            localLpReportInfo_dc02880 = new LpReportInfo_dc02880(9, 1);
            paramArrayList = localLpReportInfo_dc02880;
            if (localMQMsg.postGuide != null)
            {
              localLpReportInfo_dc02880.reserves8 = String.valueOf(localMQMsg.postGuide.leadType);
              paramArrayList = localLpReportInfo_dc02880;
            }
          }
          else
          {
            localLpReportInfo_dc02880 = new LpReportInfo_dc02880(8, 1, null, localMQMsg.reportValue);
            localLpReportInfo_dc02880.reserves6 = localMQMsg.getReportRev6();
            paramArrayList = localLpReportInfo_dc02880;
            if (localMQMsg.expand != null)
            {
              paramArrayList = localLpReportInfo_dc02880;
              if (localMQMsg.expand.containsKey("feedid"))
              {
                localLpReportInfo_dc02880.reserves3 = ((String)localMQMsg.expand.get("feedid"));
                paramArrayList = localLpReportInfo_dc02880;
              }
            }
          }
          LpReportManager.getInstance().reportToDC02880(paramArrayList, false, true);
        }
      }
    }
  }
  
  public void addMQMsgs(ArrayList<IMQMsg> paramArrayList)
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
    ArrayList localArrayList = this.MQMsgs;
    if ((localArrayList != null) && (paramInt >= 0) && (paramInt < localArrayList.size())) {
      return this.MQMsgs.get(paramInt);
    }
    return null;
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
    boolean bool = this.MQMsgs.isEmpty();
    MQMsg localMQMsg = null;
    if (bool) {
      return null;
    }
    Iterator localIterator = this.MQMsgs.iterator();
    while (localIterator.hasNext())
    {
      IMQMsg localIMQMsg = (IMQMsg)localIterator.next();
      if (localMQMsg == null) {
        localMQMsg = QZoneMsgManager.getMqMsg(localIMQMsg);
      } else if (localMQMsg.getPushTime() <= localIMQMsg.getPushTime()) {
        localMQMsg = QZoneMsgManager.getMqMsg(localIMQMsg);
      }
    }
    return localMQMsg;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (paramView == null)
    {
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3)
            {
              paramView = this.mActivity;
              paramView = new MsgNewGuideCardView(paramView, paramView.app);
              paramView.initDateRegion((MQMsg)getItem(paramInt), paramInt);
              paramView.setData((MQMsg)getItem(paramInt));
              paramView.setMsgOnClickListener(this.msgOnClickListener);
            }
          }
          else
          {
            paramView = this.mActivity;
            paramView = new MsgNewSmallCardView(paramView, paramView.app);
            paramView.setData((MQMsg)getItem(paramInt));
            paramView.setMsgOnClickListener(this.msgOnClickListener);
          }
        }
        else
        {
          paramView = this.mActivity;
          paramView = new MsgNewLargeCardView(paramView, paramView.app);
          paramView.initDateRegion((MQMsg)getItem(paramInt), paramInt);
          paramView.setData((MQMsg)getItem(paramInt));
          paramView.setMsgOnClickListener(this.msgOnClickListener);
        }
      }
      else
      {
        paramView = this.mActivity;
        paramView = new MsgCardView(paramView, paramView.app);
        paramView.setMsgOnClickListener(this.msgOnClickListener);
        paramView.setData(paramInt, (MQMsg)getItem(paramInt), this.isNightMode, this.mUseNewUI);
      }
    }
    else if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            localObject1 = (MsgNewGuideCardView)paramView;
            ((MsgNewGuideCardView)localObject1).setMsgOnClickListener(this.msgOnClickListener);
            ((MsgNewGuideCardView)localObject1).initDateRegion((MQMsg)getItem(paramInt), paramInt);
            ((MsgNewGuideCardView)localObject1).setData((MQMsg)getItem(paramInt));
          }
        }
        else
        {
          localObject1 = (MsgNewSmallCardView)paramView;
          ((MsgNewSmallCardView)localObject1).setMsgOnClickListener(this.msgOnClickListener);
          ((MsgNewSmallCardView)localObject1).setData((MQMsg)getItem(paramInt));
        }
      }
      else
      {
        localObject1 = (MsgNewLargeCardView)paramView;
        ((MsgNewLargeCardView)localObject1).setMsgOnClickListener(this.msgOnClickListener);
        ((MsgNewLargeCardView)localObject1).initDateRegion((MQMsg)getItem(paramInt), paramInt);
        ((MsgNewLargeCardView)localObject1).setData((MQMsg)getItem(paramInt));
      }
    }
    else
    {
      localObject1 = (MsgCardView)paramView;
      ((MsgCardView)localObject1).setMsgOnClickListener(this.msgOnClickListener);
      ((MsgCardView)localObject1).setData(paramInt, (MQMsg)getItem(paramInt), this.isNightMode, this.mUseNewUI);
    }
    int k = 0;
    int m = 0;
    int j = 0;
    Object localObject2;
    boolean bool;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          if ((this.mFeedHolder != null) && (paramInt == getCount() - 1))
          {
            localObject2 = this.mFeedHolder;
            localObject1 = (MsgNewSmallCardView)paramView;
            bool = ((IFeedViewHolderInterface)localObject2).addFeedViewToGroup(((MsgNewSmallCardView)localObject1).getFeedsContainer(), (MQMsg)getItem(paramInt));
            localObject2 = ((MsgNewSmallCardView)localObject1).getFeedTitleTv();
            if (bool) {
              i = 0;
            } else {
              i = 8;
            }
            ((TextView)localObject2).setVisibility(i);
            localObject1 = ((MsgNewSmallCardView)localObject1).getFeedsContainer();
            if (bool) {
              i = j;
            } else {
              i = 8;
            }
            ((LinearLayout)localObject1).setVisibility(i);
          }
          else
          {
            localObject1 = (MsgNewSmallCardView)paramView;
            ((MsgNewSmallCardView)localObject1).getFeedTitleTv().setVisibility(8);
            ((MsgNewSmallCardView)localObject1).getFeedsContainer().setVisibility(8);
          }
        }
      }
      else if ((this.mFeedHolder != null) && (paramInt == getCount() - 1))
      {
        localObject2 = this.mFeedHolder;
        localObject1 = (MsgNewLargeCardView)paramView;
        bool = ((IFeedViewHolderInterface)localObject2).addFeedViewToGroup(((MsgNewLargeCardView)localObject1).getFeedsContainer(), (MQMsg)getItem(paramInt));
        localObject2 = ((MsgNewLargeCardView)localObject1).getFeedTitleTv();
        if (bool) {
          i = 0;
        } else {
          i = 8;
        }
        ((TextView)localObject2).setVisibility(i);
        localObject1 = ((MsgNewLargeCardView)localObject1).getFeedsContainer();
        if (bool) {
          i = k;
        } else {
          i = 8;
        }
        ((LinearLayout)localObject1).setVisibility(i);
      }
      else
      {
        localObject1 = (MsgNewLargeCardView)paramView;
        ((MsgNewLargeCardView)localObject1).getFeedTitleTv().setVisibility(8);
        ((MsgNewLargeCardView)localObject1).getFeedsContainer().setVisibility(8);
      }
    }
    else
    {
      if (paramInt == 0)
      {
        localObject2 = this.mFeedHolder;
        if (localObject2 != null)
        {
          localObject1 = (MsgCardView)paramView;
          bool = ((IFeedViewHolderInterface)localObject2).addFeedViewToGroup(((MsgCardView)localObject1).getFeedsContainer(), (MQMsg)getItem(paramInt));
          localObject2 = ((MsgCardView)localObject1).getFeedTitleTv();
          if (bool) {
            i = 0;
          } else {
            i = 8;
          }
          ((TextView)localObject2).setVisibility(i);
          localObject1 = ((MsgCardView)localObject1).getFeedsContainer();
          if (bool) {
            i = m;
          } else {
            i = 8;
          }
          ((LinearLayout)localObject1).setVisibility(i);
          break label864;
        }
      }
      localObject1 = (MsgCardView)paramView;
      ((MsgCardView)localObject1).getFeedTitleTv().setVisibility(8);
      ((MsgCardView)localObject1).getFeedsContainer().setVisibility(8);
    }
    label864:
    Object localObject1 = this.onGetViewLinstener;
    if (localObject1 != null) {
      ((QZoneMsgAdapter.OnGetViewLinstener)localObject1).onGetView(paramInt, paramView, paramViewGroup);
    }
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return MSG_CARD_TYPE.length;
  }
  
  public void removeFirstMQMsg()
  {
    ArrayList localArrayList = this.MQMsgs;
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      this.MQMsgs.remove(0);
    }
  }
  
  public boolean removeLastEmptyMQMsg()
  {
    Object localObject = getLastMQMsg();
    if ((localObject != null) && (((MQMsg)localObject).msgBody != null) && (((MQMsg)localObject).msgBody.photolist != null) && (!((MQMsg)localObject).msgBody.photolist.isEmpty())) {
      return false;
    }
    boolean bool = this.MQMsgs.remove(localObject);
    if (bool)
    {
      localObject = this.mFeedHolder;
      if (localObject != null) {
        ((IFeedViewHolderInterface)localObject).clearCache();
      }
    }
    return bool;
  }
  
  public void setFeedHolder(IFeedViewHolderInterface paramIFeedViewHolderInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mFeedHolder = paramIFeedViewHolderInterface;
    this.mShowFeeds = paramBoolean1;
    this.mUseNewUI = paramBoolean2;
  }
  
  public void setMQMsgs(ArrayList<IMQMsg> paramArrayList, int paramInt)
  {
    IFeedViewHolderInterface localIFeedViewHolderInterface = this.mFeedHolder;
    if (localIFeedViewHolderInterface != null) {
      localIFeedViewHolderInterface.clearCache();
    }
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.MQMsgs.clear();
      this.MQMsgs.addAll(paramArrayList);
      notifyDataSetChanged();
      reportExpose(this.MQMsgs, paramInt);
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
      Object localObject = QZoneMsgManager.getMqMsg((IMQMsg)localIterator.next());
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
    if ((this.MQMsgs != null) && (paramMQMsg != null))
    {
      int k = -1;
      Object localObject2 = null;
      int i = 0;
      int j;
      Object localObject1;
      for (;;)
      {
        j = k;
        localObject1 = localObject2;
        if (i >= this.MQMsgs.size()) {
          break;
        }
        localObject1 = QZoneMsgManager.getMqMsg((IMQMsg)this.MQMsgs.get(i));
        if ((localObject1 != null) && (((MQMsg)localObject1).pushTime == paramMQMsg.pushTime))
        {
          j = i;
          break;
        }
        i += 1;
      }
      if (j < 0)
      {
        this.MQMsgs.add(0, paramMQMsg);
        paramMQMsg = this.mFeedHolder;
        if (paramMQMsg != null) {
          paramMQMsg.clearCache();
        }
      }
      else if (paramMQMsg != localObject1)
      {
        this.MQMsgs.set(j, paramMQMsg);
        if (j == 0)
        {
          paramMQMsg = this.mFeedHolder;
          if (paramMQMsg != null) {
            paramMQMsg.clearCache();
          }
        }
      }
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgAdapter
 * JD-Core Version:    0.7.0.1
 */