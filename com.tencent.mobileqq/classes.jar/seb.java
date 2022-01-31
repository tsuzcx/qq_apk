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
import java.util.List;
import java.util.Set;

public class seb
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  List<CommunityConfigInfo> jdField_a_of_type_JavaUtilList;
  
  public seb(List<CommunityConfigInfo> paramList)
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
    Object localObject1;
    if (paramView == null)
    {
      paramView = new sed(null);
      localObject1 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560002, null);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)((View)localObject1).findViewById(2131368007));
      paramView.b = ((TextView)((View)localObject1).findViewById(2131364647));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131364874));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369119));
      paramView.jdField_a_of_type_Sef = new sef(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController, null);
      ((View)localObject1).setTag(paramView);
      ((View)localObject1).setOnClickListener(paramView.jdField_a_of_type_Sef);
      paramViewGroup = paramView;
      paramView = (View)localObject1;
      paramViewGroup.jdField_a_of_type_Sef.jdField_a_of_type_Int = paramInt;
      if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label533;
      }
      localObject1 = (CommunityConfigInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController.a;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController.a;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = bcwh.a(paramView.getContext(), 60.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = bcwh.a(paramView.getContext(), 60.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
      if (TextUtils.isEmpty(((CommunityConfigInfo)localObject1).picUrl)) {
        break label475;
      }
      localObject2 = URLDrawable.getDrawable(((CommunityConfigInfo)localObject1).picUrl, (URLDrawable.URLDrawableOptions)localObject2);
      ((URLDrawable)localObject2).setTag(bcuq.a(bcwh.a(paramView.getContext(), 60.0F), bcwh.a(paramView.getContext(), 60.0F)));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable((Drawable)localObject2);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setRoundRect(bcwh.a(paramView.getContext(), 2.0F));
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      label314:
      if (((CommunityConfigInfo)localObject1).dynamicCount <= 0) {
        break label492;
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setFilterColor(Color.parseColor("#7F000000"));
      int i = ((CommunityConfigInfo)localObject1).dynamicCount;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(i + "");
      localObject2 = Typeface.create(Typeface.createFromAsset(paramView.getContext().getAssets(), "qzone_din.ttf"), 0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTypeface((Typeface)localObject2);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.b.setText(((CommunityConfigInfo)localObject1).name);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController).add(Long.valueOf(((CommunityConfigInfo)localObject1).bid));
      if (this.jdField_a_of_type_Int <= paramInt) {
        break label517;
      }
      ReadInJoyDiandianHeaderController.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController, false);
      return paramView;
      paramViewGroup = (sed)paramView.getTag();
      break;
      label475:
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController.a);
      break label314;
      label492:
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setFilterColor(Color.parseColor("#00000000"));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label517:
    ReadInJoyDiandianHeaderController.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController, true);
    this.jdField_a_of_type_Int = paramInt;
    return paramView;
    label533:
    paramViewGroup.b.setText(alpo.a(2131713432));
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setFilterColor(Color.parseColor("#F2F2F2"));
    nrt.a(null, "", "0X8009BA2", "0X8009BA2", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin(), "", "", "", false);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     seb
 * JD-Core Version:    0.7.0.1
 */