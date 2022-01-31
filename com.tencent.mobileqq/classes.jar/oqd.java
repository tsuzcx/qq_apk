import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

final class oqd
  implements ViewFactory.FoundClickableViewListener
{
  oqd(int paramInt, Container paramContainer, pgd parampgd, VafContext paramVafContext, bcws parambcws, rqj paramrqj, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    poa localpoa = (poa)opy.a().get(Integer.valueOf(this.jdField_a_of_type_Int));
    if ((localpoa != null) && (localpoa.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_a_of_type_Pgd, paramViewBase))) {}
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            return;
          } while ((paramViewBase.getNativeView() == null) || (paramViewBase.getClickEvnet() == null));
          i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
          if (QLog.isColorLevel()) {
            QLog.d("ProteusSupportUtil", 2, "configListener viewID : " + paramViewBase.getViewId() + ", cmd : " + i + ",, event : " + paramViewBase.getClickEvnet());
          }
          switch (i)
          {
          case 1035: 
          case 1145: 
          case 1162: 
          case 1163: 
          default: 
            paramViewBase.setOnClickListener(new oqj(this, paramViewBase));
            return;
          case 1001: 
            paramViewBase.setOnClickListener(new oqe(this, paramViewBase));
            return;
          }
        } while (!AdvertisementInfo.isAdvertisementInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
        paramViewBase.setOnClickListener(new oqk(this));
        return;
        paramViewBase.setOnClickListener(new ppa((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
        return;
        paramViewBase.setOnClickListener(new ppv((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Rqj));
        return;
        paramViewBase.setOnClickListener(new ppw((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext));
        return;
        paramViewBase.setOnClickListener(new pot((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext));
        return;
        paramViewBase.setOnClickListener(new pos((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
        return;
        paramViewBase.setOnClickListener(new ppp((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
        return;
        paramViewBase.setOnClickListener(new oql(this));
        return;
        paramViewBase.setOnClickListener(new ppq((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
        return;
      } while ((!ors.b((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (!ors.c((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)));
      paramViewBase.getNativeView().setOnClickListener(new oqm(this));
      return;
      paramViewBase.setOnClickListener(new por((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Rqj));
      return;
      paramViewBase.setOnClickListener(new poz(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
      return;
      paramViewBase.setOnClickListener(new pph((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Int));
      return;
      paramViewBase.setOnClickListener(new ppn((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
      return;
      paramViewBase.setOnClickListener(new ppm((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
      return;
      paramViewBase.setOnClickListener(new ppd((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Rqj));
      return;
      paramViewBase.setOnClickListener(new poq((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
      return;
      paramViewBase.setOnClickListener(new ppg((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
      return;
      paramViewBase.setOnClickListener(new ppk((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Rqj));
      return;
      paramViewBase.setOnClickListener(new ppf((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Rqj));
      return;
      paramViewBase.setOnClickListener(new ppe((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Int));
      return;
      paramViewBase.setOnClickListener(new ppb((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
      return;
      paramViewBase.setOnClickListener(new pov((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Int));
      return;
      paramViewBase.setOnClickListener(new poo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
      return;
      paramViewBase.setOnClickListener(new oqn(this));
      return;
      paramViewBase.setOnClickListener(new poy((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Int));
      return;
      paramViewBase.setOnClickListener(new ppo((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Int, paramViewBase.getEventAttachedData()));
      return;
      paramViewBase.setOnClickListener(new ppc(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
      return;
      paramViewBase.setOnClickListener(new oqo(this));
      return;
      paramViewBase.setOnClickListener(new oqp(this, paramViewBase));
      return;
      if (AdvertisementInfo.class.isInstance(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        szl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pgd.a(), this.jdField_a_of_type_Pgd.e(), 5);
        return;
      }
      paramViewBase.setOnClickListener(null);
      return;
      szl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pgd.a(), this.jdField_a_of_type_Pgd.e(), 5);
      return;
      szl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pgd.a(), this.jdField_a_of_type_Pgd.e(), 8);
      return;
      szl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pgd.a(), this.jdField_a_of_type_Pgd.e(), odr.a(i));
      return;
      if (AdvertisementInfo.class.isInstance(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        szl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pgd.a(), this.jdField_a_of_type_Pgd.e(), 6);
        return;
      }
      paramViewBase.setOnClickListener(null);
      return;
    } while (!szl.a((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
    paramViewBase.setOnClickListener(new oqq(this));
    return;
    paramViewBase.setOnClickListener(new pow((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
    return;
    paramViewBase.setOnClickListener(new pox((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Pgd.a(), this.jdField_a_of_type_Pgd, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getHolderView()));
    return;
    paramViewBase.setOnClickListener(new oqr(this));
    return;
    paramViewBase.setOnClickListener(new pou((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
    return;
    paramViewBase.setOnClickListener(new oqf(this));
    return;
    paramViewBase.setOnClickListener(new oqg(this));
    return;
    paramViewBase.setOnClickListener(new pop(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
    return;
    szl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pgd.a(), this.jdField_a_of_type_Pgd.e(), 4);
    return;
    szl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pgd.a(), this.jdField_a_of_type_Pgd.e(), 1);
    return;
    szl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pgd.a(), this.jdField_a_of_type_Pgd.e(), 3);
    return;
    szl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pgd.a(), this.jdField_a_of_type_Pgd.e(), 1000);
    return;
    paramViewBase.setOnClickListener(new oqh(this));
    return;
    paramViewBase.setOnClickListener(new oqi(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oqd
 * JD-Core Version:    0.7.0.1
 */