import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class snr
  implements sfj
{
  snr(snh paramsnh) {}
  
  public List<sfk> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    int m;
    int k;
    Object localObject;
    if ((paramInt >= 0) && (paramInt < this.a.getCount()))
    {
      if ((this.a.c == 0) || (this.a.c == 40677)) {}
      int n;
      for (i = 0;; i = 1)
      {
        m = she.a().a("video_channel", paramInt);
        k = i + paramInt;
        i = 0;
        for (;;)
        {
          j = i;
          if (k >= this.a.getCount()) {
            break label326;
          }
          j = i;
          if (k >= paramInt + 10) {
            break label326;
          }
          n = this.a.a(k);
          if ((n != 4) && (n != 6) && (n != 66) && (n != 115) && (n != 46))
          {
            j = i;
            if (n != 70) {
              break label886;
            }
          }
          localObject = this.a.b(k);
          if (localObject != null) {
            break;
          }
          k += 1;
        }
      }
      if ((n == 46) || (n == 70))
      {
        localArrayList.add(new sfk(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
        localArrayList.add(new sfk(((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).mVideoVid, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).innerUniqueID, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).busiType, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).getVideoDuration()));
        i += 2;
        j = i;
        if (i < m) {
          break label886;
        }
      }
    }
    for (int j = i;; j = 0)
    {
      label326:
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "scroll to next = " + paramBoolean + " preDownload to forward = " + j);
      }
      j = 0;
      i = 0;
      if (paramInt >= 0)
      {
        m = she.a().a();
        k = paramInt - 1;
        label389:
        j = i;
        if (k > 0)
        {
          j = i;
          if (k > paramInt - 10)
          {
            j = i;
            if (k < this.a.getCount())
            {
              j = this.a.a(k);
              if ((j != 4) && (j != 6) && (j != 66) && (j != 115) && (j != 46) && (j != 70)) {
                break label883;
              }
              localObject = this.a.b(k);
              if (localObject != null) {}
            }
          }
        }
      }
      label883:
      for (;;)
      {
        k -= 1;
        break label389;
        localArrayList.add(new sfk(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
        j = i + 1;
        i = j;
        if (((BaseArticleInfo)localObject).busiType != 5) {
          break;
        }
        i = j;
        if (!(localObject instanceof AdvertisementInfo)) {
          break;
        }
        i = j;
        if (((AdvertisementInfo)localObject).mImaxShowAdType != 1001) {
          break;
        }
        String str = ((AdvertisementInfo)localObject).mImaxVideoUrl;
        i = j;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        localObject = new sfk(str, "", ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration());
        ((sfk)localObject).a = true;
        localArrayList.add(localObject);
        i = j + 1;
        break;
        if ((j == 46) || (j == 70))
        {
          localArrayList.add(new sfk(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
          localArrayList.add(new sfk(((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).mVideoVid, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).innerUniqueID, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).busiType, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).getVideoDuration()));
        }
        for (j = i + 2;; j = i + 1)
        {
          i = j;
          if (j < m) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseAdapter", 2, "scroll to next = " + paramBoolean + " preDownload to backward = " + j);
          }
          return localArrayList;
          localArrayList.add(new sfk(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
        }
      }
      label886:
      i = j;
      break;
    }
  }
  
  public boolean a()
  {
    if (this.a.jdField_a_of_type_Sey != null) {}
    for (String str = this.a.jdField_a_of_type_Sey.a();; str = "") {
      return she.a().a(this.a.jdField_a_of_type_Seu.a(str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     snr
 * JD-Core Version:    0.7.0.1
 */