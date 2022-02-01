import android.content.Context;
import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import java.util.Iterator;
import java.util.List;

public class nmp
  extends nmo
{
  public nmp(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    super(paramContext, paramAVGameAppInterface);
    this.b = 2;
  }
  
  public int a(nmr[] paramArrayOfnmr, String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = 0;
      while (i < paramArrayOfnmr.length)
      {
        nmr localnmr = paramArrayOfnmr[i];
        String str = localnmr.c();
        if ((paramInt == localnmr.h()) && (paramString.equals(str)) && (localnmr.a() == 0)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public void a(nmr[] paramArrayOfnmr1, nmr[] paramArrayOfnmr2, int paramInt1, int paramInt2, List<niq> paramList)
  {
    for (;;)
    {
      niq localniq;
      nmr localnmr;
      int i;
      int j;
      int k;
      try
      {
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localniq = (niq)localIterator.next();
        if ((!localniq.jdField_a_of_type_Boolean) && (!localniq.jdField_c_of_type_Boolean)) {
          break label307;
        }
        if (localniq.jdField_a_of_type_Boolean)
        {
          paramInt1 = a(paramArrayOfnmr1, String.valueOf(localniq.jdField_a_of_type_Long), localniq.e);
          if (paramInt1 >= 0)
          {
            localnmr = paramArrayOfnmr1[paramInt1];
            localnmr.a(localniq.jdField_a_of_type_Int, localniq.b, localniq.jdField_a_of_type_Int + localniq.jdField_c_of_type_Int, localniq.b + localniq.d);
            localnmr.a(0, 0, 0, 0);
          }
        }
        else
        {
          if (!localniq.jdField_c_of_type_Boolean) {
            continue;
          }
          paramInt1 = a(paramArrayOfnmr1, String.valueOf(localniq.jdField_a_of_type_Long), 2);
          if (paramInt1 < 0) {
            break label276;
          }
          localnmr = paramArrayOfnmr1[paramInt1];
          localnmr.g(false);
          paramInt1 = localniq.f;
          paramInt2 = localniq.g;
          i = localniq.f;
          j = localniq.h;
          k = localniq.g;
          localnmr.a(paramInt1, paramInt2, i + j, localniq.i + k);
          localnmr.a(0, 0, 0, 0);
          continue;
        }
        bjuc.d("AVGameShowScreenLayout", "layout VideoView fail uin:=" + localniq.jdField_a_of_type_Long);
      }
      finally {}
      continue;
      label276:
      bjuc.d("AVGameShowScreenLayout", "layout VideoView fail uin:=" + localniq.jdField_a_of_type_Long);
      continue;
      label307:
      paramInt1 = a(paramArrayOfnmr1, String.valueOf(localniq.jdField_a_of_type_Long), localniq.e);
      if (paramInt1 >= 0) {
        paramArrayOfnmr1[paramInt1].a(0, 0, 0, 0);
      }
      paramInt1 = a(paramArrayOfnmr2, String.valueOf(localniq.jdField_a_of_type_Long), localniq.e);
      if (paramInt1 >= 0)
      {
        localnmr = paramArrayOfnmr2[paramInt1];
        paramInt1 = localniq.jdField_a_of_type_Int;
        paramInt2 = localniq.b;
        i = localniq.jdField_a_of_type_Int;
        j = localniq.jdField_c_of_type_Int;
        k = localniq.b;
        localnmr.a(paramInt1, paramInt2, i + j, localniq.d + k);
        localnmr.a(0, 0, 0, 0);
      }
      else
      {
        bjuc.d("AVGameShowScreenLayout", "layout AudioView fail uin:=" + localniq.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nmp
 * JD-Core Version:    0.7.0.1
 */