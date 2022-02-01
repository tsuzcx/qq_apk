package com.tencent.mobileqq.mini.share;

import alno;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import aoog;
import ascz;
import bhnv;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QuickSendProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class MiniShareQuicklySendPanelAdapter
  extends BaseAdapter
  implements View.OnClickListener, aoog
{
  private static final String TAG = "MiniShareQuicklySendPanelAdapter";
  private Activity activity;
  private MiniShareQuicklySendPanelAdapter.SendPanelViewHolder curShareViewHolder;
  private long decodeFaceStartTime;
  private Hashtable<String, Bitmap> faceCache = new Hashtable();
  private QQAppInterface mApp;
  protected alno mFaceDecoder;
  private XListView mListView;
  private Bundle mShareDataBundle;
  private ArrayList<MiniShareQuicklySendPanelAdapter.SendPanelData> sendPanelDataList;
  
  public MiniShareQuicklySendPanelAdapter(Activity paramActivity, QQAppInterface paramQQAppInterface, XListView paramXListView, Bundle paramBundle)
  {
    this.activity = paramActivity;
    this.mApp = paramQQAppInterface;
    this.mListView = paramXListView;
    this.mShareDataBundle = paramBundle;
    this.sendPanelDataList = new ArrayList();
    this.mFaceDecoder = new alno(paramQQAppInterface, this, false);
  }
  
  public static Drawable getIconDrawable(String paramString, int paramInt1, int paramInt2)
  {
    ascz localascz = new ascz(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localascz, localascz);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniShareQuicklySendPanelAdapter", 2, "getIconDrawable Exception, coverUrl=" + paramString, localException);
        }
      }
    }
    return localascz;
  }
  
  private void updateItem(MiniShareQuicklySendPanelAdapter.SendPanelViewHolder paramSendPanelViewHolder, MiniShareQuicklySendPanelAdapter.SendPanelData paramSendPanelData, Drawable paramDrawable)
  {
    if ((paramSendPanelViewHolder == null) || (paramSendPanelData == null)) {
      return;
    }
    Drawable localDrawable = paramDrawable;
    int i;
    if (paramDrawable == null)
    {
      i = paramSendPanelData.baseData.getRecentUserType();
      if ((!(paramSendPanelData.baseData instanceof RecentCallItem)) || (!((RecentCallItem)paramSendPanelData.baseData).a())) {
        break label79;
      }
      i = 3002;
    }
    label79:
    for (;;)
    {
      localDrawable = this.mFaceDecoder.a(i, paramSendPanelData.baseData.getRecentUserUin());
      bindData(paramSendPanelViewHolder, localDrawable);
      return;
    }
  }
  
  private MiniShareQuicklySendPanelAdapter.SendPanelData updateStatus(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.sendPanelDataList != null) && (this.sendPanelDataList.size() > 0))
    {
      Iterator localIterator = this.sendPanelDataList.iterator();
      while (localIterator.hasNext())
      {
        MiniShareQuicklySendPanelAdapter.SendPanelData localSendPanelData = (MiniShareQuicklySendPanelAdapter.SendPanelData)localIterator.next();
        if ((!TextUtils.isEmpty(localSendPanelData.baseData.getRecentUserUin())) && (paramString.equals(localSendPanelData.baseData.getRecentUserUin())))
        {
          localSendPanelData.operateStatus = paramInt;
          return localSendPanelData;
        }
      }
    }
    return null;
  }
  
  private void updateStatusView(MiniShareQuicklySendPanelAdapter.SendPanelViewHolder paramSendPanelViewHolder)
  {
    if ((paramSendPanelViewHolder == null) || (paramSendPanelViewHolder.itemInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniShareQuicklySendPanelAdapter", 2, "updateStatusView fail");
      }
      return;
    }
    QLog.d("MiniShareQuicklySendPanelAdapter", 2, "updateStatusView");
    paramSendPanelViewHolder.operateView.setStatus(paramSendPanelViewHolder.itemInfo.operateStatus);
  }
  
  public void bindData(MiniShareQuicklySendPanelAdapter.SendPanelViewHolder paramSendPanelViewHolder, Drawable paramDrawable)
  {
    boolean bool = true;
    if ((paramSendPanelViewHolder == null) || (paramSendPanelViewHolder.itemInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniShareQuicklySendPanelAdapter", 2, "bindData fail viewHolder");
      }
      return;
    }
    MiniShareQuicklySendPanelAdapter.SendPanelData localSendPanelData = paramSendPanelViewHolder.itemInfo;
    RecentDynamicAvatarView localRecentDynamicAvatarView = null;
    if (paramDrawable == null)
    {
      paramDrawable = localRecentDynamicAvatarView;
      if (this.mFaceDecoder != null) {
        paramDrawable = this.mFaceDecoder.a(localSendPanelData.baseData);
      }
      if (!needDynamic(localSendPanelData.baseData)) {
        break label260;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MiniShareQuicklySendPanelAdapter", 2, "bindview user:" + localSendPanelData.baseData.getRecentUserUin());
      }
      int j = ((Integer)alno.a(this.mApp, localSendPanelData.baseData.getRecentUserType(), localSendPanelData.baseData.getRecentUserUin()).first).intValue();
      int i = j;
      if (j == 103) {
        i = 1;
      }
      localRecentDynamicAvatarView = paramSendPanelViewHolder.iconView;
      QQAppInterface localQQAppInterface = this.mApp;
      String str = localSendPanelData.baseData.getRecentUserUin();
      if (this.mApp.a.a() != 1) {
        break label254;
      }
      label197:
      localRecentDynamicAvatarView.setFaceDrawable(localQQAppInterface, paramDrawable, i, str, 100, false, bool, 0);
    }
    for (;;)
    {
      paramSendPanelViewHolder.nameText.setText(localSendPanelData.baseData.getTitleName());
      paramSendPanelViewHolder.operateView.setTag(paramSendPanelViewHolder);
      paramSendPanelViewHolder.operateView.setOnClickListener(this);
      updateStatusView(paramSendPanelViewHolder);
      return;
      break;
      label254:
      bool = false;
      break label197;
      label260:
      paramSendPanelViewHolder.iconView.setImageDrawable(paramDrawable);
    }
  }
  
  public int getCount()
  {
    if (this.sendPanelDataList != null) {
      return this.sendPanelDataList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.sendPanelDataList != null) {
      return (MiniShareQuicklySendPanelAdapter.SendPanelData)this.sendPanelDataList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if ((this.sendPanelDataList != null) && (paramInt < this.sendPanelDataList.size())) {
      try
      {
        long l = Long.parseLong(((MiniShareQuicklySendPanelAdapter.SendPanelData)this.sendPanelDataList.get(paramInt)).baseData.getRecentUserUin());
        return l;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniShareQuicklySendPanelAdapter", 2, "getItemId exception = " + localException.getMessage());
        }
      }
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MiniShareQuicklySendPanelAdapter.SendPanelData localSendPanelData = (MiniShareQuicklySendPanelAdapter.SendPanelData)getItem(paramInt);
    MiniShareQuicklySendPanelAdapter.SendPanelViewHolder localSendPanelViewHolder;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.activity).inflate(2131562920, null);
      localSendPanelViewHolder = new MiniShareQuicklySendPanelAdapter.SendPanelViewHolder(this);
      localSendPanelViewHolder.iconView = ((RecentDynamicAvatarView)paramView.findViewById(2131368212));
      localSendPanelViewHolder.nameText = ((TextView)paramView.findViewById(2131371647));
      localSendPanelViewHolder.operateView = ((QuickSendProgressView)paramView.findViewById(2131372125));
      localSendPanelViewHolder.itemInfo = localSendPanelData;
      bindData(localSendPanelViewHolder, null);
      paramView.setTag(localSendPanelViewHolder);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localSendPanelViewHolder = (MiniShareQuicklySendPanelAdapter.SendPanelViewHolder)paramView.getTag();
      localSendPanelViewHolder.itemInfo = localSendPanelData;
      bindData(localSendPanelViewHolder, null);
    }
  }
  
  protected boolean needDynamic(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.getRecentUserType();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023) || (i == 10008);
  }
  
  public void notifyShareCancel()
  {
    if (this.curShareViewHolder != null)
    {
      MiniShareQuicklySendPanelAdapter.SendPanelData localSendPanelData = updateStatus(this.curShareViewHolder.itemInfo.baseData.getRecentUserUin(), 0);
      if (localSendPanelData != null)
      {
        this.curShareViewHolder.itemInfo = localSendPanelData;
        updateStatusView(this.curShareViewHolder);
      }
      this.curShareViewHolder = null;
    }
  }
  
  public void notifyShareSuc()
  {
    if (this.curShareViewHolder != null)
    {
      MiniShareQuicklySendPanelAdapter.SendPanelData localSendPanelData = updateStatus(this.curShareViewHolder.itemInfo.baseData.getRecentUserUin(), 3);
      if (localSendPanelData != null)
      {
        this.curShareViewHolder.itemInfo = localSendPanelData;
        updateStatusView(this.curShareViewHolder);
      }
      this.curShareViewHolder = null;
    }
  }
  
  public void onClick(View paramView)
  {
    MiniShareQuicklySendPanelAdapter.SendPanelViewHolder localSendPanelViewHolder;
    if ((paramView.getTag() instanceof MiniShareQuicklySendPanelAdapter.SendPanelViewHolder))
    {
      localSendPanelViewHolder = (MiniShareQuicklySendPanelAdapter.SendPanelViewHolder)paramView.getTag();
      if (localSendPanelViewHolder.itemInfo != null) {
        break label48;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MiniShareQuicklySendPanelAdapter", 2, "onClick itemInfo is null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label48:
      if (QLog.isColorLevel()) {
        QLog.d("MiniShareQuicklySendPanelAdapter", 2, "onClick operateStatus = " + localSendPanelViewHolder.itemInfo.operateStatus);
      }
      switch (localSendPanelViewHolder.itemInfo.operateStatus)
      {
      case 1: 
      case 3: 
      default: 
        break;
      case 0: 
        if (!bhnv.g(this.activity))
        {
          QQToast.a(this.activity, this.activity.getString(2131718355), 0).a();
        }
        else
        {
          MiniShareQuicklySendPanelAdapter.SendPanelData localSendPanelData = updateStatus(localSendPanelViewHolder.itemInfo.baseData.getRecentUserUin(), 1);
          if (localSendPanelData != null)
          {
            localSendPanelViewHolder.itemInfo = localSendPanelData;
            updateStatusView(localSendPanelViewHolder);
            if (this.curShareViewHolder == null) {
              this.curShareViewHolder = localSendPanelViewHolder;
            }
          }
          MiniProgramShareUtils.shareToChatDirectly(this.activity, this.mShareDataBundle, localSendPanelViewHolder.itemInfo.baseData.getRecentUserType(), String.valueOf(localSendPanelViewHolder.itemInfo.baseData.getRecentUserUin()), localSendPanelViewHolder.itemInfo.baseData.getTitleName(), 678, false);
        }
        break;
      case 2: 
        if (!bhnv.g(this.activity)) {
          QQToast.a(this.activity, this.activity.getString(2131718355), 0).a();
        }
        break;
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String arg3, Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(???)) {}
    long l;
    for (;;)
    {
      return;
      if ((paramBitmap != null) || (paramInt1 <= 0))
      {
        if (paramBitmap != null) {}
        try
        {
          this.faceCache.put(paramInt2 + ":" + ???, paramBitmap);
          l = System.currentTimeMillis();
          if ((this.decodeFaceStartTime > 0L) && (l - this.decodeFaceStartTime > 300L))
          {
            paramInt2 = 1;
            if ((paramInt1 > 0) && (paramInt2 == 0)) {
              continue;
            }
            synchronized (this.faceCache)
            {
              if (this.faceCache.size() == 0) {
                return;
              }
            }
          }
        }
        catch (OutOfMemoryError ???)
        {
          for (;;)
          {
            System.gc();
            ???.printStackTrace();
            QLog.i("MiniShareQuicklySendPanelAdapter", 1, "onDecodeTaskCompleted error:" + ???.getMessage());
            continue;
            paramInt2 = 0;
          }
        }
      }
    }
    if (paramInt1 == 0) {}
    boolean bool;
    MiniShareQuicklySendPanelAdapter.SendPanelData localSendPanelData;
    for (this.decodeFaceStartTime = 0L;; this.decodeFaceStartTime = l)
    {
      paramInt2 = this.mListView.getChildCount();
      paramInt1 = 0;
      bool = false;
      if (paramInt1 >= paramInt2) {
        break label404;
      }
      paramBitmap = (MiniShareQuicklySendPanelAdapter.SendPanelViewHolder)this.mListView.getChildAt(paramInt1).getTag();
      if ((paramBitmap == null) || (paramBitmap.itemInfo == null)) {
        break label392;
      }
      i = paramBitmap.itemInfo.position;
      localSendPanelData = (MiniShareQuicklySendPanelAdapter.SendPanelData)this.sendPanelDataList.get(i);
      if (localSendPanelData != null) {
        break;
      }
      break label466;
    }
    int i = localSendPanelData.baseData.getRecentUserType();
    i = ((Integer)alno.a(this.mApp, i, localSendPanelData.baseData.getRecentUserUin()).first).intValue();
    if (i != -2147483648)
    {
      Object localObject = i + ":" + localSendPanelData.baseData.getRecentUserUin();
      localObject = (Bitmap)this.faceCache.get(localObject);
      if (localObject != null)
      {
        updateItem(paramBitmap, localSendPanelData, new BitmapDrawable(this.activity.getResources(), (Bitmap)localObject));
        bool = true;
        break label473;
        label392:
        QLog.e("MiniShareQuicklySendPanelAdapter", 1, "onDecodeTaskCompleted holder is null?!");
        break label466;
        label404:
        if (QLog.isDevelopLevel()) {
          QLog.i("MiniShareQuicklySendPanelAdapter", 4, "decodecomplete|faceCache size = " + this.faceCache.size() + ", isNeedUpdateAvatar=" + bool);
        }
        this.faceCache.clear();
        return;
      }
    }
    label466:
    label473:
    for (;;)
    {
      paramInt1 += 1;
      break;
    }
  }
  
  public void onDestroy()
  {
    if (this.mFaceDecoder != null) {
      this.mFaceDecoder.a();
    }
  }
  
  public void onUpdate(int paramInt, MiniShareQuicklySendPanelAdapter.SendPanelData paramSendPanelData)
  {
    if ((paramInt < 0) || (this.sendPanelDataList == null) || (paramInt > this.sendPanelDataList.size()) || (paramSendPanelData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniShareQuicklySendPanelAdapter", 2, "onUpdate return");
      }
      return;
    }
    this.sendPanelDataList.set(paramInt, paramSendPanelData);
  }
  
  public void setData(ArrayList<MiniShareQuicklySendPanelAdapter.SendPanelData> paramArrayList)
  {
    if (paramArrayList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MiniShareQuicklySendPanelAdapter", 2, "setData list is empty");
      }
    }
    do
    {
      return;
      if ((this.sendPanelDataList == null) || (!paramArrayList.isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MiniShareQuicklySendPanelAdapter", 2, "setData do not need refresh");
    return;
    this.sendPanelDataList = paramArrayList;
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniShareQuicklySendPanelAdapter
 * JD-Core Version:    0.7.0.1
 */