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

public class lbp
  extends lby<lbq>
{
  public lbp()
  {
    super(431);
  }
  
  public static lbs a(int paramInt)
  {
    lbq locallbq = (lbq)aran.a().a(431);
    if (locallbq.jdField_a_of_type_JavaUtilHashMap == null) {
      return null;
    }
    return (lbs)locallbq.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  static lbs a(lbu paramlbu)
  {
    int j = paramlbu.jdField_a_of_type_Int;
    if ((j != 1) && (j != 2) && (j != 4) && (j != 8)) {
      return null;
    }
    int k = paramlbu.jdField_b_of_type_Int;
    if (k <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "min_sdk不合法, codec[" + j + "], min_sdk[" + k + "]");
      }
      return null;
    }
    int m = paramlbu.c;
    if (m < 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "async_min_sdk不合法, codec[" + j + "], async_min_sdk[" + m + "]");
      }
      return null;
    }
    String str = paramlbu.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "min_version不合法, codec[" + j + "], min_version[" + str + "]");
      }
      return null;
    }
    int n = paramlbu.d;
    if (n <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "test_ver不合法, codec[" + j + "], test_ver[" + n + "]");
      }
      return null;
    }
    if ((paramlbu.jdField_b_of_type_JavaUtilList == null) || (paramlbu.jdField_b_of_type_JavaUtilList.size() == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "没有样本, codec[" + j + "]");
      }
      return null;
    }
    long l;
    HashMap localHashMap;
    label591:
    lbr locallbr;
    label675:
    Object localObject2;
    try
    {
      Object localObject1 = paramlbu.jdField_b_of_type_JavaLangString;
      localObject3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      ((SimpleDateFormat)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+8"));
      l = ((SimpleDateFormat)localObject3).parse((String)localObject1).getTime();
      localHashMap = new HashMap();
      localObject1 = paramlbu.jdField_b_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label675;
        }
        localObject3 = (lbv)((Iterator)localObject1).next();
        if ((!TextUtils.isEmpty(((lbv)localObject3).c)) && (!TextUtils.isEmpty(((lbv)localObject3).jdField_b_of_type_JavaLangString)))
        {
          if ((j != 1) && (j != 4)) {
            break;
          }
          if (!TextUtils.isEmpty(((lbv)localObject3).jdField_a_of_type_JavaLangString)) {
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
        QLog.w("QAVConfig_431", 1, "没有过期时间, codec[" + j + "], expdate[" + paramlbu.jdField_b_of_type_JavaLangString + "]");
        l = 0L;
        continue;
        if (((j == 2) || (j == 8)) && ((((lbv)localObject3).jdField_a_of_type_Int == 0) || (((lbv)localObject3).jdField_b_of_type_Int == 0)))
        {
          QLog.w("QAVConfig_431", 1, "w/h 为空, codec[" + j + "]");
        }
        else
        {
          locallbr = new lbr();
          locallbr.jdField_b_of_type_JavaLangString = ((lbv)localObject3).jdField_b_of_type_JavaLangString;
          locallbr.c = ((lbv)localObject3).jdField_a_of_type_JavaLangString;
          locallbr.jdField_a_of_type_JavaLangString = ((lbv)localObject3).c;
          locallbr.jdField_a_of_type_Int = ((lbv)localObject3).jdField_a_of_type_Int;
          locallbr.jdField_b_of_type_Int = ((lbv)localObject3).jdField_b_of_type_Int;
          locallbr.jdField_a_of_type_Boolean = paramlbu.jdField_a_of_type_Boolean;
          localHashMap.put(((lbv)localObject3).c, locallbr);
        }
      }
      if (localHashMap.size() == 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("QAVConfig_431", 1, "样本不够, codec[" + j + "]");
        }
        return null;
      }
      locallbr = null;
      localObject2 = null;
      localObject3 = locallbr;
      if (paramlbu.jdField_a_of_type_JavaUtilList == null) {
        break label831;
      }
    }
    Object localObject3 = locallbr;
    int i1;
    if (paramlbu.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      int i = 0;
      for (;;)
      {
        localObject3 = localObject2;
        if (i >= paramlbu.jdField_a_of_type_JavaUtilList.size()) {
          break label831;
        }
        i1 = ((Integer)paramlbu.jdField_a_of_type_JavaUtilList.get(i)).intValue();
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
      localObject2 = new lbs();
      ((lbs)localObject2).jdField_a_of_type_JavaUtilHashMap = localHashMap;
      ((lbs)localObject2).jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject3);
      ((lbs)localObject2).c = k;
      ((lbs)localObject2).d = m;
      ((lbs)localObject2).jdField_b_of_type_Int = j;
      ((lbs)localObject2).jdField_a_of_type_JavaLangString = str;
      ((lbs)localObject2).e = n;
      ((lbs)localObject2).jdField_a_of_type_Boolean = paramlbu.jdField_a_of_type_Boolean;
      ((lbs)localObject2).jdField_a_of_type_Long = l;
      return localObject2;
    }
  }
  
  @NonNull
  public lbq a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("QAVConfig_431", 1, "migrateOldOrDefaultContent, type[" + paramInt + "]");
    }
    return new lbq();
  }
  
  @Nullable
  protected lbq a(araj[] paramArrayOfaraj)
  {
    lbq locallbq = new lbq();
    int j = paramArrayOfaraj.length;
    int i = 0;
    while (i < j)
    {
      araj localaraj = paramArrayOfaraj[i];
      Object localObject = lbt.a(localaraj.jdField_a_of_type_JavaLangString);
      boolean bool;
      if ((localObject != null) && (((lbt)localObject).jdField_a_of_type_JavaUtilList != null))
      {
        bool = true;
        if (AudioHelper.f()) {
          QLog.w("QAVConfig_431", 1, "parsed, taskId[" + localaraj.jdField_a_of_type_Int + "], suc[" + bool + "], oldVersion[" + a() + "]");
        }
        if (bool) {
          localObject = ((lbt)localObject).jdField_a_of_type_JavaUtilList.iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label365;
          }
          lbu locallbu = (lbu)((Iterator)localObject).next();
          lbs locallbs1 = a(locallbu);
          if (locallbs1 == null)
          {
            if (!AudioHelper.f()) {
              continue;
            }
            QLog.w("QAVConfig_431", 1, "parsed, 数据不合法");
            continue;
            bool = false;
            break;
          }
          if (locallbq.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(locallbu.jdField_a_of_type_Int)))
          {
            lbs locallbs2 = (lbs)locallbq.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(locallbu.jdField_a_of_type_Int));
            QLog.w("QAVConfig_431", 1, "parsed, 数据已存在, codec[" + locallbu.jdField_a_of_type_Int + "], _taskId[" + locallbs2.jdField_a_of_type_Int + "], _test_ver[" + locallbs2.e + "], taskId[" + localaraj.jdField_a_of_type_Int + "], test_ver[" + locallbs1.e + "]");
            if (locallbs1.e <= locallbs2.e) {}
          }
          else
          {
            locallbs1.jdField_a_of_type_Int = localaraj.jdField_a_of_type_Int;
            locallbq.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(locallbu.jdField_a_of_type_Int), locallbs1);
          }
        }
      }
      label365:
      i += 1;
    }
    return locallbq;
  }
  
  public void a(lbq paramlbq)
  {
    super.onUpdate(paramlbq);
    int i = aran.a().a(431, "");
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
        lbs locallbs = (lbs)paramlbq.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k));
        if (locallbs != null)
        {
          int m = lol.a(locallbs);
          ((HashMap)localObject1).put("test" + k, "1");
          ((HashMap)localObject1).put("test" + k + "_ver", locallbs.e + "");
          ((HashMap)localObject1).put("test" + k + "_flag", m + "");
        }
        i += 1;
      }
      UserAction.onUserAction("qav_codec_config", true, -1L, -1L, (Map)localObject1, true, true);
    }
  }
  
  public Class<lbq> clazz()
  {
    return lbq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lbp
 * JD-Core Version:    0.7.0.1
 */