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
import java.util.Map;

final class olt
  implements ViewFactory.FoundClickableViewListener
{
  olt(int paramInt, Container paramContainer, pau parampau, VafContext paramVafContext, baxy parambaxy, ram paramram, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    php localphp = (php)olo.a().get(Integer.valueOf(this.jdField_a_of_type_Int));
    if ((localphp != null) && (localphp.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_a_of_type_Pau, paramViewBase))) {}
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
          switch (i)
          {
          case 1035: 
          case 1143: 
          case 1145: 
          case 1146: 
          case 1009: 
          case 1011: 
          case 1017: 
          case 1018: 
          case 1028: 
          case 1030: 
          case 1034: 
          case 1040: 
          case 1041: 
          case 1047: 
          case 1048: 
          case 1049: 
          case 1050: 
          case 1051: 
          case 1052: 
          case 1053: 
          case 1054: 
          case 1055: 
          case 1056: 
          case 1057: 
          case 1058: 
          case 1059: 
          case 1060: 
          case 1061: 
          case 1062: 
          case 1063: 
          case 1067: 
          case 1068: 
          case 1069: 
          case 1071: 
          case 1072: 
          case 1073: 
          case 1074: 
          case 1075: 
          case 1076: 
          case 1077: 
          case 1078: 
          case 1079: 
          case 1080: 
          case 1081: 
          case 1083: 
          case 1084: 
          case 1085: 
          case 1086: 
          case 1087: 
          case 1088: 
          case 1089: 
          case 1090: 
          case 1091: 
          case 1092: 
          case 1093: 
          case 1094: 
          case 1102: 
          case 1110: 
          case 1111: 
          case 1112: 
          case 1113: 
          case 1114: 
          case 1115: 
          case 1116: 
          case 1117: 
          case 1118: 
          case 1119: 
          case 1120: 
          case 1121: 
          case 1122: 
          case 1123: 
          case 1124: 
          case 1125: 
          case 1126: 
          case 1127: 
          case 1128: 
          case 1129: 
          case 1130: 
          case 1131: 
          case 1132: 
          case 1133: 
          case 1134: 
          case 1135: 
          case 1136: 
          case 1137: 
          case 1138: 
          case 1139: 
          case 1140: 
          case 1141: 
          case 1144: 
          default: 
            paramViewBase.setOnClickListener(new oly(this, paramViewBase));
            return;
          case 1001: 
            paramViewBase.setOnClickListener(new olu(this, paramViewBase));
            return;
          }
        } while (!AdvertisementInfo.isAdvertisementInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
        paramViewBase.setOnClickListener(new olz(this));
        return;
        paramViewBase.setOnClickListener(new pip((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
        return;
        paramViewBase.setOnClickListener(new pjk((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Ram));
        return;
        paramViewBase.setOnClickListener(new pjl((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext));
        return;
        paramViewBase.setOnClickListener(new pii((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext));
        return;
        paramViewBase.setOnClickListener(new pih((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
        return;
        paramViewBase.setOnClickListener(new pje((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
        return;
        paramViewBase.setOnClickListener(new oma(this));
        return;
        paramViewBase.setOnClickListener(new pjf((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
        return;
      } while ((!onh.b((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (!onh.c((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)));
      paramViewBase.getNativeView().setOnClickListener(new omb(this));
      return;
      paramViewBase.setOnClickListener(new pig((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Ram));
      return;
      paramViewBase.setOnClickListener(new pio(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
      return;
      paramViewBase.setOnClickListener(new piw((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Int));
      return;
      paramViewBase.setOnClickListener(new pjc((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
      return;
      paramViewBase.setOnClickListener(new pjb((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
      return;
      paramViewBase.setOnClickListener(new pis((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Ram));
      return;
      paramViewBase.setOnClickListener(new pif((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
      return;
      paramViewBase.setOnClickListener(new piv((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
      return;
      paramViewBase.setOnClickListener(new piz((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Ram));
      return;
      paramViewBase.setOnClickListener(new piu((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Ram));
      return;
      paramViewBase.setOnClickListener(new pit((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Int));
      return;
      paramViewBase.setOnClickListener(new piq((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
      return;
      paramViewBase.setOnClickListener(new pik((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Int));
      return;
      paramViewBase.setOnClickListener(new pid(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
      return;
      paramViewBase.setOnClickListener(new omc(this));
      return;
      paramViewBase.setOnClickListener(new pin((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Int));
      return;
      paramViewBase.setOnClickListener(new pjd((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Int, paramViewBase.getEventAttachedData()));
      return;
      paramViewBase.setOnClickListener(new pir(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
      return;
      paramViewBase.setOnClickListener(new omd(this));
      return;
      paramViewBase.setOnClickListener(new ome(this, paramViewBase));
      return;
      if (AdvertisementInfo.class.isInstance(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        shq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pau.a(), this.jdField_a_of_type_Pau.e(), 5);
        return;
      }
      paramViewBase.setOnClickListener(null);
      return;
      shq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pau.a(), this.jdField_a_of_type_Pau.e(), 5);
      return;
      shq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pau.a(), this.jdField_a_of_type_Pau.e(), 8);
      return;
      shq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pau.a(), this.jdField_a_of_type_Pau.e(), oae.a(i));
      return;
      if (AdvertisementInfo.class.isInstance(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        shq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pau.a(), this.jdField_a_of_type_Pau.e(), 6);
        return;
      }
      paramViewBase.setOnClickListener(null);
      return;
    } while (!shq.a((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
    paramViewBase.setOnClickListener(new omf(this));
    return;
    paramViewBase.setOnClickListener(new pil((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
    return;
    paramViewBase.setOnClickListener(new pim((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Pau.a(), this.jdField_a_of_type_Pau, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getHolderView()));
    return;
    paramViewBase.setOnClickListener(new omg(this));
    return;
    paramViewBase.setOnClickListener(new pij((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
    return;
    paramViewBase.setOnClickListener(new olv(this));
    return;
    paramViewBase.setOnClickListener(new olw(this));
    return;
    paramViewBase.setOnClickListener(new pie(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
    return;
    shq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pau.a(), this.jdField_a_of_type_Pau.e(), 4);
    return;
    shq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pau.a(), this.jdField_a_of_type_Pau.e(), 1);
    return;
    shq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pau.a(), this.jdField_a_of_type_Pau.e(), 3);
    return;
    shq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Pau.a(), this.jdField_a_of_type_Pau.e(), 1000);
    return;
    paramViewBase.setOnClickListener(new olx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     olt
 * JD-Core Version:    0.7.0.1
 */