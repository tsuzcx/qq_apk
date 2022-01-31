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

public class odg
  extends oce
{
  private AdData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData;
  private obg jdField_a_of_type_Obg;
  boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public odg(VafContext paramVafContext)
  {
    super(paramVafContext);
  }
  
  private boolean i()
  {
    Object localObject = this.jdField_a_of_type_Qjf.d;
    int j = nmf.K;
    int i = nmf.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if (bbfd.a(BaseApplicationImpl.getContext(), (String)localObject))
    {
      k();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = 1;
      if (oal.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        j = nmf.ac;
        i = nmf.e;
        localHashMap.put("download_state", "5");
      }
      nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(oav.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localHashMap)).a());
      return true;
    }
    if (nlx.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Qjf))
    {
      localObject = bdgv.a().c(this.jdField_a_of_type_Qjf.d);
      bdgv.a().a((DownloadInfo)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = 5;
      if (oal.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        j = nmf.ac;
        i = nmf.e;
        localHashMap.put("download_state", "3");
      }
      for (;;)
      {
        nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(oav.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localHashMap)).a());
        return true;
        j = nmf.X;
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
      if (oal.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
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
        paramInt = nmk.a(this.jdField_b_of_type_OrgJsonJSONObject.optString("clickTextColor"), "#9D9D9D");
      }
      localGradientDrawable = new GradientDrawable();
      i = 0;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_OrgJsonJSONObject.optString("clickBackgroundColor")))
      {
        localGradientDrawable.setColor(nmk.a(this.jdField_b_of_type_OrgJsonJSONObject.optString("clickBackgroundColor"), "#12B7F5"));
        i = 1;
      }
      String str1 = this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonBorderSize");
      String str2 = this.jdField_b_of_type_OrgJsonJSONObject.optString("clickBorderColor");
      if (nmk.a(str1, 0.0F) > 0.0F)
      {
        f2 = nmk.a(str1, 0.0F);
        f1 = f2;
        if (f2 > 2.0F) {
          f1 = 2.0F;
        }
        localGradientDrawable.setStroke(actn.a(f1, this.jdField_a_of_type_AndroidContentContext.getResources()), nmk.a(str2, "#12B7F5"));
        i = 1;
      }
      str1 = this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonCornerSize");
      if (TextUtils.isEmpty(str1)) {
        break label257;
      }
      f2 = nmk.a(str1, 0.0F);
      if (f2 >= 0.0F) {
        break label242;
      }
      f1 = 0.0F;
      localGradientDrawable.setCornerRadius(actn.a(f1, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
    for (;;)
    {
      i = paramInt;
      if (j != 0)
      {
        olb.a(this.jdField_a_of_type_AndroidWidgetTextView, localGradientDrawable);
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
    if (oal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Nxz.b;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.p;
    }
    return "";
  }
  
  public void a(pax parampax, boolean paramBoolean)
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
      paramAdvertisementInfo = BaseApplicationImpl.getContext().getResources().getString(2131718455);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAdvertisementInfo);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
      paramString = ajyc.a(2131712786);
      paramAdvertisementInfo = paramString;
      if (oal.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        paramAdvertisementInfo = paramString;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Nxz.w)) {
          paramAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Nxz.w;
        }
      }
      bcpw.a(BaseApplicationImpl.getApplication(), 2, paramAdvertisementInfo, 0).a();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (yyq.a()))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (i()) {}
        while ((!yyq.a()) || (paramBoolean2)) {
          return;
        }
        g();
        return;
      }
      oao.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, new odi(this, paramBoolean2));
      return;
    }
    oao.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, paramBoolean1, this.jdField_a_of_type_Boolean, new odj(this, paramBoolean2));
    HashMap localHashMap = new HashMap();
    localHashMap.put("stat_src", "2");
    nmf.a(new nyg().a(BaseApplication.getContext()).a(nmf.b).b(nmf.ac).a(oav.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localHashMap)).a());
  }
  
  protected boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (oal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)))
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
    String str1 = ajyc.a(2131712953);
    String str2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null) {
      str2 = str1;
    }
    do
    {
      do
      {
        return str2;
        if (oax.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
          str1 = ajyc.a(2131713115);
        }
        if (oal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
          str1 = ajyc.a(2131712705);
        }
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (oal.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)))
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Nxz.l)) {
            return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Nxz.l;
          }
          return ajyc.a(2131713078);
        }
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (oal.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))) {
          return BaseApplicationImpl.getContext().getResources().getString(2131718456);
        }
        if ((oal.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (c())) {
          return BaseApplicationImpl.getContext().getResources().getString(2131718455);
        }
        if ((oal.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) || ((b()) && (!TextUtils.isEmpty(a()))))
        {
          if (nmf.a(BaseApplicationImpl.getContext(), a()))
          {
            if (oal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
              return ajyc.a(2131712999);
            }
            return ajyc.a(2131713071);
          }
          if ((!this.jdField_b_of_type_Boolean) && (!this.c) && (oal.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)))
          {
            this.c = true;
            g();
          }
        }
        if ((oal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Nxz.l))) {
          return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Nxz.l;
        }
        if (oal.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
          return ajyc.a(2131712805);
        }
        if (b()) {
          break;
        }
        str2 = str1;
      } while (!oal.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData));
      str2 = str1;
    } while (TextUtils.isEmpty(a()));
    if (oal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
      return ajyc.a(2131712872);
    }
    return ajyc.a(2131712799);
  }
  
  protected void b(int paramInt)
  {
    int i = nmf.L;
    int j = nmf.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if ((paramInt == 5) && (oal.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)))
    {
      paramInt = j;
      if (oal.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        i = nmf.ac;
        paramInt = nmf.e;
        localHashMap.put("download_state", "2");
      }
      nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(paramInt).b(i).a(oav.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localHashMap)).a());
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
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Nxy != null)) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Nxy.a;
    }
    return "";
  }
  
  protected boolean c()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (oal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (obd.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Nxz.b));
  }
  
  public void d()
  {
    super.d();
    if ((oal.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (c()) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
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
    rmt.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, true, 8);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Qjf == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null)) {}
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
            localObject = this.jdField_a_of_type_Qjf.d;
          } while (!bbfd.a(BaseApplicationImpl.getContext(), (String)localObject));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = 1;
          a(1, b());
          return;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k != 3);
        a(3, b());
      } while ((!(this.jdField_a_of_type_AndroidContentContext instanceof obr)) || (this.jdField_a_of_type_Qjf == null));
      localObject = ((obr)this.jdField_a_of_type_AndroidContentContext).a();
    } while (localObject == null);
    ((nly)localObject).a(this.jdField_a_of_type_Qjf);
    return;
    label154:
    int j = nmf.L;
    int i = nmf.jdField_a_of_type_Int;
    Object localObject = new HashMap();
    if (nlw.a(this.jdField_a_of_type_Qjf, c()))
    {
      i();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = 5;
      if (oal.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        j = nmf.ac;
        i = nmf.e;
        ((HashMap)localObject).put("download_state", "3");
      }
      nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(oav.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, (HashMap)localObject)).a());
      return;
    }
    h();
    j = nmf.aa;
    if (oal.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
    {
      j = nmf.ac;
      i = nmf.e;
      ((HashMap)localObject).put("download_state", "1");
    }
    nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(oav.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, (HashMap)localObject)).a());
  }
  
  protected void g()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof obr)) && (this.jdField_a_of_type_Qjf != null))
    {
      nly localnly = ((obr)this.jdField_a_of_type_AndroidContentContext).a();
      if (localnly != null) {
        localnly.b(this.jdField_a_of_type_Qjf);
      }
    }
  }
  
  protected boolean g()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.v))) {}
    for (int i = oat.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.v, 8);; i = 0)
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
    if (((this.jdField_a_of_type_AndroidContentContext instanceof obr)) && (this.jdField_a_of_type_Qjf != null))
    {
      nly localnly = ((obr)this.jdField_a_of_type_AndroidContentContext).a();
      if (localnly != null) {
        localnly.a(this.jdField_a_of_type_Qjf);
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
    if (((this.jdField_a_of_type_AndroidContentContext instanceof obr)) && (this.jdField_a_of_type_Qjf != null))
    {
      nly localnly = ((obr)this.jdField_a_of_type_AndroidContentContext).a();
      if (localnly != null) {
        localnly.e(this.jdField_a_of_type_Qjf);
      }
    }
  }
  
  protected void j()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof obr)) && (this.jdField_a_of_type_Qjf != null))
    {
      nly localnly = ((obr)this.jdField_a_of_type_AndroidContentContext).a();
      if (localnly != null) {
        localnly.c(this.jdField_a_of_type_Qjf);
      }
    }
  }
  
  protected void k()
  {
    if ((this.jdField_a_of_type_Qjf != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qjf.d)) && (oal.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))) {
      oau.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Qjf.d);
    }
    while (!b()) {
      return;
    }
    sht.b(this.jdField_a_of_type_AndroidContentContext, oav.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), null, 2, true);
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
    if (oal.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
    {
      ThreadManager.executeOnNetWorkThread(new ReadinjoyNativeArticleAdDownloadView.1(this));
      nmf.a(new nyg().a(BaseApplication.getContext()).a(nmf.jdField_a_of_type_Int).b(nmf.ac).a(oav.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a());
    }
    while (((oal.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerTriplePicItemData)) && (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerVideoItemData))) || (!oal.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) || (i())) {
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
      case 2131362649: 
        try
        {
          if (oax.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
          {
            oax.a(this.jdField_a_of_type_AndroidContentContext, oav.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData));
            return;
          }
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
          return;
        }
        if (oal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
        {
          o();
          return;
        }
        if (this.jdField_a_of_type_Qjf != null)
        {
          boolean bool = i();
          if (!bool)
          {
            i = j;
            if (bbev.b(this.jdField_a_of_type_AndroidContentContext))
            {
              i = j;
              if (oat.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.U)) {
                i = 1;
              }
            }
            if ((yyq.a()) || (i != 0))
            {
              if (oal.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
              {
                g();
                return;
              }
              h();
              nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(nmf.jdField_a_of_type_Int).b(nmf.X).a(oav.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a());
              return;
            }
            if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
            {
              rmt.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, true, 8);
              nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(nmf.jdField_a_of_type_Int).b(nmf.K).a(oav.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a());
              return;
            }
          }
        }
        break;
      case 2131379153: 
        i = nmf.K;
        j = nmf.jdField_a_of_type_Int;
        paramView = new HashMap();
        try
        {
          if (this.jdField_a_of_type_Qjf != null)
          {
            localObject = this.jdField_a_of_type_Qjf.d;
            if (bbfd.a(BaseApplicationImpl.getContext(), (String)localObject))
            {
              k();
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = 1;
              if (oal.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
              {
                paramView.put("download_state", "5");
                i = nmf.ac;
                j = nmf.e;
              }
              nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(j).b(i).a(oav.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, paramView)).a());
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
    if (nlx.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Qjf))
    {
      localObject = bdgv.a().c(this.jdField_a_of_type_Qjf.d);
      bdgv.a().a((DownloadInfo)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = 5;
      if (oal.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        paramView.put("download_state", "3");
        i = nmf.ac;
        j = nmf.e;
      }
      nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(j).b(i).a(oav.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, paramView)).a());
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
      return;
    }
    int k = m;
    if (bbev.b(this.jdField_a_of_type_AndroidContentContext))
    {
      k = m;
      if (oat.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.U)) {
        k = 1;
      }
    }
    if ((yyq.a()) || (k != 0)) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k == 3)
      {
        j();
        if (!oal.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
          break label947;
        }
        paramView.put("download_state", "8");
        j = nmf.ac;
        i = nmf.e;
      }
    }
    for (;;)
    {
      nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(oav.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, paramView)).a());
      return;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k != 4) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k != 0)) {
        break;
      }
      h();
      if (oal.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        paramView.put("download_state", "9");
        i = nmf.ac;
        j = nmf.e;
      }
      nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(j).b(i).a(oav.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, paramView)).a());
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k == 3)
      {
        j();
        if (oal.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
        {
          paramView.put("download_state", "8");
          i = nmf.ac;
          j = nmf.e;
        }
        nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(j).b(i).a(oav.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(nmf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, paramView)).a());
        return;
      }
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        break;
      }
      rmt.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, true, 8);
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
                    this.jdField_a_of_type_Qjf = qjf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData);
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
 * Qualified Name:     odg
 * JD-Core Version:    0.7.0.1
 */