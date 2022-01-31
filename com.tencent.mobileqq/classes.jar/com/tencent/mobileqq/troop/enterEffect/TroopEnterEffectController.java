package com.tencent.mobileqq.troop.enterEffect;

import ajff;
import ajfg;
import ajfh;
import ajfr;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Vector;

public class TroopEnterEffectController
{
  public static final String a;
  public Handler a;
  public SparseArray a;
  public LinearLayout a;
  public RelativeLayout a;
  public ScrollView a;
  protected QQAppInterface a;
  public SpriteGLView a;
  protected TroopEnterEffectManager a;
  private VasQuickUpdateManager.CallBacker a;
  protected DownloaderInterface a;
  public boolean a;
  public String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aJ + ".troop/enter_effects/";
  }
  
  public TroopEnterEffectController(QQAppInterface paramQQAppInterface, RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new ajfr(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = ((DownloaderFactory)paramQQAppInterface.getManager(46)).a(1);
    this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectManager = ((TroopEnterEffectManager)paramQQAppInterface.getManager(230));
    ((VasQuickUpdateManager)paramQQAppInterface.getManager(183)).a(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
  }
  
  public static int a(String paramString)
  {
    if (paramString.startsWith("groupeffect_item_"))
    {
      paramString = paramString.substring("groupeffect_item_".length(), paramString.length() - ".zip".length());
      if ((!TextUtils.isEmpty(paramString)) && (TextUtils.isDigitsOnly(paramString))) {
        return Integer.parseInt(paramString);
      }
    }
    return -1;
  }
  
  private TroopEnterEffectConfig.GrayTipsConfig a()
  {
    TroopEnterEffectManager localTroopEnterEffectManager = (TroopEnterEffectManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(230);
    boolean bool = localTroopEnterEffectManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "getGrayTips isShowEnterEffectEveryTime = " + false + " hasShowToday = " + bool);
    }
    if (!bool)
    {
      TroopEnterEffectConfig localTroopEnterEffectConfig = localTroopEnterEffectManager.a();
      if (localTroopEnterEffectConfig.a.size() > 0)
      {
        int k = VasUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        int i;
        int j;
        if (localTroopEnterEffectManager.b(this.b))
        {
          i = 2;
          j = 0;
        }
        for (;;)
        {
          if (j >= localTroopEnterEffectConfig.a.size()) {
            break label254;
          }
          TroopEnterEffectConfig.GrayTipsConfig localGrayTipsConfig = (TroopEnterEffectConfig.GrayTipsConfig)localTroopEnterEffectConfig.a.get(j);
          bool = localTroopEnterEffectManager.a().getBoolean("gray_tips_no_longer_" + localGrayTipsConfig.jdField_a_of_type_Int, false);
          if (QLog.isColorLevel()) {
            QLog.d("TroopEnterEffect.Controller", 2, "getGrayTips id = " + localGrayTipsConfig.jdField_a_of_type_Int + " nolongerShow = " + bool);
          }
          if ((!bool) && (localGrayTipsConfig.a(i, k)))
          {
            return localGrayTipsConfig;
            i = 1;
            break;
          }
          j += 1;
        }
      }
    }
    label254:
    return null;
  }
  
  public static String a(int paramInt)
  {
    return jdField_a_of_type_JavaLangString + paramInt + File.separator + paramInt + ".zip";
  }
  
  public void a()
  {
    if (DeviceInfoUtil.e()) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect.Controller", 2, "playAnimaions: isLowEndPhoneForPreDownload = true");
      }
    }
    TroopEnterEffectController.TroopEnterEffectData localTroopEnterEffectData;
    do
    {
      return;
      localTroopEnterEffectData = this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectManager.a(this.b);
    } while ((localTroopEnterEffectData == null) || (!a(localTroopEnterEffectData)));
    if (System.currentTimeMillis() - localTroopEnterEffectData.jdField_a_of_type_Long < 60000L)
    {
      a(localTroopEnterEffectData);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectManager.b(localTroopEnterEffectData);
  }
  
  public void a(TroopEnterEffectController.TroopEnterEffectData paramTroopEnterEffectData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "showAnimation: enterEffectData = " + paramTroopEnterEffectData + " isAio = " + this.jdField_a_of_type_Boolean);
    }
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    View localView2;
    View localView3;
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals(paramTroopEnterEffectData.jdField_a_of_type_JavaLangString))) {
        break label461;
      }
      VasWebviewUtil.reportCommercialDrainage((String)localObject, "style", "0X8008E5F", "", 1, 0, 0, "", Integer.toString(paramTroopEnterEffectData.jdField_a_of_type_Int), "");
      this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectManager.b(paramTroopEnterEffectData);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = new SpriteGLView(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 1);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b = true;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, 0);
      View localView1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368277);
      localView2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362422);
      localView3 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363508);
      if ((localView1 == null) || (localView1.getVisibility() != 0)) {
        break label493;
      }
      localLayoutParams.topMargin = localView1.getBottom();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
      }
      if (this.jdField_a_of_type_AndroidWidgetScrollView == null)
      {
        this.jdField_a_of_type_AndroidWidgetScrollView = new ajff(this, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
        this.jdField_a_of_type_AndroidWidgetScrollView.setClickable(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, -1, DisplayUtil.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight()));
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetScrollView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, -1, 0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.bringChildToFront(this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363494));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.bringChildToFront(this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363500));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.bringChildToFront(this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363493));
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.setOnTouchListener(new ajfg(this, (String)localObject, paramTroopEnterEffectData));
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.post(new ajfh(this, paramTroopEnterEffectData));
      paramTroopEnterEffectData = (TroopEnterEffectManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(230);
      localObject = a();
      if (localObject != null) {
        paramTroopEnterEffectData.a((TroopEnterEffectConfig.GrayTipsConfig)localObject, this.b);
      }
      TroopEnterEffectManager.a("Grp_AIO", "action_play", new String[0]);
      return;
      label461:
      VasWebviewUtil.reportCommercialDrainage((String)localObject, "style", "0X8008E60", "", 1, 0, 0, "", Integer.toString(paramTroopEnterEffectData.jdField_a_of_type_Int), "");
      break;
      label493:
      if ((localView2 != null) && (localView2.getVisibility() == 0)) {
        localLayoutParams.topMargin = localView2.getBottom();
      } else if ((localView3 != null) && (localView3.getVisibility() == 0)) {
        localLayoutParams.topMargin = localView3.getBottom();
      } else {
        localLayoutParams.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 50.0F);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public boolean a(TroopEnterEffectController.TroopEnterEffectData paramTroopEnterEffectData)
  {
    int i = paramTroopEnterEffectData.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "downloadAnimationResources: id = " + i);
    }
    String str = jdField_a_of_type_JavaLangString + i;
    if (TroopGiftUtil.a(new File(str))) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(i) != null) {
      return false;
    }
    FileUtils.a(str);
    ((VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(183)).a(25L, "groupeffect_item_" + i + ".zip", "TroopEnterEffectController");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramTroopEnterEffectData);
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "onResume");
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.n();
      this.jdField_a_of_type_AndroidWidgetScrollView.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetScrollView);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = null;
      this.jdField_a_of_type_AndroidWidgetScrollView = null;
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectManager.b(this.b);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "onDestroy remove quickupdate callback");
    }
    ((VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(183)).b(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController
 * JD-Core Version:    0.7.0.1
 */