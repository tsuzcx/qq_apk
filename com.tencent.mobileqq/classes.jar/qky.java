import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.EventCallback;
import java.util.List;

class qky
  extends EventCallback
{
  qky(qks paramqks) {}
  
  public void onPagerChange(int paramInt)
  {
    qks.b(paramInt);
    if ((qks.b() != null) && (!qks.b().contains(Integer.valueOf(paramInt)))) {
      qks.b().add(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qky
 * JD-Core Version:    0.7.0.1
 */