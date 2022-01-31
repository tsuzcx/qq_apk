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
import com.tencent.widget.AdapterView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public class oze
  extends sik<TabChannelCoverInfo>
  implements View.OnClickListener, bhqp, bhqq, siq, sir
{
  public int a;
  private int[] a;
  private int c = -1;
  private int d;
  
  public oze(ReadInJoyChannelPanelFragment paramReadInJoyChannelPanelFragment, Context paramContext, int paramInt1, int paramInt2)
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
      QLog.d("ReadInJoyChannelPanelFragment", 2, new Object[] { "can not delete item, position = ", Integer.valueOf(paramInt), ", LOCK_COUNT = ", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    do
    {
      return;
      ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, paramTabChannelCoverInfo);
      try
      {
        ReadInJoyChannelPanelFragment.a("0X800949C", new orz().b().a(paramTabChannelCoverInfo.mChannelCoverId).m(ReadInJoyChannelPanelFragment.a(paramTabChannelCoverInfo)).a());
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
    for (paramTabChannelCoverInfo.channelConfigType = ((qkm)ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).get(1)).a;; paramTabChannelCoverInfo.channelConfigType = paramTabChannelCoverInfo.sectionId)
    {
      localReadInJoyStaticGridView.a(localReadInJoyStaticGridView.a().getCount() - 1, 0, paramTabChannelCoverInfo);
      paramTabChannelCoverInfo = new ozf(this, localReadInJoyStaticGridView);
      localReadInJoyStaticGridView.setTag(2131375225, paramTabChannelCoverInfo);
      localReadInJoyStaticGridView.getViewTreeObserver().addOnPreDrawListener(paramTabChannelCoverInfo);
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
        localObject = new qlu();
        ((qkk)localObject).a = ((TabChannelCoverInfo)localList.get(i));
        ((qkk)localObject).l = i;
        ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, (qkk)localObject, this.d);
        i += 1;
      }
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
      ReadInJoyChannelPanelFragment.a("0X800949B", new orz().b().a(localTabChannelCoverInfo.mChannelCoverId).m(ReadInJoyChannelPanelFragment.a(localTabChannelCoverInfo)).a());
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
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
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
      ReadInJoyChannelPanelFragment.a("0X800949A", new orz().b().a(paramAdapterView.mChannelCoverId).m(ReadInJoyChannelPanelFragment.a(paramAdapterView)).a());
      return true;
    }
    catch (JSONException paramAdapterView)
    {
      paramAdapterView.printStackTrace();
    }
    return true;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (TabChannelCoverInfo)getItem(paramInt);
    ImageView localImageView;
    int i;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, 2131560068), null);
      paramViewGroup = new ozg(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369472));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView = ((AutoFitTextView)paramView.findViewById(2131364114));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375500));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375516));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131365087));
      paramViewGroup.b.setOnClickListener(this);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setOnGetMaxWidthCallback(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)paramView.findViewById(2131368794));
      if (paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView != null) {
        paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment));
      }
      paramView.setTag(paramViewGroup);
      paramView.setAlpha(1.0F);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setText(((TabChannelCoverInfo)localObject).mChannelCoverName);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setTextColor(ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, (TabChannelCoverInfo)localObject));
      localImageView = paramViewGroup.b;
      if (!ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment)) {
        break label368;
      }
      i = 0;
      label223:
      localImageView.setVisibility(i);
      paramViewGroup.b.setTag(localObject);
      paramViewGroup.b.setTag(2131375280, Integer.valueOf(paramInt));
      if ((paramInt < this.jdField_a_of_type_Int) && (ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment)))
      {
        paramView.setAlpha(0.5F);
        paramViewGroup.b.setVisibility(8);
      }
      if (!ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment)) {
        break label375;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      if ((paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView != null) && (otb.a())) {}
      try
      {
        localObject = new URL(((TabChannelCoverInfo)localObject).mChannelCoverIcon);
        orc.a(paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, (URL)localObject, paramView.getContext());
        return paramView;
      }
      catch (MalformedURLException paramViewGroup)
      {
        QLog.e("ReadInJoyChannelPanelFragment", 1, "", paramViewGroup);
      }
      paramViewGroup = (ozg)paramView.getTag();
      break;
      label368:
      i = 8;
      break label223;
      label375:
      localImageView = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      if (ReadInJoyChannelPanelFragment.a((TabChannelCoverInfo)localObject) == 0) {}
      for (paramInt = 0;; paramInt = 8)
      {
        localImageView.setVisibility(paramInt);
        if ((ReadInJoyChannelPanelFragment.a((TabChannelCoverInfo)localObject) != 1) || (((TabChannelCoverInfo)localObject).redPoint.c > 0L)) {
          break label449;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, (TabChannelCoverInfo)localObject, paramViewGroup.jdField_a_of_type_AndroidWidgetTextView);
        break;
      }
      label449:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    int i = ((Integer)paramView.getTag(2131375280)).intValue();
    paramView = (TabChannelCoverInfo)paramView.getTag();
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "onClick, delete button position = ", Integer.valueOf(i) });
    a(i, paramView);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (TabChannelCoverInfo)getItem(paramInt);
    if (!ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment)) {
      try
      {
        ReadInJoyChannelPanelFragment.a("0X8009499", new orz().b().a(paramAdapterView.mChannelCoverId).m(ReadInJoyChannelPanelFragment.a(paramAdapterView)).n(ReadInJoyChannelPanelFragment.a(paramAdapterView)).c((int)paramAdapterView.sectionId).b("style", 1).a());
        ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, paramAdapterView, this);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment.getActivity().finish();
        if (bjxj.A())
        {
          owy.a().a(paramAdapterView.mChannelCoverId, 3, false, true);
          ors.b().post(new ReadInJoyChannelPanelFragment.DynamicGridViewAdapter.1(this, paramAdapterView));
          return;
        }
      }
      catch (JSONException paramView)
      {
        for (;;)
        {
          paramView.printStackTrace();
          continue;
          owy.a().b(paramAdapterView.mChannelCoverId, 3);
        }
      }
    }
    a(paramInt, paramAdapterView);
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oze
 * JD-Core Version:    0.7.0.1
 */