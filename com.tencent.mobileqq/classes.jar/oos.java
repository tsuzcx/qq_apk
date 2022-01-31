import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class oos
  implements ViewBase.OnClickListener
{
  oos(oor paramoor) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return;
    case 1093: 
      ors.a(oop.a(this.a.a), oop.a(this.a.a), otd.a(oop.a(this.a.a).innerUniqueID));
      this.a.a.a(2);
      this.a.a.dismiss();
      paramViewBase = new orz();
      paramViewBase.i().b("wording", "" + otd.a());
      olt.a("0X8009FE8", oop.a(this.a.a), paramViewBase);
      return;
    }
    this.a.a.a(1);
    this.a.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oos
 * JD-Core Version:    0.7.0.1
 */