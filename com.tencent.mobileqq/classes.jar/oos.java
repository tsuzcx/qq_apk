import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.open.downloadnew.DownloadInfo;

public final class oos
  implements DialogInterface.OnClickListener
{
  public oos(DownloadInfo paramDownloadInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    WeishiGuideUtils.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oos
 * JD-Core Version:    0.7.0.1
 */