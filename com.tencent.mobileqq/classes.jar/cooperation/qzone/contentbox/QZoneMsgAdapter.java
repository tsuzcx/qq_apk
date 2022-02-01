package cooperation.qzone.contentbox;

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
import cooperation.qzone.contentbox.model.MsgOnClickListener;
import java.util.ArrayList;
import java.util.Iterator;

public class QZoneMsgAdapter
  extends BaseAdapter
{
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
    int j = 0;
    int i;
    if (paramView == null)
    {
      paramView = new MsgCardView(this.mActivity, this.mActivity.app);
      paramView.setMsgOnClickListener(this.msgOnClickListener);
      paramView.setData(paramInt, (MQMsg)getItem(paramInt), this.isNightMode, this.mUseNewUI);
      if ((paramInt != 0) || (this.mFeedHolder == null)) {
        break label228;
      }
      boolean bool = this.mFeedHolder.addFeedViewToGroup(((MsgCardView)paramView).getFeedsContainer(), (MQMsg)getItem(paramInt));
      Object localObject = ((MsgCardView)paramView).getFeedTitleTv();
      if (!bool) {
        break label214;
      }
      i = 0;
      label109:
      ((TextView)localObject).setVisibility(i);
      localObject = ((MsgCardView)paramView).getFeedsContainer();
      if (!bool) {
        break label221;
      }
      i = j;
      label134:
      ((LinearLayout)localObject).setVisibility(i);
    }
    for (;;)
    {
      if (this.onGetViewLinstener != null) {
        this.onGetViewLinstener.onGetView(paramInt, paramView, paramViewGroup);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      ((MsgCardView)paramView).setMsgOnClickListener(this.msgOnClickListener);
      ((MsgCardView)paramView).setData(paramInt, (MQMsg)getItem(paramInt), this.isNightMode, this.mUseNewUI);
      break;
      label214:
      i = 8;
      break label109;
      label221:
      i = 8;
      break label134;
      label228:
      ((MsgCardView)paramView).getFeedTitleTv().setVisibility(8);
      ((MsgCardView)paramView).getFeedsContainer().setVisibility(8);
    }
  }
  
  public boolean removeLastEmptyMQMsg()
  {
    MQMsg localMQMsg = getLastMQMsg();
    if ((localMQMsg.msgBody.photolist == null) || (localMQMsg.msgBody.photolist.isEmpty()))
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
  
  public void setMQMsgs(ArrayList<MQMsg> paramArrayList)
  {
    if (this.mFeedHolder != null) {
      this.mFeedHolder.clearCache();
    }
    if (paramArrayList != null)
    {
      this.MQMsgs.clear();
      this.MQMsgs.addAll(paramArrayList);
      notifyDataSetChanged();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgAdapter
 * JD-Core Version:    0.7.0.1
 */