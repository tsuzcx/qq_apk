import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.settings.QQStoryShieldListActivity;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class nri
  extends BaseAdapter
{
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public nri(QQStoryShieldListActivity paramQQStoryShieldListActivity, List paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList);
      Collections.sort(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList);
    if (this.jdField_a_of_type_JavaUtilList != null) {
      Collections.sort(this.jdField_a_of_type_JavaUtilList);
    }
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity).inflate(2130970836, null);
      paramViewGroup = new nrj(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362739));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362754));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.a.widthPixels - AIOUtils.a(175.0F, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.getResources()));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370944));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity);
      paramView.setTag(paramViewGroup);
      localObject = (QQStoryUserInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup.jdField_a_of_type_JavaLangString = ((QQStoryUserInfo)localObject).uin;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((QQStoryUserInfo)localObject).nick);
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(localObject);
      if (this.jdField_a_of_type_JavaUtilList.size() <= 2) {
        break label258;
      }
      if (paramInt != 0) {
        break label225;
      }
      paramView.setBackgroundResource(2130838635);
    }
    label258:
    for (;;)
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.app.a(((QQStoryUserInfo)localObject).uin, true);
      if (localObject == null) {
        break label315;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      return paramView;
      paramViewGroup = (nrj)paramView.getTag();
      break;
      label225:
      if (paramInt == this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        paramView.setBackgroundResource(2130838630);
      }
      else
      {
        paramView.setBackgroundResource(2130838633);
        continue;
        if (this.jdField_a_of_type_JavaUtilList.size() == 2)
        {
          if (paramInt == 0) {
            paramView.setBackgroundResource(2130838635);
          } else {
            paramView.setBackgroundResource(2130838630);
          }
        }
        else if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
          paramView.setBackgroundResource(2130838630);
        }
      }
    }
    label315:
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.a());
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nri
 * JD-Core Version:    0.7.0.1
 */