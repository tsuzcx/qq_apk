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
import java.util.ArrayList;

public class mfi
  extends BaseAdapter
{
  public mfi(MultiMembersVideoUI paramMultiMembersVideoUI) {}
  
  mfe a(View paramView)
  {
    mfe localmfe = new mfe();
    localmfe.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131372275));
    localmfe.d = ((ImageView)paramView.findViewById(2131372272));
    localmfe.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372288));
    localmfe.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372290));
    localmfe.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372274));
    localmfe.e = ((ImageView)paramView.findViewById(2131372287));
    localmfe.f = ((ImageView)paramView.findViewById(2131372273));
    if ((this.a.jdField_b_of_type_Boolean) && (localmfe.jdField_a_of_type_AndroidWidgetTextView != null) && (localmfe.d != null))
    {
      float f = MultiMembersVideoUI.a(this.a).getDisplayMetrics().density;
      localmfe.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      int i = (int)(f * 1.5D);
      localmfe.d.setPadding(i, i, i, i);
    }
    if (localmfe.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (this.a.jdField_a_of_type_Boolean) {
        localmfe.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131165925));
      }
    }
    else if (localmfe.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      paramView = (RelativeLayout.LayoutParams)localmfe.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      if (!this.a.jdField_a_of_type_Boolean) {
        break label312;
      }
      paramView.width = this.a.getResources().getDimensionPixelSize(2131297653);
    }
    for (paramView.height = this.a.getResources().getDimensionPixelSize(2131297652);; paramView.height = this.a.getResources().getDimensionPixelSize(2131297657))
    {
      localmfe.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramView);
      return localmfe;
      localmfe.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131165925));
      break;
      label312:
      paramView.width = this.a.getResources().getDimensionPixelSize(2131297659);
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
      return localObject1;
    }
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559548, null);
      paramViewGroup = a(paramView);
      paramView.setTag(paramViewGroup);
    }
    label162:
    label419:
    label428:
    label443:
    label1084:
    label1221:
    for (;;)
    {
      Object localObject2 = (mff)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if ((((mff)localObject2).jdField_a_of_type_JavaLangString == null) || (((mff)localObject2).jdField_a_of_type_AndroidGraphicsBitmap == null) || (!((mff)localObject2).d))
      {
        if (((mff)localObject2).jdField_b_of_type_Int != 0) {
          break label443;
        }
        localObject1 = String.valueOf(((mff)localObject2).jdField_a_of_type_Long);
        ((mff)localObject2).jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
        if (((mff)localObject2).jdField_a_of_type_JavaLangString.compareTo((String)localObject1) == 0) {
          break label419;
        }
        ((mff)localObject2).d = true;
        localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int, false, true);
        if (localObject1 == null) {
          break label428;
        }
        ((mff)localObject2).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
      }
      for (;;)
      {
        if (((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 2)) || (paramInt != 7) || (this.a.jdField_a_of_type_JavaUtilArrayList.size() <= 8)) {
          break label694;
        }
        paramViewGroup.jdField_b_of_type_Boolean = false;
        localObject1 = new GradientDrawable();
        ((GradientDrawable)localObject1).setShape(1);
        ((GradientDrawable)localObject1).setColor(Color.parseColor("#4C000000"));
        paramViewGroup.d.setImageDrawable((Drawable)localObject1);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372274));
        localObject1 = new StringBuilder("");
        ((StringBuilder)localObject1).append(this.a.jdField_a_of_type_JavaUtilArrayList.size() - 8 + 1);
        ((StringBuilder)localObject1).append("+");
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject1).toString());
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("");
        paramView.setContentDescription(MultiMembersVideoUI.d(this.a).getString(2131693242));
        return paramView;
        paramViewGroup = (mfe)paramView.getTag();
        if (paramViewGroup != null) {
          break label1221;
        }
        paramViewGroup = a(paramView);
        break;
        ((mff)localObject2).d = false;
        break label162;
        ((mff)localObject2).jdField_a_of_type_AndroidGraphicsBitmap = null;
        ((mff)localObject2).d = false;
      }
      long l = ((mff)localObject2).jdField_a_of_type_Long;
      if (((mff)localObject2).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null)
      {
        localObject1 = ((mff)localObject2).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        label465:
        if ((localObject1 == null) || (((AVPhoneUserInfo)localObject1).telInfo.mobile == null)) {
          break label625;
        }
        ((mff)localObject2).jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject1).telInfo.mobile;
        String str = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject1).telInfo.mobile);
        if (str == null) {
          break label599;
        }
        ((mff)localObject2).jdField_b_of_type_JavaLangString = bbcl.a(str);
        ((mff)localObject2).jdField_a_of_type_JavaLangString = str;
      }
      for (;;)
      {
        ((mff)localObject2).jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)MultiMembersVideoUI.c(this.a).getDrawable(2130841623)).getBitmap();
        ((mff)localObject2).d = true;
        break;
        localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
        break label465;
        label599:
        ((mff)localObject2).jdField_b_of_type_JavaLangString = null;
        ((mff)localObject2).jdField_a_of_type_JavaLangString = msp.a(((AVPhoneUserInfo)localObject1).telInfo.mobile, 4);
        continue;
        label625:
        if ((localObject1 != null) && (QLog.isColorLevel())) {
          QLog.d("MultiMembersVideoUI", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject1).toString());
        }
        ((mff)localObject2).jdField_b_of_type_JavaLangString = null;
        ((mff)localObject2).jdField_a_of_type_JavaLangString = MultiMembersVideoUI.b(this.a).getString(2131693243);
      }
      paramViewGroup.jdField_b_of_type_Boolean = true;
      paramViewGroup.jdField_a_of_type_Long = ((mff)localObject2).jdField_a_of_type_Long;
      if (((mff)localObject2).jdField_a_of_type_JavaLangString != null)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((mff)localObject2).jdField_a_of_type_JavaLangString);
        label728:
        if (((mff)localObject2).jdField_a_of_type_AndroidGraphicsBitmap == null) {
          break label1108;
        }
        if ((((mff)localObject2).jdField_b_of_type_Int == 0) || (((mff)localObject2).jdField_b_of_type_JavaLangString == null)) {
          break label1084;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(((mff)localObject2).jdField_b_of_type_JavaLangString);
        localObject1 = ((BitmapDrawable)MultiMembersVideoUI.e(this.a).getDrawable(2130841580)).getBitmap();
        paramViewGroup.d.setImageBitmap((Bitmap)localObject1);
        if (((this.a.jdField_a_of_type_ComTencentAvVideoController.a().E == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().C == 10)) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().E == 2))
        {
          if (!((mff)localObject2).e) {
            break label1130;
          }
          if (paramViewGroup.e.getVisibility() != 0) {
            paramViewGroup.e.setVisibility(0);
          }
          if (paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          ((mff)localObject2).jdField_a_of_type_Boolean = false;
        }
        paramViewGroup.jdField_a_of_type_Boolean = ((mff)localObject2).jdField_a_of_type_Boolean;
        if (!paramViewGroup.jdField_a_of_type_Boolean) {
          break label1152;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (((mff)localObject2).jdField_a_of_type_Int != 2) {
          break label1164;
        }
        paramViewGroup.jdField_a_of_type_Int = 5;
      }
      for (;;)
      {
        localObject1 = paramView;
        if (paramViewGroup.d == null) {
          break;
        }
        if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().E != 1) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().C != 10))
        {
          localObject1 = paramView;
          if (this.a.jdField_a_of_type_Int != 2) {
            break;
          }
        }
        localObject1 = paramView;
        if (((mff)localObject2).f) {
          break;
        }
        localObject2 = paramViewGroup.d.getDrawable();
        localObject1 = paramView;
        if (localObject2 == null) {
          break;
        }
        localObject1 = paramView;
        if (!(localObject2 instanceof BitmapDrawable)) {
          break;
        }
        localObject1 = bbdr.a(((BitmapDrawable)localObject2).getBitmap(), true);
        paramViewGroup.d.setImageBitmap((Bitmap)localObject1);
        return paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(((mff)localObject2).jdField_a_of_type_Long));
        break label728;
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.d.setImageBitmap(((mff)localObject2).jdField_a_of_type_AndroidGraphicsBitmap);
        break label802;
        label1108:
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.d.setImageResource(2130839736);
        break label802;
        label1130:
        if (paramViewGroup.e.getVisibility() != 0) {
          break label905;
        }
        paramViewGroup.e.setVisibility(8);
        break label905;
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label929;
        if (((mff)localObject2).c) {
          paramViewGroup.jdField_a_of_type_Int = 3;
        } else if (((mff)localObject2).jdField_a_of_type_Int == 1) {
          paramViewGroup.jdField_a_of_type_Int = 2;
        } else if (((mff)localObject2).jdField_b_of_type_Boolean) {
          paramViewGroup.jdField_a_of_type_Int = 1;
        } else {
          paramViewGroup.jdField_a_of_type_Int = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mfi
 * JD-Core Version:    0.7.0.1
 */