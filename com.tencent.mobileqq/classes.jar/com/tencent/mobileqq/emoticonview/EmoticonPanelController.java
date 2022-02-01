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
import anhk;
import anni;
import arqk;
import arvg;
import arwe;
import arxd;
import arxf;
import arxk;
import arxr;
import arxw;
import arxx;
import arxy;
import arxz;
import aryb;
import aryf;
import aryi;
import aryo;
import aryu;
import aryv;
import aryw;
import arzb;
import arzc;
import arze;
import asaf;
import asag;
import asai;
import asak;
import asco;
import aval;
import awmr;
import bcst;
import bgso;
import bgsp;
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
  implements ViewPager.OnPageChangeListener, asag
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
  public arxd a;
  private arxf jdField_a_of_type_Arxf;
  private arxk jdField_a_of_type_Arxk;
  private arxr jdField_a_of_type_Arxr;
  public arxz a;
  private aryb jdField_a_of_type_Aryb;
  private aryf jdField_a_of_type_Aryf;
  protected aryi a;
  private aryo jdField_a_of_type_Aryo;
  private aryu jdField_a_of_type_Aryu;
  private aryv jdField_a_of_type_Aryv;
  public aryw a;
  public arzb a;
  private asco jdField_a_of_type_Asco;
  public aval a;
  public BaseChatPie a;
  public QQAppInterface a;
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  public EmoticonPanelViewPager a;
  public EmotionPanelViewPagerAdapter a;
  public HorizontalListViewEx a;
  List<EmoticonPackage> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int[] jdField_a_of_type_ArrayOfInt;
  public List<asaf> b;
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
    this.jdField_a_of_type_Aval = new aval("emoticon_panel", "com.tencent.mobileqq:tool");
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = paramEmoticonMainPanel;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Arxz = new arxz(paramEmoticonMainPanel);
    this.jdField_e_of_type_Int = paramContext.getResources().getConfiguration().orientation;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.i = false;
    this.jdField_a_of_type_Arxf = new arxf(this);
    this.jdField_a_of_type_Aryb = ((aryb)a(1));
    this.jdField_a_of_type_Aryf = ((aryf)a(2));
    this.jdField_a_of_type_Arxr = ((arxr)a(3));
    this.jdField_a_of_type_Aryv = ((aryv)a(4));
    this.jdField_a_of_type_Aryo = ((aryo)a(5));
    this.jdField_a_of_type_Aryu = ((aryu)a(6));
    this.jdField_a_of_type_Aryw = ((aryw)a(8));
    this.jdField_a_of_type_Aryi = ((aryi)a(7));
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
      if ((localObject == null) || ((((List)localObject).size() > jdField_d_of_type_Int) && (((asaf)((List)localObject).get(jdField_d_of_type_Int)).jdField_a_of_type_Int == 8)))
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
      bgso.a("AIO_EmoticonPanel_EnterSecond", null);
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
        this.jdField_a_of_type_Aryo.a((asaf)((List)localObject).get(n), true);
      }
      e(n);
      if ((this.jdField_e_of_type_Boolean) && (n == 0))
      {
        localObject = (asaf)((List)localObject).get(n);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.b((asaf)localObject);
      }
    }
  }
  
  private int b(String paramString)
  {
    return this.jdField_a_of_type_Aryo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_b_of_type_JavaUtilList);
  }
  
  private void t()
  {
    if (jdField_b_of_type_Int != a(12))
    {
      jdField_b_of_type_Int -= this.jdField_a_of_type_Int;
      if (jdField_b_of_type_Int < 0) {
        jdField_b_of_type_Int = this.jdField_a_of_type_Aryw.c();
      }
    }
  }
  
  private void u()
  {
    int i1 = 0;
    if (this.jdField_a_of_type_Asco == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        int n = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c != null)
        {
          GestureDetector localGestureDetector = ((TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c).getGestureDetector();
          n = i1;
          if ((localGestureDetector instanceof asco))
          {
            n = 1;
            this.jdField_a_of_type_Asco = ((asco)localGestureDetector);
          }
        }
        if (n == 0)
        {
          this.jdField_a_of_type_Asco = new asco(this.jdField_a_of_type_AndroidContentContext, ((TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c).getGestureListener(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          ((TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c).setGestureDetector(this.jdField_a_of_type_Asco);
        }
      }
      return;
    }
    this.jdField_a_of_type_Asco.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Asco.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Asco.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.getBottom();
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
        asaf localasaf = (asaf)localIterator.next();
        if ((localasaf != null) && (localasaf.jdField_a_of_type_Int == paramInt)) {
          return n;
        }
        n += 1;
      }
    }
  }
  
  public int a(String paramString)
  {
    return this.jdField_a_of_type_Aryo.a(paramString, this.jdField_b_of_type_JavaUtilList, jdField_a_of_type_Boolean);
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
  
  public <T extends arwe> T a(int paramInt)
  {
    return this.jdField_a_of_type_Arxf.a(paramInt);
  }
  
  public EmoticonMainPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Arxf.a(1);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager = ((EmoticonPanelViewPager)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131380863));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter = new EmotionPanelViewPagerAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Arxd, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_g_of_type_Int, this.h);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_c_of_type_Boolean = this.jdField_a_of_type_Arxz.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_a_of_type_ArrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_d_of_type_Boolean = a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131365951));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131364992);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx = ((HorizontalListViewEx)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131378213));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setOnItemClickListener(this.jdField_a_of_type_Aryo.a);
    this.jdField_a_of_type_Arzb = new arzb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_g_of_type_Int);
    this.jdField_a_of_type_Arzb.a(b());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setTabAnimateEnable(b());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setAdapter(this.jdField_a_of_type_Arzb);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131365917));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165623));
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165622));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131378179).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165621));
    this.jdField_e_of_type_Boolean = true;
    if (this.jdField_a_of_type_Arxz.jdField_c_of_type_Int != -1) {
      g(this.jdField_a_of_type_Arxz.jdField_c_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Arxf.a(2);
      return;
      a(this.jdField_a_of_type_Arxz.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_Aryv.a(paramInt1, paramInt2);
  }
  
  void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "initEmoticonView 2, selectIndex = " + paramInt + ", defaultEpId = " + paramString);
    }
    int n = this.jdField_a_of_type_Aryw.a(paramInt);
    u();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_g_of_type_Boolean = false;
    long l1 = System.currentTimeMillis();
    Object localObject = (arqk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(334);
    int i1;
    String str;
    if ((localObject != null) && (this.jdField_a_of_type_Arzb != null) && (((arqk)localObject).c()) && (n == a(11)))
    {
      i1 = 1;
      if (!arze.c(this.jdField_c_of_type_Int))
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
      new QueryTask(new arxx(this, n), new arxy(this, l1)).a(paramString);
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
      bgso.a("AIO_EmoticonPanel_OpenDuration", null);
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
  
  public void a(arxd paramarxd)
  {
    this.jdField_a_of_type_Arxd = paramarxd;
    this.jdField_a_of_type_Arxz.jdField_a_of_type_Arxd = paramarxd;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "initEmoticonView 1");
    }
    this.jdField_a_of_type_Aryw.b();
    a(jdField_b_of_type_Int, paramString);
    this.jdField_a_of_type_Aryb.b();
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
    if (this.jdField_a_of_type_Arxd != null) {
      this.jdField_a_of_type_Arxd.b();
    }
    asaf localasaf;
    if ((this.jdField_b_of_type_JavaUtilList != null) && (jdField_b_of_type_Int >= 0) && (jdField_b_of_type_Int < this.jdField_b_of_type_JavaUtilList.size()))
    {
      localasaf = (asaf)this.jdField_b_of_type_JavaUtilList.get(jdField_b_of_type_Int);
      if (localasaf.jdField_a_of_type_Int != 7) {
        break label106;
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A845", "0X800A845", 1, 0, "", "", "", "");
    }
    label106:
    while (localasaf.jdField_a_of_type_Int != 10) {
      return;
    }
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A845", "0X800A845", 2, 0, "", "", "", "");
  }
  
  @Deprecated
  public void b(int paramInt)
  {
    if (paramInt != 0) {
      this.jdField_a_of_type_Aryw.c();
    }
    this.jdField_a_of_type_Aryu.b(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Arxz.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_c_of_type_Boolean = this.jdField_a_of_type_Arxz.jdField_b_of_type_Boolean;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Aryb.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Arxf.a(5);
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
      this.jdField_a_of_type_Aryv.l();
      File localFile = new File(anhk.bV);
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
    this.jdField_a_of_type_Arxf.a(4, -1, paramBoolean);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Aryb.c();
  }
  
  public void d()
  {
    bgso.a(null, "AIO_EmoticonPanel_OnResume");
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
      this.jdField_a_of_type_Arxf.a(6);
      bgso.a("AIO_EmoticonPanel_OnResume", null);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.isShown())
      {
        if ((arze.c(this.jdField_c_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0).getString("LAST_ADD_EMO_PACKAGE", ""))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonPanelController", 2, "download in market, initEmoticonView");
          }
          a(jdField_b_of_type_Int, null);
        }
        q();
        this.jdField_a_of_type_Arxr.c();
      }
    }
  }
  
  public void d(int paramInt)
  {
    paramInt = this.jdField_a_of_type_Aryw.a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "switchTabMode selectIndex = " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    long l1 = System.currentTimeMillis();
    bgso.a(null, "AIO_EmoticonPanel_EnterSecond");
    if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i)
    {
      this.jdField_a_of_type_Aryo.a(this.k, new arxw(this, paramInt, l1));
      return;
    }
    a(l1, paramInt);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i) {}
    while (this.jdField_a_of_type_Arxk == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList = this.jdField_a_of_type_Aryw.a(this.jdField_a_of_type_Arxk.a(paramBoolean, this.jdField_a_of_type_Arxz.jdField_d_of_type_Boolean));
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.j = false;
    this.jdField_a_of_type_Arxf.a(7);
  }
  
  public void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "showPanelByTabIndex tabIndex = " + paramInt);
    }
    asaf localasaf = null;
    List localList = this.jdField_b_of_type_JavaUtilList;
    if (paramInt < localList.size()) {
      localasaf = (asaf)localList.get(paramInt);
    }
    if (localasaf != null)
    {
      this.jdField_a_of_type_Aryu.a(localasaf);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setCurrentItem(paramInt, false);
      this.jdField_a_of_type_Arxr.a(localasaf);
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
    this.jdField_a_of_type_Arxf.a(8);
    HorizontalListViewEx.a();
    arvg.a().a();
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
      localObject = (awmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      if (localObject != null) {
        ((awmr)localObject).f();
      }
    }
    this.jdField_a_of_type_Aval.d();
    this.jdField_a_of_type_Arxd = null;
    if ((this.jdField_a_of_type_Asco != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c != null))
    {
      localObject = (TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c;
      GestureDetector localGestureDetector = ((TopGestureLayout)localObject).getGestureDetector();
      if ((localGestureDetector instanceof asco))
      {
        ThreadManagerV2.getUIHandlerV2().post(new EmoticonPanelController.4(this, (TopGestureLayout)localObject, localGestureDetector));
        com.tencent.mobileqq.emoticon.EmojiStickerManager.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.q(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.q(false);
      }
      ((TopGestureLayout)localObject).restoreGestureDetector();
      this.jdField_a_of_type_Asco = null;
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
    arzc localarzc;
    if (n < i1)
    {
      localObject2 = (asaf)localList.get(n);
      localarzc = new arzc();
      localarzc.jdField_a_of_type_Int = ((asaf)localObject2).jdField_a_of_type_Int;
      if (((asaf)localObject2).jdField_a_of_type_Int == 8) {
        localObject1 = anni.a(2131702841);
      }
    }
    for (;;)
    {
      localarzc.jdField_b_of_type_JavaLangString = ((String)localObject1);
      localArrayList.add(localarzc);
      n += 1;
      break label101;
      if (((asaf)localObject2).jdField_a_of_type_Int == 9)
      {
        localObject1 = anni.a(2131702843);
      }
      else if (((asaf)localObject2).jdField_a_of_type_Int == 4)
      {
        localObject1 = anni.a(2131702865);
      }
      else if (((asaf)localObject2).jdField_a_of_type_Int == 7)
      {
        localObject1 = anni.a(2131702864);
      }
      else if ((((asaf)localObject2).jdField_a_of_type_Int == 6) || (((asaf)localObject2).jdField_a_of_type_Int == 10))
      {
        if (((asaf)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null)
        {
          EmoticonPackage localEmoticonPackage = ((asaf)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
          localObject2 = localEmoticonPackage.name + anni.a(2131702884);
          localObject1 = localObject2;
          if (localEmoticonPackage.status != 2) {
            localObject1 = (String)localObject2 + anni.a(2131702886);
          }
          localarzc.jdField_a_of_type_JavaLangString = localEmoticonPackage.epId;
          localarzc.jdField_b_of_type_Int = localEmoticonPackage.subType;
          if (localEmoticonPackage.status == 2) {}
          for (boolean bool = true;; bool = false)
          {
            localarzc.jdField_a_of_type_Boolean = bool;
            break;
          }
        }
      }
      else if (((asaf)localObject2).jdField_a_of_type_Int == 11)
      {
        localObject1 = anni.a(2131702829);
      }
      else if (((asaf)localObject2).jdField_a_of_type_Int == 13)
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691754);
      }
      else if (((asaf)localObject2).jdField_a_of_type_Int == 14)
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691762);
      }
      else if (((asaf)localObject2).jdField_a_of_type_Int == 12)
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689858);
        continue;
        if (localArrayList.size() > 0)
        {
          if (this.jdField_d_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.resetCurrentX(paramInt);
          }
          this.jdField_d_of_type_Boolean = true;
          this.jdField_a_of_type_Arzb.a(localArrayList);
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
    this.jdField_a_of_type_Aryo.a();
  }
  
  public void g(int paramInt)
  {
    jdField_b_of_type_Int = a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "initEmoticonView panelType: " + paramInt + " selectIndex: " + jdField_b_of_type_Int);
    }
    this.jdField_a_of_type_Aryw.b();
    a(jdField_b_of_type_Int, null);
    this.i = true;
    this.jdField_a_of_type_Aryb.b();
    if (paramInt == 12) {
      this.jdField_a_of_type_Aryi.w();
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_Aryo.c();
  }
  
  public void i()
  {
    this.jdField_a_of_type_Aryo.b();
  }
  
  void j()
  {
    this.jdField_a_of_type_Arxf.a(9);
  }
  
  void k()
  {
    this.jdField_g_of_type_Boolean = true;
    asai.a().a();
    asak.a().a();
    this.jdField_a_of_type_Arxf.a(10);
  }
  
  public void l()
  {
    this.jdField_a_of_type_Aryv.b();
  }
  
  public void m()
  {
    this.jdField_a_of_type_Aryb.m();
  }
  
  public void n()
  {
    this.jdField_a_of_type_Aryb.n();
  }
  
  public void o()
  {
    this.jdField_a_of_type_Aryv.c();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    bgso.a(null, "AIO_EmoticonPanel_PageScroll");
    Object localObject = this.jdField_b_of_type_JavaUtilList;
    if (localObject == null) {
      break label22;
    }
    label22:
    while (this.jdField_a_of_type_Aryw.b(paramInt)) {
      return;
    }
    localObject = (asaf)((List)localObject).get(paramInt);
    int n;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.b((asaf)localObject);
      if (((asaf)localObject).jdField_a_of_type_Int != 7) {
        break label336;
      }
      n = 1;
    }
    for (;;)
    {
      label80:
      if (n > 0) {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x800a572", "0x800a572", 0, 0, n + "", n + "", n + "", "");
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "onPageSelected, position=" + paramInt + "panelInfo = " + localObject);
      }
      this.jdField_a_of_type_Aryu.b((asaf)localObject);
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
        this.jdField_a_of_type_Arxf.a(3, paramInt, false);
        bgso.a("AIO_EmoticonPanel_PageScroll", null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EmoticonPanelController", 2, "[Performance] onPageSelected, handle duration=" + (System.currentTimeMillis() - l1));
        return;
        label336:
        if ((((asaf)localObject).jdField_a_of_type_Int == 5) || (((asaf)localObject).jdField_a_of_type_Int == 4))
        {
          n = 2;
          break label80;
        }
        if (((asaf)localObject).jdField_a_of_type_Int == 11)
        {
          n = 3;
          break label80;
        }
        if (((asaf)localObject).jdField_a_of_type_Int == 8)
        {
          n = 4;
          break label80;
        }
        if (((asaf)localObject).jdField_a_of_type_Int == 9)
        {
          n = 5;
          break label80;
        }
        if ((((asaf)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (bgsp.a(((asaf)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))) {
          break label535;
        }
        n = 6;
        break label80;
        if ((localObject != null) && (((asaf)localObject).jdField_a_of_type_Int == 8))
        {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005813", 0, 0, "", paramInt + "", "", "");
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
        asak.a().a();
        asak.jdField_a_of_type_Int = n;
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
    this.jdField_a_of_type_Aryf.b();
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null) {}
    View localView;
    do
    {
      return;
      localView = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131378226);
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
      localView = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131378226);
    } while (localView == null);
    localView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelController
 * JD-Core Version:    0.7.0.1
 */