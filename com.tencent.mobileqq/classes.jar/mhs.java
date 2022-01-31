import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class mhs
  implements Runnable
{
  public mhs(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, long paramLong1, List paramList, int paramInt1, int paramInt2, long paramLong2) {}
  
  public void run()
  {
    if (ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter) != this.jdField_a_of_type_Long) {
      return;
    }
    int i;
    label25:
    LinkedList localLinkedList;
    int j;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      i = 0;
      localLinkedList = new LinkedList();
      j = this.jdField_a_of_type_Int;
      label39:
      if (j >= this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) {
        break label787;
      }
      if ((j < i) && (j >= 0)) {
        break label81;
      }
    }
    label61:
    label81:
    Object localObject2;
    int k;
    label182:
    Object localObject1;
    label213:
    label228:
    label377:
    Object localObject3;
    for (;;)
    {
      j += 1;
      break label39;
      i = this.jdField_a_of_type_JavaUtilList.size();
      break label25;
      if (ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter) != this.jdField_a_of_type_Long) {
        break;
      }
      for (;;)
      {
        try
        {
          localObject2 = (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(j);
          k = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.getItemViewType(j);
          if (k != 4) {
            break label969;
          }
          if (((BaseArticleInfo)localObject2).mVideoCoverUrl == null) {
            break label182;
          }
          URL localURL = ((BaseArticleInfo)localObject2).mVideoCoverUrl;
          localLinkedList.add(mib.a(localURL, ReadInJoyDisplayUtils.c()));
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if (ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter) == this.jdField_a_of_type_Long) {
          break;
        }
        return;
        if (((BaseArticleInfo)localObject2).mSinglePicture != null) {
          localObject1 = ((BaseArticleInfo)localObject2).mSinglePicture;
        } else {
          localObject1 = ReadInJoyUtils.a(((BaseArticleInfo)localObject2).mFirstPagePicUrl);
        }
      }
      if (((BaseArticleInfo)localObject2).mVideoCoverUrl != null)
      {
        localObject1 = ((BaseArticleInfo)localObject2).mVideoCoverUrl;
        localLinkedList.add(mib.a((URL)localObject1, ReadInJoyDisplayUtils.d()));
        if ((((BaseArticleInfo)localObject2).mSubArtilceList == null) || (((BaseArticleInfo)localObject2).mSubArtilceList.size() <= 0)) {
          continue;
        }
        localObject1 = (ArticleInfo)((BaseArticleInfo)localObject2).mSubArtilceList.get(0);
        if (((ArticleInfo)localObject1).mVideoCoverUrl == null) {
          break label346;
        }
        localObject1 = ((ArticleInfo)localObject1).mVideoCoverUrl;
      }
      for (;;)
      {
        localLinkedList.add(mib.a((URL)localObject1, ReadInJoyDisplayUtils.d()));
        break;
        if (((BaseArticleInfo)localObject2).mSinglePicture != null)
        {
          localObject1 = ((BaseArticleInfo)localObject2).mSinglePicture;
          break label228;
        }
        localObject1 = ReadInJoyUtils.a(((BaseArticleInfo)localObject2).mFirstPagePicUrl);
        break label228;
        label346:
        if (((ArticleInfo)localObject1).mSinglePicture != null) {
          localObject1 = ((ArticleInfo)localObject1).mSinglePicture;
        } else {
          localObject1 = ReadInJoyUtils.a(((ArticleInfo)localObject1).mFirstPagePicUrl);
        }
      }
      if ((((BaseArticleInfo)localObject2).mPictures == null) || (((BaseArticleInfo)localObject2).mPictures.length <= 0))
      {
        localObject3 = ReadInJoyBaseAdapter.a(((BaseArticleInfo)localObject2).mJsonPictureList, "pictures");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
        {
          localObject1 = ((JSONArray)localObject3).optJSONObject(0);
          if (localObject1 == null)
          {
            localObject1 = ((BaseArticleInfo)localObject2).mFirstPagePicUrl;
            label439:
            localLinkedList.add(mib.a(ReadInJoyUtils.a((String)localObject1), ReadInJoyDisplayUtils.a()));
            localObject1 = ((JSONArray)localObject3).optJSONObject(1);
            if (localObject1 != null) {
              break label551;
            }
            localObject1 = ((BaseArticleInfo)localObject2).mFirstPagePicUrl;
            label478:
            localLinkedList.add(mib.a(ReadInJoyUtils.a((String)localObject1), ReadInJoyDisplayUtils.a()));
            localObject1 = ((JSONArray)localObject3).optJSONObject(2);
            if (localObject1 != null) {
              break label563;
            }
          }
          label551:
          label563:
          for (localObject1 = ((BaseArticleInfo)localObject2).mFirstPagePicUrl;; localObject1 = ((JSONObject)localObject1).optString("picture"))
          {
            localLinkedList.add(mib.a(ReadInJoyUtils.a((String)localObject1), ReadInJoyDisplayUtils.a()));
            break;
            localObject1 = ((JSONObject)localObject1).optString("picture");
            break label439;
            localObject1 = ((JSONObject)localObject1).optString("picture");
            break label478;
          }
        }
      }
      else
      {
        if ((((BaseArticleInfo)localObject2).mPictures.length < 1) || (localObject2.mPictures[0] == null))
        {
          localObject1 = ((BaseArticleInfo)localObject2).mSinglePicture;
          label602:
          localLinkedList.add(mib.a((URL)localObject1, ReadInJoyDisplayUtils.a()));
          if ((((BaseArticleInfo)localObject2).mPictures.length >= 2) && (localObject2.mPictures[1] != null)) {
            break label719;
          }
          localObject1 = ((BaseArticleInfo)localObject2).mSinglePicture;
          label645:
          localLinkedList.add(mib.a((URL)localObject1, ReadInJoyDisplayUtils.a()));
          if ((((BaseArticleInfo)localObject2).mPictures.length >= 3) && (localObject2.mPictures[2] != null)) {
            break label731;
          }
        }
        label719:
        label731:
        for (localObject1 = ((BaseArticleInfo)localObject2).mSinglePicture;; localObject1 = localObject2.mPictures[2])
        {
          localLinkedList.add(mib.a((URL)localObject1, ReadInJoyDisplayUtils.a()));
          break;
          localObject1 = localObject2.mPictures[0];
          break label602;
          localObject1 = localObject2.mPictures[1];
          break label645;
        }
        label743:
        localLinkedList.add(mib.a(((BaseArticleInfo)localObject2).mSinglePicture, ReadInJoyDisplayUtils.b()));
      }
    }
    for (;;)
    {
      localLinkedList.add(mib.a(((BaseArticleInfo)localObject2).mSinglePicture, ReadInJoyDisplayUtils.a()));
      break label61;
      label787:
      if (ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter) != this.jdField_a_of_type_Long) {
        break;
      }
      localObject1 = localLinkedList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (mib)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((mib)localObject2).jdField_a_of_type_JavaNetURL != null))
        {
          localObject3 = new ImageRequest();
          ((ImageRequest)localObject3).jdField_a_of_type_JavaNetURL = ((mib)localObject2).jdField_a_of_type_JavaNetURL;
          ((ImageRequest)localObject3).jdField_a_of_type_Int = ((Integer)((mib)localObject2).jdField_a_of_type_AndroidUtilPair.first).intValue();
          ((ImageRequest)localObject3).jdField_b_of_type_Int = ((Integer)((mib)localObject2).jdField_a_of_type_AndroidUtilPair.second).intValue();
          ImageManager.a().a((ImageRequest)localObject3, null);
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyBaseAdapter", 2, "preloadImg size:" + localLinkedList.size() + " cost:" + (System.currentTimeMillis() - this.jdField_b_of_type_Long));
      return;
      label969:
      if ((k == 70) || (k == 46)) {
        break label213;
      }
      if ((k == 3) || (k == 14)) {
        break label377;
      }
      if ((k == 2) || (k == 6) || (k == 66)) {
        break label743;
      }
      if (k != 1) {
        if (k != 5) {
          break label61;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mhs
 * JD-Core Version:    0.7.0.1
 */