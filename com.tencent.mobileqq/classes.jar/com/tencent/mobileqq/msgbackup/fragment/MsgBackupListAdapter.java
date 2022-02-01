package com.tencent.mobileqq.msgbackup.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgUserData;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class MsgBackupListAdapter
  extends RecyclerView.Adapter<MsgBackupListAdapter.BackupAndMigrateItemHolder>
  implements DecodeTaskCompletionListener
{
  private final LayoutInflater a;
  private SparseArray<Boolean> b;
  private List<RecentBaseData> c;
  private long d = 0L;
  private Hashtable<String, Bitmap> e = new Hashtable();
  private Context f;
  private BaseQQAppInterface g;
  private RecyclerView h;
  private MsgBackupListAdapter.OnItemCheckedChangeListener i;
  
  public MsgBackupListAdapter(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, RecyclerView paramRecyclerView)
  {
    this.f = paramContext;
    this.g = paramBaseQQAppInterface;
    this.h = paramRecyclerView;
    this.c = new ArrayList();
    this.b = new SparseArray();
    this.a = LayoutInflater.from(paramContext);
  }
  
  private void a(MsgBackupListAdapter.BackupAndMigrateItemHolder paramBackupAndMigrateItemHolder, int paramInt, Drawable paramDrawable)
  {
    RecentBaseData localRecentBaseData = (RecentBaseData)this.c.get(paramInt);
    IMsgBackupTempApi localIMsgBackupTempApi = (IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class);
    if ((localRecentBaseData instanceof MsgBackupMsgUserData))
    {
      MsgBackupMsgUserData localMsgBackupMsgUserData = (MsgBackupMsgUserData)localRecentBaseData;
      Drawable localDrawable = paramDrawable;
      if (paramDrawable == null) {
        localDrawable = localIMsgBackupTempApi.getFaceDrawable(this.g, this, localRecentBaseData);
      }
      paramBackupAndMigrateItemHolder.b.setImageDrawable(localDrawable);
      paramBackupAndMigrateItemHolder.c.setText(localRecentBaseData.mTitleName);
      MsgBackupListAdapter.BackupAndMigrateItemHolder.a(paramBackupAndMigrateItemHolder).setChecked(((Boolean)this.b.valueAt(paramInt)).booleanValue());
      if (AppSetting.e) {
        paramBackupAndMigrateItemHolder.a.setContentDescription(localMsgBackupMsgUserData.name);
      }
    }
  }
  
  private void b(MsgBackupListAdapter.BackupAndMigrateItemHolder paramBackupAndMigrateItemHolder, int paramInt, Drawable paramDrawable)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= this.c.size()) {
        return;
      }
      RecentBaseData localRecentBaseData = (RecentBaseData)this.c.get(paramInt);
      if (paramBackupAndMigrateItemHolder != null)
      {
        if (localRecentBaseData == null) {
          return;
        }
        Drawable localDrawable = paramDrawable;
        if (paramDrawable == null)
        {
          int j = localRecentBaseData.getRecentUserType();
          localDrawable = ((IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class)).getFaceDrawable(this.g, this, j, localRecentBaseData.getRecentUserUin());
        }
        a(paramBackupAndMigrateItemHolder, paramInt, localDrawable);
      }
    }
  }
  
  public MsgBackupListAdapter.BackupAndMigrateItemHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new MsgBackupListAdapter.BackupAndMigrateItemHolder(this, this.a.inflate(2131629162, paramViewGroup, false), this.i);
  }
  
  public void a()
  {
    int k = this.c.size();
    int j = 0;
    while (j < k)
    {
      this.b.put(j, Boolean.valueOf(false));
      j += 1;
    }
  }
  
  public void a(MsgBackupListAdapter.BackupAndMigrateItemHolder paramBackupAndMigrateItemHolder, int paramInt)
  {
    a(paramBackupAndMigrateItemHolder, paramInt, null);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramBackupAndMigrateItemHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(MsgBackupListAdapter.OnItemCheckedChangeListener paramOnItemCheckedChangeListener)
  {
    this.i = paramOnItemCheckedChangeListener;
  }
  
  public void a(List<RecentBaseData> paramList)
  {
    this.c.clear();
    this.c.addAll(paramList);
  }
  
  public void b()
  {
    int k = this.b.size();
    int j = 0;
    while (j < k)
    {
      this.b.setValueAt(j, Boolean.valueOf(true));
      j += 1;
    }
    notifyDataSetChanged();
  }
  
  public void c()
  {
    int k = this.b.size();
    int j = 0;
    while (j < k)
    {
      this.b.setValueAt(j, Boolean.valueOf(false));
      j += 1;
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.c.size();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String arg3, Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(???)) {
      return;
    }
    if ((paramBitmap == null) && (paramInt1 > 0)) {
      return;
    }
    Object localObject;
    StringBuilder localStringBuilder;
    if (paramBitmap != null) {
      try
      {
        localObject = this.e;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(":");
        localStringBuilder.append(???);
        ((Hashtable)localObject).put(localStringBuilder.toString(), paramBitmap);
      }
      catch (OutOfMemoryError ???)
      {
        System.gc();
        ???.printStackTrace();
        paramBitmap = new StringBuilder();
        paramBitmap.append("onDecodeTaskCompleted error:");
        paramBitmap.append(???.getMessage());
        QLog.i("MsgBackup.BackupAndMigrateListAdapter", 1, paramBitmap.toString());
      }
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.d;
    int j = 0;
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
    synchronized (this.e)
    {
      if (this.e.size() == 0) {
        return;
      }
      if (paramInt1 == 0) {
        this.d = 0L;
      } else {
        this.d = l1;
      }
      paramInt2 = this.h.getChildCount();
      bool1 = false;
      paramInt1 = j;
      if (paramInt1 < paramInt2)
      {
        paramBitmap = this.h.getChildAt(paramInt1);
        paramBitmap = (MsgBackupListAdapter.BackupAndMigrateItemHolder)this.h.getChildViewHolder(paramBitmap);
        j = paramBitmap.getAdapterPosition();
        localObject = (RecentBaseData)this.c.get(j);
        if (localObject == null)
        {
          bool2 = bool1;
        }
        else
        {
          int k = ((RecentBaseData)localObject).getRecentUserType();
          k = ((Integer)((IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class)).getHeadIcon(this.g, k, ((RecentBaseData)localObject).getRecentUserUin()).first).intValue();
          bool2 = bool1;
          if (k != -2147483648)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(k);
            localStringBuilder.append(":");
            localStringBuilder.append(((RecentBaseData)localObject).getRecentUserUin());
            localObject = localStringBuilder.toString();
            localObject = (Bitmap)this.e.get(localObject);
            bool2 = bool1;
            if (localObject != null)
            {
              b(paramBitmap, j, new BitmapDrawable(this.f.getResources(), (Bitmap)localObject));
              bool2 = true;
            }
          }
        }
      }
      else
      {
        if (QLog.isDevelopLevel())
        {
          paramBitmap = new StringBuilder();
          paramBitmap.append("decodecomplete|faceCache size = ");
          paramBitmap.append(this.e.size());
          paramBitmap.append(", isNeedUpdateAvatar=");
          paramBitmap.append(bool1);
          QLog.i("MsgBackup.BackupAndMigrateListAdapter", 4, paramBitmap.toString());
        }
        this.e.clear();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupListAdapter
 * JD-Core Version:    0.7.0.1
 */