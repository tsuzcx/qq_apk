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
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.helpers.ViewHelper;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;

public class sqd
  implements View.OnClickListener, AbsListView.OnScrollListener, sfm, sin, spi
{
  protected int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new sqe(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new sqi(this);
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
  private ArrayList<sql> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private List<sqk> jdField_a_of_type_JavaUtilList;
  private sfk jdField_a_of_type_Sfk;
  private sgi jdField_a_of_type_Sgi;
  private spa jdField_a_of_type_Spa;
  private spg jdField_a_of_type_Spg;
  private spk jdField_a_of_type_Spk;
  private sqj jdField_a_of_type_Sqj;
  private sql jdField_a_of_type_Sql;
  private suf jdField_a_of_type_Suf;
  private articlesummary.VideoDownloadBarInfo jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo;
  public ukx a;
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
  
  public sqd(FrameLayout paramFrameLayout, ReadInJoyBaseListView paramReadInJoyBaseListView, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView = paramReadInJoyBaseListView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Suf = new suf(this.jdField_a_of_type_AndroidWidgetFrameLayout, this);
    this.jdField_a_of_type_Spa = new spa(paramActivity, this.jdField_a_of_type_AndroidWidgetFrameLayout, new sqf(this));
    this.jdField_a_of_type_Sfk = new sfk(this.jdField_a_of_type_AndroidAppActivity, this);
    this.jdField_a_of_type_Sgi = new sgi(paramActivity);
    paramFrameLayout = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    this.jdField_a_of_type_Int = paramFrameLayout.getAttributes().flags;
    this.jdField_b_of_type_Int = paramFrameLayout.getDecorView().getSystemUiVisibility();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.setScrollEventCallback(new sqg(this));
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(1000L);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatMode(1);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setStartTime(-1L);
    paramFrameLayout = new LinearInterpolator();
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setInterpolator(paramFrameLayout);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131379027);
  }
  
  private void A()
  {
    this.jdField_a_of_type_Suf.b();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
  }
  
  private void B()
  {
    six.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8, 300);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    six.a(this.jdField_a_of_type_AndroidWidgetImageView, 8, 300);
    if (a()) {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    }
    for (;;)
    {
      if (!six.d()) {
        six.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8, 300);
      }
      return;
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
    }
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_Spg != null) {}
    for (int n = (int)(this.jdField_a_of_type_Spg.a() / 1000L);; n = 0)
    {
      uhy.a(n, this.jdField_a_of_type_Spg);
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
        this.jdField_f_of_type_AndroidWidgetTextView.setText(pjr.a(n, false));
      }
      if ((this.jdField_a_of_type_Sql != null) && (this.jdField_a_of_type_Spk != null) && (this.jdField_a_of_type_Spg != null)) {
        this.jdField_a_of_type_Sql.a(this.jdField_a_of_type_Spg.a(), (int)this.jdField_a_of_type_Spg.a(), this.jdField_a_of_type_Spk.jdField_b_of_type_Int * 1000);
      }
      if ((this.jdField_a_of_type_Spk != null) && (this.jdField_a_of_type_Spg != null))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((sql)localIterator.next()).a(this.jdField_a_of_type_Spg.a(), (int)this.jdField_a_of_type_Spg.a(), this.jdField_a_of_type_Spk.jdField_b_of_type_Int * 1000);
        }
        a(this.jdField_a_of_type_Spg.a(this.jdField_a_of_type_Spk.a()), this.jdField_a_of_type_Spk);
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
    O();
    H();
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
    if ((this.jdField_a_of_type_Spk != null) && (this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null))
    {
      if (a()) {
        b(false);
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoUIManager.10(this));
      sug.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Spg.a(this.jdField_a_of_type_Spk.a()), 0, 0);
      sug.a(this.jdField_a_of_type_Spk.a(), 0, 0);
    }
  }
  
  private void G()
  {
    if (this.jdField_a_of_type_Spk != null)
    {
      Object localObject = this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if (localObject != null)
      {
        localObject = new suu(null, this.jdField_a_of_type_Spk.k, ((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).getInnerUniqueID()).a((int)((BaseArticleInfo)localObject).mChannelID).a().a();
        olh.a(null, "", "0X8009505", "0X8009505", 0, 0, "", this.jdField_a_of_type_Spa.a(), "", (String)localObject, false);
      }
    }
  }
  
  private void H()
  {
    if (this.jdField_b_of_type_AndroidWidgetSeekBar == null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(true);
    int n = 0;
    if (this.jdField_a_of_type_Spg != null) {
      n = (int)(this.jdField_a_of_type_Spg.a() / 1000L);
    }
    this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(n);
  }
  
  private void I()
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
      if (this.jdField_a_of_type_Spg != null) {
        n = (int)(this.jdField_a_of_type_Spg.a() / 1000L);
      }
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(n);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
    }
  }
  
  private void J()
  {
    int i1 = 0;
    if ((this.jdField_a_of_type_Spk == null) || (this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video.VideoUIManager", 2, "checkIfHasDownloadInfo(), mVideoDownloadBarInfo == null, mPlayingVideoParam:" + this.jdField_a_of_type_Spk);
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
          this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo = this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo;
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
  
  private void K()
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
      } while (this.jdField_a_of_type_Spg.a() / 1000L < this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_time.get());
      if ((!c()) && (!b()) && (this.jdField_a_of_type_Spg.a() == 3)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video.VideoUIManager", 2, "checkIfShowDownloadBarPlaying(): failure");
    return;
    h(1);
  }
  
  private void L()
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365831)).inflate();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131362847));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131362848));
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
  
  private void M()
  {
    Object localObject;
    if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null))
    {
      localObject = (articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get();
      if (((articlesummary.UrlJumpInfo)localObject).uint32_jump_type.get() != 1) {
        break label248;
      }
      if (qxl.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url)) {
        pkh.a(this.jdField_a_of_type_AndroidAppActivity, qxl.b(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url));
      }
      this.jdField_g_of_type_Boolean = true;
      if ((this.jdField_a_of_type_Spk != null) && (this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null))
      {
        localObject = "";
        if (this.jdField_k_of_type_Int != 1) {
          break label331;
        }
        localObject = "0X8009BC5";
      }
    }
    for (;;)
    {
      suu localsuu = new suu("", this.jdField_a_of_type_Spk.k, this.jdField_a_of_type_Spk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
      localsuu.a((int)this.jdField_a_of_type_Spk.jdField_b_of_type_Long);
      if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null)) {
        localsuu.a(qxl.b(((articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get()).bytes_common_data));
      }
      olh.a(null, "", (String)localObject, (String)localObject, 0, 0, "3", "", "", localsuu.a().a(), false);
      return;
      label248:
      if (((articlesummary.UrlJumpInfo)localObject).uint32_jump_type.get() != 2) {
        break;
      }
      if ((qxl.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_bundle)) && (bhfn.a(this.jdField_a_of_type_AndroidAppActivity, qxl.b(((articlesummary.UrlJumpInfo)localObject).bytes_jump_bundle))))
      {
        six.a(this.jdField_a_of_type_AndroidAppActivity, qxl.b(((articlesummary.UrlJumpInfo)localObject).bytes_jump_schema));
        break;
      }
      if (!qxl.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url)) {
        break;
      }
      pkh.a(this.jdField_a_of_type_AndroidAppActivity, qxl.b(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url));
      break;
      label331:
      if (this.jdField_k_of_type_Int == 2) {
        localObject = "0X8009BC7";
      }
    }
  }
  
  private void N()
  {
    if (this.jdField_c_of_type_AndroidViewView == null)
    {
      this.jdField_c_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365832)).inflate();
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131362847));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131362848));
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131376531));
      this.l = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131365854));
      this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.l.setOnClickListener(this);
      int n = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 16.0F);
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843228);
      ((Drawable)localObject1).setBounds(0, 0, n, n);
      this.jdField_k_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject1, null, null, null);
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843139);
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
  
  private void O()
  {
    i(1);
    i(2);
  }
  
  private void P()
  {
    if ((this.jdField_a_of_type_Spk == null) || (this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {
      return;
    }
    if ((six.e()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoLogoUrl)))
    {
      Object localObject1 = this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoLogoUrl;
      for (;;)
      {
        try
        {
          if (((String)localObject1).endsWith("zip"))
          {
            localObject1 = pta.a((String)localObject1);
            ((pta)localObject1).setRepeatCount(0);
            this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
            ((pta)localObject1).playAnimation();
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
        localURLDrawableOptions.mLoadingDrawable = new asbg(0, 50, 150);
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
      i1 = DisplayUtil.dip2px(paramContext, 12.0F);
    }
    for (int n = DisplayUtil.dip2px(paramContext, 60.0F);; n = DisplayUtil.dip2px(paramContext, 28.0F))
    {
      return new asbh(-2565928, i1, n, n);
      i1 = DisplayUtil.dip2px(paramContext, 6.0F);
    }
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (qxl.a(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_url))) {
      return qxl.b(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_url);
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
    if (sqp.a().c())
    {
      paramImageView.setImageResource(2130843121);
      paramImageView.setContentDescription(anvx.a(2131715786));
      return;
    }
    paramImageView.setImageResource(2130843122);
    paramImageView.setContentDescription(anvx.a(2131715791));
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL)
  {
    pjr.a(paramKandianUrlImageView, paramURL, this.jdField_a_of_type_AndroidAppActivity, false);
  }
  
  private void a(spk paramspk, int paramInt, Object paramObject)
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
  
  private void a(boolean paramBoolean, spk paramspk1, spk paramspk2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.readinjoy.video.VideoUIManager", 2, "onScreenChange   isFullScreen:" + paramBoolean + "  enterPlayParam:" + paramspk1 + "   exitPlayParam:" + paramspk2);
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_Spa;
      int n = spm.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView, paramspk1);
      this.jdField_c_of_type_Int = n;
      ((spa)localObject).a(paramspk1, n);
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
        sqk localsqk = (sqk)((Iterator)localObject).next();
        if (localsqk != null)
        {
          if (paramBoolean)
          {
            localsqk.p();
            continue;
            this.jdField_a_of_type_Spa.a();
            break;
          }
          localsqk.a(paramspk1, paramspk2);
        }
      }
    }
  }
  
  private String b()
  {
    if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (qxl.a(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_text))) {
      return qxl.b(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_text);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "getDownloadIconText(), null:");
    }
    return null;
  }
  
  private void b(spk paramspk, int paramInt, Object paramObject)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(103, 1200L);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void c(spk paramspk, int paramInt, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1) != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1).getTag() instanceof sxh)))
    {
      paramObject = (sxh)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1).getTag();
      if ((paramObject != null) && (paramObject.jdField_g_of_type_AndroidWidgetTextView != null) && (paramObject.jdField_a_of_type_Int == 0))
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        paramObject.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.e("Q.readinjoy.video.VideoUIManager", 2, "隐藏大王卡引导Textview");
        }
      }
    }
    ukv.a(paramspk, this, false, this.jdField_a_of_type_Ukx);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841816));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841817));
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
  
  private void d(View paramView)
  {
    if (a()) {
      b(false);
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new VideoUIManager.8(this));
      return;
      i();
    }
  }
  
  private void d(spk paramspk, int paramInt, Object paramObject)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(102);
    if (paramInt == 2) {
      if (this.jdField_a_of_type_Spk.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
        this.jdField_a_of_type_Spk.jdField_a_of_type_Stv.a().setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165357));
        E();
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 3000L);
        if ((NetworkUtil.isMobileNetWork(this.jdField_a_of_type_AndroidAppActivity)) && (!this.jdField_d_of_type_Boolean))
        {
          y();
          this.jdField_d_of_type_Boolean = true;
        }
        a(this.jdField_f_of_type_AndroidWidgetImageView);
        if ((this.jdField_a_of_type_Spk.jdField_b_of_type_Boolean) && (this.jdField_f_of_type_AndroidWidgetImageView != null)) {
          this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        J();
        P();
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
          six.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, 8, 300);
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
      } while (!NetworkUtil.isMobileNetWork(this.jdField_a_of_type_AndroidAppActivity));
      y();
      return;
    } while (!this.jdField_a_of_type_Spk.jdField_b_of_type_Boolean);
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
      localLayoutParams.width = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 91.0F);
      localLayoutParams.height = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 28.0F);
      localLayoutParams.rightMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 16.0F);
    }
    for (localLayoutParams.topMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 16.0F);; localLayoutParams.topMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 8.0F))
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 78.0F);
      localLayoutParams.height = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 24.0F);
      localLayoutParams.rightMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 8.0F);
    }
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_Suf.a();
  }
  
  private void e(int paramInt)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      six.a(this.jdField_d_of_type_AndroidWidgetTextView, 8, 300);
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
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843294));
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(1));
      } while (e());
      six.a(this.jdField_a_of_type_AndroidWidgetImageView, 0, 300);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843292));
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(3));
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843293));
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2));
    } while (e());
    six.a(this.jdField_a_of_type_AndroidWidgetImageView, 0, 300);
  }
  
  private void e(View paramView)
  {
    int n = ((Integer)paramView.getTag()).intValue();
    switch (n)
    {
    default: 
      if (2 != n) {
        break;
      }
    }
    for (n = 1;; n = 0)
    {
      ThreadManager.executeOnSubThread(new VideoUIManager.9(this, n));
      return;
      if (!sge.a().a()) {
        sqp.a().a(false, "noAutoPlayClickVideoInReadInjoy", 1);
      }
      this.jdField_a_of_type_Spg.f(true);
      break;
      this.jdField_a_of_type_Spg.e(true);
      break;
    }
  }
  
  private void e(spk paramspk, int paramInt, Object paramObject)
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
  
  private void f(spk paramspk, int paramInt, Object paramObject)
  {
    if (e()) {
      e(1);
    }
    if (this.jdField_a_of_type_Spk.jdField_b_of_type_Boolean) {
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
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130843247);
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
  
  private void g(spk paramspk, int paramInt, Object paramObject)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
    if ((paramObject instanceof int[]))
    {
      paramspk = (int[])paramObject;
      a(1, spm.a(paramspk[0], paramspk[1]), anvx.a(2131715790));
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
      if ((this.jdField_a_of_type_Spk != null) && (this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null))
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
      suu localsuu = new suu("", this.jdField_a_of_type_Spk.k, this.jdField_a_of_type_Spk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
      localsuu.a((int)this.jdField_a_of_type_Spk.jdField_b_of_type_Long);
      if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null)) {
        localsuu.a(qxl.b(((articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get()).bytes_common_data));
      }
      olh.a(null, "", str, str, 0, 0, "3", "", "", localsuu.a().a(), false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "showDownloadBar(), barStyle:" + paramInt);
      return;
      L();
      break label56;
      N();
      break label56;
      label270:
      if (this.jdField_k_of_type_Int == 2) {
        str = "0X8009BC6";
      }
    }
  }
  
  private void h(spk paramspk, int paramInt, Object paramObject)
  {
    boolean bool = true;
    if ((!pjr.a(paramspk)) && (this.jdField_a_of_type_Spa.a()) && (this.jdField_a_of_type_Spk.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_Spa.a(paramspk);
      return;
    }
    if (this.jdField_k_of_type_Int == 2)
    {
      sge.jdField_c_of_type_Boolean = true;
      h(2);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      label64:
      if (paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.patchStatus.a.get() == 1) {
        break label150;
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getFirstVisiblePosition() != 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1) == null) || (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1).getTag() instanceof sxh))) {
        break label152;
      }
    }
    for (;;)
    {
      ukv.a(paramspk, this, bool, false, this.jdField_a_of_type_Sqj, this.jdField_a_of_type_Spa, this.jdField_a_of_type_Ukx);
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
    sge.jdField_c_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo = null;
    this.jdField_k_of_type_Int = 0;
  }
  
  private void p()
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131380944));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131370555));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367650));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131379056));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131379001));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131379083);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365915));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131368501));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372923));
    this.m = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372334));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372277));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372278));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131369734));
    this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372333));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131370794));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367472));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367469));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367471));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131373251));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131368908));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365917));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367470));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setSeekBar(this.jdField_a_of_type_AndroidWidgetSeekBar);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoBrightnessController(this.jdField_a_of_type_Sgi);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131381099));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131381098));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131381096));
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView = ((ReadInJoyPatchAdView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372473));
    q();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar = ((ReadInJoyVideoAdHighLightBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131368206));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide = ((ReadInJoyAdVideoGuide)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131362027));
    UIUtils.expandViewTouchArea(this.jdField_f_of_type_AndroidWidgetImageView, 10, 10, 10, 10);
    UIUtils.expandViewTouchArea(this.jdField_d_of_type_AndroidWidgetImageView, 20, 20, 20, 20);
    sqp.a().a(this.jdField_f_of_type_AndroidWidgetImageView);
    sqp.a().a(this.jdField_d_of_type_AndroidWidgetImageView);
    this.jdField_e_of_type_Boolean = true;
  }
  
  private void q()
  {
    this.jdField_a_of_type_Ukx = new sqh(this);
    ukv.a(this.jdField_a_of_type_AndroidAppActivity, this, this.jdField_a_of_type_Spg, this.jdField_a_of_type_Spa, this.jdField_a_of_type_Sqj, this.jdField_a_of_type_Ukx);
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_Spk == null) {}
    while (!(this.jdField_a_of_type_AndroidWidgetFrameLayout instanceof RoundAngleFrameLayout)) {
      return;
    }
    ((RoundAngleFrameLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout).setRadius(this.jdField_a_of_type_Spk.o, this.jdField_a_of_type_Spk.p, this.jdField_a_of_type_Spk.q, this.jdField_a_of_type_Spk.r);
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
    if (this.jdField_a_of_type_Spk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoUIManager", 2, "innerConfigVideoUI() mPlayingVideoParam == null ERROR");
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    this.jdField_h_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167363));
    if (this.jdField_a_of_type_Spk.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoPlayCount == 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(pjr.a(this.jdField_a_of_type_Spk.jdField_b_of_type_Int, true));
      qdc.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_Spk);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getVideoCoverUrlWithSmartCut(false));
      if (this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize > 0L) {
        break label523;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(anvx.a(2131715784));
      label221:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(this.jdField_a_of_type_Spk.jdField_b_of_type_Long);
      if (!NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidAppActivity)) {
        break label568;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843294));
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(1));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      f();
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(this.jdField_a_of_type_Spk.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(this.jdField_a_of_type_Spk.jdField_b_of_type_Int);
      D();
      d(this.jdField_a_of_type_Spk.n);
      t();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      if (this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.patchStatus.a.get() != 1) {
        ukv.a(this);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a() != null) && (this.jdField_a_of_type_Spk != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.d();
      }
      ujz.a.a(this.jdField_a_of_type_Spk, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar);
      ujz.a.a(this.jdField_a_of_type_Spk, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide);
      ujz.a.a(this.jdField_a_of_type_Spk);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(six.c(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoPlayCount) + anvx.a(2131715785));
      break;
      label523:
      this.jdField_d_of_type_AndroidWidgetTextView.setText(six.b(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize) + anvx.a(2131715788));
      break label221;
      label568:
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      Drawable localDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843226);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      if (bhyk.a() == 1) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(anvx.a(2131715783));
      }
    }
  }
  
  private void v()
  {
    this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup;
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
    this.jdField_a_of_type_Spg.a(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-16777216);
    d(true);
  }
  
  private void x()
  {
    Object localObject = this.jdField_a_of_type_Spg.a();
    String str1;
    String str2;
    if (localObject != null)
    {
      localObject = ((spk)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if (localObject != null)
      {
        str1 = new suu(null, ((BaseArticleInfo)localObject).getSubscribeUin(), ((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).getInnerUniqueID(), this.jdField_a_of_type_Spg.a(), ((BaseArticleInfo)localObject).getVideoDuration() * 1000L).a((int)((BaseArticleInfo)localObject).mChannelID).a().a();
        str2 = ((BaseArticleInfo)localObject).getSubscribeUin();
        if (TextUtils.isEmpty(((BaseArticleInfo)localObject).getInnerUniqueID())) {
          break label115;
        }
      }
    }
    label115:
    for (localObject = ((BaseArticleInfo)localObject).getInnerUniqueID();; localObject = "0")
    {
      olh.a(null, str2, "0X8007411", "0X8007411", 0, 0, "0", "", (String)localObject, str1, false);
      return;
    }
  }
  
  private void y()
  {
    if ((this.jdField_a_of_type_Spk == null) || (this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Spk.jdField_a_of_type_AndroidViewView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.readinjoy.video.VideoUIManager", 2, "showXGToast failed for mPlayingVideoParam.feedsVideoCover is null");
    return;
    String str;
    if (bhyk.a() == 1) {
      str = anvx.a(2131715787);
    }
    for (;;)
    {
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_Spk.jdField_a_of_type_AndroidViewView.getLocationOnScreen(arrayOfInt);
      int n = arrayOfInt[1] - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
      n = (n + (this.jdField_a_of_type_Spk.jdField_a_of_type_AndroidViewView.getHeight() + n) - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 40.0F)) / 2;
      six.a(this.jdField_a_of_type_AndroidAppActivity, str, n);
      return;
      if (this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize > 0L) {
        str = anvx.a(2131715782) + six.b(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize);
      } else {
        str = anvx.a(2131715781);
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
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getVideoCoverUrlWithSmartCut(false));
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
  
  public spk a()
  {
    return this.jdField_a_of_type_Spk;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Spa.c();
    if (this.jdField_g_of_type_Boolean) {
      i(1);
    }
    if (a() != null)
    {
      BaseArticleInfo localBaseArticleInfo = a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if (((ukv.c(localBaseArticleInfo)) || (ukv.d(localBaseArticleInfo))) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.b();
      }
      if (ukv.a(localBaseArticleInfo)) {
        this.jdField_a_of_type_Spg.a(a());
      }
      if ((ukv.b(localBaseArticleInfo)) && (this.jdField_a_of_type_Sqj != null))
      {
        this.jdField_a_of_type_Sqj.a(a());
        this.jdField_a_of_type_Spa.c();
      }
    }
    ujz.a.a(this.jdField_a_of_type_Spk, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar);
    ujz.a.b(this.jdField_a_of_type_Spk, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide);
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
        n = this.jdField_a_of_type_Spg.a();
        if ((n != 0) && (n != 1) && (n != 7) && (n != 2) && (n != 4)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "innerEnterFullScreen => playState=" + spm.a(n) + ", illegal state just ignore fullscreen.");
      return;
    } while (this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_Boolean = true;
    a(true, this.jdField_a_of_type_Spg.a(), null);
    c(true);
    this.jdField_i_of_type_Int = this.jdField_a_of_type_Spg.b();
    if ((paramBoolean) && (pjr.a(this.jdField_a_of_type_Spk))) {
      if (this.jdField_a_of_type_Sfk.a(false)) {
        this.jdField_c_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      Window localWindow = this.jdField_a_of_type_AndroidAppActivity.getWindow();
      localWindow.setFlags(1024, 1024);
      if ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent() instanceof ViewGroup))
      {
        this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent());
        this.jdField_j_of_type_Int = this.jdField_a_of_type_AndroidViewViewGroup.indexOfChild(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        this.jdField_a_of_type_Spk.jdField_a_of_type_Stv.a();
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        this.jdField_a_of_type_Spk.jdField_a_of_type_Stv.b();
        localWindow.addContentView(this.jdField_a_of_type_AndroidWidgetFrameLayout, new ViewGroup.LayoutParams(-1, -1));
      }
      this.jdField_g_of_type_Int = this.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth();
      this.jdField_h_of_type_Int = this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoUIManager", 2, "FullScreen => mOriginalWidth=" + this.jdField_g_of_type_Int + ", mOriginalHeight=" + this.jdField_h_of_type_Int + ", playState=" + spm.a(n) + "，userClickEnter:" + paramBoolean);
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
      } while (!this.jdField_a_of_type_Spg.d());
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
      } while ((this.jdField_a_of_type_Spg == null) || (this.jdField_a_of_type_Spg.a() == null));
      i2 = this.jdField_a_of_type_Spg.a().jdField_a_of_type_Int;
    } while ((i2 < 0) || ((i2 >= n) && (i2 <= i1)));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "triggerVideoRecycleCheck => stop video，firstVisblePosi:" + n + ",lastVisiblePosi:" + i1 + ",playingPosi:" + i2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "triggerVideoRecycleCheck => stop video，playParam:" + this.jdField_a_of_type_Spg.a());
    }
    this.jdField_a_of_type_Spg.a(ReportConstants.VideoEndType.SLIDE_LEAVE);
    this.jdField_a_of_type_Spg.b(10);
  }
  
  public void a(spd paramspd)
  {
    this.jdField_a_of_type_Spa.a(paramspd);
  }
  
  public void a(spg paramspg)
  {
    this.jdField_a_of_type_Spg = paramspg;
    this.jdField_a_of_type_Spg.a(this);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367650));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(this.jdField_a_of_type_Spg.c());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(paramspg);
    this.jdField_a_of_type_Spa.a(paramspg);
  }
  
  public void a(spk paramspk)
  {
    this.jdField_a_of_type_Spk = paramspk;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "playVideo(): videoPlayParam=" + paramspk);
    }
    if ((this.jdField_a_of_type_Spk != null) && (this.jdField_a_of_type_Spk.jdField_b_of_type_Boolean))
    {
      a(false);
      this.jdField_c_of_type_Boolean = false;
    }
    p();
    u();
    v();
    g();
  }
  
  public void a(spk paramspk, spn paramspn, int paramInt1, int paramInt2, Object paramObject)
  {
    if ((this.jdField_a_of_type_Spk == null) || (paramspk == null) || (this.jdField_a_of_type_Spk != paramspk)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video.VideoUIManager", 2, "onStateChange(): mPlayingVideoParam and videoPlayParam not equal, just return;");
      }
    }
    do
    {
      return;
      if (paramInt2 == 0)
      {
        a(paramspk, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 1)
      {
        b(paramspk, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 2)
      {
        c(paramspk, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 3)
      {
        d(paramspk, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 4)
      {
        e(paramspk, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 5)
      {
        f(paramspk, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 6)
      {
        g(paramspk, paramInt1, paramObject);
        return;
      }
    } while (paramInt2 != 7);
    h(paramspk, paramInt1, paramObject);
  }
  
  public void a(spn paramspn, spk paramspk) {}
  
  public void a(sqj paramsqj)
  {
    this.jdField_a_of_type_Sqj = paramsqj;
  }
  
  public void a(sqk paramsqk)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramsqk)) {
      this.jdField_a_of_type_JavaUtilList.add(paramsqk);
    }
  }
  
  public void a(sql paramsql)
  {
    this.jdField_a_of_type_Sql = paramsql;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Sfk != null) {
      this.jdField_a_of_type_Sfk.a(paramBoolean);
    }
    if ((this.jdField_a_of_type_Sfk != null) && (this.jdField_a_of_type_Spk != null) && (this.jdField_a_of_type_Spk.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_Sfk.a(false);
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
    this.jdField_a_of_type_Spa.d();
  }
  
  public void b(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void b(View paramView) {}
  
  public void b(sql paramsql)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramsql);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {}
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Spa.b();
    c(false);
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    ((Window)localObject).clearFlags(1024);
    ((Window)localObject).addFlags(this.jdField_a_of_type_Int);
    ((Window)localObject).getDecorView().setSystemUiVisibility(this.jdField_b_of_type_Int);
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent() instanceof ViewGroup))
    {
      this.jdField_a_of_type_Spk.jdField_a_of_type_Stv.a();
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      this.jdField_a_of_type_Spk.jdField_a_of_type_Stv.b();
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
      this.jdField_a_of_type_Sfk.a(true);
    }
    this.jdField_a_of_type_Spg.a(this.jdField_i_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
    if ((this.jdField_a_of_type_Spa.a() != null) && ((this.jdField_a_of_type_Spa.a() instanceof spk))) {
      a(false, (spk)this.jdField_a_of_type_Spa.a(), this.jdField_a_of_type_Spk);
    }
    d(false);
    if (paramBoolean) {
      G();
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
    if ((this.jdField_b_of_type_AndroidWidgetSeekBar == null) || (this.jdField_a_of_type_Spk == null)) {
      return;
    }
    sqp.a().a(paramInt);
    paramInt = (int)(sqp.a().a() * this.jdField_a_of_type_Spk.jdField_b_of_type_Int);
    if (c())
    {
      g(paramInt);
      return;
    }
    f(paramInt);
  }
  
  public void c(View paramView)
  {
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof qdh))) {}
    do
    {
      qdh localqdh;
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
              n = this.jdField_a_of_type_Spg.a();
              localqdh = (qdh)paramView.getTag();
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  playState=" + spm.a(n) + ", view id: " + six.a(paramView));
              }
              if ((n != 7) || (!f())) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.w("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  complete && isDownloadBarShowing, just return.");
            return;
            if (this.jdField_a_of_type_Spg.a() != null) {
              break;
            }
            if (!sge.a().a()) {
              sqp.a().a(false, "noAutoPlayClickVideoInReadInjoy", 1);
            }
            this.jdField_a_of_type_Spg.a(localqdh.a());
            paramView = localqdh.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
          } while ((paramView == null) || (paramView.mChannelID != 56L) || (!AdvertisementInfo.isAdvertisementInfo(paramView)));
          ((AdvertisementInfo)paramView).adbt = ((int)localqdh.a().jdField_d_of_type_Long);
          ((AdvertisementInfo)paramView).adpa = 1;
          ((AdvertisementInfo)paramView).adpb = 2;
          ois.a(new ufy().a(this.jdField_a_of_type_AndroidAppActivity).a(6).b(4).a((AdvertisementInfo)paramView).a(ois.a(((AdvertisementInfo)paramView).adbt, 0, ((AdvertisementInfo)paramView).getAdbf(), 0, 1, 2, paramView.mVideoDuration * 1000, 9, 0, ((AdvertisementInfo)paramView).videoReplayCount, ReportConstants.VideoEndType.CLICK_PAUSE, ((AdvertisementInfo)paramView).isClickReplay, false)).a());
          ((AdvertisementInfo)paramView).isClickReplay = false;
          return;
          if (this.jdField_a_of_type_Spg.b() != localqdh.a().jdField_c_of_type_Long) {
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
      this.jdField_a_of_type_Spg.a(ReportConstants.VideoEndType.AD_AREA_CLICK);
      this.jdField_a_of_type_Spg.b(2);
      this.jdField_a_of_type_Spg.a(localqdh.a());
      paramView = localqdh.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((paramView != null) && (paramView.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(paramView)))
      {
        ois.a(new ufy().a(this.jdField_a_of_type_AndroidAppActivity).a(6).b(4).a((AdvertisementInfo)paramView).a(ois.a(0, 0, 1, 0, 1, 2, paramView.mVideoDuration * 1000, 9, 0, ((AdvertisementInfo)paramView).videoReplayCount, ReportConstants.VideoEndType.CLICK_PAUSE, ((AdvertisementInfo)paramView).isClickReplay, false)).a());
        ((AdvertisementInfo)paramView).isClickReplay = false;
        ((AdvertisementInfo)paramView).adbt = 0;
        ((AdvertisementInfo)paramView).adpa = 1;
        ((AdvertisementInfo)paramView).adpb = 2;
      }
    } while (sge.a().a());
    sqp.a().a(false, "noAutoPlayClickVideoInReadInjoy", 1);
  }
  
  public void c(sql paramsql)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramsql);
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
    if (this.jdField_a_of_type_Spk == null) {
      return;
    }
    float f1 = DeviceInfoUtil.getAppDisplayWidth(this.jdField_a_of_type_AndroidAppActivity);
    if (this.jdField_a_of_type_Spk.jdField_b_of_type_Boolean) {
      if (this.jdField_a_of_type_Spk.l > 0) {
        f1 = this.jdField_a_of_type_Spk.l;
      }
    }
    float f2;
    for (;;)
    {
      f2 = f1 * pjr.a(this.jdField_a_of_type_Spk.jdField_c_of_type_Int, this.jdField_a_of_type_Spk.jdField_d_of_type_Int);
      if (!this.jdField_a_of_type_Spa.a()) {
        break;
      }
      this.jdField_g_of_type_Int = ((int)f1);
      this.jdField_h_of_type_Int = ((int)f2);
      w();
      return;
      continue;
      f1 = pjr.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Spk);
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, pjr.a(this.jdField_a_of_type_Spk.jdField_c_of_type_Int, this.jdField_a_of_type_Spk.jdField_d_of_type_Int));
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
      } while ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Spk == null) || (this.jdField_a_of_type_Spk.jdField_a_of_type_AndroidViewView == null));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      this.jdField_f_of_type_Int = this.jdField_a_of_type_ArrayOfInt[1];
      this.jdField_a_of_type_Spk.jdField_a_of_type_AndroidViewView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      n = this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_f_of_type_Int;
    } while (n == this.jdField_a_of_type_AndroidWidgetFrameLayout.getTranslationY());
    ViewHelper.setTranslationY(this.jdField_a_of_type_AndroidWidgetFrameLayout, n);
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
      n = this.jdField_a_of_type_Spg.a();
      if (n != 5) {
        break label232;
      }
      e(1);
      label69:
      this.jdField_a_of_type_Suf.a();
      six.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 0, 300);
      if (!this.jdField_a_of_type_Boolean)
      {
        UIUtils.expandViewTouchArea(this.jdField_b_of_type_AndroidWidgetImageView, 10, 10, 10, 10);
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      O();
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
        six.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0, 300);
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
    six.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8, 300);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    six.a(this.jdField_a_of_type_AndroidWidgetImageView, 8, 300);
    six.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 8, 300);
    if ((a()) || (7 == this.jdField_a_of_type_Spg.a())) {
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
    a(0, anvx.a(2131715792), six.b(this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize) + anvx.a(2131715789));
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Spa != null)
    {
      this.jdField_a_of_type_Spa.e();
      this.jdField_a_of_type_Spa = null;
    }
    this.jdField_a_of_type_Spg.b(this);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Spk = null;
    if (this.jdField_a_of_type_Sfk != null)
    {
      this.jdField_a_of_type_Sfk.a();
      this.jdField_a_of_type_Sfk = null;
    }
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_Sgi != null) {
      this.jdField_a_of_type_Sgi.b();
    }
    if (this.jdField_a_of_type_Ukx != null) {
      this.jdField_a_of_type_Ukx = null;
    }
  }
  
  public void onClick(View paramView)
  {
    int n = this.jdField_a_of_type_Spg.a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "onClick(): current playState=" + spm.a(n) + ", view id: " + six.a(paramView));
    }
    if (paramView.getId() == 2131367470) {
      d(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131372277)
      {
        e(paramView);
      }
      else if (paramView.getId() == 2131366239)
      {
        if (this.jdField_a_of_type_Spg.d())
        {
          this.jdField_a_of_type_Spg.f(true);
        }
        else if ((this.jdField_a_of_type_Spg.a() == 6) && (this.jdField_a_of_type_Spk != null))
        {
          sug.b(this.jdField_a_of_type_Spk.a(), 0);
          this.jdField_a_of_type_Spg.a(this.jdField_a_of_type_Spk);
        }
      }
      else if (paramView.getId() == 2131367469)
      {
        j();
      }
      else
      {
        label221:
        Object localObject;
        if ((paramView.getId() == 2131381098) || (paramView.getId() == 2131381099))
        {
          boolean bool;
          suu localsuu;
          if (!sqp.a().c())
          {
            bool = true;
            sqp.a().a(bool, "user click audio btn", 1);
            if ((this.jdField_a_of_type_Spk == null) || (this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {
              continue;
            }
            localsuu = new suu("", this.jdField_a_of_type_Spk.k, this.jdField_a_of_type_Spk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
            localsuu.a((int)this.jdField_a_of_type_Spk.jdField_b_of_type_Long);
            if (!bool) {
              break label360;
            }
          }
          label360:
          for (localObject = "1";; localObject = "0")
          {
            localsuu.a("status", localObject);
            olh.a(null, "", "0X8009BD6", "0X8009BD6", 0, 0, "3", "", "", localsuu.a().a(), false);
            break;
            bool = false;
            break label221;
          }
        }
        else if (paramView.getId() == 2131376531)
        {
          this.jdField_a_of_type_Suf.a();
          this.jdField_a_of_type_Spg.a(this.jdField_a_of_type_Spk);
          if ((this.jdField_a_of_type_Spk != null) && (this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null))
          {
            localObject = new suu("", this.jdField_a_of_type_Spk.k, this.jdField_a_of_type_Spk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
            ((suu)localObject).a((int)this.jdField_a_of_type_Spk.jdField_b_of_type_Long);
            olh.a(null, "", "0X8009BC8", "0X8009BC8", 0, 0, "3", "", "", ((suu)localObject).a().a(), false);
            localObject = (AdvertisementInfo)this.jdField_a_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
            ((AdvertisementInfo)localObject).videoReplayCount += 1;
          }
        }
        else if ((paramView.getId() == 2131365854) || (paramView.getId() == 2131365861))
        {
          M();
        }
        else if (paramView.getId() == 2131380983)
        {
          F();
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
 * Qualified Name:     sqd
 * JD-Core Version:    0.7.0.1
 */