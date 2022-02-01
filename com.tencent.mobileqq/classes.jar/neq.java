import android.content.Context;
import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import java.util.Iterator;
import java.util.List;

public class neq
  extends nep
{
  public neq(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    super(paramContext, paramAVGameAppInterface);
    this.b = 2;
  }
  
  public int a(nes[] paramArrayOfnes, String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = 0;
      while (i < paramArrayOfnes.length)
      {
        nes localnes = paramArrayOfnes[i];
        String str = localnes.b();
        if ((paramInt == localnes.h()) && (paramString.equals(str)) && (localnes.a() == 0)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public void a(nes[] paramArrayOfnes1, nes[] paramArrayOfnes2, int paramInt1, int paramInt2, List<nbr> paramList)
  {
    for (;;)
    {
      nbr localnbr;
      nes localnes;
      int i;
      int j;
      int k;
      try
      {
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localnbr = (nbr)localIterator.next();
        if ((!localnbr.jdField_a_of_type_Boolean) && (!localnbr.jdField_c_of_type_Boolean)) {
          break label307;
        }
        if (localnbr.jdField_a_of_type_Boolean)
        {
          paramInt1 = a(paramArrayOfnes1, String.valueOf(localnbr.jdField_a_of_type_Long), localnbr.e);
          if (paramInt1 >= 0)
          {
            localnes = paramArrayOfnes1[paramInt1];
            localnes.a(localnbr.jdField_a_of_type_Int, localnbr.b, localnbr.jdField_a_of_type_Int + localnbr.jdField_c_of_type_Int, localnbr.b + localnbr.d);
            localnes.a(0, 0, 0, 0);
          }
        }
        else
        {
          if (!localnbr.jdField_c_of_type_Boolean) {
            continue;
          }
          paramInt1 = a(paramArrayOfnes1, String.valueOf(localnbr.jdField_a_of_type_Long), 2);
          if (paramInt1 < 0) {
            break label276;
          }
          localnes = paramArrayOfnes1[paramInt1];
          localnes.f(false);
          paramInt1 = localnbr.f;
          paramInt2 = localnbr.g;
          i = localnbr.f;
          j = localnbr.h;
          k = localnbr.g;
          localnes.a(paramInt1, paramInt2, i + j, localnbr.i + k);
          localnes.a(0, 0, 0, 0);
          continue;
        }
        bkdp.d("AVGameShowScreenLayout", "layout VideoView fail uin:=" + localnbr.jdField_a_of_type_Long);
      }
      finally {}
      continue;
      label276:
      bkdp.d("AVGameShowScreenLayout", "layout VideoView fail uin:=" + localnbr.jdField_a_of_type_Long);
      continue;
      label307:
      paramInt1 = a(paramArrayOfnes1, String.valueOf(localnbr.jdField_a_of_type_Long), localnbr.e);
      if (paramInt1 >= 0) {
        paramArrayOfnes1[paramInt1].a(0, 0, 0, 0);
      }
      paramInt1 = a(paramArrayOfnes2, String.valueOf(localnbr.jdField_a_of_type_Long), localnbr.e);
      if (paramInt1 >= 0)
      {
        localnes = paramArrayOfnes2[paramInt1];
        paramInt1 = localnbr.jdField_a_of_type_Int;
        paramInt2 = localnbr.b;
        i = localnbr.jdField_a_of_type_Int;
        j = localnbr.jdField_c_of_type_Int;
        k = localnbr.b;
        localnes.a(paramInt1, paramInt2, i + j, localnbr.d + k);
        localnes.a(0, 0, 0, 0);
      }
      else
      {
        bkdp.d("AVGameShowScreenLayout", "layout AudioView fail uin:=" + localnbr.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     neq
 * JD-Core Version:    0.7.0.1
 */