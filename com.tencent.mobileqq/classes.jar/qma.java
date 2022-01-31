import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFollowManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashSet;

public class qma
  implements qbd, qer, qes, qfs, qgl, qlp
{
  private static final String jdField_a_of_type_JavaLangString = qma.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private VideoFollowManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFollowManager;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private ArrayList<VideoInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashSet<VideoInfo> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private pyy jdField_a_of_type_Pyy;
  private qaz jdField_a_of_type_Qaz;
  private qfy jdField_a_of_type_Qfy;
  private qkw jdField_a_of_type_Qkw;
  private qld jdField_a_of_type_Qld;
  private qle jdField_a_of_type_Qle;
  private qlm jdField_a_of_type_Qlm;
  private qln jdField_a_of_type_Qln;
  private qlo jdField_a_of_type_Qlo;
  private qlq jdField_a_of_type_Qlq;
  private qmd jdField_a_of_type_Qmd;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  private boolean d;
  private boolean e;
  
  public qma(FragmentActivity paramFragmentActivity, Bundle paramBundle, qlm paramqlm)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)obz.a());
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_Qlm = paramqlm;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    l();
    m();
    k();
  }
  
  private void b(qln paramqln)
  {
    VideoInfo localVideoInfo = paramqln.a();
    paramqln.a(true);
    paramqln = paramqln.a();
    paramqln.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramqln, false);
    this.jdField_a_of_type_Qfy.a(localVideoInfo);
    this.jdField_a_of_type_Qaz.a(localVideoInfo);
  }
  
  private void c(qln paramqln)
  {
    if (this.jdField_a_of_type_Qln != null) {}
    for (qeq localqeq = this.jdField_a_of_type_Qln.a();; localqeq = null)
    {
      if ((localqeq != null) && (localqeq.jdField_a_of_type_Qhw != null))
      {
        int i = localqeq.jdField_a_of_type_Qhw.e();
        if ((i != 0) && (i != 1) && (i != 2) && (this.jdField_a_of_type_Qln.a() == paramqln.a() - 1) && (badq.h(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) && (bgmq.s(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(paramqln.a());
        }
      }
      return;
    }
  }
  
  private void k()
  {
    VideoInfo localVideoInfo = a();
    if (localVideoInfo != null)
    {
      int i = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
      int j = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      qmv localqmv = new qmv(localVideoInfo);
      localqmv.N(2).X(i).n(localVideoInfo.g);
      ndn.b(null, localVideoInfo.j, "0X800A98F", "0X800A98F", 0, 0, String.valueOf(j), "", localVideoInfo.g, localqmv.a().a(), false);
    }
  }
  
  private void l()
  {
    boolean bool2 = true;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_FROM_AIO", false));
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_PLAY_POSITION", 0L);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_SHOW_COMMENT", false);
    if ((this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 2) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 3) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 6) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 7))
    {
      bool1 = true;
      this.jdField_b_of_type_Boolean = bool1;
      if (this.jdField_b_of_type_Boolean) {
        break label183;
      }
    }
    label183:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.c = bool1;
      if (this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_LOAD_DELEGATE_TYPE", 0) == 0)
      {
        VideoInfo localVideoInfo = qlj.a(this.jdField_a_of_type_AndroidOsBundle);
        if (localVideoInfo != null) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localVideoInfo);
        }
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_Qlo = new qls(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = new VideoFeedsPlayManager(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this);
    this.jdField_a_of_type_Pyy = new pyy(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Qfy = new qfy(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_Int, false, this, 1);
    this.jdField_a_of_type_Qfy.b(a());
    this.jdField_a_of_type_Qmd = new qmd(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a = new qii(qii.e, qii.f);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new qmb(this));
  }
  
  @Nullable
  public VideoInfo a()
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public VideoFeedsPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  }
  
  public ArrayList<VideoInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public HashSet<VideoInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilHashSet;
  }
  
  public pyy a()
  {
    return this.jdField_a_of_type_Pyy;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qlo.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Qlm.a(paramInt);
    this.jdField_a_of_type_Qle.a(0, 1);
    this.jdField_a_of_type_Qfy.b(a());
    this.jdField_a_of_type_Qmd.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Qlm.b(1);
    this.jdField_a_of_type_Qlm.a(paramInt1, paramInt2);
    this.jdField_a_of_type_Qle.a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Qfy.a(paramInt1, paramInt2, paramIntent);
      this.jdField_a_of_type_Qld.a(paramInt1, paramInt2, paramIntent);
      this.jdField_a_of_type_Qaz.a(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt2 == -1)
      {
        Object localObject = new Bundle();
        ((Bundle)localObject).putAll(paramIntent.getExtras());
        qcn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Bundle)localObject);
        continue;
        if (paramInt2 == -1)
        {
          if (!paramIntent.getBooleanExtra("bFailed", false)) {
            i = 1;
          }
          localObject = new bbmy(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext());
          ((bbmy)localObject).d(2000);
          if (i != 0)
          {
            ((bbmy)localObject).a(bbmy.a(2));
            ((bbmy)localObject).c(2131626723);
            ((bbmy)localObject).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext().getResources().getDimensionPixelSize(2131167766) - (int)bacc.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), 5.0F));
          }
          else
          {
            ((bbmy)localObject).a(bbmy.a(1));
            ((bbmy)localObject).c(2131626724);
            ((bbmy)localObject).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext().getResources().getDimensionPixelSize(2131167766) - (int)bacc.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), 5.0F));
            continue;
            if (paramInt2 == -1)
            {
              bbmy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131653676, 0).a();
              continue;
              if (paramInt2 == -1) {
                bbmy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, -1, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131633876), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
              }
            }
          }
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (((this.jdField_a_of_type_Qln instanceof qlv)) && (paramLong >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b() - 7000L) && (qzk.a().a())) {}
    try
    {
      FusionBiuInfo localFusionBiuInfo = this.jdField_a_of_type_Qln.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo;
      if ((localFusionBiuInfo != null) && (!localFusionBiuInfo.jdField_b_of_type_Boolean)) {
        ((qlv)this.jdField_a_of_type_Qln).d(true);
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (qln)paramViewHolder;
    if (this.jdField_a_of_type_Qln != null)
    {
      this.jdField_a_of_type_Qln.a(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d();
    }
    this.jdField_a_of_type_Qln = paramViewHolder;
    b(this.jdField_a_of_type_Qln);
    this.jdField_a_of_type_Qmd.a(paramViewHolder);
    this.jdField_a_of_type_Qlo.a(paramViewHolder.a());
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    this.e = paramBoolean;
    if ((paramViewHolder instanceof qln)) {
      ((qln)paramViewHolder).b(paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().addFlags(1024);
      if (Build.VERSION.SDK_INT >= 19)
      {
        paramViewHolder = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().getDecorView();
        this.jdField_b_of_type_Int = paramViewHolder.getSystemUiVisibility();
        paramViewHolder.setSystemUiVisibility(4102);
      }
    }
    while ((Build.VERSION.SDK_INT < 19) || (this.jdField_b_of_type_Int == -1)) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(this.jdField_b_of_type_Int);
  }
  
  public void a(VideoInfo paramVideoInfo) {}
  
  public void a(VideoInfo paramVideoInfo, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Qlq.a(paramVideoInfo, paramInt1, paramInt2);
    this.jdField_a_of_type_Qmd.f(paramVideoInfo);
  }
  
  public void a(VideoFeedsRecyclerView paramVideoFeedsRecyclerView, qkw paramqkw, View paramView)
  {
    this.jdField_a_of_type_Qkw = paramqkw;
    paramVideoFeedsRecyclerView.a(this);
    this.jdField_a_of_type_Qlo.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFollowManager = new VideoFollowManager(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Qkw, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_JavaUtilArrayList, 1);
    this.jdField_a_of_type_Qld = new qld(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Qkw, this);
    this.jdField_a_of_type_Qlq = new qlq(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Qkw);
    this.jdField_a_of_type_Qle = new qle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Qkw, this);
    this.jdField_a_of_type_Qaz = new qaz(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager(), null, this.jdField_a_of_type_Qkw, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, (ViewGroup)paramView.findViewById(2131298953));
    this.jdField_a_of_type_Qaz.b();
    if (bjeh.b()) {
      this.jdField_a_of_type_Qaz.a(ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity));
    }
    this.jdField_a_of_type_Qaz.a(this);
    qji.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
  }
  
  public void a(qeq paramqeq)
  {
    this.jdField_a_of_type_Qmd.a(paramqeq);
  }
  
  public void a(qeq paramqeq, int paramInt)
  {
    this.jdField_a_of_type_Qmd.b(paramqeq);
  }
  
  public void a(qeq paramqeq, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(qeq paramqeq, boolean paramBoolean)
  {
    this.jdField_a_of_type_Qmd.a(paramqeq, paramBoolean);
  }
  
  public void a(qln paramqln)
  {
    c(paramqln);
    if (paramqln.a() != 0) {
      this.jdField_a_of_type_Qmd.a(paramqln.a(), paramqln.a());
    }
    this.jdField_a_of_type_JavaUtilHashSet.add(paramqln.a());
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qlm.a(paramBoolean);
    if (this.jdField_a_of_type_Qln != null) {
      this.jdField_a_of_type_Qln.c(paramBoolean);
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if (this.jdField_a_of_type_Qln != null)
    {
      if (paramInt == 25) {}
      for (paramInt = -1;; paramInt = 1)
      {
        qji.a().a(paramInt);
        this.jdField_a_of_type_Qln.a(qji.a().a());
        return true;
      }
    }
    return false;
  }
  
  public boolean a(qla paramqla)
  {
    if (paramqla == this.jdField_a_of_type_Qln) {
      return true;
    }
    this.jdField_a_of_type_Qlm.b();
    return false;
  }
  
  public boolean a(qln paramqln)
  {
    return paramqln == this.jdField_a_of_type_Qln;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.e)
    {
      this.jdField_a_of_type_Qlm.d();
      return true;
    }
    if (this.jdField_a_of_type_Qaz.a())
    {
      this.jdField_a_of_type_Qaz.h();
      return true;
    }
    this.jdField_a_of_type_Qmd.a(paramBoolean);
    return false;
  }
  
  public void b()
  {
    this.d = true;
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Qfy.a(0);
    this.jdField_a_of_type_Qmd.a(paramVideoInfo);
  }
  
  public void b(qeq paramqeq)
  {
    if ((badq.h(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) && (bgmq.s(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      paramqeq = this.jdField_a_of_type_Qlm.a(this.jdField_a_of_type_Qln.a() + 1);
      if ((paramqeq != null) && (paramqeq.a() != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(paramqeq.a());
      }
    }
    if (this.jdField_a_of_type_Qln != null) {
      this.jdField_a_of_type_Qln.e();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e();
    this.jdField_a_of_type_Qfy.b();
    this.jdField_a_of_type_Qlm.a(new qmc(this));
    qji.a().a(true, "multivideo doOnResume");
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFollowManager.a(paramVideoInfo);
    this.jdField_a_of_type_Qmd.b(paramVideoInfo);
  }
  
  public void c(qeq paramqeq)
  {
    if ((!this.e) && (!this.jdField_a_of_type_Qaz.a())) {
      this.jdField_a_of_type_Qlm.b();
    }
  }
  
  public void d()
  {
    if (this.d)
    {
      this.d = false;
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f();
    this.jdField_a_of_type_Qfy.c();
    qji.a().a(false, "multivideo doOnPause");
  }
  
  public void d(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.e()) {
      qcn.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.a);
    }
    for (;;)
    {
      this.jdField_a_of_type_Qmd.c(paramVideoInfo);
      return;
      if ((paramVideoInfo.O != null) && (!paramVideoInfo.O.equals(""))) {
        obz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramVideoInfo.O);
      } else if (paramVideoInfo.jdField_a_of_type_Int == 6)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.j))
        {
          String str = obb.g + baaw.encodeToString(paramVideoInfo.j.getBytes(), 2);
          obz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str);
        }
      }
      else if ((!TextUtils.isEmpty(paramVideoInfo.j)) && (!paramVideoInfo.j.equals("16888"))) {
        qlj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramVideoInfo.j);
      }
    }
  }
  
  public void d(qeq paramqeq) {}
  
  public void e()
  {
    this.jdField_a_of_type_Qlm.e();
  }
  
  public void e(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Qld.a(paramVideoInfo);
    this.jdField_a_of_type_Qmd.e(paramVideoInfo);
  }
  
  public void e(qeq paramqeq) {}
  
  public void f()
  {
    this.jdField_a_of_type_Qlm.f();
  }
  
  public void f(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Qlq.a(paramVideoInfo);
    this.jdField_a_of_type_Qmd.f(paramVideoInfo);
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g();
    this.jdField_a_of_type_Qlo.b();
    this.jdField_a_of_type_Qfy.d();
    this.jdField_a_of_type_Pyy.b();
    this.jdField_a_of_type_Qle.a();
    this.jdField_a_of_type_Qlq.a();
    qji.a().b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
  }
  
  public void g(VideoInfo paramVideoInfo)
  {
    if (qzk.a().b()) {
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
        break label114;
      }
    }
    label79:
    label114:
    for (FusionBiuInfo localFusionBiuInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo;; localFusionBiuInfo = null)
    {
      if (localFusionBiuInfo != null)
      {
        if (localFusionBiuInfo.jdField_b_of_type_Boolean) {
          break label79;
        }
        qzk.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, obz.a(), 1, 2, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 5, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      }
      for (;;)
      {
        qzk.a().b(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, 0, 2, 3);
        return;
        qzk.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localFusionBiuInfo.jdField_a_of_type_Long, obz.a(), paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType, 5, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      }
    }
  }
  
  public void h()
  {
    qeq localqeq = this.jdField_a_of_type_Qln.a();
    if ((localqeq != null) && (localqeq.jdField_a_of_type_Qhw != null)) {}
    for (int i = localqeq.jdField_a_of_type_Qhw.e();; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handlePlayButtonClick() status()=" + i);
      }
      switch (i)
      {
      default: 
        return;
      case 0: 
      case 7: 
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localqeq, false);
        return;
      case 6: 
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(localqeq);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localqeq, true);
        return;
      case 3: 
      case 4: 
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
        this.jdField_a_of_type_Qmd.c(localqeq);
        return;
      case 5: 
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
        return;
      case 1: 
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
      return;
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_Qaz.e();
    this.jdField_a_of_type_Qmd.d(this.jdField_a_of_type_Qln.a());
  }
  
  public void j()
  {
    this.jdField_a_of_type_Qlm.b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qma
 * JD-Core Version:    0.7.0.1
 */