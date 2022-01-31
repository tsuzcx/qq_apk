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

public class qpn
  extends sjk
  implements View.OnTouchListener
{
  private qpq jdField_a_of_type_Qpq;
  private qpr jdField_a_of_type_Qpr;
  
  public qpn(Context paramContext, int paramInt)
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
        localURLDrawableOptions.mPlayGifImage = awkr.a(paramString);
        localURLDrawableOptions.mLoadingDrawable = ReadInJoyDeliverUGCActivity.a;
        localURLDrawableOptions.mFailedDrawable = ReadInJoyDeliverUGCActivity.a;
        localURLDrawableOptions.mUseAutoScaleParams = false;
        localURLDrawableOptions.mRequestWidth = bdoo.b(114.0F);
        localURLDrawableOptions.mRequestHeight = bdoo.b(114.0F);
        return URLDrawable.getDrawable(localFile, localURLDrawableOptions);
      }
    }
    return null;
  }
  
  public void a(qpq paramqpq)
  {
    this.jdField_a_of_type_Qpq = paramqpq;
  }
  
  public void a(qpr paramqpr)
  {
    this.jdField_a_of_type_Qpr = paramqpr;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560136, null);
      paramViewGroup = new qpp(this, null);
      paramViewGroup.a = ((ImageView)paramView.findViewById(2131379238));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131379235));
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
      paramViewGroup.a.setOnClickListener(new qpo(this));
      return paramView;
      paramViewGroup = (qpp)paramView.getTag();
      break;
      label177:
      if ("".equals(localObject))
      {
        paramViewGroup.b.setImageResource(2130841399);
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
    if (this.jdField_a_of_type_Qpr != null) {
      return this.jdField_a_of_type_Qpr.a(paramView, paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qpn
 * JD-Core Version:    0.7.0.1
 */