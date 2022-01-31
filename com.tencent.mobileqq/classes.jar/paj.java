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
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;
import tencent.im.oidb.gallery.galleryFeeds.Picture;
import tencent.im.oidb.gallery.galleryFeeds.UserInfo;

public class paj
  extends RecyclerView.Adapter<ozy>
{
  public final int a;
  List<BaseArticleInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  int b;
  int c;
  int d;
  int e;
  
  public paj(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment)
  {
    this.jdField_a_of_type_Int = bcwh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity(), 150.0F);
    this.b = aekt.a(3.0F, paramReadInJoyPicWaterFallFragment.getResources());
    this.c = aekt.a(58.5F, paramReadInJoyPicWaterFallFragment.getResources());
    this.d = aekt.a(226.0F, paramReadInJoyPicWaterFallFragment.getResources());
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.waterFallPic != null) {
      return;
    }
    Object localObject = (galleryFeeds.Picture)paramBaseArticleInfo.mGalleryFeedsInfo.msg_custom_cover.get();
    pai localpai = new pai();
    if (localObject != null)
    {
      int i = (int)((galleryFeeds.Picture)localObject).uint64_width.get();
      int j = (int)((galleryFeeds.Picture)localObject).uint64_height.get();
      localpai.jdField_a_of_type_Int = i;
      localpai.b = j;
    }
    for (localpai.jdField_a_of_type_JavaNetURL = ors.a(((galleryFeeds.Picture)localObject).bytes_pic_url.get().toStringUtf8());; localpai.jdField_a_of_type_JavaNetURL = ors.a((String)localObject))
    {
      paramBaseArticleInfo.waterFallPic = localpai;
      a(paramBaseArticleInfo.waterFallPic);
      return;
      localObject = paramBaseArticleInfo.mFirstPagePicUrl;
      localpai.jdField_a_of_type_Int = -1;
      localpai.b = -1;
    }
  }
  
  private void a(ozw paramozw, int paramInt)
  {
    int i = -1;
    Object localObject1 = (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramozw.itemView.getLayoutParams() == null)
    {
      localObject2 = new StaggeredGridLayoutManager.LayoutParams(-1, aekt.a(314.0F, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getResources()));
      paramozw.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    paramozw.jdField_a_of_type_AndroidWidgetTextView.setText(((BaseArticleInfo)localObject1).mTitle);
    Object localObject2 = paramozw.jdField_a_of_type_AndroidWidgetTextView;
    paramInt = i;
    if (owy.a().a(((BaseArticleInfo)localObject1).mArticleID)) {
      paramInt = ReadInJoyPicWaterFallFragment.c;
    }
    ((TextView)localObject2).setTextColor(paramInt);
    paramozw.jdField_b_of_type_ComTencentImageURLImageView.setContentDescription(((BaseArticleInfo)localObject1).getSubscribeName());
    orc.a(paramozw.jdField_b_of_type_ComTencentImageURLImageView, ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_topic_pic_url.get().toStringUtf8(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity());
    paramozw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)localObject1);
    localObject1 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_topic_icon_url.get().toStringUtf8();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramozw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject1 = baul.a((String)localObject1);
      paramozw.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      return;
    }
    paramozw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(pac parampac, int paramInt)
  {
    Object localObject1 = (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    a((BaseArticleInfo)localObject1);
    Object localObject2 = (FrameLayout.LayoutParams)parampac.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams();
    label107:
    int i;
    label153:
    label331:
    Object localObject3;
    if (localObject2 == null)
    {
      localObject2 = new FrameLayout.LayoutParams(-1, ((BaseArticleInfo)localObject1).waterFallPic.c);
      parampac.jdField_b_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (((BaseArticleInfo)localObject1).waterFallPic.d <= this.d) {
        break label819;
      }
      parampac.jdField_b_of_type_ComTencentImageURLImageView.setPadding(0, ((BaseArticleInfo)localObject1).waterFallPic.d - ((BaseArticleInfo)localObject1).waterFallPic.c, 0, 0);
      parampac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)localObject1);
      parampac.jdField_a_of_type_AndroidWidgetTextView.setText(((BaseArticleInfo)localObject1).mTitle);
      boolean bool = owy.a().a(((BaseArticleInfo)localObject1).mArticleID);
      localObject2 = parampac.jdField_a_of_type_AndroidWidgetTextView;
      if (!bool) {
        break label833;
      }
      i = ReadInJoyPicWaterFallFragment.c;
      ((TextView)localObject2).setTextColor(i);
      parampac.jdField_b_of_type_ComTencentImageURLImageView.setContentDescription(((BaseArticleInfo)localObject1).getSubscribeName());
      orc.a(parampac.jdField_b_of_type_ComTencentImageURLImageView, ((BaseArticleInfo)localObject1).waterFallPic.jdField_a_of_type_JavaNetURL, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity());
      parampac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
      parampac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(((BaseArticleInfo)localObject1).getSubscribeName());
      parampac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setContentDescription(((BaseArticleInfo)localObject1).getSubscribeName());
      parampac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
      if (((BaseArticleInfo)localObject1).mGalleryFeedsInfo.uint32_is_account_derelict.get() != 1) {
        break label844;
      }
      parampac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setImageResource(2130845836);
      label261:
      if (((BaseArticleInfo)localObject1).mSocialFeedInfo == null) {
        break label969;
      }
      parampac.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject2 = bjxj.a(((BaseArticleInfo)localObject1).mSocialFeedInfo.b, 999000L, "99.9万", "0");
      parampac.jdField_b_of_type_AndroidWidgetTextView.setText((String)localObject2 + alpo.a(2131713363));
      if (((BaseArticleInfo)localObject1).mGalleryPicNumber <= 1) {
        break label981;
      }
      parampac.c.setVisibility(0);
      parampac.c.setText(String.valueOf(((BaseArticleInfo)localObject1).mGalleryPicNumber) + alpo.a(2131713265));
      label385:
      if (((BaseArticleInfo)localObject1).mGalleryFeedsInfo == null) {
        break label1025;
      }
      localObject2 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_content.get().toStringUtf8();
      localObject3 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_jump_url.get().toStringUtf8();
      String str = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_icon_url.get().toStringUtf8();
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty(str))) {
        break label1003;
      }
      parampac.jdField_a_of_type_AndroidViewView.setVisibility(0);
      parampac.d.setText((CharSequence)localObject2);
      localObject2 = baul.a(str);
      parampac.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      localObject2 = opn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity(), ReadInJoyPicWaterFallFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment), 3, paramInt, (ArticleInfo)localObject1);
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
          localObject3 = new opp((BaseArticleInfo)localObject1);
          ((opp)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)localObject1);
          ((opp)localObject3).e = String.valueOf(((BaseArticleInfo)localObject1).mArticleID);
          ((opp)localObject3).f = String.valueOf(((BaseArticleInfo)localObject1).mAlgorithmID);
          ((opp)localObject3).g = ((JSONObject)localObject2).toString();
          if (((BaseArticleInfo)localObject1).mSocialFeedInfo.a != null) {
            ((opp)localObject3).jdField_a_of_type_JavaLangString = String.valueOf(((BaseArticleInfo)localObject1).mSocialFeedInfo.a.a);
          }
          ((opp)localObject3).b = "0X8009A7A";
          ((opp)localObject3).c = "0X8009A7A";
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.jdField_a_of_type_Opk.a("exp_waterfall_operation", localObject3);
        }
        catch (JSONException localJSONException)
        {
          label819:
          label833:
          label844:
          localJSONException.printStackTrace();
          continue;
        }
        localObject2 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_note_content.get().toStringUtf8();
        localObject1 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_note_icon_url.get().toStringUtf8();
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label1015;
        }
        parampac.jdField_b_of_type_AndroidViewView.setVisibility(0);
        parampac.e.setText((CharSequence)localObject2);
        localObject1 = baul.a((String)localObject1);
        parampac.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        return;
        if ((((FrameLayout.LayoutParams)localObject2).height > 0) && (((FrameLayout.LayoutParams)localObject2).height == ((BaseArticleInfo)localObject1).waterFallPic.c)) {
          break;
        }
        ((FrameLayout.LayoutParams)localObject2).height = ((BaseArticleInfo)localObject1).waterFallPic.c;
        parampac.jdField_b_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break;
        parampac.jdField_b_of_type_ComTencentImageURLImageView.setPadding(0, 0, 0, 0);
        break label107;
        i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.e;
        break label153;
        localObject2 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.msg_publisher_info.bytes_header_url.get().toStringUtf8();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        i = aekt.a(12.0F, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getResources());
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i;
        try
        {
          localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
          parampac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setImageDrawable((Drawable)localObject2);
        }
        catch (Exception localException)
        {
          QLog.e("ReadInJoyPicWaterFallFragment", 1, "bindNormalHolder, e = " + localException);
        }
      }
      break label261;
      parampac.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setImageResource(2130845836);
      break label261;
      label969:
      parampac.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label331;
      label981:
      parampac.c.setVisibility(8);
      break label385;
      label1003:
      parampac.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    label1015:
    parampac.jdField_b_of_type_AndroidViewView.setVisibility(8);
    return;
    label1025:
    parampac.jdField_b_of_type_AndroidViewView.setVisibility(8);
    parampac.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void a(pai parampai)
  {
    if (parampai.jdField_a_of_type_Int > 0)
    {
      i = (int)(this.e / parampai.jdField_a_of_type_Int * parampai.b);
      parampai.d = i;
      if ((i >= this.c) && (i <= this.d)) {
        parampai.c = i;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyPicWaterFallFragment", 2, "WaterFallPic = " + parampai.toString());
        }
        return;
        if (i < this.c) {
          parampai.c = this.c;
        } else {
          parampai.c = this.d;
        }
      }
    }
    if (this.e != 0) {}
    for (int i = this.e;; i = this.jdField_a_of_type_Int)
    {
      parampai.c = i;
      break;
    }
  }
  
  public ozy a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity()).inflate(2131560088, null);
      paramViewGroup = new pac(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity();
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity()).inflate(2131560089, null);
    paramViewGroup = new ozw(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment, paramViewGroup);
    paramViewGroup.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity();
    return paramViewGroup;
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(ozy paramozy, int paramInt)
  {
    int j;
    int i;
    if (this.e == 0)
    {
      j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.getWidth();
      if (j > 0) {
        break label275;
      }
      if (azgq.jdField_a_of_type_Int <= 0) {
        break label244;
      }
      i = azgq.jdField_a_of_type_Int;
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
        paramozy = (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(paramozy, paramInt);
        return;
        label244:
        i = 1080;
        break;
        a((pac)paramozy, paramInt);
        continue;
        a((ozw)paramozy, paramInt);
      }
      label275:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     paj
 * JD-Core Version:    0.7.0.1
 */