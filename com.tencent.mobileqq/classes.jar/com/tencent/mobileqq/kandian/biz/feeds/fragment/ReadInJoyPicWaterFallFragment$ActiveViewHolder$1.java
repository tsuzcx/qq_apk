package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils.ReportData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

class ReadInJoyPicWaterFallFragment$ActiveViewHolder$1
  implements View.OnClickListener
{
  ReadInJoyPicWaterFallFragment$ActiveViewHolder$1(ReadInJoyPicWaterFallFragment.ActiveViewHolder paramActiveViewHolder, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = this.b.g.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
    Object localObject;
    if (TextUtils.isEmpty(paramView))
    {
      localObject = this.b.g.mArticleContentUrl;
      if (!TextUtils.isEmpty(paramView))
      {
        paramView = new Intent(this.b.d, QQBrowserActivity.class);
        paramView.putExtra("url", (String)localObject);
        this.b.d.startActivity(paramView);
      }
    }
    else
    {
      localObject = new Intent(this.b.d, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.b.d.startActivity((Intent)localObject);
    }
    this.b.f.setTextColor(ReadInJoyPicWaterFallFragment.v);
    ReadInJoyLogicEngine.a().a(this.b.g.mArticleID, System.currentTimeMillis());
    paramView = GalleryReportedUtils.a(this.b.c.v(), this.b.c.d(), 16, this.b.a(), this.b.g);
    try
    {
      paramView.put("card_type", 12);
      localObject = new GalleryReportedUtils.ReportData(this.b.g);
      ((GalleryReportedUtils.ReportData)localObject).f = String.valueOf(this.b.g.mArticleID);
      ((GalleryReportedUtils.ReportData)localObject).g = String.valueOf(this.b.g.mStrategyId);
      ((GalleryReportedUtils.ReportData)localObject).h = paramView.toString();
      if (this.b.g.mSocialFeedInfo.c != null) {
        ((GalleryReportedUtils.ReportData)localObject).b = String.valueOf(this.b.g.mSocialFeedInfo.c.a);
      }
      ((GalleryReportedUtils.ReportData)localObject).c = "0X8008E2F";
      ((GalleryReportedUtils.ReportData)localObject).d = "0X8008E2F";
      GalleryReportedUtils.a((GalleryReportedUtils.ReportData)localObject);
      ReadInJoyPicWaterFallFragment.a(this.b.g, this.b.c.d(), 1009);
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.ActiveViewHolder.1
 * JD-Core Version:    0.7.0.1
 */