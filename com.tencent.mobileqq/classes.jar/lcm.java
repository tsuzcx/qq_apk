import com.tencent.mobileqq.utils.httputils.HttpCommunicator;

public class lcm
{
  private static ayry jdField_a_of_type_Ayry;
  private static bbmh jdField_a_of_type_Bbmh = new lcn();
  
  public static ayry a()
  {
    if (jdField_a_of_type_Ayry == null) {}
    try
    {
      if (jdField_a_of_type_Ayry == null)
      {
        HttpCommunicator localHttpCommunicator = new HttpCommunicator(jdField_a_of_type_Bbmh, 128);
        localHttpCommunicator.a();
        jdField_a_of_type_Ayry = new aysz(localHttpCommunicator, true);
      }
      return jdField_a_of_type_Ayry;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lcm
 * JD-Core Version:    0.7.0.1
 */