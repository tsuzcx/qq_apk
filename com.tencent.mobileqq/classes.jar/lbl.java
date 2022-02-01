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

public class lbl
  extends lbu<lbm>
{
  public lbl()
  {
    super(431);
  }
  
  public static lbo a(int paramInt)
  {
    Object localObject = (lbm)aqxe.a().a(431);
    if (((lbm)localObject).jdField_a_of_type_JavaUtilHashMap == null) {
      localObject = null;
    }
    lbo locallbo;
    do
    {
      return localObject;
      locallbo = (lbo)((lbm)localObject).jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      localObject = locallbo;
    } while (!QLog.isDevelopLevel());
    StringBuilder localStringBuilder = new StringBuilder().append("loadTestInfo, content[");
    if (locallbo != null) {}
    for (localObject = locallbo.toString();; localObject = "")
    {
      QLog.w("QAVConfig_431", 1, (String)localObject + "]");
      return locallbo;
    }
  }
  
  static lbo a(lbq paramlbq)
  {
    int j = paramlbq.jdField_a_of_type_Int;
    if ((j != 1) && (j != 2) && (j != 4) && (j != 8)) {
      return null;
    }
    int k = paramlbq.jdField_b_of_type_Int;
    if (k <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "min_sdk不合法, codec[" + j + "], min_sdk[" + k + "]");
      }
      return null;
    }
    int m = paramlbq.c;
    if (m < 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "async_min_sdk不合法, codec[" + j + "], async_min_sdk[" + m + "]");
      }
      return null;
    }
    String str = paramlbq.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "min_version不合法, codec[" + j + "], min_version[" + str + "]");
      }
      return null;
    }
    int n = paramlbq.d;
    if (n <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "test_ver不合法, codec[" + j + "], test_ver[" + n + "]");
      }
      return null;
    }
    if ((paramlbq.jdField_b_of_type_JavaUtilList == null) || (paramlbq.jdField_b_of_type_JavaUtilList.size() == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "没有样本, codec[" + j + "]");
      }
      return null;
    }
    long l;
    HashMap localHashMap;
    label591:
    lbn locallbn;
    label675:
    Object localObject2;
    try
    {
      Object localObject1 = paramlbq.jdField_b_of_type_JavaLangString;
      localObject3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      ((SimpleDateFormat)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+8"));
      l = ((SimpleDateFormat)localObject3).parse((String)localObject1).getTime();
      localHashMap = new HashMap();
      localObject1 = paramlbq.jdField_b_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label675;
        }
        localObject3 = (lbr)((Iterator)localObject1).next();
        if ((!TextUtils.isEmpty(((lbr)localObject3).c)) && (!TextUtils.isEmpty(((lbr)localObject3).jdField_b_of_type_JavaLangString)))
        {
          if ((j != 1) && (j != 4)) {
            break;
          }
          if (!TextUtils.isEmpty(((lbr)localObject3).jdField_a_of_type_JavaLangString)) {
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
        QLog.w("QAVConfig_431", 1, "没有过期时间, codec[" + j + "], expdate[" + paramlbq.jdField_b_of_type_JavaLangString + "]");
        l = 0L;
        continue;
        if (((j == 2) || (j == 8)) && ((((lbr)localObject3).jdField_a_of_type_Int == 0) || (((lbr)localObject3).jdField_b_of_type_Int == 0)))
        {
          QLog.w("QAVConfig_431", 1, "w/h 为空, codec[" + j + "]");
        }
        else
        {
          locallbn = new lbn();
          locallbn.jdField_b_of_type_JavaLangString = ((lbr)localObject3).jdField_b_of_type_JavaLangString;
          locallbn.c = ((lbr)localObject3).jdField_a_of_type_JavaLangString;
          locallbn.jdField_a_of_type_JavaLangString = ((lbr)localObject3).c;
          locallbn.jdField_a_of_type_Int = ((lbr)localObject3).jdField_a_of_type_Int;
          locallbn.jdField_b_of_type_Int = ((lbr)localObject3).jdField_b_of_type_Int;
          locallbn.jdField_a_of_type_Boolean = paramlbq.jdField_a_of_type_Boolean;
          localHashMap.put(((lbr)localObject3).c, locallbn);
        }
      }
      if (localHashMap.size() == 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("QAVConfig_431", 1, "样本不够, codec[" + j + "]");
        }
        return null;
      }
      locallbn = null;
      localObject2 = null;
      localObject3 = locallbn;
      if (paramlbq.jdField_a_of_type_JavaUtilList == null) {
        break label831;
      }
    }
    Object localObject3 = locallbn;
    int i1;
    if (paramlbq.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      int i = 0;
      for (;;)
      {
        localObject3 = localObject2;
        if (i >= paramlbq.jdField_a_of_type_JavaUtilList.size()) {
          break label831;
        }
        i1 = ((Integer)paramlbq.jdField_a_of_type_JavaUtilList.get(i)).intValue();
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
      localObject2 = new lbo();
      ((lbo)localObject2).jdField_a_of_type_JavaUtilHashMap = localHashMap;
      ((lbo)localObject2).jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject3);
      ((lbo)localObject2).c = k;
      ((lbo)localObject2).d = m;
      ((lbo)localObject2).jdField_b_of_type_Int = j;
      ((lbo)localObject2).jdField_a_of_type_JavaLangString = str;
      ((lbo)localObject2).e = n;
      ((lbo)localObject2).jdField_a_of_type_Boolean = paramlbq.jdField_a_of_type_Boolean;
      ((lbo)localObject2).jdField_a_of_type_Long = l;
      return localObject2;
    }
  }
  
  @NonNull
  public lbm a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("QAVConfig_431", 1, "migrateOldOrDefaultContent, type[" + paramInt + "]");
    }
    return new lbm();
  }
  
  @Nullable
  protected lbm a(aqxa[] paramArrayOfaqxa)
  {
    lbm locallbm = new lbm();
    int j = paramArrayOfaqxa.length;
    int i = 0;
    while (i < j)
    {
      aqxa localaqxa = paramArrayOfaqxa[i];
      Object localObject = lbp.a(localaqxa.jdField_a_of_type_JavaLangString);
      boolean bool;
      if ((localObject != null) && (((lbp)localObject).jdField_a_of_type_JavaUtilList != null))
      {
        bool = true;
        if (AudioHelper.f()) {
          QLog.w("QAVConfig_431", 1, "parsed, taskId[" + localaqxa.jdField_a_of_type_Int + "], suc[" + bool + "], oldVersion[" + a() + "], content[" + localaqxa.jdField_a_of_type_JavaLangString + "]");
        }
        if (bool) {
          localObject = ((lbp)localObject).jdField_a_of_type_JavaUtilList.iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label379;
          }
          lbq locallbq = (lbq)((Iterator)localObject).next();
          lbo locallbo1 = a(locallbq);
          if (locallbo1 == null)
          {
            if (!AudioHelper.f()) {
              continue;
            }
            QLog.w("QAVConfig_431", 1, "parsed, 数据不合法");
            continue;
            bool = false;
            break;
          }
          if (locallbm.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(locallbq.jdField_a_of_type_Int)))
          {
            lbo locallbo2 = (lbo)locallbm.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(locallbq.jdField_a_of_type_Int));
            QLog.w("QAVConfig_431", 1, "parsed, 数据已存在, codec[" + locallbq.jdField_a_of_type_Int + "], _taskId[" + locallbo2.jdField_a_of_type_Int + "], _test_ver[" + locallbo2.e + "], taskId[" + localaqxa.jdField_a_of_type_Int + "], test_ver[" + locallbo1.e + "]");
            if (locallbo1.e <= locallbo2.e) {}
          }
          else
          {
            locallbo1.jdField_a_of_type_Int = localaqxa.jdField_a_of_type_Int;
            locallbm.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(locallbq.jdField_a_of_type_Int), locallbo1);
          }
        }
      }
      label379:
      i += 1;
    }
    return locallbm;
  }
  
  public void a(lbm paramlbm)
  {
    super.onUpdate(paramlbm);
    int i = aqxe.a().a(431, "");
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      Object localObject2 = (QQAppInterface)localObject1;
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("uin", ((QQAppInterface)localObject2).getCurrentAccountUin());
      ((HashMap)localObject1).put("ver", i + "");
      ((HashMap)localObject1).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
      localObject2 = new int[4];
      Object tmp113_111 = localObject2;
      tmp113_111[0] = 1;
      Object tmp117_113 = tmp113_111;
      tmp117_113[1] = 2;
      Object tmp121_117 = tmp117_113;
      tmp121_117[2] = 4;
      Object tmp125_121 = tmp121_117;
      tmp125_121[3] = 8;
      tmp125_121;
      int j = localObject2.length;
      i = 0;
      while (i < j)
      {
        int k = localObject2[i];
        lbo locallbo = (lbo)paramlbm.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k));
        if (locallbo != null)
        {
          int m = loh.a(locallbo);
          ((HashMap)localObject1).put("test" + k, "1");
          ((HashMap)localObject1).put("test" + k + "_ver", locallbo.e + "");
          ((HashMap)localObject1).put("test" + k + "_flag", m + "");
        }
        i += 1;
      }
      UserAction.onUserAction("qav_codec_config", true, -1L, -1L, (Map)localObject1, true, true);
    }
  }
  
  public Class<lbm> clazz()
  {
    return lbm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lbl
 * JD-Core Version:    0.7.0.1
 */