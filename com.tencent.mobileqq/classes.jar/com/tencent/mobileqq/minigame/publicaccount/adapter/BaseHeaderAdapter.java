package com.tencent.mobileqq.minigame.publicaccount.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.qwallet.utils.ArkPubicEventWrap;
import com.tencent.mobileqq.minigame.publicaccount.model.QQGameMsgInfo;
import com.tencent.mobileqq.minigame.publicaccount.view.GameArkView;
import com.tencent.mobileqq.minigame.publicaccount.view.IHeaderView;
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
          QLog.d("BaseHeaderAdapter", 4, "decode header(web) faile:" + paramQQGameMsgInfo.getMessage());
        }
      }
      return null;
    }
    QLog.d("BaseHeaderAdapter", 4, "createHeader fail activity is null");
    return null;
  }
  
  protected View createEmptyView()
  {
    View localView = LayoutInflater.from(this.mActivity).inflate(2131559275, null, false);
    ((ImageView)localView.findViewById(2131366332)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    return localView;
  }
  
  public int getCount()
  {
    if (this.mMsgInfoList == null) {}
    for (int i = 0;; i = this.mMsgInfoList.size()) {
      return Math.min(i, this.mHeaderRecords.size());
    }
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
    if ((paramInt >= this.mMsgInfoList.size()) || (paramInt < 0) || (paramInt >= this.mArkInited.size()) || (paramInt >= this.mHeaderRecords.size())) {}
    while (((Boolean)this.mArkInited.get(paramInt)).booleanValue()) {
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
  
  public void onDestroy()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.mHeaderRecords.size())
        {
          if (!(this.mHeaderRecords.get(i) instanceof GameArkView)) {
            break label172;
          }
          ((GameArkView)this.mHeaderRecords.get(i)).destory();
          if (!QLog.isColorLevel()) {
            break label172;
          }
          QLog.d("BaseHeaderAdapter", 2, "header destroy i=" + i);
          break label172;
        }
        this.mHeaderRecords.clear();
      }
      catch (Throwable localThrowable)
      {
        Iterator localIterator;
        String str;
        QLog.e("BaseHeaderAdapter", 1, "header destroy error=" + localThrowable.toString());
        continue;
        ArkPubicEventWrap.a().a(new String[0]);
        return;
      }
      localIterator = this.mArkAppNameList.iterator();
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        ArkPubicEventWrap.a().b(str);
      }
      else
      {
        label172:
        i += 1;
      }
    }
  }
  
  public void onDestroyView()
  {
    ArkPubicEventWrap.a().b(this.mArkAppNameList);
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
          ArkPubicEventWrap.a().a(localQQGameMsgInfo.arkAppName);
          this.mArkAppNameList.add(localQQGameMsgInfo.arkAppName);
        }
      }
    }
    ArkPubicEventWrap.a().a(this.mArkAppNameList);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.adapter.BaseHeaderAdapter
 * JD-Core Version:    0.7.0.1
 */