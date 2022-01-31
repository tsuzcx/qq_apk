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

class mdp
  extends BaseAdapter
{
  private mdp(mdl parammdl) {}
  
  mdq a(View paramView, boolean paramBoolean)
  {
    mdq localmdq = new mdq(this.a, null);
    localmdq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372274));
    localmdq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372290));
    localmdq.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372276));
    localmdq.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372263));
    localmdq.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372295));
    localmdq.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372292));
    if (!mdl.a(this.a))
    {
      localmdq.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localmdq.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
      localmdq.jdField_b_of_type_AndroidWidgetImageView.setClickable(false);
    }
    localmdq.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.a.b);
    localmdq.jdField_c_of_type_Boolean = paramBoolean;
    if (mdl.b(this.a))
    {
      paramView.setBackgroundColor(-16777216);
      localmdq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A8A8A8"));
      localmdq.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#757575"));
      localmdq.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131372294);
      localmdq.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(muc.a(10.4F, (Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()));
      paramView.findViewById(2131363369).setBackgroundColor(Color.parseColor("#0F0F0F"));
    }
    return localmdq;
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
    mdo localmdo = (mdo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject1;
    label163:
    Object localObject2;
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559515, null);
      paramViewGroup = a(paramView, localmdo.e);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setTag(localmdo);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(localmdo);
      if ((localmdo.jdField_a_of_type_JavaLangString == null) || (localmdo.jdField_a_of_type_AndroidGraphicsBitmap == null) || (!localmdo.jdField_b_of_type_Boolean))
      {
        if (localmdo.jdField_a_of_type_Int != 0) {
          break label574;
        }
        localObject1 = String.valueOf(localmdo.jdField_a_of_type_Long);
        localmdo.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
        if (localmdo.jdField_a_of_type_JavaLangString.compareTo((String)localObject1) == 0) {
          break label550;
        }
        localmdo.jdField_b_of_type_Boolean = true;
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int, false, true);
        if (localmdo.e)
        {
          localObject1 = localObject2;
          if (!mdl.b(this.a)) {}
        }
        else
        {
          localObject1 = localObject2;
          if (localObject2 != null) {
            localObject1 = bbef.a((Bitmap)localObject2, true);
          }
        }
        if (localObject1 == null) {
          break label559;
        }
        localmdo.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
      }
      label247:
      paramViewGroup.jdField_b_of_type_Boolean = true;
      paramViewGroup.jdField_a_of_type_Long = localmdo.jdField_a_of_type_Long;
      if (localmdo.jdField_a_of_type_JavaLangString == null) {
        break label843;
      }
      float f = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getResources().getDimensionPixelSize(2131297021);
      localObject1 = muc.a(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getContext(), localmdo.jdField_a_of_type_JavaLangString, paramViewGroup.jdField_a_of_type_AndroidWidgetTextView, f);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      label316:
      if (localmdo.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        break label907;
      }
      if ((localmdo.jdField_a_of_type_Int == 0) || (localmdo.jdField_b_of_type_JavaLangString == null)) {
        break label861;
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localmdo.jdField_b_of_type_JavaLangString);
      localObject1 = ((BitmapDrawable)((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130841580)).getBitmap();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
      label398:
      if (!localmdo.jdField_c_of_type_Boolean) {
        break label929;
      }
      if ((paramViewGroup.jdField_a_of_type_Int == -1) || (paramViewGroup.jdField_a_of_type_Int == 0))
      {
        this.a.a(paramViewGroup.jdField_b_of_type_AndroidWidgetImageView, localmdo.jdField_c_of_type_Boolean);
        paramViewGroup.jdField_a_of_type_Int = 1;
      }
      localmdo.jdField_a_of_type_Boolean = false;
      label448:
      paramViewGroup.jdField_a_of_type_Boolean = localmdo.jdField_a_of_type_Boolean;
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
      if (localmdo.e) {
        break label997;
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return paramView;
      localObject1 = (mdq)paramView.getTag();
      paramViewGroup = (ViewGroup)localObject1;
      if (localObject1 == null)
      {
        paramViewGroup = a(paramView, localmdo.e);
        paramView.setTag(paramViewGroup);
      }
      break;
      label550:
      localmdo.jdField_b_of_type_Boolean = false;
      break label163;
      label559:
      localmdo.jdField_a_of_type_AndroidGraphicsBitmap = null;
      localmdo.jdField_b_of_type_Boolean = false;
      break label247;
      label574:
      long l = localmdo.jdField_a_of_type_Long;
      if (localmdo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null)
      {
        localObject1 = localmdo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        label596:
        if ((localObject1 == null) || (((AVPhoneUserInfo)localObject1).telInfo.mobile == null)) {
          break label765;
        }
        localmdo.jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject1).telInfo.mobile;
        localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject1).telInfo.mobile);
        if (localObject2 == null) {
          break label739;
        }
        localmdo.jdField_b_of_type_JavaLangString = bbcz.a((String)localObject2);
        localmdo.jdField_a_of_type_JavaLangString = ((String)localObject2);
      }
      for (;;)
      {
        localmdo.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130841623)).getBitmap();
        localmdo.jdField_b_of_type_Boolean = true;
        break;
        localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
        break label596;
        label739:
        localmdo.jdField_b_of_type_JavaLangString = null;
        localmdo.jdField_a_of_type_JavaLangString = msm.a(((AVPhoneUserInfo)localObject1).telInfo.mobile, 4);
        continue;
        label765:
        if ((localObject1 != null) && (QLog.isColorLevel())) {
          QLog.d("GAudioMemberListCtrl", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject1).toString());
        }
        localmdo.jdField_b_of_type_JavaLangString = null;
        localmdo.jdField_a_of_type_JavaLangString = ((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131693244);
      }
      label843:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localmdo.jdField_a_of_type_Long));
      break label316;
      label861:
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localmdo.jdField_a_of_type_AndroidGraphicsBitmap);
      if (localmdo.jdField_a_of_type_Int != 0) {
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
      this.a.a(paramViewGroup.jdField_b_of_type_AndroidWidgetImageView, localmdo.jdField_c_of_type_Boolean);
      paramViewGroup.jdField_a_of_type_Int = 0;
      break label448;
      label969:
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      if (paramViewGroup.jdField_a_of_type_AndroidViewView != null) {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    label997:
    if (mdl.a(this.a)) {
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mdp
 * JD-Core Version:    0.7.0.1
 */