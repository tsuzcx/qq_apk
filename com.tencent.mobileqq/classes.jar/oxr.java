import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class oxr
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<rsj> jdField_a_of_type_JavaUtilArrayList;
  
  public void a(List<rsj> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      rsj localrsj = new rsj();
      this.jdField_a_of_type_JavaUtilArrayList.add(localrsj);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      paramList = new rsj();
      this.jdField_a_of_type_JavaUtilArrayList.add(paramList);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size() - 1)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources();
    Object localObject1;
    if ((paramInt == 0) || (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size() - 1))
    {
      localObject1 = paramView;
      if (paramView == null)
      {
        localObject1 = new View(this.jdField_a_of_type_AndroidContentContext);
        ((View)localObject1).setLayoutParams(new ViewGroup.LayoutParams(AIOUtils.dp2px(2.0F, (Resources)localObject2), AIOUtils.dp2px(100.0F, (Resources)localObject2)));
      }
      paramView = (View)localObject1;
      localObject2 = localObject1;
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject2;
    }
    Object localObject3;
    if (paramView == null)
    {
      localObject1 = new oxt(null);
      paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(AIOUtils.dp2px(100.0F, (Resources)localObject2), AIOUtils.dp2px(100.0F, (Resources)localObject2)));
      localObject3 = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      ((BubbleImageView)localObject3).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      ((BubbleImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((BubbleImageView)localObject3).setRadius(5.0F);
      ((BubbleImageView)localObject3).d(false);
      ((oxt)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)localObject3);
      paramView.addView((View)localObject3);
      localObject3 = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      ((BubbleImageView)localObject3).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      ((BubbleImageView)localObject3).setRadius(5.0F);
      ((BubbleImageView)localObject3).d(false);
      ((BubbleImageView)localObject3).setBackgroundColor(1711276032);
      ((oxt)localObject1).jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)localObject3);
      paramView.addView((View)localObject3);
      localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      Object localObject4 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject4).setMargins(AIOUtils.dp2px(9.0F, (Resources)localObject2), AIOUtils.dp2px(6.0F, (Resources)localObject2), AIOUtils.dp2px(9.0F, (Resources)localObject2), 0);
      ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      ((TextView)localObject3).setTextColor(-1);
      ((TextView)localObject3).setTextSize(14.0F);
      ((TextView)localObject3).setMaxLines(2);
      ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject3).getPaint().setFakeBoldText(true);
      ((oxt)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject3);
      paramView.addView((View)localObject3);
      localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).setMargins(AIOUtils.dp2px(8.0F, (Resources)localObject2), 0, 0, AIOUtils.dp2px(8.0F, (Resources)localObject2));
      ((RelativeLayout.LayoutParams)localObject4).addRule(12);
      ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      ((TextView)localObject3).setPadding(AIOUtils.dp2px(5.0F, (Resources)localObject2), 0, AIOUtils.dp2px(5.0F, (Resources)localObject2), 0);
      ((TextView)localObject3).setTextColor(-7745469);
      ((TextView)localObject3).setTextSize(11.0F);
      ((TextView)localObject3).setBackgroundResource(2130843085);
      ((oxt)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject3);
      paramView.addView((View)localObject3);
      paramView.setTag(localObject1);
      label501:
      localObject2 = (rsj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localObject2 != null)
      {
        localObject3 = new ColorDrawable(-1);
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject4).mPlayGifImage = true;
        if (TextUtils.isEmpty(((rsj)localObject2).d)) {
          break label706;
        }
        localObject3 = URLDrawable.getDrawable(((rsj)localObject2).d, (URLDrawable.URLDrawableOptions)localObject4);
        if (((URLDrawable)localObject3).getStatus() == 2) {
          ((URLDrawable)localObject3).restartDownload();
        }
        ((oxt)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject3);
        label601:
        localObject3 = new StringBuilder();
        if (!TextUtils.isEmpty(((rsj)localObject2).c)) {
          ((StringBuilder)localObject3).append(((rsj)localObject2).c);
        }
        if (!TextUtils.isEmpty(((rsj)localObject2).a)) {
          ((StringBuilder)localObject3).append(((rsj)localObject2).a);
        }
        ((oxt)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject3).toString());
        if (((rsj)localObject2).b > 0) {
          break label719;
        }
        ((oxt)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    for (;;)
    {
      localObject1 = paramView;
      localObject2 = paramView;
      break;
      localObject1 = (oxt)paramView.getTag();
      break label501;
      label706:
      ((oxt)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject3);
      break label601;
      label719:
      if (((rsj)localObject2).b < 1000)
      {
        ((oxt)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        ((oxt)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText("+" + ((rsj)localObject2).b);
      }
      else
      {
        ((oxt)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        ((oxt)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText("+999");
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oxr
 * JD-Core Version:    0.7.0.1
 */