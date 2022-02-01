package com.tencent.mobileqq.vas.qqvaluecard.bean;

import android.content.SharedPreferences;
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
    QQValueInfoItem localQQValueInfoItem = new QQValueInfoItem();
    localQQValueInfoItem.jdField_a_of_type_Boolean = false;
    if ((paramObject instanceof qqvalue.UserQQValueInfo)) {
      a((qqvalue.UserQQValueInfo)paramObject, localQQValueInfoItem);
    } else if ((paramObject instanceof VaProfileGate.QQValueInfoItem)) {
      a((VaProfileGate.QQValueInfoItem)paramObject, localQQValueInfoItem);
    } else if ((paramObject instanceof MQQ.QQValueInfoItem)) {
      a((MQQ.QQValueInfoItem)paramObject, localQQValueInfoItem);
    }
    paramObject = (QQValueViewBusiness)QQVasUpdateBusiness.a(QQValueViewBusiness.class);
    if (paramObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramObject.b(localQQValueInfoItem.jdField_a_of_type_JavaLangString));
      localStringBuilder.append("/qqvalue/level_");
      localStringBuilder.append(localQQValueInfoItem.jdField_b_of_type_Int);
      localStringBuilder.append("/");
      localQQValueInfoItem.jdField_c_of_type_JavaLangString = localStringBuilder.toString();
    }
    return localQQValueInfoItem;
  }
  
  public static QQValueInfoItem a(@NonNull String paramString)
  {
    Object localObject2 = BaseApplicationImpl.getApplication();
    QQValueInfoItem localQQValueInfoItem = null;
    if (localObject2 == null) {
      return null;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = localQQValueInfoItem;
    if (localQQAppInterface != null)
    {
      localObject1 = localQQValueInfoItem;
      if (localQQAppInterface.getCurrentUin() != null)
      {
        if (!localQQAppInterface.getCurrentUin().equals(paramString)) {
          return null;
        }
        localQQValueInfoItem = new QQValueInfoItem();
        boolean bool = false;
        localObject1 = ((BaseApplicationImpl)localObject2).getSharedPreferences("sp_vip_qqvalue_info", 0);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("key_info_score");
        ((StringBuilder)localObject2).append(paramString);
        localQQValueInfoItem.jdField_a_of_type_Int = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), 0);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("key_info_level");
        ((StringBuilder)localObject2).append(paramString);
        localQQValueInfoItem.jdField_b_of_type_Int = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), 0);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("key_info_trend");
        ((StringBuilder)localObject2).append(paramString);
        localQQValueInfoItem.jdField_c_of_type_Int = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), 0);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("key_info_material_id");
        ((StringBuilder)localObject2).append(paramString);
        localQQValueInfoItem.jdField_a_of_type_JavaLangString = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), "");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("key_info_url");
        ((StringBuilder)localObject2).append(paramString);
        localQQValueInfoItem.jdField_b_of_type_JavaLangString = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), "");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("key_info_on_off");
        ((StringBuilder)localObject2).append(paramString);
        localQQValueInfoItem.d = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), 1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("key_info_static_show");
        ((StringBuilder)localObject2).append(paramString);
        if (((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), 0) == 1) {
          bool = true;
        }
        localQQValueInfoItem.jdField_a_of_type_Boolean = bool;
        paramString = (QQValueViewBusiness)QQVasUpdateBusiness.a(QQValueViewBusiness.class);
        if (paramString != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString.b(localQQValueInfoItem.jdField_a_of_type_JavaLangString));
          ((StringBuilder)localObject1).append("/qqvalue/level_");
          ((StringBuilder)localObject1).append(localQQValueInfoItem.jdField_b_of_type_Int);
          ((StringBuilder)localObject1).append("/");
          localQQValueInfoItem.jdField_c_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
        }
        localObject1 = localQQValueInfoItem;
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("get sp score:");
          paramString.append(localQQValueInfoItem.jdField_a_of_type_Int);
          paramString.append(" level = ");
          paramString.append(localQQValueInfoItem.jdField_b_of_type_Int);
          paramString.append(" trend = ");
          paramString.append(localQQValueInfoItem.jdField_c_of_type_Int);
          paramString.append("materialId = ");
          paramString.append(localQQValueInfoItem.jdField_a_of_type_JavaLangString);
          paramString.append("url");
          paramString.append(localQQValueInfoItem.jdField_b_of_type_JavaLangString);
          paramString.append("on_off");
          paramString.append(localQQValueInfoItem.d);
          QLog.d("QQValueInfoItem", 1, paramString.toString());
          localObject1 = localQQValueInfoItem;
        }
      }
    }
    return localObject1;
  }
  
  private static void a(MQQ.QQValueInfoItem paramQQValueInfoItem, QQValueInfoItem paramQQValueInfoItem1)
  {
    paramQQValueInfoItem1.jdField_b_of_type_Int = paramQQValueInfoItem.level;
    paramQQValueInfoItem1.jdField_a_of_type_Int = paramQQValueInfoItem.score;
    paramQQValueInfoItem1.jdField_c_of_type_Int = paramQQValueInfoItem.trend;
    paramQQValueInfoItem1.jdField_a_of_type_JavaLangString = paramQQValueInfoItem.material_id;
    paramQQValueInfoItem1.jdField_b_of_type_JavaLangString = paramQQValueInfoItem.url;
    paramQQValueInfoItem1.d = paramQQValueInfoItem.on_off;
    paramQQValueInfoItem = paramQQValueInfoItem.qqvalue_ext_info;
    if ((paramQQValueInfoItem != null) && ("1".equals(paramQQValueInfoItem.get("use_static")))) {
      paramQQValueInfoItem1.jdField_a_of_type_Boolean = true;
    }
  }
  
  private static void a(VaProfileGate.QQValueInfoItem paramQQValueInfoItem, QQValueInfoItem paramQQValueInfoItem1)
  {
    paramQQValueInfoItem1.jdField_b_of_type_Int = paramQQValueInfoItem.level.get();
    paramQQValueInfoItem1.jdField_a_of_type_Int = paramQQValueInfoItem.score.get();
    paramQQValueInfoItem1.jdField_c_of_type_Int = paramQQValueInfoItem.trend.get();
    paramQQValueInfoItem1.jdField_a_of_type_JavaLangString = paramQQValueInfoItem.material_id.get();
    paramQQValueInfoItem1.jdField_b_of_type_JavaLangString = paramQQValueInfoItem.url.get();
    paramQQValueInfoItem1.d = paramQQValueInfoItem.on_off.get();
    if (paramQQValueInfoItem.qqvalue_ext_info.has())
    {
      paramQQValueInfoItem = paramQQValueInfoItem.qqvalue_ext_info.get();
      if (paramQQValueInfoItem != null) {
        return;
      }
      int i = 0;
      while (i < paramQQValueInfoItem.size())
      {
        if (((VaProfileGate.QQValueExtInfo)paramQQValueInfoItem.get(i)).key.get().equals("use_static"))
        {
          paramQQValueInfoItem1.jdField_a_of_type_Boolean = ((VaProfileGate.QQValueExtInfo)paramQQValueInfoItem.get(i)).value.get().equals("1");
          return;
        }
        i += 1;
      }
    }
  }
  
  private static void a(qqvalue.UserQQValueInfo paramUserQQValueInfo, QQValueInfoItem paramQQValueInfoItem)
  {
    paramQQValueInfoItem.jdField_b_of_type_Int = paramUserQQValueInfo.level.get();
    paramQQValueInfoItem.jdField_a_of_type_Int = paramUserQQValueInfo.score.get();
    paramQQValueInfoItem.jdField_c_of_type_Int = paramUserQQValueInfo.trend.get();
    paramQQValueInfoItem.jdField_a_of_type_JavaLangString = paramUserQQValueInfo.material_id.get();
    paramQQValueInfoItem.jdField_b_of_type_JavaLangString = paramUserQQValueInfo.url.get();
    paramQQValueInfoItem.d = paramUserQQValueInfo.on_off.get();
    if (paramUserQQValueInfo.ext_info.has())
    {
      paramUserQQValueInfo = paramUserQQValueInfo.ext_info.get();
      if (paramUserQQValueInfo != null) {
        return;
      }
      int i = 0;
      while (i < paramUserQQValueInfo.size())
      {
        if (((qqvalue.UserQQValueInfo.ExtInfo)paramUserQQValueInfo.get(i)).key.get().equals("use_static"))
        {
          paramQQValueInfoItem.jdField_a_of_type_Boolean = ((qqvalue.UserQQValueInfo.ExtInfo)paramUserQQValueInfo.get(i)).value.get().equals("1");
          return;
        }
        i += 1;
      }
    }
  }
  
  public void a(@NonNull String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean a(QQValueInfoItem paramQQValueInfoItem)
  {
    if (paramQQValueInfoItem == null) {
      return false;
    }
    if (this == paramQQValueInfoItem) {
      return true;
    }
    if (!this.jdField_a_of_type_JavaLangString.equals(paramQQValueInfoItem.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (this.d != paramQQValueInfoItem.d) {
      return false;
    }
    if (this.jdField_a_of_type_Int != paramQQValueInfoItem.jdField_a_of_type_Int) {
      return false;
    }
    if (this.jdField_c_of_type_Int != paramQQValueInfoItem.jdField_c_of_type_Int) {
      return false;
    }
    if (!this.jdField_b_of_type_JavaLangString.equals(paramQQValueInfoItem.jdField_b_of_type_JavaLangString)) {
      return false;
    }
    if (this.jdField_b_of_type_Int != paramQQValueInfoItem.jdField_b_of_type_Int) {
      return false;
    }
    return this.jdField_a_of_type_Boolean == paramQQValueInfoItem.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qqvaluecard.bean.QQValueInfoItem
 * JD-Core Version:    0.7.0.1
 */