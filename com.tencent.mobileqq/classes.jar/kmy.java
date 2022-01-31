import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.addContactTroopView.TroopCardSameCity;
import com.tencent.biz.addContactTroopView.TroopCardSameCity.ViewHolder;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportControllerImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Item2;

public class kmy
  extends BaseAdapter
{
  public kmy(TroopCardSameCity paramTroopCardSameCity) {}
  
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
    searchtab.Item2 localItem2;
    int i;
    int j;
    if (paramView == null)
    {
      paramView = new TroopCardSameCity.ViewHolder();
      localObject = LayoutInflater.from(this.a.getContext()).inflate(2130969412, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131366417));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366419));
      paramView.b = ((TextView)((View)localObject).findViewById(2131366420));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      localItem2 = (searchtab.Item2)this.a.a.get(paramInt);
      i = AIOUtils.a(38.0F, this.a.getResources());
      j = AIOUtils.a(57.0F, this.a.getResources());
      localObject = localItem2.str_img_url.get();
      paramInt = 1;
      if (HttpUtil.a((String)localObject)) {
        break label364;
      }
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).startsWith("//"))) {
        break label320;
      }
      localObject = "http:" + (String)localObject;
      ReportControllerImpl.b(null, "dc00899", "Q..urldrawable", "", "url_no_head", "", 0, 0, "TroopCardSameCity", "" + (String)localObject, "", "");
      paramInt = 1;
      label234:
      if (paramInt == 0) {
        break label430;
      }
    }
    for (;;)
    {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable((String)localObject, i, j);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
        if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus())) {
          localURLDrawable.restartDownload();
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        label320:
        label364:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q..urldrawable", 2, "URLDrawable.getDrawable() Exception.", localIllegalArgumentException);
        ReportControllerImpl.b(null, "dc00899", "Q..urldrawable", "", "url_illegal", "", 0, 1, "TroopCardSameCity", "" + (String)localObject, "", "");
        continue;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localItem2.str_name.get());
      paramViewGroup.b.setText(localItem2.str_desc.get());
      return paramView;
      paramViewGroup = (TroopCardSameCity.ViewHolder)paramView.getTag();
      break;
      paramInt = 0;
      ReportControllerImpl.b(null, "dc00899", "Q..urldrawable", "", "url_illegal", "", 0, 0, "TroopCardSameCity", "" + (String)localObject, "", "");
      break label234;
      label430:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kmy
 * JD-Core Version:    0.7.0.1
 */