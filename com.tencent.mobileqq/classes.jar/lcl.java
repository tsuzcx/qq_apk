import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class lcl
  extends lcu<lcm>
{
  public lcl()
  {
    super(431);
  }
  
  public static lco a(int paramInt)
  {
    lcm locallcm = (lcm)ampl.a().a(431);
    if (locallcm.jdField_a_of_type_JavaUtilHashMap == null) {
      return null;
    }
    return (lco)locallcm.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  static lco a(lcq paramlcq)
  {
    int j = paramlcq.jdField_a_of_type_Int;
    if ((j != 1) && (j != 2) && (j != 4) && (j != 8)) {
      return null;
    }
    int k = paramlcq.jdField_b_of_type_Int;
    if (k <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "min_sdk不合法, codec[" + j + "], min_sdk[" + k + "]");
      }
      return null;
    }
    int m = paramlcq.c;
    if (m < 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "async_min_sdk不合法, codec[" + j + "], async_min_sdk[" + m + "]");
      }
      return null;
    }
    String str = paramlcq.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "min_version不合法, codec[" + j + "], min_version[" + str + "]");
      }
      return null;
    }
    int n = paramlcq.d;
    if (n <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "test_ver不合法, codec[" + j + "], test_ver[" + n + "]");
      }
      return null;
    }
    if ((paramlcq.jdField_b_of_type_JavaUtilList == null) || (paramlcq.jdField_b_of_type_JavaUtilList.size() == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "没有样本, codec[" + j + "]");
      }
      return null;
    }
    long l;
    HashMap localHashMap;
    label591:
    lcn locallcn;
    label675:
    Object localObject2;
    try
    {
      Object localObject1 = paramlcq.jdField_b_of_type_JavaLangString;
      localObject3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      ((SimpleDateFormat)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+8"));
      l = ((SimpleDateFormat)localObject3).parse((String)localObject1).getTime();
      localHashMap = new HashMap();
      localObject1 = paramlcq.jdField_b_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label675;
        }
        localObject3 = (lcr)((Iterator)localObject1).next();
        if ((!TextUtils.isEmpty(((lcr)localObject3).c)) && (!TextUtils.isEmpty(((lcr)localObject3).jdField_b_of_type_JavaLangString)))
        {
          if ((j != 1) && (j != 4)) {
            break;
          }
          if (!TextUtils.isEmpty(((lcr)localObject3).jdField_a_of_type_JavaLangString)) {
            break label591;
          }
          QLog.w("QAVConfig_431", 1, "exp 为空, codec[" + j + "]");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("QAVConfig_431", 1, "没有过期时间, codec[" + j + "], expdate[" + paramlcq.jdField_b_of_type_JavaLangString + "]");
        l = 0L;
        continue;
        if (((j == 2) || (j == 8)) && ((((lcr)localObject3).jdField_a_of_type_Int == 0) || (((lcr)localObject3).jdField_b_of_type_Int == 0)))
        {
          QLog.w("QAVConfig_431", 1, "w/h 为空, codec[" + j + "]");
        }
        else
        {
          locallcn = new lcn();
          locallcn.jdField_b_of_type_JavaLangString = ((lcr)localObject3).jdField_b_of_type_JavaLangString;
          locallcn.c = ((lcr)localObject3).jdField_a_of_type_JavaLangString;
          locallcn.jdField_a_of_type_JavaLangString = ((lcr)localObject3).c;
          locallcn.jdField_a_of_type_Int = ((lcr)localObject3).jdField_a_of_type_Int;
          locallcn.jdField_b_of_type_Int = ((lcr)localObject3).jdField_b_of_type_Int;
          locallcn.jdField_a_of_type_Boolean = paramlcq.jdField_a_of_type_Boolean;
          localHashMap.put(((lcr)localObject3).c, locallcn);
        }
      }
      if (localHashMap.size() == 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("QAVConfig_431", 1, "样本不够, codec[" + j + "]");
        }
        return null;
      }
      locallcn = null;
      localObject2 = null;
      localObject3 = locallcn;
      if (paramlcq.jdField_a_of_type_JavaUtilList == null) {
        break label831;
      }
    }
    Object localObject3 = locallcn;
    int i1;
    if (paramlcq.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      int i = 0;
      for (;;)
      {
        localObject3 = localObject2;
        if (i >= paramlcq.jdField_a_of_type_JavaUtilList.size()) {
          break label831;
        }
        i1 = ((Integer)paramlcq.jdField_a_of_type_JavaUtilList.get(i)).intValue();
        if (i1 > 0) {
          break;
        }
        i += 1;
      }
      if (localObject2 != null) {
        break label906;
      }
      localObject2 = new ArrayList();
    }
    label906:
    for (;;)
    {
      ((ArrayList)localObject2).add(Integer.valueOf(i1));
      break;
      label831:
      localObject2 = new lco();
      ((lco)localObject2).jdField_a_of_type_JavaUtilHashMap = localHashMap;
      ((lco)localObject2).jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject3);
      ((lco)localObject2).c = k;
      ((lco)localObject2).d = m;
      ((lco)localObject2).jdField_b_of_type_Int = j;
      ((lco)localObject2).jdField_a_of_type_JavaLangString = str;
      ((lco)localObject2).e = n;
      ((lco)localObject2).jdField_a_of_type_Boolean = paramlcq.jdField_a_of_type_Boolean;
      ((lco)localObject2).jdField_a_of_type_Long = l;
      return localObject2;
    }
  }
  
  public Class<lcm> a()
  {
    return lcm.class;
  }
  
  @NonNull
  public lcm a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("QAVConfig_431", 1, "migrateOldOrDefaultContent, type[" + paramInt + "]");
    }
    return new lcm();
  }
  
  @Nullable
  protected lcm a(amph[] paramArrayOfamph)
  {
    lcm locallcm = new lcm();
    int j = paramArrayOfamph.length;
    int i = 0;
    while (i < j)
    {
      amph localamph = paramArrayOfamph[i];
      Object localObject = lcp.a(localamph.jdField_a_of_type_JavaLangString);
      boolean bool;
      if ((localObject != null) && (((lcp)localObject).jdField_a_of_type_JavaUtilList != null))
      {
        bool = true;
        if (AudioHelper.e()) {
          QLog.w("QAVConfig_431", 1, "parsed, taskId[" + localamph.jdField_a_of_type_Int + "], suc[" + bool + "], oldVersion[" + c() + "]");
        }
        if (bool) {
          localObject = ((lcp)localObject).jdField_a_of_type_JavaUtilList.iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label365;
          }
          lcq locallcq = (lcq)((Iterator)localObject).next();
          lco locallco1 = a(locallcq);
          if (locallco1 == null)
          {
            if (!AudioHelper.e()) {
              continue;
            }
            QLog.w("QAVConfig_431", 1, "parsed, 数据不合法");
            continue;
            bool = false;
            break;
          }
          if (locallcm.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(locallcq.jdField_a_of_type_Int)))
          {
            lco locallco2 = (lco)locallcm.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(locallcq.jdField_a_of_type_Int));
            QLog.w("QAVConfig_431", 1, "parsed, 数据已存在, codec[" + locallcq.jdField_a_of_type_Int + "], _taskId[" + locallco2.jdField_a_of_type_Int + "], _test_ver[" + locallco2.e + "], taskId[" + localamph.jdField_a_of_type_Int + "], test_ver[" + locallco1.e + "]");
            if (locallco1.e <= locallco2.e) {}
          }
          else
          {
            locallco1.jdField_a_of_type_Int = localamph.jdField_a_of_type_Int;
            locallcm.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(locallcq.jdField_a_of_type_Int), locallco1);
          }
        }
      }
      label365:
      i += 1;
    }
    return locallcm;
  }
  
  public void a(lcm paramlcm)
  {
    super.a(paramlcm);
    int i = ampl.a().a(431, "");
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      Object localObject2 = (QQAppInterface)localObject1;
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("uin", ((QQAppInterface)localObject2).getCurrentAccountUin());
      ((HashMap)localObject1).put("ver", i + "");
      ((HashMap)localObject1).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
      localObject2 = new int[4];
      Object tmp115_113 = localObject2;
      tmp115_113[0] = 1;
      Object tmp119_115 = tmp115_113;
      tmp119_115[1] = 2;
      Object tmp123_119 = tmp119_115;
      tmp123_119[2] = 4;
      Object tmp127_123 = tmp123_119;
      tmp127_123[3] = 8;
      tmp127_123;
      int j = localObject2.length;
      i = 0;
      while (i < j)
      {
        int k = localObject2[i];
        lco locallco = (lco)paramlcm.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k));
        if (locallco != null)
        {
          int m = lox.a(locallco);
          ((HashMap)localObject1).put("test" + k, "1");
          ((HashMap)localObject1).put("test" + k + "_ver", locallco.e + "");
          ((HashMap)localObject1).put("test" + k + "_flag", m + "");
        }
        i += 1;
      }
      UserAction.onUserAction("qav_codec_config", true, -1L, -1L, (Map)localObject1, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lcl
 * JD-Core Version:    0.7.0.1
 */