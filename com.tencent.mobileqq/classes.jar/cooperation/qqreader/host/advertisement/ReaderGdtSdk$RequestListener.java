package cooperation.qqreader.host.advertisement;

import aamt;
import aamu;
import aamv;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.MutiPicTextInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

public abstract class ReaderGdtSdk$RequestListener
  implements aamu
{
  public void onResponse(aamt paramaamt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = null;
    paramaamt = paramaamt.a().a;
    if (paramaamt == null) {
      paramaamt = (aamt)localObject;
    }
    for (;;)
    {
      onResult(localArrayList, paramaamt);
      return;
      localObject = paramaamt.pos_ads_info.get();
      paramaamt = paramaamt.gdt_cookie.get();
      if (localObject != null) {
        if (!((List)localObject).isEmpty())
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            qq_ad_get.QQAdGetRsp.PosAdInfo localPosAdInfo = (qq_ad_get.QQAdGetRsp.PosAdInfo)((Iterator)localObject).next();
            Iterator localIterator = localPosAdInfo.ads_info.get().iterator();
            while (localIterator.hasNext())
            {
              qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)localIterator.next();
              if ((!localAdInfo.display_info.basic_info.img.get().isEmpty()) || (localAdInfo.display_info.muti_pic_text_info.image.size() >= 3)) {
                localArrayList.add(new ReaderAdWrapper(new GdtAd(localAdInfo), localPosAdInfo.pos_id.get()));
              }
            }
          }
        }
      }
    }
  }
  
  public abstract void onResult(@NonNull List<ReaderAdWrapper> paramList, @Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.host.advertisement.ReaderGdtSdk.RequestListener
 * JD-Core Version:    0.7.0.1
 */