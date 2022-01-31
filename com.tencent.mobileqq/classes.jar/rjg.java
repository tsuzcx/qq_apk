import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.3;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.4;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
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

public class rjg
  implements qyy, rjr
{
  public static final String a;
  protected int a;
  private volatile Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private ArrayList<Pair<Integer, Bitmap>> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Integer, rjn> jdField_a_of_type_JavaUtilHashMap;
  private Map<String, WeakReference<rjn>> jdField_a_of_type_JavaUtilMap;
  private Set<rjl> jdField_a_of_type_JavaUtilSet;
  private CopyOnWriteArrayList<rjj> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private qzy jdField_a_of_type_Qzy;
  public rjk a;
  private rjn jdField_a_of_type_Rjn;
  private rjo jdField_a_of_type_Rjo = new rjh(this);
  private rjp jdField_a_of_type_Rjp;
  private rkb jdField_a_of_type_Rkb;
  private rkp jdField_a_of_type_Rkp;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private String jdField_b_of_type_JavaLangString;
  private rjk jdField_b_of_type_Rjk;
  private boolean jdField_b_of_type_Boolean = true;
  private rjk jdField_c_of_type_Rjk;
  private volatile boolean jdField_c_of_type_Boolean;
  private rjk jdField_d_of_type_Rjk;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + rjg.class.getSimpleName();
  }
  
  public rjg(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : create a new manager !");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Rjp = new rjp(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.jdField_a_of_type_Rjp.a(this);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    rlb.a().a(this);
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
  
  private void a(rjk paramrjk)
  {
    paramrjk.jdField_a_of_type_Qlq.v = rlt.a().a();
    paramrjk.jdField_a_of_type_Qlq.jdField_n_of_type_JavaLangString = rmc.a().a();
  }
  
  private void a(rjk paramrjk, rjn paramrjn, int paramInt, Object paramObject)
  {
    int i;
    try
    {
      i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (paramInt != i)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "changeStateAndNotify(): " + rjm.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + " ===> " + rjm.a(paramInt) + ", extra = " + paramObject + ", videoPlayParam=" + paramrjk + ", videoPlayWrapper=" + paramrjn);
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label193;
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext())
          {
            rjj localrjj = (rjj)localIterator.next();
            if (localrjj != null) {
              localrjj.a(paramrjk, paramrjn, i, paramInt, paramObject);
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
      label193:
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.2(this, paramrjk, paramrjn, i, paramInt, paramObject));
    }
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_Rjn != null) {
      i = this.jdField_a_of_type_Rjn.e();
    }
    if (i == this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) {
      return i;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.readinjoy.video", 2, "getCurPlayState, should not happen...: mVideoPlayerWrapper.getCurrentStatus() = " + rjm.a(i) + ",mState.get()=" + rjm.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Rjn != null) {
      return this.jdField_a_of_type_Rjn.a();
    }
    return 0L;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public rjk a()
  {
    return this.jdField_b_of_type_Rjk;
  }
  
  public rjn a(String paramString)
  {
    paramString = (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return (rjn)paramString.get();
    }
    return null;
  }
  
  public rjn a(rjk paramrjk)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return null;
    }
    rjn localrjn = new rjn(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    localrjn.e(true);
    localrjn.a(this.jdField_a_of_type_Rjo);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "getVideoPlayer new instant!");
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramrjk.a(), new WeakReference(localrjn));
    return localrjn;
  }
  
  public rkp a()
  {
    return this.jdField_a_of_type_Rkp;
  }
  
  public void a()
  {
    e(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Rjn != null) {
      this.jdField_a_of_type_Rjn.b(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video", 2, "setXYaxis value:" + paramInt);
    }
  }
  
  public void a(int paramInt, rjk paramrjk)
  {
    this.jdField_d_of_type_Rjk = null;
    if ((this.jdField_b_of_type_Rjk != null) && (this.jdField_a_of_type_Rjn != null))
    {
      if (this.jdField_a_of_type_Rjn.e() == 2) {
        this.jdField_a_of_type_Rjn.f();
      }
      this.jdField_a_of_type_Rjn.a(paramInt);
      a(this.jdField_b_of_type_Rjk, this.jdField_a_of_type_Rjn, 3, null);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: mVideoPlayerWrapper.seekTo() position=" + paramInt);
      }
    }
    do
    {
      do
      {
        return;
        if (paramrjk == null) {
          break;
        }
        this.jdField_b_of_type_Rjk = paramrjk;
        paramrjk = this.jdField_b_of_type_Rjk;
        b(1);
        paramrjk.d = paramInt;
        a(paramrjk);
      } while (!QLog.isColorLevel());
      QLog.w(jdField_a_of_type_JavaLangString, 2, "resume(): mCurrenPlayVideoParam = null, playVideo: " + paramrjk.jdField_c_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: param = null && mVideoPlayerWrapper = null");
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "player stop [async]  stopID : " + paramLong + ", from : " + paramInt);
    }
    if ((this.jdField_a_of_type_Rjn != null) && (this.jdField_b_of_type_Rjk != null) && (this.jdField_b_of_type_Rjk.jdField_c_of_type_Long == paramLong))
    {
      this.jdField_b_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setKeepScreenOn(false);
      a(this.jdField_b_of_type_Rjk, this.jdField_a_of_type_Rjn, 0, null);
      this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_a_of_type_Long = this.jdField_a_of_type_Rjn.a(false);
      this.jdField_b_of_type_Rjk.d = a();
      if ((this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_c_of_type_Long == 0L) && (this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_b_of_type_Long != 0L)) {
        this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_b_of_type_Long);
      }
      this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_a_of_type_Float = ((float)this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_a_of_type_Long / this.jdField_b_of_type_Rjk.jdField_b_of_type_Int);
      this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.m = this.jdField_a_of_type_Rjn.c();
      this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_e_of_type_Int = this.jdField_a_of_type_Rjn.c();
      this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_f_of_type_Int = this.jdField_a_of_type_Rjn.d();
      this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_c_of_type_Boolean = this.jdField_a_of_type_Rjn.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_p_of_type_Long = this.jdField_a_of_type_Rjn.jdField_b_of_type_Long;
      this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_o_of_type_Long = this.jdField_a_of_type_Rjn.jdField_a_of_type_Long;
      this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.q = this.jdField_a_of_type_Rjn.f();
      this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_r_of_type_Long = this.jdField_a_of_type_Rjn.f();
      this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Rjn.a();
      this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.t = this.jdField_a_of_type_Rjn.h();
      this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.u = this.jdField_a_of_type_Rjn.g();
      if ((this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_c_of_type_Long == 0L))
      {
        this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_b_of_type_Long);
        this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_e_of_type_Long = this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_c_of_type_Long;
      }
      this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.k = c();
      this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.l = d();
      if (this.jdField_c_of_type_Rjk != null)
      {
        localqlq = this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq;
        paramInt = this.jdField_c_of_type_Rjk.jdField_a_of_type_Int;
        i = this.jdField_b_of_type_Rjk.jdField_a_of_type_Int;
        if (this.jdField_b_of_type_Rjk.m == 3)
        {
          bool = true;
          localqlq.jdField_r_of_type_Int = ors.a(paramInt, i, bool);
          this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_c_of_type_Int = this.jdField_b_of_type_Rjk.m;
          this.jdField_a_of_type_Rjn.m();
          a(this.jdField_b_of_type_Rjk);
          ors.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), ors.a(), true, this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.a());
          nse.a(this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq);
          ors.a(true, this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_d_of_type_Boolean, this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_f_of_type_Int, this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_a_of_type_Int, this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_c_of_type_Long, 56, this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_a_of_type_JavaLangString);
          if ((this.jdField_b_of_type_Rjk.d > 0L) && (this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_a_of_type_Long > 0L)) {
            ThreadManager.post(new VideoPlayManager.4(this, this.jdField_b_of_type_Rjk, this.jdField_a_of_type_Rkb), 5, null, true);
          }
          this.jdField_d_of_type_Boolean = false;
          this.jdField_c_of_type_Rjk = this.jdField_b_of_type_Rjk;
          this.jdField_b_of_type_Rjk = null;
          this.jdField_a_of_type_Rjn = null;
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        qlq localqlq;
        int i;
        return;
        boolean bool = false;
        continue;
        this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_r_of_type_Int = -1;
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
  
  public void a(qyp paramqyp)
  {
    if ((paramqyp == null) || (!(paramqyp instanceof rjk))) {}
    do
    {
      do
      {
        return;
        paramqyp = (rjk)paramqyp;
        if (!rlb.a(this.jdField_a_of_type_AndroidAppActivity)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "playVideo in call return");
      return;
      try
      {
        this.jdField_d_of_type_Rjk = null;
        this.jdField_a_of_type_Rjk = null;
        if (this.jdField_a_of_type_Rkp != null) {
          this.jdField_a_of_type_Rkp.a(paramqyp);
        }
        if (this.jdField_a_of_type_Rjp.a()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "start install tencent sdk plugin");
        }
        this.jdField_b_of_type_Rjk = paramqyp;
        a(this.jdField_b_of_type_Rjk, null, 4, null);
        this.jdField_a_of_type_Rjp.a();
        return;
      }
      catch (Exception paramqyp)
      {
        paramqyp.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.readinjoy.video", 2, "playVideo error:", paramqyp);
    return;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "play video start ! playParams : " + paramqyp.toString());
    }
    this.jdField_a_of_type_Boolean = true;
    rjn localrjn = a(paramqyp);
    this.jdField_a_of_type_Rjn = localrjn;
    this.jdField_b_of_type_Rjk = paramqyp;
    a(this.jdField_b_of_type_Rjk, this.jdField_a_of_type_Rjn, 1, null);
    View localView = this.jdField_a_of_type_Rjn.b();
    if (localView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "playVideo : get videoView Fail !");
      }
      a(this.jdField_b_of_type_Rjk, null, 6, "videoview null");
      this.jdField_a_of_type_Rjn = null;
      this.jdField_b_of_type_Rjk = null;
      return;
    }
    paramqyp.jdField_b_of_type_AndroidViewView = localView;
    localView.setId(2131375294);
    paramqyp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setKeepScreenOn(true);
    paramqyp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
    paramqyp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_Rjn.b(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Rjn.a((IVideoViewBase)localView);
    this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_n_of_type_Int = 0;
    this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_o_of_type_Int = 0;
    this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_p_of_type_Int = 0;
    this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.g = false;
    this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.h = false;
    ThreadManager.executeOnSubThread(new VideoPlayManager.3(this, paramqyp, localrjn));
  }
  
  public void a(qzp paramqzp)
  {
    paramqzp.a(this);
  }
  
  public void a(qzy paramqzy)
  {
    this.jdField_a_of_type_Qzy = paramqzy;
  }
  
  public void a(rjj paramrjj)
  {
    if ((paramrjj != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramrjj))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramrjj);
    }
  }
  
  public void a(rjl paramrjl)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null) {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramrjl);
  }
  
  public void a(rkb paramrkb)
  {
    this.jdField_a_of_type_Rkb = paramrkb;
  }
  
  public void a(rkp paramrkp)
  {
    this.jdField_a_of_type_Rkp = paramrkp;
    this.jdField_a_of_type_Rkp.a(this);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Rjn != null) && (this.jdField_a_of_type_Rjn.b());
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long b()
  {
    if (this.jdField_b_of_type_Rjk == null) {
      return -1L;
    }
    return this.jdField_b_of_type_Rjk.jdField_c_of_type_Long;
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = false;
    e(false);
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_b_of_type_Rjk != null) && (this.jdField_a_of_type_Rjn != null)) {
      a(this.jdField_b_of_type_Rjk.jdField_c_of_type_Long, paramInt);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "stop , from : " + paramInt);
      }
      return;
      if (this.jdField_a_of_type_Rjn != null)
      {
        a(this.jdField_b_of_type_Rjk, this.jdField_a_of_type_Rjn, 0, null);
        this.jdField_a_of_type_Rjn.m();
        this.jdField_a_of_type_Rjn = null;
        this.jdField_b_of_type_Rjk = null;
      }
      else if (this.jdField_b_of_type_Rjk != null)
      {
        a(this.jdField_b_of_type_Rjk, this.jdField_a_of_type_Rjn, 0, null);
        this.jdField_a_of_type_Rjn = null;
        this.jdField_b_of_type_Rjk = null;
      }
    }
  }
  
  public void b(rjj paramrjj)
  {
    if ((paramrjj != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramrjj);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this.jdField_b_of_type_Rjk != null)
    {
      bool = paramBoolean;
      if (this.jdField_b_of_type_Rjk.jdField_b_of_type_Boolean) {
        bool = true;
      }
    }
    if ((this.jdField_a_of_type_Rjn != null) && (this.jdField_a_of_type_Rjn.a() != null)) {
      this.jdField_a_of_type_Rjn.a().setOutputMute(bool);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Rjn != null) && (this.jdField_a_of_type_Rjn.c());
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Rjn != null) {
      return this.jdField_a_of_type_Rjn.a();
    }
    return -1;
  }
  
  public long c()
  {
    if (this.jdField_b_of_type_Rjk == null) {
      return 0L;
    }
    return this.jdField_b_of_type_Rjk.jdField_b_of_type_Long;
  }
  
  public void c()
  {
    if (!rcp.a().a()) {
      f(false);
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Rjn != null) {
      this.jdField_a_of_type_Rjn.a(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk success!");
      }
      if (this.jdField_b_of_type_Rjk != null) {
        a(this.jdField_b_of_type_Rjk);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk fail!");
    }
    a(this.jdField_b_of_type_Rjk, this.jdField_a_of_type_Rjn, 6, "install failure");
    this.jdField_b_of_type_Rjk = null;
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Rjn != null) {
      return this.jdField_a_of_type_Rjn.b();
    }
    return -1;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : destroy !");
    }
    b(7);
    if (this.jdField_a_of_type_Rjn != null)
    {
      this.jdField_a_of_type_Rjn.m();
      this.jdField_a_of_type_Rjn = null;
    }
    if (this.jdField_b_of_type_Rjk != null) {
      this.jdField_b_of_type_Rjk = null;
    }
    this.jdField_a_of_type_Rjp.b();
    this.jdField_a_of_type_Rjp = null;
    try
    {
      this.jdField_a_of_type_AndroidAppActivity = null;
      rlb.a().b(this);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        rjn localrjn = (rjn)((WeakReference)localIterator.next()).get();
        if ((localrjn != null) && (!localrjn.jdField_a_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper : " + localrjn.toString() + " not release");
          }
          localrjn.m();
        }
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
    if (this.jdField_a_of_type_Rkp != null)
    {
      this.jdField_a_of_type_Rkp.m();
      this.jdField_a_of_type_Rkp = null;
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
    if ((this.jdField_a_of_type_Rjn == null) || (this.jdField_b_of_type_Rjk == null)) {}
    do
    {
      return false;
      if (a() == 5)
      {
        if ((!this.jdField_a_of_type_Rjn.d()) && (QLog.isColorLevel())) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return true. getCurPlayState is PLAY_STATE_PAUSED. But mVideoPlayerWrapper.isPause() == false;");
        }
        return true;
      }
    } while ((!this.jdField_a_of_type_Rjn.d()) || (!QLog.isColorLevel()));
    QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return false. getCurPlayState is " + rjm.a(a()) + ". But mVideoPlayerWrapper.isPause() == true;");
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
        break label105;
      }
      a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Rkp != null)
      {
        this.jdField_a_of_type_Rkp.b();
        this.jdField_a_of_type_Rkp.a(false);
      }
      rlt.a().b(this.jdField_a_of_type_AndroidAppActivity);
      return;
      label105:
      if (f()) {
        b(8);
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Rjn != null) && (this.jdField_a_of_type_Rjn.c()))
    {
      this.jdField_a_of_type_Rjn.h();
      this.jdField_d_of_type_Boolean = paramBoolean;
      if (!bdin.h(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext())) {
        this.jdField_a_of_type_Rjn.k();
      }
      a(this.jdField_b_of_type_Rjk, this.jdField_a_of_type_Rjn, 5, Boolean.valueOf(this.jdField_d_of_type_Boolean));
      this.jdField_b_of_type_Rjk.d = a();
      this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_a_of_type_Long = this.jdField_a_of_type_Rjn.a(false);
      BaseArticleInfo localBaseArticleInfo = this.jdField_b_of_type_Rjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (oee.a((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && ((this.jdField_b_of_type_Rjk.jdField_b_of_type_Boolean) || (localBaseArticleInfo.mChannelID == 56L)))
      {
        int j = 1;
        int i = noy.Q;
        if (localBaseArticleInfo.mChannelID == 56L)
        {
          j = noy.aF;
          i = noy.M;
        }
        noy.a(new obk().a(this.jdField_a_of_type_AndroidAppActivity).a(noy.jdField_f_of_type_Int).b(i).a((AdvertisementInfo)localBaseArticleInfo).a(noy.a(((AdvertisementInfo)localBaseArticleInfo).adbt, (int)this.jdField_b_of_type_Rjk.d, ((AdvertisementInfo)localBaseArticleInfo).getAdbf(), 0, ((AdvertisementInfo)localBaseArticleInfo).adpa, ((AdvertisementInfo)localBaseArticleInfo).adpb, localBaseArticleInfo.mVideoDuration, j, 0)).a());
        ((AdvertisementInfo)localBaseArticleInfo).adbt = ((int)this.jdField_b_of_type_Rjk.d);
      }
    }
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_Rjn != null) && (a() == 2);
  }
  
  public void f()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onVisiable() isPause()=" + d() + ", mPausedByMannul:" + this.jdField_d_of_type_Boolean);
      }
      if ((this.jdField_b_of_type_Rjk != null) && (this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq != null)) {
        this.jdField_b_of_type_Rjk.jdField_a_of_type_Qlq.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if ((d()) && (!this.jdField_d_of_type_Boolean)) {
        c();
      }
      if (this.jdField_a_of_type_Rkp != null)
      {
        this.jdField_a_of_type_Rkp.a();
        if (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
          break label152;
        }
        this.jdField_a_of_type_Rkp.a(false);
      }
    }
    for (;;)
    {
      rlt.a().a(this.jdField_a_of_type_AndroidAppActivity);
      return;
      label152:
      this.jdField_a_of_type_Rkp.a(true);
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (d())
    {
      if (!rlb.a(this.jdField_a_of_type_AndroidAppActivity)) {
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
    this.jdField_a_of_type_Rjn.g();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    a(this.jdField_b_of_type_Rjk, this.jdField_a_of_type_Rjn, 3, null);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_Rjn != null) && (this.jdField_a_of_type_Rjn.f());
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
    if (this.jdField_a_of_type_Rkp != null) {
      return this.jdField_a_of_type_Rkp.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rjg
 * JD-Core Version:    0.7.0.1
 */