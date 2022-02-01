import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class ovv
  implements ViewBase.OnClickListener
{
  ovv(ovu paramovu) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return;
    case 1095: 
      ozs.a(ovs.a(this.a.a), ovs.a(this.a.a), pbb.a(ovs.a(this.a.a).innerUniqueID));
      this.a.a.a(2);
      this.a.a.dismiss();
      paramViewBase = new paa();
      paramViewBase.i().b("wording", "" + pbb.a());
      osp.a("0X8009FE8", ovs.a(this.a.a), paramViewBase);
      return;
    }
    this.a.a.a(1);
    this.a.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ovv
 * JD-Core Version:    0.7.0.1
 */