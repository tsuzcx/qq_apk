import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class sou
  extends BaseAdapter
{
  public sou(sos paramsos) {}
  
  public spc a(int paramInt)
  {
    if (sos.a != null) {
      return (spc)sos.a.get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    if (sos.a != null) {
      return sos.a.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    int i;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(sos.a()).inflate(2131559408, paramViewGroup, false);
      paramViewGroup = new sov(this);
      localObject1 = paramView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((sos.b() - actn.a(110.0F, sos.a().getResources())) / 3);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "height of item is" + ((ViewGroup.LayoutParams)localObject1).height);
      }
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131374948));
      localObject2 = paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = ((sos.c() - actn.a(2.0F, sos.a().getResources())) / 2);
      ((ViewGroup.LayoutParams)localObject2).height = (((ViewGroup.LayoutParams)localObject2).width * 9 / 16);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "height of image is" + ((ViewGroup.LayoutParams)localObject2).height);
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374964));
      if (((ViewGroup.LayoutParams)localObject1).height - ((ViewGroup.LayoutParams)localObject2).height - actn.a(40.0F, sos.a().getResources()) > actn.a(16.0F, sos.a().getResources()))
      {
        i = 2;
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, " number is" + i);
        }
        if ((Build.MANUFACTURER.toLowerCase().contains("meizu")) && (Build.VERSION.SDK_INT <= 16))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "this is meizu");
          }
          localObject1 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject1).setMargins(12, 0, 12, 1);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 10.0F);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(i);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      localObject1 = a(paramInt);
      if (localObject1 != null)
      {
        localObject2 = ((spc)localObject1).a;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
        localURLDrawableOptions.mFailedDrawable = localColorDrawable;
        localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
        if ((localObject2 != null) && (((URLDrawable)localObject2).getStatus() == 2)) {
          ((URLDrawable)localObject2).restartDownload();
        }
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((spc)localObject1).b);
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "recommendInfo position = " + paramInt + "; url =" + localObject2 + "; title = " + ((spc)localObject1).b);
        }
      }
      return paramView;
      i = 1;
      break;
      paramViewGroup = (sov)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     sou
 * JD-Core Version:    0.7.0.1
 */