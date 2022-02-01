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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.ShortcutBarAIOHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class LeftAppShortcutBarPanel
  extends ILeftAppShortBarDataUI
{
  protected View.OnClickListener a;
  private View jdField_a_of_type_AndroidViewView;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected PopupWindow.OnDismissListener a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private ShortcutBarAIOHelper jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper;
  private ImportantMessageReporter jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter;
  private PopupMoreListDialog jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog;
  private AppShortcutBarScrollView jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView;
  protected ArrayList<ShortcutBarInfo> a;
  protected boolean a;
  protected View.OnClickListener b;
  private LinearLayout b;
  protected boolean b;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private boolean jdField_c_of_type_Boolean = false;
  
  public LeftAppShortcutBarPanel(BaseChatPie paramBaseChatPie, AppShortcutBarScrollView paramAppShortcutBarScrollView, ILifeCycleHelper paramILifeCycleHelper)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new LeftAppShortcutBarPanel.1(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new LeftAppShortcutBarPanel.2(this);
    this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener = new LeftAppShortcutBarPanel.3(this);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new LeftAppShortcutBarPanel.4(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = paramAppShortcutBarScrollView;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131372724));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372714));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372722));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper = ((ShortcutBarAIOHelper)paramILifeCycleHelper);
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter = new ImportantMessageReporter(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper);
  }
  
  private void a(View paramView, ImportantMsgInfo paramImportantMsgInfo, ArrayList<ShortcutBarInfo> paramArrayList)
  {
    paramView.setTag(paramImportantMsgInfo);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramView.setLongClickable(false);
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramImportantMsgInfo = (TextView)paramView.findViewById(2131378049);
    if (bool)
    {
      paramImportantMsgInfo.setTextColor(Color.parseColor("#ffffff"));
      paramImportantMsgInfo = (LinearLayout)paramView.findViewById(2131378046);
      if (!bool) {
        break label154;
      }
      paramImportantMsgInfo.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838748));
      label88:
      paramImportantMsgInfo = (ImageView)paramView.findViewById(2131378047);
      if (!bool) {
        break label176;
      }
      paramImportantMsgInfo.setColorFilter(1996488704);
    }
    for (;;)
    {
      paramView = (TextView)paramView.findViewById(2131378034);
      paramView.setVisibility(0);
      paramView.setText(String.valueOf(paramArrayList.size()));
      paramView.setBackgroundResource(2130846527);
      return;
      paramImportantMsgInfo.setTextColor(Color.parseColor("#1C1D1E"));
      break;
      label154:
      paramImportantMsgInfo.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838747));
      break label88;
      label176:
      paramImportantMsgInfo.setColorFilter(0);
    }
  }
  
  private void a(ShortcutBarInfo paramShortcutBarInfo, View paramView)
  {
    boolean bool1 = true;
    paramView.setTag(paramShortcutBarInfo);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    boolean bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = (TextView)paramView.findViewById(2131378043);
    ((TextView)localObject).setText(paramShortcutBarInfo.a());
    ((TextView)localObject).setContentDescription(paramShortcutBarInfo.a());
    label107:
    Context localContext;
    label130:
    String str;
    if (bool2)
    {
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localObject = (LinearLayout)paramView.findViewById(2131378041);
      if (!bool2) {
        break label202;
      }
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838748));
      localObject = (URLImageView)paramView.findViewById(2131378042);
      if (!bool2) {
        break label225;
      }
      ((URLImageView)localObject).setColorFilter(1996488704);
      localContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext;
      str = paramShortcutBarInfo.b();
      if (paramShortcutBarInfo.b() != 1) {
        break label234;
      }
    }
    for (;;)
    {
      TroopAppShortcutUtils.a(localContext, (ImageView)localObject, str, 19.0F, bool1);
      paramView = (ImageView)paramView.findViewById(2131378040);
      if (paramShortcutBarInfo.a()) {
        break label239;
      }
      paramView.setVisibility(8);
      return;
      ((TextView)localObject).setTextColor(Color.parseColor("#1C1D1E"));
      break;
      label202:
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838747));
      break label107;
      label225:
      ((URLImageView)localObject).setColorFilter(0);
      break label130;
      label234:
      bool1 = false;
    }
    label239:
    if (bool2) {
      paramView.setColorFilter(1996488704);
    }
    for (;;)
    {
      paramView.setTag(paramShortcutBarInfo);
      paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription("关闭");
      return;
      paramView.setColorFilter(0);
    }
  }
  
  private void a(ImportantMsgInfo paramImportantMsgInfo, ArrayList<ShortcutBarInfo> paramArrayList)
  {
    if (paramImportantMsgInfo == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      try
      {
        View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131561698, null);
        a(localView, paramImportantMsgInfo, paramArrayList);
        this.jdField_a_of_type_AndroidViewView = localView;
        this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
        if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter.a();
        }
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
          return;
        }
      }
      catch (OutOfMemoryError paramImportantMsgInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LeftAppShortcutBarPanel", 2, "ShortcutBarAioHelper.updateMessageShortcutPanel got OOM, e:" + paramImportantMsgInfo.getMessage());
        }
        System.gc();
        return;
      }
      catch (InflateException paramImportantMsgInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LeftAppShortcutBarPanel", 2, "ShortcutBarAioHelper.updateMessageShortcutPanel got InflateException, e:" + paramImportantMsgInfo.getMessage());
        }
        System.gc();
      }
    }
  }
  
  private void b(ArrayList<ShortcutBarInfo> paramArrayList)
  {
    if ((this.jdField_c_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_b_of_type_AndroidWidgetLinearLayout == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("LeftAppShortcutBarPanel", 2, "updateMessageShortcutPanel. messageShortcutPanel is null.");
      }
    }
    do
    {
      return;
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
    } while (paramArrayList == null);
    paramArrayList = paramArrayList.iterator();
    boolean bool = false;
    int i = 1;
    Object localObject;
    if (paramArrayList.hasNext()) {
      localObject = (ShortcutBarInfo)paramArrayList.next();
    }
    label285:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter.b(Long.valueOf(((ShortcutBarInfo)localObject).a()), Long.valueOf(((ShortcutBarInfo)localObject).b()));
        }
        View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131561697, null);
        a((ShortcutBarInfo)localObject, localView);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
        if (i == 0) {
          break label285;
        }
        localObject = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getResources()), 0, 0, 0);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        i = 0;
        bool = true;
      }
      catch (OutOfMemoryError paramArrayList)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LeftAppShortcutBarPanel", 2, "ShortcutBarAioHelper.updateMessageShortcutPanel got OOM, e:" + paramArrayList.getMessage());
        }
        System.gc();
        return;
      }
      catch (InflateException paramArrayList)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LeftAppShortcutBarPanel", 2, "ShortcutBarAioHelper.updateMessageShortcutPanel got InflateException, e:" + paramArrayList.getMessage());
        }
        System.gc();
        return;
      }
      this.jdField_c_of_type_Boolean = bool;
      if (!bool) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper.h();
      return;
    }
  }
  
  private void c(ArrayList<ShortcutBarInfo> paramArrayList)
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper == null) || (this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener == null)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog == null) || ((this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog.a())))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog = new PopupMoreListDialog(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper, this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener, this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter);
        this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog.a(paramArrayList);
    } while ((!this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog.a()) || (this.jdField_a_of_type_AndroidViewView == null));
    paramArrayList = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(paramArrayList);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog.a() > 5) {}
    for (int i = ViewUtils.a(247.0F);; i = ViewUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog.a() * 40 + 7))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog.a(this.jdField_a_of_type_AndroidViewView, paramArrayList[0] - ViewUtils.a(175.0F) / 2, paramArrayList[1] - i - 5, ViewUtils.a(175.0F), i);
      return;
    }
  }
  
  public int a()
  {
    int j = 2;
    int i = j;
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
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
    if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter.c();
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper = null;
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {
      return;
    }
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper.i();
      }
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    if ((paramArrayList.size() > 3) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount() > 0))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      if (i < paramArrayList.size())
      {
        if (i < 2) {
          localArrayList1.add(paramArrayList.get(i));
        }
        for (;;)
        {
          i += 1;
          break;
          localArrayList2.add(paramArrayList.get(i));
        }
      }
      b(localArrayList1);
      a(new ImportantMsgInfo(0L, 0L, "更多", "", "", 0L, 0), localArrayList2);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog.a())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog.d();
    }
    b(paramArrayList);
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
    if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgPopupMoreListDialog.b();
    }
  }
  
  public void d() {}
  
  public void e()
  {
    if ((this.jdField_c_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper == null)) {}
    for (;;)
    {
      return;
      if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperShortcutBarAIOHelper.a()) != null)
      {
        Rect localRect = new Rect();
        this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getHitRect(localRect);
        int i = 0;
        while (i < this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildCount())
        {
          Object localObject = this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          if ((localObject != null) && (((View)localObject).getLocalVisibleRect(localRect)))
          {
            localObject = ((View)localObject).getTag();
            if ((localObject instanceof ImportantMsgInfo))
            {
              localObject = (ImportantMsgInfo)localObject;
              if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter != null)) {
                this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarImportantmsgImportantMessageReporter.c(Long.valueOf(((ImportantMsgInfo)localObject).a()), Long.valueOf(((ImportantMsgInfo)localObject).b()));
              }
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.LeftAppShortcutBarPanel
 * JD-Core Version:    0.7.0.1
 */