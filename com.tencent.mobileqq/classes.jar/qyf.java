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
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
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

public class qyf
  implements qnb, qqp, qqq, qrq, qsj, qxu
{
  private static final String jdField_a_of_type_JavaLangString = qyf.class.getSimpleName();
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
  private qky jdField_a_of_type_Qky;
  private qmx jdField_a_of_type_Qmx;
  private qrw jdField_a_of_type_Qrw;
  private qxb jdField_a_of_type_Qxb;
  private qxi jdField_a_of_type_Qxi;
  private qxj jdField_a_of_type_Qxj;
  private qxr jdField_a_of_type_Qxr;
  private qxs jdField_a_of_type_Qxs;
  private qxt jdField_a_of_type_Qxt;
  private qxv jdField_a_of_type_Qxv;
  private qyi jdField_a_of_type_Qyi;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  private boolean d;
  private boolean e;
  
  public qyf(FragmentActivity paramFragmentActivity, Bundle paramBundle, qxr paramqxr)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)onk.a());
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_Qxr = paramqxr;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    l();
    m();
    k();
  }
  
  private void b(qxs paramqxs)
  {
    VideoInfo localVideoInfo = paramqxs.a();
    paramqxs.a(true);
    paramqxs = paramqxs.a();
    paramqxs.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramqxs, false);
    this.jdField_a_of_type_Qrw.a(localVideoInfo);
    this.jdField_a_of_type_Qmx.a(localVideoInfo);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      paramqxs = (AnchorData)this.jdField_a_of_type_AndroidOsBundle.getParcelable("VIDEO_COMMENT_ANCHOR");
      this.jdField_a_of_type_Qmx.a(paramqxs);
    }
  }
  
  private void c(qxs paramqxs)
  {
    if (this.jdField_a_of_type_Qxs != null) {}
    for (qqo localqqo = this.jdField_a_of_type_Qxs.a();; localqqo = null)
    {
      if ((localqqo != null) && (localqqo.jdField_a_of_type_Qub != null))
      {
        int i = localqqo.jdField_a_of_type_Qub.e();
        if ((i != 0) && (i != 1) && (i != 2) && (this.jdField_a_of_type_Qxs.a() == paramqxs.a() - 1) && (bbev.h(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) && (bhvh.t(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(paramqxs.a());
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
      qze localqze = new qze(localVideoInfo);
      localqze.O(2).Y(i).n(localVideoInfo.g);
      noo.b(null, localVideoInfo.j, "0X800A98F", "0X800A98F", 0, 0, String.valueOf(j), "", localVideoInfo.g, localqze.a().a(), false);
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
        break label188;
      }
    }
    label188:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.c = bool1;
      if (this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_LOAD_DELEGATE_TYPE", 0) == 0)
      {
        VideoInfo localVideoInfo = qxo.a(this.jdField_a_of_type_AndroidOsBundle);
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
    this.jdField_a_of_type_Qxt = new qxx(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = new VideoFeedsPlayManager(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this);
    this.jdField_a_of_type_Qky = new qky(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Qrw = new qrw(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_Int, false, this, 1);
    this.jdField_a_of_type_Qrw.b(a());
    this.jdField_a_of_type_Qyi = new qyi(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a = new qun(qun.e, qun.f);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new qyg(this));
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
  
  public qky a()
  {
    return this.jdField_a_of_type_Qky;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qxt.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Qxr.a(paramInt);
    this.jdField_a_of_type_Qxj.a(0, 1);
    this.jdField_a_of_type_Qrw.b(a());
    this.jdField_a_of_type_Qyi.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Qxr.b(1);
    this.jdField_a_of_type_Qxr.a(paramInt1, paramInt2);
    this.jdField_a_of_type_Qxj.a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Qrw.a(paramInt1, paramInt2, paramIntent);
      this.jdField_a_of_type_Qxi.a(paramInt1, paramInt2, paramIntent);
      this.jdField_a_of_type_Qmx.a(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt2 == -1)
      {
        Object localObject = new Bundle();
        ((Bundle)localObject).putAll(paramIntent.getExtras());
        qol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Bundle)localObject);
        continue;
        if (paramInt2 == -1)
        {
          if (!paramIntent.getBooleanExtra("bFailed", false)) {
            i = 1;
          }
          localObject = new bcpw(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext());
          ((bcpw)localObject).d(2000);
          if (i != 0)
          {
            ((bcpw)localObject).a(bcpw.a(2));
            ((bcpw)localObject).c(2131692325);
            ((bcpw)localObject).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext().getResources().getDimensionPixelSize(2131298865) - (int)bbdh.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), 5.0F));
          }
          else
          {
            ((bcpw)localObject).a(bcpw.a(1));
            ((bcpw)localObject).c(2131692326);
            ((bcpw)localObject).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext().getResources().getDimensionPixelSize(2131298865) - (int)bbdh.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), 5.0F));
            continue;
            if (paramInt2 == -1)
            {
              bcpw.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131719560, 0).a();
              continue;
              if (paramInt2 == -1) {
                bcpw.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, -1, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131699664), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
              }
            }
          }
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (((this.jdField_a_of_type_Qxs instanceof qya)) && (paramLong >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b() - 7000L) && (rmc.a().a())) {}
    try
    {
      FusionBiuInfo localFusionBiuInfo = this.jdField_a_of_type_Qxs.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo;
      if ((localFusionBiuInfo != null) && (!localFusionBiuInfo.jdField_b_of_type_Boolean)) {
        ((qya)this.jdField_a_of_type_Qxs).d(true);
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
    paramViewHolder = (qxs)paramViewHolder;
    if (this.jdField_a_of_type_Qxs != null)
    {
      this.jdField_a_of_type_Qxs.a(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d();
    }
    this.jdField_a_of_type_Qxs = paramViewHolder;
    b(this.jdField_a_of_type_Qxs);
    this.jdField_a_of_type_Qyi.a(paramViewHolder);
    this.jdField_a_of_type_Qxt.a(paramViewHolder.a());
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    this.e = paramBoolean;
    if ((paramViewHolder instanceof qxs)) {
      ((qxs)paramViewHolder).b(paramBoolean);
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
    this.jdField_a_of_type_Qxv.a(paramVideoInfo, paramInt1, paramInt2);
    this.jdField_a_of_type_Qyi.f(paramVideoInfo);
  }
  
  public void a(VideoFeedsRecyclerView paramVideoFeedsRecyclerView, qxb paramqxb, View paramView)
  {
    this.jdField_a_of_type_Qxb = paramqxb;
    paramVideoFeedsRecyclerView.a(this);
    this.jdField_a_of_type_Qxt.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFollowManager = new VideoFollowManager(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Qxb, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_JavaUtilArrayList, 1);
    this.jdField_a_of_type_Qxi = new qxi(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Qxb, this);
    this.jdField_a_of_type_Qxv = new qxv(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Qxb);
    this.jdField_a_of_type_Qxj = new qxj(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Qxb, this);
    this.jdField_a_of_type_Qmx = new qmx(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager(), null, this.jdField_a_of_type_Qxb, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, (ViewGroup)paramView.findViewById(2131364513));
    this.jdField_a_of_type_Qmx.b();
    if (bkur.b()) {
      this.jdField_a_of_type_Qmx.a(ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity));
    }
    this.jdField_a_of_type_Qmx.a(this);
    qvn.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
  }
  
  public void a(qqo paramqqo)
  {
    this.jdField_a_of_type_Qyi.a(paramqqo);
  }
  
  public void a(qqo paramqqo, int paramInt)
  {
    this.jdField_a_of_type_Qyi.b(paramqqo);
  }
  
  public void a(qqo paramqqo, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(qqo paramqqo, boolean paramBoolean)
  {
    this.jdField_a_of_type_Qyi.a(paramqqo, paramBoolean);
  }
  
  public void a(qxs paramqxs)
  {
    c(paramqxs);
    if (paramqxs.a() != 0) {
      this.jdField_a_of_type_Qyi.a(paramqxs.a(), paramqxs.a());
    }
    this.jdField_a_of_type_JavaUtilHashSet.add(paramqxs.a());
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qxr.a(paramBoolean);
    if (this.jdField_a_of_type_Qxs != null) {
      this.jdField_a_of_type_Qxs.c(paramBoolean);
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if (this.jdField_a_of_type_Qxs != null)
    {
      if (paramInt == 25) {}
      for (paramInt = -1;; paramInt = 1)
      {
        qvn.a().a(paramInt);
        this.jdField_a_of_type_Qxs.a(qvn.a().a());
        return true;
      }
    }
    return false;
  }
  
  public boolean a(qxf paramqxf)
  {
    if (paramqxf == this.jdField_a_of_type_Qxs) {
      return true;
    }
    this.jdField_a_of_type_Qxr.b();
    return false;
  }
  
  public boolean a(qxs paramqxs)
  {
    return paramqxs == this.jdField_a_of_type_Qxs;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.e)
    {
      this.jdField_a_of_type_Qxr.d();
      return true;
    }
    if (this.jdField_a_of_type_Qmx.a())
    {
      this.jdField_a_of_type_Qmx.h();
      return true;
    }
    this.jdField_a_of_type_Qyi.a(paramBoolean);
    return false;
  }
  
  public void b()
  {
    this.d = true;
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Qrw.a(0);
    this.jdField_a_of_type_Qyi.a(paramVideoInfo);
  }
  
  public void b(qqo paramqqo)
  {
    if ((bbev.h(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) && (bhvh.t(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      paramqqo = this.jdField_a_of_type_Qxr.a(this.jdField_a_of_type_Qxs.a() + 1);
      if ((paramqqo != null) && (paramqqo.a() != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(paramqqo.a());
      }
    }
    if (this.jdField_a_of_type_Qxs != null) {
      this.jdField_a_of_type_Qxs.e();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e();
    this.jdField_a_of_type_Qrw.b();
    this.jdField_a_of_type_Qxr.a(new qyh(this));
    qvn.a().a(true, "multivideo doOnResume");
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFollowManager.a(paramVideoInfo);
    this.jdField_a_of_type_Qyi.b(paramVideoInfo);
  }
  
  public void c(qqo paramqqo)
  {
    if ((!this.e) && (!this.jdField_a_of_type_Qmx.a())) {
      this.jdField_a_of_type_Qxr.b();
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
    this.jdField_a_of_type_Qrw.c();
    qvn.a().a(false, "multivideo doOnPause");
  }
  
  public void d(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.e()) {
      qol.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.a);
    }
    for (;;)
    {
      this.jdField_a_of_type_Qyi.c(paramVideoInfo);
      return;
      if ((paramVideoInfo.O != null) && (!paramVideoInfo.O.equals(""))) {
        onk.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramVideoInfo.O);
      } else if (paramVideoInfo.jdField_a_of_type_Int == 6)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.j))
        {
          String str = omm.g + bbca.encodeToString(paramVideoInfo.j.getBytes(), 2);
          onk.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str);
        }
      }
      else if ((!TextUtils.isEmpty(paramVideoInfo.j)) && (!paramVideoInfo.j.equals("16888"))) {
        qxo.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramVideoInfo.j);
      }
    }
  }
  
  public void d(qqo paramqqo) {}
  
  public void e()
  {
    this.jdField_a_of_type_Qxr.e();
  }
  
  public void e(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Qxi.a(paramVideoInfo);
    this.jdField_a_of_type_Qyi.e(paramVideoInfo);
  }
  
  public void e(qqo paramqqo) {}
  
  public void f()
  {
    this.jdField_a_of_type_Qxr.f();
  }
  
  public void f(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Qxv.a(paramVideoInfo);
    this.jdField_a_of_type_Qyi.f(paramVideoInfo);
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g();
    this.jdField_a_of_type_Qxt.b();
    this.jdField_a_of_type_Qrw.d();
    this.jdField_a_of_type_Qky.b();
    this.jdField_a_of_type_Qxj.a();
    this.jdField_a_of_type_Qxv.a();
    qvn.a().b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
  }
  
  public void g(VideoInfo paramVideoInfo)
  {
    if (rmc.a().b()) {
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
        rmc.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, onk.a(), 1, 2, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 5, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      }
      for (;;)
      {
        rmc.a().b(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, 0, 2, 3);
        return;
        rmc.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localFusionBiuInfo.jdField_a_of_type_Long, onk.a(), paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType, 5, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      }
    }
  }
  
  public void h()
  {
    qqo localqqo = this.jdField_a_of_type_Qxs.a();
    if ((localqqo != null) && (localqqo.jdField_a_of_type_Qub != null)) {}
    for (int i = localqqo.jdField_a_of_type_Qub.e();; i = 0)
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localqqo, false);
        return;
      case 6: 
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(localqqo);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localqqo, true);
        return;
      case 3: 
      case 4: 
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
        this.jdField_a_of_type_Qyi.c(localqqo);
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
    this.jdField_a_of_type_Qmx.e();
    this.jdField_a_of_type_Qyi.d(this.jdField_a_of_type_Qxs.a());
  }
  
  public void j()
  {
    this.jdField_a_of_type_Qxr.b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qyf
 * JD-Core Version:    0.7.0.1
 */