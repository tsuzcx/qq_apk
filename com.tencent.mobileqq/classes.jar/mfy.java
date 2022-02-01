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
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class mfy
  extends BaseAdapter
{
  public mfy(MultiMembersVideoUI paramMultiMembersVideoUI) {}
  
  mfu a(View paramView)
  {
    mfu localmfu = new mfu();
    localmfu.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131373526));
    localmfu.d = ((ImageView)paramView.findViewById(2131373523));
    localmfu.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373539));
    localmfu.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373541));
    localmfu.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373525));
    localmfu.e = ((ImageView)paramView.findViewById(2131373538));
    localmfu.f = ((ImageView)paramView.findViewById(2131373524));
    if ((this.a.jdField_b_of_type_Boolean) && (localmfu.jdField_a_of_type_AndroidWidgetTextView != null) && (localmfu.d != null))
    {
      float f = MultiMembersVideoUI.a(this.a).getDisplayMetrics().density;
      localmfu.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      int i = (int)(f * 1.5D);
      localmfu.d.setPadding(i, i, i, i);
    }
    if (localmfu.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (this.a.jdField_a_of_type_Boolean) {
        localmfu.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131166047));
      }
    }
    else if (localmfu.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      paramView = (RelativeLayout.LayoutParams)localmfu.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      if (!this.a.jdField_a_of_type_Boolean) {
        break label312;
      }
      paramView.width = this.a.getResources().getDimensionPixelSize(2131297821);
    }
    for (paramView.height = this.a.getResources().getDimensionPixelSize(2131297820);; paramView.height = this.a.getResources().getDimensionPixelSize(2131297825))
    {
      localmfu.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramView);
      return localmfu;
      localmfu.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131166047));
      break;
      label312:
      paramView.width = this.a.getResources().getDimensionPixelSize(2131297827);
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
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559781, null);
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
      mfv localmfv = (mfv)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      Object localObject2;
      if ((localmfv.jdField_a_of_type_JavaLangString == null) || (localmfv.jdField_a_of_type_AndroidGraphicsBitmap == null) || (!localmfv.d))
      {
        if (localmfv.jdField_b_of_type_Int != 0) {
          break label473;
        }
        localObject2 = String.valueOf(localmfv.jdField_a_of_type_Long);
        localmfv.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
        if (localmfv.jdField_a_of_type_JavaLangString.compareTo((String)localObject2) == 0) {
          break label449;
        }
        localmfv.d = true;
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int, false, true);
        if (localObject2 == null) {
          break label458;
        }
        localmfv.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
      }
      for (;;)
      {
        if (((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 2)) || (paramInt != 7) || (this.a.jdField_a_of_type_JavaUtilArrayList.size() <= 8)) {
          break label724;
        }
        ((mfu)localObject1).jdField_b_of_type_Boolean = false;
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(1);
        ((GradientDrawable)localObject2).setColor(Color.parseColor("#4C000000"));
        ((mfu)localObject1).d.setImageDrawable((Drawable)localObject2);
        ((mfu)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373525));
        localObject2 = new StringBuilder("");
        ((StringBuilder)localObject2).append(this.a.jdField_a_of_type_JavaUtilArrayList.size() - 8 + 1);
        ((StringBuilder)localObject2).append("+");
        ((mfu)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject2).toString());
        ((mfu)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        ((mfu)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        ((mfu)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("");
        paramView.setContentDescription(MultiMembersVideoUI.d(this.a).getString(2131693003));
        localObject1 = paramView;
        break;
        localObject1 = (mfu)paramView.getTag();
        if (localObject1 != null) {
          break label1269;
        }
        localObject1 = a(paramView);
        break label67;
        localmfv.d = false;
        break label178;
        localmfv.jdField_a_of_type_AndroidGraphicsBitmap = null;
        localmfv.d = false;
      }
      long l = localmfv.jdField_a_of_type_Long;
      if (localmfv.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null)
      {
        localObject2 = localmfv.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        if ((localObject2 == null) || (((AVPhoneUserInfo)localObject2).telInfo.mobile == null)) {
          break label655;
        }
        localmfv.jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject2).telInfo.mobile;
        String str = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject2).telInfo.mobile);
        if (str == null) {
          break label629;
        }
        localmfv.jdField_b_of_type_JavaLangString = ContactUtils.getHeaderText(str);
        localmfv.jdField_a_of_type_JavaLangString = str;
      }
      for (;;)
      {
        localmfv.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)MultiMembersVideoUI.c(this.a).getDrawable(2130842161)).getBitmap();
        localmfv.d = true;
        break;
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
        break label495;
        localmfv.jdField_b_of_type_JavaLangString = null;
        localmfv.jdField_a_of_type_JavaLangString = mtq.a(((AVPhoneUserInfo)localObject2).telInfo.mobile, 4);
        continue;
        if ((localObject2 != null) && (QLog.isColorLevel())) {
          QLog.d("MultiMembersVideoUI", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject2).toString());
        }
        localmfv.jdField_b_of_type_JavaLangString = null;
        localmfv.jdField_a_of_type_JavaLangString = MultiMembersVideoUI.b(this.a).getString(2131693004);
      }
      ((mfu)localObject1).jdField_b_of_type_Boolean = true;
      ((mfu)localObject1).jdField_a_of_type_Long = localmfv.jdField_a_of_type_Long;
      if (localmfv.jdField_a_of_type_JavaLangString != null)
      {
        ((mfu)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localmfv.jdField_a_of_type_JavaLangString);
        label761:
        if (localmfv.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          break label1147;
        }
        if ((localmfv.jdField_b_of_type_Int == 0) || (localmfv.jdField_b_of_type_JavaLangString == null)) {
          break label1121;
        }
        ((mfu)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        ((mfu)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(localmfv.jdField_b_of_type_JavaLangString);
        localObject2 = ((BitmapDrawable)MultiMembersVideoUI.e(this.a).getDrawable(2130842118)).getBitmap();
        ((mfu)localObject1).d.setImageBitmap((Bitmap)localObject2);
        if (((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 2))
        {
          if (!localmfv.e) {
            break label1171;
          }
          if (((mfu)localObject1).e.getVisibility() != 0) {
            ((mfu)localObject1).e.setVisibility(0);
          }
          if (((mfu)localObject1).jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
            ((mfu)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          localmfv.jdField_a_of_type_Boolean = false;
        }
        ((mfu)localObject1).jdField_a_of_type_Boolean = localmfv.jdField_a_of_type_Boolean;
        if (!((mfu)localObject1).jdField_a_of_type_Boolean) {
          break label1195;
        }
        ((mfu)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (localmfv.jdField_a_of_type_Int != 2) {
          break label1208;
        }
        ((mfu)localObject1).jdField_a_of_type_Int = 5;
      }
      for (;;)
      {
        if ((((mfu)localObject1).d != null) && (((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)) || ((this.a.jdField_a_of_type_Int == 2) && (!localmfv.f))))
        {
          localObject2 = ((mfu)localObject1).d.getDrawable();
          if ((localObject2 != null) && ((localObject2 instanceof BitmapDrawable)))
          {
            localObject2 = bheg.a(((BitmapDrawable)localObject2).getBitmap(), true);
            ((mfu)localObject1).d.setImageBitmap((Bitmap)localObject2);
          }
        }
        localObject1 = paramView;
        break;
        ((mfu)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localmfv.jdField_a_of_type_Long));
        break label761;
        ((mfu)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        ((mfu)localObject1).d.setImageBitmap(localmfv.jdField_a_of_type_AndroidGraphicsBitmap);
        break label838;
        label1147:
        ((mfu)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        ((mfu)localObject1).d.setImageResource(2130840348);
        break label838;
        if (((mfu)localObject1).e.getVisibility() != 0) {
          break label945;
        }
        ((mfu)localObject1).e.setVisibility(8);
        break label945;
        ((mfu)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label972;
        if (localmfv.c) {
          ((mfu)localObject1).jdField_a_of_type_Int = 3;
        } else if (localmfv.jdField_a_of_type_Int == 1) {
          ((mfu)localObject1).jdField_a_of_type_Int = 2;
        } else if (localmfv.jdField_b_of_type_Boolean) {
          ((mfu)localObject1).jdField_a_of_type_Int = 1;
        } else {
          ((mfu)localObject1).jdField_a_of_type_Int = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mfy
 * JD-Core Version:    0.7.0.1
 */