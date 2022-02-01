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
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;

public class rif
  extends tcv
  implements View.OnTouchListener
{
  private rii jdField_a_of_type_Rii;
  private rij jdField_a_of_type_Rij;
  
  public rif(Context paramContext, int paramInt)
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
        localURLDrawableOptions.mPlayGifImage = ayfc.a(paramString);
        localURLDrawableOptions.mLoadingDrawable = ReadInJoyDeliverUGCActivity.a;
        localURLDrawableOptions.mFailedDrawable = ReadInJoyDeliverUGCActivity.a;
        localURLDrawableOptions.mUseAutoScaleParams = false;
        localURLDrawableOptions.mRequestWidth = ViewUtils.dpToPx(114.0F);
        localURLDrawableOptions.mRequestHeight = ViewUtils.dpToPx(114.0F);
        return URLDrawable.getDrawable(localFile, localURLDrawableOptions);
      }
    }
    return null;
  }
  
  public void a(rii paramrii)
  {
    this.jdField_a_of_type_Rii = paramrii;
  }
  
  public void a(rij paramrij)
  {
    this.jdField_a_of_type_Rij = paramrij;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560299, null);
      paramView = new rih(this, null);
      paramView.a = ((ImageView)localView.findViewById(2131380076));
      paramView.b = ((ImageView)localView.findViewById(2131380073));
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
      paramView.a.setOnClickListener(new rig(this));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (rih)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label204:
      if ("".equals(localObject))
      {
        paramView.b.setImageResource(2130841750);
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
    if (this.jdField_a_of_type_Rij != null) {
      return this.jdField_a_of_type_Rij.a(paramView, paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rif
 * JD-Core Version:    0.7.0.1
 */