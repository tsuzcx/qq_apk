import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BannerAdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.BaseItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.JumpAdUtils;
import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;

public class mne
  extends BaseItemViewHolder
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private TextView b;
  private TextView c;
  
  public mne(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    paramView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367103));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361926));
    this.b = ((TextView)paramView.findViewById(2131367106));
    this.c = ((TextView)paramView.findViewById(2131367107));
  }
  
  private void a()
  {
    BannerAdData localBannerAdData = (BannerAdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData;
    if (localBannerAdData.jdField_b_of_type_Int == 12)
    {
      if (TextUtils.isEmpty(localBannerAdData.h)) {}
      while (!NativeAdUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), localBannerAdData.h)) {
        return;
      }
      this.c.setText("立即打开");
      return;
    }
    this.c.setText("查看详情");
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    switch (paramBaseData2.d)
    {
    default: 
      throw new IllegalArgumentException();
    }
    paramBaseData1 = (BannerAdData)paramBaseData2;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseData1.jdField_b_of_type_JavaLangString);
    this.b.setText(paramBaseData1.i);
    paramBaseData2 = URLDrawable.URLDrawableOptions.obtain();
    paramBaseData2.mLoadingDrawable = new ColorDrawable(-2565414);
    paramBaseData2.mPlayGifImage = true;
    paramBaseData2.mMemoryCacheKeySuffix = "fast_web";
    paramBaseData1 = URLDrawable.getDrawable(PubAccountHttpDownloader.a(paramBaseData1.d, 4), paramBaseData2);
    if ((paramBaseData1 != null) && (paramBaseData1.getStatus() == 2)) {
      paramBaseData1.restartDownload();
    }
    a();
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBaseData1);
  }
  
  public void onClick(View paramView)
  {
    JumpAdUtils.a((Activity)paramView.getContext(), (AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mne
 * JD-Core Version:    0.7.0.1
 */