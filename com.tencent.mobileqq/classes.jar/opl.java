import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyHeaderAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MainService;

public class opl
  implements seb
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private HashMap<String, orb> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private nxp jdField_a_of_type_Nxp;
  private omy jdField_a_of_type_Omy;
  private orb jdField_a_of_type_Orb;
  private rxy jdField_a_of_type_Rxy;
  private sea jdField_a_of_type_Sea;
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private Set<String> jdField_b_of_type_JavaUtilSet;
  private boolean jdField_b_of_type_Boolean;
  private Set<String> jdField_c_of_type_JavaUtilSet;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 2;
    case 2: 
      return 1;
    case 3: 
      return 1;
    case 4: 
      return 4;
    case 5: 
      return 2;
    }
    return 2;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(paramInt2);
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_Boolean = this.jdField_c_of_type_Boolean;
    }
    olm.a(e(), this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, nxw.an, paramInt1, 5);
  }
  
  private boolean a(VideoInfo paramVideoInfo, double paramDouble, long paramLong)
  {
    double d1 = paramLong / 1000L * paramDouble / 100.0D;
    if (this.e)
    {
      if (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.z)) {
        break label148;
      }
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.z.equals("1")) {
        if (paramDouble <= Integer.valueOf(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.A).intValue()) {}
      }
    }
    while (paramDouble > this.jdField_a_of_type_Int)
    {
      int i;
      do
      {
        return true;
        return false;
        if (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.z.equals("2")) {
          break;
        }
        i = Integer.valueOf(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.B).intValue();
      } while ((d1 != 0.0D) && (d1 > i));
      return false;
    }
    return false;
    label148:
    return false;
  }
  
  private CharSequence b()
  {
    float f1 = 13.0F;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k;
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k = "";
    }
    String str1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l + " " + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k;
    if (!TextUtils.isEmpty(str1.trim()))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str1);
      int i;
      int j;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l))
      {
        str2 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l;
        if (str1.contains(str2))
        {
          i = str1.indexOf(str2);
          j = str2.length() + i;
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FF4060")), i, j, 33);
          localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(afur.a(13.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())), i, j, 33);
          localSpannableStringBuilder.setSpan(new opn(afur.a(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())), j, j + 1, 33);
        }
      }
      String str2 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k;
      if ((!TextUtils.isEmpty(str2)) && (str1.contains(str2)))
      {
        i = str1.indexOf(str2);
        j = str2.length() + i;
        if (c()) {
          break label398;
        }
        localSpannableStringBuilder.setSpan(new StrikethroughSpan(), i, j, 33);
        localSpannableStringBuilder.setSpan(new StrikethroughSpan(), i, j, 33);
        if (!c()) {
          break label422;
        }
      }
      for (;;)
      {
        localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(afur.a(f1, this.jdField_a_of_type_AndroidAppActivity.getResources())), i, j, 33);
        return localSpannableStringBuilder;
        label398:
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#777777")), i, j, 33);
        break;
        label422:
        f1 = 11.0F;
      }
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_JavaLangString;
  }
  
  private void b(int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(paramInt);
      }
      return;
      paramInt = 41;
      continue;
      paramInt = 42;
      continue;
      paramInt = 8;
      continue;
      paramInt = 40;
    }
  }
  
  private void b(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null))
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_b_of_type_Int;
      this.e = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.y.equals("1");
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Boolean = this.e;
      this.f = false;
    }
  }
  
  private void c(int paramInt)
  {
    a(paramInt, 0);
  }
  
  private String e()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString;
  }
  
  private boolean e()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0);
  }
  
  private void h()
  {
    if (bgnw.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Orb.jdField_d_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Rxy.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_Rxy.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717083));
    }
    while (this.jdField_a_of_type_Orb.jdField_a_of_type_Int != 5) {
      return;
    }
    this.jdField_a_of_type_Rxy.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_Rxy.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717076));
  }
  
  private void i()
  {
    c(nxw.jdField_b_of_type_Int);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      String str = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString != null) {
        str = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString + "_B";
      }
      if ((this.jdField_c_of_type_JavaUtilSet != null) && (!this.jdField_c_of_type_JavaUtilSet.contains(str)))
      {
        this.jdField_c_of_type_JavaUtilSet.add(str);
        i();
      }
    }
  }
  
  private void k()
  {
    oli.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_AndroidAppActivity);
  }
  
  private void l()
  {
    if (this.e) {}
    for (ReadInjoyHeaderAdDownloadView localReadInjoyHeaderAdDownloadView = this.jdField_a_of_type_Rxy.b;; localReadInjoyHeaderAdDownloadView = this.jdField_a_of_type_Rxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView)
    {
      localReadInjoyHeaderAdDownloadView.a(this.jdField_a_of_type_Orb.jdField_b_of_type_Int);
      return;
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1)) {
      return 1;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int;
  }
  
  public CharSequence a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null))
    {
      Object localObject;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12))
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_JavaLangString;
        return localObject;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 0) {
        return b();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 2)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int != 0) {}
        for (String str = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_JavaLangString;; str = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdDesc)
        {
          localObject = str;
          if (!TextUtils.isEmpty(str)) {
            break;
          }
          return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_JavaLangString;
        }
      }
    }
    return null;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12) {
          return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateLogo;
        }
        return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdImg;
      }
      return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_b_of_type_JavaLangString;
    }
    return null;
  }
  
  public void a()
  {
    this.f = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = null;
    if (this.jdField_a_of_type_Nxp != null) {
      this.jdField_a_of_type_Nxp.a();
    }
  }
  
  protected void a(int paramInt) {}
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    b(paramVideoInfo);
  }
  
  public void a(VideoInfo paramVideoInfo, rxy paramrxy)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Rxy = paramrxy;
    String str;
    orb localorb2;
    orb localorb1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12)
      {
        str = paramVideoInfo.jdField_a_of_type_JavaLangString;
        localorb2 = (orb)this.jdField_a_of_type_JavaUtilHashMap.get(str);
        localorb1 = localorb2;
        if (localorb2 == null)
        {
          localorb1 = orb.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
          this.jdField_a_of_type_JavaUtilHashMap.put(str, localorb1);
        }
        if (localorb1 != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.o = localorb1.jdField_d_of_type_JavaLangString;
          if ((nxp.a(BaseApplicationImpl.getApplication(), localorb1)) || (bgnw.a(BaseApplicationImpl.getContext(), localorb1.jdField_d_of_type_JavaLangString))) {
            localorb1.jdField_a_of_type_Int = 5;
          }
          this.jdField_a_of_type_Orb = localorb1;
          if (!this.e) {
            break label291;
          }
          h();
          paramrxy.b.a(a(localorb1.jdField_a_of_type_Int), localorb1.jdField_b_of_type_Int);
        }
      }
    }
    label291:
    label502:
    for (;;)
    {
      paramrxy.y.setTag(2131380929, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo);
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
        if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isKolSoftAd())) {
          this.jdField_a_of_type_Omy.a();
        }
        obj.a().a(paramrxy.getAdapterPosition());
        obj.a().a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.K);
        i();
      }
      return;
      paramrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a(a(localorb1.jdField_a_of_type_Int), localorb1.jdField_b_of_type_Int);
      continue;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1)
      {
        str = paramVideoInfo.jdField_a_of_type_JavaLangString;
        localorb2 = (orb)this.jdField_a_of_type_JavaUtilHashMap.get(str);
        int i = oqj.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
        localorb1 = localorb2;
        if (localorb2 == null)
        {
          localorb1 = orb.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo, i);
          this.jdField_a_of_type_JavaUtilHashMap.put(str, localorb1);
        }
        if ((nxp.a(BaseApplicationImpl.getApplication(), localorb1)) || (bgnw.a(BaseApplicationImpl.getContext(), localorb1.jdField_d_of_type_JavaLangString))) {
          localorb1.jdField_a_of_type_Int = 5;
        }
        this.jdField_a_of_type_Orb = localorb1;
        if (this.e)
        {
          h();
          paramrxy.b.a(a(localorb1.jdField_a_of_type_Int), localorb1.jdField_b_of_type_Int);
        }
        for (;;)
        {
          if (i == 0) {
            break label502;
          }
          d();
          break;
          paramrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a(a(localorb1.jdField_a_of_type_Int), localorb1.jdField_b_of_type_Int);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_c_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Nxp = new nxp(paramActivity);
    this.jdField_a_of_type_Nxp.a(new opm(this));
    this.jdField_a_of_type_Omy = new omy(paramQQAppInterface);
  }
  
  public void a(rxy paramrxy)
  {
    LinearLayout.LayoutParams localLayoutParams1;
    if (!this.e)
    {
      localLayoutParams1 = (LinearLayout.LayoutParams)paramrxy.w.getLayoutParams();
      if (TextUtils.isEmpty(paramrxy.N.getText().toString().trim()))
      {
        paramrxy.N.setVisibility(8);
        localLayoutParams1.gravity = 16;
        paramrxy.w.setLayoutParams(localLayoutParams1);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1)) {
          break label209;
        }
        paramrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setVisibility(8);
        paramrxy.w.setVisibility(0);
        label111:
        if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString))) {
          paramrxy.M.setText(e());
        }
      }
    }
    for (;;)
    {
      return;
      LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)paramrxy.N.getLayoutParams();
      localLayoutParams2.topMargin = afur.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      paramrxy.N.setLayoutParams(localLayoutParams2);
      paramrxy.N.setVisibility(0);
      localLayoutParams1.gravity = 16;
      break;
      label209:
      paramrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setVisibility(0);
      paramrxy.w.setVisibility(8);
      break label111;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType != 12) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int != 1))
      {
        paramrxy.b.setVisibility(8);
        paramrxy.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
      while ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString)))
      {
        paramrxy.Q.setText(e());
        return;
        paramrxy.b.setVisibility(0);
        paramrxy.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
    }
  }
  
  public void a(rxy paramrxy, int paramInt1, int paramInt2)
  {
    if ((paramrxy == null) || (this.jdField_a_of_type_Orb == null)) {
      return;
    }
    this.jdField_a_of_type_Orb.jdField_b_of_type_Int = paramInt2;
    if (paramInt1 != 8) {
      this.jdField_a_of_type_Orb.jdField_a_of_type_Int = paramInt1;
    }
    this.jdField_d_of_type_Boolean = false;
    switch (paramInt1)
    {
    case 2: 
    case 7: 
    default: 
      return;
    case 1: 
      if (this.e)
      {
        paramrxy.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramrxy.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717083));
        paramrxy.b.a(2, 100);
      }
    case 3: 
    case 5: 
      for (;;)
      {
        this.jdField_d_of_type_Boolean = true;
        if (!this.jdField_c_of_type_Boolean) {
          break;
        }
        if (!this.e) {
          break label297;
        }
        paramrxy.b.setVisibility(0);
        return;
        l();
        if (!this.e) {
          break;
        }
        paramrxy.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        return;
        if (this.e)
        {
          paramrxy.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          paramrxy.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717076));
          paramrxy.b.a(2, 100);
          this.jdField_d_of_type_Boolean = true;
          if (this.jdField_c_of_type_Boolean)
          {
            if (!this.e) {
              break label273;
            }
            paramrxy.b.setVisibility(0);
          }
        }
        for (;;)
        {
          a(paramInt1);
          return;
          paramrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a(2, 100);
          break;
          paramrxy.x.setVisibility(0);
        }
        paramrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a(2, 100);
      }
      paramrxy.x.setVisibility(0);
      return;
    case 4: 
      if (this.e)
      {
        paramrxy.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramrxy.b.a(4, paramInt2);
        return;
      }
      paramrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a(4, paramInt2);
      return;
    case 6: 
      label273:
      label297:
      if (this.e)
      {
        paramrxy.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramrxy.b.a(0, 0);
      }
      for (;;)
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, anni.a(2131714910), 0).a();
        return;
        paramrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a(0, 0);
      }
    }
    c();
  }
  
  public void a(sea paramsea)
  {
    this.jdField_a_of_type_Sea = paramsea;
  }
  
  public boolean a()
  {
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType == 2)) {
      bool = true;
    }
    while ((bool) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 2))
    {
      String str1 = b();
      String str2 = a();
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        return true;
        bool = false;
      }
      else
      {
        return false;
      }
    }
    return bool;
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    if (MainService.isDebugVersion) {}
    do
    {
      do
      {
        return true;
      } while (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString));
      if (oqj.a(this.jdField_a_of_type_Omy)) {
        return false;
      }
    } while (!this.jdField_b_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString));
    return false;
  }
  
  public boolean a(VideoInfo paramVideoInfo, rxy paramrxy, double paramDouble, long paramLong)
  {
    if ((paramrxy.y != null) && (paramrxy.y.getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsSoftAdBarDelegateForAd", 2, "进度判断 video_percent=" + paramDouble);
      }
      return a(paramVideoInfo, paramDouble, paramLong);
    }
    return false;
  }
  
  protected int b()
  {
    if (this.jdField_a_of_type_Orb == null) {
      return 0;
    }
    return this.jdField_a_of_type_Orb.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int != 0) {
          break label135;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType != 12) {
          break label74;
        }
        str1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName;
      }
    }
    return str1;
    label74:
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 0)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdDesc)) {
        return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdDesc;
      }
      return anni.a(2131714825);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdTxt;
    label135:
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 0)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_JavaLangString)) {
        return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_JavaLangString;
      }
      return anni.a(2131714862);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString;
  }
  
  protected void b()
  {
    if ((d()) && (this.jdField_a_of_type_Orb != null))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Orb.jdField_d_of_type_JavaLangString)) {
        oqj.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Orb.jdField_d_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    ubb.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true);
  }
  
  public void b(rxy paramrxy)
  {
    this.jdField_c_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  public String c()
  {
    String str2 = "详情";
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
      {
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)
        {
          str1 = str2;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.D)) {
            str1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.D;
          }
        }
      }
    }
    return str1;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Orb == null) {}
    do
    {
      do
      {
        return;
        if (this.jdField_b_of_type_Boolean) {
          break;
        }
        if (this.jdField_a_of_type_Orb.jdField_a_of_type_Int == 4)
        {
          a(this.jdField_a_of_type_Rxy, 4, b());
          return;
        }
        if (this.jdField_a_of_type_Orb.jdField_a_of_type_Int == 5)
        {
          String str = this.jdField_a_of_type_Orb.jdField_d_of_type_JavaLangString;
          if (bgnw.a(BaseApplicationImpl.getContext(), str))
          {
            this.jdField_a_of_type_Orb.jdField_a_of_type_Int = 1;
            a(this.jdField_a_of_type_Rxy, 1, b());
            return;
          }
          a(this.jdField_a_of_type_Rxy, 5, b());
          return;
        }
      } while (this.jdField_a_of_type_Orb.jdField_a_of_type_Int != 3);
      a(this.jdField_a_of_type_Rxy, 3, b());
    } while ((this.jdField_a_of_type_Orb == null) || (this.jdField_a_of_type_Nxp == null));
    this.jdField_a_of_type_Nxp.a(this.jdField_a_of_type_Orb);
    return;
    int i = nxw.jdField_a_of_type_Int;
    if (nxp.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Orb))
    {
      f();
      this.jdField_a_of_type_Orb.jdField_a_of_type_Int = 5;
      c(i);
      return;
    }
    e();
    c(i);
  }
  
  public void c(rxy paramrxy)
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_d_of_type_Boolean)
    {
      if (!this.e) {
        break label39;
      }
      paramrxy.b.setVisibility(0);
    }
    for (;;)
    {
      if (this.e) {
        j();
      }
      return;
      label39:
      paramrxy.x.setVisibility(0);
    }
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public String d()
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
      {
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)
        {
          str1 = str2;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.E)) {
            str1 = "来自" + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.E;
          }
        }
      }
    }
    return str1;
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_Nxp != null) && (this.jdField_a_of_type_Orb != null)) {
      this.jdField_a_of_type_Nxp.a(this.jdField_a_of_type_Orb);
    }
  }
  
  protected boolean d()
  {
    return true;
  }
  
  protected void e()
  {
    if ((this.jdField_a_of_type_Nxp != null) && (this.jdField_a_of_type_Orb != null)) {
      this.jdField_a_of_type_Nxp.a(this.jdField_a_of_type_Orb);
    }
    if ((this.jdField_a_of_type_Rxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView != null) || ((this.jdField_a_of_type_Rxy.b != null) && (this.jdField_a_of_type_Orb != null))) {
      l();
    }
  }
  
  protected void f()
  {
    if ((this.jdField_a_of_type_Orb != null) && (this.jdField_a_of_type_Nxp != null)) {
      this.jdField_a_of_type_Nxp.d(this.jdField_a_of_type_Orb);
    }
  }
  
  protected void g()
  {
    if ((this.jdField_a_of_type_Orb != null) && (this.jdField_a_of_type_Nxp != null)) {
      this.jdField_a_of_type_Nxp.a(this.jdField_a_of_type_Orb, true);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    rxy localrxy = (rxy)paramView.getTag();
    int j = nxw.jdField_a_of_type_Int;
    this.jdField_b_of_type_Boolean = true;
    switch (paramView.getId())
    {
    default: 
    case 2131362017: 
    case 2131362107: 
    case 2131362016: 
    case 2131362019: 
    case 2131367936: 
    case 2131380636: 
    case 2131380637: 
      do
      {
        return;
        if (this.jdField_a_of_type_Sea != null) {
          this.jdField_a_of_type_Sea.a();
        }
        this.f = true;
        b(paramView.getId());
        a(j, 3);
        return;
        b(paramView.getId());
        if (!this.e) {
          break label296;
        }
        if ((a() != 1) || (paramView.getId() != 2131362016) || (localrxy == null)) {
          break;
        }
        localrxy.b.callOnClick();
      } while (localrxy.b.a() == 2);
      localrxy.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      if (paramView.getId() == 2131362016) {}
      for (i = 1;; i = 0)
      {
        a(j, i);
        if ((paramView.getId() != 2131362016) || (TextUtils.isEmpty(ubb.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)))) {
          break;
        }
        ubb.a(this.jdField_a_of_type_AndroidAppActivity, ubb.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdRl, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdTraceId);
        return;
      }
      label296:
      if (paramView.getId() == 2131367936) {}
      for (;;)
      {
        a(j, i);
        break;
        i = 0;
      }
      k();
      return;
    }
    if (this.e)
    {
      i = localrxy.b.a();
      if (i != 2) {
        break label525;
      }
      if (!bgnw.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Orb.jdField_d_of_type_JavaLangString)) {
        break label404;
      }
      b();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = 1;
      this.jdField_a_of_type_Orb.jdField_a_of_type_Int = 1;
    }
    label525:
    for (;;)
    {
      a(j, 1);
      return;
      i = localrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.a();
      break;
      label404:
      if (nxp.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Orb))
      {
        paramView = bisa.a().c(this.jdField_a_of_type_Orb.jdField_d_of_type_JavaLangString);
        bisa.a().a(paramView);
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = 5;
        this.jdField_a_of_type_Orb.jdField_a_of_type_Int = 5;
      }
      else if (nxp.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Orb))
      {
        f();
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = 5;
        this.jdField_a_of_type_Orb.jdField_a_of_type_Int = 5;
      }
      else if (bgnt.h(BaseApplicationImpl.getContext()))
      {
        e();
      }
      else
      {
        k();
        continue;
        if ((i == 0) || (i == 4))
        {
          if (i == 4)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = 3;
            this.jdField_a_of_type_Orb.jdField_a_of_type_Int = 3;
          }
          if (bgnt.h(BaseApplicationImpl.getContext()))
          {
            if (i == 0)
            {
              if (this.jdField_a_of_type_Orb.jdField_a_of_type_Boolean)
              {
                d();
                return;
              }
              e();
            }
            else
            {
              e();
            }
          }
          else {
            k();
          }
        }
        else if (i == 1)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = 4;
          this.jdField_a_of_type_Orb.jdField_a_of_type_Int = 4;
          g();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     opl
 * JD-Core Version:    0.7.0.1
 */