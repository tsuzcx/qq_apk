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
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
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

public class oqv
  extends oqu
  implements View.OnClickListener, View.OnKeyListener, rmw, rnn, spd, spi, sqj, sqk, sql
{
  private static boolean jdField_a_of_type_Boolean = true;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  protected pvq a;
  private rkf jdField_a_of_type_Rkf;
  private spg jdField_a_of_type_Spg;
  private spz jdField_a_of_type_Spz;
  private sqd jdField_a_of_type_Sqd;
  szd jdField_a_of_type_Szd;
  private int jdField_b_of_type_Int = -1;
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private int d = -1;
  
  public oqv(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Pvq = new oqx(this, null);
  }
  
  private boolean a()
  {
    return b() == 40677;
  }
  
  private boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_Spg != null) && (this.jdField_a_of_type_Spg.b()) && (this.jdField_a_of_type_Sqd != null) && (!this.jdField_a_of_type_Sqd.a()))
    {
      this.jdField_a_of_type_Sqd.c(paramInt);
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
    if (this.jdField_a_of_type_Szd == null) {
      return null;
    }
    return this.jdField_a_of_type_Szd.a();
  }
  
  public spg a()
  {
    return this.jdField_a_of_type_Spg;
  }
  
  public spz a()
  {
    return this.jdField_a_of_type_Spz;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Spz = new spz(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Spg = new spg(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Spg.a(this.jdField_a_of_type_Spz);
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(b()), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, b(), c(), this.d, null);
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setNotifyEndRefresh(new oqw(this));
    this.jdField_a_of_type_Szd = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    if (this.jdField_a_of_type_Szd != null) {
      this.jdField_a_of_type_Szd.c();
    }
    Object localObject;
    if (((this.jdField_a_of_type_AndroidAppActivity instanceof ReadInJoyNewFeedsActivity)) || ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)))
    {
      localObject = omx.b();
      omx.a.put(ReadInJoyVideoChannelFragment.class, localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Spg.a((String)localObject);
      this.jdField_a_of_type_Spz.a((String)localObject);
      this.jdField_a_of_type_Sqd = new sqd((FrameLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131381023), (ReadInJoyBaseListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131378302), this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_Sqd.a(this);
      this.jdField_a_of_type_Spg.a(this.jdField_a_of_type_Sqd);
      this.jdField_a_of_type_Sqd.a(this);
      this.jdField_a_of_type_Sqd.a(this);
      this.jdField_a_of_type_Sqd.b(this);
      this.jdField_a_of_type_Spg.a(this);
      if (b())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.setFocusableInTouchMode(true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.requestFocus();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.setOnKeyListener(this);
      }
      pvm.a().a(this.jdField_a_of_type_Pvq);
      if (jdField_a_of_type_Boolean)
      {
        jdField_a_of_type_Boolean = false;
        pvj.a().c();
      }
      b();
      this.jdField_a_of_type_Rkf = new rkf();
      this.jdField_a_of_type_Rkf.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Spg);
      return;
      String str = (String)omx.a.get(ReadInJoyChannelActivity.class);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = omx.b();
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
  
  public void a(ses paramses1, ses paramses2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyBaseAdapter", 2, "onNextVideoPlay:  enterVideoPlayParam:" + paramses1 + "  nextVideoPlayParam:" + paramses2 + "\n nextScrollByDistance:" + paramInt + " isPlayFirstNext:" + paramBoolean);
    }
    BaseArticleInfo localBaseArticleInfo;
    szd localszd;
    if ((paramses1 != null) && ((paramses1 instanceof spk)) && (paramses2 != null) && ((paramses2 instanceof spk)))
    {
      paramses1 = ((spk)paramses1).a;
      localBaseArticleInfo = ((spk)paramses2).a;
      if ((paramses1 != null) && (localBaseArticleInfo != null))
      {
        localszd = this.jdField_a_of_type_Szd;
        if (paramBoolean) {
          break label159;
        }
      }
    }
    label159:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localszd.a(paramses1, localBaseArticleInfo, paramBoolean);
      if (!this.jdField_a_of_type_Sqd.a()) {
        this.jdField_a_of_type_Szd.a((spk)paramses2, 1);
      }
      return;
    }
  }
  
  public void a(spk paramspk)
  {
    if (sge.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Szd.a(paramspk);
  }
  
  public void a(spk paramspk, int paramInt1, int paramInt2) {}
  
  public void a(spk paramspk1, spk paramspk2)
  {
    this.jdField_a_of_type_Szd.a(paramspk1, paramspk2);
  }
  
  public void a(spk paramspk, spn paramspn, int paramInt1, int paramInt2, Object paramObject) {}
  
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
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
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
    if (this.jdField_a_of_type_Szd != null) {
      this.jdField_a_of_type_Szd.a(paramInt);
    }
  }
  
  public void d()
  {
    pvm.a().b(this.jdField_a_of_type_Pvq);
    super.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(b(Integer.valueOf(b())), a(Integer.valueOf(b())));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(this.jdField_b_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.g();
    this.jdField_a_of_type_Szd.b();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    if (this.jdField_a_of_type_Spg != null)
    {
      this.jdField_a_of_type_Spg.b(this);
      this.jdField_a_of_type_Spg.d();
    }
    if (this.jdField_a_of_type_Sqd != null) {
      this.jdField_a_of_type_Sqd.a(null);
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Szd != null) {
      this.jdField_a_of_type_Szd.notifyDataSetChanged();
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
    if (this.jdField_a_of_type_Rkf != null) {
      this.jdField_a_of_type_Rkf.b();
    }
    this.jdField_a_of_type_Spg.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_Rkf != null) {
      this.jdField_a_of_type_Rkf.a();
    }
    pvm.a().a(this.jdField_a_of_type_Pvq);
    this.jdField_a_of_type_Spg.d(b());
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
    this.jdField_a_of_type_Sqd.j();
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)))
    {
      Object localObject = a(Integer.valueOf(b()));
      Map localMap = uvs.a(b());
      ThreadManager.executeOnSubThread(new ReadInJoyChannelViewController.2(this, (Map)localObject, a(Integer.valueOf(b())), localMap, prp.a(b())));
      b(Integer.valueOf(b())).clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      localObject = (qcw)((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a().a(2);
      if (localObject != null) {
        ((qcw)localObject).h();
      }
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Rkf != null) {
      this.jdField_a_of_type_Rkf.b();
    }
    this.jdField_a_of_type_Spg.a(ReportConstants.VideoEndType.EXIT_SCENE);
    this.jdField_a_of_type_Spg.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
    if ((this.jdField_a_of_type_Sqd != null) && (this.jdField_a_of_type_Sqd.a() != null)) {
      this.jdField_a_of_type_Sqd.a().c();
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Rkf != null) {
      this.jdField_a_of_type_Rkf.a();
    }
    if ((this.jdField_a_of_type_Sqd != null) && (this.jdField_a_of_type_Sqd.a() != null)) {
      this.jdField_a_of_type_Sqd.a().b();
    }
  }
  
  public void o()
  {
    if (zfn.a(a()))
    {
      uwq.a(a(), "video_type_videopublic");
      olh.a(null, "", "0X8009338", "0X8009338", 0, 0, "", "", "", omx.a("0"), false);
      return;
    }
    QQToast.a(a(), -1, anvx.a(2131712534), 0).b(a().getResources().getDimensionPixelSize(2131299080));
    uwq.b(a(), "video_type_videopublic");
    olh.a(null, "", "0X8009338", "0X8009338", 0, 0, "", "", "", omx.a("1"), false);
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
        olh.a(null, null, "0X800932E", "0X800932E", 0, 0, "", "", "", omx.a(null), false);
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
    this.jdField_a_of_type_Szd.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqv
 * JD-Core Version:    0.7.0.1
 */