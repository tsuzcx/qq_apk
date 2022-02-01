package cooperation.qzone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
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
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicfaceRenderListener;
import com.tencent.mobileqq.magicface.service.MagicfacePlayManager;
import com.tencent.mobileqq.magicface.view.IMagicFaceView;
import com.tencent.mobileqq.magicface.view.MagicfaceContainerView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class QzoneGiftFullScreenViewController
  implements View.OnClickListener
{
  public static boolean IS_SUPPORT_MAGICFACE = true;
  public static final String TAG = "QzoneGiftFullScreenViewController";
  protected ActionGlobalData actionGlobalData;
  protected String epId;
  protected boolean isUseHardDecode;
  private Activity mActivity;
  protected WindowManager mWindowManager;
  private List<QzoneGiftFullScreenViewController.MagicData> magicDatas = new ArrayList();
  public QzoneGiftFullScreenActionManager magicfaceActionManager;
  protected MagicfaceContainerView magicfaceReceiveContent;
  protected IMagicFaceView magicfaceReceivePlay;
  protected Button magicfaceReceiveStop;
  protected ImageView magicfaceTip;
  protected View topbar;
  protected View topbarBgView;
  protected Handler uiHandler;
  
  static
  {
    String str = DeviceInfoUtil.g();
    if (str != null)
    {
      str = str.toLowerCase();
      if ((str.contains("marvell")) || (str.contains("armv5")) || (str.contains("armv6"))) {
        IS_SUPPORT_MAGICFACE = false;
      }
    }
    else
    {
      return;
    }
  }
  
  public QzoneGiftFullScreenViewController(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.uiHandler = new Handler(Looper.getMainLooper());
    checkHardDecodeCondition();
  }
  
  private void checkHardDecodeCondition()
  {
    if (!DeviceInfoUtil.d())
    {
      this.isUseHardDecode = false;
      return;
    }
    if (Math.min(DeviceInfoUtil.g(), DeviceInfoUtil.h()) >= 720L)
    {
      this.isUseHardDecode = true;
      return;
    }
    this.isUseHardDecode = false;
  }
  
  private void initMagicfaceView()
  {
    if (this.magicfaceReceiveContent == null) {
      if (!this.isUseHardDecode) {
        break label126;
      }
    }
    label126:
    for (View localView = View.inflate(BaseApplicationImpl.getContext(), 2131562099, null);; localView = View.inflate(BaseApplicationImpl.getContext(), 2131562101, null))
    {
      this.topbar = View.inflate(BaseApplicationImpl.getContext(), 2131562103, null);
      this.topbarBgView = this.topbar.findViewById(2131370981);
      this.magicfaceReceivePlay = ((IMagicFaceView)localView.findViewById(2131370974));
      this.magicfaceReceiveContent = ((MagicfaceContainerView)localView.findViewById(2131370976));
      this.magicfaceReceiveStop = ((Button)this.topbar.findViewById(2131370975));
      this.magicfaceReceiveStop.setVisibility(8);
      this.magicfaceTip = ((ImageView)this.topbar.findViewById(2131370979));
      this.magicfaceReceiveStop.setOnClickListener(this);
      return;
    }
  }
  
  private void initTopbar(int paramInt)
  {
    if (this.topbar == null) {}
    for (;;)
    {
      return;
      Object localObject = BaseApplicationImpl.getApplication();
      if (localObject != null)
      {
        if (Build.VERSION.SDK_INT >= 23) {
          if (!Settings.canDrawOverlays((Context)localObject)) {
            ((Context)localObject).startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION"));
          }
        }
        for (int i = 0; i != 0; i = 1) {
          for (;;)
          {
            localObject = new WindowManager.LayoutParams();
            ((WindowManager.LayoutParams)localObject).type = 2002;
            ((WindowManager.LayoutParams)localObject).flags = 131112;
            ((WindowManager.LayoutParams)localObject).gravity = 51;
            ((WindowManager.LayoutParams)localObject).x = 0;
            ((WindowManager.LayoutParams)localObject).y = paramInt;
            ((WindowManager.LayoutParams)localObject).width = -1;
            ((WindowManager.LayoutParams)localObject).height = -2;
            ((WindowManager.LayoutParams)localObject).format = 1;
            this.mWindowManager = ((WindowManager)BaseApplicationImpl.getContext().getSystemService("window"));
            if (this.topbar.getParent() != null) {}
            try
            {
              this.mWindowManager.removeView(this.topbar);
              try
              {
                this.mWindowManager.addView(this.topbar, (ViewGroup.LayoutParams)localObject);
                return;
              }
              catch (Exception localException1)
              {
                QLog.e("QzoneGiftFullScreenViewController", 1, "initTopbar: ", localException1);
                return;
              }
              if (localException1.checkSelfPermission("android.settings.action.MANAGE_WRITE_SETTINGS") != 0)
              {
                localException1.startActivity(new Intent("android.settings.action.MANAGE_WRITE_SETTINGS"));
                i = 0;
              }
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                QLog.e("QzoneGiftFullScreenViewController", 1, "initTopbar: ", localException2);
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean isSupportMagicface()
  {
    if ((((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.magicface_support.name())) && (IS_SUPPORT_MAGICFACE) && (DecoderUtil.IS_LOAD_SUCESS))
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
  
  private void magicfaceClose()
  {
    if ((this.magicfaceActionManager != null) && (this.mActivity != null))
    {
      this.magicfaceReceiveContent.setVisibility(8);
      this.magicfaceReceiveContent.setMagicfaceGestureListener(null);
      ((View)this.magicfaceReceivePlay).setVisibility(8);
      this.magicfaceReceivePlay.setSurfaceCreatelistener(null);
    }
    try
    {
      ((ViewGroup)this.mActivity.getWindow().getDecorView()).removeView(this.magicfaceReceiveContent);
      if (this.topbar != null)
      {
        this.topbar.setVisibility(8);
        if (this.mWindowManager != null) {
          this.mWindowManager.removeView(this.topbar);
        }
      }
      label109:
      if (this.magicfaceActionManager.isStart())
      {
        QzoneGiftFullScreenActionManager localQzoneGiftFullScreenActionManager = this.magicfaceActionManager;
        localQzoneGiftFullScreenActionManager.close(new QzoneGiftFullScreenViewController.1(this, localQzoneGiftFullScreenActionManager));
        return;
      }
      this.magicfaceActionManager.release();
      return;
    }
    catch (Exception localException)
    {
      break label109;
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.magicfaceActionManager != null) && (this.magicfaceReceiveContent.getVisibility() != 8))
    {
      magicfaceClose();
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      magicfaceClose();
    }
  }
  
  public View playMaigcface(String paramString1, String paramString2, QzoneGiftFullScreenViewController.GiftFullScreenPlayListener paramGiftFullScreenPlayListener)
  {
    return playMaigcface(paramString1, paramString2, false, paramGiftFullScreenPlayListener);
  }
  
  public View playMaigcface(String paramString1, String paramString2, boolean paramBoolean, QzoneGiftFullScreenViewController.GiftFullScreenPlayListener paramGiftFullScreenPlayListener)
  {
    if (Build.VERSION.SDK_INT <= 17) {
      return null;
    }
    try
    {
      long l = System.currentTimeMillis();
      if ((this.magicfaceReceivePlay != null) && (((View)this.magicfaceReceivePlay).getVisibility() == 0))
      {
        localObject1 = new QzoneGiftFullScreenViewController.MagicData(this);
        ((QzoneGiftFullScreenViewController.MagicData)localObject1).emotionId = paramString1;
        ((QzoneGiftFullScreenViewController.MagicData)localObject1).isPassivePraise = paramBoolean;
        ((QzoneGiftFullScreenViewController.MagicData)localObject1).maigcPath = paramString2;
        ((QzoneGiftFullScreenViewController.MagicData)localObject1).playListener = paramGiftFullScreenPlayListener;
        this.magicDatas.add(localObject1);
        return null;
      }
      if ((this.magicfaceActionManager != null) && (this.magicfaceActionManager.isStart())) {
        return null;
      }
      if (this.mActivity == null) {
        return null;
      }
      this.actionGlobalData = QzoneGiftFullScreenActionManager.hasAction(paramString1, paramString2);
      if (this.actionGlobalData == null) {
        return null;
      }
      this.epId = paramString1;
      initMagicfaceView();
      this.magicfaceActionManager = new QzoneGiftFullScreenActionManager(this);
      Object localObject1 = (ViewGroup)this.mActivity.getWindow().getDecorView();
      ((ViewGroup)localObject1).removeView(this.magicfaceReceiveContent);
      Object localObject2 = new Rect();
      ((ViewGroup)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
      int i = ((Rect)localObject2).top;
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      this.topbarBgView.setBackgroundColor(0);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
      this.magicfaceReceiveContent.updateViewLayout((View)this.magicfaceReceivePlay, (ViewGroup.LayoutParams)localObject2);
      if (!paramBoolean) {
        initTopbar(0);
      }
      ((ViewGroup)localObject1).addView(this.magicfaceReceiveContent);
      if (paramBoolean)
      {
        localObject1 = (FrameLayout.LayoutParams)this.magicfaceReceiveContent.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).topMargin = ViewUtils.a(75.0F);
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = ViewUtils.a(75.0F);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = ViewUtils.a(15.0F);
        ((FrameLayout.LayoutParams)localObject1).rightMargin = ViewUtils.a(15.0F);
        this.magicfaceReceivePlay.setIsFullScreen(false);
        this.magicfaceReceiveContent.setTouchEffect(true);
        ((View)this.magicfaceReceivePlay).setClickable(false);
        ((View)this.magicfaceReceivePlay).setFocusable(false);
        this.magicfaceReceiveContent.setClickable(false);
        this.magicfaceReceiveContent.setFocusable(false);
      }
      this.uiHandler.post(new QzoneGiftFullScreenViewController.2(this));
      this.magicfaceReceiveContent.setVisibility(8);
      ((View)this.magicfaceReceivePlay).setVisibility(8);
      this.magicfaceReceiveContent.setVisibility(0);
      this.magicfaceReceivePlay.setIsFullScreen(this.actionGlobalData.b);
      this.topbar.setVisibility(0);
      localObject1 = this.magicfaceReceivePlay;
      this.magicfaceTip.setVisibility(8);
      ((View)localObject1).setVisibility(0);
      ((SurfaceView)localObject1).setZOrderOnTop(true);
      ((SurfaceView)localObject1).getHolder().setFormat(-2);
      localObject2 = new MagicfacePlayManager();
      ((MagicfacePlayManager)localObject2).a((MagicfaceDecoder.MagicfaceRenderListener)localObject1);
      this.magicfaceActionManager.setMagicfacePlayManager((MagicfacePlayManager)localObject2);
      this.magicfaceActionManager.setMagicfaceActionListener(new QzoneGiftFullScreenViewController.3(this, l, paramGiftFullScreenPlayListener));
      this.magicfaceActionManager.doAction(paramString1, paramString2);
    }
    catch (SecurityException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
    return this.magicfaceReceiveContent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenViewController
 * JD-Core Version:    0.7.0.1
 */