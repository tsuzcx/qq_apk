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

public class lcq
  extends lcz<lcr>
{
  public lcq()
  {
    super(431);
  }
  
  public static lct a(int paramInt)
  {
    lcr locallcr = (lcr)ampm.a().a(431);
    if (locallcr.jdField_a_of_type_JavaUtilHashMap == null) {
      return null;
    }
    return (lct)locallcr.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  static lct a(lcv paramlcv)
  {
    int j = paramlcv.jdField_a_of_type_Int;
    if ((j != 1) && (j != 2) && (j != 4) && (j != 8)) {
      return null;
    }
    int k = paramlcv.jdField_b_of_type_Int;
    if (k <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "min_sdk不合法, codec[" + j + "], min_sdk[" + k + "]");
      }
      return null;
    }
    int m = paramlcv.c;
    if (m < 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "async_min_sdk不合法, codec[" + j + "], async_min_sdk[" + m + "]");
      }
      return null;
    }
    String str = paramlcv.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "min_version不合法, codec[" + j + "], min_version[" + str + "]");
      }
      return null;
    }
    int n = paramlcv.d;
    if (n <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "test_ver不合法, codec[" + j + "], test_ver[" + n + "]");
      }
      return null;
    }
    if ((paramlcv.jdField_b_of_type_JavaUtilList == null) || (paramlcv.jdField_b_of_type_JavaUtilList.size() == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "没有样本, codec[" + j + "]");
      }
      return null;
    }
    long l;
    HashMap localHashMap;
    label591:
    lcs locallcs;
    label675:
    Object localObject2;
    try
    {
      Object localObject1 = paramlcv.jdField_b_of_type_JavaLangString;
      localObject3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      ((SimpleDateFormat)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+8"));
      l = ((SimpleDateFormat)localObject3).parse((String)localObject1).getTime();
      localHashMap = new HashMap();
      localObject1 = paramlcv.jdField_b_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label675;
        }
        localObject3 = (lcw)((Iterator)localObject1).next();
        if ((!TextUtils.isEmpty(((lcw)localObject3).c)) && (!TextUtils.isEmpty(((lcw)localObject3).jdField_b_of_type_JavaLangString)))
        {
          if ((j != 1) && (j != 4)) {
            break;
          }
          if (!TextUtils.isEmpty(((lcw)localObject3).jdField_a_of_type_JavaLangString)) {
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
        QLog.w("QAVConfig_431", 1, "没有过期时间, codec[" + j + "], expdate[" + paramlcv.jdField_b_of_type_JavaLangString + "]");
        l = 0L;
        continue;
        if (((j == 2) || (j == 8)) && ((((lcw)localObject3).jdField_a_of_type_Int == 0) || (((lcw)localObject3).jdField_b_of_type_Int == 0)))
        {
          QLog.w("QAVConfig_431", 1, "w/h 为空, codec[" + j + "]");
        }
        else
        {
          locallcs = new lcs();
          locallcs.jdField_b_of_type_JavaLangString = ((lcw)localObject3).jdField_b_of_type_JavaLangString;
          locallcs.c = ((lcw)localObject3).jdField_a_of_type_JavaLangString;
          locallcs.jdField_a_of_type_JavaLangString = ((lcw)localObject3).c;
          locallcs.jdField_a_of_type_Int = ((lcw)localObject3).jdField_a_of_type_Int;
          locallcs.jdField_b_of_type_Int = ((lcw)localObject3).jdField_b_of_type_Int;
          locallcs.jdField_a_of_type_Boolean = paramlcv.jdField_a_of_type_Boolean;
          localHashMap.put(((lcw)localObject3).c, locallcs);
        }
      }
      if (localHashMap.size() == 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("QAVConfig_431", 1, "样本不够, codec[" + j + "]");
        }
        return null;
      }
      locallcs = null;
      localObject2 = null;
      localObject3 = locallcs;
      if (paramlcv.jdField_a_of_type_JavaUtilList == null) {
        break label831;
      }
    }
    Object localObject3 = locallcs;
    int i1;
    if (paramlcv.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      int i = 0;
      for (;;)
      {
        localObject3 = localObject2;
        if (i >= paramlcv.jdField_a_of_type_JavaUtilList.size()) {
          break label831;
        }
        i1 = ((Integer)paramlcv.jdField_a_of_type_JavaUtilList.get(i)).intValue();
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
      localObject2 = new lct();
      ((lct)localObject2).jdField_a_of_type_JavaUtilHashMap = localHashMap;
      ((lct)localObject2).jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject3);
      ((lct)localObject2).c = k;
      ((lct)localObject2).d = m;
      ((lct)localObject2).jdField_b_of_type_Int = j;
      ((lct)localObject2).jdField_a_of_type_JavaLangString = str;
      ((lct)localObject2).e = n;
      ((lct)localObject2).jdField_a_of_type_Boolean = paramlcv.jdField_a_of_type_Boolean;
      ((lct)localObject2).jdField_a_of_type_Long = l;
      return localObject2;
    }
  }
  
  public Class<lcr> a()
  {
    return lcr.class;
  }
  
  @NonNull
  public lcr a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("QAVConfig_431", 1, "migrateOldOrDefaultContent, type[" + paramInt + "]");
    }
    return new lcr();
  }
  
  @Nullable
  protected lcr a(ampi[] paramArrayOfampi)
  {
    lcr locallcr = new lcr();
    int j = paramArrayOfampi.length;
    int i = 0;
    while (i < j)
    {
      ampi localampi = paramArrayOfampi[i];
      Object localObject = lcu.a(localampi.jdField_a_of_type_JavaLangString);
      boolean bool;
      if ((localObject != null) && (((lcu)localObject).jdField_a_of_type_JavaUtilList != null))
      {
        bool = true;
        if (AudioHelper.e()) {
          QLog.w("QAVConfig_431", 1, "parsed, taskId[" + localampi.jdField_a_of_type_Int + "], suc[" + bool + "], oldVersion[" + c() + "]");
        }
        if (bool) {
          localObject = ((lcu)localObject).jdField_a_of_type_JavaUtilList.iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label365;
          }
          lcv locallcv = (lcv)((Iterator)localObject).next();
          lct locallct1 = a(locallcv);
          if (locallct1 == null)
          {
            if (!AudioHelper.e()) {
              continue;
            }
            QLog.w("QAVConfig_431", 1, "parsed, 数据不合法");
            continue;
            bool = false;
            break;
          }
          if (locallcr.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(locallcv.jdField_a_of_type_Int)))
          {
            lct locallct2 = (lct)locallcr.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(locallcv.jdField_a_of_type_Int));
            QLog.w("QAVConfig_431", 1, "parsed, 数据已存在, codec[" + locallcv.jdField_a_of_type_Int + "], _taskId[" + locallct2.jdField_a_of_type_Int + "], _test_ver[" + locallct2.e + "], taskId[" + localampi.jdField_a_of_type_Int + "], test_ver[" + locallct1.e + "]");
            if (locallct1.e <= locallct2.e) {}
          }
          else
          {
            locallct1.jdField_a_of_type_Int = localampi.jdField_a_of_type_Int;
            locallcr.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(locallcv.jdField_a_of_type_Int), locallct1);
          }
        }
      }
      label365:
      i += 1;
    }
    return locallcr;
  }
  
  public void a(lcr paramlcr)
  {
    super.a(paramlcr);
    int i = ampm.a().a(431, "");
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
        lct locallct = (lct)paramlcr.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k));
        if (locallct != null)
        {
          int m = lpc.a(locallct);
          ((HashMap)localObject1).put("test" + k, "1");
          ((HashMap)localObject1).put("test" + k + "_ver", locallct.e + "");
          ((HashMap)localObject1).put("test" + k + "_flag", m + "");
        }
        i += 1;
      }
      UserAction.onUserAction("qav_codec_config", true, -1L, -1L, (Map)localObject1, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lcq
 * JD-Core Version:    0.7.0.1
 */