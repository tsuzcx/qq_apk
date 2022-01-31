import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class rav
  implements quh
{
  private int jdField_a_of_type_Int = 10;
  
  rav(ram paramram) {}
  
  public List<qui> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    int k;
    int m;
    Object localObject;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_Ram.getCount()))
    {
      if ((this.jdField_a_of_type_Ram.c == 0) || (this.jdField_a_of_type_Ram.c == 40677)) {}
      for (i = 0;; i = 1)
      {
        k = i + paramInt;
        i = 0;
        for (;;)
        {
          j = i;
          if (k >= this.jdField_a_of_type_Ram.getCount()) {
            break label324;
          }
          j = i;
          if (k >= this.jdField_a_of_type_Int + paramInt) {
            break label324;
          }
          m = this.jdField_a_of_type_Ram.a(k);
          if ((m != 4) && (m != 6) && (m != 66) && (m != 115) && (m != 46))
          {
            j = i;
            if (m != 70) {
              break label906;
            }
          }
          localObject = this.jdField_a_of_type_Ram.b(k);
          if (localObject != null) {
            break;
          }
          k += 1;
        }
      }
      if ((m == 46) || (m == 70))
      {
        localArrayList.add(new qui(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
        localArrayList.add(new qui(((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).mVideoVid, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).innerUniqueID, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).busiType, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).getVideoDuration()));
        i += 2;
        if (!paramBoolean) {
          break label647;
        }
        m = 4;
        label312:
        j = i;
        if (i < m) {
          break label906;
        }
      }
    }
    for (int j = i;; j = 0)
    {
      label324:
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "scroll to next = " + paramBoolean + " preDownload to forward = " + j);
      }
      j = 0;
      i = 0;
      if (paramInt >= 0)
      {
        k = paramInt - 1;
        label379:
        j = i;
        if (k > 0)
        {
          j = i;
          if (k > paramInt - this.jdField_a_of_type_Int)
          {
            j = i;
            if (k < this.jdField_a_of_type_Ram.getCount())
            {
              j = this.jdField_a_of_type_Ram.a(k);
              if ((j != 4) && (j != 6) && (j != 66) && (j != 115) && (j != 46) && (j != 70)) {
                break label900;
              }
              localObject = this.jdField_a_of_type_Ram.b(k);
              if (localObject == null) {
                j = i;
              }
            }
          }
        }
      }
      for (;;)
      {
        k -= 1;
        i = j;
        break label379;
        localArrayList.add(new qui(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
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
        localObject = new qui(str, "", ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration());
        ((qui)localObject).a = true;
        localArrayList.add(localObject);
        i = j + 1;
        break;
        label647:
        m = 3;
        break label312;
        if ((j == 46) || (j == 70))
        {
          localArrayList.add(new qui(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
          localArrayList.add(new qui(((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).mVideoVid, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).innerUniqueID, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).busiType, ((ArticleInfo)((BaseArticleInfo)localObject).mSubArtilceList.get(0)).getVideoDuration()));
          i += 2;
          label789:
          if (!paramBoolean) {
            break label894;
          }
        }
        label894:
        for (m = 1;; m = 2)
        {
          j = i;
          if (i < m) {
            break;
          }
          j = i;
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseAdapter", 2, "scroll to next = " + paramBoolean + " preDownload to backward = " + j);
          }
          return localArrayList;
          localArrayList.add(new qui(((BaseArticleInfo)localObject).mVideoVid, ((BaseArticleInfo)localObject).innerUniqueID, ((BaseArticleInfo)localObject).busiType, ((BaseArticleInfo)localObject).getVideoDuration()));
          i += 1;
          break label789;
        }
        label900:
        j = i;
      }
      label906:
      i = j;
      break;
    }
  }
  
  public boolean a()
  {
    return bbfj.h(this.jdField_a_of_type_Ram.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rav
 * JD-Core Version:    0.7.0.1
 */