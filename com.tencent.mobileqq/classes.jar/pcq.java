import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.EventCallback;
import java.util.List;

class pcq
  extends EventCallback
{
  pcq(pcj parampcj) {}
  
  public void onPagerChange(int paramInt)
  {
    pcj.b(paramInt);
    if ((pcj.b() != null) && (!pcj.b().contains(Integer.valueOf(paramInt)))) {
      pcj.b().add(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pcq
 * JD-Core Version:    0.7.0.1
 */