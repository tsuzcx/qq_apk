import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.NativeAd.util.ADVideoFeedsVideoAppDownlodManager.1;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.Iterator;
import java.util.List;

public class nos
  extends nop
{
  private VideoFeedsRecyclerView a;
  
  public nos(Context paramContext, boolean paramBoolean, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
  }
  
  protected void a()
  {
    super.a();
    Object localObject = bkel.a().a();
    if ((localObject == null) || (((List)localObject).isEmpty())) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bked localbked = (bked)((Iterator)localObject).next();
        if ((localbked instanceof nos)) {
          bkel.a().b(localbked);
        }
      }
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    super.a(paramDownloadInfo, paramInt);
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        qyj localqyj = (qyj)localIterator.next();
        if ((localqyj.d != null) && (localqyj.d.equals(paramDownloadInfo.e)) && (localqyj.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null))
        {
          localqyj.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.b = paramInt;
          localqyj.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c = paramDownloadInfo.f;
          a(localqyj, paramInt, paramDownloadInfo.f);
        }
      }
      return;
    }
    catch (Exception paramDownloadInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ADFeedsVideoAppDownlodManager", 2, "notifyState error " + paramDownloadInfo.getMessage());
    }
  }
  
  public void a(WadlResult paramWadlResult, int paramInt)
  {
    super.a(paramWadlResult, paramInt);
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        qyj localqyj = (qyj)localIterator.next();
        if ((localqyj.d != null) && (localqyj.jdField_a_of_type_JavaLangString.equals(paramWadlResult.a.jdField_a_of_type_JavaLangString)) && (localqyj.d.equals(paramWadlResult.a.j)) && (localqyj.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null))
        {
          localqyj.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.b = a(paramWadlResult);
          localqyj.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c = paramWadlResult.d;
          if (!TextUtils.isEmpty(paramWadlResult.b)) {
            localqyj.i = paramWadlResult.b;
          }
          a(localqyj, paramInt, paramWadlResult.d);
        }
      }
      return;
    }
    catch (Exception paramWadlResult)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ADFeedsVideoAppDownlodManager", 2, "notifyState error " + paramWadlResult.getMessage());
    }
  }
  
  public void a(qyj paramqyj, int paramInt1, int paramInt2)
  {
    super.a(paramqyj, paramInt1, paramInt2);
    if ((paramqyj == null) || (paramqyj.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData == null)) {
      return;
    }
    Object localObject = (LinearLayoutManager)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getLayoutManager();
    int j = ((LinearLayoutManager)localObject).findLastVisibleItemPosition();
    int i = ((LinearLayoutManager)localObject).findFirstVisibleItemPosition();
    label45:
    if (i < j + 1)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getLayoutManager().findViewByPosition(i);
      if (localObject != null) {
        break label82;
      }
    }
    label82:
    do
    {
      do
      {
        do
        {
          i += 1;
          break label45;
          break;
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildViewHolder((View)localObject);
        } while (!(localObject instanceof rbt));
        localObject = (rbt)localObject;
      } while ((((rbt)localObject).r == null) || (((rbt)localObject).r.getVisibility() != 0));
      localObject = (VideoInfo.GameAdComData)((rbt)localObject).r.getTag(2131379913);
    } while ((localObject == null) || (!"2".equals(((VideoInfo.GameAdComData)localObject).r)) || (!paramqyj.d.equals(((VideoInfo.GameAdComData)localObject).d)));
    ((VideoInfo.GameAdComData)localObject).c = paramqyj.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c;
    ((VideoInfo.GameAdComData)localObject).b = paramqyj.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.b;
    paramqyj = ((raw)((biau)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getAdapter()).a()).a();
    this.b.post(new ADVideoFeedsVideoAppDownlodManager.1(this, paramqyj, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nos
 * JD-Core Version:    0.7.0.1
 */