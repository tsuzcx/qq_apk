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

public class ohm
  extends ohl
  implements View.OnClickListener, View.OnKeyListener, qts, quj, rvv, rwa, rxa, rxb, rxc
{
  private static boolean jdField_a_of_type_Boolean = true;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  protected pfh a;
  private rvy jdField_a_of_type_Rvy;
  private rwr jdField_a_of_type_Rwr;
  private rwu jdField_a_of_type_Rwu;
  sel jdField_a_of_type_Sel;
  private int jdField_b_of_type_Int = -1;
  private volatile boolean jdField_b_of_type_Boolean;
  private int c;
  private int d = -1;
  
  public ohm(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Pfh = new oho(this, null);
  }
  
  private boolean a()
  {
    return b() == 40677;
  }
  
  private boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_Rvy != null) && (this.jdField_a_of_type_Rvy.b()) && (this.jdField_a_of_type_Rwu != null) && (!this.jdField_a_of_type_Rwu.a()))
    {
      this.jdField_a_of_type_Rwu.c(paramInt);
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
    if (this.jdField_a_of_type_Sel == null) {
      return null;
    }
    return this.jdField_a_of_type_Sel.a();
  }
  
  public rvy a()
  {
    return this.jdField_a_of_type_Rvy;
  }
  
  public rwr a()
  {
    return this.jdField_a_of_type_Rwr;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Rwr = new rwr(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Rvy = new rvy(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Rvy.a(this.jdField_a_of_type_Rwr);
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(b()), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, b(), c(), this.d, null);
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setNotifyEndRefresh(new ohn(this));
    this.jdField_a_of_type_Sel = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    if (this.jdField_a_of_type_Sel != null) {
      this.jdField_a_of_type_Sel.e();
    }
    Object localObject;
    if (((this.jdField_a_of_type_AndroidAppActivity instanceof ReadInJoyNewFeedsActivity)) || ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)))
    {
      localObject = odr.b();
      odr.a.put(ReadInJoyVideoChannelFragment.class, localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rvy.a((String)localObject);
      this.jdField_a_of_type_Rwr.a((String)localObject);
      this.jdField_a_of_type_Rwu = new rwu((FrameLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131380948), (ReadInJoyBaseListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131378246), this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_Rwu.a(this);
      this.jdField_a_of_type_Rvy.a(this.jdField_a_of_type_Rwu);
      this.jdField_a_of_type_Rwu.a(this);
      this.jdField_a_of_type_Rwu.a(this);
      this.jdField_a_of_type_Rwu.b(this);
      this.jdField_a_of_type_Rvy.a(this);
      this.jdField_a_of_type_Sel.f();
      if (b())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.setFocusableInTouchMode(true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.requestFocus();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.setOnKeyListener(this);
      }
      pfd.a().a(this.jdField_a_of_type_Pfh);
      if (jdField_a_of_type_Boolean)
      {
        jdField_a_of_type_Boolean = false;
        pfa.a().c();
      }
      b();
      return;
      String str = (String)odr.a.get(ReadInJoyChannelActivity.class);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = odr.b();
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
  
  public void a(rld paramrld1, rld paramrld2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyBaseAdapter", 2, "onNextVideoPlay:  enterVideoPlayParam:" + paramrld1 + "  nextVideoPlayParam:" + paramrld2 + "\n nextScrollByDistance:" + paramInt + " isPlayFirstNext:" + paramBoolean);
    }
    BaseArticleInfo localBaseArticleInfo;
    sel localsel;
    if ((paramrld1 != null) && ((paramrld1 instanceof rwc)) && (paramrld2 != null) && ((paramrld2 instanceof rwc)))
    {
      paramrld1 = ((rwc)paramrld1).a;
      localBaseArticleInfo = ((rwc)paramrld2).a;
      if ((paramrld1 != null) && (localBaseArticleInfo != null))
      {
        localsel = this.jdField_a_of_type_Sel;
        if (paramBoolean) {
          break label160;
        }
      }
    }
    label160:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localsel.a(paramrld1, localBaseArticleInfo, paramBoolean);
      if (!this.jdField_a_of_type_Rwu.a()) {
        this.jdField_a_of_type_Sel.a((rwc)paramrld2, 1);
      }
      return;
    }
  }
  
  public void a(rwc paramrwc)
  {
    if (rmn.c) {
      return;
    }
    this.jdField_a_of_type_Sel.a(paramrwc);
  }
  
  public void a(rwc paramrwc, int paramInt1, int paramInt2) {}
  
  public void a(rwc paramrwc1, rwc paramrwc2)
  {
    this.jdField_a_of_type_Sel.a(paramrwc1, paramrwc2);
  }
  
  public void a(rwc paramrwc, rwf paramrwf, int paramInt1, int paramInt2, Object paramObject) {}
  
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
        localReadInJoyListViewGroup.t();
      }
      if (!paramBoolean2) {
        localReadInJoyListViewGroup.u();
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
    if (this.jdField_a_of_type_Sel != null) {
      this.jdField_a_of_type_Sel.a(paramInt);
    }
  }
  
  public void d()
  {
    pfd.a().b(this.jdField_a_of_type_Pfh);
    super.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(b(Integer.valueOf(b())), a(Integer.valueOf(b())));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(this.jdField_b_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.g();
    this.jdField_a_of_type_Sel.d();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    if (this.jdField_a_of_type_Rvy != null)
    {
      this.jdField_a_of_type_Rvy.b(this);
      this.jdField_a_of_type_Rvy.d();
    }
    if (this.jdField_a_of_type_Rwu != null) {
      this.jdField_a_of_type_Rwu.a(null);
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Sel != null) {
      this.jdField_a_of_type_Sel.notifyDataSetChanged();
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
    this.jdField_a_of_type_Rvy.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
  }
  
  public void h()
  {
    super.h();
    pfd.a().a(this.jdField_a_of_type_Pfh);
    this.jdField_a_of_type_Rvy.f();
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
    this.jdField_a_of_type_Rwu.j();
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)))
    {
      Object localObject = a(Integer.valueOf(b()));
      Map localMap = ubg.a(b());
      ThreadManager.executeOnSubThread(new ReadInJoyChannelViewController.2(this, (Map)localObject, a(Integer.valueOf(b())), localMap, ozs.e(b())));
      b(Integer.valueOf(b())).clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      localObject = (pmm)((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a(2);
      if (localObject != null) {
        ((pmm)localObject).i();
      }
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_Sel.l();
  }
  
  public void m()
  {
    this.jdField_a_of_type_Rvy.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
    if ((this.jdField_a_of_type_Rwu != null) && (this.jdField_a_of_type_Rwu.a() != null)) {
      this.jdField_a_of_type_Rwu.a().c();
    }
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_Rwu != null) && (this.jdField_a_of_type_Rwu.a() != null)) {
      this.jdField_a_of_type_Rwu.a().b();
    }
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
        ocd.a(null, null, "0X800932E", "0X800932E", 0, 0, "", "", "", odr.a(null), false);
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
    if (zqd.a(a()))
    {
      ucd.a(a(), "video_type_videopublic");
      ocd.a(null, "", "0X8009338", "0X8009338", 0, 0, "", "", "", odr.a("0"), false);
      return;
    }
    QQToast.a(a(), -1, anzj.a(2131711955), 0).b(a().getResources().getDimensionPixelSize(2131299011));
    ucd.b(a(), "video_type_videopublic");
    ocd.a(null, "", "0X8009338", "0X8009338", 0, 0, "", "", "", odr.a("1"), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohm
 * JD-Core Version:    0.7.0.1
 */