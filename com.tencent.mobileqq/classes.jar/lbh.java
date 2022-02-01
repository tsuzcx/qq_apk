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

public class lbh
  extends lbq<lbi>
{
  public lbh()
  {
    super(431);
  }
  
  public static lbk a(int paramInt)
  {
    lbi locallbi = (lbi)apub.a().a(431);
    if (locallbi.jdField_a_of_type_JavaUtilHashMap == null) {
      return null;
    }
    return (lbk)locallbi.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  static lbk a(lbm paramlbm)
  {
    int j = paramlbm.jdField_a_of_type_Int;
    if ((j != 1) && (j != 2) && (j != 4) && (j != 8)) {
      return null;
    }
    int k = paramlbm.jdField_b_of_type_Int;
    if (k <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "min_sdk不合法, codec[" + j + "], min_sdk[" + k + "]");
      }
      return null;
    }
    int m = paramlbm.c;
    if (m < 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "async_min_sdk不合法, codec[" + j + "], async_min_sdk[" + m + "]");
      }
      return null;
    }
    String str = paramlbm.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "min_version不合法, codec[" + j + "], min_version[" + str + "]");
      }
      return null;
    }
    int n = paramlbm.d;
    if (n <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "test_ver不合法, codec[" + j + "], test_ver[" + n + "]");
      }
      return null;
    }
    if ((paramlbm.jdField_b_of_type_JavaUtilList == null) || (paramlbm.jdField_b_of_type_JavaUtilList.size() == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "没有样本, codec[" + j + "]");
      }
      return null;
    }
    long l;
    HashMap localHashMap;
    label591:
    lbj locallbj;
    label675:
    Object localObject2;
    try
    {
      Object localObject1 = paramlbm.jdField_b_of_type_JavaLangString;
      localObject3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      ((SimpleDateFormat)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+8"));
      l = ((SimpleDateFormat)localObject3).parse((String)localObject1).getTime();
      localHashMap = new HashMap();
      localObject1 = paramlbm.jdField_b_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label675;
        }
        localObject3 = (lbn)((Iterator)localObject1).next();
        if ((!TextUtils.isEmpty(((lbn)localObject3).c)) && (!TextUtils.isEmpty(((lbn)localObject3).jdField_b_of_type_JavaLangString)))
        {
          if ((j != 1) && (j != 4)) {
            break;
          }
          if (!TextUtils.isEmpty(((lbn)localObject3).jdField_a_of_type_JavaLangString)) {
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
        QLog.w("QAVConfig_431", 1, "没有过期时间, codec[" + j + "], expdate[" + paramlbm.jdField_b_of_type_JavaLangString + "]");
        l = 0L;
        continue;
        if (((j == 2) || (j == 8)) && ((((lbn)localObject3).jdField_a_of_type_Int == 0) || (((lbn)localObject3).jdField_b_of_type_Int == 0)))
        {
          QLog.w("QAVConfig_431", 1, "w/h 为空, codec[" + j + "]");
        }
        else
        {
          locallbj = new lbj();
          locallbj.jdField_b_of_type_JavaLangString = ((lbn)localObject3).jdField_b_of_type_JavaLangString;
          locallbj.c = ((lbn)localObject3).jdField_a_of_type_JavaLangString;
          locallbj.jdField_a_of_type_JavaLangString = ((lbn)localObject3).c;
          locallbj.jdField_a_of_type_Int = ((lbn)localObject3).jdField_a_of_type_Int;
          locallbj.jdField_b_of_type_Int = ((lbn)localObject3).jdField_b_of_type_Int;
          locallbj.jdField_a_of_type_Boolean = paramlbm.jdField_a_of_type_Boolean;
          localHashMap.put(((lbn)localObject3).c, locallbj);
        }
      }
      if (localHashMap.size() == 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("QAVConfig_431", 1, "样本不够, codec[" + j + "]");
        }
        return null;
      }
      locallbj = null;
      localObject2 = null;
      localObject3 = locallbj;
      if (paramlbm.jdField_a_of_type_JavaUtilList == null) {
        break label831;
      }
    }
    Object localObject3 = locallbj;
    int i1;
    if (paramlbm.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      int i = 0;
      for (;;)
      {
        localObject3 = localObject2;
        if (i >= paramlbm.jdField_a_of_type_JavaUtilList.size()) {
          break label831;
        }
        i1 = ((Integer)paramlbm.jdField_a_of_type_JavaUtilList.get(i)).intValue();
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
      localObject2 = new lbk();
      ((lbk)localObject2).jdField_a_of_type_JavaUtilHashMap = localHashMap;
      ((lbk)localObject2).jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject3);
      ((lbk)localObject2).c = k;
      ((lbk)localObject2).d = m;
      ((lbk)localObject2).jdField_b_of_type_Int = j;
      ((lbk)localObject2).jdField_a_of_type_JavaLangString = str;
      ((lbk)localObject2).e = n;
      ((lbk)localObject2).jdField_a_of_type_Boolean = paramlbm.jdField_a_of_type_Boolean;
      ((lbk)localObject2).jdField_a_of_type_Long = l;
      return localObject2;
    }
  }
  
  @NonNull
  public lbi a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("QAVConfig_431", 1, "migrateOldOrDefaultContent, type[" + paramInt + "]");
    }
    return new lbi();
  }
  
  @Nullable
  protected lbi a(aptx[] paramArrayOfaptx)
  {
    lbi locallbi = new lbi();
    int j = paramArrayOfaptx.length;
    int i = 0;
    while (i < j)
    {
      aptx localaptx = paramArrayOfaptx[i];
      Object localObject = lbl.a(localaptx.jdField_a_of_type_JavaLangString);
      boolean bool;
      if ((localObject != null) && (((lbl)localObject).jdField_a_of_type_JavaUtilList != null))
      {
        bool = true;
        if (AudioHelper.f()) {
          QLog.w("QAVConfig_431", 1, "parsed, taskId[" + localaptx.jdField_a_of_type_Int + "], suc[" + bool + "], oldVersion[" + a() + "]");
        }
        if (bool) {
          localObject = ((lbl)localObject).jdField_a_of_type_JavaUtilList.iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label365;
          }
          lbm locallbm = (lbm)((Iterator)localObject).next();
          lbk locallbk1 = a(locallbm);
          if (locallbk1 == null)
          {
            if (!AudioHelper.f()) {
              continue;
            }
            QLog.w("QAVConfig_431", 1, "parsed, 数据不合法");
            continue;
            bool = false;
            break;
          }
          if (locallbi.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(locallbm.jdField_a_of_type_Int)))
          {
            lbk locallbk2 = (lbk)locallbi.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(locallbm.jdField_a_of_type_Int));
            QLog.w("QAVConfig_431", 1, "parsed, 数据已存在, codec[" + locallbm.jdField_a_of_type_Int + "], _taskId[" + locallbk2.jdField_a_of_type_Int + "], _test_ver[" + locallbk2.e + "], taskId[" + localaptx.jdField_a_of_type_Int + "], test_ver[" + locallbk1.e + "]");
            if (locallbk1.e <= locallbk2.e) {}
          }
          else
          {
            locallbk1.jdField_a_of_type_Int = localaptx.jdField_a_of_type_Int;
            locallbi.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(locallbm.jdField_a_of_type_Int), locallbk1);
          }
        }
      }
      label365:
      i += 1;
    }
    return locallbi;
  }
  
  public void a(lbi paramlbi)
  {
    super.onUpdate(paramlbi);
    int i = apub.a().a(431, "");
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
        lbk locallbk = (lbk)paramlbi.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k));
        if (locallbk != null)
        {
          int m = lnu.a(locallbk);
          ((HashMap)localObject1).put("test" + k, "1");
          ((HashMap)localObject1).put("test" + k + "_ver", locallbk.e + "");
          ((HashMap)localObject1).put("test" + k + "_flag", m + "");
        }
        i += 1;
      }
      UserAction.onUserAction("qav_codec_config", true, -1L, -1L, (Map)localObject1, true, true);
    }
  }
  
  public Class<lbi> clazz()
  {
    return lbi.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lbh
 * JD-Core Version:    0.7.0.1
 */