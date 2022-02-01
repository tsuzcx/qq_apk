import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class nia
  extends low
{
  public nia(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  public nia(nia paramnia)
  {
    if (paramnia != null)
    {
      this.jdField_a_of_type_Int = paramnia.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramnia.jdField_b_of_type_Int;
      this.jdField_a_of_type_Float = paramnia.jdField_a_of_type_Float;
      this.jdField_b_of_type_Float = paramnia.jdField_b_of_type_Float;
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramString[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          int k = localObject.indexOf('=');
          if ((k > 0) && (k < localObject.length()))
          {
            String str;
            float f;
            try
            {
              str = localObject.substring(0, k);
              f = Float.parseFloat(localObject.substring(k + 1));
              if (!"MemoryLimit".equalsIgnoreCase(str)) {
                break label129;
              }
              this.jdField_b_of_type_Float = f;
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
              QLog.e("AvGameMachineLevelUtils", 2, localThrowable.toString());
            }
            continue;
            label129:
            if ("CpuNumLimit".equalsIgnoreCase(str)) {
              this.jdField_b_of_type_Int = ((int)f);
            } else if ("CpuFreqLimit".equalsIgnoreCase(str)) {
              this.jdField_a_of_type_Float = f;
            } else if ("APILevelLimit".equalsIgnoreCase(str)) {
              this.jdField_a_of_type_Int = ((int)f);
            }
          }
        }
      }
    }
  }
  
  public boolean a(@NonNull low paramlow)
  {
    return (this.jdField_a_of_type_Int <= paramlow.jdField_a_of_type_Int) && (this.jdField_b_of_type_Int <= paramlow.jdField_b_of_type_Int) && (this.jdField_a_of_type_Float <= paramlow.jdField_a_of_type_Float) && (this.jdField_b_of_type_Float <= paramlow.jdField_b_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nia
 * JD-Core Version:    0.7.0.1
 */