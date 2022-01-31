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
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rqi
  extends rqj
  implements bcwt
{
  private bcws a;
  
  public rqi(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, bcws parambcws, SparseArray<pdc> paramSparseArray)
  {
    super(paramActivity, paramLayoutInflater, paramInt, paramListView, paramSparseArray);
    this.jdField_a_of_type_Bcws = parambcws;
    this.jdField_a_of_type_Bcws.a(this);
  }
  
  public int a(int paramInt)
  {
    return a((ArticleInfo)this.b.get(paramInt), this.d);
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public bcws a()
  {
    return this.jdField_a_of_type_Bcws;
  }
  
  public BaseArticleInfo a(int paramInt)
  {
    return owy.a().a(Integer.valueOf(this.c));
  }
  
  public BaseArticleInfo a(int paramInt, long paramLong)
  {
    return owy.a().a(this.c, paramLong);
  }
  
  public void a()
  {
    super.a();
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
            if (peo.a(paramBaseArticleInfo.mRecommendSeq))
            {
              peo.a().a(this.c, paramBaseArticleInfo.mRecommendSeq);
              return;
            }
            paramBaseArticleInfo = ors.a();
            Iterator localIterator = paramArrayList.iterator();
            while (localIterator.hasNext())
            {
              DislikeInfo localDislikeInfo = (DislikeInfo)localIterator.next();
              if (localDislikeInfo.c == 5) {
                a(localDislikeInfo.b);
              }
            }
            owy.a().a(Long.valueOf(paramBaseArticleInfo).longValue(), ((ArticleInfo)localObject).makeDislikeParam(paramArrayList));
            owy.a().a(this.c, (BaseArticleInfo)localObject);
          } while (paramInt != 0);
          paramBaseArticleInfo = (QQAppInterface)ors.a();
          paramArrayList = (KandianMergeManager)paramBaseArticleInfo.getManager(162);
          if (this.b.size() <= 0) {
            break;
          }
        } while (this.c != 0);
        paramArrayList = (BaseArticleInfo)this.b.get(0);
      } while (paramArrayList == null);
      localObject = syb.b(a(), paramArrayList);
      syb.a(paramBaseArticleInfo, syb.a(paramArrayList), String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, true);
      return;
      owy.a().a(this.c, 20, 9223372036854775807L, true);
    } while (this.c != 0);
    syb.a(paramBaseArticleInfo, paramBaseArticleInfo.getApp().getResources().getString(2131695737), String.valueOf(NetConnInfoCenter.getServerTime()), "", true);
  }
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1)
  {
    Object localObject = ors.a();
    ArticleInfo localArticleInfo = (ArticleInfo)paramArrayList.get(0);
    if (localArticleInfo != null) {
      owy.a().a(Long.valueOf((String)localObject).longValue(), localArticleInfo.makeDislikeParam(paramArrayList1));
    }
    paramArrayList1 = paramArrayList1.iterator();
    while (paramArrayList1.hasNext())
    {
      localObject = (DislikeInfo)paramArrayList1.next();
      if (((DislikeInfo)localObject).c == 5) {
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
        if (peo.a(l)) {
          peo.a().a(this.c, l);
        } else {
          owy.a().a(this.c, paramArrayList1);
        }
      }
    }
    if (paramInt == 0)
    {
      paramArrayList = (QQAppInterface)ors.a();
      paramArrayList1 = (KandianMergeManager)paramArrayList.getManager(162);
      if (this.b.size() <= 0) {
        break label248;
      }
      if (this.c == 0)
      {
        paramArrayList1 = (BaseArticleInfo)this.b.get(0);
        if (paramArrayList1 != null)
        {
          localObject = syb.b(a(), paramArrayList1);
          syb.a(paramArrayList, syb.a(paramArrayList1), String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, true);
        }
      }
    }
    label248:
    do
    {
      return;
      owy.a().a(this.c, 20, 9223372036854775807L, true);
    } while (this.c != 0);
    syb.a(paramArrayList, paramArrayList.getApp().getResources().getString(2131695737), String.valueOf(NetConnInfoCenter.getServerTime()), "", true);
  }
  
  public void a(rjk paramrjk, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBaseArticleInfo == null) || (paramrjk == null)) {
      return;
    }
    if (paramBoolean2) {
      super.b(paramrjk, paramBaseArticleInfo);
    }
    if (this.c != 40677)
    {
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = ors.a();
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
        qlv localqlv = new qlv();
        localqlv.jdField_a_of_type_Long = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme != null) {
          localqlv.jdField_b_of_type_Long = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme.jdField_a_of_type_Long;
        }
        localqlv.jdField_a_of_type_Int = paramBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
        localqlv.jdField_b_of_type_Int = paramBaseArticleInfo.mSocialFeedInfo.d;
        Object localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localqlv.jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            qme localqme = (qme)((Iterator)localObject).next();
            if (localqme != null) {
              localqlv.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localqme.jdField_a_of_type_Long));
            }
          }
        }
        localReportInfo.mFeedsReportData = localqlv;
      }
      localArrayList.add(localReportInfo);
      owy.a().a(localArrayList);
    }
    owy.a().a(paramBaseArticleInfo.mArticleID, System.currentTimeMillis());
    super.a(paramrjk, paramBaseArticleInfo, paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return ors.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return owy.a().a(paramLong);
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      new nsb((QQAppInterface)ors.a(), paramString, this.jdField_a_of_type_AndroidAppActivity).a();
      return true;
    }
    QLog.d("Q.readinjoy.ui", 2, "unfollow fail , puin is null !");
    return false;
  }
  
  public boolean b(int paramInt, long paramLong)
  {
    return owy.a().a(Long.valueOf(paramLong));
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_Bcws.a())
    {
      paramInt2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount();
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 < paramInt2)
        {
          Object localObject = (pgd)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131379913);
          rvg localrvg = (rvg)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131379918);
          piz localpiz = (piz)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131379915);
          if ((localObject != null) && (localrvg != null) && (localpiz != null)) {
            localpiz.a(localrvg, (pgd)localObject, Long.valueOf(paramString).longValue(), paramBitmap);
          }
          if ((localObject != null) && (pxi.a(((pgd)localObject).a())))
          {
            localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
            if (localObject != null)
            {
              localObject = (pxl)((View)localObject).getTag();
              if (localObject == null) {}
            }
          }
          try
          {
            ((pxl)localObject).a(Long.valueOf(paramString).longValue(), paramBitmap);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rqi
 * JD-Core Version:    0.7.0.1
 */