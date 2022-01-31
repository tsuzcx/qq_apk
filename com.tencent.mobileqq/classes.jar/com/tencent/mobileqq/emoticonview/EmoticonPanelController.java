package com.tencent.mobileqq.emoticonview;

import alof;
import alud;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Handler;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import apno;
import apsf;
import aptd;
import apuc;
import apue;
import apuj;
import apuo;
import apuu;
import apuv;
import apuw;
import apux;
import apuz;
import apvd;
import apvi;
import apvo;
import apvp;
import apvu;
import apvv;
import apvx;
import apwv;
import apww;
import apwy;
import apxa;
import apyt;
import astc;
import aufn;
import azqs;
import bdnm;
import bdnn;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

public class EmoticonPanelController
  implements ViewPager.OnPageChangeListener, apww
{
  public static boolean a;
  public static int b;
  public static int d;
  static boolean jdField_f_of_type_Boolean;
  public float a;
  public int a;
  public final Context a;
  View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public apuc a;
  private apue jdField_a_of_type_Apue;
  private apuj jdField_a_of_type_Apuj;
  private apuo jdField_a_of_type_Apuo;
  public apux a;
  private apuz jdField_a_of_type_Apuz;
  private apvd jdField_a_of_type_Apvd;
  private apvi jdField_a_of_type_Apvi;
  private apvo jdField_a_of_type_Apvo;
  private apvp jdField_a_of_type_Apvp;
  public apvu a;
  private apyt jdField_a_of_type_Apyt;
  public astc a;
  public BaseChatPie a;
  public QQAppInterface a;
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  public EmotionPanelViewPagerAdapter a;
  public HorizontalListViewEx a;
  public QQViewPager a;
  List<EmoticonPackage> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int[] jdField_a_of_type_ArrayOfInt;
  public List<apwv> b;
  public boolean b;
  int c;
  public boolean c;
  public boolean d;
  int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int;
  public int g;
  public volatile boolean g;
  public boolean h;
  public boolean i = false;
  boolean j = false;
  public boolean k = true;
  private boolean l;
  
  static
  {
    jdField_b_of_type_Int = -1;
    jdField_a_of_type_Boolean = true;
    f = true;
    jdField_d_of_type_Int = 3;
  }
  
  protected EmoticonPanelController(Context paramContext, EmoticonMainPanel paramEmoticonMainPanel)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_Astc = new astc("emoticon_panel", "com.tencent.mobileqq:tool");
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = paramEmoticonMainPanel;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Apux = new apux(paramEmoticonMainPanel);
    this.jdField_e_of_type_Int = paramContext.getResources().getConfiguration().orientation;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.i = false;
    this.jdField_a_of_type_Apue = new apue(this);
    this.jdField_a_of_type_Apuz = ((apuz)a(1));
    this.jdField_a_of_type_Apvd = ((apvd)a(2));
    this.jdField_a_of_type_Apuo = ((apuo)a(3));
    this.jdField_a_of_type_Apvp = ((apvp)a(4));
    this.jdField_a_of_type_Apvi = ((apvi)a(5));
    this.jdField_a_of_type_Apvo = ((apvo)a(6));
  }
  
  private void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    Object localObject = this.jdField_b_of_type_JavaUtilList;
    int m;
    if ((localObject != null) && (paramInt >= 0))
    {
      m = paramInt;
      if (paramInt < ((List)localObject).size()) {}
    }
    else
    {
      m = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "switchTabMode selectIndex = " + m);
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("clubContentVersion", 0);
    if (localSharedPreferences.getBoolean("force_to_recommend_panel_sp", false)) {
      if ((localObject == null) || ((((List)localObject).size() > jdField_d_of_type_Int) && (((apwv)((List)localObject).get(jdField_d_of_type_Int)).jdField_a_of_type_Int == 8)))
      {
        jdField_b_of_type_Int = jdField_d_of_type_Int;
        m = jdField_d_of_type_Int;
        localSharedPreferences.edit().putBoolean("force_to_recommend_panel_sp", false).apply();
        label166:
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelController", 2, "switchTabMode after recommend calculate, selectIndex = " + m);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i) {
          f(m);
        }
        if ((localObject != null) && (((List)localObject).size() != 0)) {
          break label314;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(null);
      }
    }
    for (;;)
    {
      bdnm.a("AIO_EmoticonPanel_EnterSecond", null);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "[Performance] switchTabMode to , duration:" + (System.currentTimeMillis() - paramLong) + ",mSecondTabInited:" + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i);
      }
      return;
      jdField_b_of_type_Int = m;
      break;
      jdField_b_of_type_Int = m;
      break label166;
      label314:
      paramInt = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.getSelectedItemPosition();
      if ((paramInt != m) || (paramInt == 0))
      {
        if (m == jdField_d_of_type_Int) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setSelection(m);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a((List)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getAdapter() != this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter);
      }
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "[Performance] switchTabMode to , setAdapter duration: " + (System.currentTimeMillis() - l1));
      }
      e(m);
      if ((this.jdField_e_of_type_Boolean) && (m == 0))
      {
        localObject = (apwv)((List)localObject).get(m);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.b((apwv)localObject);
      }
    }
  }
  
  private int b(String paramString)
  {
    return this.jdField_a_of_type_Apvi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_b_of_type_JavaUtilList);
  }
  
  private void r()
  {
    int n = 0;
    if (this.jdField_a_of_type_Apyt == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        int m = n;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c != null)
        {
          GestureDetector localGestureDetector = ((TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c).getGestureDetector();
          m = n;
          if ((localGestureDetector instanceof apyt))
          {
            m = 1;
            this.jdField_a_of_type_Apyt = ((apyt)localGestureDetector);
          }
        }
        if (m == 0)
        {
          this.jdField_a_of_type_Apyt = new apyt(this.jdField_a_of_type_AndroidContentContext, ((TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c).getGestureListener(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          ((TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c).setGestureDetector(this.jdField_a_of_type_Apyt);
        }
      }
      return;
    }
    this.jdField_a_of_type_Apyt.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Apyt.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Apyt.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.getBottom();
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_Apvu == null) {
      return 0;
    }
    return this.jdField_a_of_type_Apvu.a(paramInt);
  }
  
  public int a(String paramString)
  {
    return this.jdField_a_of_type_Apvi.a(paramString, this.jdField_b_of_type_JavaUtilList, jdField_a_of_type_Boolean);
  }
  
  public <T extends aptd> T a(int paramInt)
  {
    return this.jdField_a_of_type_Apue.a(paramInt);
  }
  
  public EmoticonMainPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Apue.a(1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131379906));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter = new EmotionPanelViewPagerAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Apuc, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_g_of_type_Int, this.h);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_c_of_type_Boolean = this.jdField_a_of_type_Apux.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_a_of_type_ArrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_d_of_type_Boolean = a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131365713));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131364764);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx = ((HorizontalListViewEx)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131377388));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setOnItemClickListener(this.jdField_a_of_type_Apvi.a);
    this.jdField_a_of_type_Apvu = new apvu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_g_of_type_Int);
    this.jdField_a_of_type_Apvu.a(b());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setTabAnimateEnable(b());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setAdapter(this.jdField_a_of_type_Apvu);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131365680));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165587));
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165586));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131377353).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165585));
    this.jdField_e_of_type_Boolean = true;
    if (this.jdField_a_of_type_Apux.jdField_c_of_type_Int != -1)
    {
      g(this.jdField_a_of_type_Apux.jdField_c_of_type_Int);
      if (!((apno)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(334)).c()) {
        break label389;
      }
    }
    label389:
    for (jdField_d_of_type_Int = 3;; jdField_d_of_type_Int = 2)
    {
      this.jdField_a_of_type_Apue.a(2);
      return;
      a(this.jdField_a_of_type_Apux.jdField_a_of_type_JavaLangString);
      break;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    switch (paramInt)
    {
    case 100000: 
    default: 
      this.jdField_g_of_type_Int = 0;
      return;
    case 99999: 
      this.jdField_g_of_type_Int = 1;
      return;
    case 100001: 
      this.jdField_g_of_type_Int = 2;
      return;
    case 100002: 
      this.jdField_g_of_type_Int = 3;
      return;
    }
    this.jdField_g_of_type_Int = 4;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Apvp.a(paramInt1, paramInt2);
  }
  
  void a(int paramInt, String paramString)
  {
    int m = 1;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "initEmoticonView 2, selectIndex = " + paramInt + ", defaultEpId = " + paramString);
    }
    r();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_g_of_type_Boolean = false;
    long l1 = System.currentTimeMillis();
    Object localObject = (apno)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(334);
    int n;
    if ((localObject != null) && (this.jdField_a_of_type_Apvu != null) && (((apno)localObject).c()) && (paramInt == this.jdField_a_of_type_Apvu.a(11)))
    {
      n = 1;
      if (apvx.c(this.jdField_c_of_type_Int)) {
        break label388;
      }
      if (paramInt < 2) {
        break label383;
      }
      label127:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.k = false;
    }
    for (;;)
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0);
      localObject = localSharedPreferences.getString("LAST_ADD_EMO_PACKAGE", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i = false;
        this.jdField_b_of_type_Boolean = false;
        localSharedPreferences.edit().remove("LAST_ADD_EMO_PACKAGE").apply();
        localSharedPreferences.edit().remove("LAST_ADD_EMO_PACKAGE_MAGIC").apply();
        m = 0;
        label232:
        if (paramString == null) {
          break label358;
        }
        localObject = paramString;
      }
      for (;;)
      {
        label239:
        if ((n != 0) && (paramString == null)) {
          paramString = null;
        }
        for (;;)
        {
          new QueryTask(new apuv(this, paramInt), new apuw(this, l1)).a(paramString);
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "ep_mall", "show_mine", "", 0, 0, 0, "", "", "");
          return;
          n = 0;
          break;
          if ((this.k) && (this.jdField_b_of_type_Boolean))
          {
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonPanelController", 2, "new pkg downloaded in panel, refresh");
            }
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i = false;
          }
          break label232;
          label358:
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label377;
          }
          break label239;
          paramString = (String)localObject;
          paramInt = m;
        }
        label377:
        localObject = null;
      }
      label383:
      m = paramInt;
      break label127;
      label388:
      m = paramInt;
    }
  }
  
  void a(Canvas paramCanvas)
  {
    if (EmoticonMainPanel.jdField_a_of_type_Long == -1L) {}
    long l1;
    do
    {
      return;
      l1 = System.currentTimeMillis() - EmoticonMainPanel.jdField_a_of_type_Long;
    } while (l1 <= 0L);
    paramCanvas = new HashMap(2);
    if (f)
    {
      m = 1;
      paramCanvas.put("panelMode", "2");
      paramCanvas.put("duration", String.valueOf(l1));
      ThreadManager.post(new EmoticonPanelController.5(this, m, l1, paramCanvas), 5, null, true);
      bdnm.a("AIO_EmoticonPanel_OpenDuration", null);
      if (QLog.isColorLevel())
      {
        QLog.d("EmoticonPanelController", 2, "[Performance] dispatchDraw over, duration=" + l1 + ",openCondition=" + m + ",panelMode=" + "2");
        QLog.d("StressTesting.Emoticon.PanelCreate", 2, "open EmoticonPanel duration=" + l1);
      }
      EmoticonMainPanel.jdField_a_of_type_Long = -1L;
      this.jdField_e_of_type_Boolean = false;
      f = false;
      return;
    }
    if (this.jdField_e_of_type_Boolean) {}
    for (int m = 2;; m = 3) {
      break;
    }
  }
  
  public void a(apuc paramapuc)
  {
    this.jdField_a_of_type_Apuc = paramapuc;
    this.jdField_a_of_type_Apux.jdField_a_of_type_Apuc = paramapuc;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "initEmoticonView 1");
    }
    a(jdField_b_of_type_Int, paramString);
    this.jdField_a_of_type_Apuz.i();
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_d_of_type_Boolean = paramBoolean;
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_a_of_type_ArrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    }
  }
  
  public boolean a()
  {
    return this.l;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Apuc != null) {
      this.jdField_a_of_type_Apuc.b();
    }
    apwv localapwv;
    if ((this.jdField_b_of_type_JavaUtilList != null) && (jdField_b_of_type_Int >= 0) && (jdField_b_of_type_Int < this.jdField_b_of_type_JavaUtilList.size()))
    {
      localapwv = (apwv)this.jdField_b_of_type_JavaUtilList.get(jdField_b_of_type_Int);
      if (localapwv.jdField_a_of_type_Int != 7) {
        break label106;
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A845", "0X800A845", 1, 0, "", "", "", "");
    }
    label106:
    while (localapwv.jdField_a_of_type_Int != 10) {
      return;
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A845", "0X800A845", 2, 0, "", "", "", "");
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Apvo.b(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Apux.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_c_of_type_Boolean = this.jdField_a_of_type_Apux.jdField_b_of_type_Boolean;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Apuz.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Apue.a(5);
  }
  
  public void c(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    if (paramInt != this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getVisibility())
    {
      if (paramInt != 0) {
        break label209;
      }
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration().orientation;
      if (!this.jdField_c_of_type_Boolean) {
        break label193;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i = false;
      jdField_b_of_type_Int -= this.jdField_a_of_type_Int;
      if (jdField_b_of_type_Int < 0) {
        jdField_b_of_type_Int = 0;
      }
      a(null);
      this.jdField_a_of_type_Int = 0;
      this.jdField_c_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_e_of_type_Int = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "[Performance] reopen in aio, duration=" + (System.currentTimeMillis() - l1));
      }
      this.jdField_a_of_type_Apvp.l();
      File localFile = new File(alof.bS);
      if (!localFile.exists())
      {
        boolean bool = localFile.mkdirs();
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelController", 2, "root dir not exist. try to make it. success:" + bool);
        }
      }
      return;
      label193:
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i = false;
      a(null);
    }
    label209:
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelController.1(this), 1L);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Apue.a(4, -1, paramBoolean);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Apuz.c();
  }
  
  public void d()
  {
    bdnm.a(null, "AIO_EmoticonPanel_OnResume");
    this.j = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getVisibility() == 0) && (this.jdField_c_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "onResume, Emoticon pkg moved、added or deleted, refresh");
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i = false;
      jdField_b_of_type_Int -= this.jdField_a_of_type_Int;
      if (jdField_b_of_type_Int < 0) {
        jdField_b_of_type_Int = 0;
      }
      a(jdField_b_of_type_Int, null);
      this.jdField_a_of_type_Int = 0;
      this.jdField_c_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_Apue.a(6);
      bdnm.a("AIO_EmoticonPanel_OnResume", null);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.isShown())
      {
        if ((apvx.c(this.jdField_c_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0).getString("LAST_ADD_EMO_PACKAGE", ""))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonPanelController", 2, "download in market, initEmoticonView");
          }
          a(0, null);
        }
        q();
        this.jdField_a_of_type_Apuo.k();
      }
    }
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "switchTabMode selectIndex = " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    long l1 = System.currentTimeMillis();
    bdnm.a(null, "AIO_EmoticonPanel_EnterSecond");
    if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i)
    {
      this.jdField_a_of_type_Apvi.a(this.k, new apuu(this, paramInt, l1));
      return;
    }
    a(l1, paramInt);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i) {}
    while (this.jdField_a_of_type_Apuj == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList = this.jdField_a_of_type_Apuj.a(paramBoolean, this.jdField_a_of_type_Apux.jdField_d_of_type_Boolean);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.j = false;
    this.jdField_a_of_type_Apue.a(7);
  }
  
  public void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "showPanelByTabIndex tabIndex = " + paramInt);
    }
    apwv localapwv = null;
    List localList = this.jdField_b_of_type_JavaUtilList;
    if (paramInt < localList.size()) {
      localapwv = (apwv)localList.get(paramInt);
    }
    if (localapwv != null)
    {
      this.jdField_a_of_type_Apvo.a(localapwv);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt, false);
      this.jdField_a_of_type_Apuo.a(localapwv);
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "OnDestory");
    }
    this.jdField_a_of_type_Apue.a(8);
    HorizontalListViewEx.a();
    apsf.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a();
    }
    Object localObject = this.jdField_b_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("commonUsedSystemEmoji_sp", 0);
      long l1 = ((SharedPreferences)localObject).getLong("lastRequestTime", 0L);
      if ((System.currentTimeMillis() - l1 > 43200000L) || (System.currentTimeMillis() - l1 < 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelController", 2, "onDestroy commonused send");
        }
        ThreadManagerV2.excute(new EmoticonPanelController.3(this, (SharedPreferences)localObject), 64, null, true);
      }
      localObject = (aufn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      if (localObject != null) {
        ((aufn)localObject).f();
      }
    }
    this.jdField_a_of_type_Astc.d();
    this.jdField_a_of_type_Apuc = null;
    if ((this.jdField_a_of_type_Apyt != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c != null))
    {
      localObject = (TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c;
      GestureDetector localGestureDetector = ((TopGestureLayout)localObject).getGestureDetector();
      if ((localGestureDetector instanceof apyt))
      {
        ThreadManagerV2.getUIHandlerV2().post(new EmoticonPanelController.4(this, (TopGestureLayout)localObject, localGestureDetector));
        com.tencent.mobileqq.emoticon.EmojiStickerManager.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.p(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.p(false);
      }
      ((TopGestureLayout)localObject).restoreGestureDetector();
      this.jdField_a_of_type_Apyt = null;
    }
  }
  
  public void f(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i) {}
    long l1;
    List localList;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      localList = this.jdField_b_of_type_JavaUtilList;
    } while ((localList == null) || (localList.size() == 0));
    if (paramInt == jdField_d_of_type_Int) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
    }
    Object localObject1 = "";
    int n = localList.size();
    ArrayList localArrayList = new ArrayList();
    int m = 0;
    label101:
    Object localObject2;
    apvv localapvv;
    if (m < n)
    {
      localObject2 = (apwv)localList.get(m);
      localapvv = new apvv();
      localapvv.jdField_a_of_type_Int = ((apwv)localObject2).jdField_a_of_type_Int;
      if (((apwv)localObject2).jdField_a_of_type_Int == 8) {
        localObject1 = alud.a(2131704444);
      }
    }
    for (;;)
    {
      localapvv.jdField_b_of_type_JavaLangString = ((String)localObject1);
      localArrayList.add(localapvv);
      m += 1;
      break label101;
      if (((apwv)localObject2).jdField_a_of_type_Int == 9)
      {
        localObject1 = alud.a(2131704446);
      }
      else if (((apwv)localObject2).jdField_a_of_type_Int == 4)
      {
        localObject1 = alud.a(2131704468);
      }
      else if (((apwv)localObject2).jdField_a_of_type_Int == 7)
      {
        localObject1 = alud.a(2131704467);
      }
      else if ((((apwv)localObject2).jdField_a_of_type_Int == 6) || (((apwv)localObject2).jdField_a_of_type_Int == 10))
      {
        if (((apwv)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null)
        {
          EmoticonPackage localEmoticonPackage = ((apwv)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
          localObject2 = localEmoticonPackage.name + alud.a(2131704487);
          localObject1 = localObject2;
          if (localEmoticonPackage.status != 2) {
            localObject1 = (String)localObject2 + alud.a(2131704489);
          }
          localapvv.jdField_a_of_type_JavaLangString = localEmoticonPackage.epId;
          localapvv.jdField_b_of_type_Int = localEmoticonPackage.subType;
          if (localEmoticonPackage.status == 2) {}
          for (boolean bool = true;; bool = false)
          {
            localapvv.jdField_a_of_type_Boolean = bool;
            break;
          }
        }
      }
      else if (((apwv)localObject2).jdField_a_of_type_Int == 11)
      {
        localObject1 = alud.a(2131704432);
        continue;
        if (localArrayList.size() > 0)
        {
          if (this.jdField_d_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.resetCurrentX(paramInt);
          }
          this.jdField_d_of_type_Boolean = true;
          this.jdField_a_of_type_Apvu.a(localArrayList);
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i = true;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EmoticonPanelController", 2, "[Performance] initSecondTabView duration:" + (System.currentTimeMillis() - l1));
        return;
      }
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Apvi.i();
  }
  
  public void g(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "initEmoticonView 2");
    }
    jdField_b_of_type_Int = a(paramInt);
    a(jdField_b_of_type_Int, null);
    this.i = true;
    this.jdField_a_of_type_Apuz.i();
  }
  
  public void h()
  {
    this.jdField_a_of_type_Apvi.k();
  }
  
  public void i()
  {
    this.jdField_a_of_type_Apvi.j();
  }
  
  void j()
  {
    this.jdField_a_of_type_Apue.a(9);
  }
  
  void k()
  {
    this.jdField_g_of_type_Boolean = true;
    apwy.a().a();
    apxa.a().a();
    this.jdField_a_of_type_Apue.a(10);
  }
  
  public void l()
  {
    this.jdField_a_of_type_Apvp.j();
  }
  
  public void m()
  {
    this.jdField_a_of_type_Apuz.m();
  }
  
  public void n()
  {
    this.jdField_a_of_type_Apuz.n();
  }
  
  public void o()
  {
    this.jdField_a_of_type_Apvp.k();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    bdnm.a(null, "AIO_EmoticonPanel_PageScroll");
    Object localObject = this.jdField_b_of_type_JavaUtilList;
    if (localObject == null) {
      return;
    }
    localObject = (apwv)((List)localObject).get(paramInt);
    int m;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.b((apwv)localObject);
      if (((apwv)localObject).jdField_a_of_type_Int != 7) {
        break label325;
      }
      m = 1;
    }
    for (;;)
    {
      label69:
      if (m > 0) {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x800a572", "0x800a572", 0, 0, m + "", m + "", m + "", "");
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "onPageSelected, position=" + paramInt + "panelInfo = " + localObject);
      }
      this.jdField_a_of_type_Apvo.b((apwv)localObject);
      if (jdField_b_of_type_Int != paramInt)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setSelection(paramInt);
        if (paramInt == jdField_d_of_type_Int) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
        }
      }
      for (;;)
      {
        jdField_b_of_type_Int = paramInt;
        this.jdField_a_of_type_Apue.a(3, paramInt, false);
        bdnm.a("AIO_EmoticonPanel_PageScroll", null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EmoticonPanelController", 2, "[Performance] onPageSelected, handle duration=" + (System.currentTimeMillis() - l1));
        return;
        label325:
        if ((((apwv)localObject).jdField_a_of_type_Int == 5) || (((apwv)localObject).jdField_a_of_type_Int == 4))
        {
          m = 2;
          break label69;
        }
        if (((apwv)localObject).jdField_a_of_type_Int == 11)
        {
          m = 3;
          break label69;
        }
        if (((apwv)localObject).jdField_a_of_type_Int == 8)
        {
          m = 4;
          break label69;
        }
        if (((apwv)localObject).jdField_a_of_type_Int == 9)
        {
          m = 5;
          break label69;
        }
        if ((((apwv)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (bdnn.a(((apwv)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))) {
          break label524;
        }
        m = 6;
        break label69;
        if ((localObject != null) && (((apwv)localObject).jdField_a_of_type_Int == 8))
        {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005813", 0, 0, "", paramInt + "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonPanelController", 2, "view times report. cur page:" + paramInt);
          }
        }
      }
      label524:
      m = -1;
    }
  }
  
  public void p()
  {
    int m = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getMeasuredWidth();
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    EmotionPanelViewPagerAdapter localEmotionPanelViewPagerAdapter;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null)
    {
      int n = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_a_of_type_Int;
      if (m != n)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelController", 2, "onMeasure: oldWidth=" + n + " newWidth=" + m);
        }
        apxa.a().a();
        apxa.jdField_a_of_type_Int = m;
        localEmotionPanelViewPagerAdapter = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter;
        if (m / localDisplayMetrics.widthPixels >= 0.66F) {
          break label146;
        }
      }
    }
    label146:
    for (boolean bool = true;; bool = false)
    {
      localEmotionPanelViewPagerAdapter.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_a_of_type_Int = m;
      ThreadManagerV2.getUIHandlerV2().post(new EmoticonPanelController.8(this));
      return;
    }
  }
  
  public void q()
  {
    this.jdField_a_of_type_Apvd.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelController
 * JD-Core Version:    0.7.0.1
 */