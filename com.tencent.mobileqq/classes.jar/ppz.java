import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.image.RIJPreloadImage.1;
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

public class ppz
{
  private static int jdField_a_of_type_Int = 10;
  private static int b;
  private long jdField_a_of_type_Long;
  
  static
  {
    jdField_b_of_type_Int = 10;
  }
  
  private List<ppy> a(BaseArticleInfo paramBaseArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    URL localURL;
    if (paramBaseArticleInfo.mVideoCoverUrl != null)
    {
      localURL = paramBaseArticleInfo.mVideoCoverUrl;
      localArrayList.add(ppy.a(localURL, pjr.g()));
      if ((paramBaseArticleInfo.mSubArtilceList != null) && (paramBaseArticleInfo.mSubArtilceList.size() > 0))
      {
        paramBaseArticleInfo = (ArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
        if (paramBaseArticleInfo.mVideoCoverUrl == null) {
          break label121;
        }
        paramBaseArticleInfo = paramBaseArticleInfo.mVideoCoverUrl;
      }
    }
    for (;;)
    {
      localArrayList.add(ppy.a(paramBaseArticleInfo, pjr.g()));
      return localArrayList;
      if (paramBaseArticleInfo.mSinglePicture != null)
      {
        localURL = paramBaseArticleInfo.mSinglePicture;
        break;
      }
      localURL = pqa.a(paramBaseArticleInfo.mFirstPagePicUrl);
      break;
      label121:
      if (paramBaseArticleInfo.mSinglePicture != null) {
        paramBaseArticleInfo = paramBaseArticleInfo.mSinglePicture;
      } else {
        paramBaseArticleInfo = pqa.a(paramBaseArticleInfo.mFirstPagePicUrl);
      }
    }
  }
  
  private void a(List<ppy> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ppy localppy = (ppy)paramList.next();
      if ((localppy != null) && (localppy.jdField_a_of_type_JavaNetURL != null))
      {
        if (TextUtils.equals("pubaccountimage", localppy.jdField_a_of_type_JavaNetURL.getProtocol())) {
          localppy.jdField_a_of_type_JavaNetURL = pqa.a(localppy.jdField_a_of_type_JavaNetURL.getFile(), false);
        }
        if (localppy.jdField_a_of_type_JavaNetURL != null)
        {
          tlw localtlw = new tlw();
          qdn.a.a(localtlw, localppy.jdField_a_of_type_JavaNetURL.toString());
          localtlw.jdField_a_of_type_Int = ((Integer)localppy.jdField_a_of_type_AndroidUtilPair.first).intValue();
          localtlw.jdField_b_of_type_Int = ((Integer)localppy.jdField_a_of_type_AndroidUtilPair.second).intValue();
          localtlw.jdField_b_of_type_Boolean = true;
          tlv.a().a(localtlw, null);
        }
      }
    }
  }
  
