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

class mdo
  extends BaseAdapter
{
  private mdo(mdk parammdk) {}
  
  mdp a(View paramView, boolean paramBoolean)
  {
    mdp localmdp = new mdp(this.a, null);
    localmdp.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373310));
    localmdp.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373326));
    localmdp.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373312));
    localmdp.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373299));
    localmdp.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373331));
    localmdp.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373328));
    if (!mdk.a(this.a))
    {
      localmdp.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localmdp.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
      localmdp.jdField_b_of_type_AndroidWidgetImageView.setClickable(false);
    }
    localmdp.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.a.b);
    localmdp.jdField_c_of_type_Boolean = paramBoolean;
    if (mdk.b(this.a))
    {
      paramView.setBackgroundColor(-16777216);
      localmdp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
      localmdp.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#757575"));
      localmdp.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373330);
      localmdp.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(mum.a(10.4F, (Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()));
      paramView.findViewById(2131363658).setBackgroundColor(Color.parseColor("#0F0F0F"));
    }
    return localmdp;
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
    mdn localmdn = (mdn)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject1;
    Object localObject2;
    label167:
    Object localObject3;
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559711, null);
      localObject1 = a(paramView, localmdn.e);
      paramView.setTag(localObject1);
      ((mdp)localObject1).jdField_b_of_type_AndroidWidgetImageView.setTag(localmdn);
      ((mdp)localObject1).jdField_a_of_type_AndroidWidgetImageView.setTag(localmdn);
      if ((localmdn.jdField_a_of_type_JavaLangString == null) || (localmdn.jdField_a_of_type_AndroidGraphicsBitmap == null) || (!localmdn.jdField_b_of_type_Boolean))
      {
        if (localmdn.jdField_a_of_type_Int != 0) {
          break label615;
        }
        localObject2 = String.valueOf(localmdn.jdField_a_of_type_Long);
        localmdn.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
        if (localmdn.jdField_a_of_type_JavaLangString.compareTo((String)localObject2) == 0) {
          break label591;
        }
        localmdn.jdField_b_of_type_Boolean = true;
        localObject3 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject2, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int, false, true);
        if (localmdn.e)
        {
          localObject2 = localObject3;
          if (!mdk.b(this.a)) {}
        }
        else
        {
          localObject2 = localObject3;
          if (localObject3 != null) {
            localObject2 = bfvo.a((Bitmap)localObject3, true);
          }
        }
        if (localObject2 == null) {
          break label600;
        }
        localmdn.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
      }
      label251:
      ((mdp)localObject1).jdField_b_of_type_Boolean = true;
      ((mdp)localObject1).jdField_a_of_type_Long = localmdn.jdField_a_of_type_Long;
      if (localmdn.jdField_a_of_type_JavaLangString == null) {
        break label884;
      }
      float f = ((mdp)localObject1).jdField_a_of_type_AndroidWidgetTextView.getResources().getDimensionPixelSize(2131297158);
      localObject2 = mum.a(((mdp)localObject1).jdField_a_of_type_AndroidWidgetTextView.getContext(), localmdn.jdField_a_of_type_JavaLangString, ((mdp)localObject1).jdField_a_of_type_AndroidWidgetTextView, f);
      ((mdp)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      label326:
      if (localmdn.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        break label952;
      }
      if ((localmdn.jdField_a_of_type_Int == 0) || (localmdn.jdField_b_of_type_JavaLangString == null)) {
        break label903;
      }
      ((mdp)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      ((mdp)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(localmdn.jdField_b_of_type_JavaLangString);
      localObject2 = ((BitmapDrawable)((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130842104)).getBitmap();
      ((mdp)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
      label411:
      if (!localmdn.jdField_c_of_type_Boolean) {
        break label976;
      }
      if ((((mdp)localObject1).jdField_a_of_type_Int == -1) || (((mdp)localObject1).jdField_a_of_type_Int == 0))
      {
        this.a.a(((mdp)localObject1).jdField_b_of_type_AndroidWidgetImageView, localmdn.jdField_c_of_type_Boolean);
        ((mdp)localObject1).jdField_a_of_type_Int = 1;
      }
      localmdn.jdField_a_of_type_Boolean = false;
      label465:
      ((mdp)localObject1).jdField_a_of_type_Boolean = localmdn.jdField_a_of_type_Boolean;
      if (!((mdp)localObject1).jdField_a_of_type_Boolean) {
        break label1020;
      }
      ((mdp)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (((mdp)localObject1).jdField_a_of_type_AndroidViewView != null) {
        ((mdp)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      label509:
      if (localmdn.e) {
        break label1051;
      }
      ((mdp)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      ((mdp)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject2 = (mdp)paramView.getTag();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = a(paramView, localmdn.e);
        paramView.setTag(localObject1);
      }
      break;
      label591:
      localmdn.jdField_b_of_type_Boolean = false;
      break label167;
      label600:
      localmdn.jdField_a_of_type_AndroidGraphicsBitmap = null;
      localmdn.jdField_b_of_type_Boolean = false;
      break label251;
      label615:
      long l = localmdn.jdField_a_of_type_Long;
      if (localmdn.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null)
      {
        localObject2 = localmdn.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        label637:
        if ((localObject2 == null) || (((AVPhoneUserInfo)localObject2).telInfo.mobile == null)) {
          break label806;
        }
        localmdn.jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject2).telInfo.mobile;
        localObject3 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject2).telInfo.mobile);
        if (localObject3 == null) {
          break label780;
        }
        localmdn.jdField_b_of_type_JavaLangString = ContactUtils.getHeaderText((String)localObject3);
        localmdn.jdField_a_of_type_JavaLangString = ((String)localObject3);
      }
      for (;;)
      {
        localmdn.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130842147)).getBitmap();
        localmdn.jdField_b_of_type_Boolean = true;
        break;
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
        break label637;
        label780:
        localmdn.jdField_b_of_type_JavaLangString = null;
        localmdn.jdField_a_of_type_JavaLangString = mst.a(((AVPhoneUserInfo)localObject2).telInfo.mobile, 4);
        continue;
        label806:
        if ((localObject2 != null) && (QLog.isColorLevel())) {
          QLog.d("GAudioMemberListCtrl", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject2).toString());
        }
        localmdn.jdField_b_of_type_JavaLangString = null;
        localmdn.jdField_a_of_type_JavaLangString = ((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131692898);
      }
      label884:
      ((mdp)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localmdn.jdField_a_of_type_Long));
      break label326;
      label903:
      ((mdp)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      ((mdp)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localmdn.jdField_a_of_type_AndroidGraphicsBitmap);
      if (localmdn.jdField_a_of_type_Int != 0) {
        break label411;
      }
      ((mdp)localObject1).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
      break label411;
      label952:
      ((mdp)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      ((mdp)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840312);
      break label411;
      label976:
      if ((((mdp)localObject1).jdField_a_of_type_Int != -1) && (((mdp)localObject1).jdField_a_of_type_Int != 1)) {
        break label465;
      }
      this.a.a(((mdp)localObject1).jdField_b_of_type_AndroidWidgetImageView, localmdn.jdField_c_of_type_Boolean);
      ((mdp)localObject1).jdField_a_of_type_Int = 0;
      break label465;
      label1020:
      ((mdp)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      if (((mdp)localObject1).jdField_a_of_type_AndroidViewView == null) {
        break label509;
      }
      ((mdp)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label509;
      label1051:
      if (mdk.a(this.a)) {
        ((mdp)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      ((mdp)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mdo
 * JD-Core Version:    0.7.0.1
 */