import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.ad.common_ad_action.report_action.ReadInJoyAdReportUtils.1;
import com.tencent.biz.pubaccount.readinjoy.ad.common_ad_action.report_action.ReadInJoyAdReportUtils.2;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class olm
{
  private static omp a(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2)
  {
    Object localObject = (QQAppInterface)pha.a();
    localObject = new omp().a((AppInterface)localObject).a(BaseApplication.getContext()).a(paramInt2).b(paramInt1).a(paramAdvertisementInfo).d(nxw.a(paramAdvertisementInfo));
    if (paramAdvertisementInfo.mReportDataJson != null) {
      ((omp)localObject).c(paramAdvertisementInfo.mReportDataJson);
    }
    return localObject;
  }
  
  public static void a(boolean paramBoolean, Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    if ((paramBoolean) && (paramInt2 == nxw.a)) {
      paramInt1 = nxw.T;
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyAdReportUtils.1(paramAdvertisementInfo, paramInt2, paramInt3, paramContext, paramInt1));
      return;
    }
  }
  
  private static void b(Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = 4;
    int i = nxw.an;
    int j = paramAdvertisementInfo.clickPos;
    if (paramInt3 == 3) {
      paramInt1 = 2;
    }
    for (;;)
    {
      int k = olu.a(paramAdvertisementInfo);
      paramContext = olu.a(paramContext, paramAdvertisementInfo, paramInt2, j, olu.a(paramAdvertisementInfo.downloadState, false), paramInt1, k);
      omp localomp = a(paramAdvertisementInfo, i, paramInt2);
      localomp.e(paramContext);
      nxw.a(localomp.a());
      oqh.a("ReadInJoyAdReportUtils", "softAdReport: scene = " + paramInt3 + " advertisementInfo = " + paramAdvertisementInfo.toString());
      if (paramAdvertisementInfo.mAdvertisementSoftInfo == null)
      {
        return;
        if (paramInt3 == 4)
        {
          paramInt1 = 7;
          continue;
        }
        if ((paramInt3 == 5) && (paramAdvertisementInfo.mAdvertisementSoftInfo != null))
        {
          if (paramAdvertisementInfo.mAdvertisementSoftInfo.c)
          {
            if (paramAdvertisementInfo.mAdvertisementSoftInfo.d) {
              continue;
            }
            for (;;)
            {
              paramInt1 = 3;
            }
          }
          if (paramAdvertisementInfo.mAdvertisementSoftInfo.d) {}
          for (paramInt1 = 1;; paramInt1 = 0) {
            break;
          }
        }
      }
      else
      {
        localomp = null;
        if (paramInt2 == nxw.a)
        {
          paramContext = localomp;
          if (!paramAdvertisementInfo.mAdvertisementSoftInfo.a)
          {
            paramContext = paramAdvertisementInfo.mAdvertisementSoftInfo.I;
            paramAdvertisementInfo.mAdvertisementSoftInfo.a = true;
          }
        }
        for (;;)
        {
          ThreadManager.getSubThreadHandler().post(new ReadInJoyAdReportUtils.2(paramContext));
          return;
          paramContext = localomp;
          if (paramInt2 == nxw.b)
          {
            paramContext = localomp;
            if (!paramAdvertisementInfo.mAdvertisementSoftInfo.b)
            {
              paramContext = paramAdvertisementInfo.mAdvertisementSoftInfo.J;
              paramAdvertisementInfo.mAdvertisementSoftInfo.b = true;
            }
          }
        }
      }
      paramInt1 = 0;
    }
  }
  
  private static void c(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2)
  {
    long l1;
    long l2;
    label23:
    Object localObject2;
    if (paramInt1 == nxw.b)
    {
      l1 = 6L;
      if (!opz.b(paramAdvertisementInfo)) {
        break label132;
      }
      l2 = 3010304L;
      localObject2 = oll.a(opz.d(paramAdvertisementInfo), opz.b(paramAdvertisementInfo), paramAdvertisementInfo.downloadState);
      if (paramInt2 != 3) {
        break label140;
      }
    }
    label132:
    label140:
    for (Object localObject1 = "2";; localObject1 = "1")
    {
      localObject1 = oll.a(paramAdvertisementInfo, l2, l1, (String)localObject2, (String)localObject1);
      localObject2 = a(paramAdvertisementInfo, 39, 119);
      ((omp)localObject2).e((JSONObject)localObject1);
      nxw.a(((omp)localObject2).a());
      oqh.a("ReadInJoyAdReportUtils", "gameAdReport: scene = " + paramInt2 + " advertisementInfo = " + paramAdvertisementInfo.toString());
      return;
      l1 = 9L;
      break;
      l2 = 3010204L;
      break label23;
    }
  }
  
  private static void d(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2)
  {
    nxw.a(a(paramAdvertisementInfo, paramInt1, paramInt2).a());
    oqh.a("ReadInJoyAdReportUtils", "normalAdReport: advertisementInfo = " + paramAdvertisementInfo.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     olm
 * JD-Core Version:    0.7.0.1
 */