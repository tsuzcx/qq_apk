import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.util.ADNativeArticleAppDownloadManager.1;
import com.tencent.biz.pubaccount.NativeAd.util.ADNativeArticleAppDownloadManager.2;
import com.tencent.biz.pubaccount.readinjoy.ad.soft_ad.ReadInJoyCommonSoftAdBar;
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

public class nor
  extends nop
{
  private ReadInJoyCommonSoftAdBar jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdSoft_adReadInJoyCommonSoftAdBar;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  
  public nor(Context paramContext, ListView paramListView, ReadInJoyCommonSoftAdBar paramReadInJoyCommonSoftAdBar)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdSoft_adReadInJoyCommonSoftAdBar = paramReadInJoyCommonSoftAdBar;
  }
  
  public ogy a(qyj paramqyj)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView == null) || (paramqyj == null)) {
      return null;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentWidgetListView.getChildCount())
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
      if ((localView != null) && ((localView instanceof Container)))
      {
        Object localObject = localView.getTag(2131362036);
        if ((localObject != null) && ((localObject instanceof AdData)))
        {
          AdData localAdData = (AdData)localObject;
          localObject = "";
          try
          {
            if (localAdData.a != null)
            {
              localObject = localAdData.a.c;
              localObject = localAdData.a.b;
            }
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(paramqyj.d)))
            {
              localAdData.j = paramqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.j;
              localAdData.k = paramqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k;
              localAdData.Q = paramqyj.i;
              localObject = ((Container)localView).getVirtualView().findViewBaseByName("id_view_AdDownloadView");
              if ((localObject instanceof ogy))
              {
                localObject = (ogy)localObject;
                return localObject;
              }
            }
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel())
            {
              localException.printStackTrace();
              QLog.d("ADFeedsVideoAppDownlodManager", 1, "updateUIState exception :" + localException.toString());
            }
          }
        }
      }
      i += 1;
    }
    return null;
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
        if ((localqyj.jdField_a_of_type_JavaLangString != null) && (localqyj.d != null) && (localqyj.d.equals(paramDownloadInfo.e)) && (localqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null))
        {
          localqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = paramInt;
          localqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.j = paramDownloadInfo.f;
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
        if ((localqyj.jdField_a_of_type_JavaLangString != null) && (localqyj.d != null) && (localqyj.jdField_a_of_type_JavaLangString.equals(paramWadlResult.a.jdField_a_of_type_JavaLangString)) && (localqyj.d.equals(paramWadlResult.a.j)) && (localqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null))
        {
          localqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = a(paramWadlResult);
          localqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.j = paramWadlResult.d;
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
    if ((paramqyj == null) || (paramqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null)) {}
    do
    {
      return;
      ogy localogy = a(paramqyj);
      if (localogy != null) {
        this.b.post(new ADNativeArticleAppDownloadManager.1(this, localogy, paramInt1, paramInt2));
      }
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdSoft_adReadInJoyCommonSoftAdBar == null) || (!paramqyj.d.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdSoft_adReadInJoyCommonSoftAdBar.a.d)));
    this.b.post(new ADNativeArticleAppDownloadManager.2(this, paramInt1, paramInt2));
  }
  
  protected boolean b(qyj paramqyj)
  {
    if ((paramqyj != null) && (paramqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (odv.a(paramqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (!TextUtils.isEmpty(paramqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.p))) {
      return false;
    }
    return super.b(paramqyj);
  }
  
  protected boolean c(qyj paramqyj)
  {
    if ((paramqyj != null) && (paramqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (odv.a(paramqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))) {
      return false;
    }
    return super.c(paramqyj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nor
 * JD-Core Version:    0.7.0.1
 */