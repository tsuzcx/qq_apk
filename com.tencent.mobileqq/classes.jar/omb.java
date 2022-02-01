import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

public class omb
  extends omf
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NativeAdDownloadView jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public omb(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(0);
      olb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (Activity)this.jdField_a_of_type_AndroidContentContext, nxw.an, nxw.a, 4, null);
    }
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.b == null)) {
      return;
    }
    String str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.b.optString("adImg", "");
    String str2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.b.optString("goodsName", "");
    String str3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.b.optString("buttonTxt", "");
    olu.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetImageView, str1, 8, 30, -1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(str3);
    e();
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setStyle(2);
  }
  
  public int a()
  {
    return 2131562892;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368138));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378776));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365344));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365666));
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView = ((NativeAdDownloadView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365678));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366517));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setProgress(paramInt);
  }
  
  public void a(AdData paramAdData)
  {
    super.a(paramAdData);
    i();
  }
  
  public void a(oln paramoln)
  {
    super.a(paramoln);
    if ((this.jdField_a_of_type_Oln != null) && (this.jdField_a_of_type_Oln.a != null))
    {
      this.jdField_a_of_type_Oln.a(new omd(this));
      this.jdField_a_of_type_Oln.a.a(new ome(this));
      e();
    }
  }
  
  public void b()
  {
    a(new View[] { this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.c, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView, this.jdField_b_of_type_AndroidWidgetImageView });
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new omc(this));
  }
  
  public void c() {}
  
  public void d()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    olm.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, nxw.an, nxw.a, 4);
    super.d();
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Oln == null) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_Oln.b();
    } while ((TextUtils.isEmpty(str)) || (this.c == null));
    this.c.setText(str);
  }
  
  public void f()
  {
    this.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(0);
  }
  
  public void g()
  {
    this.c.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      h();
      continue;
      this.jdField_a_of_type_Oln.a(4);
      continue;
      this.jdField_a_of_type_Oln.b(4);
      continue;
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Olw != null) {
        this.jdField_a_of_type_Olw.b();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(3);
        olm.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, nxw.an, nxw.a, 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     omb
 * JD-Core Version:    0.7.0.1
 */