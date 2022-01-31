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

public class nay
  extends nav
{
  private VideoFeedsRecyclerView a;
  
  public nay(Context paramContext, boolean paramBoolean, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
  }
  
  protected void a()
  {
    super.a();
    Object localObject = bgsw.a().a();
    if ((localObject == null) || (((List)localObject).isEmpty())) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bgso localbgso = (bgso)((Iterator)localObject).next();
        if ((localbgso instanceof nay)) {
          bgsw.a().b(localbgso);
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
        pxh localpxh = (pxh)localIterator.next();
        if ((localpxh.d != null) && (localpxh.d.equals(paramDownloadInfo.e)) && (localpxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null))
        {
          localpxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.b = paramInt;
          localpxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c = paramDownloadInfo.f;
          a(localpxh, paramInt, paramDownloadInfo.f);
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
        pxh localpxh = (pxh)localIterator.next();
        if ((localpxh.d != null) && (localpxh.jdField_a_of_type_JavaLangString.equals(paramWadlResult.a.jdField_a_of_type_JavaLangString)) && (localpxh.d.equals(paramWadlResult.a.j)) && (localpxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null))
        {
          localpxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.b = a(paramWadlResult);
          localpxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c = paramWadlResult.d;
          if (!TextUtils.isEmpty(paramWadlResult.b)) {
            localpxh.i = paramWadlResult.b;
          }
          a(localpxh, paramInt, paramWadlResult.d);
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
  
  public void a(pxh parampxh, int paramInt1, int paramInt2)
  {
    super.a(parampxh, paramInt1, paramInt2);
    if ((parampxh == null) || (parampxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData == null)) {
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
        } while (!(localObject instanceof qaq));
        localObject = (qaq)localObject;
      } while ((((qaq)localObject).s == null) || (((qaq)localObject).s.getVisibility() != 0));
      localObject = (VideoInfo.GameAdComData)((qaq)localObject).s.getTag(2131313373);
    } while ((localObject == null) || (!"2".equals(((VideoInfo.GameAdComData)localObject).r)) || (!parampxh.d.equals(((VideoInfo.GameAdComData)localObject).d)));
    ((VideoInfo.GameAdComData)localObject).c = parampxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c;
    ((VideoInfo.GameAdComData)localObject).b = parampxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.b;
    parampxh = ((pzs)((berm)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getAdapter()).a()).a();
    this.b.post(new ADVideoFeedsVideoAppDownlodManager.1(this, parampxh, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nay
 * JD-Core Version:    0.7.0.1
 */