import android.content.res.Resources;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import mqq.util.WeakReference;

public class kjn
  implements Runnable
{
  public kjn(TraeHelper paramTraeHelper) {}
  
  public void run()
  {
    Button localButton;
    if (this.a.jdField_b_of_type_MqqUtilWeakReference != null)
    {
      localButton = (Button)this.a.jdField_b_of_type_MqqUtilWeakReference.get();
      if (localButton != null)
      {
        localButton.setClickable(true);
        if ((!this.a.jdField_b_of_type_Boolean) || (!TraeHelper.c())) {
          break label98;
        }
        localButton.setSelected(true);
        UITools.a(localButton, localButton.getResources().getString(2131428887));
      }
    }
    this.a.a.a().N = TraeHelper.a(this.a).N;
    TraeHelper.a(this.a);
    return;
    label98:
    localButton.setSelected(TraeHelper.a(this.a).N);
    Resources localResources = localButton.getResources();
    if (TraeHelper.a(this.a).N) {}
    for (int i = 2131428885;; i = 2131428886)
    {
      UITools.a(localButton, localResources.getString(i));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kjn
 * JD-Core Version:    0.7.0.1
 */