import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.CharSpelling;
import java.util.Comparator;

public class teo
  implements Comparator
{
  public teo(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(tex paramtex1, tex paramtex2)
  {
    paramtex1 = paramtex1.a.name;
    paramtex2 = paramtex2.a.name;
    if ((paramtex1 == null) && (paramtex2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramtex1 == null) && (paramtex2 != null)) {
        return -1;
      }
      if ((paramtex1 != null) && (paramtex2 == null)) {
        return 1;
      }
      j = paramtex1.length();
      k = paramtex2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramtex1.charAt(i);
        char c2 = paramtex2.charAt(i);
        if (c1 != c2)
        {
          paramtex1 = ChnToSpell.a(c1, i);
          paramtex2 = ChnToSpell.a(c2, i);
          if (paramtex1.jdField_a_of_type_Int == paramtex2.jdField_a_of_type_Int) {
            return paramtex1.jdField_a_of_type_JavaLangString.compareTo(paramtex2.jdField_a_of_type_JavaLangString);
          }
          return paramtex1.jdField_a_of_type_Int - paramtex2.jdField_a_of_type_Int;
        }
        i += 1;
      }
      if (j < k) {
        return -1;
      }
    } while (j <= k);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     teo
 * JD-Core Version:    0.7.0.1
 */