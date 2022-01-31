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

public class nmm
  extends nlw
{
  private VideoFeedsRecyclerView a;
  
  public nmm(Context paramContext, boolean paramBoolean, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
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
        qjf localqjf = (qjf)localIterator.next();
        if ((localqjf.d != null) && (localqjf.d.equals(paramDownloadInfo.e)))
        {
          localqjf.jdField_a_of_type_Int = paramInt;
          localqjf.jdField_a_of_type_Int = paramDownloadInfo.f;
          a(localqjf, paramInt, paramDownloadInfo.f);
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
        qjf localqjf = (qjf)localIterator.next();
        if ((localqjf.d != null) && (localqjf.jdField_a_of_type_JavaLangString.equals(paramWadlResult.a.jdField_a_of_type_JavaLangString)) && (localqjf.d.equals(paramWadlResult.a.j)))
        {
          localqjf.jdField_a_of_type_Int = a(paramWadlResult);
          localqjf.b = paramWadlResult.d;
          if (!TextUtils.isEmpty(paramWadlResult.b)) {
            localqjf.i = paramWadlResult.b;
          }
          a(localqjf, paramInt, paramWadlResult.d);
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
  
  public void a(qjf paramqjf, int paramInt1, int paramInt2)
  {
    super.a(paramqjf, paramInt1, paramInt2);
    if (paramqjf == null) {
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
        } while (!(localObject instanceof qms));
        localObject = (qms)localObject;
      } while ((((qms)localObject).t == null) || (((qms)localObject).t.getVisibility() != 0));
      localObject = (nyi)((qms)localObject).t.getTag(2131379208);
    } while ((localObject == null) || (!paramqjf.d.equals(((nyi)localObject).n)));
    paramqjf = ((qls)((bfzg)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getAdapter()).a()).a();
    this.b.post(new VideoFeedsSoftAdDownloadManager.1(this, paramqjf, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nmm
 * JD-Core Version:    0.7.0.1
 */