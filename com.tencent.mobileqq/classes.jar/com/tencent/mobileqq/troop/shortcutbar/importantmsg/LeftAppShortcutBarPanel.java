package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class LeftAppShortcutBarPanel
  extends ILeftAppShortBarDataUI
{
  protected Context a;
  protected View.OnClickListener a;
  private View jdField_a_of_type_AndroidViewView;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected PopupWindow.OnDismissListener a;
  private TroopAppShortcutBarHelper jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAppShortcutBarHelper;
  private AIOShortcutBarContext jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext;
  private ImportantMessageReporter jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter;
  private PopupMoreListDialog jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog;
  private AppShortcutBarScrollView jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView;
  protected ArrayList<ShortcutBarInfo> a;
  protected AppRuntime a;
  protected boolean a;
  protected View.OnClickListener b;
  private LinearLayout b;
  protected boolean b;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private boolean jdField_c_of_type_Boolean = false;
  
  public LeftAppShortcutBarPanel(AIOShortcutBarContext paramAIOShortcutBarContext, AppShortcutBarScrollView paramAppShortcutBarScrollView, TroopAppShortcutBarHelper paramTroopAppShortcutBarHelper)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new LeftAppShortcutBarPanel.1(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new LeftAppShortcutBarPanel.2(this);
    this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener = new LeftAppShortcutBarPanel.3(this);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new LeftAppShortcutBarPanel.4(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext = paramAIOShortcutBarContext;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAIOShortcutBarContext.a();
    this.jdField_a_of_type_AndroidContentContext = paramAIOShortcutBarContext.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = paramAppShortcutBarScrollView;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131372301));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372291));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372299));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAppShortcutBarHelper = paramTroopAppShortcutBarHelper;
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter = new ImportantMessageReporter(this, paramAIOShortcutBarContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAppShortcutBarHelper);
  }
  
  private void a(View paramView, ImportantMsgInfo paramImportantMsgInfo, ArrayList<ShortcutBarInfo> paramArrayList)
  {
    paramView.setTag(paramImportantMsgInfo);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramView.setLongClickable(false);
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime);
    paramImportantMsgInfo = (TextView)paramView.findViewById(2131377474);
    if (bool) {
      paramImportantMsgInfo.setTextColor(Color.parseColor("#ffffff"));
    } else {
      paramImportantMsgInfo.setTextColor(Color.parseColor("#1C1D1E"));
    }
    paramImportantMsgInfo = (LinearLayout)paramView.findViewById(2131377471);
    if (bool) {
      paramImportantMsgInfo.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838593));
    } else {
      paramImportantMsgInfo.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838592));
    }
    paramImportantMsgInfo = (ImageView)paramView.findViewById(2131377472);
    if (bool) {
      paramImportantMsgInfo.setColorFilter(1996488704);
    } else {
      paramImportantMsgInfo.setColorFilter(0);
    }
    paramView = (TextView)paramView.findViewById(2131377459);
    paramView.setVisibility(0);
    paramView.setText(String.valueOf(paramArrayList.size()));
    paramView.setBackgroundResource(2130846402);
  }
  
  private void a(ShortcutBarInfo paramShortcutBarInfo, View paramView)
  {
    paramView.setTag(paramShortcutBarInfo);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    boolean bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime);
    Object localObject = (TextView)paramView.findViewById(2131377468);
    ((TextView)localObject).setText(paramShortcutBarInfo.a());
    ((TextView)localObject).setContentDescription(paramShortcutBarInfo.a());
    if (bool2) {
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
    } else {
      ((TextView)localObject).setTextColor(Color.parseColor("#1C1D1E"));
    }
    localObject = (LinearLayout)paramView.findViewById(2131377466);
    if (bool2) {
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838593));
    } else {
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838592));
    }
    localObject = (URLImageView)paramView.findViewById(2131377467);
    if (bool2) {
      ((URLImageView)localObject).setColorFilter(1996488704);
    } else {
      ((URLImageView)localObject).setColorFilter(0);
    }
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = paramShortcutBarInfo.b();
    int i = paramShortcutBarInfo.b();
    boolean bool1 = true;
    if (i != 1) {
      bool1 = false;
    }
    TroopAppShortcutUtils.a(localContext, (ImageView)localObject, str, 19.0F, bool1);
    paramView = (ImageView)paramView.findViewById(2131377465);
    if (!paramShortcutBarInfo.a())
    {
      paramView.setVisibility(8);
      return;
    }
    if (bool2) {
      paramView.setColorFilter(1996488704);
    } else {
      paramView.setColorFilter(0);
    }
    paramView.setTag(paramShortcutBarInfo);
    paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    paramView.setContentDescription("关闭");
  }
  
  private void a(ImportantMsgInfo paramImportantMsgInfo, ArrayList<ShortcutBarInfo> paramArrayList)
  {
    if (paramImportantMsgInfo == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    try
    {
      View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131561541, null);
      a(localView, paramImportantMsgInfo, paramArrayList);
      this.jdField_a_of_type_AndroidViewView = localView;
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter.a();
      }
      paramImportantMsgInfo = this.jdField_a_of_type_AndroidViewView;
      if (paramImportantMsgInfo != null) {
        paramImportantMsgInfo.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      return;
    }
    catch (InflateException paramImportantMsgInfo)
    {
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("ShortcutBarAioHelper.updateMessageShortcutPanel got InflateException, e:");
        paramArrayList.append(paramImportantMsgInfo.getMessage());
        QLog.e("LeftAppShortcutBarPanel", 2, paramArrayList.toString());
      }
      System.gc();
      return;
    }
    catch (OutOfMemoryError paramImportantMsgInfo)
    {
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("ShortcutBarAioHelper.updateMessageShortcutPanel got OOM, e:");
        paramArrayList.append(paramImportantMsgInfo.getMessage());
        QLog.e("LeftAppShortcutBarPanel", 2, paramArrayList.toString());
      }
      System.gc();
    }
  }
  
  private void b(ArrayList<ShortcutBarInfo> paramArrayList)
  {
    Object localObject1 = this.jdField_c_of_type_AndroidWidgetLinearLayout;
    if ((localObject1 != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout != null))
    {
      ((LinearLayout)localObject1).removeAllViews();
      if (paramArrayList == null) {
        return;
      }
      paramArrayList = paramArrayList.iterator();
      boolean bool = false;
      int i = 1;
      while (paramArrayList.hasNext())
      {
        Object localObject2 = (ShortcutBarInfo)paramArrayList.next();
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter != null) {
            this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter.b(Long.valueOf(((ShortcutBarInfo)localObject2).a()), Long.valueOf(((ShortcutBarInfo)localObject2).b()));
          }
          localObject1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a(), 2131561540, null);
          a((ShortcutBarInfo)localObject2, (View)localObject1);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          int j = i;
          if (i != 0)
          {
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject2).setMargins(ViewUtils.a(14.0F), 0, 0, 0);
            ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            j = 0;
          }
          bool = true;
          i = j;
        }
        catch (InflateException paramArrayList)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("ShortcutBarAioHelper.updateMessageShortcutPanel got InflateException, e:");
            ((StringBuilder)localObject1).append(paramArrayList.getMessage());
            QLog.e("LeftAppShortcutBarPanel", 2, ((StringBuilder)localObject1).toString());
          }
          System.gc();
          return;
        }
        catch (OutOfMemoryError paramArrayList)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("ShortcutBarAioHelper.updateMessageShortcutPanel got OOM, e:");
            ((StringBuilder)localObject1).append(paramArrayList.getMessage());
            QLog.e("LeftAppShortcutBarPanel", 2, ((StringBuilder)localObject1).toString());
          }
          System.gc();
          return;
        }
      }
      this.jdField_c_of_type_Boolean = bool;
      if (bool) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAppShortcutBarHelper.g();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("LeftAppShortcutBarPanel", 2, "updateMessageShortcutPanel. messageShortcutPanel is null.");
    }
  }
  
  private void c(ArrayList<ShortcutBarInfo> paramArrayList)
  {
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAppShortcutBarHelper != null))
    {
      if (this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener == null) {
        return;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog;
      if ((localObject == null) || ((localObject != null) && (!((PopupMoreListDialog)localObject).a())))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog = new PopupMoreListDialog(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAppShortcutBarHelper, this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener, this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter);
        this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog.a(paramArrayList);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog.a())
      {
        paramArrayList = this.jdField_a_of_type_AndroidViewView;
        if (paramArrayList != null)
        {
          localObject = new int[2];
          paramArrayList.getLocationOnScreen((int[])localObject);
          int i;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog.a() > 5) {
            i = ViewUtils.a(247.0F);
          } else {
            i = ViewUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog.a() * 40 + 7);
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog.a(this.jdField_a_of_type_AndroidViewView, localObject[0] - ViewUtils.a(175.0F) / 2, localObject[1] - i - 5, ViewUtils.a(175.0F), i);
        }
      }
    }
  }
  
  public int a()
  {
    LinearLayout localLinearLayout = this.jdField_b_of_type_AndroidWidgetLinearLayout;
    int j = 2;
    int i = j;
    if (localLinearLayout != null)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getChildCount() > 0) {
        i = 1;
      }
    }
    return i;
  }
  
  public void a()
  {
    ImportantMessageReporter localImportantMessageReporter = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter;
    if (localImportantMessageReporter != null)
    {
      localImportantMessageReporter.c();
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAppShortcutBarHelper = null;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_c_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
    this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener = null;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(ArrayList<ShortcutBarInfo> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null) {
        return;
      }
      int i = 0;
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        this.jdField_c_of_type_Boolean = false;
        if ((paramArrayList.size() > 3) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount() > 0))
        {
          localObject = new ArrayList();
          ArrayList localArrayList = new ArrayList();
          while (i < paramArrayList.size())
          {
            if (i < 2) {
              ((ArrayList)localObject).add(paramArrayList.get(i));
            } else {
              localArrayList.add(paramArrayList.get(i));
            }
            i += 1;
          }
          b((ArrayList)localObject);
          a(new ImportantMsgInfo(0L, 0L, "更多", "", "", 0L, 0), localArrayList);
          return;
        }
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog;
        if ((localObject != null) && (((PopupMoreListDialog)localObject).a())) {
          this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog.d();
        }
        b(paramArrayList);
        return;
      }
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAppShortcutBarHelper.h();
      }
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void c()
  {
    PopupMoreListDialog localPopupMoreListDialog = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog;
    if (localPopupMoreListDialog != null) {
      localPopupMoreListDialog.b();
    }
  }
  
  public void d() {}
  
  public void e()
  {
    if ((this.jdField_c_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView != null))
    {
      Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime;
      if (localObject1 != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAppShortcutBarHelper == null) {
          return;
        }
        if (((TroopManager)((AppRuntime)localObject1).getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAppShortcutBarHelper.a()) == null) {
          return;
        }
        localObject1 = new Rect();
        this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getHitRect((Rect)localObject1);
        int i = 0;
        while (i < this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildCount())
        {
          Object localObject2 = this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          if ((localObject2 != null) && (((View)localObject2).getLocalVisibleRect((Rect)localObject1)))
          {
            localObject2 = ((View)localObject2).getTag();
            if ((localObject2 instanceof ImportantMsgInfo))
            {
              localObject2 = (ImportantMsgInfo)localObject2;
              if (localObject2 != null)
              {
                ImportantMessageReporter localImportantMessageReporter = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter;
                if (localImportantMessageReporter != null) {
                  localImportantMessageReporter.c(Long.valueOf(((ImportantMsgInfo)localObject2).a()), Long.valueOf(((ImportantMsgInfo)localObject2).b()));
                }
              }
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.LeftAppShortcutBarPanel
 * JD-Core Version:    0.7.0.1
 */