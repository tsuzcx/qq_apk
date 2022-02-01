import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class pqq
{
  public static int a()
  {
    return KandianVideoUploadService.a();
  }
  
  public static void a(int paramInt, List<blek> paramList)
  {
    blek localblek;
    if ((paramInt & 0x1) != 0)
    {
      localblek = new blek();
      localblek.jdField_a_of_type_Int = 0;
      localblek.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131717712);
      localblek.b = 2130842890;
      paramList.add(localblek);
    }
    if ((paramInt & 0x2) != 0)
    {
      localblek = new blek();
      localblek.jdField_a_of_type_Int = 1;
      localblek.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131717716);
      localblek.b = 2130842891;
      paramList.add(localblek);
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, View paramView)
  {
    StatisticCollector.getInstance(paramBaseActivity).collectPerformance(pnn.a(), "actReadInJoyDDShowPopupMenu", true, 0L, 0L, null, "");
    ArrayList localArrayList = new ArrayList();
    a(bmhv.m(pnn.a()), localArrayList);
    if (localArrayList.size() == 0) {
      a(31, localArrayList);
    }
    bleh.a(paramBaseActivity, localArrayList, new pqr(paramBaseActivity), new pqs(), AIOUtils.dp2px(125.0F, paramBaseActivity.getResources()), false, 2130842871, 2131755031).showAsDropDown(paramView);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", prp.jdField_a_of_type_Int);
      localJSONObject.put("releasetype", paramString2);
      localJSONObject.put("tab_source", paramString1);
      paramString1 = localJSONObject.toString();
      olh.a(null, "", "0X8008C5D", "0X8008C5D", 0, 0, "", "", "", paramString1, false);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        paramString1 = str;
        if (QLog.isColorLevel())
        {
          QLog.e("RIJUGCDianDian", 2, "secondClassDeliverOperationReport:" + paramString2.toString());
          paramString1 = str;
        }
      }
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (bmhv.m(pnn.a()) != 0) {
      bool = true;
    }
    return bool;
  }
  
  private static void b(Context paramContext)
  {
    c(paramContext);
    StatisticCollector.getInstance(paramContext).collectPerformance(pnn.a().getAccount(), "actReadInJoyDDShowVideoAS", true, 0L, 0L, null, "");
  }
  
  private static void c(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_from_dian_dian", true);
    oxf.a(paramContext, localBundle);
    ((Activity)paramContext).overridePendingTransition(2130772239, 2130772041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pqq
 * JD-Core Version:    0.7.0.1
 */