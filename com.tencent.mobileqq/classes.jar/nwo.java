import com.tencent.biz.qqstory.model.QQStoryActivityManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class nwo
  implements Runnable
{
  public nwo(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity) {}
  
  public void run()
  {
    QQStoryActivityManager localQQStoryActivityManager = (QQStoryActivityManager)SuperManager.a(18);
    ArrayList localArrayList = localQQStoryActivityManager.a(this.a);
    int i = localArrayList.size();
    if (i >= 4)
    {
      localQQStoryActivityManager.a(((Integer)localArrayList.get(0)).intValue() + 1, ((Integer)localArrayList.get(i - 1)).intValue());
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "QQStoryShareGroupProfileActivity activity stack full, size = " + i + ", start clear!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwo
 * JD-Core Version:    0.7.0.1
 */