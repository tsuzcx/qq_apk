import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.util.ADNativeArticleAppDownloadManager.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.Iterator;
import java.util.List;

public class nly
  extends nlw
{
  private ListView a;
  
  public nly(Context paramContext, ListView paramListView)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
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
        if ((localqjf.jdField_a_of_type_JavaLangString != null) && (localqjf.d != null) && (localqjf.d.equals(paramDownloadInfo.e)) && (localqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null))
        {
          localqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = paramInt;
          localqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.j = paramDownloadInfo.f;
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
        if ((localqjf.jdField_a_of_type_JavaLangString != null) && (localqjf.d != null) && (localqjf.jdField_a_of_type_JavaLangString.equals(paramWadlResult.a.jdField_a_of_type_JavaLangString)) && (localqjf.d.equals(paramWadlResult.a.j)) && (localqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null))
        {
          localqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = a(paramWadlResult);
          localqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.j = paramWadlResult.d;
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
    if ((paramqjf == null) || (paramqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentWidgetListView.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
        Object localObject;
        AdData localAdData;
        if ((localView != null) && ((localView instanceof Container)))
        {
          localObject = localView.getTag(2131362034);
          if ((localObject != null) && ((localObject instanceof AdData)))
          {
            localAdData = (AdData)localObject;
            localObject = "";
          }
        }
        try
        {
          if (localAdData.a != null)
          {
            localObject = localAdData.a.c;
            localObject = localAdData.a.b;
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(paramqjf.d)))
          {
            localAdData.j = paramqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.j;
            localAdData.k = paramqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k;
            localAdData.Q = paramqjf.i;
            localObject = ((Container)localView).getVirtualView().findViewBaseByName("id_view_AdDownloadView");
            this.b.post(new ADNativeArticleAppDownloadManager.1(this, (ViewBase)localObject, paramInt1, paramInt2));
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              localException.printStackTrace();
              QLog.d("ADFeedsVideoAppDownlodManager", 1, "updateUIState exception :" + localException.toString());
            }
          }
        }
        i += 1;
      }
    }
  }
  
  protected boolean b(qjf paramqjf)
  {
    if ((paramqjf != null) && (paramqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (oal.a(paramqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (!TextUtils.isEmpty(paramqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.p))) {
      return false;
    }
    return super.b(paramqjf);
  }
  
  protected boolean c(qjf paramqjf)
  {
    if ((paramqjf != null) && (paramqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (oal.a(paramqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))) {
      return false;
    }
    return super.c(paramqjf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nly
 * JD-Core Version:    0.7.0.1
 */