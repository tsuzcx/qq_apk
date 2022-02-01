package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.List;
import mqq.os.MqqHandler;

public class GameAioViewSwitcher
  extends ViewSwitcher
  implements Handler.Callback
{
  private int jdField_a_of_type_Int = 0;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private CornerImageView jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView;
  private List<String> jdField_a_of_type_JavaUtilList;
  protected final MqqHandler a;
  private Animation b;
  private Animation c;
  private Animation d;
  
  public GameAioViewSwitcher(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    a(paramContext);
  }
  
  public GameAioViewSwitcher(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    a(paramContext);
  }
  
  public void a()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = 1;
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 2000L);
  }
  
  public void a(int paramInt)
  {
    if (paramInt % 2 == 0)
    {
      setInAnimation(this.c);
      setOutAnimation(this.d);
      setDisplayedChild(0);
    }
    do
    {
      return;
      setInAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      setOutAnimation(this.b);
    } while (this.jdField_a_of_type_JavaUtilList.size() < this.jdField_a_of_type_Int);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2130840792);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getResources().getDrawable(2130840792);
    localObject = URLDrawable.getDrawable((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int), (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilList.size()) {
      this.jdField_a_of_type_Int = 0;
    }
    setDisplayedChild(1);
  }
  
  public void a(Context paramContext)
  {
    this.c = AnimationUtils.loadAnimation(paramContext, 2130772356);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(paramContext, 2130772357);
    this.d = AnimationUtils.loadAnimation(paramContext, 2130772358);
    this.b = AnimationUtils.loadAnimation(paramContext, 2130772359);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = new CornerImageView(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(AIOUtils.a(12.0F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, 0, paramContext);
    addView(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, 1, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840314);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageResource(2130840792);
    setDisplayedChild(0);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Message localMessage;
    do
    {
      return true;
      a(paramMessage.arg1);
      localMessage = Message.obtain();
      localMessage.what = 1;
      int i = paramMessage.arg1 + 1;
      paramMessage.arg1 = i;
      localMessage.arg1 = i;
    } while (localMessage.arg1 >= this.jdField_a_of_type_JavaUtilList.size() * 2 + 1);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 2000L);
    return true;
  }
  
  public void setData(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      ThreadManagerV2.excute(new GameAioViewSwitcher.1(this), 128, null, true);
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameAioViewSwitcher
 * JD-Core Version:    0.7.0.1
 */