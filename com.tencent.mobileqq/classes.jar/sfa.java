import com.tencent.qphone.base.util.QLog;

public class sfa
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
        return anni.a(2131714999) + paramInt1 + "-" + paramInt2;
      }
      if (paramInt2 == 108) {
        return anni.a(2131717235) + ": " + paramInt1 + "-" + paramInt2;
      }
      return anni.a(2131715013) + paramInt1 + "-" + paramInt2;
    }
    if (paramInt1 == 122)
    {
      if (paramInt2 == 204) {
        return anni.a(2131715009) + paramInt1 + "-" + paramInt2;
      }
      if (paramInt2 == 202) {
        return anni.a(2131715002) + paramInt1 + "-" + paramInt2;
      }
      return anni.a(2131714989) + paramInt1 + "-" + paramInt2;
    }
    if (paramInt1 == 101)
    {
      if (paramInt2 == 80) {
        return anni.a(2131715001) + paramInt1 + "-" + paramInt2;
      }
      return anni.a(2131714991) + paramInt1 + "-" + paramInt2;
    }
    return anni.a(2131714997) + paramInt1 + "-" + paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sfa
 * JD-Core Version:    0.7.0.1
 */