import android.content.Context;
import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import java.util.Iterator;
import java.util.List;

public class ncy
  extends ncx
{
  public ncy(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    super(paramContext, paramAVGameAppInterface);
    this.b = 2;
  }
  
  public int a(nda[] paramArrayOfnda, String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = 0;
      while (i < paramArrayOfnda.length)
      {
        nda localnda = paramArrayOfnda[i];
        String str = localnda.b();
        if ((paramInt == localnda.h()) && (paramString.equals(str)) && (localnda.a() == 0)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public void a(nda[] paramArrayOfnda1, nda[] paramArrayOfnda2, int paramInt1, int paramInt2, List<nan> paramList)
  {
    for (;;)
    {
      nan localnan;
      nda localnda;
      int i;
      int j;
      int k;
      try
      {
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localnan = (nan)localIterator.next();
        if ((!localnan.jdField_a_of_type_Boolean) && (!localnan.jdField_c_of_type_Boolean)) {
          break label307;
        }
        if (localnan.jdField_a_of_type_Boolean)
        {
          paramInt1 = a(paramArrayOfnda1, String.valueOf(localnan.jdField_a_of_type_Long), localnan.e);
          if (paramInt1 >= 0)
          {
            localnda = paramArrayOfnda1[paramInt1];
            localnda.a(localnan.jdField_a_of_type_Int, localnan.b, localnan.jdField_a_of_type_Int + localnan.jdField_c_of_type_Int, localnan.b + localnan.d);
            localnda.a(0, 0, 0, 0);
          }
        }
        else
        {
          if (!localnan.jdField_c_of_type_Boolean) {
            continue;
          }
          paramInt1 = a(paramArrayOfnda1, String.valueOf(localnan.jdField_a_of_type_Long), 2);
          if (paramInt1 < 0) {
            break label276;
          }
          localnda = paramArrayOfnda1[paramInt1];
          localnda.f(false);
          paramInt1 = localnan.f;
          paramInt2 = localnan.g;
          i = localnan.f;
          j = localnan.h;
          k = localnan.g;
          localnda.a(paramInt1, paramInt2, i + j, localnan.i + k);
          localnda.a(0, 0, 0, 0);
          continue;
        }
        bjcq.d("AVGameShowScreenLayout", "layout VideoView fail uin:=" + localnan.jdField_a_of_type_Long);
      }
      finally {}
      continue;
      label276:
      bjcq.d("AVGameShowScreenLayout", "layout VideoView fail uin:=" + localnan.jdField_a_of_type_Long);
      continue;
      label307:
      paramInt1 = a(paramArrayOfnda1, String.valueOf(localnan.jdField_a_of_type_Long), localnan.e);
      if (paramInt1 >= 0) {
        paramArrayOfnda1[paramInt1].a(0, 0, 0, 0);
      }
      paramInt1 = a(paramArrayOfnda2, String.valueOf(localnan.jdField_a_of_type_Long), localnan.e);
      if (paramInt1 >= 0)
      {
        localnda = paramArrayOfnda2[paramInt1];
        paramInt1 = localnan.jdField_a_of_type_Int;
        paramInt2 = localnan.b;
        i = localnan.jdField_a_of_type_Int;
        j = localnan.jdField_c_of_type_Int;
        k = localnan.b;
        localnda.a(paramInt1, paramInt2, i + j, localnan.d + k);
        localnda.a(0, 0, 0, 0);
      }
      else
      {
        bjcq.d("AVGameShowScreenLayout", "layout AudioView fail uin:=" + localnan.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ncy
 * JD-Core Version:    0.7.0.1
 */