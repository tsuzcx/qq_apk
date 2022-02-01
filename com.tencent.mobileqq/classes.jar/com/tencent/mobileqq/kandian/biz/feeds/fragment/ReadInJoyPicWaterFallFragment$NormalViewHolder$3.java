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
    paramView = new Intent(this.b.d, QQBrowserActivity.class);
    paramView.putExtra("url", this.b.g.mGalleryFeedsInfo.bytes_attachment_jump_url.get().toStringUtf8());
    this.b.d.startActivity(paramView);
    paramView = GalleryReportedUtils.a(this.b.d, this.b.r.d(), 3, this.b.a(), this.b.g);
    try
    {
      paramView.put("exptime", System.currentTimeMillis());
      paramView.put("proxy_bytes", this.b.g.galleryReprotExdData);
      paramView.put("operation_id", this.b.g.mGalleryFeedsInfo.bytes_operation_id.get().toStringUtf8());
      GalleryReportedUtils.ReportData localReportData = new GalleryReportedUtils.ReportData(this.b.g);
      localReportData.f = String.valueOf(this.b.g.mArticleID);
      localReportData.g = String.valueOf(this.b.g.mStrategyId);
      localReportData.h = paramView.toString();
      localReportData.b = String.valueOf(this.b.g.publishUin);
      localReportData.c = "0X8009A7B";
      localReportData.d = "0X8009A7B";
      GalleryReportedUtils.a(localReportData);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.NormalViewHolder.3
 * JD-Core Version:    0.7.0.1
 */