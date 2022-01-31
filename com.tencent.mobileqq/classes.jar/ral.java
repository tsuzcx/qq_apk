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

public class ral
  extends ram
  implements baxz
{
  private baxy a;
  
  public ral(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, baxy parambaxy, SparseArray<oxx> paramSparseArray)
  {
    super(paramActivity, paramLayoutInflater, paramInt, paramListView, paramSparseArray);
    this.jdField_a_of_type_Baxy = parambaxy;
    this.jdField_a_of_type_Baxy.a(this);
  }
  
  public int a(int paramInt)
  {
    return a((ArticleInfo)this.b.get(paramInt), this.d);
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public baxy a()
  {
    return this.jdField_a_of_type_Baxy;
  }
  
  public BaseArticleInfo a(int paramInt)
  {
    return osg.a().a(Integer.valueOf(this.c));
  }
  
  public BaseArticleInfo a(int paramInt, long paramLong)
  {
    return osg.a().a(this.c, paramLong);
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
            if (ozg.a(paramBaseArticleInfo.mRecommendSeq))
            {
              ozg.a().a(this.c, paramBaseArticleInfo.mRecommendSeq);
              return;
            }
            paramBaseArticleInfo = onh.a();
            Iterator localIterator = paramArrayList.iterator();
            while (localIterator.hasNext())
            {
              DislikeInfo localDislikeInfo = (DislikeInfo)localIterator.next();
              if (localDislikeInfo.c == 5) {
                a(localDislikeInfo.b);
              }
            }
            osg.a().a(Long.valueOf(paramBaseArticleInfo).longValue(), ((ArticleInfo)localObject).makeDislikeParam(paramArrayList));
            osg.a().a(this.c, (BaseArticleInfo)localObject);
          } while (paramInt != 0);
          paramBaseArticleInfo = (QQAppInterface)onh.a();
          paramArrayList = (KandianMergeManager)paramBaseArticleInfo.getManager(162);
          if (this.b.size() <= 0) {
            break;
          }
        } while (this.c != 0);
        paramArrayList = (BaseArticleInfo)this.b.get(0);
      } while (paramArrayList == null);
      localObject = sgg.b(a(), paramArrayList);
      sgg.a(paramBaseArticleInfo, sgg.a(paramArrayList), String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, true);
      return;
      osg.a().a(this.c, 20, 9223372036854775807L, true);
    } while (this.c != 0);
    sgg.a(paramBaseArticleInfo, paramBaseArticleInfo.getApp().getResources().getString(2131695579), String.valueOf(NetConnInfoCenter.getServerTime()), "", true);
  }
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1)
  {
    Object localObject = onh.a();
    ArticleInfo localArticleInfo = (ArticleInfo)paramArrayList.get(0);
    if (localArticleInfo != null) {
      osg.a().a(Long.valueOf((String)localObject).longValue(), localArticleInfo.makeDislikeParam(paramArrayList1));
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
        if (ozg.a(l)) {
          ozg.a().a(this.c, l);
        } else {
          osg.a().a(this.c, paramArrayList1);
        }
      }
    }
    if (paramInt == 0)
    {
      paramArrayList = (QQAppInterface)onh.a();
      paramArrayList1 = (KandianMergeManager)paramArrayList.getManager(162);
      if (this.b.size() <= 0) {
        break label248;
      }
      if (this.c == 0)
      {
        paramArrayList1 = (BaseArticleInfo)this.b.get(0);
        if (paramArrayList1 != null)
        {
          localObject = sgg.b(a(), paramArrayList1);
          sgg.a(paramArrayList, sgg.a(paramArrayList1), String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, true);
        }
      }
    }
    label248:
    do
    {
      return;
      osg.a().a(this.c, 20, 9223372036854775807L, true);
    } while (this.c != 0);
    sgg.a(paramArrayList, paramArrayList.getApp().getResources().getString(2131695579), String.valueOf(NetConnInfoCenter.getServerTime()), "", true);
  }
  
  public void a(qtv paramqtv, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBaseArticleInfo == null) || (paramqtv == null)) {
      return;
    }
    if (paramBoolean2) {
      super.b(paramqtv, paramBaseArticleInfo);
    }
    if (this.c != 40677)
    {
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = onh.a();
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
        qbz localqbz = new qbz();
        localqbz.jdField_a_of_type_Long = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci != null) {
          localqbz.jdField_b_of_type_Long = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long;
        }
        localqbz.jdField_a_of_type_Int = paramBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
        localqbz.jdField_b_of_type_Int = paramBaseArticleInfo.mSocialFeedInfo.d;
        Object localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localqbz.jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            qci localqci = (qci)((Iterator)localObject).next();
            if (localqci != null) {
              localqbz.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localqci.jdField_a_of_type_Long));
            }
          }
        }
        localReportInfo.mFeedsReportData = localqbz;
      }
      localArrayList.add(localReportInfo);
      osg.a().a(localArrayList);
    }
    osg.a().a(paramBaseArticleInfo.mArticleID, System.currentTimeMillis());
    super.a(paramqtv, paramBaseArticleInfo, paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return onh.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return osg.a().a(paramLong);
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      new not((QQAppInterface)onh.a(), paramString, this.jdField_a_of_type_AndroidAppActivity).a();
      return true;
    }
    QLog.d("Q.readinjoy.ui", 2, "unfollow fail , puin is null !");
    return false;
  }
  
  public boolean b(int paramInt, long paramLong)
  {
    return osg.a().a(Long.valueOf(paramLong));
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_Baxy.a())
    {
      paramInt2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount();
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 < paramInt2)
        {
          Object localObject = (pau)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131379213);
          rfk localrfk = (rfk)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131379218);
          pcx localpcx = (pcx)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131379215);
          if ((localObject != null) && (localrfk != null) && (localpcx != null)) {
            localpcx.a(localrfk, (pau)localObject, Long.valueOf(paramString).longValue(), paramBitmap);
          }
          if ((localObject != null) && (pqn.a(((pau)localObject).a())))
          {
            localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
            if (localObject != null)
            {
              localObject = (pqq)((View)localObject).getTag();
              if (localObject == null) {}
            }
          }
          try
          {
            ((pqq)localObject).a(Long.valueOf(paramString).longValue(), paramBitmap);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ral
 * JD-Core Version:    0.7.0.1
 */