import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.2;
import com.tencent.mobileqq.app.ThreadManager;

public class sdl
{
  private static boolean b;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new sdm(this));
  private sdn jdField_a_of_type_Sdn;
  private she jdField_a_of_type_She = shg.a.a();
  private boolean jdField_a_of_type_Boolean;
  
  public sdl()
  {
    ThreadManager.executeOnSubThread(new VideoPluginInstall.1(this));
  }
  
  private void c()
  {
    try
    {
      if (!b)
      {
        this.jdField_a_of_type_She.a();
        b = true;
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    if ((!a()) && (!this.jdField_a_of_type_Boolean)) {
      ThreadManager.post(new VideoPluginInstall.2(this), 8, null, true);
    }
  }
  
  public void a(sdn paramsdn)
  {
    this.jdField_a_of_type_Sdn = paramsdn;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_She.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Sdn = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sdl
 * JD-Core Version:    0.7.0.1
 */