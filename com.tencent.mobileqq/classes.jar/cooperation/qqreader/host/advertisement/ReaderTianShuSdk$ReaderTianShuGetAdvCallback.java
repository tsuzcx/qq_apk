package cooperation.qqreader.host.advertisement;

import bmvh;
import bmvi;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class ReaderTianShuSdk$ReaderTianShuGetAdvCallback
  implements bmvh
{
  int jdField_a_of_type_Int;
  ReaderTianShuSdk.RequestListener jdField_a_of_type_CooperationQqreaderHostAdvertisementReaderTianShuSdk$RequestListener;
  
  ReaderTianShuSdk$ReaderTianShuGetAdvCallback(int paramInt, ReaderTianShuSdk.RequestListener paramRequestListener)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_CooperationQqreaderHostAdvertisementReaderTianShuSdk$RequestListener = paramRequestListener;
  }
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    ArrayList localArrayList = new ArrayList();
    if ((!paramBoolean) || (paramGetAdsRsp == null)) {}
    label274:
    label279:
    for (;;)
    {
      if (this.jdField_a_of_type_CooperationQqreaderHostAdvertisementReaderTianShuSdk$RequestListener != null) {
        this.jdField_a_of_type_CooperationQqreaderHostAdvertisementReaderTianShuSdk$RequestListener.onResult(paramBoolean, localArrayList);
      }
      return;
      label53:
      Object localObject;
      if (paramGetAdsRsp.mapAds.has())
      {
        paramGetAdsRsp = paramGetAdsRsp.mapAds.get();
        if (paramGetAdsRsp == null) {
          break label225;
        }
        localObject = paramGetAdsRsp.iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          paramGetAdsRsp = (TianShuAccess.RspEntry)((Iterator)localObject).next();
        } while ((paramGetAdsRsp == null) || (paramGetAdsRsp.key.get() != this.jdField_a_of_type_Int));
      }
      for (;;)
      {
        if ((paramGetAdsRsp == null) || (paramGetAdsRsp.value == null)) {
          break label279;
        }
        paramGetAdsRsp = paramGetAdsRsp.value.lst.get().iterator();
        for (;;)
        {
          if (!paramGetAdsRsp.hasNext()) {
            break label274;
          }
          localObject = (TianShuAccess.AdItem)paramGetAdsRsp.next();
          HashMap localHashMap = new HashMap();
          Iterator localIterator = ((TianShuAccess.AdItem)localObject).argList.get().iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              TianShuAccess.MapEntry localMapEntry = (TianShuAccess.MapEntry)localIterator.next();
              localHashMap.put(localMapEntry.key.get(), localMapEntry.value.get());
              continue;
              paramGetAdsRsp = null;
              break label53;
              label225:
              break;
            }
          }
          if (!localHashMap.containsKey("iAdId")) {
            localHashMap.put("iAdId", String.valueOf(((TianShuAccess.AdItem)localObject).iAdId.get()));
          }
          localArrayList.add(localHashMap);
          bmvi.a().a((TianShuAccess.AdItem)localObject);
        }
        break;
        paramGetAdsRsp = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.host.advertisement.ReaderTianShuSdk.ReaderTianShuGetAdvCallback
 * JD-Core Version:    0.7.0.1
 */