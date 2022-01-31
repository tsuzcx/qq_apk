import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import java.util.ArrayList;

public class jyr
  extends BaseAdapter
{
  public jyr(MultiVideoMembersListviewAvtivity paramMultiVideoMembersListviewAvtivity) {}
  
  Bitmap a()
  {
    return ((BitmapDrawable)MultiVideoMembersListviewAvtivity.d(this.a).getDrawable(2130839128)).getBitmap();
  }
  
  Bitmap a(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return null;
    }
    int i = -1;
    if (this.a.jdField_a_of_type_Int == 3000) {
      i = 1004;
    }
    for (;;)
    {
      return this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, paramString, String.valueOf(this.a.jdField_a_of_type_Long), true, false);
      if (this.a.jdField_a_of_type_Int == 1) {
        i = 1000;
      }
    }
  }
  
  String a(String paramString)
  {
    int i = -1;
    if (this.a.jdField_a_of_type_Int == 3000) {
      i = 1004;
    }
    for (;;)
    {
      return this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, paramString, String.valueOf(this.a.jdField_a_of_type_Long));
      if (this.a.jdField_a_of_type_Int == 1) {
        i = 1000;
      }
    }
  }
  
  void a(VideoController.GAudioFriends paramGAudioFriends, jyu paramjyu)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (paramGAudioFriends == null) || (paramjyu == null)) {
      return;
    }
    if (paramGAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      paramjyu.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a());
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new jys(this, paramjyu, paramGAudioFriends));
      return;
    }
    paramjyu.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramGAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
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
    label28:
    label117:
    VideoController.GAudioFriends localGAudioFriends;
    String str;
    if (paramView == null) {
      if (this.a.jdField_a_of_type_Boolean)
      {
        paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969303, null);
        paramViewGroup = new jyu(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366039));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366040));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366044));
        paramViewGroup.c = ((ImageView)paramView.findViewById(2131366043));
        if (this.a.jdField_a_of_type_Boolean) {
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366041));
        }
        paramView.setTag(paramViewGroup);
        localGAudioFriends = (VideoController.GAudioFriends)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        paramViewGroup.jdField_a_of_type_Long = localGAudioFriends.jdField_a_of_type_Long;
        a(localGAudioFriends, paramViewGroup);
        localGAudioFriends.jdField_a_of_type_JavaLangString = a(String.valueOf(localGAudioFriends.jdField_a_of_type_Long));
        if (localGAudioFriends.jdField_a_of_type_JavaLangString != null) {
          break label366;
        }
        str = "";
        label178:
        localGAudioFriends.jdField_a_of_type_JavaLangString = str;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localGAudioFriends.jdField_a_of_type_JavaLangString);
        if ((localGAudioFriends.jdField_a_of_type_Int <= 0) && (!localGAudioFriends.b) && (!localGAudioFriends.c)) {
          break label376;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        label229:
        if (!localGAudioFriends.jdField_a_of_type_Boolean) {
          break label388;
        }
        paramViewGroup.c.setVisibility(0);
      }
    }
    for (;;)
    {
      int i;
      if (this.a.jdField_a_of_type_Boolean)
      {
        paramInt = localGAudioFriends.e;
        i = localGAudioFriends.f;
        if (paramInt < 0) {
          break label462;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("Lv." + paramInt);
      }
      switch (i)
      {
      default: 
        return paramView;
        paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969316, null);
        break label28;
        paramViewGroup = (jyu)paramView.getTag();
        break label117;
        label366:
        str = localGAudioFriends.jdField_a_of_type_JavaLangString;
        break label178;
        label376:
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label229;
        label388:
        paramViewGroup.c.setVisibility(4);
      }
    }
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(MultiVideoMembersListviewAvtivity.a(this.a).getColor(2131493549));
    return paramView;
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(MultiVideoMembersListviewAvtivity.b(this.a).getColor(2131493550));
    return paramView;
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(MultiVideoMembersListviewAvtivity.c(this.a).getColor(2131493551));
    return paramView;
    label462:
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jyr
 * JD-Core Version:    0.7.0.1
 */