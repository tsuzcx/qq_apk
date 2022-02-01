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

class rvb
  extends Handler
{
  rvb(ruw paramruw, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a()
  {
    ruw.a(this.a).sendEmptyMessageDelayed(0, 3000L);
    if (ruw.a(this.a) == null) {}
    do
    {
      return;
      long l1 = ruw.a(this.a).jdField_a_of_type_Scs.a();
      long l2 = ruw.a(this.a).a();
      if (l2 > l1) {
        l1 = l2;
      }
      for (;;)
      {
        l1 = 3000L - (System.currentTimeMillis() - l1);
        if (l1 <= 0L) {
          break;
        }
        ruw.a(this.a).removeMessages(0);
        ruw.a(this.a).sendEmptyMessageDelayed(0, l1);
        return;
      }
    } while ((ruw.a(this.a) == null) || (ruw.a(this.a) == null) || (ruw.a(this.a).jdField_a_of_type_Rsn == null));
    if (ruw.a(this.a).d())
    {
      ruw.a(this.a).jdField_a_of_type_Rsn.g(false);
      return;
    }
    ruw.a(this.a).jdField_a_of_type_Rsn.b();
  }
  
  private void a(Message paramMessage)
  {
    View localView;
    if ((ruw.a(this.a) instanceof rvi))
    {
      localrvi = (rvi)ruw.a(this.a);
      localView = localrvi.jdField_b_of_type_AndroidViewView;
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
      paramMessage = localrvi.jdField_a_of_type_Ryo.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
      localAdvertisementInfo = obb.a(paramMessage);
      if (localObject != null)
      {
        ruw.b(this.a, true);
        if (localrvi.i != null) {
          localrvi.i.setVisibility(8);
        }
        if ((twq.d(paramMessage)) && (ruw.a(this.a) != null)) {
          ruw.a(this.a).a();
        }
        rwv.a(localrvi.m, 250, 8, Utils.dp2px(200.0D));
        rwv.a(localView, 250, 0, 250, localView.getMeasuredHeight());
        obb.a(new trn().a(ruw.a(this.a)).a(obb.jdField_a_of_type_Int).b(obb.aa).a(localAdvertisementInfo).a(paramMessage).d(obb.aX).a());
        return;
      }
    } while (ruw.c(this.a));
    rvi localrvi = (rvi)ruw.a(this.a);
    localrvi.p.setVisibility(8);
    localrvi.k.setVisibility(0);
    localrvi.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(100);
    rwv.a(localView, 250, 8, localView.getMeasuredHeight());
    if (!ruw.b(this.a)) {
      twb.b(localrvi.jdField_b_of_type_AndroidWidgetSeekBar);
    }
    if (((rvi)ruw.a(this.a)).i != null)
    {
      ruw.a(this.a, (rvi)ruw.a(this.a));
      ((rvi)ruw.a(this.a)).i.setVisibility(0);
    }
    rwv.a(((rvi)ruw.a(this.a)).m, 250, 0, 250, Utils.dp2px(200.0D));
    if ((twq.d(paramMessage)) && (ruw.a(this.a) != null)) {
      ruw.a(this.a).a();
    }
    obb.a(new trn().a(ruw.a(this.a)).a(obb.b).b(obb.aa).a(localAdvertisementInfo).a(paramMessage).a());
  }
  
  private void b()
  {
    if (ruw.a(this.a))
    {
      ruw.a(this.a).sendEmptyMessage(3);
      ruw.a(this.a).sendEmptyMessageDelayed(2, 50L);
    }
    ruw.a(this.a).a();
  }
  
  private void c()
  {
    int j = 0;
    ruw.a(this.a, false);
    rvv localrvv;
    Object localObject;
    int i;
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    trv localtrv;
    if ((ruw.a(this.a) instanceof rvv))
    {
      localrvv = (rvv)ruw.a(this.a);
      if ((localrvv.jdField_a_of_type_Ryo != null) && (localrvv.jdField_a_of_type_Ryo.a != null) && (localrvv.jdField_a_of_type_Ryo.a.c) && (localrvv.jdField_a_of_type_Ryo.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
      {
        localObject = localrvv.jdField_a_of_type_Ryo.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h;
        if (!ruw.a(this.a).contains(localObject))
        {
          ruw.a(this.a).add(localObject);
          localObject = obb.a(localrvv.jdField_a_of_type_Ryo.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
          i = obb.P;
          if (localrvv.jdField_a_of_type_Ryo.a.a(ruw.a(this.a))) {
            i = obb.R;
          }
          localJSONObject1 = new JSONObject();
          localJSONObject2 = new JSONObject();
          localtrv = localrvv.jdField_a_of_type_Ryo.a.jdField_a_of_type_Trv;
          if ((txw.jdField_a_of_type_Int != 1) || (localtrv == null)) {
            break label399;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject2.put("slot", localtrv.jdField_a_of_type_Int);
        localJSONObject2.put("last_ad_distance", localtrv.b);
        localJSONObject2.put("last_ad_time", localtrv.jdField_a_of_type_Long);
        localJSONObject2.put("stratege_time_b", localtrv.c);
        localJSONObject1.put("exposure_info_report", localJSONObject2.toString());
        twp.a("Q.pubaccount.video.feeds.VideoFeedsAdapter", "exposure_info_report = " + localJSONObject2.toString());
        obb.a(new trn().a(ruw.a(this.a)).a(obb.b).b(i).a((AdvertisementInfo)localObject).a(localrvv.jdField_a_of_type_Ryo.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).e(localJSONObject1).a());
        nwz.a().a(Long.valueOf(localrvv.jdField_a_of_type_Ryo.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.e));
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      try
      {
        label399:
        if (ruw.a(this.a) != null) {
          j = ruw.a(this.a).c();
        }
        localJSONObject2.put("slot", ruw.a(this.a).getAdapterPosition() - j);
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
    ruw.a(this.a).b();
  }
  
  private void e()
  {
    if (ruw.a(this.a) == null) {}
    while ((ruw.a(this.a) == null) || (!ruw.a(this.a).d()) || (!(ruw.a(this.a) instanceof rvi)) || (twr.a((rvi)ruw.a(this.a)))) {
      return;
    }
    ruw.a(this.a, true, (rvi)ruw.a(this.a));
  }
  
  private void f()
  {
    if (ruw.a(this.a) == null) {}
    while ((ruw.a(this.a) == null) || (!ruw.a(this.a).d()) || (!(ruw.a(this.a) instanceof rvi)) || (twr.a((rvi)ruw.a(this.a)))) {
      return;
    }
    twd.a(true, (rvi)ruw.a(this.a), ruw.b(this.a), this.a);
  }
  
  private void g()
  {
    if ((ruw.a(this.a) instanceof rvv)) {
      rwv.a(((rvv)ruw.a(this.a)).jdField_a_of_type_Rsm.a(), 8, 600);
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "mUIHandler handleMessage() msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      a();
      return;
      b();
      return;
      d();
      return;
      c();
      return;
      e();
      return;
      g();
      return;
      a(paramMessage);
      return;
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvb
 * JD-Core Version:    0.7.0.1
 */