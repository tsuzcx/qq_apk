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
import org.json.JSONObject;

public class sdc
  implements rsq, sdn
{
  public static final String a;
  protected int a;
  private volatile Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private ArrayList<Pair<Integer, Bitmap>> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Integer, sdj> jdField_a_of_type_JavaUtilHashMap;
  private Map<String, WeakReference<sdj>> jdField_a_of_type_JavaUtilMap;
  private Set<sdh> jdField_a_of_type_JavaUtilSet;
  private CopyOnWriteArrayList<sde> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private rtp jdField_a_of_type_Rtp;
  private sdf jdField_a_of_type_Sdf = new sdf(this);
  public sdg a;
  private sdj jdField_a_of_type_Sdj;
  private sdl jdField_a_of_type_Sdl;
  private sdv jdField_a_of_type_Sdv;
  private sdy jdField_a_of_type_Sdy;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private String jdField_b_of_type_JavaLangString;
  private sdg jdField_b_of_type_Sdg;
  private boolean jdField_b_of_type_Boolean = true;
  private sdg jdField_c_of_type_Sdg;
  private volatile boolean jdField_c_of_type_Boolean;
  private sdg jdField_d_of_type_Sdg;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + sdc.class.getSimpleName();
  }
  
  public sdc(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : create a new manager !");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Sdl = new sdl();
    this.jdField_a_of_type_Sdl.a(this);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    sek.a().a(this);
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
  
  private void a(long paramLong1, long paramLong2, String paramString, sdg paramsdg, boolean paramBoolean)
  {
    if (AdvertisementInfo.isAdvertisementInfo(paramsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      return;
    }
    paramString = sic.a(paramsdg).a("dt_vdend").b("14").e(paramLong2).e(paramString);
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      sib.a(paramString.a(i).b(1).b(System.currentTimeMillis()).c(paramLong1));
      return;
    }
  }
  
  private void a(sdg paramsdg)
  {
    paramsdg.jdField_a_of_type_Rdt.jdField_t_of_type_Long = sfc.a().a();
    paramsdg.jdField_a_of_type_Rdt.jdField_m_of_type_JavaLangString = sfl.a().a();
  }
  
  private void a(sdg paramsdg, sdj paramsdj, int paramInt, Object paramObject)
  {
    int i;
    try
    {
      i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (paramInt != i)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "changeStateAndNotify(): " + sdi.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + " ===> " + sdi.a(paramInt) + ", extra = " + paramObject + ", videoPlayParam=" + paramsdg + ", videoPlayWrapper=" + paramsdj);
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
            sde localsde = (sde)localIterator.next();
            if (localsde != null) {
              localsde.a(paramsdg, paramsdj, i, paramInt, paramObject);
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
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.6(this, paramsdg, paramsdj, i, paramInt, paramObject));
    }
  }
  
  private void a(sdj paramsdj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "video play completion!");
    }
    if (this.jdField_a_of_type_Sdj == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video", 2, "onCompletion return for mVideoPlayerWrapper is null");
      }
      return;
    }
    long l1 = this.jdField_a_of_type_Sdj.a(true);
    this.jdField_d_of_type_Sdg = this.jdField_b_of_type_Sdg;
    this.jdField_c_of_type_Sdg = this.jdField_b_of_type_Sdg;
    sdg localsdg;
    Object localObject;
    rdt localrdt;
    int i;
    int j;
    boolean bool;
    if (this.jdField_b_of_type_Sdg != null)
    {
      localsdg = this.jdField_b_of_type_Sdg;
      localObject = this.jdField_a_of_type_Sdv;
      localsdg.jdField_a_of_type_Rdt.jdField_a_of_type_Long = l1;
      localsdg.jdField_d_of_type_Long = a();
      if ((localsdg.jdField_a_of_type_Rdt.jdField_a_of_type_Long == 0L) && (localsdg.jdField_a_of_type_Rdt.jdField_d_of_type_Long == 0L) && (localsdg.jdField_a_of_type_Rdt.jdField_b_of_type_Long != 0L)) {
        localsdg.jdField_a_of_type_Rdt.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - localsdg.jdField_a_of_type_Rdt.jdField_b_of_type_Long);
      }
      localsdg.jdField_a_of_type_Rdt.jdField_a_of_type_Float = ((float)localsdg.jdField_a_of_type_Rdt.jdField_a_of_type_Long / localsdg.jdField_b_of_type_Int);
      localsdg.jdField_a_of_type_Rdt.jdField_a_of_type_Boolean = true;
      localsdg.jdField_a_of_type_Rdt.jdField_b_of_type_Boolean = true;
      localsdg.jdField_a_of_type_Rdt.n = paramsdj.c();
      localsdg.jdField_a_of_type_Rdt.jdField_f_of_type_Int = paramsdj.e();
      localsdg.jdField_a_of_type_Rdt.jdField_g_of_type_Int = paramsdj.f();
      localsdg.jdField_a_of_type_Rdt.jdField_c_of_type_Boolean = paramsdj.jdField_b_of_type_Boolean;
      localsdg.jdField_a_of_type_Rdt.jdField_q_of_type_Long = paramsdj.jdField_b_of_type_Long;
      localsdg.jdField_a_of_type_Rdt.jdField_p_of_type_Long = paramsdj.jdField_a_of_type_Long;
      localsdg.jdField_a_of_type_Rdt.r = paramsdj.g();
      localsdg.jdField_a_of_type_Rdt.jdField_l_of_type_Int = c();
      localsdg.jdField_a_of_type_Rdt.jdField_m_of_type_Int = d();
      if (this.jdField_c_of_type_Sdg == null) {
        break label865;
      }
      localrdt = localsdg.jdField_a_of_type_Rdt;
      i = this.jdField_c_of_type_Sdg.jdField_a_of_type_Int;
      j = localsdg.jdField_a_of_type_Int;
      if (localsdg.jdField_m_of_type_Int != 3) {
        break label859;
      }
      bool = true;
    }
    label859:
    label865:
    for (localrdt.s = pay.a(i, j, bool);; localsdg.jdField_a_of_type_Rdt.s = -1)
    {
      localsdg.jdField_a_of_type_Rdt.jdField_d_of_type_Int = localsdg.jdField_m_of_type_Int;
      localsdg.jdField_a_of_type_Rdt.jdField_l_of_type_Boolean = paramsdj.p();
      a(localsdg);
      pay.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), pay.a(), true, localsdg.jdField_a_of_type_Rdt.a());
      oee.a(localsdg.jdField_a_of_type_Rdt);
      pay.a(true, localsdg.jdField_a_of_type_Rdt.jdField_d_of_type_Boolean, localsdg.jdField_a_of_type_Rdt.jdField_g_of_type_Int, localsdg.jdField_a_of_type_Rdt.jdField_a_of_type_Int, localsdg.jdField_a_of_type_Rdt.jdField_d_of_type_Long, 56, localsdg.jdField_a_of_type_Rdt.jdField_c_of_type_JavaLangString, localsdg.jdField_a_of_type_Rdt.jdField_a_of_type_JavaLangString);
      long l2 = this.jdField_a_of_type_Sdj.b();
      paramsdj = this.jdField_a_of_type_Sdj.a();
      if (localsdg.jdField_a_of_type_Rdt.jdField_a_of_type_Long > 0L)
      {
        new JSONObject();
        ThreadManager.post(new VideoPlayManager.3(this, localsdg, (sdv)localObject), 5, null, true);
      }
      bcef.b(null, "dc00899", "Pb_account_lifeservice", "", "0X800709B", "0X800709B", 0, 0, "", "", "", localsdg.jdField_c_of_type_JavaLangString);
      localObject = localsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localObject != null) && (twr.a((int)((BaseArticleInfo)localObject).mChannelID)) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && (localsdg.jdField_b_of_type_Boolean))
      {
        i = (int)l1;
        obb.a(new trn().a(this.jdField_a_of_type_AndroidAppActivity).a(obb.jdField_f_of_type_Int).b(obb.S).a((AdvertisementInfo)localObject).a(obb.a(((AdvertisementInfo)localObject).adbt, i, ((AdvertisementInfo)localObject).getAdbf(), 1, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, 1, 0)).a());
      }
      localObject = localsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localObject != null) && (((BaseArticleInfo)localObject).mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject))) {
        obb.a(new trn().a(this.jdField_a_of_type_AndroidAppActivity).a(obb.jdField_f_of_type_Int).b(obb.O).a((AdvertisementInfo)localObject).a(obb.a(((AdvertisementInfo)localObject).adbt, ((BaseArticleInfo)localObject).mVideoDuration * 1000, ((AdvertisementInfo)localObject).getAdbf(), 1, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, obb.aQ, 0)).a());
      }
      a(l1, l2, paramsdj, localsdg, false);
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.4(this));
      return;
      bool = false;
      break;
    }
  }
  
  private void a(sdj paramsdj, Object paramObject)
  {
    long l = 0L;
    paramObject = this.jdField_b_of_type_Sdg;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onVideoPrepared() mIsOpenedVideo=" + this.jdField_a_of_type_Boolean + "   mVisable:" + this.jdField_c_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Sdj == paramsdj) && (paramObject != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramObject.jdField_a_of_type_Int, true);
        if ((paramObject.jdField_a_of_type_Rdt != null) && (paramObject.jdField_a_of_type_Rdt.jdField_d_of_type_Long == 0L))
        {
          paramObject.jdField_a_of_type_Rdt.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - paramObject.jdField_a_of_type_Rdt.jdField_b_of_type_Long);
          rdt localrdt = paramObject.jdField_a_of_type_Rdt;
          localrdt.jdField_f_of_type_Long += paramObject.jdField_a_of_type_Rdt.jdField_d_of_type_Long;
          localrdt = paramObject.jdField_a_of_type_Rdt;
          localrdt.jdField_c_of_type_Int += 1;
          if ((paramObject.jdField_a_of_type_Rdt != null) && (QLog.isColorLevel())) {
            QLog.d("Q.readinjoy.video", 2, "video player ready. from open. prepare cost : " + paramObject.jdField_a_of_type_Rdt.jdField_d_of_type_Long);
          }
        }
        a(paramObject, this.jdField_a_of_type_Sdj, 2, null);
        if ((sek.a(this.jdField_a_of_type_AndroidAppActivity)) || (!GesturePWDUtils.isAppOnForeground(this.jdField_a_of_type_AndroidAppActivity)) || (this.jdField_a_of_type_Rtp == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onVideoPrepared start,in call stop.background:" + GesturePWDUtils.isAppOnForeground(this.jdField_a_of_type_AndroidAppActivity));
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.1(this));
        }
        for (;;)
        {
          paramsdj = new StringBuilder().append(amtj.a(2131715341)).append(paramsdj.jdField_b_of_type_Boolean).append(amtj.a(2131715358));
          if (paramObject.jdField_a_of_type_Rdt != null) {
            l = paramObject.jdField_a_of_type_Rdt.jdField_d_of_type_Long;
          }
          paramsdj = l;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.readinjoy.video", 2, paramsdj);
          return;
          paramsdj.d();
          a(paramObject, this.jdField_a_of_type_Sdj, 3, null);
          a(paramsdj, paramObject, false);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video", 2, "video player ready,but has error!");
  }
  
  private void a(sdj paramsdj, sdg paramsdg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "doOpenVideo executed On SubThread, busitype:" + paramsdg.jdField_f_of_type_Int + " vid:" + paramsdg.jdField_c_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_Sdj == null) || (this.jdField_a_of_type_Sdj != paramsdj)) {
      return;
    }
    if (TextUtils.isEmpty(paramsdg.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Sdf.a(paramsdj, 201, 61, 0, "vid null", null);
      return;
    }
    if ((paramsdg.jdField_f_of_type_Int == 2) || (paramsdg.jdField_f_of_type_Int == 6))
    {
      sjo localsjo = sjo.a();
      localsjo.a(paramsdg.jdField_c_of_type_JavaLangString, new sdd(this, paramsdj, paramsdg, localsjo));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
      {
        paramsdj.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramsdg.g, paramsdg.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramsdg.jdField_c_of_type_JavaLangString, paramsdj.jdField_b_of_type_Boolean);
      }
      ugf.a(paramsdg.j, paramsdg.jdField_c_of_type_JavaLangString, 0, 0);
      return;
      if (twr.j(paramsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        ((AdvertisementInfo)paramsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adbt = ((int)paramsdg.jdField_d_of_type_Long);
        if (paramsdg.jdField_d_of_type_Long == 0L)
        {
          ((AdvertisementInfo)paramsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpa = 1;
          ((AdvertisementInfo)paramsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpb = 1;
        }
        paramsdj.a("", paramsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid, 101, paramsdg.jdField_d_of_type_Long, paramsdg.e, paramsdg.jdField_b_of_type_Int);
      }
      else
      {
        paramsdj.a(paramsdg.jdField_c_of_type_JavaLangString, 1, paramsdg.jdField_d_of_type_Long);
      }
    }
  }
  
  private void a(sdj paramsdj, sdg paramsdg, boolean paramBoolean)
  {
    if (AdvertisementInfo.isAdvertisementInfo(paramsdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      return;
    }
    paramsdj = sic.a(paramsdg).a("dt_vdstart").b("14").e(paramsdj.b()).e(paramsdj.a());
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      sib.a(paramsdj.a(i).a(System.currentTimeMillis()).b(1));
      return;
    }
  }
  
  private boolean a(sdj paramsdj, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      paramObject = paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "video play has error ! " + paramObject);
      }
      this.jdField_a_of_type_Sdg = this.jdField_b_of_type_Sdg;
      if (this.jdField_b_of_type_Sdg != null) {
        ugf.a(this.jdField_b_of_type_Sdg.j, this.jdField_b_of_type_Sdg.jdField_c_of_type_JavaLangString, 1, paramInt2);
      }
      if (paramsdj == this.jdField_a_of_type_Sdj) {
        this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.5(this, paramInt1, paramInt2, paramString, paramsdj));
      }
      return true;
    }
  }
  
  private boolean a(sdj paramsdj, int paramInt, Object paramObject)
  {
    if ((paramsdj != this.jdField_a_of_type_Sdj) || (a() == 5) || (this.jdField_b_of_type_Sdg == null) || (this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt == null)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onInfo(): what:" + paramInt + ",extra:" + paramObject + ", getCurPlayState == paused, just ignore.");
      }
    }
    rdt localrdt;
    label499:
    do
    {
      do
      {
        do
        {
          return false;
          localrdt = this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt;
          switch (paramInt)
          {
          default: 
            return false;
          case 28: 
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
            }
            localrdt.o += 1;
            rwv.b(this.jdField_a_of_type_AndroidAppActivity, amtj.a(2131715335));
            return false;
          case 112: 
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onInfo(): video start buffering !");
            }
            a(this.jdField_b_of_type_Sdg, this.jdField_a_of_type_Sdj, 4, null);
            localrdt.e = SystemClock.uptimeMillis();
            return false;
          case 113: 
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onInfo(): video end buffering ! isPause=" + d());
            }
            if (!d()) {
              a(this.jdField_b_of_type_Sdg, this.jdField_a_of_type_Sdj, 3, null);
            }
            localrdt.jdField_f_of_type_Long += SystemClock.uptimeMillis() - localrdt.e;
            localrdt.jdField_c_of_type_Int += 1;
            return false;
          case 40: 
            for (;;)
            {
              try
              {
                paramsdj = new JSONObject((String)paramObject);
                paramInt = paramsdj.optInt("decoderMode", 0);
              }
              catch (Exception paramsdj)
              {
                try
                {
                  i = paramsdj.optInt("skipFrameCount", 1);
                  if (i > 0)
                  {
                    localrdt.jdField_p_of_type_Int += i;
                    localrdt.jdField_q_of_type_Int += i;
                  }
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_SKIP_ONE_FRAME decoderMode = " + paramInt + ", skipFrameCount = " + i + ", totalSkipCount = " + localrdt.jdField_p_of_type_Int + ", finalSkipCount = " + localrdt.jdField_q_of_type_Int);
                  return false;
                }
                catch (Exception paramsdj)
                {
                  int i;
                  break label499;
                }
                paramsdj = paramsdj;
                paramInt = 0;
              }
              QLog.e(jdField_a_of_type_JavaLangString, 1, "onInfo() PLAYER_INFO_SKIP_ONE_FRAME", paramsdj);
              i = 0;
            }
          case 39: 
            QLog.e(jdField_a_of_type_JavaLangString, 1, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
            localrdt.jdField_f_of_type_Boolean = true;
            if ((paramObject instanceof String)) {
              localrdt.jdField_f_of_type_JavaLangString = ((String)paramObject);
            }
            rwv.b(this.jdField_a_of_type_AndroidAppActivity, amtj.a(2131715360));
            return false;
          case 41: 
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_CHANGE_HW_BACKUP_URL");
            }
            localrdt.jdField_g_of_type_Boolean = true;
            rwv.b(this.jdField_a_of_type_AndroidAppActivity, amtj.a(2131715343));
            return false;
          }
        } while (paramObject == null);
        paramsdj = ((String)paramObject).split(":", 2);
      } while ((paramsdj == null) || (paramsdj.length != 2));
      if (QLog.isColorLevel()) {
        QLog.d("VideoPlayManager", 2, "Performance PERFORMANCE_REPORT videoPlayVideoParam:" + this.jdField_b_of_type_Sdg + "  method:" + paramsdj[0] + "\ntimeJson:" + paramsdj[1]);
      }
    } while (!"prepare".equals(paramsdj[0]));
    localrdt.jdField_l_of_type_JavaLangString = paramsdj[1];
    return false;
    rse.a.a(paramObject, localrdt);
    return false;
    localrdt.v = (SystemClock.uptimeMillis() - localrdt.jdField_b_of_type_Long);
    localrdt.w = (SystemClock.uptimeMillis() - localrdt.jdField_c_of_type_Long);
    return false;
    localrdt.jdField_t_of_type_Int = ((Long)paramObject).intValue();
    return false;
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_Sdj != null) {
      i = this.jdField_a_of_type_Sdj.b();
    }
    if (i == this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) {
      return i;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.readinjoy.video", 2, "getCurPlayState, should not happen...: mVideoPlayerWrapper.getCurrentStatus() = " + sdi.a(i) + ",mState.get()=" + sdi.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Sdj != null) {
      return this.jdField_a_of_type_Sdj.a();
    }
    return 0L;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Sdj != null) {
      return this.jdField_a_of_type_Sdj.a();
    }
    return null;
  }
  
  public sdg a()
  {
    return this.jdField_b_of_type_Sdg;
  }
  
  public sdj a(String paramString)
  {
    paramString = (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return (sdj)paramString.get();
    }
    return null;
  }
  
  public sdj a(sdg paramsdg)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return null;
    }
    sdj localsdj = new sdj(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    localsdj.e(true);
    localsdj.a(this.jdField_a_of_type_Sdf);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "getVideoPlayer new instant!");
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramsdg.a(), new WeakReference(localsdj));
    return localsdj;
  }
  
  public sdy a()
  {
    return this.jdField_a_of_type_Sdy;
  }
  
  public void a()
  {
    e(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Sdj != null) {
      this.jdField_a_of_type_Sdj.b(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video", 2, "setXYaxis value:" + paramInt);
    }
  }
  
  public void a(int paramInt, sdg paramsdg)
  {
    this.jdField_d_of_type_Sdg = null;
    if ((this.jdField_b_of_type_Sdg != null) && (this.jdField_a_of_type_Sdj != null))
    {
      if (this.jdField_a_of_type_Sdj.b() == 2) {
        this.jdField_a_of_type_Sdj.d();
      }
      this.jdField_a_of_type_Sdj.a(paramInt);
      a(this.jdField_b_of_type_Sdg, this.jdField_a_of_type_Sdj, 3, null);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: mVideoPlayerWrapper.seekTo() position=" + paramInt);
      }
      a(this.jdField_a_of_type_Sdj, paramsdg, false);
    }
    do
    {
      do
      {
        return;
        if (paramsdg == null) {
          break;
        }
        this.jdField_b_of_type_Sdg = paramsdg;
        paramsdg = this.jdField_b_of_type_Sdg;
        b(1);
        paramsdg.jdField_d_of_type_Long = paramInt;
        a(paramsdg);
      } while (!QLog.isColorLevel());
      QLog.w(jdField_a_of_type_JavaLangString, 2, "resume(): mCurrenPlayVideoParam = null, playVideo: " + paramsdg.jdField_c_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: param = null && mVideoPlayerWrapper = null");
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "player stop [async]  stopID : " + paramLong + ", from : " + paramInt);
    }
    if ((this.jdField_a_of_type_Sdj != null) && (this.jdField_b_of_type_Sdg != null) && (this.jdField_b_of_type_Sdg.jdField_c_of_type_Long == paramLong))
    {
      this.jdField_b_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setKeepScreenOn(false);
      a(this.jdField_b_of_type_Sdg, this.jdField_a_of_type_Sdj, 0, null);
      this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_a_of_type_Long = this.jdField_a_of_type_Sdj.a(false);
      this.jdField_b_of_type_Sdg.jdField_d_of_type_Long = a();
      if ((this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_d_of_type_Long == 0L) && (this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_b_of_type_Long != 0L)) {
        this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_b_of_type_Long);
      }
      this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_a_of_type_Float = ((float)this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_a_of_type_Long / this.jdField_b_of_type_Sdg.jdField_b_of_type_Int);
      this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.n = this.jdField_a_of_type_Sdj.c();
      this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_f_of_type_Int = this.jdField_a_of_type_Sdj.e();
      this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_g_of_type_Int = this.jdField_a_of_type_Sdj.f();
      this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_c_of_type_Boolean = this.jdField_a_of_type_Sdj.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_q_of_type_Long = this.jdField_a_of_type_Sdj.jdField_b_of_type_Long;
      this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_p_of_type_Long = this.jdField_a_of_type_Sdj.jdField_a_of_type_Long;
      this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.r = this.jdField_a_of_type_Sdj.g();
      if ((this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_d_of_type_Long == 0L))
      {
        this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_b_of_type_Long);
        this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_f_of_type_Long = this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_d_of_type_Long;
      }
      this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_l_of_type_Int = c();
      this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_m_of_type_Int = d();
      if (this.jdField_c_of_type_Sdg != null)
      {
        localObject = this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt;
        paramInt = this.jdField_c_of_type_Sdg.jdField_a_of_type_Int;
        i = this.jdField_b_of_type_Sdg.jdField_a_of_type_Int;
        if (this.jdField_b_of_type_Sdg.jdField_m_of_type_Int == 3)
        {
          bool = true;
          ((rdt)localObject).s = pay.a(paramInt, i, bool);
          this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_d_of_type_Int = this.jdField_b_of_type_Sdg.jdField_m_of_type_Int;
          paramLong = this.jdField_a_of_type_Sdj.b();
          localObject = this.jdField_a_of_type_Sdj.a();
          this.jdField_a_of_type_Sdj.l();
          a(this.jdField_b_of_type_Sdg);
          pay.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), pay.a(), true, this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.a());
          oee.a(this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt);
          pay.a(true, this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_d_of_type_Boolean, this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_g_of_type_Int, this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_a_of_type_Int, this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_d_of_type_Long, 56, this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_a_of_type_JavaLangString);
          if ((this.jdField_b_of_type_Sdg.jdField_d_of_type_Long > 0L) && (this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_a_of_type_Long > 0L)) {
            ThreadManager.post(new VideoPlayManager.9(this, this.jdField_b_of_type_Sdg, this.jdField_a_of_type_Sdv, paramLong, (String)localObject), 5, null, true);
          }
          this.jdField_d_of_type_Boolean = false;
          this.jdField_c_of_type_Sdg = this.jdField_b_of_type_Sdg;
          this.jdField_b_of_type_Sdg = null;
          this.jdField_a_of_type_Sdj = null;
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
        this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.s = -1;
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
  
  public void a(rsd paramrsd)
  {
    if ((paramrsd == null) || (!(paramrsd instanceof sdg))) {}
    sdj localsdj;
    do
    {
      do
      {
        return;
        if (!sek.a(this.jdField_a_of_type_AndroidAppActivity)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "playVideo in call return");
      return;
      paramrsd = (sdg)paramrsd;
      try
      {
        this.jdField_d_of_type_Sdg = null;
        this.jdField_a_of_type_Sdg = null;
        if (this.jdField_a_of_type_Sdy != null) {
          this.jdField_a_of_type_Sdy.a(paramrsd);
        }
        if (!this.jdField_a_of_type_Sdl.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "start install tencent sdk plugin");
          }
          this.jdField_b_of_type_Sdg = paramrsd;
          a(this.jdField_b_of_type_Sdg, null, 4, null);
          this.jdField_a_of_type_Sdl.a();
          return;
        }
      }
      catch (Exception paramrsd)
      {
        paramrsd.printStackTrace();
        QLog.e("Q.readinjoy.video", 1, "playVideo error:", paramrsd);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "play video start ! playParams : " + paramrsd.toString());
      }
      this.jdField_a_of_type_Boolean = true;
      localsdj = a(paramrsd);
      this.jdField_a_of_type_Sdj = localsdj;
      this.jdField_b_of_type_Sdg = paramrsd;
    } while (this.jdField_a_of_type_Sdj == null);
    a(this.jdField_b_of_type_Sdg, this.jdField_a_of_type_Sdj, 1, null);
    paramrsd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
    this.jdField_a_of_type_Sdj.a(paramrsd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup);
    shf localshf = this.jdField_a_of_type_Sdj.a();
    if ((localshf == null) || (localshf.a() == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "playVideo failed, because get videoView == null!");
      a(this.jdField_b_of_type_Sdg, null, 6, "videoview null");
      this.jdField_a_of_type_Sdj = null;
      this.jdField_b_of_type_Sdg = null;
      return;
    }
    paramrsd.jdField_a_of_type_Shf = localshf;
    localshf.a().setId(2131375928);
    paramrsd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setKeepScreenOn(true);
    this.jdField_a_of_type_Sdj.b(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.o = 0;
    this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_p_of_type_Int = 0;
    this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_q_of_type_Int = 0;
    this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_g_of_type_Boolean = false;
    this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.h = false;
    ThreadManager.executeOnSubThread(new VideoPlayManager.7(this, localsdj, paramrsd));
  }
  
  public void a(rti paramrti)
  {
    paramrti.a(this);
  }
  
  public void a(rtp paramrtp)
  {
    this.jdField_a_of_type_Rtp = paramrtp;
  }
  
  public void a(sde paramsde)
  {
    if ((paramsde != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramsde))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramsde);
    }
  }
  
  public void a(sdh paramsdh)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null) {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramsdh);
  }
  
  public void a(sdv paramsdv)
  {
    this.jdField_a_of_type_Sdv = paramsdv;
  }
  
  public void a(sdy paramsdy)
  {
    this.jdField_a_of_type_Sdy = paramsdy;
    this.jdField_a_of_type_Sdy.a(this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk success!");
      }
      if (this.jdField_b_of_type_Sdg != null) {
        a(this.jdField_b_of_type_Sdg);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk fail!");
    }
    a(this.jdField_b_of_type_Sdg, this.jdField_a_of_type_Sdj, 6, "install failure");
    this.jdField_b_of_type_Sdg = null;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Sdj != null) && (this.jdField_a_of_type_Sdj.l());
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long b()
  {
    if (this.jdField_b_of_type_Sdg == null) {
      return -1L;
    }
    return this.jdField_b_of_type_Sdg.jdField_c_of_type_Long;
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
    if ((this.jdField_b_of_type_Sdg != null) && (this.jdField_a_of_type_Sdj != null)) {
      a(this.jdField_b_of_type_Sdg.jdField_c_of_type_Long, paramInt);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "stop , from : " + paramInt);
      }
      return;
      if (this.jdField_a_of_type_Sdj != null)
      {
        a(this.jdField_b_of_type_Sdg, this.jdField_a_of_type_Sdj, 0, null);
        this.jdField_a_of_type_Sdj.l();
        this.jdField_a_of_type_Sdj = null;
        this.jdField_b_of_type_Sdg = null;
      }
      else if (this.jdField_b_of_type_Sdg != null)
      {
        a(this.jdField_b_of_type_Sdg, this.jdField_a_of_type_Sdj, 0, null);
        this.jdField_a_of_type_Sdj = null;
        this.jdField_b_of_type_Sdg = null;
      }
    }
  }
  
  public void b(sde paramsde)
  {
    if ((paramsde != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramsde);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Sdj != null) && (this.jdField_a_of_type_Sdj.f());
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Sdj != null) {
      return this.jdField_a_of_type_Sdj.c();
    }
    return -1;
  }
  
  public long c()
  {
    if (this.jdField_b_of_type_Sdg == null) {
      return 0L;
    }
    return this.jdField_b_of_type_Sdg.jdField_b_of_type_Long;
  }
  
  public void c()
  {
    f(false);
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Sdj != null) {
      this.jdField_a_of_type_Sdj.a(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this.jdField_b_of_type_Sdg != null)
    {
      bool = paramBoolean;
      if (this.jdField_b_of_type_Sdg.jdField_b_of_type_Boolean) {
        bool = true;
      }
    }
    if (this.jdField_a_of_type_Sdj != null) {
      this.jdField_a_of_type_Sdj.c(bool);
    }
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Sdj != null) {
      return this.jdField_a_of_type_Sdj.d();
    }
    return -1;
  }
  
  public long d()
  {
    if (this.jdField_a_of_type_Sdj != null) {
      return this.jdField_a_of_type_Sdj.b();
    }
    return 0L;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : destroy !");
    }
    b(7);
    if (this.jdField_a_of_type_Sdj != null)
    {
      this.jdField_a_of_type_Sdj.l();
      this.jdField_a_of_type_Sdj = null;
    }
    if (this.jdField_b_of_type_Sdg != null) {
      this.jdField_b_of_type_Sdg = null;
    }
    this.jdField_a_of_type_Sdl.b();
    this.jdField_a_of_type_Sdl = null;
    try
    {
      this.jdField_a_of_type_AndroidAppActivity = null;
      sek.a().b(this);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        sdj localsdj = (sdj)((WeakReference)localIterator.next()).get();
        if ((localsdj != null) && (!localsdj.jdField_a_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper : " + localsdj.toString() + " not release");
          }
          localsdj.l();
        }
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
    if (this.jdField_a_of_type_Sdy != null)
    {
      this.jdField_a_of_type_Sdy.n();
      this.jdField_a_of_type_Sdy = null;
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
    if ((this.jdField_a_of_type_Sdj == null) || (this.jdField_b_of_type_Sdg == null)) {}
    do
    {
      return false;
      if (a() == 5)
      {
        if ((!this.jdField_a_of_type_Sdj.e()) && (QLog.isColorLevel())) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return true. getCurPlayState is PLAY_STATE_PAUSED. But mVideoPlayerWrapper.isPause() == false;");
        }
        return true;
      }
    } while ((!this.jdField_a_of_type_Sdj.e()) || (!QLog.isColorLevel()));
    QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return false. getCurPlayState is " + sdi.a(a()) + ". But mVideoPlayerWrapper.isPause() == true;");
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
      a(this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_a_of_type_Long, this.jdField_a_of_type_Sdj.b(), this.jdField_a_of_type_Sdj.a(), this.jdField_b_of_type_Sdg, false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Sdy != null)
      {
        this.jdField_a_of_type_Sdy.b();
        this.jdField_a_of_type_Sdy.a(false);
      }
      sfc.a().b(this.jdField_a_of_type_AndroidAppActivity);
      return;
      label138:
      if (f()) {
        b(8);
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Sdj != null) && (this.jdField_a_of_type_Sdj.f()))
    {
      this.jdField_a_of_type_Sdj.f();
      this.jdField_d_of_type_Boolean = paramBoolean;
      if (!NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext())) {
        this.jdField_a_of_type_Sdj.j();
      }
      a(this.jdField_b_of_type_Sdg, this.jdField_a_of_type_Sdj, 5, Boolean.valueOf(this.jdField_d_of_type_Boolean));
      this.jdField_b_of_type_Sdg.jdField_d_of_type_Long = a();
      this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_a_of_type_Long = this.jdField_a_of_type_Sdj.a(false);
      BaseArticleInfo localBaseArticleInfo = this.jdField_b_of_type_Sdg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (twr.a((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && ((this.jdField_b_of_type_Sdg.jdField_b_of_type_Boolean) || (localBaseArticleInfo.mChannelID == 56L)))
      {
        int j = 1;
        int i = obb.S;
        if (localBaseArticleInfo.mChannelID == 56L)
        {
          j = obb.aQ;
          i = obb.O;
        }
        obb.a(new trn().a(this.jdField_a_of_type_AndroidAppActivity).a(obb.jdField_f_of_type_Int).b(i).a((AdvertisementInfo)localBaseArticleInfo).a(obb.a(((AdvertisementInfo)localBaseArticleInfo).adbt, (int)this.jdField_b_of_type_Sdg.jdField_d_of_type_Long, ((AdvertisementInfo)localBaseArticleInfo).getAdbf(), 0, ((AdvertisementInfo)localBaseArticleInfo).adpa, ((AdvertisementInfo)localBaseArticleInfo).adpb, localBaseArticleInfo.mVideoDuration, j, 0)).a());
        ((AdvertisementInfo)localBaseArticleInfo).adbt = ((int)this.jdField_b_of_type_Sdg.jdField_d_of_type_Long);
      }
    }
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_Sdj != null) && (a() == 2);
  }
  
  public void f()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onVisiable() isPause()=" + d() + ", mPausedByMannul:" + this.jdField_d_of_type_Boolean);
      }
      if ((this.jdField_b_of_type_Sdg != null) && (this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt != null)) {
        this.jdField_b_of_type_Sdg.jdField_a_of_type_Rdt.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if ((d()) && (!this.jdField_d_of_type_Boolean)) {
        c();
      }
      if (this.jdField_a_of_type_Sdy != null)
      {
        this.jdField_a_of_type_Sdy.a();
        if (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
          break label152;
        }
        this.jdField_a_of_type_Sdy.a(false);
      }
    }
    for (;;)
    {
      sfc.a().a(this.jdField_a_of_type_AndroidAppActivity);
      return;
      label152:
      this.jdField_a_of_type_Sdy.a(true);
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (d())
    {
      if (!sek.a(this.jdField_a_of_type_AndroidAppActivity)) {
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
    this.jdField_a_of_type_Sdj.e();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    a(this.jdField_b_of_type_Sdg, this.jdField_a_of_type_Sdj, 3, null);
    a(this.jdField_a_of_type_Sdj, this.jdField_b_of_type_Sdg, paramBoolean);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_Sdj != null) && (this.jdField_a_of_type_Sdj.b());
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
    if (this.jdField_a_of_type_Sdy != null) {
      return this.jdField_a_of_type_Sdy.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sdc
 * JD-Core Version:    0.7.0.1
 */