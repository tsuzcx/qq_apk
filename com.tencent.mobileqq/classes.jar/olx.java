import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.GameGiftsImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class olx
  extends omf
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NativeAdDownloadView jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView;
  private GameGiftsImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barGameGiftsImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private TextView b;
  private TextView c;
  
  public olx(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if ((paramTextView != null) && (!TextUtils.isEmpty(paramString))) {
      paramTextView.setText(paramString);
    }
  }
  
  private void h()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(Color.parseColor("#00CAFC"));
    localGradientDrawable.setCornerRadius(afur.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.c.setBackgroundDrawable(localGradientDrawable);
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_Oln != null) && (this.jdField_a_of_type_Oln.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (!this.jdField_a_of_type_Oln.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mShowAdButton)) {}
    for (;;)
    {
      return;
      boolean bool2 = false;
      try
      {
        if ((this.jdField_a_of_type_Oln != null) && (this.jdField_a_of_type_Oln.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null))
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Oln.jdField_a_of_type_Orb != null) {
            bool1 = bgnw.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Oln.jdField_a_of_type_Orb.d);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool1 = bool2;
          if (QLog.isColorLevel())
          {
            localException.printStackTrace();
            bool1 = bool2;
          }
        }
        g();
      }
    }
    bool2 = this.jdField_a_of_type_Oln.b();
    if ((!bool1) && (!bool2) && ((c() == 4) || (c() == 3)) && (b() >= 0) && (b() < 100))
    {
      f();
      a(this.jdField_a_of_type_Oln.jdField_a_of_type_Orb, c(), b());
      return;
    }
  }
  
  private void j()
  {
    olt localolt = new olt(1);
    localolt.c = 48;
    localolt.jdField_e_of_type_Int = 28;
    localolt.jdField_e_of_type_JavaLangString = "#00cafc";
    localolt.jdField_a_of_type_JavaLangString = "#4c00cafc";
    localolt.jdField_b_of_type_Float = 1.0F;
    localolt.d = "#00cafc";
    localolt.g = 14;
    localolt.jdField_a_of_type_Boolean = false;
    localolt.jdField_b_of_type_JavaLangString = "#ffffff";
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setStyle(localolt);
  }
  
  public int a()
  {
    return 2131559190;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368138));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378776));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barGameGiftsImageView = ((GameGiftsImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367525));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367318));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365666));
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView = ((NativeAdDownloadView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365678));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366517));
    h();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setProgress(paramInt);
  }
  
  public void a(AdData paramAdData)
  {
    super.a(paramAdData);
    if (paramAdData.a != null)
    {
      olu.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentImageURLImageView, paramAdData.a.k, 12, 48, -1);
      a(this.jdField_a_of_type_AndroidWidgetTextView, paramAdData.a.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Oln == null) {
        break label310;
      }
      a(this.c, this.jdField_a_of_type_Oln.b());
      a(this.jdField_b_of_type_AndroidWidgetTextView, paramAdData.a.h);
      if (!opz.c(paramAdData)) {
        break label328;
      }
      Object localObject = new ArrayList();
      if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_Omk.d)) {
        ((ArrayList)localObject).add(paramAdData.a.jdField_a_of_type_Omk.d);
      }
      if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_Omk.jdField_e_of_type_JavaLangString)) {
        ((ArrayList)localObject).add(paramAdData.a.jdField_a_of_type_Omk.jdField_e_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_Omk.f)) {
        ((ArrayList)localObject).add(paramAdData.a.jdField_a_of_type_Omk.f);
      }
      if (((ArrayList)localObject).size() > 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barGameGiftsImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barGameGiftsImageView.setImages((ArrayList)localObject);
      }
      if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_Omk.g)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramAdData.a.jdField_a_of_type_Omk.g);
      }
      localObject = this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      if ((localObject instanceof LinearLayout.LayoutParams)) {
        ((LinearLayout.LayoutParams)localObject).leftMargin = afur.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      j();
      if (opz.e(paramAdData)) {
        i();
      }
      return;
      label310:
      a(this.c, paramAdData.a.l);
      break;
      label328:
      if (opz.e(paramAdData)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdCommon_ad_barGameGiftsImageView.setVisibility(8);
      }
    }
  }
  
  public void a(oln paramoln)
  {
    super.a(paramoln);
    if ((this.jdField_a_of_type_Oln != null) && (this.jdField_a_of_type_Oln.jdField_a_of_type_Nxp != null))
    {
      this.jdField_a_of_type_Oln.a(new olz(this));
      this.jdField_a_of_type_Oln.jdField_a_of_type_Nxp.a(new oma(this));
    }
  }
  
  public void a(orb paramorb, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Oln.a(paramorb)) {
      return;
    }
    this.jdField_a_of_type_Oln.a(this.c, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView, paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Oln != null) && (this.jdField_a_of_type_Oln.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)) {
      return this.jdField_a_of_type_Oln.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress;
    }
    return 0;
  }
  
  public void b()
  {
    a(new View[] { this.c, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView, this.jdField_a_of_type_AndroidWidgetImageView });
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new oly(this));
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_Oln != null) && (this.jdField_a_of_type_Oln.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)) {
      return this.jdField_a_of_type_Oln.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState;
    }
    return 0;
  }
  
  public void c() {}
  
  public void d()
  {
    long l1 = 3010203L;
    long l3 = 6L;
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    long l2;
    if (opz.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
      l2 = 7L;
    }
    for (;;)
    {
      oll.a(this.jdField_a_of_type_Oln.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, nxw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), oll.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, l1, l2, null, "1"));
      super.d();
      return;
      if (opz.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        l1 = 3010303L;
        l2 = l3;
      }
      else
      {
        l2 = l3;
        if (opz.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
        {
          l1 = 3010403L;
          l2 = l3;
        }
      }
    }
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
    long l = 3010208L;
    switch (paramView.getId())
    {
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.jdField_a_of_type_Oln != null)
        {
          this.jdField_a_of_type_Oln.a(4);
          continue;
          if (this.jdField_a_of_type_Oln != null) {
            this.jdField_a_of_type_Oln.b(4);
          }
        }
      }
      this.jdField_a_of_type_Boolean = true;
    } while ((this.jdField_a_of_type_Olw == null) || (this.jdField_a_of_type_Oln == null));
    this.jdField_a_of_type_Olw.b();
    if (opz.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {}
    for (;;)
    {
      oll.a(this.jdField_a_of_type_Oln.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, nxw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), oll.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, l, 9L, null, "1"));
      break;
      if (opz.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
        l = 3010308L;
      } else if (opz.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
        l = 3010408L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     olx
 * JD-Core Version:    0.7.0.1
 */