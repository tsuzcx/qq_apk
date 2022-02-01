import android.content.Context;
import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import java.util.Iterator;
import java.util.List;

public class nfx
  extends nfw
{
  public nfx(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    super(paramContext, paramAVGameAppInterface);
    this.b = 2;
  }
  
  public int a(nfz[] paramArrayOfnfz, String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = 0;
      while (i < paramArrayOfnfz.length)
      {
        nfz localnfz = paramArrayOfnfz[i];
        String str = localnfz.b();
        if ((paramInt == localnfz.h()) && (paramString.equals(str)) && (localnfz.a() == 0)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public void a(nfz[] paramArrayOfnfz1, nfz[] paramArrayOfnfz2, int paramInt1, int paramInt2, List<ncs> paramList)
  {
    for (;;)
    {
      ncs localncs;
      nfz localnfz;
      int i;
      int j;
      int k;
      try
      {
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localncs = (ncs)localIterator.next();
        if ((!localncs.jdField_a_of_type_Boolean) && (!localncs.jdField_c_of_type_Boolean)) {
          break label307;
        }
        if (localncs.jdField_a_of_type_Boolean)
        {
          paramInt1 = a(paramArrayOfnfz1, String.valueOf(localncs.jdField_a_of_type_Long), localncs.e);
          if (paramInt1 >= 0)
          {
            localnfz = paramArrayOfnfz1[paramInt1];
            localnfz.a(localncs.jdField_a_of_type_Int, localncs.b, localncs.jdField_a_of_type_Int + localncs.jdField_c_of_type_Int, localncs.b + localncs.d);
            localnfz.a(0, 0, 0, 0);
          }
        }
        else
        {
          if (!localncs.jdField_c_of_type_Boolean) {
            continue;
          }
          paramInt1 = a(paramArrayOfnfz1, String.valueOf(localncs.jdField_a_of_type_Long), 2);
          if (paramInt1 < 0) {
            break label276;
          }
          localnfz = paramArrayOfnfz1[paramInt1];
          localnfz.f(false);
          paramInt1 = localncs.f;
          paramInt2 = localncs.g;
          i = localncs.f;
          j = localncs.h;
          k = localncs.g;
          localnfz.a(paramInt1, paramInt2, i + j, localncs.i + k);
          localnfz.a(0, 0, 0, 0);
          continue;
        }
        bija.d("AVGameShowScreenLayout", "layout VideoView fail uin:=" + localncs.jdField_a_of_type_Long);
      }
      finally {}
      continue;
      label276:
      bija.d("AVGameShowScreenLayout", "layout VideoView fail uin:=" + localncs.jdField_a_of_type_Long);
      continue;
      label307:
      paramInt1 = a(paramArrayOfnfz1, String.valueOf(localncs.jdField_a_of_type_Long), localncs.e);
      if (paramInt1 >= 0) {
        paramArrayOfnfz1[paramInt1].a(0, 0, 0, 0);
      }
      paramInt1 = a(paramArrayOfnfz2, String.valueOf(localncs.jdField_a_of_type_Long), localncs.e);
      if (paramInt1 >= 0)
      {
        localnfz = paramArrayOfnfz2[paramInt1];
        paramInt1 = localncs.jdField_a_of_type_Int;
        paramInt2 = localncs.b;
        i = localncs.jdField_a_of_type_Int;
        j = localncs.jdField_c_of_type_Int;
        k = localncs.b;
        localnfz.a(paramInt1, paramInt2, i + j, localncs.d + k);
        localnfz.a(0, 0, 0, 0);
      }
      else
      {
        bija.d("AVGameShowScreenLayout", "layout AudioView fail uin:=" + localncs.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nfx
 * JD-Core Version:    0.7.0.1
 */