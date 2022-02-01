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
  public final int a = DisplayUtil.a(this.g.v(), 150.0F);
  List<AbsBaseArticleInfo> b = new ArrayList();
  int c;
  int d;
  int e;
  int f;
  
  public ReadInJoyPicWaterFallFragment$WaterFallPicAdapter(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment)
  {
    this.c = AIOUtils.b(3.0F, paramReadInJoyPicWaterFallFragment.getResources());
    this.d = AIOUtils.b(58.5F, paramReadInJoyPicWaterFallFragment.getResources());
    this.e = AIOUtils.b(226.0F, paramReadInJoyPicWaterFallFragment.getResources());
  }
  
  private void a(ReadInJoyPicWaterFallFragment.ActiveViewHolder paramActiveViewHolder, int paramInt)
  {
    Object localObject1 = (AbsBaseArticleInfo)this.b.get(paramInt);
    Object localObject2 = paramActiveViewHolder.itemView.getLayoutParams();
    paramInt = -1;
    if (localObject2 == null)
    {
      localObject2 = new StaggeredGridLayoutManager.LayoutParams(-1, AIOUtils.b(314.0F, this.g.getResources()));
      paramActiveViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    paramActiveViewHolder.f.setText(((AbsBaseArticleInfo)localObject1).mTitle);
    localObject2 = paramActiveViewHolder.f;
    if (ReadInJoyLogicEngine.a().a(((AbsBaseArticleInfo)localObject1).mArticleID)) {
      paramInt = ReadInJoyPicWaterFallFragment.v;
    }
    ((TextView)localObject2).setTextColor(paramInt);
    paramActiveViewHolder.e.setContentDescription(((AbsBaseArticleInfo)localObject1).getSubscribeName());
    localObject2 = RIJConvertString2URL.b(((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_topic_pic_url.get().toStringUtf8());
    ReadInJoyDisplayUtils.a(paramActiveViewHolder.e, (URL)localObject2, this.g.v());
    paramActiveViewHolder.g = ((AbsBaseArticleInfo)localObject1);
    localObject1 = ((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_topic_icon_url.get().toStringUtf8();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramActiveViewHolder.a.setVisibility(0);
      localObject1 = URLDrawableHelper.getDrawable((String)localObject1);
      paramActiveViewHolder.a.setImageDrawable((Drawable)localObject1);
      return;
    }
    paramActiveViewHolder.a.setVisibility(8);
  }
  
  private void a(ReadInJoyPicWaterFallFragment.NormalViewHolder paramNormalViewHolder, int paramInt)
  {
    Object localObject1 = (AbsBaseArticleInfo)this.b.get(paramInt);
    a((AbsBaseArticleInfo)localObject1);
    Object localObject2 = (FrameLayout.LayoutParams)paramNormalViewHolder.e.getLayoutParams();
    if (localObject2 == null)
    {
      localObject2 = new FrameLayout.LayoutParams(-1, ((AbsBaseArticleInfo)localObject1).waterFallPic.d);
      paramNormalViewHolder.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    else if ((((FrameLayout.LayoutParams)localObject2).height <= 0) || (((FrameLayout.LayoutParams)localObject2).height != ((AbsBaseArticleInfo)localObject1).waterFallPic.d))
    {
      ((FrameLayout.LayoutParams)localObject2).height = ((AbsBaseArticleInfo)localObject1).waterFallPic.d;
      paramNormalViewHolder.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    if (((AbsBaseArticleInfo)localObject1).waterFallPic.e > this.e) {
      paramNormalViewHolder.e.setPadding(0, ((AbsBaseArticleInfo)localObject1).waterFallPic.e - ((AbsBaseArticleInfo)localObject1).waterFallPic.d, 0, 0);
    } else {
      paramNormalViewHolder.e.setPadding(0, 0, 0, 0);
    }
    paramNormalViewHolder.g = ((AbsBaseArticleInfo)localObject1);
    paramNormalViewHolder.f.setText(((AbsBaseArticleInfo)localObject1).mTitle);
    boolean bool = ReadInJoyLogicEngine.a().a(((AbsBaseArticleInfo)localObject1).mArticleID);
    localObject2 = paramNormalViewHolder.f;
    int i;
    if (bool) {
      i = ReadInJoyPicWaterFallFragment.v;
    } else {
      i = ReadInJoyPicWaterFallFragment.w;
    }
    ((TextView)localObject2).setTextColor(i);
    paramNormalViewHolder.e.setContentDescription(((AbsBaseArticleInfo)localObject1).getSubscribeName());
    ReadInJoyDisplayUtils.a(paramNormalViewHolder.e, ((AbsBaseArticleInfo)localObject1).waterFallPic.a, this.g.v());
    paramNormalViewHolder.a.setVisibility(0);
    paramNormalViewHolder.a.setText(((AbsBaseArticleInfo)localObject1).getSubscribeName());
    paramNormalViewHolder.a.setContentDescription(((AbsBaseArticleInfo)localObject1).getSubscribeName());
    paramNormalViewHolder.a.getPaint().setFakeBoldText(true);
    Object localObject4;
    if (((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo.uint32_is_account_derelict.get() == 1)
    {
      paramNormalViewHolder.b.setImageResource(2130848156);
    }
    else
    {
      localObject2 = ((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo.msg_publisher_info.bytes_header_url.get().toStringUtf8();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        i = AIOUtils.b(12.0F, this.g.getResources());
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = i;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = i;
        try
        {
          localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject4);
          paramNormalViewHolder.b.setImageDrawable((Drawable)localObject2);
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
        paramNormalViewHolder.b.setImageResource(2130848156);
      }
    }
    Object localObject3;
    Object localObject5;
    if (((AbsBaseArticleInfo)localObject1).mSocialFeedInfo != null)
    {
      paramNormalViewHolder.c.setVisibility(0);
      localObject3 = ReadInJoyHelper.a(((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.h, 999000L, "99.9万", "0");
      localObject4 = paramNormalViewHolder.c;
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append((String)localObject3);
      ((StringBuilder)localObject5).append(HardCodeUtil.a(2131910492));
      ((TextView)localObject4).setText(((StringBuilder)localObject5).toString());
    }
    else
    {
      paramNormalViewHolder.c.setVisibility(8);
    }
    if (((AbsBaseArticleInfo)localObject1).mGalleryPicNumber > 1)
    {
      paramNormalViewHolder.i.setVisibility(0);
      localObject3 = paramNormalViewHolder.i;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(((AbsBaseArticleInfo)localObject1).mGalleryPicNumber);
      ((StringBuilder)localObject4).append(HardCodeUtil.a(2131910401));
      ((TextView)localObject3).setText(((StringBuilder)localObject4).toString());
    }
    else
    {
      paramNormalViewHolder.i.setVisibility(8);
    }
    if (((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo != null)
    {
      localObject3 = ((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_content.get().toStringUtf8();
      localObject4 = ((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_jump_url.get().toStringUtf8();
      localObject5 = ((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_icon_url.get().toStringUtf8();
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
      {
        paramNormalViewHolder.l.setVisibility(0);
        paramNormalViewHolder.j.setText((CharSequence)localObject3);
        localObject3 = URLDrawableHelper.getDrawable((String)localObject5);
        paramNormalViewHolder.k.setImageDrawable((Drawable)localObject3);
        localObject3 = GalleryReportedUtils.a(this.g.v(), ReadInJoyPicWaterFallFragment.c(this.g), 3, paramInt, (AbsBaseArticleInfo)localObject1);
        try
        {
          ((JSONObject)localObject3).put("exptime", System.currentTimeMillis());
          ((JSONObject)localObject3).put("proxy_bytes", ((AbsBaseArticleInfo)localObject1).galleryReprotExdData);
          ((JSONObject)localObject3).put("operation_id", ((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_operation_id.get().toStringUtf8());
          localObject4 = new GalleryReportedUtils.ReportData((AbsBaseArticleInfo)localObject1);
          ((GalleryReportedUtils.ReportData)localObject4).a = ((AbsBaseArticleInfo)localObject1);
          ((GalleryReportedUtils.ReportData)localObject4).f = String.valueOf(((AbsBaseArticleInfo)localObject1).mArticleID);
          ((GalleryReportedUtils.ReportData)localObject4).g = String.valueOf(((AbsBaseArticleInfo)localObject1).mAlgorithmID);
          ((GalleryReportedUtils.ReportData)localObject4).h = ((JSONObject)localObject3).toString();
          if (((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.c != null) {
            ((GalleryReportedUtils.ReportData)localObject4).b = String.valueOf(((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.c.a);
          }
          ((GalleryReportedUtils.ReportData)localObject4).c = "0X8009A7A";
          ((GalleryReportedUtils.ReportData)localObject4).d = "0X8009A7A";
          this.g.u.trigger("exp_waterfall_operation", localObject4);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      else
      {
        paramNormalViewHolder.l.setVisibility(8);
      }
      String str = ((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_note_content.get().toStringUtf8();
      localObject1 = ((AbsBaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_note_icon_url.get().toStringUtf8();
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        paramNormalViewHolder.m.setVisibility(0);
        paramNormalViewHolder.o.setText(str);
        localObject1 = URLDrawableHelper.getDrawable((String)localObject1);
        paramNormalViewHolder.n.setImageDrawable((Drawable)localObject1);
        return;
      }
      paramNormalViewHolder.m.setVisibility(8);
      return;
    }
    paramNormalViewHolder.m.setVisibility(8);
    paramNormalViewHolder.l.setVisibility(8);
  }
  
  private void a(WaterFallPic paramWaterFallPic)
  {
    int i;
    if (paramWaterFallPic.b > 0)
    {
      i = (int)(this.f / paramWaterFallPic.b * paramWaterFallPic.c);
      paramWaterFallPic.e = i;
      if ((i >= this.d) && (i <= this.e))
      {
        paramWaterFallPic.d = i;
      }
      else
      {
        int j = this.d;
        if (i < j) {
          paramWaterFallPic.d = j;
        } else {
          paramWaterFallPic.d = this.e;
        }
      }
    }
    else
    {
      i = this.f;
      if (i == 0) {
        i = this.a;
      }
      paramWaterFallPic.d = i;
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
      localWaterFallPic.b = i;
      localWaterFallPic.c = j;
      localWaterFallPic.a = RIJConvertString2URL.b(((galleryFeeds.Picture)localObject).bytes_pic_url.get().toStringUtf8());
    }
    else
    {
      localObject = paramAbsBaseArticleInfo.mFirstPagePicUrl;
      localWaterFallPic.b = -1;
      localWaterFallPic.c = -1;
      localWaterFallPic.a = RIJConvertString2URL.b((String)localObject);
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
      paramViewGroup = LayoutInflater.from(this.g.v()).inflate(2131626303, null);
      paramViewGroup = new ReadInJoyPicWaterFallFragment.ActiveViewHolder(this.g, paramViewGroup);
      paramViewGroup.d = this.g.v();
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(this.g.v()).inflate(2131626302, null);
    paramViewGroup = new ReadInJoyPicWaterFallFragment.NormalViewHolder(this.g, paramViewGroup);
    paramViewGroup.d = this.g.v();
    return paramViewGroup;
  }
  
  public void a(ReadInJoyPicWaterFallFragment.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    if (this.f == 0)
    {
      int j = this.g.n.getWidth();
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
      this.f = ((i - this.g.q * 2 - this.c * 2 * this.g.m) / 2);
      i = this.f;
      this.d = ((int)(i * 0.52F));
      this.e = ((int)(i * 1.33F));
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("itemWidth = ");
        localStringBuilder.append(this.f);
        localStringBuilder.append(",minImgHeight = ");
        localStringBuilder.append(this.d);
        localStringBuilder.append(",maxImgHeight = ");
        localStringBuilder.append(this.e);
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
    paramBaseViewHolder = (AbsBaseArticleInfo)this.b.get(paramInt);
    this.g.a(paramBaseViewHolder, paramInt);
  }
  
  public void a(List<AbsBaseArticleInfo> paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    paramInt = ((AbsBaseArticleInfo)this.b.get(paramInt)).mGalleryFeedsInfo.enum_article_style.get();
    if (paramInt == 4) {
      return 1;
    }
    if (paramInt == 5) {
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.WaterFallPicAdapter
 * JD-Core Version:    0.7.0.1
 */