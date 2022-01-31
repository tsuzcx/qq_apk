package okhttp3;

import okio.AsyncTimeout;

class RealCall$1
  extends AsyncTimeout
{
  RealCall$1(RealCall paramRealCall) {}
  
  public void timedOut()
  {
    this.this$0.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.RealCall.1
 * JD-Core Version:    0.7.0.1
 */