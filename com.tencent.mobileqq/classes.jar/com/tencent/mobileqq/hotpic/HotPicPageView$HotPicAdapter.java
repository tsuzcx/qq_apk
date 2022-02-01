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
  OnHolderItemClickListener jdField_a_of_type_ComTencentMobileqqHotpicOnHolderItemClickListener;
  List<HotPicData> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public HotPicPageView$HotPicAdapter(HotPicPageView paramHotPicPageView, int paramInt) {}
  
  public HotPicPageView.MyViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_Int))
    {
      localHotPicPageView = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView;
      return new HotPicPageView.MyVideoViewHolder(localHotPicPageView, LayoutInflater.from(localHotPicPageView.jdField_a_of_type_AndroidContentContext).inflate(2131558549, paramViewGroup, false), this.jdField_a_of_type_ComTencentMobileqqHotpicOnHolderItemClickListener);
    }
    HotPicPageView localHotPicPageView = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView;
    return new HotPicPageView.MyViewHolder(localHotPicPageView, LayoutInflater.from(localHotPicPageView.jdField_a_of_type_AndroidContentContext).inflate(2131558548, paramViewGroup, false), this.jdField_a_of_type_ComTencentMobileqqHotpicOnHolderItemClickListener);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(HotPicPageView.MyViewHolder paramMyViewHolder, int paramInt)
  {
    Object localObject1;
    if ((paramMyViewHolder instanceof HotPicPageView.MyVideoViewHolder))
    {
      localObject1 = (HotPicPageView.MyVideoViewHolder)paramMyViewHolder;
      ((HotPicPageView.MyVideoViewHolder)localObject1).d();
      localObject2 = ((HotPicPageView.MyVideoViewHolder)localObject1).a();
      if (localObject2 != null)
      {
        ((HotVideoData)localObject2).SetPreviewDownloadListener(null);
        if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoBlurTaskManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoBlurTaskManager.a((HotVideoData)localObject2);
        }
      }
      ((HotPicPageView.MyVideoViewHolder)localObject1).a(null);
    }
    else
    {
      localObject1 = null;
    }
    HotPicData localHotPicData = (HotPicData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject4 = (ViewGroup.MarginLayoutParams)paramMyViewHolder.d.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject4).rightMargin = HotPicPageView.e;
    ((ViewGroup.MarginLayoutParams)localObject4).leftMargin = HotPicPageView.e;
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2)) {
      ((ViewGroup.MarginLayoutParams)localObject4).topMargin = (HotPicPageView.e * 2);
    } else {
      ((ViewGroup.MarginLayoutParams)localObject4).topMargin = 0;
    }
    int j = localHotPicData.width;
    int k = localHotPicData.height;
    int i = HotPicPageView.d;
    Object localObject5;
    Object localObject6;
    Object localObject3;
    float f;
    if ((localHotPicData.getDataType() == 2) && (localObject1 != null))
    {
      localObject5 = (ViewGroup.MarginLayoutParams)((HotPicPageView.MyVideoViewHolder)localObject1).c.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject4).topMargin = 0;
      ((ViewGroup.MarginLayoutParams)localObject4).rightMargin = 0;
      ((ViewGroup.MarginLayoutParams)localObject4).leftMargin = 0;
      localObject6 = (HotVideoData)localHotPicData;
      ((HotPicPageView.MyVideoViewHolder)localObject1).a((HotVideoData)localObject6);
      ((HotVideoData)localObject6).SetPreviewDownloadListener((URLDrawable.DownloadListener)localObject1);
      i = HotPicPageView.g;
      localObject3 = HotPicPageView.a(HotPicPageView.g, ((HotVideoData)localObject6).width, ((HotVideoData)localObject6).height, HotPicPageView.jdField_a_of_type_Double);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new Size(((HotVideoData)localObject6).width, ((HotVideoData)localObject6).height);
      }
      f = j / ((Size)localObject2).a();
      j = ((Size)localObject2).b();
      ((HotPicPageView.MyVideoViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((HotVideoData)localObject6).getVideoLengthString());
      ((HotPicPageView.MyVideoViewHolder)localObject1).a.setText(((HotVideoData)localObject6).name);
      ((ViewGroup.MarginLayoutParams)localObject5).width = i;
      ((ViewGroup.MarginLayoutParams)localObject5).height = j;
      localObject2 = (ViewGroup.MarginLayoutParams)((HotPicPageView.MyVideoViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
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
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position);
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
          ((HotVideoData)localObject3).GetPreviewURLAsync(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, "0", new HotPicPageView.HotPicAdapter.1(this, (HotVideoData)localObject3, (HotPicPageView.MyVideoViewHolder)localObject1, (URLDrawable)localObject2));
          i = 0;
          break label799;
        }
        localHotPicData.getDataType();
      }
      else if (!HotVideoPreviewDownloader.a((HotVideoData)localObject3))
      {
        ((HotPicPageView.MyVideoViewHolder)localObject1).a(-11);
      }
      else
      {
        ((HotPicPageView.MyVideoViewHolder)localObject1).a(0);
        if (((HotVideoData)localObject3).CheckIsNeedBlurBackground())
        {
          ((HotPicPageView.MyVideoViewHolder)localObject1).b(new ColorDrawable(Color.parseColor("#7f000000")));
          if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a()) && (Build.VERSION.SDK_INT >= 17) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoBlurTaskManager != null)) {
            this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoBlurTaskManager.a((HotPicPageView.MyVideoViewHolder)localObject1, (HotVideoData)localObject3);
          }
        }
      }
    }
    i = 1;
    label799:
    if (localObject2 != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_Int != -20)
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView;
        if (paramInt >= HotPicPageView.a((HotPicPageView)localObject3)) {
          j = paramInt;
        } else {
          j = HotPicPageView.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView);
        }
        HotPicPageView.a((HotPicPageView)localObject3, j);
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.b.add(Integer.valueOf(paramInt));
        if (((URLDrawable)localObject2).getStatus() != 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotpicDownloadDispatcher.a((URLDrawable)localObject2, paramInt);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
          ((URLDrawable)localObject2).setAutoDownload(true);
        }
        j = 16;
        if (localHotPicData.getDataType() == 2) {
          j = 8;
        }
        if (paramInt % j == 1) {
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.m();
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
          paramMyViewHolder.d.setImageDrawable((Drawable)localObject2);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position);
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(paramInt);
        localObject1 = ((StringBuilder)localObject1).toString();
        if ((!this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_JavaUtilSet.contains(localObject1)) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_AndroidxViewpagerWidgetViewPager != null)) {
          if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getCurrentItem() == this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position);
            ((StringBuilder)localObject3).append("");
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(paramInt);
            ((StringBuilder)localObject4).append("");
            localObject4 = ((StringBuilder)localObject4).toString();
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagName);
            ((StringBuilder)localObject5).append("");
            localObject5 = ((StringBuilder)localObject5).toString();
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append(localHotPicData.url);
            ((StringBuilder)localObject6).append("");
            ((HotPicPageView)localObject2).a("0X8007EDD", (String)localObject3, (String)localObject4, (String)localObject5, ((StringBuilder)localObject6).toString());
            this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_JavaUtilSet.add(localObject1);
          }
          else
          {
            HotPicPageView.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView).put(paramInt, localHotPicData.url);
          }
        }
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramMyViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(List<? extends HotPicData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.HotPicAdapter
 * JD-Core Version:    0.7.0.1
 */