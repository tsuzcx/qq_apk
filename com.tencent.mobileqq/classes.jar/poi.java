import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.EventCallback;
import java.util.List;

class poi
  extends EventCallback
{
  poi(pob parampob) {}
  
  public void onPagerChange(int paramInt)
  {
    pob.b(paramInt);
    if ((pob.b() != null) && (!pob.b().contains(Integer.valueOf(paramInt)))) {
      pob.b().add(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     poi
 * JD-Core Version:    0.7.0.1
 */