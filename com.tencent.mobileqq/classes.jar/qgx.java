import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelRequestModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelRequestModule.UserLevelInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import tencent.im.oidb.cmd0xef9.oidb_cmd0xef9.PrivilegeRspBody;

public class qgx
{
  private static volatile qgx jdField_a_of_type_Qgx;
  private Map<Long, RIJUserLevelRequestModule.UserLevelInfo> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  private qgx()
  {
    qgy localqgy = new qgy(this);
    pvm.a().a(localqgy);
    c();
  }
  
  private RIJUserLevelRequestModule.UserLevelInfo a(int paramInt)
  {
    RIJUserLevelRequestModule.UserLevelInfo localUserLevelInfo = a(pkh.a());
    localUserLevelInfo.currentOpType = paramInt;
    return localUserLevelInfo;
  }
  
  private RIJUserLevelRequestModule.UserLevelInfo a(long paramLong)
  {
    RIJUserLevelRequestModule.UserLevelInfo localUserLevelInfo2 = (RIJUserLevelRequestModule.UserLevelInfo)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    RIJUserLevelRequestModule.UserLevelInfo localUserLevelInfo1 = localUserLevelInfo2;
    if (localUserLevelInfo2 == null)
    {
      localUserLevelInfo1 = new RIJUserLevelRequestModule.UserLevelInfo();
      localUserLevelInfo1.uin = paramLong;
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localUserLevelInfo1);
    }
    return localUserLevelInfo1;
  }
  
  /* Error */
  public static qgx a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 74	qgx:jdField_a_of_type_Qgx	Lqgx;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 74	qgx:jdField_a_of_type_Qgx	Lqgx;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	qgx
    //   21: dup
    //   22: invokespecial 75	qgx:<init>	()V
    //   25: putstatic 74	qgx:jdField_a_of_type_Qgx	Lqgx;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 74	qgx:jdField_a_of_type_Qgx	Lqgx;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localqgx	qgx
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  private void a(long paramLong, int paramInt)
  {
    RIJUserLevelRequestModule localRIJUserLevelRequestModule = pvj.a().a();
    if (localRIJUserLevelRequestModule != null) {
      localRIJUserLevelRequestModule.a(paramLong, paramInt);
    }
  }
  
  private void a(Context paramContext, RIJUserLevelRequestModule.UserLevelInfo paramUserLevelInfo)
  {
    if (paramUserLevelInfo == null)
    {
      QLog.d("RIJUserLevelModel", 1, "showErrorDialog userLevelInfo is null.");
      return;
    }
    b(paramContext, paramUserLevelInfo);
    tou localtou = new tou();
    localtou.jdField_a_of_type_JavaLangString = paramUserLevelInfo.errorDialogTitle;
    localtou.c = paramUserLevelInfo.errorDialogContent;
    localtou.jdField_a_of_type_Tot = new qgz(this, paramContext, paramUserLevelInfo);
    pkh.a(paramContext, localtou);
  }
  
  private void a(RIJUserLevelRequestModule.UserLevelInfo paramUserLevelInfo)
  {
    if (paramUserLevelInfo == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramUserLevelInfo.uin), paramUserLevelInfo);
    b();
  }
  
  private void a(RIJUserLevelRequestModule.UserLevelInfo paramUserLevelInfo, qha paramqha)
  {
    if (paramqha != null) {
      paramqha.a(paramUserLevelInfo);
    }
  }
  
  private void a(Object paramObject)
  {
    Gson localGson = new Gson();
    if ((paramObject instanceof String))
    {
      paramObject = (RIJUserLevelRequestModule.UserLevelInfo)localGson.fromJson(paramObject.toString(), RIJUserLevelRequestModule.UserLevelInfo.class);
      if (paramObject != null) {
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramObject.uin), paramObject);
      }
    }
  }
  
  private void a(oidb_cmd0xef9.PrivilegeRspBody paramPrivilegeRspBody, long paramLong, int paramInt)
  {
    QLog.d("RIJUserLevelModel", 1, "updateUserLevelInfo!");
    if (paramPrivilegeRspBody == null) {
      return;
    }
    RIJUserLevelRequestModule.UserLevelInfo localUserLevelInfo = a(paramLong);
    localUserLevelInfo.jumpUrl = qxl.a(paramPrivilegeRspBody.jump_url);
    localUserLevelInfo.level = qxl.a(paramPrivilegeRspBody.level);
    localUserLevelInfo.opesAllowedMap.put(Integer.valueOf(paramInt), Boolean.valueOf(qxl.a(paramPrivilegeRspBody.is_allowed)));
    a(localUserLevelInfo);
    QLog.d("RIJUserLevelModel", 1, "updateUserLevelInfo! cacheUserLevelInfo=" + localUserLevelInfo);
  }
  
  private void b()
  {
    Gson localGson = new Gson();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      String str = localGson.toJson((RIJUserLevelRequestModule.UserLevelInfo)((Map.Entry)localIterator.next()).getValue());
      if (!TextUtils.isEmpty(str)) {
        localJSONArray.put(str);
      }
    }
    if (localJSONArray.length() > 0) {
      bmhv.a("user_info_level_sp", localJSONArray.toString());
    }
    QLog.d("RIJUserLevelModel", 1, "save2Local ,datas=" + localJSONArray);
  }
  
  private void b(Context paramContext, RIJUserLevelRequestModule.UserLevelInfo paramUserLevelInfo)
  {
    if ((paramUserLevelInfo == null) || (paramContext == null)) {
      return;
    }
    String str2 = paramContext.getString(2131699147);
    String str1;
    switch (paramUserLevelInfo.currentOpType)
    {
    default: 
      str1 = paramContext.getString(2131699176);
    }
    for (;;)
    {
      paramUserLevelInfo.errorDialogContent = (paramContext.getString(2131699135) + paramUserLevelInfo.level + str1);
      paramUserLevelInfo.errorDialogTitle = str2;
      return;
      str1 = paramContext.getString(2131699174);
      continue;
      str1 = paramContext.getString(2131699173);
      continue;
      str2 = paramContext.getString(2131699146);
      str1 = paramContext.getString(2131699175);
    }
  }
  
  private void c()
  {
    String str = (String)bmhv.a("user_info_level_sp", "");
    if (!TextUtils.isEmpty(str)) {
      try
      {
        JSONArray localJSONArray = new JSONArray(str);
        int i = 0;
        while (i < localJSONArray.length())
        {
          a(localJSONArray.get(i));
          i += 1;
        }
        QLog.d("RIJUserLevelModel", 1, "loadUserInfoFromSP ,data=" + str);
      }
      catch (Exception localException)
      {
        QLog.d("RIJUserLevelModel", 1, "loadUserInfoFromSP error! msg=" + localException);
      }
    }
  }
  
  public void a()
  {
    QLog.d("RIJUserLevelModel", 1, "preRequestUserLevel! hasPreRequest=" + this.jdField_a_of_type_Boolean);
    long l = pkh.a();
    a(l, 5);
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(l, 7);
    a(l, 6);
    this.jdField_a_of_type_Boolean = true;
  }
  
  @Deprecated
  public void a(int paramInt, qha paramqha)
  {
    RIJUserLevelRequestModule.UserLevelInfo localUserLevelInfo = a(paramInt);
    a(localUserLevelInfo, paramqha);
    a(localUserLevelInfo.uin, paramInt);
  }
  
  public void a(Context paramContext, int paramInt, qha paramqha)
  {
    boolean bool = false;
    if (Aladdin.getConfig(389).getIntegerFromString("ugc_privilege_switch", 0) == 1) {
      bool = true;
    }
    QLog.d("RIJUserLevelModel", 1, "doActionsByUserLevel ,switchOpen=" + bool + " operType=" + paramInt);
    RIJUserLevelRequestModule.UserLevelInfo localUserLevelInfo = a(paramInt);
    if (!bool)
    {
      a(localUserLevelInfo, paramqha);
      return;
    }
    Boolean localBoolean = (Boolean)localUserLevelInfo.opesAllowedMap.get(Integer.valueOf(paramInt));
    if ((localBoolean == null) || (localBoolean.booleanValue())) {
      a(localUserLevelInfo, paramqha);
    }
    for (;;)
    {
      QLog.d("RIJUserLevelModel", 1, "doActionsByUserLevel ,isAllow=" + localBoolean);
      a(localUserLevelInfo.uin, paramInt);
      return;
      a(paramContext, localUserLevelInfo);
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    if (Aladdin.getConfig(389).getIntegerFromString("ugc_privilege_switch", 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.d("RIJUserLevelModel", 2, "getCacheUserLevel ,switchOpen=" + bool1 + " operType=" + paramInt);
      if (bool1) {
        break;
      }
      return true;
    }
    Boolean localBoolean = (Boolean)a(paramInt).opesAllowedMap.get(Integer.valueOf(paramInt));
    QLog.d("RIJUserLevelModel", 2, "getCacheUserLevel ,isAllow=" + localBoolean);
    if (localBoolean != null)
    {
      bool1 = bool2;
      if (!localBoolean.booleanValue()) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qgx
 * JD-Core Version:    0.7.0.1
 */