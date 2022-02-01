import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment.DynamicGridViewAdapter.1;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyStaticGridView;
import com.tencent.mobileqq.widget.AutoFitTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public class pya
  extends tpg<TabChannelCoverInfo>
  implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, tpm, tpn
{
  public int a;
  private int[] a;
  private int c = -1;
  private int d;
  
  public pya(ReadInJoyChannelPanelFragment paramReadInJoyChannelPanelFragment, Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1);
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    this.d = paramInt2;
    d();
  }
  
  private void a(int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "deleteChannelItem, position = ", Integer.valueOf(paramInt), ", tabChannelCoverInfo = ", paramTabChannelCoverInfo.shortLogString() });
    if (paramInt < this.jdField_a_of_type_Int) {
      QLog.d("ReadInJoyChannelPanelFragment", 2, new Object[] { "can not delete item, position = ", Integer.valueOf(paramInt), ", lockCount = ", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    do
    {
      return;
      ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, paramTabChannelCoverInfo);
      try
      {
        ReadInJoyChannelPanelFragment.a("0X800949C", new pqg().b().a(paramTabChannelCoverInfo.mChannelCoverId).m(ReadInJoyChannelPanelFragment.a(paramTabChannelCoverInfo)).a());
        if (ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).getChildAt(paramInt) == null)
        {
          QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "deleteChannelItem NPE, position = ", Integer.valueOf(paramInt), ", tabChannelCoverInfo = ", paramTabChannelCoverInfo.shortLogString() });
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).getChildAt(paramInt).getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      }
    } while (!ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).a(paramInt, ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).getCount() - 1));
    ReadInJoyStaticGridView localReadInJoyStaticGridView = (ReadInJoyStaticGridView)ReadInJoyChannelPanelFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).findViewWithTag(Long.valueOf(paramTabChannelCoverInfo.sectionId));
    if (localReadInJoyStaticGridView == null) {
      localReadInJoyStaticGridView = (ReadInJoyStaticGridView)ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).get(0);
    }
    for (paramTabChannelCoverInfo.channelConfigType = ((rov)ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).get(1)).a;; paramTabChannelCoverInfo.channelConfigType = paramTabChannelCoverInfo.sectionId)
    {
      localReadInJoyStaticGridView.a(localReadInJoyStaticGridView.getAdapter().getCount() - 1, 0, paramTabChannelCoverInfo);
      paramTabChannelCoverInfo = new pyb(this, localReadInJoyStaticGridView);
      localReadInJoyStaticGridView.setTag(2131376157, paramTabChannelCoverInfo);
      localReadInJoyStaticGridView.getViewTreeObserver().addOnPreDrawListener(paramTabChannelCoverInfo);
      if (paramInt != ReadInJoyChannelPanelFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment)) {
        break;
      }
      e();
      return;
    }
  }
  
  private void d()
  {
    int m = 0;
    List localList = ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).b();
    if ((localList == null) || (localList.size() == 0)) {
      QLog.d("ReadInJoyChannelPanelFragment", 2, "No channel Cache info.");
    }
    for (;;)
    {
      return;
      if ((ReadInJoyChannelPanelFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment) >= 0) && (ReadInJoyChannelPanelFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment) < localList.size())) {
        ((TabChannelCoverInfo)localList.get(ReadInJoyChannelPanelFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment))).isCurrent = true;
      }
      int i = 0;
      Object localObject;
      if (i < localList.size())
      {
        localObject = (TabChannelCoverInfo)localList.get(i);
        if (localObject != null) {
          if (i != ReadInJoyChannelPanelFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment)) {
            break label146;
          }
        }
        label146:
        for (boolean bool = true;; bool = false)
        {
          ((TabChannelCoverInfo)localObject).isCurrent = bool;
          i += 1;
          break;
        }
      }
      b(localList);
      i = 0;
      int k;
      for (int j = 0; i < localList.size(); j = k)
      {
        localObject = (TabChannelCoverInfo)localList.get(i);
        k = j;
        if (localObject != null)
        {
          if (((TabChannelCoverInfo)localObject).reason != 4) {
            break;
          }
          k = j + 1;
        }
        i += 1;
      }
      this.jdField_a_of_type_Int = j;
      ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).setLockCount(this.jdField_a_of_type_Int);
      i = m;
      while (i < localList.size())
      {
        localObject = new rqe();
        ((rot)localObject).a = ((TabChannelCoverInfo)localList.get(i));
        ((rot)localObject).l = i;
        ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, (rot)localObject, this.d);
        i += 1;
      }
    }
  }
  
  private void e()
  {
    int i = ReadInJoyChannelPanelFragment.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment);
    if (i != -1)
    {
      ReadInJoyChannelPanelFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, i);
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)getItem(ReadInJoyChannelPanelFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment));
      if (localTabChannelCoverInfo != null)
      {
        localTabChannelCoverInfo.isCurrent = true;
        notifyDataSetChanged();
      }
      QLog.d("ReadInJoyChannelPanelFragment", 1, "getRecommendChannelIndex: " + ReadInJoyChannelPanelFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment));
    }
  }
  
  public void a()
  {
    ReadInJoyChannelPanelFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, false);
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, -1);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = null;
    if (this.c >= 0) {
      localTabChannelCoverInfo = (TabChannelCoverInfo)getItem(this.c);
    }
    if (localTabChannelCoverInfo != null) {}
    try
    {
      ReadInJoyChannelPanelFragment.a("0X800949B", new pqg().b().a(localTabChannelCoverInfo.mChannelCoverId).m(ReadInJoyChannelPanelFragment.a(localTabChannelCoverInfo)).a());
      this.c = -1;
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (TabChannelCoverInfo)getItem(paramInt);
    pyc localpyc;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, 2131560275), null);
      localpyc = new pyc(this);
      localpyc.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370145));
      localpyc.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView = ((AutoFitTextView)paramView.findViewById(2131364467));
      localpyc.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376435));
      localpyc.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376440));
      localpyc.b = ((ImageView)paramView.findViewById(2131365496));
      localpyc.b.setOnClickListener(this);
      localpyc.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setOnGetMaxWidthCallback(localpyc);
      localpyc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)paramView.findViewById(2131369431));
      if (localpyc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView != null) {
        localpyc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment));
      }
      paramView.setTag(localpyc);
    }
    for (;;)
    {
      paramView.setAlpha(1.0F);
      localpyc.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setText(((TabChannelCoverInfo)localObject).mChannelCoverName);
      localpyc.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setTextColor(ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, (TabChannelCoverInfo)localObject));
      ImageView localImageView = localpyc.b;
      int i;
      if (ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment))
      {
        i = 0;
        label239:
        localImageView.setVisibility(i);
        localpyc.b.setTag(localObject);
        localpyc.b.setTag(2131376207, Integer.valueOf(paramInt));
        if ((paramInt < this.jdField_a_of_type_Int) && (ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment)))
        {
          paramView.setAlpha(0.5F);
          localpyc.b.setVisibility(8);
        }
        if (!ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment)) {
          break label413;
        }
        localpyc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localpyc.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        if ((localpyc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView == null) || (!pli.a())) {}
      }
      try
      {
        localObject = new URL(((TabChannelCoverInfo)localObject).mChannelCoverIcon);
        pjr.a(localpyc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, (URL)localObject, paramView.getContext());
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localpyc = (pyc)paramView.getTag();
        continue;
        i = 8;
        break label239;
        label413:
        localImageView = localpyc.jdField_a_of_type_AndroidWidgetImageView;
        if (ReadInJoyChannelPanelFragment.a((TabChannelCoverInfo)localObject) == 0) {}
        for (i = 0;; i = 8)
        {
          localImageView.setVisibility(i);
          if ((ReadInJoyChannelPanelFragment.a((TabChannelCoverInfo)localObject) != 1) || (((TabChannelCoverInfo)localObject).redPoint.c > 0L)) {
            break label493;
          }
          localpyc.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, (TabChannelCoverInfo)localObject, localpyc.jdField_a_of_type_AndroidWidgetTextView);
          break;
        }
        label493:
        localpyc.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.e("ReadInJoyChannelPanelFragment", 1, "", localMalformedURLException);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = ((Integer)paramView.getTag(2131376207)).intValue();
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)paramView.getTag();
      QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "onClick, delete button position = ", Integer.valueOf(i) });
      a(i, localTabChannelCoverInfo);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (TabChannelCoverInfo)getItem(paramInt);
    if (!ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment)) {
      try
      {
        ReadInJoyChannelPanelFragment.a("0X8009499", new pqg().b().a(paramAdapterView.mChannelCoverId).m(ReadInJoyChannelPanelFragment.a(paramAdapterView)).n(ReadInJoyChannelPanelFragment.a(paramAdapterView)).c((int)paramAdapterView.sectionId).b("style", 1).a());
        ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, paramAdapterView, this);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment.getActivity().finish();
        if (bmhv.E())
        {
          pvj.a().a(paramAdapterView.mChannelCoverId, 3, false, true);
          pno.b().post(new ReadInJoyChannelPanelFragment.DynamicGridViewAdapter.1(this, paramAdapterView));
          return;
        }
      }
      catch (JSONException paramView)
      {
        for (;;)
        {
          paramView.printStackTrace();
          continue;
          pvj.a().b(paramAdapterView.mChannelCoverId, 3);
        }
      }
    }
    a(paramInt, paramAdapterView);
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "onItemLongClick, position = ", Integer.valueOf(paramInt), ", id = ", Long.valueOf(paramLong) });
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, true);
    paramAdapterView = (TabChannelCoverInfo)getItem(paramInt);
    if (paramInt >= this.jdField_a_of_type_Int)
    {
      this.c = paramInt;
      ReadInJoyChannelPanelFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, true);
      ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, paramAdapterView);
    }
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, paramInt);
    try
    {
      ReadInJoyChannelPanelFragment.a("0X800949A", new pqg().b().a(paramAdapterView.mChannelCoverId).m(ReadInJoyChannelPanelFragment.a(paramAdapterView)).a());
      return true;
    }
    catch (JSONException paramAdapterView)
    {
      paramAdapterView.printStackTrace();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pya
 * JD-Core Version:    0.7.0.1
 */