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

public class nth
  extends ntg
  implements View.OnClickListener, View.OnKeyListener, pze, pzv, qtr, qtx, qvi, qvj
{
  private static boolean jdField_a_of_type_Boolean = true;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  protected osp a;
  private qtu jdField_a_of_type_Qtu;
  private qup jdField_a_of_type_Qup;
  private qvd jdField_a_of_type_Qvd;
  rap jdField_a_of_type_Rap;
  private int jdField_b_of_type_Int = -1;
  private volatile boolean jdField_b_of_type_Boolean;
  private int c;
  private int d = -1;
  
  public nth(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Osp = new ntj(this);
  }
  
  private boolean a()
  {
    return b() == 40677;
  }
  
  private boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_Qtu != null) && (this.jdField_a_of_type_Qtu.b()) && (this.jdField_a_of_type_Qvd != null) && (!this.jdField_a_of_type_Qvd.a()))
    {
      this.jdField_a_of_type_Qvd.d(paramInt);
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
    if (this.jdField_a_of_type_Rap == null) {
      return null;
    }
    return this.jdField_a_of_type_Rap.a();
  }
  
  public qtu a()
  {
    return this.jdField_a_of_type_Qtu;
  }
  
  public qup a()
  {
    return this.jdField_a_of_type_Qup;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Qup = new qup(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Qtu = new qtu(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Qtu.a(this.jdField_a_of_type_Qup);
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(b()), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, b(), c(), this.d, null);
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setNotifyEndRefresh(new nti(this));
    this.jdField_a_of_type_Rap = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    if (this.jdField_a_of_type_Rap != null) {
      this.jdField_a_of_type_Rap.e();
    }
    Object localObject;
    if (((this.jdField_a_of_type_AndroidAppActivity instanceof ReadInJoyNewFeedsActivity)) || ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)))
    {
      localObject = npx.b();
      npx.a.put(ReadInJoyVideoChannelFragment.class, localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Qtu.a((String)localObject);
      this.jdField_a_of_type_Qup.a((String)localObject);
      this.jdField_a_of_type_Qvd = new qvd((FrameLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131379072), (ReadInJoyBaseListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131376712), this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_Qvd.a(this);
      this.jdField_a_of_type_Qtu.a(this.jdField_a_of_type_Qvd);
      this.jdField_a_of_type_Qvd.a(this);
      this.jdField_a_of_type_Rap.f();
      if (b())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.setFocusableInTouchMode(true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.requestFocus();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.setOnKeyListener(this);
      }
      osm.a().a(this.jdField_a_of_type_Osp);
      if (jdField_a_of_type_Boolean)
      {
        jdField_a_of_type_Boolean = false;
        osj.a().c();
      }
      b();
      return;
      String str = (String)npx.a.get(ReadInJoyChannelActivity.class);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = npx.b();
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
  
  public void a(qjl paramqjl1, qjl paramqjl2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyBaseAdapter", 2, "onNextVideoPlay:  enterVideoPlayParam:" + paramqjl1 + "  nextVideoPlayParam:" + paramqjl2 + "\n nextScrollByDistance:" + paramInt + " isPlayFirstNext:" + paramBoolean);
    }
    BaseArticleInfo localBaseArticleInfo;
    rap localrap;
    if ((paramqjl1 != null) && ((paramqjl1 instanceof qty)) && (paramqjl2 != null) && ((paramqjl2 instanceof qty)))
    {
      paramqjl1 = ((qty)paramqjl1).a;
      localBaseArticleInfo = ((qty)paramqjl2).a;
      if ((paramqjl1 != null) && (localBaseArticleInfo != null))
      {
        localrap = this.jdField_a_of_type_Rap;
        if (paramBoolean) {
          break label160;
        }
      }
    }
    label160:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localrap.a(paramqjl1, localBaseArticleInfo, paramBoolean);
      if (!this.jdField_a_of_type_Qvd.a()) {
        this.jdField_a_of_type_Rap.a((qty)paramqjl2, 1);
      }
      return;
    }
  }
  
  public void a(qty paramqty, int paramInt1, int paramInt2) {}
  
  public void a(qty paramqty1, qty paramqty2)
  {
    this.jdField_a_of_type_Rap.a(paramqty1, paramqty2);
  }
  
  public void a(qty paramqty, qub paramqub, int paramInt1, int paramInt2, Object paramObject) {}
  
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
    if (this.jdField_a_of_type_Rap != null) {
      this.jdField_a_of_type_Rap.a(paramInt);
    }
  }
  
  public void d()
  {
    osm.a().b(this.jdField_a_of_type_Osp);
    super.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(b(Integer.valueOf(b())), a(Integer.valueOf(b())));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(this.jdField_b_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.g();
    this.jdField_a_of_type_Rap.d();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    if (this.jdField_a_of_type_Qtu != null)
    {
      this.jdField_a_of_type_Qtu.b(this);
      this.jdField_a_of_type_Qtu.d();
    }
    if (this.jdField_a_of_type_Qvd != null) {
      this.jdField_a_of_type_Qvd.a(null);
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Rap != null) {
      this.jdField_a_of_type_Rap.notifyDataSetChanged();
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
    this.jdField_a_of_type_Qtu.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
  }
  
  public void h()
  {
    super.h();
    osm.a().a(this.jdField_a_of_type_Osp);
    this.jdField_a_of_type_Qtu.f();
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
    this.jdField_a_of_type_Qvd.g();
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)))
    {
      Map localMap1 = a(Integer.valueOf(b()));
      Map localMap2 = shx.a(b());
      ThreadManager.executeOnSubThread(new ReadInJoyChannelViewController.3(this, localMap1, a(Integer.valueOf(b())), localMap2, onk.e(b())));
      b(Integer.valueOf(b())).clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_Rap.l();
  }
  
  public void m()
  {
    this.jdField_a_of_type_Qtu.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
  }
  
  public void n()
  {
    if (vzz.a(a()))
    {
      siu.a(a(), "video_type_videopublic");
      noo.a(null, "", "0X8009338", "0X8009338", 0, 0, "", "", "", npx.a("0"), false);
      return;
    }
    bcpw.a(a(), -1, ajyc.a(2131713072), 0).b(a().getResources().getDimensionPixelSize(2131298865));
    siu.b(a(), "video_type_videopublic");
    noo.a(null, "", "0X8009338", "0X8009338", 0, 0, "", "", "", npx.a("1"), false);
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
    noo.a(null, null, "0X800932E", "0X800932E", 0, 0, "", "", "", npx.a(null), false);
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
 * Qualified Name:     nth
 * JD-Core Version:    0.7.0.1
 */