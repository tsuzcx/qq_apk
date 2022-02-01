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

public class lbi
  extends lbr<lbj>
{
  public lbi()
  {
    super(431);
  }
  
  public static lbl a(int paramInt)
  {
    lbj locallbj = (lbj)aqlk.a().a(431);
    if (locallbj.jdField_a_of_type_JavaUtilHashMap == null) {
      return null;
    }
    return (lbl)locallbj.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  static lbl a(lbn paramlbn)
  {
    int j = paramlbn.jdField_a_of_type_Int;
    if ((j != 1) && (j != 2) && (j != 4) && (j != 8)) {
      return null;
    }
    int k = paramlbn.jdField_b_of_type_Int;
    if (k <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "min_sdk不合法, codec[" + j + "], min_sdk[" + k + "]");
      }
      return null;
    }
    int m = paramlbn.c;
    if (m < 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "async_min_sdk不合法, codec[" + j + "], async_min_sdk[" + m + "]");
      }
      return null;
    }
    String str = paramlbn.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "min_version不合法, codec[" + j + "], min_version[" + str + "]");
      }
      return null;
    }
    int n = paramlbn.d;
    if (n <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "test_ver不合法, codec[" + j + "], test_ver[" + n + "]");
      }
      return null;
    }
    if ((paramlbn.jdField_b_of_type_JavaUtilList == null) || (paramlbn.jdField_b_of_type_JavaUtilList.size() == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "没有样本, codec[" + j + "]");
      }
      return null;
    }
    long l;
    HashMap localHashMap;
    label591:
    lbk locallbk;
    label675:
    Object localObject2;
    try
    {
      Object localObject1 = paramlbn.jdField_b_of_type_JavaLangString;
      localObject3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      ((SimpleDateFormat)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+8"));
      l = ((SimpleDateFormat)localObject3).parse((String)localObject1).getTime();
      localHashMap = new HashMap();
      localObject1 = paramlbn.jdField_b_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label675;
        }
        localObject3 = (lbo)((Iterator)localObject1).next();
        if ((!TextUtils.isEmpty(((lbo)localObject3).c)) && (!TextUtils.isEmpty(((lbo)localObject3).jdField_b_of_type_JavaLangString)))
        {
          if ((j != 1) && (j != 4)) {
            break;
          }
          if (!TextUtils.isEmpty(((lbo)localObject3).jdField_a_of_type_JavaLangString)) {
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
        QLog.w("QAVConfig_431", 1, "没有过期时间, codec[" + j + "], expdate[" + paramlbn.jdField_b_of_type_JavaLangString + "]");
        l = 0L;
        continue;
        if (((j == 2) || (j == 8)) && ((((lbo)localObject3).jdField_a_of_type_Int == 0) || (((lbo)localObject3).jdField_b_of_type_Int == 0)))
        {
          QLog.w("QAVConfig_431", 1, "w/h 为空, codec[" + j + "]");
        }
        else
        {
          locallbk = new lbk();
          locallbk.jdField_b_of_type_JavaLangString = ((lbo)localObject3).jdField_b_of_type_JavaLangString;
          locallbk.c = ((lbo)localObject3).jdField_a_of_type_JavaLangString;
          locallbk.jdField_a_of_type_JavaLangString = ((lbo)localObject3).c;
          locallbk.jdField_a_of_type_Int = ((lbo)localObject3).jdField_a_of_type_Int;
          locallbk.jdField_b_of_type_Int = ((lbo)localObject3).jdField_b_of_type_Int;
          locallbk.jdField_a_of_type_Boolean = paramlbn.jdField_a_of_type_Boolean;
          localHashMap.put(((lbo)localObject3).c, locallbk);
        }
      }
      if (localHashMap.size() == 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("QAVConfig_431", 1, "样本不够, codec[" + j + "]");
        }
        return null;
      }
      locallbk = null;
      localObject2 = null;
      localObject3 = locallbk;
      if (paramlbn.jdField_a_of_type_JavaUtilList == null) {
        break label831;
      }
    }
    Object localObject3 = locallbk;
    int i1;
    if (paramlbn.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      int i = 0;
      for (;;)
      {
        localObject3 = localObject2;
        if (i >= paramlbn.jdField_a_of_type_JavaUtilList.size()) {
          break label831;
        }
        i1 = ((Integer)paramlbn.jdField_a_of_type_JavaUtilList.get(i)).intValue();
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
      localObject2 = new lbl();
      ((lbl)localObject2).jdField_a_of_type_JavaUtilHashMap = localHashMap;
      ((lbl)localObject2).jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject3);
      ((lbl)localObject2).c = k;
      ((lbl)localObject2).d = m;
      ((lbl)localObject2).jdField_b_of_type_Int = j;
      ((lbl)localObject2).jdField_a_of_type_JavaLangString = str;
      ((lbl)localObject2).e = n;
      ((lbl)localObject2).jdField_a_of_type_Boolean = paramlbn.jdField_a_of_type_Boolean;
      ((lbl)localObject2).jdField_a_of_type_Long = l;
      return localObject2;
    }
  }
  
  @NonNull
  public lbj a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("QAVConfig_431", 1, "migrateOldOrDefaultContent, type[" + paramInt + "]");
    }
    return new lbj();
  }
  
  @Nullable
  protected lbj a(aqlg[] paramArrayOfaqlg)
  {
    lbj locallbj = new lbj();
    int j = paramArrayOfaqlg.length;
    int i = 0;
    while (i < j)
    {
      aqlg localaqlg = paramArrayOfaqlg[i];
      Object localObject = lbm.a(localaqlg.jdField_a_of_type_JavaLangString);
      boolean bool;
      if ((localObject != null) && (((lbm)localObject).jdField_a_of_type_JavaUtilList != null))
      {
        bool = true;
        if (AudioHelper.f()) {
          QLog.w("QAVConfig_431", 1, "parsed, taskId[" + localaqlg.jdField_a_of_type_Int + "], suc[" + bool + "], oldVersion[" + a() + "]");
        }
        if (bool) {
          localObject = ((lbm)localObject).jdField_a_of_type_JavaUtilList.iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label365;
          }
          lbn locallbn = (lbn)((Iterator)localObject).next();
          lbl locallbl1 = a(locallbn);
          if (locallbl1 == null)
          {
            if (!AudioHelper.f()) {
              continue;
            }
            QLog.w("QAVConfig_431", 1, "parsed, 数据不合法");
            continue;
            bool = false;
            break;
          }
          if (locallbj.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(locallbn.jdField_a_of_type_Int)))
          {
            lbl locallbl2 = (lbl)locallbj.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(locallbn.jdField_a_of_type_Int));
            QLog.w("QAVConfig_431", 1, "parsed, 数据已存在, codec[" + locallbn.jdField_a_of_type_Int + "], _taskId[" + locallbl2.jdField_a_of_type_Int + "], _test_ver[" + locallbl2.e + "], taskId[" + localaqlg.jdField_a_of_type_Int + "], test_ver[" + locallbl1.e + "]");
            if (locallbl1.e <= locallbl2.e) {}
          }
          else
          {
            locallbl1.jdField_a_of_type_Int = localaqlg.jdField_a_of_type_Int;
            locallbj.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(locallbn.jdField_a_of_type_Int), locallbl1);
          }
        }
      }
      label365:
      i += 1;
    }
    return locallbj;
  }
  
  public void a(lbj paramlbj)
  {
    super.onUpdate(paramlbj);
    int i = aqlk.a().a(431, "");
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
        lbl locallbl = (lbl)paramlbj.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k));
        if (locallbl != null)
        {
          int m = lnx.a(locallbl);
          ((HashMap)localObject1).put("test" + k, "1");
          ((HashMap)localObject1).put("test" + k + "_ver", locallbl.e + "");
          ((HashMap)localObject1).put("test" + k + "_flag", m + "");
        }
        i += 1;
      }
      UserAction.onUserAction("qav_codec_config", true, -1L, -1L, (Map)localObject1, true, true);
    }
  }
  
  public Class<lbj> clazz()
  {
    return lbj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lbi
 * JD-Core Version:    0.7.0.1
 */