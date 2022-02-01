import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.video.ADVideoAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import org.json.JSONObject;

class rxd
  extends Handler
{
  rxd(rwy paramrwy, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a()
  {
    rwy.a(this.a).sendEmptyMessageDelayed(0, 3000L);
    if (rwy.a(this.a) == null) {}
    do
    {
      return;
      long l1 = rwy.a(this.a).jdField_a_of_type_Sek.a();
      long l2 = rwy.a(this.a).a();
      if (l2 > l1) {
        l1 = l2;
      }
      for (;;)
      {
        l1 = 3000L - (System.currentTimeMillis() - l1);
        if (l1 <= 0L) {
          break;
        }
        rwy.a(this.a).removeMessages(0);
        rwy.a(this.a).sendEmptyMessageDelayed(0, l1);
        return;
      }
    } while ((rwy.a(this.a) == null) || (rwy.a(this.a) == null) || (rwy.a(this.a).jdField_a_of_type_Rur == null));
    if (rwy.a(this.a).d())
    {
      rwy.a(this.a).jdField_a_of_type_Rur.g(false);
      return;
    }
    rwy.a(this.a).jdField_a_of_type_Rur.b();
  }
  
  private void a(Message paramMessage)
  {
    View localView;
    if ((rwy.a(this.a) instanceof rxl))
    {
      localrxl = (rxl)rwy.a(this.a);
      localView = localrxl.jdField_b_of_type_AndroidViewView;
      if (localView != null) {
        break label34;
      }
    }
    label34:
    AdvertisementInfo localAdvertisementInfo;
    do
    {
      return;
      Object localObject = paramMessage.obj;
      paramMessage = localrxl.jdField_a_of_type_Sar.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
      localAdvertisementInfo = nxw.a(paramMessage);
      if (localObject != null)
      {
        rwy.b(this.a, true);
        if (localrxl.i != null) {
          localrxl.i.setVisibility(8);
        }
        ryx.a(localrxl.m, 250, 8, Utils.dp2px(200.0D));
        ryx.a(localView, 250, 0, 250, localView.getMeasuredHeight());
        nxw.a(new omp().a(rwy.a(this.a)).a(nxw.jdField_a_of_type_Int).b(nxw.aa).a(localAdvertisementInfo).a(paramMessage).d(nxw.aQ).a());
        return;
      }
    } while (rwy.b(this.a));
    rxl localrxl = (rxl)rwy.a(this.a);
    localrxl.p.setVisibility(8);
    localrxl.k.setVisibility(0);
    localrxl.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(100);
    ryx.a(localView, 250, 8, localView.getMeasuredHeight());
    if (!rwy.c(this.a)) {
      opr.b(localrxl.jdField_b_of_type_AndroidWidgetSeekBar);
    }
    if (((rxl)rwy.a(this.a)).i != null)
    {
      rwy.a(this.a, (rxl)rwy.a(this.a));
      ((rxl)rwy.a(this.a)).i.setVisibility(0);
    }
    ryx.a(((rxl)rwy.a(this.a)).m, 250, 0, 250, Utils.dp2px(200.0D));
    if ((oqi.d(paramMessage)) && (rwy.a(this.a) != null)) {
      rwy.a(this.a).a();
    }
    nxw.a(new omp().a(rwy.a(this.a)).a(nxw.b).b(nxw.aa).a(localAdvertisementInfo).a(paramMessage).a());
  }
  
  private void b()
  {
    if (rwy.a(this.a))
    {
      rwy.a(this.a).sendEmptyMessage(3);
      rwy.a(this.a).sendEmptyMessageDelayed(2, 50L);
    }
    rwy.a(this.a).a();
  }
  
  private void c()
  {
    rwy.a(this.a, false);
    rxy localrxy;
    Object localObject;
    int i;
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    omx localomx;
    if ((rwy.a(this.a) instanceof rxy))
    {
      localrxy = (rxy)rwy.a(this.a);
      if ((localrxy.jdField_a_of_type_Sar != null) && (localrxy.jdField_a_of_type_Sar.a != null) && (localrxy.jdField_a_of_type_Sar.a.c) && (localrxy.jdField_a_of_type_Sar.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
      {
        localObject = localrxy.jdField_a_of_type_Sar.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h;
        if (!rwy.a(this.a).contains(localObject))
        {
          rwy.a(this.a).add(localObject);
          localObject = nxw.a(localrxy.jdField_a_of_type_Sar.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
          i = nxw.P;
          if (localrxy.jdField_a_of_type_Sar.a.a(rwy.a(this.a))) {
            i = nxw.R;
          }
          localJSONObject1 = new JSONObject();
          localJSONObject2 = new JSONObject();
          localomx = localrxy.jdField_a_of_type_Sar.a.jdField_a_of_type_Omx;
          if ((orl.jdField_a_of_type_Int != 1) || (localomx == null)) {}
        }
      }
    }
    try
    {
      localJSONObject2.put("slot", localomx.jdField_a_of_type_Int);
      localJSONObject2.put("last_ad_distance", localomx.b);
      localJSONObject2.put("last_ad_time", localomx.jdField_a_of_type_Long);
      localJSONObject2.put("stratege_time_b", localomx.c);
      localJSONObject1.put("exposure_info_report", localJSONObject2.toString());
      label274:
      nxw.a(new omp().a(rwy.a(this.a)).a(nxw.b).b(i).a((AdvertisementInfo)localObject).a(localrxy.jdField_a_of_type_Sar.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).e(localJSONObject1).a());
      return;
    }
    catch (Exception localException)
    {
      break label274;
    }
  }
  
  private void d()
  {
    rwy.a(this.a).b();
  }
  
  private void e()
  {
    if (rwy.a(this.a) == null) {}
    while ((rwy.a(this.a) == null) || (!rwy.a(this.a).d()) || (!(rwy.a(this.a) instanceof rxl)) || (oqj.a((rxl)rwy.a(this.a)))) {
      return;
    }
    rwy.a(this.a, true, (rxl)rwy.a(this.a));
  }
  
  private void f()
  {
    if ((rwy.a(this.a) instanceof rxy)) {
      ryx.a(((rxy)rwy.a(this.a)).jdField_a_of_type_Ruq.a(), 8, 600);
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "mUIHandler handleMessage() msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    case 1: 
    case 5: 
    case 8: 
    default: 
      super.handleMessage(paramMessage);
      return;
    case 0: 
      a();
      return;
    case 2: 
      b();
      return;
    case 3: 
      d();
      return;
    case 4: 
      c();
      return;
    case 6: 
      e();
      return;
    case 7: 
      f();
      return;
    }
    a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxd
 * JD-Core Version:    0.7.0.1
 */