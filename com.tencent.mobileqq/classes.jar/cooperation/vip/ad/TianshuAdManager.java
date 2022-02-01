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
  private ARMapHongBaoListView a;
  private TianshuBigInsertPage b;
  private TianshuBreathLight c;
  private TianshuPendantHolder d;
  private QQAppInterface e;
  private Conversation f;
  private TianShuGetAdvCallback g = new TianshuAdManager.1(this);
  
  public TianshuAdManager(QQAppInterface paramQQAppInterface, Conversation paramConversation, ARMapHongBaoListView paramARMapHongBaoListView)
  {
    this.e = paramQQAppInterface;
    this.f = paramConversation;
    this.a = paramARMapHongBaoListView;
  }
  
  private void a(TianShuAccess.AdItem paramAdItem)
  {
    if (this.b == null) {
      this.b = new TianshuBigInsertPage(this.f);
    }
    this.b.a(paramAdItem);
  }
  
  private void a(TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if (this.e != null)
    {
      if (this.f == null) {
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
    localObject = this.a;
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
    ARMapHongBaoListView localARMapHongBaoListView = this.a;
    if (localARMapHongBaoListView != null)
    {
      if (this.d == null)
      {
        this.d = new TianshuPendantHolder(this.e, localARMapHongBaoListView);
        this.d.d();
      }
      this.d.a(paramAdItem);
      this.a.setPendantHolder(this.d);
      this.a.setOnPendentClickListener(this.d);
    }
  }
  
  private void c(TianShuAccess.AdItem paramAdItem)
  {
    ARMapHongBaoListView localARMapHongBaoListView = this.a;
    if (localARMapHongBaoListView != null)
    {
      if (this.c == null)
      {
        this.c = new TianshuBreathLight(this.e, localARMapHongBaoListView);
        this.c.d();
      }
      this.c.a(paramAdItem);
      this.a.a(this.c);
    }
  }
  
  public void a()
  {
    TianShuManager.getInstance().requestAdv(TianshuAdUtils.a(), this.g);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.e = paramQQAppInterface;
    paramQQAppInterface = this.a;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.setPendantHolder(null);
      this.a.i();
      this.a.setOnPendentClickListener(null);
    }
    this.c = null;
    this.d = null;
  }
  
  public void b()
  {
    this.e = null;
    this.f = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.ad.TianshuAdManager
 * JD-Core Version:    0.7.0.1
 */