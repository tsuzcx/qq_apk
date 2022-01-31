class mct
{
  lsv jdField_a_of_type_Lsv;
  mcs[] jdField_a_of_type_ArrayOfMcs = new mcs[2];
  
  mct(mcr parammcr)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfMcs.length)
    {
      this.jdField_a_of_type_ArrayOfMcs[i] = new mcs(parammcr);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mct
 * JD-Core Version:    0.7.0.1
 */