import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
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
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
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
import org.json.JSONObject;

public class rvy
  implements rlq, rwj
{
  public static final String a;
  protected int a;
  private volatile Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private ArrayList<Pair<Integer, Bitmap>> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Integer, rwf> jdField_a_of_type_JavaUtilHashMap;
  private Map<String, WeakReference<rwf>> jdField_a_of_type_JavaUtilMap;
  private Set<rwd> jdField_a_of_type_JavaUtilSet;
  private CopyOnWriteArrayList<rwa> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private rmn jdField_a_of_type_Rmn;
  private rwb jdField_a_of_type_Rwb = new rwb(this);
  public rwc a;
  private rwf jdField_a_of_type_Rwf;
  private rwh jdField_a_of_type_Rwh;
  private rwr jdField_a_of_type_Rwr;
  private rwu jdField_a_of_type_Rwu;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private String jdField_b_of_type_JavaLangString;
  private rwc jdField_b_of_type_Rwc;
  private boolean jdField_b_of_type_Boolean = true;
  private rwc jdField_c_of_type_Rwc;
  private volatile boolean jdField_c_of_type_Boolean;
  private rwc jdField_d_of_type_Rwc;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + rvy.class.getSimpleName();
  }
  
  public rvy(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : create a new manager !");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Rwh = new rwh();
    this.jdField_a_of_type_Rwh.a(this);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    rxg.a().a(this);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 3) && (!this.jdField_c_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "pause for not visible，isSubThread:" + paramBoolean);
      }
      a();
    }
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, rwc paramrwc, boolean paramBoolean)
  {
    if (AdvertisementInfo.isAdvertisementInfo(paramrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      return;
    }
    paramString = sbe.a(paramrwc).a("dt_vdend").b("8014").e(paramLong2).e(paramString);
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      sbd.a(paramString.a(i).b(1).b(System.currentTimeMillis()).c(paramLong1));
      return;
    }
  }
  
  private void a(rwc paramrwc)
  {
    paramrwc.jdField_a_of_type_Qwv.jdField_t_of_type_Long = rxy.a().a();
    paramrwc.jdField_a_of_type_Qwv.jdField_m_of_type_JavaLangString = ryh.a().a();
  }
  
  private void a(rwc paramrwc, rwf paramrwf, int paramInt, Object paramObject)
  {
    int i;
    try
    {
      i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (paramInt != i)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "changeStateAndNotify(): " + rwe.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + " ===> " + rwe.a(paramInt) + ", extra = " + paramObject + ", videoPlayParam=" + paramrwc + ", videoPlayWrapper=" + paramrwf);
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
            rwa localrwa = (rwa)localIterator.next();
            if (localrwa != null) {
              localrwa.a(paramrwc, paramrwf, i, paramInt, paramObject);
            }
          }
        }
        a(paramInt, false);
      }
    }
    finally {}
    for (;;)
    {
      return;
      label197:
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.6(this, paramrwc, paramrwf, i, paramInt, paramObject));
    }
  }
  
  private void a(rwf paramrwf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "video play completion!");
    }
    if (this.jdField_a_of_type_Rwf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video", 2, "onCompletion return for mVideoPlayerWrapper is null");
      }
      return;
    }
    long l1 = this.jdField_a_of_type_Rwf.a(true);
    this.jdField_d_of_type_Rwc = this.jdField_b_of_type_Rwc;
    this.jdField_c_of_type_Rwc = this.jdField_b_of_type_Rwc;
    rwc localrwc;
    Object localObject;
    qwv localqwv;
    int i;
    int j;
    boolean bool;
    if (this.jdField_b_of_type_Rwc != null)
    {
      localrwc = this.jdField_b_of_type_Rwc;
      localObject = this.jdField_a_of_type_Rwr;
      localrwc.jdField_a_of_type_Qwv.jdField_a_of_type_Long = l1;
      localrwc.jdField_d_of_type_Long = a();
      if ((localrwc.jdField_a_of_type_Qwv.jdField_a_of_type_Long == 0L) && (localrwc.jdField_a_of_type_Qwv.jdField_d_of_type_Long == 0L) && (localrwc.jdField_a_of_type_Qwv.jdField_b_of_type_Long != 0L)) {
        localrwc.jdField_a_of_type_Qwv.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - localrwc.jdField_a_of_type_Qwv.jdField_b_of_type_Long);
      }
      localrwc.jdField_a_of_type_Qwv.jdField_a_of_type_Float = ((float)localrwc.jdField_a_of_type_Qwv.jdField_a_of_type_Long / localrwc.jdField_b_of_type_Int);
      localrwc.jdField_a_of_type_Qwv.jdField_a_of_type_Boolean = true;
      localrwc.jdField_a_of_type_Qwv.jdField_b_of_type_Boolean = true;
      localrwc.jdField_a_of_type_Qwv.n = paramrwf.c();
      localrwc.jdField_a_of_type_Qwv.jdField_f_of_type_Int = paramrwf.e();
      localrwc.jdField_a_of_type_Qwv.jdField_g_of_type_Int = paramrwf.f();
      localrwc.jdField_a_of_type_Qwv.jdField_c_of_type_Boolean = paramrwf.jdField_b_of_type_Boolean;
      localrwc.jdField_a_of_type_Qwv.jdField_q_of_type_Long = paramrwf.jdField_b_of_type_Long;
      localrwc.jdField_a_of_type_Qwv.jdField_p_of_type_Long = paramrwf.jdField_a_of_type_Long;
      localrwc.jdField_a_of_type_Qwv.r = paramrwf.g();
      localrwc.jdField_a_of_type_Qwv.jdField_l_of_type_Int = c();
      localrwc.jdField_a_of_type_Qwv.jdField_m_of_type_Int = d();
      if (this.jdField_c_of_type_Rwc == null) {
        break label865;
      }
      localqwv = localrwc.jdField_a_of_type_Qwv;
      i = this.jdField_c_of_type_Rwc.jdField_a_of_type_Int;
      j = localrwc.jdField_a_of_type_Int;
      if (localrwc.jdField_m_of_type_Int != 3) {
        break label859;
      }
      bool = true;
    }
    label859:
    label865:
    for (localqwv.s = ozs.a(i, j, bool);; localrwc.jdField_a_of_type_Qwv.s = -1)
    {
      localrwc.jdField_a_of_type_Qwv.jdField_d_of_type_Int = localrwc.jdField_m_of_type_Int;
      localrwc.jdField_a_of_type_Qwv.jdField_l_of_type_Boolean = paramrwf.p();
      a(localrwc);
      ozs.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), ozs.a(), true, localrwc.jdField_a_of_type_Qwv.a());
      ocr.a(localrwc.jdField_a_of_type_Qwv);
      ozs.a(true, localrwc.jdField_a_of_type_Qwv.jdField_d_of_type_Boolean, localrwc.jdField_a_of_type_Qwv.jdField_g_of_type_Int, localrwc.jdField_a_of_type_Qwv.jdField_a_of_type_Int, localrwc.jdField_a_of_type_Qwv.jdField_d_of_type_Long, 56, localrwc.jdField_a_of_type_Qwv.jdField_c_of_type_JavaLangString, localrwc.jdField_a_of_type_Qwv.jdField_a_of_type_JavaLangString);
      long l2 = this.jdField_a_of_type_Rwf.b();
      paramrwf = this.jdField_a_of_type_Rwf.a();
      if (localrwc.jdField_a_of_type_Qwv.jdField_a_of_type_Long > 0L)
      {
        new JSONObject();
        ThreadManager.post(new VideoPlayManager.3(this, localrwc, (rwr)localObject), 5, null, true);
      }
      bdll.b(null, "dc00899", "Pb_account_lifeservice", "", "0X800709B", "0X800709B", 0, 0, "", "", "", localrwc.jdField_c_of_type_JavaLangString);
      localObject = localrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localObject != null) && (tqa.a((int)((BaseArticleInfo)localObject).mChannelID)) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && (localrwc.jdField_b_of_type_Boolean))
      {
        i = (int)l1;
        nzq.a(new tlx().a(this.jdField_a_of_type_AndroidAppActivity).a(nzq.jdField_f_of_type_Int).b(nzq.S).a((AdvertisementInfo)localObject).a(nzq.a(((AdvertisementInfo)localObject).adbt, i, ((AdvertisementInfo)localObject).getAdbf(), 1, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, 1, 0)).a());
      }
      localObject = localrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localObject != null) && (((BaseArticleInfo)localObject).mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject))) {
        nzq.a(new tlx().a(this.jdField_a_of_type_AndroidAppActivity).a(nzq.jdField_f_of_type_Int).b(nzq.O).a((AdvertisementInfo)localObject).a(nzq.a(((AdvertisementInfo)localObject).adbt, ((BaseArticleInfo)localObject).mVideoDuration * 1000, ((AdvertisementInfo)localObject).getAdbf(), 1, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, nzq.aP, 0)).a());
      }
      a(l1, l2, paramrwf, localrwc, false);
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.4(this));
      return;
      bool = false;
      break;
    }
  }
  
  private void a(rwf paramrwf, Object paramObject)
  {
    long l = 0L;
    paramObject = this.jdField_b_of_type_Rwc;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onVideoPrepared() mIsOpenedVideo=" + this.jdField_a_of_type_Boolean + "   mVisable:" + this.jdField_c_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Rwf == paramrwf) && (paramObject != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramObject.jdField_a_of_type_Int, true);
        if ((paramObject.jdField_a_of_type_Qwv != null) && (paramObject.jdField_a_of_type_Qwv.jdField_d_of_type_Long == 0L))
        {
          paramObject.jdField_a_of_type_Qwv.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - paramObject.jdField_a_of_type_Qwv.jdField_b_of_type_Long);
          qwv localqwv = paramObject.jdField_a_of_type_Qwv;
          localqwv.jdField_f_of_type_Long += paramObject.jdField_a_of_type_Qwv.jdField_d_of_type_Long;
          localqwv = paramObject.jdField_a_of_type_Qwv;
          localqwv.jdField_c_of_type_Int += 1;
          if ((paramObject.jdField_a_of_type_Qwv != null) && (QLog.isColorLevel())) {
            QLog.d("Q.readinjoy.video", 2, "video player ready. from open. prepare cost : " + paramObject.jdField_a_of_type_Qwv.jdField_d_of_type_Long);
          }
        }
        a(paramObject, this.jdField_a_of_type_Rwf, 2, null);
        if ((rxg.a(this.jdField_a_of_type_AndroidAppActivity)) || (!GesturePWDUtils.isAppOnForeground(this.jdField_a_of_type_AndroidAppActivity)) || (this.jdField_a_of_type_Rmn == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onVideoPrepared start,in call stop.background:" + GesturePWDUtils.isAppOnForeground(this.jdField_a_of_type_AndroidAppActivity));
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.1(this));
        }
        for (;;)
        {
          paramrwf = new StringBuilder().append(anzj.a(2131715107)).append(paramrwf.jdField_b_of_type_Boolean).append(anzj.a(2131715124));
          if (paramObject.jdField_a_of_type_Qwv != null) {
            l = paramObject.jdField_a_of_type_Qwv.jdField_d_of_type_Long;
          }
          paramrwf = l;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.readinjoy.video", 2, paramrwf);
          return;
          paramrwf.d();
          a(paramObject, this.jdField_a_of_type_Rwf, 3, null);
          a(paramrwf, paramObject, false);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video", 2, "video player ready,but has error!");
  }
  
  private void a(rwf paramrwf, rwc paramrwc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "doOpenVideo executed On SubThread, busitype:" + paramrwc.jdField_f_of_type_Int + " vid:" + paramrwc.jdField_c_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_Rwf == null) || (this.jdField_a_of_type_Rwf != paramrwf)) {
      return;
    }
    if (TextUtils.isEmpty(paramrwc.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Rwb.a(paramrwf, 201, 61, 0, "vid null", null);
      return;
    }
    if ((paramrwc.jdField_f_of_type_Int == 2) || (paramrwc.jdField_f_of_type_Int == 6))
    {
      scq localscq = scq.a();
      localscq.a(paramrwc.jdField_c_of_type_JavaLangString, new rvz(this, paramrwf, paramrwc, localscq));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
      {
        paramrwf.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramrwc.g, paramrwc.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramrwc.jdField_c_of_type_JavaLangString, paramrwf.jdField_b_of_type_Boolean);
      }
      tzq.a(paramrwc.j, paramrwc.jdField_c_of_type_JavaLangString, 0, 0);
      return;
      if (tqa.j(paramrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        ((AdvertisementInfo)paramrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adbt = ((int)paramrwc.jdField_d_of_type_Long);
        if (paramrwc.jdField_d_of_type_Long == 0L)
        {
          ((AdvertisementInfo)paramrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpa = 1;
          ((AdvertisementInfo)paramrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpb = 1;
        }
        paramrwf.a("", paramrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid, 101, paramrwc.jdField_d_of_type_Long, paramrwc.e, paramrwc.jdField_b_of_type_Int);
      }
      else
      {
        paramrwf.a(paramrwc.jdField_c_of_type_JavaLangString, 1, paramrwc.jdField_d_of_type_Long);
      }
    }
  }
  
  private void a(rwf paramrwf, rwc paramrwc, boolean paramBoolean)
  {
    if (AdvertisementInfo.isAdvertisementInfo(paramrwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      return;
    }
    paramrwf = sbe.a(paramrwc).a("dt_vdstart").b("8014").e(paramrwf.b()).e(paramrwf.a());
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      sbd.a(paramrwf.a(i).a(System.currentTimeMillis()).b(1));
      return;
    }
  }
  
  private boolean a(rwf paramrwf, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      paramObject = paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "video play has error ! " + paramObject);
      }
      this.jdField_a_of_type_Rwc = this.jdField_b_of_type_Rwc;
      if (this.jdField_b_of_type_Rwc != null) {
        tzq.a(this.jdField_b_of_type_Rwc.j, this.jdField_b_of_type_Rwc.jdField_c_of_type_JavaLangString, 1, paramInt2);
      }
      if (paramrwf == this.jdField_a_of_type_Rwf) {
        this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.5(this, paramInt1, paramInt2, paramString, paramrwf));
      }
      return true;
    }
  }
  
  private boolean a(rwf paramrwf, int paramInt, Object paramObject)
  {
    if ((paramrwf != this.jdField_a_of_type_Rwf) || (a() == 5) || (this.jdField_b_of_type_Rwc == null) || (this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv == null)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onInfo(): what:" + paramInt + ",extra:" + paramObject + ", getCurPlayState == paused, just ignore.");
      }
    }
    qwv localqwv;
    label499:
    do
    {
      do
      {
        do
        {
          return false;
          localqwv = this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv;
          switch (paramInt)
          {
          default: 
            return false;
          case 28: 
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
            }
            localqwv.o += 1;
            rpt.b(this.jdField_a_of_type_AndroidAppActivity, anzj.a(2131715101));
            return false;
          case 112: 
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onInfo(): video start buffering !");
            }
            a(this.jdField_b_of_type_Rwc, this.jdField_a_of_type_Rwf, 4, null);
            localqwv.e = SystemClock.uptimeMillis();
            return false;
          case 113: 
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onInfo(): video end buffering ! isPause=" + d());
            }
            if (!d()) {
              a(this.jdField_b_of_type_Rwc, this.jdField_a_of_type_Rwf, 3, null);
            }
            localqwv.jdField_f_of_type_Long += SystemClock.uptimeMillis() - localqwv.e;
            localqwv.jdField_c_of_type_Int += 1;
            return false;
          case 40: 
            for (;;)
            {
              try
              {
                paramrwf = new JSONObject((String)paramObject);
                paramInt = paramrwf.optInt("decoderMode", 0);
              }
              catch (Exception paramrwf)
              {
                try
                {
                  i = paramrwf.optInt("skipFrameCount", 1);
                  if (i > 0)
                  {
                    localqwv.jdField_p_of_type_Int += i;
                    localqwv.jdField_q_of_type_Int += i;
                  }
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_SKIP_ONE_FRAME decoderMode = " + paramInt + ", skipFrameCount = " + i + ", totalSkipCount = " + localqwv.jdField_p_of_type_Int + ", finalSkipCount = " + localqwv.jdField_q_of_type_Int);
                  return false;
                }
                catch (Exception paramrwf)
                {
                  int i;
                  break label499;
                }
                paramrwf = paramrwf;
                paramInt = 0;
              }
              QLog.e(jdField_a_of_type_JavaLangString, 1, "onInfo() PLAYER_INFO_SKIP_ONE_FRAME", paramrwf);
              i = 0;
            }
          case 39: 
            QLog.e(jdField_a_of_type_JavaLangString, 1, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
            localqwv.jdField_f_of_type_Boolean = true;
            if ((paramObject instanceof String)) {
              localqwv.jdField_f_of_type_JavaLangString = ((String)paramObject);
            }
            rpt.b(this.jdField_a_of_type_AndroidAppActivity, anzj.a(2131715126));
            return false;
          case 41: 
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_CHANGE_HW_BACKUP_URL");
            }
            localqwv.jdField_g_of_type_Boolean = true;
            rpt.b(this.jdField_a_of_type_AndroidAppActivity, anzj.a(2131715109));
            return false;
          }
        } while (paramObject == null);
        paramrwf = ((String)paramObject).split(":", 2);
      } while ((paramrwf == null) || (paramrwf.length != 2));
      if (QLog.isColorLevel()) {
        QLog.d("VideoPlayManager", 2, "Performance PERFORMANCE_REPORT videoPlayVideoParam:" + this.jdField_b_of_type_Rwc + "  method:" + paramrwf[0] + "\ntimeJson:" + paramrwf[1]);
      }
    } while (!"prepare".equals(paramrwf[0]));
    localqwv.jdField_l_of_type_JavaLangString = paramrwf[1];
    return false;
    rle.a.a(paramObject, localqwv);
    return false;
    localqwv.v = (SystemClock.uptimeMillis() - localqwv.jdField_b_of_type_Long);
    localqwv.w = (SystemClock.uptimeMillis() - localqwv.jdField_c_of_type_Long);
    return false;
    localqwv.jdField_t_of_type_Int = ((Long)paramObject).intValue();
    return false;
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_Rwf != null) {
      i = this.jdField_a_of_type_Rwf.b();
    }
    if (i == this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) {
      return i;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.readinjoy.video", 2, "getCurPlayState, should not happen...: mVideoPlayerWrapper.getCurrentStatus() = " + rwe.a(i) + ",mState.get()=" + rwe.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Rwf != null) {
      return this.jdField_a_of_type_Rwf.a();
    }
    return 0L;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Rwf != null) {
      return this.jdField_a_of_type_Rwf.a();
    }
    return null;
  }
  
  public rwc a()
  {
    return this.jdField_b_of_type_Rwc;
  }
  
  public rwf a(String paramString)
  {
    paramString = (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return (rwf)paramString.get();
    }
    return null;
  }
  
  public rwf a(rwc paramrwc)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return null;
    }
    rwf localrwf = new rwf(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    localrwf.e(true);
    localrwf.a(this.jdField_a_of_type_Rwb);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "getVideoPlayer new instant!");
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramrwc.a(), new WeakReference(localrwf));
    return localrwf;
  }
  
  public rwu a()
  {
    return this.jdField_a_of_type_Rwu;
  }
  
  public void a()
  {
    e(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Rwf != null) {
      this.jdField_a_of_type_Rwf.b(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video", 2, "setXYaxis value:" + paramInt);
    }
  }
  
  public void a(int paramInt, rwc paramrwc)
  {
    this.jdField_d_of_type_Rwc = null;
    if ((this.jdField_b_of_type_Rwc != null) && (this.jdField_a_of_type_Rwf != null))
    {
      if (this.jdField_a_of_type_Rwf.b() == 2) {
        this.jdField_a_of_type_Rwf.d();
      }
      this.jdField_a_of_type_Rwf.a(paramInt);
      a(this.jdField_b_of_type_Rwc, this.jdField_a_of_type_Rwf, 3, null);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: mVideoPlayerWrapper.seekTo() position=" + paramInt);
      }
      a(this.jdField_a_of_type_Rwf, paramrwc, false);
    }
    do
    {
      do
      {
        return;
        if (paramrwc == null) {
          break;
        }
        this.jdField_b_of_type_Rwc = paramrwc;
        paramrwc = this.jdField_b_of_type_Rwc;
        b(1);
        paramrwc.jdField_d_of_type_Long = paramInt;
        a(paramrwc);
      } while (!QLog.isColorLevel());
      QLog.w(jdField_a_of_type_JavaLangString, 2, "resume(): mCurrenPlayVideoParam = null, playVideo: " + paramrwc.jdField_c_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: param = null && mVideoPlayerWrapper = null");
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "player stop [async]  stopID : " + paramLong + ", from : " + paramInt);
    }
    if ((this.jdField_a_of_type_Rwf != null) && (this.jdField_b_of_type_Rwc != null) && (this.jdField_b_of_type_Rwc.jdField_c_of_type_Long == paramLong))
    {
      this.jdField_b_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setKeepScreenOn(false);
      a(this.jdField_b_of_type_Rwc, this.jdField_a_of_type_Rwf, 0, null);
      this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_a_of_type_Long = this.jdField_a_of_type_Rwf.a(false);
      this.jdField_b_of_type_Rwc.jdField_d_of_type_Long = a();
      if ((this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_d_of_type_Long == 0L) && (this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_b_of_type_Long != 0L)) {
        this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_b_of_type_Long);
      }
      this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_a_of_type_Float = ((float)this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_a_of_type_Long / this.jdField_b_of_type_Rwc.jdField_b_of_type_Int);
      this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.n = this.jdField_a_of_type_Rwf.c();
      this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_f_of_type_Int = this.jdField_a_of_type_Rwf.e();
      this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_g_of_type_Int = this.jdField_a_of_type_Rwf.f();
      this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_c_of_type_Boolean = this.jdField_a_of_type_Rwf.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_q_of_type_Long = this.jdField_a_of_type_Rwf.jdField_b_of_type_Long;
      this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_p_of_type_Long = this.jdField_a_of_type_Rwf.jdField_a_of_type_Long;
      this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.r = this.jdField_a_of_type_Rwf.g();
      if ((this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_d_of_type_Long == 0L))
      {
        this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_b_of_type_Long);
        this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_f_of_type_Long = this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_d_of_type_Long;
      }
      this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_l_of_type_Int = c();
      this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_m_of_type_Int = d();
      if (this.jdField_c_of_type_Rwc != null)
      {
        localObject = this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv;
        paramInt = this.jdField_c_of_type_Rwc.jdField_a_of_type_Int;
        i = this.jdField_b_of_type_Rwc.jdField_a_of_type_Int;
        if (this.jdField_b_of_type_Rwc.jdField_m_of_type_Int == 3)
        {
          bool = true;
          ((qwv)localObject).s = ozs.a(paramInt, i, bool);
          this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_d_of_type_Int = this.jdField_b_of_type_Rwc.jdField_m_of_type_Int;
          paramLong = this.jdField_a_of_type_Rwf.b();
          localObject = this.jdField_a_of_type_Rwf.a();
          this.jdField_a_of_type_Rwf.l();
          a(this.jdField_b_of_type_Rwc);
          ozs.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), ozs.a(), true, this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.a());
          ocr.a(this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv);
          ozs.a(true, this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_d_of_type_Boolean, this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_g_of_type_Int, this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_a_of_type_Int, this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_d_of_type_Long, 56, this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_a_of_type_JavaLangString);
          if ((this.jdField_b_of_type_Rwc.jdField_d_of_type_Long > 0L) && (this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_a_of_type_Long > 0L)) {
            ThreadManager.post(new VideoPlayManager.9(this, this.jdField_b_of_type_Rwc, this.jdField_a_of_type_Rwr, paramLong, (String)localObject), 5, null, true);
          }
          this.jdField_d_of_type_Boolean = false;
          this.jdField_c_of_type_Rwc = this.jdField_b_of_type_Rwc;
          this.jdField_b_of_type_Rwc = null;
          this.jdField_a_of_type_Rwf = null;
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        Object localObject;
        int i;
        return;
        boolean bool = false;
        continue;
        this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.s = -1;
      }
    }
    QLog.w("Q.readinjoy.video", 2, "stop : current player is null or articleID is not equal!");
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(rld paramrld)
  {
    if ((paramrld == null) || (!(paramrld instanceof rwc))) {}
    do
    {
      return;
      if (!rxg.a(this.jdField_a_of_type_AndroidAppActivity)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "playVideo in call return");
    return;
    paramrld = (rwc)paramrld;
    try
    {
      this.jdField_d_of_type_Rwc = null;
      this.jdField_a_of_type_Rwc = null;
      if (this.jdField_a_of_type_Rwu != null) {
        this.jdField_a_of_type_Rwu.a(paramrld);
      }
      if (!this.jdField_a_of_type_Rwh.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "start install tencent sdk plugin");
        }
        this.jdField_b_of_type_Rwc = paramrld;
        a(this.jdField_b_of_type_Rwc, null, 4, null);
        this.jdField_a_of_type_Rwh.a();
        return;
      }
    }
    catch (Exception paramrld)
    {
      paramrld.printStackTrace();
      QLog.e("Q.readinjoy.video", 1, "playVideo error:", paramrld);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "play video start ! playParams : " + paramrld.toString());
    }
    this.jdField_a_of_type_Boolean = true;
    rwf localrwf = a(paramrld);
    this.jdField_a_of_type_Rwf = localrwf;
    this.jdField_b_of_type_Rwc = paramrld;
    a(this.jdField_b_of_type_Rwc, this.jdField_a_of_type_Rwf, 1, null);
    paramrld.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
    this.jdField_a_of_type_Rwf.a(paramrld.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup);
    sab localsab = this.jdField_a_of_type_Rwf.a();
    if ((localsab == null) || (localsab.a() == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "playVideo failed, because get videoView == null!");
      a(this.jdField_b_of_type_Rwc, null, 6, "videoview null");
      this.jdField_a_of_type_Rwf = null;
      this.jdField_b_of_type_Rwc = null;
      return;
    }
    paramrld.jdField_a_of_type_Sab = localsab;
    localsab.a().setId(2131376164);
    paramrld.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setKeepScreenOn(true);
    this.jdField_a_of_type_Rwf.b(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.o = 0;
    this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_p_of_type_Int = 0;
    this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_q_of_type_Int = 0;
    this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_g_of_type_Boolean = false;
    this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.h = false;
    ThreadManager.executeOnSubThread(new VideoPlayManager.7(this, localrwf, paramrld));
  }
  
  public void a(rmg paramrmg)
  {
    paramrmg.a(this);
  }
  
  public void a(rmn paramrmn)
  {
    this.jdField_a_of_type_Rmn = paramrmn;
  }
  
  public void a(rwa paramrwa)
  {
    if ((paramrwa != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramrwa))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramrwa);
    }
  }
  
  public void a(rwd paramrwd)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null) {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramrwd);
  }
  
  public void a(rwr paramrwr)
  {
    this.jdField_a_of_type_Rwr = paramrwr;
  }
  
  public void a(rwu paramrwu)
  {
    this.jdField_a_of_type_Rwu = paramrwu;
    this.jdField_a_of_type_Rwu.a(this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk success!");
      }
      if (this.jdField_b_of_type_Rwc != null) {
        a(this.jdField_b_of_type_Rwc);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk fail!");
    }
    a(this.jdField_b_of_type_Rwc, this.jdField_a_of_type_Rwf, 6, "install failure");
    this.jdField_b_of_type_Rwc = null;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Rwf != null) && (this.jdField_a_of_type_Rwf.l());
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long b()
  {
    if (this.jdField_b_of_type_Rwc == null) {
      return -1L;
    }
    return this.jdField_b_of_type_Rwc.jdField_c_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = false;
    e(false);
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_b_of_type_Rwc != null) && (this.jdField_a_of_type_Rwf != null)) {
      a(this.jdField_b_of_type_Rwc.jdField_c_of_type_Long, paramInt);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "stop , from : " + paramInt);
      }
      return;
      if (this.jdField_a_of_type_Rwf != null)
      {
        a(this.jdField_b_of_type_Rwc, this.jdField_a_of_type_Rwf, 0, null);
        this.jdField_a_of_type_Rwf.l();
        this.jdField_a_of_type_Rwf = null;
        this.jdField_b_of_type_Rwc = null;
      }
      else if (this.jdField_b_of_type_Rwc != null)
      {
        a(this.jdField_b_of_type_Rwc, this.jdField_a_of_type_Rwf, 0, null);
        this.jdField_a_of_type_Rwf = null;
        this.jdField_b_of_type_Rwc = null;
      }
    }
  }
  
  public void b(rwa paramrwa)
  {
    if ((paramrwa != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramrwa);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Rwf != null) && (this.jdField_a_of_type_Rwf.f());
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Rwf != null) {
      return this.jdField_a_of_type_Rwf.c();
    }
    return -1;
  }
  
  public long c()
  {
    if (this.jdField_b_of_type_Rwc == null) {
      return 0L;
    }
    return this.jdField_b_of_type_Rwc.jdField_b_of_type_Long;
  }
  
  public void c()
  {
    f(false);
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Rwf != null) {
      this.jdField_a_of_type_Rwf.a(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this.jdField_b_of_type_Rwc != null)
    {
      bool = paramBoolean;
      if (this.jdField_b_of_type_Rwc.jdField_b_of_type_Boolean) {
        bool = true;
      }
    }
    if (this.jdField_a_of_type_Rwf != null) {
      this.jdField_a_of_type_Rwf.c(bool);
    }
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Rwf != null) {
      return this.jdField_a_of_type_Rwf.d();
    }
    return -1;
  }
  
  public long d()
  {
    if (this.jdField_a_of_type_Rwf != null) {
      return this.jdField_a_of_type_Rwf.b();
    }
    return 0L;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : destroy !");
    }
    b(7);
    if (this.jdField_a_of_type_Rwf != null)
    {
      this.jdField_a_of_type_Rwf.l();
      this.jdField_a_of_type_Rwf = null;
    }
    if (this.jdField_b_of_type_Rwc != null) {
      this.jdField_b_of_type_Rwc = null;
    }
    this.jdField_a_of_type_Rwh.b();
    this.jdField_a_of_type_Rwh = null;
    try
    {
      this.jdField_a_of_type_AndroidAppActivity = null;
      rxg.a().b(this);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        rwf localrwf = (rwf)((WeakReference)localIterator.next()).get();
        if ((localrwf != null) && (!localrwf.jdField_a_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper : " + localrwf.toString() + " not release");
          }
          localrwf.l();
        }
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
    if (this.jdField_a_of_type_Rwu != null)
    {
      this.jdField_a_of_type_Rwu.n();
      this.jdField_a_of_type_Rwu = null;
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = null;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_Rwf == null) || (this.jdField_b_of_type_Rwc == null)) {}
    do
    {
      return false;
      if (a() == 5)
      {
        if ((!this.jdField_a_of_type_Rwf.e()) && (QLog.isColorLevel())) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return true. getCurPlayState is PLAY_STATE_PAUSED. But mVideoPlayerWrapper.isPause() == false;");
        }
        return true;
      }
    } while ((!this.jdField_a_of_type_Rwf.e()) || (!QLog.isColorLevel()));
    QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return false. getCurPlayState is " + rwe.a(a()) + ". But mVideoPlayerWrapper.isPause() == true;");
    return false;
  }
  
  public void e()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onUnVisiable() isPlaying()=" + b() + ", isOpening()=" + f());
      }
      if (!b()) {
        break label138;
      }
      a();
      a(this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_a_of_type_Long, this.jdField_a_of_type_Rwf.b(), this.jdField_a_of_type_Rwf.a(), this.jdField_b_of_type_Rwc, false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Rwu != null)
      {
        this.jdField_a_of_type_Rwu.b();
        this.jdField_a_of_type_Rwu.a(false);
      }
      rxy.a().b(this.jdField_a_of_type_AndroidAppActivity);
      return;
      label138:
      if (f()) {
        b(8);
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Rwf != null) && (this.jdField_a_of_type_Rwf.f()))
    {
      this.jdField_a_of_type_Rwf.f();
      this.jdField_d_of_type_Boolean = paramBoolean;
      if (!bhnv.h(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext())) {
        this.jdField_a_of_type_Rwf.j();
      }
      a(this.jdField_b_of_type_Rwc, this.jdField_a_of_type_Rwf, 5, Boolean.valueOf(this.jdField_d_of_type_Boolean));
      this.jdField_b_of_type_Rwc.jdField_d_of_type_Long = a();
      this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_a_of_type_Long = this.jdField_a_of_type_Rwf.a(false);
      BaseArticleInfo localBaseArticleInfo = this.jdField_b_of_type_Rwc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (tqa.a((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && ((this.jdField_b_of_type_Rwc.jdField_b_of_type_Boolean) || (localBaseArticleInfo.mChannelID == 56L)))
      {
        int j = 1;
        int i = nzq.S;
        if (localBaseArticleInfo.mChannelID == 56L)
        {
          j = nzq.aP;
          i = nzq.O;
        }
        nzq.a(new tlx().a(this.jdField_a_of_type_AndroidAppActivity).a(nzq.jdField_f_of_type_Int).b(i).a((AdvertisementInfo)localBaseArticleInfo).a(nzq.a(((AdvertisementInfo)localBaseArticleInfo).adbt, (int)this.jdField_b_of_type_Rwc.jdField_d_of_type_Long, ((AdvertisementInfo)localBaseArticleInfo).getAdbf(), 0, ((AdvertisementInfo)localBaseArticleInfo).adpa, ((AdvertisementInfo)localBaseArticleInfo).adpb, localBaseArticleInfo.mVideoDuration, j, 0)).a());
        ((AdvertisementInfo)localBaseArticleInfo).adbt = ((int)this.jdField_b_of_type_Rwc.jdField_d_of_type_Long);
      }
    }
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_Rwf != null) && (a() == 2);
  }
  
  public void f()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onVisiable() isPause()=" + d() + ", mPausedByMannul:" + this.jdField_d_of_type_Boolean);
      }
      if ((this.jdField_b_of_type_Rwc != null) && (this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv != null)) {
        this.jdField_b_of_type_Rwc.jdField_a_of_type_Qwv.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if ((d()) && (!this.jdField_d_of_type_Boolean)) {
        c();
      }
      if (this.jdField_a_of_type_Rwu != null)
      {
        this.jdField_a_of_type_Rwu.a();
        if (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
          break label152;
        }
        this.jdField_a_of_type_Rwu.a(false);
      }
    }
    for (;;)
    {
      rxy.a().a(this.jdField_a_of_type_AndroidAppActivity);
      return;
      label152:
      this.jdField_a_of_type_Rwu.a(true);
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (d())
    {
      if (!rxg.a(this.jdField_a_of_type_AndroidAppActivity)) {
        break label33;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "VideoPlayManager resume, in call return");
      }
    }
    return;
    label33:
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : resume(), mannulResume:" + paramBoolean + ", mPausedByMannul:" + this.jdField_d_of_type_Boolean);
    }
    this.jdField_a_of_type_Rwf.e();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    a(this.jdField_b_of_type_Rwc, this.jdField_a_of_type_Rwf, 3, null);
    a(this.jdField_a_of_type_Rwf, this.jdField_b_of_type_Rwc, paramBoolean);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_Rwf != null) && (this.jdField_a_of_type_Rwf.b());
  }
  
  void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkPlayStateAfterPhoneCall isVisible() = " + g());
    }
    if (!g()) {
      return;
    }
    c();
  }
  
  public boolean g()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_Rwu != null) {
      return this.jdField_a_of_type_Rwu.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvy
 * JD-Core Version:    0.7.0.1
 */