import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class pfv
  implements ViewBase.OnClickListener
{
  pfv(pfu parampfu) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return;
    case 1095: 
      pqx.a(pfs.a(this.a.a), pfs.a(this.a.a), plk.a(pfs.a(this.a.a).innerUniqueID));
      this.a.a.a(2);
      this.a.a.dismiss();
      paramViewBase = new pqg();
      paramViewBase.i().b("wording", "" + plk.a());
      pbq.a("0X8009FE8", pfs.a(this.a.a), paramViewBase);
      return;
    }
    this.a.a.a(1);
    this.a.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pfv
 * JD-Core Version:    0.7.0.1
 */