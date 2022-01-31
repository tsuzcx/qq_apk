class pcu
  implements osi
{
  pcu(pct parampct, pcr parampcr) {}
  
  public void a(osl paramosl)
  {
    if ((this.jdField_a_of_type_Pcr != null) && (paramosl != null))
    {
      pcr localpcr = this.jdField_a_of_type_Pcr;
      String str = paramosl.b;
      paramosl = paramosl.a;
      localpcr.a(new String[] { str }, new String[] { paramosl });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pcu
 * JD-Core Version:    0.7.0.1
 */