import android.os.Handler;
import com.tencent.biz.qqstory.model.AddressDataProvider.AddressInfo;
import com.tencent.biz.qqstory.model.DataProvider.DataUpdateListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;

public class opq
  implements DataProvider.DataUpdateListener
{
  public opq(EditVideoMusicDialog paramEditVideoMusicDialog) {}
  
  public void a(boolean paramBoolean, AddressDataProvider.AddressInfo paramAddressInfo)
  {
    SLog.b("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate.");
    if ((paramBoolean) && (paramAddressInfo != null))
    {
      SLog.a("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate success, address=%s", paramAddressInfo);
      this.a.a.post(new opr(this, paramAddressInfo));
      return;
    }
    SLog.e("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     opq
 * JD-Core Version:    0.7.0.1
 */