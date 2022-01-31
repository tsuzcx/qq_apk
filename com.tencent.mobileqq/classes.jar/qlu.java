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

class qlu
  extends Handler
{
  qlu(qls paramqls, Looper paramLooper)
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
                        qls.a(this.a).sendEmptyMessageDelayed(0, 3000L);
                      } while (qls.a(this.a) == null);
                      long l1 = qls.a(this.a).jdField_a_of_type_Qtk.a();
                      long l2 = qls.a(this.a).a();
                      if (l2 > l1) {
                        l1 = l2;
                      }
                      for (;;)
                      {
                        l1 = 3000L - (System.currentTimeMillis() - l1);
                        if (l1 <= 0L) {
                          break;
                        }
                        qls.a(this.a).removeMessages(0);
                        qls.a(this.a).sendEmptyMessageDelayed(0, l1);
                        return;
                      }
                    } while ((qls.a(this.a) == null) || (qls.a(this.a) == null) || (qls.a(this.a).jdField_a_of_type_Qjr == null));
                    if (qls.a(this.a).d())
                    {
                      qls.a(this.a).jdField_a_of_type_Qjr.f(false);
                      return;
                    }
                    qls.a(this.a).jdField_a_of_type_Qjr.b();
                    return;
                    if (qls.a(this.a))
                    {
                      qls.a(this.a).sendEmptyMessage(3);
                      qls.a(this.a).sendEmptyMessageDelayed(2, 50L);
                    }
                    qls.a(this.a).a();
                    return;
                    qls.a(this.a).b();
                    return;
                    qls.a(this.a, false);
                  } while (!(qls.a(this.a) instanceof qms));
                  paramMessage = (qms)qls.a(this.a);
                } while ((paramMessage.jdField_a_of_type_Qqo == null) || (paramMessage.jdField_a_of_type_Qqo.a == null) || (!paramMessage.jdField_a_of_type_Qqo.a.c) || (paramMessage.jdField_a_of_type_Qqo.a.a == null));
                localObject1 = paramMessage.jdField_a_of_type_Qqo.a.a.h;
              } while (qls.a(this.a).contains(localObject1));
              qls.a(this.a).add(localObject1);
              localObject1 = nmf.a(paramMessage.jdField_a_of_type_Qqo.a.a);
              if (paramMessage.jdField_a_of_type_Qqo.a.a(qls.a(this.a)))
              {
                nmf.a(new nyg().a(qls.a(this.a)).a(nmf.b).b(nmf.P).a((AdvertisementInfo)localObject1).a(paramMessage.jdField_a_of_type_Qqo.a.a).a());
                return;
              }
              nmf.a(new nyg().a(qls.a(this.a)).a(nmf.b).b(nmf.N).a((AdvertisementInfo)localObject1).a(paramMessage.jdField_a_of_type_Qqo.a.a).a());
              return;
            } while ((qls.a(this.a) == null) || (qls.a(this.a) == null) || (!qls.a(this.a).d()) || (!(qls.a(this.a) instanceof qmd)) || (oau.a((qmd)qls.a(this.a))));
            qls.a(this.a, true, (qmd)qls.a(this.a));
            return;
          } while (!(qls.a(this.a) instanceof qms));
          qol.a(((qms)qls.a(this.a)).jdField_a_of_type_Qjq.a(), 8, 600);
          return;
        } while (!(qls.a(this.a) instanceof qmd));
        localqmd = (qmd)qls.a(this.a);
        localObject1 = localqmd.d;
      } while (localObject1 == null);
      Object localObject2 = paramMessage.obj;
      paramMessage = localqmd.jdField_a_of_type_Qqo.a.a;
      localAdvertisementInfo = nmf.a(paramMessage);
      if (localObject2 != null)
      {
        qls.b(this.a, true);
        if (localqmd.k != null) {
          localqmd.k.setVisibility(8);
        }
        qol.a(localqmd.o, 250, 8, Utils.dp2px(200.0D));
        qol.a((View)localObject1, 250, 0, 250, ((View)localObject1).getMeasuredHeight());
        nmf.a(new nyg().a(qls.a(this.a)).a(nmf.a).b(nmf.Y).a(localAdvertisementInfo).a(paramMessage).d(nmf.aM).a());
        return;
      }
    } while (qls.b(this.a));
    qmd localqmd = (qmd)qls.a(this.a);
    localqmd.r.setVisibility(8);
    localqmd.m.setVisibility(0);
    localqmd.b.setProgress(100);
    qol.a((View)localObject1, 250, 8, ((View)localObject1).getMeasuredHeight());
    if (((qmd)qls.a(this.a)).k != null)
    {
      qls.a(this.a, (qmd)qls.a(this.a));
      ((qmd)qls.a(this.a)).k.setVisibility(0);
    }
    qol.a(((qmd)qls.a(this.a)).o, 250, 0, 250, Utils.dp2px(200.0D));
    if ((oat.d(paramMessage)) && (qls.a(this.a) != null)) {
      qls.a(this.a).a();
    }
    nmf.a(new nyg().a(qls.a(this.a)).a(nmf.b).b(nmf.Y).a(localAdvertisementInfo).a(paramMessage).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlu
 * JD-Core Version:    0.7.0.1
 */