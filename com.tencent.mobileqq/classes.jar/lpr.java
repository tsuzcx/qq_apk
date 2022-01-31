class lpr
{
  lgc jdField_a_of_type_Lgc;
  lpq[] jdField_a_of_type_ArrayOfLpq = new lpq[2];
  
  lpr(lpp paramlpp)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfLpq.length)
    {
      this.jdField_a_of_type_ArrayOfLpq[i] = new lpq(paramlpp);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lpr
 * JD-Core Version:    0.7.0.1
 */