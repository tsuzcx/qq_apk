import com.tencent.image.URLDrawable.DownloadListener;

class rsv
  implements URLDrawable.DownloadListener
{
  rsv(rsn paramrsn) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    rsn.b(this.a);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    rsn.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsv
 * JD-Core Version:    0.7.0.1
 */