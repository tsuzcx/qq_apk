package com.tencent.mobileqq.vas.qqvaluecard.bean;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.updatesystem.business.QQValueViewBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.pb.profilecard.VaProfileGate.QQValueExtInfo;
import com.tencent.pb.profilecard.VaProfileGate.QQValueInfoItem;
import com.tencent.pb.qqvalue.qqvalue.UserQQValueInfo;
import com.tencent.pb.qqvalue.qqvalue.UserQQValueInfo.ExtInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

public class QQValueInfoItem
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d = 1;
  
  public QQValueInfoItem()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public static QQValueInfoItem a(Object paramObject)
  {
    int j = 0;
    int i = 0;
    QQValueInfoItem localQQValueInfoItem = new QQValueInfoItem();
    localQQValueInfoItem.jdField_a_of_type_Boolean = false;
    if ((paramObject instanceof qqvalue.UserQQValueInfo))
    {
      localQQValueInfoItem.jdField_b_of_type_Int = ((qqvalue.UserQQValueInfo)paramObject).level.get();
      localQQValueInfoItem.jdField_a_of_type_Int = ((qqvalue.UserQQValueInfo)paramObject).score.get();
      localQQValueInfoItem.jdField_c_of_type_Int = ((qqvalue.UserQQValueInfo)paramObject).trend.get();
      localQQValueInfoItem.jdField_a_of_type_JavaLangString = ((qqvalue.UserQQValueInfo)paramObject).material_id.get();
      localQQValueInfoItem.jdField_b_of_type_JavaLangString = ((qqvalue.UserQQValueInfo)paramObject).url.get();
      localQQValueInfoItem.d = ((qqvalue.UserQQValueInfo)paramObject).on_off.get();
      if (((qqvalue.UserQQValueInfo)paramObject).ext_info.has())
      {
        paramObject = ((qqvalue.UserQQValueInfo)paramObject).ext_info.get();
        if (paramObject != null) {
          if (i < paramObject.size())
          {
            if (!((qqvalue.UserQQValueInfo.ExtInfo)paramObject.get(i)).key.get().equals("use_static")) {
              break label252;
            }
            localQQValueInfoItem.jdField_a_of_type_Boolean = ((qqvalue.UserQQValueInfo.ExtInfo)paramObject.get(i)).value.get().equals("1");
          }
        }
      }
    }
    for (;;)
    {
      paramObject = (QQValueViewBusiness)QQVasUpdateBusiness.a(QQValueViewBusiness.class);
      if (paramObject != null) {
        localQQValueInfoItem.jdField_c_of_type_JavaLangString = (paramObject.b(localQQValueInfoItem.jdField_a_of_type_JavaLangString) + "/qqvalue/level_" + localQQValueInfoItem.jdField_b_of_type_Int + "/");
      }
      return localQQValueInfoItem;
      label252:
      i += 1;
      break;
      if ((paramObject instanceof VaProfileGate.QQValueInfoItem))
      {
        localQQValueInfoItem.jdField_b_of_type_Int = ((VaProfileGate.QQValueInfoItem)paramObject).level.get();
        localQQValueInfoItem.jdField_a_of_type_Int = ((VaProfileGate.QQValueInfoItem)paramObject).score.get();
        localQQValueInfoItem.jdField_c_of_type_Int = ((VaProfileGate.QQValueInfoItem)paramObject).trend.get();
        localQQValueInfoItem.jdField_a_of_type_JavaLangString = ((VaProfileGate.QQValueInfoItem)paramObject).material_id.get();
        localQQValueInfoItem.jdField_b_of_type_JavaLangString = ((VaProfileGate.QQValueInfoItem)paramObject).url.get();
        localQQValueInfoItem.d = ((VaProfileGate.QQValueInfoItem)paramObject).on_off.get();
        if (((VaProfileGate.QQValueInfoItem)paramObject).qqvalue_ext_info.has())
        {
          paramObject = ((VaProfileGate.QQValueInfoItem)paramObject).qqvalue_ext_info.get();
          if (paramObject != null)
          {
            i = j;
            for (;;)
            {
              if (i >= paramObject.size()) {
                break label447;
              }
              if (((VaProfileGate.QQValueExtInfo)paramObject.get(i)).key.get().equals("use_static"))
              {
                localQQValueInfoItem.jdField_a_of_type_Boolean = ((VaProfileGate.QQValueExtInfo)paramObject.get(i)).value.get().equals("1");
                break;
              }
              i += 1;
            }
          }
        }
      }
      else
      {
        label447:
        if ((paramObject instanceof MQQ.QQValueInfoItem))
        {
          localQQValueInfoItem.jdField_b_of_type_Int = ((MQQ.QQValueInfoItem)paramObject).level;
          localQQValueInfoItem.jdField_a_of_type_Int = ((MQQ.QQValueInfoItem)paramObject).score;
          localQQValueInfoItem.jdField_c_of_type_Int = ((MQQ.QQValueInfoItem)paramObject).trend;
          localQQValueInfoItem.jdField_a_of_type_JavaLangString = ((MQQ.QQValueInfoItem)paramObject).material_id;
          localQQValueInfoItem.jdField_b_of_type_JavaLangString = ((MQQ.QQValueInfoItem)paramObject).url;
          localQQValueInfoItem.d = ((MQQ.QQValueInfoItem)paramObject).on_off;
          paramObject = ((MQQ.QQValueInfoItem)paramObject).qqvalue_ext_info;
          if ((paramObject != null) && ("1".equals(paramObject.get("use_static")))) {
            localQQValueInfoItem.jdField_a_of_type_Boolean = true;
          }
        }
      }
    }
  }
  
  public static QQValueInfoItem a(@NonNull String paramString)
  {
    Object localObject2 = BaseApplicationImpl.getApplication();
    if (localObject2 == null) {
      return null;
    }
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 == null) || (((QQAppInterface)localObject1).getCurrentUin() == null) || (!((QQAppInterface)localObject1).getCurrentUin().equals(paramString))) {
      return null;
    }
    localObject1 = new QQValueInfoItem();
    localObject2 = ((BaseApplicationImpl)localObject2).getSharedPreferences("sp_vip_qqvalue_info", 0);
    ((QQValueInfoItem)localObject1).jdField_a_of_type_Int = ((SharedPreferences)localObject2).getInt("key_info_score" + paramString, 0);
    ((QQValueInfoItem)localObject1).jdField_b_of_type_Int = ((SharedPreferences)localObject2).getInt("key_info_level" + paramString, 0);
    ((QQValueInfoItem)localObject1).jdField_c_of_type_Int = ((SharedPreferences)localObject2).getInt("key_info_trend" + paramString, 0);
    ((QQValueInfoItem)localObject1).jdField_a_of_type_JavaLangString = ((SharedPreferences)localObject2).getString("key_info_material_id" + paramString, "");
    ((QQValueInfoItem)localObject1).jdField_b_of_type_JavaLangString = ((SharedPreferences)localObject2).getString("key_info_url" + paramString, "");
    ((QQValueInfoItem)localObject1).d = ((SharedPreferences)localObject2).getInt("key_info_on_off" + paramString, 1);
    if (((SharedPreferences)localObject2).getInt("key_info_static_show" + paramString, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((QQValueInfoItem)localObject1).jdField_a_of_type_Boolean = bool;
      paramString = (QQValueViewBusiness)QQVasUpdateBusiness.a(QQValueViewBusiness.class);
      if (paramString != null) {
        ((QQValueInfoItem)localObject1).jdField_c_of_type_JavaLangString = (paramString.b(((QQValueInfoItem)localObject1).jdField_a_of_type_JavaLangString) + "/qqvalue/level_" + ((QQValueInfoItem)localObject1).jdField_b_of_type_Int + "/");
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQValueInfoItem", 1, "get sp score:" + ((QQValueInfoItem)localObject1).jdField_a_of_type_Int + " level = " + ((QQValueInfoItem)localObject1).jdField_b_of_type_Int + " trend = " + ((QQValueInfoItem)localObject1).jdField_c_of_type_Int + "materialId = " + ((QQValueInfoItem)localObject1).jdField_a_of_type_JavaLangString + "url" + ((QQValueInfoItem)localObject1).jdField_b_of_type_JavaLangString + "on_off" + ((QQValueInfoItem)localObject1).d);
      }
      return localObject1;
    }
  }
  
  public void a(@NonNull String paramString)
  {
    Object localObject1 = BaseApplicationImpl.getApplication();
    if (localObject1 == null) {}
    do
    {
      return;
      localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while ((localObject2 == null) || (((QQAppInterface)localObject2).getCurrentUin() == null) || (!((QQAppInterface)localObject2).getCurrentUin().equals(paramString)));
    localObject1 = ((BaseApplicationImpl)localObject1).getSharedPreferences("sp_vip_qqvalue_info", 0);
    Object localObject2 = "key_info_score" + paramString;
    ((SharedPreferences)localObject1).edit().putInt((String)localObject2, this.jdField_a_of_type_Int);
    localObject2 = "key_info_level" + paramString;
    ((SharedPreferences)localObject1).edit().putInt((String)localObject2, this.jdField_b_of_type_Int);
    localObject2 = "key_info_trend" + paramString;
    ((SharedPreferences)localObject1).edit().putInt((String)localObject2, this.jdField_c_of_type_Int);
    localObject2 = "key_info_material_id" + paramString;
    ((SharedPreferences)localObject1).edit().putString((String)localObject2, this.jdField_a_of_type_JavaLangString);
    localObject2 = "key_info_url" + paramString;
    ((SharedPreferences)localObject1).edit().putString((String)localObject2, this.jdField_b_of_type_JavaLangString);
    localObject2 = "key_info_on_off" + paramString;
    ((SharedPreferences)localObject1).edit().putInt((String)localObject2, this.d);
    paramString = "key_info_static_show" + paramString;
    localObject2 = ((SharedPreferences)localObject1).edit();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      ((SharedPreferences.Editor)localObject2).putInt(paramString, i);
      ((SharedPreferences)localObject1).edit().commit();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQValueInfoItem", 1, "save sp score:" + this.jdField_a_of_type_Int + " level = " + this.jdField_b_of_type_Int + " trend = " + this.jdField_c_of_type_Int + "materialId = " + this.jdField_a_of_type_JavaLangString + "url" + this.jdField_b_of_type_JavaLangString + "on_off" + this.d);
      return;
    }
  }
  
  public boolean a(QQValueInfoItem paramQQValueInfoItem)
  {
    if (paramQQValueInfoItem == null) {}
    do
    {
      return false;
      if (this == paramQQValueInfoItem) {
        return true;
      }
    } while ((!this.jdField_a_of_type_JavaLangString.equals(paramQQValueInfoItem.jdField_a_of_type_JavaLangString)) || (this.d != paramQQValueInfoItem.d) || (this.jdField_a_of_type_Int != paramQQValueInfoItem.jdField_a_of_type_Int) || (this.jdField_c_of_type_Int != paramQQValueInfoItem.jdField_c_of_type_Int) || (!this.jdField_b_of_type_JavaLangString.equals(paramQQValueInfoItem.jdField_b_of_type_JavaLangString)) || (this.jdField_b_of_type_Int != paramQQValueInfoItem.jdField_b_of_type_Int) || (this.jdField_a_of_type_Boolean != paramQQValueInfoItem.jdField_a_of_type_Boolean));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qqvaluecard.bean.QQValueInfoItem
 * JD-Core Version:    0.7.0.1
 */