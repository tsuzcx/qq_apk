import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.RoundImageView;

public class qta
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoundImageView jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
  private TextView b;
  
  qta(Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)paramViewGroup.findViewById(2131364889));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131377972));
    this.b = ((TextView)paramViewGroup.findViewById(2131379600));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131378150));
  }
  
  void a(ColumnInfo paramColumnInfo, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842636);
    ((Drawable)localObject).setBounds(0, 0, xod.a(BaseApplicationImpl.getContext(), 15.0F), xod.a(BaseApplicationImpl.getContext(), 15.0F));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramColumnInfo.title);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(xod.a(BaseApplicationImpl.getContext(), 5.0F));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
    localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131719049);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.b.setText(String.format((String)localObject, new Object[] { Integer.valueOf(paramColumnInfo.videoCount) }));
    }
    if (!TextUtils.isEmpty(paramColumnInfo.coverUrl))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      localObject = URLDrawable.getDrawable(paramColumnInfo.coverUrl, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageDrawable((Drawable)localObject);
    }
    if (paramInt == paramColumnInfo.columnID)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qta
 * JD-Core Version:    0.7.0.1
 */