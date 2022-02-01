import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

class psp
  implements pnq
{
  psp(psf parampsf) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof sxi)) {
      ((sxi)localObject).onClick(paramView);
    }
    do
    {
      return;
      localObject = (sxh)paramView.getTag();
      localObject = psf.a(this.a).a(((sxh)localObject).a);
    } while (localObject == null);
    qgx.a().a(psf.a(this.a), 2, new psq(this, (BaseArticleInfo)localObject, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psp
 * JD-Core Version:    0.7.0.1
 */