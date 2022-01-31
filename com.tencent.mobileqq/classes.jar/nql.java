import android.os.Handler;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;

class nql
  implements ApngDrawable.OnPlayRepeatListener
{
  nql(nqi paramnqi) {}
  
  public void onPlayRepeat(int paramInt)
  {
    if (paramInt == 1) {
      nqi.a(this.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nql
 * JD-Core Version:    0.7.0.1
 */