import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadinjoyNativeArticleAdDownloadView.1;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class odd
  extends ocb
{
  private AdData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData;
  private obd jdField_a_of_type_Obd;
  boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public odd(VafContext paramVafContext)
  {
    super(paramVafContext);
  }
  
  private boolean i()
  {
    Object localObject = this.jdField_a_of_type_Qjc.d;
    int j = nmc.K;
    int i = nmc.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if (bbfr.a(BaseApplicationImpl.getContext(), (String)localObject))
    {
      k();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = 1;
      if (oai.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        j = nmc.ac;
        i = nmc.e;
        localHashMap.put("download_state", "5");
      }
      nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(oas.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localHashMap)).a());
      return true;
    }
    if (nlu.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Qjc))
    {
      localObject = bdhk.a().c(this.jdField_a_of_type_Qjc.d);
      bdhk.a().a((DownloadInfo)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = 5;
      if (oai.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        j = nmc.ac;
        i = nmc.e;
        localHashMap.put("download_state", "3");
      }
      for (;;)
      {
        nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(oas.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localHashMap)).a());
        return true;
        j = nmc.X;
      }
    }
    return false;
  }
  
  private void p()
  {
    if (c())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
      if (oai.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
        b();
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setClickable(true);
    }
  }
  
  protected int a()
  {
    return 0;
  }
  
  protected int a(int paramInt)
  {
    int j = 1;
    int i = paramInt;
    GradientDrawable localGradientDrawable;
    float f2;
    float f1;
    if (c())
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_OrgJsonJSONObject.optString("clickTextColor"))) {
        paramInt = nmh.a(this.jdField_b_of_type_OrgJsonJSONObject.optString("clickTextColor"), "#9D9D9D");
      }
      localGradientDrawable = new GradientDrawable();
      i = 0;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_OrgJsonJSONObject.optString("clickBackgroundColor")))
      {
        localGradientDrawable.setColor(nmh.a(this.jdField_b_of_type_OrgJsonJSONObject.optString("clickBackgroundColor"), "#12B7F5"));
        i = 1;
      }
      String str1 = this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonBorderSize");
      String str2 = this.jdField_b_of_type_OrgJsonJSONObject.optString("clickBorderColor");
      if (nmh.a(str1, 0.0F) > 0.0F)
      {
        f2 = nmh.a(str1, 0.0F);
        f1 = f2;
        if (f2 > 2.0F) {
          f1 = 2.0F;
        }
        localGradientDrawable.setStroke(actj.a(f1, this.jdField_a_of_type_AndroidContentContext.getResources()), nmh.a(str2, "#12B7F5"));
        i = 1;
      }
      str1 = this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonCornerSize");
      if (TextUtils.isEmpty(str1)) {
        break label257;
      }
      f2 = nmh.a(str1, 0.0F);
      if (f2 >= 0.0F) {
        break label242;
      }
      f1 = 0.0F;
      localGradientDrawable.setCornerRadius(actj.a(f1, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
    for (;;)
    {
      i = paramInt;
      if (j != 0)
      {
        oky.a(this.jdField_a_of_type_AndroidWidgetTextView, localGradientDrawable);
        i = paramInt;
      }
      return i;
      label242:
      f1 = f2;
      if (f2 <= 10.0F) {
        break;
      }
      f1 = 10.0F;
      break;
      label257:
      j = i;
    }
  }
  
  protected String a()
  {
    if (oai.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Nxw.b;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.p;
    }
    return "";
  }
  
  public void a(pau parampau, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_d_of_type_Boolean)) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, AdvertisementInfo paramAdvertisementInfo, String paramString)
  {
    if ((paramAdvertisementInfo != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(a())))
    {
      paramAdvertisementInfo = BaseApplicationImpl.getContext().getResources().getString(2131718466);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAdvertisementInfo);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
      paramString = ajya.a(2131712797);
      paramAdvertisementInfo = paramString;
      if (oai.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        paramAdvertisementInfo = paramString;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Nxw.w)) {
          paramAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Nxw.w;
        }
      }
      bcql.a(BaseApplicationImpl.getApplication(), 2, paramAdvertisementInfo, 0).a();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (yyn.a()))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (i()) {}
        while ((!yyn.a()) || (paramBoolean2)) {
          return;
        }
        g();
        return;
      }
      oal.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, new odf(this, paramBoolean2));
      return;
    }
    oal.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, paramBoolean1, this.jdField_a_of_type_Boolean, new odg(this, paramBoolean2));
    HashMap localHashMap = new HashMap();
    localHashMap.put("stat_src", "2");
    nmc.a(new nyd().a(BaseApplication.getContext()).a(nmc.b).b(nmc.ac).a(oas.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localHashMap)).a());
  }
  
  protected boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (oai.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)))
    {
      p();
      return true;
    }
    return super.a();
  }
  
  protected int b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.j;
    }
    return 0;
  }
  
  protected String b()
  {
    String str1 = ajya.a(2131712964);
    String str2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null) {
      str2 = str1;
    }
    do
    {
      do
      {
        return str2;
        if (oau.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
          str1 = ajya.a(2131713126);
        }
        if (oai.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
          str1 = ajya.a(2131712716);
        }
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (oai.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)))
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Nxw.l)) {
            return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Nxw.l;
          }
          return ajya.a(2131713089);
        }
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (oai.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))) {
          return BaseApplicationImpl.getContext().getResources().getString(2131718467);
        }
        if ((oai.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (c())) {
          return BaseApplicationImpl.getContext().getResources().getString(2131718466);
        }
        if ((oai.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) || ((b()) && (!TextUtils.isEmpty(a()))))
        {
          if (nmc.a(BaseApplicationImpl.getContext(), a()))
          {
            if (oai.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
              return ajya.a(2131713010);
            }
            return ajya.a(2131713082);
          }
          if ((!this.jdField_b_of_type_Boolean) && (!this.c) && (oai.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)))
          {
            this.c = true;
            g();
          }
        }
        if ((oai.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Nxw.l))) {
          return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Nxw.l;
        }
        if (oai.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
          return ajya.a(2131712816);
        }
        if (b()) {
          break;
        }
        str2 = str1;
      } while (!oai.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData));
      str2 = str1;
    } while (TextUtils.isEmpty(a()));
    if (oai.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
      return ajya.a(2131712883);
    }
    return ajya.a(2131712810);
  }
  
  protected void b(int paramInt)
  {
    int i = nmc.L;
    int j = nmc.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if ((paramInt == 5) && (oai.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)))
    {
      paramInt = j;
      if (oai.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        i = nmc.ac;
        paramInt = nmc.e;
        localHashMap.put("download_state", "2");
      }
      nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(paramInt).b(i).a(oas.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localHashMap)).a());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  protected boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_d_of_type_Int == 12) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected int c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k;
    }
    return 0;
  }
  
  protected String c()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Nxv != null)) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Nxv.a;
    }
    return "";
  }
  
  protected boolean c()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (oai.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (oba.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Nxw.b));
  }
  
  public void d()
  {
    super.d();
    if ((oai.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (c()) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
    }
  }
  
  protected void e()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetTextView.isClickable())) {
      onClick(this.jdField_a_of_type_AndroidWidgetTextView);
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.isClickable()))
      {
        onClick(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView);
        return;
      }
    } while (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity));
    this.jdField_b_of_type_Boolean = false;
    rmq.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, true, 8);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Qjc == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_b_of_type_Boolean) {
              break label154;
            }
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k == 4)
            {
              a(4, b());
              return;
            }
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k != 5) {
              break;
            }
            localObject = this.jdField_a_of_type_Qjc.d;
          } while (!bbfr.a(BaseApplicationImpl.getContext(), (String)localObject));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = 1;
          a(1, b());
          return;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k != 3);
        a(3, b());
      } while ((!(this.jdField_a_of_type_AndroidContentContext instanceof obo)) || (this.jdField_a_of_type_Qjc == null));
      localObject = ((obo)this.jdField_a_of_type_AndroidContentContext).a();
    } while (localObject == null);
    ((nlv)localObject).a(this.jdField_a_of_type_Qjc);
    return;
    label154:
    int j = nmc.L;
    int i = nmc.jdField_a_of_type_Int;
    Object localObject = new HashMap();
    if (nlt.a(this.jdField_a_of_type_Qjc, c()))
    {
      i();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = 5;
      if (oai.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        j = nmc.ac;
        i = nmc.e;
        ((HashMap)localObject).put("download_state", "3");
      }
      nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(oas.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, (HashMap)localObject)).a());
      return;
    }
    h();
    j = nmc.aa;
    if (oai.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
    {
      j = nmc.ac;
      i = nmc.e;
      ((HashMap)localObject).put("download_state", "1");
    }
    nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(oas.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, (HashMap)localObject)).a());
  }
  
  protected void g()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof obo)) && (this.jdField_a_of_type_Qjc != null))
    {
      nlv localnlv = ((obo)this.jdField_a_of_type_AndroidContentContext).a();
      if (localnlv != null) {
        localnlv.b(this.jdField_a_of_type_Qjc);
      }
    }
  }
  
  protected boolean g()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.v))) {}
    for (int i = oaq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.v, 8);; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyNativeArticleAdDownloadView", 2, "isADVideoDownloadProgress->value:" + i);
      }
      if (i == 1) {
        bool = true;
      }
      return bool;
    }
  }
  
  protected void h()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof obo)) && (this.jdField_a_of_type_Qjc != null))
    {
      nlv localnlv = ((obo)this.jdField_a_of_type_AndroidContentContext).a();
      if (localnlv != null) {
        localnlv.a(this.jdField_a_of_type_Qjc);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView != null)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k != 4) {
          break label76;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setProgress(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.j);
      }
    }
    return;
    label76:
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.j != 100) {}
    for (int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.j;; i = 0)
    {
      a(3, i);
      return;
    }
  }
  
  protected boolean h()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.i == 1) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.i == 2));
  }
  
  protected void i()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof obo)) && (this.jdField_a_of_type_Qjc != null))
    {
      nlv localnlv = ((obo)this.jdField_a_of_type_AndroidContentContext).a();
      if (localnlv != null) {
        localnlv.e(this.jdField_a_of_type_Qjc);
      }
    }
  }
  
  protected void j()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof obo)) && (this.jdField_a_of_type_Qjc != null))
    {
      nlv localnlv = ((obo)this.jdField_a_of_type_AndroidContentContext).a();
      if (localnlv != null) {
        localnlv.c(this.jdField_a_of_type_Qjc);
      }
    }
  }
  
  protected void k()
  {
    if ((this.jdField_a_of_type_Qjc != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qjc.d)) && (oai.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))) {
      oar.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Qjc.d);
    }
    while (!b()) {
      return;
    }
    shq.b(this.jdField_a_of_type_AndroidContentContext, oas.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), null, 2, true);
  }
  
  public void l() {}
  
  protected void m()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = 5;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.j = 100;
    }
  }
  
  protected void n() {}
  
  public void o()
  {
    if (oai.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
    {
      ThreadManager.executeOnNetWorkThread(new ReadinjoyNativeArticleAdDownloadView.1(this));
      nmc.a(new nyd().a(BaseApplication.getContext()).a(nmc.jdField_a_of_type_Int).b(nmc.ac).a(oas.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a());
    }
    while (((oai.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerTriplePicItemData)) && (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerVideoItemData))) || (!oai.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) || (i())) {
      return;
    }
    a(false, false);
  }
  
  public void onClick(View paramView)
  {
    int m = 0;
    int j = 0;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null) {}
    int i;
    Object localObject;
    for (;;)
    {
      return;
      this.jdField_b_of_type_Boolean = true;
      if (paramView == this.jdField_a_of_type_AndroidViewView)
      {
        e();
        return;
      }
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131362648: 
        try
        {
          if (oau.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
          {
            oau.a(this.jdField_a_of_type_AndroidContentContext, oas.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData));
            return;
          }
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
          return;
        }
        if (oai.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
        {
          o();
          return;
        }
        if (this.jdField_a_of_type_Qjc != null)
        {
          boolean bool = i();
          if (!bool)
          {
            i = j;
            if (bbfj.b(this.jdField_a_of_type_AndroidContentContext))
            {
              i = j;
              if (oaq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.U)) {
                i = 1;
              }
            }
            if ((yyn.a()) || (i != 0))
            {
              if (oai.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
              {
                g();
                return;
              }
              h();
              nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(nmc.jdField_a_of_type_Int).b(nmc.X).a(oas.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a());
              return;
            }
            if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
            {
              rmq.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, true, 8);
              nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(nmc.jdField_a_of_type_Int).b(nmc.K).a(oas.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a());
              return;
            }
          }
        }
        break;
      case 2131379158: 
        i = nmc.K;
        j = nmc.jdField_a_of_type_Int;
        paramView = new HashMap();
        try
        {
          if (this.jdField_a_of_type_Qjc != null)
          {
            localObject = this.jdField_a_of_type_Qjc.d;
            if (bbfr.a(BaseApplicationImpl.getContext(), (String)localObject))
            {
              k();
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = 1;
              if (oai.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
              {
                paramView.put("download_state", "5");
                i = nmc.ac;
                j = nmc.e;
              }
              nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(j).b(i).a(oas.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, paramView)).a());
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
              return;
            }
          }
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
          return;
        }
      }
    }
    if (nlu.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Qjc))
    {
      localObject = bdhk.a().c(this.jdField_a_of_type_Qjc.d);
      bdhk.a().a((DownloadInfo)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = 5;
      if (oai.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        paramView.put("download_state", "3");
        i = nmc.ac;
        j = nmc.e;
      }
      nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(j).b(i).a(oas.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, paramView)).a());
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
      return;
    }
    int k = m;
    if (bbfj.b(this.jdField_a_of_type_AndroidContentContext))
    {
      k = m;
      if (oaq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.U)) {
        k = 1;
      }
    }
    if ((yyn.a()) || (k != 0)) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k == 3)
      {
        j();
        if (!oai.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
          break label947;
        }
        paramView.put("download_state", "8");
        j = nmc.ac;
        i = nmc.e;
      }
    }
    for (;;)
    {
      nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(oas.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, paramView)).a());
      return;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k != 4) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k != 0)) {
        break;
      }
      h();
      if (oai.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        paramView.put("download_state", "9");
        i = nmc.ac;
        j = nmc.e;
      }
      nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(j).b(i).a(oas.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, paramView)).a());
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k == 3)
      {
        j();
        if (oai.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
        {
          paramView.put("download_state", "8");
          i = nmc.ac;
          j = nmc.e;
        }
        nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(j).b(i).a(oas.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, paramView)).a());
        return;
      }
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        break;
      }
      rmq.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, true, 8);
      return;
      label947:
      k = i;
      i = j;
      j = k;
    }
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = super.setAttribute(paramInt, paramObject);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    for (;;)
                    {
                      return bool1;
                      bool1 = bool2;
                      if (paramObject != null)
                      {
                        bool1 = bool2;
                        try
                        {
                          if ((paramObject instanceof AdData))
                          {
                            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData = ((AdData)paramObject);
                            if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null))
                            {
                              this.jdField_a_of_type_AndroidViewView.setVisibility(8);
                              return true;
                            }
                          }
                        }
                        catch (Exception paramObject)
                        {
                          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData = null;
                          QLog.d("ReadinjoyNativeArticleAdDownloadView", 1, "setAttribute STR_ID_SET_AD_BANNER exception " + paramObject.toString());
                          return true;
                        }
                      }
                    }
                    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerBigPicItemData)) || ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerTriplePicItemData)) || ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerVideoItemData))) {
                      this.jdField_a_of_type_Boolean = true;
                    }
                    this.jdField_b_of_type_Boolean = false;
                    this.c = false;
                    this.jdField_a_of_type_Qjc = qjc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData);
                    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData);
                    return true;
                    bool1 = bool2;
                  } while (paramObject == null);
                  bool1 = bool2;
                } while (!(paramObject instanceof JSONObject));
                this.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)paramObject);
                bool1 = bool2;
              } while (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView == null);
              this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setProgressStyle(this.jdField_a_of_type_OrgJsonJSONObject);
              bool1 = bool2;
            } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null);
            a(null);
            return true;
            bool1 = bool2;
          } while (paramObject == null);
          bool1 = bool2;
        } while (!(paramObject instanceof JSONObject));
        this.jdField_b_of_type_OrgJsonJSONObject = ((JSONObject)paramObject);
        bool1 = bool2;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null);
      bool1 = bool2;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView == null);
    a(null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odd
 * JD-Core Version:    0.7.0.1
 */