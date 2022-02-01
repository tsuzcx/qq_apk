import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class psi
  implements sdr
{
  psi(psf parampsf) {}
  
  public List<sds> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    int m;
    int k;
    Object localObject;
    if ((paramInt >= 0) && (paramInt < this.a.d()))
    {
      if ((this.a.b() == 0) || (this.a.b() == 40677)) {}
      int n;
      for (i = 0;; i = 1)
      {
        m = sfm.a().a("video_channel", paramInt);
        k = i + paramInt;
        i = 0;
        for (;;)
        {
          j = i;
          if (k >= this.a.d()) {
            break label329;
          }
          j = i;
          if (k >= paramInt + 10) {
            break label329;
          }
          n = this.a.a(k).intValue();
          if ((n != 4) && (n != 6) && (n != 66) && (n != 115) && (n != 46))
          {
            j = i;
            if (n != 70) {
              break label892;
            }
          }
          localObject = psf.a(this.a, k);
          if (localObject != null) {
            break;
          }
          k += 1;
        }
      }
      if ((n == 46) || (n == 70))
      {
        localArrayList.add(new sds(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
        localArrayList.add(new sds(((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).mVideoVid, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).innerUniqueID, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).busiType, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).getVideoDuration()));
        i += 2;
        j = i;
        if (i < m) {
          break label892;
        }
      }
    }
    for (int j = i;; j = 0)
    {
      label329:
      if (QLog.isColorLevel()) {
        QLog.d("VideoHandler", 2, "scroll to next = " + paramBoolean + " preDownload to forward = " + j);
      }
      j = 0;
      i = 0;
      if (paramInt >= 0)
      {
        m = sfm.a().a();
        k = paramInt - 1;
        label392:
        j = i;
        if (k > 0)
        {
          j = i;
          if (k > paramInt - 10)
          {
            j = i;
            if (k < this.a.d())
            {
              j = this.a.a(k).intValue();
              if ((j != 4) && (j != 6) && (j != 66) && (j != 115) && (j != 46) && (j != 70)) {
                break label889;
              }
              localObject = psf.a(this.a, k);
              if (localObject != null) {}
            }
          }
        }
      }
      label889:
      for (;;)
      {
        k -= 1;
        break label392;
        localArrayList.add(new sds(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
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
        localObject = new sds(str, "", ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration());
        ((sds)localObject).a = true;
        localArrayList.add(localObject);
        i = j + 1;
        break;
        if ((j == 46) || (j == 70))
        {
          localArrayList.add(new sds(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
          localArrayList.add(new sds(((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).mVideoVid, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).innerUniqueID, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).busiType, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).getVideoDuration()));
        }
        for (j = i + 2;; j = i + 1)
        {
          i = j;
          if (j < m) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoHandler", 2, "scroll to next = " + paramBoolean + " preDownload to backward = " + j);
          }
          return localArrayList;
          localArrayList.add(new sds(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
        }
      }
      label892:
      i = j;
      break;
    }
  }
  
  public boolean a()
  {
    Object localObject = psf.a(this.a);
    if (localObject != null) {}
    for (localObject = ((sdg)localObject).a();; localObject = "") {
      return sfm.a().a(this.a.a.a((String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psi
 * JD-Core Version:    0.7.0.1
 */