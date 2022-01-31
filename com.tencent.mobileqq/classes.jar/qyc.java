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

public class qyc
  implements qmy, qqm, qqn, qrn, qsg, qxr
{
  private static final String jdField_a_of_type_JavaLangString = qyc.class.getSimpleName();
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
  private qkv jdField_a_of_type_Qkv;
  private qmu jdField_a_of_type_Qmu;
  private qrt jdField_a_of_type_Qrt;
  private qwy jdField_a_of_type_Qwy;
  private qxf jdField_a_of_type_Qxf;
  private qxg jdField_a_of_type_Qxg;
  private qxo jdField_a_of_type_Qxo;
  private qxp jdField_a_of_type_Qxp;
  private qxq jdField_a_of_type_Qxq;
  private qxs jdField_a_of_type_Qxs;
  private qyf jdField_a_of_type_Qyf;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  private boolean d;
  private boolean e;
  
  public qyc(FragmentActivity paramFragmentActivity, Bundle paramBundle, qxo paramqxo)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)onh.a());
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_Qxo = paramqxo;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    l();
    m();
    k();
  }
  
  private void b(qxp paramqxp)
  {
    VideoInfo localVideoInfo = paramqxp.a();
    paramqxp.a(true);
    paramqxp = paramqxp.a();
    paramqxp.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramqxp, false);
    this.jdField_a_of_type_Qrt.a(localVideoInfo);
    this.jdField_a_of_type_Qmu.a(localVideoInfo);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      paramqxp = (AnchorData)this.jdField_a_of_type_AndroidOsBundle.getParcelable("VIDEO_COMMENT_ANCHOR");
      this.jdField_a_of_type_Qmu.a(paramqxp);
    }
  }
  
  private void c(qxp paramqxp)
  {
    if (this.jdField_a_of_type_Qxp != null) {}
    for (qql localqql = this.jdField_a_of_type_Qxp.a();; localqql = null)
    {
      if ((localqql != null) && (localqql.jdField_a_of_type_Qty != null))
      {
        int i = localqql.jdField_a_of_type_Qty.e();
        if ((i != 0) && (i != 1) && (i != 2) && (this.jdField_a_of_type_Qxp.a() == paramqxp.a() - 1) && (bbfj.h(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) && (bhvy.t(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(paramqxp.a());
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
      qzb localqzb = new qzb(localVideoInfo);
      localqzb.O(2).Y(i).n(localVideoInfo.g);
      nol.b(null, localVideoInfo.j, "0X800A98F", "0X800A98F", 0, 0, String.valueOf(j), "", localVideoInfo.g, localqzb.a().a(), false);
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
        VideoInfo localVideoInfo = qxl.a(this.jdField_a_of_type_AndroidOsBundle);
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
    this.jdField_a_of_type_Qxq = new qxu(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = new VideoFeedsPlayManager(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this);
    this.jdField_a_of_type_Qkv = new qkv(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Qrt = new qrt(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_Int, false, this, 1);
    this.jdField_a_of_type_Qrt.b(a());
    this.jdField_a_of_type_Qyf = new qyf(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a = new quk(quk.e, quk.f);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new qyd(this));
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
  
  public qkv a()
  {
    return this.jdField_a_of_type_Qkv;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qxq.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Qxo.a(paramInt);
    this.jdField_a_of_type_Qxg.a(0, 1);
    this.jdField_a_of_type_Qrt.b(a());
    this.jdField_a_of_type_Qyf.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Qxo.b(1);
    this.jdField_a_of_type_Qxo.a(paramInt1, paramInt2);
    this.jdField_a_of_type_Qxg.a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Qrt.a(paramInt1, paramInt2, paramIntent);
      this.jdField_a_of_type_Qxf.a(paramInt1, paramInt2, paramIntent);
      this.jdField_a_of_type_Qmu.a(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt2 == -1)
      {
        Object localObject = new Bundle();
        ((Bundle)localObject).putAll(paramIntent.getExtras());
        qoi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Bundle)localObject);
        continue;
        if (paramInt2 == -1)
        {
          if (!paramIntent.getBooleanExtra("bFailed", false)) {
            i = 1;
          }
          localObject = new bcql(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext());
          ((bcql)localObject).d(2000);
          if (i != 0)
          {
            ((bcql)localObject).a(bcql.a(2));
            ((bcql)localObject).c(2131692325);
            ((bcql)localObject).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext().getResources().getDimensionPixelSize(2131298865) - (int)bbdv.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), 5.0F));
          }
          else
          {
            ((bcql)localObject).a(bcql.a(1));
            ((bcql)localObject).c(2131692326);
            ((bcql)localObject).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext().getResources().getDimensionPixelSize(2131298865) - (int)bbdv.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), 5.0F));
            continue;
            if (paramInt2 == -1)
            {
              bcql.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131719571, 0).a();
              continue;
              if (paramInt2 == -1) {
                bcql.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, -1, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131699675), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
              }
            }
          }
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (((this.jdField_a_of_type_Qxp instanceof qxx)) && (paramLong >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b() - 7000L) && (rlz.a().a())) {}
    try
    {
      FusionBiuInfo localFusionBiuInfo = this.jdField_a_of_type_Qxp.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo;
      if ((localFusionBiuInfo != null) && (!localFusionBiuInfo.jdField_b_of_type_Boolean)) {
        ((qxx)this.jdField_a_of_type_Qxp).d(true);
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
    paramViewHolder = (qxp)paramViewHolder;
    if (this.jdField_a_of_type_Qxp != null)
    {
      this.jdField_a_of_type_Qxp.a(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d();
    }
    this.jdField_a_of_type_Qxp = paramViewHolder;
    b(this.jdField_a_of_type_Qxp);
    this.jdField_a_of_type_Qyf.a(paramViewHolder);
    this.jdField_a_of_type_Qxq.a(paramViewHolder.a());
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    this.e = paramBoolean;
    if ((paramViewHolder instanceof qxp)) {
      ((qxp)paramViewHolder).b(paramBoolean);
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
    this.jdField_a_of_type_Qxs.a(paramVideoInfo, paramInt1, paramInt2);
    this.jdField_a_of_type_Qyf.f(paramVideoInfo);
  }
  
  public void a(VideoFeedsRecyclerView paramVideoFeedsRecyclerView, qwy paramqwy, View paramView)
  {
    this.jdField_a_of_type_Qwy = paramqwy;
    paramVideoFeedsRecyclerView.a(this);
    this.jdField_a_of_type_Qxq.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFollowManager = new VideoFollowManager(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Qwy, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_JavaUtilArrayList, 1);
    this.jdField_a_of_type_Qxf = new qxf(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Qwy, this);
    this.jdField_a_of_type_Qxs = new qxs(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Qwy);
    this.jdField_a_of_type_Qxg = new qxg(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Qwy, this);
    this.jdField_a_of_type_Qmu = new qmu(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager(), null, this.jdField_a_of_type_Qwy, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, (ViewGroup)paramView.findViewById(2131364512));
    this.jdField_a_of_type_Qmu.b();
    if (bkvi.b()) {
      this.jdField_a_of_type_Qmu.a(ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity));
    }
    this.jdField_a_of_type_Qmu.a(this);
    qvk.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
  }
  
  public void a(qql paramqql)
  {
    this.jdField_a_of_type_Qyf.a(paramqql);
  }
  
  public void a(qql paramqql, int paramInt)
  {
    this.jdField_a_of_type_Qyf.b(paramqql);
  }
  
  public void a(qql paramqql, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(qql paramqql, boolean paramBoolean)
  {
    this.jdField_a_of_type_Qyf.a(paramqql, paramBoolean);
  }
  
  public void a(qxp paramqxp)
  {
    c(paramqxp);
    if (paramqxp.a() != 0) {
      this.jdField_a_of_type_Qyf.a(paramqxp.a(), paramqxp.a());
    }
    this.jdField_a_of_type_JavaUtilHashSet.add(paramqxp.a());
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qxo.a(paramBoolean);
    if (this.jdField_a_of_type_Qxp != null) {
      this.jdField_a_of_type_Qxp.c(paramBoolean);
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if (this.jdField_a_of_type_Qxp != null)
    {
      if (paramInt == 25) {}
      for (paramInt = -1;; paramInt = 1)
      {
        qvk.a().a(paramInt);
        this.jdField_a_of_type_Qxp.a(qvk.a().a());
        return true;
      }
    }
    return false;
  }
  
  public boolean a(qxc paramqxc)
  {
    if (paramqxc == this.jdField_a_of_type_Qxp) {
      return true;
    }
    this.jdField_a_of_type_Qxo.b();
    return false;
  }
  
  public boolean a(qxp paramqxp)
  {
    return paramqxp == this.jdField_a_of_type_Qxp;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.e)
    {
      this.jdField_a_of_type_Qxo.d();
      return true;
    }
    if (this.jdField_a_of_type_Qmu.a())
    {
      this.jdField_a_of_type_Qmu.h();
      return true;
    }
    this.jdField_a_of_type_Qyf.a(paramBoolean);
    return false;
  }
  
  public void b()
  {
    this.d = true;
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Qrt.a(0);
    this.jdField_a_of_type_Qyf.a(paramVideoInfo);
  }
  
  public void b(qql paramqql)
  {
    if ((bbfj.h(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) && (bhvy.t(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      paramqql = this.jdField_a_of_type_Qxo.a(this.jdField_a_of_type_Qxp.a() + 1);
      if ((paramqql != null) && (paramqql.a() != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(paramqql.a());
      }
    }
    if (this.jdField_a_of_type_Qxp != null) {
      this.jdField_a_of_type_Qxp.e();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e();
    this.jdField_a_of_type_Qrt.b();
    this.jdField_a_of_type_Qxo.a(new qye(this));
    qvk.a().a(true, "multivideo doOnResume");
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFollowManager.a(paramVideoInfo);
    this.jdField_a_of_type_Qyf.b(paramVideoInfo);
  }
  
  public void c(qql paramqql)
  {
    if ((!this.e) && (!this.jdField_a_of_type_Qmu.a())) {
      this.jdField_a_of_type_Qxo.b();
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
    this.jdField_a_of_type_Qrt.c();
    qvk.a().a(false, "multivideo doOnPause");
  }
  
  public void d(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.e()) {
      qoi.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.a);
    }
    for (;;)
    {
      this.jdField_a_of_type_Qyf.c(paramVideoInfo);
      return;
      if ((paramVideoInfo.O != null) && (!paramVideoInfo.O.equals(""))) {
        onh.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramVideoInfo.O);
      } else if (paramVideoInfo.jdField_a_of_type_Int == 6)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.j))
        {
          String str = omj.g + bbco.encodeToString(paramVideoInfo.j.getBytes(), 2);
          onh.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str);
        }
      }
      else if ((!TextUtils.isEmpty(paramVideoInfo.j)) && (!paramVideoInfo.j.equals("16888"))) {
        qxl.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramVideoInfo.j);
      }
    }
  }
  
  public void d(qql paramqql) {}
  
  public void e()
  {
    this.jdField_a_of_type_Qxo.e();
  }
  
  public void e(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Qxf.a(paramVideoInfo);
    this.jdField_a_of_type_Qyf.e(paramVideoInfo);
  }
  
  public void e(qql paramqql) {}
  
  public void f()
  {
    this.jdField_a_of_type_Qxo.f();
  }
  
  public void f(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Qxs.a(paramVideoInfo);
    this.jdField_a_of_type_Qyf.f(paramVideoInfo);
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g();
    this.jdField_a_of_type_Qxq.b();
    this.jdField_a_of_type_Qrt.d();
    this.jdField_a_of_type_Qkv.b();
    this.jdField_a_of_type_Qxg.a();
    this.jdField_a_of_type_Qxs.a();
    qvk.a().b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
  }
  
  public void g(VideoInfo paramVideoInfo)
  {
    if (rlz.a().b()) {
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
        rlz.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, onh.a(), 1, 2, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 5, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      }
      for (;;)
      {
        rlz.a().b(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, 0, 2, 3);
        return;
        rlz.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localFusionBiuInfo.jdField_a_of_type_Long, onh.a(), paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType, 5, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      }
    }
  }
  
  public void h()
  {
    qql localqql = this.jdField_a_of_type_Qxp.a();
    if ((localqql != null) && (localqql.jdField_a_of_type_Qty != null)) {}
    for (int i = localqql.jdField_a_of_type_Qty.e();; i = 0)
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localqql, false);
        return;
      case 6: 
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(localqql);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localqql, true);
        return;
      case 3: 
      case 4: 
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
        this.jdField_a_of_type_Qyf.c(localqql);
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
    this.jdField_a_of_type_Qmu.e();
    this.jdField_a_of_type_Qyf.d(this.jdField_a_of_type_Qxp.a());
  }
  
  public void j()
  {
    this.jdField_a_of_type_Qxo.b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qyc
 * JD-Core Version:    0.7.0.1
 */