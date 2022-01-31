import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class rqs
  implements rjw
{
  private int jdField_a_of_type_Int = 10;
  
  rqs(rqj paramrqj) {}
  
  public List<rjx> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    int m;
    int k;
    Object localObject;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_Rqj.getCount()))
    {
      if ((this.jdField_a_of_type_Rqj.c == 0) || (this.jdField_a_of_type_Rqj.c == 40677)) {}
      int n;
      for (i = 0;; i = 1)
      {
        m = rmd.a().a("video_channel", paramInt);
        k = i + paramInt;
        i = 0;
        for (;;)
        {
          j = i;
          if (k >= this.jdField_a_of_type_Rqj.getCount()) {
            break label328;
          }
          j = i;
          if (k >= this.jdField_a_of_type_Int + paramInt) {
            break label328;
          }
          n = this.jdField_a_of_type_Rqj.a(k);
          if ((n != 4) && (n != 6) && (n != 66) && (n != 115) && (n != 46))
          {
            j = i;
            if (n != 70) {
              break label890;
            }
          }
          localObject = this.jdField_a_of_type_Rqj.b(k);
          if (localObject != null) {
            break;
          }
          k += 1;
        }
      }
      if ((n == 46) || (n == 70))
      {
        localArrayList.add(new rjx(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
        localArrayList.add(new rjx(((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).mVideoVid, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).innerUniqueID, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).busiType, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).getVideoDuration()));
        i += 2;
        j = i;
        if (i < m) {
          break label890;
        }
      }
    }
    for (int j = i;; j = 0)
    {
      label328:
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "scroll to next = " + paramBoolean + " preDownload to forward = " + j);
      }
      j = 0;
      i = 0;
      if (paramInt >= 0)
      {
        m = rmd.a().a();
        k = paramInt - 1;
        label391:
        j = i;
        if (k > 0)
        {
          j = i;
          if (k > paramInt - this.jdField_a_of_type_Int)
          {
            j = i;
            if (k < this.jdField_a_of_type_Rqj.getCount())
            {
              j = this.jdField_a_of_type_Rqj.a(k);
              if ((j != 4) && (j != 6) && (j != 66) && (j != 115) && (j != 46) && (j != 70)) {
                break label887;
              }
              localObject = this.jdField_a_of_type_Rqj.b(k);
              if (localObject != null) {}
            }
          }
        }
      }
      label887:
      for (;;)
      {
        k -= 1;
        break label391;
        localArrayList.add(new rjx(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
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
        localObject = new rjx(str, "", ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration());
        ((rjx)localObject).a = true;
        localArrayList.add(localObject);
        i = j + 1;
        break;
        if ((j == 46) || (j == 70))
        {
          localArrayList.add(new rjx(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
          localArrayList.add(new rjx(((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).mVideoVid, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).innerUniqueID, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).busiType, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).getVideoDuration()));
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
          localArrayList.add(new rjx(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
        }
      }
      label890:
      i = j;
      break;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Rqj.jdField_a_of_type_Rjk != null) {}
    for (String str = this.jdField_a_of_type_Rqj.jdField_a_of_type_Rjk.a();; str = "") {
      return rmd.a().a(this.jdField_a_of_type_Rqj.jdField_a_of_type_Rjg.a(str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rqs
 * JD-Core Version:    0.7.0.1
 */