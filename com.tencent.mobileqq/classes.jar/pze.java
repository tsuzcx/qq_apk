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
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.HeadImageWithRing;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;
import tencent.im.oidb.gallery.galleryFeeds.Picture;
import tencent.im.oidb.gallery.galleryFeeds.UserInfo;

public class pze
  extends RecyclerView.Adapter<pyt>
{
  public final int a;
  List<BaseArticleInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  int b;
  int c;
  int d;
  int e;
  
  public pze(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment)
  {
    this.jdField_a_of_type_Int = DisplayUtil.dip2px(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity(), 150.0F);
    this.b = AIOUtils.dp2px(3.0F, paramReadInJoyPicWaterFallFragment.getResources());
    this.c = AIOUtils.dp2px(58.5F, paramReadInJoyPicWaterFallFragment.getResources());
    this.d = AIOUtils.dp2px(226.0F, paramReadInJoyPicWaterFallFragment.getResources());
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.waterFallPic != null) {
      return;
    }
    Object localObject = (galleryFeeds.Picture)paramBaseArticleInfo.mGalleryFeedsInfo.msg_custom_cover.get();
    pzd localpzd = new pzd();
    if (localObject != null)
    {
      int i = (int)((galleryFeeds.Picture)localObject).uint64_width.get();
      int j = (int)((galleryFeeds.Picture)localObject).uint64_height.get();
      localpzd.jdField_a_of_type_Int = i;
      localpzd.b = j;
    }
    for (localpzd.jdField_a_of_type_JavaNetURL = pqa.a(((galleryFeeds.Picture)localObject).bytes_pic_url.get().toStringUtf8());; localpzd.jdField_a_of_type_JavaNetURL = pqa.a((String)localObject))
    {
      paramBaseArticleInfo.waterFallPic = localpzd;
      a(paramBaseArticleInfo.waterFallPic);
      return;
      localObject = paramBaseArticleInfo.mFirstPagePicUrl;
      localpzd.jdField_a_of_type_Int = -1;
      localpzd.b = -1;
    }
  }
  
  private void a(pyr parampyr, int paramInt)
  {
    int i = -1;
    Object localObject1 = (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (parampyr.itemView.getLayoutParams() == null)
    {
      localObject2 = new StaggeredGridLayoutManager.LayoutParams(-1, AIOUtils.dp2px(314.0F, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getResources()));
      parampyr.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    parampyr.jdField_a_of_type_AndroidWidgetTextView.setText(((BaseArticleInfo)localObject1).mTitle);
    Object localObject2 = parampyr.jdField_a_of_type_AndroidWidgetTextView;
    paramInt = i;
    if (pvj.a().a(((BaseArticleInfo)localObject1).mArticleID)) {
      paramInt = ReadInJoyPicWaterFallFragment.c;
    }
    ((TextView)localObject2).setTextColor(paramInt);
    parampyr.jdField_b_of_type_ComTencentImageURLImageView.setContentDescription(((BaseArticleInfo)localObject1).getSubscribeName());
    pjr.a(parampyr.jdField_b_of_type_ComTencentImageURLImageView, ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_topic_pic_url.get().toStringUtf8(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity());
    parampyr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)localObject1);
    localObject1 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_topic_icon_url.get().toStringUtf8();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      parampyr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject1 = URLDrawableHelper.getDrawable((String)localObject1);
      parampyr.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      return;
    }
    parampyr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(pyx parampyx, int paramInt)
  {
    Object localObject1 = (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    a((BaseArticleInfo)localObject1);
    Object localObject2 = (FrameLayout.LayoutParams)parampyx.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams();
    label107:
    int i;
    label153:
    label331:
    label382:
    Object localObject3;
    if (localObject2 == null)
    {
      localObject2 = new FrameLayout.LayoutParams(-1, ((BaseArticleInfo)localObject1).waterFallPic.c);
      parampyx.jdField_b_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (((BaseArticleInfo)localObject1).waterFallPic.d <= this.d) {
        break label816;
      }
      parampyx.jdField_b_of_type_ComTencentImageURLImageView.setPadding(0, ((BaseArticleInfo)localObject1).waterFallPic.d - ((BaseArticleInfo)localObject1).waterFallPic.c, 0, 0);
      parampyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)localObject1);
      parampyx.jdField_a_of_type_AndroidWidgetTextView.setText(((BaseArticleInfo)localObject1).mTitle);
      boolean bool = pvj.a().a(((BaseArticleInfo)localObject1).mArticleID);
      localObject2 = parampyx.jdField_a_of_type_AndroidWidgetTextView;
      if (!bool) {
        break label830;
      }
      i = ReadInJoyPicWaterFallFragment.c;
      ((TextView)localObject2).setTextColor(i);
      parampyx.jdField_b_of_type_ComTencentImageURLImageView.setContentDescription(((BaseArticleInfo)localObject1).getSubscribeName());
      pjr.a(parampyx.jdField_b_of_type_ComTencentImageURLImageView, ((BaseArticleInfo)localObject1).waterFallPic.jdField_a_of_type_JavaNetURL, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity());
      parampyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
      parampyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(((BaseArticleInfo)localObject1).getSubscribeName());
      parampyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setContentDescription(((BaseArticleInfo)localObject1).getSubscribeName());
      parampyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
      if (((BaseArticleInfo)localObject1).mGalleryFeedsInfo.uint32_is_account_derelict.get() != 1) {
        break label837;
      }
      parampyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setImageResource(2130846369);
      label261:
      if (((BaseArticleInfo)localObject1).mSocialFeedInfo == null) {
        break label962;
      }
      parampyx.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject2 = bmhv.a(((BaseArticleInfo)localObject1).mSocialFeedInfo.b, 999000L, "99.9万", "0");
      parampyx.jdField_b_of_type_AndroidWidgetTextView.setText((String)localObject2 + anvx.a(2131712442));
      if (((BaseArticleInfo)localObject1).mGalleryPicNumber <= 1) {
        break label974;
      }
      parampyx.c.setVisibility(0);
      parampyx.c.setText(((BaseArticleInfo)localObject1).mGalleryPicNumber + anvx.a(2131712344));
      if (((BaseArticleInfo)localObject1).mGalleryFeedsInfo == null) {
        break label1018;
      }
      localObject2 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_content.get().toStringUtf8();
      localObject3 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_jump_url.get().toStringUtf8();
      String str = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_icon_url.get().toStringUtf8();
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty(str))) {
        break label996;
      }
      parampyx.jdField_a_of_type_AndroidViewView.setVisibility(0);
      parampyx.d.setText((CharSequence)localObject2);
      localObject2 = URLDrawableHelper.getDrawable(str);
      parampyx.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      localObject2 = pih.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity(), ReadInJoyPicWaterFallFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment), 3, paramInt, (ArticleInfo)localObject1);
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          ((JSONObject)localObject2).put("exptime", System.currentTimeMillis());
          ((JSONObject)localObject2).put("proxy_bytes", ((BaseArticleInfo)localObject1).galleryReprotExdData);
          ((JSONObject)localObject2).put("operation_id", ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_operation_id.get().toStringUtf8());
          localObject3 = new pij((BaseArticleInfo)localObject1);
          ((pij)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)localObject1);
          ((pij)localObject3).e = String.valueOf(((BaseArticleInfo)localObject1).mArticleID);
          ((pij)localObject3).f = String.valueOf(((BaseArticleInfo)localObject1).mAlgorithmID);
          ((pij)localObject3).g = ((JSONObject)localObject2).toString();
          if (((BaseArticleInfo)localObject1).mSocialFeedInfo.a != null) {
            ((pij)localObject3).jdField_a_of_type_JavaLangString = String.valueOf(((BaseArticleInfo)localObject1).mSocialFeedInfo.a.a);
          }
          ((pij)localObject3).b = "0X8009A7A";
          ((pij)localObject3).c = "0X8009A7A";
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.jdField_a_of_type_Pie.a("exp_waterfall_operation", localObject3);
        }
        catch (JSONException localJSONException)
        {
          label816:
          label830:
          label837:
          localJSONException.printStackTrace();
          continue;
        }
        localObject2 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_note_content.get().toStringUtf8();
        localObject1 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_note_icon_url.get().toStringUtf8();
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label1008;
        }
        parampyx.jdField_b_of_type_AndroidViewView.setVisibility(0);
        parampyx.e.setText((CharSequence)localObject2);
        localObject1 = URLDrawableHelper.getDrawable((String)localObject1);
        parampyx.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        return;
        if ((((FrameLayout.LayoutParams)localObject2).height > 0) && (((FrameLayout.LayoutParams)localObject2).height == ((BaseArticleInfo)localObject1).waterFallPic.c)) {
          break;
        }
        ((FrameLayout.LayoutParams)localObject2).height = ((BaseArticleInfo)localObject1).waterFallPic.c;
        parampyx.jdField_b_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break;
        parampyx.jdField_b_of_type_ComTencentImageURLImageView.setPadding(0, 0, 0, 0);
        break label107;
        i = ReadInJoyPicWaterFallFragment.e;
        break label153;
        localObject2 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.msg_publisher_info.bytes_header_url.get().toStringUtf8();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        i = AIOUtils.dp2px(12.0F, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getResources());
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i;
        try
        {
          localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
          parampyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setImageDrawable((Drawable)localObject2);
        }
        catch (Exception localException)
        {
          QLog.e("ReadInJoyPicWaterFallFragment", 1, "bindNormalHolder, e = " + localException);
        }
      }
      break label261;
      parampyx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setImageResource(2130846369);
      break label261;
      label962:
      parampyx.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label331;
      label974:
      parampyx.c.setVisibility(8);
      break label382;
      label996:
      parampyx.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    label1008:
    parampyx.jdField_b_of_type_AndroidViewView.setVisibility(8);
    return;
    label1018:
    parampyx.jdField_b_of_type_AndroidViewView.setVisibility(8);
    parampyx.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void a(pzd parampzd)
  {
    if (parampzd.jdField_a_of_type_Int > 0)
    {
      i = (int)(this.e / parampzd.jdField_a_of_type_Int * parampzd.b);
      parampzd.d = i;
      if ((i >= this.c) && (i <= this.d)) {
        parampzd.c = i;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyPicWaterFallFragment", 2, "WaterFallPic = " + parampzd.toString());
        }
        return;
        if (i < this.c) {
          parampzd.c = this.c;
        } else {
          parampzd.c = this.d;
        }
      }
    }
    if (this.e != 0) {}
    for (int i = this.e;; i = this.jdField_a_of_type_Int)
    {
      parampzd.c = i;
      break;
    }
  }
  
  public pyt a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity()).inflate(2131560295, null);
      paramViewGroup = new pyx(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity();
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity()).inflate(2131560296, null);
    paramViewGroup = new pyr(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment, paramViewGroup);
    paramViewGroup.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity();
    return paramViewGroup;
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(pyt parampyt, int paramInt)
  {
    int j;
    int i;
    if (this.e == 0)
    {
      j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.getWidth();
      if (j > 0) {
        break label290;
      }
      if (ScreenUtil.SCREEN_WIDTH <= 0) {
        break label259;
      }
      i = ScreenUtil.SCREEN_WIDTH;
      QLog.d("ReadInJoyPicWaterFallFragment", 1, "getRecyclerView width error, getScreenWidth : " + i + ", layoutWidth : " + j);
    }
    for (;;)
    {
      this.e = ((i - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.b * 2 - this.b * 2 * this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.jdField_a_of_type_Int) / 2);
      this.c = ((int)(this.e * 0.52F));
      this.d = ((int)(this.e * 1.33F));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyPicWaterFallFragment", 2, "itemWidth = " + this.e + ",minImgHeight = " + this.c + ",maxImgHeight = " + this.d);
      }
      switch (getItemViewType(paramInt))
      {
      }
      for (;;)
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(localBaseArticleInfo, paramInt);
        EventCollector.getInstance().onRecyclerBindViewHolder(parampyt, paramInt, getItemId(paramInt));
        return;
        label259:
        i = 1080;
        break;
        a((pyx)parampyt, paramInt);
        continue;
        a((pyr)parampyt, paramInt);
      }
      label290:
      i = j;
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    paramInt = ((BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).mGalleryFeedsInfo.enum_article_style.get();
    if (paramInt == 4) {
      return 1;
    }
    if (paramInt == 5) {
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pze
 * JD-Core Version:    0.7.0.1
 */