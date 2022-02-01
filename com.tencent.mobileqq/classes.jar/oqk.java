import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class oqk
{
  public static int a(@NonNull AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    switch (paramAdData.jdField_t_of_type_Int)
    {
    default: 
      return 0;
    }
    if (!TextUtils.isEmpty(paramAdData.jdField_l_of_type_JavaLangString)) {
      paramAdvertisementInfo.mSinglePicture = tyc.a(paramAdData.jdField_l_of_type_JavaLangString, 4);
    }
    return 2;
  }
  
  public static AdvertisementInfo a(AdData paramAdData)
  {
    oqh.a("ReadInJoyBottomAdVideoUtil", "start : " + System.currentTimeMillis());
    if (paramAdData == null) {
      return null;
    }
    if (paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      return paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    }
    AdvertisementInfo localAdvertisementInfo = new AdvertisementInfo();
    localAdvertisementInfo.mAdAdvertiseId = paramAdData.jdField_e_of_type_Int;
    localAdvertisementInfo.mAdVideoUrl = paramAdData.w;
    localAdvertisementInfo.mAdAid = paramAdData.jdField_b_of_type_Long;
    localAdvertisementInfo.mAdTraceId = paramAdData.u;
    localAdvertisementInfo.mAdViewId = paramAdData.jdField_t_of_type_JavaLangString;
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
    localAdvertisementInfo.mOrigin = nxw.M;
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
    if (paramAdData.jdField_a_of_type_Omi != null) {
      localAdvertisementInfo.mAdBtnTxt = paramAdData.jdField_a_of_type_Omi.jdField_l_of_type_JavaLangString;
    }
    try
    {
      localAdvertisementInfo.mArticleID = Long.parseLong(paramAdData.M);
      a(localAdvertisementInfo, paramAdData);
      b(localAdvertisementInfo, paramAdData);
      c(localAdvertisementInfo, paramAdData);
      d(localAdvertisementInfo, paramAdData);
      if (!TextUtils.isEmpty(paramAdData.j)) {
        localAdvertisementInfo.mTitle = paramAdData.j;
      }
      localAdvertisementInfo.mAdvertisementExtInfo = new omq(localAdvertisementInfo.mAdExtInfo);
      localAdvertisementInfo.mAdLocalSource = a(paramAdData, localAdvertisementInfo);
      if (!TextUtils.isEmpty(paramAdData.I))
      {
        localAdvertisementInfo.mAdCorporateImageName = paramAdData.I;
        localAdvertisementInfo.mAdCorporateLogo = paramAdData.J;
        localAdvertisementInfo.mSubordinateProductId = paramAdData.H;
        localAdvertisementInfo.mPopFormH5Url = paramAdData.K;
        localAdvertisementInfo.mShowAdButton = paramAdData.jdField_e_of_type_Boolean;
        localAdvertisementInfo.mAdJumpMode = paramAdData.jdField_o_of_type_Int;
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if (!TextUtils.isEmpty(paramAdData.i)) {
            localAdvertisementInfo.mAdPosID = Long.valueOf(paramAdData.i).longValue();
          }
          label449:
          if (paramAdData.jdField_b_of_type_OrgJsonJSONObject != null)
          {
            localAdvertisementInfo.processSoftDataInfo(paramAdData.jdField_b_of_type_OrgJsonJSONObject);
            if ((localAdvertisementInfo.mAdvertisementSoftInfo != null) && (!TextUtils.isEmpty(localAdvertisementInfo.mAdvertisementSoftInfo.jdField_a_of_type_JavaLangString)))
            {
              localAdvertisementInfo.mSoftAdType = 2;
              if (!TextUtils.isEmpty(localAdvertisementInfo.mAdvertisementSoftInfo.D)) {
                localAdvertisementInfo.mAdBtnTxt = localAdvertisementInfo.mAdvertisementSoftInfo.D;
              }
              if (localAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1) {
                localAdvertisementInfo.mAdProductType = 12;
              }
            }
          }
          oqh.a("ReadInJoyBottomAdVideoUtil", "end : " + System.currentTimeMillis());
          return localAdvertisementInfo;
          localException1 = localException1;
          oqh.a("ReadInJoyBottomAdVideoUtil", "parse article_id error :" + localException1.getMessage());
        }
        localAdvertisementInfo.mAdCorporateImageName = paramAdData.q;
      }
      catch (Exception localException2)
      {
        break label449;
      }
    }
  }
  
  private static void a(VideoInfo.GameAdComData paramGameAdComData, omi paramomi)
  {
    String str;
    Object localObject;
    if ((paramomi != null) && (paramGameAdComData != null))
    {
      paramGameAdComData.b = String.valueOf(paramomi.jdField_a_of_type_Int);
      paramGameAdComData.s = paramomi.x;
      paramGameAdComData.d = paramomi.b;
      paramGameAdComData.c = paramomi.jdField_a_of_type_JavaLangString;
      paramGameAdComData.e = paramomi.c;
      paramGameAdComData.f = paramomi.d;
      paramGameAdComData.g = paramomi.e;
      paramGameAdComData.j = paramomi.k;
      paramGameAdComData.k = paramomi.f;
      paramGameAdComData.jdField_l_of_type_JavaLangString = paramomi.r;
      paramGameAdComData.jdField_m_of_type_JavaLangString = paramomi.q;
      paramGameAdComData.n = paramomi.h;
      paramGameAdComData.jdField_o_of_type_JavaLangString = paramomi.i;
      paramGameAdComData.p = paramomi.jdField_m_of_type_JavaLangString;
      paramGameAdComData.q = paramomi.n;
      paramGameAdComData.r = paramomi.g;
      paramGameAdComData.v = paramomi.jdField_l_of_type_JavaLangString;
      paramGameAdComData.y = paramomi.s;
      paramGameAdComData.x = paramomi.jdField_t_of_type_JavaLangString;
      paramGameAdComData.z = paramomi.u;
      paramGameAdComData.A = paramomi.v;
      paramGameAdComData.w = paramomi.w;
      if (paramomi.jdField_a_of_type_Omk != null)
      {
        str = paramGameAdComData.u;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      ((JSONObject)localObject).put("sActivityId", paramomi.jdField_a_of_type_Omk.b);
      ((JSONObject)localObject).put("sGiftName", paramomi.jdField_a_of_type_Omk.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("sNeedRole", paramomi.jdField_a_of_type_Omk.h);
      ((JSONObject)localObject).put("iGiftId", paramomi.jdField_a_of_type_Omk.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("gift_icon", paramomi.jdField_a_of_type_Omk.c);
      ((JSONObject)localObject).put("gift_desc", paramomi.jdField_a_of_type_Omk.g);
      ((JSONObject)localObject).put("bag_item_icon_1", paramomi.jdField_a_of_type_Omk.d);
      ((JSONObject)localObject).put("bag_item_icon_2", paramomi.jdField_a_of_type_Omk.e);
      ((JSONObject)localObject).put("bag_item_icon_3", paramomi.jdField_a_of_type_Omk.f);
      paramGameAdComData.u = ((JSONObject)localObject).toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          str = paramGameAdComData.jdField_t_of_type_JavaLangString;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localObject = new JSONObject((String)localObject);
          ((JSONObject)localObject).put("sGameDownloadUrl", paramomi.p);
          ((JSONObject)localObject).put("lGameSize", paramomi.q);
          paramGameAdComData.jdField_t_of_type_JavaLangString = ((JSONObject)localObject).toString();
          return;
        }
        catch (Exception paramGameAdComData)
        {
          oqh.a("parse download info", paramGameAdComData.getMessage());
        }
        localException = localException;
        oqh.a("parse gift info", localException.getMessage());
      }
    }
  }
  
  private static void a(AdvertisementInfo paramAdvertisementInfo, AdData paramAdData)
  {
    try
    {
      String str = paramAdData.T;
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localObject = new JSONObject((String)localObject);
      ((JSONObject)localObject).put("pkgurl", paramAdData.E);
      ((JSONObject)localObject).put("appname", paramAdData.q);
      ((JSONObject)localObject).put("pkg_name", paramAdData.D);
      paramAdvertisementInfo.mAdExt = ((JSONObject)localObject).toString();
      return;
    }
    catch (Exception paramAdvertisementInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadInJoyBottomAdVideoUtil", 2, "adData.mAdExt error:" + paramAdvertisementInfo.getMessage());
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
  
  private static void b(AdvertisementInfo paramAdvertisementInfo, AdData paramAdData)
  {
    if (!TextUtils.isEmpty(paramAdData.U))
    {
      paramAdvertisementInfo.mAdExtInfo = paramAdData.U;
      try
      {
        localJSONObject = new JSONObject(paramAdData.U);
        localJSONObject.put("AdSource", paramAdData.p);
        if (opz.e(paramAdData)) {
          localJSONObject.put("game_button_type", 2);
        }
        for (;;)
        {
          if (paramAdData.jdField_a_of_type_Omi != null)
          {
            localJSONObject.put("game_pkg_name", paramAdData.jdField_a_of_type_Omi.b);
            localJSONObject.put("game_adtag", paramAdData.jdField_a_of_type_Omi.jdField_o_of_type_JavaLangString);
            localJSONObject.put("game_app_id", paramAdData.jdField_a_of_type_Omi.e);
            localJSONObject.put("game_app_name", paramAdData.jdField_a_of_type_Omi.jdField_a_of_type_JavaLangString);
            localJSONObject.put("game_apk_url", paramAdData.jdField_a_of_type_Omi.p);
          }
          paramAdvertisementInfo.mAdExtInfo = localJSONObject.toString();
          return;
          if (!opz.c(paramAdData)) {
            break;
          }
          localJSONObject.put("game_button_type", 3);
        }
      }
      catch (Exception paramAdvertisementInfo)
      {
        JSONObject localJSONObject;
        while (QLog.isColorLevel())
        {
          QLog.e("ReadInJoyBottomAdVideoUtil", 2, "adData.mAdExtInfo error:" + paramAdvertisementInfo.getMessage());
          return;
          if (opz.d(paramAdData)) {
            localJSONObject.put("game_button_type", 1);
          } else if (opz.f(paramAdData)) {
            localJSONObject.put("game_button_type", 4);
          }
        }
      }
    }
  }
  
  private static void c(AdvertisementInfo paramAdvertisementInfo, AdData paramAdData)
  {
    Object localObject;
    if (opz.a(paramAdData))
    {
      String str = paramAdvertisementInfo.mAdExt;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      localObject = new VideoInfo.GameAdComData(paramAdData.N, (JSONObject)localObject);
      a((VideoInfo.GameAdComData)localObject, paramAdData.jdField_a_of_type_Omi);
      paramAdvertisementInfo.gameAdComData = ((VideoInfo.GameAdComData)localObject);
      paramAdvertisementInfo.mSoftAdType = 1;
      if (paramAdvertisementInfo.gameAdComData.s.equals("2")) {
        paramAdvertisementInfo.mAdProductType = 12;
      }
      return;
    }
    catch (Exception paramAdvertisementInfo) {}
  }
  
  private static void d(AdvertisementInfo paramAdvertisementInfo, AdData paramAdData)
  {
    paramAdvertisementInfo.mBusiJson = new JSONObject();
    try
    {
      paramAdvertisementInfo.mBusiJson.put("article_id", paramAdData.M);
      paramAdvertisementInfo.mBusiJson.put("rowkey", paramAdData.N);
      if ((!TextUtils.isEmpty(paramAdData.O)) && (!paramAdData.O.contains("%"))) {
        paramAdvertisementInfo.mBusiJson.put("tags", paramAdData.O);
      }
      if (opz.a(paramAdData))
      {
        paramAdvertisementInfo.mBusiJson.put("game_component_type", paramAdData.jdField_a_of_type_Omi.x);
        paramAdvertisementInfo.mBusiJson.put("game_pkg", paramAdData.jdField_a_of_type_Omi.b);
      }
      if (paramAdData.jdField_a_of_type_OrgJsonJSONObject != null) {
        paramAdvertisementInfo.mBusiJson.put("article_ad_ext", paramAdData.jdField_a_of_type_OrgJsonJSONObject.toString());
      }
      return;
    }
    catch (Exception paramAdvertisementInfo)
    {
      oqh.a("fillBusiJson", paramAdvertisementInfo.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqk
 * JD-Core Version:    0.7.0.1
 */