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

public class mft
  extends BaseAdapter
{
  public mft(MultiMembersVideoUI paramMultiMembersVideoUI) {}
  
  mfp a(View paramView)
  {
    mfp localmfp = new mfp();
    localmfp.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131373397));
    localmfp.d = ((ImageView)paramView.findViewById(2131373394));
    localmfp.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373410));
    localmfp.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373412));
    localmfp.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373396));
    localmfp.e = ((ImageView)paramView.findViewById(2131373409));
    localmfp.f = ((ImageView)paramView.findViewById(2131373395));
    if ((this.a.jdField_b_of_type_Boolean) && (localmfp.jdField_a_of_type_AndroidWidgetTextView != null) && (localmfp.d != null))
    {
      float f = MultiMembersVideoUI.a(this.a).getDisplayMetrics().density;
      localmfp.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      int i = (int)(f * 1.5D);
      localmfp.d.setPadding(i, i, i, i);
    }
    if (localmfp.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (this.a.jdField_a_of_type_Boolean) {
        localmfp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131166020));
      }
    }
    else if (localmfp.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      paramView = (RelativeLayout.LayoutParams)localmfp.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      if (!this.a.jdField_a_of_type_Boolean) {
        break label312;
      }
      paramView.width = this.a.getResources().getDimensionPixelSize(2131297765);
    }
    for (paramView.height = this.a.getResources().getDimensionPixelSize(2131297764);; paramView.height = this.a.getResources().getDimensionPixelSize(2131297769))
    {
      localmfp.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramView);
      return localmfp;
      localmfp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131166020));
      break;
      label312:
      paramView.width = this.a.getResources().getDimensionPixelSize(2131297771);
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
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559743, null);
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
      mfq localmfq = (mfq)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      Object localObject2;
      if ((localmfq.jdField_a_of_type_JavaLangString == null) || (localmfq.jdField_a_of_type_AndroidGraphicsBitmap == null) || (!localmfq.d))
      {
        if (localmfq.jdField_b_of_type_Int != 0) {
          break label473;
        }
        localObject2 = String.valueOf(localmfq.jdField_a_of_type_Long);
        localmfq.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
        if (localmfq.jdField_a_of_type_JavaLangString.compareTo((String)localObject2) == 0) {
          break label449;
        }
        localmfq.d = true;
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int, false, true);
        if (localObject2 == null) {
          break label458;
        }
        localmfq.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
      }
      for (;;)
      {
        if (((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 2)) || (paramInt != 7) || (this.a.jdField_a_of_type_JavaUtilArrayList.size() <= 8)) {
          break label724;
        }
        ((mfp)localObject1).jdField_b_of_type_Boolean = false;
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(1);
        ((GradientDrawable)localObject2).setColor(Color.parseColor("#4C000000"));
        ((mfp)localObject1).d.setImageDrawable((Drawable)localObject2);
        ((mfp)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373396));
        localObject2 = new StringBuilder("");
        ((StringBuilder)localObject2).append(this.a.jdField_a_of_type_JavaUtilArrayList.size() - 8 + 1);
        ((StringBuilder)localObject2).append("+");
        ((mfp)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject2).toString());
        ((mfp)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        ((mfp)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        ((mfp)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("");
        paramView.setContentDescription(MultiMembersVideoUI.d(this.a).getString(2131692846));
        localObject1 = paramView;
        break;
        localObject1 = (mfp)paramView.getTag();
        if (localObject1 != null) {
          break label1269;
        }
        localObject1 = a(paramView);
        break label67;
        localmfq.d = false;
        break label178;
        localmfq.jdField_a_of_type_AndroidGraphicsBitmap = null;
        localmfq.d = false;
      }
      long l = localmfq.jdField_a_of_type_Long;
      if (localmfq.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null)
      {
        localObject2 = localmfq.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        if ((localObject2 == null) || (((AVPhoneUserInfo)localObject2).telInfo.mobile == null)) {
          break label655;
        }
        localmfq.jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject2).telInfo.mobile;
        String str = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject2).telInfo.mobile);
        if (str == null) {
          break label629;
        }
        localmfq.jdField_b_of_type_JavaLangString = bhlg.a(str);
        localmfq.jdField_a_of_type_JavaLangString = str;
      }
      for (;;)
      {
        localmfq.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)MultiMembersVideoUI.c(this.a).getDrawable(2130842105)).getBitmap();
        localmfq.d = true;
        break;
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
        break label495;
        localmfq.jdField_b_of_type_JavaLangString = null;
        localmfq.jdField_a_of_type_JavaLangString = mtk.a(((AVPhoneUserInfo)localObject2).telInfo.mobile, 4);
        continue;
        if ((localObject2 != null) && (QLog.isColorLevel())) {
          QLog.d("MultiMembersVideoUI", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject2).toString());
        }
        localmfq.jdField_b_of_type_JavaLangString = null;
        localmfq.jdField_a_of_type_JavaLangString = MultiMembersVideoUI.b(this.a).getString(2131692847);
      }
      ((mfp)localObject1).jdField_b_of_type_Boolean = true;
      ((mfp)localObject1).jdField_a_of_type_Long = localmfq.jdField_a_of_type_Long;
      if (localmfq.jdField_a_of_type_JavaLangString != null)
      {
        ((mfp)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localmfq.jdField_a_of_type_JavaLangString);
        label761:
        if (localmfq.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          break label1147;
        }
        if ((localmfq.jdField_b_of_type_Int == 0) || (localmfq.jdField_b_of_type_JavaLangString == null)) {
          break label1121;
        }
        ((mfp)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        ((mfp)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(localmfq.jdField_b_of_type_JavaLangString);
        localObject2 = ((BitmapDrawable)MultiMembersVideoUI.e(this.a).getDrawable(2130842062)).getBitmap();
        ((mfp)localObject1).d.setImageBitmap((Bitmap)localObject2);
        if (((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 2))
        {
          if (!localmfq.e) {
            break label1171;
          }
          if (((mfp)localObject1).e.getVisibility() != 0) {
            ((mfp)localObject1).e.setVisibility(0);
          }
          if (((mfp)localObject1).jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
            ((mfp)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          localmfq.jdField_a_of_type_Boolean = false;
        }
        ((mfp)localObject1).jdField_a_of_type_Boolean = localmfq.jdField_a_of_type_Boolean;
        if (!((mfp)localObject1).jdField_a_of_type_Boolean) {
          break label1195;
        }
        ((mfp)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (localmfq.jdField_a_of_type_Int != 2) {
          break label1208;
        }
        ((mfp)localObject1).jdField_a_of_type_Int = 5;
      }
      for (;;)
      {
        if ((((mfp)localObject1).d != null) && (((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)) || ((this.a.jdField_a_of_type_Int == 2) && (!localmfq.f))))
        {
          localObject2 = ((mfp)localObject1).d.getDrawable();
          if ((localObject2 != null) && ((localObject2 instanceof BitmapDrawable)))
          {
            localObject2 = bhmq.a(((BitmapDrawable)localObject2).getBitmap(), true);
            ((mfp)localObject1).d.setImageBitmap((Bitmap)localObject2);
          }
        }
        localObject1 = paramView;
        break;
        ((mfp)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localmfq.jdField_a_of_type_Long));
        break label761;
        ((mfp)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        ((mfp)localObject1).d.setImageBitmap(localmfq.jdField_a_of_type_AndroidGraphicsBitmap);
        break label838;
        label1147:
        ((mfp)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        ((mfp)localObject1).d.setImageResource(2130840274);
        break label838;
        if (((mfp)localObject1).e.getVisibility() != 0) {
          break label945;
        }
        ((mfp)localObject1).e.setVisibility(8);
        break label945;
        ((mfp)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label972;
        if (localmfq.c) {
          ((mfp)localObject1).jdField_a_of_type_Int = 3;
        } else if (localmfq.jdField_a_of_type_Int == 1) {
          ((mfp)localObject1).jdField_a_of_type_Int = 2;
        } else if (localmfq.jdField_b_of_type_Boolean) {
          ((mfp)localObject1).jdField_a_of_type_Int = 1;
        } else {
          ((mfp)localObject1).jdField_a_of_type_Int = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mft
 * JD-Core Version:    0.7.0.1
 */