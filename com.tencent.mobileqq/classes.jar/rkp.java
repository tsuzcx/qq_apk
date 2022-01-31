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
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyPatchAdView;
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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.widget.AbsListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;

public class rkp
  implements View.OnClickListener, bhtv, qzd, rde, rjj
{
  protected int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new rkq(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new rku(this);
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyPatchAdView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView;
  private VideoFeedsGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private ReadInJoyBaseListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView;
  private VideoViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private ArrayList<rkx> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private List<rkw> jdField_a_of_type_JavaUtilList;
  public oej a;
  private qzb jdField_a_of_type_Qzb;
  private rac jdField_a_of_type_Rac;
  private rja jdField_a_of_type_Rja;
  private rjg jdField_a_of_type_Rjg;
  private rjk jdField_a_of_type_Rjk;
  private rkv jdField_a_of_type_Rkv;
  private rkx jdField_a_of_type_Rkx;
  private roh jdField_a_of_type_Roh;
  private articlesummary.VideoDownloadBarInfo jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo;
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
  
  public rkp(FrameLayout paramFrameLayout, ReadInJoyBaseListView paramReadInJoyBaseListView, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView = paramReadInJoyBaseListView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Roh = new roh(this.jdField_a_of_type_AndroidWidgetFrameLayout, this);
    this.jdField_a_of_type_Rja = new rja(paramActivity, this.jdField_a_of_type_AndroidWidgetFrameLayout, new rkr(this));
    this.jdField_a_of_type_Qzb = new qzb(this.jdField_a_of_type_AndroidAppActivity, this);
    this.jdField_a_of_type_Rac = new rac(paramActivity);
    paramFrameLayout = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    this.jdField_a_of_type_Int = paramFrameLayout.getAttributes().flags;
    this.jdField_b_of_type_Int = paramFrameLayout.getDecorView().getSystemUiVisibility();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.setScrollEventCallback(new rks(this));
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(1000L);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatMode(1);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setStartTime(-1L);
    paramFrameLayout = new LinearInterpolator();
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setInterpolator(paramFrameLayout);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131377964);
  }
  
  private void A()
  {
    rdm.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8, 300);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    rdm.a(this.jdField_a_of_type_AndroidWidgetImageView, 8, 300);
    if (a()) {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    }
    for (;;)
    {
      if (!rdm.c()) {
        rdm.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8, 300);
      }
      return;
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
    }
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_Rjg != null) {}
    for (int n = (int)(this.jdField_a_of_type_Rjg.a() / 1000L);; n = 0)
    {
      ocr.a(n, this.jdField_a_of_type_Rjg);
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
        this.jdField_f_of_type_AndroidWidgetTextView.setText(orc.a(n));
      }
      if ((this.jdField_a_of_type_Rkx != null) && (this.jdField_a_of_type_Rjk != null) && (this.jdField_a_of_type_Rjg != null)) {
        this.jdField_a_of_type_Rkx.a(this.jdField_a_of_type_Rjg.a(), (int)this.jdField_a_of_type_Rjg.a(), this.jdField_a_of_type_Rjk.jdField_b_of_type_Int * 1000);
      }
      if ((this.jdField_a_of_type_Rjk != null) && (this.jdField_a_of_type_Rjg != null))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((rkx)localIterator.next()).a(this.jdField_a_of_type_Rjg.a(), (int)this.jdField_a_of_type_Rjg.a(), this.jdField_a_of_type_Rjk.jdField_b_of_type_Int * 1000);
        }
        rdm.a(this.m, this.jdField_a_of_type_Rjg.a(this.jdField_a_of_type_Rjk.a()));
      }
      return;
    }
  }
  
  private void C()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    k();
    z();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    M();
    F();
    this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
  }
  
  private void D()
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_Rjk != null)
    {
      Object localObject = this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if (localObject != null)
      {
        localObject = new ron(null, this.jdField_a_of_type_Rjk.k, ((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).getInnerUniqueID()).a((int)((BaseArticleInfo)localObject).mChannelID).a().a();
        nrt.a(null, "", "0X8009505", "0X8009505", 0, 0, "", this.jdField_a_of_type_Rja.a(), "", (String)localObject, false);
      }
    }
  }
  
  private void F()
  {
    if (this.jdField_b_of_type_AndroidWidgetSeekBar == null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(true);
    int n = 0;
    if (this.jdField_a_of_type_Rjg != null) {
      n = (int)(this.jdField_a_of_type_Rjg.a() / 1000L);
    }
    this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(n);
  }
  
  private void G()
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
      if (this.jdField_a_of_type_Rjg != null) {
        n = (int)(this.jdField_a_of_type_Rjg.a() / 1000L);
      }
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(n);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
    }
  }
  
  private void H()
  {
    int i1 = 0;
    if ((this.jdField_a_of_type_Rjk == null) || (this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video.VideoUIManager", 2, "checkIfHasDownloadInfo(), mVideoDownloadBarInfo == null, mPlayingVideoParam:" + this.jdField_a_of_type_Rjk);
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
          this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo = this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo;
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
  
  private void I()
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
      } while (this.jdField_a_of_type_Rjg.a() / 1000L < this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_time.get());
      if ((!c()) && (!b()) && (this.jdField_a_of_type_Rjg.a() == 3)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video.VideoUIManager", 2, "checkIfShowDownloadBarPlaying(): failure");
    return;
    h(1);
  }
  
  private void J()
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365425)).inflate();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131362696));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131362697));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    }
    String str = a();
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Object localObject = new URL(str);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(a(this.jdField_a_of_type_AndroidAppActivity, false)).a((URL)localObject);
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
  
  private void K()
  {
    Object localObject;
    if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null))
    {
      localObject = (articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get();
      if (((articlesummary.UrlJumpInfo)localObject).uint32_jump_type.get() != 1) {
        break label247;
      }
      if (ors.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url)) {
        ors.a(this.jdField_a_of_type_AndroidAppActivity, ors.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url));
      }
      this.jdField_g_of_type_Boolean = true;
      if ((this.jdField_a_of_type_Rjk != null) && (this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null))
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
      ron localron = new ron("", this.jdField_a_of_type_Rjk.k, this.jdField_a_of_type_Rjk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
      localron.a((int)this.jdField_a_of_type_Rjk.jdField_b_of_type_Long);
      if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null)) {
        localron.a(ors.a(((articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get()).bytes_common_data));
      }
      nrt.a(null, "", (String)localObject, (String)localObject, 0, 0, "3", "", "", localron.a().a(), false);
      return;
      label247:
      if (((articlesummary.UrlJumpInfo)localObject).uint32_jump_type.get() != 2) {
        break;
      }
      if ((ors.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_bundle)) && (bdiv.a(this.jdField_a_of_type_AndroidAppActivity, ors.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_bundle))))
      {
        rdm.a(this.jdField_a_of_type_AndroidAppActivity, ors.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_schema));
        break;
      }
      if (!ors.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url)) {
        break;
      }
      ors.a(this.jdField_a_of_type_AndroidAppActivity, ors.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url));
      break;
      label329:
      if (this.jdField_k_of_type_Int == 2) {
        localObject = "0X8009BC7";
      }
    }
  }
  
  private void L()
  {
    if (this.jdField_c_of_type_AndroidViewView == null)
    {
      this.jdField_c_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365426)).inflate();
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131362696));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131362697));
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131375653));
      this.l = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131365444));
      this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.l.setOnClickListener(this);
      int n = bdaq.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F);
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842772);
      ((Drawable)localObject1).setBounds(0, 0, n, n);
      this.jdField_k_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject1, null, null, null);
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842690);
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
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(a(this.jdField_a_of_type_AndroidAppActivity, true)).a((URL)localObject2);
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
        D();
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
  
  private void M()
  {
    i(1);
    i(2);
  }
  
  private void N()
  {
    if ((this.jdField_a_of_type_Rjk == null) || (this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {
      return;
    }
    if ((rdm.d()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoLogoUrl)))
    {
      Object localObject1 = this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoLogoUrl;
      for (;;)
      {
        try
        {
          if (((String)localObject1).endsWith("zip"))
          {
            localObject1 = out.a((String)localObject1);
            ((out)localObject1).setRepeatCount(0);
            this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
            ((out)localObject1).playAnimation();
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
        localURLDrawableOptions.mLoadingDrawable = new apkp(0, 50, 150);
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
      i1 = bdaq.a(paramContext, 12.0F);
    }
    for (int n = bdaq.a(paramContext, 60.0F);; n = bdaq.a(paramContext, 28.0F))
    {
      return new apkq(-2565928, i1, n, n);
      i1 = bdaq.a(paramContext, 6.0F);
    }
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (ors.a(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_url))) {
      return ors.a(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_url);
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
    if (rlb.a().c())
    {
      paramImageView.setImageResource(2130842673);
      paramImageView.setContentDescription(alud.a(2131716818));
      return;
    }
    paramImageView.setImageResource(2130842674);
    paramImageView.setContentDescription(alud.a(2131716823));
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL)
  {
    orc.a(paramKandianUrlImageView, paramURL, this.jdField_a_of_type_AndroidAppActivity, false);
  }
  
  private void a(boolean paramBoolean, rjk paramrjk1, rjk paramrjk2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.readinjoy.video.VideoUIManager", 2, "onScreenChange   isFullScreen:" + paramBoolean + "  enterPlayParam:" + paramrjk1 + "   exitPlayParam:" + paramrjk2);
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_Rja;
      int n = rqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView, paramrjk1);
      this.jdField_c_of_type_Int = n;
      ((rja)localObject).a(paramrjk1, n);
      s();
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
        rkw localrkw = (rkw)((Iterator)localObject).next();
        if (localrkw != null)
        {
          if (paramBoolean)
          {
            localrkw.l();
            continue;
            this.jdField_a_of_type_Rja.a();
            break;
          }
          localrkw.a(paramrjk1, paramrjk2);
        }
      }
    }
  }
  
  private String b()
  {
    if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (ors.a(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_text))) {
      return ors.a(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_text);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "getDownloadIconText(), null:");
    }
    return null;
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841445));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841446));
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
  
  private void d(boolean paramBoolean)
  {
    if (!g()) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.width = bdaq.a(this.jdField_a_of_type_AndroidAppActivity, 91.0F);
      localLayoutParams.height = bdaq.a(this.jdField_a_of_type_AndroidAppActivity, 28.0F);
      localLayoutParams.rightMargin = bdaq.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F);
    }
    for (localLayoutParams.topMargin = bdaq.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F);; localLayoutParams.topMargin = bdaq.a(this.jdField_a_of_type_AndroidAppActivity, 8.0F))
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = bdaq.a(this.jdField_a_of_type_AndroidAppActivity, 78.0F);
      localLayoutParams.height = bdaq.a(this.jdField_a_of_type_AndroidAppActivity, 24.0F);
      localLayoutParams.rightMargin = bdaq.a(this.jdField_a_of_type_AndroidAppActivity, 8.0F);
    }
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_Roh.a();
  }
  
  private void e(int paramInt)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      rdm.a(this.jdField_d_of_type_AndroidWidgetTextView, 8, 300);
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
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842836));
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(1));
      } while (e());
      rdm.a(this.jdField_a_of_type_AndroidWidgetImageView, 0, 300);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842834));
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(3));
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842835));
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2));
    } while (e());
    rdm.a(this.jdField_a_of_type_AndroidWidgetImageView, 0, 300);
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
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130842787);
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
      if ((this.jdField_a_of_type_Rjk != null) && (this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null))
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
      ron localron = new ron("", this.jdField_a_of_type_Rjk.k, this.jdField_a_of_type_Rjk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
      localron.a((int)this.jdField_a_of_type_Rjk.jdField_b_of_type_Long);
      if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null)) {
        localron.a(ors.a(((articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get()).bytes_common_data));
      }
      nrt.a(null, "", str, str, 0, 0, "3", "", "", localron.a().a(), false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "showDownloadBar(), barStyle:" + paramInt);
      return;
      J();
      break label56;
      L();
      break label56;
      label270:
      if (this.jdField_k_of_type_Int == 2) {
        str = "0X8009BC6";
      }
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
  
  private void n()
  {
    qzy.jdField_c_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo = null;
    this.jdField_k_of_type_Int = 0;
  }
  
  private void o()
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131379738));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131369862));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367135));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131377989));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131377938));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131378016);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365506));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367921));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372080));
    this.m = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131371492));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131371435));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131371436));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131369096));
    this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131371491));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131370097));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367002));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131366999));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367001));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372364));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131368342));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365508));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367000));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setSeekBar(this.jdField_a_of_type_AndroidWidgetSeekBar);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoBrightnessController(this.jdField_a_of_type_Rac);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131379886));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131379885));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131379883));
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView = ((ReadInJoyPatchAdView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131371628));
    p();
    xsm.a(this.jdField_f_of_type_AndroidWidgetImageView, 10, 10, 10, 10);
    xsm.a(this.jdField_d_of_type_AndroidWidgetImageView, 20, 20, 20, 20);
    rlb.a().a(this.jdField_f_of_type_AndroidWidgetImageView);
    rlb.a().a(this.jdField_d_of_type_AndroidWidgetImageView);
    this.jdField_e_of_type_Boolean = true;
  }
  
  private void p()
  {
    this.jdField_a_of_type_Oej = new rkt(this);
    oeh.a(this.jdField_a_of_type_AndroidAppActivity, this, this.jdField_a_of_type_Rjg, this.jdField_a_of_type_Rja, this.jdField_a_of_type_Rkv, this.jdField_a_of_type_Oej);
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_Rjk == null) {}
    while (!(this.jdField_a_of_type_AndroidWidgetFrameLayout instanceof RoundAngleFrameLayout)) {
      return;
    }
    ((RoundAngleFrameLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout).setRaduis(this.jdField_a_of_type_Rjk.o, this.jdField_a_of_type_Rjk.p, this.jdField_a_of_type_Rjk.q, this.jdField_a_of_type_Rjk.r);
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout instanceof RoundAngleFrameLayout)) {
      ((RoundAngleFrameLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout).setRaduis(0, 0, 0, 0);
    }
  }
  
  private void s()
  {
    if (a())
    {
      r();
      return;
    }
    q();
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Rjk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoUIManager", 2, "innerConfigVideoUI() mPlayingVideoParam == null ERROR");
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    this.jdField_h_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167194));
    if (this.jdField_a_of_type_Rjk.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoPlayCount == 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      label141:
      this.jdField_g_of_type_AndroidWidgetTextView.setText(orc.a(this.jdField_a_of_type_Rjk.jdField_b_of_type_Int));
      pdj.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_Rjk);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getVideoCoverUrlWithSmartCut(false));
      if (this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize > 0L) {
        break label484;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(alud.a(2131716816));
      label220:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(this.jdField_a_of_type_Rjk.jdField_b_of_type_Long);
      if (!bdin.h(this.jdField_a_of_type_AndroidAppActivity)) {
        break label529;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842836));
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(1));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      f();
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(this.jdField_a_of_type_Rjk.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(this.jdField_a_of_type_Rjk.jdField_b_of_type_Int);
      C();
      d(this.jdField_a_of_type_Rjk.n);
      s();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      if (this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.patchStatus.a.get() != 1) {
        oeh.a(this);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.a()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.a() == null) || (this.jdField_a_of_type_Rjk == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.a())) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.d();
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(rdm.c(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoPlayCount) + alud.a(2131716817));
      break label141;
      label484:
      this.jdField_d_of_type_AndroidWidgetTextView.setText(rdm.b(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize) + alud.a(2131716820));
      break label220;
      label529:
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      Drawable localDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842770);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(aepi.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      if (beaa.a() == 1) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(alud.a(2131716815));
      }
    }
  }
  
  private void u()
  {
    this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup;
  }
  
  private void v()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setTranslationY(0.0F);
    A();
    k();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.a(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
    this.jdField_a_of_type_Rjg.a(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-16777216);
    d(true);
  }
  
  private void w()
  {
    Object localObject = this.jdField_a_of_type_Rjg.a();
    String str1;
    String str2;
    if (localObject != null)
    {
      localObject = ((rjk)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if (localObject != null)
      {
        str1 = new ron(null, ((BaseArticleInfo)localObject).getSubscribeUin(), ((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).getInnerUniqueID(), this.jdField_a_of_type_Rjg.a(), ((BaseArticleInfo)localObject).getVideoDuration() * 1000L).a((int)((BaseArticleInfo)localObject).mChannelID).a().a();
        str2 = ((BaseArticleInfo)localObject).getSubscribeUin();
        if (TextUtils.isEmpty(((BaseArticleInfo)localObject).getInnerUniqueID())) {
          break label115;
        }
      }
    }
    label115:
    for (localObject = ((BaseArticleInfo)localObject).getInnerUniqueID();; localObject = "0")
    {
      nrt.a(null, str2, "0X8007411", "0X8007411", 0, 0, "0", "", (String)localObject, str1, false);
      return;
    }
  }
  
  private void x()
  {
    if ((this.jdField_a_of_type_Rjk == null) || (this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Rjk.jdField_a_of_type_AndroidViewView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.readinjoy.video.VideoUIManager", 2, "showXGToast failed for mPlayingVideoParam.feedsVideoCover is null");
    return;
    String str;
    if (beaa.a() == 1) {
      str = alud.a(2131716819);
    }
    for (;;)
    {
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_Rjk.jdField_a_of_type_AndroidViewView.getLocationOnScreen(arrayOfInt);
      int n = arrayOfInt[1] - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
      n = (n + (this.jdField_a_of_type_Rjk.jdField_a_of_type_AndroidViewView.getHeight() + n) - bdaq.a(this.jdField_a_of_type_AndroidAppActivity, 40.0F)) / 2;
      rdm.a(this.jdField_a_of_type_AndroidAppActivity, str, n);
      return;
      if (this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize > 0L) {
        str = alud.a(2131716814) + rdm.b(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize);
      } else {
        str = alud.a(2131716813);
      }
    }
  }
  
  private void y()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.clearAnimation();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getVideoCoverUrlWithSmartCut(false));
  }
  
  private void z()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.clearAnimation();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
    this.jdField_a_of_type_Roh.b();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
  }
  
  public ReadInJoyPatchAdView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView;
  }
  
  public rjk a()
  {
    return this.jdField_a_of_type_Rjk;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rja.c();
    if (this.jdField_g_of_type_Boolean) {
      i(1);
    }
    if (a() != null)
    {
      BaseArticleInfo localBaseArticleInfo = a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if (((oeh.c(localBaseArticleInfo)) || (oeh.d(localBaseArticleInfo))) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.b();
      }
      if (oeh.a(localBaseArticleInfo)) {
        this.jdField_a_of_type_Rjg.a(a());
      }
      if ((oeh.b(localBaseArticleInfo)) && (this.jdField_a_of_type_Rkv != null))
      {
        this.jdField_a_of_type_Rkv.a(a());
        this.jdField_a_of_type_Rja.c();
      }
    }
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
        n = this.jdField_a_of_type_Rjg.a();
        if ((n != 0) && (n != 1) && (n != 7) && (n != 2) && (n != 4)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "innerEnterFullScreen => playState=" + rjm.a(n) + ", illegal state just ignore fullscreen.");
      return;
    } while (this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_Boolean = true;
    a(true, this.jdField_a_of_type_Rjg.a(), null);
    c(true);
    this.jdField_i_of_type_Int = this.jdField_a_of_type_Rjg.b();
    if ((paramBoolean) && (orc.a(this.jdField_a_of_type_Rjk))) {
      if (this.jdField_a_of_type_Qzb.a(false)) {
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
        ((IVideoViewBase)this.jdField_a_of_type_Rjk.jdField_b_of_type_AndroidViewView).doCacheSurfaceTexture();
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        ((IVideoViewBase)this.jdField_a_of_type_Rjk.jdField_b_of_type_AndroidViewView).doRecoverSurfaceTexture();
        localWindow.addContentView(this.jdField_a_of_type_AndroidWidgetFrameLayout, new ViewGroup.LayoutParams(-1, -1));
      }
      this.jdField_g_of_type_Int = this.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth();
      this.jdField_h_of_type_Int = this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoUIManager", 2, "FullScreen => mOriginalWidth=" + this.jdField_g_of_type_Int + ", mOriginalHeight=" + this.jdField_h_of_type_Int + ", playState=" + rjm.a(n) + "，userClickEnter:" + paramBoolean);
      }
      v();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setTranslationY(0.0F);
      w();
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
      k();
      return;
    }
    j();
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
        k();
      } while (!this.jdField_a_of_type_Rjg.d());
      this.jdField_f_of_type_Boolean = true;
      return;
    } while (!this.jdField_f_of_type_Boolean);
    j();
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
      } while ((this.jdField_a_of_type_Rjg == null) || (this.jdField_a_of_type_Rjg.a() == null));
      i2 = this.jdField_a_of_type_Rjg.a().jdField_a_of_type_Int;
    } while ((i2 < 0) || ((i2 >= n) && (i2 <= i1)));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "triggerVideoRecycleCheck => stop video，firstVisblePosi:" + n + ",lastVisiblePosi:" + i1 + ",playingPosi:" + i2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "triggerVideoRecycleCheck => stop video，playParam:" + this.jdField_a_of_type_Rjg.a());
    }
    this.jdField_a_of_type_Rjg.b(10);
  }
  
  public void a(rjd paramrjd)
  {
    this.jdField_a_of_type_Rja.a(paramrjd);
  }
  
  public void a(rjg paramrjg)
  {
    this.jdField_a_of_type_Rjg = paramrjg;
    this.jdField_a_of_type_Rjg.a(this);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367135));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(this.jdField_a_of_type_Rjg.c());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(paramrjg);
    this.jdField_a_of_type_Rja.a(paramrjg);
  }
  
  public void a(rjk paramrjk)
  {
    this.jdField_a_of_type_Rjk = paramrjk;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "playVideo(): videoPlayParam=" + paramrjk);
    }
    if ((this.jdField_a_of_type_Rjk != null) && (this.jdField_a_of_type_Rjk.jdField_b_of_type_Boolean))
    {
      a(false);
      this.jdField_c_of_type_Boolean = false;
    }
    o();
    t();
    u();
    g();
  }
  
  public void a(rjk paramrjk, rjn paramrjn, int paramInt1, int paramInt2, Object paramObject)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_Rjk == null) || (paramrjk == null) || (this.jdField_a_of_type_Rjk != paramrjk)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video.VideoUIManager", 2, "onStateChange(): mPlayingVideoParam and videoPlayParam not equal, just return;");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (paramInt2 == 0)
              {
                if (paramInt1 == 3)
                {
                  if (a()) {
                    b(false);
                  }
                  e();
                  return;
                }
                e();
                return;
              }
              if (paramInt2 == 1)
              {
                this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
                this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(103, 1200L);
                this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
                this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
                this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
                return;
              }
              if (paramInt2 == 2)
              {
                if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1) != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1).getTag() instanceof pdq)))
                {
                  paramrjn = (pdq)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1).getTag();
                  if ((paramrjn != null) && (paramrjn.jdField_g_of_type_AndroidWidgetTextView != null) && (paramrjn.jdField_a_of_type_Int == 0))
                  {
                    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
                    paramrjn.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
                    if (QLog.isColorLevel()) {
                      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "隐藏大王卡引导Textview");
                    }
                  }
                }
                oeh.a(paramrjk, this, false, this.jdField_a_of_type_Oej);
                return;
              }
              if (paramInt2 != 3) {
                break;
              }
              this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(102);
              if (paramInt1 == 2)
              {
                if (this.jdField_a_of_type_Rjk.jdField_b_of_type_Boolean) {
                  this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
                }
                for (;;)
                {
                  this.jdField_a_of_type_Rjk.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165307));
                  D();
                  this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
                  this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 3000L);
                  if ((bdin.b(this.jdField_a_of_type_AndroidAppActivity)) && (!this.jdField_d_of_type_Boolean))
                  {
                    x();
                    this.jdField_d_of_type_Boolean = true;
                  }
                  a(this.jdField_f_of_type_AndroidWidgetImageView);
                  if ((this.jdField_a_of_type_Rjk.jdField_b_of_type_Boolean) && (this.jdField_f_of_type_AndroidWidgetImageView != null)) {
                    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
                  }
                  H();
                  N();
                  return;
                  rdm.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, 8, 300);
                }
              }
              if (paramInt1 == 4)
              {
                D();
                return;
              }
            } while (paramInt1 != 5);
            if ((e()) && (c()))
            {
              e(2);
              this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
              return;
            }
            if (!d()) {
              break;
            }
            z();
          } while (!bdin.b(this.jdField_a_of_type_AndroidAppActivity));
          x();
          return;
        } while (!this.jdField_a_of_type_Rjk.jdField_b_of_type_Boolean);
        this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
        if (paramInt2 == 4)
        {
          if (paramInt1 == 0)
          {
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            z();
            e(3);
            this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
          }
          for (;;)
          {
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
            return;
            if (paramInt1 == 3) {
              e(3);
            }
          }
        }
        if (paramInt2 == 5)
        {
          if (e()) {
            e(1);
          }
          if (this.jdField_a_of_type_Rjk.jdField_b_of_type_Boolean) {
            e(1);
          }
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
          return;
        }
        if (paramInt2 != 6) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
      } while (!(paramObject instanceof int[]));
      paramrjk = (int[])paramObject;
      a(1, rjm.a(paramrjk[0], paramrjk[1]), alud.a(2131716822));
      return;
    } while (paramInt2 != 7);
    if ((!orc.a(paramrjk)) && (this.jdField_a_of_type_Rja.a()) && (this.jdField_a_of_type_Rjk.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_Rja.a(paramrjk);
      return;
    }
    if (this.jdField_k_of_type_Int == 2)
    {
      qzy.jdField_c_of_type_Boolean = true;
      h(2);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      label837:
      if (paramrjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.patchStatus.a.get() == 1) {
        break label923;
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getFirstVisiblePosition() != 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1) == null) || (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1).getTag() instanceof pdq))) {
        break label925;
      }
    }
    for (;;)
    {
      oeh.a(paramrjk, this, bool, false, this.jdField_a_of_type_Rkv, this.jdField_a_of_type_Rja, this.jdField_a_of_type_Oej);
      return;
      b(false);
      e();
      break label837;
      label923:
      break;
      label925:
      bool = false;
    }
  }
  
  public void a(rjn paramrjn, rjk paramrjk) {}
  
  public void a(rkv paramrkv)
  {
    this.jdField_a_of_type_Rkv = paramrkv;
  }
  
  public void a(rkw paramrkw)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramrkw)) {
      this.jdField_a_of_type_JavaUtilList.add(paramrkw);
    }
  }
  
  public void a(rkx paramrkx)
  {
    this.jdField_a_of_type_Rkx = paramrkx;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Qzb != null) {
      this.jdField_a_of_type_Qzb.a(paramBoolean);
    }
    if ((this.jdField_a_of_type_Qzb != null) && (this.jdField_a_of_type_Rjk != null) && (this.jdField_a_of_type_Rjk.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_Qzb.a(false);
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
    this.jdField_a_of_type_Rja.d();
  }
  
  public void b(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void b(View paramView) {}
  
  public void b(rkx paramrkx)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramrkx);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {}
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Rja.b();
    c(false);
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    ((Window)localObject).clearFlags(1024);
    ((Window)localObject).addFlags(this.jdField_a_of_type_Int);
    ((Window)localObject).getDecorView().setSystemUiVisibility(this.jdField_b_of_type_Int);
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent() instanceof ViewGroup)))
    {
      ((IVideoViewBase)this.jdField_a_of_type_Rjk.jdField_b_of_type_AndroidViewView).doCacheSurfaceTexture();
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      ((IVideoViewBase)this.jdField_a_of_type_Rjk.jdField_b_of_type_AndroidViewView).doRecoverSurfaceTexture();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_j_of_type_Int, new ViewGroup.LayoutParams(-1, -1));
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    k();
    localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.jdField_g_of_type_Int;
    ((ViewGroup.LayoutParams)localObject).height = this.jdField_h_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.a(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_Qzb.a(true);
    }
    this.jdField_a_of_type_Rjg.a(this.jdField_i_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
    if ((this.jdField_a_of_type_Rja.a() != null) && ((this.jdField_a_of_type_Rja.a() instanceof rjk))) {
      a(false, (rjk)this.jdField_a_of_type_Rja.a(), this.jdField_a_of_type_Rjk);
    }
    d(false);
    if (paramBoolean) {
      E();
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.c();
    }
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidWidgetSeekBar == null) || (this.jdField_a_of_type_Rjk == null)) {
      return;
    }
    rlb.a().a(paramInt);
    paramInt = (int)(rlb.a().a() * this.jdField_a_of_type_Rjk.jdField_b_of_type_Int);
    if (c())
    {
      g(paramInt);
      return;
    }
    f(paramInt);
  }
  
  public void c(View paramView)
  {
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof pdn))) {}
    do
    {
      pdn localpdn;
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
              n = this.jdField_a_of_type_Rjg.a();
              localpdn = (pdn)paramView.getTag();
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  playState=" + rjm.a(n) + ", view id: " + rdm.a(paramView));
              }
              if ((n != 7) || (!f())) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.w("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  complete && isDownloadBarShowing, just return.");
            return;
            if (this.jdField_a_of_type_Rjg.a() != null) {
              break;
            }
            if (!qzy.a().a()) {
              rlb.a().a(false, "noAutoPlayClickVideoInReadInjoy", 1);
            }
            this.jdField_a_of_type_Rjg.a(localpdn.a());
            paramView = localpdn.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
          } while ((paramView == null) || (paramView.mChannelID != 56L) || (!AdvertisementInfo.isAdvertisementInfo(paramView)));
          ((AdvertisementInfo)paramView).adbt = ((int)localpdn.a().jdField_d_of_type_Long);
          ((AdvertisementInfo)paramView).adpa = 1;
          ((AdvertisementInfo)paramView).adpb = 2;
          noy.a(new obk().a(this.jdField_a_of_type_AndroidAppActivity).a(noy.jdField_f_of_type_Int).b(noy.M).a((AdvertisementInfo)paramView).a(noy.a(((AdvertisementInfo)paramView).adbt, 0, ((AdvertisementInfo)paramView).getAdbf(), 0, 1, 2, paramView.mVideoDuration, noy.aF, 0)).a());
          return;
          if (this.jdField_a_of_type_Rjg.b() != localpdn.a().jdField_c_of_type_Long) {
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
        k();
        return;
      }
      j();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  点击非当前播放的视频feeds，播放点击的视频");
      }
      this.jdField_a_of_type_Rjg.b(2);
      this.jdField_a_of_type_Rjg.a(localpdn.a());
      paramView = localpdn.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((paramView != null) && (paramView.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(paramView)))
      {
        noy.a(new obk().a(this.jdField_a_of_type_AndroidAppActivity).a(noy.jdField_f_of_type_Int).b(noy.M).a((AdvertisementInfo)paramView).a(noy.a(0, 0, 1, 0, 1, 2, paramView.mVideoDuration, noy.aF, 0)).a());
        ((AdvertisementInfo)paramView).adbt = 0;
        ((AdvertisementInfo)paramView).adpa = 1;
        ((AdvertisementInfo)paramView).adpb = 2;
      }
    } while (qzy.a().a());
    rlb.a().a(false, "noAutoPlayClickVideoInReadInjoy", 1);
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.c();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    n();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "updateVideoViewSize");
    }
    if (this.jdField_a_of_type_Rjk == null) {
      return;
    }
    float f1 = bdgk.b(this.jdField_a_of_type_AndroidAppActivity);
    if (this.jdField_a_of_type_Rjk.jdField_b_of_type_Boolean) {
      if (this.jdField_a_of_type_Rjk.l > 0) {
        f1 = this.jdField_a_of_type_Rjk.l;
      }
    }
    float f2;
    for (;;)
    {
      f2 = f1 * orc.a(this.jdField_a_of_type_Rjk.jdField_c_of_type_Int, this.jdField_a_of_type_Rjk.jdField_d_of_type_Int);
      if (!this.jdField_a_of_type_Rja.a()) {
        break;
      }
      this.jdField_g_of_type_Int = ((int)f1);
      this.jdField_h_of_type_Int = ((int)f2);
      v();
      return;
      continue;
      f1 = orc.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Rjk);
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, orc.a(this.jdField_a_of_type_Rjk.jdField_c_of_type_Int, this.jdField_a_of_type_Rjk.jdField_d_of_type_Int));
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
      } while ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Rjk == null) || (this.jdField_a_of_type_Rjk.jdField_a_of_type_AndroidViewView == null));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      this.jdField_f_of_type_Int = this.jdField_a_of_type_ArrayOfInt[1];
      this.jdField_a_of_type_Rjk.jdField_a_of_type_AndroidViewView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      n = this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_f_of_type_Int;
    } while (n == this.jdField_a_of_type_AndroidWidgetFrameLayout.getTranslationY());
    aoac.f(this.jdField_a_of_type_AndroidWidgetFrameLayout, n);
  }
  
  public void h()
  {
    a(0, true);
  }
  
  public void i()
  {
    b(true);
  }
  
  public void j()
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
      n = this.jdField_a_of_type_Rjg.a();
      if (n != 5) {
        break label232;
      }
      e(1);
      label69:
      this.jdField_a_of_type_Roh.a();
      rdm.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 0, 300);
      if (!this.jdField_a_of_type_Boolean)
      {
        xsm.a(this.jdField_b_of_type_AndroidWidgetImageView, 10, 10, 10, 10);
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      M();
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
        rdm.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0, 300);
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
  
  public void k()
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {
      return;
    }
    rdm.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8, 300);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    rdm.a(this.jdField_a_of_type_AndroidWidgetImageView, 8, 300);
    rdm.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 8, 300);
    if ((a()) || (7 == this.jdField_a_of_type_Rjg.a())) {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
      return;
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
    }
  }
  
  public void l()
  {
    a(0, alud.a(2131716824), rdm.b(this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize) + alud.a(2131716821));
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Rja != null)
    {
      this.jdField_a_of_type_Rja.e();
      this.jdField_a_of_type_Rja = null;
    }
    this.jdField_a_of_type_Rjg.b(this);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Rjk = null;
    if (this.jdField_a_of_type_Qzb != null)
    {
      this.jdField_a_of_type_Qzb.a();
      this.jdField_a_of_type_Qzb = null;
    }
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_Rac != null) {
      this.jdField_a_of_type_Rac.b();
    }
    if (this.jdField_a_of_type_Oej != null) {
      this.jdField_a_of_type_Oej = null;
    }
  }
  
  public void onClick(View paramView)
  {
    int n = 0;
    int i1 = this.jdField_a_of_type_Rjg.a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "onClick(): current playState=" + rjm.a(i1) + ", view id: " + rdm.a(paramView));
    }
    if (paramView.getId() == 2131367000) {
      if (a())
      {
        b(false);
        ThreadManager.executeOnSubThread(new VideoUIManager.8(this));
      }
    }
    label277:
    label456:
    label469:
    do
    {
      do
      {
        boolean bool;
        do
        {
          do
          {
            return;
            h();
            break;
            if (paramView.getId() == 2131371435)
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
                return;
                if (!qzy.a().a()) {
                  rlb.a().a(false, "noAutoPlayClickVideoInReadInjoy", 1);
                }
                this.jdField_a_of_type_Rjg.f(true);
                continue;
                this.jdField_a_of_type_Rjg.e(true);
              }
            }
            if (paramView.getId() != 2131365813) {
              break label277;
            }
            if (this.jdField_a_of_type_Rjg.d())
            {
              this.jdField_a_of_type_Rjg.f(true);
              return;
            }
          } while ((this.jdField_a_of_type_Rjg.a() != 6) || (this.jdField_a_of_type_Rjk == null));
          roi.b(this.jdField_a_of_type_Rjk.a(), 3);
          this.jdField_a_of_type_Rjg.a(this.jdField_a_of_type_Rjk);
          return;
          if (paramView.getId() == 2131366999)
          {
            i();
            return;
          }
          if ((paramView.getId() != 2131379885) && (paramView.getId() != 2131379886)) {
            break label469;
          }
          if (rlb.a().c()) {
            break label456;
          }
          bool = true;
          rlb.a().a(bool, "user click audio btn", 1);
        } while ((this.jdField_a_of_type_Rjk == null) || (this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null));
        ron localron = new ron("", this.jdField_a_of_type_Rjk.k, this.jdField_a_of_type_Rjk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
        localron.a((int)this.jdField_a_of_type_Rjk.jdField_b_of_type_Long);
        if (bool) {}
        for (paramView = "1";; paramView = "0")
        {
          localron.a("status", paramView);
          nrt.a(null, "", "0X8009BD6", "0X8009BD6", 0, 0, "3", "", "", localron.a().a(), false);
          return;
          bool = false;
          break;
        }
        if (paramView.getId() != 2131375653) {
          break label595;
        }
        this.jdField_a_of_type_Roh.a();
        this.jdField_a_of_type_Rjg.a(this.jdField_a_of_type_Rjk);
      } while ((this.jdField_a_of_type_Rjk == null) || (this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null));
      paramView = new ron("", this.jdField_a_of_type_Rjk.k, this.jdField_a_of_type_Rjk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
      paramView.a((int)this.jdField_a_of_type_Rjk.jdField_b_of_type_Long);
      nrt.a(null, "", "0X8009BC8", "0X8009BC8", 0, 0, "3", "", "", paramView.a().a(), false);
      return;
      if ((paramView.getId() == 2131365444) || (paramView.getId() == 2131365450))
      {
        K();
        return;
      }
    } while ((paramView.getId() != 2131379772) || (this.jdField_a_of_type_Rjk == null) || (this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null));
    label595:
    if (a()) {
      b(false);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoUIManager.10(this));
    roi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Rjg.a(this.jdField_a_of_type_Rjk.a()), 3, 0);
    roi.a(this.jdField_a_of_type_Rjk.a(), 3, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rkp
 * JD-Core Version:    0.7.0.1
 */