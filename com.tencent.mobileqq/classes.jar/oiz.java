import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController.2;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class oiz
  extends oiy
  implements View.OnClickListener, View.OnKeyListener, raq, rbh, scz, sde, see, sef, seg
{
  private static boolean jdField_a_of_type_Boolean = true;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  protected pkt a;
  private qxz jdField_a_of_type_Qxz;
  private sdc jdField_a_of_type_Sdc;
  private sdv jdField_a_of_type_Sdv;
  private sdy jdField_a_of_type_Sdy;
  slt jdField_a_of_type_Slt;
  private int jdField_b_of_type_Int = -1;
  private volatile boolean jdField_b_of_type_Boolean;
  private int c;
  private int d = -1;
  
  public oiz(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Pkt = new ojb(this, null);
  }
  
  private boolean a()
  {
    return b() == 40677;
  }
  
  private boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_Sdc != null) && (this.jdField_a_of_type_Sdc.b()) && (this.jdField_a_of_type_Sdy != null) && (!this.jdField_a_of_type_Sdy.a()))
    {
      this.jdField_a_of_type_Sdy.c(paramInt);
      return true;
    }
    return false;
  }
  
  private int b()
  {
    if (this.jdField_b_of_type_Int != -1) {
      return this.jdField_b_of_type_Int;
    }
    return this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("channel_id", 0);
  }
  
  private boolean b()
  {
    return b() == 56;
  }
  
  private int c()
  {
    if (this.jdField_c_of_type_Int != -1) {
      return this.jdField_c_of_type_Int;
    }
    return this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("channel_type", 0);
  }
  
  public int a()
  {
    int i = -1;
    if (this.d != -1) {
      i = this.d;
    }
    while (a().getIntent() == null) {
      return i;
    }
    return a().getIntent().getIntExtra("channel_from", -1);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public List<BaseArticleInfo> a()
  {
    if (this.jdField_a_of_type_Slt == null) {
      return null;
    }
    return this.jdField_a_of_type_Slt.a();
  }
  
  public sdc a()
  {
    return this.jdField_a_of_type_Sdc;
  }
  
  public sdv a()
  {
    return this.jdField_a_of_type_Sdv;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Sdv = new sdv(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Sdc = new sdc(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Sdc.a(this.jdField_a_of_type_Sdv);
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(b()), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, b(), c(), this.d, null);
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setNotifyEndRefresh(new oja(this));
    this.jdField_a_of_type_Slt = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    if (this.jdField_a_of_type_Slt != null) {
      this.jdField_a_of_type_Slt.c();
    }
    Object localObject;
    if (((this.jdField_a_of_type_AndroidAppActivity instanceof ReadInJoyNewFeedsActivity)) || ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)))
    {
      localObject = ofe.b();
      ofe.a.put(ReadInJoyVideoChannelFragment.class, localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Sdc.a((String)localObject);
      this.jdField_a_of_type_Sdv.a((String)localObject);
      this.jdField_a_of_type_Sdy = new sdy((FrameLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131380674), (ReadInJoyBaseListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131378014), this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_Sdy.a(this);
      this.jdField_a_of_type_Sdc.a(this.jdField_a_of_type_Sdy);
      this.jdField_a_of_type_Sdy.a(this);
      this.jdField_a_of_type_Sdy.a(this);
      this.jdField_a_of_type_Sdy.b(this);
      this.jdField_a_of_type_Sdc.a(this);
      if (b())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.setFocusableInTouchMode(true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.requestFocus();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.setOnKeyListener(this);
      }
      pkp.a().a(this.jdField_a_of_type_Pkt);
      if (jdField_a_of_type_Boolean)
      {
        jdField_a_of_type_Boolean = false;
        pkm.a().c();
      }
      b();
      this.jdField_a_of_type_Qxz = new qxz();
      this.jdField_a_of_type_Qxz.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Sdc);
      return;
      String str = (String)ofe.a.get(ReadInJoyChannelActivity.class);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = ofe.b();
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setRefreshHeader(paramInt);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a(rsd paramrsd1, rsd paramrsd2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyBaseAdapter", 2, "onNextVideoPlay:  enterVideoPlayParam:" + paramrsd1 + "  nextVideoPlayParam:" + paramrsd2 + "\n nextScrollByDistance:" + paramInt + " isPlayFirstNext:" + paramBoolean);
    }
    BaseArticleInfo localBaseArticleInfo;
    slt localslt;
    if ((paramrsd1 != null) && ((paramrsd1 instanceof sdg)) && (paramrsd2 != null) && ((paramrsd2 instanceof sdg)))
    {
      paramrsd1 = ((sdg)paramrsd1).a;
      localBaseArticleInfo = ((sdg)paramrsd2).a;
      if ((paramrsd1 != null) && (localBaseArticleInfo != null))
      {
        localslt = this.jdField_a_of_type_Slt;
        if (paramBoolean) {
          break label159;
        }
      }
    }
    label159:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localslt.a(paramrsd1, localBaseArticleInfo, paramBoolean);
      if (!this.jdField_a_of_type_Sdy.a()) {
        this.jdField_a_of_type_Slt.a((sdg)paramrsd2, 1);
      }
      return;
    }
  }
  
  public void a(sdg paramsdg)
  {
    if (rtp.c) {
      return;
    }
    this.jdField_a_of_type_Slt.a(paramsdg);
  }
  
  public void a(sdg paramsdg, int paramInt1, int paramInt2) {}
  
  public void a(sdg paramsdg1, sdg paramsdg2)
  {
    this.jdField_a_of_type_Slt.a(paramsdg1, paramsdg2);
  }
  
  public void a(sdg paramsdg, sdj paramsdj, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramBoolean);
    super.a(paramBoolean, paramInt);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))
    {
      ReadInJoyListViewGroup localReadInJoyListViewGroup = (ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
      if (!paramBoolean1) {
        localReadInJoyListViewGroup.o();
      }
      if (!paramBoolean2) {
        localReadInJoyListViewGroup.q();
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_Boolean = true;
        super.b();
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(a(Integer.valueOf(b())), b(Integer.valueOf(b())));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.b(this.jdField_b_of_type_JavaUtilMap);
    } while (this.jdField_a_of_type_AndroidViewViewGroup == null);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup, localLayoutParams);
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_Boolean = false;
        super.c();
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(b(Integer.valueOf(b())), a(Integer.valueOf(b())));
    } while (this.jdField_a_of_type_AndroidViewViewGroup == null);
    this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup);
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
    if (a().getIntent() != null) {
      a().getIntent().putExtra("channel_from", paramInt);
    }
    if (this.jdField_a_of_type_Slt != null) {
      this.jdField_a_of_type_Slt.a(paramInt);
    }
  }
  
  public void d()
  {
    pkp.a().b(this.jdField_a_of_type_Pkt);
    super.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(b(Integer.valueOf(b())), a(Integer.valueOf(b())));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(this.jdField_b_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.g();
    this.jdField_a_of_type_Slt.b();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    if (this.jdField_a_of_type_Sdc != null)
    {
      this.jdField_a_of_type_Sdc.b(this);
      this.jdField_a_of_type_Sdc.d();
    }
    if (this.jdField_a_of_type_Sdy != null) {
      this.jdField_a_of_type_Sdy.a(null);
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Slt != null) {
      this.jdField_a_of_type_Slt.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.e();
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.f();
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Qxz != null) {
      this.jdField_a_of_type_Qxz.b();
    }
    this.jdField_a_of_type_Sdc.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_Qxz != null) {
      this.jdField_a_of_type_Qxz.a();
    }
    pkp.a().a(this.jdField_a_of_type_Pkt);
    this.jdField_a_of_type_Sdc.f();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a();
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a(null, 1);
    }
  }
  
  public void j()
  {
    this.jdField_a_of_type_Sdy.j();
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)))
    {
      Object localObject = a(Integer.valueOf(b()));
      Map localMap = uhv.a(b());
      ThreadManager.executeOnSubThread(new ReadInJoyChannelViewController.2(this, (Map)localObject, a(Integer.valueOf(b())), localMap, pay.e(b())));
      b(Integer.valueOf(b())).clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      localObject = (prz)((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a().a(2);
      if (localObject != null) {
        ((prz)localObject).h();
      }
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Qxz != null) {
      this.jdField_a_of_type_Qxz.b();
    }
    this.jdField_a_of_type_Sdc.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
    if ((this.jdField_a_of_type_Sdy != null) && (this.jdField_a_of_type_Sdy.a() != null)) {
      this.jdField_a_of_type_Sdy.a().c();
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Qxz != null) {
      this.jdField_a_of_type_Qxz.a();
    }
    if ((this.jdField_a_of_type_Sdy != null) && (this.jdField_a_of_type_Sdy.a() != null)) {
      this.jdField_a_of_type_Sdy.a().b();
    }
  }
  
  public void o()
  {
    if (yqu.a(a()))
    {
      uit.a(a(), "video_type_videopublic");
      odq.a(null, "", "0X8009338", "0X8009338", 0, 0, "", "", "", ofe.a("0"), false);
      return;
    }
    QQToast.a(a(), -1, amtj.a(2131712187), 0).b(a().getResources().getDimensionPixelSize(2131299076));
    uit.b(a(), "video_type_videopublic");
    odq.a(null, "", "0X8009338", "0X8009338", 0, 0, "", "", "", ofe.a("1"), false);
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
      if (a())
      {
        Context localContext = this.jdField_a_of_type_AndroidViewViewGroup.getContext();
        Intent localIntent = new Intent(localContext, AccountDetailActivity.class);
        localIntent.putExtra("uin", String.valueOf(2062433139L));
        localIntent.putExtra("uintype", 1008);
        localIntent.putExtra("source", 119);
        localContext.startActivity(localIntent);
        odq.a(null, null, "0X800932E", "0X800932E", 0, 0, "", "", "", ofe.a(null), false);
      }
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (b())
    {
      bool1 = bool2;
      if (paramKeyEvent.getAction() == 0)
      {
        if (paramInt != 25) {
          break label41;
        }
        bool1 = a(-1);
      }
    }
    label41:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramInt != 24);
    return a(1);
  }
  
  public void p()
  {
    this.jdField_a_of_type_Slt.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oiz
 * JD-Core Version:    0.7.0.1
 */