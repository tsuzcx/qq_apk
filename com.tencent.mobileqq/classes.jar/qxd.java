import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.EventCallback;
import java.util.List;

class qxd
  extends EventCallback
{
  qxd(qwx paramqwx) {}
  
  public void onPagerChange(int paramInt)
  {
    qwx.b(paramInt);
    if ((qwx.b() != null) && (!qwx.b().contains(Integer.valueOf(paramInt)))) {
      qwx.b().add(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qxd
 * JD-Core Version:    0.7.0.1
 */