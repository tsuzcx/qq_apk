import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.ui.MultiMembersVideoUI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class mex
  extends BaseAdapter
{
  public mex(MultiMembersVideoUI paramMultiMembersVideoUI) {}
  
  met a(View paramView)
  {
    met localmet = new met();
    localmet.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131373274));
    localmet.d = ((ImageView)paramView.findViewById(2131373271));
    localmet.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373287));
    localmet.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373289));
    localmet.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373273));
    localmet.e = ((ImageView)paramView.findViewById(2131373286));
    localmet.f = ((ImageView)paramView.findViewById(2131373272));
    if ((this.a.jdField_b_of_type_Boolean) && (localmet.jdField_a_of_type_AndroidWidgetTextView != null) && (localmet.d != null))
    {
      float f = MultiMembersVideoUI.a(this.a).getDisplayMetrics().density;
      localmet.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      int i = (int)(f * 1.5D);
      localmet.d.setPadding(i, i, i, i);
    }
    if (localmet.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (this.a.jdField_a_of_type_Boolean) {
        localmet.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131166019));
      }
    }
    else if (localmet.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      paramView = (RelativeLayout.LayoutParams)localmet.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      if (!this.a.jdField_a_of_type_Boolean) {
        break label312;
      }
      paramView.width = this.a.getResources().getDimensionPixelSize(2131297753);
    }
    for (paramView.height = this.a.getResources().getDimensionPixelSize(2131297752);; paramView.height = this.a.getResources().getDimensionPixelSize(2131297757))
    {
      localmet.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramView);
      return localmet;
      localmet.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131166019));
      break;
      label312:
      paramView.width = this.a.getResources().getDimensionPixelSize(2131297759);
    }
  }
  
  public int getCount()
  {
    if (((this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 2)) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 8)) {
      return 8;
    }
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if ((paramInt == 0) && (paramView != null) && (paramViewGroup.getChildCount() != paramInt))
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559736, null);
      localObject1 = a(paramView);
      paramView.setTag(localObject1);
    }
    label67:
    label458:
    label473:
    label495:
    label629:
    label1269:
    for (;;)
    {
      meu localmeu = (meu)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      Object localObject2;
      if ((localmeu.jdField_a_of_type_JavaLangString == null) || (localmeu.jdField_a_of_type_AndroidGraphicsBitmap == null) || (!localmeu.d))
      {
        if (localmeu.jdField_b_of_type_Int != 0) {
          break label473;
        }
        localObject2 = String.valueOf(localmeu.jdField_a_of_type_Long);
        localmeu.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
        if (localmeu.jdField_a_of_type_JavaLangString.compareTo((String)localObject2) == 0) {
          break label449;
        }
        localmeu.d = true;
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int, false, true);
        if (localObject2 == null) {
          break label458;
        }
        localmeu.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
      }
      for (;;)
      {
        if (((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 2)) || (paramInt != 7) || (this.a.jdField_a_of_type_JavaUtilArrayList.size() <= 8)) {
          break label724;
        }
        ((met)localObject1).jdField_b_of_type_Boolean = false;
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(1);
        ((GradientDrawable)localObject2).setColor(Color.parseColor("#4C000000"));
        ((met)localObject1).d.setImageDrawable((Drawable)localObject2);
        ((met)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373273));
        localObject2 = new StringBuilder("");
        ((StringBuilder)localObject2).append(this.a.jdField_a_of_type_JavaUtilArrayList.size() - 8 + 1);
        ((StringBuilder)localObject2).append("+");
        ((met)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject2).toString());
        ((met)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        ((met)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        ((met)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("");
        paramView.setContentDescription(MultiMembersVideoUI.d(this.a).getString(2131692838));
        localObject1 = paramView;
        break;
        localObject1 = (met)paramView.getTag();
        if (localObject1 != null) {
          break label1269;
        }
        localObject1 = a(paramView);
        break label67;
        localmeu.d = false;
        break label178;
        localmeu.jdField_a_of_type_AndroidGraphicsBitmap = null;
        localmeu.d = false;
      }
      long l = localmeu.jdField_a_of_type_Long;
      if (localmeu.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null)
      {
        localObject2 = localmeu.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        if ((localObject2 == null) || (((AVPhoneUserInfo)localObject2).telInfo.mobile == null)) {
          break label655;
        }
        localmeu.jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject2).telInfo.mobile;
        String str = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject2).telInfo.mobile);
        if (str == null) {
          break label629;
        }
        localmeu.jdField_b_of_type_JavaLangString = bglf.a(str);
        localmeu.jdField_a_of_type_JavaLangString = str;
      }
      for (;;)
      {
        localmeu.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)MultiMembersVideoUI.c(this.a).getDrawable(2130842093)).getBitmap();
        localmeu.d = true;
        break;
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
        break label495;
        localmeu.jdField_b_of_type_JavaLangString = null;
        localmeu.jdField_a_of_type_JavaLangString = msm.a(((AVPhoneUserInfo)localObject2).telInfo.mobile, 4);
        continue;
        if ((localObject2 != null) && (QLog.isColorLevel())) {
          QLog.d("MultiMembersVideoUI", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject2).toString());
        }
        localmeu.jdField_b_of_type_JavaLangString = null;
        localmeu.jdField_a_of_type_JavaLangString = MultiMembersVideoUI.b(this.a).getString(2131692839);
      }
      ((met)localObject1).jdField_b_of_type_Boolean = true;
      ((met)localObject1).jdField_a_of_type_Long = localmeu.jdField_a_of_type_Long;
      if (localmeu.jdField_a_of_type_JavaLangString != null)
      {
        ((met)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localmeu.jdField_a_of_type_JavaLangString);
        label761:
        if (localmeu.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          break label1147;
        }
        if ((localmeu.jdField_b_of_type_Int == 0) || (localmeu.jdField_b_of_type_JavaLangString == null)) {
          break label1121;
        }
        ((met)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        ((met)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(localmeu.jdField_b_of_type_JavaLangString);
        localObject2 = ((BitmapDrawable)MultiMembersVideoUI.e(this.a).getDrawable(2130842050)).getBitmap();
        ((met)localObject1).d.setImageBitmap((Bitmap)localObject2);
        if (((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 2))
        {
          if (!localmeu.e) {
            break label1171;
          }
          if (((met)localObject1).e.getVisibility() != 0) {
            ((met)localObject1).e.setVisibility(0);
          }
          if (((met)localObject1).jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
            ((met)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          localmeu.jdField_a_of_type_Boolean = false;
        }
        ((met)localObject1).jdField_a_of_type_Boolean = localmeu.jdField_a_of_type_Boolean;
        if (!((met)localObject1).jdField_a_of_type_Boolean) {
          break label1195;
        }
        ((met)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (localmeu.jdField_a_of_type_Int != 2) {
          break label1208;
        }
        ((met)localObject1).jdField_a_of_type_Int = 5;
      }
      for (;;)
      {
        if ((((met)localObject1).d != null) && (((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)) || ((this.a.jdField_a_of_type_Int == 2) && (!localmeu.f))))
        {
          localObject2 = ((met)localObject1).d.getDrawable();
          if ((localObject2 != null) && ((localObject2 instanceof BitmapDrawable)))
          {
            localObject2 = bgmo.a(((BitmapDrawable)localObject2).getBitmap(), true);
            ((met)localObject1).d.setImageBitmap((Bitmap)localObject2);
          }
        }
        localObject1 = paramView;
        break;
        ((met)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localmeu.jdField_a_of_type_Long));
        break label761;
        ((met)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        ((met)localObject1).d.setImageBitmap(localmeu.jdField_a_of_type_AndroidGraphicsBitmap);
        break label838;
        label1147:
        ((met)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        ((met)localObject1).d.setImageResource(2130840264);
        break label838;
        if (((met)localObject1).e.getVisibility() != 0) {
          break label945;
        }
        ((met)localObject1).e.setVisibility(8);
        break label945;
        ((met)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label972;
        if (localmeu.c) {
          ((met)localObject1).jdField_a_of_type_Int = 3;
        } else if (localmeu.jdField_a_of_type_Int == 1) {
          ((met)localObject1).jdField_a_of_type_Int = 2;
        } else if (localmeu.jdField_b_of_type_Boolean) {
          ((met)localObject1).jdField_a_of_type_Int = 1;
        } else {
          ((met)localObject1).jdField_a_of_type_Int = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mex
 * JD-Core Version:    0.7.0.1
 */