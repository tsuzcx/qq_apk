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

public class rkk
  extends tib
  implements View.OnTouchListener
{
  private rkn jdField_a_of_type_Rkn;
  private rko jdField_a_of_type_Rko;
  
  public rkk(Context paramContext, int paramInt)
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
        localURLDrawableOptions.mPlayGifImage = ayzh.a(paramString);
        localURLDrawableOptions.mLoadingDrawable = ReadInJoyDeliverUGCActivity.a;
        localURLDrawableOptions.mFailedDrawable = ReadInJoyDeliverUGCActivity.a;
        localURLDrawableOptions.mUseAutoScaleParams = false;
        localURLDrawableOptions.mRequestWidth = bgtn.b(114.0F);
        localURLDrawableOptions.mRequestHeight = bgtn.b(114.0F);
        return URLDrawable.getDrawable(localFile, localURLDrawableOptions);
      }
    }
    return null;
  }
  
  public void a(rkn paramrkn)
  {
    this.jdField_a_of_type_Rkn = paramrkn;
  }
  
  public void a(rko paramrko)
  {
    this.jdField_a_of_type_Rko = paramrko;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560280, null);
      paramView = new rkm(this, null);
      paramView.a = ((ImageView)localView.findViewById(2131380165));
      paramView.b = ((ImageView)localView.findViewById(2131380162));
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
      paramView.a.setOnClickListener(new rkl(this));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (rkm)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label204:
      if ("".equals(localObject))
      {
        paramView.b.setImageResource(2130841700);
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
    if (this.jdField_a_of_type_Rko != null) {
      return this.jdField_a_of_type_Rko.a(paramView, paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rkk
 * JD-Core Version:    0.7.0.1
 */