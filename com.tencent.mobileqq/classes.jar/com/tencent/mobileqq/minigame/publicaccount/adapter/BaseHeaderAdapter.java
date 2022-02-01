package com.tencent.mobileqq.minigame.publicaccount.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.minigame.publicaccount.model.QQGameMsgInfo;
import com.tencent.mobileqq.minigame.publicaccount.view.GameArkView;
import com.tencent.mobileqq.minigame.publicaccount.view.IHeaderView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class BaseHeaderAdapter
  extends PagerAdapter
{
  private static final String TAG = "BaseHeaderAdapter";
  protected Activity mActivity;
  private final List<String> mArkAppNameList = new ArrayList();
  private List<Boolean> mArkInited = new ArrayList();
  protected final List<IHeaderView> mHeaderRecords = new ArrayList();
  protected List<QQGameMsgInfo> mMsgInfoList;
  
  public BaseHeaderAdapter(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  @Nullable
  private static IHeaderView createHeader(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      if (paramQQGameMsgInfo != null) {
        try
        {
          if (paramQQGameMsgInfo.msgType == 1)
          {
            paramQQGameMsgInfo = new GameArkView(paramActivity, null);
            return paramQQGameMsgInfo;
          }
        }
        catch (Throwable paramQQGameMsgInfo)
        {
          paramActivity = new StringBuilder();
          paramActivity.append("decode header(web) faile:");
          paramActivity.append(paramQQGameMsgInfo.getMessage());
          QLog.d("BaseHeaderAdapter", 4, paramActivity.toString());
        }
      }
      return null;
    }
    QLog.d("BaseHeaderAdapter", 4, "createHeader fail activity is null");
    return null;
  }
  
  protected View createEmptyView()
  {
    View localView = LayoutInflater.from(this.mActivity).inflate(2131624902, null, false);
    ((ImageView)localView.findViewById(2131432508)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    return localView;
  }
  
  public int getCount()
  {
    List localList = this.mMsgInfoList;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    return Math.min(i, this.mHeaderRecords.size());
  }
  
  public IHeaderView getHeaderView(int paramInt)
  {
    if (paramInt < this.mHeaderRecords.size()) {
      return (IHeaderView)this.mHeaderRecords.get(paramInt);
    }
    return null;
  }
  
  public void initArk(int paramInt)
  {
    if ((paramInt < this.mMsgInfoList.size()) && (paramInt >= 0) && (paramInt < this.mArkInited.size()))
    {
      if (paramInt >= this.mHeaderRecords.size()) {
        return;
      }
      if (((Boolean)this.mArkInited.get(paramInt)).booleanValue()) {
        return;
      }
      QQGameMsgInfo localQQGameMsgInfo2 = (QQGameMsgInfo)this.mMsgInfoList.get(paramInt);
      IHeaderView localIHeaderView = (IHeaderView)this.mHeaderRecords.get(paramInt);
      QQGameMsgInfo localQQGameMsgInfo1 = localQQGameMsgInfo2;
      if (localQQGameMsgInfo2 == null) {
        localQQGameMsgInfo1 = new QQGameMsgInfo();
      }
      if (localIHeaderView != null) {
        localIHeaderView.init(localQQGameMsgInfo1, this.mActivity, paramInt, "");
      }
      this.mArkInited.set(paramInt, Boolean.valueOf(true));
    }
  }
  
  public void onDestroy()
  {
    int i = 0;
    for (;;)
    {
      Object localObject;
      try
      {
        if (i < this.mHeaderRecords.size())
        {
          if (!(this.mHeaderRecords.get(i) instanceof GameArkView)) {
            break label198;
          }
          ((GameArkView)this.mHeaderRecords.get(i)).destory();
          if (!QLog.isColorLevel()) {
            break label198;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("header destroy i=");
          localStringBuilder.append(i);
          QLog.d("BaseHeaderAdapter", 2, localStringBuilder.toString());
          break label198;
        }
        this.mHeaderRecords.clear();
      }
      catch (Throwable localThrowable)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("header destroy error=");
        ((StringBuilder)localObject).append(localThrowable.toString());
        QLog.e("BaseHeaderAdapter", 1, ((StringBuilder)localObject).toString());
      }
      Iterator localIterator = this.mArkAppNameList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).removeNotify((String)localObject);
      }
      ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).unRegistVolumnReceiver(new String[0]);
      return;
      label198:
      i += 1;
    }
  }
  
  public void onDestroyView()
  {
    ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).unRegistVolumnReceiver(this.mArkAppNameList);
  }
  
  public void onPause()
  {
    IHeaderView localIHeaderView = getHeaderView(0);
    if (localIHeaderView != null) {
      localIHeaderView.onPause();
    }
  }
  
  public void onResume()
  {
    IHeaderView localIHeaderView = getHeaderView(0);
    if (localIHeaderView != null) {
      localIHeaderView.onResume();
    }
  }
  
  public void setData(List<QQGameMsgInfo> paramList)
  {
    this.mMsgInfoList = paramList;
    this.mArkInited = new ArrayList(Collections.nCopies(paramList.size(), Boolean.valueOf(false)));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)paramList.next();
      IHeaderView localIHeaderView = createHeader(localQQGameMsgInfo, this.mActivity);
      if (localIHeaderView != null)
      {
        this.mHeaderRecords.add(localIHeaderView);
        if (!TextUtils.isEmpty(localQQGameMsgInfo.arkAppName))
        {
          ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify(localQQGameMsgInfo.arkAppName);
          this.mArkAppNameList.add(localQQGameMsgInfo.arkAppName);
        }
      }
    }
    ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).registVolumnReceiver(this.mArkAppNameList);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.adapter.BaseHeaderAdapter
 * JD-Core Version:    0.7.0.1
 */