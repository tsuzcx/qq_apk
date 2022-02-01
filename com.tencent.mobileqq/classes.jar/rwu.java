import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.10;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.5;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.6;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.8;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.9;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RoundAngleFrameLayout;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyVideoAdHighLightBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;

public class rwu
  implements View.OnClickListener, blih, rlw, rpj, rwa
{
  protected int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new rwv(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new rwz(this);
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoFeedsGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private ReadInJoyBaseListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView;
  private VideoViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup;
  private ReadInJoyAdVideoGuide jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide;
  private ReadInJoyPatchAdView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView;
  private ReadInJoyVideoAdHighLightBar jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private ArrayList<rxc> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private List<rxb> jdField_a_of_type_JavaUtilList;
  private rlu jdField_a_of_type_Rlu;
  private rmr jdField_a_of_type_Rmr;
  private rvs jdField_a_of_type_Rvs;
  private rvy jdField_a_of_type_Rvy;
  private rwc jdField_a_of_type_Rwc;
  private rxa jdField_a_of_type_Rxa;
  private rxc jdField_a_of_type_Rxc;
  private sar jdField_a_of_type_Sar;
  private articlesummary.VideoDownloadBarInfo jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo;
  public tqf a;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  protected int b;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private SeekBar jdField_b_of_type_AndroidWidgetSeekBar;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private int jdField_i_of_type_Int;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private int jdField_j_of_type_Int;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private int jdField_k_of_type_Int = 0;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  private TextView l;
  private TextView m;
  
  public rwu(FrameLayout paramFrameLayout, ReadInJoyBaseListView paramReadInJoyBaseListView, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView = paramReadInJoyBaseListView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Sar = new sar(this.jdField_a_of_type_AndroidWidgetFrameLayout, this);
    this.jdField_a_of_type_Rvs = new rvs(paramActivity, this.jdField_a_of_type_AndroidWidgetFrameLayout, new rww(this));
    this.jdField_a_of_type_Rlu = new rlu(this.jdField_a_of_type_AndroidAppActivity, this);
    this.jdField_a_of_type_Rmr = new rmr(paramActivity);
    paramFrameLayout = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    this.jdField_a_of_type_Int = paramFrameLayout.getAttributes().flags;
    this.jdField_b_of_type_Int = paramFrameLayout.getDecorView().getSystemUiVisibility();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.setScrollEventCallback(new rwx(this));
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(1000L);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatMode(1);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setStartTime(-1L);
    paramFrameLayout = new LinearInterpolator();
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setInterpolator(paramFrameLayout);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131378964);
  }
  
  private void A()
  {
    this.jdField_a_of_type_Sar.b();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
  }
  
  private void B()
  {
    rpt.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8, 300);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    rpt.a(this.jdField_a_of_type_AndroidWidgetImageView, 8, 300);
    if (a()) {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    }
    for (;;)
    {
      if (!rpt.d()) {
        rpt.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8, 300);
      }
      return;
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
    }
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_Rvy != null) {}
    for (int n = (int)(this.jdField_a_of_type_Rvy.a() / 1000L);; n = 0)
    {
      tnu.a(n, this.jdField_a_of_type_Rvy);
      if (this.jdField_b_of_type_AndroidWidgetSeekBar.isEnabled())
      {
        if (this.jdField_b_of_type_AndroidWidgetSeekBar.getVisibility() != 0) {
          this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
        }
        this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(n);
      }
      if ((this.jdField_a_of_type_AndroidWidgetSeekBar.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetSeekBar.isEnabled())) {
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(n);
      }
      if (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(ozc.a(n, true));
      }
      if ((this.jdField_a_of_type_Rxc != null) && (this.jdField_a_of_type_Rwc != null) && (this.jdField_a_of_type_Rvy != null)) {
        this.jdField_a_of_type_Rxc.a(this.jdField_a_of_type_Rvy.a(), (int)this.jdField_a_of_type_Rvy.a(), this.jdField_a_of_type_Rwc.jdField_b_of_type_Int * 1000);
      }
      if ((this.jdField_a_of_type_Rwc != null) && (this.jdField_a_of_type_Rvy != null))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((rxc)localIterator.next()).a(this.jdField_a_of_type_Rvy.a(), (int)this.jdField_a_of_type_Rvy.a(), this.jdField_a_of_type_Rwc.jdField_b_of_type_Int * 1000);
        }
        a(this.jdField_a_of_type_Rvy.a(this.jdField_a_of_type_Rwc.a()), this.jdField_a_of_type_Rwc);
      }
      return;
    }
  }
  
  private void D()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    l();
    A();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    N();
    G();
    this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide.setVisibility(8);
    }
  }
  
  private void E()
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_Rwc != null)
    {
      Object localObject = this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if (localObject != null)
      {
        localObject = new sbg(null, this.jdField_a_of_type_Rwc.k, ((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).getInnerUniqueID()).a((int)((BaseArticleInfo)localObject).mChannelID).a().a();
        ocd.a(null, "", "0X8009505", "0X8009505", 0, 0, "", this.jdField_a_of_type_Rvs.a(), "", (String)localObject, false);
      }
    }
  }
  
  private void G()
  {
    if (this.jdField_b_of_type_AndroidWidgetSeekBar == null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(true);
    int n = 0;
    if (this.jdField_a_of_type_Rvy != null) {
      n = (int)(this.jdField_a_of_type_Rvy.a() / 1000L);
    }
    this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(n);
  }
  
  private void H()
  {
    int n = 0;
    if (this.jdField_f_of_type_AndroidWidgetTextView != null) {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (this.jdField_g_of_type_AndroidWidgetTextView != null) {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if (this.jdField_a_of_type_AndroidWidgetSeekBar != null)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
      if (this.jdField_a_of_type_Rvy != null) {
        n = (int)(this.jdField_a_of_type_Rvy.a() / 1000L);
      }
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(n);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
    }
  }
  
  private void I()
  {
    int i1 = 0;
    if ((this.jdField_a_of_type_Rwc == null) || (this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video.VideoUIManager", 2, "checkIfHasDownloadInfo(), mVideoDownloadBarInfo == null, mPlayingVideoParam:" + this.jdField_a_of_type_Rwc);
      }
    }
    int n;
    label244:
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo = this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo;
          n = i1;
          if (!this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_style.has()) {
            break label244;
          }
          n = i1;
          if (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_style.get() < 0) {
            break label244;
          }
          this.jdField_k_of_type_Int = this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_style.get();
          if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null)) {
            break;
          }
          this.jdField_k_of_type_Int = 0;
        } while (!QLog.isColorLevel());
        QLog.e("Q.readinjoy.video.VideoUIManager", 2, "checkIfHasDownloadInfo(), 协议字段不合法 1");
        return;
        n = i1;
        if (this.jdField_k_of_type_Int != 1) {
          break label244;
        }
        if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_time.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_time.get() > 0)) {
          break;
        }
        this.jdField_k_of_type_Int = 0;
      } while (!QLog.isColorLevel());
      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "checkIfHasDownloadInfo(), 协议字段不合法 2");
      return;
      n = this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_time.get();
    } while (!QLog.isColorLevel());
    QLog.i("Q.readinjoy.video.VideoUIManager", 2, "checkIfHasDownloadInfo(), mDownloadBarStyle:" + this.jdField_k_of_type_Int + ", appearTime:" + n);
  }
  
  private void J()
  {
    if (this.jdField_g_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.video.VideoUIManager", 2, "checkIfShowDownloadBarPlaying(), mDownloadBarClicked, return");
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Rvy.a() / 1000L < this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_time.get());
      if ((!c()) && (!b()) && (this.jdField_a_of_type_Rvy.a() == 3)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video.VideoUIManager", 2, "checkIfShowDownloadBarPlaying(): failure");
    return;
    h(1);
  }
  
  private void K()
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365704)).inflate();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131362823));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131362824));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    }
    String str = a();
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Object localObject = new URL(str);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImagePlaceHolder(a(this.jdField_a_of_type_AndroidAppActivity, false)).setImage((URL)localObject);
        localObject = b();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.jdField_i_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoUIManager", 2, "showDownloadBarPlaying(), iconUrl:" + str + "，iconText:" + (String)localObject);
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setBackgroundDrawable(a(this.jdField_a_of_type_AndroidAppActivity, false));
    }
  }
  
  private void L()
  {
    Object localObject;
    if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null))
    {
      localObject = (articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get();
      if (((articlesummary.UrlJumpInfo)localObject).uint32_jump_type.get() != 1) {
        break label247;
      }
      if (ozs.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url)) {
        ozs.a(this.jdField_a_of_type_AndroidAppActivity, ozs.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url));
      }
      this.jdField_g_of_type_Boolean = true;
      if ((this.jdField_a_of_type_Rwc != null) && (this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null))
      {
        localObject = "";
        if (this.jdField_k_of_type_Int != 1) {
          break label329;
        }
        localObject = "0X8009BC5";
      }
    }
    for (;;)
    {
      sbg localsbg = new sbg("", this.jdField_a_of_type_Rwc.k, this.jdField_a_of_type_Rwc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
      localsbg.a((int)this.jdField_a_of_type_Rwc.jdField_b_of_type_Long);
      if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null)) {
        localsbg.a(ozs.a(((articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get()).bytes_common_data));
      }
      ocd.a(null, "", (String)localObject, (String)localObject, 0, 0, "3", "", "", localsbg.a().a(), false);
      return;
      label247:
      if (((articlesummary.UrlJumpInfo)localObject).uint32_jump_type.get() != 2) {
        break;
      }
      if ((ozs.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_bundle)) && (bhny.a(this.jdField_a_of_type_AndroidAppActivity, ozs.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_bundle))))
      {
        rpt.a(this.jdField_a_of_type_AndroidAppActivity, ozs.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_schema));
        break;
      }
      if (!ozs.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url)) {
        break;
      }
      ozs.a(this.jdField_a_of_type_AndroidAppActivity, ozs.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url));
      break;
      label329:
      if (this.jdField_k_of_type_Int == 2) {
        localObject = "0X8009BC7";
      }
    }
  }
  
  private void M()
  {
    if (this.jdField_c_of_type_AndroidViewView == null)
    {
      this.jdField_c_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365705)).inflate();
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131362823));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131362824));
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131376508));
      this.l = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131365725));
      this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.l.setOnClickListener(this);
      int n = bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F);
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843134);
      ((Drawable)localObject1).setBounds(0, 0, n, n);
      this.jdField_k_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject1, null, null, null);
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843049);
      ((Drawable)localObject1).setBounds(0, 0, n, n);
      this.l.setCompoundDrawables((Drawable)localObject1, null, null, null);
    }
    Object localObject1 = a();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      try
      {
        Object localObject2 = new URL((String)localObject1);
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImagePlaceHolder(a(this.jdField_a_of_type_AndroidAppActivity, true)).setImage((URL)localObject2);
        localObject2 = b();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.jdField_j_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_b_of_type_AndroidViewView != null) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoUIManager", 2, "showDownloadBarComplete(), iconUrl:" + (String)localObject1 + "，iconText:" + (String)localObject2);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        E();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setBackgroundDrawable(a(this.jdField_a_of_type_AndroidAppActivity, true));
    }
  }
  
  private void N()
  {
    i(1);
    i(2);
  }
  
  private void O()
  {
    if ((this.jdField_a_of_type_Rwc == null) || (this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {
      return;
    }
    if ((rpt.e()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoLogoUrl)))
    {
      Object localObject1 = this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoLogoUrl;
      for (;;)
      {
        try
        {
          if (((String)localObject1).endsWith("zip"))
          {
            localObject1 = pcs.a((String)localObject1);
            ((pcs)localObject1).setRepeatCount(0);
            this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
            ((pcs)localObject1).playAnimation();
            this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        Object localObject2 = new URL(localException);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = new ascz(0, 50, 150);
        localURLDrawableOptions.mPlayGifImage = true;
        localObject2 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      }
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
  }
  
  private static Drawable a(Context paramContext, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = bhgr.a(paramContext, 12.0F);
    }
    for (int n = bhgr.a(paramContext, 60.0F);; n = bhgr.a(paramContext, 28.0F))
    {
      return new asda(-2565928, i1, n, n);
      i1 = bhgr.a(paramContext, 6.0F);
    }
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (ozs.a(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_url))) {
      return ozs.a(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_url);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "getDownloadIconUrl(), null:");
    }
    return null;
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoUIManager.5(this, paramInt, paramString1, paramString2));
  }
  
  private void a(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    paramImageView.setVisibility(0);
    if (rxg.a().c())
    {
      paramImageView.setImageResource(2130843031);
      paramImageView.setContentDescription(anzj.a(2131715204));
      return;
    }
    paramImageView.setImageResource(2130843032);
    paramImageView.setContentDescription(anzj.a(2131715209));
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL)
  {
    ozc.a(paramKandianUrlImageView, paramURL, this.jdField_a_of_type_AndroidAppActivity, false);
  }
  
  private void a(rwc paramrwc, int paramInt, Object paramObject)
  {
    if (paramInt == 3)
    {
      if (a()) {
        b(false);
      }
      e();
      return;
    }
    e();
  }
  
  private void a(boolean paramBoolean, rwc paramrwc1, rwc paramrwc2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.readinjoy.video.VideoUIManager", 2, "onScreenChange   isFullScreen:" + paramBoolean + "  enterPlayParam:" + paramrwc1 + "   exitPlayParam:" + paramrwc2);
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_Rvs;
      int n = sel.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView, paramrwc1);
      this.jdField_c_of_type_Int = n;
      ((rvs)localObject).a(paramrwc1, n);
      t();
      if (this.jdField_a_of_type_JavaUtilList != null) {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          return;
        }
        rxb localrxb = (rxb)((Iterator)localObject).next();
        if (localrxb != null)
        {
          if (paramBoolean)
          {
            localrxb.l();
            continue;
            this.jdField_a_of_type_Rvs.a();
            break;
          }
          localrxb.a(paramrwc1, paramrwc2);
        }
      }
    }
  }
  
  private String b()
  {
    if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (ozs.a(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_text))) {
      return ozs.a(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_text);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "getDownloadIconText(), null:");
    }
    return null;
  }
  
  private void b(rwc paramrwc, int paramInt, Object paramObject)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(103, 1200L);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void c(rwc paramrwc, int paramInt, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1) != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1).getTag() instanceof pmz)))
    {
      paramObject = (pmz)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1).getTag();
      if ((paramObject != null) && (paramObject.jdField_g_of_type_AndroidWidgetTextView != null) && (paramObject.jdField_a_of_type_Int == 0))
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        paramObject.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.e("Q.readinjoy.video.VideoUIManager", 2, "隐藏大王卡引导Textview");
        }
      }
    }
    tqd.a(paramrwc, this, false, this.jdField_a_of_type_Tqf);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841764));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841765));
  }
  
  private void d(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      if (a())
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  private void d(rwc paramrwc, int paramInt, Object paramObject)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(102);
    if (paramInt == 2) {
      if (this.jdField_a_of_type_Rwc.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
        this.jdField_a_of_type_Rwc.jdField_a_of_type_Sab.a().setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165343));
        E();
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 3000L);
        if ((bhnv.b(this.jdField_a_of_type_AndroidAppActivity)) && (!this.jdField_d_of_type_Boolean))
        {
          y();
          this.jdField_d_of_type_Boolean = true;
        }
        a(this.jdField_f_of_type_AndroidWidgetImageView);
        if ((this.jdField_a_of_type_Rwc.jdField_b_of_type_Boolean) && (this.jdField_f_of_type_AndroidWidgetImageView != null)) {
          this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        I();
        O();
      }
    }
    label265:
    do
    {
      do
      {
        do
        {
          return;
          rpt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, 8, 300);
          break;
          if (paramInt == 4)
          {
            E();
            return;
          }
        } while (paramInt != 5);
        if ((e()) && (c()))
        {
          e(2);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
          return;
        }
        if (!d()) {
          break label265;
        }
        A();
      } while (!bhnv.b(this.jdField_a_of_type_AndroidAppActivity));
      y();
      return;
    } while (!this.jdField_a_of_type_Rwc.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void d(boolean paramBoolean)
  {
    if (!g()) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.width = bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 91.0F);
      localLayoutParams.height = bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 28.0F);
      localLayoutParams.rightMargin = bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F);
    }
    for (localLayoutParams.topMargin = bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F);; localLayoutParams.topMargin = bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 8.0F))
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 78.0F);
      localLayoutParams.height = bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 24.0F);
      localLayoutParams.rightMargin = bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 8.0F);
    }
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_Sar.a();
  }
  
  private void e(int paramInt)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      rpt.a(this.jdField_d_of_type_AndroidWidgetTextView, 8, 300);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843196));
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(1));
      } while (e());
      rpt.a(this.jdField_a_of_type_AndroidWidgetImageView, 0, 300);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843194));
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(3));
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843195));
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2));
    } while (e());
    rpt.a(this.jdField_a_of_type_AndroidWidgetImageView, 0, 300);
  }
  
  private void e(rwc paramrwc, int paramInt, Object paramObject)
  {
    if (paramInt == 0)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      A();
      e(3);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
      return;
      if (paramInt == 3) {
        e(3);
      }
    }
  }
  
  private boolean e()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0;
  }
  
  private void f(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetSeekBar.getVisibility() != 0) {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(104);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(104, 1500L);
  }
  
  private void f(rwc paramrwc, int paramInt, Object paramObject)
  {
    if (e()) {
      e(1);
    }
    if (this.jdField_a_of_type_Rwc.jdField_b_of_type_Boolean) {
      e(1);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
  }
  
  private boolean f()
  {
    boolean bool = true;
    switch (this.jdField_k_of_type_Int)
    {
    default: 
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (this.jdField_b_of_type_AndroidViewView == null) {
          break;
        }
      } while (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0);
      return false;
      if (this.jdField_c_of_type_AndroidViewView == null) {
        break;
      }
    } while (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0);
    return false;
  }
  
  private void g(int paramInt)
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != 8) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_e_of_type_AndroidWidgetImageView.getVisibility() != 0)
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130843149);
    }
    if (paramInt == 0) {
      this.jdField_e_of_type_AndroidWidgetImageView.setEnabled(false);
    }
    for (;;)
    {
      if (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 8) {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_g_of_type_AndroidWidgetTextView.getVisibility() != 8) {
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(paramInt);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(105);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(105, 1500L);
      return;
      this.jdField_e_of_type_AndroidWidgetImageView.setEnabled(true);
    }
  }
  
  private void g(rwc paramrwc, int paramInt, Object paramObject)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
    if ((paramObject instanceof int[]))
    {
      paramrwc = (int[])paramObject;
      a(1, rwe.a(paramrwc[0], paramrwc[1]), anzj.a(2131715208));
    }
  }
  
  private boolean g()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void h(int paramInt)
  {
    if (f()) {}
    do
    {
      return;
      if (!this.jdField_g_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video.VideoUIManager", 2, "showDownloadBar(): mDownloadBarClicked, just jump.");
    return;
    label56:
    String str;
    switch (paramInt)
    {
    default: 
      if ((this.jdField_a_of_type_Rwc != null) && (this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null))
      {
        str = "";
        if (this.jdField_k_of_type_Int != 1) {
          break label270;
        }
        str = "0X8009BC4";
      }
      break;
    }
    for (;;)
    {
      sbg localsbg = new sbg("", this.jdField_a_of_type_Rwc.k, this.jdField_a_of_type_Rwc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
      localsbg.a((int)this.jdField_a_of_type_Rwc.jdField_b_of_type_Long);
      if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null)) {
        localsbg.a(ozs.a(((articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get()).bytes_common_data));
      }
      ocd.a(null, "", str, str, 0, 0, "3", "", "", localsbg.a().a(), false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "showDownloadBar(), barStyle:" + paramInt);
      return;
      K();
      break label56;
      M();
      break label56;
      label270:
      if (this.jdField_k_of_type_Int == 2) {
        str = "0X8009BC6";
      }
    }
  }
  
  private void h(rwc paramrwc, int paramInt, Object paramObject)
  {
    boolean bool = true;
    if ((!ozc.a(paramrwc)) && (this.jdField_a_of_type_Rvs.a()) && (this.jdField_a_of_type_Rwc.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_Rvs.a(paramrwc);
      return;
    }
    if (this.jdField_k_of_type_Int == 2)
    {
      rmn.jdField_c_of_type_Boolean = true;
      h(2);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      label64:
      if (paramrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.patchStatus.a.get() == 1) {
        break label150;
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getFirstVisiblePosition() != 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1) == null) || (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1).getTag() instanceof pmz))) {
        break label152;
      }
    }
    for (;;)
    {
      tqd.a(paramrwc, this, bool, false, this.jdField_a_of_type_Rxa, this.jdField_a_of_type_Rvs, this.jdField_a_of_type_Tqf);
      return;
      b(false);
      e();
      break label64;
      label150:
      break;
      label152:
      bool = false;
    }
  }
  
  private void i(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_AndroidViewView == null);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    } while (this.jdField_c_of_type_AndroidViewView == null);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void o()
  {
    rmn.jdField_c_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo = null;
    this.jdField_k_of_type_Int = 0;
  }
  
  private void p()
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131380872));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131370404));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367489));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131378993));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131378936));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131379020);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365785));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131368320));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372762));
    this.m = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372177));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372119));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372120));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131369574));
    this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372176));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131370643));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367324));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367321));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367323));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131373071));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131368724));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365787));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367322));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setSeekBar(this.jdField_a_of_type_AndroidWidgetSeekBar);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoBrightnessController(this.jdField_a_of_type_Rmr);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131381022));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131381021));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131381019));
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView = ((ReadInJoyPatchAdView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372315));
    q();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar = ((ReadInJoyVideoAdHighLightBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131368036));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide = ((ReadInJoyAdVideoGuide)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131362026));
    zps.a(this.jdField_f_of_type_AndroidWidgetImageView, 10, 10, 10, 10);
    zps.a(this.jdField_d_of_type_AndroidWidgetImageView, 20, 20, 20, 20);
    rxg.a().a(this.jdField_f_of_type_AndroidWidgetImageView);
    rxg.a().a(this.jdField_d_of_type_AndroidWidgetImageView);
    this.jdField_e_of_type_Boolean = true;
  }
  
  private void q()
  {
    this.jdField_a_of_type_Tqf = new rwy(this);
    tqd.a(this.jdField_a_of_type_AndroidAppActivity, this, this.jdField_a_of_type_Rvy, this.jdField_a_of_type_Rvs, this.jdField_a_of_type_Rxa, this.jdField_a_of_type_Tqf);
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_Rwc == null) {}
    while (!(this.jdField_a_of_type_AndroidWidgetFrameLayout instanceof RoundAngleFrameLayout)) {
      return;
    }
    ((RoundAngleFrameLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout).setRadius(this.jdField_a_of_type_Rwc.o, this.jdField_a_of_type_Rwc.p, this.jdField_a_of_type_Rwc.q, this.jdField_a_of_type_Rwc.r);
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout instanceof RoundAngleFrameLayout)) {
      ((RoundAngleFrameLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout).setRadius(0, 0, 0, 0);
    }
  }
  
  private void t()
  {
    if (a())
    {
      s();
      return;
    }
    r();
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_Rwc == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoUIManager", 2, "innerConfigVideoUI() mPlayingVideoParam == null ERROR");
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    this.jdField_h_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167302));
    if (this.jdField_a_of_type_Rwc.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoPlayCount == 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(ozc.a(this.jdField_a_of_type_Rwc.jdField_b_of_type_Int, true));
      pms.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_Rwc);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getVideoCoverUrlWithSmartCut(false));
      if (this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize > 0L) {
        break label523;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(anzj.a(2131715202));
      label221:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(this.jdField_a_of_type_Rwc.jdField_b_of_type_Long);
      if (!bhnv.h(this.jdField_a_of_type_AndroidAppActivity)) {
        break label568;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843196));
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(1));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      f();
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(this.jdField_a_of_type_Rwc.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(this.jdField_a_of_type_Rwc.jdField_b_of_type_Int);
      D();
      d(this.jdField_a_of_type_Rwc.n);
      t();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      if (this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.patchStatus.a.get() != 1) {
        tqd.a(this);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a() != null) && (this.jdField_a_of_type_Rwc != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.d();
      }
      tpe.a.a(this.jdField_a_of_type_Rwc, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar);
      tpe.a.a(this.jdField_a_of_type_Rwc, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide);
      tpe.a.a(this.jdField_a_of_type_Rwc);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(rpt.c(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoPlayCount) + anzj.a(2131715203));
      break;
      label523:
      this.jdField_d_of_type_AndroidWidgetTextView.setText(rpt.b(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize) + anzj.a(2131715206));
      break label221;
      label568:
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      Drawable localDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843132);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(agej.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      if (bihq.a() == 1) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(anzj.a(2131715201));
      }
    }
  }
  
  private void v()
  {
    this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup;
  }
  
  private void w()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setTranslationY(0.0F);
    B();
    l();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.a(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
    this.jdField_a_of_type_Rvy.a(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-16777216);
    d(true);
  }
  
  private void x()
  {
    Object localObject = this.jdField_a_of_type_Rvy.a();
    String str1;
    String str2;
    if (localObject != null)
    {
      localObject = ((rwc)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if (localObject != null)
      {
        str1 = new sbg(null, ((BaseArticleInfo)localObject).getSubscribeUin(), ((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).getInnerUniqueID(), this.jdField_a_of_type_Rvy.a(), ((BaseArticleInfo)localObject).getVideoDuration() * 1000L).a((int)((BaseArticleInfo)localObject).mChannelID).a().a();
        str2 = ((BaseArticleInfo)localObject).getSubscribeUin();
        if (TextUtils.isEmpty(((BaseArticleInfo)localObject).getInnerUniqueID())) {
          break label115;
        }
      }
    }
    label115:
    for (localObject = ((BaseArticleInfo)localObject).getInnerUniqueID();; localObject = "0")
    {
      ocd.a(null, str2, "0X8007411", "0X8007411", 0, 0, "0", "", (String)localObject, str1, false);
      return;
    }
  }
  
  private void y()
  {
    if ((this.jdField_a_of_type_Rwc == null) || (this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Rwc.jdField_a_of_type_AndroidViewView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.readinjoy.video.VideoUIManager", 2, "showXGToast failed for mPlayingVideoParam.feedsVideoCover is null");
    return;
    String str;
    if (bihq.a() == 1) {
      str = anzj.a(2131715205);
    }
    for (;;)
    {
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_Rwc.jdField_a_of_type_AndroidViewView.getLocationOnScreen(arrayOfInt);
      int n = arrayOfInt[1] - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
      n = (n + (this.jdField_a_of_type_Rwc.jdField_a_of_type_AndroidViewView.getHeight() + n) - bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 40.0F)) / 2;
      rpt.a(this.jdField_a_of_type_AndroidAppActivity, str, n);
      return;
      if (this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize > 0L) {
        str = anzj.a(2131715200) + rpt.b(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize);
      } else {
        str = anzj.a(2131715199);
      }
    }
  }
  
  private void z()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.clearAnimation();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getVideoCoverUrlWithSmartCut(false));
  }
  
  public ReadInJoyAdVideoGuide a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide;
  }
  
  public ReadInJoyPatchAdView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView;
  }
  
  public ReadInJoyVideoAdHighLightBar a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar;
  }
  
  public rwc a()
  {
    return this.jdField_a_of_type_Rwc;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rvs.c();
    if (this.jdField_g_of_type_Boolean) {
      i(1);
    }
    if (a() != null)
    {
      BaseArticleInfo localBaseArticleInfo = a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if (((tqd.c(localBaseArticleInfo)) || (tqd.d(localBaseArticleInfo))) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.b();
      }
      if (tqd.a(localBaseArticleInfo)) {
        this.jdField_a_of_type_Rvy.a(a());
      }
      if ((tqd.b(localBaseArticleInfo)) && (this.jdField_a_of_type_Rxa != null))
      {
        this.jdField_a_of_type_Rxa.a(a());
        this.jdField_a_of_type_Rvs.c();
      }
    }
    tpe.a.a(this.jdField_a_of_type_Rwc, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar);
    tpe.a.b(this.jdField_a_of_type_Rwc, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "onOrientationChanged=> orientation=" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      b(false);
      return;
    case 0: 
      b(0);
      return;
    case 8: 
      b(8);
      return;
    }
    b(false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {}
    int n;
    do
    {
      do
      {
        return;
        n = this.jdField_a_of_type_Rvy.a();
        if ((n != 0) && (n != 1) && (n != 7) && (n != 2) && (n != 4)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "innerEnterFullScreen => playState=" + rwe.a(n) + ", illegal state just ignore fullscreen.");
      return;
    } while (this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_Boolean = true;
    a(true, this.jdField_a_of_type_Rvy.a(), null);
    c(true);
    this.jdField_i_of_type_Int = this.jdField_a_of_type_Rvy.b();
    if ((paramBoolean) && (ozc.a(this.jdField_a_of_type_Rwc))) {
      if (this.jdField_a_of_type_Rlu.a(false)) {
        this.jdField_c_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      Window localWindow = this.jdField_a_of_type_AndroidAppActivity.getWindow();
      localWindow.setFlags(1024, 1024);
      if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent() instanceof ViewGroup)))
      {
        this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent());
        this.jdField_j_of_type_Int = this.jdField_a_of_type_AndroidViewViewGroup.indexOfChild(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        this.jdField_a_of_type_Rwc.jdField_a_of_type_Sab.a();
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        this.jdField_a_of_type_Rwc.jdField_a_of_type_Sab.b();
        localWindow.addContentView(this.jdField_a_of_type_AndroidWidgetFrameLayout, new ViewGroup.LayoutParams(-1, -1));
      }
      this.jdField_g_of_type_Int = this.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth();
      this.jdField_h_of_type_Int = this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoUIManager", 2, "FullScreen => mOriginalWidth=" + this.jdField_g_of_type_Int + ", mOriginalHeight=" + this.jdField_h_of_type_Int + ", playState=" + rwe.a(n) + "，userClickEnter:" + paramBoolean);
      }
      w();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setTranslationY(0.0F);
      x();
      return;
      if (paramInt == 0) {
        this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(0);
      } else {
        this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(8);
      }
    }
  }
  
  public void a(View paramView)
  {
    if (c())
    {
      l();
      return;
    }
    k();
  }
  
  public void a(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!c());
        l();
      } while (!this.jdField_a_of_type_Rvy.d());
      this.jdField_f_of_type_Boolean = true;
      return;
    } while (!this.jdField_f_of_type_Boolean);
    k();
    this.jdField_f_of_type_Boolean = false;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2) {}
  
  public void a(AbsListView paramAbsListView)
  {
    if (a()) {}
    int i2;
    int i1;
    int n;
    do
    {
      do
      {
        return;
        i2 = ((ReadInJoyBaseListView)paramAbsListView).getHeaderViewsCount();
        i1 = paramAbsListView.getFirstVisiblePosition() - i2;
        n = i1;
        if (i1 < 0) {
          n = 0;
        }
        i1 = paramAbsListView.getLastVisiblePosition() - i2;
      } while ((this.jdField_a_of_type_Rvy == null) || (this.jdField_a_of_type_Rvy.a() == null));
      i2 = this.jdField_a_of_type_Rvy.a().jdField_a_of_type_Int;
    } while ((i2 < 0) || ((i2 >= n) && (i2 <= i1)));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "triggerVideoRecycleCheck => stop video，firstVisblePosi:" + n + ",lastVisiblePosi:" + i1 + ",playingPosi:" + i2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "triggerVideoRecycleCheck => stop video，playParam:" + this.jdField_a_of_type_Rvy.a());
    }
    this.jdField_a_of_type_Rvy.b(10);
  }
  
  public void a(rvv paramrvv)
  {
    this.jdField_a_of_type_Rvs.a(paramrvv);
  }
  
  public void a(rvy paramrvy)
  {
    this.jdField_a_of_type_Rvy = paramrvy;
    this.jdField_a_of_type_Rvy.a(this);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367489));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(this.jdField_a_of_type_Rvy.c());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(paramrvy);
    this.jdField_a_of_type_Rvs.a(paramrvy);
  }
  
  public void a(rwc paramrwc)
  {
    this.jdField_a_of_type_Rwc = paramrwc;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "playVideo(): videoPlayParam=" + paramrwc);
    }
    if ((this.jdField_a_of_type_Rwc != null) && (this.jdField_a_of_type_Rwc.jdField_b_of_type_Boolean))
    {
      a(false);
      this.jdField_c_of_type_Boolean = false;
    }
    p();
    u();
    v();
    g();
  }
  
  public void a(rwc paramrwc, rwf paramrwf, int paramInt1, int paramInt2, Object paramObject)
  {
    if ((this.jdField_a_of_type_Rwc == null) || (paramrwc == null) || (this.jdField_a_of_type_Rwc != paramrwc)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video.VideoUIManager", 2, "onStateChange(): mPlayingVideoParam and videoPlayParam not equal, just return;");
      }
    }
    do
    {
      return;
      if (paramInt2 == 0)
      {
        a(paramrwc, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 1)
      {
        b(paramrwc, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 2)
      {
        c(paramrwc, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 3)
      {
        d(paramrwc, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 4)
      {
        e(paramrwc, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 5)
      {
        f(paramrwc, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 6)
      {
        g(paramrwc, paramInt1, paramObject);
        return;
      }
    } while (paramInt2 != 7);
    h(paramrwc, paramInt1, paramObject);
  }
  
  public void a(rwf paramrwf, rwc paramrwc) {}
  
  public void a(rxa paramrxa)
  {
    this.jdField_a_of_type_Rxa = paramrxa;
  }
  
  public void a(rxb paramrxb)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramrxb)) {
      this.jdField_a_of_type_JavaUtilList.add(paramrxb);
    }
  }
  
  public void a(rxc paramrxc)
  {
    this.jdField_a_of_type_Rxc = paramrxc;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Rlu != null) {
      this.jdField_a_of_type_Rlu.a(paramBoolean);
    }
    if ((this.jdField_a_of_type_Rlu != null) && (this.jdField_a_of_type_Rwc != null) && (this.jdField_a_of_type_Rwc.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_Rlu.a(false);
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {
      return false;
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Rvs.d();
  }
  
  public void b(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void b(View paramView) {}
  
  public void b(rxc paramrxc)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramrxc);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {}
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Rvs.b();
    c(false);
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    ((Window)localObject).clearFlags(1024);
    ((Window)localObject).addFlags(this.jdField_a_of_type_Int);
    ((Window)localObject).getDecorView().setSystemUiVisibility(this.jdField_b_of_type_Int);
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent() instanceof ViewGroup)))
    {
      this.jdField_a_of_type_Rwc.jdField_a_of_type_Sab.a();
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      this.jdField_a_of_type_Rwc.jdField_a_of_type_Sab.b();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_j_of_type_Int, new ViewGroup.LayoutParams(-1, -1));
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    l();
    localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.jdField_g_of_type_Int;
    ((ViewGroup.LayoutParams)localObject).height = this.jdField_h_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.a(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_Rlu.a(true);
    }
    this.jdField_a_of_type_Rvy.a(this.jdField_i_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
    if ((this.jdField_a_of_type_Rvs.a() != null) && ((this.jdField_a_of_type_Rvs.a() instanceof rwc))) {
      a(false, (rwc)this.jdField_a_of_type_Rvs.a(), this.jdField_a_of_type_Rwc);
    }
    d(false);
    if (paramBoolean) {
      F();
    }
    f();
    g();
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {}
    while (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.c();
    }
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidWidgetSeekBar == null) || (this.jdField_a_of_type_Rwc == null)) {
      return;
    }
    rxg.a().a(paramInt);
    paramInt = (int)(rxg.a().a() * this.jdField_a_of_type_Rwc.jdField_b_of_type_Int);
    if (c())
    {
      g(paramInt);
      return;
    }
    f(paramInt);
  }
  
  public void c(View paramView)
  {
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof pmw))) {}
    do
    {
      pmw localpmw;
      do
      {
        int n;
        do
        {
          do
          {
            do
            {
              return;
              n = this.jdField_a_of_type_Rvy.a();
              localpmw = (pmw)paramView.getTag();
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  playState=" + rwe.a(n) + ", view id: " + rpt.a(paramView));
              }
              if ((n != 7) || (!f())) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.w("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  complete && isDownloadBarShowing, just return.");
            return;
            if (this.jdField_a_of_type_Rvy.a() != null) {
              break;
            }
            if (!rmn.a().a()) {
              rxg.a().a(false, "noAutoPlayClickVideoInReadInjoy", 1);
            }
            this.jdField_a_of_type_Rvy.a(localpmw.a());
            paramView = localpmw.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
          } while ((paramView == null) || (paramView.mChannelID != 56L) || (!AdvertisementInfo.isAdvertisementInfo(paramView)));
          ((AdvertisementInfo)paramView).adbt = ((int)localpmw.a().jdField_d_of_type_Long);
          ((AdvertisementInfo)paramView).adpa = 1;
          ((AdvertisementInfo)paramView).adpb = 2;
          nzq.a(new tlx().a(this.jdField_a_of_type_AndroidAppActivity).a(nzq.jdField_f_of_type_Int).b(nzq.O).a((AdvertisementInfo)paramView).a(nzq.a(((AdvertisementInfo)paramView).adbt, 0, ((AdvertisementInfo)paramView).getAdbf(), 0, 1, 2, paramView.mVideoDuration, nzq.aP, 0)).a());
          return;
          if (this.jdField_a_of_type_Rvy.b() != localpmw.a().jdField_c_of_type_Long) {
            break;
          }
        } while (n == 1);
        if ((n != 5) || (!d())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  paused && isErrorLayoutShowing, just return.");
      return;
      if (c())
      {
        l();
        return;
      }
      k();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  点击非当前播放的视频feeds，播放点击的视频");
      }
      this.jdField_a_of_type_Rvy.b(2);
      this.jdField_a_of_type_Rvy.a(localpmw.a());
      paramView = localpmw.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((paramView != null) && (paramView.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(paramView)))
      {
        nzq.a(new tlx().a(this.jdField_a_of_type_AndroidAppActivity).a(nzq.jdField_f_of_type_Int).b(nzq.O).a((AdvertisementInfo)paramView).a(nzq.a(0, 0, 1, 0, 1, 2, paramView.mVideoDuration, nzq.aP, 0)).a());
        ((AdvertisementInfo)paramView).adbt = 0;
        ((AdvertisementInfo)paramView).adpa = 1;
        ((AdvertisementInfo)paramView).adpb = 2;
      }
    } while (rmn.a().a());
    rxg.a().a(false, "noAutoPlayClickVideoInReadInjoy", 1);
  }
  
  public void c(rxc paramrxc)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramrxc);
  }
  
  public boolean c()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {}
    while (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.c();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    o();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "updateVideoViewSize");
    }
    if (this.jdField_a_of_type_Rwc == null) {
      return;
    }
    float f1 = bhlo.b(this.jdField_a_of_type_AndroidAppActivity);
    if (this.jdField_a_of_type_Rwc.jdField_b_of_type_Boolean) {
      if (this.jdField_a_of_type_Rwc.l > 0) {
        f1 = this.jdField_a_of_type_Rwc.l;
      }
    }
    float f2;
    for (;;)
    {
      f2 = f1 * ozc.a(this.jdField_a_of_type_Rwc.jdField_c_of_type_Int, this.jdField_a_of_type_Rwc.jdField_d_of_type_Int);
      if (!this.jdField_a_of_type_Rvs.a()) {
        break;
      }
      this.jdField_g_of_type_Int = ((int)f1);
      this.jdField_h_of_type_Int = ((int)f2);
      w();
      return;
      continue;
      f1 = ozc.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Rwc);
    }
    Object localObject;
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams() instanceof FrameLayout.LayoutParams))
    {
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = ((int)f1);
      ((FrameLayout.LayoutParams)localObject).height = ((int)f2);
      ((FrameLayout.LayoutParams)localObject).gravity = 1;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.a(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, ozc.a(this.jdField_a_of_type_Rwc.jdField_c_of_type_Int, this.jdField_a_of_type_Rwc.jdField_d_of_type_Int));
      return;
      if ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams))
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).width = ((int)f1);
        ((RelativeLayout.LayoutParams)localObject).height = ((int)f2);
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  @TargetApi(11)
  public void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {}
    int n;
    do
    {
      do
      {
        return;
      } while ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Rwc == null) || (this.jdField_a_of_type_Rwc.jdField_a_of_type_AndroidViewView == null));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      this.jdField_f_of_type_Int = this.jdField_a_of_type_ArrayOfInt[1];
      this.jdField_a_of_type_Rwc.jdField_a_of_type_AndroidViewView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      n = this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_f_of_type_Int;
    } while (n == this.jdField_a_of_type_AndroidWidgetFrameLayout.getTranslationY());
    aqoh.f(this.jdField_a_of_type_AndroidWidgetFrameLayout, n);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
  }
  
  public void i()
  {
    a(0, true);
  }
  
  public void j()
  {
    b(true);
  }
  
  public void k()
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
      return;
    }
    int n;
    if (a())
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      n = this.jdField_a_of_type_Rvy.a();
      if (n != 5) {
        break label232;
      }
      e(1);
      label69:
      this.jdField_a_of_type_Sar.a();
      rpt.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 0, 300);
      if (!this.jdField_a_of_type_Boolean)
      {
        zps.a(this.jdField_b_of_type_AndroidWidgetImageView, 10, 10, 10, 10);
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      N();
      if (n != 5) {
        break label245;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new VideoUIManager.6(this));
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        rpt.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0, 300);
      }
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      a(this.jdField_d_of_type_AndroidWidgetImageView);
      break;
      label232:
      if (n != 3) {
        break label69;
      }
      e(2);
      break label69;
      label245:
      if (n == 3)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
      }
    }
  }
  
  public void l()
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {
      return;
    }
    rpt.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8, 300);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    rpt.a(this.jdField_a_of_type_AndroidWidgetImageView, 8, 300);
    rpt.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 8, 300);
    if ((a()) || (7 == this.jdField_a_of_type_Rvy.a())) {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
      return;
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
    }
  }
  
  public void m()
  {
    a(0, anzj.a(2131715210), rpt.b(this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize) + anzj.a(2131715207));
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Rvs != null)
    {
      this.jdField_a_of_type_Rvs.e();
      this.jdField_a_of_type_Rvs = null;
    }
    this.jdField_a_of_type_Rvy.b(this);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Rwc = null;
    if (this.jdField_a_of_type_Rlu != null)
    {
      this.jdField_a_of_type_Rlu.a();
      this.jdField_a_of_type_Rlu = null;
    }
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_Rmr != null) {
      this.jdField_a_of_type_Rmr.b();
    }
    if (this.jdField_a_of_type_Tqf != null) {
      this.jdField_a_of_type_Tqf = null;
    }
  }
  
  public void onClick(View paramView)
  {
    int n = 0;
    int i1 = this.jdField_a_of_type_Rvy.a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "onClick(): current playState=" + rwe.a(i1) + ", view id: " + rpt.a(paramView));
    }
    if (paramView.getId() == 2131367322) {
      if (a())
      {
        b(false);
        ThreadManager.executeOnSubThread(new VideoUIManager.8(this));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i();
      break;
      if (paramView.getId() == 2131372119)
      {
        i1 = ((Integer)paramView.getTag()).intValue();
        switch (i1)
        {
        }
        for (;;)
        {
          if (2 == i1) {
            n = 1;
          }
          ThreadManager.executeOnSubThread(new VideoUIManager.9(this, n));
          break;
          if (!rmn.a().a()) {
            rxg.a().a(false, "noAutoPlayClickVideoInReadInjoy", 1);
          }
          this.jdField_a_of_type_Rvy.f(true);
          continue;
          this.jdField_a_of_type_Rvy.e(true);
        }
      }
      if (paramView.getId() == 2131366109)
      {
        if (this.jdField_a_of_type_Rvy.d())
        {
          this.jdField_a_of_type_Rvy.f(true);
        }
        else if ((this.jdField_a_of_type_Rvy.a() == 6) && (this.jdField_a_of_type_Rwc != null))
        {
          sas.b(this.jdField_a_of_type_Rwc.a(), 0);
          this.jdField_a_of_type_Rvy.a(this.jdField_a_of_type_Rwc);
        }
      }
      else if (paramView.getId() == 2131367321)
      {
        j();
      }
      else
      {
        label340:
        Object localObject;
        if ((paramView.getId() == 2131381021) || (paramView.getId() == 2131381022))
        {
          boolean bool;
          sbg localsbg;
          if (!rxg.a().c())
          {
            bool = true;
            rxg.a().a(bool, "user click audio btn", 1);
            if ((this.jdField_a_of_type_Rwc == null) || (this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {
              continue;
            }
            localsbg = new sbg("", this.jdField_a_of_type_Rwc.k, this.jdField_a_of_type_Rwc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
            localsbg.a((int)this.jdField_a_of_type_Rwc.jdField_b_of_type_Long);
            if (!bool) {
              break label482;
            }
          }
          label482:
          for (localObject = "1";; localObject = "0")
          {
            localsbg.a("status", localObject);
            ocd.a(null, "", "0X8009BD6", "0X8009BD6", 0, 0, "3", "", "", localsbg.a().a(), false);
            break;
            bool = false;
            break label340;
          }
        }
        else if (paramView.getId() == 2131376508)
        {
          this.jdField_a_of_type_Sar.a();
          this.jdField_a_of_type_Rvy.a(this.jdField_a_of_type_Rwc);
          if ((this.jdField_a_of_type_Rwc != null) && (this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null))
          {
            localObject = new sbg("", this.jdField_a_of_type_Rwc.k, this.jdField_a_of_type_Rwc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
            ((sbg)localObject).a((int)this.jdField_a_of_type_Rwc.jdField_b_of_type_Long);
            ocd.a(null, "", "0X8009BC8", "0X8009BC8", 0, 0, "3", "", "", ((sbg)localObject).a().a(), false);
          }
        }
        else if ((paramView.getId() == 2131365725) || (paramView.getId() == 2131365731))
        {
          L();
        }
        else if ((paramView.getId() == 2131380909) && (this.jdField_a_of_type_Rwc != null) && (this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null))
        {
          if (a()) {
            b(false);
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new VideoUIManager.10(this));
          sas.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Rvy.a(this.jdField_a_of_type_Rwc.a()), 0, 0);
          sas.a(this.jdField_a_of_type_Rwc.a(), 0, 0);
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = paramInt1 + paramInt2 - 1;
    if (((this.jdField_d_of_type_Int != -1) && (this.jdField_d_of_type_Int != paramInt1)) || ((this.jdField_e_of_type_Int != -1) && (this.jdField_e_of_type_Int != paramInt2))) {
      a(paramAbsListView);
    }
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = paramInt2;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      a(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwu
 * JD-Core Version:    0.7.0.1
 */