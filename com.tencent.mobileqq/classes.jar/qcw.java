import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoyJumpActivity;
import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerView;
import com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.1;
import com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.4;
import com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.5;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.os.MqqHandler;

public class qcw
  extends qcu
  implements orp
{
  private int jdField_a_of_type_Int = 8;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bdvp jdField_a_of_type_Bdvp;
  private RIJChannelBannerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView;
  private oxw jdField_a_of_type_Oxw;
  private qcz jdField_a_of_type_Qcz = new qcz(this);
  private qym jdField_a_of_type_Qym;
  boolean jdField_a_of_type_Boolean = false;
  public boolean b;
  public boolean c;
  private boolean d = true;
  
  private void a(int paramInt) {}
  
  private void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366720));
    } while (!(a() instanceof ReadInJoyListViewGroup));
    orn.a().a(b(), (qcw)((ReadInJoyListViewGroup)a()).a().a());
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!bmhv.j()) {
      bool1 = bool2;
    }
    for (;;)
    {
      QLog.d("FrameworkHandler", 1, "deleteArticleInStudyMode, isStudyMode=" + paramBoolean + "  hasDeleted=" + bool1);
      return bool1;
      bool1 = bool2;
      if (b() == 0)
      {
        pmz localpmz = a();
        bool1 = bool2;
        if (localpmz != null)
        {
          localpmz.b(b());
          bool1 = true;
        }
      }
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369328));
    if ((b() == 0) && (bmhv.n()))
    {
      paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramView.setMargins(paramView.leftMargin, paramView.topMargin, ViewUtils.dip2px(34.0F), ViewUtils.dip2px(184.0F));
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramView);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new qcx(this));
  }
  
  private void b(List<oyb> paramList)
  {
    if (this.jdField_a_of_type_Oxw == null) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_Oxw.a(true);
      this.jdField_a_of_type_Oxw.a((oyb)paramList.get(0));
      return;
    }
    this.jdField_a_of_type_Oxw.a(false);
  }
  
  private void b(boolean paramBoolean)
  {
    boolean bool2 = false;
    label163:
    for (;;)
    {
      try
      {
        boolean bool3 = bdvn.a();
        if ((bool3 == this.jdField_a_of_type_Boolean) && (!paramBoolean)) {
          return;
        }
        if (a().a().a() == null) {
          break;
        }
        this.jdField_a_of_type_Boolean = bool3;
        if (plm.c(b()))
        {
          if (!paramBoolean) {
            break;
          }
          bool1 = false;
          if (b() == 0) {
            break label163;
          }
          if (!paramBoolean) {
            break;
          }
          bool1 = bool2;
          a().a().a().a(a().a().a(), (ReadInJoyXListView)a(), a().a().a(), b(), bool1, paramBoolean);
          if (!bool3) {
            break;
          }
          a(true);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("FrameworkHandler", 2, "update ListViewPadding error, e=" + localException);
        return;
      }
      boolean bool1 = this.jdField_a_of_type_Boolean;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Oxw != null) && ((a() instanceof ListView)))
    {
      RIJChannelBannerView localRIJChannelBannerView = this.jdField_a_of_type_Oxw.a();
      ListView localListView = (ListView)a();
      if (paramBoolean) {
        localListView.removeHeaderView(localRIJChannelBannerView);
      }
    }
    d(paramBoolean);
  }
  
  private void d(boolean paramBoolean)
  {
    boolean bool = a(paramBoolean);
    pmz localpmz = a();
    if ((bool) && (!paramBoolean) && (localpmz != null)) {
      a(true);
    }
  }
  
  private void l()
  {
    if ((a().a().a() instanceof oqo))
    {
      localActivity = a().a().a();
      if (localActivity.findViewById(2131362002) != null) {
        b(true);
      }
    }
    while (!(a().a().a() instanceof orj))
    {
      Activity localActivity;
      do
      {
        return;
      } while (localActivity.findViewById(2131362003) == null);
      a().a().a().a(a().a().a(), (ReadInJoyXListView)a(), a().a().a(), b());
      return;
    }
    ((orj)a().a().a()).a((ReadInJoyXListView)a(), a().a().a());
  }
  
  private void m()
  {
    if ((!this.b) && (this.c))
    {
      this.b = true;
      this.c = false;
      if (b() != qez.a()) {
        break label105;
      }
      uuq.jdField_a_of_type_Int = 1;
    }
    for (;;)
    {
      uuq.a("KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW", null);
      uuq.a("KANDIAN_FEEDS_STAGE_2_COST", null);
      uuq.a("KANDIAN_FEEDS_COST", null);
      if (b() == 56) {
        uuq.a("video_tab_cost", null);
      }
      if (this.d)
      {
        this.d = false;
        if (b() != qez.a()) {
          break;
        }
        uuq.a("recommend_tab_cost", null);
      }
      return;
      label105:
      switch (b())
      {
      default: 
        break;
      case 0: 
        uuq.jdField_a_of_type_Int = 1;
        break;
      case 56: 
        uuq.jdField_a_of_type_Int = 2;
        break;
      case 70: 
        uuq.jdField_a_of_type_Int = 3;
      }
    }
    switch (b())
    {
    default: 
      return;
    case 0: 
      uuq.a("recommend_tab_cost", null);
      return;
    case 56: 
      uuq.a("video_tab_cost", null);
      return;
    }
    uuq.a("subscribe_tab_cost", null);
  }
  
  private void n()
  {
    Activity localActivity = a().a().a();
    if (ReadinjoyJumpActivity.a(localActivity.getIntent())) {
      ReadinjoyJumpActivity.a(localActivity, localActivity.getIntent(), 500L);
    }
    Intent localIntent;
    do
    {
      do
      {
        return;
        if (ReadinjoyJumpActivity.b(localActivity.getIntent()))
        {
          localIntent = localActivity.getIntent();
          ReadInJoyLockScreenJumpDelegate.a(localActivity, localIntent);
          localIntent.removeExtra("daily_lock_screen_flag");
          return;
        }
      } while ((!ReadinjoyJumpActivity.c(localActivity.getIntent())) || (bmhv.n()));
      localIntent = localActivity.getIntent();
    } while (localIntent.getIntExtra("launch_from", 0) != 9);
    ReadInJoyLockScreenJumpDelegate.a(localActivity, localIntent);
    localIntent.removeExtra("kan_dian_lock_screen_flag");
  }
  
  private void o()
  {
    if (b() == 0)
    {
      if (owf.a().a())
      {
        a(false, 1);
        QLog.d("FrameworkHandler", 2, "transformCommentBiuCard | shouldAutoRefresh and backToTop");
      }
      ThreadManager.getUIHandler().postDelayed(new FrameworkHandler.4(this), 500L);
      return;
    }
    owf.a().c();
    QLog.d("FrameworkHandler", 2, "transformCommentBiuCard | not in recommend feeds and clear biuinfo");
  }
  
  private void p()
  {
    new Handler(Looper.getMainLooper()).post(new FrameworkHandler.5(this));
  }
  
  private void q()
  {
    szd localszd = a();
    if ((localszd != null) && (localszd.a() != null)) {
      pwt.a.a(localszd, localszd.a());
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView = new RIJChannelBannerView(a());
    if ((a() instanceof ListView))
    {
      ((ListView)a()).addHeaderView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView, 2);
      this.jdField_a_of_type_Bdvp = new qcy(this);
      bdvn.a(this.jdField_a_of_type_Bdvp);
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_Oxw != null) {
      QLog.i("FrameworkHandler", 1, "[initRijChannelBannerController] controller is not null, do not init again.");
    }
    while ((!rad.a().a()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView == null)) {
      return;
    }
    this.jdField_a_of_type_Oxw = new oxw(b(), a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView);
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Oxw != null) {
      this.jdField_a_of_type_Oxw.a();
    }
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    System.currentTimeMillis();
    int j = a(paramInt).intValue();
    ArticleInfo localArticleInfo1 = (ArticleInfo)a(paramInt);
    ArticleInfo localArticleInfo2 = (ArticleInfo)a(paramInt + 1);
    if (localArticleInfo1 != null) {
      localArticleInfo1.mResolvedFeedType = j;
    }
    paramViewGroup = null;
    this.jdField_a_of_type_Qcz.a();
    if ((this.jdField_a_of_type_Qym != null) && (qym.a(localArticleInfo1)))
    {
      paramViewGroup = new qhk(a(), localArticleInfo1, j, b(), c(), paramInt, a(), d(), localArticleInfo2, a());
      paramViewGroup = this.jdField_a_of_type_Qym.a(paramView, localArticleInfo1, paramInt, paramViewGroup);
    }
    label252:
    do
    {
      do
      {
        do
        {
          do
          {
            return paramViewGroup;
            if ((j == 123) && (!piv.a(a().a(), j, localArticleInfo1))) {}
            for (int i = 1;; i = 0)
            {
              if ((i != 0) || (!piv.a(j))) {
                break label252;
              }
              l = System.currentTimeMillis();
              paramView = qcz.a(this.jdField_a_of_type_Qcz, paramView, localArticleInfo1, localArticleInfo2, j, paramInt);
              uda.a("FrameworkHandler", String.valueOf(j), "getProteusNormalView", System.currentTimeMillis() - l);
              paramViewGroup = paramView;
              if (localArticleInfo1 == null) {
                break;
              }
              QLog.d("FrameworkHandler", 2, "article is normalProteusView: " + localArticleInfo1.mTitle);
              return paramView;
            }
            if (!qcz.a(this.jdField_a_of_type_Qcz).a(j)) {
              break;
            }
            l = System.currentTimeMillis();
            paramView = qcz.b(this.jdField_a_of_type_Qcz, paramView, localArticleInfo1, localArticleInfo2, j, paramInt);
            uda.a("FrameworkHandler", String.valueOf(j), "getDynamicProteusView", System.currentTimeMillis() - l);
            paramViewGroup = paramView;
          } while (localArticleInfo1 == null);
          QLog.d("FrameworkHandler", 2, "article is dynamicProteusView: " + localArticleInfo1.mTitle);
          return paramView;
          if (j != 38) {
            break;
          }
          l = System.currentTimeMillis();
          paramView = qcz.a(this.jdField_a_of_type_Qcz, paramView, localArticleInfo1, paramInt);
          uda.a("FrameworkHandler", String.valueOf(j), "getArkAppView", System.currentTimeMillis() - l);
          paramViewGroup = paramView;
        } while (localArticleInfo1 == null);
        QLog.d("FrameworkHandler", 2, "article is arkAppView: " + localArticleInfo1.mTitle);
        return paramView;
      } while (!rbm.a(j));
      long l = System.currentTimeMillis();
      paramView = qcz.a(this.jdField_a_of_type_Qcz, paramView, localArticleInfo1, j, paramInt);
      uda.a("FrameworkHandler", String.valueOf(j), "cellRebuildCompleted", System.currentTimeMillis() - l);
      paramViewGroup = paramView;
    } while (localArticleInfo1 == null);
    QLog.d("FrameworkHandler", 2, "article is cellRebuildView: " + localArticleInfo1.mTitle);
    return paramView;
  }
  
  public void a()
  {
    super.a();
    QLog.d("FrameworkHandler", 2, "doStart!");
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    super.a(paramInt, paramList);
    if (this.jdField_a_of_type_Oxw != null) {
      this.jdField_a_of_type_Oxw.c();
    }
  }
  
  public void a(View paramView, ListView paramListView)
  {
    super.a(paramView, paramListView);
  }
  
  public void a(View paramView, ListView paramListView, long paramLong)
  {
    a(paramView);
    b(paramView);
    l();
    PTSDeviceUtil.init(a());
    if (rad.a().a()) {
      this.jdField_a_of_type_Qym = new qym(a(), a());
    }
    r();
    s();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt);
    if ((b() == 0) || (plm.c(b()))) {
      pwb.a().a.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1);
    if ((b() == 0) || (plm.c(b()))) {
      pwb.a().a.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ArticleInfo localArticleInfo = (ArticleInfo)a((int)paramLong);
    if ((plm.c(b())) || (b() == 0))
    {
      pwb.a().a.a(paramView, (AbsListView)paramAdapterView, localArticleInfo);
      rjm.a().a(paramView, (AbsListView)paramAdapterView, localArticleInfo);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    this.c = false;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.d = true;
    pwq localpwq;
    if ((b() == 0) || (plm.c(b())))
    {
      localpwq = pwb.a().a;
      if (a() == null) {
        break label54;
      }
    }
    label54:
    for (ListView localListView = a().a();; localListView = null)
    {
      localpwq.onScrollStateChanged(localListView, 6);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramInt, paramList, paramBoolean2);
    s();
    if (this.jdField_a_of_type_Oxw != null) {
      this.jdField_a_of_type_Oxw.b();
    }
  }
  
  public boolean a(int paramInt)
  {
    this.jdField_a_of_type_Qcz.a();
    if (ukk.a(paramInt)) {}
    while ((!piv.a(paramInt)) && (!qcz.a(this.jdField_a_of_type_Qcz).a(paramInt)) && (38 != paramInt) && (!rbm.a(paramInt)) && (!qym.a(paramInt))) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    this.d = true;
    ovr.b(b());
    if (this.jdField_a_of_type_Oxw != null) {
      this.jdField_a_of_type_Oxw.e();
    }
    q();
    o();
    p();
    n();
    b(false);
  }
  
  public void b(int paramInt, List<oyb> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onRijChannelBannerRefreshed], channelId = ").append(paramInt).append(", list size = ");
    if (paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      QLog.i("FrameworkHandler", 1, i);
      if (paramInt == b()) {
        break;
      }
      QLog.i("FrameworkHandler", 1, "[onRijChannelBannerRefreshed], do not refresh, current channel id = " + b());
      return;
    }
    pno.b().post(new FrameworkHandler.1(this, paramList));
  }
  
  public void c()
  {
    ovr.a(b());
    sen.a().a();
    pwq localpwq;
    if ((b() == 0) || (plm.c(b())))
    {
      localpwq = pwb.a().a;
      if (a() == null) {
        break label59;
      }
    }
    label59:
    for (ListView localListView = a().a();; localListView = null)
    {
      localpwq.onScrollStateChanged(localListView, 5);
      return;
    }
  }
  
  public void d()
  {
    orn.a().b(b(), this);
    if (this.jdField_a_of_type_Qym != null) {
      this.jdField_a_of_type_Qym.a();
    }
    h();
    i();
    t();
  }
  
  public void e()
  {
    m();
    pwq localpwq;
    if ((b() == 0) || (plm.c(b())))
    {
      localpwq = pwb.a().a;
      if (a() == null) {
        break label50;
      }
    }
    label50:
    for (ListView localListView = a().a();; localListView = null)
    {
      localpwq.a(4, localListView);
      return;
    }
  }
  
  public void g()
  {
    super.g();
    if ((b() == 0) || (plm.c(b()))) {
      pwb.a().a.a();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Oxw != null) {
      this.jdField_a_of_type_Oxw.d();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Bdvp != null) {
      bdvn.b(this.jdField_a_of_type_Bdvp);
    }
  }
  
  public void j() {}
  
  public void k() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qcw
 * JD-Core Version:    0.7.0.1
 */