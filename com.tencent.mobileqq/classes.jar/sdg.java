import com.tencent.image.URLDrawable.DownloadListener;

class sdg
  implements URLDrawable.DownloadListener
{
  sdg(scy paramscy) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    scy.b(this.a);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    scy.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sdg
 * JD-Core Version:    0.7.0.1
 */