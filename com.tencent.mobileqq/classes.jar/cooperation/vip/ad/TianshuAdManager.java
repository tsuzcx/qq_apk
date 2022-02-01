package cooperation.vip.ad;

import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.widget.ARMapHongBaoListView;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import cooperation.vip.tianshu.TianShuManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TianshuAdManager
{
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityHomeConversation;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TianShuGetAdvCallback jdField_a_of_type_ComTencentMobileqqTianshuDataTianShuGetAdvCallback = new TianshuAdManager.1(this);
  private ARMapHongBaoListView jdField_a_of_type_ComTencentWidgetARMapHongBaoListView;
  private TianshuBigInsertPage jdField_a_of_type_CooperationVipAdTianshuBigInsertPage;
  private TianshuBreathLight jdField_a_of_type_CooperationVipAdTianshuBreathLight;
  private TianshuPendantHolder jdField_a_of_type_CooperationVipAdTianshuPendantHolder;
  
  public TianshuAdManager(QQAppInterface paramQQAppInterface, Conversation paramConversation, ARMapHongBaoListView paramARMapHongBaoListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation = paramConversation;
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView = paramARMapHongBaoListView;
  }
  
  private void a(TianShuAccess.AdItem paramAdItem)
  {
    if (this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage == null) {
      this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage = new TianshuBigInsertPage(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation);
    }
    this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage.a(paramAdItem);
  }
  
  private void a(TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation == null) {
        return;
      }
      if (paramGetAdsRsp.mapAds.has()) {
        paramGetAdsRsp = paramGetAdsRsp.mapAds.get();
      } else {
        paramGetAdsRsp = null;
      }
      if (paramGetAdsRsp == null) {
        return;
      }
      HashMap localHashMap = new HashMap();
      paramGetAdsRsp = paramGetAdsRsp.iterator();
      while (paramGetAdsRsp.hasNext())
      {
        TianShuAccess.RspEntry localRspEntry = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
        if ((localRspEntry != null) && (localRspEntry.key.has())) {
          localHashMap.put(Integer.valueOf(localRspEntry.key.get()), localRspEntry);
        }
      }
      a(localHashMap);
    }
  }
  
  private void a(Map<Integer, TianShuAccess.RspEntry> paramMap)
  {
    Object localObject = (TianShuAccess.RspEntry)paramMap.get(Integer.valueOf(340));
    if ((localObject != null) && (((TianShuAccess.RspEntry)localObject).value != null) && (((TianShuAccess.RspEntry)localObject).value.lst.size() != 0) && (((TianShuAccess.RspEntry)localObject).value.lst.get(0) != null)) {
      a((TianShuAccess.AdItem)((TianShuAccess.RspEntry)localObject).value.lst.get(0));
    }
    localObject = (TianShuAccess.RspEntry)paramMap.get(Integer.valueOf(341));
    if ((localObject != null) && (((TianShuAccess.RspEntry)localObject).value != null) && (((TianShuAccess.RspEntry)localObject).value.lst.size() != 0) && (((TianShuAccess.RspEntry)localObject).value.lst.get(0) != null)) {
      b((TianShuAccess.AdItem)((TianShuAccess.RspEntry)localObject).value.lst.get(0));
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView;
    if ((localObject != null) && (((ARMapHongBaoListView)localObject).a == null))
    {
      paramMap = (TianShuAccess.RspEntry)paramMap.get(Integer.valueOf(339));
      if ((paramMap != null) && (paramMap.value != null) && (paramMap.value.lst.size() != 0) && (paramMap.value.lst.get(0) != null)) {
        c((TianShuAccess.AdItem)paramMap.value.lst.get(0));
      }
    }
  }
  
  private void b(TianShuAccess.AdItem paramAdItem)
  {
    ARMapHongBaoListView localARMapHongBaoListView = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView;
    if (localARMapHongBaoListView != null)
    {
      if (this.jdField_a_of_type_CooperationVipAdTianshuPendantHolder == null)
      {
        this.jdField_a_of_type_CooperationVipAdTianshuPendantHolder = new TianshuPendantHolder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localARMapHongBaoListView);
        this.jdField_a_of_type_CooperationVipAdTianshuPendantHolder.c();
      }
      this.jdField_a_of_type_CooperationVipAdTianshuPendantHolder.a(paramAdItem);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setPendantHolder(this.jdField_a_of_type_CooperationVipAdTianshuPendantHolder);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setOnPendentClickListener(this.jdField_a_of_type_CooperationVipAdTianshuPendantHolder);
    }
  }
  
  private void c(TianShuAccess.AdItem paramAdItem)
  {
    ARMapHongBaoListView localARMapHongBaoListView = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView;
    if (localARMapHongBaoListView != null)
    {
      if (this.jdField_a_of_type_CooperationVipAdTianshuBreathLight == null)
      {
        this.jdField_a_of_type_CooperationVipAdTianshuBreathLight = new TianshuBreathLight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localARMapHongBaoListView);
        this.jdField_a_of_type_CooperationVipAdTianshuBreathLight.c();
      }
      this.jdField_a_of_type_CooperationVipAdTianshuBreathLight.a(paramAdItem);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.a(this.jdField_a_of_type_CooperationVipAdTianshuBreathLight);
    }
  }
  
  public void a()
  {
    TianShuManager.getInstance().requestAdv(TianshuAdUtils.a(), this.jdField_a_of_type_ComTencentMobileqqTianshuDataTianShuGetAdvCallback);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.setPendantHolder(null);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.h();
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setOnPendentClickListener(null);
    }
    this.jdField_a_of_type_CooperationVipAdTianshuBreathLight = null;
    this.jdField_a_of_type_CooperationVipAdTianshuPendantHolder = null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ad.TianshuAdManager
 * JD-Core Version:    0.7.0.1
 */