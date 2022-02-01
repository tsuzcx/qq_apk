import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class rnz
  extends Handler
{
  rnz(rnu paramrnu, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a()
  {
    rnu.a(this.a).sendEmptyMessageDelayed(0, 3000L);
    if (rnu.a(this.a) == null) {}
    do
    {
      return;
      long l1 = rnu.a(this.a).jdField_a_of_type_Rvo.a();
      long l2 = rnu.a(this.a).a();
      if (l2 > l1) {
        l1 = l2;
      }
      for (;;)
      {
        l1 = 3000L - (System.currentTimeMillis() - l1);
        if (l1 <= 0L) {
          break;
        }
        rnu.a(this.a).removeMessages(0);
        rnu.a(this.a).sendEmptyMessageDelayed(0, l1);
        return;
      }
    } while ((rnu.a(this.a) == null) || (rnu.a(this.a) == null) || (rnu.a(this.a).jdField_a_of_type_Rln == null));
    if (rnu.a(this.a).d())
    {
      rnu.a(this.a).jdField_a_of_type_Rln.g(false);
      return;
    }
    rnu.a(this.a).jdField_a_of_type_Rln.b();
  }
  
  private void a(Message paramMessage)
  {
    View localView;
    if ((rnu.a(this.a) instanceof rog))
    {
      localrog = (rog)rnu.a(this.a);
      localView = localrog.jdField_b_of_type_AndroidViewView;
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
      paramMessage = localrog.jdField_a_of_type_Rrm.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
      localAdvertisementInfo = nzq.a(paramMessage);
      if (localObject != null)
      {
        rnu.b(this.a, true);
        if (localrog.i != null) {
          localrog.i.setVisibility(8);
        }
        rpt.a(localrog.m, 250, 8, Utils.dp2px(200.0D));
        rpt.a(localView, 250, 0, 250, localView.getMeasuredHeight());
        nzq.a(new tlx().a(rnu.a(this.a)).a(nzq.jdField_a_of_type_Int).b(nzq.aa).a(localAdvertisementInfo).a(paramMessage).d(nzq.aW).a());
        return;
      }
    } while (rnu.b(this.a));
    rog localrog = (rog)rnu.a(this.a);
    localrog.p.setVisibility(8);
    localrog.k.setVisibility(0);
    localrog.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(100);
    rpt.a(localView, 250, 8, localView.getMeasuredHeight());
    if (!rnu.c(this.a)) {
      tph.b(localrog.jdField_b_of_type_AndroidWidgetSeekBar);
    }
    if (((rog)rnu.a(this.a)).i != null)
    {
      rnu.a(this.a, (rog)rnu.a(this.a));
      ((rog)rnu.a(this.a)).i.setVisibility(0);
    }
    rpt.a(((rog)rnu.a(this.a)).m, 250, 0, 250, Utils.dp2px(200.0D));
    if ((tpz.d(paramMessage)) && (rnu.a(this.a) != null)) {
      rnu.a(this.a).a();
    }
    nzq.a(new tlx().a(rnu.a(this.a)).a(nzq.b).b(nzq.aa).a(localAdvertisementInfo).a(paramMessage).a());
  }
  
  private void b()
  {
    if (rnu.a(this.a))
    {
      rnu.a(this.a).sendEmptyMessage(3);
      rnu.a(this.a).sendEmptyMessageDelayed(2, 50L);
    }
    rnu.a(this.a).a();
  }
  
  private void c()
  {
    int j = 0;
    rnu.a(this.a, false);
    rot localrot;
    Object localObject;
    int i;
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    tmf localtmf;
    if ((rnu.a(this.a) instanceof rot))
    {
      localrot = (rot)rnu.a(this.a);
      if ((localrot.jdField_a_of_type_Rrm != null) && (localrot.jdField_a_of_type_Rrm.a != null) && (localrot.jdField_a_of_type_Rrm.a.c) && (localrot.jdField_a_of_type_Rrm.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
      {
        localObject = localrot.jdField_a_of_type_Rrm.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h;
        if (!rnu.a(this.a).contains(localObject))
        {
          rnu.a(this.a).add(localObject);
          localObject = nzq.a(localrot.jdField_a_of_type_Rrm.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
          i = nzq.P;
          if (localrot.jdField_a_of_type_Rrm.a.a(rnu.a(this.a))) {
            i = nzq.R;
          }
          localJSONObject1 = new JSONObject();
          localJSONObject2 = new JSONObject();
          localtmf = localrot.jdField_a_of_type_Rrm.a.jdField_a_of_type_Tmf;
          if ((trd.jdField_a_of_type_Int != 1) || (localtmf == null)) {
            break label377;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject2.put("slot", localtmf.jdField_a_of_type_Int);
        localJSONObject2.put("last_ad_distance", localtmf.b);
        localJSONObject2.put("last_ad_time", localtmf.jdField_a_of_type_Long);
        localJSONObject2.put("stratege_time_b", localtmf.c);
        localJSONObject1.put("exposure_info_report", localJSONObject2.toString());
        tpx.a("Q.pubaccount.video.feeds.VideoFeedsAdapter", "exposure_info_report = " + localJSONObject2.toString());
        nzq.a(new tlx().a(rnu.a(this.a)).a(nzq.b).b(i).a((AdvertisementInfo)localObject).a(localrot.jdField_a_of_type_Rrm.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).e(localJSONObject1).a());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      try
      {
        label377:
        if (rnu.a(this.a) != null) {
          j = rnu.a(this.a).c();
        }
        localJSONObject2.put("slot", rnu.a(this.a).getAdapterPosition() - j);
        localJSONObject1.put("exposure_info_report", localJSONObject2.toString());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void d()
  {
    rnu.a(this.a).b();
  }
  
  private void e()
  {
    if (rnu.a(this.a) == null) {}
    while ((rnu.a(this.a) == null) || (!rnu.a(this.a).d()) || (!(rnu.a(this.a) instanceof rog)) || (tqa.a((rog)rnu.a(this.a)))) {
      return;
    }
    rnu.a(this.a, true, (rog)rnu.a(this.a));
  }
  
  private void f()
  {
    if ((rnu.a(this.a) instanceof rot)) {
      rpt.a(((rot)rnu.a(this.a)).jdField_a_of_type_Rlm.a(), 8, 600);
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
 * Qualified Name:     rnz
 * JD-Core Version:    0.7.0.1
 */