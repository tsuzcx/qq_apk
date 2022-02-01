import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class osm
  extends ViewBase
  implements View.OnClickListener
{
  protected int a;
  protected Context a;
  protected View a;
  protected FrameLayout a;
  public TextView a;
  public NativeAdDownloadView a;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private AdData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData;
  private oln jdField_a_of_type_Oln;
  private ols jdField_a_of_type_Ols;
  private olt jdField_a_of_type_Olt;
  public orb a;
  private pan jdField_a_of_type_Pan;
  private pxk jdField_a_of_type_Pxk;
  
  public osm(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_Int = -6447715;
    this.jdField_a_of_type_AndroidContentContext = paramVafContext.getContext();
    e();
  }
  
  private int a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {}
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID == 0L) {
      return 1;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID == 95555552L) {
      return 2;
    }
    return 3;
  }
  
  private void a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    if (this.jdField_a_of_type_Ols != null)
    {
      int i = (int)this.jdField_a_of_type_Ols.h;
      if (i > 0)
      {
        i = afur.a(i, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramDrawable.setBounds(0, 0, i, i);
        return;
      }
    }
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
  }
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof AdvertisementInfo)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)paramObject);
    }
    for (this.jdField_a_of_type_Orb = orb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);; this.jdField_a_of_type_Orb = orb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      h();
      a();
      f();
      do
      {
        return;
      } while (!(paramObject instanceof AdData));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData = ((AdData)paramObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = oqk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData);
    }
  }
  
  private void a(ols paramols)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (paramols == null)) {
      return;
    }
    ole.a(this.jdField_a_of_type_AndroidContentContext, this, paramols, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView);
  }
  
  private void a(olt paramolt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView != null) && (paramolt != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setStyle(paramolt);
    }
  }
  
  private boolean a(nxp paramnxp)
  {
    if (this.jdField_a_of_type_Orb == null) {}
    for (String str = ""; (TextUtils.isEmpty(str)) || (paramnxp == null) || (paramnxp.a() == null) || (paramnxp.a().size() == 0); str = this.jdField_a_of_type_Orb.d) {
      return false;
    }
    paramnxp = paramnxp.a().iterator();
    while (paramnxp.hasNext())
    {
      orb localorb = (orb)paramnxp.next();
      if ((localorb.d != null) && (localorb.d.equals(str))) {
        return true;
      }
    }
    return false;
  }
  
  private int b()
  {
    int j = afur.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int i = j;
    if (this.jdField_a_of_type_Ols != null)
    {
      int k = (int)this.jdField_a_of_type_Ols.g;
      i = j;
      if (k > 0) {
        i = afur.a(k, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
    }
    return i;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Oln.jdField_a_of_type_Nxp != null) {
      this.jdField_a_of_type_Oln.jdField_a_of_type_Nxp.a(new osn(this));
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131560031, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370348));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362784));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView = ((NativeAdDownloadView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380869));
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setOnClickListener(this);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    if ((f()) && (g()))
    {
      setClickable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setClickable(true);
      oqh.a("ReadInJoyAdDownloadView", "mAppButton is clickable");
    }
    for (;;)
    {
      oqh.a("ReadInJoyAdDownloadView", "allowShowProgress = " + f() + " isApp = " + AdvertisementInfo.isAppAdvertisementInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo) + " PackageName = " + this.jdField_a_of_type_Orb.d + " AppID= " + this.jdField_a_of_type_Orb.a);
      return;
      setClickable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setClickable(false);
      oqh.a("ReadInJoyAdDownloadView", "mAppButton is unClickable");
    }
  }
  
  private boolean f()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID == 0L) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        return false;
        i = 0;
      }
      else
      {
        return true;
        i = 1;
      }
    }
  }
  
  private void g()
  {
    int j;
    int i;
    if ((this.jdField_a_of_type_Ols != null) && (a()) && (this.jdField_a_of_type_Ols.b == 1.0F))
    {
      j = -15550475;
      i = j;
    }
    try
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Ols.a)) {
        i = nya.a(this.jdField_a_of_type_Ols.a, "#12B7F5");
      }
      Object localObject = a();
      if (localObject != null)
      {
        ((Drawable)localObject).setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        a((Drawable)localObject);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
        i = b();
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(i);
      }
      if ((this.jdField_a_of_type_Orb == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null)) {}
      do
      {
        return;
        localObject = this.jdField_a_of_type_Orb.d;
      } while (TextUtils.isEmpty((CharSequence)localObject));
      if (olc.a((String)localObject))
      {
        if (opz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText("打开");
          return;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText("立即打开");
        return;
      }
      if (!f()) {
        a();
      }
      olc.a(this.jdField_a_of_type_Orb, new oso(this));
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
  
  private boolean g()
  {
    return ((AdvertisementInfo.isAppAdvertisementInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) || (opz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))) && (!TextUtils.isEmpty(this.jdField_a_of_type_Orb.d)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Orb.a));
  }
  
  private void h()
  {
    this.jdField_a_of_type_Oln = new oln();
    if ((this.jdField_a_of_type_AndroidContentContext instanceof orz))
    {
      oln localoln = ((orz)this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Orb.d);
      if (localoln != null) {
        this.jdField_a_of_type_Oln = localoln;
      }
    }
    if (this.jdField_a_of_type_Oln.jdField_a_of_type_Nxp == null) {
      this.jdField_a_of_type_Oln.jdField_a_of_type_Nxp = a();
    }
    this.jdField_a_of_type_Oln.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Oln.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    this.jdField_a_of_type_Oln.a(this.jdField_a_of_type_Orb);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
      this.jdField_a_of_type_Oln.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData);
    }
    this.jdField_a_of_type_Oln.a(new osp(this));
    d();
  }
  
  protected Drawable a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Drawable localDrawable;
    if (this.jdField_a_of_type_Ols != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Ols.b == 1.0F)
      {
        localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842677);
        if ((this.jdField_a_of_type_Orb == null) || (!bgnw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Orb.d))) {
          break label79;
        }
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842677);
      }
    }
    label79:
    do
    {
      return localObject1;
      if (e()) {
        return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842675);
      }
      if ((c()) || (d())) {
        return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842678);
      }
      localObject1 = localObject2;
    } while (b());
    return localDrawable;
  }
  
  protected String a()
  {
    return oqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  public nxp a()
  {
    Object localObject2 = null;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof orz)) {
      localObject2 = ((orz)this.jdField_a_of_type_AndroidContentContext).a();
    }
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Pan != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Pan.a() != null) {
          localObject1 = this.jdField_a_of_type_Pan.a();
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Pxk != null)
      {
        localObject2 = localObject1;
        if (this.jdField_a_of_type_Pxk.a() != null) {
          localObject2 = this.jdField_a_of_type_Pxk.a().a();
        }
      }
    }
    return localObject2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Oln != null)
    {
      String str = this.jdField_a_of_type_Oln.b();
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      }
    }
  }
  
  public void a(orb paramorb, int paramInt1, int paramInt2)
  {
    if ((paramorb == null) || (this.jdField_a_of_type_Oln == null) || (this.jdField_a_of_type_Oln.jdField_a_of_type_Orb == null) || (this.jdField_a_of_type_Oln.jdField_a_of_type_Orb.d == null) || (!this.jdField_a_of_type_Oln.jdField_a_of_type_Orb.d.trim().equals(paramorb.d)))
    {
      oqh.a("ReadInJoyAdDownloadView", "updateDownloadState error : maybe packageName not equal");
      return;
    }
    this.jdField_a_of_type_Oln.a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView, paramInt1, paramInt2);
  }
  
  public void a(pan parampan)
  {
    this.jdField_a_of_type_Pan = parampan;
    if ((this.jdField_a_of_type_Oln != null) && (parampan != null) && (this.jdField_a_of_type_Oln.jdField_a_of_type_Nxp == null))
    {
      this.jdField_a_of_type_Oln.jdField_a_of_type_Nxp = parampan.a();
      d();
    }
  }
  
  public void a(pxk parampxk, boolean paramBoolean)
  {
    this.jdField_a_of_type_Pxk = parampxk;
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mShowAdButton))
    {
      c();
      f();
    }
  }
  
  public void a(boolean paramBoolean, AdvertisementInfo paramAdvertisementInfo, String paramString)
  {
    if ((paramAdvertisementInfo != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(a())))
    {
      paramAdvertisementInfo = BaseApplicationImpl.getContext().getResources().getString(2131717033);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAdvertisementInfo);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
    }
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      return false;
    }
    return AdvertisementInfo.isAppAdvertisementInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isCommentAd())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickPos = 8;
    }
  }
  
  protected boolean b()
  {
    return oqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      if (a()) {
        g();
      }
    }
    else {
      return;
    }
    a();
  }
  
  protected boolean c()
  {
    return oqj.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  protected boolean d()
  {
    return oqj.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  protected boolean e()
  {
    return (this.jdField_a_of_type_Orb != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Orb.d)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Orb.a)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Orb.c));
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
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b();
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131362784: 
        if (this.jdField_a_of_type_Oln != null) {
          this.jdField_a_of_type_Oln.a(a());
        }
        break;
      case 2131380869: 
        if (this.jdField_a_of_type_Oln != null) {
          this.jdField_a_of_type_Oln.b(a());
        }
        break;
      }
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
              return bool1;
              a(paramObject);
              bool1 = bool2;
            } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null);
            bool1 = bool2;
          } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isCommentAd());
          bool1 = bool2;
        } while (this.jdField_a_of_type_AndroidWidgetTextView == null);
        this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.DEFAULT);
        return true;
        bool1 = bool2;
      } while (!(paramObject instanceof JSONObject));
      this.jdField_a_of_type_Olt = olt.a(1, (JSONObject)paramObject);
      a(this.jdField_a_of_type_Olt);
      return true;
      bool1 = bool2;
    } while (!(paramObject instanceof JSONObject));
    this.jdField_a_of_type_Ols = ols.a((JSONObject)paramObject);
    a(this.jdField_a_of_type_Ols);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osm
 * JD-Core Version:    0.7.0.1
 */