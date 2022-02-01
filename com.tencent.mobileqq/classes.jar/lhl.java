import com.tencent.qphone.base.util.QLog;

class lhl
  implements lhg
{
  lhl(lhk paramlhk) {}
  
  public void a(long paramLong, String paramString)
  {
    lbj.c("AVMagicfacePlayer", "play video begin." + paramString);
    if (this.a.jdField_b_of_type_Lhg != null) {
      this.a.jdField_b_of_type_Lhg.a(paramLong, paramString);
    }
  }
  
  public void a(long paramLong, String arg3, int paramInt)
  {
    QLog.w("AVMagicfacePlayer", 1, "onEndMagicPlay, id[" + ??? + "], reason[" + paramInt + "], seq[" + paramLong + "]");
    if (this.a.jdField_b_of_type_Lhg != null) {
      this.a.jdField_b_of_type_Lhg.a(paramLong, ???, paramInt);
    }
    synchronized (this.a)
    {
      if ((this.a.jdField_b_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_Lhi != null)) {
        this.a.a(paramLong, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Lhi, this.a.jdField_a_of_type_Lhh, this.a.jdField_a_of_type_Lhg);
      }
      return;
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    lbj.c("AVMagicfacePlayer", "play audio begin. id = " + paramString + ", repeat = " + paramBoolean);
    if (paramBoolean)
    {
      this.a.a(this.a.jdField_a_of_type_JavaLangString, 100);
      return;
    }
    this.a.a(this.a.jdField_a_of_type_JavaLangString, 1);
  }
  
  public void b(long paramLong, String paramString)
  {
    lbj.c("AVMagicfacePlayer", "play audio end. id = " + paramString);
    this.a.a(this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lhl
 * JD-Core Version:    0.7.0.1
 */