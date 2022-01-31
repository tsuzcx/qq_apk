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
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity.ListViewBaseAdapter.1;
import java.util.ArrayList;

public class lwd
  extends BaseAdapter
{
  public lwd(MultiVideoMembersListviewAvtivity paramMultiVideoMembersListviewAvtivity) {}
  
  Bitmap a()
  {
    return ((BitmapDrawable)MultiVideoMembersListviewAvtivity.d(this.a).getDrawable(2130839687)).getBitmap();
  }
  
  public Bitmap a(String paramString)
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
  
  public void a(kth paramkth, lwe paramlwe)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (paramkth == null) || (paramlwe == null)) {
      return;
    }
    if (paramkth.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      paramlwe.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a());
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new MultiVideoMembersListviewAvtivity.ListViewBaseAdapter.1(this, paramlwe, paramkth));
      return;
    }
    paramlwe.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramkth.jdField_a_of_type_AndroidGraphicsBitmap);
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
    kth localkth;
    String str;
    if (paramView == null) {
      if (this.a.jdField_a_of_type_Boolean)
      {
        paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493959, null);
        paramViewGroup = new lwe(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302717));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302728));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302769));
        paramViewGroup.c = ((ImageView)paramView.findViewById(2131302773));
        if (this.a.jdField_a_of_type_Boolean) {
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302724));
        }
        paramView.setTag(paramViewGroup);
        localkth = (kth)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        paramViewGroup.jdField_a_of_type_Long = localkth.jdField_a_of_type_Long;
        a(localkth, paramViewGroup);
        localkth.jdField_a_of_type_JavaLangString = a(String.valueOf(localkth.jdField_a_of_type_Long));
        if (localkth.jdField_a_of_type_JavaLangString != null) {
          break label366;
        }
        str = "";
        label178:
        localkth.jdField_a_of_type_JavaLangString = str;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localkth.jdField_a_of_type_JavaLangString);
        if ((localkth.jdField_a_of_type_Int <= 0) && (!localkth.b) && (!localkth.c)) {
          break label376;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        label229:
        if (!localkth.jdField_a_of_type_Boolean) {
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
        paramInt = localkth.d;
        i = localkth.e;
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
        paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493967, null);
        break label28;
        paramViewGroup = (lwe)paramView.getTag();
        break label117;
        label366:
        str = localkth.jdField_a_of_type_JavaLangString;
        break label178;
        label376:
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label229;
        label388:
        paramViewGroup.c.setVisibility(4);
      }
    }
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(MultiVideoMembersListviewAvtivity.a(this.a).getColor(2131100304));
    return paramView;
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(MultiVideoMembersListviewAvtivity.b(this.a).getColor(2131100305));
    return paramView;
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(MultiVideoMembersListviewAvtivity.c(this.a).getColor(2131100306));
    return paramView;
    label462:
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lwd
 * JD-Core Version:    0.7.0.1
 */