import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AttachedAdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;

class qyb
  extends qxr
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private TextView b;
  
  public qyb(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    paramView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131302781));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312553));
    this.b = ((TextView)paramView.findViewById(2131312304));
    rue.a((FrameLayout)paramView.findViewById(2131300890), 0.0F, Color.parseColor("#dedfe0"), 1);
    rue.a((TextView)paramView.findViewById(2131312362), aciy.a(2.0F, paramView.getResources()), Color.parseColor("#fa8726"), 1);
    rue.a((TextView)paramView.findViewById(2131312455), aciy.a(2.0F, paramView.getResources()), Color.parseColor("#12b7f5"), 1);
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    switch (paramBaseData2.p)
    {
    default: 
      throw new IllegalArgumentException();
    }
    paramBaseData1 = (AttachedAdData)paramBaseData2;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseData1.j);
    this.b.setText(paramBaseData1.k);
    paramBaseData2 = URLDrawable.URLDrawableOptions.obtain();
    paramBaseData2.mRequestWidth = aciy.a(85.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    paramBaseData2.mRequestHeight = aciy.a(72.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    paramBaseData2.mLoadingDrawable = new ColorDrawable(-2565414);
    paramBaseData2.mPlayGifImage = true;
    paramBaseData2.mMemoryCacheKeySuffix = "fast_web";
    paramBaseData1 = URLDrawable.getDrawable(rsl.a(paramBaseData1.l, 4), paramBaseData2);
    if ((paramBaseData1 != null) && (paramBaseData1.getStatus() == 2)) {
      paramBaseData1.restartDownload();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBaseData1);
  }
  
  public void onClick(View paramView)
  {
    rav.a((Activity)paramView.getContext(), (AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qyb
 * JD-Core Version:    0.7.0.1
 */