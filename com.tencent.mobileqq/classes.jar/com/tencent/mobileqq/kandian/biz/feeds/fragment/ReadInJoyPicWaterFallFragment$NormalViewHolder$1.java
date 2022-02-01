package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils.ReportData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

class ReadInJoyPicWaterFallFragment$NormalViewHolder$1
  implements View.OnClickListener
{
  ReadInJoyPicWaterFallFragment$NormalViewHolder$1(ReadInJoyPicWaterFallFragment.NormalViewHolder paramNormalViewHolder, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = this.b.g.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
    if (!TextUtils.isEmpty(paramView))
    {
      ReadInJoyUtils.a(this.b.d, paramView);
      paramView = GalleryReportedUtils.a(this.b.r.v(), this.b.r.d(), 16, this.b.a(), this.b.g);
      try
      {
        paramView.put("card_type", 8);
        GalleryReportedUtils.ReportData localReportData = new GalleryReportedUtils.ReportData(this.b.g);
        localReportData.f = String.valueOf(this.b.g.mArticleID);
        localReportData.g = String.valueOf(this.b.g.mStrategyId);
        localReportData.h = paramView.toString();
        localReportData.b = String.valueOf(this.b.g.publishUin);
        localReportData.c = "0X8008E2F";
        localReportData.d = "0X8008E2F";
        GalleryReportedUtils.a(localReportData);
      }
      catch (JSONException paramView)
      {
        paramView.printStackTrace();
      }
    }
    ReadInJoyPicWaterFallFragment.a(this.b.g, this.b.r.d(), 1008);
    this.b.f.setTextColor(ReadInJoyPicWaterFallFragment.v);
    ReadInJoyLogicEngine.a().a(this.b.g.mArticleID, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.NormalViewHolder.1
 * JD-Core Version:    0.7.0.1
 */