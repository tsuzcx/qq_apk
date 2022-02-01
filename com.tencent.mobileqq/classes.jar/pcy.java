import android.text.TextUtils;

class pcy
{
  public int a;
  public long a;
  public CharSequence a;
  public String a;
  public CharSequence b;
  
  public pcy(pcw parampcw, String paramString, long paramLong, CharSequence paramCharSequence)
  {
    this(parampcw, paramString, paramLong, paramCharSequence, 0);
  }
  
  public pcy(pcw parampcw, String paramString, long paramLong, CharSequence paramCharSequence, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    parampcw = paramCharSequence;
    if (paramCharSequence == null) {
      parampcw = "";
    }
    this.b = parampcw;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String toString()
  {
    int i = 0;
    if (!TextUtils.isEmpty(this.b)) {
      i = this.b.length();
    }
    return "UserBiuInfo {uin=" + this.jdField_a_of_type_JavaLangString + ", nickName=" + this.jdField_a_of_type_JavaLangCharSequence + ", comment=" + this.b + ", length=" + i + ", feedid=" + this.jdField_a_of_type_Long + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pcy
 * JD-Core Version:    0.7.0.1
 */