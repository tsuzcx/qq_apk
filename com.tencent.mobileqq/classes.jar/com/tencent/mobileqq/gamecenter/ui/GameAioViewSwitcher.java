package com.tencent.mobileqq.gamecenter.ui;

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
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.util.CommonUtils;
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
  private CornerImageView jdField_a_of_type_ComTencentMobileqqGamecenterUiCornerImageView;
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
      return;
    }
    setInAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    setOutAnimation(this.b);
    if (this.jdField_a_of_type_JavaUtilList.size() >= this.jdField_a_of_type_Int)
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2130840667);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getResources().getDrawable(2130840667);
      localObject = URLDrawable.getDrawable((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int), (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterUiCornerImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilList.size()) {
        this.jdField_a_of_type_Int = 0;
      }
      setDisplayedChild(1);
    }
  }
  
  public void a(Context paramContext)
  {
    this.c = AnimationUtils.loadAnimation(paramContext, 2130772388);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(paramContext, 2130772389);
    this.d = AnimationUtils.loadAnimation(paramContext, 2130772390);
    this.b = AnimationUtils.loadAnimation(paramContext, 2130772391);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterUiCornerImageView = new CornerImageView(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterUiCornerImageView.setRadius(CommonUtils.a(12.0F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterUiCornerImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, 0, paramContext);
    addView(this.jdField_a_of_type_ComTencentMobileqqGamecenterUiCornerImageView, 1, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840173);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterUiCornerImageView.setImageResource(2130840667);
    setDisplayedChild(0);
  }
  
  public void b()
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localMqqHandler != null) {
      localMqqHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return true;
    }
    a(paramMessage.arg1);
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    int i = paramMessage.arg1 + 1;
    paramMessage.arg1 = i;
    localMessage.arg1 = i;
    if (localMessage.arg1 < this.jdField_a_of_type_JavaUtilList.size() * 2 + 1) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 2000L);
    }
    return true;
  }
  
  public void setData(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = this.jdField_a_of_type_JavaUtilList;
    if ((paramList != null) && (paramList.size() > 0))
    {
      ThreadManagerV2.excute(new GameAioViewSwitcher.1(this), 128, null, true);
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.ui.GameAioViewSwitcher
 * JD-Core Version:    0.7.0.1
 */