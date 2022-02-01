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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;
import tencent.im.oidb.gallery.galleryFeeds.Picture;
import tencent.im.oidb.gallery.galleryFeeds.UserInfo;

public class piu
  extends RecyclerView.Adapter<pij>
{
  public final int a;
  List<BaseArticleInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  int b;
  int c;
  int d;
  int e;
  
  public piu(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment)
  {
    this.jdField_a_of_type_Int = bhgr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity(), 150.0F);
    this.b = agej.a(3.0F, paramReadInJoyPicWaterFallFragment.getResources());
    this.c = agej.a(58.5F, paramReadInJoyPicWaterFallFragment.getResources());
    this.d = agej.a(226.0F, paramReadInJoyPicWaterFallFragment.getResources());
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.waterFallPic != null) {
      return;
    }
    Object localObject = (galleryFeeds.Picture)paramBaseArticleInfo.mGalleryFeedsInfo.msg_custom_cover.get();
    pit localpit = new pit();
    if (localObject != null)
    {
      int i = (int)((galleryFeeds.Picture)localObject).uint64_width.get();
      int j = (int)((galleryFeeds.Picture)localObject).uint64_height.get();
      localpit.jdField_a_of_type_Int = i;
      localpit.b = j;
    }
    for (localpit.jdField_a_of_type_JavaNetURL = ozs.a(((galleryFeeds.Picture)localObject).bytes_pic_url.get().toStringUtf8());; localpit.jdField_a_of_type_JavaNetURL = ozs.a((String)localObject))
    {
      paramBaseArticleInfo.waterFallPic = localpit;
      a(paramBaseArticleInfo.waterFallPic);
      return;
      localObject = paramBaseArticleInfo.mFirstPagePicUrl;
      localpit.jdField_a_of_type_Int = -1;
      localpit.b = -1;
    }
  }
  
  private void a(pih parampih, int paramInt)
  {
    int i = -1;
    Object localObject1 = (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (parampih.itemView.getLayoutParams() == null)
    {
      localObject2 = new StaggeredGridLayoutManager.LayoutParams(-1, agej.a(314.0F, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getResources()));
      parampih.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    parampih.jdField_a_of_type_AndroidWidgetTextView.setText(((BaseArticleInfo)localObject1).mTitle);
    Object localObject2 = parampih.jdField_a_of_type_AndroidWidgetTextView;
    paramInt = i;
    if (pfa.a().a(((BaseArticleInfo)localObject1).mArticleID)) {
      paramInt = ReadInJoyPicWaterFallFragment.c;
    }
    ((TextView)localObject2).setTextColor(paramInt);
    parampih.jdField_b_of_type_ComTencentImageURLImageView.setContentDescription(((BaseArticleInfo)localObject1).getSubscribeName());
    ozc.a(parampih.jdField_b_of_type_ComTencentImageURLImageView, ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_topic_pic_url.get().toStringUtf8(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity());
    parampih.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)localObject1);
    localObject1 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_topic_icon_url.get().toStringUtf8();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      parampih.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject1 = beyq.a((String)localObject1);
      parampih.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      return;
    }
    parampih.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(pin parampin, int paramInt)
  {
    Object localObject1 = (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    a((BaseArticleInfo)localObject1);
    Object localObject2 = (FrameLayout.LayoutParams)parampin.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams();
    label107:
    int i;
    label153:
    label331:
    label382:
    Object localObject3;
    if (localObject2 == null)
    {
      localObject2 = new FrameLayout.LayoutParams(-1, ((BaseArticleInfo)localObject1).waterFallPic.c);
      parampin.jdField_b_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (((BaseArticleInfo)localObject1).waterFallPic.d <= this.d) {
        break label816;
      }
      parampin.jdField_b_of_type_ComTencentImageURLImageView.setPadding(0, ((BaseArticleInfo)localObject1).waterFallPic.d - ((BaseArticleInfo)localObject1).waterFallPic.c, 0, 0);
      parampin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)localObject1);
      parampin.jdField_a_of_type_AndroidWidgetTextView.setText(((BaseArticleInfo)localObject1).mTitle);
      boolean bool = pfa.a().a(((BaseArticleInfo)localObject1).mArticleID);
      localObject2 = parampin.jdField_a_of_type_AndroidWidgetTextView;
      if (!bool) {
        break label830;
      }
      i = ReadInJoyPicWaterFallFragment.c;
      ((TextView)localObject2).setTextColor(i);
      parampin.jdField_b_of_type_ComTencentImageURLImageView.setContentDescription(((BaseArticleInfo)localObject1).getSubscribeName());
      ozc.a(parampin.jdField_b_of_type_ComTencentImageURLImageView, ((BaseArticleInfo)localObject1).waterFallPic.jdField_a_of_type_JavaNetURL, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity());
      parampin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
      parampin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(((BaseArticleInfo)localObject1).getSubscribeName());
      parampin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setContentDescription(((BaseArticleInfo)localObject1).getSubscribeName());
      parampin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
      if (((BaseArticleInfo)localObject1).mGalleryFeedsInfo.uint32_is_account_derelict.get() != 1) {
        break label837;
      }
      parampin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setImageResource(2130846365);
      label261:
      if (((BaseArticleInfo)localObject1).mSocialFeedInfo == null) {
        break label962;
      }
      parampin.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject2 = bnrf.a(((BaseArticleInfo)localObject1).mSocialFeedInfo.b, 999000L, "99.9万", "0");
      parampin.jdField_b_of_type_AndroidWidgetTextView.setText((String)localObject2 + anzj.a(2131711863));
      if (((BaseArticleInfo)localObject1).mGalleryPicNumber <= 1) {
        break label974;
      }
      parampin.c.setVisibility(0);
      parampin.c.setText(((BaseArticleInfo)localObject1).mGalleryPicNumber + anzj.a(2131711765));
      if (((BaseArticleInfo)localObject1).mGalleryFeedsInfo == null) {
        break label1018;
      }
      localObject2 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_content.get().toStringUtf8();
      localObject3 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_jump_url.get().toStringUtf8();
      String str = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_icon_url.get().toStringUtf8();
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty(str))) {
        break label996;
      }
      parampin.jdField_a_of_type_AndroidViewView.setVisibility(0);
      parampin.d.setText((CharSequence)localObject2);
      localObject2 = beyq.a(str);
      parampin.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      localObject2 = oxw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity(), ReadInJoyPicWaterFallFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment), 3, paramInt, (ArticleInfo)localObject1);
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
          localObject3 = new oxy((BaseArticleInfo)localObject1);
          ((oxy)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)localObject1);
          ((oxy)localObject3).e = String.valueOf(((BaseArticleInfo)localObject1).mArticleID);
          ((oxy)localObject3).f = String.valueOf(((BaseArticleInfo)localObject1).mAlgorithmID);
          ((oxy)localObject3).g = ((JSONObject)localObject2).toString();
          if (((BaseArticleInfo)localObject1).mSocialFeedInfo.a != null) {
            ((oxy)localObject3).jdField_a_of_type_JavaLangString = String.valueOf(((BaseArticleInfo)localObject1).mSocialFeedInfo.a.a);
          }
          ((oxy)localObject3).b = "0X8009A7A";
          ((oxy)localObject3).c = "0X8009A7A";
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.jdField_a_of_type_Oxt.a("exp_waterfall_operation", localObject3);
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
        parampin.jdField_b_of_type_AndroidViewView.setVisibility(0);
        parampin.e.setText((CharSequence)localObject2);
        localObject1 = beyq.a((String)localObject1);
        parampin.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        return;
        if ((((FrameLayout.LayoutParams)localObject2).height > 0) && (((FrameLayout.LayoutParams)localObject2).height == ((BaseArticleInfo)localObject1).waterFallPic.c)) {
          break;
        }
        ((FrameLayout.LayoutParams)localObject2).height = ((BaseArticleInfo)localObject1).waterFallPic.c;
        parampin.jdField_b_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break;
        parampin.jdField_b_of_type_ComTencentImageURLImageView.setPadding(0, 0, 0, 0);
        break label107;
        i = ReadInJoyPicWaterFallFragment.e;
        break label153;
        localObject2 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.msg_publisher_info.bytes_header_url.get().toStringUtf8();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        i = agej.a(12.0F, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getResources());
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i;
        try
        {
          localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
          parampin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setImageDrawable((Drawable)localObject2);
        }
        catch (Exception localException)
        {
          QLog.e("ReadInJoyPicWaterFallFragment", 1, "bindNormalHolder, e = " + localException);
        }
      }
      break label261;
      parampin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setImageResource(2130846365);
      break label261;
      label962:
      parampin.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label331;
      label974:
      parampin.c.setVisibility(8);
      break label382;
      label996:
      parampin.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    label1008:
    parampin.jdField_b_of_type_AndroidViewView.setVisibility(8);
    return;
    label1018:
    parampin.jdField_b_of_type_AndroidViewView.setVisibility(8);
    parampin.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void a(pit parampit)
  {
    if (parampit.jdField_a_of_type_Int > 0)
    {
      i = (int)(this.e / parampit.jdField_a_of_type_Int * parampit.b);
      parampit.d = i;
      if ((i >= this.c) && (i <= this.d)) {
        parampit.c = i;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyPicWaterFallFragment", 2, "WaterFallPic = " + parampit.toString());
        }
        return;
        if (i < this.c) {
          parampit.c = this.c;
        } else {
          parampit.c = this.d;
        }
      }
    }
    if (this.e != 0) {}
    for (int i = this.e;; i = this.jdField_a_of_type_Int)
    {
      parampit.c = i;
      break;
    }
  }
  
  public pij a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity()).inflate(2131560242, null);
      paramViewGroup = new pin(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity();
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity()).inflate(2131560243, null);
    paramViewGroup = new pih(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment, paramViewGroup);
    paramViewGroup.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity();
    return paramViewGroup;
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(pij parampij, int paramInt)
  {
    int j;
    int i;
    if (this.e == 0)
    {
      j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.getWidth();
      if (j > 0) {
        break label290;
      }
      if (bdep.jdField_a_of_type_Int <= 0) {
        break label259;
      }
      i = bdep.jdField_a_of_type_Int;
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
        EventCollector.getInstance().onRecyclerBindViewHolder(parampij, paramInt, getItemId(paramInt));
        return;
        label259:
        i = 1080;
        break;
        a((pin)parampij, paramInt);
        continue;
        a((pih)parampij, paramInt);
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
 * Qualified Name:     piu
 * JD-Core Version:    0.7.0.1
 */