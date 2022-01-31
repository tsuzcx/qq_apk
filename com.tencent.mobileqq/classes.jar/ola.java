import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;

public class ola
  implements DialogInterface.OnClickListener
{
  public ola(EditVideoMusicDialog paramEditVideoMusicDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.h();
    paramDialogInterface.dismiss();
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ola
 * JD-Core Version:    0.7.0.1
 */