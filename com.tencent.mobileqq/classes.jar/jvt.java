import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.av.ui.MultiMembersUI.Holder;
import com.tencent.av.ui.MultiMembersUI.MVMembersInfo;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class jvt
  extends PagerAdapter
{
  public jvt(MultiMembersAudioUI paramMultiMembersAudioUI) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.a.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    int j = this.a.jdField_b_of_type_Int / 8;
    if (this.a.jdField_b_of_type_Int % 8 == 0) {}
    for (;;)
    {
      return i + j;
      i = 1;
    }
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  @TargetApi(11)
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if ((!QLog.isColorLevel()) || ((this.a.jdField_a_of_type_JavaUtilArrayList == null) || (this.a.jdField_b_of_type_Int == 0)))
    {
      if (QLog.isColorLevel()) {}
      return null;
    }
    View localView1 = View.inflate(paramViewGroup.getContext(), 2130969324, null);
    Object localObject1;
    if (AudioHelper.a(0) == 1)
    {
      localView1.setBackgroundColor(-16776961);
      localView1.addOnLayoutChangeListener(new jvu(this));
      if (paramViewGroup.getTag(2131361845) == null)
      {
        paramViewGroup.setBackgroundColor(-16711936);
        localObject1 = new jvv(this);
        paramViewGroup.addOnLayoutChangeListener((View.OnLayoutChangeListener)localObject1);
        paramViewGroup.setTag(2131361845, localObject1);
      }
    }
    if (paramInt == getCount() - 1) {}
    for (int i = this.a.jdField_b_of_type_Int - paramInt * 8;; i = 8)
    {
      this.a.a(localView1, i);
      int j = 0;
      int k;
      if (j < i)
      {
        k = paramInt * 8 + j;
        if (k <= this.a.jdField_b_of_type_Int - 1) {}
      }
      else
      {
        localView1.setTag("MemberPagerAdapter_" + paramInt);
        paramViewGroup.addView(localView1);
        return localView1;
      }
      MultiMembersUI.MVMembersInfo localMVMembersInfo = (MultiMembersUI.MVMembersInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(k);
      if (localMVMembersInfo == null) {}
      for (;;)
      {
        j += 1;
        break;
        int m = this.a.a(i, j);
        View localView2;
        MultiMembersUI.Holder localHolder;
        Object localObject2;
        if (m != -1)
        {
          localView2 = localView1.findViewById(m);
          if (localView2 != null)
          {
            localHolder = this.a.a(localView2);
            localView2.setTag(localHolder);
            if (this.a.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
              localView2.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
            }
            if ((localMVMembersInfo.jdField_a_of_type_JavaLangString == null) || (localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap == null) || (!localMVMembersInfo.jdField_d_of_type_Boolean))
            {
              if (localMVMembersInfo.jdField_b_of_type_Int != 0) {
                break label840;
              }
              localObject1 = String.valueOf(localMVMembersInfo.jdField_a_of_type_Long);
              if (this.a.jdField_a_of_type_Int != 7) {
                break label743;
              }
              localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1);
              if (localObject2 != null)
              {
                if (!this.a.jdField_b_of_type_Boolean) {
                  break label730;
                }
                localMVMembersInfo.jdField_a_of_type_JavaLangString = ((VideoController.GAudioFriends)localObject2).jdField_b_of_type_JavaLangString;
                label407:
                if ((((String)localObject1).equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) && (localMVMembersInfo.jdField_a_of_type_JavaLangString != null)) {
                  localMVMembersInfo.jdField_a_of_type_JavaLangString += this.a.getResources().getString(2131429352);
                }
              }
              label471:
              if (localMVMembersInfo.jdField_a_of_type_JavaLangString == null) {
                localMVMembersInfo.jdField_a_of_type_JavaLangString = ((String)localObject1);
              }
              if (localMVMembersInfo.jdField_a_of_type_JavaLangString.compareTo((String)localObject1) == 0) {
                break label780;
              }
              localMVMembersInfo.jdField_d_of_type_Boolean = true;
              label505:
              if (this.a.jdField_a_of_type_Int != 7) {
                break label789;
              }
              localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, this.a.jdField_b_of_type_Boolean);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject2 = new BitmapFactory.Options();
                ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
                localObject1 = BitmapFactory.decodeResource(this.a.getResources(), 2130840293, (BitmapFactory.Options)localObject2);
                ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
              }
            }
          }
        }
        try
        {
          localObject2 = BitmapFactory.decodeResource(this.a.getResources(), 2130840293, (BitmapFactory.Options)localObject2);
          localObject1 = localObject2;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          label604:
          long l;
          break label604;
        }
        localMVMembersInfo.jdField_d_of_type_Boolean = false;
        label610:
        if (localObject1 != null) {
          localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
        }
        for (;;)
        {
          if (((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 2) && (this.a.jdField_a_of_type_Int != 7)) || (k != 17) || (this.a.jdField_a_of_type_JavaUtilArrayList.size() <= 18)) {
            break label1091;
          }
          localHolder.jdField_b_of_type_Boolean = false;
          localHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840272);
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setText("更多成员");
          localHolder.jdField_c_of_type_Boolean = true;
          localView2.setContentDescription(this.a.getResources().getString(2131428933));
          break;
          label730:
          localMVMembersInfo.jdField_a_of_type_JavaLangString = ((VideoController.GAudioFriends)localObject2).jdField_a_of_type_JavaLangString;
          break label407;
          label743:
          localMVMembersInfo.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
          break label471;
          label780:
          localMVMembersInfo.jdField_d_of_type_Boolean = false;
          break label505;
          label789:
          localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int, false, true);
          break label610;
          localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap = null;
          localMVMembersInfo.jdField_d_of_type_Boolean = false;
        }
        label840:
        l = localMVMembersInfo.jdField_a_of_type_Long;
        if (localMVMembersInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null)
        {
          localObject1 = localMVMembersInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
          label862:
          if ((localObject1 == null) || (((AVPhoneUserInfo)localObject1).telInfo.mobile == null)) {
            break label1022;
          }
          localMVMembersInfo.jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject1).telInfo.mobile;
          localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject1).telInfo.mobile);
          if (localObject2 == null) {
            break label996;
          }
          localMVMembersInfo.jdField_b_of_type_JavaLangString = ContactUtils.a((String)localObject2);
          localMVMembersInfo.jdField_a_of_type_JavaLangString = ((String)localObject2);
        }
        for (;;)
        {
          localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)this.a.getResources().getDrawable(2130840223)).getBitmap();
          localMVMembersInfo.jdField_d_of_type_Boolean = true;
          break;
          localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
          break label862;
          label996:
          localMVMembersInfo.jdField_b_of_type_JavaLangString = null;
          localMVMembersInfo.jdField_a_of_type_JavaLangString = PstnUtils.a(((AVPhoneUserInfo)localObject1).telInfo.mobile, 4);
          continue;
          label1022:
          if ((localObject1 != null) && (QLog.isColorLevel())) {
            QLog.d("MemberPagerAdapter", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject1).toString());
          }
          localMVMembersInfo.jdField_b_of_type_JavaLangString = null;
          localMVMembersInfo.jdField_a_of_type_JavaLangString = this.a.getResources().getString(2131428934);
        }
        label1091:
        if (this.a.jdField_a_of_type_Int == 7) {
          localHolder.jdField_b_of_type_Int = localMVMembersInfo.jdField_d_of_type_Int;
        }
        switch (localHolder.jdField_b_of_type_Int)
        {
        case 3: 
        default: 
          label1148:
          if (localHolder.jdField_b_of_type_Int != 0) {
            localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          }
          if (String.valueOf(localMVMembersInfo.jdField_a_of_type_Long).endsWith(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
          {
            localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131493251));
            label1210:
            localHolder.jdField_b_of_type_Boolean = true;
            localHolder.jdField_a_of_type_Long = localMVMembersInfo.jdField_a_of_type_Long;
            l = localMVMembersInfo.jdField_a_of_type_Long;
            if (localMVMembersInfo.jdField_a_of_type_JavaLangString == null) {
              break label1621;
            }
            localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMVMembersInfo.jdField_a_of_type_JavaLangString);
            if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 7) && (!localHolder.jdField_a_of_type_AndroidWidgetTextView.isShown()) && (!localMVMembersInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(l)))) {
              localHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            }
            label1308:
            if (localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap == null) {
              break label1704;
            }
            if ((localMVMembersInfo.jdField_b_of_type_Int == 0) || (localMVMembersInfo.jdField_b_of_type_JavaLangString == null)) {
              break label1678;
            }
            localHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            localHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localMVMembersInfo.jdField_b_of_type_JavaLangString);
            localObject1 = ((BitmapDrawable)this.a.getResources().getDrawable(2130840189)).getBitmap();
            localHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
            label1385:
            if (((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 2) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 7))
            {
              if (!localMVMembersInfo.e) {
                break label1728;
              }
              if (localHolder.d.getVisibility() != 0) {
                localHolder.d.setVisibility(0);
              }
              if (localHolder.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
                localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              }
              localMVMembersInfo.jdField_a_of_type_Boolean = false;
            }
            label1510:
            localHolder.jdField_a_of_type_Boolean = localMVMembersInfo.jdField_a_of_type_Boolean;
            if (!localHolder.jdField_a_of_type_Boolean) {
              break label1752;
            }
            localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          }
          break;
        }
        for (;;)
        {
          if (localMVMembersInfo.jdField_a_of_type_Int != 2) {
            break label1765;
          }
          localHolder.jdField_a_of_type_Int = 5;
          break;
          localHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840064);
          break label1148;
          localHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840068);
          break label1148;
          localHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840066);
          break label1148;
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131492969));
          break label1210;
          label1621:
          if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 7) && (localHolder.jdField_a_of_type_AndroidWidgetTextView.isShown())) {
            localHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
          }
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localMVMembersInfo.jdField_a_of_type_Long));
          break label1308;
          label1678:
          localHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          localHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap);
          break label1385;
          label1704:
          localHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          localHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839132);
          break label1385;
          label1728:
          if (localHolder.d.getVisibility() != 0) {
            break label1510;
          }
          localHolder.d.setVisibility(8);
          break label1510;
          label1752:
          localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        label1765:
        if (localMVMembersInfo.jdField_c_of_type_Boolean) {
          localHolder.jdField_a_of_type_Int = 3;
        } else if (localMVMembersInfo.jdField_a_of_type_Int == 1) {
          localHolder.jdField_a_of_type_Int = 2;
        } else if (localMVMembersInfo.jdField_b_of_type_Boolean) {
          localHolder.jdField_a_of_type_Int = 1;
        } else {
          localHolder.jdField_a_of_type_Int = 0;
        }
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jvt
 * JD-Core Version:    0.7.0.1
 */