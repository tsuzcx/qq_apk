import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.CircleCountdownView;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class org
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ArrayList<ori> jdField_a_of_type_JavaUtilArrayList;
  private rxl jdField_a_of_type_Rxl;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public org(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private int a(VideoInfo paramVideoInfo)
  {
    int i = 2;
    if ((paramVideoInfo == null) || (paramVideoInfo.a == null)) {
      i = 0;
    }
    for (;;)
    {
      return i;
      if (rwy.a(paramVideoInfo.a)) {
        return 4;
      }
      if (paramVideoInfo.a.c != 12) {
        return 1;
      }
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.a.r);
        boolean bool = bgnw.a(this.jdField_a_of_type_AndroidContentContext, paramVideoInfo.optString("pkg_name"));
        if (bool) {
          return 3;
        }
      }
      catch (JSONException paramVideoInfo) {}
    }
    return 2;
  }
  
  private boolean b(sar paramsar)
  {
    return (paramsar != null) && (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramsar.jdField_a_of_type_Rgb != null) && (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) && (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null);
  }
  
  private void g()
  {
    Resources localResources;
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.jdField_a_of_type_Rxl != null) && (this.jdField_a_of_type_Rxl.h != null))
    {
      localResources = this.jdField_a_of_type_Rxl.h.getResources();
      localObject1 = "";
      if ((this.jdField_a_of_type_Rxl.jdField_a_of_type_Sar == null) || (this.jdField_a_of_type_Rxl.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
        break label327;
      }
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Rxl.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null)
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Rxl.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.l)) {
          localObject2 = this.jdField_a_of_type_Rxl.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.l;
        }
      }
      switch (a(this.jdField_a_of_type_Rxl.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))
      {
      default: 
        localObject1 = localObject2;
        i = 2130843040;
        if (localResources.getText(2131717031).toString().equals(localObject1)) {
          i = 2130843039;
        }
        break;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Rxl.h.setText((CharSequence)localObject1);
      int j = afur.a(12.0F, localResources);
      localObject1 = localResources.getDrawable(i);
      ((Drawable)localObject1).setBounds(0, 0, j, j);
      this.jdField_a_of_type_Rxl.h.setCompoundDrawables((Drawable)localObject1, null, null, null);
      return;
      localObject1 = localResources.getText(2131717034).toString();
      break;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localResources.getText(2131717031).toString();
      break;
      localObject1 = localResources.getText(2131717032).toString();
      break;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localResources.getText(2131717085).toString();
      break;
      label327:
      localObject1 = localResources.getText(2131717085).toString();
      break;
      if (localResources.getText(2131717032).toString().equals(localObject1)) {
        i = 2130843042;
      }
    }
  }
  
  public rxl a()
  {
    return this.jdField_a_of_type_Rxl;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.jdField_a_of_type_AndroidContentContext = null;
    }
    if (this.jdField_a_of_type_Rxl != null) {
      this.jdField_a_of_type_Rxl = null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
  }
  
  public void a(ori paramori)
  {
    if ((paramori != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramori))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramori);
    }
  }
  
  public void a(rxy paramrxy)
  {
    if (this.jdField_a_of_type_Rxl != null)
    {
      this.jdField_a_of_type_Rxl.e.setVisibility(8);
      this.jdField_a_of_type_Rxl.jdField_a_of_type_Sar.a("continue_pause", false);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = false;
    }
    if ((paramrxy instanceof rxl))
    {
      this.jdField_a_of_type_Rxl = ((rxl)paramrxy);
      return;
    }
    this.jdField_a_of_type_Rxl = null;
  }
  
  public boolean a()
  {
    if ((!this.b) && (this.jdField_a_of_type_Rxl != null) && (this.jdField_a_of_type_Rxl.e != null) && (this.jdField_a_of_type_Rxl.e.getVisibility() == 0))
    {
      if (this.c)
      {
        this.jdField_a_of_type_Rxl.e.setVisibility(8);
        this.jdField_a_of_type_Rxl.jdField_a_of_type_Sar.a("continue_pause", false);
        this.c = false;
        return true;
      }
      g();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
    }
    this.c = false;
    return false;
  }
  
  public boolean a(sar paramsar)
  {
    if ((paramsar == null) || (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) || ((this.jdField_a_of_type_Rxl != null) && (!this.jdField_a_of_type_Boolean) && (oqi.b(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a)))) {}
    while ((this.jdField_a_of_type_Rxl == null) || (this.jdField_a_of_type_Boolean) || (!oqi.a(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a))) {
      return false;
    }
    rgb localrgb;
    boolean bool;
    label163:
    AdvertisementInfo localAdvertisementInfo;
    int m;
    int n;
    int i;
    label228:
    int j;
    label238:
    int i1;
    if ((b(paramsar)) && (paramsar.jdField_a_of_type_Sfb != null) && (!paramsar.jdField_a_of_type_Rgb.jdField_d_of_type_Boolean))
    {
      if (paramsar.jdField_a_of_type_Sfb.e() != 0L) {
        break label496;
      }
      paramsar.jdField_a_of_type_Rgb.jdField_d_of_type_Int = paramsar.jdField_a_of_type_Rgb.e;
      paramsar.jdField_a_of_type_Rgb.e = ((int)paramsar.jdField_a_of_type_Sfb.b(true));
      localrgb = paramsar.jdField_a_of_type_Rgb;
      if (paramsar.jdField_a_of_type_Rgb.jdField_d_of_type_Int != 0) {
        break label514;
      }
      bool = true;
      localrgb.b = bool;
      paramsar.jdField_a_of_type_Rgb.c = true;
      paramsar.jdField_a_of_type_Rgb.jdField_d_of_type_Boolean = true;
      localrgb = paramsar.jdField_a_of_type_Rgb;
      localAdvertisementInfo = nxw.a(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      m = localrgb.jdField_d_of_type_Int;
      n = localrgb.e;
      if (!localrgb.b) {
        break label520;
      }
      i = 1;
      if (!localrgb.c) {
        break label525;
      }
      j = 1;
      i1 = localrgb.f;
      if (!localrgb.jdField_a_of_type_Boolean) {
        break label530;
      }
    }
    label514:
    label520:
    label525:
    label530:
    for (int k = 1;; k = 2)
    {
      JSONObject localJSONObject = nxw.a(m, n, i, j, i1, k, (int)paramsar.jdField_a_of_type_Sfb.b(), nxw.aI, 0);
      nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(nxw.f).b(localrgb.g).a(localAdvertisementInfo).a(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(localJSONObject).a());
      if (this.jdField_a_of_type_Rxl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView != null) {
        this.jdField_a_of_type_Rxl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.a();
      }
      g();
      if (this.jdField_a_of_type_Rxl.e != null)
      {
        this.jdField_a_of_type_Rxl.e.setVisibility(0);
        this.jdField_a_of_type_Rxl.jdField_a_of_type_Sar.a("continue_pause", true);
        if (this.jdField_a_of_type_Rxl.f != null) {
          this.jdField_a_of_type_Rxl.f.setVisibility(8);
        }
        paramsar = ObjectAnimator.ofFloat(this.jdField_a_of_type_Rxl.e, "alpha", new float[] { 0.0F, 1.0F });
        paramsar.setDuration(200L);
        paramsar.setInterpolator(new DecelerateInterpolator());
        paramsar.addListener(new orh(this));
        paramsar.start();
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
      return true;
      label496:
      paramsar.jdField_a_of_type_Rgb.jdField_d_of_type_Int = ((int)paramsar.jdField_a_of_type_Sfb.e());
      break;
      bool = false;
      break label163;
      i = 0;
      break label228;
      j = 0;
      break label238;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void c()
  {
    this.b = true;
    b();
  }
  
  public void d()
  {
    this.b = false;
    a();
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Rxl != null) && (this.jdField_a_of_type_Rxl.e != null))
    {
      this.jdField_a_of_type_Rxl.e.setVisibility(8);
      this.jdField_a_of_type_Rxl.jdField_a_of_type_Sar.a("continue_pause", false);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Rxl != null) && (this.jdField_a_of_type_Rxl.jdField_a_of_type_Sar != null) && (this.jdField_a_of_type_Rxl.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (a(this.jdField_a_of_type_Rxl.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo) != 3)) {
      this.c = true;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if ((this.jdField_a_of_type_Rxl != null) && (this.jdField_a_of_type_Rxl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView != null))
    {
      if (!this.jdField_a_of_type_Rxl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.a(20)) {
        break label154;
      }
      if (this.jdField_a_of_type_Rxl.e != null)
      {
        this.jdField_a_of_type_Rxl.e.setVisibility(8);
        this.jdField_a_of_type_Rxl.jdField_a_of_type_Sar.a("continue_pause", false);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        paramMessage = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramMessage.hasNext()) {
          ((ori)paramMessage.next()).a();
        }
      }
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      return true;
      label154:
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org
 * JD-Core Version:    0.7.0.1
 */