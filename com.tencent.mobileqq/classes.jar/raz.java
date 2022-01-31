import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

class raz
  extends Handler
{
  raz(raw paramraw, Looper paramLooper)
  {
    super(paramLooper);
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
    default: 
      super.handleMessage(paramMessage);
    }
    Object localObject1;
    AdvertisementInfo localAdvertisementInfo;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                        raw.a(this.a).sendEmptyMessageDelayed(0, 3000L);
                      } while (raw.a(this.a) == null);
                      long l1 = raw.a(this.a).jdField_a_of_type_Riw.a();
                      long l2 = raw.a(this.a).a();
                      if (l2 > l1) {
                        l1 = l2;
                      }
                      for (;;)
                      {
                        l1 = 3000L - (System.currentTimeMillis() - l1);
                        if (l1 <= 0L) {
                          break;
                        }
                        raw.a(this.a).removeMessages(0);
                        raw.a(this.a).sendEmptyMessageDelayed(0, l1);
                        return;
                      }
                    } while ((raw.a(this.a) == null) || (raw.a(this.a) == null) || (raw.a(this.a).jdField_a_of_type_Qyv == null));
                    if (raw.a(this.a).d())
                    {
                      raw.a(this.a).jdField_a_of_type_Qyv.f(false);
                      return;
                    }
                    raw.a(this.a).jdField_a_of_type_Qyv.b();
                    return;
                    if (raw.a(this.a))
                    {
                      raw.a(this.a).sendEmptyMessage(3);
                      raw.a(this.a).sendEmptyMessageDelayed(2, 50L);
                    }
                    raw.a(this.a).a();
                    return;
                    raw.a(this.a).b();
                    return;
                    raw.a(this.a, false);
                  } while (!(raw.a(this.a) instanceof rbt));
                  paramMessage = (rbt)raw.a(this.a);
                } while ((paramMessage.jdField_a_of_type_Rfs == null) || (paramMessage.jdField_a_of_type_Rfs.a == null) || (!paramMessage.jdField_a_of_type_Rfs.a.c) || (paramMessage.jdField_a_of_type_Rfs.a.a == null));
                localObject1 = paramMessage.jdField_a_of_type_Rfs.a.a.h;
              } while (raw.a(this.a).contains(localObject1));
              raw.a(this.a).add(localObject1);
              localObject1 = noy.a(paramMessage.jdField_a_of_type_Rfs.a.a);
              if (paramMessage.jdField_a_of_type_Rfs.a.a(raw.a(this.a)))
              {
                noy.a(new obk().a(raw.a(this.a)).a(noy.b).b(noy.P).a((AdvertisementInfo)localObject1).a(paramMessage.jdField_a_of_type_Rfs.a.a).a());
                return;
              }
              noy.a(new obk().a(raw.a(this.a)).a(noy.b).b(noy.N).a((AdvertisementInfo)localObject1).a(paramMessage.jdField_a_of_type_Rfs.a.a).a());
              return;
            } while ((raw.a(this.a) == null) || (raw.a(this.a) == null) || (!raw.a(this.a).d()) || (!(raw.a(this.a) instanceof rbi)) || (oee.a((rbi)raw.a(this.a))));
            raw.a(this.a, true, (rbi)raw.a(this.a));
            return;
          } while (!(raw.a(this.a) instanceof rbt));
          rdm.a(((rbt)raw.a(this.a)).jdField_a_of_type_Qyu.a(), 8, 600);
          return;
        } while (!(raw.a(this.a) instanceof rbi));
        localrbi = (rbi)raw.a(this.a);
        localObject1 = localrbi.d;
      } while (localObject1 == null);
      Object localObject2 = paramMessage.obj;
      paramMessage = localrbi.jdField_a_of_type_Rfs.a.a;
      localAdvertisementInfo = noy.a(paramMessage);
      if (localObject2 != null)
      {
        raw.b(this.a, true);
        if (localrbi.k != null) {
          localrbi.k.setVisibility(8);
        }
        rdm.a(localrbi.o, 250, 8, Utils.dp2px(200.0D));
        rdm.a((View)localObject1, 250, 0, 250, ((View)localObject1).getMeasuredHeight());
        noy.a(new obk().a(raw.a(this.a)).a(noy.a).b(noy.Y).a(localAdvertisementInfo).a(paramMessage).d(noy.aM).a());
        return;
      }
    } while (raw.b(this.a));
    rbi localrbi = (rbi)raw.a(this.a);
    localrbi.r.setVisibility(8);
    localrbi.m.setVisibility(0);
    localrbi.b.setProgress(100);
    rdm.a((View)localObject1, 250, 8, ((View)localObject1).getMeasuredHeight());
    if (((rbi)raw.a(this.a)).k != null)
    {
      raw.a(this.a, (rbi)raw.a(this.a));
      ((rbi)raw.a(this.a)).k.setVisibility(0);
    }
    rdm.a(((rbi)raw.a(this.a)).o, 250, 0, 250, Utils.dp2px(200.0D));
    if ((oed.d(paramMessage)) && (raw.a(this.a) != null)) {
      raw.a(this.a).a();
    }
    noy.a(new obk().a(raw.a(this.a)).a(noy.b).b(noy.Y).a(localAdvertisementInfo).a(paramMessage).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     raz
 * JD-Core Version:    0.7.0.1
 */