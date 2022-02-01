package com.tencent.mobileqq.hotpic;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

class HotPicPageView$HotPicAdapter
  extends RecyclerView.Adapter<HotPicPageView.MyViewHolder>
{
  List<HotPicData> a = new ArrayList();
  OnHolderItemClickListener b;
  
  public HotPicPageView$HotPicAdapter(HotPicPageView paramHotPicPageView, int paramInt) {}
  
  public HotPicPageView.MyViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (HotPicManager.a(this.c.a.f).b(this.c.l))
    {
      localHotPicPageView = this.c;
      return new HotPicPageView.MyVideoViewHolder(localHotPicPageView, LayoutInflater.from(localHotPicPageView.b).inflate(2131624105, paramViewGroup, false), this.b);
    }
    HotPicPageView localHotPicPageView = this.c;
    return new HotPicPageView.MyViewHolder(localHotPicPageView, LayoutInflater.from(localHotPicPageView.b).inflate(2131624104, paramViewGroup, false), this.b);
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(HotPicPageView.MyViewHolder paramMyViewHolder, int paramInt)
  {
    Object localObject1;
    if ((paramMyViewHolder instanceof HotPicPageView.MyVideoViewHolder))
    {
      localObject1 = (HotPicPageView.MyVideoViewHolder)paramMyViewHolder;
      ((HotPicPageView.MyVideoViewHolder)localObject1).f();
      localObject2 = ((HotPicPageView.MyVideoViewHolder)localObject1).a();
      if (localObject2 != null)
      {
        ((HotVideoData)localObject2).SetPreviewDownloadListener(null);
        if (this.c.C != null) {
          this.c.C.a((HotVideoData)localObject2);
        }
      }
      ((HotPicPageView.MyVideoViewHolder)localObject1).a(null);
    }
    else
    {
      localObject1 = null;
    }
    HotPicData localHotPicData = (HotPicData)this.a.get(paramInt);
    Object localObject4 = (ViewGroup.MarginLayoutParams)paramMyViewHolder.q.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject4).rightMargin = HotPicPageView.u;
    ((ViewGroup.MarginLayoutParams)localObject4).leftMargin = HotPicPageView.u;
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2)) {
      ((ViewGroup.MarginLayoutParams)localObject4).topMargin = (HotPicPageView.u * 2);
    } else {
      ((ViewGroup.MarginLayoutParams)localObject4).topMargin = 0;
    }
    int j = localHotPicData.width;
    int k = localHotPicData.height;
    int i = HotPicPageView.t;
    Object localObject5;
    Object localObject6;
    Object localObject3;
    float f;
    if ((localHotPicData.getDataType() == 2) && (localObject1 != null))
    {
      localObject5 = (ViewGroup.MarginLayoutParams)((HotPicPageView.MyVideoViewHolder)localObject1).d.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject4).topMargin = 0;
      ((ViewGroup.MarginLayoutParams)localObject4).rightMargin = 0;
      ((ViewGroup.MarginLayoutParams)localObject4).leftMargin = 0;
      localObject6 = (HotVideoData)localHotPicData;
      ((HotPicPageView.MyVideoViewHolder)localObject1).a((HotVideoData)localObject6);
      ((HotVideoData)localObject6).SetPreviewDownloadListener((URLDrawable.DownloadListener)localObject1);
      i = HotPicPageView.x;
      localObject3 = HotPicPageView.a(HotPicPageView.x, ((HotVideoData)localObject6).width, ((HotVideoData)localObject6).height, HotPicPageView.y);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new Size(((HotVideoData)localObject6).width, ((HotVideoData)localObject6).height);
      }
      f = j / ((Size)localObject2).a();
      j = ((Size)localObject2).b();
      ((HotPicPageView.MyVideoViewHolder)localObject1).f.setText(((HotVideoData)localObject6).getVideoLengthString());
      ((HotPicPageView.MyVideoViewHolder)localObject1).e.setText(((HotVideoData)localObject6).name);
      ((ViewGroup.MarginLayoutParams)localObject5).width = i;
      ((ViewGroup.MarginLayoutParams)localObject5).height = j;
      localObject2 = (ViewGroup.MarginLayoutParams)((HotPicPageView.MyVideoViewHolder)localObject1).h.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject2).width = i;
      ((ViewGroup.MarginLayoutParams)localObject2).height = j;
    }
    else
    {
      f = j / i;
      j = (int)(k / f + 0.5F);
    }
    ((ViewGroup.MarginLayoutParams)localObject4).width = i;
    ((ViewGroup.MarginLayoutParams)localObject4).height = j;
    k = (int)(160.0F / f + 0.5F);
    Object localObject2 = HotPicPageView.a(localHotPicData);
    if ((localObject2 != null) && (localHotPicData.getDataType() == 2) && (localObject1 != null))
    {
      localObject3 = this.c.c;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(this.c.n.position);
      ((StringBuilder)localObject4).append("");
      localObject4 = ((StringBuilder)localObject4).toString();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(paramInt);
      ((StringBuilder)localObject5).append("");
      localObject5 = ((StringBuilder)localObject5).toString();
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append(localHotPicData.name);
      ((StringBuilder)localObject6).append("");
      localObject6 = ((StringBuilder)localObject6).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localHotPicData.url);
      localStringBuilder.append("");
      ReportController.b((AppRuntime)localObject3, "dc00898", "", "", "0X8007EDC", "0X8007EDC", 0, 0, (String)localObject4, (String)localObject5, (String)localObject6, localStringBuilder.toString());
      localObject3 = (HotVideoData)localHotPicData;
      i = ((URLDrawable)localObject2).getStatus();
      if ((i != 1) && (i != 4))
      {
        if (((HotVideoData)localObject3).url.isEmpty())
        {
          ((HotPicPageView.MyVideoViewHolder)localObject1).a(-10);
          ((HotVideoData)localObject3).GetPreviewURLAsync(this.c.c, 0, "0", new HotPicPageView.HotPicAdapter.1(this, (HotVideoData)localObject3, (HotPicPageView.MyVideoViewHolder)localObject1, (URLDrawable)localObject2));
          i = 0;
          break label800;
        }
        localHotPicData.getDataType();
      }
      else if (!HotVideoPreviewDownloader.c((HotVideoData)localObject3))
      {
        ((HotPicPageView.MyVideoViewHolder)localObject1).a(-11);
      }
      else
      {
        ((HotPicPageView.MyVideoViewHolder)localObject1).a(0);
        if (((HotVideoData)localObject3).CheckIsNeedBlurBackground())
        {
          ((HotPicPageView.MyVideoViewHolder)localObject1).b(new ColorDrawable(Color.parseColor("#7f000000")));
          if ((this.c.j()) && (Build.VERSION.SDK_INT >= 17) && (this.c.C != null)) {
            this.c.C.a((HotPicPageView.MyVideoViewHolder)localObject1, (HotVideoData)localObject3);
          }
        }
      }
    }
    i = 1;
    label800:
    if (localObject2 != null)
    {
      if (this.c.l != -20)
      {
        localObject3 = this.c;
        if (paramInt >= HotPicPageView.a((HotPicPageView)localObject3)) {
          j = paramInt;
        } else {
          j = HotPicPageView.a(this.c);
        }
        HotPicPageView.a((HotPicPageView)localObject3, j);
        this.c.s.add(Integer.valueOf(paramInt));
        if (((URLDrawable)localObject2).getStatus() != 1)
        {
          this.c.q.a((URLDrawable)localObject2, paramInt);
        }
        else
        {
          this.c.r.add(Integer.valueOf(paramInt));
          ((URLDrawable)localObject2).setAutoDownload(true);
        }
        j = 16;
        if (localHotPicData.getDataType() == 2) {
          j = 8;
        }
        if (paramInt % j == 1) {
          this.c.n();
        }
      }
      if (localHotPicData.getDataType() != 2) {
        ((URLDrawable)localObject2).setTargetDensity(k);
      } else {
        ((URLDrawable)localObject2).setTargetDensity(160);
      }
      if (i != 0) {
        if (localHotPicData.getDataType() == 2) {
          ((HotPicPageView.MyVideoViewHolder)localObject1).a((Drawable)localObject2);
        } else {
          paramMyViewHolder.q.setImageDrawable((Drawable)localObject2);
        }
      }
      if (this.c.a != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.c.n.position);
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(paramInt);
        localObject1 = ((StringBuilder)localObject1).toString();
        if ((!this.c.a.u.contains(localObject1)) && (this.c.a.p != null)) {
          if (this.c.a.p.getCurrentItem() == this.c.n.position)
          {
            localObject2 = this.c;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(this.c.n.position);
            ((StringBuilder)localObject3).append("");
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(paramInt);
            ((StringBuilder)localObject4).append("");
            localObject4 = ((StringBuilder)localObject4).toString();
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append(this.c.n.tagName);
            ((StringBuilder)localObject5).append("");
            localObject5 = ((StringBuilder)localObject5).toString();
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append(localHotPicData.url);
            ((StringBuilder)localObject6).append("");
            ((HotPicPageView)localObject2).a("0X8007EDD", (String)localObject3, (String)localObject4, (String)localObject5, ((StringBuilder)localObject6).toString());
            this.c.a.u.add(localObject1);
          }
          else
          {
            HotPicPageView.b(this.c).put(paramInt, localHotPicData.url);
          }
        }
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramMyViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(List<? extends HotPicData> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.HotPicAdapter
 * JD-Core Version:    0.7.0.1
 */