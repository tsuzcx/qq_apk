import com.tencent.mobileqq.utils.httputils.HttpCommunicator;

public class lch
{
  private static aysa jdField_a_of_type_Aysa;
  private static bbmv jdField_a_of_type_Bbmv = new lci();
  
  public static aysa a()
  {
    if (jdField_a_of_type_Aysa == null) {}
    try
    {
      if (jdField_a_of_type_Aysa == null)
      {
        HttpCommunicator localHttpCommunicator = new HttpCommunicator(jdField_a_of_type_Bbmv, 128);
        localHttpCommunicator.a();
        jdField_a_of_type_Aysa = new aytb(localHttpCommunicator, true);
      }
      return jdField_a_of_type_Aysa;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lch
 * JD-Core Version:    0.7.0.1
 */