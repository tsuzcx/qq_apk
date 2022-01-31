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
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFollowManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashSet;

public class rnn
  implements rcc, rft, rfu, rgv, rhs, rng
{
  private static final String jdField_a_of_type_JavaLangString = rnn.class.getSimpleName();
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
  private rac jdField_a_of_type_Rac;
  private rby jdField_a_of_type_Rby;
  private rhf jdField_a_of_type_Rhf;
  private rmn jdField_a_of_type_Rmn;
  private rmu jdField_a_of_type_Rmu;
  private rmv jdField_a_of_type_Rmv;
  private rnd jdField_a_of_type_Rnd;
  private rne jdField_a_of_type_Rne;
  private rnf jdField_a_of_type_Rnf;
  private rnh jdField_a_of_type_Rnh;
  private rnq jdField_a_of_type_Rnq;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  private boolean d;
  private boolean e;
  
  public rnn(FragmentActivity paramFragmentActivity, Bundle paramBundle, rnd paramrnd)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ors.a());
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_Rnd = paramrnd;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    l();
    m();
    k();
  }
  
  private void b(rne paramrne)
  {
    VideoInfo localVideoInfo = paramrne.a();
    paramrne.a(true);
    paramrne = paramrne.a();
    paramrne.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramrne, false);
    this.jdField_a_of_type_Rhf.a(localVideoInfo);
    this.jdField_a_of_type_Rby.a(localVideoInfo);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      paramrne = (AnchorData)this.jdField_a_of_type_AndroidOsBundle.getParcelable("VIDEO_COMMENT_ANCHOR");
      this.jdField_a_of_type_Rby.a(paramrne);
    }
  }
  
  private void c(rne paramrne)
  {
    if (this.jdField_a_of_type_Rne != null) {}
    for (rfs localrfs = this.jdField_a_of_type_Rne.a();; localrfs = null)
    {
      if ((localrfs != null) && (localrfs.jdField_a_of_type_Rjn != null))
      {
        int i = localrfs.jdField_a_of_type_Rjn.e();
        if ((i != 0) && (i != 1) && (i != 2) && (this.jdField_a_of_type_Rne.a() == paramrne.a() - 1) && (bdin.h(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) && (bkbq.u(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(paramrne.a());
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
      ron localron = new ron(localVideoInfo);
      localron.N(2).X(i).n(localVideoInfo.g);
      nrt.b(null, localVideoInfo.j, "0X800A98F", "0X800A98F", 0, 0, String.valueOf(j), "", localVideoInfo.g, localron.a().a(), false);
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
        VideoInfo localVideoInfo = rna.a(this.jdField_a_of_type_AndroidOsBundle);
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
    this.jdField_a_of_type_Rnf = new rnj(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = new VideoFeedsPlayManager(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this);
    this.jdField_a_of_type_Rac = new rac(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Rhf = new rhf(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_Int, false, this, 1);
    this.jdField_a_of_type_Rhf.b(a());
    this.jdField_a_of_type_Rnq = new rnq(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a = new rjz(rjz.e, rjz.f);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new rno(this));
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
  
  public rac a()
  {
    return this.jdField_a_of_type_Rac;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rnf.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Rnd.a(paramInt);
    this.jdField_a_of_type_Rmv.a(0, 1);
    this.jdField_a_of_type_Rhf.b(a());
    this.jdField_a_of_type_Rnq.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Rnd.b(1);
    this.jdField_a_of_type_Rnd.a(paramInt1, paramInt2);
    this.jdField_a_of_type_Rmv.a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Rhf.a(paramInt1, paramInt2, paramIntent);
      this.jdField_a_of_type_Rmu.a(paramInt1, paramInt2, paramIntent);
      this.jdField_a_of_type_Rby.a(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt2 == -1)
      {
        Object localObject = new Bundle();
        ((Bundle)localObject).putAll(paramIntent.getExtras());
        rdm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Bundle)localObject);
        continue;
        if (paramInt2 == -1)
        {
          if (!paramIntent.getBooleanExtra("bFailed", false)) {
            i = 1;
          }
          localObject = new QQToast(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext());
          ((QQToast)localObject).d(2000);
          if (i != 0)
          {
            ((QQToast)localObject).a(QQToast.a(2));
            ((QQToast)localObject).c(2131692402);
            ((QQToast)localObject).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext().getResources().getDimensionPixelSize(2131298914) - (int)bdgz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), 5.0F));
          }
          else
          {
            ((QQToast)localObject).a(QQToast.a(1));
            ((QQToast)localObject).c(2131692403);
            ((QQToast)localObject).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext().getResources().getDimensionPixelSize(2131298914) - (int)bdgz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), 5.0F));
            continue;
            if (paramInt2 == -1)
            {
              QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131720115, 0).a();
              continue;
              if (paramInt2 == -1) {
                QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, -1, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131700055), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
              }
            }
          }
        }
      }
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (rne)paramViewHolder;
    if (this.jdField_a_of_type_Rne != null)
    {
      this.jdField_a_of_type_Rne.a(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d();
    }
    this.jdField_a_of_type_Rne = paramViewHolder;
    b(this.jdField_a_of_type_Rne);
    this.jdField_a_of_type_Rnq.a(paramViewHolder);
    this.jdField_a_of_type_Rnf.a(paramViewHolder.a());
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    this.e = paramBoolean;
    if ((paramViewHolder instanceof rne)) {
      ((rne)paramViewHolder).b(paramBoolean);
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
    this.jdField_a_of_type_Rnh.a(paramVideoInfo, paramInt1, paramInt2);
    this.jdField_a_of_type_Rnq.f(paramVideoInfo);
  }
  
  public void a(VideoFeedsRecyclerView paramVideoFeedsRecyclerView, rmn paramrmn, View paramView)
  {
    this.jdField_a_of_type_Rmn = paramrmn;
    paramVideoFeedsRecyclerView.a(this);
    this.jdField_a_of_type_Rnf.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFollowManager = new VideoFollowManager(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Rmn, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_JavaUtilArrayList, 1);
    this.jdField_a_of_type_Rmu = new rmu(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Rmn, this);
    this.jdField_a_of_type_Rnh = new rnh(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Rmn);
    this.jdField_a_of_type_Rmv = new rmv(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Rmn, this);
    this.jdField_a_of_type_Rby = new rby(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager(), null, this.jdField_a_of_type_Rmn, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, (ViewGroup)paramView.findViewById(2131364588));
    this.jdField_a_of_type_Rby.b();
    if (bnle.b()) {
      this.jdField_a_of_type_Rby.a(ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity));
    }
    this.jdField_a_of_type_Rby.a(this);
    rlb.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
  }
  
  public void a(rfs paramrfs)
  {
    this.jdField_a_of_type_Rnq.a(paramrfs);
  }
  
  public void a(rfs paramrfs, int paramInt)
  {
    this.jdField_a_of_type_Rnq.b(paramrfs);
  }
  
  public void a(rfs paramrfs, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(rfs paramrfs, boolean paramBoolean)
  {
    this.jdField_a_of_type_Rnq.a(paramrfs, paramBoolean);
  }
  
  public void a(rne paramrne)
  {
    c(paramrne);
    if (paramrne.a() != 0) {
      this.jdField_a_of_type_Rnq.a(paramrne.a(), paramrne.a());
    }
    this.jdField_a_of_type_JavaUtilHashSet.add(paramrne.a());
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Rnd.a(paramBoolean);
    if (this.jdField_a_of_type_Rne != null) {
      this.jdField_a_of_type_Rne.c(paramBoolean);
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if (this.jdField_a_of_type_Rne != null)
    {
      if (paramInt == 25) {}
      for (paramInt = -1;; paramInt = 1)
      {
        rlb.a().a(paramInt);
        this.jdField_a_of_type_Rne.a(rlb.a().a());
        return true;
      }
    }
    return false;
  }
  
  public boolean a(rmr paramrmr)
  {
    if (paramrmr == this.jdField_a_of_type_Rne) {
      return true;
    }
    this.jdField_a_of_type_Rnd.b();
    return false;
  }
  
  public boolean a(rne paramrne)
  {
    return paramrne == this.jdField_a_of_type_Rne;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.e)
    {
      this.jdField_a_of_type_Rnd.d();
      return true;
    }
    if (this.jdField_a_of_type_Rby.a())
    {
      this.jdField_a_of_type_Rby.h();
      return true;
    }
    this.jdField_a_of_type_Rnq.a(paramBoolean);
    return false;
  }
  
  public void b()
  {
    this.d = true;
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Rhf.a(0);
    this.jdField_a_of_type_Rnq.a(paramVideoInfo);
  }
  
  public void b(rfs paramrfs)
  {
    if ((bdin.h(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) && (bkbq.u(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      paramrfs = this.jdField_a_of_type_Rnd.a(this.jdField_a_of_type_Rne.a() + 1);
      if ((paramrfs != null) && (paramrfs.a() != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(paramrfs.a());
      }
    }
    if (this.jdField_a_of_type_Rne != null) {
      this.jdField_a_of_type_Rne.e();
    }
  }
  
  public void b(rfs paramrfs, boolean paramBoolean) {}
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e();
    this.jdField_a_of_type_Rhf.b();
    this.jdField_a_of_type_Rnd.a(new rnp(this));
    rlb.a().a(true, "multivideo doOnResume");
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFollowManager.a(paramVideoInfo);
    this.jdField_a_of_type_Rnq.b(paramVideoInfo);
  }
  
  public void c(rfs paramrfs)
  {
    if ((!this.e) && (!this.jdField_a_of_type_Rby.a())) {
      this.jdField_a_of_type_Rnd.b();
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
    this.jdField_a_of_type_Rhf.c();
    rlb.a().a(false, "multivideo doOnPause");
  }
  
  public void d(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.e()) {
      rdm.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.a);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rnq.c(paramVideoInfo);
      return;
      if ((paramVideoInfo.z != null) && (!paramVideoInfo.z.equals(""))) {
        ors.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramVideoInfo.z);
      } else if (paramVideoInfo.jdField_a_of_type_Int == 6)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.j))
        {
          String str = oqu.g + bdfr.encodeToString(paramVideoInfo.j.getBytes(), 2);
          ors.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str);
        }
      }
      else if ((!TextUtils.isEmpty(paramVideoInfo.j)) && (!paramVideoInfo.j.equals("16888"))) {
        rna.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramVideoInfo.j);
      }
    }
  }
  
  public void d(rfs paramrfs) {}
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g();
    this.jdField_a_of_type_Rnf.b();
    this.jdField_a_of_type_Rhf.d();
    this.jdField_a_of_type_Rac.b();
    this.jdField_a_of_type_Rmv.a();
    this.jdField_a_of_type_Rnh.a();
    rlb.a().b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
  }
  
  public void e(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Rmu.a(paramVideoInfo);
    this.jdField_a_of_type_Rnq.e(paramVideoInfo);
  }
  
  public void e(rfs paramrfs) {}
  
  public void f()
  {
    this.jdField_a_of_type_Rnd.e();
  }
  
  public void f(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Rnh.a(paramVideoInfo);
    this.jdField_a_of_type_Rnq.f(paramVideoInfo);
  }
  
  public void f(rfs paramrfs) {}
  
  public void g()
  {
    this.jdField_a_of_type_Rnd.f();
  }
  
  public void h()
  {
    rfs localrfs = this.jdField_a_of_type_Rne.a();
    if ((localrfs != null) && (localrfs.jdField_a_of_type_Rjn != null)) {}
    for (int i = localrfs.jdField_a_of_type_Rjn.e();; i = 0)
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localrfs, false);
        return;
      case 6: 
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(localrfs);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localrfs, true);
        return;
      case 3: 
      case 4: 
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
        this.jdField_a_of_type_Rnq.c(localrfs);
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
    this.jdField_a_of_type_Rby.e();
    this.jdField_a_of_type_Rnq.d(this.jdField_a_of_type_Rne.a());
  }
  
  public void j()
  {
    this.jdField_a_of_type_Rnd.b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rnn
 * JD-Core Version:    0.7.0.1
 */