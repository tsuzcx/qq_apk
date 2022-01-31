import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.image.URLDrawable.DownloadListener;

public class qwm
  extends AsyncTask<Void, Void, Boolean>
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private URLDrawable.DownloadListener jdField_a_of_type_ComTencentImageURLDrawable$DownloadListener;
  private String jdField_a_of_type_JavaLangString;
  
  public qwm(Bitmap paramBitmap, String paramString)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected Boolean a(Void... paramVarArgs)
  {
    return Boolean.valueOf(xqw.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_JavaLangString));
  }
  
  public void a()
  {
    executeOnExecutor(amdp.a(64), null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qwm
 * JD-Core Version:    0.7.0.1
 */