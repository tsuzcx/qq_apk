import com.tencent.image.URLDrawable.DownloadListener;

class rqr
  implements URLDrawable.DownloadListener
{
  rqr(rqj paramrqj) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    rqj.b(this.a);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    rqj.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rqr
 * JD-Core Version:    0.7.0.1
 */