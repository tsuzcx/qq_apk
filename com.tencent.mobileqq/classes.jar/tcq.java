import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.model.CommunityConfigInfo;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Set;

public class tcq
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  List<CommunityConfigInfo> jdField_a_of_type_JavaUtilList;
  
  public tcq(List<CommunityConfigInfo> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount() - 1) && (paramInt >= 0)) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    tcs localtcs;
    if (paramView == null)
    {
      localtcs = new tcs(null);
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560147, null);
      localtcs.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131368343));
      localtcs.b = ((TextView)paramView.findViewById(2131364864));
      localtcs.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365109));
      localtcs.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369526));
      localtcs.jdField_a_of_type_Tcu = new tcu(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController, null);
      paramView.setTag(localtcs);
      paramView.setOnClickListener(localtcs.jdField_a_of_type_Tcu);
      localtcs.jdField_a_of_type_Tcu.jdField_a_of_type_Int = paramInt;
      if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label557;
      }
      CommunityConfigInfo localCommunityConfigInfo = (CommunityConfigInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController.a;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController.a;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bggq.a(paramView.getContext(), 60.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bggq.a(paramView.getContext(), 60.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      if (TextUtils.isEmpty(localCommunityConfigInfo.picUrl)) {
        break label495;
      }
      localObject = URLDrawable.getDrawable(localCommunityConfigInfo.picUrl, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(bgey.a(bggq.a(paramView.getContext(), 60.0F), bggq.a(paramView.getContext(), 60.0F)));
      localtcs.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable((Drawable)localObject);
      localtcs.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setRoundRect(bggq.a(paramView.getContext(), 2.0F));
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      label313:
      if (localCommunityConfigInfo.dynamicCount <= 0) {
        break label513;
      }
      localtcs.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setFilterColor(Color.parseColor("#7F000000"));
      int i = localCommunityConfigInfo.dynamicCount;
      localtcs.jdField_a_of_type_AndroidWidgetTextView.setText(i + "");
      localObject = Typeface.create(Typeface.createFromAsset(paramView.getContext().getAssets(), "qzone_din.ttf"), 0);
      localtcs.jdField_a_of_type_AndroidWidgetTextView.setTypeface((Typeface)localObject);
      localtcs.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label406:
      localtcs.b.setText(localCommunityConfigInfo.name);
      localtcs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController).add(Long.valueOf(localCommunityConfigInfo.bid));
      if (this.jdField_a_of_type_Int <= paramInt) {
        break label540;
      }
      ReadInJoyDiandianHeaderController.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController, false);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localtcs = (tcs)paramView.getTag();
      break;
      label495:
      localtcs.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController.a);
      break label313;
      label513:
      localtcs.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setFilterColor(Color.parseColor("#00000000"));
      localtcs.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label406;
      label540:
      ReadInJoyDiandianHeaderController.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController, true);
      this.jdField_a_of_type_Int = paramInt;
      continue;
      label557:
      localtcs.b.setText(anni.a(2131711823));
      localtcs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localtcs.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      localtcs.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setFilterColor(Color.parseColor("#F2F2F2"));
      oat.a(null, "", "0X8009BA2", "0X8009BA2", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin(), "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tcq
 * JD-Core Version:    0.7.0.1
 */