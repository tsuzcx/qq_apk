import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class mdj
  extends BaseAdapter
{
  private mdj(mdf parammdf) {}
  
  mdk a(View paramView, boolean paramBoolean)
  {
    mdk localmdk = new mdk(this.a, null);
    localmdk.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373271));
    localmdk.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373287));
    localmdk.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373273));
    localmdk.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373260));
    localmdk.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373292));
    localmdk.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373289));
    if (!mdf.a(this.a))
    {
      localmdk.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localmdk.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
      localmdk.jdField_b_of_type_AndroidWidgetImageView.setClickable(false);
    }
    localmdk.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.a.b);
    localmdk.jdField_c_of_type_Boolean = paramBoolean;
    if (mdf.b(this.a))
    {
      paramView.setBackgroundColor(-16777216);
      localmdk.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
      localmdk.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#757575"));
      localmdk.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373291);
      localmdk.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(mue.a(10.4F, (Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()));
      paramView.findViewById(2131363602).setBackgroundColor(Color.parseColor("#0F0F0F"));
    }
    return localmdk;
  }
  
  public int getCount()
  {
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
    mdi localmdi = (mdi)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject1;
    Object localObject2;
    label167:
    Object localObject3;
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559703, null);
      localObject1 = a(paramView, localmdi.e);
      paramView.setTag(localObject1);
      ((mdk)localObject1).jdField_b_of_type_AndroidWidgetImageView.setTag(localmdi);
      ((mdk)localObject1).jdField_a_of_type_AndroidWidgetImageView.setTag(localmdi);
      if ((localmdi.jdField_a_of_type_JavaLangString == null) || (localmdi.jdField_a_of_type_AndroidGraphicsBitmap == null) || (!localmdi.jdField_b_of_type_Boolean))
      {
        if (localmdi.jdField_a_of_type_Int != 0) {
          break label615;
        }
        localObject2 = String.valueOf(localmdi.jdField_a_of_type_Long);
        localmdi.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
        if (localmdi.jdField_a_of_type_JavaLangString.compareTo((String)localObject2) == 0) {
          break label591;
        }
        localmdi.jdField_b_of_type_Boolean = true;
        localObject3 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int, false, true);
        if (localmdi.e)
        {
          localObject2 = localObject3;
          if (!mdf.b(this.a)) {}
        }
        else
        {
          localObject2 = localObject3;
          if (localObject3 != null) {
            localObject2 = bgmo.a((Bitmap)localObject3, true);
          }
        }
        if (localObject2 == null) {
          break label600;
        }
        localmdi.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
      }
      label251:
      ((mdk)localObject1).jdField_b_of_type_Boolean = true;
      ((mdk)localObject1).jdField_a_of_type_Long = localmdi.jdField_a_of_type_Long;
      if (localmdi.jdField_a_of_type_JavaLangString == null) {
        break label884;
      }
      float f = ((mdk)localObject1).jdField_a_of_type_AndroidWidgetTextView.getResources().getDimensionPixelSize(2131297091);
      localObject2 = mue.a(((mdk)localObject1).jdField_a_of_type_AndroidWidgetTextView.getContext(), localmdi.jdField_a_of_type_JavaLangString, ((mdk)localObject1).jdField_a_of_type_AndroidWidgetTextView, f);
      ((mdk)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      label326:
      if (localmdi.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        break label952;
      }
      if ((localmdi.jdField_a_of_type_Int == 0) || (localmdi.jdField_b_of_type_JavaLangString == null)) {
        break label903;
      }
      ((mdk)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      ((mdk)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(localmdi.jdField_b_of_type_JavaLangString);
      localObject2 = ((BitmapDrawable)((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130842050)).getBitmap();
      ((mdk)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
      label411:
      if (!localmdi.jdField_c_of_type_Boolean) {
        break label976;
      }
      if ((((mdk)localObject1).jdField_a_of_type_Int == -1) || (((mdk)localObject1).jdField_a_of_type_Int == 0))
      {
        this.a.a(((mdk)localObject1).jdField_b_of_type_AndroidWidgetImageView, localmdi.jdField_c_of_type_Boolean);
        ((mdk)localObject1).jdField_a_of_type_Int = 1;
      }
      localmdi.jdField_a_of_type_Boolean = false;
      label465:
      ((mdk)localObject1).jdField_a_of_type_Boolean = localmdi.jdField_a_of_type_Boolean;
      if (!((mdk)localObject1).jdField_a_of_type_Boolean) {
        break label1020;
      }
      ((mdk)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (((mdk)localObject1).jdField_a_of_type_AndroidViewView != null) {
        ((mdk)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      label509:
      if (localmdi.e) {
        break label1051;
      }
      ((mdk)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      ((mdk)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject2 = (mdk)paramView.getTag();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = a(paramView, localmdi.e);
        paramView.setTag(localObject1);
      }
      break;
      label591:
      localmdi.jdField_b_of_type_Boolean = false;
      break label167;
      label600:
      localmdi.jdField_a_of_type_AndroidGraphicsBitmap = null;
      localmdi.jdField_b_of_type_Boolean = false;
      break label251;
      label615:
      long l = localmdi.jdField_a_of_type_Long;
      if (localmdi.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null)
      {
        localObject2 = localmdi.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        label637:
        if ((localObject2 == null) || (((AVPhoneUserInfo)localObject2).telInfo.mobile == null)) {
          break label806;
        }
        localmdi.jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject2).telInfo.mobile;
        localObject3 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject2).telInfo.mobile);
        if (localObject3 == null) {
          break label780;
        }
        localmdi.jdField_b_of_type_JavaLangString = bglf.a((String)localObject3);
        localmdi.jdField_a_of_type_JavaLangString = ((String)localObject3);
      }
      for (;;)
      {
        localmdi.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130842093)).getBitmap();
        localmdi.jdField_b_of_type_Boolean = true;
        break;
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
        break label637;
        label780:
        localmdi.jdField_b_of_type_JavaLangString = null;
        localmdi.jdField_a_of_type_JavaLangString = msm.a(((AVPhoneUserInfo)localObject2).telInfo.mobile, 4);
        continue;
        label806:
        if ((localObject2 != null) && (QLog.isColorLevel())) {
          QLog.d("GAudioMemberListCtrl", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject2).toString());
        }
        localmdi.jdField_b_of_type_JavaLangString = null;
        localmdi.jdField_a_of_type_JavaLangString = ((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131692839);
      }
      label884:
      ((mdk)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localmdi.jdField_a_of_type_Long));
      break label326;
      label903:
      ((mdk)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      ((mdk)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localmdi.jdField_a_of_type_AndroidGraphicsBitmap);
      if (localmdi.jdField_a_of_type_Int != 0) {
        break label411;
      }
      ((mdk)localObject1).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
      break label411;
      label952:
      ((mdk)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      ((mdk)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840264);
      break label411;
      label976:
      if ((((mdk)localObject1).jdField_a_of_type_Int != -1) && (((mdk)localObject1).jdField_a_of_type_Int != 1)) {
        break label465;
      }
      this.a.a(((mdk)localObject1).jdField_b_of_type_AndroidWidgetImageView, localmdi.jdField_c_of_type_Boolean);
      ((mdk)localObject1).jdField_a_of_type_Int = 0;
      break label465;
      label1020:
      ((mdk)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      if (((mdk)localObject1).jdField_a_of_type_AndroidViewView == null) {
        break label509;
      }
      ((mdk)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label509;
      label1051:
      if (mdf.a(this.a)) {
        ((mdk)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      ((mdk)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mdj
 * JD-Core Version:    0.7.0.1
 */