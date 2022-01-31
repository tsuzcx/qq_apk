import android.graphics.Bitmap;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.biz.qqstory.shareGroup.icon.UrlListToBitmapListSegment;
import java.util.Arrays;

public class nwn
  implements Handler.Callback
{
  private nwn(UrlListToBitmapListSegment paramUrlListToBitmapListSegment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int k = 0;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      UrlListToBitmapListSegment.a(this.a, new Error((Throwable)paramMessage.obj));
      return true;
    }
    paramMessage = (Bitmap[])paramMessage.obj;
    int m = paramMessage.length;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        if (paramMessage[i] == null) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          UrlListToBitmapListSegment.a(this.a, Arrays.asList(paramMessage));
        }
        return true;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwn
 * JD-Core Version:    0.7.0.1
 */