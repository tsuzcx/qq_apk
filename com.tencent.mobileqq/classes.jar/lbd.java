import com.tencent.biz.pubaccount.readinjoy.KanDianViewController;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import java.util.List;

public class lbd
  extends ReadInJoyObserver
{
  public lbd(KanDianViewController paramKanDianViewController) {}
  
  public void X_()
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).k();
    }
  }
  
  public void a(int paramInt, List paramList)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a(paramInt, paramList);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List paramList, boolean paramBoolean2)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a(paramBoolean1, paramInt, paramList, paramBoolean2);
    }
  }
  
  public void b(int paramInt, List paramList)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).c(paramInt, paramList);
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List paramList, boolean paramBoolean2)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).b(paramBoolean1, paramInt, paramList, paramBoolean2);
    }
  }
  
  public void c(int paramInt, List paramList)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).b(paramInt, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lbd
 * JD-Core Version:    0.7.0.1
 */