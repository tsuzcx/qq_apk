import com.tencent.qphone.base.util.QLog;

class lhr
  implements lhm
{
  lhr(lhq paramlhq) {}
  
  public void a(long paramLong, String paramString)
  {
    lbd.f("AVMagicfacePlayer", "play video begin." + paramString);
    if (this.a.jdField_b_of_type_Lhm != null) {
      this.a.jdField_b_of_type_Lhm.a(paramLong, paramString);
    }
  }
  
  public void a(long paramLong, String arg3, int paramInt)
  {
    QLog.w("AVMagicfacePlayer", 1, "onEndMagicPlay, id[" + ??? + "], reason[" + paramInt + "], seq[" + paramLong + "]");
    if (this.a.jdField_b_of_type_Lhm != null) {
      this.a.jdField_b_of_type_Lhm.a(paramLong, ???, paramInt);
    }
    synchronized (this.a)
    {
      if ((this.a.jdField_b_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_Lho != null)) {
        this.a.a(paramLong, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Lho, this.a.jdField_a_of_type_Lhn, this.a.jdField_a_of_type_Lhm);
      }
      return;
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    lbd.f("AVMagicfacePlayer", "play audio begin. id = " + paramString + ", repeat = " + paramBoolean);
    if (paramBoolean)
    {
      this.a.a(this.a.jdField_a_of_type_JavaLangString, 100);
      return;
    }
    this.a.a(this.a.jdField_a_of_type_JavaLangString, 1);
  }
  
  public void b(long paramLong, String paramString)
  {
    lbd.f("AVMagicfacePlayer", "play audio end. id = " + paramString);
    this.a.a(this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lhr
 * JD-Core Version:    0.7.0.1
 */