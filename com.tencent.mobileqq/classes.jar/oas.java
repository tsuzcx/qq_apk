import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class oas
{
  public static int a(@NonNull AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    switch (paramAdData.p)
    {
    default: 
      return 0;
    }
    if (!TextUtils.isEmpty(paramAdData.jdField_l_of_type_JavaLangString)) {
      paramAdvertisementInfo.mSinglePicture = sfa.a(paramAdData.jdField_l_of_type_JavaLangString, 4);
    }
    return 2;
  }
  
  public static AdvertisementInfo a(AdData paramAdData)
  {
    Object localObject;
    if (paramAdData == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      AdvertisementInfo localAdvertisementInfo = new AdvertisementInfo();
      localAdvertisementInfo.mAdAdvertiseId = paramAdData.jdField_e_of_type_Int;
      localAdvertisementInfo.mAdVideoUrl = paramAdData.w;
      localAdvertisementInfo.mAdAid = paramAdData.b;
      localAdvertisementInfo.mAdTraceId = paramAdData.u;
      localAdvertisementInfo.mAdViewId = paramAdData.t;
      localAdvertisementInfo.mAdProductId = paramAdData.z;
      localAdvertisementInfo.mAdVia = paramAdData.A;
      localAdvertisementInfo.mAdNocoId = paramAdData.jdField_d_of_type_Long;
      localAdvertisementInfo.mAdApurl = paramAdData.jdField_o_of_type_JavaLangString;
      localAdvertisementInfo.mAdRl = paramAdData.jdField_m_of_type_JavaLangString;
      localAdvertisementInfo.mAdEffectUrl = paramAdData.x;
      localAdvertisementInfo.mAdLandingPageReportUrl = paramAdData.y;
      localAdvertisementInfo.mAdLandingPage = paramAdData.B;
      localAdvertisementInfo.mAdCanvasJson = paramAdData.C;
      localAdvertisementInfo.mAdDestType = paramAdData.jdField_f_of_type_Int;
      localAdvertisementInfo.mOrigin = nmc.K;
      try
      {
        String str = paramAdData.T;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localObject = new JSONObject((String)localObject);
        ((JSONObject)localObject).put("pkgurl", paramAdData.E);
        ((JSONObject)localObject).put("appname", paramAdData.q);
        ((JSONObject)localObject).put("pkg_name", paramAdData.D);
        localAdvertisementInfo.mAdExt = ((JSONObject)localObject).toString();
        localAdvertisementInfo.mAdAppDownLoadSchema = paramAdData.F;
        localAdvertisementInfo.mAdCustomizedInvokeUrl = paramAdData.G;
        localAdvertisementInfo.mChannelID = 2L;
        localAdvertisementInfo.mAdProductType = paramAdData.jdField_d_of_type_Int;
        localAdvertisementInfo.mADVideoAutoPlay = paramAdData.g;
        localAdvertisementInfo.mAlgorithmID = paramAdData.jdField_e_of_type_Long;
        localAdvertisementInfo.mAlgorithmGroup = paramAdData.jdField_f_of_type_Long;
        localAdvertisementInfo.mC2SSwitch = paramAdData.h;
        localAdvertisementInfo.mC2SClickUrl = paramAdData.c;
        localAdvertisementInfo.mC2SExposureUrl = paramAdData.jdField_d_of_type_JavaUtilArrayList;
        localAdvertisementInfo.miniProgramType = paramAdData.jdField_l_of_type_Int;
        localAdvertisementInfo.mPhoneComponetId = paramAdData.jdField_m_of_type_Int;
        if (!oai.d(paramAdData)) {}
      }
      catch (Exception localException2)
      {
        try
        {
          localObject = new JSONObject();
          if (!TextUtils.isEmpty(paramAdData.U)) {
            localObject = new JSONObject(paramAdData.U);
          }
          ((JSONObject)localObject).put("game_pkg_name", paramAdData.a.b);
          paramAdData.U = ((JSONObject)localObject).toString();
          if (!TextUtils.isEmpty(paramAdData.U)) {
            localAdvertisementInfo.mAdExtInfo = paramAdData.U;
          }
        }
        catch (Exception localException2)
        {
          try
          {
            for (;;)
            {
              for (;;)
              {
                localObject = new JSONObject(paramAdData.U);
                ((JSONObject)localObject).put("AdSource", paramAdData.jdField_o_of_type_Int);
                localAdvertisementInfo.mAdExtInfo = ((JSONObject)localObject).toString();
                if (!TextUtils.isEmpty(paramAdData.j)) {
                  localAdvertisementInfo.mTitle = paramAdData.j;
                }
                localAdvertisementInfo.mAdvertisementExtInfo = new nye(localAdvertisementInfo.mAdExtInfo);
                localAdvertisementInfo.mAdLocalSource = a(paramAdData, localAdvertisementInfo);
                if (TextUtils.isEmpty(paramAdData.I)) {
                  break label632;
                }
                localAdvertisementInfo.mAdCorporateImageName = paramAdData.I;
                localAdvertisementInfo.mAdCorporateLogo = paramAdData.J;
                localAdvertisementInfo.mSubordinateProductId = paramAdData.H;
                localAdvertisementInfo.mPopFormH5Url = paramAdData.K;
                localAdvertisementInfo.mShowAdButton = paramAdData.jdField_d_of_type_Boolean;
                localAdvertisementInfo.mAdJumpMode = paramAdData.n;
                localObject = localAdvertisementInfo;
                try
                {
                  if (TextUtils.isEmpty(paramAdData.i)) {
                    break;
                  }
                  localAdvertisementInfo.mAdPosID = Long.valueOf(paramAdData.i).longValue();
                  return localAdvertisementInfo;
                }
                catch (Exception paramAdData)
                {
                  return localAdvertisementInfo;
                }
              }
              localException1 = localException1;
              if (QLog.isColorLevel()) {
                QLog.e("ReadInJoyBottomAdVideoUtil", 2, "adVideData.mAdExt error:" + localException1.getMessage());
              }
            }
            localException2 = localException2;
            localException2.printStackTrace();
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              if (QLog.isColorLevel())
              {
                QLog.e("ReadInJoyBottomAdVideoUtil", 2, "adVideData.mAdExtInfo error:" + localException3.getMessage());
                continue;
                label632:
                localAdvertisementInfo.mAdCorporateImageName = paramAdData.q;
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(AdData paramAdData)
  {
    a(paramAdData, 0);
  }
  
  public static void a(AdData paramAdData, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)onh.a();
    if (localQQAppInterface != null) {
      nmc.a(localQQAppInterface, paramAdData, paramInt);
    }
  }
  
  public static boolean a(View paramView)
  {
    if (paramView == null) {}
    double d;
    do
    {
      return false;
      int i = paramView.getHeight();
      Rect localRect = new Rect();
      paramView.getLocalVisibleRect(localRect);
      d = localRect.height() * 1.0F / i;
    } while ((d < 0.5D) || (d <= 0.800000011920929D));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oas
 * JD-Core Version:    0.7.0.1
 */