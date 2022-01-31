package com.tencent.mobileqq.leba;

import aeaq;
import aear;
import aeas;
import aeat;
import aeau;
import aeaw;
import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.LebaQZoneFacePlayHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.header.LebaGridShowManager;
import com.tencent.mobileqq.leba.view.LebaTopEntryView;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.EXReportController;
import com.tencent.mobileqq.statistics.exreportitem.DC03309ReportItem;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.CustomWidgetUtil;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class QZoneEntryController
  implements AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int;
  public Context a;
  ImageSwitcher jdField_a_of_type_AndroidWidgetImageSwitcher;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  LebaQZoneFacePlayHelper jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper;
  public QQAppInterface a;
  LebaTopEntryView jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopEntryView;
  private QZoneObserver jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver = new aeaq(this);
  private boolean jdField_a_of_type_Boolean;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  
  public QZoneEntryController(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private ArrayList a(QZoneCountInfo paramQZoneCountInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramQZoneCountInfo != null) && (paramQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = paramQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        paramQZoneCountInfo = (QZoneCountUserInfo)localIterator.next();
        if ((paramQZoneCountInfo != null) && (paramQZoneCountInfo.jdField_a_of_type_Long >= 10000L))
        {
          localArrayList.add(String.valueOf(paramQZoneCountInfo.jdField_a_of_type_Long));
        }
        else
        {
          if (paramQZoneCountInfo == null) {}
          for (paramQZoneCountInfo = "userInfo==null";; paramQZoneCountInfo = "userInfo,uin<10000,不是合法qq号")
          {
            QLog.w("UndealCount.QZoneEntryController", 1, paramQZoneCountInfo);
            break;
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (QLog.isColorLevel()) {
      QLog.i("UndealCount.QZoneEntryController", 2, String.format("updateRedTouch mQzoneRedDot :%s,viewStyle:%d,count:%d", new Object[] { String.valueOf(this.jdField_a_of_type_AndroidWidgetTextView), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    CustomWidgetUtil.a(this.jdField_a_of_type_AndroidWidgetTextView, paramInt1, paramInt2, 0);
    CustomWidgetUtil.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetTextView, paramInt1);
  }
  
  private void a(Runnable paramRunnable)
  {
    ThreadManager.getUIHandler().post(paramRunnable);
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopEntryView != null) {
      AccessibilityUtil.a(this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopEntryView, paramString);
    }
  }
  
  private void a(ArrayList paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.a(paramArrayList);
    }
  }
  
  private boolean a()
  {
    int[] arrayOfInt;
    if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopEntryView != null)
    {
      arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopEntryView.getLocationOnScreen(arrayOfInt);
    }
    return arrayOfInt[0] + this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopEntryView.getHeight() >= 0;
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UndealCount.QZoneEntryController", 2, String.format("updateDesc descView :%s,descContent:%s", new Object[] { String.valueOf(this.jdField_b_of_type_AndroidWidgetTextView), paramString }));
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private boolean b()
  {
    QZoneCountInfo localQZoneCountInfo = ((QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9)).a(1);
    if ((localQZoneCountInfo != null) && (localQZoneCountInfo.jdField_a_of_type_Long > 0L))
    {
      int i = (int)localQZoneCountInfo.jdField_a_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.QZoneEntryController", 2, "TYPE_PASSIVE_FEED freshEntryItemUI  num=" + localQZoneCountInfo.jdField_a_of_type_Long);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.e();
      }
      if (i > 0) {
        a("好友动态 " + i + "条更新");
      }
      a(3, i);
      b(localQZoneCountInfo.f);
      c(localQZoneCountInfo.e);
      return true;
    }
    return false;
  }
  
  private void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UndealCount.QZoneEntryController", 2, String.format("updateOprateImageView imageView :%s,url:%s", new Object[] { String.valueOf(this.jdField_a_of_type_AndroidWidgetImageView), paramString }));
    }
    if ((URLUtil.isNetworkUrl(paramString)) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(paramString));
    }
    while (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private boolean c()
  {
    boolean bool = true;
    QZoneCountInfo localQZoneCountInfo = ((QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9)).a(2);
    if (localQZoneCountInfo != null)
    {
      int i = (int)localQZoneCountInfo.jdField_a_of_type_Long;
      ArrayList localArrayList = a(localQZoneCountInfo);
      String str = "好友动态";
      if ((i > 0) && (localQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList != null) && (localQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("UndealCount.QZoneEntryController", 2, "showActiveIfNecessary好友列表不为空，并且count>0,将显示主动并轮播头像");
        }
        str = "好友动态 有更新";
        a(localArrayList);
        a(1, i);
        b(localQZoneCountInfo.f);
        c(localQZoneCountInfo.e);
      }
      for (;;)
      {
        a(str);
        return bool;
        if (QLog.isColorLevel()) {
          QLog.i("UndealCount.QZoneEntryController", 2, "showActiveIfNecessary 好友列表不为空或者count<=0,不现在主动头像和红点");
        }
        m();
        a(0, 0);
        b(null);
        c(null);
        bool = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("UndealCount.QZoneEntryController", 2, "activeCountInfo==null,不现在主动头像和红点");
    }
    m();
    a(0, 0);
    b(null);
    c(null);
    return false;
  }
  
  private boolean d()
  {
    boolean bool = true;
    QZoneCountInfo localQZoneCountInfo = ((QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9)).a(3);
    String str = "好友动态";
    int i;
    if (localQZoneCountInfo != null)
    {
      ArrayList localArrayList = a(localQZoneCountInfo);
      if ((localQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList != null) && (localQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (localQZoneCountInfo.jdField_a_of_type_Long > 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.i("UndealCount.QZoneEntryController", 2, "showVistorIfNecessary 好友列表不为空，并且未读数uCount大于0，显示访客头像");
        }
        a(localArrayList);
        if (localQZoneCountInfo.jdField_a_of_type_Int == 2) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      a(i, (int)localQZoneCountInfo.jdField_a_of_type_Long);
      b(localQZoneCountInfo.f);
      c(localQZoneCountInfo.e);
      str = "好友动态 有访客";
      a(str);
      return bool;
      if ((localQZoneCountInfo.jdField_a_of_type_Int == 4) || (localQZoneCountInfo.jdField_a_of_type_Int == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.w("UndealCount.QZoneEntryController", 2, "访客如果有红点只能是小红点，当前下发的是iControl：" + localQZoneCountInfo.jdField_a_of_type_Int + ",降级到小红点");
        }
        i = 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("UndealCount.QZoneEntryController", 2, "showVistorIfNecessary 好友列表为空，或未读数uCount不大于0，不显示访客头像");
        }
        m();
        a(0, 0);
        b(null);
        c(null);
        for (;;)
        {
          bool = false;
          break;
          if (QLog.isColorLevel()) {
            QLog.i("UndealCount.QZoneEntryController", 2, "visitorCountInfo==null，不显示访客头像");
          }
          m();
          a(0, 0);
          b(null);
          c(null);
        }
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private boolean e()
  {
    QZoneCountInfo localQZoneCountInfo = ((QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9)).a(53);
    if (localQZoneCountInfo != null)
    {
      if ((!TextUtils.isEmpty(localQZoneCountInfo.f)) || (!URLUtil.isNetworkUrl(localQZoneCountInfo.e))) {
        break label59;
      }
      if (QLog.isColorLevel()) {
        QLog.w("UndealCount.QZoneEntryController", 2, "showOprationIfNecessary strShowMsg为空，并且iconUrl不是一个网络连接，不显示运营");
      }
    }
    return false;
    label59:
    c(localQZoneCountInfo.e);
    b(localQZoneCountInfo.f);
    m();
    int i;
    if (localQZoneCountInfo.jdField_a_of_type_Int == 2) {
      i = 1;
    }
    for (;;)
    {
      a(i, (int)localQZoneCountInfo.jdField_a_of_type_Long);
      a("好友动态");
      return true;
      if ((localQZoneCountInfo.jdField_a_of_type_Int == 4) || (localQZoneCountInfo.jdField_a_of_type_Int == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.w("UndealCount.QZoneEntryController", 2, "showOprationIfNecessary 运营如果有红点只能是小红点，当前下发的是iControl：" + localQZoneCountInfo.jdField_a_of_type_Int + ",降级到小红点");
        }
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.e();
    }
  }
  
  private void n()
  {
    m();
    b(null);
    a(0, 0);
    c(null);
    a("好友动态");
  }
  
  private void o()
  {
    a(new aeas(this));
  }
  
  private void p()
  {
    QZoneManager localQZoneManager = (QZoneManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
    if (localQZoneManager != null)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UndealCount.QZoneEntryController", 2, "getQzoneUnread by tab resume.");
        }
        localQZoneManager.a(3);
      }
      localQZoneManager.a(false);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void q()
  {
    Object localObject1 = new LpReportInfo_pf00064();
    ((LpReportInfo_pf00064)localObject1).actionType = 637;
    ((LpReportInfo_pf00064)localObject1).subactionType = 21;
    Object localObject2;
    if (this.jdField_a_of_type_Int == 2)
    {
      ((LpReportInfo_pf00064)localObject1).reserves = 1;
      localObject2 = ((QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9)).a(2);
      if (localObject2 != null) {
        ((LpReportInfo_pf00064)localObject1).reserves3 = ((QZoneCountInfo)localObject2).g;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
        ((LpReportInfo_pf00064)localObject1).reserves2 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.a());
      }
    }
    for (;;)
    {
      LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject1, false, true);
      int i = LebaGridShowManager.a().jdField_a_of_type_Int;
      localObject1 = Integer.toString(10000);
      localObject2 = new DC03309ReportItem();
      ((DC03309ReportItem)localObject2).i = "trends_tab";
      ((DC03309ReportItem)localObject2).j = "trends_plugin";
      ((DC03309ReportItem)localObject2).k = "plugin_clk";
      ((DC03309ReportItem)localObject2).jdField_a_of_type_Int = i;
      ((DC03309ReportItem)localObject2).jdField_c_of_type_Int = 1;
      ((DC03309ReportItem)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
      ((DC03309ReportItem)localObject2).jdField_c_of_type_JavaLangString = Integer.toString(1);
      EXReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (DC03309ReportItem)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.QZoneEntryController", 2, "qzon click" + i);
      }
      return;
      if (1 == this.jdField_a_of_type_Int)
      {
        ((LpReportInfo_pf00064)localObject1).reserves = 2;
        localObject2 = ((QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9)).a(1);
        if (localObject2 != null)
        {
          ((LpReportInfo_pf00064)localObject1).reserves2 = String.valueOf(((QZoneCountInfo)localObject2).jdField_a_of_type_Long);
          ((LpReportInfo_pf00064)localObject1).reserves3 = ((QZoneCountInfo)localObject2).g;
        }
      }
      else if (3 == this.jdField_a_of_type_Int)
      {
        ((LpReportInfo_pf00064)localObject1).reserves = 3;
        localObject2 = ((QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9)).a(3);
        if (localObject2 != null)
        {
          ((LpReportInfo_pf00064)localObject1).reserves2 = String.valueOf(((QZoneCountInfo)localObject2).jdField_a_of_type_Long);
          ((LpReportInfo_pf00064)localObject1).reserves3 = ((QZoneCountInfo)localObject2).g;
        }
      }
      else if (4 == this.jdField_a_of_type_Int)
      {
        ((LpReportInfo_pf00064)localObject1).reserves = 5;
        localObject2 = ((QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9)).a(53);
        if (localObject2 != null)
        {
          ((LpReportInfo_pf00064)localObject1).reserves2 = String.valueOf(((QZoneCountInfo)localObject2).jdField_a_of_type_Long);
          ((LpReportInfo_pf00064)localObject1).reserves3 = ((QZoneCountInfo)localObject2).g;
        }
      }
      else if (this.jdField_a_of_type_Int == 0)
      {
        ((LpReportInfo_pf00064)localObject1).reserves = 4;
      }
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopEntryView;
  }
  
  public void a()
  {
    a(new aear(this));
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.b(paramQQAppInterface);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (QLog.isColorLevel()) {
      QLog.i("UndealCount.QZoneEntryController", 2, "发生了账****号切换，刷新页面");
    }
    k();
    a();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = a();
    if (bool) {
      if (!this.c)
      {
        e();
        if (!this.jdField_b_of_type_Boolean)
        {
          j();
          this.jdField_b_of_type_Boolean = true;
        }
      }
    }
    for (;;)
    {
      this.c = bool;
      return;
      if ((!bool) && (this.c)) {
        g();
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 0;
    k();
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopEntryView = new LebaTopEntryView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopEntryView.a().setImageResource(2130844836);
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopEntryView.a().setText("好友动态");
    LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970391, this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopEntryView.a());
    this.jdField_a_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopEntryView.findViewById(2131370341));
    this.jdField_a_of_type_AndroidWidgetImageSwitcher.setFactory(new aeat(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopEntryView.findViewById(2131370318));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopEntryView.b();
    this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(ViewUtils.b(140.0F));
    this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper = new LebaQZoneFacePlayHelper(this.jdField_a_of_type_AndroidWidgetImageSwitcher, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopEntryView.findViewById(2131370342));
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopEntryView.setOnClickListener(new aeau(this));
  }
  
  public void c()
  {
    l();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.e();
    }
  }
  
  void d()
  {
    QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Leba");
    p();
    if (a())
    {
      o();
      e();
      a(new aeaw(this));
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.QZoneEntryController", 2, "onResume qzone入口在屏幕上显示");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("UndealCount.QZoneEntryController", 2, "onResume qzone入口不可见");
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.c();
    }
  }
  
  void f()
  {
    g();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.b();
    }
  }
  
  void h()
  {
    c();
    if (QLog.isColorLevel()) {
      QLog.i("UndealCount.QZoneEntryController", 2, "leba onDestroy 调用了本对象的onDestroy");
    }
  }
  
  public void i()
  {
    l();
  }
  
  public void j()
  {
    LpReportInfo_pf00064 localLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    localLpReportInfo_pf00064.actionType = 637;
    localLpReportInfo_pf00064.subactionType = 20;
    QZoneCountInfo localQZoneCountInfo;
    if (this.jdField_a_of_type_Int == 2)
    {
      localLpReportInfo_pf00064.reserves = 1;
      localQZoneCountInfo = ((QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9)).a(2);
      if (localQZoneCountInfo != null) {
        localLpReportInfo_pf00064.reserves3 = localQZoneCountInfo.g;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
        localLpReportInfo_pf00064.reserves2 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.a());
      }
    }
    for (;;)
    {
      LpReportManager.getInstance().reportToPF00064(localLpReportInfo_pf00064, false, true);
      return;
      if (1 == this.jdField_a_of_type_Int)
      {
        localLpReportInfo_pf00064.reserves = 2;
        localQZoneCountInfo = ((QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9)).a(1);
        if (localQZoneCountInfo != null)
        {
          localLpReportInfo_pf00064.reserves2 = String.valueOf(localQZoneCountInfo.jdField_a_of_type_Long);
          localLpReportInfo_pf00064.reserves3 = localQZoneCountInfo.g;
        }
      }
      else if (3 == this.jdField_a_of_type_Int)
      {
        localLpReportInfo_pf00064.reserves = 3;
        localQZoneCountInfo = ((QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9)).a(3);
        if (localQZoneCountInfo != null)
        {
          localLpReportInfo_pf00064.reserves2 = String.valueOf(localQZoneCountInfo.jdField_a_of_type_Long);
          localLpReportInfo_pf00064.reserves3 = localQZoneCountInfo.g;
        }
      }
      else if (4 == this.jdField_a_of_type_Int)
      {
        localLpReportInfo_pf00064.reserves = 5;
        localQZoneCountInfo = ((QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9)).a(53);
        if (localQZoneCountInfo != null)
        {
          localLpReportInfo_pf00064.reserves2 = String.valueOf(localQZoneCountInfo.jdField_a_of_type_Long);
          localLpReportInfo_pf00064.reserves3 = localQZoneCountInfo.g;
        }
      }
      else if (this.jdField_a_of_type_Int == 0)
      {
        localLpReportInfo_pf00064.reserves = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.QZoneEntryController
 * JD-Core Version:    0.7.0.1
 */