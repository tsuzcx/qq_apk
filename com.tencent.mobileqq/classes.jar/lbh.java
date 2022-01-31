import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import java.util.List;

public class lbh
  extends ReadInJoyObserver
{
  public lbh(ReadInJoyChannelViewController paramReadInJoyChannelViewController) {}
  
  public void X_()
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).k();
    }
  }
  
  public void a(int paramInt, List paramList)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a(paramInt, paramList);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List paramList1, List paramList2)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a(paramBoolean, paramInt, paramLong, paramList1, paramList2);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List paramList, boolean paramBoolean2)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a(paramBoolean1, paramInt, paramList, paramBoolean2);
    }
  }
  
  public void b(int paramInt, List paramList)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).c(paramInt, paramList);
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List paramList, boolean paramBoolean2)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).b(paramBoolean1, paramInt, paramList, paramBoolean2);
    }
  }
  
  public void c(int paramInt, List paramList)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).b(paramInt, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lbh
 * JD-Core Version:    0.7.0.1
 */