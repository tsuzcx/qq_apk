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

public class lup
  extends BaseAdapter
{
  public lup(MultiMembersVideoUI paramMultiMembersVideoUI) {}
  
  lul a(View paramView)
  {
    lul locallul = new lul();
    locallul.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131306576));
    locallul.d = ((ImageView)paramView.findViewById(2131306573));
    locallul.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131306589));
    locallul.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131306591));
    locallul.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131306575));
    locallul.e = ((ImageView)paramView.findViewById(2131306588));
    locallul.f = ((ImageView)paramView.findViewById(2131306574));
    if ((this.a.jdField_b_of_type_Boolean) && (locallul.jdField_a_of_type_AndroidWidgetTextView != null) && (locallul.d != null))
    {
      float f = MultiMembersVideoUI.a(this.a).getDisplayMetrics().density;
      locallul.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      int i = (int)(f * 1.5D);
      locallul.d.setPadding(i, i, i, i);
    }
    if (locallul.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (this.a.jdField_a_of_type_Boolean) {
        locallul.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131100335));
      }
    }
    else if (locallul.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      paramView = (RelativeLayout.LayoutParams)locallul.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      if (!this.a.jdField_a_of_type_Boolean) {
        break label312;
      }
      paramView.width = this.a.getResources().getDimensionPixelSize(2131166564);
    }
    for (paramView.height = this.a.getResources().getDimensionPixelSize(2131166563);; paramView.height = this.a.getResources().getDimensionPixelSize(2131166568))
    {
      locallul.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramView);
      return locallul;
      locallul.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131100335));
      break;
      label312:
      paramView.width = this.a.getResources().getDimensionPixelSize(2131166570);
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
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493980, null);
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
      Object localObject2 = (lum)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if ((((lum)localObject2).jdField_a_of_type_JavaLangString == null) || (((lum)localObject2).jdField_a_of_type_AndroidGraphicsBitmap == null) || (!((lum)localObject2).d))
      {
        if (((lum)localObject2).jdField_b_of_type_Int != 0) {
          break label443;
        }
        localObject1 = String.valueOf(((lum)localObject2).jdField_a_of_type_Long);
        ((lum)localObject2).jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
        if (((lum)localObject2).jdField_a_of_type_JavaLangString.compareTo((String)localObject1) == 0) {
          break label419;
        }
        ((lum)localObject2).d = true;
        localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int, false, true);
        if (localObject1 == null) {
          break label428;
        }
        ((lum)localObject2).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
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
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131306575));
        localObject1 = new StringBuilder("");
        ((StringBuilder)localObject1).append(this.a.jdField_a_of_type_JavaUtilArrayList.size() - 8 + 1);
        ((StringBuilder)localObject1).append("+");
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject1).toString());
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("");
        paramView.setContentDescription(MultiMembersVideoUI.d(this.a).getString(2131627602));
        return paramView;
        paramViewGroup = (lul)paramView.getTag();
        if (paramViewGroup != null) {
          break label1221;
        }
        paramViewGroup = a(paramView);
        break;
        ((lum)localObject2).d = false;
        break label162;
        ((lum)localObject2).jdField_a_of_type_AndroidGraphicsBitmap = null;
        ((lum)localObject2).d = false;
      }
      long l = ((lum)localObject2).jdField_a_of_type_Long;
      if (((lum)localObject2).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null)
      {
        localObject1 = ((lum)localObject2).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        label465:
        if ((localObject1 == null) || (((AVPhoneUserInfo)localObject1).telInfo.mobile == null)) {
          break label625;
        }
        ((lum)localObject2).jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject1).telInfo.mobile;
        String str = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject1).telInfo.mobile);
        if (str == null) {
          break label599;
        }
        ((lum)localObject2).jdField_b_of_type_JavaLangString = babh.a(str);
        ((lum)localObject2).jdField_a_of_type_JavaLangString = str;
      }
      for (;;)
      {
        ((lum)localObject2).jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)MultiMembersVideoUI.c(this.a).getDrawable(2130841533)).getBitmap();
        ((lum)localObject2).d = true;
        break;
        localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
        break label465;
        label599:
        ((lum)localObject2).jdField_b_of_type_JavaLangString = null;
        ((lum)localObject2).jdField_a_of_type_JavaLangString = mhq.a(((AVPhoneUserInfo)localObject1).telInfo.mobile, 4);
        continue;
        label625:
        if ((localObject1 != null) && (QLog.isColorLevel())) {
          QLog.d("MultiMembersVideoUI", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject1).toString());
        }
        ((lum)localObject2).jdField_b_of_type_JavaLangString = null;
        ((lum)localObject2).jdField_a_of_type_JavaLangString = MultiMembersVideoUI.b(this.a).getString(2131627603);
      }
      paramViewGroup.jdField_b_of_type_Boolean = true;
      paramViewGroup.jdField_a_of_type_Long = ((lum)localObject2).jdField_a_of_type_Long;
      if (((lum)localObject2).jdField_a_of_type_JavaLangString != null)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((lum)localObject2).jdField_a_of_type_JavaLangString);
        label728:
        if (((lum)localObject2).jdField_a_of_type_AndroidGraphicsBitmap == null) {
          break label1108;
        }
        if ((((lum)localObject2).jdField_b_of_type_Int == 0) || (((lum)localObject2).jdField_b_of_type_JavaLangString == null)) {
          break label1084;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(((lum)localObject2).jdField_b_of_type_JavaLangString);
        localObject1 = ((BitmapDrawable)MultiMembersVideoUI.e(this.a).getDrawable(2130841491)).getBitmap();
        paramViewGroup.d.setImageBitmap((Bitmap)localObject1);
        if (((this.a.jdField_a_of_type_ComTencentAvVideoController.a().C == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().A == 10)) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().C == 2))
        {
          if (!((lum)localObject2).e) {
            break label1130;
          }
          if (paramViewGroup.e.getVisibility() != 0) {
            paramViewGroup.e.setVisibility(0);
          }
          if (paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          ((lum)localObject2).jdField_a_of_type_Boolean = false;
        }
        paramViewGroup.jdField_a_of_type_Boolean = ((lum)localObject2).jdField_a_of_type_Boolean;
        if (!paramViewGroup.jdField_a_of_type_Boolean) {
          break label1152;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (((lum)localObject2).jdField_a_of_type_Int != 2) {
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
        if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().C != 1) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().A != 10))
        {
          localObject1 = paramView;
          if (this.a.jdField_a_of_type_Int != 2) {
            break;
          }
        }
        localObject1 = paramView;
        if (((lum)localObject2).f) {
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
        localObject1 = bacm.a(((BitmapDrawable)localObject2).getBitmap(), true);
        paramViewGroup.d.setImageBitmap((Bitmap)localObject1);
        return paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(((lum)localObject2).jdField_a_of_type_Long));
        break label728;
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.d.setImageBitmap(((lum)localObject2).jdField_a_of_type_AndroidGraphicsBitmap);
        break label802;
        label1108:
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.d.setImageResource(2130839687);
        break label802;
        label1130:
        if (paramViewGroup.e.getVisibility() != 0) {
          break label905;
        }
        paramViewGroup.e.setVisibility(8);
        break label905;
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label929;
        if (((lum)localObject2).c) {
          paramViewGroup.jdField_a_of_type_Int = 3;
        } else if (((lum)localObject2).jdField_a_of_type_Int == 1) {
          paramViewGroup.jdField_a_of_type_Int = 2;
        } else if (((lum)localObject2).jdField_b_of_type_Boolean) {
          paramViewGroup.jdField_a_of_type_Int = 1;
        } else {
          paramViewGroup.jdField_a_of_type_Int = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lup
 * JD-Core Version:    0.7.0.1
 */