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
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sls
  extends slt
  implements FaceDecoder.DecodeTaskCompletionListener
{
  private FaceDecoder a;
  
  public sls(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, FaceDecoder paramFaceDecoder, SparseArray<prx> paramSparseArray)
  {
    super(paramActivity, paramLayoutInflater, paramInt, paramListView, paramSparseArray);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  public int a(int paramInt)
  {
    return pgb.a((ArticleInfo)b(paramInt), this.d);
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public BaseArticleInfo a(int paramInt)
  {
    return pkm.a().a(Integer.valueOf(this.c));
  }
  
  public BaseArticleInfo a(int paramInt, long paramLong)
  {
    return pkm.a().a(this.c, paramLong);
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
      rdl localrdl;
      if ((localBaseArticleInfo.mResolvedFeedType == 142) && (localBaseArticleInfo.multiVideoColumnInfo != null) && (localBaseArticleInfo.multiVideoColumnInfo.jdField_a_of_type_Int == paramInt1))
      {
        localrdl = localBaseArticleInfo.multiVideoColumnInfo;
        if (paramInt2 != 1) {
          break label125;
        }
      }
      label125:
      for (boolean bool = true;; bool = false)
      {
        localrdl.jdField_a_of_type_Boolean = bool;
        localBaseArticleInfo.multiVideoColumnInfo.d = paramInt3;
        if ((localBaseArticleInfo instanceof ArticleInfo)) {
          pkm.a().b((ArticleInfo)localBaseArticleInfo);
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
            if (ptk.a(paramBaseArticleInfo.mRecommendSeq))
            {
              ptk.a().a(this.c, paramBaseArticleInfo.mRecommendSeq);
              return;
            }
            paramBaseArticleInfo = pay.a();
            Iterator localIterator = paramArrayList.iterator();
            while (localIterator.hasNext())
            {
              DislikeInfo localDislikeInfo = (DislikeInfo)localIterator.next();
              if (localDislikeInfo.jdField_a_of_type_Int == 5) {
                a(localDislikeInfo.b);
              }
            }
            pkm.a().a(Long.valueOf(paramBaseArticleInfo).longValue(), ((ArticleInfo)localObject).makeDislikeParam(paramArrayList));
            pkm.a().a(this.c, (BaseArticleInfo)localObject);
          } while (paramInt != 0);
          paramBaseArticleInfo = (QQAppInterface)pay.a();
          paramArrayList = (KandianMergeManager)paramBaseArticleInfo.getManager(162);
          if (a().size() <= 0) {
            break;
          }
        } while (this.c != 0);
        paramArrayList = b(0);
      } while (paramArrayList == null);
      localObject = ugf.b(pem.a(), paramArrayList);
      ugf.a(paramBaseArticleInfo, ugf.a(paramArrayList), String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, true);
      return;
      pkm.a().a(this.c, 20, 9223372036854775807L, true);
    } while (this.c != 0);
    ugf.a(paramBaseArticleInfo, paramBaseArticleInfo.getApp().getResources().getString(2131694786), String.valueOf(NetConnInfoCenter.getServerTime()), "", true);
  }
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1)
  {
    Object localObject = pay.a();
    ArticleInfo localArticleInfo = (ArticleInfo)paramArrayList.get(0);
    if (localArticleInfo != null) {
      pkm.a().a(Long.valueOf((String)localObject).longValue(), localArticleInfo.makeDislikeParam(paramArrayList1));
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
        if (ptk.a(l)) {
          ptk.a().a(this.c, l);
        } else {
          pkm.a().a(this.c, paramArrayList1);
        }
      }
    }
    if (paramInt == 0)
    {
      paramArrayList = (QQAppInterface)pay.a();
      paramArrayList1 = (KandianMergeManager)paramArrayList.getManager(162);
      if (a().size() <= 0) {
        break label240;
      }
      if (this.c == 0)
      {
        paramArrayList1 = b(0);
        if (paramArrayList1 != null)
        {
          localObject = ugf.b(pem.a(), paramArrayList1);
          ugf.a(paramArrayList, ugf.a(paramArrayList1), String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, true);
        }
      }
    }
    label240:
    do
    {
      return;
      pkm.a().a(this.c, 20, 9223372036854775807L, true);
    } while (this.c != 0);
    ugf.a(paramArrayList, paramArrayList.getApp().getResources().getString(2131694786), String.valueOf(NetConnInfoCenter.getServerTime()), "", true);
  }
  
  public void a(sdg paramsdg, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBaseArticleInfo == null) || (paramsdg == null)) {
      return;
    }
    if (paramBoolean2) {
      this.jdField_a_of_type_Pey.a().a(paramsdg, paramBaseArticleInfo);
    }
    if (this.c != 40677)
    {
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = pay.a();
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
        rdy localrdy = new rdy();
        localrdy.jdField_a_of_type_Long = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer != null) {
          localrdy.jdField_b_of_type_Long = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long;
        }
        localrdy.jdField_a_of_type_Int = paramBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
        localrdy.jdField_b_of_type_Int = paramBaseArticleInfo.mSocialFeedInfo.d;
        Object localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localrdy.jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            rer localrer = (rer)((Iterator)localObject).next();
            if (localrer != null) {
              localrdy.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localrer.jdField_a_of_type_Long));
            }
          }
        }
        localReportInfo.mFeedsReportData = localrdy;
      }
      localArrayList.add(localReportInfo);
      pkm.a().a(localArrayList);
    }
    pkm.a().a(paramBaseArticleInfo.mArticleID, System.currentTimeMillis());
    pma.a.b(this.c, paramBaseArticleInfo);
    super.a(paramsdg, paramBaseArticleInfo, paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return pay.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return pkm.a().a(paramLong);
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      new oeb((QQAppInterface)pay.a(), paramString, this.jdField_a_of_type_AndroidAppActivity).a();
      return true;
    }
    QLog.d("Q.readinjoy.ui", 2, "unfollow fail , puin is null !");
    return false;
  }
  
  public boolean b(int paramInt, long paramLong)
  {
    return pkm.a().a(Long.valueOf(paramLong));
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
          Object localObject = (pvc)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131380831);
          soh localsoh = (soh)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131380836);
          pyq localpyq = (pyq)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131380833);
          if ((localObject != null) && (localsoh != null) && (localpyq != null)) {
            localpyq.a(localsoh, (pvc)localObject, Long.valueOf(paramString).longValue(), paramBitmap);
          }
          if ((localObject != null) && (qph.a(((pvc)localObject).a())))
          {
            localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
            if (localObject != null)
            {
              localObject = (qpk)((View)localObject).getTag();
              if (localObject == null) {}
            }
          }
          try
          {
            ((qpk)localObject).a(Long.valueOf(paramString).longValue(), paramBitmap);
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
 * Qualified Name:     sls
 * JD-Core Version:    0.7.0.1
 */