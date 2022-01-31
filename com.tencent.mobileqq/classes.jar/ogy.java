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
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadinjoyNativeArticleAdDownloadView.1;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class ogy
  extends oft
{
  private AdData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData;
  private oev jdField_a_of_type_Oev;
  boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public ogy(VafContext paramVafContext)
  {
    super(paramVafContext);
  }
  
  private boolean i()
  {
    Object localObject = this.jdField_a_of_type_Qyj.d;
    int j = noy.K;
    int i = noy.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if (bdem.a(BaseApplicationImpl.getContext(), (String)localObject))
    {
      k();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = 1;
      if (odv.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        j = noy.ac;
        i = noy.e;
        localHashMap.put("download_state", "5");
      }
      noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(oef.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(noy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localHashMap)).a());
      return true;
    }
    if (noq.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Qyj))
    {
      localObject = bfgi.a().c(this.jdField_a_of_type_Qyj.d);
      bfgi.a().a((DownloadInfo)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = 5;
      if (odv.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        j = noy.ac;
        i = noy.e;
        localHashMap.put("download_state", "3");
      }
      for (;;)
      {
        noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(oef.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(noy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localHashMap)).a());
        return true;
        j = noy.X;
      }
    }
    return false;
  }
  
  private void r()
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
      if (odv.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
        b();
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setClickable(true);
    }
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (this.jdField_b_of_type_OrgJsonJSONObject != null)) {
      try
      {
        switch (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_p_of_type_Int)
        {
        case 1: 
        case 2: 
          this.jdField_b_of_type_OrgJsonJSONObject.put("buttonTextColor", "#00cafc");
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
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
        paramInt = npd.a(this.jdField_b_of_type_OrgJsonJSONObject.optString("clickTextColor"), "#9D9D9D");
      }
      localGradientDrawable = new GradientDrawable();
      i = 0;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_OrgJsonJSONObject.optString("clickBackgroundColor")))
      {
        localGradientDrawable.setColor(npd.a(this.jdField_b_of_type_OrgJsonJSONObject.optString("clickBackgroundColor"), "#12B7F5"));
        i = 1;
      }
      String str1 = this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonBorderSize");
      String str2 = this.jdField_b_of_type_OrgJsonJSONObject.optString("clickBorderColor");
      if (npd.a(str1, 0.0F) > 0.0F)
      {
        f2 = npd.a(str1, 0.0F);
        f1 = f2;
        if (f2 > 2.0F) {
          f1 = 2.0F;
        }
        localGradientDrawable.setStroke(aekt.a(f1, this.jdField_a_of_type_AndroidContentContext.getResources()), npd.a(str2, "#12B7F5"));
        i = 1;
      }
      str1 = this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonCornerSize");
      if (TextUtils.isEmpty(str1)) {
        break label259;
      }
      f2 = npd.a(str1, 0.0F);
      if (f2 >= 0.0F) {
        break label242;
      }
      f1 = 0.0F;
      localGradientDrawable.setCornerRadius(aekt.a(f1, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
    for (;;)
    {
      i = paramInt;
      if (j != 0)
      {
        opi.a(this.jdField_a_of_type_AndroidWidgetTextView, localGradientDrawable);
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
      label259:
      j = i;
    }
  }
  
  protected String a()
  {
    if (odv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Obd.b;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_p_of_type_JavaLangString;
    }
    return "";
  }
  
  public void a(pgd parampgd, boolean paramBoolean)
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
      paramAdvertisementInfo = BaseApplicationImpl.getContext().getResources().getString(2131718895);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAdvertisementInfo);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
      paramString = alpo.a(2131713169);
      paramAdvertisementInfo = paramString;
      if (odv.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        paramAdvertisementInfo = paramString;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Obd.w)) {
          paramAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Obd.w;
        }
      }
      QQToast.a(BaseApplicationImpl.getApplication(), 2, paramAdvertisementInfo, 0).a();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (aaon.a()))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (i()) {}
        while ((!aaon.a()) || (paramBoolean2)) {
          return;
        }
        g();
        return;
      }
      ody.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, new oha(this, paramBoolean2));
      return;
    }
    ody.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, paramBoolean1, this.jdField_a_of_type_Boolean, new ohb(this, paramBoolean2));
    HashMap localHashMap = new HashMap();
    localHashMap.put("stat_src", "2");
    noy.a(new obk().a(BaseApplication.getContext()).a(noy.b).b(noy.ac).a(oef.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(noy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localHashMap)).a());
  }
  
  protected boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (odv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)))
    {
      r();
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
    String str1 = alpo.a(2131713336);
    String str2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null) {
      str2 = str1;
    }
    do
    {
      do
      {
        return str2;
        if (oem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
          str1 = alpo.a(2131713498);
        }
        if (odv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
          str1 = alpo.a(2131713088);
        }
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (odv.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)))
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Obd.l)) {
            return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Obd.l;
          }
          return alpo.a(2131713461);
        }
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (odv.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))) {
          return BaseApplicationImpl.getContext().getResources().getString(2131718896);
        }
        if ((odv.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (c())) {
          return BaseApplicationImpl.getContext().getResources().getString(2131718895);
        }
        if ((odv.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) || ((b()) && (!TextUtils.isEmpty(a()))))
        {
          if (noy.a(BaseApplicationImpl.getContext(), a()))
          {
            if (odv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
              return alpo.a(2131713382);
            }
            return alpo.a(2131713454);
          }
          if ((!this.jdField_b_of_type_Boolean) && (!this.c) && (odv.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)))
          {
            this.c = true;
            g();
          }
        }
        if ((odv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Obd.l))) {
          return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Obd.l;
        }
        if (odv.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
          return alpo.a(2131713188);
        }
        if (b()) {
          break;
        }
        str2 = str1;
      } while (!odv.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData));
      str2 = str1;
    } while (TextUtils.isEmpty(a()));
    if (odv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
      return alpo.a(2131713255);
    }
    return alpo.a(2131713182);
  }
  
  protected void b(int paramInt)
  {
    int i = noy.L;
    int j = noy.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if ((paramInt == 5) && (odv.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)))
    {
      paramInt = j;
      if (odv.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        i = noy.ac;
        paramInt = noy.e;
        localHashMap.put("download_state", "2");
      }
      noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(paramInt).b(i).a(oef.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(noy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localHashMap)).a());
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
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k;
    }
    return 0;
  }
  
  protected String c()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Obc != null)) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Obc.a;
    }
    return "";
  }
  
  protected boolean c()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (odv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (oes.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_a_of_type_Obd.b));
  }
  
  public void d()
  {
    super.d();
    if ((odv.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (c()) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
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
    scp.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, true, 8);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Qyj == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null)) {}
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
            localObject = this.jdField_a_of_type_Qyj.d;
          } while (!bdem.a(BaseApplicationImpl.getContext(), (String)localObject));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = 1;
          a(1, b());
          return;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k != 3);
        a(3, b());
      } while ((!(this.jdField_a_of_type_AndroidContentContext instanceof ofg)) || (this.jdField_a_of_type_Qyj == null));
      localObject = ((ofg)this.jdField_a_of_type_AndroidContentContext).a();
    } while (localObject == null);
    ((nor)localObject).a(this.jdField_a_of_type_Qyj);
    return;
    label154:
    int j = noy.L;
    int i = noy.jdField_a_of_type_Int;
    Object localObject = new HashMap();
    if (nop.a(this.jdField_a_of_type_Qyj, c()))
    {
      i();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = 5;
      if (odv.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        j = noy.ac;
        i = noy.e;
        ((HashMap)localObject).put("download_state", "3");
      }
      noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(oef.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(noy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, (HashMap)localObject)).a());
      return;
    }
    h();
    j = noy.aa;
    if (odv.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
    {
      j = noy.ac;
      i = noy.e;
      ((HashMap)localObject).put("download_state", "1");
    }
    noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(oef.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(noy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, (HashMap)localObject)).a());
  }
  
  protected void g()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof ofg)) && (this.jdField_a_of_type_Qyj != null))
    {
      nor localnor = ((ofg)this.jdField_a_of_type_AndroidContentContext).a();
      if (localnor != null) {
        localnor.b(this.jdField_a_of_type_Qyj);
      }
    }
  }
  
  protected boolean g()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.v))) {}
    for (int i = oed.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.v, 8);; i = 0)
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
  
  public void h()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof ofg)) && (this.jdField_a_of_type_Qyj != null))
    {
      nor localnor = ((ofg)this.jdField_a_of_type_AndroidContentContext).a();
      if (localnor != null) {
        localnor.a(this.jdField_a_of_type_Qyj);
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
    if (((this.jdField_a_of_type_AndroidContentContext instanceof ofg)) && (this.jdField_a_of_type_Qyj != null))
    {
      nor localnor = ((ofg)this.jdField_a_of_type_AndroidContentContext).a();
      if (localnor != null) {
        localnor.e(this.jdField_a_of_type_Qyj);
      }
    }
  }
  
  protected void j()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof ofg)) && (this.jdField_a_of_type_Qyj != null))
    {
      nor localnor = ((ofg)this.jdField_a_of_type_AndroidContentContext).a();
      if (localnor != null) {
        localnor.c(this.jdField_a_of_type_Qyj);
      }
    }
  }
  
  protected void k()
  {
    if ((this.jdField_a_of_type_Qyj != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qyj.d)) && (odv.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))) {
      oee.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Qyj.d);
    }
    while (!b()) {
      return;
    }
    szl.b(this.jdField_a_of_type_AndroidContentContext, oef.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), null, 2, true);
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
    try
    {
      if (oem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        oem.a(this.jdField_a_of_type_AndroidContentContext, oef.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData));
        return;
      }
      if (odv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        q();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    if (this.jdField_a_of_type_Qyj != null)
    {
      boolean bool = i();
      if (!bool)
      {
        int i;
        if ((bdee.b(this.jdField_a_of_type_AndroidContentContext)) && (oed.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.U))) {
          i = 1;
        }
        while ((aaon.a()) || (i != 0)) {
          if (odv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
          {
            g();
            return;
            i = 0;
          }
          else
          {
            h();
            noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.X).a(oef.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a());
            return;
          }
        }
        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
        {
          scp.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, true, 8);
          noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.K).a(oef.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a());
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null) {
      return;
    }
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
    case 2131362676: 
      o();
      return;
    }
    p();
  }
  
  public void p()
  {
    int m = 0;
    int i = noy.K;
    int j = noy.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    Object localObject;
    try
    {
      if (this.jdField_a_of_type_Qyj == null) {
        return;
      }
      localObject = this.jdField_a_of_type_Qyj.d;
      if (bdem.a(BaseApplicationImpl.getContext(), (String)localObject))
      {
        k();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = 1;
        if (odv.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
        {
          localHashMap.put("download_state", "5");
          i = noy.ac;
          j = noy.e;
        }
        noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(j).b(i).a(oef.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(noy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localHashMap)).a());
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    if (noq.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Qyj))
    {
      localObject = bfgi.a().c(this.jdField_a_of_type_Qyj.d);
      bfgi.a().a((DownloadInfo)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = 5;
      if (odv.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        localException.put("download_state", "3");
        i = noy.ac;
        j = noy.e;
      }
      noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(j).b(i).a(oef.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(noy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localException)).a());
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
      return;
    }
    int k = m;
    if (bdee.b(this.jdField_a_of_type_AndroidContentContext))
    {
      k = m;
      if (oed.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.U)) {
        k = 1;
      }
    }
    if ((aaon.a()) || (k != 0)) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k == 3)
      {
        j();
        if (!odv.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
          break label667;
        }
        localException.put("download_state", "8");
        j = noy.ac;
        i = noy.e;
      }
    }
    for (;;)
    {
      noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(oef.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(noy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localException)).a());
      return;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k != 4) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k != 0)) {
        break;
      }
      h();
      if (odv.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        localException.put("download_state", "9");
        i = noy.ac;
        j = noy.e;
      }
      noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(j).b(i).a(oef.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(noy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localException)).a());
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k == 3)
      {
        j();
        if (odv.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
        {
          localException.put("download_state", "8");
          i = noy.ac;
          j = noy.e;
        }
        noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(j).b(i).a(oef.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(noy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localException)).a());
        return;
      }
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        break;
      }
      scp.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, true, 8);
      return;
      label667:
      k = i;
      i = j;
      j = k;
    }
  }
  
  public void q()
  {
    if (odv.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
    {
      ThreadManager.executeOnNetWorkThread(new ReadinjoyNativeArticleAdDownloadView.1(this));
      noy.a(new obk().a(BaseApplication.getContext()).a(noy.jdField_a_of_type_Int).b(noy.ac).a(oef.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(noy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a());
    }
    while (((odv.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerTriplePicItemData)) && (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerVideoItemData))) || (!odv.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) || (i())) {
      return;
    }
    a(false, false);
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramObject);
    case 1041: 
      if (paramObject != null) {}
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
          if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerBigPicItemData)) || ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerTriplePicItemData)) || ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerVideoItemData))) {
            this.jdField_a_of_type_Boolean = true;
          }
          this.jdField_b_of_type_Boolean = false;
          this.c = false;
          this.jdField_a_of_type_Qyj = qyj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData);
          if (((this.jdField_a_of_type_AndroidContentContext instanceof FastWebActivity)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusInnerData)) && (((ProteusInnerData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData).d())) {
            ((FastWebActivity)this.jdField_a_of_type_AndroidContentContext).a().jdField_a_of_type_Qyj = this.jdField_a_of_type_Qyj;
          }
          s();
          a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData);
        }
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData = null;
          QLog.d("ReadinjoyNativeArticleAdDownloadView", 1, "setAttribute STR_ID_SET_AD_BANNER exception " + paramObject.toString());
        }
      }
      return true;
    case 1053: 
      if ((paramObject != null) && ((paramObject instanceof JSONObject)))
      {
        this.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)paramObject);
        if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setProgressStyle(this.jdField_a_of_type_OrgJsonJSONObject);
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
            a(null);
          }
        }
      }
      return true;
    }
    if ((paramObject != null) && ((paramObject instanceof JSONObject)))
    {
      this.jdField_b_of_type_OrgJsonJSONObject = ((JSONObject)paramObject);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView != null))
      {
        s();
        a(null);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ogy
 * JD-Core Version:    0.7.0.1
 */