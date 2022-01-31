import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emosm.view.DragSortListView.DropListener;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.statistics.ReportController;

public class sjh
  implements DragSortListView.DropListener
{
  public sjh(EmosmActivity paramEmosmActivity) {}
  
  public void b_(int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.a.a.getItem(paramInt1);
      this.a.a.a(localEmoticonPackage);
      this.a.a.b(true);
      this.a.a.a(localEmoticonPackage, paramInt2);
      EmojiListenerManager.a().a(localEmoticonPackage, paramInt1, paramInt2);
      this.a.c = true;
      ReportController.b(this.a.app, "CliOper", "", "", "EmosSetting", "EpMove", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sjh
 * JD-Core Version:    0.7.0.1
 */