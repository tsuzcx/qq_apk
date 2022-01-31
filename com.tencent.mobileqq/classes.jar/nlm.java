import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;

public final class nlm
  implements DialogInterface.OnClickListener
{
  public nlm(StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SLog.d("Q.qqstory.player.PlayModeUtils", "onClick delete =%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem });
    StoryVideoUploadManager.a(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlm
 * JD-Core Version:    0.7.0.1
 */