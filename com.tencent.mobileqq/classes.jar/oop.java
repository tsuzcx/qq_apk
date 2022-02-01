import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.data.AdDislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class oop
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bkly jdField_a_of_type_Bkly;
  private shz jdField_a_of_type_Shz;
  
  public oop(Activity paramActivity, shz paramshz)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Shz = paramshz;
    this.jdField_a_of_type_Bkly = new bkly(paramActivity);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bkly != null) && (this.jdField_a_of_type_Bkly.isShowing())) {
      this.jdField_a_of_type_Bkly.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt, VideoInfo paramVideoInfo)
  {
    oor localoor = new oor(this, paramInt, paramVideoInfo);
    if (!this.jdField_a_of_type_Bkly.a()) {
      this.jdField_a_of_type_Bkly.a();
    }
    this.jdField_a_of_type_Bkly.b = false;
    ArrayList localArrayList = new ArrayList();
    if ((paramVideoInfo.a != null) && (paramVideoInfo.a.e != null))
    {
      int i = 0;
      while (i < paramVideoInfo.a.e.size())
      {
        DislikeInfo localDislikeInfo = new DislikeInfo();
        localDislikeInfo.jdField_a_of_type_Long = ((VideoAdInfo.NegFeedback)paramVideoInfo.a.e.get(i)).jdField_a_of_type_Long;
        localDislikeInfo.jdField_a_of_type_JavaLangString = ((VideoAdInfo.NegFeedback)paramVideoInfo.a.e.get(i)).jdField_a_of_type_JavaLangString;
        localArrayList.add(localDislikeInfo);
        i += 1;
      }
    }
    if (localArrayList.size() > 0)
    {
      nxw.a(paramVideoInfo.a);
      if (this.jdField_a_of_type_Bkly.a(paramInt, localArrayList)) {
        this.jdField_a_of_type_Bkly.a(paramView, localoor);
      }
    }
  }
  
  public void a(View paramView, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramView == null) || (paramAdvertisementInfo == null) || (paramAdvertisementInfo.mAdDislikeInfos == null) || (paramAdvertisementInfo.mAdDislikeInfos.size() == 0)) {}
    ooq localooq;
    ArrayList localArrayList;
    do
    {
      return;
      localooq = new ooq(this, paramAdvertisementInfo);
      if (!this.jdField_a_of_type_Bkly.a()) {
        this.jdField_a_of_type_Bkly.a();
      }
      this.jdField_a_of_type_Bkly.b = false;
      localArrayList = new ArrayList();
      paramAdvertisementInfo = paramAdvertisementInfo.mAdDislikeInfos.iterator();
      while (paramAdvertisementInfo.hasNext())
      {
        AdDislikeInfo localAdDislikeInfo = (AdDislikeInfo)paramAdvertisementInfo.next();
        DislikeInfo localDislikeInfo = new DislikeInfo();
        localDislikeInfo.jdField_a_of_type_ArrayOfByte = localAdDislikeInfo.jdField_a_of_type_ArrayOfByte;
        localDislikeInfo.c = localAdDislikeInfo.c;
        localDislikeInfo.jdField_a_of_type_Long = localAdDislikeInfo.jdField_a_of_type_Long;
        localDislikeInfo.b = localAdDislikeInfo.b;
        localDislikeInfo.jdField_a_of_type_JavaLangString = localAdDislikeInfo.jdField_a_of_type_JavaLangString;
        localArrayList.add(localDislikeInfo);
      }
    } while ((localArrayList.size() <= 0) || (!this.jdField_a_of_type_Bkly.a(0, localArrayList)));
    this.jdField_a_of_type_Bkly.a(paramView, localooq);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bkly != null) && (this.jdField_a_of_type_Bkly.isShowing())) {
      this.jdField_a_of_type_Bkly.dismiss();
    }
    this.jdField_a_of_type_Bkly = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oop
 * JD-Core Version:    0.7.0.1
 */