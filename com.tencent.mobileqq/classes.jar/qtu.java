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

public class qtu
  implements qju, quf
{
  public static final String a;
  protected int a;
  private volatile Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private ArrayList<Pair<Integer, Bitmap>> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Integer, qub> jdField_a_of_type_JavaUtilHashMap;
  private Map<String, WeakReference<qub>> jdField_a_of_type_JavaUtilMap;
  private Set<qtz> jdField_a_of_type_JavaUtilSet;
  private CopyOnWriteArrayList<qtx> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private qku jdField_a_of_type_Qku;
  public qty a;
  private qub jdField_a_of_type_Qub;
  private quc jdField_a_of_type_Quc = new qtv(this);
  private qud jdField_a_of_type_Qud;
  private qup jdField_a_of_type_Qup;
  private qvd jdField_a_of_type_Qvd;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private String jdField_b_of_type_JavaLangString;
  private qty jdField_b_of_type_Qty;
  private boolean jdField_b_of_type_Boolean = true;
  private qty jdField_c_of_type_Qty;
  private volatile boolean jdField_c_of_type_Boolean;
  private qty jdField_d_of_type_Qty;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + qtu.class.getSimpleName();
  }
  
  public qtu(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : create a new manager !");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Qud = new qud(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.jdField_a_of_type_Qud.a(this);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    qvn.a().a(this);
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
  
  private void a(qty paramqty)
  {
    paramqty.jdField_a_of_type_Qbx.v = qwf.a().a();
    long[] arrayOfLong = qwf.a().a();
    paramqty.jdField_a_of_type_Qbx.z = arrayOfLong[0];
    paramqty.jdField_a_of_type_Qbx.A = arrayOfLong[1];
    paramqty.jdField_a_of_type_Qbx.x = arrayOfLong[2];
    paramqty.jdField_a_of_type_Qbx.y = arrayOfLong[3];
    paramqty.jdField_a_of_type_Qbx.w = arrayOfLong[4];
  }
  
  private void a(qty paramqty, qub paramqub, int paramInt, Object paramObject)
  {
    int i;
    try
    {
      i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (paramInt != i)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "changeStateAndNotify(): " + qua.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + " ===> " + qua.a(paramInt) + ", extra = " + paramObject + ", videoPlayParam=" + paramqty + ", videoPlayWrapper=" + paramqub);
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
            qtx localqtx = (qtx)localIterator.next();
            if (localqtx != null) {
              localqtx.a(paramqty, paramqub, i, paramInt, paramObject);
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
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.2(this, paramqty, paramqub, i, paramInt, paramObject));
    }
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_Qub != null) {
      i = this.jdField_a_of_type_Qub.e();
    }
    if (i == this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) {
      return i;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.readinjoy.video", 2, "getCurPlayState, should not happen...: mVideoPlayerWrapper.getCurrentStatus() = " + qua.a(i) + ",mState.get()=" + qua.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Qub != null) {
      return this.jdField_a_of_type_Qub.a();
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
  
  public qty a()
  {
    return this.jdField_b_of_type_Qty;
  }
  
  public qub a(String paramString)
  {
    paramString = (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return (qub)paramString.get();
    }
    return null;
  }
  
  public qub a(qty paramqty)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return null;
    }
    qub localqub = new qub(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    localqub.e(true);
    localqub.a(this.jdField_a_of_type_Quc);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "getVideoPlayer new instant!");
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramqty.a(), new WeakReference(localqub));
    return localqub;
  }
  
  public qvd a()
  {
    return this.jdField_a_of_type_Qvd;
  }
  
  public void a()
  {
    e(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Qub != null) {
      this.jdField_a_of_type_Qub.b(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video", 2, "setXYaxis value:" + paramInt);
    }
  }
  
  public void a(int paramInt, qty paramqty)
  {
    this.jdField_d_of_type_Qty = null;
    if ((this.jdField_b_of_type_Qty != null) && (this.jdField_a_of_type_Qub != null))
    {
      if (this.jdField_a_of_type_Qub.e() == 2) {
        this.jdField_a_of_type_Qub.f();
      }
      this.jdField_a_of_type_Qub.a(paramInt);
      a(this.jdField_b_of_type_Qty, this.jdField_a_of_type_Qub, 3, null);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: mVideoPlayerWrapper.seekTo() position=" + paramInt);
      }
    }
    do
    {
      do
      {
        return;
        if (paramqty == null) {
          break;
        }
        this.jdField_b_of_type_Qty = paramqty;
        paramqty = this.jdField_b_of_type_Qty;
        b(1);
        paramqty.d = paramInt;
        a(paramqty);
      } while (!QLog.isColorLevel());
      QLog.w(jdField_a_of_type_JavaLangString, 2, "resume(): mCurrenPlayVideoParam = null, playVideo: " + paramqty.jdField_c_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: param = null && mVideoPlayerWrapper = null");
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "player stop [async]  stopID : " + paramLong + ", from : " + paramInt);
    }
    if ((this.jdField_a_of_type_Qub != null) && (this.jdField_b_of_type_Qty != null) && (this.jdField_b_of_type_Qty.jdField_c_of_type_Long == paramLong))
    {
      this.jdField_b_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setKeepScreenOn(false);
      a(this.jdField_b_of_type_Qty, this.jdField_a_of_type_Qub, 0, null);
      this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_a_of_type_Long = this.jdField_a_of_type_Qub.a(false);
      this.jdField_b_of_type_Qty.d = a();
      if ((this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_c_of_type_Long == 0L) && (this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_b_of_type_Long != 0L)) {
        this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_b_of_type_Long);
      }
      this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_a_of_type_Float = ((float)this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_a_of_type_Long / this.jdField_b_of_type_Qty.jdField_b_of_type_Int);
      this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.m = this.jdField_a_of_type_Qub.c();
      this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_e_of_type_Int = this.jdField_a_of_type_Qub.c();
      this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_f_of_type_Int = this.jdField_a_of_type_Qub.d();
      this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_c_of_type_Boolean = this.jdField_a_of_type_Qub.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_p_of_type_Long = this.jdField_a_of_type_Qub.jdField_b_of_type_Long;
      this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_o_of_type_Long = this.jdField_a_of_type_Qub.jdField_a_of_type_Long;
      this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.q = this.jdField_a_of_type_Qub.f();
      this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_r_of_type_Long = this.jdField_a_of_type_Qub.i();
      this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Qub.a();
      this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.t = this.jdField_a_of_type_Qub.h();
      this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.u = this.jdField_a_of_type_Qub.g();
      if ((this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_c_of_type_Long == 0L))
      {
        this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_b_of_type_Long);
        this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_e_of_type_Long = this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_c_of_type_Long;
      }
      this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.k = c();
      this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.l = d();
      if (this.jdField_c_of_type_Qty != null)
      {
        localqbx = this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx;
        paramInt = this.jdField_c_of_type_Qty.jdField_a_of_type_Int;
        i = this.jdField_b_of_type_Qty.jdField_a_of_type_Int;
        if (this.jdField_b_of_type_Qty.m == 3)
        {
          bool = true;
          localqbx.jdField_r_of_type_Int = onk.a(paramInt, i, bool);
          this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_c_of_type_Int = this.jdField_b_of_type_Qty.m;
          this.jdField_a_of_type_Qub.m();
          a(this.jdField_b_of_type_Qty);
          onk.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), onk.a(), true, this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.a());
          noz.a(this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx);
          onk.a(true, this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_d_of_type_Boolean, this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_f_of_type_Int, this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_a_of_type_Int, this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_c_of_type_Long, 56, this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_a_of_type_JavaLangString);
          if ((this.jdField_b_of_type_Qty.d > 0L) && (this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_a_of_type_Long > 0L)) {
            ThreadManager.post(new VideoPlayManager.4(this, this.jdField_b_of_type_Qty, this.jdField_a_of_type_Qup), 5, null, true);
          }
          this.jdField_d_of_type_Boolean = false;
          this.jdField_c_of_type_Qty = this.jdField_b_of_type_Qty;
          this.jdField_b_of_type_Qty = null;
          this.jdField_a_of_type_Qub = null;
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        qbx localqbx;
        int i;
        return;
        boolean bool = false;
        continue;
        this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_r_of_type_Int = -1;
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
  
  public void a(qjl paramqjl)
  {
    if ((paramqjl == null) || (!(paramqjl instanceof qty))) {}
    do
    {
      do
      {
        return;
        paramqjl = (qty)paramqjl;
        if (!qvn.a(this.jdField_a_of_type_AndroidAppActivity)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "playVideo in call return");
      return;
      try
      {
        this.jdField_d_of_type_Qty = null;
        this.jdField_a_of_type_Qty = null;
        if (this.jdField_a_of_type_Qvd != null) {
          this.jdField_a_of_type_Qvd.a(paramqjl);
        }
        if (this.jdField_a_of_type_Qud.a()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "start install tencent sdk plugin");
        }
        this.jdField_b_of_type_Qty = paramqjl;
        a(this.jdField_b_of_type_Qty, null, 4, null);
        this.jdField_a_of_type_Qud.a();
        return;
      }
      catch (Exception paramqjl)
      {
        paramqjl.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.readinjoy.video", 2, "playVideo error:", paramqjl);
    return;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "play video start ! playParams : " + paramqjl.toString());
    }
    this.jdField_a_of_type_Boolean = true;
    qub localqub = a(paramqjl);
    this.jdField_a_of_type_Qub = localqub;
    this.jdField_b_of_type_Qty = paramqjl;
    a(this.jdField_b_of_type_Qty, this.jdField_a_of_type_Qub, 1, null);
    View localView = this.jdField_a_of_type_Qub.b();
    if (localView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "playVideo : get videoView Fail !");
      }
      a(this.jdField_b_of_type_Qty, null, 6, "videoview null");
      this.jdField_a_of_type_Qub = null;
      this.jdField_b_of_type_Qty = null;
      return;
    }
    paramqjl.jdField_b_of_type_AndroidViewView = localView;
    localView.setId(2131374778);
    paramqjl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setKeepScreenOn(true);
    paramqjl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
    paramqjl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_Qub.b(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Qub.a((IVideoViewBase)localView);
    this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.n = 0;
    this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_o_of_type_Int = 0;
    this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_p_of_type_Int = 0;
    this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.g = false;
    this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.h = false;
    ThreadManager.executeOnSubThread(new VideoPlayManager.3(this, paramqjl, localqub));
  }
  
  public void a(qkl paramqkl)
  {
    paramqkl.a(this);
  }
  
  public void a(qku paramqku)
  {
    this.jdField_a_of_type_Qku = paramqku;
  }
  
  public void a(qtx paramqtx)
  {
    if ((paramqtx != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramqtx))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramqtx);
    }
  }
  
  public void a(qtz paramqtz)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null) {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramqtz);
  }
  
  public void a(qup paramqup)
  {
    this.jdField_a_of_type_Qup = paramqup;
  }
  
  public void a(qvd paramqvd)
  {
    this.jdField_a_of_type_Qvd = paramqvd;
    this.jdField_a_of_type_Qvd.a(this);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Qub != null) && (this.jdField_a_of_type_Qub.b());
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long b()
  {
    if (this.jdField_b_of_type_Qty == null) {
      return -1L;
    }
    return this.jdField_b_of_type_Qty.jdField_c_of_type_Long;
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = false;
    e(false);
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_b_of_type_Qty != null) && (this.jdField_a_of_type_Qub != null)) {
      a(this.jdField_b_of_type_Qty.jdField_c_of_type_Long, paramInt);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "stop , from : " + paramInt);
      }
      return;
      if (this.jdField_a_of_type_Qub != null)
      {
        a(this.jdField_b_of_type_Qty, this.jdField_a_of_type_Qub, 0, null);
        this.jdField_a_of_type_Qub.m();
        this.jdField_a_of_type_Qub = null;
        this.jdField_b_of_type_Qty = null;
      }
      else if (this.jdField_b_of_type_Qty != null)
      {
        a(this.jdField_b_of_type_Qty, this.jdField_a_of_type_Qub, 0, null);
        this.jdField_a_of_type_Qub = null;
        this.jdField_b_of_type_Qty = null;
      }
    }
  }
  
  public void b(qtx paramqtx)
  {
    if ((paramqtx != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramqtx);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this.jdField_b_of_type_Qty != null)
    {
      bool = paramBoolean;
      if (this.jdField_b_of_type_Qty.jdField_b_of_type_Boolean) {
        bool = true;
      }
    }
    if ((this.jdField_a_of_type_Qub != null) && (this.jdField_a_of_type_Qub.a() != null)) {
      this.jdField_a_of_type_Qub.a().setOutputMute(bool);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Qub != null) && (this.jdField_a_of_type_Qub.c());
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Qub != null) {
      return this.jdField_a_of_type_Qub.a();
    }
    return -1;
  }
  
  public long c()
  {
    if (this.jdField_b_of_type_Qty == null) {
      return 0L;
    }
    return this.jdField_b_of_type_Qty.jdField_b_of_type_Long;
  }
  
  public void c()
  {
    if (!qno.a().a()) {
      f(false);
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Qub != null) {
      this.jdField_a_of_type_Qub.a(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk success!");
      }
      if (this.jdField_b_of_type_Qty != null) {
        a(this.jdField_b_of_type_Qty);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk fail!");
    }
    a(this.jdField_b_of_type_Qty, this.jdField_a_of_type_Qub, 6, "install failure");
    this.jdField_b_of_type_Qty = null;
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Qub != null) {
      return this.jdField_a_of_type_Qub.b();
    }
    return -1;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : destroy !");
    }
    b(7);
    if (this.jdField_a_of_type_Qub != null)
    {
      this.jdField_a_of_type_Qub.m();
      this.jdField_a_of_type_Qub = null;
    }
    if (this.jdField_b_of_type_Qty != null) {
      this.jdField_b_of_type_Qty = null;
    }
    this.jdField_a_of_type_Qud.b();
    this.jdField_a_of_type_Qud = null;
    try
    {
      this.jdField_a_of_type_AndroidAppActivity = null;
      qvn.a().b(this);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        qub localqub = (qub)((WeakReference)localIterator.next()).get();
        if ((localqub != null) && (!localqub.jdField_a_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper : " + localqub.toString() + " not release");
          }
          localqub.m();
        }
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
    if (this.jdField_a_of_type_Qvd != null)
    {
      this.jdField_a_of_type_Qvd.k();
      this.jdField_a_of_type_Qvd = null;
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
    if ((this.jdField_a_of_type_Qub == null) || (this.jdField_b_of_type_Qty == null)) {}
    do
    {
      return false;
      if (a() == 5)
      {
        if ((!this.jdField_a_of_type_Qub.d()) && (QLog.isColorLevel())) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return true. getCurPlayState is PLAY_STATE_PAUSED. But mVideoPlayerWrapper.isPause() == false;");
        }
        return true;
      }
    } while ((!this.jdField_a_of_type_Qub.d()) || (!QLog.isColorLevel()));
    QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return false. getCurPlayState is " + qua.a(a()) + ". But mVideoPlayerWrapper.isPause() == true;");
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
      if (this.jdField_a_of_type_Qvd != null)
      {
        this.jdField_a_of_type_Qvd.b();
        this.jdField_a_of_type_Qvd.a(false);
      }
      qwf.a().b(this.jdField_a_of_type_AndroidAppActivity);
      return;
      label105:
      if (f()) {
        b(8);
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Qub != null) && (this.jdField_a_of_type_Qub.c()))
    {
      this.jdField_a_of_type_Qub.h();
      this.jdField_d_of_type_Boolean = paramBoolean;
      if (!bbev.h(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext())) {
        this.jdField_a_of_type_Qub.k();
      }
      a(this.jdField_b_of_type_Qty, this.jdField_a_of_type_Qub, 5, Boolean.valueOf(this.jdField_d_of_type_Boolean));
      this.jdField_b_of_type_Qty.d = a();
      this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_a_of_type_Long = this.jdField_a_of_type_Qub.a(false);
      BaseArticleInfo localBaseArticleInfo = this.jdField_b_of_type_Qty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (oau.a((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && ((this.jdField_b_of_type_Qty.jdField_b_of_type_Boolean) || (localBaseArticleInfo.mChannelID == 56L)))
      {
        int j = 1;
        int i = nmf.Q;
        if (localBaseArticleInfo.mChannelID == 56L)
        {
          j = nmf.aF;
          i = nmf.M;
        }
        nmf.a(new nyg().a(this.jdField_a_of_type_AndroidAppActivity).a(nmf.jdField_f_of_type_Int).b(i).a((AdvertisementInfo)localBaseArticleInfo).a(nmf.a(((AdvertisementInfo)localBaseArticleInfo).adbt, (int)this.jdField_b_of_type_Qty.d, ((AdvertisementInfo)localBaseArticleInfo).getAdbf(), 0, ((AdvertisementInfo)localBaseArticleInfo).adpa, ((AdvertisementInfo)localBaseArticleInfo).adpb, localBaseArticleInfo.mVideoDuration, j, 0)).a());
        ((AdvertisementInfo)localBaseArticleInfo).adbt = ((int)this.jdField_b_of_type_Qty.d);
      }
    }
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_Qub != null) && (a() == 2);
  }
  
  public void f()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onVisiable() isPause()=" + d() + ", mPausedByMannul:" + this.jdField_d_of_type_Boolean);
      }
      if ((this.jdField_b_of_type_Qty != null) && (this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx != null)) {
        this.jdField_b_of_type_Qty.jdField_a_of_type_Qbx.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if ((d()) && (!this.jdField_d_of_type_Boolean)) {
        c();
      }
      if (this.jdField_a_of_type_Qvd != null)
      {
        this.jdField_a_of_type_Qvd.a();
        if (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
          break label152;
        }
        this.jdField_a_of_type_Qvd.a(false);
      }
    }
    for (;;)
    {
      qwf.a().a(this.jdField_a_of_type_AndroidAppActivity);
      return;
      label152:
      this.jdField_a_of_type_Qvd.a(true);
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (d())
    {
      if (!qvn.a(this.jdField_a_of_type_AndroidAppActivity)) {
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
    this.jdField_a_of_type_Qub.g();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    a(this.jdField_b_of_type_Qty, this.jdField_a_of_type_Qub, 3, null);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_Qub != null) && (this.jdField_a_of_type_Qub.f());
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
    if (this.jdField_a_of_type_Qvd != null) {
      return this.jdField_a_of_type_Qvd.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qtu
 * JD-Core Version:    0.7.0.1
 */