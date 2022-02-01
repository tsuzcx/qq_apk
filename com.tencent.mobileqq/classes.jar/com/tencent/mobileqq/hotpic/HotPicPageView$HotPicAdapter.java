package com.tencent.mobileqq.hotpic;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class HotPicPageView$HotPicAdapter
  extends RecyclerView.Adapter<HotPicPageView.MyViewHolder>
{
  OnHolderItemClickListener jdField_a_of_type_ComTencentMobileqqHotpicOnHolderItemClickListener;
  List<HotPicData> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public HotPicPageView$HotPicAdapter(HotPicPageView paramHotPicPageView, int paramInt) {}
  
  public HotPicPageView.MyViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_Int)) {
      return new HotPicPageView.MyVideoViewHolder(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_AndroidContentContext).inflate(2131558650, paramViewGroup, false), this.jdField_a_of_type_ComTencentMobileqqHotpicOnHolderItemClickListener);
    }
    return new HotPicPageView.MyViewHolder(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_AndroidContentContext).inflate(2131558649, paramViewGroup, false), this.jdField_a_of_type_ComTencentMobileqqHotpicOnHolderItemClickListener);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(HotPicPageView.MyViewHolder paramMyViewHolder, int paramInt)
  {
    Object localObject1;
    Object localObject2;
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
    for (;;)
    {
      HotPicData localHotPicData = (HotPicData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      ViewGroup.MarginLayoutParams localMarginLayoutParams1 = (ViewGroup.MarginLayoutParams)paramMyViewHolder.d.getLayoutParams();
      localMarginLayoutParams1.rightMargin = HotPicPageView.e;
      localMarginLayoutParams1.leftMargin = HotPicPageView.e;
      int i;
      int k;
      int j;
      Object localObject3;
      float f;
      if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2))
      {
        localMarginLayoutParams1.topMargin = (HotPicPageView.e * 2);
        i = localHotPicData.width;
        k = localHotPicData.height;
        j = HotPicPageView.d;
        if ((localHotPicData.getDataType() != 2) || (localObject1 == null)) {
          break label805;
        }
        ViewGroup.MarginLayoutParams localMarginLayoutParams2 = (ViewGroup.MarginLayoutParams)((HotPicPageView.MyVideoViewHolder)localObject1).c.getLayoutParams();
        localMarginLayoutParams1.topMargin = 0;
        localMarginLayoutParams1.rightMargin = 0;
        localMarginLayoutParams1.leftMargin = 0;
        HotVideoData localHotVideoData = (HotVideoData)localHotPicData;
        ((HotPicPageView.MyVideoViewHolder)localObject1).a(localHotVideoData);
        localHotVideoData.SetPreviewDownloadListener((URLDrawable.DownloadListener)localObject1);
        j = HotPicPageView.g;
        localObject3 = HotPicPageView.a(HotPicPageView.g, localHotVideoData.width, localHotVideoData.height, HotPicPageView.jdField_a_of_type_Double);
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = new Size(localHotVideoData.width, localHotVideoData.height);
        }
        f = i / ((Size)localObject2).a();
        i = ((Size)localObject2).b();
        ((HotPicPageView.MyVideoViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(localHotVideoData.getVideoLengthString());
        ((HotPicPageView.MyVideoViewHolder)localObject1).a.setText(localHotVideoData.name);
        localMarginLayoutParams2.width = j;
        localMarginLayoutParams2.height = i;
        localObject2 = (ViewGroup.MarginLayoutParams)((HotPicPageView.MyVideoViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject2).width = j;
        ((ViewGroup.MarginLayoutParams)localObject2).height = i;
        label355:
        localMarginLayoutParams1.width = j;
        localMarginLayoutParams1.height = i;
        k = (int)(160.0F / f + 0.5F);
        localObject2 = HotPicPageView.a(localHotPicData);
        if ((localObject2 == null) || (localHotPicData.getDataType() != 2) || (localObject1 == null)) {
          break label1239;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDC", "0X8007EDC", 0, 0, this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position + "", paramInt + "", localHotPicData.name + "", localHotPicData.url + "");
        localObject3 = (HotVideoData)localHotPicData;
        i = ((URLDrawable)localObject2).getStatus();
        if ((i != 1) && (i != 4)) {
          break label907;
        }
        if (HotVideoPreviewDownloader.a((HotVideoData)localObject3)) {
          break label827;
        }
        ((HotPicPageView.MyVideoViewHolder)localObject1).a(-11);
        i = 1;
      }
      for (;;)
      {
        label564:
        if (localObject2 != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_Int != -20)
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView;
            if (paramInt < HotPicPageView.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView)) {
              break label991;
            }
            j = paramInt;
            label601:
            HotPicPageView.a((HotPicPageView)localObject3, j);
            this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.b.add(Integer.valueOf(paramInt));
            if (((URLDrawable)localObject2).getStatus() == 1) {
              break label1003;
            }
            this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotpicDownloadDispatcher.a((URLDrawable)localObject2, paramInt);
            j = 16;
            if (localHotPicData.getDataType() == 2) {
              j = 8;
            }
            if (paramInt % j == 1) {
              this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.m();
            }
          }
          if (localHotPicData.getDataType() == 2) {
            break label1029;
          }
          ((URLDrawable)localObject2).setTargetDensity(k);
          label696:
          if (i != 0)
          {
            if (localHotPicData.getDataType() != 2) {
              break label1040;
            }
            ((HotPicPageView.MyVideoViewHolder)localObject1).a((Drawable)localObject2);
          }
          label717:
          if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel != null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position + "_" + paramInt;
            if (!this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_JavaUtilSet.contains(localObject1)) {
              break label1052;
            }
          }
        }
        for (;;)
        {
          label648:
          EventCollector.getInstance().onRecyclerBindViewHolder(paramMyViewHolder, paramInt, getItemId(paramInt));
          return;
          localMarginLayoutParams1.topMargin = 0;
          break;
          label805:
          f = i / j;
          i = (int)(k / f + 0.5F);
          break label355;
          label827:
          ((HotPicPageView.MyVideoViewHolder)localObject1).a(0);
          if (!((HotVideoData)localObject3).CheckIsNeedBlurBackground()) {
            break label1239;
          }
          ((HotPicPageView.MyVideoViewHolder)localObject1).b(new ColorDrawable(Color.parseColor("#7f000000")));
          if ((!this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a()) || (Build.VERSION.SDK_INT < 17) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoBlurTaskManager == null)) {
            break label1239;
          }
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoBlurTaskManager.a((HotPicPageView.MyVideoViewHolder)localObject1, (HotVideoData)localObject3);
          i = 1;
          break label564;
          label907:
          if (((HotVideoData)localObject3).url.isEmpty())
          {
            i = 0;
            ((HotPicPageView.MyVideoViewHolder)localObject1).a(-10);
            ((HotVideoData)localObject3).GetPreviewURLAsync(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, "0", new HotPicPageView.HotPicAdapter.1(this, (HotVideoData)localObject3, (HotPicPageView.MyVideoViewHolder)localObject1, (URLDrawable)localObject2));
            break label564;
          }
          j = 1;
          i = j;
          if (localHotPicData.getDataType() != 2) {
            break label564;
          }
          localObject3 = (HotVideoData)localHotPicData;
          i = j;
          break label564;
          label991:
          j = HotPicPageView.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView);
          break label601;
          label1003:
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
          ((URLDrawable)localObject2).setAutoDownload(true);
          break label648;
          label1029:
          ((URLDrawable)localObject2).setTargetDensity(160);
          break label696;
          label1040:
          paramMyViewHolder.d.setImageDrawable((Drawable)localObject2);
          break label717;
          label1052:
          if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
            if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position)
            {
              this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a("0X8007EDD", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position + "", paramInt + "", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagName + "", localHotPicData.url + "");
              this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_JavaUtilSet.add(localObject1);
            }
            else
            {
              HotPicPageView.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView).put(paramInt, localHotPicData.url);
            }
          }
        }
        label1239:
        i = 1;
      }
      localObject1 = null;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.HotPicAdapter
 * JD-Core Version:    0.7.0.1
 */