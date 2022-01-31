import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import java.util.List;

public class mor
  extends ReadInJoyObserver
{
  public mor(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController) {}
  
  public void a(boolean paramBoolean1, int paramInt, List paramList, boolean paramBoolean2)
  {
    if ((paramInt == 70) && (paramBoolean1)) {
      ReadInJoyDiandianHeaderController.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mor
 * JD-Core Version:    0.7.0.1
 */