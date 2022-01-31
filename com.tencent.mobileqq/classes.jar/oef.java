import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class oef
{
  public static int a(@NonNull AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    switch (paramAdData.s)
    {
    default: 
      return 0;
    }
    if (!TextUtils.isEmpty(paramAdData.jdField_l_of_type_JavaLangString)) {
      paramAdvertisementInfo.mSinglePicture = swu.a(paramAdData.jdField_l_of_type_JavaLangString, 4);
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
      localAdvertisementInfo.mAdAid = paramAdData.jdField_b_of_type_Long;
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
      localAdvertisementInfo.mOrigin = noy.K;
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
        if (!odv.d(paramAdData)) {}
      }
      catch (Exception localException3)
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
        catch (Exception localException3)
        {
          try
          {
            localObject = new JSONObject(paramAdData.U);
            ((JSONObject)localObject).put("AdSource", paramAdData.jdField_o_of_type_Int);
            localAdvertisementInfo.mAdExtInfo = ((JSONObject)localObject).toString();
            if (!TextUtils.isEmpty(paramAdData.j)) {
              localAdvertisementInfo.mTitle = paramAdData.j;
            }
            localAdvertisementInfo.mAdvertisementExtInfo = new obl(localAdvertisementInfo.mAdExtInfo);
            localAdvertisementInfo.mAdLocalSource = a(paramAdData, localAdvertisementInfo);
            if (!TextUtils.isEmpty(paramAdData.I))
            {
              localAdvertisementInfo.mAdCorporateImageName = paramAdData.I;
              localAdvertisementInfo.mAdCorporateLogo = paramAdData.J;
              localAdvertisementInfo.mSubordinateProductId = paramAdData.H;
              localAdvertisementInfo.mPopFormH5Url = paramAdData.K;
              localAdvertisementInfo.mShowAdButton = paramAdData.jdField_d_of_type_Boolean;
              localAdvertisementInfo.mAdJumpMode = paramAdData.n;
            }
          }
          catch (Exception localException3)
          {
            try
            {
              for (;;)
              {
                if (!TextUtils.isEmpty(paramAdData.i)) {
                  localAdvertisementInfo.mAdPosID = Long.valueOf(paramAdData.i).longValue();
                }
                label537:
                localObject = localAdvertisementInfo;
                if (paramAdData.jdField_b_of_type_OrgJsonJSONObject == null) {
                  break;
                }
                localAdvertisementInfo.processSoftDataInfo(paramAdData.jdField_b_of_type_OrgJsonJSONObject);
                return localAdvertisementInfo;
                localException1 = localException1;
                if (QLog.isColorLevel())
                {
                  QLog.e("ReadInJoyBottomAdVideoUtil", 2, "adVideData.mAdExt error:" + localException1.getMessage());
                  continue;
                  localException2 = localException2;
                  localException2.printStackTrace();
                  continue;
                  localException3 = localException3;
                  if (QLog.isColorLevel()) {
                    QLog.e("ReadInJoyBottomAdVideoUtil", 2, "adVideData.mAdExtInfo error:" + localException3.getMessage());
                  }
                }
              }
              localAdvertisementInfo.mAdCorporateImageName = paramAdData.q;
            }
            catch (Exception localException4)
            {
              break label537;
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
    QQAppInterface localQQAppInterface = (QQAppInterface)ors.a();
    if (localQQAppInterface != null) {
      noy.a(localQQAppInterface, paramAdData, paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oef
 * JD-Core Version:    0.7.0.1
 */