import com.tencent.qphone.base.util.QLog;

class kxw
  implements kxr
{
  kxw(kxv paramkxv) {}
  
  public void a(long paramLong, String paramString)
  {
    krx.c("AVMagicfacePlayer", "play video begin." + paramString);
    if (this.a.jdField_b_of_type_Kxr != null) {
      this.a.jdField_b_of_type_Kxr.a(paramLong, paramString);
    }
  }
  
  public void a(long paramLong, String arg3, int paramInt)
  {
    QLog.w("AVMagicfacePlayer", 1, "onEndMagicPlay, id[" + ??? + "], reason[" + paramInt + "], seq[" + paramLong + "]");
    if (this.a.jdField_b_of_type_Kxr != null) {
      this.a.jdField_b_of_type_Kxr.a(paramLong, ???, paramInt);
    }
    synchronized (this.a)
    {
      if ((this.a.jdField_b_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_Kxt != null)) {
        this.a.a(paramLong, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Kxt, this.a.jdField_a_of_type_Kxs, this.a.jdField_a_of_type_Kxr);
      }
      return;
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    krx.c("AVMagicfacePlayer", "play audio begin. id = " + paramString + ", repeat = " + paramBoolean);
    if (paramBoolean)
    {
      this.a.a(this.a.jdField_a_of_type_JavaLangString, 100);
      return;
    }
    this.a.a(this.a.jdField_a_of_type_JavaLangString, 1);
  }
  
  public void b(long paramLong, String paramString)
  {
    krx.c("AVMagicfacePlayer", "play audio end. id = " + paramString);
    this.a.a(this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kxw
 * JD-Core Version:    0.7.0.1
 */