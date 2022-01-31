import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.SensorReport.2;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class mwa
{
  private static BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new mwb();
  static String jdField_a_of_type_JavaLangString = "actAVGSensorCaseReport";
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  ArrayList<mwc> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  mwc jdField_a_of_type_Mwc = null;
  int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString = "";
  int jdField_c_of_type_Int = 2;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int = 4;
  private long jdField_d_of_type_Long;
  int jdField_e_of_type_Int = 8;
  private long jdField_e_of_type_Long;
  int jdField_f_of_type_Int = 16;
  private long jdField_f_of_type_Long;
  int g = 32;
  int h = 0;
  final int i = 0;
  final int j = 1;
  final int k = 2;
  
  private void a(int paramInt, ArrayList<mwc> paramArrayList)
  {
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_e_of_type_Long == 0L)) {
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "report Ignore, mRoomID[" + this.jdField_e_of_type_Long + "], guid[" + this.jdField_c_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      return;
      Object localObject1 = "";
      if (paramArrayList.size() > 0) {}
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("size", paramArrayList.size());
        localObject2 = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          mwc localmwc = (mwc)paramArrayList.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("i", localmwc.jdField_a_of_type_Int);
          localJSONObject.put("off", localmwc.jdField_a_of_type_Long);
          localJSONObject.put("on", localmwc.jdField_b_of_type_Long);
          localJSONObject.put("why", localmwc.jdField_c_of_type_Long);
          ((JSONArray)localObject2).put(localJSONObject);
        }
      }
      catch (JSONException paramArrayList)
      {
        Object localObject2;
        for (localObject1 = "JSONException. ";; localObject1 = ((JSONObject)localObject1).toString())
        {
          paramArrayList = new HashMap();
          paramArrayList.put("guid", this.jdField_c_of_type_JavaLangString);
          paramArrayList.put("RoomID", String.valueOf(this.jdField_e_of_type_Long));
          paramArrayList.put("EnterRoomTime", String.valueOf(this.jdField_f_of_type_Long));
          paramArrayList.put("screenInfo", localObject1);
          paramArrayList.put("StartSensorTime", String.valueOf(this.jdField_a_of_type_Long));
          paramArrayList.put("EndSensorTime", String.valueOf(this.jdField_b_of_type_Long));
          paramArrayList.put("SetIgnore", String.valueOf(this.jdField_c_of_type_Long));
          paramArrayList.put("ClearIgnore", String.valueOf(this.jdField_d_of_type_Long));
          paramArrayList.put("reportType", String.valueOf(paramInt));
          paramArrayList.put("Log", this.jdField_b_of_type_JavaLangString);
          paramArrayList.put("ScreenInfoCount", String.valueOf(this.h));
          if (this.jdField_c_of_type_Long != 0L)
          {
            paramArrayList.put("sdkVersion", String.valueOf(Build.VERSION.SDK_INT));
            paramArrayList.put("devicesInfo", AppSetting.jdField_c_of_type_JavaLangString);
          }
          if (QLog.isDevelopLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 4, "mRoomID[" + this.jdField_e_of_type_Long + "], guid[" + this.jdField_c_of_type_JavaLangString + "], [" + (String)localObject1);
          }
          if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
            QLog.d(jdField_a_of_type_JavaLangString, 1, this.jdField_c_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString);
          }
          if (paramInt != 0) {
            break label634;
          }
          localObject1 = (VideoAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          if (localObject1 != null)
          {
            localObject2 = new Intent(jdField_a_of_type_JavaLangString);
            ((Intent)localObject2).putExtra("params", paramArrayList);
            ((Intent)localObject2).setPackage(((VideoAppInterface)localObject1).getApp().getPackageName());
            ((VideoAppInterface)localObject1).getApp().sendBroadcast((Intent)localObject2);
          }
          this.jdField_b_of_type_JavaLangString = "";
          this.jdField_a_of_type_Mwc = null;
          if (paramInt == 1) {
            break;
          }
          this.jdField_a_of_type_Long = 0L;
          this.jdField_b_of_type_Long = 0L;
          this.jdField_c_of_type_Long = 0L;
          this.jdField_d_of_type_Long = 0L;
          return;
          ((JSONObject)localObject1).put("infos", localObject2);
        }
      }
      catch (Exception paramArrayList)
      {
        for (;;)
        {
          localObject1 = "json_" + paramArrayList.getClass().getName() + ". ";
          continue;
          label634:
          UserAction.onUserAction(jdField_a_of_type_JavaLangString, true, -1L, -1L, paramArrayList, true);
        }
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    AudioHelper.a(paramContext);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction(jdField_a_of_type_JavaLangString);
    ThreadManager.post(new SensorReport.2(paramContext, localIntentFilter), 5, null, false);
  }
  
  public static void b(Context paramContext)
  {
    try
    {
      paramContext.unregisterReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SensorReport", 2, "unregistonUserActionReceiver e = " + paramContext);
    }
  }
  
  void a()
  {
    long l = System.currentTimeMillis();
    String str = UUID.randomUUID().toString();
    if (this.jdField_a_of_type_Long != 0L)
    {
      this.jdField_b_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + "[" + this.jdField_c_of_type_JavaLangString + "->" + str + "]begin had came[" + this.jdField_a_of_type_Long + "->" + l + "]");
      if (this.jdField_b_of_type_Long == 0L) {
        this.jdField_b_of_type_Long = l;
      }
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      a(2, localArrayList);
    }
    this.jdField_a_of_type_Long = l;
    this.jdField_c_of_type_JavaLangString = str;
  }
  
  void a(VideoController paramVideoController)
  {
    if (paramVideoController != null)
    {
      this.jdField_e_of_type_Long = paramVideoController.f();
      if (this.jdField_e_of_type_Long != 0L)
      {
        int m = paramVideoController.a().jdField_d_of_type_Int;
        if ((m == 3) || (m == 4)) {
          this.jdField_f_of_type_Long = paramVideoController.e();
        }
        if (QLog.isDevelopLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 4, "setRoomID[" + this.jdField_e_of_type_Long + "], EnterRoomTime[" + this.jdField_f_of_type_Long);
        }
      }
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, boolean paramBoolean4, VideoController paramVideoController)
  {
    if (this.jdField_e_of_type_Long == 0L) {
      a(paramVideoController);
    }
    int n = this.jdField_a_of_type_Int;
    int m = n;
    if (!paramBoolean1) {
      m = n | this.jdField_d_of_type_Int;
    }
    n = m;
    if (!paramBoolean2) {
      n = m | this.jdField_e_of_type_Int;
    }
    m = n;
    if (paramBoolean3) {
      m = n | this.jdField_b_of_type_Int;
    }
    n = m;
    if (paramInt == 3) {
      n = m | this.jdField_c_of_type_Int;
    }
    m = n;
    if (paramInt == 1) {
      m = n | this.jdField_f_of_type_Int;
    }
    paramInt = m;
    if (paramBoolean4) {
      paramInt = m | this.g;
    }
    long l = System.currentTimeMillis();
    paramVideoController = this.jdField_a_of_type_Mwc;
    this.jdField_a_of_type_Mwc = null;
    if (paramVideoController != null)
    {
      paramVideoController.jdField_b_of_type_Long = l;
      paramVideoController.jdField_c_of_type_Long = paramInt;
    }
    for (;;)
    {
      if ((!paramBoolean4) && (this.jdField_a_of_type_JavaUtilArrayList.size() >= 6))
      {
        paramVideoController = this.jdField_a_of_type_JavaUtilArrayList;
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        a(1, paramVideoController);
      }
      return;
      this.jdField_b_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + "setScreenOn_LastScreenInfo_null[" + l + "], why[" + paramInt + "]。");
    }
  }
  
  void b()
  {
    if (this.jdField_b_of_type_Long != 0L) {
      this.jdField_b_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + "end_came[" + this.jdField_b_of_type_Long + "]。");
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    a(0, localArrayList);
  }
  
  void c()
  {
    this.jdField_a_of_type_Mwc = new mwc(this);
    this.jdField_a_of_type_Mwc.jdField_a_of_type_Int = this.h;
    this.h += 1;
    this.jdField_a_of_type_Mwc.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Mwc);
  }
  
  void d()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_c_of_type_Long != 0L) {
      this.jdField_b_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + "setIgnore[" + this.jdField_c_of_type_Long + "->" + l + "]。");
    }
    this.jdField_c_of_type_Long = l;
  }
  
  void e()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_d_of_type_Long != 0L) {
      this.jdField_b_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + "clearIgnoreFlag[" + this.jdField_d_of_type_Long + "->" + l + "]。");
    }
    this.jdField_d_of_type_Long = l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mwa
 * JD-Core Version:    0.7.0.1
 */