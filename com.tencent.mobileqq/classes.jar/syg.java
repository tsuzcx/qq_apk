import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class syg
{
  public static final String a;
  int a;
  public List<byte[]> a;
  public syi a;
  public sys<Bitmap> a;
  int jdField_b_of_type_Int = 0;
  final List<SoftReference<Bitmap>> jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  
  static
  {
    jdField_a_of_type_JavaLangString = "zimage." + syg.class.getSimpleName();
  }
  
  syg(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
    this.jdField_a_of_type_Syi = new syi(2097152);
    this.jdField_a_of_type_Int = 0;
    while (paramInt < 5)
    {
      this.jdField_a_of_type_JavaUtilList.add(new byte[16384]);
      paramInt += 1;
    }
    this.jdField_a_of_type_Sys = new syh(this);
  }
  
  public Bitmap a(BitmapFactory.Options paramOptions)
  {
    for (;;)
    {
      int i;
      try
      {
        this.jdField_b_of_type_Int += 1;
        ArrayList localArrayList = new ArrayList();
        List localList = this.jdField_b_of_type_JavaUtilList;
        i = 0;
        try
        {
          if (i < this.jdField_b_of_type_JavaUtilList.size())
          {
            localBitmap = (Bitmap)((SoftReference)this.jdField_b_of_type_JavaUtilList.get(i)).get();
            if (localBitmap != null)
            {
              if (syv.a(localBitmap, paramOptions))
              {
                localArrayList.add(this.jdField_b_of_type_JavaUtilList.get(i));
                str = "cache";
                if (!localArrayList.isEmpty()) {
                  this.jdField_b_of_type_JavaUtilList.removeAll(localArrayList);
                }
                if (localBitmap != null) {
                  this.jdField_a_of_type_Int += 1;
                }
                if (QLog.isColorLevel()) {
                  syv.a(jdField_a_of_type_JavaLangString, "getReuseableBitmap found:" + str + " picSize:" + paramOptions.outWidth + "x" + paramOptions.outHeight + " bitmap:" + localBitmap + " state:" + toString());
                }
                return localBitmap;
              }
            }
            else {
              localArrayList.add(this.jdField_b_of_type_JavaUtilList.get(i));
            }
          }
        }
        finally {}
        String str = "notFound";
      }
      finally {}
      Bitmap localBitmap = null;
      continue;
      i += 1;
    }
  }
  
  syk a(syo paramsyo)
  {
    if (paramsyo == null) {}
    do
    {
      return null;
      paramsyo = bfuj.a(paramsyo.a());
    } while (paramsyo == null);
    try
    {
      if (paramsyo.a())
      {
        syk localsyk = paramsyo.a();
        return localsyk;
      }
    }
    finally {}
    return null;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Syi.a();
      this.jdField_b_of_type_JavaUtilList.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(syo paramsyo, syk paramsyk)
  {
    if (paramsyo == null) {}
    for (;;)
    {
      return;
      try
      {
        bfuj.a(paramsyo.a(), paramsyk);
      }
      finally {}
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("total:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" reuse:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    if (this.jdField_b_of_type_Int > 0) {
      localStringBuilder.append(" rate:").append(this.jdField_a_of_type_Int / this.jdField_b_of_type_Int);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     syg
 * JD-Core Version:    0.7.0.1
 */