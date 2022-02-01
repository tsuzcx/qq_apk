import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.image.RIJPreloadImage.1;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pgv
{
  private static int jdField_a_of_type_Int = 10;
  private static int b;
  private long jdField_a_of_type_Long;
  
  static
  {
    jdField_b_of_type_Int = 10;
  }
  
  private void a(List<pgu> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      pgu localpgu = (pgu)paramList.next();
      if ((localpgu != null) && (localpgu.jdField_a_of_type_JavaNetURL != null))
      {
        if (TextUtils.equals("pubaccountimage", localpgu.jdField_a_of_type_JavaNetURL.getProtocol())) {
          localpgu.jdField_a_of_type_JavaNetURL = pay.a(localpgu.jdField_a_of_type_JavaNetURL.getFile(), false);
        }
        if (localpgu.jdField_a_of_type_JavaNetURL != null)
        {
          syo localsyo = new syo();
          psq.a.a(localsyo, localpgu.jdField_a_of_type_JavaNetURL.toString());
          localsyo.jdField_a_of_type_Int = ((Integer)localpgu.jdField_a_of_type_AndroidUtilPair.first).intValue();
          localsyo.jdField_b_of_type_Int = ((Integer)localpgu.jdField_a_of_type_AndroidUtilPair.second).intValue();
          localsyo.jdField_b_of_type_Boolean = true;
          syn.a().a(localsyo, null);
        }
      }
    }
  }
  
  private void a(List<pgu> paramList, int paramInt, BaseArticleInfo paramBaseArticleInfo, ped paramped)
  {
    paramInt = paramped.a().a().getItemViewType(paramInt);
    if (paramInt == 4) {
      if (paramBaseArticleInfo.mVideoCoverUrl != null)
      {
        paramBaseArticleInfo = paramBaseArticleInfo.mVideoCoverUrl;
        paramList.add(pgu.a(paramBaseArticleInfo, pai.f()));
      }
    }
    for (;;)
    {
      return;
      if (paramBaseArticleInfo.mSinglePicture != null)
      {
        paramBaseArticleInfo = paramBaseArticleInfo.mSinglePicture;
        break;
      }
      paramBaseArticleInfo = pay.a(paramBaseArticleInfo.mFirstPagePicUrl);
      break;
      if ((paramInt == 70) || (paramInt == 46))
      {
        if (paramBaseArticleInfo.mVideoCoverUrl != null)
        {
          paramped = paramBaseArticleInfo.mVideoCoverUrl;
          paramList.add(pgu.a(paramped, pai.g()));
          if ((paramBaseArticleInfo.mSubArtilceList == null) || (paramBaseArticleInfo.mSubArtilceList.size() <= 0)) {
            continue;
          }
          paramBaseArticleInfo = (ArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
          if (paramBaseArticleInfo.mVideoCoverUrl == null) {
            break label199;
          }
          paramBaseArticleInfo = paramBaseArticleInfo.mVideoCoverUrl;
        }
        for (;;)
        {
          paramList.add(pgu.a(paramBaseArticleInfo, pai.g()));
          return;
          if (paramBaseArticleInfo.mSinglePicture != null)
          {
            paramped = paramBaseArticleInfo.mSinglePicture;
            break;
          }
          paramped = pay.a(paramBaseArticleInfo.mFirstPagePicUrl);
          break;
          label199:
          if (paramBaseArticleInfo.mSinglePicture != null) {
            paramBaseArticleInfo = paramBaseArticleInfo.mSinglePicture;
          } else {
            paramBaseArticleInfo = pay.a(paramBaseArticleInfo.mFirstPagePicUrl);
          }
        }
      }
      else if ((paramInt == 3) || (paramInt == 14) || (paramInt == 105))
      {
        if (paramBaseArticleInfo.mPictures != null)
        {
          paramBaseArticleInfo = paramBaseArticleInfo.mPictures;
          int i = paramBaseArticleInfo.length;
          paramInt = 0;
          while (paramInt < i)
          {
            paramList.add(pgu.a(paramBaseArticleInfo[paramInt], pai.a()));
            paramInt += 1;
          }
        }
      }
      else
      {
        if ((paramInt == 2) || (paramInt == 6) || (paramInt == 66) || (paramInt == 115))
        {
          paramList.add(pgu.a(paramBaseArticleInfo.mSinglePicture, pai.e()));
          return;
        }
        if ((paramInt == 1) || (paramInt == 5) || (paramInt == 104) || (paramInt == 106))
        {
          paramList.add(pgu.a(paramBaseArticleInfo.mSinglePicture, pai.a()));
          return;
        }
        if ((paramInt == 122) && (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) && (twr.k((AdvertisementInfo)paramBaseArticleInfo)) && (((AdvertisementInfo)paramBaseArticleInfo).mAdImgList != null))
        {
          paramBaseArticleInfo = ((AdvertisementInfo)paramBaseArticleInfo).mAdImgList.iterator();
          while (paramBaseArticleInfo.hasNext()) {
            paramList.add(pgu.a(pay.a((String)paramBaseArticleInfo.next()), pai.e()));
          }
        }
      }
    }
  }
  
  public int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJPreloadImage", 2, "cpu:" + DeviceInfoUtil.getCpuNumber() + " mem:" + DeviceInfoUtil.getSystemTotalMemory() + " fre:" + DeviceInfoUtil.getCpuFrequency());
    }
    int i = DeviceInfoUtil.getCpuNumber();
    long l = DeviceInfoUtil.getSystemTotalMemory();
    if ((i >= 4) && (l >= 1610612736.0D))
    {
      jdField_a_of_type_Int = 6;
      return;
    }
    jdField_a_of_type_Int = 4;
  }
  
  public void a(int paramInt1, int paramInt2, ped paramped)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJPreloadImage", 2, "preloadImg start:" + paramInt1 + " count:" + paramInt2);
    }
    long l = System.currentTimeMillis();
    if (!NetworkUtil.isWifiConnected(paramped.a().a())) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramped.a());
    ThreadManager.post(new RIJPreloadImage.1(this, this.jdField_a_of_type_Long, localArrayList, paramInt1, paramInt2, paramped, l), 5, null, true);
  }
  
  public void a(int paramInt1, int paramInt2, slt paramslt)
  {
    if (!PreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PreloadManager.a().e();
      int i = paramslt.a();
      while (paramInt1 <= paramInt2)
      {
        Object localObject = paramslt.getItem(paramInt1);
        if ((localObject instanceof BaseArticleInfo))
        {
          localObject = (BaseArticleInfo)localObject;
          if ((!pay.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, (ArticleInfo)localObject)) && (!pay.a((BaseArticleInfo)localObject)) && (!paramslt.a(i, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (aacg.a((String)localObject)) {
              PreloadManager.a().a((String)localObject);
            }
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, peu parampeu, ped paramped)
  {
    syn.a().c();
    if (QLog.isColorLevel()) {
      QLog.d("RIJPreloadImage", 2, "resume image onScrollStateChanged idle");
    }
    if (paramBoolean) {
      a(paramInt2, jdField_a_of_type_Int, paramped);
    }
    for (;;)
    {
      if ((paramInt1 - paramInt2 < jdField_b_of_type_Int) && (parampeu != null)) {
        parampeu.a();
      }
      return;
      a(paramInt2 - jdField_a_of_type_Int, jdField_a_of_type_Int, paramped);
    }
  }
  
  public void b(int paramInt1, int paramInt2, slt paramslt)
  {
    if (!PublicAccountImageCollectionPreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PublicAccountImageCollectionPreloadManager.a().c();
      while (paramInt1 <= paramInt2)
      {
        Object localObject = paramslt.getItem(paramInt1);
        if (localObject != null)
        {
          localObject = (BaseArticleInfo)localObject;
          int i = paramslt.a(paramInt1);
          if ((i == 8) || (i == 7)) {
            PublicAccountImageCollectionPreloadManager.a().a(String.valueOf(((BaseArticleInfo)localObject).innerUniqueID));
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2, slt paramslt)
  {
    if ((!bkwm.C(pem.a())) || (!bkwm.D(pem.a()))) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    while (paramInt1 <= paramInt2)
    {
      Object localObject = paramslt.getItem(paramInt1);
      if (localObject != null)
      {
        localObject = (BaseArticleInfo)localObject;
        if (!pay.a((BaseArticleInfo)localObject)) {
          localArrayList.add((ArticleInfo)localObject);
        }
      }
      paramInt1 += 1;
    }
    pkm.a().a().a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgv
 * JD-Core Version:    0.7.0.1
 */