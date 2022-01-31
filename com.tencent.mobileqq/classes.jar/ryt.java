import android.app.Activity;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.VComponentAdapter.OnVideoViewMethodListener;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONException;
import org.json.JSONObject;

public class ryt
  implements qvp, qyq, ryu
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  protected Activity a;
  protected VVideoView a;
  qyr jdField_a_of_type_Qyr;
  @Nullable
  private ryw jdField_a_of_type_Ryw;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public ryt(Activity paramActivity, VVideoView paramVVideoView, int paramInt)
  {
    this.jdField_a_of_type_Qyr = new qyr(paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView = paramVVideoView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    qvo.a().a(paramActivity);
    qvo.a().a(this);
    this.jdField_a_of_type_Qyr.a(this);
    this.jdField_a_of_type_Qyr.a(paramVVideoView);
  }
  
  private int a()
  {
    switch (this.jdField_a_of_type_Qyr.a())
    {
    case 6: 
    default: 
      return 6;
    case 1: 
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    case 5: 
      return 4;
    }
    return 5;
  }
  
  public static final int a(long paramLong)
  {
    int i = 0;
    if (paramLong >= 500L) {
      i = (int)(paramLong / 1000L + 0.5D);
    }
    return i;
  }
  
  private void a(int paramInt, Object paramObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", paramInt);
      if (paramObject != null) {
        localJSONObject.put("message", paramObject);
      }
      paramObject = new JSONObject();
      paramObject.put("width", this.jdField_a_of_type_Qyr.b());
      paramObject.put("height", this.jdField_a_of_type_Qyr.c());
      localJSONObject.put("videoSize", paramObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("stateChange", localJSONObject);
      return;
    }
    catch (Exception paramObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VVideoControlListenerImpl", 2, "callJsStateChange,error = " + paramObject.getMessage());
    }
  }
  
  private void r()
  {
    if (this.jdField_b_of_type_Boolean) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("hasUI", 0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("didEnterFullScreen", localJSONObject);
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("VVideoControlListenerImpl", 2, "initChangeFullScreenAnim onAnimationEnd error = : " + localException.getMessage());
        return;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("didExitFullScreen", null);
  }
  
  public void a()
  {
    a(1, null);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_Qyr.e(true);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (this.jdField_a_of_type_Int == -1) {
          this.jdField_a_of_type_Int = qvo.a().a(3);
        }
        localJSONObject.put("value", paramInt / this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("volumeChange", localJSONObject);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.jdField_a_of_type_Qyr.e(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject1.put("code", 101);
      localJSONObject2.put("code", paramInt1 + "-" + paramInt2);
      localJSONObject2.put("msg", paramString);
      localJSONObject1.put("extra", localJSONObject2);
      a(6, localJSONObject1);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("currentTime", a(paramLong));
      localJSONObject.put("totalTime", this.jdField_a_of_type_Qyr.a() / 1000L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("playTimeChange", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_Qyr.a.a(paramVideoPreDownloadMgr);
  }
  
  public void a(VVideoView paramVVideoView)
  {
    if ((this.jdField_a_of_type_Ryw != null) && (!this.jdField_a_of_type_Qyr.a()))
    {
      this.jdField_a_of_type_Qyr.a(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Qyr.a(this.jdField_a_of_type_Ryw.jdField_a_of_type_Int, this.jdField_a_of_type_Ryw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ryw.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Ryw.jdField_d_of_type_Int);
    }
  }
  
  public void a(VVideoView paramVVideoView, int paramInt)
  {
    this.jdField_a_of_type_Qyr.b(paramInt);
  }
  
  public void a(VVideoView paramVVideoView, String paramString)
  {
    if (paramString.equals("contain")) {
      this.jdField_a_of_type_Qyr.a(0);
    }
    while (!paramString.equals("cover")) {
      return;
    }
    this.jdField_a_of_type_Qyr.a(2);
  }
  
  public void a(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    try
    {
      paramVVideoView = new JSONObject();
      paramVVideoView.put("state", a());
      paramVVideoView.put("currentTime", a(this.jdField_a_of_type_Qyr.b()));
      paramVVideoView.put("totalTime", this.jdField_a_of_type_Qyr.a() / 1000L);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("width", this.jdField_a_of_type_Qyr.b());
      localJSONObject.put("height", this.jdField_a_of_type_Qyr.c());
      paramVVideoView.put("videoSize", localJSONObject);
      paramOnVideoViewMethodListener.OnMethodSuccess(paramString, paramVVideoView);
      return;
    }
    catch (JSONException paramVVideoView)
    {
      paramVVideoView.printStackTrace();
    }
  }
  
  public void a(VVideoView paramVVideoView, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "open: " + paramJSONObject);
    }
    try
    {
      boolean bool1 = paramJSONObject.optBoolean("autoplay", true);
      boolean bool2 = paramJSONObject.optBoolean("autoPreplay", false);
      a(paramVVideoView, paramJSONObject.optString("resize"));
      c(paramVVideoView, paramJSONObject.optInt("timeupdateRate"));
      c_(paramJSONObject.optBoolean("endWithLastFrame"));
      this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("cover_frame", false);
      this.jdField_a_of_type_Long = (paramJSONObject.optLong("start_position", 0L) * 1000L);
      this.jdField_a_of_type_Ryw = new ryw(paramJSONObject.getJSONObject("video_info"));
      this.jdField_a_of_type_Qyr.e(paramJSONObject.optBoolean("muted", false));
      if (bool1)
      {
        this.jdField_a_of_type_Qyr.a(this.jdField_a_of_type_Ryw.jdField_a_of_type_Int, this.jdField_a_of_type_Ryw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ryw.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Ryw.jdField_d_of_type_Int);
        return;
      }
      if (bool2)
      {
        a(null);
        return;
      }
    }
    catch (JSONException paramVVideoView)
    {
      paramVVideoView.printStackTrace();
    }
  }
  
  public void a(VVideoView paramVVideoView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Qyr.e(paramBoolean);
  }
  
  public void a(VVideoView paramVVideoView, boolean paramBoolean, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "deal enterFullScreen: ");
    }
    this.jdField_b_of_type_Boolean = true;
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(0);
    }
    paramVVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView;
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    this.jdField_b_of_type_Int = localActivity.getWindow().getDecorView().getSystemUiVisibility();
    qoi.a(localActivity);
    if ((paramVVideoView.a() != null) && (paramVVideoView.a().getInstance() != null) && (paramVVideoView.a().getInstance().getFragment() != null))
    {
      paramVVideoView = (ViolaLazyFragment)paramVVideoView.a().getInstance().getFragment();
      if (paramVVideoView != null)
      {
        paramVVideoView.o();
        paramVVideoView.m();
      }
    }
    r();
    try
    {
      paramVVideoView = new JSONObject();
      paramVVideoView.put("hasUI", false);
      paramOnVideoViewMethodListener.OnMethodSuccess(paramString, paramVVideoView);
      return;
    }
    catch (Exception paramVVideoView)
    {
      QLog.e("VVideoControlListenerImpl", 2, "enterFullScreen error = : " + paramVVideoView.getMessage());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Qyr.e(false);
      return;
    }
    this.jdField_a_of_type_Qyr.e(true);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    a(2, null);
  }
  
  public void b(int paramInt)
  {
    a(5, null);
  }
  
  public void b(VVideoView paramVVideoView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "play: status=" + this.jdField_a_of_type_Qyr.a() + ", isPreload=" + this.jdField_a_of_type_Qyr.a() + ", videoinfo=" + this.jdField_a_of_type_Ryw + ", mStartPosition:" + this.jdField_a_of_type_Long);
    }
    if ((this.jdField_a_of_type_Ryw != null) && (this.jdField_a_of_type_Qyr.a())) {
      this.jdField_a_of_type_Qyr.a(this.jdField_a_of_type_Ryw.jdField_a_of_type_Int, this.jdField_a_of_type_Ryw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ryw.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Ryw.jdField_d_of_type_Int);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Qyr.b())
      {
        this.jdField_a_of_type_Qyr.a();
        return;
      }
    } while (this.jdField_a_of_type_Ryw == null);
    this.jdField_a_of_type_Qyr.a(this.jdField_a_of_type_Ryw.jdField_a_of_type_Int, this.jdField_a_of_type_Ryw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ryw.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Ryw.jdField_d_of_type_Int);
  }
  
  public void b(VVideoView paramVVideoView, int paramInt) {}
  
  public void b(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "deal exitFullScreen: ");
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    paramVVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView;
    this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().setSystemUiVisibility(this.jdField_b_of_type_Int);
    if ((paramVVideoView.a() != null) && (paramVVideoView.a().getInstance() != null) && (paramVVideoView.a().getInstance().getFragment() != null))
    {
      paramVVideoView = (ViolaLazyFragment)paramVVideoView.a().getInstance().getFragment();
      if (paramVVideoView != null)
      {
        paramVVideoView.p();
        paramVVideoView.n();
      }
    }
    r();
    if ((TextUtils.isEmpty(paramString)) && (paramOnVideoViewMethodListener != null)) {}
    try
    {
      paramVVideoView = new JSONObject();
      paramVVideoView.put("hasUI", false);
      paramOnVideoViewMethodListener.OnMethodSuccess(paramString, paramVVideoView);
      return;
    }
    catch (Exception paramVVideoView)
    {
      QLog.e("VVideoControlListenerImpl", 2, "exitFullScreen error = : " + paramVVideoView.getMessage());
    }
  }
  
  public void b(VVideoView paramVVideoView, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "resetSrc: " + paramJSONObject);
    }
    this.jdField_a_of_type_Qyr.d();
    a(paramVVideoView, paramJSONObject);
  }
  
  public void b(VVideoView paramVVideoView, boolean paramBoolean) {}
  
  public void b_(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qyr.d(paramBoolean);
  }
  
  public void c()
  {
    a(4, null);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Long = (paramInt * 1000);
  }
  
  public void c(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_Qyr.b();
  }
  
  public void c(VVideoView paramVVideoView, int paramInt)
  {
    this.jdField_a_of_type_Qyr.c(paramInt);
  }
  
  public void c(VVideoView paramVVideoView, boolean paramBoolean) {}
  
  public void c_(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qyr.b(paramBoolean);
  }
  
  public void d()
  {
    a(2, null);
  }
  
  public void d(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_Qyr.d();
  }
  
  public void e()
  {
    a(7, null);
  }
  
  public void e(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_Qyr.d();
    if (this.jdField_a_of_type_Ryw != null) {
      this.jdField_a_of_type_Qyr.a(this.jdField_a_of_type_Ryw.jdField_a_of_type_Int, this.jdField_a_of_type_Ryw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ryw.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Ryw.jdField_d_of_type_Int);
    }
  }
  
  public void f()
  {
    a(3, null);
  }
  
  public void f(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_Qyr.e();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Qyr.b();
  }
  
  public void g(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_Qyr.f();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Qyr.g()) {
      a(2, null);
    }
    while (!this.jdField_a_of_type_Qyr.f()) {
      return;
    }
    a(4, null);
  }
  
  public void i()
  {
    a(5, null);
  }
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
  
  public void m() {}
  
  public void n()
  {
    this.jdField_a_of_type_Qyr.h();
    qvo.a().a(true, "viola video");
  }
  
  public void o()
  {
    this.jdField_a_of_type_Qyr.g();
    qvo.a().a(false, "viola video");
  }
  
  public void p() {}
  
  public void q()
  {
    this.jdField_a_of_type_Qyr.i();
    qvo.a().b(this.jdField_a_of_type_AndroidAppActivity);
    qvo.a().b(this);
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ryt
 * JD-Core Version:    0.7.0.1
 */