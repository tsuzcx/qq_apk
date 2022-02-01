class pmc
  implements sct
{
  pmc(pmb parampmb, plz paramplz) {}
  
  public void a(scv paramscv)
  {
    if ((this.jdField_a_of_type_Plz != null) && (paramscv != null))
    {
      plz localplz = this.jdField_a_of_type_Plz;
      String str = paramscv.b;
      paramscv = paramscv.a;
      localplz.a(new String[] { str }, new String[] { paramscv });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pmc
 * JD-Core Version:    0.7.0.1
 */