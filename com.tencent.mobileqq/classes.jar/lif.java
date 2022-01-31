import com.tencent.qphone.base.util.QLog;

class lif
  implements lia
{
  lif(lie paramlie) {}
  
  public void a(long paramLong, String paramString)
  {
    lcg.c("AVMagicfacePlayer", "play video begin." + paramString);
    if (this.a.jdField_b_of_type_Lia != null) {
      this.a.jdField_b_of_type_Lia.a(paramLong, paramString);
    }
  }
  
  public void a(long paramLong, String arg3, int paramInt)
  {
    QLog.w("AVMagicfacePlayer", 1, "onEndMagicPlay, id[" + ??? + "], reason[" + paramInt + "], seq[" + paramLong + "]");
    if (this.a.jdField_b_of_type_Lia != null) {
      this.a.jdField_b_of_type_Lia.a(paramLong, ???, paramInt);
    }
    synchronized (this.a)
    {
      if ((this.a.jdField_b_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_Lic != null)) {
        this.a.a(paramLong, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Lic, this.a.jdField_a_of_type_Lib, this.a.jdField_a_of_type_Lia);
      }
      return;
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    lcg.c("AVMagicfacePlayer", "play audio begin. id = " + paramString + ", repeat = " + paramBoolean);
    if (paramBoolean)
    {
      this.a.a(this.a.jdField_a_of_type_JavaLangString, 100);
      return;
    }
    this.a.a(this.a.jdField_a_of_type_JavaLangString, 1);
  }
  
  public void b(long paramLong, String paramString)
  {
    lcg.c("AVMagicfacePlayer", "play audio end. id = " + paramString);
    this.a.a(this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lif
 * JD-Core Version:    0.7.0.1
 */