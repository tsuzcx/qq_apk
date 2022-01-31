import com.tencent.av.widget.stageview.StageEffectView;
import com.tencent.av.widget.stageview.StageMemberView;
import java.util.Comparator;

public class mvn
  implements Comparator<StageMemberView>
{
  public mvn(StageEffectView paramStageEffectView) {}
  
  public int a(StageMemberView paramStageMemberView1, StageMemberView paramStageMemberView2)
  {
    if ((paramStageMemberView1 == null) && (paramStageMemberView2 == null)) {
      return 0;
    }
    if (paramStageMemberView2 == null) {
      return -1;
    }
    if (paramStageMemberView1 == null) {
      return 1;
    }
    paramStageMemberView1 = (mvt)paramStageMemberView1.getTag();
    paramStageMemberView2 = (mvt)paramStageMemberView2.getTag();
    if (paramStageMemberView1.a == paramStageMemberView2.a) {
      return 0;
    }
    if (mvi.a(paramStageMemberView1.a - 10000, 20000) < mvi.a(paramStageMemberView2.a - 10000, 20000)) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mvn
 * JD-Core Version:    0.7.0.1
 */