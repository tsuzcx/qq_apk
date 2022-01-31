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
import java.io.File;
import java.util.ArrayList;

public class qfh
  extends rsx
  implements View.OnTouchListener
{
  private qfk jdField_a_of_type_Qfk;
  private qfl jdField_a_of_type_Qfl;
  
  public qfh(Context paramContext, int paramInt)
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
        localURLDrawableOptions.mPlayGifImage = aupa.a(paramString);
        localURLDrawableOptions.mLoadingDrawable = ReadInJoyDeliverUGCActivity.a;
        localURLDrawableOptions.mFailedDrawable = ReadInJoyDeliverUGCActivity.a;
        localURLDrawableOptions.mUseAutoScaleParams = false;
        localURLDrawableOptions.mRequestWidth = bbll.b(114.0F);
        localURLDrawableOptions.mRequestHeight = bbll.b(114.0F);
        return URLDrawable.getDrawable(localFile, localURLDrawableOptions);
      }
    }
    return null;
  }
  
  public void a(qfk paramqfk)
  {
    this.jdField_a_of_type_Qfk = paramqfk;
  }
  
  public void a(qfl paramqfl)
  {
    this.jdField_a_of_type_Qfl = paramqfl;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560036, null);
      paramViewGroup = new qfj(this, null);
      paramViewGroup.a = ((ImageView)paramView.findViewById(2131378565));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131378562));
      paramView.setTag(paramViewGroup);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (!(localObject instanceof HotPicData)) {
        break label177;
      }
      localObject = ReadInJoyDeliverUGCActivity.a((HotPicData)localObject);
      if (localObject != null)
      {
        paramViewGroup.b.setImageDrawable((Drawable)localObject);
        paramViewGroup.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramViewGroup.a.setVisibility(0);
      }
    }
    for (;;)
    {
      paramViewGroup.b.setTag(Integer.valueOf(paramInt));
      paramViewGroup.a.setTag(Integer.valueOf(paramInt));
      paramViewGroup.b.setOnTouchListener(this);
      paramViewGroup.a.setOnClickListener(new qfi(this));
      return paramView;
      paramViewGroup = (qfj)paramView.getTag();
      break;
      label177:
      if ("".equals(localObject))
      {
        paramViewGroup.b.setImageResource(2130841278);
        paramViewGroup.b.setScaleType(ImageView.ScaleType.CENTER);
        paramViewGroup.a.setVisibility(8);
      }
      else
      {
        localObject = a((String)localObject);
        if (localObject != null)
        {
          paramViewGroup.b.setImageDrawable((Drawable)localObject);
          paramViewGroup.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
          paramViewGroup.a.setVisibility(0);
        }
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Qfl != null) {
      return this.jdField_a_of_type_Qfl.a(paramView, paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qfh
 * JD-Core Version:    0.7.0.1
 */