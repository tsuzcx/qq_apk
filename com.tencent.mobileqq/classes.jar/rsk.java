import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.image.URLDrawable.DownloadListener;

public class rsk
  extends AsyncTask<Void, Void, Boolean>
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private URLDrawable.DownloadListener jdField_a_of_type_ComTencentImageURLDrawable$DownloadListener;
  private String jdField_a_of_type_JavaLangString;
  
  public rsk(Bitmap paramBitmap, String paramString)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected Boolean a(Void... paramVarArgs)
  {
    return Boolean.valueOf(zkh.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_JavaLangString));
  }
  
  public void a()
  {
    executeOnExecutor(anvy.a(64), null);
  }
  
  public void a(URLDrawable.DownloadListener paramDownloadListener)
  {
    this.jdField_a_of_type_ComTencentImageURLDrawable$DownloadListener = paramDownloadListener;
  }
  
  protected void a(Boolean paramBoolean)
  {
    super.onPostExecute(paramBoolean);
    if (this.jdField_a_of_type_ComTencentImageURLDrawable$DownloadListener == null) {
      return;
    }
    if (paramBoolean.booleanValue())
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable$DownloadListener.onFileDownloadSucceed(0L);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable$DownloadListener.onFileDownloadFailed(0);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    if (this.jdField_a_of_type_ComTencentImageURLDrawable$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawable$DownloadListener.onFileDownloadStarted();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsk
 * JD-Core Version:    0.7.0.1
 */