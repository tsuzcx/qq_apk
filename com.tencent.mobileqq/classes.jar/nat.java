import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.util.VideoFeedsWeiShiUtils;
import com.tencent.open.downloadnew.DownloadManager;

public final class nat
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    DownloadManager.a().a(VideoFeedsWeiShiUtils.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nat
 * JD-Core Version:    0.7.0.1
 */