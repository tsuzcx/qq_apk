package dov.com.qq.im.capture.view;

import aepi;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import azga;
import azjh;
import bdoo;
import blqr;
import blra;
import blsw;
import bltq;
import bmau;
import bmbi;
import bmbm;
import bmbn;
import bnpl;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateViewPagerAdapter;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import xsx;

public class QIMPtvTemplateProviderView
  extends ProviderView
  implements ViewPager.OnPageChangeListener, ViewTreeObserver.OnScrollChangedListener, azga, bmbm
{
  int jdField_a_of_type_Int = 1;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private blsw jdField_a_of_type_Blsw;
  public bltq a;
  bnpl jdField_a_of_type_Bnpl;
  QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  QIMPtvTemplateViewPagerAdapter jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter;
  List<blsw> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean = true;
  private View c;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public QIMPtvTemplateProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Bltq = new bmbi(this);
  }
  
  private ArrayList<bmbn> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_Bnpl != null) {}
    for (int i = this.jdField_a_of_type_Bnpl.a();; i = -1)
    {
      int j = 0;
      while (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        blsw localblsw = (blsw)this.jdField_a_of_type_JavaUtilList.get(j);
        if ((i != -1) && (i == localblsw.jdField_a_of_type_Int)) {
          this.jdField_a_of_type_Int = j;
        }
        bmbn localbmbn = new bmbn();
        localbmbn.jdField_a_of_type_JavaLangString = localblsw.jdField_a_of_type_JavaLangString;
        localbmbn.jdField_b_of_type_Boolean = localblsw.jdField_a_of_type_Boolean;
        localArrayList.add(localbmbn);
        j += 1;
      }
      return localArrayList;
    }
  }
  
  protected int a()
  {
    return 2131560766;
  }
  
  protected Bundle a()
  {
    Bundle localBundle = new Bundle();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
      if ((this.jdField_a_of_type_JavaUtilList != null) && (i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()))
      {
        blsw localblsw = (blsw)this.jdField_a_of_type_JavaUtilList.get(i);
        String str = localblsw.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.i("PtvTemplateProviderView", 2, "save " + localblsw.jdField_a_of_type_JavaLangString);
          }
          localBundle.putString("ProviderView.select_item_category", str);
        }
      }
    }
    return localBundle;
  }
  
  public String a()
  {
    return "PtvTemplateProviderView";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bmau != null) {
      this.jdField_a_of_type_Bmau.a(null);
    }
    if (this.jdField_a_of_type_Bnpl != null)
    {
      this.jdField_a_of_type_Bnpl.a("0", 0, "");
      blra.c = 0;
      this.jdField_a_of_type_Bnpl.a(null);
      this.jdField_a_of_type_Bnpl.a(111);
      this.jdField_a_of_type_Bnpl.a(113);
      this.jdField_a_of_type_Bnpl.a(112);
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Bltq);
    }
    super.a();
  }
  
  @TargetApi(9)
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt);
    if (paramInt != 1) {
      k();
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("selectCategoryAndItem");
      ((StringBuilder)localObject).append("  category=").append(paramInt);
      ((StringBuilder)localObject).append(", categoryName=").append(paramString1);
      ((StringBuilder)localObject).append(", itemId=").append(paramString2);
      ((StringBuilder)localObject).append(", mTabListSize=").append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.d("PtvTemplateProviderView", 2, ((StringBuilder)localObject).toString());
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if ((paramInt != -1) && (((blsw)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int == paramInt)) {
        paramInt = i;
      }
    }
    for (;;)
    {
      label130:
      a().a(paramInt);
      localObject = (blsw)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
      i = 0;
      label162:
      if (i < ((blsw)localObject).jdField_a_of_type_JavaUtilList.size())
      {
        paramString1 = (PtvTemplateManager.PtvTemplateInfo)((blsw)localObject).jdField_a_of_type_JavaUtilList.get(i);
        if (!paramString1.id.equals(paramString2)) {}
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PtvTemplateProviderView", 2, "itemInfo= " + paramString1 + ",index=" + paramInt + ",pos=" + i);
        }
        if (paramString1 != null)
        {
          if (paramString1.isWsBanner()) {
            xsx.a(this.jdField_a_of_type_AndroidContentContext, paramString1);
          }
        }
        else
        {
          return;
          if ((paramString1 != null) && (paramString1.equals(((blsw)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString)))
          {
            paramInt = i;
            break label130;
          }
          i += 1;
          break;
          i += 1;
          break label162;
        }
        postDelayed(new QIMPtvTemplateProviderView.2(this, paramString1), 200L);
        return;
        i = 0;
        paramString1 = null;
      }
      paramInt = 0;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_e_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560766, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131379906));
    this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter = new QIMPtvTemplateViewPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bmau, this.jdField_g_of_type_Int);
    this.jdField_a_of_type_Bnpl = ((bnpl)blqr.a(3));
    this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter.a(new ArrayList());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.getViewTreeObserver().addOnScrollChangedListener(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Bltq);
    g();
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if ((paramInt != 114) || (paramVarArgs == null) || (paramVarArgs.length != 1)) {
      return;
    }
    h();
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.d) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Bnpl.a(paramBoolean);
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (!paramBoolean)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null)
      {
        i = j;
        if (this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter != null)
        {
          if (this.jdField_b_of_type_Boolean) {
            break label362;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
          blsw localblsw1 = this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter.a(i);
          if (localblsw1 == null) {
            break label362;
          }
          i = 0;
          label81:
          if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label362;
          }
          blsw localblsw2 = (blsw)this.jdField_a_of_type_JavaUtilList.get(i);
          if ((localblsw2 == null) || (TextUtils.isEmpty(localblsw2.jdField_a_of_type_JavaLangString)) || (!localblsw2.jdField_a_of_type_JavaLangString.equals(localblsw1.jdField_a_of_type_JavaLangString))) {
            break label346;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter != null) {
        this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter.a(this.jdField_a_of_type_JavaUtilList);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter);
      }
      if (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView != null)
      {
        this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(a());
        this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
      }
      j = i;
      if (i >= this.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.d("PtvTemplateProviderView", 2, "resetPos " + i + " not exist, mTabList size = " + this.jdField_a_of_type_JavaUtilList.size());
          j = 0;
        }
      }
      if ((this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(j);
        this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(j);
      }
      if (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView == null) {
        break;
      }
      i = this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.getScrollX();
      if (this.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        i();
        return;
        label346:
        i += 1;
        break label81;
      }
      if (i == 0) {
        break;
      }
      h();
      return;
      label362:
      i = j;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    for (Object localObject = BaseApplicationImpl.sApplication.getRuntime();; localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface)
    {
      localObject = getContext().getSharedPreferences(azjh.jdField_b_of_type_JavaLangString + ((AppRuntime)localObject).getAccount(), 4);
      if (!((SharedPreferences)localObject).getBoolean(paramInt1 + "&" + paramInt2, false)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateProviderView", 2, new Object[] { "VideoRedbag, checkTipsLayoutShown, already shown, id:", Integer.valueOf(paramInt1), " tipver:", Integer.valueOf(paramInt2) });
      }
      return true;
    }
    if (((SharedPreferences)localObject).contains(String.valueOf(paramInt1)))
    {
      if (((SharedPreferences)localObject).getInt(String.valueOf(paramInt1), 0) > paramInt2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PtvTemplateProviderView", 2, new Object[] { "VideoRedbag, checkTipsLayoutShown, exist high version, id:", Integer.valueOf(paramInt1), " tipver:", Integer.valueOf(paramInt2) });
        }
        return true;
      }
      ((SharedPreferences)localObject).edit().remove(String.valueOf(paramInt1)).commit();
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, new Object[] { "VideoRedbag, checkTipsLayoutShown, not shown, id: ", Integer.valueOf(paramInt1), " tipver: ", Integer.valueOf(paramInt2) });
    }
    return false;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Bmau != null)
    {
      this.jdField_a_of_type_Bmau.a(null, "");
      this.jdField_a_of_type_Bmau.a(null);
    }
    if (this.jdField_a_of_type_Bnpl != null)
    {
      this.jdField_a_of_type_Bnpl.a("0", 0, "");
      blra.c = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, "onClear");
    }
  }
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateProviderView", 2, "onProviderShow isAccountChange=" + this.jdField_a_of_type_Boolean + " isInit=" + d());
    }
    if ((d()) && (this.jdField_a_of_type_Boolean))
    {
      g();
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    a(false);
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.removeAllViews();
    }
    if (this.jdField_g_of_type_Boolean) {
      h();
    }
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, "random tab template onResume");
    }
    if ((blra.jdField_b_of_type_Int == 0) && (blra.jdField_b_of_type_JavaLangString.equals("0"))) {}
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_Bnpl != null) {
      this.jdField_a_of_type_Bnpl.f();
    }
  }
  
  public void g()
  {
    a(true);
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      this.c = null;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_a_of_type_Blsw != null) {
        if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
          break label192;
        }
      }
    }
    label192:
    for (Object localObject = BaseApplicationImpl.sApplication.getRuntime();; localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface)
    {
      String str = this.jdField_a_of_type_Blsw.jdField_a_of_type_Int + "&" + this.jdField_a_of_type_Blsw.jdField_b_of_type_Int;
      localObject = getContext().getSharedPreferences(azjh.jdField_b_of_type_JavaLangString + ((AppRuntime)localObject).getAccount(), 4).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(str, true);
      ((SharedPreferences.Editor)localObject).putInt(String.valueOf(this.jdField_a_of_type_Blsw.jdField_a_of_type_Int), this.jdField_a_of_type_Blsw.jdField_b_of_type_Int);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
  }
  
  public void i()
  {
    int i;
    label35:
    int j;
    int m;
    int i2;
    int k;
    label238:
    Object localObject3;
    label298:
    label311:
    label360:
    RelativeLayout.LayoutParams localLayoutParams;
    int n;
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView;
        if (localObject1 != null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        int i1;
        Context localContext;
        label561:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PtvTemplateProviderView", 2, new Object[] { "VideoRedbag, showTipsLayout ", localException.getMessage() });
        continue;
      }
      finally {}
      return;
      if (!this.jdField_g_of_type_Boolean)
      {
        localObject1 = this.jdField_a_of_type_Bnpl.a(false);
        i = 0;
        if (i < ((ArrayList)localObject1).size())
        {
          this.jdField_a_of_type_Blsw = ((blsw)((ArrayList)localObject1).get(i));
          if ((this.jdField_a_of_type_Blsw.jdField_b_of_type_JavaLangString == null) || (a(this.jdField_a_of_type_Blsw.jdField_a_of_type_Int, this.jdField_a_of_type_Blsw.jdField_b_of_type_Int))) {
            break label975;
          }
          this.jdField_b_of_type_Int = i;
        }
        if ((this.jdField_b_of_type_Int != -1) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.b().size() > this.jdField_b_of_type_Int)) {
          this.c = ((View)this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.b().get(this.jdField_b_of_type_Int));
        }
      }
      if ((this.c != null) && (this.jdField_a_of_type_Blsw != null))
      {
        i = this.c.getLeft();
        j = this.c.getRight();
        m = this.c.getWidth();
        if ((i != 0) || (j != 0))
        {
          i2 = bdoo.a();
          i1 = this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.getScrollX();
          j = m / 2 + i - i1;
          k = aepi.a(30.0F, getContext().getResources());
          if ((j <= 0) || (j + k >= i2)) {
            break label982;
          }
          j = 1;
          this.jdField_g_of_type_Boolean = true;
          if ((this.jdField_a_of_type_AndroidWidgetTextView == null) && (j != 0) && (this.jdField_e_of_type_Int == 2))
          {
            if ((this.jdField_b_of_type_AndroidViewView == null) || (!(this.jdField_b_of_type_AndroidViewView instanceof RelativeLayout))) {
              continue;
            }
            if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
              break label987;
            }
            localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent();
            if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
              break label996;
            }
            localObject3 = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
            localContext = getContext();
            this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(localContext);
            this.jdField_a_of_type_AndroidWidgetImageView.setId(2131376642);
            if (!this.jdField_a_of_type_Blsw.jdField_a_of_type_Boolean) {
              break label1005;
            }
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849173);
            localLayoutParams = new RelativeLayout.LayoutParams(aepi.a(20.0F, localContext.getResources()), aepi.a(10.0F, localContext.getResources()));
            localLayoutParams.addRule(2, ((View)localObject3).getId());
            localLayoutParams.addRule(9);
            localLayoutParams.leftMargin = (m / 2 + i - aepi.a(20.0F, localContext.getResources()) / 2);
            localLayoutParams.bottomMargin = 5;
            ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
            this.jdField_a_of_type_AndroidWidgetTextView = new TextView(localContext);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Blsw.jdField_b_of_type_JavaLangString);
            k = aepi.a(5.0F, localContext.getResources());
            n = aepi.a(5.0F, localContext.getResources());
            if (!this.jdField_a_of_type_Blsw.jdField_a_of_type_Boolean) {
              break label1018;
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FBD49D"));
            this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130849175);
            this.jdField_a_of_type_AndroidWidgetTextView.setPadding(aepi.a(30.0F, localContext.getResources()), k, n, k);
            this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
            this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
            this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
            this.jdField_a_of_type_AndroidWidgetTextView.measure(-2, -2);
            k = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
            if (!this.jdField_a_of_type_Blsw.jdField_a_of_type_Boolean) {
              break label1066;
            }
            k += aepi.a(17.0F, localContext.getResources());
          }
        }
      }
    }
    label1066:
    for (;;)
    {
      m = m / 2 + i - k / 2;
      n = i2 - m - k;
      i = 16;
      if ((n >= 16) || (k + 32 >= i2)) {
        break label1085;
      }
      if (n >= 16) {
        break label1079;
      }
      break label1069;
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(2, 2131376642);
      localLayoutParams.addRule(9);
      if (this.jdField_a_of_type_Blsw.jdField_a_of_type_Boolean) {
        localLayoutParams.setMargins(aepi.a(17.0F, localContext.getResources()) + k, 0, i, 0);
      }
      for (;;)
      {
        ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
        if (this.jdField_a_of_type_Blsw.jdField_a_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(localContext);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849176);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(2, ((View)localObject3).getId());
          localLayoutParams.addRule(9);
          localLayoutParams.leftMargin = k;
          localLayoutParams.bottomMargin = aepi.a(3.0F, localContext.getResources());
          ((RelativeLayout)localObject1).addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
        }
        if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (j == 0)) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setTranslationX(-i1);
        this.jdField_a_of_type_AndroidWidgetImageView.setTranslationX(-i1);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setTranslationX(-i1);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        break;
        label975:
        i += 1;
        break label35;
        label982:
        j = 0;
        break label238;
        label987:
        View localView = this.jdField_b_of_type_AndroidViewView;
        break label298;
        label996:
        localObject3 = this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView;
        break label311;
        label1005:
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849172);
        break label360;
        label1018:
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130849174);
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding(n, k, n, k);
        break label561;
        localLayoutParams.setMargins(k, 0, i, 0);
      }
    }
    for (;;)
    {
      label1069:
      k = i2 - i - k;
      break;
      label1079:
      i = n;
    }
    label1085:
    if (m < 16) {}
    for (;;)
    {
      m = i2 - i - k;
      k = i;
      i = m;
      break;
      i = m;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(paramInt);
    h();
  }
  
  public void onScrollChanged()
  {
    int i = this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.getScrollX();
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      i();
    }
    while (i == 0) {
      return;
    }
    h();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    i();
  }
  
  public void setGIFMode(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMPtvTemplateProviderView
 * JD-Core Version:    0.7.0.1
 */