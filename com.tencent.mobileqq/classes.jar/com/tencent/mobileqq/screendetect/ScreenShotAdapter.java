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
  protected RecentFaceDecoder a;
  private int b = -1;
  private boolean c = true;
  private QQAppInterface d;
  private Hashtable<String, Bitmap> e = new Hashtable();
  private final Context f;
  private final LayoutInflater g;
  private ArrayList<RecentBaseData> h;
  private long i = 0L;
  private RecyclerView j;
  private ScreenShotAdapter.OnHolderItemClickListener k;
  
  public ScreenShotAdapter(Context paramContext, QQAppInterface paramQQAppInterface, RecyclerView paramRecyclerView, int paramInt)
  {
    this.f = paramContext;
    this.d = paramQQAppInterface;
    this.j = paramRecyclerView;
    this.g = LayoutInflater.from(paramContext);
    this.h = new ArrayList();
    this.a = new RecentFaceDecoder(paramQQAppInterface, this, false);
    this.b = paramInt;
    if (paramInt == 1) {
      this.c = false;
    }
  }
  
  @Nullable
  private RecentBaseData a(int paramInt)
  {
    if ((paramInt > 0) && (this.c)) {
      return (RecentBaseData)this.h.get(paramInt - 1);
    }
    return (RecentBaseData)this.h.get(paramInt);
  }
  
  private void a(ScreenShotAdapter.ScreenShotViewHolder paramScreenShotViewHolder, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null)
    {
      paramDrawable = this.a;
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
      int m = ((Integer)RecentFaceDecoder.a(this.d, paramRecentBaseData.getRecentUserType(), paramRecentBaseData.getRecentUserUin()).first).intValue();
      if (m == 103) {
        m = 1;
      }
      paramDrawable = paramScreenShotViewHolder.a;
      QQAppInterface localQQAppInterface = this.d;
      String str = paramRecentBaseData.getRecentUserUin();
      boolean bool;
      if (this.d.mAutomator.f() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramDrawable.setFaceDrawable(localQQAppInterface, localDrawable, m, str, 100, false, bool, 0);
    }
    else
    {
      paramScreenShotViewHolder.a.setImageDrawable(localDrawable);
    }
    paramScreenShotViewHolder.b.setText(paramRecentBaseData.getTitleName());
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
        int n = paramRecentBaseData.getRecentUserType();
        int m = n;
        if ((paramRecentBaseData instanceof RecentCallItem))
        {
          m = n;
          if (((RecentCallItem)paramRecentBaseData).a()) {
            m = 3002;
          }
        }
        localDrawable = this.a.a(m, paramRecentBaseData.getRecentUserUin());
      }
      a(paramScreenShotViewHolder, paramRecentBaseData, localDrawable);
    }
  }
  
  public void a()
  {
    RecentFaceDecoder localRecentFaceDecoder = this.a;
    if (localRecentFaceDecoder != null) {
      localRecentFaceDecoder.b();
    }
  }
  
  public void a(ScreenShotAdapter.OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    this.k = paramOnHolderItemClickListener;
  }
  
  public void a(List<RecentBaseData> paramList)
  {
    this.h.clear();
    this.h.addAll(paramList);
    notifyDataSetChanged();
  }
  
  protected boolean a(RecentBaseData paramRecentBaseData)
  {
    int m = paramRecentBaseData.getRecentUserType();
    return (m == 0) || (m == 1000) || (m == 1004) || (m == 1003) || (m == 10004) || (m == 1021) || (m == 1022) || (m == 1023) || (m == 10008) || (m == 10010);
  }
  
  public int getItemCount()
  {
    if (this.c) {
      return this.h.size() + 1;
    }
    return this.h.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (this.c)) {
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
    if ((paramInt == 0) && (this.c)) {
      return new ScreenShotAdapter.ScreenShotHeaderViewHolder(this, this.g.inflate(2131629213, paramViewGroup, false));
    }
    return new ScreenShotAdapter.ScreenShotViewHolder(this, this.g.inflate(2131627770, paramViewGroup, false), this.k);
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
        localObject1 = this.e;
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
    long l2 = this.i;
    int m = 0;
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
        this.i = 0L;
      } else {
        this.i = l1;
      }
      paramInt2 = this.j.getChildCount();
      bool1 = false;
      paramInt1 = m;
      if (paramInt1 < paramInt2)
      {
        paramBitmap = this.j.getChildAt(paramInt1);
        paramBitmap = this.j.getChildViewHolder(paramBitmap);
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
            m = ((RecentBaseData)localObject1).getRecentUserType();
            m = ((Integer)RecentFaceDecoder.a(this.d, m, ((RecentBaseData)localObject1).getRecentUserUin()).first).intValue();
            bool2 = bool1;
            if (m != -2147483648)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(m);
              ((StringBuilder)localObject2).append(":");
              ((StringBuilder)localObject2).append(((RecentBaseData)localObject1).getRecentUserUin());
              localObject2 = ((StringBuilder)localObject2).toString();
              localObject2 = (Bitmap)this.e.get(localObject2);
              bool2 = bool1;
              if (localObject2 != null)
              {
                b(paramBitmap, (RecentBaseData)localObject1, new BitmapDrawable(this.f.getResources(), (Bitmap)localObject2));
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
          paramBitmap.append(this.e.size());
          paramBitmap.append(", isNeedUpdateAvatar=");
          paramBitmap.append(bool1);
          QLog.i("ScreenShotAdapter", 4, paramBitmap.toString());
        }
        this.e.clear();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotAdapter
 * JD-Core Version:    0.7.0.1
 */