import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.EventCallback;
import java.util.List;

class pun
  extends EventCallback
{
  pun(pug parampug) {}
  
  public void onPagerChange(int paramInt)
  {
    pug.b(paramInt);
    if ((pug.b() != null) && (!pug.b().contains(Integer.valueOf(paramInt)))) {
      pug.b().add(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pun
 * JD-Core Version:    0.7.0.1
 */