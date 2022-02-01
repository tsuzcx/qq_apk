import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.so.ResInfo;
import com.tencent.avgame.util.AVGameStep;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class nqc
{
  private static nqc jdField_a_of_type_Nqc;
  private static boolean jdField_a_of_type_Boolean = true;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "param_StepEntrance", "param_StepLoading", "param_StepPrepareGame", "param_StepGameReady", "param_StepGameCanStart" };
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "param_StepEntrance", "param_StepLoading", "param_StepPrepareGame", "param_StepSecure", "param_StepResource", "param_StepRoomProto", "param_StepAvAlive" };
  private volatile String jdField_a_of_type_JavaLangString;
  private final ConcurrentHashMap<String, AVGameStep> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
  private volatile String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  
  private AVGameStep a(String paramString)
  {
    AVGameStep localAVGameStep = null;
    if (!TextUtils.isEmpty(paramString)) {
      localAVGameStep = (AVGameStep)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return localAVGameStep;
  }
  
  public static nqc a()
  {
    if (jdField_a_of_type_Nqc == null) {}
    try
    {
      if (jdField_a_of_type_Nqc == null) {
        jdField_a_of_type_Nqc = new nqc();
      }
      return jdField_a_of_type_Nqc;
    }
    finally {}
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT >= 16) {
      bool = lfm.a().d();
    }
    return bool;
  }
  
  private AVGameStep b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    AVGameStep localAVGameStep = new AVGameStep(paramString);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localAVGameStep);
    return localAVGameStep;
  }
  
  public String a()
  {
    int j = 1;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return this.jdField_a_of_type_JavaLangString;
    }
    str3 = "";
    Object localObject = mal.a().a("AVGameVoiceRecogModel");
    String str1 = str3;
    if (localObject != null) {
      localObject = ((ResInfo)localObject).resZipUrl;
    }
    for (;;)
    {
      try
      {
        int k = ((String)localObject).lastIndexOf(File.separator);
        if (k < 0) {
          continue;
        }
        i = 1;
        if (k >= ((String)localObject).length() - 1) {
          continue;
        }
        str1 = str3;
        if ((j & i) != 0) {
          str1 = ((String)localObject).substring(k + 1);
        }
      }
      catch (Exception localException)
      {
        int i;
        localException.printStackTrace();
        String str2 = str3;
        continue;
      }
      this.jdField_a_of_type_JavaLangString = str1;
      return str1;
      i = 0;
      continue;
      j = 0;
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("AVGamePerfReporter", 2, "exit, report[" + this.jdField_b_of_type_Boolean + "], from[" + paramInt + "]");
    }
    AVGameStep localAVGameStep;
    if (!this.jdField_b_of_type_Boolean)
    {
      if (paramInt != 1) {
        break label171;
      }
      localAVGameStep = a("param_StepGameCanStart");
      if ((localAVGameStep == null) || (!localAVGameStep.b())) {
        break label140;
      }
      bool = true;
    }
    for (;;)
    {
      if (bool)
      {
        b(1);
        label91:
        if (QLog.isColorLevel()) {
          QLog.i("AVGamePerfReporter", 2, "exit, isReady[" + bool + "]");
        }
      }
      label140:
      label171:
      do
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        this.jdField_b_of_type_Boolean = false;
        return;
        localAVGameStep = a("param_StepGameReady");
        if ((localAVGameStep == null) || (!localAVGameStep.b())) {
          break label254;
        }
        bool = true;
        break;
        b(2);
        break label91;
      } while (paramInt != 2);
      localAVGameStep = a("param_StepLoading");
      if ((localAVGameStep != null) && (localAVGameStep.b())) {
        bool = false;
      }
      for (;;)
      {
        if (bool) {
          b(3);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("AVGamePerfReporter", 2, "exit, needReport[" + bool + "]");
        break;
        a("param_StepLoading", 0);
      }
      label254:
      bool = false;
    }
  }
  
  public void a(Intent paramIntent)
  {
    if ((paramIntent == null) || (this.jdField_b_of_type_Boolean)) {
      if (QLog.isColorLevel()) {
        QLog.i("AVGamePerfReporter", 2, "getStepInfoFromIntent, report[" + this.jdField_b_of_type_Boolean + "], intent[" + paramIntent + "]");
      }
    }
    for (;;)
    {
      return;
      String[] arrayOfString = jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        AVGameStep localAVGameStep1 = a(str);
        AVGameStep localAVGameStep2 = (AVGameStep)paramIntent.getParcelableExtra(str);
        if ((localAVGameStep2 != null) && ((localAVGameStep1 == null) || (!localAVGameStep1.a()) || ((localAVGameStep2.b()) && (!localAVGameStep1.b()))))
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localAVGameStep2);
          if (QLog.isColorLevel()) {
            QLog.i("AVGamePerfReporter", 2, "getStepInfoFromIntent, pre[" + localAVGameStep1 + "], cur[" + localAVGameStep2 + "]");
          }
        }
        i += 1;
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_b_of_type_Boolean)) {
      if (QLog.isColorLevel()) {
        QLog.i("AVGamePerfReporter", 2, "stepStart, report[" + this.jdField_b_of_type_Boolean + "], name[" + paramString + "]");
      }
    }
    for (;;)
    {
      return;
      boolean bool = false;
      AVGameStep localAVGameStep2 = a(paramString);
      AVGameStep localAVGameStep1 = localAVGameStep2;
      if (localAVGameStep2 == null) {
        localAVGameStep1 = b(paramString);
      }
      if ((localAVGameStep1 != null) && (localAVGameStep1.jdField_a_of_type_Long == 0L)) {
        localAVGameStep1.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      while (QLog.isColorLevel())
      {
        QLog.i("AVGamePerfReporter", 2, "stepStart, name[" + paramString + "], isRepeatStep[" + bool + "], step[" + localAVGameStep1 + "]");
        return;
        bool = true;
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    long l1 = 0L;
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_b_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AVGamePerfReporter", 2, "stepEnd, report[" + this.jdField_b_of_type_Boolean + "], name[" + paramString + "]");
      }
      return;
    }
    boolean bool1 = false;
    boolean bool2 = false;
    long l2 = System.currentTimeMillis();
    AVGameStep localAVGameStep = a(paramString);
    if (localAVGameStep != null)
    {
      if (localAVGameStep.b != 0L) {
        break label206;
      }
      localAVGameStep.b = l2;
    }
    label206:
    for (bool1 = bool2;; bool1 = true)
    {
      l1 = Math.abs(localAVGameStep.b - localAVGameStep.jdField_a_of_type_Long);
      localAVGameStep.jdField_a_of_type_Int = paramInt;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("AVGamePerfReporter", 2, "stepEnd, name[" + paramString + "], cost[" + l1 + "], isRepeatStep[" + bool1 + "], cur[" + localAVGameStep + "], time[" + l2 + "]");
      return;
    }
  }
  
  public void a(String paramString, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      if (paramHashMap != null) {
        break label56;
      }
    }
    label56:
    for (String str = "";; str = paramHashMap.toString())
    {
      QLog.i("AVGamePerfReporter", 2, String.format("reportForVoiceRecognize: tag:%s params:%s", new Object[] { paramString, str }));
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance("", paramString, true, 0L, 0L, paramHashMap, "", true);
      return;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    HashMap localHashMap = new HashMap(20);
    boolean bool = a();
    if (bool)
    {
      str = "1";
      localHashMap.put("is_local", str);
      if (!bool) {
        break label130;
      }
      str = a();
      label48:
      localHashMap.put("asr_model", str);
      localHashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
      localHashMap.put("asr_model", a());
      localHashMap.put("roomID", String.valueOf(paramLong));
      if (!paramBoolean) {
        break label137;
      }
    }
    label130:
    label137:
    for (String str = "actAVGameASRStart";; str = "actAVGameASRStop")
    {
      a(str, localHashMap);
      return;
      str = "0";
      break;
      str = "";
      break label48;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong1, String paramString3, String paramString4, String paramString5, long paramLong2)
  {
    HashMap localHashMap = new HashMap(20);
    String str = paramString5;
    if (!paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString5))
      {
        this.jdField_b_of_type_JavaLangString = paramString5;
        str = this.jdField_b_of_type_JavaLangString;
      }
    }
    else {
      if (!paramBoolean) {
        break label178;
      }
    }
    label178:
    for (paramString5 = "1";; paramString5 = "0")
    {
      localHashMap.put("is_local", paramString5);
      localHashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
      localHashMap.put("asr_model", str);
      localHashMap.put("game_id", paramString3);
      localHashMap.put("asr_uin", paramString4);
      localHashMap.put("time_cost", String.valueOf(paramLong1));
      localHashMap.put("asr_result", paramString1);
      localHashMap.put("keyWord", paramString2);
      localHashMap.put("roomID", String.valueOf(paramLong2));
      a("actAVGameASRResult", localHashMap);
      return;
      paramString5 = this.jdField_b_of_type_JavaLangString;
      break;
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AVGamePerfReporter", 2, "reportForEnterGame, repeat report. retCode[" + paramInt + "=");
      }
      return;
    }
    Object localObject2 = new ArrayList();
    long l2 = 0L;
    long l1 = 0L;
    long l3 = 0L;
    int i = 0;
    Object localObject1;
    while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      localObject1 = (AVGameStep)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(jdField_a_of_type_ArrayOfJavaLangString[i]);
      if (localObject1 == null)
      {
        label95:
        i += 1;
      }
      else
      {
        ((List)localObject2).add(localObject1);
        if (l2 != 0L) {
          break label701;
        }
        l2 = ((AVGameStep)localObject1).jdField_a_of_type_Long;
      }
    }
    label550:
    label687:
    label701:
    for (;;)
    {
      if (((AVGameStep)localObject1).b != 0L) {
        l1 = ((AVGameStep)localObject1).b;
      }
      for (;;)
      {
        l3 = i + 1;
        break label95;
        if (((List)localObject2).size() == 0)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("AVGamePerfReporter", 2, "reportForEnterGame, no main step for report.");
          return;
        }
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_RetCode", String.valueOf(paramInt));
        long l4 = l1;
        if (l1 == 0L) {
          l4 = System.currentTimeMillis();
        }
        if (l2 != 0L) {}
        for (l1 = Math.abs(l4 - l2);; l1 = 0L)
        {
          Object localObject3 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Object localObject4 = (String)((Iterator)localObject3).next();
            localObject4 = (AVGameStep)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject4);
            if ((localObject4 != null) && (!((List)localObject2).contains(localObject4))) {
              ((List)localObject2).add(localObject4);
            }
          }
          i = 0;
          if (i < ((List)localObject2).size())
          {
            localObject3 = (AVGameStep)((List)localObject2).get(i);
            if ((((AVGameStep)localObject3).jdField_a_of_type_Long != 0L) && (((AVGameStep)localObject3).b != 0L) && (Math.abs(((AVGameStep)localObject3).b - ((AVGameStep)localObject3).jdField_a_of_type_Long) > 0L))
            {
              ((HashMap)localObject1).put(((AVGameStep)localObject3).jdField_a_of_type_JavaLangString + "Cost", String.valueOf(((AVGameStep)localObject3).b - ((AVGameStep)localObject3).jdField_a_of_type_Long));
              ((HashMap)localObject1).put(((AVGameStep)localObject3).jdField_a_of_type_JavaLangString + "Ret", String.valueOf(((AVGameStep)localObject3).jdField_a_of_type_Int));
            }
            for (;;)
            {
              i += 1;
              break;
              if (QLog.isColorLevel()) {
                QLog.i("AVGamePerfReporter", 2, "reportForEnterGame, invalid step[" + localObject3 + "]");
              }
            }
          }
          localObject2 = BaseApplicationImpl.getApplication().getQQProcessName();
          if ((jdField_a_of_type_Boolean) && (localObject2 != null) && (((String)localObject2).endsWith(":avgame")))
          {
            jdField_a_of_type_Boolean = false;
            ((HashMap)localObject1).put("param_AVGameFirst", "1");
            this.jdField_b_of_type_Boolean = true;
            localObject2 = StatisticCollector.getInstance(BaseApplicationImpl.getApplication());
            if (paramInt != 0) {
              break label687;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            ((StatisticCollector)localObject2).collectPerformance("", "actAVGameMainCost", bool, l1, l3, (HashMap)localObject1, "", true);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("AVGamePerfReporter", 2, "reportForEnterGame, tagName[" + "actAVGameMainCost" + "], retCode[" + paramInt + "], duration[" + l1 + "], mainStepCnt[" + l3 + "], params[" + localObject1 + "]");
            return;
            ((HashMap)localObject1).put("param_AVGameFirst", "0");
            break label550;
          }
        }
      }
    }
  }
  
  public void b(Intent paramIntent)
  {
    if ((paramIntent == null) || (this.jdField_b_of_type_Boolean)) {
      if (QLog.isColorLevel()) {
        QLog.i("AVGamePerfReporter", 2, "addStepInfoToIntent, report[" + this.jdField_b_of_type_Boolean + "], intent[" + paramIntent + "]");
      }
    }
    for (;;)
    {
      return;
      String[] arrayOfString = jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        AVGameStep localAVGameStep = (AVGameStep)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        if (localAVGameStep != null) {
          paramIntent.putExtra(str, localAVGameStep);
        }
        if ((localAVGameStep != null) && (QLog.isColorLevel())) {
          QLog.i("AVGamePerfReporter", 2, "addStepInfoToIntent, step[" + localAVGameStep + "]");
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nqc
 * JD-Core Version:    0.7.0.1
 */