public class lqq
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public long b;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  
  public lqq()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = 4L;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof lqq)))
    {
      paramObject = (lqq)paramObject;
      if (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    return "Uin[" + this.jdField_a_of_type_Long + "], VideoSrcType[" + this.jdField_a_of_type_Int + "], isBig[" + this.jdField_a_of_type_Boolean + "], isRender[" + this.jdField_b_of_type_Boolean + "], isNeedRequest[" + this.c + "], hasRecvData[" + this.d + "], inviteId[" + this.jdField_a_of_type_JavaLangString + "], isMirror[" + this.f + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lqq
 * JD-Core Version:    0.7.0.1
 */