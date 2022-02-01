package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.report.DistinctEventReporter;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.HeadImageWithRing;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.tab.ReadInjoyXRecyclerView;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils.ReportData;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.feeds.WaterFallPic;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;
import tencent.im.oidb.gallery.galleryFeeds.Picture;
import tencent.im.oidb.gallery.galleryFeeds.UserInfo;

class ReadInJoyPicWaterFallFragment$WaterFallPicAdapter
  extends RecyclerView.Adapter<ReadInJoyPicWaterFallFragment.BaseViewHolder>
{
  public final int a;
  List<AbsBaseArticleInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  int b;
  int c;
  int d;
  int e;
  
  public ReadInJoyPicWaterFallFragment$WaterFallPicAdapter(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment)
  {
    this.jdField_a_of_type_Int = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment.a(), 150.0F);
    this.b = AIOUtils.b(3.0F, paramReadInJoyPicWaterFallFragment.getResources());
    this.c = AIOUtils.b(58.5F, paramReadInJoyPicWaterFallFragment.getResources());
    this.d = AIOUtils.b(226.0F, paramReadInJoyPicWaterFallFragment.getResources());
  }
  
  private void a(ReadInJoyPicWaterFallFragment.ActiveViewHolder paramActiveViewHolder, int paramInt)
  {
    Object localObject1 = (AbsBaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject2 = paramActiveViewHolder.itemView.getLayoutParams();
    paramInt = -1;
    if (localObject2 == null)
    {
      localObject2 = new StaggeredGridLayoutManager.LayoutParams(-1, AIOUtils.b(314.0F, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment.getResources()));
      paramActiveViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    paramActiveViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((AbsBaseArticleInfo)localObject1).mTitle);
    localObject2 = paramActiveViewHolder.jdField_a_of_type_AndroidWidgetTextView;
    if (ReadInJoyLogicEngine.a().a(((AbsBaseArticleInfo)localObject1).mArticleID)) {
      paramInt = ReadInJoyPicWaterFallFragment.d;
    }
    ((TextView)localObject2).setTextColor(paramInt);
    paramActiveViewHolder.jdField_b_of_type_ComTencentImageURLImageView.setContentDescription(((AbsBaseArticleInfo)localObject1).getSubscribeName());
    localObject2 = RIJConvertString2URL.a(((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_topic_pic_url.get().toStringUtf8());
    ReadInJoyDisplayUtils.a(paramActiveViewHolder.jdField_b_of_type_ComTencentImageURLImageView, (URL)localObject2, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment.a());
    paramActiveViewHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = ((AbsBaseArticleInfo)localObject1);
    localObject1 = ((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_topic_icon_url.get().toStringUtf8();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramActiveViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject1 = URLDrawableHelper.getDrawable((String)localObject1);
      paramActiveViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      return;
    }
    paramActiveViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(ReadInJoyPicWaterFallFragment.NormalViewHolder paramNormalViewHolder, int paramInt)
  {
    Object localObject1 = (AbsBaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    a((AbsBaseArticleInfo)localObject1);
    Object localObject2 = (FrameLayout.LayoutParams)paramNormalViewHolder.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams();
    if (localObject2 == null)
    {
      localObject2 = new FrameLayout.LayoutParams(-1, ((AbsBaseArticleInfo)localObject1).waterFallPic.c);
      paramNormalViewHolder.jdField_b_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    else if ((((FrameLayout.LayoutParams)localObject2).height <= 0) || (((FrameLayout.LayoutParams)localObject2).height != ((AbsBaseArticleInfo)localObject1).waterFallPic.c))
    {
      ((FrameLayout.LayoutParams)localObject2).height = ((AbsBaseArticleInfo)localObject1).waterFallPic.c;
      paramNormalViewHolder.jdField_b_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    if (((AbsBaseArticleInfo)localObject1).waterFallPic.d > this.d) {
      paramNormalViewHolder.jdField_b_of_type_ComTencentImageURLImageView.setPadding(0, ((AbsBaseArticleInfo)localObject1).waterFallPic.d - ((AbsBaseArticleInfo)localObject1).waterFallPic.c, 0, 0);
    } else {
      paramNormalViewHolder.jdField_b_of_type_ComTencentImageURLImageView.setPadding(0, 0, 0, 0);
    }
    paramNormalViewHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = ((AbsBaseArticleInfo)localObject1);
    paramNormalViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((AbsBaseArticleInfo)localObject1).mTitle);
    boolean bool = ReadInJoyLogicEngine.a().a(((AbsBaseArticleInfo)localObject1).mArticleID);
    localObject2 = paramNormalViewHolder.jdField_a_of_type_AndroidWidgetTextView;
    int i;
    if (bool) {
      i = ReadInJoyPicWaterFallFragment.d;
    } else {
      i = ReadInJoyPicWaterFallFragment.e;
    }
    ((TextView)localObject2).setTextColor(i);
    paramNormalViewHolder.jdField_b_of_type_ComTencentImageURLImageView.setContentDescription(((AbsBaseArticleInfo)localObject1).getSubscribeName());
    ReadInJoyDisplayUtils.a(paramNormalViewHolder.jdField_b_of_type_ComTencentImageURLImageView, ((AbsBaseArticleInfo)localObject1).waterFallPic.jdField_a_of_type_JavaNetURL, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment.a());
    paramNormalViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setVisibility(0);
    paramNormalViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setText(((AbsBaseArticleInfo)localObject1).getSubscribeName());
    paramNormalViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setContentDescription(((AbsBaseArticleInfo)localObject1).getSubscribeName());
    paramNormalViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
    Object localObject4;
    if (((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo.uint32_is_account_derelict.get() == 1)
    {
      paramNormalViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetHeadImageWithRing.setImageResource(2130846604);
    }
    else
    {
      localObject2 = ((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo.msg_publisher_info.bytes_header_url.get().toStringUtf8();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        i = AIOUtils.b(12.0F, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment.getResources());
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = i;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = i;
        try
        {
          localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject4);
          paramNormalViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetHeadImageWithRing.setImageDrawable((Drawable)localObject2);
        }
        catch (Exception localException)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("bindNormalHolder, e = ");
          ((StringBuilder)localObject4).append(localException);
          QLog.e("ReadInJoyPicWaterFallFragment", 1, ((StringBuilder)localObject4).toString());
        }
      }
      else
      {
        paramNormalViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetHeadImageWithRing.setImageResource(2130846604);
      }
    }
    Object localObject3;
    Object localObject5;
    if (((AbsBaseArticleInfo)localObject1).mSocialFeedInfo != null)
    {
      paramNormalViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject3 = ReadInJoyHelper.a(((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.b, 999000L, "99.9万", "0");
      localObject4 = paramNormalViewHolder.jdField_b_of_type_AndroidWidgetTextView;
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append((String)localObject3);
      ((StringBuilder)localObject5).append(HardCodeUtil.a(2131712922));
      ((TextView)localObject4).setText(((StringBuilder)localObject5).toString());
    }
    else
    {
      paramNormalViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (((AbsBaseArticleInfo)localObject1).mGalleryPicNumber > 1)
    {
      paramNormalViewHolder.c.setVisibility(0);
      localObject3 = paramNormalViewHolder.c;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(((AbsBaseArticleInfo)localObject1).mGalleryPicNumber);
      ((StringBuilder)localObject4).append(HardCodeUtil.a(2131712829));
      ((TextView)localObject3).setText(((StringBuilder)localObject4).toString());
    }
    else
    {
      paramNormalViewHolder.c.setVisibility(8);
    }
    if (((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo != null)
    {
      localObject3 = ((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_content.get().toStringUtf8();
      localObject4 = ((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_jump_url.get().toStringUtf8();
      localObject5 = ((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_icon_url.get().toStringUtf8();
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
      {
        paramNormalViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramNormalViewHolder.d.setText((CharSequence)localObject3);
        localObject3 = URLDrawableHelper.getDrawable((String)localObject5);
        paramNormalViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
        localObject3 = GalleryReportedUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment.a(), ReadInJoyPicWaterFallFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment), 3, paramInt, (AbsBaseArticleInfo)localObject1);
        try
        {
          ((JSONObject)localObject3).put("exptime", System.currentTimeMillis());
          ((JSONObject)localObject3).put("proxy_bytes", ((AbsBaseArticleInfo)localObject1).galleryReprotExdData);
          ((JSONObject)localObject3).put("operation_id", ((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_operation_id.get().toStringUtf8());
          localObject4 = new GalleryReportedUtils.ReportData((AbsBaseArticleInfo)localObject1);
          ((GalleryReportedUtils.ReportData)localObject4).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = ((AbsBaseArticleInfo)localObject1);
          ((GalleryReportedUtils.ReportData)localObject4).e = String.valueOf(((AbsBaseArticleInfo)localObject1).mArticleID);
          ((GalleryReportedUtils.ReportData)localObject4).f = String.valueOf(((AbsBaseArticleInfo)localObject1).mAlgorithmID);
          ((GalleryReportedUtils.ReportData)localObject4).g = ((JSONObject)localObject3).toString();
          if (((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.a != null) {
            ((GalleryReportedUtils.ReportData)localObject4).jdField_a_of_type_JavaLangString = String.valueOf(((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.a.a);
          }
          ((GalleryReportedUtils.ReportData)localObject4).b = "0X8009A7A";
          ((GalleryReportedUtils.ReportData)localObject4).c = "0X8009A7A";
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment.jdField_a_of_type_ComTencentMobileqqKandianBaseReportDistinctEventReporter.trigger("exp_waterfall_operation", localObject4);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      else
      {
        paramNormalViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      String str = ((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_note_content.get().toStringUtf8();
      localObject1 = ((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_note_icon_url.get().toStringUtf8();
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        paramNormalViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        paramNormalViewHolder.e.setText(str);
        localObject1 = URLDrawableHelper.getDrawable((String)localObject1);
        paramNormalViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        return;
      }
      paramNormalViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    paramNormalViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
    paramNormalViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void a(WaterFallPic paramWaterFallPic)
  {
    int i;
    if (paramWaterFallPic.jdField_a_of_type_Int > 0)
    {
      i = (int)(this.e / paramWaterFallPic.jdField_a_of_type_Int * paramWaterFallPic.b);
      paramWaterFallPic.d = i;
      if ((i >= this.c) && (i <= this.d))
      {
        paramWaterFallPic.c = i;
      }
      else
      {
        int j = this.c;
        if (i < j) {
          paramWaterFallPic.c = j;
        } else {
          paramWaterFallPic.c = this.d;
        }
      }
    }
    else
    {
      i = this.e;
      if (i == 0) {
        i = this.jdField_a_of_type_Int;
      }
      paramWaterFallPic.c = i;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WaterFallPic = ");
      localStringBuilder.append(paramWaterFallPic.toString());
      QLog.d("ReadInJoyPicWaterFallFragment", 2, localStringBuilder.toString());
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo.waterFallPic != null) {
      return;
    }
    Object localObject = (galleryFeeds.Picture)paramAbsBaseArticleInfo.mGalleryFeedsInfo.msg_custom_cover.get();
    WaterFallPic localWaterFallPic = new WaterFallPic();
    if (localObject != null)
    {
      int i = (int)((galleryFeeds.Picture)localObject).uint64_width.get();
      int j = (int)((galleryFeeds.Picture)localObject).uint64_height.get();
      localWaterFallPic.jdField_a_of_type_Int = i;
      localWaterFallPic.b = j;
      localWaterFallPic.jdField_a_of_type_JavaNetURL = RIJConvertString2URL.a(((galleryFeeds.Picture)localObject).bytes_pic_url.get().toStringUtf8());
    }
    else
    {
      localObject = paramAbsBaseArticleInfo.mFirstPagePicUrl;
      localWaterFallPic.jdField_a_of_type_Int = -1;
      localWaterFallPic.b = -1;
      localWaterFallPic.jdField_a_of_type_JavaNetURL = RIJConvertString2URL.a((String)localObject);
    }
    paramAbsBaseArticleInfo.waterFallPic = localWaterFallPic;
    a(paramAbsBaseArticleInfo.waterFallPic);
  }
  
  public ReadInJoyPicWaterFallFragment.BaseViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return null;
      }
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment.a()).inflate(2131560256, null);
      paramViewGroup = new ReadInJoyPicWaterFallFragment.ActiveViewHolder(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment.a();
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment.a()).inflate(2131560255, null);
    paramViewGroup = new ReadInJoyPicWaterFallFragment.NormalViewHolder(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment, paramViewGroup);
    paramViewGroup.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment.a();
    return paramViewGroup;
  }
  
  public void a(ReadInJoyPicWaterFallFragment.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    if (this.e == 0)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInjoyXRecyclerView.getWidth();
      i = j;
      StringBuilder localStringBuilder;
      if (j <= 0)
      {
        if (ScreenUtil.SCREEN_WIDTH > 0) {
          i = ScreenUtil.SCREEN_WIDTH;
        } else {
          i = 1080;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getRecyclerView width error, getScreenWidth : ");
        localStringBuilder.append(i);
        localStringBuilder.append(", layoutWidth : ");
        localStringBuilder.append(j);
        QLog.d("ReadInJoyPicWaterFallFragment", 1, localStringBuilder.toString());
      }
      this.e = ((i - this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment.c * 2 - this.b * 2 * this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment.jdField_a_of_type_Int) / 2);
      i = this.e;
      this.c = ((int)(i * 0.52F));
      this.d = ((int)(i * 1.33F));
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("itemWidth = ");
        localStringBuilder.append(this.e);
        localStringBuilder.append(",minImgHeight = ");
        localStringBuilder.append(this.c);
        localStringBuilder.append(",maxImgHeight = ");
        localStringBuilder.append(this.d);
        QLog.d("ReadInJoyPicWaterFallFragment", 2, localStringBuilder.toString());
      }
    }
    int i = getItemViewType(paramInt);
    if (i != 1)
    {
      if (i == 2) {
        a((ReadInJoyPicWaterFallFragment.ActiveViewHolder)paramBaseViewHolder, paramInt);
      }
    }
    else {
      a((ReadInJoyPicWaterFallFragment.NormalViewHolder)paramBaseViewHolder, paramInt);
    }
    paramBaseViewHolder = (AbsBaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment.a(paramBaseViewHolder, paramInt);
  }
  
  public void a(List<AbsBaseArticleInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    paramInt = ((AbsBaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).mGalleryFeedsInfo.enum_article_style.get();
    if (paramInt == 4) {
      return 1;
    }
    if (paramInt == 5) {
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.WaterFallPicAdapter
 * JD-Core Version:    0.7.0.1
 */