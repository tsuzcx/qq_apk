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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class qhp
  implements pxv, qia
{
  public static final String a;
  protected int a;
  private volatile Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private ArrayList<Pair<Integer, Bitmap>> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Integer, qhw> jdField_a_of_type_JavaUtilHashMap;
  private List<WeakReference<qhw>> jdField_a_of_type_JavaUtilList;
  private Set<qhu> jdField_a_of_type_JavaUtilSet;
  private CopyOnWriteArrayList<qhs> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private pyu jdField_a_of_type_Pyu;
  private qht jdField_a_of_type_Qht;
  private qhw jdField_a_of_type_Qhw;
  private qhx jdField_a_of_type_Qhx = new qhq(this);
  private qhy jdField_a_of_type_Qhy;
  private qik jdField_a_of_type_Qik;
  private qiy jdField_a_of_type_Qiy;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private String jdField_b_of_type_JavaLangString;
  private qht jdField_b_of_type_Qht;
  private boolean jdField_b_of_type_Boolean = true;
  private qht jdField_c_of_type_Qht;
  private volatile boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + qhp.class.getSimpleName();
  }
  
  public qhp(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : create a new manager !");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Qhy = new qhy(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.jdField_a_of_type_Qhy.a(this);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    qji.a().a(this);
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
  
  private void a(qht paramqht)
  {
    paramqht.jdField_a_of_type_Pqb.v = qka.a().a();
    long[] arrayOfLong = qka.a().a();
    paramqht.jdField_a_of_type_Pqb.z = arrayOfLong[0];
    paramqht.jdField_a_of_type_Pqb.A = arrayOfLong[1];
    paramqht.jdField_a_of_type_Pqb.x = arrayOfLong[2];
    paramqht.jdField_a_of_type_Pqb.y = arrayOfLong[3];
    paramqht.jdField_a_of_type_Pqb.w = arrayOfLong[4];
  }
  
  private void a(qht paramqht, qhw paramqhw, int paramInt, Object paramObject)
  {
    int i;
    try
    {
      i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (paramInt != i)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "changeStateAndNotify(): " + qhv.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + " ===> " + qhv.a(paramInt) + ", extra = " + paramObject + ", videoPlayParam=" + paramqht + ", videoPlayWrapper=" + paramqhw);
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label196;
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext())
          {
            qhs localqhs = (qhs)localIterator.next();
            if (localqhs != null) {
              localqhs.a(paramqht, paramqhw, i, paramInt, paramObject);
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
      label196:
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.2(this, paramqht, paramqhw, i, paramInt, paramObject));
    }
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_Qhw != null) {
      i = this.jdField_a_of_type_Qhw.e();
    }
    if (i == this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) {
      return i;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.readinjoy.video", 2, "getCurPlayState, should not happen...: mVideoPlayerWrapper.getCurrentStatus() = " + qhv.a(i) + ",mState.get()=" + qhv.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Qhw != null) {
      return this.jdField_a_of_type_Qhw.a();
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
  
  public qht a()
  {
    return this.jdField_a_of_type_Qht;
  }
  
  public qhw a(qht paramqht)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return null;
    }
    paramqht = new qhw(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    paramqht.e(true);
    paramqht.a(this.jdField_a_of_type_Qhx);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "getVideoPlayer new instant!");
    }
    this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramqht));
    return paramqht;
  }
  
  public qiy a()
  {
    return this.jdField_a_of_type_Qiy;
  }
  
  public void a()
  {
    e(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Qhw != null) {
      this.jdField_a_of_type_Qhw.b(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video", 2, "setXYaxis value:" + paramInt);
    }
  }
  
  public void a(int paramInt, qht paramqht)
  {
    this.jdField_c_of_type_Qht = null;
    if ((this.jdField_a_of_type_Qht != null) && (this.jdField_a_of_type_Qhw != null))
    {
      if (this.jdField_a_of_type_Qhw.e() == 2) {
        this.jdField_a_of_type_Qhw.f();
      }
      this.jdField_a_of_type_Qhw.a(paramInt);
      a(this.jdField_a_of_type_Qht, this.jdField_a_of_type_Qhw, 3, null);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: mVideoPlayerWrapper.seekTo() position=" + paramInt);
      }
    }
    do
    {
      do
      {
        return;
        if (paramqht == null) {
          break;
        }
        this.jdField_a_of_type_Qht = paramqht;
        paramqht = this.jdField_a_of_type_Qht;
        b(1);
        paramqht.d = paramInt;
        a(paramqht);
      } while (!QLog.isColorLevel());
      QLog.w(jdField_a_of_type_JavaLangString, 2, "resume(): mCurrenPlayVideoParam = null, playVideo: " + paramqht.jdField_c_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: param = null && mVideoPlayerWrapper = null");
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "player stop [async]  stopID : " + paramLong + ", from : " + paramInt);
    }
    if ((this.jdField_a_of_type_Qhw != null) && (this.jdField_a_of_type_Qht != null) && (this.jdField_a_of_type_Qht.jdField_c_of_type_Long == paramLong))
    {
      this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setKeepScreenOn(false);
      a(this.jdField_a_of_type_Qht, this.jdField_a_of_type_Qhw, 0, null);
      this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_a_of_type_Long = this.jdField_a_of_type_Qhw.a(false);
      this.jdField_a_of_type_Qht.d = a();
      if ((this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_a_of_type_Long == 0L) && (this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_c_of_type_Long == 0L) && (this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_b_of_type_Long != 0L)) {
        this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_a_of_type_Float = ((float)this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_a_of_type_Long / this.jdField_a_of_type_Qht.jdField_b_of_type_Int);
      this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.m = this.jdField_a_of_type_Qhw.c();
      this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_e_of_type_Int = this.jdField_a_of_type_Qhw.c();
      this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_f_of_type_Int = this.jdField_a_of_type_Qhw.d();
      this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_c_of_type_Boolean = this.jdField_a_of_type_Qhw.jdField_b_of_type_Boolean;
      this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_p_of_type_Long = this.jdField_a_of_type_Qhw.jdField_b_of_type_Long;
      this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_o_of_type_Long = this.jdField_a_of_type_Qhw.jdField_a_of_type_Long;
      this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.q = this.jdField_a_of_type_Qhw.e();
      this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_r_of_type_Long = this.jdField_a_of_type_Qhw.h();
      this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Qhw.a();
      this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.t = this.jdField_a_of_type_Qhw.g();
      this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.u = this.jdField_a_of_type_Qhw.f();
      if ((this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_a_of_type_Long == 0L) && (this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_c_of_type_Long == 0L))
      {
        this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_b_of_type_Long);
        this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_e_of_type_Long = this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_c_of_type_Long;
      }
      this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.k = c();
      this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.l = d();
      if (this.jdField_b_of_type_Qht != null)
      {
        localpqb = this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb;
        paramInt = this.jdField_b_of_type_Qht.jdField_a_of_type_Int;
        i = this.jdField_a_of_type_Qht.jdField_a_of_type_Int;
        if (this.jdField_a_of_type_Qht.m == 3)
        {
          bool = true;
          localpqb.jdField_r_of_type_Int = obz.a(paramInt, i, bool);
          this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_c_of_type_Int = this.jdField_a_of_type_Qht.m;
          this.jdField_a_of_type_Qhw.m();
          a(this.jdField_a_of_type_Qht);
          obz.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), obz.a(), true, this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.a());
          ndy.a(this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb);
          obz.a(true, this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.d, this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_f_of_type_Int, this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_a_of_type_Int, this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_c_of_type_Long, 56, this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_a_of_type_JavaLangString);
          if ((this.jdField_a_of_type_Qht.d > 0L) && (this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_a_of_type_Long > 0L)) {
            ThreadManager.post(new VideoPlayManager.4(this, this.jdField_a_of_type_Qht, this.jdField_a_of_type_Qik), 5, null, true);
          }
          this.d = false;
          this.jdField_b_of_type_Qht = this.jdField_a_of_type_Qht;
          this.jdField_a_of_type_Qht = null;
          this.jdField_a_of_type_Qhw = null;
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        pqb localpqb;
        int i;
        return;
        boolean bool = false;
        continue;
        this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_r_of_type_Int = -1;
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
  
  public void a(pxn parampxn)
  {
    if ((parampxn == null) || (!(parampxn instanceof qht))) {}
    do
    {
      do
      {
        return;
        parampxn = (qht)parampxn;
        if (!qji.a(this.jdField_a_of_type_AndroidAppActivity)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "playVideo in call return");
      return;
      try
      {
        this.jdField_c_of_type_Qht = null;
        if (this.jdField_a_of_type_Qiy != null) {
          this.jdField_a_of_type_Qiy.a(parampxn);
        }
        if (this.jdField_a_of_type_Qhy.a()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "start install tencent sdk plugin");
        }
        this.jdField_a_of_type_Qht = parampxn;
        a(this.jdField_a_of_type_Qht, null, 4, null);
        this.jdField_a_of_type_Qhy.a();
        return;
      }
      catch (Exception parampxn)
      {
        parampxn.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.readinjoy.video", 2, "playVideo error:", parampxn);
    return;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "play video start ! playParams : " + parampxn.toString());
    }
    this.jdField_a_of_type_Boolean = true;
    qhw localqhw = a(parampxn);
    this.jdField_a_of_type_Qhw = localqhw;
    this.jdField_a_of_type_Qht = parampxn;
    a(this.jdField_a_of_type_Qht, this.jdField_a_of_type_Qhw, 1, null);
    View localView = this.jdField_a_of_type_Qhw.b();
    if (localView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "playVideo : get videoView Fail !");
      }
      a(this.jdField_a_of_type_Qht, null, 6, "videoview null");
      this.jdField_a_of_type_Qhw = null;
      this.jdField_a_of_type_Qht = null;
      return;
    }
    parampxn.jdField_b_of_type_AndroidViewView = localView;
    localView.setId(2131309037);
    parampxn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setKeepScreenOn(true);
    parampxn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
    parampxn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_Qhw.b(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Qhw.a((IVideoViewBase)localView);
    this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.n = 0;
    this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_o_of_type_Int = 0;
    this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_p_of_type_Int = 0;
    this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.g = false;
    this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.h = false;
    ThreadManager.executeOnSubThread(new VideoPlayManager.3(this, parampxn, localqhw));
  }
  
  public void a(pyl parampyl)
  {
    parampyl.a(this);
  }
  
  public void a(pyu parampyu)
  {
    this.jdField_a_of_type_Pyu = parampyu;
  }
  
  public void a(qhs paramqhs)
  {
    if ((paramqhs != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramqhs))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramqhs);
    }
  }
  
  public void a(qhu paramqhu)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null) {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramqhu);
  }
  
  public void a(qik paramqik)
  {
    this.jdField_a_of_type_Qik = paramqik;
  }
  
  public void a(qiy paramqiy)
  {
    this.jdField_a_of_type_Qiy = paramqiy;
    this.jdField_a_of_type_Qiy.a(this);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Qhw != null) && (this.jdField_a_of_type_Qhw.b());
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_Qht == null) {
      return -1L;
    }
    return this.jdField_a_of_type_Qht.jdField_c_of_type_Long;
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = false;
    e(false);
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Qht != null) && (this.jdField_a_of_type_Qhw != null)) {
      a(this.jdField_a_of_type_Qht.jdField_c_of_type_Long, paramInt);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "stop , from : " + paramInt);
      }
      return;
      if (this.jdField_a_of_type_Qhw != null)
      {
        a(this.jdField_a_of_type_Qht, this.jdField_a_of_type_Qhw, 0, null);
        this.jdField_a_of_type_Qhw.m();
        this.jdField_a_of_type_Qhw = null;
        this.jdField_a_of_type_Qht = null;
      }
      else if (this.jdField_a_of_type_Qht != null)
      {
        a(this.jdField_a_of_type_Qht, this.jdField_a_of_type_Qhw, 0, null);
        this.jdField_a_of_type_Qhw = null;
        this.jdField_a_of_type_Qht = null;
      }
    }
  }
  
  public void b(qhs paramqhs)
  {
    if ((paramqhs != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramqhs);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this.jdField_a_of_type_Qht != null)
    {
      bool = paramBoolean;
      if (this.jdField_a_of_type_Qht.jdField_b_of_type_Boolean) {
        bool = true;
      }
    }
    if ((this.jdField_a_of_type_Qhw != null) && (this.jdField_a_of_type_Qhw.a() != null)) {
      this.jdField_a_of_type_Qhw.a().setOutputMute(bool);
    }
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Qhw != null) {
      return this.jdField_a_of_type_Qhw.a();
    }
    return -1;
  }
  
  public long c()
  {
    if (this.jdField_a_of_type_Qht == null) {
      return 0L;
    }
    return this.jdField_a_of_type_Qht.jdField_b_of_type_Long;
  }
  
  public void c()
  {
    if (!qbq.a().a()) {
      f(false);
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Qhw != null) {
      this.jdField_a_of_type_Qhw.a(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk success!");
      }
      if (this.jdField_a_of_type_Qht != null) {
        a(this.jdField_a_of_type_Qht);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk fail!");
    }
    a(this.jdField_a_of_type_Qht, this.jdField_a_of_type_Qhw, 6, "install failure");
    this.jdField_a_of_type_Qht = null;
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_Qhw == null) || (this.jdField_a_of_type_Qht == null)) {}
    do
    {
      return false;
      if (a() == 5)
      {
        if ((!this.jdField_a_of_type_Qhw.c()) && (QLog.isColorLevel())) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return true. getCurPlayState is PLAY_STATE_PAUSED. But mVideoPlayerWrapper.isPause() == false;");
        }
        return true;
      }
    } while ((!this.jdField_a_of_type_Qhw.c()) || (!QLog.isColorLevel()));
    QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return false. getCurPlayState is " + qhv.a(a()) + ". But mVideoPlayerWrapper.isPause() == true;");
    return false;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Qhw != null) {
      return this.jdField_a_of_type_Qhw.b();
    }
    return -1;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : destroy !");
    }
    b(7);
    if (this.jdField_a_of_type_Qhw != null)
    {
      this.jdField_a_of_type_Qhw.m();
      this.jdField_a_of_type_Qhw = null;
    }
    if (this.jdField_a_of_type_Qht != null) {
      this.jdField_a_of_type_Qht = null;
    }
    this.jdField_a_of_type_Qhy.b();
    this.jdField_a_of_type_Qhy = null;
    try
    {
      this.jdField_a_of_type_AndroidAppActivity = null;
      qji.a().b(this);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        qhw localqhw = (qhw)((WeakReference)localIterator.next()).get();
        if ((localqhw != null) && (!localqhw.jdField_a_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper : " + localqhw.toString() + " not release");
          }
          localqhw.m();
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    finally {}
    if (this.jdField_a_of_type_Qiy != null)
    {
      this.jdField_a_of_type_Qiy.k();
      this.jdField_a_of_type_Qiy = null;
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = null;
    this.d = false;
  }
  
  public void d(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Qhw != null) && (a() == 2);
  }
  
  public void e()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onUnVisiable() isPlaying()=" + a() + ", isOpening()=" + e());
      }
      if (!a()) {
        break label105;
      }
      a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Qiy != null)
      {
        this.jdField_a_of_type_Qiy.b();
        this.jdField_a_of_type_Qiy.a(false);
      }
      qka.a().b(this.jdField_a_of_type_AndroidAppActivity);
      return;
      label105:
      if (e()) {
        b(8);
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Qhw != null) && (this.jdField_a_of_type_Qhw.b()))
    {
      this.jdField_a_of_type_Qhw.h();
      this.d = paramBoolean;
      if (!badq.h(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext())) {
        this.jdField_a_of_type_Qhw.k();
      }
      a(this.jdField_a_of_type_Qht, this.jdField_a_of_type_Qhw, 5, Boolean.valueOf(this.d));
      this.jdField_a_of_type_Qht.d = a();
      this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_a_of_type_Long = this.jdField_a_of_type_Qhw.a(false);
      BaseArticleInfo localBaseArticleInfo = this.jdField_a_of_type_Qht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (npj.a((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && ((this.jdField_a_of_type_Qht.jdField_b_of_type_Boolean) || (localBaseArticleInfo.mChannelID == 56L)))
      {
        int j = 1;
        int i = nbe.Q;
        if (localBaseArticleInfo.mChannelID == 56L)
        {
          j = nbe.aE;
          i = nbe.M;
        }
        nbe.a(new nmv().a(this.jdField_a_of_type_AndroidAppActivity).a(nbe.jdField_f_of_type_Int).b(i).a((AdvertisementInfo)localBaseArticleInfo).a(nbe.a(((AdvertisementInfo)localBaseArticleInfo).adbt, (int)this.jdField_a_of_type_Qht.d, ((AdvertisementInfo)localBaseArticleInfo).getAdbf(), 0, ((AdvertisementInfo)localBaseArticleInfo).adpa, ((AdvertisementInfo)localBaseArticleInfo).adpb, localBaseArticleInfo.mVideoDuration, j, 0)).a());
        ((AdvertisementInfo)localBaseArticleInfo).adbt = ((int)this.jdField_a_of_type_Qht.d);
      }
    }
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_Qhw != null) && (this.jdField_a_of_type_Qhw.e());
  }
  
  public void f()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onVisiable() isPause()=" + c() + ", mPausedByMannul:" + this.d);
      }
      if ((this.jdField_a_of_type_Qht != null) && (this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb != null)) {
        this.jdField_a_of_type_Qht.jdField_a_of_type_Pqb.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if ((c()) && (!this.d)) {
        c();
      }
      if (this.jdField_a_of_type_Qiy != null)
      {
        this.jdField_a_of_type_Qiy.a();
        if (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
          break label152;
        }
        this.jdField_a_of_type_Qiy.a(false);
      }
    }
    for (;;)
    {
      qka.a().a(this.jdField_a_of_type_AndroidAppActivity);
      return;
      label152:
      this.jdField_a_of_type_Qiy.a(true);
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (c())
    {
      if (!qji.a(this.jdField_a_of_type_AndroidAppActivity)) {
        break label33;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "VideoPlayManager resume, in call return");
      }
    }
    return;
    label33:
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : resume(), mannulResume:" + paramBoolean + ", mPausedByMannul:" + this.d);
    }
    this.jdField_a_of_type_Qhw.g();
    this.jdField_a_of_type_Boolean = true;
    this.d = false;
    a(this.jdField_a_of_type_Qht, this.jdField_a_of_type_Qhw, 3, null);
  }
  
  public boolean f()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkPlayStateAfterPhoneCall isVisible() = " + f());
    }
    if (!f()) {
      return;
    }
    c();
  }
  
  public boolean g()
  {
    if (this.jdField_a_of_type_Qiy != null) {
      return this.jdField_a_of_type_Qiy.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qhp
 * JD-Core Version:    0.7.0.1
 */