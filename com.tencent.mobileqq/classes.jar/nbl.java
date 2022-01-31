import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.NativeAd.util.VideoFeedsSoftAdDownloadManager.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.Iterator;
import java.util.List;

public class nbl
  extends nav
{
  private VideoFeedsRecyclerView a;
  
  public nbl(Context paramContext, boolean paramBoolean, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
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
        if ((localpxh.d != null) && (localpxh.d.equals(paramDownloadInfo.e)))
        {
          localpxh.jdField_a_of_type_Int = paramInt;
          localpxh.jdField_a_of_type_Int = paramDownloadInfo.f;
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
        if ((localpxh.d != null) && (localpxh.jdField_a_of_type_JavaLangString.equals(paramWadlResult.a.jdField_a_of_type_JavaLangString)) && (localpxh.d.equals(paramWadlResult.a.j)))
        {
          localpxh.jdField_a_of_type_Int = a(paramWadlResult);
          localpxh.b = paramWadlResult.d;
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
    if (parampxh == null) {
      return;
    }
    Object localObject = (LinearLayoutManager)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getLayoutManager();
    int j = ((LinearLayoutManager)localObject).findLastVisibleItemPosition();
    int i = ((LinearLayoutManager)localObject).findFirstVisibleItemPosition();
    label38:
    if (i < j + 1)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getLayoutManager().findViewByPosition(i);
      if (localObject != null) {
        break label75;
      }
    }
    label75:
    do
    {
      do
      {
        do
        {
          i += 1;
          break label38;
          break;
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildViewHolder((View)localObject);
        } while (!(localObject instanceof qaq));
        localObject = (qaq)localObject;
      } while ((((qaq)localObject).u == null) || (((qaq)localObject).u.getVisibility() != 0));
      localObject = (nmx)((qaq)localObject).u.getTag(2131313373);
    } while ((localObject == null) || (!parampxh.d.equals(((nmx)localObject).n)));
    parampxh = ((pzs)((berm)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getAdapter()).a()).a();
    this.b.post(new VideoFeedsSoftAdDownloadManager.1(this, parampxh, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbl
 * JD-Core Version:    0.7.0.1
 */