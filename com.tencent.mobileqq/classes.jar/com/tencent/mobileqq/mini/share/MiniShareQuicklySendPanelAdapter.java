package com.tencent.mobileqq.mini.share;

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
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QuickSendProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class MiniShareQuicklySendPanelAdapter
  extends BaseAdapter
  implements View.OnClickListener, DecodeTaskCompletionListener
{
  private static final String TAG = "MiniShareQuicklySendPanelAdapter";
  private Activity activity;
  private MiniShareQuicklySendPanelAdapter.SendPanelViewHolder curShareViewHolder = null;
  private long decodeFaceStartTime = 0L;
  private Hashtable<String, Bitmap> faceCache = new Hashtable();
  private QQAppInterface mApp;
  protected RecentFaceDecoder mFaceDecoder;
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
    this.mFaceDecoder = new RecentFaceDecoder(paramQQAppInterface, this, false);
  }
  
  public static Drawable getIconDrawable(String paramString, int paramInt1, int paramInt2)
  {
    EmptyDrawable localEmptyDrawable = new EmptyDrawable(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localEmptyDrawable, localEmptyDrawable);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getIconDrawable Exception, coverUrl=");
          localStringBuilder.append(paramString);
          QLog.e("MiniShareQuicklySendPanelAdapter", 2, localStringBuilder.toString(), localException);
        }
      }
    }
    return localEmptyDrawable;
  }
  
  private void updateItem(MiniShareQuicklySendPanelAdapter.SendPanelViewHolder paramSendPanelViewHolder, MiniShareQuicklySendPanelAdapter.SendPanelData paramSendPanelData, Drawable paramDrawable)
  {
    if (paramSendPanelViewHolder != null)
    {
      if (paramSendPanelData == null) {
        return;
      }
      Drawable localDrawable = paramDrawable;
      if (paramDrawable == null)
      {
        int j = paramSendPanelData.baseData.getRecentUserType();
        int i = j;
        if ((paramSendPanelData.baseData instanceof RecentCallItem))
        {
          i = j;
          if (((RecentCallItem)paramSendPanelData.baseData).a()) {
            i = 3002;
          }
        }
        localDrawable = this.mFaceDecoder.a(i, paramSendPanelData.baseData.getRecentUserUin());
      }
      bindData(paramSendPanelViewHolder, localDrawable);
    }
  }
  
  private MiniShareQuicklySendPanelAdapter.SendPanelData updateStatus(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = this.sendPanelDataList;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = this.sendPanelDataList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          MiniShareQuicklySendPanelAdapter.SendPanelData localSendPanelData = (MiniShareQuicklySendPanelAdapter.SendPanelData)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(localSendPanelData.baseData.getRecentUserUin())) && (paramString.equals(localSendPanelData.baseData.getRecentUserUin())))
          {
            localSendPanelData.operateStatus = paramInt;
            return localSendPanelData;
          }
        }
      }
    }
    return null;
  }
  
  private void updateStatusView(MiniShareQuicklySendPanelAdapter.SendPanelViewHolder paramSendPanelViewHolder)
  {
    if ((paramSendPanelViewHolder != null) && (paramSendPanelViewHolder.itemInfo != null))
    {
      QLog.d("MiniShareQuicklySendPanelAdapter", 2, "updateStatusView");
      paramSendPanelViewHolder.operateView.setStatus(paramSendPanelViewHolder.itemInfo.operateStatus);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniShareQuicklySendPanelAdapter", 2, "updateStatusView fail");
    }
  }
  
  public void bindData(MiniShareQuicklySendPanelAdapter.SendPanelViewHolder paramSendPanelViewHolder, Drawable paramDrawable)
  {
    if ((paramSendPanelViewHolder != null) && (paramSendPanelViewHolder.itemInfo != null))
    {
      MiniShareQuicklySendPanelAdapter.SendPanelData localSendPanelData = paramSendPanelViewHolder.itemInfo;
      Object localObject = paramDrawable;
      if (paramDrawable == null)
      {
        paramDrawable = this.mFaceDecoder;
        if (paramDrawable != null)
        {
          localObject = paramDrawable.a(localSendPanelData.baseData);
        }
        else
        {
          paramDrawable = null;
          break label58;
        }
      }
      paramDrawable = (Drawable)localObject;
      label58:
      if (needDynamic(localSendPanelData.baseData))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("bindview user:");
          ((StringBuilder)localObject).append(localSendPanelData.baseData.getRecentUserUin());
          QLog.d("MiniShareQuicklySendPanelAdapter", 2, ((StringBuilder)localObject).toString());
        }
        int i = ((Integer)RecentFaceDecoder.a(this.mApp, localSendPanelData.baseData.getRecentUserType(), localSendPanelData.baseData.getRecentUserUin()).first).intValue();
        if (i == 103) {
          i = 1;
        }
        localObject = paramSendPanelViewHolder.iconView;
        QQAppInterface localQQAppInterface = this.mApp;
        String str = localSendPanelData.baseData.getRecentUserUin();
        boolean bool;
        if (this.mApp.mAutomator.f() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((RecentDynamicAvatarView)localObject).setFaceDrawable(localQQAppInterface, paramDrawable, i, str, 100, false, bool, 0);
      }
      else
      {
        paramSendPanelViewHolder.iconView.setImageDrawable(paramDrawable);
      }
      paramSendPanelViewHolder.nameText.setText(localSendPanelData.baseData.getTitleName());
      paramSendPanelViewHolder.operateView.setTag(paramSendPanelViewHolder);
      paramSendPanelViewHolder.operateView.setOnClickListener(this);
      updateStatusView(paramSendPanelViewHolder);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniShareQuicklySendPanelAdapter", 2, "bindData fail viewHolder");
    }
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.sendPanelDataList;
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    ArrayList localArrayList = this.sendPanelDataList;
    if (localArrayList != null) {
      return localArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    ArrayList localArrayList = this.sendPanelDataList;
    if ((localArrayList != null) && (paramInt < localArrayList.size())) {
      try
      {
        long l = Long.parseLong(((MiniShareQuicklySendPanelAdapter.SendPanelData)this.sendPanelDataList.get(paramInt)).baseData.getRecentUserUin());
        return l;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getItemId exception = ");
          localStringBuilder.append(localException.getMessage());
          QLog.d("MiniShareQuicklySendPanelAdapter", 2, localStringBuilder.toString());
        }
      }
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (MiniShareQuicklySendPanelAdapter.SendPanelData)getItem(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.activity).inflate(2131629284, null);
      localSendPanelViewHolder = new MiniShareQuicklySendPanelAdapter.SendPanelViewHolder(this);
      localSendPanelViewHolder.iconView = ((RecentDynamicAvatarView)paramView.findViewById(2131435219));
      localSendPanelViewHolder.nameText = ((TextView)paramView.findViewById(2131439121));
      localSendPanelViewHolder.operateView = ((QuickSendProgressView)paramView.findViewById(2131439644));
      localSendPanelViewHolder.itemInfo = paramViewGroup;
      bindData(localSendPanelViewHolder, null);
      paramView.setTag(localSendPanelViewHolder);
      return paramView;
    }
    MiniShareQuicklySendPanelAdapter.SendPanelViewHolder localSendPanelViewHolder = (MiniShareQuicklySendPanelAdapter.SendPanelViewHolder)paramView.getTag();
    localSendPanelViewHolder.itemInfo = paramViewGroup;
    bindData(localSendPanelViewHolder, null);
    return paramView;
  }
  
  protected boolean needDynamic(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.getRecentUserType();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023) || (i == 10008);
  }
  
  public void notifyShareCancel()
  {
    Object localObject = this.curShareViewHolder;
    if (localObject != null)
    {
      localObject = updateStatus(((MiniShareQuicklySendPanelAdapter.SendPanelViewHolder)localObject).itemInfo.baseData.getRecentUserUin(), 0);
      if (localObject != null)
      {
        MiniShareQuicklySendPanelAdapter.SendPanelViewHolder localSendPanelViewHolder = this.curShareViewHolder;
        localSendPanelViewHolder.itemInfo = ((MiniShareQuicklySendPanelAdapter.SendPanelData)localObject);
        updateStatusView(localSendPanelViewHolder);
      }
      this.curShareViewHolder = null;
    }
  }
  
  public void notifyShareSuc()
  {
    Object localObject = this.curShareViewHolder;
    if (localObject != null)
    {
      localObject = updateStatus(((MiniShareQuicklySendPanelAdapter.SendPanelViewHolder)localObject).itemInfo.baseData.getRecentUserUin(), 3);
      if (localObject != null)
      {
        MiniShareQuicklySendPanelAdapter.SendPanelViewHolder localSendPanelViewHolder = this.curShareViewHolder;
        localSendPanelViewHolder.itemInfo = ((MiniShareQuicklySendPanelAdapter.SendPanelData)localObject);
        updateStatusView(localSendPanelViewHolder);
      }
      this.curShareViewHolder = null;
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof MiniShareQuicklySendPanelAdapter.SendPanelViewHolder))
    {
      paramView = (MiniShareQuicklySendPanelAdapter.SendPanelViewHolder)paramView.getTag();
      if (paramView.itemInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniShareQuicklySendPanelAdapter", 2, "onClick itemInfo is null");
        }
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClick operateStatus = ");
        ((StringBuilder)localObject).append(paramView.itemInfo.operateStatus);
        QLog.d("MiniShareQuicklySendPanelAdapter", 2, ((StringBuilder)localObject).toString());
      }
      int i = paramView.itemInfo.operateStatus;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          if (!NetworkUtil.isNetworkAvailable(this.activity))
          {
            paramView = this.activity;
            QQToast.makeText(paramView, paramView.getString(2131916792), 0).show();
          }
        }
      }
      else
      {
        if (!NetworkUtil.isNetworkAvailable(this.activity))
        {
          paramView = this.activity;
          QQToast.makeText(paramView, paramView.getString(2131916792), 0).show();
          return;
        }
        localObject = updateStatus(paramView.itemInfo.baseData.getRecentUserUin(), 1);
        if (localObject != null)
        {
          paramView.itemInfo = ((MiniShareQuicklySendPanelAdapter.SendPanelData)localObject);
          updateStatusView(paramView);
          if (this.curShareViewHolder == null) {
            this.curShareViewHolder = paramView;
          }
        }
        MiniProgramShareUtils.shareToChatDirectly(this.activity, this.mShareDataBundle, paramView.itemInfo.baseData.getRecentUserType(), String.valueOf(paramView.itemInfo.baseData.getRecentUserUin()), paramView.itemInfo.baseData.getTitleName(), 678, false);
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String arg3, Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(???)) {
      return;
    }
    if ((paramBitmap == null) && (paramInt1 > 0)) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (paramBitmap != null) {
      try
      {
        localObject1 = this.faceCache;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramInt2);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append(???);
        ((Hashtable)localObject1).put(((StringBuilder)localObject2).toString(), paramBitmap);
      }
      catch (OutOfMemoryError ???)
      {
        System.gc();
        ???.printStackTrace();
        paramBitmap = new StringBuilder();
        paramBitmap.append("onDecodeTaskCompleted error:");
        paramBitmap.append(???.getMessage());
        QLog.i("MiniShareQuicklySendPanelAdapter", 1, paramBitmap.toString());
      }
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.decodeFaceStartTime;
    int i = 0;
    if ((l2 > 0L) && (l1 - l2 > 300L)) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if ((paramInt1 > 0) && (paramInt2 == 0)) {
      return;
    }
    boolean bool1;
    boolean bool2;
    synchronized (this.faceCache)
    {
      if (this.faceCache.size() == 0) {
        return;
      }
      if (paramInt1 == 0) {
        this.decodeFaceStartTime = 0L;
      } else {
        this.decodeFaceStartTime = l1;
      }
      paramInt2 = this.mListView.getChildCount();
      bool1 = false;
      paramInt1 = i;
      if (paramInt1 < paramInt2)
      {
        paramBitmap = (MiniShareQuicklySendPanelAdapter.SendPanelViewHolder)this.mListView.getChildAt(paramInt1).getTag();
        if ((paramBitmap != null) && (paramBitmap.itemInfo != null))
        {
          i = paramBitmap.itemInfo.position;
          localObject1 = (MiniShareQuicklySendPanelAdapter.SendPanelData)this.sendPanelDataList.get(i);
          if (localObject1 == null)
          {
            bool2 = bool1;
          }
          else
          {
            i = ((MiniShareQuicklySendPanelAdapter.SendPanelData)localObject1).baseData.getRecentUserType();
            i = ((Integer)RecentFaceDecoder.a(this.mApp, i, ((MiniShareQuicklySendPanelAdapter.SendPanelData)localObject1).baseData.getRecentUserUin()).first).intValue();
            bool2 = bool1;
            if (i != -2147483648)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(i);
              ((StringBuilder)localObject2).append(":");
              ((StringBuilder)localObject2).append(((MiniShareQuicklySendPanelAdapter.SendPanelData)localObject1).baseData.getRecentUserUin());
              localObject2 = ((StringBuilder)localObject2).toString();
              localObject2 = (Bitmap)this.faceCache.get(localObject2);
              bool2 = bool1;
              if (localObject2 != null)
              {
                updateItem(paramBitmap, (MiniShareQuicklySendPanelAdapter.SendPanelData)localObject1, new BitmapDrawable(this.activity.getResources(), (Bitmap)localObject2));
                bool2 = true;
              }
            }
          }
        }
        else
        {
          QLog.e("MiniShareQuicklySendPanelAdapter", 1, "onDecodeTaskCompleted holder is null?!");
          bool2 = bool1;
        }
      }
      else
      {
        if (QLog.isDevelopLevel())
        {
          paramBitmap = new StringBuilder();
          paramBitmap.append("decodecomplete|faceCache size = ");
          paramBitmap.append(this.faceCache.size());
          paramBitmap.append(", isNeedUpdateAvatar=");
          paramBitmap.append(bool1);
          QLog.i("MiniShareQuicklySendPanelAdapter", 4, paramBitmap.toString());
        }
        this.faceCache.clear();
        return;
      }
    }
  }
  
  public void onDestroy()
  {
    RecentFaceDecoder localRecentFaceDecoder = this.mFaceDecoder;
    if (localRecentFaceDecoder != null) {
      localRecentFaceDecoder.b();
    }
  }
  
  public void onUpdate(int paramInt, MiniShareQuicklySendPanelAdapter.SendPanelData paramSendPanelData)
  {
    if (paramInt >= 0)
    {
      ArrayList localArrayList = this.sendPanelDataList;
      if ((localArrayList != null) && (paramInt <= localArrayList.size()) && (paramSendPanelData != null))
      {
        this.sendPanelDataList.set(paramInt, paramSendPanelData);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniShareQuicklySendPanelAdapter", 2, "onUpdate return");
    }
  }
  
  public void setData(ArrayList<MiniShareQuicklySendPanelAdapter.SendPanelData> paramArrayList)
  {
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniShareQuicklySendPanelAdapter", 2, "setData list is empty");
      }
      return;
    }
    if ((this.sendPanelDataList != null) && (paramArrayList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniShareQuicklySendPanelAdapter", 2, "setData do not need refresh");
      }
      return;
    }
    this.sendPanelDataList = paramArrayList;
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniShareQuicklySendPanelAdapter
 * JD-Core Version:    0.7.0.1
 */