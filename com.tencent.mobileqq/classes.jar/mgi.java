import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class mgi
  extends les
{
  public mgi(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  protected void a(long paramLong1, long paramLong2, ArrayList<lcu> paramArrayList)
  {
    ThreadManager.getUIHandler().post(new MultiVideoCtrlLayerUIBase.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mgi
 * JD-Core Version:    0.7.0.1
 */