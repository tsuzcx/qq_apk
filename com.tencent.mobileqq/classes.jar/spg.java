import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.3;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.4;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.5;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.6;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.7;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.9;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class spg
  implements sff, spr
{
  public static final String a;
  protected int a;
  private volatile Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ReportConstants.VideoEndType jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = ReportConstants.VideoEndType.CLICK_PAUSE;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private ArrayList<Pair<Integer, Bitmap>> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Integer, spn> jdField_a_of_type_JavaUtilHashMap;
  private Map<String, WeakReference<spn>> jdField_a_of_type_JavaUtilMap;
  private Set<spl> jdField_a_of_type_JavaUtilSet;
  private CopyOnWriteArrayList<spi> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private sge jdField_a_of_type_Sge;
  private spj jdField_a_of_type_Spj = new spj(this);
  public spk a;
  private spn jdField_a_of_type_Spn;
  private spp jdField_a_of_type_Spp;
  private spz jdField_a_of_type_Spz;
  private sqd jdField_a_of_type_Sqd;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private String jdField_b_of_type_JavaLangString;
  private spk jdField_b_of_type_Spk;
  private boolean jdField_b_of_type_Boolean;
  private spk jdField_c_of_type_Spk;
  private boolean jdField_c_of_type_Boolean = true;
  private spk jdField_d_of_type_Spk;
  private volatile boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + spg.class.getSimpleName();
  }
  
  public spg(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : create a new manager !");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Spp = new spp();
    this.jdField_a_of_type_Spp.a(this);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    sqp.a().a(this);
  }
  
  private ReportConstants.VideoEndType a()
  {
    if ((this.jdField_b_of_type_Spk != null) && ((this.jdField_b_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo)) && (ohz.a((AdvertisementInfo)this.jdField_b_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))) {
      return ReportConstants.VideoEndType.AD_AREA_CLICK;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType;
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, spk paramspk, boolean paramBoolean)
  {
    if (AdvertisementInfo.isAdvertisementInfo(paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      return;
    }
    paramString = sus.a(paramspk).a("dt_vdend").b("14").e(paramLong2).e(paramString);
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      sur.a(paramString.a(i).b(1).b(System.currentTimeMillis()).c(paramLong1));
      return;
    }
  }
  
  private void a(spk paramspk)
  {
    paramspk.jdField_a_of_type_Rqa.jdField_t_of_type_Long = srh.a().a();
    paramspk.jdField_a_of_type_Rqa.jdField_m_of_type_JavaLangString = srq.a().a();
  }
  
  private void a(spk paramspk, long paramLong)
  {
    Object localObject = paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    if ((localObject != null) && (uks.a((int)((BaseArticleInfo)localObject).mChannelID)) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && (paramspk.jdField_b_of_type_Boolean))
    {
      int i = (int)paramLong;
      ois.a(new ufy().a(this.jdField_a_of_type_AndroidAppActivity).a(6).b(11).a((AdvertisementInfo)localObject).a(ois.a(((AdvertisementInfo)localObject).adbt, i, ((AdvertisementInfo)localObject).getAdbf(), 1, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration * 1000, 1, 0, ((AdvertisementInfo)localObject).videoReplayCount, ReportConstants.VideoEndType.NORMAL_COMPLETE, ((AdvertisementInfo)localObject).isClickReplay, false)).a());
      ((AdvertisementInfo)localObject).isClickReplay = false;
      localObject = (AdvertisementInfo)localObject;
      ((AdvertisementInfo)localObject).videoReplayCount += 1;
    }
    paramspk = paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    if ((paramspk != null) && (paramspk.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(paramspk)))
    {
      ois.a(new ufy().a(this.jdField_a_of_type_AndroidAppActivity).a(6).b(4).a((AdvertisementInfo)paramspk).a(ois.a(((AdvertisementInfo)paramspk).adbt, paramspk.mVideoDuration * 1000, ((AdvertisementInfo)paramspk).getAdbf(), 1, ((AdvertisementInfo)paramspk).adpa, ((AdvertisementInfo)paramspk).adpb, paramspk.mVideoDuration * 1000, 9, 0, ((AdvertisementInfo)paramspk).videoReplayCount, ReportConstants.VideoEndType.NORMAL_COMPLETE, ((AdvertisementInfo)paramspk).isClickReplay, false)).a());
      ((AdvertisementInfo)paramspk).isClickReplay = false;
      paramspk = (AdvertisementInfo)paramspk;
      paramspk.videoReplayCount += 1;
    }
  }
  
  private void a(spk paramspk, spn paramspn, int paramInt, Object paramObject)
  {
    int i;
    try
    {
      i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (paramInt != i)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "changeStateAndNotify(): " + spm.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + " ===> " + spm.a(paramInt) + ", extra = " + paramObject + ", videoPlayParam=" + paramspk + ", videoPlayWrapper=" + paramspn);
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label197;
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext())
          {
            spi localspi = (spi)localIterator.next();
            if (localspi != null) {
              localspi.a(paramspk, paramspn, i, paramInt, paramObject);
            }
          }
        }
        b(paramInt, false);
      }
    }
    finally {}
    for (;;)
    {
      return;
      label197:
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.6(this, paramspk, paramspn, i, paramInt, paramObject));
    }
  }
  
  private void a(spn paramspn)
  {
    if ((this.jdField_a_of_type_Spn == null) || (this.jdField_b_of_type_Spk == null))
    {
      QLog.e("Q.readinjoy.video", 1, "onCompletion return for mVideoPlayerWrapper || mCurrenPlayVideoParam is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "video play completion!");
    }
    long l1 = this.jdField_a_of_type_Spn.a(true);
    this.jdField_d_of_type_Spk = this.jdField_b_of_type_Spk;
    this.jdField_c_of_type_Spk = this.jdField_b_of_type_Spk;
    spk localspk = this.jdField_b_of_type_Spk;
    spz localspz = this.jdField_a_of_type_Spz;
    localspk.jdField_a_of_type_Rqa.jdField_a_of_type_Long = l1;
    localspk.jdField_d_of_type_Long = a();
    if ((localspk.jdField_a_of_type_Rqa.jdField_a_of_type_Long == 0L) && (localspk.jdField_a_of_type_Rqa.jdField_d_of_type_Long == 0L) && (localspk.jdField_a_of_type_Rqa.jdField_b_of_type_Long != 0L)) {
      localspk.jdField_a_of_type_Rqa.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - localspk.jdField_a_of_type_Rqa.jdField_b_of_type_Long);
    }
    localspk.jdField_a_of_type_Rqa.jdField_a_of_type_Float = ((float)localspk.jdField_a_of_type_Rqa.jdField_a_of_type_Long / localspk.jdField_b_of_type_Int);
    localspk.jdField_a_of_type_Rqa.jdField_a_of_type_Boolean = true;
    localspk.jdField_a_of_type_Rqa.jdField_b_of_type_Boolean = true;
    localspk.jdField_a_of_type_Rqa.n = paramspn.c();
    localspk.jdField_a_of_type_Rqa.jdField_f_of_type_Int = paramspn.e();
    localspk.jdField_a_of_type_Rqa.jdField_g_of_type_Int = paramspn.f();
    localspk.jdField_a_of_type_Rqa.jdField_c_of_type_Boolean = paramspn.jdField_b_of_type_Boolean;
    localspk.jdField_a_of_type_Rqa.jdField_q_of_type_Long = paramspn.jdField_b_of_type_Long;
    localspk.jdField_a_of_type_Rqa.jdField_p_of_type_Long = paramspn.jdField_a_of_type_Long;
    localspk.jdField_a_of_type_Rqa.r = paramspn.g();
    localspk.jdField_a_of_type_Rqa.jdField_l_of_type_Int = c();
    localspk.jdField_a_of_type_Rqa.jdField_m_of_type_Int = d();
    rqa localrqa;
    int i;
    int j;
    boolean bool;
    if (this.jdField_c_of_type_Spk != null)
    {
      localrqa = localspk.jdField_a_of_type_Rqa;
      i = this.jdField_c_of_type_Spk.jdField_a_of_type_Int;
      j = localspk.jdField_a_of_type_Int;
      if (localspk.jdField_m_of_type_Int == 3) {
        bool = true;
      }
    }
    for (localrqa.s = pkh.a(i, j, bool);; localspk.jdField_a_of_type_Rqa.s = -1)
    {
      localspk.jdField_a_of_type_Rqa.jdField_d_of_type_Int = localspk.jdField_m_of_type_Int;
      localspk.jdField_a_of_type_Rqa.jdField_l_of_type_Boolean = paramspn.p();
      a(localspk);
      paramspn.a(localspk.jdField_a_of_type_Rqa.b());
      pqe.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), pkh.a(), true, localspk.jdField_a_of_type_Rqa.a());
      olv.a(localspk.jdField_a_of_type_Rqa);
      pqe.a(true, localspk.jdField_a_of_type_Rqa.jdField_d_of_type_Boolean, localspk.jdField_a_of_type_Rqa.jdField_g_of_type_Int, localspk.jdField_a_of_type_Rqa.jdField_a_of_type_Int, localspk.jdField_a_of_type_Rqa.jdField_d_of_type_Long, 56, localspk.jdField_a_of_type_Rqa.jdField_c_of_type_JavaLangString, localspk.jdField_a_of_type_Rqa.jdField_a_of_type_JavaLangString);
      long l2 = this.jdField_a_of_type_Spn.b();
      paramspn = this.jdField_a_of_type_Spn.a();
      if (localspk.jdField_a_of_type_Rqa.jdField_a_of_type_Long > 0L) {
        ThreadManager.post(new VideoPlayManager.3(this, localspk, localspz), 5, null, true);
      }
      bdla.b(null, "dc00899", "Pb_account_lifeservice", "", "0X800709B", "0X800709B", 0, 0, "", "", "", localspk.jdField_c_of_type_JavaLangString);
      a(localspk, l1);
      a(l1, l2, paramspn, localspk, false);
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.4(this));
      return;
      bool = false;
      break;
    }
  }
  
  private void a(spn paramspn, Object paramObject)
  {
    long l = 0L;
    paramObject = this.jdField_b_of_type_Spk;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onVideoPrepared() mIsOpenedVideo=" + this.jdField_a_of_type_Boolean + "   mVisable:" + this.jdField_d_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Spn == paramspn) && (paramObject != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramObject.jdField_a_of_type_Int, true);
        if ((paramObject.jdField_a_of_type_Rqa != null) && (paramObject.jdField_a_of_type_Rqa.jdField_d_of_type_Long == 0L))
        {
          paramObject.jdField_a_of_type_Rqa.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - paramObject.jdField_a_of_type_Rqa.jdField_b_of_type_Long);
          rqa localrqa = paramObject.jdField_a_of_type_Rqa;
          localrqa.jdField_f_of_type_Long += paramObject.jdField_a_of_type_Rqa.jdField_d_of_type_Long;
          localrqa = paramObject.jdField_a_of_type_Rqa;
          localrqa.jdField_c_of_type_Int += 1;
          if ((paramObject.jdField_a_of_type_Rqa != null) && (QLog.isColorLevel())) {
            QLog.d("Q.readinjoy.video", 2, "video player ready. from open. prepare cost : " + paramObject.jdField_a_of_type_Rqa.jdField_d_of_type_Long);
          }
        }
        a(paramObject, this.jdField_a_of_type_Spn, 2, null);
        if ((sqp.a(this.jdField_a_of_type_AndroidAppActivity)) || (!GesturePWDUtils.isAppOnForeground(this.jdField_a_of_type_AndroidAppActivity)) || (this.jdField_a_of_type_Sge == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onVideoPrepared start,in call stop.background:" + GesturePWDUtils.isAppOnForeground(this.jdField_a_of_type_AndroidAppActivity));
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.1(this));
        }
        for (;;)
        {
          paramspn = new StringBuilder().append(anvx.a(2131715689)).append(paramspn.jdField_b_of_type_Boolean).append(anvx.a(2131715706));
          if (paramObject.jdField_a_of_type_Rqa != null) {
            l = paramObject.jdField_a_of_type_Rqa.jdField_d_of_type_Long;
          }
          paramspn = l;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.readinjoy.video", 2, paramspn);
          return;
          paramspn.d();
          a(paramObject, this.jdField_a_of_type_Spn, 3, null);
          a(paramspn, paramObject, false);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video", 2, "video player ready,but has error!");
  }
  
  private void a(spn paramspn, spk paramspk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "doOpenVideo executed On SubThread, busitype:" + paramspk.jdField_f_of_type_Int + " vid:" + paramspk.jdField_c_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_Spn == null) || (this.jdField_a_of_type_Spn != paramspn)) {
      return;
    }
    if (TextUtils.isEmpty(paramspk.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Spj.a(paramspn, 201, 61, 0, "vid null", null);
      return;
    }
    if (paramspk.jdField_d_of_type_Long <= 0L) {
      paramspk.jdField_d_of_type_Long = sqb.a.a(paramspk.j, paramspk.jdField_c_of_type_JavaLangString);
    }
    if ((paramspk.jdField_f_of_type_Int == 2) || (paramspk.jdField_f_of_type_Int == 6))
    {
      swx localswx = swx.a();
      localswx.a(paramspk.jdField_c_of_type_JavaLangString, new sph(this, paramspn, paramspk, localswx));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
      {
        paramspn.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramspk.g, paramspk.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramspk.jdField_c_of_type_JavaLangString, paramspn.jdField_b_of_type_Boolean);
      }
      uuc.a(paramspk.j, paramspk.jdField_c_of_type_JavaLangString, 0, 0);
      return;
      if (uks.l(paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        ((AdvertisementInfo)paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adbt = ((int)paramspk.jdField_d_of_type_Long);
        if (paramspk.jdField_d_of_type_Long == 0L)
        {
          ((AdvertisementInfo)paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpa = 1;
          ((AdvertisementInfo)paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpb = 1;
        }
        paramspn.a("", paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid, 101, paramspk.jdField_d_of_type_Long, paramspk.e, paramspk.jdField_b_of_type_Int);
      }
      else
      {
        paramspn.a(paramspk.jdField_c_of_type_JavaLangString, 1, paramspk.jdField_d_of_type_Long);
      }
    }
  }
  
  private void a(spn paramspn, spk paramspk, boolean paramBoolean)
  {
    if (AdvertisementInfo.isAdvertisementInfo(paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      return;
    }
    paramspn = sus.a(paramspk).a("dt_vdstart").b("14").e(paramspn.b()).e(paramspn.a());
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      sur.a(paramspn.a(i).a(System.currentTimeMillis()).b(1));
      return;
    }
  }
  
  private void a(boolean paramBoolean, Activity paramActivity, spk paramspk, int paramInt)
  {
    BaseArticleInfo localBaseArticleInfo = paramspk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)))
    {
      ois.a(new ufy().a(paramActivity).a(6).b(4).a((AdvertisementInfo)localBaseArticleInfo).a(ois.a(((AdvertisementInfo)localBaseArticleInfo).adbt, (int)paramspk.jdField_d_of_type_Long, ((AdvertisementInfo)localBaseArticleInfo).getAdbf(), 0, ((AdvertisementInfo)localBaseArticleInfo).adpa, ((AdvertisementInfo)localBaseArticleInfo).adpb, localBaseArticleInfo.mVideoDuration * 1000, 9, 0, ((AdvertisementInfo)localBaseArticleInfo).videoReplayCount, a(), ((AdvertisementInfo)localBaseArticleInfo).isClickReplay, false)).a());
      ((AdvertisementInfo)localBaseArticleInfo).isClickReplay = false;
    }
    if ((!paramBoolean) && (localBaseArticleInfo != null) && (uks.a((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && (paramspk.jdField_b_of_type_Boolean))
    {
      ois.a(new ufy().a(paramActivity).a(6).b(11).a((AdvertisementInfo)localBaseArticleInfo).a(ois.a(((AdvertisementInfo)localBaseArticleInfo).adbt, (int)paramspk.jdField_d_of_type_Long, ((AdvertisementInfo)localBaseArticleInfo).getAdbf(), 0, ((AdvertisementInfo)localBaseArticleInfo).adpa, ((AdvertisementInfo)localBaseArticleInfo).adpb, localBaseArticleInfo.mVideoDuration * 1000, 1, 0, ((AdvertisementInfo)localBaseArticleInfo).videoReplayCount, a(), ((AdvertisementInfo)localBaseArticleInfo).isClickReplay, false)).a());
      ((AdvertisementInfo)localBaseArticleInfo).isClickReplay = false;
    }
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      QQAppInterface localQQAppInterface = pnn.b();
      if (localQQAppInterface != null) {
        return ((aoan)localQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a(Long.valueOf(paramString));
      }
    }
    return false;
  }
  
  private boolean a(spn paramspn, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      paramObject = paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "video play has error ! " + paramObject);
      }
      this.jdField_a_of_type_Spk = this.jdField_b_of_type_Spk;
      if (this.jdField_b_of_type_Spk != null) {
        uuc.a(this.jdField_b_of_type_Spk.j, this.jdField_b_of_type_Spk.jdField_c_of_type_JavaLangString, 1, paramInt2);
      }
      if (paramspn == this.jdField_a_of_type_Spn) {
        this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.5(this, paramInt1, paramInt2, paramString, paramspn));
      }
      return true;
    }
  }
  
  private boolean a(spn paramspn, int paramInt, Object paramObject)
  {
    if ((paramspn != this.jdField_a_of_type_Spn) || (a() == 5) || (this.jdField_b_of_type_Spk == null) || (this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onInfo(): what:" + paramInt + ",extra:" + paramObject + ", getCurPlayState == paused, just ignore.");
      }
      return false;
    }
    paramspn = this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa;
    switch (paramInt)
    {
    default: 
      return false;
    case 105: 
      paramspn.v = (SystemClock.uptimeMillis() - paramspn.jdField_b_of_type_Long);
      paramspn.w = (SystemClock.uptimeMillis() - paramspn.jdField_c_of_type_Long);
      return false;
    case 112: 
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onInfo(): video start buffering !");
      }
      a(this.jdField_b_of_type_Spk, this.jdField_a_of_type_Spn, 4, null);
      paramspn.e = SystemClock.uptimeMillis();
      return false;
    case 113: 
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onInfo(): video end buffering ! isPause=" + d());
      }
      if (!d()) {
        a(this.jdField_b_of_type_Spk, this.jdField_a_of_type_Spn, 3, null);
      }
      paramspn.jdField_f_of_type_Long += SystemClock.uptimeMillis() - paramspn.e;
      paramspn.jdField_c_of_type_Int += 1;
      return false;
    case 208: 
      set.a.a(paramObject, paramspn);
      return false;
    }
    paramspn.jdField_t_of_type_Int = ((Long)paramObject).intValue();
    return false;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 3) && (!this.jdField_d_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "pause for not visible，isSubThread:" + paramBoolean);
      }
      a();
    }
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_Spn != null) {
      i = this.jdField_a_of_type_Spn.b();
    }
    if (i == this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) {
      return i;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.readinjoy.video", 2, "getCurPlayState, should not happen...: mVideoPlayerWrapper.getCurrentStatus() = " + spm.a(i) + ",mState.get()=" + spm.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Spn != null) {
      return this.jdField_a_of_type_Spn.a();
    }
    return 0L;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Spn != null) {
      return this.jdField_a_of_type_Spn.a();
    }
    return null;
  }
  
  public spk a()
  {
    return this.jdField_b_of_type_Spk;
  }
  
  public spn a(String paramString)
  {
    paramString = (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return (spn)paramString.get();
    }
    return null;
  }
  
  public spn a(spk paramspk)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return null;
    }
    spn localspn = new spn(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    localspn.e(true);
    localspn.a(this.jdField_a_of_type_Spj);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "getVideoPlayer new instant!");
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramspk.a(), new WeakReference(localspn));
    return localspn;
  }
  
  public sqd a()
  {
    return this.jdField_a_of_type_Sqd;
  }
  
  public void a()
  {
    e(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Spn != null) {
      this.jdField_a_of_type_Spn.b(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video", 2, "setXYaxis value:" + paramInt);
    }
  }
  
  public void a(int paramInt, spk paramspk)
  {
    a(ReportConstants.VideoEndType.CLICK_PAUSE);
    if ((this.jdField_b_of_type_Spk != null) && ((this.jdField_b_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo))) {
      ohz.b((AdvertisementInfo)this.jdField_b_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
    this.jdField_d_of_type_Spk = null;
    if ((this.jdField_b_of_type_Spk != null) && (this.jdField_a_of_type_Spn != null))
    {
      if (this.jdField_a_of_type_Spn.b() == 2) {
        this.jdField_a_of_type_Spn.d();
      }
      this.jdField_a_of_type_Spn.a(paramInt);
      a(this.jdField_b_of_type_Spk, this.jdField_a_of_type_Spn, 3, null);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: mVideoPlayerWrapper.seekTo() position=" + paramInt);
      }
      a(this.jdField_a_of_type_Spn, paramspk, false);
    }
    do
    {
      do
      {
        return;
        if (paramspk == null) {
          break;
        }
        this.jdField_b_of_type_Spk = paramspk;
        paramspk = this.jdField_b_of_type_Spk;
        b(1);
        paramspk.jdField_d_of_type_Long = paramInt;
        a(paramspk);
      } while (!QLog.isColorLevel());
      QLog.w(jdField_a_of_type_JavaLangString, 2, "resume(): mCurrenPlayVideoParam = null, playVideo: " + paramspk.jdField_c_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: param = null && mVideoPlayerWrapper = null");
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if ((this.jdField_b_of_type_Spk != null) && (this.jdField_a_of_type_Spn != null)) {
      a(this.jdField_b_of_type_Spk.jdField_c_of_type_Long, paramInt);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "stop , from : " + paramInt);
      }
      return;
      if (this.jdField_a_of_type_Spn != null)
      {
        a(this.jdField_b_of_type_Spk, this.jdField_a_of_type_Spn, 0, null);
        this.jdField_a_of_type_Spn.l();
        this.jdField_a_of_type_Spn = null;
        this.jdField_b_of_type_Spk = null;
      }
      else if (this.jdField_b_of_type_Spk != null)
      {
        a(this.jdField_b_of_type_Spk, this.jdField_a_of_type_Spn, 0, null);
        this.jdField_a_of_type_Spn = null;
        this.jdField_b_of_type_Spk = null;
      }
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "player stop [async]  stopID : " + paramLong + ", from : " + paramInt);
    }
    if ((this.jdField_a_of_type_Spn != null) && (this.jdField_b_of_type_Spk != null) && (this.jdField_b_of_type_Spk.jdField_c_of_type_Long == paramLong))
    {
      this.jdField_b_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setKeepScreenOn(false);
      a(this.jdField_b_of_type_Spk, this.jdField_a_of_type_Spn, 0, null);
      this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_a_of_type_Long = this.jdField_a_of_type_Spn.a(false);
      this.jdField_b_of_type_Spk.jdField_d_of_type_Long = a();
      sqb.a.a(this.jdField_b_of_type_Spk.j, this.jdField_b_of_type_Spk.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Spk.jdField_d_of_type_Long, this.jdField_a_of_type_Spn.b());
      if ((this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_d_of_type_Long == 0L) && (this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_b_of_type_Long != 0L)) {
        this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_b_of_type_Long);
      }
      this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_a_of_type_Float = ((float)this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_a_of_type_Long / this.jdField_b_of_type_Spk.jdField_b_of_type_Int);
      this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.n = this.jdField_a_of_type_Spn.c();
      this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_f_of_type_Int = this.jdField_a_of_type_Spn.e();
      this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_g_of_type_Int = this.jdField_a_of_type_Spn.f();
      this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_c_of_type_Boolean = this.jdField_a_of_type_Spn.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_q_of_type_Long = this.jdField_a_of_type_Spn.jdField_b_of_type_Long;
      this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_p_of_type_Long = this.jdField_a_of_type_Spn.jdField_a_of_type_Long;
      this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.r = this.jdField_a_of_type_Spn.g();
      if ((this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_d_of_type_Long == 0L))
      {
        this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_b_of_type_Long);
        this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_f_of_type_Long = this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_d_of_type_Long;
      }
      this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_l_of_type_Int = c();
      this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_m_of_type_Int = d();
      Object localObject;
      int i;
      int j;
      boolean bool;
      if (this.jdField_c_of_type_Spk != null)
      {
        localObject = this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa;
        i = this.jdField_c_of_type_Spk.jdField_a_of_type_Int;
        j = this.jdField_b_of_type_Spk.jdField_a_of_type_Int;
        if (this.jdField_b_of_type_Spk.jdField_m_of_type_Int == 3) {
          bool = true;
        }
      }
      for (((rqa)localObject).s = pkh.a(i, j, bool);; this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.s = -1)
      {
        this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_d_of_type_Int = this.jdField_b_of_type_Spk.jdField_m_of_type_Int;
        paramLong = this.jdField_a_of_type_Spn.b();
        localObject = this.jdField_a_of_type_Spn.a();
        this.jdField_a_of_type_Spn.a(this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.b());
        this.jdField_a_of_type_Spn.l();
        a(this.jdField_b_of_type_Spk);
        pqe.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), pkh.a(), true, this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.a());
        olv.a(this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa);
        pqe.a(true, this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_d_of_type_Boolean, this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_g_of_type_Int, this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_a_of_type_Int, this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_d_of_type_Long, 56, this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_a_of_type_JavaLangString);
        if ((this.jdField_b_of_type_Spk.jdField_d_of_type_Long > 0L) && (this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_a_of_type_Long > 0L)) {
          ThreadManager.post(new VideoPlayManager.9(this, this.jdField_b_of_type_Spk, this.jdField_a_of_type_Spz, paramLong, (String)localObject, this.jdField_b_of_type_Boolean, paramInt), 5, null, true);
        }
        this.e = false;
        this.jdField_c_of_type_Spk = this.jdField_b_of_type_Spk;
        this.jdField_b_of_type_Spk = null;
        this.jdField_a_of_type_Spn = null;
        return;
        bool = false;
        break;
      }
    }
    QLog.e("Q.readinjoy.video", 1, "stop : current player is null or articleID is not equal!");
  }
  
  public void a(ReportConstants.VideoEndType paramVideoEndType)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = paramVideoEndType;
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(ses paramses)
  {
    if ((paramses == null) || (!(paramses instanceof spk))) {}
    spn localspn;
    do
    {
      do
      {
        return;
        if (!sqp.a(this.jdField_a_of_type_AndroidAppActivity)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "playVideo in call return");
      return;
      paramses = (spk)paramses;
      try
      {
        this.jdField_d_of_type_Spk = null;
        this.jdField_a_of_type_Spk = null;
        if (this.jdField_a_of_type_Sqd != null) {
          this.jdField_a_of_type_Sqd.a(paramses);
        }
        if (!this.jdField_a_of_type_Spp.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "start install tencent sdk plugin");
          }
          this.jdField_b_of_type_Spk = paramses;
          a(this.jdField_b_of_type_Spk, null, 4, null);
          this.jdField_a_of_type_Spp.a();
          return;
        }
      }
      catch (Exception paramses)
      {
        paramses.printStackTrace();
        QLog.e("Q.readinjoy.video", 1, "playVideo error:", paramses);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "play video start ! playParams : " + paramses.toString());
      }
      this.jdField_a_of_type_Boolean = true;
      localspn = a(paramses);
      this.jdField_a_of_type_Spn = localspn;
      this.jdField_b_of_type_Spk = paramses;
    } while (this.jdField_a_of_type_Spn == null);
    a(this.jdField_b_of_type_Spk, this.jdField_a_of_type_Spn, 1, null);
    paramses.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
    this.jdField_a_of_type_Spn.a(paramses.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup);
    stv localstv = this.jdField_a_of_type_Spn.a();
    if ((localstv == null) || (localstv.a() == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "playVideo failed, because get videoView == null!");
      a(this.jdField_b_of_type_Spk, null, 6, "videoview null");
      this.jdField_a_of_type_Spn = null;
      this.jdField_b_of_type_Spk = null;
      return;
    }
    paramses.jdField_a_of_type_Stv = localstv;
    localstv.a().setId(2131376175);
    paramses.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setKeepScreenOn(true);
    this.jdField_a_of_type_Spn.b(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.o = 0;
    this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_p_of_type_Int = 0;
    this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_q_of_type_Int = 0;
    this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_g_of_type_Boolean = false;
    this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.h = false;
    ThreadManager.executeOnSubThread(new VideoPlayManager.7(this, localspn, paramses));
  }
  
  public void a(sfx paramsfx)
  {
    paramsfx.a(this);
  }
  
  public void a(sge paramsge)
  {
    this.jdField_a_of_type_Sge = paramsge;
  }
  
  public void a(spi paramspi)
  {
    if ((paramspi != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramspi))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramspi);
    }
  }
  
  public void a(spl paramspl)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null) {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramspl);
  }
  
  public void a(spz paramspz)
  {
    this.jdField_a_of_type_Spz = paramspz;
  }
  
  public void a(sqd paramsqd)
  {
    this.jdField_a_of_type_Sqd = paramsqd;
    this.jdField_a_of_type_Sqd.a(this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk success!");
      }
      if (this.jdField_b_of_type_Spk != null) {
        a(this.jdField_b_of_type_Spk);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk fail!");
    }
    a(this.jdField_b_of_type_Spk, this.jdField_a_of_type_Spn, 6, "install failure");
    this.jdField_b_of_type_Spk = null;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Spn != null) && (this.jdField_a_of_type_Spn.l());
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long b()
  {
    if (this.jdField_b_of_type_Spk == null) {
      return -1L;
    }
    return this.jdField_b_of_type_Spk.jdField_c_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b()
  {
    this.jdField_d_of_type_Boolean = false;
    e(false);
  }
  
  public void b(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void b(spi paramspi)
  {
    if ((paramspi != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramspi);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Spn != null) && (this.jdField_a_of_type_Spn.f());
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Spn != null) {
      return this.jdField_a_of_type_Spn.c();
    }
    return -1;
  }
  
  public long c()
  {
    if (this.jdField_b_of_type_Spk == null) {
      return 0L;
    }
    return this.jdField_b_of_type_Spk.jdField_b_of_type_Long;
  }
  
  public void c()
  {
    f(false);
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Spn != null) {
      this.jdField_a_of_type_Spn.a(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this.jdField_b_of_type_Spk != null)
    {
      bool = paramBoolean;
      if (this.jdField_b_of_type_Spk.jdField_b_of_type_Boolean) {
        bool = true;
      }
    }
    if (this.jdField_a_of_type_Spn != null) {
      this.jdField_a_of_type_Spn.c(bool);
    }
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Spn != null) {
      return this.jdField_a_of_type_Spn.d();
    }
    return -1;
  }
  
  public long d()
  {
    if (this.jdField_a_of_type_Spn != null) {
      return this.jdField_a_of_type_Spn.b();
    }
    return 0L;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : destroy !");
    }
    a(ReportConstants.VideoEndType.EXIT_SCENE);
    b(7);
    if (this.jdField_a_of_type_Spn != null)
    {
      this.jdField_a_of_type_Spn.l();
      this.jdField_a_of_type_Spn = null;
    }
    if (this.jdField_b_of_type_Spk != null) {
      this.jdField_b_of_type_Spk = null;
    }
    this.jdField_a_of_type_Spp.b();
    this.jdField_a_of_type_Spp = null;
    try
    {
      this.jdField_a_of_type_AndroidAppActivity = null;
      sqp.a().b(this);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        spn localspn = (spn)((WeakReference)localIterator.next()).get();
        if ((localspn != null) && (!localspn.jdField_a_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper : " + localspn.toString() + " not release");
          }
          localspn.l();
        }
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
    if (this.jdField_a_of_type_Sqd != null)
    {
      this.jdField_a_of_type_Sqd.n();
      this.jdField_a_of_type_Sqd = null;
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = null;
    this.e = false;
  }
  
  public void d(int paramInt)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = true;
      if (paramInt != 0) {
        a(ReportConstants.VideoEndType.EXIT_SCENE);
      }
      if ((this.jdField_b_of_type_Spk != null) && ((this.jdField_b_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo))) {
        ohz.b((AdvertisementInfo)this.jdField_b_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onVisiable() isPause()=" + d() + ", mPausedByMannul:" + this.e);
      }
      if ((this.jdField_b_of_type_Spk != null) && (this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa != null)) {
        this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if ((d()) && (!this.e)) {
        c();
      }
      if (this.jdField_a_of_type_Sqd != null)
      {
        this.jdField_a_of_type_Sqd.a();
        if (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
          break label196;
        }
        this.jdField_a_of_type_Sqd.a(false);
      }
    }
    for (;;)
    {
      srh.a().a(this.jdField_a_of_type_AndroidAppActivity);
      return;
      label196:
      this.jdField_a_of_type_Sqd.a(true);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_Spn == null) || (this.jdField_b_of_type_Spk == null)) {}
    do
    {
      return false;
      if (a() == 5)
      {
        if ((!this.jdField_a_of_type_Spn.e()) && (QLog.isColorLevel())) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return true. getCurPlayState is PLAY_STATE_PAUSED. But mVideoPlayerWrapper.isPause() == false;");
        }
        return true;
      }
    } while ((!this.jdField_a_of_type_Spn.e()) || (!QLog.isColorLevel()));
    QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return false. getCurPlayState is " + spm.a(a()) + ". But mVideoPlayerWrapper.isPause() == true;");
    return false;
  }
  
  public void e()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onUnVisiable() isPlaying()=" + b() + ", isOpening()=" + f());
      }
      if (!b()) {
        break label138;
      }
      a();
      a(this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_a_of_type_Long, this.jdField_a_of_type_Spn.b(), this.jdField_a_of_type_Spn.a(), this.jdField_b_of_type_Spk, false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Sqd != null)
      {
        this.jdField_a_of_type_Sqd.b();
        this.jdField_a_of_type_Sqd.a(false);
      }
      srh.a().b(this.jdField_a_of_type_AndroidAppActivity);
      return;
      label138:
      if (f())
      {
        a(ReportConstants.VideoEndType.EXIT_SCENE);
        b(8);
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Spn != null) && (this.jdField_a_of_type_Spn.f()))
    {
      this.jdField_a_of_type_Spn.f();
      this.e = paramBoolean;
      if (!NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext())) {
        this.jdField_a_of_type_Spn.j();
      }
      a(this.jdField_b_of_type_Spk, this.jdField_a_of_type_Spn, 5, Boolean.valueOf(this.e));
      this.jdField_b_of_type_Spk.jdField_d_of_type_Long = a();
      this.jdField_b_of_type_Spk.jdField_a_of_type_Rqa.jdField_a_of_type_Long = this.jdField_a_of_type_Spn.a(false);
      BaseArticleInfo localBaseArticleInfo = this.jdField_b_of_type_Spk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (uks.a((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && ((this.jdField_b_of_type_Spk.jdField_b_of_type_Boolean) || (localBaseArticleInfo.mChannelID == 56L)))
      {
        int j = 1;
        int i = 11;
        if (localBaseArticleInfo.mChannelID == 56L)
        {
          j = 9;
          i = 4;
        }
        ois.a(new ufy().a(this.jdField_a_of_type_AndroidAppActivity).a(6).b(i).a((AdvertisementInfo)localBaseArticleInfo).a(ois.a(((AdvertisementInfo)localBaseArticleInfo).adbt, (int)this.jdField_b_of_type_Spk.jdField_d_of_type_Long, ((AdvertisementInfo)localBaseArticleInfo).getAdbf(), 0, ((AdvertisementInfo)localBaseArticleInfo).adpa, ((AdvertisementInfo)localBaseArticleInfo).adpb, localBaseArticleInfo.mVideoDuration * 1000, j, 0, ((AdvertisementInfo)localBaseArticleInfo).videoReplayCount, a(), ((AdvertisementInfo)localBaseArticleInfo).isClickReplay, false)).a());
        ((AdvertisementInfo)localBaseArticleInfo).isClickReplay = false;
        ((AdvertisementInfo)localBaseArticleInfo).adbt = ((int)this.jdField_b_of_type_Spk.jdField_d_of_type_Long);
      }
    }
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_Spn != null) && (a() == 2);
  }
  
  void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkPlayStateAfterPhoneCall isVisible() = " + g());
    }
    if (!g()) {
      return;
    }
    c();
  }
  
  public void f(boolean paramBoolean)
  {
    if (d())
    {
      if (!sqp.a(this.jdField_a_of_type_AndroidAppActivity)) {
        break label33;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "VideoPlayManager resume, in call return");
      }
    }
    return;
    label33:
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : resume(), mannulResume:" + paramBoolean + ", mPausedByMannul:" + this.e);
    }
    this.jdField_a_of_type_Spn.e();
    this.jdField_a_of_type_Boolean = true;
    this.e = false;
    a(this.jdField_b_of_type_Spk, this.jdField_a_of_type_Spn, 3, null);
    a(this.jdField_a_of_type_Spn, this.jdField_b_of_type_Spk, paramBoolean);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_Spn != null) && (this.jdField_a_of_type_Spn.b());
  }
  
  public boolean g()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_Sqd != null) {
      return this.jdField_a_of_type_Sqd.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     spg
 * JD-Core Version:    0.7.0.1
 */