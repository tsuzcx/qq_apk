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
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class mek
  extends BaseAdapter
{
  private mek(meg parammeg) {}
  
  mel a(View paramView, boolean paramBoolean)
  {
    mel localmel = new mel(this.a, null);
    localmel.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373523));
    localmel.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373539));
    localmel.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373525));
    localmel.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373512));
    localmel.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373544));
    localmel.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373541));
    if (!meg.a(this.a))
    {
      localmel.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localmel.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
      localmel.jdField_b_of_type_AndroidWidgetImageView.setClickable(false);
    }
    localmel.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.a.b);
    localmel.jdField_c_of_type_Boolean = paramBoolean;
    if (meg.b(this.a))
    {
      paramView.setBackgroundColor(-16777216);
      localmel.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
      localmel.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#757575"));
      localmel.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373543);
      localmel.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(mvk.a(10.4F, (Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()));
      paramView.findViewById(2131363727).setBackgroundColor(Color.parseColor("#0F0F0F"));
    }
    return localmel;
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
    mej localmej = (mej)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject1;
    Object localObject2;
    label167:
    Object localObject3;
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559747, null);
      localObject1 = a(paramView, localmej.e);
      paramView.setTag(localObject1);
      ((mel)localObject1).jdField_b_of_type_AndroidWidgetImageView.setTag(localmej);
      ((mel)localObject1).jdField_a_of_type_AndroidWidgetImageView.setTag(localmej);
      if ((localmej.jdField_a_of_type_JavaLangString == null) || (localmej.jdField_a_of_type_AndroidGraphicsBitmap == null) || (!localmej.jdField_b_of_type_Boolean))
      {
        if (localmej.jdField_a_of_type_Int != 0) {
          break label615;
        }
        localObject2 = String.valueOf(localmej.jdField_a_of_type_Long);
        localmej.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
        if (localmej.jdField_a_of_type_JavaLangString.compareTo((String)localObject2) == 0) {
          break label591;
        }
        localmej.jdField_b_of_type_Boolean = true;
        localObject3 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int, false, true);
        if (localmej.e)
        {
          localObject2 = localObject3;
          if (!meg.b(this.a)) {}
        }
        else
        {
          localObject2 = localObject3;
          if (localObject3 != null) {
            localObject2 = bheg.a((Bitmap)localObject3, true);
          }
        }
        if (localObject2 == null) {
          break label600;
        }
        localmej.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
      }
      label251:
      ((mel)localObject1).jdField_b_of_type_Boolean = true;
      ((mel)localObject1).jdField_a_of_type_Long = localmej.jdField_a_of_type_Long;
      if (localmej.jdField_a_of_type_JavaLangString == null) {
        break label884;
      }
      float f = ((mel)localObject1).jdField_a_of_type_AndroidWidgetTextView.getResources().getDimensionPixelSize(2131297159);
      localObject2 = mvk.a(((mel)localObject1).jdField_a_of_type_AndroidWidgetTextView.getContext(), localmej.jdField_a_of_type_JavaLangString, ((mel)localObject1).jdField_a_of_type_AndroidWidgetTextView, f);
      ((mel)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      label326:
      if (localmej.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        break label952;
      }
      if ((localmej.jdField_a_of_type_Int == 0) || (localmej.jdField_b_of_type_JavaLangString == null)) {
        break label903;
      }
      ((mel)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      ((mel)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(localmej.jdField_b_of_type_JavaLangString);
      localObject2 = ((BitmapDrawable)((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130842118)).getBitmap();
      ((mel)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
      label411:
      if (!localmej.jdField_c_of_type_Boolean) {
        break label976;
      }
      if ((((mel)localObject1).jdField_a_of_type_Int == -1) || (((mel)localObject1).jdField_a_of_type_Int == 0))
      {
        this.a.a(((mel)localObject1).jdField_b_of_type_AndroidWidgetImageView, localmej.jdField_c_of_type_Boolean);
        ((mel)localObject1).jdField_a_of_type_Int = 1;
      }
      localmej.jdField_a_of_type_Boolean = false;
      label465:
      ((mel)localObject1).jdField_a_of_type_Boolean = localmej.jdField_a_of_type_Boolean;
      if (!((mel)localObject1).jdField_a_of_type_Boolean) {
        break label1020;
      }
      ((mel)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (((mel)localObject1).jdField_a_of_type_AndroidViewView != null) {
        ((mel)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      label509:
      if (localmej.e) {
        break label1051;
      }
      ((mel)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      ((mel)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject2 = (mel)paramView.getTag();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = a(paramView, localmej.e);
        paramView.setTag(localObject1);
      }
      break;
      label591:
      localmej.jdField_b_of_type_Boolean = false;
      break label167;
      label600:
      localmej.jdField_a_of_type_AndroidGraphicsBitmap = null;
      localmej.jdField_b_of_type_Boolean = false;
      break label251;
      label615:
      long l = localmej.jdField_a_of_type_Long;
      if (localmej.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null)
      {
        localObject2 = localmej.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        label637:
        if ((localObject2 == null) || (((AVPhoneUserInfo)localObject2).telInfo.mobile == null)) {
          break label806;
        }
        localmej.jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject2).telInfo.mobile;
        localObject3 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject2).telInfo.mobile);
        if (localObject3 == null) {
          break label780;
        }
        localmej.jdField_b_of_type_JavaLangString = ContactUtils.getHeaderText((String)localObject3);
        localmej.jdField_a_of_type_JavaLangString = ((String)localObject3);
      }
      for (;;)
      {
        localmej.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130842161)).getBitmap();
        localmej.jdField_b_of_type_Boolean = true;
        break;
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
        break label637;
        label780:
        localmej.jdField_b_of_type_JavaLangString = null;
        localmej.jdField_a_of_type_JavaLangString = mtq.a(((AVPhoneUserInfo)localObject2).telInfo.mobile, 4);
        continue;
        label806:
        if ((localObject2 != null) && (QLog.isColorLevel())) {
          QLog.d("GAudioMemberListCtrl", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject2).toString());
        }
        localmej.jdField_b_of_type_JavaLangString = null;
        localmej.jdField_a_of_type_JavaLangString = ((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131693004);
      }
      label884:
      ((mel)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localmej.jdField_a_of_type_Long));
      break label326;
      label903:
      ((mel)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      ((mel)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localmej.jdField_a_of_type_AndroidGraphicsBitmap);
      if (localmej.jdField_a_of_type_Int != 0) {
        break label411;
      }
      ((mel)localObject1).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
      break label411;
      label952:
      ((mel)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      ((mel)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840348);
      break label411;
      label976:
      if ((((mel)localObject1).jdField_a_of_type_Int != -1) && (((mel)localObject1).jdField_a_of_type_Int != 1)) {
        break label465;
      }
      this.a.a(((mel)localObject1).jdField_b_of_type_AndroidWidgetImageView, localmej.jdField_c_of_type_Boolean);
      ((mel)localObject1).jdField_a_of_type_Int = 0;
      break label465;
      label1020:
      ((mel)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      if (((mel)localObject1).jdField_a_of_type_AndroidViewView == null) {
        break label509;
      }
      ((mel)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label509;
      label1051:
      if (meg.a(this.a)) {
        ((mel)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      ((mel)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mek
 * JD-Core Version:    0.7.0.1
 */