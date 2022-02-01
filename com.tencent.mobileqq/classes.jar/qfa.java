import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.EventCallback;
import java.util.List;

class qfa
  extends EventCallback
{
  qfa(qeu paramqeu) {}
  
  public void onPagerChange(int paramInt)
  {
    qeu.b(paramInt);
    if ((qeu.b() != null) && (!qeu.b().contains(Integer.valueOf(paramInt)))) {
      qeu.b().add(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qfa
 * JD-Core Version:    0.7.0.1
 */