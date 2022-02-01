package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils.ReportData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

class ReadInJoyPicWaterFallFragment$NormalViewHolder$3
  implements View.OnClickListener
{
  ReadInJoyPicWaterFallFragment$NormalViewHolder$3(ReadInJoyPicWaterFallFragment.NormalViewHolder paramNormalViewHolder, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mGalleryFeedsInfo.bytes_attachment_jump_url.get().toStringUtf8());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    paramView = GalleryReportedUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment.b(), 3, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    try
    {
      paramView.put("exptime", System.currentTimeMillis());
      paramView.put("proxy_bytes", this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.galleryReprotExdData);
      paramView.put("operation_id", this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mGalleryFeedsInfo.bytes_operation_id.get().toStringUtf8());
      GalleryReportedUtils.ReportData localReportData = new GalleryReportedUtils.ReportData(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      localReportData.e = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID);
      localReportData.f = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId);
      localReportData.g = paramView.toString();
      localReportData.a = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.publishUin);
      localReportData.b = "0X8009A7B";
      localReportData.c = "0X8009A7B";
      GalleryReportedUtils.a(localReportData);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.NormalViewHolder.3
 * JD-Core Version:    0.7.0.1
 */