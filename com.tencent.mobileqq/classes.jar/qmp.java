import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.EventCallback;
import java.util.List;

class qmp
  extends EventCallback
{
  qmp(qmi paramqmi) {}
  
  public void onPagerChange(int paramInt)
  {
    qmi.b(paramInt);
    if ((qmi.b() != null) && (!qmi.b().contains(Integer.valueOf(paramInt)))) {
      qmi.b().add(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qmp
 * JD-Core Version:    0.7.0.1
 */