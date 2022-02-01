import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class spm
{
  public static final String a = String.valueOf(20160519);
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = 10000;
    if (paramInt2 * 1000 > 60000) {
      if (paramInt1 <= paramInt2 * 1000 - 8000) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "getPreviewStartPosi(): forwardPosition=" + paramInt1 + ", videoDuration=" + paramInt2 + " => previewStartPosi=" + i);
      }
      return i;
      if (paramInt1 >= 8000)
      {
        i = paramInt1 - 8000;
        continue;
        i = 0;
      }
    }
  }
  
  public static int a(ListView paramListView, spk paramspk)
  {
    if (paramspk != null)
    {
      paramspk = paramListView.getChildAt(paramspk.a + paramListView.getHeaderViewsCount() - paramListView.getFirstVisiblePosition());
      if (paramspk != null) {
        return paramspk.getBottom() - AIOUtils.dp2px(175.0F, paramListView.getResources());
      }
    }
    return 0;
  }
  
  public static long a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 <= 0) {
      return 0L;
    }
    return paramInt2 * 512 + paramInt1 * paramInt3 / paramInt2;
  }
  
  public static String a()
  {
    return "";
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " PLAY_STATE_UNKNOW ";
    case 0: 
      return " PLAY_STATE_IDLE ";
    case 1: 
      return " PLAY_STATE_PREPARING ";
    case 2: 
      return " PLAY_STATE_PREPARED ";
    case 3: 
      return " PLAY_STATE_PLAYING ";
    case 5: 
      return " PLAY_STATE_PAUSED ";
    case 4: 
      return " PLAY_STATE_BUFFERING ";
    case 7: 
      return " PLAY_STATE_COMPLETE ";
    case 6: 
      return " PLAY_STATE_ERROR ";
    }
    return "PLAY_STATE_DESTORY";
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 123)
    {
      if (paramInt2 == 103) {
        return anvx.a(2131715690) + paramInt1 + "-" + paramInt2;
      }
      if (paramInt2 == 108) {
        return anvx.a(2131717949) + ": " + paramInt1 + "-" + paramInt2;
      }
      return anvx.a(2131715704) + paramInt1 + "-" + paramInt2;
    }
    if (paramInt1 == 122)
    {
      if (paramInt2 == 204) {
        return anvx.a(2131715700) + paramInt1 + "-" + paramInt2;
      }
      if (paramInt2 == 202) {
        return anvx.a(2131715693) + paramInt1 + "-" + paramInt2;
      }
      return anvx.a(2131715680) + paramInt1 + "-" + paramInt2;
    }
    if (paramInt1 == 101)
    {
      if (paramInt2 == 80) {
        return anvx.a(2131715692) + paramInt1 + "-" + paramInt2;
      }
      return anvx.a(2131715682) + paramInt1 + "-" + paramInt2;
    }
    return anvx.a(2131715688) + paramInt1 + "-" + paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     spm
 * JD-Core Version:    0.7.0.1
 */