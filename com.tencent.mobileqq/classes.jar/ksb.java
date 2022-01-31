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

public class ksb
  extends ksk<ksc>
{
  public ksb()
  {
    super(431);
  }
  
  public static kse a(int paramInt)
  {
    ksc localksc = (ksc)alzw.a().a(431);
    if (localksc.jdField_a_of_type_JavaUtilHashMap == null) {
      return null;
    }
    return (kse)localksc.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  static kse a(ksg paramksg)
  {
    int j = paramksg.jdField_a_of_type_Int;
    if ((j != 1) && (j != 2) && (j != 4) && (j != 8)) {
      return null;
    }
    int k = paramksg.jdField_b_of_type_Int;
    if (k <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "min_sdk不合法, codec[" + j + "], min_sdk[" + k + "]");
      }
      return null;
    }
    int m = paramksg.c;
    if (m < 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "async_min_sdk不合法, codec[" + j + "], async_min_sdk[" + m + "]");
      }
      return null;
    }
    String str = paramksg.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "min_version不合法, codec[" + j + "], min_version[" + str + "]");
      }
      return null;
    }
    int n = paramksg.d;
    if (n <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "test_ver不合法, codec[" + j + "], test_ver[" + n + "]");
      }
      return null;
    }
    if ((paramksg.jdField_b_of_type_JavaUtilList == null) || (paramksg.jdField_b_of_type_JavaUtilList.size() == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "没有样本, codec[" + j + "]");
      }
      return null;
    }
    long l;
    HashMap localHashMap;
    label591:
    ksd localksd;
    label675:
    Object localObject2;
    try
    {
      Object localObject1 = paramksg.jdField_b_of_type_JavaLangString;
      localObject3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      ((SimpleDateFormat)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+8"));
      l = ((SimpleDateFormat)localObject3).parse((String)localObject1).getTime();
      localHashMap = new HashMap();
      localObject1 = paramksg.jdField_b_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label675;
        }
        localObject3 = (ksh)((Iterator)localObject1).next();
        if ((!TextUtils.isEmpty(((ksh)localObject3).c)) && (!TextUtils.isEmpty(((ksh)localObject3).jdField_b_of_type_JavaLangString)))
        {
          if ((j != 1) && (j != 4)) {
            break;
          }
          if (!TextUtils.isEmpty(((ksh)localObject3).jdField_a_of_type_JavaLangString)) {
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
        QLog.w("QAVConfig_431", 1, "没有过期时间, codec[" + j + "], expdate[" + paramksg.jdField_b_of_type_JavaLangString + "]");
        l = 0L;
        continue;
        if (((j == 2) || (j == 8)) && ((((ksh)localObject3).jdField_a_of_type_Int == 0) || (((ksh)localObject3).jdField_b_of_type_Int == 0)))
        {
          QLog.w("QAVConfig_431", 1, "w/h 为空, codec[" + j + "]");
        }
        else
        {
          localksd = new ksd();
          localksd.jdField_b_of_type_JavaLangString = ((ksh)localObject3).jdField_b_of_type_JavaLangString;
          localksd.c = ((ksh)localObject3).jdField_a_of_type_JavaLangString;
          localksd.jdField_a_of_type_JavaLangString = ((ksh)localObject3).c;
          localksd.jdField_a_of_type_Int = ((ksh)localObject3).jdField_a_of_type_Int;
          localksd.jdField_b_of_type_Int = ((ksh)localObject3).jdField_b_of_type_Int;
          localksd.jdField_a_of_type_Boolean = paramksg.jdField_a_of_type_Boolean;
          localHashMap.put(((ksh)localObject3).c, localksd);
        }
      }
      if (localHashMap.size() == 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("QAVConfig_431", 1, "样本不够, codec[" + j + "]");
        }
        return null;
      }
      localksd = null;
      localObject2 = null;
      localObject3 = localksd;
      if (paramksg.jdField_a_of_type_JavaUtilList == null) {
        break label831;
      }
    }
    Object localObject3 = localksd;
    int i1;
    if (paramksg.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      int i = 0;
      for (;;)
      {
        localObject3 = localObject2;
        if (i >= paramksg.jdField_a_of_type_JavaUtilList.size()) {
          break label831;
        }
        i1 = ((Integer)paramksg.jdField_a_of_type_JavaUtilList.get(i)).intValue();
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
      localObject2 = new kse();
      ((kse)localObject2).jdField_a_of_type_JavaUtilHashMap = localHashMap;
      ((kse)localObject2).jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject3);
      ((kse)localObject2).c = k;
      ((kse)localObject2).d = m;
      ((kse)localObject2).jdField_b_of_type_Int = j;
      ((kse)localObject2).jdField_a_of_type_JavaLangString = str;
      ((kse)localObject2).e = n;
      ((kse)localObject2).jdField_a_of_type_Boolean = paramksg.jdField_a_of_type_Boolean;
      ((kse)localObject2).jdField_a_of_type_Long = l;
      return localObject2;
    }
  }
  
  public Class<ksc> a()
  {
    return ksc.class;
  }
  
  @NonNull
  public ksc a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("QAVConfig_431", 1, "migrateOldOrDefaultContent, type[" + paramInt + "]");
    }
    return new ksc();
  }
  
  @Nullable
  protected ksc a(alzs[] paramArrayOfalzs)
  {
    ksc localksc = new ksc();
    int j = paramArrayOfalzs.length;
    int i = 0;
    while (i < j)
    {
      alzs localalzs = paramArrayOfalzs[i];
      Object localObject = ksf.a(localalzs.jdField_a_of_type_JavaLangString);
      boolean bool;
      if ((localObject != null) && (((ksf)localObject).jdField_a_of_type_JavaUtilList != null))
      {
        bool = true;
        if (AudioHelper.e()) {
          QLog.w("QAVConfig_431", 1, "parsed, taskId[" + localalzs.jdField_a_of_type_Int + "], suc[" + bool + "], oldVersion[" + c() + "]");
        }
        if (bool) {
          localObject = ((ksf)localObject).jdField_a_of_type_JavaUtilList.iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label365;
          }
          ksg localksg = (ksg)((Iterator)localObject).next();
          kse localkse1 = a(localksg);
          if (localkse1 == null)
          {
            if (!AudioHelper.e()) {
              continue;
            }
            QLog.w("QAVConfig_431", 1, "parsed, 数据不合法");
            continue;
            bool = false;
            break;
          }
          if (localksc.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(localksg.jdField_a_of_type_Int)))
          {
            kse localkse2 = (kse)localksc.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localksg.jdField_a_of_type_Int));
            QLog.w("QAVConfig_431", 1, "parsed, 数据已存在, codec[" + localksg.jdField_a_of_type_Int + "], _taskId[" + localkse2.jdField_a_of_type_Int + "], _test_ver[" + localkse2.e + "], taskId[" + localalzs.jdField_a_of_type_Int + "], test_ver[" + localkse1.e + "]");
            if (localkse1.e <= localkse2.e) {}
          }
          else
          {
            localkse1.jdField_a_of_type_Int = localalzs.jdField_a_of_type_Int;
            localksc.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localksg.jdField_a_of_type_Int), localkse1);
          }
        }
      }
      label365:
      i += 1;
    }
    return localksc;
  }
  
  public void a(ksc paramksc)
  {
    super.a(paramksc);
    int i = alzw.a().a(431, "");
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
        kse localkse = (kse)paramksc.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k));
        if (localkse != null)
        {
          int m = lel.a(localkse);
          ((HashMap)localObject1).put("test" + k, "1");
          ((HashMap)localObject1).put("test" + k + "_ver", localkse.e + "");
          ((HashMap)localObject1).put("test" + k + "_flag", m + "");
        }
        i += 1;
      }
      UserAction.onUserAction("qav_codec_config", true, -1L, -1L, (Map)localObject1, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ksb
 * JD-Core Version:    0.7.0.1
 */