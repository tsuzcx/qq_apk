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

public class seu
  implements ruu, sff
{
  public static final String a;
  protected int a;
  private volatile Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private ArrayList<Pair<Integer, Bitmap>> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Integer, sfb> jdField_a_of_type_JavaUtilHashMap;
  private Map<String, WeakReference<sfb>> jdField_a_of_type_JavaUtilMap;
  private Set<sez> jdField_a_of_type_JavaUtilSet;
  private CopyOnWriteArrayList<sew> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private rvr jdField_a_of_type_Rvr;
  private sex jdField_a_of_type_Sex = new sex(this);
  public sey a;
  private sfb jdField_a_of_type_Sfb;
  private sfd jdField_a_of_type_Sfd;
  private sfn jdField_a_of_type_Sfn;
  private sfq jdField_a_of_type_Sfq;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private String jdField_b_of_type_JavaLangString;
  private sey jdField_b_of_type_Sey;
  private boolean jdField_b_of_type_Boolean = true;
  private sey jdField_c_of_type_Sey;
  private volatile boolean jdField_c_of_type_Boolean;
  private sey jdField_d_of_type_Sey;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + seu.class.getSimpleName();
  }
  
  public seu(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : create a new manager !");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Sfd = new sfd();
    this.jdField_a_of_type_Sfd.a(this);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    sgc.a().a(this);
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
  
  private void a(long paramLong1, long paramLong2, String paramString, sey paramsey, boolean paramBoolean)
  {
    if (AdvertisementInfo.isAdvertisementInfo(paramsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      return;
    }
    paramString = ska.a(paramsey).a("dt_vdend").b("8014").e(paramLong2).e(paramString);
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      sjz.a(paramString.a(i).b(1).b(System.currentTimeMillis()).c(paramLong1));
      return;
    }
  }
  
  private void a(sey paramsey)
  {
    paramsey.jdField_a_of_type_Rgc.jdField_t_of_type_Long = sgu.a().a();
    paramsey.jdField_a_of_type_Rgc.jdField_m_of_type_JavaLangString = shd.a().a();
  }
  
  private void a(sey paramsey, sfb paramsfb, int paramInt, Object paramObject)
  {
    int i;
    try
    {
      i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (paramInt != i)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "changeStateAndNotify(): " + sfa.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + " ===> " + sfa.a(paramInt) + ", extra = " + paramObject + ", videoPlayParam=" + paramsey + ", videoPlayWrapper=" + paramsfb);
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
            sew localsew = (sew)localIterator.next();
            if (localsew != null) {
              localsew.a(paramsey, paramsfb, i, paramInt, paramObject);
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
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.6(this, paramsey, paramsfb, i, paramInt, paramObject));
    }
  }
  
  private void a(sfb paramsfb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "video play completion!");
    }
    if (this.jdField_a_of_type_Sfb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video", 2, "onCompletion return for mVideoPlayerWrapper is null");
      }
      return;
    }
    long l1 = this.jdField_a_of_type_Sfb.a(true);
    this.jdField_d_of_type_Sey = this.jdField_b_of_type_Sey;
    this.jdField_c_of_type_Sey = this.jdField_b_of_type_Sey;
    sey localsey;
    Object localObject;
    rgc localrgc;
    int i;
    int j;
    boolean bool;
    if (this.jdField_b_of_type_Sey != null)
    {
      localsey = this.jdField_b_of_type_Sey;
      localObject = this.jdField_a_of_type_Sfn;
      localsey.jdField_a_of_type_Rgc.jdField_a_of_type_Long = l1;
      localsey.jdField_d_of_type_Long = a();
      if ((localsey.jdField_a_of_type_Rgc.jdField_a_of_type_Long == 0L) && (localsey.jdField_a_of_type_Rgc.jdField_d_of_type_Long == 0L) && (localsey.jdField_a_of_type_Rgc.jdField_b_of_type_Long != 0L)) {
        localsey.jdField_a_of_type_Rgc.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - localsey.jdField_a_of_type_Rgc.jdField_b_of_type_Long);
      }
      localsey.jdField_a_of_type_Rgc.jdField_a_of_type_Float = ((float)localsey.jdField_a_of_type_Rgc.jdField_a_of_type_Long / localsey.jdField_b_of_type_Int);
      localsey.jdField_a_of_type_Rgc.jdField_a_of_type_Boolean = true;
      localsey.jdField_a_of_type_Rgc.jdField_b_of_type_Boolean = true;
      localsey.jdField_a_of_type_Rgc.n = paramsfb.c();
      localsey.jdField_a_of_type_Rgc.jdField_f_of_type_Int = paramsfb.e();
      localsey.jdField_a_of_type_Rgc.jdField_g_of_type_Int = paramsfb.f();
      localsey.jdField_a_of_type_Rgc.jdField_c_of_type_Boolean = paramsfb.jdField_b_of_type_Boolean;
      localsey.jdField_a_of_type_Rgc.jdField_q_of_type_Long = paramsfb.jdField_b_of_type_Long;
      localsey.jdField_a_of_type_Rgc.jdField_p_of_type_Long = paramsfb.jdField_a_of_type_Long;
      localsey.jdField_a_of_type_Rgc.r = paramsfb.g();
      localsey.jdField_a_of_type_Rgc.jdField_l_of_type_Int = c();
      localsey.jdField_a_of_type_Rgc.jdField_m_of_type_Int = d();
      if (this.jdField_c_of_type_Sey == null) {
        break label865;
      }
      localrgc = localsey.jdField_a_of_type_Rgc;
      i = this.jdField_c_of_type_Sey.jdField_a_of_type_Int;
      j = localsey.jdField_a_of_type_Int;
      if (localsey.jdField_m_of_type_Int != 3) {
        break label859;
      }
      bool = true;
    }
    label859:
    label865:
    for (localrgc.s = pha.a(i, j, bool);; localsey.jdField_a_of_type_Rgc.s = -1)
    {
      localsey.jdField_a_of_type_Rgc.jdField_d_of_type_Int = localsey.jdField_m_of_type_Int;
      localsey.jdField_a_of_type_Rgc.jdField_l_of_type_Boolean = paramsfb.p();
      a(localsey);
      pha.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), pha.a(), true, localsey.jdField_a_of_type_Rgc.a());
      obh.a(localsey.jdField_a_of_type_Rgc);
      pha.a(true, localsey.jdField_a_of_type_Rgc.jdField_d_of_type_Boolean, localsey.jdField_a_of_type_Rgc.jdField_g_of_type_Int, localsey.jdField_a_of_type_Rgc.jdField_a_of_type_Int, localsey.jdField_a_of_type_Rgc.jdField_d_of_type_Long, 56, localsey.jdField_a_of_type_Rgc.jdField_c_of_type_JavaLangString, localsey.jdField_a_of_type_Rgc.jdField_a_of_type_JavaLangString);
      long l2 = this.jdField_a_of_type_Sfb.b();
      paramsfb = this.jdField_a_of_type_Sfb.a();
      if (localsey.jdField_a_of_type_Rgc.jdField_a_of_type_Long > 0L)
      {
        new JSONObject();
        ThreadManager.post(new VideoPlayManager.3(this, localsey, (sfn)localObject), 5, null, true);
      }
      bcst.b(null, "dc00899", "Pb_account_lifeservice", "", "0X800709B", "0X800709B", 0, 0, "", "", "", localsey.jdField_c_of_type_JavaLangString);
      localObject = localsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localObject != null) && (oqj.a((int)((BaseArticleInfo)localObject).mChannelID)) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && (localsey.jdField_b_of_type_Boolean))
      {
        i = (int)l1;
        nxw.a(new omp().a(this.jdField_a_of_type_AndroidAppActivity).a(nxw.jdField_f_of_type_Int).b(nxw.S).a((AdvertisementInfo)localObject).a(nxw.a(((AdvertisementInfo)localObject).adbt, i, ((AdvertisementInfo)localObject).getAdbf(), 1, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, 1, 0)).a());
      }
      localObject = localsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localObject != null) && (((BaseArticleInfo)localObject).mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject))) {
        nxw.a(new omp().a(this.jdField_a_of_type_AndroidAppActivity).a(nxw.jdField_f_of_type_Int).b(nxw.O).a((AdvertisementInfo)localObject).a(nxw.a(((AdvertisementInfo)localObject).adbt, ((BaseArticleInfo)localObject).mVideoDuration * 1000, ((AdvertisementInfo)localObject).getAdbf(), 1, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration, nxw.aJ, 0)).a());
      }
      a(l1, l2, paramsfb, localsey, false);
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.4(this));
      return;
      bool = false;
      break;
    }
  }
  
  private void a(sfb paramsfb, Object paramObject)
  {
    long l = 0L;
    paramObject = this.jdField_b_of_type_Sey;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onVideoPrepared() mIsOpenedVideo=" + this.jdField_a_of_type_Boolean + "   mVisable:" + this.jdField_c_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Sfb == paramsfb) && (paramObject != null))
      {
        this.jdField_a_of_type_Sfq.a(this.jdField_a_of_type_Sfb, paramObject);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramObject.jdField_a_of_type_Int, true);
        if ((paramObject.jdField_a_of_type_Rgc != null) && (paramObject.jdField_a_of_type_Rgc.jdField_d_of_type_Long == 0L))
        {
          paramObject.jdField_a_of_type_Rgc.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - paramObject.jdField_a_of_type_Rgc.jdField_b_of_type_Long);
          rgc localrgc = paramObject.jdField_a_of_type_Rgc;
          localrgc.jdField_f_of_type_Long += paramObject.jdField_a_of_type_Rgc.jdField_d_of_type_Long;
          localrgc = paramObject.jdField_a_of_type_Rgc;
          localrgc.jdField_c_of_type_Int += 1;
          if ((paramObject.jdField_a_of_type_Rgc != null) && (QLog.isColorLevel())) {
            QLog.d("Q.readinjoy.video", 2, "video player ready. from open. prepare cost : " + paramObject.jdField_a_of_type_Rgc.jdField_d_of_type_Long);
          }
        }
        a(paramObject, this.jdField_a_of_type_Sfb, 2, null);
        if ((sgc.a(this.jdField_a_of_type_AndroidAppActivity)) || (!GesturePWDUtils.isAppOnForeground(this.jdField_a_of_type_AndroidAppActivity)) || (this.jdField_a_of_type_Rvr == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onVideoPrepared start,in call stop.background:" + GesturePWDUtils.isAppOnForeground(this.jdField_a_of_type_AndroidAppActivity));
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.1(this));
        }
        for (;;)
        {
          paramsfb = new StringBuilder().append(anni.a(2131714998)).append(paramsfb.jdField_b_of_type_Boolean).append(anni.a(2131715015));
          if (paramObject.jdField_a_of_type_Rgc != null) {
            l = paramObject.jdField_a_of_type_Rgc.jdField_d_of_type_Long;
          }
          paramsfb = l;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.readinjoy.video", 2, paramsfb);
          return;
          paramsfb.d();
          a(paramObject, this.jdField_a_of_type_Sfb, 3, null);
          a(paramsfb, paramObject, false);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video", 2, "video player ready,but has error!");
  }
  
  private void a(sfb paramsfb, sey paramsey)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "doOpenVideo executed On SubThread, busitype:" + paramsey.jdField_f_of_type_Int + " vid:" + paramsey.jdField_c_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_Sfb == null) || (this.jdField_a_of_type_Sfb != paramsfb)) {
      return;
    }
    if (TextUtils.isEmpty(paramsey.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Sex.a(paramsfb, 201, 61, 0, "vid null", null);
      return;
    }
    if ((paramsey.jdField_f_of_type_Int == 2) || (paramsey.jdField_f_of_type_Int == 6))
    {
      slm localslm = slm.a();
      localslm.a(paramsey.jdField_c_of_type_JavaLangString, new sev(this, paramsfb, paramsey, localslm));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
      {
        paramsfb.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramsey.g, paramsey.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramsey.jdField_c_of_type_JavaLangString, paramsfb.jdField_b_of_type_Boolean);
      }
      tzo.a(paramsey.j, paramsey.jdField_c_of_type_JavaLangString, 0, 0);
      return;
      if (oqj.j(paramsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        ((AdvertisementInfo)paramsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adbt = ((int)paramsey.jdField_d_of_type_Long);
        if (paramsey.jdField_d_of_type_Long == 0L)
        {
          ((AdvertisementInfo)paramsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpa = 1;
          ((AdvertisementInfo)paramsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpb = 1;
        }
        paramsfb.a("", paramsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid, 101, paramsey.jdField_d_of_type_Long, paramsey.e, paramsey.jdField_b_of_type_Int);
      }
      else
      {
        paramsfb.a(paramsey.jdField_c_of_type_JavaLangString, 1, paramsey.jdField_d_of_type_Long);
      }
    }
  }
  
  private void a(sfb paramsfb, sey paramsey, boolean paramBoolean)
  {
    if (AdvertisementInfo.isAdvertisementInfo(paramsey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      return;
    }
    paramsfb = ska.a(paramsey).a("dt_vdstart").b("8014").e(paramsfb.b()).e(paramsfb.a());
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      sjz.a(paramsfb.a(i).a(System.currentTimeMillis()).b(1));
      return;
    }
  }
  
  private boolean a(sfb paramsfb, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      paramObject = paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "video play has error ! " + paramObject);
      }
      this.jdField_a_of_type_Sey = this.jdField_b_of_type_Sey;
      if (this.jdField_b_of_type_Sey != null) {
        tzo.a(this.jdField_b_of_type_Sey.j, this.jdField_b_of_type_Sey.jdField_c_of_type_JavaLangString, 1, paramInt2);
      }
      if (paramsfb == this.jdField_a_of_type_Sfb) {
        this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.5(this, paramInt1, paramInt2, paramString, paramsfb));
      }
      return true;
    }
  }
  
  private boolean a(sfb paramsfb, int paramInt, Object paramObject)
  {
    if ((paramsfb != this.jdField_a_of_type_Sfb) || (a() == 5) || (this.jdField_b_of_type_Sey == null) || (this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc == null)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onInfo(): what:" + paramInt + ",extra:" + paramObject + ", getCurPlayState == paused, just ignore.");
      }
    }
    rgc localrgc;
    label499:
    do
    {
      do
      {
        do
        {
          return false;
          localrgc = this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc;
          switch (paramInt)
          {
          default: 
            return false;
          case 28: 
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
            }
            localrgc.o += 1;
            ryx.b(this.jdField_a_of_type_AndroidAppActivity, anni.a(2131714992));
            return false;
          case 112: 
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onInfo(): video start buffering !");
            }
            a(this.jdField_b_of_type_Sey, this.jdField_a_of_type_Sfb, 4, null);
            localrgc.e = SystemClock.uptimeMillis();
            return false;
          case 113: 
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onInfo(): video end buffering ! isPause=" + d());
            }
            if (!d()) {
              a(this.jdField_b_of_type_Sey, this.jdField_a_of_type_Sfb, 3, null);
            }
            localrgc.jdField_f_of_type_Long += SystemClock.uptimeMillis() - localrgc.e;
            localrgc.jdField_c_of_type_Int += 1;
            return false;
          case 40: 
            for (;;)
            {
              try
              {
                paramsfb = new JSONObject((String)paramObject);
                paramInt = paramsfb.optInt("decoderMode", 0);
              }
              catch (Exception paramsfb)
              {
                try
                {
                  i = paramsfb.optInt("skipFrameCount", 1);
                  if (i > 0)
                  {
                    localrgc.jdField_p_of_type_Int += i;
                    localrgc.jdField_q_of_type_Int += i;
                  }
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_SKIP_ONE_FRAME decoderMode = " + paramInt + ", skipFrameCount = " + i + ", totalSkipCount = " + localrgc.jdField_p_of_type_Int + ", finalSkipCount = " + localrgc.jdField_q_of_type_Int);
                  return false;
                }
                catch (Exception paramsfb)
                {
                  int i;
                  break label499;
                }
                paramsfb = paramsfb;
                paramInt = 0;
              }
              QLog.e(jdField_a_of_type_JavaLangString, 1, "onInfo() PLAYER_INFO_SKIP_ONE_FRAME", paramsfb);
              i = 0;
            }
          case 39: 
            QLog.e(jdField_a_of_type_JavaLangString, 1, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
            localrgc.jdField_f_of_type_Boolean = true;
            if ((paramObject instanceof String)) {
              localrgc.jdField_f_of_type_JavaLangString = ((String)paramObject);
            }
            ryx.b(this.jdField_a_of_type_AndroidAppActivity, anni.a(2131715017));
            return false;
          case 41: 
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "播放状态回调 onInfo() PLAYER_INFO_CHANGE_HW_BACKUP_URL");
            }
            localrgc.jdField_g_of_type_Boolean = true;
            ryx.b(this.jdField_a_of_type_AndroidAppActivity, anni.a(2131715000));
            return false;
          }
        } while (paramObject == null);
        paramsfb = ((String)paramObject).split(":", 2);
      } while ((paramsfb == null) || (paramsfb.length != 2));
      if (QLog.isColorLevel()) {
        QLog.d("VideoPlayManager", 2, "Performance PERFORMANCE_REPORT videoPlayVideoParam:" + this.jdField_b_of_type_Sey + "  method:" + paramsfb[0] + "\ntimeJson:" + paramsfb[1]);
      }
    } while (!"prepare".equals(paramsfb[0]));
    localrgc.jdField_l_of_type_JavaLangString = paramsfb[1];
    return false;
    rui.a.a(paramObject, localrgc);
    return false;
    localrgc.v = (SystemClock.uptimeMillis() - localrgc.jdField_b_of_type_Long);
    localrgc.w = (SystemClock.uptimeMillis() - localrgc.jdField_c_of_type_Long);
    return false;
    localrgc.jdField_t_of_type_Int = ((Long)paramObject).intValue();
    return false;
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_Sfb != null) {
      i = this.jdField_a_of_type_Sfb.b();
    }
    if (i == this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) {
      return i;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.readinjoy.video", 2, "getCurPlayState, should not happen...: mVideoPlayerWrapper.getCurrentStatus() = " + sfa.a(i) + ",mState.get()=" + sfa.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Sfb != null) {
      return this.jdField_a_of_type_Sfb.a();
    }
    return 0L;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Sfb != null) {
      return this.jdField_a_of_type_Sfb.a();
    }
    return null;
  }
  
  public sey a()
  {
    return this.jdField_b_of_type_Sey;
  }
  
  public sfb a(String paramString)
  {
    paramString = (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return (sfb)paramString.get();
    }
    return null;
  }
  
  public sfb a(sey paramsey)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return null;
    }
    sfb localsfb = new sfb(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    localsfb.e(true);
    localsfb.a(this.jdField_a_of_type_Sex);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "getVideoPlayer new instant!");
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramsey.a(), new WeakReference(localsfb));
    return localsfb;
  }
  
  public sfq a()
  {
    return this.jdField_a_of_type_Sfq;
  }
  
  public void a()
  {
    e(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Sfb != null) {
      this.jdField_a_of_type_Sfb.b(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video", 2, "setXYaxis value:" + paramInt);
    }
  }
  
  public void a(int paramInt, sey paramsey)
  {
    this.jdField_d_of_type_Sey = null;
    if ((this.jdField_b_of_type_Sey != null) && (this.jdField_a_of_type_Sfb != null))
    {
      if (this.jdField_a_of_type_Sfb.b() == 2) {
        this.jdField_a_of_type_Sfb.d();
      }
      this.jdField_a_of_type_Sfb.a(paramInt);
      a(this.jdField_b_of_type_Sey, this.jdField_a_of_type_Sfb, 3, null);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: mVideoPlayerWrapper.seekTo() position=" + paramInt);
      }
      a(this.jdField_a_of_type_Sfb, paramsey, false);
    }
    do
    {
      do
      {
        return;
        if (paramsey == null) {
          break;
        }
        this.jdField_b_of_type_Sey = paramsey;
        paramsey = this.jdField_b_of_type_Sey;
        b(1);
        paramsey.jdField_d_of_type_Long = paramInt;
        a(paramsey);
      } while (!QLog.isColorLevel());
      QLog.w(jdField_a_of_type_JavaLangString, 2, "resume(): mCurrenPlayVideoParam = null, playVideo: " + paramsey.jdField_c_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: param = null && mVideoPlayerWrapper = null");
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "player stop [async]  stopID : " + paramLong + ", from : " + paramInt);
    }
    if ((this.jdField_a_of_type_Sfb != null) && (this.jdField_b_of_type_Sey != null) && (this.jdField_b_of_type_Sey.jdField_c_of_type_Long == paramLong))
    {
      this.jdField_b_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setKeepScreenOn(false);
      a(this.jdField_b_of_type_Sey, this.jdField_a_of_type_Sfb, 0, null);
      this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_a_of_type_Long = this.jdField_a_of_type_Sfb.a(false);
      this.jdField_b_of_type_Sey.jdField_d_of_type_Long = a();
      if ((this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_d_of_type_Long == 0L) && (this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_b_of_type_Long != 0L)) {
        this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_b_of_type_Long);
      }
      this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_a_of_type_Float = ((float)this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_a_of_type_Long / this.jdField_b_of_type_Sey.jdField_b_of_type_Int);
      this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.n = this.jdField_a_of_type_Sfb.c();
      this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_f_of_type_Int = this.jdField_a_of_type_Sfb.e();
      this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_g_of_type_Int = this.jdField_a_of_type_Sfb.f();
      this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_c_of_type_Boolean = this.jdField_a_of_type_Sfb.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_q_of_type_Long = this.jdField_a_of_type_Sfb.jdField_b_of_type_Long;
      this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_p_of_type_Long = this.jdField_a_of_type_Sfb.jdField_a_of_type_Long;
      this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.r = this.jdField_a_of_type_Sfb.g();
      if ((this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_d_of_type_Long == 0L))
      {
        this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_b_of_type_Long);
        this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_f_of_type_Long = this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_d_of_type_Long;
      }
      this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_l_of_type_Int = c();
      this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_m_of_type_Int = d();
      if (this.jdField_c_of_type_Sey != null)
      {
        localObject = this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc;
        paramInt = this.jdField_c_of_type_Sey.jdField_a_of_type_Int;
        i = this.jdField_b_of_type_Sey.jdField_a_of_type_Int;
        if (this.jdField_b_of_type_Sey.jdField_m_of_type_Int == 3)
        {
          bool = true;
          ((rgc)localObject).s = pha.a(paramInt, i, bool);
          this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_d_of_type_Int = this.jdField_b_of_type_Sey.jdField_m_of_type_Int;
          paramLong = this.jdField_a_of_type_Sfb.b();
          localObject = this.jdField_a_of_type_Sfb.a();
          this.jdField_a_of_type_Sfb.l();
          a(this.jdField_b_of_type_Sey);
          pha.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), pha.a(), true, this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.a());
          obh.a(this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc);
          pha.a(true, this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_d_of_type_Boolean, this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_g_of_type_Int, this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_a_of_type_Int, this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_d_of_type_Long, 56, this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_a_of_type_JavaLangString);
          if ((this.jdField_b_of_type_Sey.jdField_d_of_type_Long > 0L) && (this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_a_of_type_Long > 0L)) {
            ThreadManager.post(new VideoPlayManager.9(this, this.jdField_b_of_type_Sey, this.jdField_a_of_type_Sfn, paramLong, (String)localObject), 5, null, true);
          }
          this.jdField_d_of_type_Boolean = false;
          this.jdField_c_of_type_Sey = this.jdField_b_of_type_Sey;
          this.jdField_b_of_type_Sey = null;
          this.jdField_a_of_type_Sfb = null;
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
        this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.s = -1;
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
  
  public void a(ruh paramruh)
  {
    if ((paramruh == null) || (!(paramruh instanceof sey))) {}
    do
    {
      return;
      if (!sgc.a(this.jdField_a_of_type_AndroidAppActivity)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "playVideo in call return");
    return;
    paramruh = (sey)paramruh;
    try
    {
      this.jdField_d_of_type_Sey = null;
      this.jdField_a_of_type_Sey = null;
      if (this.jdField_a_of_type_Sfq != null) {
        this.jdField_a_of_type_Sfq.a(paramruh);
      }
      if (!this.jdField_a_of_type_Sfd.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "start install tencent sdk plugin");
        }
        this.jdField_b_of_type_Sey = paramruh;
        a(this.jdField_b_of_type_Sey, null, 4, null);
        this.jdField_a_of_type_Sfd.a();
        return;
      }
    }
    catch (Exception paramruh)
    {
      paramruh.printStackTrace();
      QLog.e("Q.readinjoy.video", 1, "playVideo error:", paramruh);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "play video start ! playParams : " + paramruh.toString());
    }
    this.jdField_a_of_type_Boolean = true;
    sfb localsfb = a(paramruh);
    this.jdField_a_of_type_Sfb = localsfb;
    this.jdField_b_of_type_Sey = paramruh;
    a(this.jdField_b_of_type_Sey, this.jdField_a_of_type_Sfb, 1, null);
    paramruh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
    this.jdField_a_of_type_Sfb.a(paramruh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup);
    six localsix = this.jdField_a_of_type_Sfb.a();
    if ((localsix == null) || (localsix.a() == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "playVideo failed, because get videoView == null!");
      a(this.jdField_b_of_type_Sey, null, 6, "videoview null");
      this.jdField_a_of_type_Sfb = null;
      this.jdField_b_of_type_Sey = null;
      return;
    }
    paramruh.jdField_a_of_type_Six = localsix;
    localsix.a().setId(2131376024);
    paramruh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setKeepScreenOn(true);
    this.jdField_a_of_type_Sfb.b(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.o = 0;
    this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_p_of_type_Int = 0;
    this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_q_of_type_Int = 0;
    this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_g_of_type_Boolean = false;
    this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.h = false;
    ThreadManager.executeOnSubThread(new VideoPlayManager.7(this, localsfb, paramruh));
  }
  
  public void a(rvk paramrvk)
  {
    paramrvk.a(this);
  }
  
  public void a(rvr paramrvr)
  {
    this.jdField_a_of_type_Rvr = paramrvr;
  }
  
  public void a(sew paramsew)
  {
    if ((paramsew != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramsew))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramsew);
    }
  }
  
  public void a(sez paramsez)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null) {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramsez);
  }
  
  public void a(sfn paramsfn)
  {
    this.jdField_a_of_type_Sfn = paramsfn;
  }
  
  public void a(sfq paramsfq)
  {
    this.jdField_a_of_type_Sfq = paramsfq;
    this.jdField_a_of_type_Sfq.a(this);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Sfb != null) && (this.jdField_a_of_type_Sfb.l());
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long b()
  {
    if (this.jdField_b_of_type_Sey == null) {
      return -1L;
    }
    return this.jdField_b_of_type_Sey.jdField_c_of_type_Long;
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
    if ((this.jdField_b_of_type_Sey != null) && (this.jdField_a_of_type_Sfb != null)) {
      a(this.jdField_b_of_type_Sey.jdField_c_of_type_Long, paramInt);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "stop , from : " + paramInt);
      }
      return;
      if (this.jdField_a_of_type_Sfb != null)
      {
        a(this.jdField_b_of_type_Sey, this.jdField_a_of_type_Sfb, 0, null);
        this.jdField_a_of_type_Sfb.l();
        this.jdField_a_of_type_Sfb = null;
        this.jdField_b_of_type_Sey = null;
      }
      else if (this.jdField_b_of_type_Sey != null)
      {
        a(this.jdField_b_of_type_Sey, this.jdField_a_of_type_Sfb, 0, null);
        this.jdField_a_of_type_Sfb = null;
        this.jdField_b_of_type_Sey = null;
      }
    }
  }
  
  public void b(sew paramsew)
  {
    if ((paramsew != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramsew);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this.jdField_b_of_type_Sey != null)
    {
      bool = paramBoolean;
      if (this.jdField_b_of_type_Sey.jdField_b_of_type_Boolean) {
        bool = true;
      }
    }
    if (this.jdField_a_of_type_Sfb != null) {
      this.jdField_a_of_type_Sfb.c(bool);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Sfb != null) && (this.jdField_a_of_type_Sfb.f());
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Sfb != null) {
      return this.jdField_a_of_type_Sfb.c();
    }
    return -1;
  }
  
  public long c()
  {
    if (this.jdField_b_of_type_Sey == null) {
      return 0L;
    }
    return this.jdField_b_of_type_Sey.jdField_b_of_type_Long;
  }
  
  public void c()
  {
    f(false);
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Sfb != null) {
      this.jdField_a_of_type_Sfb.a(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk success!");
      }
      if (this.jdField_b_of_type_Sey != null) {
        a(this.jdField_b_of_type_Sey);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk fail!");
    }
    a(this.jdField_b_of_type_Sey, this.jdField_a_of_type_Sfb, 6, "install failure");
    this.jdField_b_of_type_Sey = null;
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Sfb != null) {
      return this.jdField_a_of_type_Sfb.d();
    }
    return -1;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : destroy !");
    }
    b(7);
    if (this.jdField_a_of_type_Sfb != null)
    {
      this.jdField_a_of_type_Sfb.l();
      this.jdField_a_of_type_Sfb = null;
    }
    if (this.jdField_b_of_type_Sey != null) {
      this.jdField_b_of_type_Sey = null;
    }
    this.jdField_a_of_type_Sfd.b();
    this.jdField_a_of_type_Sfd = null;
    try
    {
      this.jdField_a_of_type_AndroidAppActivity = null;
      sgc.a().b(this);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        sfb localsfb = (sfb)((WeakReference)localIterator.next()).get();
        if ((localsfb != null) && (!localsfb.jdField_a_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper : " + localsfb.toString() + " not release");
          }
          localsfb.l();
        }
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
    if (this.jdField_a_of_type_Sfq != null)
    {
      this.jdField_a_of_type_Sfq.n();
      this.jdField_a_of_type_Sfq = null;
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
    if ((this.jdField_a_of_type_Sfb == null) || (this.jdField_b_of_type_Sey == null)) {}
    do
    {
      return false;
      if (a() == 5)
      {
        if ((!this.jdField_a_of_type_Sfb.e()) && (QLog.isColorLevel())) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return true. getCurPlayState is PLAY_STATE_PAUSED. But mVideoPlayerWrapper.isPause() == false;");
        }
        return true;
      }
    } while ((!this.jdField_a_of_type_Sfb.e()) || (!QLog.isColorLevel()));
    QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return false. getCurPlayState is " + sfa.a(a()) + ". But mVideoPlayerWrapper.isPause() == true;");
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
      a(this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_a_of_type_Long, this.jdField_a_of_type_Sfb.b(), this.jdField_a_of_type_Sfb.a(), this.jdField_b_of_type_Sey, false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Sfq != null)
      {
        this.jdField_a_of_type_Sfq.b();
        this.jdField_a_of_type_Sfq.a(false);
      }
      sgu.a().b(this.jdField_a_of_type_AndroidAppActivity);
      return;
      label138:
      if (f()) {
        b(8);
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Sfb != null) && (this.jdField_a_of_type_Sfb.f()))
    {
      this.jdField_a_of_type_Sfb.f();
      this.jdField_d_of_type_Boolean = paramBoolean;
      if (!bgnt.h(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext())) {
        this.jdField_a_of_type_Sfb.j();
      }
      a(this.jdField_b_of_type_Sey, this.jdField_a_of_type_Sfb, 5, Boolean.valueOf(this.jdField_d_of_type_Boolean));
      this.jdField_b_of_type_Sey.jdField_d_of_type_Long = a();
      this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_a_of_type_Long = this.jdField_a_of_type_Sfb.a(false);
      BaseArticleInfo localBaseArticleInfo = this.jdField_b_of_type_Sey.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (oqj.a((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && ((this.jdField_b_of_type_Sey.jdField_b_of_type_Boolean) || (localBaseArticleInfo.mChannelID == 56L)))
      {
        int j = 1;
        int i = nxw.S;
        if (localBaseArticleInfo.mChannelID == 56L)
        {
          j = nxw.aJ;
          i = nxw.O;
        }
        nxw.a(new omp().a(this.jdField_a_of_type_AndroidAppActivity).a(nxw.jdField_f_of_type_Int).b(i).a((AdvertisementInfo)localBaseArticleInfo).a(nxw.a(((AdvertisementInfo)localBaseArticleInfo).adbt, (int)this.jdField_b_of_type_Sey.jdField_d_of_type_Long, ((AdvertisementInfo)localBaseArticleInfo).getAdbf(), 0, ((AdvertisementInfo)localBaseArticleInfo).adpa, ((AdvertisementInfo)localBaseArticleInfo).adpb, localBaseArticleInfo.mVideoDuration, j, 0)).a());
        ((AdvertisementInfo)localBaseArticleInfo).adbt = ((int)this.jdField_b_of_type_Sey.jdField_d_of_type_Long);
      }
    }
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_Sfb != null) && (a() == 2);
  }
  
  public void f()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onVisiable() isPause()=" + d() + ", mPausedByMannul:" + this.jdField_d_of_type_Boolean);
      }
      if ((this.jdField_b_of_type_Sey != null) && (this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc != null)) {
        this.jdField_b_of_type_Sey.jdField_a_of_type_Rgc.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if ((d()) && (!this.jdField_d_of_type_Boolean)) {
        c();
      }
      if (this.jdField_a_of_type_Sfq != null)
      {
        this.jdField_a_of_type_Sfq.a();
        if (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
          break label152;
        }
        this.jdField_a_of_type_Sfq.a(false);
      }
    }
    for (;;)
    {
      sgu.a().a(this.jdField_a_of_type_AndroidAppActivity);
      return;
      label152:
      this.jdField_a_of_type_Sfq.a(true);
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (d())
    {
      if (!sgc.a(this.jdField_a_of_type_AndroidAppActivity)) {
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
    this.jdField_a_of_type_Sfb.e();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    a(this.jdField_b_of_type_Sey, this.jdField_a_of_type_Sfb, 3, null);
    a(this.jdField_a_of_type_Sfb, this.jdField_b_of_type_Sey, paramBoolean);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_Sfb != null) && (this.jdField_a_of_type_Sfb.b());
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
    if (this.jdField_a_of_type_Sfq != null) {
      return this.jdField_a_of_type_Sfq.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     seu
 * JD-Core Version:    0.7.0.1
 */