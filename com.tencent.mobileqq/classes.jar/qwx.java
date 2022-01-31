import com.tencent.image.URLDrawable.DownloadListener;

class qwx
  implements URLDrawable.DownloadListener
{
  qwx(qwp paramqwp) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    qwp.b(this.a);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    qwp.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qwx
 * JD-Core Version:    0.7.0.1
 */