import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.EventCallback;
import java.util.List;

class pof
  extends EventCallback
{
  pof(pny parampny) {}
  
  public void onPagerChange(int paramInt)
  {
    pny.b(paramInt);
    if ((pny.b() != null) && (!pny.b().contains(Integer.valueOf(paramInt)))) {
      pny.b().add(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pof
 * JD-Core Version:    0.7.0.1
 */