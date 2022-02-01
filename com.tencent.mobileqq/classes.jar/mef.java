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

class mef
  extends BaseAdapter
{
  private mef(meb parammeb) {}
  
  meg a(View paramView, boolean paramBoolean)
  {
    meg localmeg = new meg(this.a, null);
    localmeg.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373394));
    localmeg.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373410));
    localmeg.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373396));
    localmeg.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373383));
    localmeg.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373415));
    localmeg.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373412));
    if (!meb.a(this.a))
    {
      localmeg.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localmeg.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
      localmeg.jdField_b_of_type_AndroidWidgetImageView.setClickable(false);
    }
    localmeg.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.a.b);
    localmeg.jdField_c_of_type_Boolean = paramBoolean;
    if (meb.b(this.a))
    {
      paramView.setBackgroundColor(-16777216);
      localmeg.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
      localmeg.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#757575"));
      localmeg.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373414);
      localmeg.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(mvd.a(10.4F, (Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()));
      paramView.findViewById(2131363626).setBackgroundColor(Color.parseColor("#0F0F0F"));
    }
    return localmeg;
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
    mee localmee = (mee)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject1;
    Object localObject2;
    label167:
    Object localObject3;
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559709, null);
      localObject1 = a(paramView, localmee.e);
      paramView.setTag(localObject1);
      ((meg)localObject1).jdField_b_of_type_AndroidWidgetImageView.setTag(localmee);
      ((meg)localObject1).jdField_a_of_type_AndroidWidgetImageView.setTag(localmee);
      if ((localmee.jdField_a_of_type_JavaLangString == null) || (localmee.jdField_a_of_type_AndroidGraphicsBitmap == null) || (!localmee.jdField_b_of_type_Boolean))
      {
        if (localmee.jdField_a_of_type_Int != 0) {
          break label615;
        }
        localObject2 = String.valueOf(localmee.jdField_a_of_type_Long);
        localmee.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
        if (localmee.jdField_a_of_type_JavaLangString.compareTo((String)localObject2) == 0) {
          break label591;
        }
        localmee.jdField_b_of_type_Boolean = true;
        localObject3 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int, false, true);
        if (localmee.e)
        {
          localObject2 = localObject3;
          if (!meb.b(this.a)) {}
        }
        else
        {
          localObject2 = localObject3;
          if (localObject3 != null) {
            localObject2 = bhmq.a((Bitmap)localObject3, true);
          }
        }
        if (localObject2 == null) {
          break label600;
        }
        localmee.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
      }
      label251:
      ((meg)localObject1).jdField_b_of_type_Boolean = true;
      ((meg)localObject1).jdField_a_of_type_Long = localmee.jdField_a_of_type_Long;
      if (localmee.jdField_a_of_type_JavaLangString == null) {
        break label884;
      }
      float f = ((meg)localObject1).jdField_a_of_type_AndroidWidgetTextView.getResources().getDimensionPixelSize(2131297103);
      localObject2 = mvd.a(((meg)localObject1).jdField_a_of_type_AndroidWidgetTextView.getContext(), localmee.jdField_a_of_type_JavaLangString, ((meg)localObject1).jdField_a_of_type_AndroidWidgetTextView, f);
      ((meg)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      label326:
      if (localmee.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        break label952;
      }
      if ((localmee.jdField_a_of_type_Int == 0) || (localmee.jdField_b_of_type_JavaLangString == null)) {
        break label903;
      }
      ((meg)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      ((meg)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(localmee.jdField_b_of_type_JavaLangString);
      localObject2 = ((BitmapDrawable)((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130842062)).getBitmap();
      ((meg)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
      label411:
      if (!localmee.jdField_c_of_type_Boolean) {
        break label976;
      }
      if ((((meg)localObject1).jdField_a_of_type_Int == -1) || (((meg)localObject1).jdField_a_of_type_Int == 0))
      {
        this.a.a(((meg)localObject1).jdField_b_of_type_AndroidWidgetImageView, localmee.jdField_c_of_type_Boolean);
        ((meg)localObject1).jdField_a_of_type_Int = 1;
      }
      localmee.jdField_a_of_type_Boolean = false;
      label465:
      ((meg)localObject1).jdField_a_of_type_Boolean = localmee.jdField_a_of_type_Boolean;
      if (!((meg)localObject1).jdField_a_of_type_Boolean) {
        break label1020;
      }
      ((meg)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (((meg)localObject1).jdField_a_of_type_AndroidViewView != null) {
        ((meg)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      label509:
      if (localmee.e) {
        break label1051;
      }
      ((meg)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      ((meg)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject2 = (meg)paramView.getTag();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = a(paramView, localmee.e);
        paramView.setTag(localObject1);
      }
      break;
      label591:
      localmee.jdField_b_of_type_Boolean = false;
      break label167;
      label600:
      localmee.jdField_a_of_type_AndroidGraphicsBitmap = null;
      localmee.jdField_b_of_type_Boolean = false;
      break label251;
      label615:
      long l = localmee.jdField_a_of_type_Long;
      if (localmee.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null)
      {
        localObject2 = localmee.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        label637:
        if ((localObject2 == null) || (((AVPhoneUserInfo)localObject2).telInfo.mobile == null)) {
          break label806;
        }
        localmee.jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject2).telInfo.mobile;
        localObject3 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject2).telInfo.mobile);
        if (localObject3 == null) {
          break label780;
        }
        localmee.jdField_b_of_type_JavaLangString = bhlg.a((String)localObject3);
        localmee.jdField_a_of_type_JavaLangString = ((String)localObject3);
      }
      for (;;)
      {
        localmee.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130842105)).getBitmap();
        localmee.jdField_b_of_type_Boolean = true;
        break;
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
        break label637;
        label780:
        localmee.jdField_b_of_type_JavaLangString = null;
        localmee.jdField_a_of_type_JavaLangString = mtk.a(((AVPhoneUserInfo)localObject2).telInfo.mobile, 4);
        continue;
        label806:
        if ((localObject2 != null) && (QLog.isColorLevel())) {
          QLog.d("GAudioMemberListCtrl", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject2).toString());
        }
        localmee.jdField_b_of_type_JavaLangString = null;
        localmee.jdField_a_of_type_JavaLangString = ((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131692847);
      }
      label884:
      ((meg)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localmee.jdField_a_of_type_Long));
      break label326;
      label903:
      ((meg)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      ((meg)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localmee.jdField_a_of_type_AndroidGraphicsBitmap);
      if (localmee.jdField_a_of_type_Int != 0) {
        break label411;
      }
      ((meg)localObject1).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
      break label411;
      label952:
      ((meg)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      ((meg)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840274);
      break label411;
      label976:
      if ((((meg)localObject1).jdField_a_of_type_Int != -1) && (((meg)localObject1).jdField_a_of_type_Int != 1)) {
        break label465;
      }
      this.a.a(((meg)localObject1).jdField_b_of_type_AndroidWidgetImageView, localmee.jdField_c_of_type_Boolean);
      ((meg)localObject1).jdField_a_of_type_Int = 0;
      break label465;
      label1020:
      ((meg)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      if (((meg)localObject1).jdField_a_of_type_AndroidViewView == null) {
        break label509;
      }
      ((meg)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label509;
      label1051:
      if (meb.a(this.a)) {
        ((meg)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      ((meg)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mef
 * JD-Core Version:    0.7.0.1
 */