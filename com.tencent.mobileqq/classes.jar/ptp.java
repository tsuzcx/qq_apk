class ptp
  implements slp
{
  ptp(pto parampto, ptm paramptm) {}
  
  public void a(slr paramslr)
  {
    if ((this.jdField_a_of_type_Ptm != null) && (paramslr != null))
    {
      ptm localptm = this.jdField_a_of_type_Ptm;
      String str = paramslr.b;
      paramslr = paramslr.a;
      localptm.a(new String[] { str }, new String[] { paramslr });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ptp
 * JD-Core Version:    0.7.0.1
 */