package cooperation.readinjoy.content;

public class ReadInJoyDataProviderObserver
{
  private static ReadInJoyDataProviderObserver jdField_a_of_type_CooperationReadinjoyContentReadInJoyDataProviderObserver = new ReadInJoyDataProviderObserver();
  private ReadInJoyDataProviderObserver.FluencyObserver jdField_a_of_type_CooperationReadinjoyContentReadInJoyDataProviderObserver$FluencyObserver;
  ReadInJoyDataProviderObserver.Reporter jdField_a_of_type_CooperationReadinjoyContentReadInJoyDataProviderObserver$Reporter;
  
  public static ReadInJoyDataProviderObserver a()
  {
    return jdField_a_of_type_CooperationReadinjoyContentReadInJoyDataProviderObserver;
  }
  
  public void a()
  {
    this.jdField_a_of_type_CooperationReadinjoyContentReadInJoyDataProviderObserver$FluencyObserver = null;
  }
  
  public void a(ReadInJoyDataProviderObserver.FluencyObserver paramFluencyObserver)
  {
    this.jdField_a_of_type_CooperationReadinjoyContentReadInJoyDataProviderObserver$FluencyObserver = paramFluencyObserver;
  }
  
  public void a(ReadInJoyDataProviderObserver.Reporter paramReporter)
  {
    this.jdField_a_of_type_CooperationReadinjoyContentReadInJoyDataProviderObserver$Reporter = paramReporter;
  }
  
  public void a(String paramString1, String paramString2)
  {
    ReadInJoyDataProviderObserver.Reporter localReporter = this.jdField_a_of_type_CooperationReadinjoyContentReadInJoyDataProviderObserver$Reporter;
    if ((localReporter != null) && (!"0X8009831".equals(paramString1)) && (!"0X8009830".equals(paramString1)) && (!"0X800982E".equals(paramString1)) && (!"0X800982F".equals(paramString1))) {
      localReporter.a(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.readinjoy.content.ReadInJoyDataProviderObserver
 * JD-Core Version:    0.7.0.1
 */