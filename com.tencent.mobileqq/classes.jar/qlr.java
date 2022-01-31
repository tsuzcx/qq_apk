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

class qlr
  extends Handler
{
  qlr(qlp paramqlp, Looper paramLooper)
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
                        qlp.a(this.a).sendEmptyMessageDelayed(0, 3000L);
                      } while (qlp.a(this.a) == null);
                      long l1 = qlp.a(this.a).jdField_a_of_type_Qth.a();
                      long l2 = qlp.a(this.a).a();
                      if (l2 > l1) {
                        l1 = l2;
                      }
                      for (;;)
                      {
                        l1 = 3000L - (System.currentTimeMillis() - l1);
                        if (l1 <= 0L) {
                          break;
                        }
                        qlp.a(this.a).removeMessages(0);
                        qlp.a(this.a).sendEmptyMessageDelayed(0, l1);
                        return;
                      }
                    } while ((qlp.a(this.a) == null) || (qlp.a(this.a) == null) || (qlp.a(this.a).jdField_a_of_type_Qjo == null));
                    if (qlp.a(this.a).d())
                    {
                      qlp.a(this.a).jdField_a_of_type_Qjo.f(false);
                      return;
                    }
                    qlp.a(this.a).jdField_a_of_type_Qjo.b();
                    return;
                    if (qlp.a(this.a))
                    {
                      qlp.a(this.a).sendEmptyMessage(3);
                      qlp.a(this.a).sendEmptyMessageDelayed(2, 50L);
                    }
                    qlp.a(this.a).a();
                    return;
                    qlp.a(this.a).b();
                    return;
                    qlp.a(this.a, false);
                  } while (!(qlp.a(this.a) instanceof qmp));
                  paramMessage = (qmp)qlp.a(this.a);
                } while ((paramMessage.jdField_a_of_type_Qql == null) || (paramMessage.jdField_a_of_type_Qql.a == null) || (!paramMessage.jdField_a_of_type_Qql.a.c) || (paramMessage.jdField_a_of_type_Qql.a.a == null));
                localObject1 = paramMessage.jdField_a_of_type_Qql.a.a.h;
              } while (qlp.a(this.a).contains(localObject1));
              qlp.a(this.a).add(localObject1);
              localObject1 = nmc.a(paramMessage.jdField_a_of_type_Qql.a.a);
              if (paramMessage.jdField_a_of_type_Qql.a.a(qlp.a(this.a)))
              {
                nmc.a(new nyd().a(qlp.a(this.a)).a(nmc.b).b(nmc.P).a((AdvertisementInfo)localObject1).a(paramMessage.jdField_a_of_type_Qql.a.a).a());
                return;
              }
              nmc.a(new nyd().a(qlp.a(this.a)).a(nmc.b).b(nmc.N).a((AdvertisementInfo)localObject1).a(paramMessage.jdField_a_of_type_Qql.a.a).a());
              return;
            } while ((qlp.a(this.a) == null) || (qlp.a(this.a) == null) || (!qlp.a(this.a).d()) || (!(qlp.a(this.a) instanceof qma)) || (oar.a((qma)qlp.a(this.a))));
            qlp.a(this.a, true, (qma)qlp.a(this.a));
            return;
          } while (!(qlp.a(this.a) instanceof qmp));
          qoi.a(((qmp)qlp.a(this.a)).jdField_a_of_type_Qjn.a(), 8, 600);
          return;
        } while (!(qlp.a(this.a) instanceof qma));
        localqma = (qma)qlp.a(this.a);
        localObject1 = localqma.d;
      } while (localObject1 == null);
      Object localObject2 = paramMessage.obj;
      paramMessage = localqma.jdField_a_of_type_Qql.a.a;
      localAdvertisementInfo = nmc.a(paramMessage);
      if (localObject2 != null)
      {
        qlp.b(this.a, true);
        if (localqma.k != null) {
          localqma.k.setVisibility(8);
        }
        qoi.a(localqma.o, 250, 8, Utils.dp2px(200.0D));
        qoi.a((View)localObject1, 250, 0, 250, ((View)localObject1).getMeasuredHeight());
        nmc.a(new nyd().a(qlp.a(this.a)).a(nmc.a).b(nmc.Y).a(localAdvertisementInfo).a(paramMessage).d(nmc.aM).a());
        return;
      }
    } while (qlp.b(this.a));
    qma localqma = (qma)qlp.a(this.a);
    localqma.r.setVisibility(8);
    localqma.m.setVisibility(0);
    localqma.b.setProgress(100);
    qoi.a((View)localObject1, 250, 8, ((View)localObject1).getMeasuredHeight());
    if (((qma)qlp.a(this.a)).k != null)
    {
      qlp.a(this.a, (qma)qlp.a(this.a));
      ((qma)qlp.a(this.a)).k.setVisibility(0);
    }
    qoi.a(((qma)qlp.a(this.a)).o, 250, 0, 250, Utils.dp2px(200.0D));
    if ((oaq.d(paramMessage)) && (qlp.a(this.a) != null)) {
      qlp.a(this.a).a();
    }
    nmc.a(new nyd().a(qlp.a(this.a)).a(nmc.b).b(nmc.Y).a(localAdvertisementInfo).a(paramMessage).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlr
 * JD-Core Version:    0.7.0.1
 */