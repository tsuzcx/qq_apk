import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;
import org.json.JSONArray;

public class obt
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  List<obr> jdField_a_of_type_JavaUtilList;
  
  public obt(PhotoWallViewForAccountDetail paramPhotoWallViewForAccountDetail, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(List<obr> paramList)
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
    try
    {
      Object localObject1 = new JSONArray(((obr)this.jdField_a_of_type_JavaUtilList.get(paramInt)).e);
      if (((JSONArray)localObject1).length() > 0)
      {
        localObject1 = ((JSONArray)localObject1).optString(0);
        if (paramView == null)
        {
          paramView = new obu(this);
          localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559577, null);
          localView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentBizPubaccountPhotoWallViewForAccountDetail.a, this.jdField_a_of_type_ComTencentBizPubaccountPhotoWallViewForAccountDetail.b));
          paramView.a = ((URLImageView)localView.findViewById(2131372572));
          localView.setTag(paramView);
          paramView.a.setTag(new aykg(25, Integer.valueOf(paramInt)));
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label212;
          }
          paramView.a.setImageResource(2130839595);
          EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
          return localView;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AccountDetail.PhotoWallViewForAccountDetail", 2, "RICH_PIC_TEXT:pic json error!");
        }
        localException.printStackTrace();
        Object localObject2 = null;
        continue;
        obu localobu = (obu)paramView.getTag();
        View localView = paramView;
        paramView = localobu;
        continue;
        label212:
        localObject2 = URLDrawable.getDrawable((String)localObject2);
        paramView.a.setImageDrawable((Drawable)localObject2);
        continue;
        localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     obt
 * JD-Core Version:    0.7.0.1
 */