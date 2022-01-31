import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.ui.MultiMembersUI.Holder;
import com.tencent.av.ui.MultiMembersUI.MVMembersInfo;
import com.tencent.av.ui.MultiMembersVideoUI;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class jvy
  extends BaseAdapter
{
  public jvy(MultiMembersVideoUI paramMultiMembersVideoUI) {}
  
  MultiMembersUI.Holder a(View paramView)
  {
    MultiMembersUI.Holder localHolder = new MultiMembersUI.Holder();
    localHolder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131365970));
    localHolder.c = ((ImageView)paramView.findViewById(2131365971));
    localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365973));
    localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365974));
    localHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365972));
    localHolder.d = ((ImageView)paramView.findViewById(2131365975));
    if ((this.a.jdField_b_of_type_Boolean) && (localHolder.jdField_a_of_type_AndroidWidgetTextView != null) && (localHolder.c != null))
    {
      float f = MultiMembersVideoUI.a(this.a).getDisplayMetrics().density;
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      int i = (int)(f * 1.5D);
      localHolder.c.setPadding(i, i, i, i);
    }
    if (localHolder.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (this.a.jdField_a_of_type_Boolean) {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      }
    }
    else if (localHolder.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      paramView = (RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      if (!this.a.jdField_a_of_type_Boolean) {
        break label291;
      }
      paramView.width = this.a.getResources().getDimensionPixelSize(2131559992);
    }
    for (paramView.height = this.a.getResources().getDimensionPixelSize(2131559993);; paramView.height = this.a.getResources().getDimensionPixelSize(2131559995))
    {
      localHolder.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramView);
      return localHolder;
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131493511));
      break;
      label291:
      paramView.width = this.a.getResources().getDimensionPixelSize(2131559994);
    }
  }
  
  public int getCount()
  {
    if (((this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 2)) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 18)) {
      return 18;
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
    if ((paramInt == 0) && (paramView != null) && (paramViewGroup.getChildCount() != paramInt)) {
      return paramView;
    }
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969327, null);
      paramViewGroup = a(paramView);
      paramView.setTag(paramViewGroup);
    }
    label158:
    label308:
    label317:
    label332:
    label852:
    label985:
    for (;;)
    {
      MultiMembersUI.MVMembersInfo localMVMembersInfo = (MultiMembersUI.MVMembersInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      Object localObject;
      if ((localMVMembersInfo.jdField_a_of_type_JavaLangString == null) || (localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap == null) || (!localMVMembersInfo.d))
      {
        if (localMVMembersInfo.jdField_b_of_type_Int != 0) {
          break label332;
        }
        localObject = String.valueOf(localMVMembersInfo.jdField_a_of_type_Long);
        localMVMembersInfo.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
        if (localMVMembersInfo.jdField_a_of_type_JavaLangString.compareTo((String)localObject) == 0) {
          break label308;
        }
        localMVMembersInfo.d = true;
        localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int, false, true);
        if (localObject == null) {
          break label317;
        }
        localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
      }
      for (;;)
      {
        if (((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 2)) || (paramInt != 17) || (this.a.jdField_a_of_type_JavaUtilArrayList.size() <= 18)) {
          break label583;
        }
        paramViewGroup.jdField_b_of_type_Boolean = false;
        paramViewGroup.c.setImageResource(2130840272);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("更多成员");
        paramView.setContentDescription(MultiMembersVideoUI.d(this.a).getString(2131428933));
        return paramView;
        paramViewGroup = (MultiMembersUI.Holder)paramView.getTag();
        if (paramViewGroup != null) {
          break label985;
        }
        paramViewGroup = a(paramView);
        break;
        localMVMembersInfo.d = false;
        break label158;
        localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap = null;
        localMVMembersInfo.d = false;
      }
      long l = localMVMembersInfo.jdField_a_of_type_Long;
      if (localMVMembersInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null)
      {
        localObject = localMVMembersInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        label354:
        if ((localObject == null) || (((AVPhoneUserInfo)localObject).telInfo.mobile == null)) {
          break label514;
        }
        localMVMembersInfo.jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject).telInfo.mobile;
        String str = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject).telInfo.mobile);
        if (str == null) {
          break label488;
        }
        localMVMembersInfo.jdField_b_of_type_JavaLangString = ContactUtils.a(str);
        localMVMembersInfo.jdField_a_of_type_JavaLangString = str;
      }
      for (;;)
      {
        localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)MultiMembersVideoUI.c(this.a).getDrawable(2130840223)).getBitmap();
        localMVMembersInfo.d = true;
        break;
        localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
        break label354;
        label488:
        localMVMembersInfo.jdField_b_of_type_JavaLangString = null;
        localMVMembersInfo.jdField_a_of_type_JavaLangString = PstnUtils.a(((AVPhoneUserInfo)localObject).telInfo.mobile, 4);
        continue;
        if ((localObject != null) && (QLog.isColorLevel())) {
          QLog.d("MultiMembersVideoUI", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject).toString());
        }
        localMVMembersInfo.jdField_b_of_type_JavaLangString = null;
        localMVMembersInfo.jdField_a_of_type_JavaLangString = MultiMembersVideoUI.b(this.a).getString(2131428934);
      }
      paramViewGroup.jdField_b_of_type_Boolean = true;
      paramViewGroup.jdField_a_of_type_Long = localMVMembersInfo.jdField_a_of_type_Long;
      if (localMVMembersInfo.jdField_a_of_type_JavaLangString != null)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localMVMembersInfo.jdField_a_of_type_JavaLangString);
        if (localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          break label876;
        }
        if ((localMVMembersInfo.jdField_b_of_type_Int == 0) || (localMVMembersInfo.jdField_b_of_type_JavaLangString == null)) {
          break label852;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localMVMembersInfo.jdField_b_of_type_JavaLangString);
        localObject = ((BitmapDrawable)MultiMembersVideoUI.e(this.a).getDrawable(2130840189)).getBitmap();
        paramViewGroup.c.setImageBitmap((Bitmap)localObject);
        if (((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 2))
        {
          if (!localMVMembersInfo.e) {
            break label898;
          }
          if (paramViewGroup.d.getVisibility() != 0) {
            paramViewGroup.d.setVisibility(0);
          }
          if (paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          localMVMembersInfo.jdField_a_of_type_Boolean = false;
        }
        paramViewGroup.jdField_a_of_type_Boolean = localMVMembersInfo.jdField_a_of_type_Boolean;
        if (!paramViewGroup.jdField_a_of_type_Boolean) {
          break label920;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      for (;;)
      {
        if (localMVMembersInfo.jdField_a_of_type_Int != 2) {
          break label932;
        }
        paramViewGroup.jdField_a_of_type_Int = 5;
        return paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localMVMembersInfo.jdField_a_of_type_Long));
        break;
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.c.setImageBitmap(localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap);
        break label691;
        label876:
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.c.setImageResource(2130839132);
        break label691;
        if (paramViewGroup.d.getVisibility() != 0) {
          break label794;
        }
        paramViewGroup.d.setVisibility(8);
        break label794;
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (localMVMembersInfo.c)
      {
        paramViewGroup.jdField_a_of_type_Int = 3;
        return paramView;
      }
      if (localMVMembersInfo.jdField_a_of_type_Int == 1)
      {
        paramViewGroup.jdField_a_of_type_Int = 2;
        return paramView;
      }
      if (localMVMembersInfo.jdField_b_of_type_Boolean)
      {
        paramViewGroup.jdField_a_of_type_Int = 1;
        return paramView;
      }
      paramViewGroup.jdField_a_of_type_Int = 0;
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jvy
 * JD-Core Version:    0.7.0.1
 */