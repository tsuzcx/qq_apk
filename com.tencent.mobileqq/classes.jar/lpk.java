import android.support.annotation.NonNull;
import android.text.TextUtils;

public class lpk
  extends lpj
{
  public lpk(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
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
                break label118;
              }
              this.jdField_b_of_type_Float = f;
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
            continue;
            label118:
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
  
  public boolean a(@NonNull lpj paramlpj)
  {
    return (this.jdField_a_of_type_Int <= paramlpj.jdField_a_of_type_Int) && (this.jdField_b_of_type_Int <= paramlpj.jdField_b_of_type_Int) && (this.jdField_a_of_type_Float <= paramlpj.jdField_a_of_type_Float) && (this.jdField_b_of_type_Float <= paramlpj.jdField_b_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lpk
 * JD-Core Version:    0.7.0.1
 */