package com.tencent.mobileqq.screendetect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ScreenShotAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements DecodeTaskCompletionListener
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 0L;
  private final Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  protected RecentFaceDecoder a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ScreenShotAdapter.OnHolderItemClickListener jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotAdapter$OnHolderItemClickListener;
  private ArrayList<RecentBaseData> jdField_a_of_type_JavaUtilArrayList;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_a_of_type_Boolean = true;
  
  public ScreenShotAdapter(Context paramContext, QQAppInterface paramQQAppInterface, RecyclerView paramRecyclerView, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(paramQQAppInterface, this, false);
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 1) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  @Nullable
  private RecentBaseData a(int paramInt)
  {
    if ((paramInt > 0) && (this.jdField_a_of_type_Boolean)) {
      return (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1);
    }
    return (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  private void a(ScreenShotAdapter.ScreenShotViewHolder paramScreenShotViewHolder, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null)
    {
      paramDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder;
      if (paramDrawable != null) {
        localDrawable = paramDrawable.a(paramRecentBaseData);
      } else {
        localDrawable = null;
      }
    }
    if (a(paramRecentBaseData))
    {
      if (QLog.isColorLevel())
      {
        paramDrawable = new StringBuilder();
        paramDrawable.append("bindview user:");
        paramDrawable.append(paramRecentBaseData.getRecentUserUin());
        QLog.d("ScreenShotAdapter", 2, paramDrawable.toString());
      }
      int i = ((Integer)RecentFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.getRecentUserType(), paramRecentBaseData.getRecentUserUin()).first).intValue();
      if (i == 103) {
        i = 1;
      }
      paramDrawable = paramScreenShotViewHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str = paramRecentBaseData.getRecentUserUin();
      boolean bool;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.a() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramDrawable.setFaceDrawable(localQQAppInterface, localDrawable, i, str, 100, false, bool, 0);
    }
    else
    {
      paramScreenShotViewHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(localDrawable);
    }
    paramScreenShotViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramRecentBaseData.getTitleName());
  }
  
  private void b(ScreenShotAdapter.ScreenShotViewHolder paramScreenShotViewHolder, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    if (paramScreenShotViewHolder != null)
    {
      if (paramRecentBaseData == null) {
        return;
      }
      Drawable localDrawable = paramDrawable;
      if (paramDrawable == null)
      {
        int j = paramRecentBaseData.getRecentUserType();
        int i = j;
        if ((paramRecentBaseData instanceof RecentCallItem))
        {
          i = j;
          if (((RecentCallItem)paramRecentBaseData).a()) {
            i = 3002;
          }
        }
        localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(i, paramRecentBaseData.getRecentUserUin());
      }
      a(paramScreenShotViewHolder, paramRecentBaseData, localDrawable);
    }
  }
  
  public void a()
  {
    RecentFaceDecoder localRecentFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder;
    if (localRecentFaceDecoder != null) {
      localRecentFaceDecoder.a();
    }
  }
  
  public void a(ScreenShotAdapter.OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotAdapter$OnHolderItemClickListener = paramOnHolderItemClickListener;
  }
  
  public void a(List<RecentBaseData> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  protected boolean a(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.getRecentUserType();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023) || (i == 10008) || (i == 10010);
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilArrayList.size() + 1;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Boolean)) {
      return 0;
    }
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof ScreenShotAdapter.ScreenShotViewHolder))
    {
      RecentBaseData localRecentBaseData = a(paramInt);
      a((ScreenShotAdapter.ScreenShotViewHolder)paramViewHolder, localRecentBaseData, null);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Boolean)) {
      return new ScreenShotAdapter.ScreenShotHeaderViewHolder(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562768, paramViewGroup, false));
    }
    return new ScreenShotAdapter.ScreenShotViewHolder(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561414, paramViewGroup, false), this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotAdapter$OnHolderItemClickListener);
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
        localObject1 = this.jdField_a_of_type_JavaUtilHashtable;
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
        QLog.i("ScreenShotAdapter", 1, paramBitmap.toString());
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
        paramBitmap = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder(paramBitmap);
        if (!(paramBitmap instanceof ScreenShotAdapter.ScreenShotViewHolder))
        {
          bool2 = bool1;
        }
        else
        {
          paramBitmap = (ScreenShotAdapter.ScreenShotViewHolder)paramBitmap;
          localObject1 = a(paramBitmap.getAdapterPosition());
          if (localObject1 == null)
          {
            bool2 = bool1;
          }
          else
          {
            i = ((RecentBaseData)localObject1).getRecentUserType();
            i = ((Integer)RecentFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, ((RecentBaseData)localObject1).getRecentUserUin()).first).intValue();
            bool2 = bool1;
            if (i != -2147483648)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(i);
              ((StringBuilder)localObject2).append(":");
              ((StringBuilder)localObject2).append(((RecentBaseData)localObject1).getRecentUserUin());
              localObject2 = ((StringBuilder)localObject2).toString();
              localObject2 = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(localObject2);
              bool2 = bool1;
              if (localObject2 != null)
              {
                b(paramBitmap, (RecentBaseData)localObject1, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject2));
                bool2 = true;
              }
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
          QLog.i("ScreenShotAdapter", 4, paramBitmap.toString());
        }
        this.jdField_a_of_type_JavaUtilHashtable.clear();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotAdapter
 * JD-Core Version:    0.7.0.1
 */