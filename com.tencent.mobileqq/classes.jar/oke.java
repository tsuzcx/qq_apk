import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class oke
  implements ViewBase.OnClickListener
{
  oke(okd paramokd) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return;
    case 1093: 
      onh.a(okb.a(this.a.a), okb.a(this.a.a), oos.a(okb.a(this.a.a).innerUniqueID));
      this.a.a.a(2);
      this.a.a.dismiss();
      paramViewBase = new ono();
      paramViewBase.i().b("wording", "" + oos.a());
      ohf.a("0X8009FE8", okb.a(this.a.a), paramViewBase);
      return;
    }
    this.a.a.a(1);
    this.a.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oke
 * JD-Core Version:    0.7.0.1
 */