import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.biz.qqstory.takevideo.CommonPicUploadFragment;
import com.tencent.mobileqq.app.BaseActivity;

public class ock
  implements DialogInterface.OnKeyListener
{
  public ock(CommonPicUploadFragment paramCommonPicUploadFragment) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 84) {
      return true;
    }
    if (paramInt == 4)
    {
      this.a.b();
      paramDialogInterface = this.a.a;
      paramKeyEvent = this.a.a;
      paramDialogInterface.setResult(0);
      this.a.a.finish();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ock
 * JD-Core Version:    0.7.0.1
 */