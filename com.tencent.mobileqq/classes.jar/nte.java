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
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController.3;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class nte
  extends ntd
  implements View.OnClickListener, View.OnKeyListener, pzb, pzs, qto, qtu, qvf, qvg
{
  private static boolean jdField_a_of_type_Boolean = true;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  protected osm a;
  private qtr jdField_a_of_type_Qtr;
  private qum jdField_a_of_type_Qum;
  private qva jdField_a_of_type_Qva;
  ram jdField_a_of_type_Ram;
  private int jdField_b_of_type_Int = -1;
  private volatile boolean jdField_b_of_type_Boolean;
  private int c;
  private int d = -1;
  
  public nte(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Osm = new ntg(this);
  }
  
  private boolean a()
  {
    return b() == 40677;
  }
  
  private boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_Qtr != null) && (this.jdField_a_of_type_Qtr.b()) && (this.jdField_a_of_type_Qva != null) && (!this.jdField_a_of_type_Qva.a()))
    {
      this.jdField_a_of_type_Qva.d(paramInt);
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
    if (this.jdField_a_of_type_Ram == null) {
      return null;
    }
    return this.jdField_a_of_type_Ram.a();
  }
  
  public qtr a()
  {
    return this.jdField_a_of_type_Qtr;
  }
  
  public qum a()
  {
    return this.jdField_a_of_type_Qum;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Qum = new qum(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Qtr = new qtr(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Qtr.a(this.jdField_a_of_type_Qum);
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(b()), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, b(), c(), this.d, null);
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setNotifyEndRefresh(new ntf(this));
    this.jdField_a_of_type_Ram = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    if (this.jdField_a_of_type_Ram != null) {
      this.jdField_a_of_type_Ram.e();
    }
    Object localObject;
    if (((this.jdField_a_of_type_AndroidAppActivity instanceof ReadInJoyNewFeedsActivity)) || ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)))
    {
      localObject = npu.b();
      npu.a.put(ReadInJoyVideoChannelFragment.class, localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Qtr.a((String)localObject);
      this.jdField_a_of_type_Qum.a((String)localObject);
      this.jdField_a_of_type_Qva = new qva((FrameLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131379077), (ReadInJoyBaseListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131376714), this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_Qva.a(this);
      this.jdField_a_of_type_Qtr.a(this.jdField_a_of_type_Qva);
      this.jdField_a_of_type_Qva.a(this);
      this.jdField_a_of_type_Ram.f();
      if (b())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.setFocusableInTouchMode(true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.requestFocus();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.setOnKeyListener(this);
      }
      osj.a().a(this.jdField_a_of_type_Osm);
      if (jdField_a_of_type_Boolean)
      {
        jdField_a_of_type_Boolean = false;
        osg.a().c();
      }
      b();
      return;
      String str = (String)npu.a.get(ReadInJoyChannelActivity.class);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = npu.b();
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
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setSkinHeader(paramInt, paramBoolean);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a(qji paramqji1, qji paramqji2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyBaseAdapter", 2, "onNextVideoPlay:  enterVideoPlayParam:" + paramqji1 + "  nextVideoPlayParam:" + paramqji2 + "\n nextScrollByDistance:" + paramInt + " isPlayFirstNext:" + paramBoolean);
    }
    BaseArticleInfo localBaseArticleInfo;
    ram localram;
    if ((paramqji1 != null) && ((paramqji1 instanceof qtv)) && (paramqji2 != null) && ((paramqji2 instanceof qtv)))
    {
      paramqji1 = ((qtv)paramqji1).a;
      localBaseArticleInfo = ((qtv)paramqji2).a;
      if ((paramqji1 != null) && (localBaseArticleInfo != null))
      {
        localram = this.jdField_a_of_type_Ram;
        if (paramBoolean) {
          break label160;
        }
      }
    }
    label160:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localram.a(paramqji1, localBaseArticleInfo, paramBoolean);
      if (!this.jdField_a_of_type_Qva.a()) {
        this.jdField_a_of_type_Ram.a((qtv)paramqji2, 1);
      }
      return;
    }
  }
  
  public void a(qtv paramqtv, int paramInt1, int paramInt2) {}
  
  public void a(qtv paramqtv1, qtv paramqtv2)
  {
    this.jdField_a_of_type_Ram.a(paramqtv1, paramqtv2);
  }
  
  public void a(qtv paramqtv, qty paramqty, int paramInt1, int paramInt2, Object paramObject) {}
  
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
        localReadInJoyListViewGroup.u();
      }
      if (!paramBoolean2) {
        localReadInJoyListViewGroup.v();
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
    if (this.jdField_a_of_type_Ram != null) {
      this.jdField_a_of_type_Ram.a(paramInt);
    }
  }
  
  public void d()
  {
    osj.a().b(this.jdField_a_of_type_Osm);
    super.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(b(Integer.valueOf(b())), a(Integer.valueOf(b())));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(this.jdField_b_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.g();
    this.jdField_a_of_type_Ram.d();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    if (this.jdField_a_of_type_Qtr != null)
    {
      this.jdField_a_of_type_Qtr.b(this);
      this.jdField_a_of_type_Qtr.d();
    }
    if (this.jdField_a_of_type_Qva != null) {
      this.jdField_a_of_type_Qva.a(null);
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Ram != null) {
      this.jdField_a_of_type_Ram.notifyDataSetChanged();
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
    this.jdField_a_of_type_Qtr.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
  }
  
  public void h()
  {
    super.h();
    osj.a().a(this.jdField_a_of_type_Osm);
    this.jdField_a_of_type_Qtr.f();
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
    this.jdField_a_of_type_Qva.g();
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)))
    {
      Map localMap1 = a(Integer.valueOf(b()));
      Map localMap2 = shu.a(b());
      ThreadManager.executeOnSubThread(new ReadInJoyChannelViewController.3(this, localMap1, a(Integer.valueOf(b())), localMap2, onh.e(b())));
      b(Integer.valueOf(b())).clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_Ram.l();
  }
  
  public void m()
  {
    this.jdField_a_of_type_Qtr.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
  }
  
  public void n()
  {
    if (vzw.a(a()))
    {
      sir.a(a(), "video_type_videopublic");
      nol.a(null, "", "0X8009338", "0X8009338", 0, 0, "", "", "", npu.a("0"), false);
      return;
    }
    bcql.a(a(), -1, ajya.a(2131713083), 0).b(a().getResources().getDimensionPixelSize(2131298865));
    sir.b(a(), "video_type_videopublic");
    nol.a(null, "", "0X8009338", "0X8009338", 0, 0, "", "", "", npu.a("1"), false);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (!a());
    paramView = this.jdField_a_of_type_AndroidViewViewGroup.getContext();
    Intent localIntent = new Intent(paramView, AccountDetailActivity.class);
    localIntent.putExtra("uin", String.valueOf(2062433139L));
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("source", 119);
    paramView.startActivity(localIntent);
    nol.a(null, null, "0X800932E", "0X800932E", 0, 0, "", "", "", npu.a(null), false);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nte
 * JD-Core Version:    0.7.0.1
 */