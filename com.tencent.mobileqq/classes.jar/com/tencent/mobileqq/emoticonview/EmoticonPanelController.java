package com.tencent.mobileqq.emoticonview;

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
import antf;
import anzj;
import asfy;
import asku;
import asls;
import asmr;
import asmt;
import asmy;
import asnf;
import asnk;
import asnl;
import asnm;
import asnn;
import asnp;
import asnt;
import asnw;
import asoc;
import asoi;
import asoj;
import asok;
import asop;
import asoq;
import asos;
import aspt;
import aspu;
import aspw;
import aspy;
import assc;
import avsm;
import axfj;
import bdll;
import bhsq;
import bhsr;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class EmoticonPanelController
  implements ViewPager.OnPageChangeListener, aspu
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
  public asmr a;
  private asmt jdField_a_of_type_Asmt;
  private asmy jdField_a_of_type_Asmy;
  private asnf jdField_a_of_type_Asnf;
  public asnn a;
  private asnp jdField_a_of_type_Asnp;
  private asnt jdField_a_of_type_Asnt;
  protected asnw a;
  private asoc jdField_a_of_type_Asoc;
  private asoi jdField_a_of_type_Asoi;
  private asoj jdField_a_of_type_Asoj;
  public asok a;
  public asop a;
  private assc jdField_a_of_type_Assc;
  public avsm a;
  public BaseChatPie a;
  public QQAppInterface a;
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  public EmoticonPanelViewPager a;
  public EmotionPanelViewPagerAdapter a;
  public HorizontalListViewEx a;
  List<EmoticonPackage> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int[] jdField_a_of_type_ArrayOfInt;
  public List<aspt> b;
  public boolean b;
  public int c;
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
  public boolean l;
  private boolean m;
  
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
    this.jdField_a_of_type_Avsm = new avsm("emoticon_panel", "com.tencent.mobileqq:tool");
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = paramEmoticonMainPanel;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Asnn = new asnn(paramEmoticonMainPanel);
    this.jdField_e_of_type_Int = paramContext.getResources().getConfiguration().orientation;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.i = false;
    this.jdField_a_of_type_Asmt = new asmt(this);
    this.jdField_a_of_type_Asnp = ((asnp)a(1));
    this.jdField_a_of_type_Asnt = ((asnt)a(2));
    this.jdField_a_of_type_Asnf = ((asnf)a(3));
    this.jdField_a_of_type_Asoj = ((asoj)a(4));
    this.jdField_a_of_type_Asoc = ((asoc)a(5));
    this.jdField_a_of_type_Asoi = ((asoi)a(6));
    this.jdField_a_of_type_Asok = ((asok)a(8));
    this.jdField_a_of_type_Asnw = ((asnw)a(7));
  }
  
  private void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    Object localObject = this.jdField_b_of_type_JavaUtilList;
    int n;
    if ((localObject != null) && (paramInt >= 0))
    {
      n = paramInt;
      if (paramInt < ((List)localObject).size()) {}
    }
    else
    {
      n = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "switchTabMode selectIndex = " + n);
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("clubContentVersion", 0);
    if (localSharedPreferences.getBoolean("force_to_recommend_panel_sp", false)) {
      if ((localObject == null) || ((((List)localObject).size() > jdField_d_of_type_Int) && (((aspt)((List)localObject).get(jdField_d_of_type_Int)).jdField_a_of_type_Int == 8)))
      {
        jdField_b_of_type_Int = jdField_d_of_type_Int;
        n = jdField_d_of_type_Int;
        localSharedPreferences.edit().putBoolean("force_to_recommend_panel_sp", false).apply();
        label166:
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelController", 2, "switchTabMode after recommend calculate, selectIndex = " + n);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i) {
          f(n);
        }
        if ((localObject != null) && (((List)localObject).size() != 0)) {
          break label314;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setAdapter(null);
      }
    }
    for (;;)
    {
      bhsq.a("AIO_EmoticonPanel_EnterSecond", null);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "[Performance] switchTabMode to , duration:" + (System.currentTimeMillis() - paramLong) + ",mSecondTabInited:" + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i);
      }
      return;
      jdField_b_of_type_Int = n;
      break;
      jdField_b_of_type_Int = n;
      break label166;
      label314:
      paramInt = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.getSelectedItemPosition();
      if ((paramInt != n) || (paramInt == 0))
      {
        if (n == jdField_d_of_type_Int) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setSelection(n);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a((List)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.getAdapter() != this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter);
      }
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "[Performance] switchTabMode to , setAdapter duration: " + (System.currentTimeMillis() - l1));
      }
      if (n < ((List)localObject).size()) {
        this.jdField_a_of_type_Asoc.a((aspt)((List)localObject).get(n), true);
      }
      e(n);
      if ((this.jdField_e_of_type_Boolean) && (n == 0))
      {
        localObject = (aspt)((List)localObject).get(n);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.b((aspt)localObject);
      }
    }
  }
  
  private int b(String paramString)
  {
    return this.jdField_a_of_type_Asoc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_b_of_type_JavaUtilList);
  }
  
  private void t()
  {
    if (jdField_b_of_type_Int != a(12))
    {
      jdField_b_of_type_Int -= this.jdField_a_of_type_Int;
      if (jdField_b_of_type_Int < 0) {
        jdField_b_of_type_Int = this.jdField_a_of_type_Asok.c();
      }
    }
  }
  
  private void u()
  {
    int i1 = 0;
    if (this.jdField_a_of_type_Assc == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        int n = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c != null)
        {
          GestureDetector localGestureDetector = ((TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c).getGestureDetector();
          n = i1;
          if ((localGestureDetector instanceof assc))
          {
            n = 1;
            this.jdField_a_of_type_Assc = ((assc)localGestureDetector);
          }
        }
        if (n == 0)
        {
          this.jdField_a_of_type_Assc = new assc(this.jdField_a_of_type_AndroidContentContext, ((TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c).getGestureListener(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          ((TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c).setGestureDetector(this.jdField_a_of_type_Assc);
        }
      }
      return;
    }
    this.jdField_a_of_type_Assc.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Assc.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Assc.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.getBottom();
  }
  
  public int a(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {}
    for (;;)
    {
      return 0;
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      int n = 0;
      while (localIterator.hasNext())
      {
        aspt localaspt = (aspt)localIterator.next();
        if ((localaspt != null) && (localaspt.jdField_a_of_type_Int == paramInt)) {
          return n;
        }
        n += 1;
      }
    }
  }
  
  public int a(String paramString)
  {
    return this.jdField_a_of_type_Asoc.a(paramString, this.jdField_b_of_type_JavaUtilList, jdField_a_of_type_Boolean);
  }
  
  public int a(boolean paramBoolean)
  {
    int i1 = 3;
    if (this.jdField_c_of_type_Int != -1)
    {
      int n = i1;
      switch (Integer.valueOf(ChatActivityUtils.b(this.jdField_c_of_type_Int)).intValue())
      {
      case 2: 
      default: 
        n = i1;
        if (paramBoolean) {
          n = 4;
        }
      case 1: 
        return n;
      case 0: 
        return 1;
      }
      return 2;
    }
    return 0;
  }
  
  public <T extends asls> T a(int paramInt)
  {
    return this.jdField_a_of_type_Asmt.a(paramInt);
  }
  
  public EmoticonMainPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Asmt.a(1);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager = ((EmoticonPanelViewPager)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131381041));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter = new EmotionPanelViewPagerAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Asmr, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_g_of_type_Int, this.h);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_c_of_type_Boolean = this.jdField_a_of_type_Asnn.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_a_of_type_ArrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_d_of_type_Boolean = a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131365996));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131365039);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx = ((HorizontalListViewEx)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131378370));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setOnItemClickListener(this.jdField_a_of_type_Asoc.a);
    this.jdField_a_of_type_Asop = new asop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_g_of_type_Int);
    this.jdField_a_of_type_Asop.a(b());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setTabAnimateEnable(b());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setAdapter(this.jdField_a_of_type_Asop);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131365962));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165623));
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165622));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131378336).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165621));
    this.jdField_e_of_type_Boolean = true;
    if (this.jdField_a_of_type_Asnn.jdField_c_of_type_Int != -1) {
      g(this.jdField_a_of_type_Asnn.jdField_c_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Asmt.a(2);
      return;
      a(this.jdField_a_of_type_Asnn.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_Asoj.a(paramInt1, paramInt2);
  }
  
  void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "initEmoticonView 2, selectIndex = " + paramInt + ", defaultEpId = " + paramString);
    }
    int n = this.jdField_a_of_type_Asok.a(paramInt);
    u();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_g_of_type_Boolean = false;
    long l1 = System.currentTimeMillis();
    Object localObject = (asfy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(334);
    int i1;
    String str;
    if ((localObject != null) && (this.jdField_a_of_type_Asop != null) && (((asfy)localObject).c()) && (n == a(11)))
    {
      i1 = 1;
      if (!asos.c(this.jdField_c_of_type_Int))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.k = false;
      }
      localObject = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0);
      str = ((SharedPreferences)localObject).getString("LAST_ADD_EMO_PACKAGE", "");
      if (TextUtils.isEmpty(str)) {
        break label317;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i = false;
      this.jdField_b_of_type_Boolean = false;
      ((SharedPreferences)localObject).edit().remove("LAST_ADD_EMO_PACKAGE").apply();
      ((SharedPreferences)localObject).edit().remove("LAST_ADD_EMO_PACKAGE_MAGIC").apply();
      paramInt = 0;
      label231:
      if (paramString == null) {
        break label359;
      }
      localObject = paramString;
      label238:
      if ((i1 == 0) || (paramString != null)) {
        break label377;
      }
      paramString = null;
    }
    for (;;)
    {
      new QueryTask(new asnl(this, n), new asnm(this, l1)).a(paramString);
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "ep_mall", "show_mine", "", 0, 0, 0, "", "", "");
      return;
      i1 = 0;
      break;
      label317:
      if ((this.k) && (this.jdField_b_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelController", 2, "new pkg downloaded in panel, refresh");
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i = false;
      }
      paramInt = n;
      break label231;
      label359:
      localObject = str;
      if (!TextUtils.isEmpty(str)) {
        break label238;
      }
      localObject = null;
      break label238;
      label377:
      paramString = (String)localObject;
      n = paramInt;
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
      n = 1;
      paramCanvas.put("panelMode", "2");
      paramCanvas.put("duration", String.valueOf(l1));
      ThreadManager.post(new EmoticonPanelController.5(this, n, l1, paramCanvas), 5, null, true);
      bhsq.a("AIO_EmoticonPanel_OpenDuration", null);
      if (QLog.isColorLevel())
      {
        QLog.d("EmoticonPanelController", 2, "[Performance] dispatchDraw over, duration=" + l1 + ",openCondition=" + n + ",panelMode=" + "2");
        QLog.d("StressTesting.Emoticon.PanelCreate", 2, "open EmoticonPanel duration=" + l1);
      }
      EmoticonMainPanel.jdField_a_of_type_Long = -1L;
      this.jdField_e_of_type_Boolean = false;
      f = false;
      return;
    }
    if (this.jdField_e_of_type_Boolean) {}
    for (int n = 2;; n = 3) {
      break;
    }
  }
  
  public void a(asmr paramasmr)
  {
    this.jdField_a_of_type_Asmr = paramasmr;
    this.jdField_a_of_type_Asnn.jdField_a_of_type_Asmr = paramasmr;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "initEmoticonView 1");
    }
    this.jdField_a_of_type_Asok.b();
    a(jdField_b_of_type_Int, paramString);
    this.jdField_a_of_type_Asnp.b();
  }
  
  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
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
    return this.m;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Asmr != null) {
      this.jdField_a_of_type_Asmr.b();
    }
    aspt localaspt;
    if ((this.jdField_b_of_type_JavaUtilList != null) && (jdField_b_of_type_Int >= 0) && (jdField_b_of_type_Int < this.jdField_b_of_type_JavaUtilList.size()))
    {
      localaspt = (aspt)this.jdField_b_of_type_JavaUtilList.get(jdField_b_of_type_Int);
      if (localaspt.jdField_a_of_type_Int != 7) {
        break label106;
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A845", "0X800A845", 1, 0, "", "", "", "");
    }
    label106:
    while (localaspt.jdField_a_of_type_Int != 10) {
      return;
    }
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A845", "0X800A845", 2, 0, "", "", "", "");
  }
  
  @Deprecated
  public void b(int paramInt)
  {
    if (paramInt != 0) {
      this.jdField_a_of_type_Asok.c();
    }
    this.jdField_a_of_type_Asoi.b(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Asnn.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_c_of_type_Boolean = this.jdField_a_of_type_Asnn.jdField_b_of_type_Boolean;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Asnp.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Asmt.a(5);
  }
  
  public void c(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    if (paramInt != this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getVisibility())
    {
      if (paramInt != 0) {
        break label192;
      }
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration().orientation;
      if (!this.jdField_c_of_type_Boolean) {
        break label176;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i = false;
      t();
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
      this.jdField_a_of_type_Asoj.l();
      File localFile = new File(antf.bV);
      if (!localFile.exists())
      {
        boolean bool = localFile.mkdirs();
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelController", 2, "root dir not exist. try to make it. success:" + bool);
        }
      }
      return;
      label176:
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i = false;
      a(null);
    }
    label192:
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelController.1(this), 1L);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Asmt.a(4, -1, paramBoolean);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Asnp.c();
  }
  
  public void d()
  {
    bhsq.a(null, "AIO_EmoticonPanel_OnResume");
    this.j = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getVisibility() == 0) && (this.jdField_c_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "onResume, Emoticon pkg moved、added or deleted, refresh");
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i = false;
      t();
      a(jdField_b_of_type_Int, null);
      this.jdField_a_of_type_Int = 0;
      this.jdField_c_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_Asmt.a(6);
      bhsq.a("AIO_EmoticonPanel_OnResume", null);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.isShown())
      {
        if ((asos.c(this.jdField_c_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0).getString("LAST_ADD_EMO_PACKAGE", ""))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonPanelController", 2, "download in market, initEmoticonView");
          }
          a(jdField_b_of_type_Int, null);
        }
        q();
        this.jdField_a_of_type_Asnf.c();
      }
    }
  }
  
  public void d(int paramInt)
  {
    paramInt = this.jdField_a_of_type_Asok.a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "switchTabMode selectIndex = " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    long l1 = System.currentTimeMillis();
    bhsq.a(null, "AIO_EmoticonPanel_EnterSecond");
    if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i)
    {
      this.jdField_a_of_type_Asoc.a(this.k, new asnk(this, paramInt, l1));
      return;
    }
    a(l1, paramInt);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i) {}
    while (this.jdField_a_of_type_Asmy == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList = this.jdField_a_of_type_Asok.a(this.jdField_a_of_type_Asmy.a(paramBoolean, this.jdField_a_of_type_Asnn.jdField_d_of_type_Boolean));
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.j = false;
    this.jdField_a_of_type_Asmt.a(7);
  }
  
  public void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "showPanelByTabIndex tabIndex = " + paramInt);
    }
    aspt localaspt = null;
    List localList = this.jdField_b_of_type_JavaUtilList;
    if (paramInt < localList.size()) {
      localaspt = (aspt)localList.get(paramInt);
    }
    if (localaspt != null)
    {
      this.jdField_a_of_type_Asoi.a(localaspt);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setCurrentItem(paramInt, false);
      this.jdField_a_of_type_Asnf.a(localaspt);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "OnDestory");
    }
    this.jdField_a_of_type_Asmt.a(8);
    HorizontalListViewEx.a();
    asku.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.b();
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
      localObject = (axfj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      if (localObject != null) {
        ((axfj)localObject).f();
      }
    }
    this.jdField_a_of_type_Avsm.d();
    this.jdField_a_of_type_Asmr = null;
    if ((this.jdField_a_of_type_Assc != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c != null))
    {
      localObject = (TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c;
      GestureDetector localGestureDetector = ((TopGestureLayout)localObject).getGestureDetector();
      if ((localGestureDetector instanceof assc))
      {
        ThreadManagerV2.getUIHandlerV2().post(new EmoticonPanelController.4(this, (TopGestureLayout)localObject, localGestureDetector));
        com.tencent.mobileqq.emoticon.EmojiStickerManager.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.q(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.q(false);
      }
      ((TopGestureLayout)localObject).restoreGestureDetector();
      this.jdField_a_of_type_Assc = null;
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
    int i1 = localList.size();
    ArrayList localArrayList = new ArrayList();
    int n = 0;
    label101:
    Object localObject2;
    asoq localasoq;
    if (n < i1)
    {
      localObject2 = (aspt)localList.get(n);
      localasoq = new asoq();
      localasoq.jdField_a_of_type_Int = ((aspt)localObject2).jdField_a_of_type_Int;
      if (((aspt)localObject2).jdField_a_of_type_Int == 8) {
        localObject1 = anzj.a(2131702948);
      }
    }
    for (;;)
    {
      localasoq.jdField_b_of_type_JavaLangString = ((String)localObject1);
      localArrayList.add(localasoq);
      n += 1;
      break label101;
      if (((aspt)localObject2).jdField_a_of_type_Int == 9)
      {
        localObject1 = anzj.a(2131702950);
      }
      else if (((aspt)localObject2).jdField_a_of_type_Int == 4)
      {
        localObject1 = anzj.a(2131702972);
      }
      else if (((aspt)localObject2).jdField_a_of_type_Int == 7)
      {
        localObject1 = anzj.a(2131702971);
      }
      else if ((((aspt)localObject2).jdField_a_of_type_Int == 6) || (((aspt)localObject2).jdField_a_of_type_Int == 10))
      {
        if (((aspt)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null)
        {
          EmoticonPackage localEmoticonPackage = ((aspt)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
          localObject2 = localEmoticonPackage.name + anzj.a(2131702991);
          localObject1 = localObject2;
          if (localEmoticonPackage.status != 2) {
            localObject1 = (String)localObject2 + anzj.a(2131702993);
          }
          localasoq.jdField_a_of_type_JavaLangString = localEmoticonPackage.epId;
          localasoq.jdField_b_of_type_Int = localEmoticonPackage.subType;
          if (localEmoticonPackage.status == 2) {}
          for (boolean bool = true;; bool = false)
          {
            localasoq.jdField_a_of_type_Boolean = bool;
            break;
          }
        }
      }
      else if (((aspt)localObject2).jdField_a_of_type_Int == 11)
      {
        localObject1 = anzj.a(2131702936);
      }
      else if (((aspt)localObject2).jdField_a_of_type_Int == 13)
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691757);
      }
      else if (((aspt)localObject2).jdField_a_of_type_Int == 14)
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691765);
      }
      else if (((aspt)localObject2).jdField_a_of_type_Int == 12)
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689863);
        continue;
        if (localArrayList.size() > 0)
        {
          if (this.jdField_d_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.resetCurrentX(paramInt);
          }
          this.jdField_d_of_type_Boolean = true;
          this.jdField_a_of_type_Asop.a(localArrayList);
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
    this.jdField_a_of_type_Asoc.a();
  }
  
  public void g(int paramInt)
  {
    jdField_b_of_type_Int = a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "initEmoticonView panelType: " + paramInt + " selectIndex: " + jdField_b_of_type_Int);
    }
    this.jdField_a_of_type_Asok.b();
    a(jdField_b_of_type_Int, null);
    this.i = true;
    this.jdField_a_of_type_Asnp.b();
    if (paramInt == 12) {
      this.jdField_a_of_type_Asnw.w();
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_Asoc.c();
  }
  
  public void i()
  {
    this.jdField_a_of_type_Asoc.b();
  }
  
  void j()
  {
    this.jdField_a_of_type_Asmt.a(9);
  }
  
  void k()
  {
    this.jdField_g_of_type_Boolean = true;
    aspw.a().a();
    aspy.a().a();
    this.jdField_a_of_type_Asmt.a(10);
  }
  
  public void l()
  {
    this.jdField_a_of_type_Asoj.b();
  }
  
  public void m()
  {
    this.jdField_a_of_type_Asnp.m();
  }
  
  public void n()
  {
    this.jdField_a_of_type_Asnp.n();
  }
  
  public void o()
  {
    this.jdField_a_of_type_Asoj.c();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    bhsq.a(null, "AIO_EmoticonPanel_PageScroll");
    Object localObject = this.jdField_b_of_type_JavaUtilList;
    if (localObject == null) {
      break label22;
    }
    label22:
    while (this.jdField_a_of_type_Asok.b(paramInt)) {
      return;
    }
    localObject = (aspt)((List)localObject).get(paramInt);
    int n;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.b((aspt)localObject);
      if (((aspt)localObject).jdField_a_of_type_Int != 7) {
        break label336;
      }
      n = 1;
    }
    for (;;)
    {
      label80:
      if (n > 0) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x800a572", "0x800a572", 0, 0, n + "", n + "", n + "", "");
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "onPageSelected, position=" + paramInt + "panelInfo = " + localObject);
      }
      this.jdField_a_of_type_Asoi.b((aspt)localObject);
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
        this.jdField_a_of_type_Asmt.a(3, paramInt, false);
        bhsq.a("AIO_EmoticonPanel_PageScroll", null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EmoticonPanelController", 2, "[Performance] onPageSelected, handle duration=" + (System.currentTimeMillis() - l1));
        return;
        label336:
        if ((((aspt)localObject).jdField_a_of_type_Int == 5) || (((aspt)localObject).jdField_a_of_type_Int == 4))
        {
          n = 2;
          break label80;
        }
        if (((aspt)localObject).jdField_a_of_type_Int == 11)
        {
          n = 3;
          break label80;
        }
        if (((aspt)localObject).jdField_a_of_type_Int == 8)
        {
          n = 4;
          break label80;
        }
        if (((aspt)localObject).jdField_a_of_type_Int == 9)
        {
          n = 5;
          break label80;
        }
        if ((((aspt)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (bhsr.a(((aspt)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))) {
          break label535;
        }
        n = 6;
        break label80;
        if ((localObject != null) && (((aspt)localObject).jdField_a_of_type_Int == 8))
        {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005813", 0, 0, "", paramInt + "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonPanelController", 2, "view times report. cur page:" + paramInt);
          }
        }
      }
      label535:
      n = -1;
    }
  }
  
  public void p()
  {
    int n = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getMeasuredWidth();
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    EmotionPanelViewPagerAdapter localEmotionPanelViewPagerAdapter;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_a_of_type_Int;
      if (n != i1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelController", 2, "onMeasure: oldWidth=" + i1 + " newWidth=" + n);
        }
        aspy.a().a();
        aspy.jdField_a_of_type_Int = n;
        localEmotionPanelViewPagerAdapter = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter;
        if (n / localDisplayMetrics.widthPixels >= 0.66F) {
          break label146;
        }
      }
    }
    label146:
    for (boolean bool = true;; bool = false)
    {
      localEmotionPanelViewPagerAdapter.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_a_of_type_Int = n;
      ThreadManagerV2.getUIHandlerV2().post(new EmoticonPanelController.8(this));
      return;
    }
  }
  
  public void q()
  {
    this.jdField_a_of_type_Asnt.b();
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null) {}
    View localView;
    do
    {
      return;
      localView = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131378383);
    } while (localView == null);
    localView.setVisibility(8);
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null) {}
    View localView;
    do
    {
      return;
      localView = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131378383);
    } while (localView == null);
    localView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelController
 * JD-Core Version:    0.7.0.1
 */