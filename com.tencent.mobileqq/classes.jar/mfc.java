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

public class mfc
  extends BaseAdapter
{
  public mfc(MultiMembersVideoUI paramMultiMembersVideoUI) {}
  
  mey a(View paramView)
  {
    mey localmey = new mey();
    localmey.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131373313));
    localmey.d = ((ImageView)paramView.findViewById(2131373310));
    localmey.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373326));
    localmey.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373328));
    localmey.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373312));
    localmey.e = ((ImageView)paramView.findViewById(2131373325));
    localmey.f = ((ImageView)paramView.findViewById(2131373311));
    if ((this.a.jdField_b_of_type_Boolean) && (localmey.jdField_a_of_type_AndroidWidgetTextView != null) && (localmey.d != null))
    {
      float f = MultiMembersVideoUI.a(this.a).getDisplayMetrics().density;
      localmey.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      int i = (int)(f * 1.5D);
      localmey.d.setPadding(i, i, i, i);
    }
    if (localmey.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (this.a.jdField_a_of_type_Boolean) {
        localmey.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131166038));
      }
    }
    else if (localmey.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      paramView = (RelativeLayout.LayoutParams)localmey.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      if (!this.a.jdField_a_of_type_Boolean) {
        break label312;
      }
      paramView.width = this.a.getResources().getDimensionPixelSize(2131297820);
    }
    for (paramView.height = this.a.getResources().getDimensionPixelSize(2131297819);; paramView.height = this.a.getResources().getDimensionPixelSize(2131297824))
    {
      localmey.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramView);
      return localmey;
      localmey.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131166038));
      break;
      label312:
      paramView.width = this.a.getResources().getDimensionPixelSize(2131297826);
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
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559745, null);
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
      mez localmez = (mez)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      Object localObject2;
      if ((localmez.jdField_a_of_type_JavaLangString == null) || (localmez.jdField_a_of_type_AndroidGraphicsBitmap == null) || (!localmez.d))
      {
        if (localmez.jdField_b_of_type_Int != 0) {
          break label473;
        }
        localObject2 = String.valueOf(localmez.jdField_a_of_type_Long);
        localmez.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
        if (localmez.jdField_a_of_type_JavaLangString.compareTo((String)localObject2) == 0) {
          break label449;
        }
        localmez.d = true;
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int, false, true);
        if (localObject2 == null) {
          break label458;
        }
        localmez.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
      }
      for (;;)
      {
        if (((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 2)) || (paramInt != 7) || (this.a.jdField_a_of_type_JavaUtilArrayList.size() <= 8)) {
          break label724;
        }
        ((mey)localObject1).jdField_b_of_type_Boolean = false;
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(1);
        ((GradientDrawable)localObject2).setColor(Color.parseColor("#4C000000"));
        ((mey)localObject1).d.setImageDrawable((Drawable)localObject2);
        ((mey)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373312));
        localObject2 = new StringBuilder("");
        ((StringBuilder)localObject2).append(this.a.jdField_a_of_type_JavaUtilArrayList.size() - 8 + 1);
        ((StringBuilder)localObject2).append("+");
        ((mey)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject2).toString());
        ((mey)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        ((mey)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        ((mey)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("");
        paramView.setContentDescription(MultiMembersVideoUI.d(this.a).getString(2131692897));
        localObject1 = paramView;
        break;
        localObject1 = (mey)paramView.getTag();
        if (localObject1 != null) {
          break label1269;
        }
        localObject1 = a(paramView);
        break label67;
        localmez.d = false;
        break label178;
        localmez.jdField_a_of_type_AndroidGraphicsBitmap = null;
        localmez.d = false;
      }
      long l = localmez.jdField_a_of_type_Long;
      if (localmez.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null)
      {
        localObject2 = localmez.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        if ((localObject2 == null) || (((AVPhoneUserInfo)localObject2).telInfo.mobile == null)) {
          break label655;
        }
        localmez.jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject2).telInfo.mobile;
        String str = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject2).telInfo.mobile);
        if (str == null) {
          break label629;
        }
        localmez.jdField_b_of_type_JavaLangString = ContactUtils.getHeaderText(str);
        localmez.jdField_a_of_type_JavaLangString = str;
      }
      for (;;)
      {
        localmez.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)MultiMembersVideoUI.c(this.a).getDrawable(2130842147)).getBitmap();
        localmez.d = true;
        break;
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
        break label495;
        localmez.jdField_b_of_type_JavaLangString = null;
        localmez.jdField_a_of_type_JavaLangString = mst.a(((AVPhoneUserInfo)localObject2).telInfo.mobile, 4);
        continue;
        if ((localObject2 != null) && (QLog.isColorLevel())) {
          QLog.d("MultiMembersVideoUI", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject2).toString());
        }
        localmez.jdField_b_of_type_JavaLangString = null;
        localmez.jdField_a_of_type_JavaLangString = MultiMembersVideoUI.b(this.a).getString(2131692898);
      }
      ((mey)localObject1).jdField_b_of_type_Boolean = true;
      ((mey)localObject1).jdField_a_of_type_Long = localmez.jdField_a_of_type_Long;
      if (localmez.jdField_a_of_type_JavaLangString != null)
      {
        ((mey)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localmez.jdField_a_of_type_JavaLangString);
        label761:
        if (localmez.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          break label1147;
        }
        if ((localmez.jdField_b_of_type_Int == 0) || (localmez.jdField_b_of_type_JavaLangString == null)) {
          break label1121;
        }
        ((mey)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        ((mey)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(localmez.jdField_b_of_type_JavaLangString);
        localObject2 = ((BitmapDrawable)MultiMembersVideoUI.e(this.a).getDrawable(2130842104)).getBitmap();
        ((mey)localObject1).d.setImageBitmap((Bitmap)localObject2);
        if (((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 2))
        {
          if (!localmez.e) {
            break label1171;
          }
          if (((mey)localObject1).e.getVisibility() != 0) {
            ((mey)localObject1).e.setVisibility(0);
          }
          if (((mey)localObject1).jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
            ((mey)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          localmez.jdField_a_of_type_Boolean = false;
        }
        ((mey)localObject1).jdField_a_of_type_Boolean = localmez.jdField_a_of_type_Boolean;
        if (!((mey)localObject1).jdField_a_of_type_Boolean) {
          break label1195;
        }
        ((mey)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (localmez.jdField_a_of_type_Int != 2) {
          break label1208;
        }
        ((mey)localObject1).jdField_a_of_type_Int = 5;
      }
      for (;;)
      {
        if ((((mey)localObject1).d != null) && (((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)) || ((this.a.jdField_a_of_type_Int == 2) && (!localmez.f))))
        {
          localObject2 = ((mey)localObject1).d.getDrawable();
          if ((localObject2 != null) && ((localObject2 instanceof BitmapDrawable)))
          {
            localObject2 = bfvo.a(((BitmapDrawable)localObject2).getBitmap(), true);
            ((mey)localObject1).d.setImageBitmap((Bitmap)localObject2);
          }
        }
        localObject1 = paramView;
        break;
        ((mey)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localmez.jdField_a_of_type_Long));
        break label761;
        ((mey)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        ((mey)localObject1).d.setImageBitmap(localmez.jdField_a_of_type_AndroidGraphicsBitmap);
        break label838;
        label1147:
        ((mey)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        ((mey)localObject1).d.setImageResource(2130840312);
        break label838;
        if (((mey)localObject1).e.getVisibility() != 0) {
          break label945;
        }
        ((mey)localObject1).e.setVisibility(8);
        break label945;
        ((mey)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label972;
        if (localmez.c) {
          ((mey)localObject1).jdField_a_of_type_Int = 3;
        } else if (localmez.jdField_a_of_type_Int == 1) {
          ((mey)localObject1).jdField_a_of_type_Int = 2;
        } else if (localmez.jdField_b_of_type_Boolean) {
          ((mey)localObject1).jdField_a_of_type_Int = 1;
        } else {
          ((mey)localObject1).jdField_a_of_type_Int = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mfc
 * JD-Core Version:    0.7.0.1
 */