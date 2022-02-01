import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class szc
  extends szd
  implements FaceDecoder.DecodeTaskCompletionListener
{
  private FaceDecoder a;
  
  public szc(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, FaceDecoder paramFaceDecoder, SparseArray<qcu> paramSparseArray)
  {
    super(paramActivity, paramLayoutInflater, paramInt, paramListView, paramSparseArray);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  public int a(int paramInt)
  {
    return ppe.a((ArticleInfo)b(paramInt), this.d);
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public BaseArticleInfo a(int paramInt)
  {
    return pvj.a().a(Integer.valueOf(this.c));
  }
  
  public BaseArticleInfo a(int paramInt, long paramLong)
  {
    return pvj.a().a(this.c, paramLong);
  }
  
  public FaceDecoder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  }
  
  public void a()
  {
    super.a();
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = Math.min(a().size(), 200);
    int i = 0;
    if (i < j)
    {
      BaseArticleInfo localBaseArticleInfo = b(i);
      rpr localrpr;
      if ((localBaseArticleInfo.mResolvedFeedType == 142) && (localBaseArticleInfo.multiVideoColumnInfo != null) && (localBaseArticleInfo.multiVideoColumnInfo.jdField_a_of_type_Int == paramInt1))
      {
        localrpr = localBaseArticleInfo.multiVideoColumnInfo;
        if (paramInt2 != 1) {
          break label125;
        }
      }
      label125:
      for (boolean bool = true;; bool = false)
      {
        localrpr.jdField_a_of_type_Boolean = bool;
        localBaseArticleInfo.multiVideoColumnInfo.d = paramInt3;
        if ((localBaseArticleInfo instanceof ArticleInfo)) {
          pvj.a().b((ArticleInfo)localBaseArticleInfo);
        }
        i += 1;
        break;
      }
    }
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, ArrayList<DislikeInfo> paramArrayList)
  {
    Object localObject = (ArticleInfo)paramBaseArticleInfo;
    if (localObject == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (qeh.a(paramBaseArticleInfo.mRecommendSeq))
            {
              qeh.a().a(this.c, paramBaseArticleInfo.mRecommendSeq);
              return;
            }
            paramBaseArticleInfo = pkh.a();
            Iterator localIterator = paramArrayList.iterator();
            while (localIterator.hasNext())
            {
              DislikeInfo localDislikeInfo = (DislikeInfo)localIterator.next();
              if (localDislikeInfo.jdField_a_of_type_Int == 5) {
                a(localDislikeInfo.b);
              }
            }
            pvj.a().a(Long.valueOf(paramBaseArticleInfo).longValue(), ((ArticleInfo)localObject).makeDislikeParam(paramArrayList));
            pvj.a().a(this.c, (BaseArticleInfo)localObject);
          } while (paramInt != 0);
          paramBaseArticleInfo = (QQAppInterface)pkh.a();
          paramArrayList = (KandianMergeManager)paramBaseArticleInfo.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
          if (a().size() <= 0) {
            break;
          }
        } while (this.c != 0);
        paramArrayList = b(0);
      } while (paramArrayList == null);
      localObject = uuc.b(pnn.b(), paramArrayList);
      uuc.a(paramBaseArticleInfo, uuc.a(paramArrayList), String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, true);
      return;
      pvj.a().a(this.c, 20, 9223372036854775807L, true);
    } while (this.c != 0);
    uuc.a(paramBaseArticleInfo, paramBaseArticleInfo.getApp().getResources().getString(2131694994), String.valueOf(NetConnInfoCenter.getServerTime()), "", true);
  }
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1)
  {
    Object localObject = pkh.a();
    ArticleInfo localArticleInfo = (ArticleInfo)paramArrayList.get(0);
    if (localArticleInfo != null) {
      pvj.a().a(Long.valueOf((String)localObject).longValue(), localArticleInfo.makeDislikeParam(paramArrayList1));
    }
    paramArrayList1 = paramArrayList1.iterator();
    while (paramArrayList1.hasNext())
    {
      localObject = (DislikeInfo)paramArrayList1.next();
      if (((DislikeInfo)localObject).jdField_a_of_type_Int == 5) {
        a(((DislikeInfo)localObject).b);
      }
    }
    int i = 0;
    if (i < paramArrayList.size())
    {
      paramArrayList1 = (ArticleInfo)paramArrayList.get(i);
      if (paramArrayList1 == null) {}
      for (;;)
      {
        i += 1;
        break;
        long l = paramArrayList1.mRecommendSeq;
        if (qeh.a(l)) {
          qeh.a().a(this.c, l);
        } else {
          pvj.a().a(this.c, paramArrayList1);
        }
      }
    }
    if (paramInt == 0)
    {
      paramArrayList = (QQAppInterface)pkh.a();
      paramArrayList1 = (KandianMergeManager)paramArrayList.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (a().size() <= 0) {
        break label240;
      }
      if (this.c == 0)
      {
        paramArrayList1 = b(0);
        if (paramArrayList1 != null)
        {
          localObject = uuc.b(pnn.b(), paramArrayList1);
          uuc.a(paramArrayList, uuc.a(paramArrayList1), String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, true);
        }
      }
    }
    label240:
    do
    {
      return;
      pvj.a().a(this.c, 20, 9223372036854775807L, true);
    } while (this.c != 0);
    uuc.a(paramArrayList, paramArrayList.getApp().getResources().getString(2131694994), String.valueOf(NetConnInfoCenter.getServerTime()), "", true);
  }
  
  public void a(spk paramspk, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBaseArticleInfo == null) || (paramspk == null)) {
      return;
    }
    if (paramBoolean2) {
      this.jdField_a_of_type_Pob.a().a(paramspk, paramBaseArticleInfo);
    }
    if (this.c != 40677)
    {
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = pkh.a();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = paramBaseArticleInfo.mArticleID;
      localReportInfo.mChannelId = this.c;
      localReportInfo.mAlgorithmId = ((int)paramBaseArticleInfo.mAlgorithmID);
      localReportInfo.mStrategyId = paramBaseArticleInfo.mStrategyId;
      localReportInfo.mOperation = 1;
      localReportInfo.mServerContext = paramBaseArticleInfo.mServerContext;
      localReportInfo.mReadTimeLength = -1;
      localReportInfo.mInnerId = paramBaseArticleInfo.innerUniqueID;
      localReportInfo.videoReportInfo = paramBaseArticleInfo.videoReportInfo;
      if (paramBaseArticleInfo.mVideoColumnInfo != null) {
        localReportInfo.mColumnID = paramBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
      }
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        rqf localrqf = new rqf();
        localrqf.jdField_a_of_type_Long = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy != null) {
          localrqf.jdField_b_of_type_Long = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long;
        }
        localrqf.jdField_a_of_type_Int = paramBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
        localrqf.jdField_b_of_type_Int = paramBaseArticleInfo.mSocialFeedInfo.d;
        Object localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localrqf.jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            rqy localrqy = (rqy)((Iterator)localObject).next();
            if (localrqy != null) {
              localrqf.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localrqy.jdField_a_of_type_Long));
            }
          }
        }
        localReportInfo.mFeedsReportData = localrqf;
      }
      localArrayList.add(localReportInfo);
      pvj.a().a(localArrayList);
    }
    pvj.a().a(paramBaseArticleInfo.mArticleID, System.currentTimeMillis());
    pwx.a.b(this.c, paramBaseArticleInfo);
    super.a(paramspk, paramBaseArticleInfo, paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return pqu.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return pvj.a().a(paramLong);
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      new ols((QQAppInterface)pkh.a(), paramString, this.jdField_a_of_type_AndroidAppActivity).a();
      return true;
    }
    QLog.d("Q.readinjoy.ui", 2, "unfollow fail , puin is null !");
    return false;
  }
  
  public boolean b(int paramInt, long paramLong)
  {
    return pvj.a().a(Long.valueOf(paramLong));
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
    {
      paramInt2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount();
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 < paramInt2)
        {
          Object localObject = (qfw)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131381183);
          tbs localtbs = (tbs)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131381188);
          qkv localqkv = (qkv)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131381185);
          if ((localObject != null) && (localtbs != null) && (localqkv != null)) {
            localqkv.a(localtbs, (qfw)localObject, Long.valueOf(paramString).longValue(), paramBitmap);
          }
          if ((localObject != null) && (rbm.a(((qfw)localObject).a())))
          {
            localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
            if (localObject != null)
            {
              localObject = (rbp)((View)localObject).getTag();
              if (localObject == null) {}
            }
          }
          try
          {
            ((rbp)localObject).a(Long.valueOf(paramString).longValue(), paramBitmap);
            paramInt1 += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     szc
 * JD-Core Version:    0.7.0.1
 */