import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class myu
{
  public final int a;
  public final long a;
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final String g;
  
  public myu(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramString7;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public int a()
  {
    int i = 0;
    if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {}
    try
    {
      i = Integer.parseInt(this.e);
      return i;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("WTogether", 1, "init WTVideoInfo", localThrowable);
    }
    return 0;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Int + "_" + this.b + "_" + this.d + "_" + this.e + "_" + this.f + "_" + this.g + "_" + this.jdField_a_of_type_Long;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 4);
  }
  
  public boolean a(myu parammyu)
  {
    boolean bool;
    if (this == parammyu) {
      bool = true;
    }
    while ((!bool) && (parammyu != null)) {
      if ((this.jdField_a_of_type_Int == parammyu.jdField_a_of_type_Int) && (this.jdField_a_of_type_Long != parammyu.jdField_a_of_type_Long) && (TextUtils.equals(this.b, parammyu.b)) && (TextUtils.equals(this.d, parammyu.d)) && (TextUtils.equals(this.e, parammyu.e)) && (TextUtils.equals(this.f, parammyu.f)) && (TextUtils.equals(this.g, parammyu.g)))
      {
        return true;
        bool = false;
      }
      else
      {
        return false;
      }
    }
    return bool;
  }
  
  public boolean b()
  {
    boolean bool = true;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          return bool;
        } while (!TextUtils.isEmpty(this.b));
        return false;
      } while ((!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.f)));
      return false;
    } while ((!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.g)));
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("VideoInfo{videoSrcType: ").append(this.jdField_a_of_type_Int).append(", title: ").append(this.jdField_a_of_type_JavaLangString).append(", url: ");
    if (this.b == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.b.length())) {
      return localObject + ", cookie: " + this.c + ", vid: " + this.d + ", strPlatForm: " + this.e + ", strSDTForm: " + this.f + ", strLivePid: " + this.g + ", mediaFormat: " + this.jdField_a_of_type_Long + "}";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     myu
 * JD-Core Version:    0.7.0.1
 */