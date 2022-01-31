import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class oft
  extends ViewBase
  implements View.OnClickListener
{
  protected int a;
  public Context a;
  protected View a;
  protected FrameLayout a;
  protected TextView a;
  protected NativeAdDownloadView a;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  protected JSONObject a;
  private pgd jdField_a_of_type_Pgd;
  protected qyj a;
  private int b;
  protected JSONObject b;
  
  public oft(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_Int = -6447715;
    this.jdField_a_of_type_AndroidContentContext = paramVafContext.getContext();
    a(paramVafContext);
  }
  
  private void a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    if (this.jdField_b_of_type_OrgJsonJSONObject != null)
    {
      int i = this.jdField_b_of_type_OrgJsonJSONObject.optInt("iconSize");
      if (i > 0)
      {
        i = aepi.a(i, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramDrawable.setBounds(0, 0, i, i);
        return;
      }
    }
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
  }
  
  private void a(VafContext paramVafContext)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131559881, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369906));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362676));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView = ((NativeAdDownloadView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379912));
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  private int d()
  {
    int j = aepi.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int i = j;
    if (this.jdField_b_of_type_OrgJsonJSONObject != null)
    {
      int k = this.jdField_b_of_type_OrgJsonJSONObject.optInt("drawablePadding");
      i = j;
      if (k > 0) {
        i = aepi.a(k, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
    }
    return i;
  }
  
  private boolean i()
  {
    if ((b()) && (this.jdField_a_of_type_Qyj != null)) {
      try
      {
        String str = this.jdField_a_of_type_Qyj.d;
        if (!TextUtils.isEmpty(str))
        {
          DownloadInfo localDownloadInfo = bfkr.a().c(str);
          if ((noq.a(this.jdField_a_of_type_AndroidContentContext, str)) && (localDownloadInfo != null) && (localDownloadInfo.a() == 4))
          {
            m();
            return true;
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
      }
    }
    return false;
  }
  
  private void o()
  {
    if (c())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
    }
  }
  
  private void p()
  {
    if ((b()) && (this.jdField_a_of_type_Qyj != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qyj.c)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setClickable(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
      b();
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setClickable(false);
    }
  }
  
  private void q()
  {
    String str2 = c();
    if ((QLog.isColorLevel()) && (TextUtils.isEmpty(str2))) {
      QLog.d("ReadInJoyAdDownloadView", 2, "bindData adDownloadApi null");
    }
    boolean bool = g();
    String str1 = "0";
    if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
      str1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("showProgress", "0");
    }
    if ((!TextUtils.isEmpty(str2)) && (bool) && (b()) && (str1.equals("1")) && (h()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAdDownloadView", 2, "bindData apptype adDownloadApi=" + str2);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setClickable(true);
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
      b();
      return;
    }
    if (e())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAdDownloadView", 2, "bindData ams subscribe type.");
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
      b();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdDownloadView", 2, "bindData not apptype");
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setClickable(false);
    this.jdField_a_of_type_AndroidViewView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
  }
  
  private void r()
  {
    int j;
    int i;
    if ((this.jdField_b_of_type_OrgJsonJSONObject != null) && (b()) && (this.jdField_b_of_type_OrgJsonJSONObject.optString("showBunttonLeftIconOrNot").trim().equals("1")))
    {
      j = -15550475;
      i = j;
    }
    try
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonTextColor"))) {
        i = npd.a(this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonTextColor"), "#12B7F5");
      }
      Object localObject = a();
      if (localObject != null)
      {
        ((Drawable)localObject).setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        a((Drawable)localObject);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
        i = d();
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(i);
      }
      if (i())
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
      }
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_Pgd == null) || (this.jdField_a_of_type_Pgd.a() == null) || (this.jdField_a_of_type_Qyj == null) || (this.jdField_a_of_type_Qyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null));
        localObject = this.jdField_a_of_type_Pgd.a().a();
      } while (localObject == null);
      ((noq)localObject).b(this.jdField_a_of_type_Qyj, this.jdField_a_of_type_Qyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      return;
    }
    szl.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mPopFormH5Url, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdRl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdTraceId);
  }
  
  protected int a()
  {
    return oee.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  protected int a(int paramInt)
  {
    if (c()) {
      paramInt = this.jdField_a_of_type_Int;
    }
    return paramInt;
  }
  
  protected Drawable a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Drawable localDrawable;
    if (this.jdField_b_of_type_OrgJsonJSONObject != null)
    {
      localObject1 = localObject2;
      if (this.jdField_b_of_type_OrgJsonJSONObject.optString("showBunttonLeftIconOrNot").trim().equals("1"))
      {
        localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842359);
        if ((this.jdField_a_of_type_Qyj == null) || (!bdiv.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Qyj.d))) {
          break label87;
        }
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842359);
      }
    }
    label87:
    do
    {
      return localObject1;
      if (f()) {
        return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842357);
      }
      if ((d()) || (e())) {
        return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842360);
      }
      localObject1 = localObject2;
    } while (c());
    return localDrawable;
  }
  
  protected String a()
  {
    return oee.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
    this.jdField_a_of_type_AndroidViewView.setClickable(true);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 2: 
    case 7: 
    default: 
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.a(paramInt1, paramInt2);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(0);
      return;
    case 5: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.a(paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
      b(paramInt1);
      return;
    case 1: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131713266));
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.a(paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
      return;
    case 4: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.a(paramInt1, paramInt2);
      return;
    case 6: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, alud.a(2131713372), 0).a();
      return;
    }
    f();
  }
  
  protected void a(AdData paramAdData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
    c();
    if (((paramAdData != null) && (oem.a(paramAdData))) || (oem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))) {
      a();
    }
    int i;
    do
    {
      return;
      i = a();
    } while (a());
    if (i == 1)
    {
      o();
      return;
    }
    if (i == 2)
    {
      p();
      return;
    }
    q();
  }
  
  public void a(pgd parampgd, boolean paramBoolean)
  {
    this.jdField_a_of_type_Pgd = parampgd;
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mShowAdButton)) {
      a(null);
    }
  }
  
  public void a(boolean paramBoolean, AdvertisementInfo paramAdvertisementInfo, String paramString)
  {
    if ((paramAdvertisementInfo != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(a())))
    {
      paramAdvertisementInfo = BaseApplicationImpl.getContext().getResources().getString(2131718907);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAdvertisementInfo);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected int b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress;
  }
  
  protected String b()
  {
    return oee.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mShowAdButton)) {
      return;
    }
    try
    {
      n();
      if (this.jdField_a_of_type_Qyj != null)
      {
        bool1 = bdiv.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Qyj.d);
        boolean bool2 = i();
        if ((bool1) || (bool2) || ((c() != 4) && (c() != 3)) || (b() < 0) || (b() >= 100)) {
          break label137;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.a(c(), b());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        boolean bool1 = false;
      }
      label137:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
    }
  }
  
  protected void b(int paramInt) {}
  
  protected boolean b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      return false;
    }
    return AdvertisementInfo.isAppAdvertisementInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  protected int c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState;
  }
  
  protected String c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdDownloadApiUrl;
  }
  
  protected void c()
  {
    d();
  }
  
  protected boolean c()
  {
    return oee.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  protected void d()
  {
    for (;;)
    {
      float f2;
      float f3;
      float f4;
      try
      {
        Drawable localDrawable = a();
        int i4 = -12541697;
        int i6 = d();
        f1 = 14.0F;
        int i3 = 0;
        int i2 = 0;
        i1 = 0;
        n = 0;
        String str1 = b();
        opi.a(this.jdField_a_of_type_AndroidWidgetTextView, null);
        f2 = f1;
        if (this.jdField_b_of_type_OrgJsonJSONObject != null)
        {
          if (TextUtils.isEmpty(this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonTextColor"))) {
            break label1059;
          }
          n = npd.a(this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonTextColor"), "#40A0FF");
          if (!TextUtils.isEmpty(this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonTextSize")))
          {
            f1 = npd.a(this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonTextSize"), 14);
            f2 = f1;
            if (f1 >= 10.0F) {
              break label1067;
            }
            f2 = 10.0F;
            break label1067;
          }
          localObject2 = this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonBorderColor");
          Object localObject1 = this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonBorderSize");
          String str2 = this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonBackgroundColor");
          String str3 = this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonCornerSize");
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (!TextUtils.isEmpty((CharSequence)localObject1)) || (!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3)))
          {
            GradientDrawable localGradientDrawable = new GradientDrawable();
            if (!TextUtils.isEmpty(str2)) {
              localGradientDrawable.setColor(npd.a(str2, "#40A0FF"));
            }
            if (npd.a((String)localObject1, 0.0F) > 0.0F)
            {
              f3 = npd.a((String)localObject1, 0.0F);
              f2 = f3;
              if (f3 > 2.0F) {
                f2 = 2.0F;
              }
              localGradientDrawable.setStroke(aepi.a(f2, this.jdField_a_of_type_AndroidContentContext.getResources()), npd.a((String)localObject2, "#40A0FF"));
            }
            if (!TextUtils.isEmpty(str3))
            {
              f3 = npd.a(str3, 0.0F);
              if (f3 >= 0.0F) {
                break label1096;
              }
              f2 = 0.0F;
              localGradientDrawable.setCornerRadius(aepi.a(f2, this.jdField_a_of_type_AndroidContentContext.getResources()));
            }
            opi.a(this.jdField_a_of_type_AndroidWidgetTextView, localGradientDrawable);
          }
          if ((!"1".equals(this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonTextBold"))) || (localDrawable != null))
          {
            a(localDrawable);
            localDrawable.setColorFilter(n, PorterDuff.Mode.SRC_ATOP);
          }
          f3 = npd.a(this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonHorizontalPadding").trim(), 0.0F);
          f4 = npd.a(this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonVerticalPadding").trim(), 0.0F);
          if (f3 >= 0.0F) {
            break label1113;
          }
          f2 = 0.0F;
          break label1084;
          label436:
          if (f2 <= 0.0F) {
            break label1050;
          }
          j = aepi.a(f2, this.jdField_a_of_type_AndroidContentContext.getResources());
          i = j;
          if (f3 <= 0.0F) {
            break label1041;
          }
          m = aepi.a(f3, this.jdField_a_of_type_AndroidContentContext.getResources());
          k = m;
          localObject2 = this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonAlignment");
          if (!"3".equals(localObject2)) {
            continue;
          }
          localObject2 = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject2).gravity = 21;
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject2 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject2).gravity = 21;
          this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          int i5 = a(n);
          f2 = npd.a(this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonWidth").trim(), 0.0F);
          f3 = npd.a(this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonHeight").trim(), 0.0F);
          if ((f2 <= 0.0F) || (f3 <= 0.0F)) {
            break label1014;
          }
          localObject2 = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject2).height = aepi.a(f3, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((FrameLayout.LayoutParams)localObject2).width = aepi.a(f2, this.jdField_a_of_type_AndroidContentContext.getResources());
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
          m = 0;
          k = 0;
          j = 0;
          i = 0;
          f4 = npd.a(this.jdField_b_of_type_OrgJsonJSONObject.optString("width").trim(), 0.0F);
          n = i;
          i1 = j;
          i2 = k;
          i3 = m;
          f2 = f1;
          i4 = i5;
          if (f4 > 0.0F)
          {
            f2 = 0.0F;
            if (npd.a((String)localObject1, 0.0F) <= 0.0F) {
              break label1011;
            }
            f3 = npd.a((String)localObject1, 0.0F);
            f2 = f3;
            if (f3 <= 2.0F) {
              break label1011;
            }
            f2 = 2.0F;
            localObject2 = getComLayoutParams();
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = new Layout.Params();
            }
            ((Layout.Params)localObject1).mLayoutWidth = aepi.a(f2 * 2.0F + f4, this.jdField_a_of_type_AndroidContentContext.getResources());
            setComLayoutParams((Layout.Params)localObject1);
            i4 = i5;
            f2 = f1;
            i3 = m;
            i2 = k;
            i1 = j;
            n = i;
          }
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(localDrawable, null, null, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(i6);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i4);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(f2);
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i3, i1, i2, n);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        return;
        if (!"1".equals(localObject2)) {
          continue;
        }
        Object localObject2 = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject2).gravity = 19;
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject2).gravity = 19;
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        continue;
        continue;
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        return;
      }
      label1011:
      label1014:
      int n = j;
      int i1 = i;
      int i = m;
      int j = k;
      int k = n;
      int m = i1;
      continue;
      label1041:
      k = 0;
      m = 0;
      continue;
      label1050:
      i = 0;
      j = 0;
      continue;
      label1059:
      n = -12541697;
      continue;
      label1067:
      float f1 = f2;
      if (f2 > 16.0F)
      {
        f1 = 16.0F;
        continue;
        for (;;)
        {
          label1084:
          if (f4 >= 0.0F) {
            break label1130;
          }
          f3 = 0.0F;
          break label436;
          label1096:
          f2 = f3;
          if (f3 <= 20.0F) {
            break;
          }
          f2 = 20.0F;
          break;
          label1113:
          f2 = f3;
          if (f3 > 12.0F) {
            f2 = 12.0F;
          }
        }
        label1130:
        f3 = f4;
        if (f4 > 12.0F) {
          f3 = 12.0F;
        }
      }
    }
  }
  
  protected boolean d()
  {
    return oee.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
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
    obg localobg = new obg();
    localobg.c = true;
    szl.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_Pgd.a(), (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true, localobg);
  }
  
  protected boolean e()
  {
    return oee.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Qyj == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null)) {
      return;
    }
    if (nop.a(this.jdField_a_of_type_Qyj, c()))
    {
      i();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = 5;
      noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.L).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
      return;
    }
    h();
    noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.aa).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
  }
  
  protected boolean f()
  {
    return oee.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  protected void g()
  {
    if ((this.jdField_a_of_type_Pgd != null) && (this.jdField_a_of_type_Pgd.a() != null) && (this.jdField_a_of_type_Qyj != null))
    {
      noq localnoq = this.jdField_a_of_type_Pgd.a().a();
      if (localnoq != null) {
        localnoq.b(this.jdField_a_of_type_Qyj);
      }
    }
  }
  
  protected boolean g()
  {
    return oed.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected void h()
  {
    if ((this.jdField_a_of_type_Pgd != null) && (this.jdField_a_of_type_Pgd.a() != null) && (this.jdField_a_of_type_Qyj != null))
    {
      noq localnoq = this.jdField_a_of_type_Pgd.a().a();
      if (localnoq != null) {
        localnoq.a(this.jdField_a_of_type_Qyj);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView != null)
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState != 4)) {
          break label92;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setProgress(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress);
      }
    }
    return;
    label92:
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setProgress(0);
  }
  
  protected boolean h()
  {
    return true;
  }
  
  protected void i()
  {
    if ((this.jdField_a_of_type_Pgd != null) && (this.jdField_a_of_type_Pgd.a() != null) && (this.jdField_a_of_type_Qyj != null))
    {
      noq localnoq = this.jdField_a_of_type_Pgd.a().a();
      if (localnoq != null) {
        localnoq.e(this.jdField_a_of_type_Qyj);
      }
    }
  }
  
  protected void j()
  {
    if ((this.jdField_a_of_type_Pgd != null) && (this.jdField_a_of_type_Pgd.a() != null) && (this.jdField_a_of_type_Qyj != null))
    {
      noq localnoq = this.jdField_a_of_type_Pgd.a().a();
      if (localnoq != null) {
        localnoq.c(this.jdField_a_of_type_Qyj);
      }
    }
  }
  
  protected void k()
  {
    if ((b()) && (this.jdField_a_of_type_Qyj != null))
    {
      if ((!this.jdField_a_of_type_Qyj.jdField_a_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_a_of_type_Qyj.d))) {
        break label53;
      }
      oee.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Qyj.d);
    }
    label53:
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      return;
    }
    szl.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true);
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      String str = oee.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      if (b()) {
        r();
      }
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      }
    }
  }
  
  protected void m()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = 5;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress = 100;
  }
  
  protected void n()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mProgressFromFeeds = true;
  }
  
  public void onClick(View paramView)
  {
    int j = 0;
    int i = 1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {}
    do
    {
      do
      {
        return;
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
          try
          {
            if (oem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
            {
              oem.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
              return;
            }
          }
          catch (Exception paramView)
          {
            paramView.printStackTrace();
            return;
          }
          j = oee.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
        }
      } while (j == 1);
      if (e())
      {
        s();
        noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.J).b(noy.L).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
        return;
      }
    } while (this.jdField_a_of_type_Qyj == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mProgressFromFeeds = true;
    paramView = this.jdField_a_of_type_Qyj.d;
    if (bdiv.a(BaseApplicationImpl.getContext(), paramView))
    {
      k();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = 1;
      noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.L).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
      return;
    }
    if (noq.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Qyj))
    {
      paramView = bfkr.a().c(this.jdField_a_of_type_Qyj.d);
      bfkr.a().a(paramView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = 5;
      noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.X).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
      return;
    }
    if (nop.a(this.jdField_a_of_type_Qyj, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState))
    {
      i();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = 5;
      noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.L).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
      return;
    }
    if ((bdin.b(this.jdField_a_of_type_AndroidContentContext)) && (oed.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdExtInfo))) {}
    for (;;)
    {
      for (;;)
      {
        if ((aatc.a()) || (i != 0))
        {
          if (j == 2)
          {
            g();
            return;
          }
          h();
          noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.X).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
          return;
        }
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          break;
        }
        szl.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_Pgd.a(), (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true, null);
        noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.L).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
        return;
        try
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mProgressFromFeeds = true;
          if (this.jdField_a_of_type_Qyj == null) {
            break;
          }
          paramView = this.jdField_a_of_type_Qyj.d;
          i = oee.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
          if (bdiv.a(BaseApplicationImpl.getContext(), paramView))
          {
            k();
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = 1;
            noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.L).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
            return;
          }
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
          return;
        }
      }
      if (noq.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Qyj))
      {
        paramView = bfkr.a().c(this.jdField_a_of_type_Qyj.d);
        bfkr.a().a(paramView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = 5;
        noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.L).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
        return;
      }
      if ((i == 2) && (nop.a(this.jdField_a_of_type_Qyj, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState)))
      {
        i();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = 5;
        noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.L).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
        return;
      }
      i = j;
      if (bdin.b(this.jdField_a_of_type_AndroidContentContext))
      {
        i = j;
        if (oed.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdExtInfo)) {
          i = 1;
        }
      }
      if ((aatc.a()) || (i != 0)) {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState == 3) {
          j();
        }
      }
      for (;;)
      {
        noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.L).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
        return;
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState == 4) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState == 0))
        {
          h();
          continue;
          if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
            szl.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_Pgd.a(), (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true, null);
          }
        }
      }
      i = 0;
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidViewView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView.measure(paramInt1, paramInt2);
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
              for (;;)
              {
                return bool1;
                bool1 = bool2;
                if (paramObject != null)
                {
                  bool1 = bool2;
                  try
                  {
                    if ((paramObject instanceof AdvertisementInfo))
                    {
                      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)paramObject);
                      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mShowAdButton) && (this.jdField_a_of_type_AndroidViewView != null))
                      {
                        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
                        return true;
                      }
                    }
                  }
                  catch (Exception paramObject)
                  {
                    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = null;
                    QLog.d("ReadInJoyAdDownloadView", 1, "setAttribute STR_ID_SET_AD_BANNER exception " + paramObject.toString());
                    return true;
                  }
                }
              }
              this.jdField_a_of_type_Qyj = qyj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
              return true;
              bool1 = bool2;
            } while (paramObject == null);
            bool1 = bool2;
          } while (!(paramObject instanceof JSONObject));
          this.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)paramObject);
          bool1 = bool2;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView == null);
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setProgressStyle(this.jdField_a_of_type_OrgJsonJSONObject);
        return true;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (!(paramObject instanceof JSONObject));
    this.jdField_b_of_type_OrgJsonJSONObject = ((JSONObject)paramObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oft
 * JD-Core Version:    0.7.0.1
 */