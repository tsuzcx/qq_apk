import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;

public class llb
{
  public int a;
  public long a;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  long[] jdField_a_of_type_ArrayOfLong = new long[41];
  public int b;
  public long b;
  public String b;
  public long c;
  public String c;
  public String d;
  
  llb()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_d_of_type_JavaLangString = "KilledBySystem";
  }
  
  public String a()
  {
    String str1 = Build.MODEL;
    String str2 = String.valueOf(Build.VERSION.SDK_INT);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Android").append('|');
    localStringBuilder.append(str1).append('|');
    localStringBuilder.append(str2).append('|');
    localStringBuilder.append(str2).append('|');
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString).append('|');
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString).append('|');
    if (this.jdField_b_of_type_Int != -1) {
      localStringBuilder.append(this.jdField_b_of_type_Int).append('|');
    }
    for (;;)
    {
      localStringBuilder.append(this.jdField_a_of_type_Int).append('|');
      return localStringBuilder.toString();
      localStringBuilder.append(String.valueOf(this.jdField_a_of_type_ArrayOfLong[20])).append('|');
    }
  }
  
  public String a(int paramInt, long paramLong)
  {
    if ((paramInt >= 0) && (paramInt < 41))
    {
      StringBuilder localStringBuilder;
      if (paramLong == 1L)
      {
        this.jdField_a_of_type_ArrayOfLong[paramInt] = 1L;
        localStringBuilder = new StringBuilder();
        paramInt = 0;
        label34:
        if (paramInt >= 41) {
          break label242;
        }
        switch (paramInt)
        {
        default: 
          localStringBuilder.append(String.valueOf(this.jdField_a_of_type_ArrayOfLong[paramInt])).append('|');
        }
      }
      for (;;)
      {
        paramInt += 1;
        break label34;
        this.jdField_a_of_type_ArrayOfLong[paramInt] = paramLong;
        break;
        if (this.jdField_a_of_type_ArrayOfLong[14] == 0L)
        {
          this.jdField_a_of_type_JavaLangString = lkz.a();
          this.jdField_a_of_type_ArrayOfLong[14] = 1L;
        }
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString).append('|');
        continue;
        localStringBuilder.append(this.jdField_d_of_type_JavaLangString).append('|');
        continue;
        localStringBuilder.append(0).append('|');
        continue;
        if (this.jdField_b_of_type_Long > 0L) {
          this.jdField_c_of_type_Long = ((System.currentTimeMillis() - this.jdField_b_of_type_Long) / 1000L);
        }
        localStringBuilder.append(this.jdField_c_of_type_Long).append('|');
      }
      label242:
      return localStringBuilder.toString();
    }
    lek.d("VideoNodeReporter", "buildBody report error:" + paramInt);
    return null;
  }
  
  public void a(lid paramlid, String paramString)
  {
    if (paramlid != null)
    {
      if (paramlid.j != -1) {
        this.jdField_a_of_type_Int = paramlid.j;
      }
      if (paramlid.jdField_d_of_type_Int != 0) {
        this.jdField_b_of_type_Int = paramlid.jdField_d_of_type_Int;
      }
      if (!TextUtils.isEmpty(paramlid.jdField_d_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = paramlid.jdField_d_of_type_JavaLangString;
      }
    }
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_c_of_type_JavaLangString = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     llb
 * JD-Core Version:    0.7.0.1
 */