  private List<ppy> b(BaseArticleInfo paramBaseArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBaseArticleInfo.mPictures != null)
    {
      paramBaseArticleInfo = paramBaseArticleInfo.mPictures;
      int j = paramBaseArticleInfo.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(ppy.a(paramBaseArticleInfo[i], pjr.a()));
        i += 1;
      }
    }
    return localArrayList;
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
  
  public void a(int paramInt1, int paramInt2, pne parampne)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJPreloadImage", 2, "preloadImg start:" + paramInt1 + " count:" + paramInt2);
    }
    long l = System.currentTimeMillis();
    if (!NetworkUtil.isWifiConnected(parampne.a().a())) {
      return;
    }
    ArrayList localArrayList = new ArrayList(parampne.a());
    ThreadManager.post(new RIJPreloadImage.1(this, this.jdField_a_of_type_Long, localArrayList, paramInt1, paramInt2, parampne, l), 5, null, true);
  }
  
  public void a(int paramInt1, int paramInt2, szd paramszd)
  {
    if (!PreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PreloadManager.a().e();
      int i = paramszd.a();
      while (paramInt1 <= paramInt2)
      {
        Object localObject = paramszd.getItem(paramInt1);
        if ((localObject instanceof BaseArticleInfo))
        {
          localObject = (BaseArticleInfo)localObject;
          if ((!pqw.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, (ArticleInfo)localObject)) && (!pqw.a((BaseArticleInfo)localObject)) && (!paramszd.a(i, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (aars.a((String)localObject)) {
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
  
  @VisibleForTesting
  public void a(List<ppy> paramList, int paramInt, BaseArticleInfo paramBaseArticleInfo, pne parampne)
  {
    paramInt = parampne.a().a().getItemViewType(paramInt);
    if (paramInt == 4) {
      if (paramBaseArticleInfo.mVideoCoverUrl != null)
      {
        paramBaseArticleInfo = paramBaseArticleInfo.mVideoCoverUrl;
        paramList.add(ppy.a(paramBaseArticleInfo, pjr.f()));
      }
    }
    do
    {
      return;
      if (paramBaseArticleInfo.mSinglePicture != null)
      {
        paramBaseArticleInfo = paramBaseArticleInfo.mSinglePicture;
        break;
      }
      paramBaseArticleInfo = pqa.a(paramBaseArticleInfo.mFirstPagePicUrl);
      break;
      if ((paramInt == 70) || (paramInt == 46))
      {
        paramList.addAll(a(paramBaseArticleInfo));
        return;
      }
      if ((paramInt == 3) || (paramInt == 14) || (paramInt == 105))
      {
        paramList.addAll(b(paramBaseArticleInfo));
        return;
      }
      if ((paramInt == 2) || (paramInt == 6) || (paramInt == 66) || (paramInt == 115))
      {
        paramList.add(ppy.a(paramBaseArticleInfo.mSinglePicture, pjr.e()));
        return;
      }
    } while ((paramInt != 1) && (paramInt != 5) && (paramInt != 104) && (paramInt != 106));
    paramList.add(ppy.a(paramBaseArticleInfo.mSinglePicture, pjr.a()));
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, pnx parampnx, pne parampne)
  {
    tlv.a().c();
    if (QLog.isColorLevel()) {
      QLog.d("RIJPreloadImage", 2, "resume image onScrollStateChanged idle");
    }
    if (paramBoolean) {
      a(paramInt2, jdField_a_of_type_Int, parampne);
    }
    for (;;)
    {
      if ((paramInt1 - paramInt2 < jdField_b_of_type_Int) && (parampnx != null)) {
        parampnx.a();
      }
      return;
      a(paramInt2 - jdField_a_of_type_Int, jdField_a_of_type_Int, parampne);
    }
  }
  
  public void b(int paramInt1, int paramInt2, szd paramszd)
  {
    if (!PublicAccountImageCollectionPreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PublicAccountImageCollectionPreloadManager.a().c();
      while (paramInt1 <= paramInt2)
      {
        Object localObject = paramszd.getItem(paramInt1);
        if (localObject != null)
        {
          localObject = (BaseArticleInfo)localObject;
          int i = paramszd.a(paramInt1);
          if ((i == 8) || (i == 7)) {
            PublicAccountImageCollectionPreloadManager.a().a(String.valueOf(((BaseArticleInfo)localObject).innerUniqueID));
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2, szd paramszd)
  {
    if ((!bmhv.C(pnn.b())) || (!bmhv.D(pnn.b()))) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    while (paramInt1 <= paramInt2)
    {
      Object localObject = paramszd.getItem(paramInt1);
      if (localObject != null)
      {
        localObject = (BaseArticleInfo)localObject;
        if (!pqw.a((BaseArticleInfo)localObject)) {
          localArrayList.add((ArticleInfo)localObject);
        }
      }
      paramInt1 += 1;
    }
    pvj.a().a().a(localArrayList);
  }
  
  public void d(int paramInt1, int paramInt2, szd paramszd)
  {
    if ((!udj.a.a()) || (!udj.a.c()) || (!udj.a.e())) {}
    for (;;)
    {
      return;
      while (paramInt1 <= paramInt2)
      {
        Object localObject = paramszd.getItem(paramInt1);
        if (localObject != null) {
          udf.a.a((BaseArticleInfo)localObject);
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ppz
 * JD-Core Version:    0.7.0.1
 */