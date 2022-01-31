import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.IPlayVideoStatusChangeListener;
import com.tencent.biz.qqstory.playmode.child.TroopStoryForAIOPlayMode;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

public class nqe
  extends IPlayVideoStatusChangeListener
{
  public nqe(TroopStoryForAIOPlayMode paramTroopStoryForAIOPlayMode) {}
  
  public void a(int paramInt)
  {
    if (paramInt == this.a.j) {
      return;
    }
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.a.a.a.get(paramInt);
    if (this.a.a(localStoryVideoItem)) {
      ReportController.b(null, "dc00898", "", "", "0X8007424", "0X8007424", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X8007427", "0X8007427", 0, 0, "", "", "", "");
      this.a.j = paramInt;
      return;
      ReportController.b(null, "dc00898", "", "", "0X8007FC9", "0X8007FC9", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqe
 * JD-Core Version:    0.7.0.1
 */