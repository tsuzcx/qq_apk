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

class pzv
  extends Handler
{
  pzv(pzs parampzs, Looper paramLooper)
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
                        pzs.a(this.a).sendEmptyMessageDelayed(0, 3000L);
                      } while (pzs.a(this.a) == null);
                      long l1 = pzs.a(this.a).jdField_a_of_type_Qhf.a();
                      long l2 = pzs.a(this.a).a();
                      if (l2 > l1) {
                        l1 = l2;
                      }
                      for (;;)
                      {
                        l1 = 3000L - (System.currentTimeMillis() - l1);
                        if (l1 <= 0L) {
                          break;
                        }
                        pzs.a(this.a).removeMessages(0);
                        pzs.a(this.a).sendEmptyMessageDelayed(0, l1);
                        return;
                      }
                    } while ((pzs.a(this.a) == null) || (pzs.a(this.a) == null) || (pzs.a(this.a).jdField_a_of_type_Pxs == null));
                    if (pzs.a(this.a).c())
                    {
                      pzs.a(this.a).jdField_a_of_type_Pxs.f(false);
                      return;
                    }
                    pzs.a(this.a).jdField_a_of_type_Pxs.b();
                    return;
                    if (pzs.a(this.a))
                    {
                      pzs.a(this.a).sendEmptyMessage(3);
                      pzs.a(this.a).sendEmptyMessageDelayed(2, 50L);
                    }
                    pzs.a(this.a).a();
                    return;
                    pzs.a(this.a).b();
                    return;
                    pzs.a(this.a, false);
                  } while (!(pzs.a(this.a) instanceof qaq));
                  paramMessage = (qaq)pzs.a(this.a);
                } while ((paramMessage.a == null) || (paramMessage.a.a == null) || (!paramMessage.a.a.c) || (paramMessage.a.a.a == null));
                localObject1 = paramMessage.a.a.a.h;
              } while (pzs.a(this.a).contains(localObject1));
              pzs.a(this.a).add(localObject1);
              localObject1 = nbe.a(paramMessage.a.a.a);
              if (paramMessage.a.a.a(pzs.a(this.a)))
              {
                nbe.a(new nmv().a(pzs.a(this.a)).a(nbe.b).b(nbe.P).a((AdvertisementInfo)localObject1).a(paramMessage.a.a.a).a());
                return;
              }
              nbe.a(new nmv().a(pzs.a(this.a)).a(nbe.b).b(nbe.N).a((AdvertisementInfo)localObject1).a(paramMessage.a.a.a).a());
              return;
            } while ((pzs.a(this.a) == null) || (pzs.a(this.a) == null) || (!pzs.a(this.a).c()) || (!(pzs.a(this.a) instanceof qab)) || (npj.a((qab)pzs.a(this.a))));
            pzs.a(this.a, true, (qab)pzs.a(this.a));
            return;
          } while (!(pzs.a(this.a) instanceof qaq));
          qcn.a(((qaq)pzs.a(this.a)).x, 8, 600);
          return;
        } while (!(pzs.a(this.a) instanceof qab));
        localqab = (qab)pzs.a(this.a);
        localObject1 = localqab.d;
      } while (localObject1 == null);
      Object localObject2 = paramMessage.obj;
      paramMessage = localqab.a.a.a;
      localAdvertisementInfo = nbe.a(paramMessage);
      if (localObject2 != null)
      {
        pzs.b(this.a, true);
        if (localqab.k != null) {
          localqab.k.setVisibility(8);
        }
        qcn.a(localqab.o, 250, 8, Utils.dp2px(200.0D));
        qcn.a((View)localObject1, 250, 0, 250, ((View)localObject1).getMeasuredHeight());
        nbe.a(new nmv().a(pzs.a(this.a)).a(nbe.a).b(nbe.Y).a(localAdvertisementInfo).a(paramMessage).d(nbe.aL).a());
        return;
      }
    } while (pzs.b(this.a));
    qab localqab = (qab)pzs.a(this.a);
    localqab.r.setVisibility(8);
    localqab.m.setVisibility(0);
    localqab.b.setProgress(100);
    qcn.a((View)localObject1, 250, 8, ((View)localObject1).getMeasuredHeight());
    if (((qab)pzs.a(this.a)).k != null)
    {
      pzs.a(this.a, (qab)pzs.a(this.a));
      ((qab)pzs.a(this.a)).k.setVisibility(0);
    }
    qcn.a(((qab)pzs.a(this.a)).o, 250, 0, 250, Utils.dp2px(200.0D));
    if ((npi.d(paramMessage)) && (pzs.a(this.a) != null)) {
      pzs.a(this.a).a();
    }
    nbe.a(new nmv().a(pzs.a(this.a)).a(nbe.b).b(nbe.Y).a(localAdvertisementInfo).a(paramMessage).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pzv
 * JD-Core Version:    0.7.0.1
 */