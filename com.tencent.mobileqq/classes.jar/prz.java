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
import com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.2;
import com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.5;
import com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.6;
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

public class prz
  extends prx
  implements ojs
{
  private int jdField_a_of_type_Int = 8;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bcoq jdField_a_of_type_Bcoq;
  private opy jdField_a_of_type_Opy;
  private psc jdField_a_of_type_Psc = new psc(this);
  private qmh jdField_a_of_type_Qmh;
  public boolean a;
  public boolean b;
  private boolean c = true;
  
  private void a(int paramInt) {}
  
  private void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366609));
    } while (!(a() instanceof ReadInJoyListViewGroup));
    ojq.a().a(b(), (prz)((ReadInJoyListViewGroup)a()).a().a());
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369166));
    if ((b() == 0) && (bkwm.k()))
    {
      paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramView.setMargins(paramView.leftMargin, paramView.topMargin, ViewUtils.dip2px(34.0F), ViewUtils.dip2px(184.0F));
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramView);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new psb(this));
  }
  
  private void b(List<oqd> paramList)
  {
    if (this.jdField_a_of_type_Opy == null) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_Opy.a(true);
      this.jdField_a_of_type_Opy.a((oqd)paramList.get(0));
      return;
    }
    this.jdField_a_of_type_Opy.a(false);
  }
  
  private void b(boolean paramBoolean)
  {
    boolean bool3 = false;
    label154:
    for (;;)
    {
      boolean bool2;
      try
      {
        bool2 = bcoo.a();
        if ((!bool2) && (!paramBoolean)) {
          return;
        }
        if (a().a().a() == null) {
          break;
        }
        if (pcl.c(b()))
        {
          if (!paramBoolean) {
            break;
          }
          bool1 = false;
          if (b() == 0) {
            break label154;
          }
          if (!paramBoolean) {
            break;
          }
          bool1 = bool3;
          a().a().a().a(a().a().a(), (ReadInJoyXListView)a(), a().a().a(), b(), bool1, paramBoolean);
          if (!bool2) {
            break;
          }
          a().b(true, 3, false);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("FrameworkHandler", 2, "update ListViewPadding error, e=" + localException);
        return;
      }
      boolean bool1 = bool2;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Opy != null) && ((a() instanceof ListView)))
    {
      RIJChannelBannerView localRIJChannelBannerView = this.jdField_a_of_type_Opy.a();
      ListView localListView = (ListView)a();
      if (paramBoolean) {
        localListView.removeHeaderView(localRIJChannelBannerView);
      }
    }
  }
  
  private void l()
  {
    if ((a().a().a() instanceof ois))
    {
      localActivity = a().a().a();
      if (localActivity.findViewById(2131362000) != null) {
        b(true);
      }
    }
    while (!(a().a().a() instanceof ojm))
    {
      Activity localActivity;
      do
      {
        return;
      } while (localActivity.findViewById(2131362001) == null);
      a().a().a().a(a().a().a(), (ReadInJoyXListView)a(), a().a().a(), b());
      return;
    }
    ((ojm)a().a().a()).a((ReadInJoyXListView)a(), a().a().a());
  }
  
  private void m()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.b))
    {
      this.jdField_a_of_type_Boolean = true;
      this.b = false;
      if (b() != puf.a()) {
        break label105;
      }
      ugt.jdField_a_of_type_Int = 1;
    }
    for (;;)
    {
      ugt.a("KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW", null);
      ugt.a("KANDIAN_FEEDS_STAGE_2_COST", null);
      ugt.a("KANDIAN_FEEDS_COST", null);
      if (b() == 56) {
        ugt.a("video_tab_cost", null);
      }
      if (this.c)
      {
        this.c = false;
        if (b() != puf.a()) {
          break;
        }
        ugt.a("recommend_tab_cost", null);
      }
      return;
      label105:
      switch (b())
      {
      default: 
        break;
      case 0: 
        ugt.jdField_a_of_type_Int = 1;
        break;
      case 56: 
        ugt.jdField_a_of_type_Int = 2;
        break;
      case 70: 
        ugt.jdField_a_of_type_Int = 3;
      }
    }
    switch (b())
    {
    default: 
      return;
    case 0: 
      ugt.a("recommend_tab_cost", null);
      return;
    case 56: 
      ugt.a("video_tab_cost", null);
      return;
    }
    ugt.a("subscribe_tab_cost", null);
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
      } while ((!ReadinjoyJumpActivity.c(localActivity.getIntent())) || (bkwm.k()));
      localIntent = localActivity.getIntent();
    } while (localIntent.getIntExtra("launch_from", 0) != 9);
    ReadInJoyLockScreenJumpDelegate.a(localActivity, localIntent);
    localIntent.removeExtra("kan_dian_lock_screen_flag");
  }
  
  private void o()
  {
    if (b() == 0)
    {
      if (ooh.a().a())
      {
        a(false, 1);
        QLog.d("FrameworkHandler", 2, "transformCommentBiuCard | shouldAutoRefresh and backToTop");
      }
      ThreadManager.getUIHandler().postDelayed(new FrameworkHandler.5(this), 500L);
      return;
    }
    ooh.a().c();
    QLog.d("FrameworkHandler", 2, "transformCommentBiuCard | not in recommend feeds and clear biuinfo");
  }
  
  private void p()
  {
    new Handler(Looper.getMainLooper()).post(new FrameworkHandler.6(this));
  }
  
  private void q()
  {
    slt localslt = a();
    if ((localslt != null) && (localslt.a() != null)) {
      plw.a.a(localslt, localslt.a());
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
    this.jdField_a_of_type_Psc.a();
    if ((this.jdField_a_of_type_Qmh != null) && (qmh.a(localArticleInfo1)))
    {
      paramViewGroup = new pwe(a(), localArticleInfo1, j, b(), c(), paramInt, a(), d(), localArticleInfo2, a());
      paramViewGroup = this.jdField_a_of_type_Qmh.a(paramView, localArticleInfo1, paramInt, paramViewGroup);
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
            if ((j == 123) && (!ozp.a(a().a(), j, localArticleInfo1))) {}
            for (int i = 1;; i = 0)
            {
              if ((i != 0) || (!ozp.a(j))) {
                break label252;
              }
              l = System.currentTimeMillis();
              paramView = psc.a(this.jdField_a_of_type_Psc, paramView, localArticleInfo1, localArticleInfo2, j, paramInt);
              tpl.a("FrameworkHandler", String.valueOf(j), "getProteusNormalView", System.currentTimeMillis() - l);
              paramViewGroup = paramView;
              if (localArticleInfo1 == null) {
                break;
              }
              QLog.d("FrameworkHandler", 2, "article is normalProteusView: " + localArticleInfo1.mTitle);
              return paramView;
            }
            if (!psc.a(this.jdField_a_of_type_Psc).a(j)) {
              break;
            }
            l = System.currentTimeMillis();
            paramView = psc.b(this.jdField_a_of_type_Psc, paramView, localArticleInfo1, localArticleInfo2, j, paramInt);
            tpl.a("FrameworkHandler", String.valueOf(j), "getDynamicProteusView", System.currentTimeMillis() - l);
            paramViewGroup = paramView;
          } while (localArticleInfo1 == null);
          QLog.d("FrameworkHandler", 2, "article is dynamicProteusView: " + localArticleInfo1.mTitle);
          return paramView;
          if (j != 38) {
            break;
          }
          l = System.currentTimeMillis();
          paramView = psc.a(this.jdField_a_of_type_Psc, paramView, localArticleInfo1, paramInt);
          tpl.a("FrameworkHandler", String.valueOf(j), "getArkAppView", System.currentTimeMillis() - l);
          paramViewGroup = paramView;
        } while (localArticleInfo1 == null);
        QLog.d("FrameworkHandler", 2, "article is arkAppView: " + localArticleInfo1.mTitle);
        return paramView;
      } while (!qph.a(j));
      long l = System.currentTimeMillis();
      paramView = psc.a(this.jdField_a_of_type_Psc, paramView, localArticleInfo1, j, paramInt);
      tpl.a("FrameworkHandler", String.valueOf(j), "cellRebuildCompleted", System.currentTimeMillis() - l);
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
    if (this.jdField_a_of_type_Opy != null) {
      this.jdField_a_of_type_Opy.b();
    }
  }
  
  public void a(View paramView, ListView paramListView)
  {
    super.a(paramView, paramListView);
    if (qny.a().a())
    {
      this.jdField_a_of_type_Opy = new opy(b(), a());
      if ((this.jdField_a_of_type_Opy.a() != null) && ((a() instanceof ListView)))
      {
        ((ListView)a()).addHeaderView(this.jdField_a_of_type_Opy.a(), 2);
        this.jdField_a_of_type_Bcoq = new psa(this);
        bcoo.a(this.jdField_a_of_type_Bcoq);
      }
    }
  }
  
  public void a(View paramView, ListView paramListView, long paramLong)
  {
    a(paramView);
    b(paramView);
    l();
    PTSDeviceUtil.init(a());
    if (qny.a().a()) {
      this.jdField_a_of_type_Qmh = new qmh(a(), a());
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt);
    if ((b() == 0) || (pcl.c(b()))) {
      ple.a().a.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1);
    if ((b() == 0) || (pcl.c(b()))) {
      ple.a().a.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ArticleInfo localArticleInfo = (ArticleInfo)a((int)paramLong);
    if ((pcl.c(b())) || (b() == 0))
    {
      ple.a().a.a(paramView, (AbsListView)paramAdapterView, localArticleInfo);
      qxg.a().a(paramView, (AbsListView)paramAdapterView, localArticleInfo);
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
    this.b = false;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.c = true;
    plt localplt;
    if ((b() == 0) || (pcl.c(b())))
    {
      localplt = ple.a().a;
      if (a() == null) {
        break label54;
      }
    }
    label54:
    for (ListView localListView = a().a();; localListView = null)
    {
      localplt.onScrollStateChanged(localListView, 6);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramInt, paramList, paramBoolean2);
    if (this.jdField_a_of_type_Opy != null) {
      this.jdField_a_of_type_Opy.a();
    }
  }
  
  public boolean a(int paramInt)
  {
    this.jdField_a_of_type_Psc.a();
    if (twj.a(paramInt)) {}
    while ((!ozp.a(paramInt)) && (!psc.a(this.jdField_a_of_type_Psc).a(paramInt)) && (38 != paramInt) && (!qph.a(paramInt)) && (!qmh.a(paramInt))) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    this.c = true;
    onu.b(b());
    if (this.jdField_a_of_type_Opy != null) {
      this.jdField_a_of_type_Opy.d();
    }
    q();
    o();
    p();
    n();
    b(false);
  }
  
  public void b(int paramInt, List<oqd> paramList)
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
    pay.b().post(new FrameworkHandler.2(this, paramList));
  }
  
  public void c()
  {
    onu.a(b());
    rry.a().a();
    plt localplt;
    if ((b() == 0) || (pcl.c(b())))
    {
      localplt = ple.a().a;
      if (a() == null) {
        break label59;
      }
    }
    label59:
    for (ListView localListView = a().a();; localListView = null)
    {
      localplt.onScrollStateChanged(localListView, 5);
      return;
    }
  }
  
  public void d()
  {
    ojq.a().b(b(), this);
    if (this.jdField_a_of_type_Qmh != null) {
      this.jdField_a_of_type_Qmh.a();
    }
    h();
    i();
  }
  
  public void e()
  {
    m();
    plt localplt;
    if ((b() == 0) || (pcl.c(b())))
    {
      localplt = ple.a().a;
      if (a() == null) {
        break label50;
      }
    }
    label50:
    for (ListView localListView = a().a();; localListView = null)
    {
      localplt.a(4, localListView);
      return;
    }
  }
  
  public void g()
  {
    super.g();
    if ((b() == 0) || (pcl.c(b()))) {
      ple.a().a.a();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Opy != null) {
      this.jdField_a_of_type_Opy.c();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Bcoq != null) {
      bcoo.b(this.jdField_a_of_type_Bcoq);
    }
  }
  
  public void j() {}
  
  public void k() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     prz
 * JD-Core Version:    0.7.0.1
 */