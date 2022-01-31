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
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.4;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.6;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.7;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
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
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;

public class qiy
  implements View.OnClickListener, begh, pya, qcf, qhs
{
  protected int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new qiz(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new qjc(this);
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoFeedsGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private ReadInJoyBaseListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView;
  private VideoViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private ArrayList<qje> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private List<qjd> jdField_a_of_type_JavaUtilList;
  private pxy jdField_a_of_type_Pxy;
  private pyy jdField_a_of_type_Pyy;
  private qhj jdField_a_of_type_Qhj;
  private qhp jdField_a_of_type_Qhp;
  private qht jdField_a_of_type_Qht;
  private qje jdField_a_of_type_Qje;
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
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private URLImageView jdField_c_of_type_ComTencentImageURLImageView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private URLImageView jdField_d_of_type_ComTencentImageURLImageView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private URLImageView jdField_e_of_type_ComTencentImageURLImageView;
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
  private TextView n;
  private TextView o;
  
  public qiy(FrameLayout paramFrameLayout, ReadInJoyBaseListView paramReadInJoyBaseListView, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView = paramReadInJoyBaseListView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Qhj = new qhj(paramActivity, this.jdField_a_of_type_AndroidWidgetFrameLayout, new qja(this));
    this.jdField_a_of_type_Pxy = new pxy(this.jdField_a_of_type_AndroidAppActivity, this);
    this.jdField_a_of_type_Pyy = new pyy(paramActivity);
    paramFrameLayout = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    this.jdField_a_of_type_Int = paramFrameLayout.getAttributes().flags;
    this.jdField_b_of_type_Int = paramFrameLayout.getDecorView().getSystemUiVisibility();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.setScrollEventCallback(new qjb(this));
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(1000L);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatMode(1);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setStartTime(-1L);
    paramFrameLayout = new LinearInterpolator();
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setInterpolator(paramFrameLayout);
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131311559);
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_Qht != null)
    {
      Object localObject = this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if (localObject != null)
      {
        localObject = new qmv(null, this.jdField_a_of_type_Qht.k, ((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).getInnerUniqueID()).a((int)((BaseArticleInfo)localObject).mChannelID).a().a();
        ndn.a(null, "", "0X8009505", "0X8009505", 0, 0, "", this.jdField_a_of_type_Qhj.a(), "", (String)localObject, false);
      }
    }
  }
  
  private void B()
  {
    if (this.jdField_b_of_type_AndroidWidgetSeekBar == null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(true);
    int i1 = 0;
    if (this.jdField_a_of_type_Qhp != null) {
      i1 = (int)(this.jdField_a_of_type_Qhp.a() / 1000L);
    }
    this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i1);
  }
  
  private void C()
  {
    int i1 = 0;
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
      if (this.jdField_a_of_type_Qhp != null) {
        i1 = (int)(this.jdField_a_of_type_Qhp.a() / 1000L);
      }
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i1);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
    }
  }
  
  private void D()
  {
    int i2 = 0;
    if ((this.jdField_a_of_type_Qht == null) || (this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video.VideoUIManager", 2, "checkIfHasDownloadInfo(), mVideoDownloadBarInfo == null, mPlayingVideoParam:" + this.jdField_a_of_type_Qht);
      }
    }
    int i1;
    label244:
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo = this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo;
          i1 = i2;
          if (!this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_style.has()) {
            break label244;
          }
          i1 = i2;
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
        i1 = i2;
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
      i1 = this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_time.get();
    } while (!QLog.isColorLevel());
    QLog.i("Q.readinjoy.video.VideoUIManager", 2, "checkIfHasDownloadInfo(), mDownloadBarStyle:" + this.jdField_k_of_type_Int + ", appearTime:" + i1);
  }
  
  private void E()
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
      } while (this.jdField_a_of_type_Qhp.a() / 1000L < this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_time.get());
      if ((!c()) && (!b()) && (this.jdField_a_of_type_Qhp.a() == 3)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video.VideoUIManager", 2, "checkIfShowDownloadBarPlaying(): failure");
    return;
    i(1);
  }
  
  private void F()
  {
    if (this.jdField_c_of_type_AndroidViewView == null)
    {
      this.jdField_c_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131299772)).inflate();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131297129));
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131297130));
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
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
          this.jdField_k_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoUIManager", 2, "showDownloadBarPlaying(), iconUrl:" + str + "，iconText:" + (String)localObject);
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
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
  
  private void G()
  {
    Object localObject;
    if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null))
    {
      localObject = (articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get();
      if (((articlesummary.UrlJumpInfo)localObject).uint32_jump_type.get() != 1) {
        break label242;
      }
      if (obz.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url)) {
        obz.a(this.jdField_a_of_type_AndroidAppActivity, obz.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url));
      }
      this.jdField_g_of_type_Boolean = true;
      if ((this.jdField_a_of_type_Qht != null) && (this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null))
      {
        localObject = "";
        if (this.jdField_k_of_type_Int != 1) {
          break label324;
        }
        localObject = "0X8009BC5";
      }
    }
    for (;;)
    {
      qmv localqmv = new qmv("", this.jdField_a_of_type_Qht.k, this.jdField_a_of_type_Qht.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
      localqmv.a((int)this.jdField_a_of_type_Qht.jdField_b_of_type_Long);
      if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null)) {
        localqmv.a(obz.a(((articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get()).bytes_common_data));
      }
      ndn.a(null, "", (String)localObject, (String)localObject, 0, 0, "3", "", "", localqmv.a().a(), false);
      return;
      label242:
      if (((articlesummary.UrlJumpInfo)localObject).uint32_jump_type.get() != 2) {
        break;
      }
      if ((obz.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_bundle)) && (bady.a(this.jdField_a_of_type_AndroidAppActivity, obz.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_bundle))))
      {
        qcn.a(this.jdField_a_of_type_AndroidAppActivity, obz.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_schema));
        break;
      }
      if (!obz.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url)) {
        break;
      }
      obz.a(this.jdField_a_of_type_AndroidAppActivity, obz.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url));
      break;
      label324:
      if (this.jdField_k_of_type_Int == 2) {
        localObject = "0X8009BC7";
      }
    }
  }
  
  private void H()
  {
    if (this.jdField_d_of_type_AndroidViewView == null)
    {
      this.jdField_d_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131299773)).inflate();
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131297129));
      this.l = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131297130));
      this.m = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131309373));
      this.n = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131299791));
      this.m.setOnClickListener(this);
      this.n.setOnClickListener(this);
      int i1 = azvv.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F);
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842496);
      ((Drawable)localObject1).setBounds(0, 0, i1, i1);
      this.m.setCompoundDrawables((Drawable)localObject1, null, null, null);
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842425);
      ((Drawable)localObject1).setBounds(0, 0, i1, i1);
      this.n.setCompoundDrawables((Drawable)localObject1, null, null, null);
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
          this.l.setText((CharSequence)localObject2);
        }
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_c_of_type_AndroidViewView != null) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoUIManager", 2, "showDownloadBarComplete(), iconUrl:" + (String)localObject1 + "，iconText:" + (String)localObject2);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        z();
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
  
  private void I()
  {
    j(1);
    j(2);
  }
  
  private void J()
  {
    if ((this.jdField_a_of_type_Qht == null) || (this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {
      return;
    }
    if ((qcn.c()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoLogoUrl)))
    {
      Object localObject1 = this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoLogoUrl;
      for (;;)
      {
        try
        {
          if (((String)localObject1).endsWith("zip"))
          {
            localObject1 = oet.a((String)localObject1);
            ((oet)localObject1).setRepeatCount(0);
            this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
            ((oet)localObject1).playAnimation();
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
        localURLDrawableOptions.mLoadingDrawable = new amym(0, 50, 150);
        localURLDrawableOptions.mPlayGifImage = true;
        localObject2 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      }
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
  }
  
  private static Drawable a(Context paramContext, boolean paramBoolean)
  {
    int i2;
    if (paramBoolean) {
      i2 = azvv.a(paramContext, 12.0F);
    }
    for (int i1 = azvv.a(paramContext, 60.0F);; i1 = azvv.a(paramContext, 28.0F))
    {
      return new amyn(-2565928, i2, i1, i1);
      i2 = azvv.a(paramContext, 6.0F);
    }
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (obz.a(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_url))) {
      return obz.a(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_url);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "getDownloadIconUrl(), null:");
    }
    return null;
  }
  
  private void a(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    paramImageView.setVisibility(0);
    if (qji.a().c())
    {
      paramImageView.setImageResource(2130842408);
      paramImageView.setContentDescription(ajjy.a(2131650632));
      return;
    }
    paramImageView.setImageResource(2130842409);
    paramImageView.setContentDescription(ajjy.a(2131650637));
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL)
  {
    obj.a(paramKandianUrlImageView, paramURL, this.jdField_a_of_type_AndroidAppActivity, false);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131300137)).inflate();
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300138));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300131));
      this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    z();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    Drawable localDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842494);
    this.jdField_i_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
    this.jdField_i_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(aciy.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    this.jdField_h_of_type_AndroidWidgetTextView.setText(paramString1);
    this.jdField_i_of_type_AndroidWidgetTextView.setText(paramString2);
  }
  
  private void a(boolean paramBoolean, qht paramqht1, qht paramqht2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.readinjoy.video.VideoUIManager", 2, "onScreenChange   isFullScreen:" + paramBoolean + "  enterPlayParam:" + paramqht1 + "   exitPlayParam:" + paramqht2);
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_Qhj;
      int i1 = qoe.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView, paramqht1);
      this.jdField_c_of_type_Int = i1;
      ((qhj)localObject).a(paramqht1, i1);
      o();
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
        qjd localqjd = (qjd)((Iterator)localObject).next();
        if (localqjd != null)
        {
          if (paramBoolean)
          {
            localqjd.l();
            continue;
            this.jdField_a_of_type_Qhj.a();
            n();
            break;
          }
          localqjd.a(paramqht1, paramqht2);
        }
      }
    }
  }
  
  private String b()
  {
    if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (obz.a(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_text))) {
      return obz.a(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_text);
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
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841247));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841248));
  }
  
  private void d(boolean paramBoolean)
  {
    if (!g()) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.width = azvv.a(this.jdField_a_of_type_AndroidAppActivity, 91.0F);
      localLayoutParams.height = azvv.a(this.jdField_a_of_type_AndroidAppActivity, 28.0F);
      localLayoutParams.rightMargin = azvv.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F);
    }
    for (localLayoutParams.topMargin = azvv.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F);; localLayoutParams.topMargin = azvv.a(this.jdField_a_of_type_AndroidAppActivity, 8.0F))
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = azvv.a(this.jdField_a_of_type_AndroidAppActivity, 78.0F);
      localLayoutParams.height = azvv.a(this.jdField_a_of_type_AndroidAppActivity, 24.0F);
      localLayoutParams.rightMargin = azvv.a(this.jdField_a_of_type_AndroidAppActivity, 8.0F);
    }
  }
  
  private boolean d()
  {
    return (this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  private void e(int paramInt)
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
  
  private boolean e()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0;
  }
  
  private void f(int paramInt)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      qcn.a(this.jdField_d_of_type_AndroidWidgetTextView, 8, 300);
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
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842556));
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(1));
      } while (e());
      qcn.a(this.jdField_a_of_type_AndroidWidgetImageView, 0, 300);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842554));
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(3));
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842555));
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2));
    } while (e());
    qcn.a(this.jdField_a_of_type_AndroidWidgetImageView, 0, 300);
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
        if (this.jdField_c_of_type_AndroidViewView == null) {
          break;
        }
      } while (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0);
      return false;
      if (this.jdField_d_of_type_AndroidViewView == null) {
        break;
      }
    } while (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0);
    return false;
  }
  
  private void g(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetSeekBar.getVisibility() != 0) {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(104);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(104, 1500L);
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
    if (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != 8) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_e_of_type_AndroidWidgetImageView.getVisibility() != 0)
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130842510);
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
  
  private void i(int paramInt)
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
      if ((this.jdField_a_of_type_Qht != null) && (this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null))
      {
        str = "";
        if (this.jdField_k_of_type_Int != 1) {
          break label265;
        }
        str = "0X8009BC4";
      }
      break;
    }
    for (;;)
    {
      qmv localqmv = new qmv("", this.jdField_a_of_type_Qht.k, this.jdField_a_of_type_Qht.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
      localqmv.a((int)this.jdField_a_of_type_Qht.jdField_b_of_type_Long);
      if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo != null) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null)) {
        localqmv.a(obz.a(((articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get()).bytes_common_data));
      }
      ndn.a(null, "", str, str, 0, 0, "3", "", "", localqmv.a().a(), false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "showDownloadBar(), barStyle:" + paramInt);
      return;
      F();
      break label56;
      H();
      break label56;
      label265:
      if (this.jdField_k_of_type_Int == 2) {
        str = "0X8009BC6";
      }
    }
  }
  
  private void j(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_c_of_type_AndroidViewView == null);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    } while (this.jdField_d_of_type_AndroidViewView == null);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void l()
  {
    pyu.jdField_c_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo = null;
    this.jdField_k_of_type_Int = 0;
  }
  
  private void m()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      p();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131313175));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131303905));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131301388));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131311586));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131311534));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131311612);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131299841));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131302158));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131306045));
    this.o = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131305468));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131305410));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131305411));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131303181));
    this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131305467));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131304142));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131301270));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131301267));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131301269));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131306330));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131302565));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131299843));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131301268));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131303469));
    this.jdField_d_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131303434));
    this.jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131309554));
    this.jdField_e_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131309515));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setSeekBar(this.jdField_a_of_type_AndroidWidgetSeekBar);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoBrightnessController(this.jdField_a_of_type_Pyy);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131313295));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131313294));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131313292));
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131303469));
    this.jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131309554));
    this.jdField_d_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131303434));
    this.jdField_e_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131309515));
    p();
    vms.a(this.jdField_f_of_type_AndroidWidgetImageView, 10, 10, 10, 10);
    vms.a(this.jdField_d_of_type_AndroidWidgetImageView, 20, 20, 20, 20);
    qji.a().a(this.jdField_f_of_type_AndroidWidgetImageView);
    qji.a().a(this.jdField_d_of_type_AndroidWidgetImageView);
    this.jdField_e_of_type_Boolean = true;
  }
  
  private void n()
  {
    if (!this.jdField_a_of_type_Qht.jdField_d_of_type_Boolean) {}
    do
    {
      return;
      if (this.jdField_b_of_type_ComTencentImageURLImageView != null) {
        this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
      if ((this.jdField_d_of_type_ComTencentImageURLImageView != null) && (!this.jdField_a_of_type_Qht.jdField_e_of_type_Boolean)) {
        this.jdField_d_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
      if (this.jdField_c_of_type_ComTencentImageURLImageView != null) {
        this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
    } while ((this.jdField_e_of_type_ComTencentImageURLImageView == null) || (this.jdField_a_of_type_Qht.jdField_e_of_type_Boolean));
    this.jdField_e_of_type_ComTencentImageURLImageView.setVisibility(0);
  }
  
  private void o()
  {
    if (this.jdField_b_of_type_ComTencentImageURLImageView != null) {
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    if (this.jdField_d_of_type_ComTencentImageURLImageView != null) {
      this.jdField_d_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    if (this.jdField_c_of_type_ComTencentImageURLImageView != null) {
      this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    if (this.jdField_e_of_type_ComTencentImageURLImageView != null) {
      this.jdField_e_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  private void p()
  {
    if (a())
    {
      o();
      return;
    }
    n();
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_Qht == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoUIManager", 2, "innerConfigVideoUI() mPlayingVideoParam == null ERROR");
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    this.jdField_j_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131101537));
    if (this.jdField_a_of_type_Qht.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoPlayCount == 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(obj.a(this.jdField_a_of_type_Qht.jdField_b_of_type_Int));
      oms.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_Qht);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getVideoCoverUrlWithSmartCut(false));
      if (this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize > 0L) {
        break label408;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(ajjy.a(2131650630));
      label220:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(this.jdField_a_of_type_Qht.jdField_b_of_type_Long);
      if (!badq.h(this.jdField_a_of_type_AndroidAppActivity)) {
        break label453;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842556));
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(1));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      d();
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(this.jdField_a_of_type_Qht.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(this.jdField_a_of_type_Qht.jdField_b_of_type_Int);
      y();
      e(this.jdField_a_of_type_Qht.n);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(qcn.c(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoPlayCount) + ajjy.a(2131650631));
      break;
      label408:
      this.jdField_d_of_type_AndroidWidgetTextView.setText(qcn.b(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize) + ajjy.a(2131650634));
      break label220;
      label453:
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      Drawable localDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842494);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(aciy.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      if (bati.a() == 1) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(ajjy.a(2131650629));
      }
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup;
  }
  
  private void s()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setTranslationY(0.0F);
    w();
    i();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.a(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
    this.jdField_a_of_type_Qhp.a(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-16777216);
    d(true);
  }
  
  private void t()
  {
    Object localObject = this.jdField_a_of_type_Qhp.a();
    String str1;
    String str2;
    if (localObject != null)
    {
      localObject = ((qht)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if (localObject != null)
      {
        str1 = new qmv(null, ((BaseArticleInfo)localObject).getSubscribeUin(), ((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).getInnerUniqueID(), this.jdField_a_of_type_Qhp.a(), ((BaseArticleInfo)localObject).getVideoDuration() * 1000L).a((int)((BaseArticleInfo)localObject).mChannelID).a().a();
        str2 = ((BaseArticleInfo)localObject).getSubscribeUin();
        if (TextUtils.isEmpty(((BaseArticleInfo)localObject).getInnerUniqueID())) {
          break label114;
        }
      }
    }
    label114:
    for (localObject = ((BaseArticleInfo)localObject).getInnerUniqueID();; localObject = "0")
    {
      ndn.a(null, str2, "0X8007411", "0X8007411", 0, 0, "0", "", (String)localObject, str1, false);
      return;
    }
  }
  
  private void u()
  {
    if ((this.jdField_a_of_type_Qht == null) || (this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Qht.jdField_a_of_type_AndroidViewView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.readinjoy.video.VideoUIManager", 2, "showXGToast failed for mPlayingVideoParam.feedsVideoCover is null");
    return;
    String str;
    if (bati.a() == 1) {
      str = ajjy.a(2131650633);
    }
    for (;;)
    {
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_Qht.jdField_a_of_type_AndroidViewView.getLocationOnScreen(arrayOfInt);
      int i1 = arrayOfInt[1] - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
      i1 = (i1 + (this.jdField_a_of_type_Qht.jdField_a_of_type_AndroidViewView.getHeight() + i1) - azvv.a(this.jdField_a_of_type_AndroidAppActivity, 40.0F)) / 2;
      qcn.a(this.jdField_a_of_type_AndroidAppActivity, str, i1);
      return;
      if (this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize > 0L) {
        str = ajjy.a(2131650628) + qcn.b(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize);
      } else {
        str = ajjy.a(2131650627);
      }
    }
  }
  
  private void v()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0))
    {
      qcn.a(this.jdField_b_of_type_AndroidViewView, 8, 300);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
    }
  }
  
  private void w()
  {
    qcn.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8, 300);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    qcn.a(this.jdField_a_of_type_AndroidWidgetImageView, 8, 300);
    if (a()) {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    }
    for (;;)
    {
      if (!qcn.b()) {
        qcn.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8, 300);
      }
      return;
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_Qhp != null) {}
    for (int i1 = (int)(this.jdField_a_of_type_Qhp.a() / 1000L);; i1 = 0)
    {
      nnz.a(i1, this.jdField_a_of_type_Qhp);
      if (this.jdField_b_of_type_AndroidWidgetSeekBar.isEnabled())
      {
        if (this.jdField_b_of_type_AndroidWidgetSeekBar.getVisibility() != 0) {
          this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
        }
        this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i1);
      }
      if ((this.jdField_a_of_type_AndroidWidgetSeekBar.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetSeekBar.isEnabled())) {
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i1);
      }
      if (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(obj.a(i1));
      }
      if ((this.jdField_a_of_type_Qje != null) && (this.jdField_a_of_type_Qht != null) && (this.jdField_a_of_type_Qhp != null)) {
        this.jdField_a_of_type_Qje.a(this.jdField_a_of_type_Qhp.a(), (int)this.jdField_a_of_type_Qhp.a(), this.jdField_a_of_type_Qht.jdField_b_of_type_Int * 1000);
      }
      if ((this.jdField_a_of_type_Qht != null) && (this.jdField_a_of_type_Qhp != null))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((qje)localIterator.next()).a(this.jdField_a_of_type_Qhp.a(), (int)this.jdField_a_of_type_Qhp.a(), this.jdField_a_of_type_Qht.jdField_b_of_type_Int * 1000);
        }
      }
      return;
    }
  }
  
  private void y()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    i();
    v();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    I();
    B();
    this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
  }
  
  private void z()
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qhj.c();
    if (this.jdField_g_of_type_Boolean) {
      j(1);
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
    int i1;
    do
    {
      do
      {
        return;
        i1 = this.jdField_a_of_type_Qhp.a();
        if ((i1 != 0) && (i1 != 1) && (i1 != 7) && (i1 != 2) && (i1 != 4)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "innerEnterFullScreen => playState=" + qhv.a(i1) + ", illegal state just ignore fullscreen.");
      return;
    } while (this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_Boolean = true;
    a(true, this.jdField_a_of_type_Qhp.a(), null);
    c(true);
    this.jdField_i_of_type_Int = this.jdField_a_of_type_Qhp.b();
    if ((paramBoolean) && (obj.a(this.jdField_a_of_type_Qht))) {
      if (this.jdField_a_of_type_Pxy.a(false)) {
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
        ((IVideoViewBase)this.jdField_a_of_type_Qht.jdField_b_of_type_AndroidViewView).doCacheSurfaceTexture();
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        ((IVideoViewBase)this.jdField_a_of_type_Qht.jdField_b_of_type_AndroidViewView).doRecoverSurfaceTexture();
        localWindow.addContentView(this.jdField_a_of_type_AndroidWidgetFrameLayout, new ViewGroup.LayoutParams(-1, -1));
      }
      this.jdField_g_of_type_Int = this.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth();
      this.jdField_h_of_type_Int = this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoUIManager", 2, "FullScreen => mOriginalWidth=" + this.jdField_g_of_type_Int + ", mOriginalHeight=" + this.jdField_h_of_type_Int + ", playState=" + qhv.a(i1) + "，userClickEnter:" + paramBoolean);
      }
      s();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setTranslationY(0.0F);
      t();
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
      i();
      return;
    }
    h();
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
        i();
      } while (!this.jdField_a_of_type_Qhp.c());
      this.jdField_f_of_type_Boolean = true;
      return;
    } while (!this.jdField_f_of_type_Boolean);
    h();
    this.jdField_f_of_type_Boolean = false;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2) {}
  
  public void a(AbsListView paramAbsListView)
  {
    if (a()) {}
    int i3;
    int i2;
    int i1;
    do
    {
      do
      {
        return;
        i3 = ((ReadInJoyBaseListView)paramAbsListView).getHeaderViewsCount();
        i2 = paramAbsListView.getFirstVisiblePosition() - i3;
        i1 = i2;
        if (i2 < 0) {
          i1 = 0;
        }
        i2 = paramAbsListView.getLastVisiblePosition() - i3;
      } while ((this.jdField_a_of_type_Qhp == null) || (this.jdField_a_of_type_Qhp.a() == null));
      i3 = this.jdField_a_of_type_Qhp.a().jdField_a_of_type_Int;
    } while ((i3 < 0) || ((i3 >= i1) && (i3 <= i2)));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "triggerVideoRecycleCheck => stop video，firstVisblePosi:" + i1 + ",lastVisiblePosi:" + i2 + ",playingPosi:" + i3);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "triggerVideoRecycleCheck => stop video，playParam:" + this.jdField_a_of_type_Qhp.a());
    }
    this.jdField_a_of_type_Qhp.b(10);
  }
  
  public void a(qhm paramqhm)
  {
    this.jdField_a_of_type_Qhj.a(paramqhm);
  }
  
  public void a(qhp paramqhp)
  {
    this.jdField_a_of_type_Qhp = paramqhp;
    this.jdField_a_of_type_Qhp.a(this);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131301388));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(this.jdField_a_of_type_Qhp.c());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(paramqhp);
    this.jdField_a_of_type_Qhj.a(paramqhp);
  }
  
  public void a(qht paramqht)
  {
    this.jdField_a_of_type_Qht = paramqht;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "playVideo(): videoPlayParam=" + paramqht);
    }
    if ((this.jdField_a_of_type_Qht != null) && (this.jdField_a_of_type_Qht.jdField_b_of_type_Boolean))
    {
      a(false);
      this.jdField_c_of_type_Boolean = false;
    }
    m();
    q();
    r();
    e();
  }
  
  public void a(qht paramqht, qhw paramqhw, int paramInt1, int paramInt2, Object paramObject)
  {
    if ((this.jdField_a_of_type_Qht == null) || (paramqht == null) || (this.jdField_a_of_type_Qht != paramqht)) {
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
                        c();
                        return;
                      }
                      c();
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
                    if (paramInt2 != 2) {
                      break;
                    }
                  } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getFirstVisiblePosition() != 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1) == null) || (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1).getTag() instanceof omz)));
                  paramqht = (omz)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1).getTag();
                } while ((paramqht == null) || (paramqht.jdField_g_of_type_AndroidWidgetTextView == null) || (paramqht.jdField_a_of_type_Int != 0));
                this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
                paramqht.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
              } while (!QLog.isColorLevel());
              QLog.e("Q.readinjoy.video.VideoUIManager", 2, "隐藏大王卡引导Textview");
              return;
              if (paramInt2 != 3) {
                break;
              }
              this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(102);
              if (paramInt1 == 2)
              {
                if (this.jdField_a_of_type_Qht.jdField_b_of_type_Boolean) {
                  this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
                }
                for (;;)
                {
                  this.jdField_a_of_type_Qht.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131099738));
                  z();
                  this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
                  this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 3000L);
                  if ((badq.b(this.jdField_a_of_type_AndroidAppActivity)) && (!this.jdField_d_of_type_Boolean))
                  {
                    u();
                    this.jdField_d_of_type_Boolean = true;
                  }
                  a(this.jdField_f_of_type_AndroidWidgetImageView);
                  if ((this.jdField_a_of_type_Qht.jdField_b_of_type_Boolean) && (this.jdField_f_of_type_AndroidWidgetImageView != null)) {
                    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
                  }
                  D();
                  J();
                  return;
                  qcn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, 8, 300);
                }
              }
              if (paramInt1 == 4)
              {
                z();
                return;
              }
            } while (paramInt1 != 5);
            if ((e()) && (c()))
            {
              f(2);
              this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
              return;
            }
            if (!d()) {
              break;
            }
            v();
          } while (!badq.b(this.jdField_a_of_type_AndroidAppActivity));
          u();
          return;
        } while (!this.jdField_a_of_type_Qht.jdField_b_of_type_Boolean);
        this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
        if (paramInt2 == 4)
        {
          if (paramInt1 == 0)
          {
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            v();
            f(3);
            this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
          }
          for (;;)
          {
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
            return;
            if (paramInt1 == 3) {
              f(3);
            }
          }
        }
        if (paramInt2 == 5)
        {
          if (e()) {
            f(1);
          }
          if (this.jdField_a_of_type_Qht.jdField_b_of_type_Boolean) {
            f(1);
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
      paramqht = (int[])paramObject;
      a(qhv.a(paramqht[0], paramqht[1]), ajjy.a(2131650636));
      return;
    } while (paramInt2 != 7);
    if ((!obj.a(paramqht)) && (this.jdField_a_of_type_Qhj.a()) && (this.jdField_a_of_type_Qht.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_Qhj.a(paramqht);
      return;
    }
    if (this.jdField_k_of_type_Int == 2)
    {
      pyu.jdField_c_of_type_Boolean = true;
      i(2);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      return;
    }
    b(false);
    c();
  }
  
  public void a(qjd paramqjd)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramqjd)) {
      this.jdField_a_of_type_JavaUtilList.add(paramqjd);
    }
  }
  
  public void a(qje paramqje)
  {
    this.jdField_a_of_type_Qje = paramqje;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pxy != null) {
      this.jdField_a_of_type_Pxy.a(paramBoolean);
    }
    if ((this.jdField_a_of_type_Pxy != null) && (this.jdField_a_of_type_Qht != null) && (this.jdField_a_of_type_Qht.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_Pxy.a(false);
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
    this.jdField_a_of_type_Qhj.d();
  }
  
  public void b(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void b(View paramView) {}
  
  public void b(qje paramqje)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramqje);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {}
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Qhj.b();
    c(false);
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    ((Window)localObject).clearFlags(1024);
    ((Window)localObject).addFlags(this.jdField_a_of_type_Int);
    ((Window)localObject).getDecorView().setSystemUiVisibility(this.jdField_b_of_type_Int);
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent() instanceof ViewGroup)))
    {
      ((IVideoViewBase)this.jdField_a_of_type_Qht.jdField_b_of_type_AndroidViewView).doCacheSurfaceTexture();
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      ((IVideoViewBase)this.jdField_a_of_type_Qht.jdField_b_of_type_AndroidViewView).doRecoverSurfaceTexture();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_j_of_type_Int, new ViewGroup.LayoutParams(-1, -1));
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    i();
    localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.jdField_g_of_type_Int;
    ((ViewGroup.LayoutParams)localObject).height = this.jdField_h_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.a(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_Pxy.a(true);
    }
    this.jdField_a_of_type_Qhp.a(this.jdField_i_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
    if ((this.jdField_a_of_type_Qhj.a() != null) && ((this.jdField_a_of_type_Qhj.a() instanceof qht))) {
      a(false, (qht)this.jdField_a_of_type_Qhj.a(), this.jdField_a_of_type_Qht);
    }
    d(false);
    if (paramBoolean) {
      A();
    }
    d();
    e();
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
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    l();
  }
  
  public void c(int paramInt) {}
  
  public void c(View paramView)
  {
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof omw))) {}
    do
    {
      omw localomw;
      do
      {
        int i1;
        do
        {
          do
          {
            do
            {
              return;
              i1 = this.jdField_a_of_type_Qhp.a();
              localomw = (omw)paramView.getTag();
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  playState=" + qhv.a(i1) + ", view id: " + qcn.a(paramView));
              }
              if ((i1 != 7) || (!f())) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.w("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  complete && isDownloadBarShowing, just return.");
            return;
            if (this.jdField_a_of_type_Qhp.a() != null) {
              break;
            }
            if (!pyu.a().a()) {
              qji.a().a(false, "noAutoPlayClickVideoInReadInjoy", 1);
            }
            this.jdField_a_of_type_Qhp.a(localomw.a());
            paramView = localomw.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
          } while ((paramView == null) || (paramView.mChannelID != 56L) || (!AdvertisementInfo.isAdvertisementInfo(paramView)));
          ((AdvertisementInfo)paramView).adbt = ((int)localomw.a().jdField_d_of_type_Long);
          ((AdvertisementInfo)paramView).adpa = 1;
          ((AdvertisementInfo)paramView).adpb = 2;
          nbe.a(new nmv().a(this.jdField_a_of_type_AndroidAppActivity).a(nbe.jdField_f_of_type_Int).b(nbe.M).a((AdvertisementInfo)paramView).a(nbe.a(((AdvertisementInfo)paramView).adbt, 0, ((AdvertisementInfo)paramView).getAdbf(), 0, 1, 2, paramView.mVideoDuration, nbe.aE, 0)).a());
          return;
          if (this.jdField_a_of_type_Qhp.b() != localomw.a().jdField_c_of_type_Long) {
            break;
          }
        } while (i1 == 1);
        if ((i1 != 5) || (!d())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  paused && isErrorLayoutShowing, just return.");
      return;
      if (c())
      {
        i();
        return;
      }
      h();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  点击非当前播放的视频feeds，播放点击的视频");
      }
      this.jdField_a_of_type_Qhp.b(2);
      this.jdField_a_of_type_Qhp.a(localomw.a());
      paramView = localomw.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((paramView != null) && (paramView.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(paramView)))
      {
        nbe.a(new nmv().a(this.jdField_a_of_type_AndroidAppActivity).a(nbe.jdField_f_of_type_Int).b(nbe.M).a((AdvertisementInfo)paramView).a(nbe.a(0, 0, 1, 0, 1, 2, paramView.mVideoDuration, nbe.aE, 0)).a());
        ((AdvertisementInfo)paramView).adbt = 0;
        ((AdvertisementInfo)paramView).adpa = 1;
        ((AdvertisementInfo)paramView).adpb = 2;
      }
    } while (pyu.a().a());
    qji.a().a(false, "noAutoPlayClickVideoInReadInjoy", 1);
  }
  
  public void c(qje paramqje)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramqje);
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "updateVideoViewSize");
    }
    if (this.jdField_a_of_type_Qht == null) {
      return;
    }
    float f1 = babp.a(this.jdField_a_of_type_AndroidAppActivity);
    if (this.jdField_a_of_type_Qht.jdField_b_of_type_Boolean) {
      if (this.jdField_a_of_type_Qht.l > 0) {
        f1 = this.jdField_a_of_type_Qht.l;
      }
    }
    float f2;
    for (;;)
    {
      f2 = f1 * obj.a(this.jdField_a_of_type_Qht.jdField_c_of_type_Int, this.jdField_a_of_type_Qht.jdField_d_of_type_Int);
      if (!this.jdField_a_of_type_Qhj.a()) {
        break;
      }
      this.jdField_g_of_type_Int = ((int)f1);
      this.jdField_h_of_type_Int = ((int)f2);
      s();
      return;
      continue;
      f1 = obj.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Qht);
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, obj.a(this.jdField_a_of_type_Qht.jdField_c_of_type_Int, this.jdField_a_of_type_Qht.jdField_d_of_type_Int));
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
  
  public void d(int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidWidgetSeekBar == null) || (this.jdField_a_of_type_Qht == null)) {
      return;
    }
    qji.a().a(paramInt);
    paramInt = (int)(qji.a().a() * this.jdField_a_of_type_Qht.jdField_b_of_type_Int);
    if (c())
    {
      h(paramInt);
      return;
    }
    g(paramInt);
  }
  
  @TargetApi(11)
  public void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {}
    int i1;
    do
    {
      do
      {
        return;
      } while ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Qht == null) || (this.jdField_a_of_type_Qht.jdField_a_of_type_AndroidViewView == null));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      this.jdField_f_of_type_Int = this.jdField_a_of_type_ArrayOfInt[1];
      this.jdField_a_of_type_Qht.jdField_a_of_type_AndroidViewView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      i1 = this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_f_of_type_Int;
    } while (i1 == this.jdField_a_of_type_AndroidWidgetFrameLayout.getTranslationY());
    alqe.f(this.jdField_a_of_type_AndroidWidgetFrameLayout, i1);
  }
  
  public void f()
  {
    a(0, true);
  }
  
  public void g()
  {
    b(true);
  }
  
  public void h()
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
      return;
    }
    int i1;
    if (a())
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      i1 = this.jdField_a_of_type_Qhp.a();
      if (i1 != 5) {
        break label239;
      }
      f(1);
      label69:
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      qcn.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 0, 300);
      if (!this.jdField_a_of_type_Boolean)
      {
        vms.a(this.jdField_b_of_type_AndroidWidgetImageView, 10, 10, 10, 10);
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      I();
      if (i1 != 5) {
        break label252;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new VideoUIManager.4(this));
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        qcn.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0, 300);
      }
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      a(this.jdField_d_of_type_AndroidWidgetImageView);
      break;
      label239:
      if (i1 != 3) {
        break label69;
      }
      f(2);
      break label69;
      label252:
      if (i1 == 3)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
      }
    }
  }
  
  public void i()
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {
      return;
    }
    qcn.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8, 300);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    qcn.a(this.jdField_a_of_type_AndroidWidgetImageView, 8, 300);
    qcn.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 8, 300);
    if ((a()) || (7 == this.jdField_a_of_type_Qhp.a())) {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
      return;
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
    }
  }
  
  public void j()
  {
    a(ajjy.a(2131650638), qcn.b(this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize) + ajjy.a(2131650635));
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Qhj != null)
    {
      this.jdField_a_of_type_Qhj.e();
      this.jdField_a_of_type_Qhj = null;
    }
    this.jdField_a_of_type_Qhp.b(this);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Qht = null;
    if (this.jdField_a_of_type_Pxy != null)
    {
      this.jdField_a_of_type_Pxy.a();
      this.jdField_a_of_type_Pxy = null;
    }
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_Pyy != null) {
      this.jdField_a_of_type_Pyy.b();
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = 0;
    int i2 = this.jdField_a_of_type_Qhp.a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "onClick(): current playState=" + qhv.a(i2) + ", view id: " + qcn.a(paramView));
    }
    if (paramView.getId() == 2131301268) {
      if (a())
      {
        b(false);
        ThreadManager.executeOnSubThread(new VideoUIManager.6(this));
      }
    }
    label259:
    label434:
    label447:
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
            f();
            break;
            if (paramView.getId() == 2131305410)
            {
              i2 = ((Integer)paramView.getTag()).intValue();
              switch (i2)
              {
              }
              for (;;)
              {
                if (2 == i2) {
                  i1 = 1;
                }
                ThreadManager.executeOnSubThread(new VideoUIManager.7(this, i1));
                return;
                if (!pyu.a().a()) {
                  qji.a().a(false, "noAutoPlayClickVideoInReadInjoy", 1);
                }
                this.jdField_a_of_type_Qhp.f(true);
                continue;
                this.jdField_a_of_type_Qhp.e(true);
              }
            }
            if (paramView.getId() != 2131300131) {
              break label259;
            }
            if (this.jdField_a_of_type_Qhp.c())
            {
              this.jdField_a_of_type_Qhp.f(true);
              return;
            }
          } while (this.jdField_a_of_type_Qhp.a() != 6);
          this.jdField_a_of_type_Qhp.a(this.jdField_a_of_type_Qht);
          return;
          if (paramView.getId() == 2131301267)
          {
            g();
            return;
          }
          if ((paramView.getId() != 2131313294) && (paramView.getId() != 2131313295)) {
            break label447;
          }
          if (qji.a().c()) {
            break label434;
          }
          bool = true;
          qji.a().a(bool, "user click audio btn", 1);
        } while ((this.jdField_a_of_type_Qht == null) || (this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null));
        qmv localqmv = new qmv("", this.jdField_a_of_type_Qht.k, this.jdField_a_of_type_Qht.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
        localqmv.a((int)this.jdField_a_of_type_Qht.jdField_b_of_type_Long);
        if (bool) {}
        for (paramView = "1";; paramView = "0")
        {
          localqmv.a("status", paramView);
          ndn.a(null, "", "0X8009BD6", "0X8009BD6", 0, 0, "3", "", "", localqmv.a().a(), false);
          return;
          bool = false;
          break;
        }
        if (paramView.getId() != 2131309373) {
          break label562;
        }
        this.jdField_a_of_type_Qhp.a(this.jdField_a_of_type_Qht);
      } while ((this.jdField_a_of_type_Qht == null) || (this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null));
      paramView = new qmv("", this.jdField_a_of_type_Qht.k, this.jdField_a_of_type_Qht.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
      paramView.a((int)this.jdField_a_of_type_Qht.jdField_b_of_type_Long);
      ndn.a(null, "", "0X8009BC8", "0X8009BC8", 0, 0, "3", "", "", paramView.a().a(), false);
      return;
    } while ((paramView.getId() != 2131299791) && (paramView.getId() != 2131299797));
    label562:
    G();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qiy
 * JD-Core Version:    0.7.0.1
 */