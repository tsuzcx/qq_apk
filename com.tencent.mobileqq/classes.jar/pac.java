import com.tencent.biz.ui.RoundProgressBar;

public class pac
  implements Runnable
{
  public pac(RoundProgressBar paramRoundProgressBar, int paramInt) {}
  
  public void run()
  {
    if (RoundProgressBar.a(this.jdField_a_of_type_ComTencentBizUiRoundProgressBar) < this.jdField_a_of_type_Int) {
      while (RoundProgressBar.a(this.jdField_a_of_type_ComTencentBizUiRoundProgressBar) < this.jdField_a_of_type_Int)
      {
        RoundProgressBar.a(this.jdField_a_of_type_ComTencentBizUiRoundProgressBar, RoundProgressBar.a(this.jdField_a_of_type_ComTencentBizUiRoundProgressBar) + 1);
        this.jdField_a_of_type_ComTencentBizUiRoundProgressBar.postInvalidate();
        try
        {
          Thread.sleep(50L);
        }
        catch (InterruptedException localInterruptedException1)
        {
          localInterruptedException1.printStackTrace();
        }
      }
    }
    while (this.jdField_a_of_type_Int < RoundProgressBar.a(this.jdField_a_of_type_ComTencentBizUiRoundProgressBar))
    {
      RoundProgressBar.a(this.jdField_a_of_type_ComTencentBizUiRoundProgressBar, RoundProgressBar.a(this.jdField_a_of_type_ComTencentBizUiRoundProgressBar) - 1);
      this.jdField_a_of_type_ComTencentBizUiRoundProgressBar.postInvalidate();
      try
      {
        Thread.sleep(50L);
      }
      catch (InterruptedException localInterruptedException2)
      {
        localInterruptedException2.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pac
 * JD-Core Version:    0.7.0.1
 */