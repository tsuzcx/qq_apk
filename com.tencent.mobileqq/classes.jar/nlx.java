import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.util.ADFeedsVideoAppDownlodManager.1;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class nlx
  extends nlw
{
  private ListView a;
  
  public nlx(Context paramContext, boolean paramBoolean, ReadInJoyListViewGroup paramReadInJoyListViewGroup, rap paramrap)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentWidgetListView = paramReadInJoyListViewGroup.a();
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
        if ((localqjf.d != null) && (localqjf.d.equals(paramDownloadInfo.e)) && (localqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null))
        {
          localqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = paramInt;
          localqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress = paramDownloadInfo.f;
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
        if ((localqjf.d != null) && (localqjf.jdField_a_of_type_JavaLangString.equals(paramWadlResult.a.jdField_a_of_type_JavaLangString)) && (localqjf.d.equals(paramWadlResult.a.j)) && (localqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null))
        {
          localqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = paramInt;
          localqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress = paramWadlResult.d;
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
    if ((paramqjf == null) || (paramqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null)) {}
    label297:
    label347:
    for (;;)
    {
      return;
      int i = 0;
      for (;;)
      {
        if (i >= this.jdField_a_of_type_ComTencentWidgetListView.getChildCount()) {
          break label347;
        }
        View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
        Object localObject = localView.getTag(2131379208);
        if ((localObject != null) && ((localObject instanceof pbi)) && (((pbi)localObject).a() != null) && ((((pbi)localObject).a() instanceof AdvertisementInfo)))
        {
          AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)((pbi)localObject).a();
          String str = "";
          localObject = "";
          for (;;)
          {
            try
            {
              if (oau.a(localAdvertisementInfo) != 2) {
                break label297;
              }
              str = new JSONObject(localAdvertisementInfo.mAdExtInfo).optString("game_app_id");
              localObject = oau.b(localAdvertisementInfo);
              if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject)) || (!str.equals(paramqjf.jdField_a_of_type_JavaLangString)) || (!((String)localObject).equals(paramqjf.d)) || (!(localView instanceof ProteusItemView))) {
                break;
              }
              localAdvertisementInfo.progress = paramqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress;
              localAdvertisementInfo.downloadState = paramqjf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState;
              paramqjf = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_view_AdDownloadView");
              this.b.post(new ADFeedsVideoAppDownlodManager.1(this, paramqjf, paramInt1, paramInt2));
              return;
            }
            catch (JSONException paramqjf) {}
            if (!QLog.isColorLevel()) {
              break;
            }
            paramqjf.printStackTrace();
            QLog.d("ADFeedsVideoAppDownlodManager", 1, "updateUIState exception :" + paramqjf.toString());
            return;
            if (localAdvertisementInfo.mAdExt != null)
            {
              localObject = new JSONObject(localAdvertisementInfo.mAdExt);
              str = ((JSONObject)localObject).optString("appid");
              localObject = ((JSONObject)localObject).optString("pkg_name");
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlx
 * JD-Core Version:    0.7.0.1
 */