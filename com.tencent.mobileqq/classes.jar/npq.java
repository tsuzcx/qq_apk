import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;
import org.json.JSONArray;

public class npq
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  List<npo> jdField_a_of_type_JavaUtilList;
  
  public npq(PhotoWallViewForAccountDetail paramPhotoWallViewForAccountDetail, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(List<npo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    for (;;)
    {
      try
      {
        paramViewGroup = new JSONArray(((npo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).e);
        if (paramViewGroup.length() > 0)
        {
          paramViewGroup = paramViewGroup.optString(0);
          if (paramView == null)
          {
            localnpr = new npr(this);
            paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559440, null);
            paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentBizPubaccountPhotoWallViewForAccountDetail.a, this.jdField_a_of_type_ComTencentBizPubaccountPhotoWallViewForAccountDetail.b));
            localnpr.a = ((URLImageView)paramView.findViewById(2131371920));
            paramView.setTag(localnpr);
            localnpr.a.setTag(new awor(25, Integer.valueOf(paramInt)));
            if (!TextUtils.isEmpty(paramViewGroup)) {
              continue;
            }
            localnpr.a.setImageResource(2130839372);
            return paramView;
          }
        }
      }
      catch (Exception paramViewGroup)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AccountDetail.PhotoWallViewForAccountDetail", 2, "RICH_PIC_TEXT:pic json error!");
        }
        paramViewGroup.printStackTrace();
        paramViewGroup = null;
        continue;
        npr localnpr = (npr)paramView.getTag();
        continue;
        paramViewGroup = URLDrawable.getDrawable(paramViewGroup);
        localnpr.a.setImageDrawable(paramViewGroup);
        return paramView;
      }
      paramViewGroup = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     npq
 * JD-Core Version:    0.7.0.1
 */