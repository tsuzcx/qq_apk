import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class suk
{
  public static int a(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 == paramLong2) {
      return 0;
    }
    return 1;
  }
  
  public static ssm a(@NonNull List<ssm> paramList1, @NonNull List<ssm> paramList2, @NonNull String paramString)
  {
    paramList2.clear();
    ssm localssm = null;
    Iterator localIterator = paramList1.iterator();
    paramList1 = localssm;
    if (localIterator.hasNext())
    {
      localssm = (ssm)localIterator.next();
      if (a(localssm)) {
        paramList2.add(localssm);
      }
      if ((paramList1 != null) || (!TextUtils.equals(paramString, localssm.jdField_a_of_type_JavaLangString))) {
        break label76;
      }
      paramList1 = localssm;
    }
    label76:
    for (;;)
    {
      break;
      return paramList1;
    }
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT > 19;
  }
  
  public static boolean a(ssm paramssm)
  {
    return (paramssm.jdField_a_of_type_Int == 5) || (paramssm.jdField_a_of_type_Int == 6) || (paramssm.jdField_a_of_type_Int == 7) || (paramssm.jdField_a_of_type_Int == 8) || (paramssm.jdField_a_of_type_Int == 9) || (paramssm.jdField_a_of_type_Int == 12) || (paramssm.jdField_a_of_type_Int == 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     suk
 * JD-Core Version:    0.7.0.1
 */