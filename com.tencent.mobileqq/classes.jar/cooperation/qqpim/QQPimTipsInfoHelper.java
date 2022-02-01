package cooperation.qqpim;

import android.content.Context;
import android.text.TextUtils;

public class QQPimTipsInfoHelper
{
  public static void a(Context paramContext, QQPimTipsInfo paramQQPimTipsInfo)
  {
    if (paramQQPimTipsInfo == null)
    {
      QQPimSharedPrefrenceUtil.a(paramContext, "QQPIM_TIPS_CLICK", System.currentTimeMillis());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QQPIM_TIPS_CLICK");
    ((StringBuilder)localObject).append(paramQQPimTipsInfo.jdField_a_of_type_Int);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQQPimTipsInfo.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(";");
    localStringBuilder.append(paramQQPimTipsInfo.b);
    localStringBuilder.append(";");
    localStringBuilder.append(System.currentTimeMillis());
    QQPimSharedPrefrenceUtil.a(paramContext, (String)localObject, localStringBuilder.toString());
  }
  
  public static void b(Context paramContext, QQPimTipsInfo paramQQPimTipsInfo)
  {
    if (paramQQPimTipsInfo == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQPIM_TIPS_CLICK");
    localStringBuilder.append(paramQQPimTipsInfo.jdField_a_of_type_Int);
    if (TextUtils.isEmpty(QQPimSharedPrefrenceUtil.a(paramContext, localStringBuilder.toString()))) {
      return;
    }
    int i = paramQQPimTipsInfo.jdField_a_of_type_Int;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4) {
          return;
        }
        paramQQPimTipsInfo.jdField_a_of_type_Byte = 0;
        return;
      }
      paramQQPimTipsInfo.jdField_a_of_type_Byte = 0;
      return;
    }
    paramQQPimTipsInfo.jdField_a_of_type_Byte = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqpim.QQPimTipsInfoHelper
 * JD-Core Version:    0.7.0.1
 */