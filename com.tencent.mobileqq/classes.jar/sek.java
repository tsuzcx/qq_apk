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

public class sek
  extends sel
  implements aoog
{
  private aoof a;
  
  public sek(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, aoof paramaoof, SparseArray<pmk> paramSparseArray)
  {
    super(paramActivity, paramLayoutInflater, paramInt, paramListView, paramSparseArray);
    this.jdField_a_of_type_Aoof = paramaoof;
    this.jdField_a_of_type_Aoof.a(this);
  }
  
  public int a(int paramInt)
  {
    return a((ArticleInfo)this.b.get(paramInt), this.d);
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public aoof a()
  {
    return this.jdField_a_of_type_Aoof;
  }
  
  public BaseArticleInfo a(int paramInt)
  {
    return pfa.a().a(Integer.valueOf(this.c));
  }
  
  public BaseArticleInfo a(int paramInt, long paramLong)
  {
    return pfa.a().a(this.c, paramLong);
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
            if (poc.a(paramBaseArticleInfo.mRecommendSeq))
            {
              poc.a().a(this.c, paramBaseArticleInfo.mRecommendSeq);
              return;
            }
            paramBaseArticleInfo = ozs.a();
            Iterator localIterator = paramArrayList.iterator();
            while (localIterator.hasNext())
            {
              DislikeInfo localDislikeInfo = (DislikeInfo)localIterator.next();
              if (localDislikeInfo.jdField_a_of_type_Int == 5) {
                a(localDislikeInfo.b);
              }
            }
            pfa.a().a(Long.valueOf(paramBaseArticleInfo).longValue(), ((ArticleInfo)localObject).makeDislikeParam(paramArrayList));
            pfa.a().a(this.c, (BaseArticleInfo)localObject);
          } while (paramInt != 0);
          paramBaseArticleInfo = (QQAppInterface)ozs.a();
          paramArrayList = (KandianMergeManager)paramBaseArticleInfo.getManager(162);
          if (this.b.size() <= 0) {
            break;
          }
        } while (this.c != 0);
        paramArrayList = (BaseArticleInfo)this.b.get(0);
      } while (paramArrayList == null);
      localObject = tzq.b(a(), paramArrayList);
      tzq.a(paramBaseArticleInfo, tzq.a(paramArrayList), String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, true);
      return;
      pfa.a().a(this.c, 20, 9223372036854775807L, true);
    } while (this.c != 0);
    tzq.a(paramBaseArticleInfo, paramBaseArticleInfo.getApp().getResources().getString(2131694670), String.valueOf(NetConnInfoCenter.getServerTime()), "", true);
  }
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1)
  {
    Object localObject = ozs.a();
    ArticleInfo localArticleInfo = (ArticleInfo)paramArrayList.get(0);
    if (localArticleInfo != null) {
      pfa.a().a(Long.valueOf((String)localObject).longValue(), localArticleInfo.makeDislikeParam(paramArrayList1));
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
        if (poc.a(l)) {
          poc.a().a(this.c, l);
        } else {
          pfa.a().a(this.c, paramArrayList1);
        }
      }
    }
    if (paramInt == 0)
    {
      paramArrayList = (QQAppInterface)ozs.a();
      paramArrayList1 = (KandianMergeManager)paramArrayList.getManager(162);
      if (this.b.size() <= 0) {
        break label248;
      }
      if (this.c == 0)
      {
        paramArrayList1 = (BaseArticleInfo)this.b.get(0);
        if (paramArrayList1 != null)
        {
          localObject = tzq.b(a(), paramArrayList1);
          tzq.a(paramArrayList, tzq.a(paramArrayList1), String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, true);
        }
      }
    }
    label248:
    do
    {
      return;
      pfa.a().a(this.c, 20, 9223372036854775807L, true);
    } while (this.c != 0);
    tzq.a(paramArrayList, paramArrayList.getApp().getResources().getString(2131694670), String.valueOf(NetConnInfoCenter.getServerTime()), "", true);
  }
  
  public void a(rwc paramrwc, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBaseArticleInfo == null) || (paramrwc == null)) {
      return;
    }
    if (paramBoolean2) {
      super.b(paramrwc, paramBaseArticleInfo);
    }
    if (this.c != 40677)
    {
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = ozs.a();
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
        qxa localqxa = new qxa();
        localqxa.jdField_a_of_type_Long = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt != null) {
          localqxa.jdField_b_of_type_Long = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt.jdField_a_of_type_Long;
        }
        localqxa.jdField_a_of_type_Int = paramBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
        localqxa.jdField_b_of_type_Int = paramBaseArticleInfo.mSocialFeedInfo.d;
        Object localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localqxa.jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            qxt localqxt = (qxt)((Iterator)localObject).next();
            if (localqxt != null) {
              localqxa.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localqxt.jdField_a_of_type_Long));
            }
          }
        }
        localReportInfo.mFeedsReportData = localqxa;
      }
      localArrayList.add(localReportInfo);
      pfa.a().a(localArrayList);
    }
    pfa.a().a(paramBaseArticleInfo.mArticleID, System.currentTimeMillis());
    pgo.a.b(this.c, paramBaseArticleInfo);
    super.a(paramrwc, paramBaseArticleInfo, paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return ozs.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return pfa.a().a(paramLong);
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      new oco((QQAppInterface)ozs.a(), paramString, this.jdField_a_of_type_AndroidAppActivity).a();
      return true;
    }
    QLog.d("Q.readinjoy.ui", 2, "unfollow fail , puin is null !");
    return false;
  }
  
  void b(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = Math.min(this.b.size(), 200);
    int i = 0;
    if (i < j)
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)this.b.get(i);
      qwn localqwn;
      if ((localBaseArticleInfo.mResolvedFeedType == 142) && (localBaseArticleInfo.multiVideoColumnInfo != null) && (localBaseArticleInfo.multiVideoColumnInfo.jdField_a_of_type_Int == paramInt1))
      {
        localqwn = localBaseArticleInfo.multiVideoColumnInfo;
        if (paramInt2 != 1) {
          break label133;
        }
      }
      label133:
      for (boolean bool = true;; bool = false)
      {
        localqwn.jdField_a_of_type_Boolean = bool;
        localBaseArticleInfo.multiVideoColumnInfo.d = paramInt3;
        if ((localBaseArticleInfo instanceof ArticleInfo)) {
          pfa.a().b((ArticleInfo)localBaseArticleInfo);
        }
        i += 1;
        break;
      }
    }
  }
  
  public boolean b(int paramInt, long paramLong)
  {
    return pfa.a().a(Long.valueOf(paramLong));
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_Aoof.a())
    {
      paramInt2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount();
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 < paramInt2)
        {
          Object localObject = (ppu)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131381109);
          skg localskg = (skg)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131381115);
          psw localpsw = (psw)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131381111);
          if ((localObject != null) && (localskg != null) && (localpsw != null)) {
            localpsw.a(localskg, (ppu)localObject, Long.valueOf(paramString).longValue(), paramBitmap);
          }
          if ((localObject != null) && (qje.a(((ppu)localObject).a())))
          {
            localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
            if (localObject != null)
            {
              localObject = (qjh)((View)localObject).getTag();
              if (localObject == null) {}
            }
          }
          try
          {
            ((qjh)localObject).a(Long.valueOf(paramString).longValue(), paramBitmap);
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
 * Qualified Name:     sek
 * JD-Core Version:    0.7.0.1
 */