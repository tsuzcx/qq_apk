import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.BaseItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.JumpAdUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class mma
  extends BaseItemViewHolder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public mma(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    paramView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367055));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361926));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367073));
    this.c = ((TextView)paramView.findViewById(2131367072));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365532);
  }
  
  private void a()
  {
    Object localObject = (RecommendAdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData;
    if (this.c != null)
    {
      if (!TextUtils.isEmpty(((RecommendAdData)localObject).i))
      {
        this.c.setVisibility(0);
        this.c.setText(((RecommendAdData)localObject).i);
      }
    }
    else
    {
      if (((RecommendAdData)localObject).jdField_b_of_type_Int != 12) {
        break label135;
      }
      if (!TextUtils.isEmpty(((RecommendAdData)localObject).h)) {
        break label76;
      }
    }
    label76:
    do
    {
      return;
      this.c.setVisibility(8);
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    } while (!NativeAdUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), ((RecommendAdData)localObject).h));
    localObject = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130839084);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("打开APP");
    return;
    label135:
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    switch (paramBaseData2.d)
    {
    default: 
      throw new IllegalArgumentException();
    }
    paramBaseData1 = (RecommendAdData)paramBaseData2;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseData1.jdField_b_of_type_JavaLangString);
    paramBaseData2 = URLDrawable.URLDrawableOptions.obtain();
    paramBaseData2.mRequestWidth = AIOUtils.a(88.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    paramBaseData2.mRequestHeight = AIOUtils.a(68.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    paramBaseData2.mLoadingDrawable = new ColorDrawable(-2565414);
    paramBaseData2.mPlayGifImage = true;
    paramBaseData2.mMemoryCacheKeySuffix = "fast_web";
    paramBaseData1 = URLDrawable.getDrawable(ReadInJoyUtils.a(paramBaseData1.d), paramBaseData2);
    if ((paramBaseData1 != null) && (paramBaseData1.getStatus() == 2)) {
      paramBaseData1.restartDownload();
    }
    a();
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBaseData1);
    this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new mmb(this));
  }
  
  public void onClick(View paramView)
  {
    JumpAdUtils.a((Activity)paramView.getContext(), (AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mma
 * JD-Core Version:    0.7.0.1
 */