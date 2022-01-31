import com.tencent.image.URLDrawableHandler;

public class sfd
  implements URLDrawableHandler
{
  private URLDrawableHandler jdField_a_of_type_ComTencentImageURLDrawableHandler;
  private sfc jdField_a_of_type_Sfc;
  
  public sfd(URLDrawableHandler paramURLDrawableHandler, sfc paramsfc)
  {
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
    this.jdField_a_of_type_Sfc = paramsfc;
  }
  
  public sfc a()
  {
    return this.jdField_a_of_type_Sfc;
  }
  
  public void doCancel()
  {
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler.doCancel();
  }
  
  public boolean isCancelled()
  {
    return this.jdField_a_of_type_ComTencentImageURLDrawableHandler.isCancelled();
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.jdField_a_of_type_Sfc.a(false, paramInt);
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadFailed(paramInt);
  }
  
  public void onFileDownloadStarted()
  {
    this.jdField_a_of_type_Sfc.b();
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadStarted();
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    this.jdField_a_of_type_Sfc.a(true, 0);
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadSucceed(paramLong);
  }
  
  public void publishProgress(int paramInt)
  {
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler.publishProgress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sfd
 * JD-Core Version:    0.7.0.1
 */