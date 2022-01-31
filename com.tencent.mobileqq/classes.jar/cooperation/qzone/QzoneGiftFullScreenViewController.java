package cooperation.qzone;

import amcl;
import amcm;
import amcn;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicfaceRenderListener;
import com.tencent.mobileqq.magicface.service.MagicfacePlayManager;
import com.tencent.mobileqq.magicface.view.IMagicFaceView;
import com.tencent.mobileqq.magicface.view.MagicfaceContainerView;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class QzoneGiftFullScreenViewController
  implements View.OnClickListener
{
  public static boolean a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  public Handler a;
  protected View a;
  protected WindowManager a;
  public Button a;
  protected ImageView a;
  protected ActionGlobalData a;
  public IMagicFaceView a;
  protected MagicfaceContainerView a;
  public QzoneGiftFullScreenActionManager a;
  protected String a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  protected View b;
  protected boolean b;
  
  static
  {
    String str = DeviceInfoUtil.h();
    if (str != null)
    {
      str = str.toLowerCase();
      if ((str.contains("marvell")) || (str.contains("armv5")) || (str.contains("armv6"))) {
        jdField_a_of_type_Boolean = false;
      }
    }
    else
    {
      return;
    }
    jdField_a_of_type_Boolean = true;
  }
  
  public QzoneGiftFullScreenViewController(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    a();
  }
  
  private void a()
  {
    if (!DeviceInfoUtil.d())
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    if (Math.min(DeviceInfoUtil.h(), DeviceInfoUtil.i()) >= 720L)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.type = 2002;
    localLayoutParams.flags = 131112;
    localLayoutParams.gravity = 51;
    localLayoutParams.x = 0;
    localLayoutParams.y = paramInt;
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localLayoutParams.format = 1;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)BaseApplicationImpl.getContext().getSystemService("window"));
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
      label89:
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      return;
    }
    catch (Exception localException)
    {
      break label89;
    }
  }
  
  public static boolean a()
  {
    if ((DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.magicface_support.name())) && (jdField_a_of_type_Boolean) && (DecoderUtil.IS_LOAD_SUCESS))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneGiftFullScreenViewController", 2, "is_support_magic:TRUE");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneGiftFullScreenViewController", 2, "is_support_magic:FALSE");
    }
    return false;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView == null) {
      if (!this.jdField_b_of_type_Boolean) {
        break label126;
      }
    }
    label126:
    for (View localView = View.inflate(BaseApplicationImpl.getContext(), 2130970911, null);; localView = View.inflate(BaseApplicationImpl.getContext(), 2130970913, null))
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(BaseApplicationImpl.getContext(), 2130970915, null);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372192);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView = ((IMagicFaceView)localView.findViewById(2131366101));
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView = ((MagicfaceContainerView)localView.findViewById(2131366100));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131366102));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372194));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager != null) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(null);
      ((View)this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView.setSurfaceCreatelistener(null);
    }
    try
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).removeView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        if (this.jdField_a_of_type_AndroidViewWindowManager != null) {
          this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
        }
      }
      label109:
      if (this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager.a())
      {
        QzoneGiftFullScreenActionManager localQzoneGiftFullScreenActionManager = this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager;
        localQzoneGiftFullScreenActionManager.a(new amcl(this, localQzoneGiftFullScreenActionManager));
        return;
      }
      this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager.a();
      return;
    }
    catch (Exception localException)
    {
      break label109;
    }
  }
  
  public View a(String paramString1, String paramString2, QzoneGiftFullScreenViewController.GiftFullScreenPlayListener paramGiftFullScreenPlayListener)
  {
    return a(paramString1, paramString2, false, paramGiftFullScreenPlayListener);
  }
  
  public View a(String paramString1, String paramString2, boolean paramBoolean, QzoneGiftFullScreenViewController.GiftFullScreenPlayListener paramGiftFullScreenPlayListener)
  {
    try
    {
      long l = System.currentTimeMillis();
      if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView != null) && (((View)this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).getVisibility() == 0))
      {
        localObject1 = new QzoneGiftFullScreenViewController.MagicData(this);
        ((QzoneGiftFullScreenViewController.MagicData)localObject1).jdField_a_of_type_JavaLangString = paramString1;
        ((QzoneGiftFullScreenViewController.MagicData)localObject1).jdField_a_of_type_Boolean = paramBoolean;
        ((QzoneGiftFullScreenViewController.MagicData)localObject1).b = paramString2;
        ((QzoneGiftFullScreenViewController.MagicData)localObject1).jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController$GiftFullScreenPlayListener = paramGiftFullScreenPlayListener;
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
        return null;
      }
      if ((this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager != null) && (this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager.a())) {
        return null;
      }
      if (this.jdField_a_of_type_AndroidAppActivity == null) {
        return null;
      }
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = QzoneGiftFullScreenActionManager.a(paramString1, paramString2);
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData == null) {
        return null;
      }
      this.jdField_a_of_type_JavaLangString = paramString1;
      b();
      this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager = new QzoneGiftFullScreenActionManager(this);
      Object localObject1 = (ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
      ((ViewGroup)localObject1).removeView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      Object localObject2 = new Rect();
      ((ViewGroup)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
      int i = ((Rect)localObject2).top;
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.updateViewLayout((View)this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView, (ViewGroup.LayoutParams)localObject2);
      if (!paramBoolean) {
        a(0);
      }
      ((ViewGroup)localObject1).addView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      if (paramBoolean)
      {
        localObject1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).topMargin = ViewUtils.a(75.0F);
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = ViewUtils.a(75.0F);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = ViewUtils.a(15.0F);
        ((FrameLayout.LayoutParams)localObject1).rightMargin = ViewUtils.a(15.0F);
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView.setIsFullScreen(false);
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setTouchEffect(true);
        ((View)this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).setClickable(false);
        ((View)this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).setFocusable(false);
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setClickable(false);
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setFocusable(false);
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new amcm(this));
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView.setIsFullScreen(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ((View)localObject1).setVisibility(0);
      ((SurfaceView)localObject1).setZOrderOnTop(true);
      ((SurfaceView)localObject1).getHolder().setFormat(-2);
      localObject2 = new MagicfacePlayManager();
      ((MagicfacePlayManager)localObject2).a((MagicfaceDecoder.MagicfaceRenderListener)localObject1);
      this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager.a((MagicfacePlayManager)localObject2);
      this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager.a(new amcn(this, l, paramGiftFullScreenPlayListener));
      this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager.a(paramString1, paramString2);
    }
    catch (SecurityException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView;
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.getVisibility() != 8))
    {
      c();
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenViewController
 * JD-Core Version:    0.7.0.1
 */