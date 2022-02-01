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
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private SparseArray<Boolean> jdField_a_of_type_AndroidUtilSparseArray;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  private MsgBackupListAdapter.OnItemCheckedChangeListener jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter$OnItemCheckedChangeListener;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private List<RecentBaseData> jdField_a_of_type_JavaUtilList;
  
  public MsgBackupListAdapter(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  private void a(MsgBackupListAdapter.BackupAndMigrateItemHolder paramBackupAndMigrateItemHolder, int paramInt, Drawable paramDrawable)
  {
    RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    IMsgBackupTempApi localIMsgBackupTempApi = (IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class);
    if ((localRecentBaseData instanceof MsgBackupMsgUserData))
    {
      MsgBackupMsgUserData localMsgBackupMsgUserData = (MsgBackupMsgUserData)localRecentBaseData;
      Drawable localDrawable = paramDrawable;
      if (paramDrawable == null) {
        localDrawable = localIMsgBackupTempApi.getFaceDrawable(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this, localRecentBaseData);
      }
      paramBackupAndMigrateItemHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      paramBackupAndMigrateItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localRecentBaseData.mTitleName);
      MsgBackupListAdapter.BackupAndMigrateItemHolder.a(paramBackupAndMigrateItemHolder).setChecked(((Boolean)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(paramInt)).booleanValue());
      if (AppSetting.d) {
        paramBackupAndMigrateItemHolder.jdField_a_of_type_AndroidViewView.setContentDescription(localMsgBackupMsgUserData.name);
      }
    }
  }
  
  private void b(MsgBackupListAdapter.BackupAndMigrateItemHolder paramBackupAndMigrateItemHolder, int paramInt, Drawable paramDrawable)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
        return;
      }
      RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (paramBackupAndMigrateItemHolder != null)
      {
        if (localRecentBaseData == null) {
          return;
        }
        Drawable localDrawable = paramDrawable;
        if (paramDrawable == null)
        {
          int i = localRecentBaseData.getRecentUserType();
          localDrawable = ((IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class)).getFaceDrawable(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this, i, localRecentBaseData.getRecentUserUin());
        }
        a(paramBackupAndMigrateItemHolder, paramInt, localDrawable);
      }
    }
  }
  
  public MsgBackupListAdapter.BackupAndMigrateItemHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new MsgBackupListAdapter.BackupAndMigrateItemHolder(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562728, paramViewGroup, false), this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter$OnItemCheckedChangeListener);
  }
  
  public void a()
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, Boolean.valueOf(false));
      i += 1;
    }
  }
  
  public void a(MsgBackupListAdapter.BackupAndMigrateItemHolder paramBackupAndMigrateItemHolder, int paramInt)
  {
    a(paramBackupAndMigrateItemHolder, paramInt, null);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramBackupAndMigrateItemHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(MsgBackupListAdapter.OnItemCheckedChangeListener paramOnItemCheckedChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter$OnItemCheckedChangeListener = paramOnItemCheckedChangeListener;
  }
  
  public void a(List<RecentBaseData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void b()
  {
    int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.setValueAt(i, Boolean.valueOf(true));
      i += 1;
    }
    notifyDataSetChanged();
  }
  
  public void c()
  {
    int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.setValueAt(i, Boolean.valueOf(false));
      i += 1;
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
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
        localObject = this.jdField_a_of_type_JavaUtilHashtable;
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
    long l2 = this.jdField_a_of_type_Long;
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
    synchronized (this.jdField_a_of_type_JavaUtilHashtable)
    {
      if (this.jdField_a_of_type_JavaUtilHashtable.size() == 0) {
        return;
      }
      if (paramInt1 == 0) {
        this.jdField_a_of_type_Long = 0L;
      } else {
        this.jdField_a_of_type_Long = l1;
      }
      paramInt2 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount();
      bool1 = false;
      paramInt1 = i;
      if (paramInt1 < paramInt2)
      {
        paramBitmap = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(paramInt1);
        paramBitmap = (MsgBackupListAdapter.BackupAndMigrateItemHolder)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder(paramBitmap);
        i = paramBitmap.getAdapterPosition();
        localObject = (RecentBaseData)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localObject == null)
        {
          bool2 = bool1;
        }
        else
        {
          int j = ((RecentBaseData)localObject).getRecentUserType();
          j = ((Integer)((IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class)).getHeadIcon(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, j, ((RecentBaseData)localObject).getRecentUserUin()).first).intValue();
          bool2 = bool1;
          if (j != -2147483648)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(j);
            localStringBuilder.append(":");
            localStringBuilder.append(((RecentBaseData)localObject).getRecentUserUin());
            localObject = localStringBuilder.toString();
            localObject = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(localObject);
            bool2 = bool1;
            if (localObject != null)
            {
              b(paramBitmap, i, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject));
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
          paramBitmap.append(this.jdField_a_of_type_JavaUtilHashtable.size());
          paramBitmap.append(", isNeedUpdateAvatar=");
          paramBitmap.append(bool1);
          QLog.i("MsgBackup.BackupAndMigrateListAdapter", 4, paramBitmap.toString());
        }
        this.jdField_a_of_type_JavaUtilHashtable.clear();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupListAdapter
 * JD-Core Version:    0.7.0.1
 */