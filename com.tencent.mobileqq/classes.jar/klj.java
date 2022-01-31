import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.addContactTroopView.TroopCardXingquBuluo;
import com.tencent.biz.addContactTroopView.TroopCardXingquBuluo.ViewHolder;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Item3;

public class klj
  extends BaseAdapter
{
  public klj(TroopCardXingquBuluo paramTroopCardXingquBuluo) {}
  
  public int getCount()
  {
    if (this.a.a != null) {
      return this.a.a.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      localObject = new TroopCardXingquBuluo.ViewHolder();
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2130969416, paramViewGroup, false);
      ((TroopCardXingquBuluo.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366392));
      ((TroopCardXingquBuluo.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366394));
      ((TroopCardXingquBuluo.ViewHolder)localObject).b = ((TextView)paramView.findViewById(2131366396));
      ((TroopCardXingquBuluo.ViewHolder)localObject).c = ((TextView)paramView.findViewById(2131366397));
      paramView.setTag(localObject);
    }
    for (paramViewGroup = (ViewGroup)localObject;; paramViewGroup = (TroopCardXingquBuluo.ViewHolder)paramView.getTag())
    {
      localObject = (searchtab.Item3)this.a.a.get(paramInt);
      paramInt = AIOUtils.a(30.0F, this.a.getResources());
      URLDrawable localURLDrawable = URLDrawable.getDrawable(((searchtab.Item3)localObject).str_img_url.get(), paramInt, paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
      if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus())) {
        localURLDrawable.restartDownload();
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((searchtab.Item3)localObject).str_name.get());
      paramViewGroup.b.setText(((searchtab.Item3)localObject).str_desc1.get());
      paramViewGroup.c.setText(((searchtab.Item3)localObject).str_desc2.get());
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     klj
 * JD-Core Version:    0.7.0.1
 */