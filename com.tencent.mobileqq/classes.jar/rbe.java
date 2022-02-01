import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;

public class rbe
  extends syv
  implements View.OnTouchListener
{
  private rbh jdField_a_of_type_Rbh;
  private rbi jdField_a_of_type_Rbi;
  
  public rbe(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private Drawable a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(paramString);
      if (localFile.exists())
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mPlayGifImage = azru.a(paramString);
        localURLDrawableOptions.mLoadingDrawable = ReadInJoyDeliverUGCActivity.a;
        localURLDrawableOptions.mFailedDrawable = ReadInJoyDeliverUGCActivity.a;
        localURLDrawableOptions.mUseAutoScaleParams = false;
        localURLDrawableOptions.mRequestWidth = bhtq.b(114.0F);
        localURLDrawableOptions.mRequestHeight = bhtq.b(114.0F);
        return URLDrawable.getDrawable(localFile, localURLDrawableOptions);
      }
    }
    return null;
  }
  
  public void a(rbh paramrbh)
  {
    this.jdField_a_of_type_Rbh = paramrbh;
  }
  
  public void a(rbi paramrbi)
  {
    this.jdField_a_of_type_Rbi = paramrbi;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560292, null);
      paramView = new rbg(this, null);
      paramView.a = ((ImageView)localView.findViewById(2131380350));
      paramView.b = ((ImageView)localView.findViewById(2131380347));
      localView.setTag(paramView);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (!(localObject instanceof HotPicData)) {
        break label204;
      }
      localObject = ReadInJoyDeliverUGCActivity.a((HotPicData)localObject);
      if (localObject != null)
      {
        paramView.b.setImageDrawable((Drawable)localObject);
        paramView.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramView.a.setVisibility(0);
      }
    }
    for (;;)
    {
      paramView.b.setTag(Integer.valueOf(paramInt));
      paramView.a.setTag(Integer.valueOf(paramInt));
      paramView.b.setOnTouchListener(this);
      paramView.a.setOnClickListener(new rbf(this));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (rbg)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label204:
      if ("".equals(localObject))
      {
        paramView.b.setImageResource(2130841710);
        paramView.b.setScaleType(ImageView.ScaleType.CENTER);
        paramView.a.setVisibility(8);
      }
      else
      {
        localObject = a((String)localObject);
        if (localObject != null)
        {
          paramView.b.setImageDrawable((Drawable)localObject);
          paramView.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
          paramView.a.setVisibility(0);
        }
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Rbi != null) {
      return this.jdField_a_of_type_Rbi.a(paramView, paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rbe
 * JD-Core Version:    0.7.0.1
 */