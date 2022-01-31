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

public class npf
  extends nop
{
  private VideoFeedsRecyclerView a;
  
  public npf(Context paramContext, boolean paramBoolean, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
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
        qyj localqyj = (qyj)localIterator.next();
        if ((localqyj.d != null) && (localqyj.d.equals(paramDownloadInfo.e)))
        {
          localqyj.jdField_a_of_type_Int = paramInt;
          localqyj.jdField_a_of_type_Int = paramDownloadInfo.f;
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
        if ((localqyj.d != null) && (localqyj.jdField_a_of_type_JavaLangString.equals(paramWadlResult.a.jdField_a_of_type_JavaLangString)) && (localqyj.d.equals(paramWadlResult.a.j)))
        {
          localqyj.jdField_a_of_type_Int = a(paramWadlResult);
          localqyj.b = paramWadlResult.d;
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
    if (paramqyj == null) {
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
        } while (!(localObject instanceof rbt));
        localObject = (rbt)localObject;
      } while ((((rbt)localObject).u == null) || (((rbt)localObject).u.getVisibility() != 0));
      localObject = (obm)((rbt)localObject).u.getTag(2131379913);
    } while ((localObject == null) || (!paramqyj.d.equals(((obm)localObject).n)));
    paramqyj = ((raw)((biau)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getAdapter()).a()).a();
    this.b.post(new VideoFeedsSoftAdDownloadManager.1(this, paramqyj, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     npf
 * JD-Core Version:    0.7.0.1
 */