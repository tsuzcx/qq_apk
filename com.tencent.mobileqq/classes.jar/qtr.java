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

public class qtr
  implements qjr, quc
{
  public static final String a;
  protected int a;
  private volatile Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private ArrayList<Pair<Integer, Bitmap>> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Integer, qty> jdField_a_of_type_JavaUtilHashMap;
  private Map<String, WeakReference<qty>> jdField_a_of_type_JavaUtilMap;
  private Set<qtw> jdField_a_of_type_JavaUtilSet;
  private CopyOnWriteArrayList<qtu> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private qkr jdField_a_of_type_Qkr;
  public qtv a;
  private qty jdField_a_of_type_Qty;
  private qtz jdField_a_of_type_Qtz = new qts(this);
  private qua jdField_a_of_type_Qua;
  private qum jdField_a_of_type_Qum;
  private qva jdField_a_of_type_Qva;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private String jdField_b_of_type_JavaLangString;
  private qtv jdField_b_of_type_Qtv;
  private boolean jdField_b_of_type_Boolean = true;
  private qtv jdField_c_of_type_Qtv;
  private volatile boolean jdField_c_of_type_Boolean;
  private qtv jdField_d_of_type_Qtv;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + qtr.class.getSimpleName();
  }
  
  public qtr(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : create a new manager !");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Qua = new qua(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.jdField_a_of_type_Qua.a(this);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    qvk.a().a(this);
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
  
  private void a(qtv paramqtv)
  {
    paramqtv.jdField_a_of_type_Qbu.v = qwc.a().a();
    long[] arrayOfLong = qwc.a().a();
    paramqtv.jdField_a_of_type_Qbu.z = arrayOfLong[0];
    paramqtv.jdField_a_of_type_Qbu.A = arrayOfLong[1];
    paramqtv.jdField_a_of_type_Qbu.x = arrayOfLong[2];
    paramqtv.jdField_a_of_type_Qbu.y = arrayOfLong[3];
    paramqtv.jdField_a_of_type_Qbu.w = arrayOfLong[4];
  }
  
  private void a(qtv paramqtv, qty paramqty, int paramInt, Object paramObject)
  {
    int i;
    try
    {
      i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (paramInt != i)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "changeStateAndNotify(): " + qtx.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + " ===> " + qtx.a(paramInt) + ", extra = " + paramObject + ", videoPlayParam=" + paramqtv + ", videoPlayWrapper=" + paramqty);
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
            qtu localqtu = (qtu)localIterator.next();
            if (localqtu != null) {
              localqtu.a(paramqtv, paramqty, i, paramInt, paramObject);
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
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.2(this, paramqtv, paramqty, i, paramInt, paramObject));
    }
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_Qty != null) {
      i = this.jdField_a_of_type_Qty.e();
    }
    if (i == this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) {
      return i;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.readinjoy.video", 2, "getCurPlayState, should not happen...: mVideoPlayerWrapper.getCurrentStatus() = " + qtx.a(i) + ",mState.get()=" + qtx.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Qty != null) {
      return this.jdField_a_of_type_Qty.a();
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
  
  public qtv a()
  {
    return this.jdField_b_of_type_Qtv;
  }
  
  public qty a(String paramString)
  {
    paramString = (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return (qty)paramString.get();
    }
    return null;
  }
  
  public qty a(qtv paramqtv)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return null;
    }
    qty localqty = new qty(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    localqty.e(true);
    localqty.a(this.jdField_a_of_type_Qtz);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "getVideoPlayer new instant!");
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramqtv.a(), new WeakReference(localqty));
    return localqty;
  }
  
  public qva a()
  {
    return this.jdField_a_of_type_Qva;
  }
  
  public void a()
  {
    e(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Qty != null) {
      this.jdField_a_of_type_Qty.b(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video", 2, "setXYaxis value:" + paramInt);
    }
  }
  
  public void a(int paramInt, qtv paramqtv)
  {
    this.jdField_d_of_type_Qtv = null;
    if ((this.jdField_b_of_type_Qtv != null) && (this.jdField_a_of_type_Qty != null))
    {
      if (this.jdField_a_of_type_Qty.e() == 2) {
        this.jdField_a_of_type_Qty.f();
      }
      this.jdField_a_of_type_Qty.a(paramInt);
      a(this.jdField_b_of_type_Qtv, this.jdField_a_of_type_Qty, 3, null);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: mVideoPlayerWrapper.seekTo() position=" + paramInt);
      }
    }
    do
    {
      do
      {
        return;
        if (paramqtv == null) {
          break;
        }
        this.jdField_b_of_type_Qtv = paramqtv;
        paramqtv = this.jdField_b_of_type_Qtv;
        b(1);
        paramqtv.d = paramInt;
        a(paramqtv);
      } while (!QLog.isColorLevel());
      QLog.w(jdField_a_of_type_JavaLangString, 2, "resume(): mCurrenPlayVideoParam = null, playVideo: " + paramqtv.jdField_c_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: param = null && mVideoPlayerWrapper = null");
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "player stop [async]  stopID : " + paramLong + ", from : " + paramInt);
    }
    if ((this.jdField_a_of_type_Qty != null) && (this.jdField_b_of_type_Qtv != null) && (this.jdField_b_of_type_Qtv.jdField_c_of_type_Long == paramLong))
    {
      this.jdField_b_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setKeepScreenOn(false);
      a(this.jdField_b_of_type_Qtv, this.jdField_a_of_type_Qty, 0, null);
      this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_a_of_type_Long = this.jdField_a_of_type_Qty.a(false);
      this.jdField_b_of_type_Qtv.d = a();
      if ((this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_c_of_type_Long == 0L) && (this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_b_of_type_Long != 0L)) {
        this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_b_of_type_Long);
      }
      this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_a_of_type_Float = ((float)this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_a_of_type_Long / this.jdField_b_of_type_Qtv.jdField_b_of_type_Int);
      this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.m = this.jdField_a_of_type_Qty.c();
      this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_e_of_type_Int = this.jdField_a_of_type_Qty.c();
      this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_f_of_type_Int = this.jdField_a_of_type_Qty.d();
      this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_c_of_type_Boolean = this.jdField_a_of_type_Qty.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_p_of_type_Long = this.jdField_a_of_type_Qty.jdField_b_of_type_Long;
      this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_o_of_type_Long = this.jdField_a_of_type_Qty.jdField_a_of_type_Long;
      this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.q = this.jdField_a_of_type_Qty.f();
      this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_r_of_type_Long = this.jdField_a_of_type_Qty.i();
      this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Qty.a();
      this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.t = this.jdField_a_of_type_Qty.h();
      this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.u = this.jdField_a_of_type_Qty.g();
      if ((this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_c_of_type_Long == 0L))
      {
        this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_b_of_type_Long);
        this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_e_of_type_Long = this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_c_of_type_Long;
      }
      this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.k = c();
      this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.l = d();
      if (this.jdField_c_of_type_Qtv != null)
      {
        localqbu = this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu;
        paramInt = this.jdField_c_of_type_Qtv.jdField_a_of_type_Int;
        i = this.jdField_b_of_type_Qtv.jdField_a_of_type_Int;
        if (this.jdField_b_of_type_Qtv.m == 3)
        {
          bool = true;
          localqbu.jdField_r_of_type_Int = onh.a(paramInt, i, bool);
          this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_c_of_type_Int = this.jdField_b_of_type_Qtv.m;
          this.jdField_a_of_type_Qty.m();
          a(this.jdField_b_of_type_Qtv);
          onh.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), onh.a(), true, this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.a());
          now.a(this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu);
          onh.a(true, this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_d_of_type_Boolean, this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_f_of_type_Int, this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_a_of_type_Int, this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_c_of_type_Long, 56, this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_a_of_type_JavaLangString);
          if ((this.jdField_b_of_type_Qtv.d > 0L) && (this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_a_of_type_Long > 0L)) {
            ThreadManager.post(new VideoPlayManager.4(this, this.jdField_b_of_type_Qtv, this.jdField_a_of_type_Qum), 5, null, true);
          }
          this.jdField_d_of_type_Boolean = false;
          this.jdField_c_of_type_Qtv = this.jdField_b_of_type_Qtv;
          this.jdField_b_of_type_Qtv = null;
          this.jdField_a_of_type_Qty = null;
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        qbu localqbu;
        int i;
        return;
        boolean bool = false;
        continue;
        this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_r_of_type_Int = -1;
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
  
  public void a(qji paramqji)
  {
    if ((paramqji == null) || (!(paramqji instanceof qtv))) {}
    do
    {
      do
      {
        return;
        paramqji = (qtv)paramqji;
        if (!qvk.a(this.jdField_a_of_type_AndroidAppActivity)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "playVideo in call return");
      return;
      try
      {
        this.jdField_d_of_type_Qtv = null;
        this.jdField_a_of_type_Qtv = null;
        if (this.jdField_a_of_type_Qva != null) {
          this.jdField_a_of_type_Qva.a(paramqji);
        }
        if (this.jdField_a_of_type_Qua.a()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "start install tencent sdk plugin");
        }
        this.jdField_b_of_type_Qtv = paramqji;
        a(this.jdField_b_of_type_Qtv, null, 4, null);
        this.jdField_a_of_type_Qua.a();
        return;
      }
      catch (Exception paramqji)
      {
        paramqji.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.readinjoy.video", 2, "playVideo error:", paramqji);
    return;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "play video start ! playParams : " + paramqji.toString());
    }
    this.jdField_a_of_type_Boolean = true;
    qty localqty = a(paramqji);
    this.jdField_a_of_type_Qty = localqty;
    this.jdField_b_of_type_Qtv = paramqji;
    a(this.jdField_b_of_type_Qtv, this.jdField_a_of_type_Qty, 1, null);
    View localView = this.jdField_a_of_type_Qty.b();
    if (localView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "playVideo : get videoView Fail !");
      }
      a(this.jdField_b_of_type_Qtv, null, 6, "videoview null");
      this.jdField_a_of_type_Qty = null;
      this.jdField_b_of_type_Qtv = null;
      return;
    }
    paramqji.jdField_b_of_type_AndroidViewView = localView;
    localView.setId(2131374780);
    paramqji.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setKeepScreenOn(true);
    paramqji.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
    paramqji.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_Qty.b(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Qty.a((IVideoViewBase)localView);
    this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.n = 0;
    this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_o_of_type_Int = 0;
    this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_p_of_type_Int = 0;
    this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.g = false;
    this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.h = false;
    ThreadManager.executeOnSubThread(new VideoPlayManager.3(this, paramqji, localqty));
  }
  
  public void a(qki paramqki)
  {
    paramqki.a(this);
  }
  
  public void a(qkr paramqkr)
  {
    this.jdField_a_of_type_Qkr = paramqkr;
  }
  
  public void a(qtu paramqtu)
  {
    if ((paramqtu != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramqtu))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramqtu);
    }
  }
  
  public void a(qtw paramqtw)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null) {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramqtw);
  }
  
  public void a(qum paramqum)
  {
    this.jdField_a_of_type_Qum = paramqum;
  }
  
  public void a(qva paramqva)
  {
    this.jdField_a_of_type_Qva = paramqva;
    this.jdField_a_of_type_Qva.a(this);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Qty != null) && (this.jdField_a_of_type_Qty.b());
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long b()
  {
    if (this.jdField_b_of_type_Qtv == null) {
      return -1L;
    }
    return this.jdField_b_of_type_Qtv.jdField_c_of_type_Long;
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = false;
    e(false);
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_b_of_type_Qtv != null) && (this.jdField_a_of_type_Qty != null)) {
      a(this.jdField_b_of_type_Qtv.jdField_c_of_type_Long, paramInt);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "stop , from : " + paramInt);
      }
      return;
      if (this.jdField_a_of_type_Qty != null)
      {
        a(this.jdField_b_of_type_Qtv, this.jdField_a_of_type_Qty, 0, null);
        this.jdField_a_of_type_Qty.m();
        this.jdField_a_of_type_Qty = null;
        this.jdField_b_of_type_Qtv = null;
      }
      else if (this.jdField_b_of_type_Qtv != null)
      {
        a(this.jdField_b_of_type_Qtv, this.jdField_a_of_type_Qty, 0, null);
        this.jdField_a_of_type_Qty = null;
        this.jdField_b_of_type_Qtv = null;
      }
    }
  }
  
  public void b(qtu paramqtu)
  {
    if ((paramqtu != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramqtu);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this.jdField_b_of_type_Qtv != null)
    {
      bool = paramBoolean;
      if (this.jdField_b_of_type_Qtv.jdField_b_of_type_Boolean) {
        bool = true;
      }
    }
    if ((this.jdField_a_of_type_Qty != null) && (this.jdField_a_of_type_Qty.a() != null)) {
      this.jdField_a_of_type_Qty.a().setOutputMute(bool);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Qty != null) && (this.jdField_a_of_type_Qty.c());
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Qty != null) {
      return this.jdField_a_of_type_Qty.a();
    }
    return -1;
  }
  
  public long c()
  {
    if (this.jdField_b_of_type_Qtv == null) {
      return 0L;
    }
    return this.jdField_b_of_type_Qtv.jdField_b_of_type_Long;
  }
  
  public void c()
  {
    if (!qnl.a().a()) {
      f(false);
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Qty != null) {
      this.jdField_a_of_type_Qty.a(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk success!");
      }
      if (this.jdField_b_of_type_Qtv != null) {
        a(this.jdField_b_of_type_Qtv);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk fail!");
    }
    a(this.jdField_b_of_type_Qtv, this.jdField_a_of_type_Qty, 6, "install failure");
    this.jdField_b_of_type_Qtv = null;
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Qty != null) {
      return this.jdField_a_of_type_Qty.b();
    }
    return -1;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : destroy !");
    }
    b(7);
    if (this.jdField_a_of_type_Qty != null)
    {
      this.jdField_a_of_type_Qty.m();
      this.jdField_a_of_type_Qty = null;
    }
    if (this.jdField_b_of_type_Qtv != null) {
      this.jdField_b_of_type_Qtv = null;
    }
    this.jdField_a_of_type_Qua.b();
    this.jdField_a_of_type_Qua = null;
    try
    {
      this.jdField_a_of_type_AndroidAppActivity = null;
      qvk.a().b(this);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        qty localqty = (qty)((WeakReference)localIterator.next()).get();
        if ((localqty != null) && (!localqty.jdField_a_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper : " + localqty.toString() + " not release");
          }
          localqty.m();
        }
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
    if (this.jdField_a_of_type_Qva != null)
    {
      this.jdField_a_of_type_Qva.k();
      this.jdField_a_of_type_Qva = null;
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
    if ((this.jdField_a_of_type_Qty == null) || (this.jdField_b_of_type_Qtv == null)) {}
    do
    {
      return false;
      if (a() == 5)
      {
        if ((!this.jdField_a_of_type_Qty.d()) && (QLog.isColorLevel())) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return true. getCurPlayState is PLAY_STATE_PAUSED. But mVideoPlayerWrapper.isPause() == false;");
        }
        return true;
      }
    } while ((!this.jdField_a_of_type_Qty.d()) || (!QLog.isColorLevel()));
    QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return false. getCurPlayState is " + qtx.a(a()) + ". But mVideoPlayerWrapper.isPause() == true;");
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
      if (this.jdField_a_of_type_Qva != null)
      {
        this.jdField_a_of_type_Qva.b();
        this.jdField_a_of_type_Qva.a(false);
      }
      qwc.a().b(this.jdField_a_of_type_AndroidAppActivity);
      return;
      label105:
      if (f()) {
        b(8);
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Qty != null) && (this.jdField_a_of_type_Qty.c()))
    {
      this.jdField_a_of_type_Qty.h();
      this.jdField_d_of_type_Boolean = paramBoolean;
      if (!bbfj.h(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext())) {
        this.jdField_a_of_type_Qty.k();
      }
      a(this.jdField_b_of_type_Qtv, this.jdField_a_of_type_Qty, 5, Boolean.valueOf(this.jdField_d_of_type_Boolean));
      this.jdField_b_of_type_Qtv.d = a();
      this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_a_of_type_Long = this.jdField_a_of_type_Qty.a(false);
      BaseArticleInfo localBaseArticleInfo = this.jdField_b_of_type_Qtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (oar.a((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && ((this.jdField_b_of_type_Qtv.jdField_b_of_type_Boolean) || (localBaseArticleInfo.mChannelID == 56L)))
      {
        int j = 1;
        int i = nmc.Q;
        if (localBaseArticleInfo.mChannelID == 56L)
        {
          j = nmc.aF;
          i = nmc.M;
        }
        nmc.a(new nyd().a(this.jdField_a_of_type_AndroidAppActivity).a(nmc.jdField_f_of_type_Int).b(i).a((AdvertisementInfo)localBaseArticleInfo).a(nmc.a(((AdvertisementInfo)localBaseArticleInfo).adbt, (int)this.jdField_b_of_type_Qtv.d, ((AdvertisementInfo)localBaseArticleInfo).getAdbf(), 0, ((AdvertisementInfo)localBaseArticleInfo).adpa, ((AdvertisementInfo)localBaseArticleInfo).adpb, localBaseArticleInfo.mVideoDuration, j, 0)).a());
        ((AdvertisementInfo)localBaseArticleInfo).adbt = ((int)this.jdField_b_of_type_Qtv.d);
      }
    }
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_Qty != null) && (a() == 2);
  }
  
  public void f()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onVisiable() isPause()=" + d() + ", mPausedByMannul:" + this.jdField_d_of_type_Boolean);
      }
      if ((this.jdField_b_of_type_Qtv != null) && (this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu != null)) {
        this.jdField_b_of_type_Qtv.jdField_a_of_type_Qbu.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if ((d()) && (!this.jdField_d_of_type_Boolean)) {
        c();
      }
      if (this.jdField_a_of_type_Qva != null)
      {
        this.jdField_a_of_type_Qva.a();
        if (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
          break label152;
        }
        this.jdField_a_of_type_Qva.a(false);
      }
    }
    for (;;)
    {
      qwc.a().a(this.jdField_a_of_type_AndroidAppActivity);
      return;
      label152:
      this.jdField_a_of_type_Qva.a(true);
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (d())
    {
      if (!qvk.a(this.jdField_a_of_type_AndroidAppActivity)) {
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
    this.jdField_a_of_type_Qty.g();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    a(this.jdField_b_of_type_Qtv, this.jdField_a_of_type_Qty, 3, null);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_Qty != null) && (this.jdField_a_of_type_Qty.f());
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
    if (this.jdField_a_of_type_Qva != null) {
      return this.jdField_a_of_type_Qva.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qtr
 * JD-Core Version:    0.7.0.1
 */