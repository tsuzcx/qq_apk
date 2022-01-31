import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;

class jyq
  implements Runnable
{
  jyq(jyn paramjyn) {}
  
  public void run()
  {
    int i = 1;
    if (this.a.a.a != null) {
      i = this.a.a.a.b();
    }
    for (;;)
    {
      if (i < MultiVideoCtrlLayerUIBase.a) {
        this.a.a.M();
      }
      return;
      AVLog.e(this.a.a.c, "mVideoController == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jyq
 * JD-Core Version:    0.7.0.1
 */