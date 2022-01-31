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

public class lep
  extends ley<leq>
{
  public lep()
  {
    super(431);
  }
  
  public static les a(int paramInt)
  {
    leq localleq = (leq)aogj.a().a(431);
    if (localleq.jdField_a_of_type_JavaUtilHashMap == null) {
      return null;
    }
    return (les)localleq.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  static les a(leu paramleu)
  {
    int j = paramleu.jdField_a_of_type_Int;
    if ((j != 1) && (j != 2) && (j != 4) && (j != 8)) {
      return null;
    }
    int k = paramleu.jdField_b_of_type_Int;
    if (k <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "min_sdk不合法, codec[" + j + "], min_sdk[" + k + "]");
      }
      return null;
    }
    int m = paramleu.c;
    if (m < 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "async_min_sdk不合法, codec[" + j + "], async_min_sdk[" + m + "]");
      }
      return null;
    }
    String str = paramleu.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "min_version不合法, codec[" + j + "], min_version[" + str + "]");
      }
      return null;
    }
    int n = paramleu.d;
    if (n <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "test_ver不合法, codec[" + j + "], test_ver[" + n + "]");
      }
      return null;
    }
    if ((paramleu.jdField_b_of_type_JavaUtilList == null) || (paramleu.jdField_b_of_type_JavaUtilList.size() == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "没有样本, codec[" + j + "]");
      }
      return null;
    }
    long l;
    HashMap localHashMap;
    label591:
    ler localler;
    label675:
    Object localObject2;
    try
    {
      Object localObject1 = paramleu.jdField_b_of_type_JavaLangString;
      localObject3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      ((SimpleDateFormat)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+8"));
      l = ((SimpleDateFormat)localObject3).parse((String)localObject1).getTime();
      localHashMap = new HashMap();
      localObject1 = paramleu.jdField_b_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label675;
        }
        localObject3 = (lev)((Iterator)localObject1).next();
        if ((!TextUtils.isEmpty(((lev)localObject3).c)) && (!TextUtils.isEmpty(((lev)localObject3).jdField_b_of_type_JavaLangString)))
        {
          if ((j != 1) && (j != 4)) {
            break;
          }
          if (!TextUtils.isEmpty(((lev)localObject3).jdField_a_of_type_JavaLangString)) {
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
        QLog.w("QAVConfig_431", 1, "没有过期时间, codec[" + j + "], expdate[" + paramleu.jdField_b_of_type_JavaLangString + "]");
        l = 0L;
        continue;
        if (((j == 2) || (j == 8)) && ((((lev)localObject3).jdField_a_of_type_Int == 0) || (((lev)localObject3).jdField_b_of_type_Int == 0)))
        {
          QLog.w("QAVConfig_431", 1, "w/h 为空, codec[" + j + "]");
        }
        else
        {
          localler = new ler();
          localler.jdField_b_of_type_JavaLangString = ((lev)localObject3).jdField_b_of_type_JavaLangString;
          localler.c = ((lev)localObject3).jdField_a_of_type_JavaLangString;
          localler.jdField_a_of_type_JavaLangString = ((lev)localObject3).c;
          localler.jdField_a_of_type_Int = ((lev)localObject3).jdField_a_of_type_Int;
          localler.jdField_b_of_type_Int = ((lev)localObject3).jdField_b_of_type_Int;
          localler.jdField_a_of_type_Boolean = paramleu.jdField_a_of_type_Boolean;
          localHashMap.put(((lev)localObject3).c, localler);
        }
      }
      if (localHashMap.size() == 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("QAVConfig_431", 1, "样本不够, codec[" + j + "]");
        }
        return null;
      }
      localler = null;
      localObject2 = null;
      localObject3 = localler;
      if (paramleu.jdField_a_of_type_JavaUtilList == null) {
        break label831;
      }
    }
    Object localObject3 = localler;
    int i1;
    if (paramleu.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      int i = 0;
      for (;;)
      {
        localObject3 = localObject2;
        if (i >= paramleu.jdField_a_of_type_JavaUtilList.size()) {
          break label831;
        }
        i1 = ((Integer)paramleu.jdField_a_of_type_JavaUtilList.get(i)).intValue();
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
      localObject2 = new les();
      ((les)localObject2).jdField_a_of_type_JavaUtilHashMap = localHashMap;
      ((les)localObject2).jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject3);
      ((les)localObject2).c = k;
      ((les)localObject2).d = m;
      ((les)localObject2).jdField_b_of_type_Int = j;
      ((les)localObject2).jdField_a_of_type_JavaLangString = str;
      ((les)localObject2).e = n;
      ((les)localObject2).jdField_a_of_type_Boolean = paramleu.jdField_a_of_type_Boolean;
      ((les)localObject2).jdField_a_of_type_Long = l;
      return localObject2;
    }
  }
  
  public Class<leq> a()
  {
    return leq.class;
  }
  
  @NonNull
  public leq a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("QAVConfig_431", 1, "migrateOldOrDefaultContent, type[" + paramInt + "]");
    }
    return new leq();
  }
  
  @Nullable
  protected leq a(aogf[] paramArrayOfaogf)
  {
    leq localleq = new leq();
    int j = paramArrayOfaogf.length;
    int i = 0;
    while (i < j)
    {
      aogf localaogf = paramArrayOfaogf[i];
      Object localObject = let.a(localaogf.jdField_a_of_type_JavaLangString);
      boolean bool;
      if ((localObject != null) && (((let)localObject).jdField_a_of_type_JavaUtilList != null))
      {
        bool = true;
        if (AudioHelper.e()) {
          QLog.w("QAVConfig_431", 1, "parsed, taskId[" + localaogf.jdField_a_of_type_Int + "], suc[" + bool + "], oldVersion[" + c() + "]");
        }
        if (bool) {
          localObject = ((let)localObject).jdField_a_of_type_JavaUtilList.iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label365;
          }
          leu localleu = (leu)((Iterator)localObject).next();
          les localles1 = a(localleu);
          if (localles1 == null)
          {
            if (!AudioHelper.e()) {
              continue;
            }
            QLog.w("QAVConfig_431", 1, "parsed, 数据不合法");
            continue;
            bool = false;
            break;
          }
          if (localleq.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(localleu.jdField_a_of_type_Int)))
          {
            les localles2 = (les)localleq.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localleu.jdField_a_of_type_Int));
            QLog.w("QAVConfig_431", 1, "parsed, 数据已存在, codec[" + localleu.jdField_a_of_type_Int + "], _taskId[" + localles2.jdField_a_of_type_Int + "], _test_ver[" + localles2.e + "], taskId[" + localaogf.jdField_a_of_type_Int + "], test_ver[" + localles1.e + "]");
            if (localles1.e <= localles2.e) {}
          }
          else
          {
            localles1.jdField_a_of_type_Int = localaogf.jdField_a_of_type_Int;
            localleq.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localleu.jdField_a_of_type_Int), localles1);
          }
        }
      }
      label365:
      i += 1;
    }
    return localleq;
  }
  
  public void a(leq paramleq)
  {
    super.a(paramleq);
    int i = aogj.a().a(431, "");
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
        les localles = (les)paramleq.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k));
        if (localles != null)
        {
          int m = lra.a(localles);
          ((HashMap)localObject1).put("test" + k, "1");
          ((HashMap)localObject1).put("test" + k + "_ver", localles.e + "");
          ((HashMap)localObject1).put("test" + k + "_flag", m + "");
        }
        i += 1;
      }
      UserAction.onUserAction("qav_codec_config", true, -1L, -1L, (Map)localObject1, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lep
 * JD-Core Version:    0.7.0.1
 */