import android.os.Handler;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.tencent.biz.now.NowVideoView;
import com.tencent.biz.now.NowVideoView.2.1;
import com.tencent.image.QQLiveDrawable.ErrorInfo;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ngi
  implements QQLiveDrawable.OnStateListener
{
  public ngi(NowVideoView paramNowVideoView) {}
  
  public void onStateChange(String paramString, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, int paramInt, Object paramObject)
  {
    this.a.c = this.a.d;
    this.a.d = paramInt;
    paramString = this.a.jdField_a_of_type_AndroidWidgetImageView;
    boolean bool = ngf.a().b;
    if (paramInt == 3)
    {
      if (this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation == null)
      {
        this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
        this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(500L);
        this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatCount(-1);
        this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatMode(1);
        this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setStartTime(-1L);
        paramQQLiveDrawableParams = new LinearInterpolator();
        this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setInterpolator(paramQQLiveDrawableParams);
      }
      if (paramString != null)
      {
        paramString.setVisibility(0);
        paramString.setImageResource(2130842834);
        paramString.clearAnimation();
        this.a.jdField_a_of_type_AndroidOsHandler.post(new NowVideoView.2.1(this, paramString));
      }
    }
    for (;;)
    {
      this.a.a(this.a.c, this.a.d);
      return;
      if (paramInt == 0)
      {
        if (paramString != null)
        {
          paramString.clearAnimation();
          paramString.setImageResource(2130842836);
          paramString.setVisibility(0);
        }
      }
      else if (paramInt == 4)
      {
        if ((paramString != null) && (!bool))
        {
          paramString.clearAnimation();
          paramString.setImageResource(2130842836);
          paramString.setVisibility(0);
        }
      }
      else if (paramInt == 2)
      {
        if (paramString != null)
        {
          paramString.clearAnimation();
          paramString.setVisibility(8);
        }
        this.a.e = 0;
        this.a.f = 0;
        this.a.a(1);
      }
      else if (paramInt == 5)
      {
        if (paramString != null)
        {
          paramString.clearAnimation();
          paramString.setVisibility(0);
          paramString.setImageResource(2130842832);
        }
        if (!bdin.g(this.a.getContext()))
        {
          QQToast.a(this.a.getContext(), 1, 2131694769, 0).b(NowVideoView.g);
          return;
        }
        if (this.a.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          this.a.jdField_a_of_type_JavaUtilList.remove(this.a.jdField_a_of_type_JavaUtilList.get(this.a.jdField_a_of_type_JavaUtilList.size() - 1));
          this.a.jdField_a_of_type_Ngj.a();
        }
        if ((this.a.jdField_a_of_type_JavaUtilList.size() == 0) && ((paramObject instanceof QQLiveDrawable.ErrorInfo)))
        {
          paramString = (QQLiveDrawable.ErrorInfo)paramObject;
          QLog.d("NowVideoView", 2, "ErrorInf = " + paramString.toString());
        }
      }
      else if (paramInt != 1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ngi
 * JD-Core Version:    0.7.0.1
 */