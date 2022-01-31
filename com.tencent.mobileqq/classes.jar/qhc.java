import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.FollowingListFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

public class qhc
  extends SimpleAdapter
{
  public qhc(Context paramContext, List<? extends Map<String, ?>> paramList, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super(paramList, paramInt, paramArrayOfString, paramArrayOfInt, arrayOfInt);
  }
  
  protected void a(View paramView, ResultRecord paramResultRecord) {}
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Map localMap = (Map)getItem(paramInt);
    ResultRecord localResultRecord = ResultRecord.a((String)localMap.get("key_uin"), (String)localMap.get("key_name"));
    if (FollowingListFragment.a(this.a).contains(localResultRecord)) {
      localMap.put("key_checked", Boolean.valueOf(true));
    }
    for (;;)
    {
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      a(paramView, localResultRecord);
      return paramView;
      localMap.put("key_checked", Boolean.valueOf(false));
    }
  }
  
  public void setViewImage(ImageView paramImageView, String paramString)
  {
    super.setViewImage(paramImageView, paramString);
    if (paramImageView.getId() == 2131367679) {}
    try
    {
      Object localObject = this.a.getResources().getDrawable(2130839736);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localObject = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      ((URLDrawable)localObject).setTag(bavi.a(140, 140));
      ((URLDrawable)localObject).setDecodeHandler(bavi.o);
      paramImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (Exception paramImageView)
    {
      QLog.e("FollowingListFragment", 2, "setViewImage: " + paramString, paramImageView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qhc
 * JD-Core Version:    0.7.0.1
 */