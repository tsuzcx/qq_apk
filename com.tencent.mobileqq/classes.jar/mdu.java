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
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class mdu
  extends BaseAdapter
{
  private mdu(mdq parammdq) {}
  
  mdv a(View paramView, boolean paramBoolean)
  {
    mdv localmdv = new mdv(this.a, null);
    localmdv.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372272));
    localmdv.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372288));
    localmdv.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372274));
    localmdv.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372261));
    localmdv.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372293));
    localmdv.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372290));
    if (!mdq.a(this.a))
    {
      localmdv.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localmdv.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
      localmdv.jdField_b_of_type_AndroidWidgetImageView.setClickable(false);
    }
    localmdv.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.a.b);
    localmdv.jdField_c_of_type_Boolean = paramBoolean;
    if (mdq.b(this.a))
    {
      paramView.setBackgroundColor(-16777216);
      localmdv.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
      localmdv.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#757575"));
      localmdv.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131372292);
      localmdv.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(muf.a(10.4F, (Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()));
      paramView.findViewById(2131363370).setBackgroundColor(Color.parseColor("#0F0F0F"));
    }
    return localmdv;
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
    mdt localmdt = (mdt)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject1;
    label163:
    Object localObject2;
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559515, null);
      paramViewGroup = a(paramView, localmdt.e);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setTag(localmdt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(localmdt);
      if ((localmdt.jdField_a_of_type_JavaLangString == null) || (localmdt.jdField_a_of_type_AndroidGraphicsBitmap == null) || (!localmdt.jdField_b_of_type_Boolean))
      {
        if (localmdt.jdField_a_of_type_Int != 0) {
          break label574;
        }
        localObject1 = String.valueOf(localmdt.jdField_a_of_type_Long);
        localmdt.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
        if (localmdt.jdField_a_of_type_JavaLangString.compareTo((String)localObject1) == 0) {
          break label550;
        }
        localmdt.jdField_b_of_type_Boolean = true;
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int, false, true);
        if (localmdt.e)
        {
          localObject1 = localObject2;
          if (!mdq.b(this.a)) {}
        }
        else
        {
          localObject1 = localObject2;
          if (localObject2 != null) {
            localObject1 = bbdr.a((Bitmap)localObject2, true);
          }
        }
        if (localObject1 == null) {
          break label559;
        }
        localmdt.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
      }
      label247:
      paramViewGroup.jdField_b_of_type_Boolean = true;
      paramViewGroup.jdField_a_of_type_Long = localmdt.jdField_a_of_type_Long;
      if (localmdt.jdField_a_of_type_JavaLangString == null) {
        break label843;
      }
      float f = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getResources().getDimensionPixelSize(2131297021);
      localObject1 = muf.a(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getContext(), localmdt.jdField_a_of_type_JavaLangString, paramViewGroup.jdField_a_of_type_AndroidWidgetTextView, f);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      label316:
      if (localmdt.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        break label907;
      }
      if ((localmdt.jdField_a_of_type_Int == 0) || (localmdt.jdField_b_of_type_JavaLangString == null)) {
        break label861;
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localmdt.jdField_b_of_type_JavaLangString);
      localObject1 = ((BitmapDrawable)((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130841580)).getBitmap();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
      label398:
      if (!localmdt.jdField_c_of_type_Boolean) {
        break label929;
      }
      if ((paramViewGroup.jdField_a_of_type_Int == -1) || (paramViewGroup.jdField_a_of_type_Int == 0))
      {
        this.a.a(paramViewGroup.jdField_b_of_type_AndroidWidgetImageView, localmdt.jdField_c_of_type_Boolean);
        paramViewGroup.jdField_a_of_type_Int = 1;
      }
      localmdt.jdField_a_of_type_Boolean = false;
      label448:
      paramViewGroup.jdField_a_of_type_Boolean = localmdt.jdField_a_of_type_Boolean;
      if (!paramViewGroup.jdField_a_of_type_Boolean) {
        break label969;
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramViewGroup.jdField_a_of_type_AndroidViewView != null) {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      if (localmdt.e) {
        break label997;
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return paramView;
      localObject1 = (mdv)paramView.getTag();
      paramViewGroup = (ViewGroup)localObject1;
      if (localObject1 == null)
      {
        paramViewGroup = a(paramView, localmdt.e);
        paramView.setTag(paramViewGroup);
      }
      break;
      label550:
      localmdt.jdField_b_of_type_Boolean = false;
      break label163;
      label559:
      localmdt.jdField_a_of_type_AndroidGraphicsBitmap = null;
      localmdt.jdField_b_of_type_Boolean = false;
      break label247;
      label574:
      long l = localmdt.jdField_a_of_type_Long;
      if (localmdt.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null)
      {
        localObject1 = localmdt.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        label596:
        if ((localObject1 == null) || (((AVPhoneUserInfo)localObject1).telInfo.mobile == null)) {
          break label765;
        }
        localmdt.jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject1).telInfo.mobile;
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject1).telInfo.mobile);
        if (localObject2 == null) {
          break label739;
        }
        localmdt.jdField_b_of_type_JavaLangString = bbcl.a((String)localObject2);
        localmdt.jdField_a_of_type_JavaLangString = ((String)localObject2);
      }
      for (;;)
      {
        localmdt.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130841623)).getBitmap();
        localmdt.jdField_b_of_type_Boolean = true;
        break;
        localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
        break label596;
        label739:
        localmdt.jdField_b_of_type_JavaLangString = null;
        localmdt.jdField_a_of_type_JavaLangString = msp.a(((AVPhoneUserInfo)localObject1).telInfo.mobile, 4);
        continue;
        label765:
        if ((localObject1 != null) && (QLog.isColorLevel())) {
          QLog.d("GAudioMemberListCtrl", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject1).toString());
        }
        localmdt.jdField_b_of_type_JavaLangString = null;
        localmdt.jdField_a_of_type_JavaLangString = ((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131693243);
      }
      label843:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localmdt.jdField_a_of_type_Long));
      break label316;
      label861:
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localmdt.jdField_a_of_type_AndroidGraphicsBitmap);
      if (localmdt.jdField_a_of_type_Int != 0) {
        break label398;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
      break label398;
      label907:
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839736);
      break label398;
      label929:
      if ((paramViewGroup.jdField_a_of_type_Int != -1) && (paramViewGroup.jdField_a_of_type_Int != 1)) {
        break label448;
      }
      this.a.a(paramViewGroup.jdField_b_of_type_AndroidWidgetImageView, localmdt.jdField_c_of_type_Boolean);
      paramViewGroup.jdField_a_of_type_Int = 0;
      break label448;
      label969:
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      if (paramViewGroup.jdField_a_of_type_AndroidViewView != null) {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    label997:
    if (mdq.a(this.a)) {
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mdu
 * JD-Core Version:    0.7.0.1
 */