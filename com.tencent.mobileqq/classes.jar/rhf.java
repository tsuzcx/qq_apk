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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;

public class rhf
  extends SimpleAdapter
{
  public rhf(Context paramContext, List<? extends Map<String, ?>> paramList, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super(paramList, paramInt, paramArrayOfString, paramArrayOfInt, arrayOfInt);
  }
  
  protected void a(View paramView, ResultRecord paramResultRecord) {}
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (Map)getItem(paramInt);
    ResultRecord localResultRecord = ResultRecord.a((String)((Map)localObject).get("key_uin"), (String)((Map)localObject).get("key_name"));
    if (FollowingListFragment.a(this.a).contains(localResultRecord)) {
      ((Map)localObject).put("key_checked", Boolean.valueOf(true));
    }
    for (;;)
    {
      localObject = super.getView(paramInt, paramView, paramViewGroup);
      a((View)localObject, localResultRecord);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      ((Map)localObject).put("key_checked", Boolean.valueOf(false));
    }
  }
  
  public void setViewImage(ImageView paramImageView, String paramString)
  {
    super.setViewImage(paramImageView, paramString);
    if (paramImageView.getId() == 2131368212) {}
    try
    {
      Object localObject = this.a.getResources().getDrawable(2130840274);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localObject = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      ((URLDrawable)localObject).setTag(bhez.a(140, 140));
      ((URLDrawable)localObject).setDecodeHandler(bhez.p);
      paramImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (Exception paramImageView)
    {
      QLog.e("FollowingListFragment", 2, "setViewImage: " + paramString, paramImageView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rhf
 * JD-Core Version:    0.7.0.1
 */