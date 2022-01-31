import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class tgs
  implements tgz
{
  tgs(tgp paramtgp) {}
  
  public void a(@Nullable tff paramtff, Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MsgTabStoryVideoPreloader", 2, "MsgTabVideoPreloaderDataProvider load video info error", paramError);
    }
    this.a.b();
  }
  
  public void a(@Nullable tff paramtff, @NonNull List<StoryVideoItem> paramList)
  {
    if (!paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "start download video list, list = " + paramList.size() + "\n" + paramList);
      }
      tgp.a(this.a, paramList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("MsgTabStoryVideoPreloader", 2, "can not find first unread video");
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tgs
 * JD-Core Version:    0.7.0.1
 */