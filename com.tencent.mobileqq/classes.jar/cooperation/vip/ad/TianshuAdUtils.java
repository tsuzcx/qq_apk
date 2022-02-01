package cooperation.vip.ad;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.List;

public class TianshuAdUtils
{
  public static List<TianShuAdPosItemData> a()
  {
    ArrayList localArrayList = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.b = 1;
    localTianShuAdPosItemData.jdField_a_of_type_Int = 339;
    localArrayList.add(localTianShuAdPosItemData);
    localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.b = 1;
    localTianShuAdPosItemData.jdField_a_of_type_Int = 340;
    localArrayList.add(localTianShuAdPosItemData);
    localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.b = 1;
    localTianShuAdPosItemData.jdField_a_of_type_Int = 341;
    localArrayList.add(localTianShuAdPosItemData);
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    TianShuReportData localTianShuReportData = new TianShuReportData();
    long l = System.currentTimeMillis() / 1000L;
    localTianShuReportData.b = (String.valueOf(paramQQAppInterface.getCurrentAccountUin()) + '_' + l);
    localTianShuReportData.d = paramInt;
    localTianShuReportData.jdField_e_of_type_Int = 1;
    localTianShuReportData.g = String.valueOf(paramString1);
    localTianShuReportData.jdField_a_of_type_Long = l;
    localTianShuReportData.jdField_a_of_type_Int = 1;
    localTianShuReportData.jdField_e_of_type_JavaLangString = "tianshu.31";
    localTianShuReportData.i = "";
    localTianShuReportData.l = paramString2;
    TianShuManager.getInstance().report(localTianShuReportData);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("TianshuAdUtils", 2, "url empty");
    }
    do
    {
      return;
      IMiniAppService localIMiniAppService = (IMiniAppService)QRoute.api(IMiniAppService.class);
      if (localIMiniAppService.isMiniAppUrl(paramString))
      {
        localIMiniAppService.startMiniApp(paramContext, paramString, paramInt, null);
        return;
      }
      if ((!paramString.startsWith("mqqapi://")) || (paramQQAppInterface == null)) {
        break;
      }
      paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramContext, paramString);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a();
    return;
    paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
    paramQQAppInterface.putExtra("url", paramString);
    paramContext.startActivity(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.ad.TianshuAdUtils
 * JD-Core Version:    0.7.0.1
 */