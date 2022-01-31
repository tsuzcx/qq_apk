import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment.StaticGridViewAdapter.1;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyStaticGridView;
import com.tencent.mobileqq.widget.AutoFitTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

public class ozh
  extends sik<TabChannelCoverInfo>
  implements bhqp
{
  private int jdField_a_of_type_Int;
  private ViewTreeObserver.OnPreDrawListener jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  
  public ozh(ReadInJoyChannelPanelFragment paramReadInJoyChannelPanelFragment, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramInt1);
    this.jdField_a_of_type_Int = paramInt3;
    a(paramInt2);
  }
  
  private void a(int paramInt)
  {
    int i = 0;
    List localList = ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).b(paramInt);
    if ((localList == null) || (localList.size() == 0)) {
      QLog.d("ReadInJoyChannelPanelFragment", 2, "No channel Cache info.");
    }
    for (;;)
    {
      return;
      Object localObject = localList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TabChannelCoverInfo)((Iterator)localObject).next()).isCurrent = false;
      }
      b(localList);
      paramInt = i;
      while (paramInt < localList.size())
      {
        localObject = new qlu();
        ((qkk)localObject).a = ((TabChannelCoverInfo)localList.get(paramInt));
        ((qkk)localObject).l = paramInt;
        ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, (qkk)localObject, this.jdField_a_of_type_Int);
        paramInt += 1;
      }
    }
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo, AdapterView<?> paramAdapterView, int paramInt)
  {
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, paramTabChannelCoverInfo);
    ((ReadInJoyStaticGridView)paramAdapterView).a(paramInt, getCount() - 1);
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).a(paramTabChannelCoverInfo);
    try
    {
      ReadInJoyChannelPanelFragment.a("0X800949D", new orz().b().a(paramTabChannelCoverInfo.mChannelCoverId).m(ReadInJoyChannelPanelFragment.a(paramTabChannelCoverInfo)).n(ReadInJoyChannelPanelFragment.a(paramTabChannelCoverInfo)).c((int)paramTabChannelCoverInfo.sectionId).a());
      if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener == null) {
        this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener = new ozi(this);
      }
      ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).getViewTreeObserver().addOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
      ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment);
      return;
    }
    catch (JSONException paramTabChannelCoverInfo)
    {
      for (;;)
      {
        paramTabChannelCoverInfo.printStackTrace();
      }
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (TabChannelCoverInfo)getItem(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, 2131560096), null);
      paramViewGroup = new ozj(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369472));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView = ((AutoFitTextView)paramView.findViewById(2131364114));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375500));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375516));
      paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)paramView.findViewById(2131368794));
      if (paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView != null) {
        paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment));
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setOnGetMaxWidthCallback(paramViewGroup);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setText(((TabChannelCoverInfo)localObject).mChannelCoverName);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setTextColor(ReadInJoyChannelPanelFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, (TabChannelCoverInfo)localObject));
      if (!ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment)) {
        break label338;
      }
      if (!otb.a())
      {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setCompoundDrawablesWithIntrinsicBounds(2130842397, 0, 0, 0);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setCompoundDrawablePadding(aekt.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      }
      label220:
      ImageView localImageView = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      if (ReadInJoyChannelPanelFragment.a((TabChannelCoverInfo)localObject) != 0) {
        break label352;
      }
      paramInt = 0;
      label236:
      localImageView.setVisibility(paramInt);
      if ((ReadInJoyChannelPanelFragment.a((TabChannelCoverInfo)localObject) != 1) || (((TabChannelCoverInfo)localObject).redPoint.c > 0L)) {
        break label358;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, (TabChannelCoverInfo)localObject, paramViewGroup.jdField_a_of_type_AndroidWidgetTextView);
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
      paramViewGroup = (ozj)paramView.getTag();
      break;
      label338:
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label220;
      label352:
      paramInt = 8;
      break label236;
      label358:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    return paramView;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView.getChildAt(paramInt).getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
    paramView = (TabChannelCoverInfo)getItem(paramInt);
    ReadInJoyChannelPanelFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, paramView, this);
    if (!ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment)) {
      try
      {
        ReadInJoyChannelPanelFragment.a("0X8009499", new orz().b().a(paramView.mChannelCoverId).m(ReadInJoyChannelPanelFragment.a(paramView)).n(ReadInJoyChannelPanelFragment.a(paramView)).c((int)paramView.sectionId).b("style", 1).a());
        if (pfg.a(paramView.mChannelCoverId))
        {
          a(paramView, paramAdapterView, paramInt);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment.getActivity().finish();
          owy.a().c(paramView.mChannelCoverId, 3);
          ors.b().post(new ReadInJoyChannelPanelFragment.StaticGridViewAdapter.1(this, paramView));
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("ReadInJoyChannelPanelFragment", 1, "", localJSONException);
        }
        if (!TextUtils.isEmpty(paramView.mChannelJumpUrl)) {
          try
          {
            paramAdapterView = URLDecoder.decode(paramView.mChannelJumpUrl, "utf-8");
            smk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment.getActivity(), paramView.mChannelCoverName, paramAdapterView, null);
            return;
          }
          catch (Exception paramAdapterView)
          {
            paramAdapterView.printStackTrace();
            QLog.w("ReadInJoyChannelPanelFragment", 1, "gotoReadInJoyViolaChannel, v_url error->" + paramAdapterView.getMessage());
            return;
          }
        }
        if (paramView.mChannelType == 3)
        {
          nxu.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment.getActivity(), paramView.mChannelCoverId, paramView.mChannelCoverName, paramView.mChannelType, -1);
          return;
        }
        nxu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment.getActivity(), paramView.mChannelCoverId, paramView.mChannelCoverName, paramView.mChannelType, -1);
        return;
      }
    }
    a(paramView, paramAdapterView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ozh
 * JD-Core Version:    0.7.0.1
 */