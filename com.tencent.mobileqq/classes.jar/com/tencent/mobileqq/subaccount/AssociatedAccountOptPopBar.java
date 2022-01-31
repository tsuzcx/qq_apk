package com.tencent.mobileqq.subaccount;

import ahwd;
import ahwe;
import ahwf;
import ahwg;
import ahwh;
import ahwi;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.debug.PstnCardTestActivity;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.LeftPopupMenuDialog;
import com.tencent.mobileqq.widget.LeftPopupMenuDialog.IItemAdapter;
import com.tencent.mobileqq.widget.LeftPopupMenuDialog.MenuItem;
import com.tencent.mobileqq.widget.LeftPopupMenuDialog.OnClickActionListener;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.PopupMenuDialog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import mqq.app.MobileQQ;

public class AssociatedAccountOptPopBar
  implements PopupWindow.OnDismissListener, LeftPopupMenuDialog.IItemAdapter, LeftPopupMenuDialog.OnClickActionListener
{
  public int a;
  public Handler a;
  public BaseActivity a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ahwf(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ahwh(this);
  private SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new ahwg(this);
  public LeftPopupMenuDialog a;
  public QQProgressDialog a;
  public String a;
  public List a;
  private Observer jdField_a_of_type_JavaUtilObserver = new ahwi(this);
  public boolean a;
  public boolean b;
  
  public AssociatedAccountOptPopBar(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  private View a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (a()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.getContentView() != null))
    {
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.getContentView().findViewById(2131363039);
      if (localViewGroup != null)
      {
        int i = 0;
        if (i < localViewGroup.getChildCount())
        {
          View localView = localViewGroup.getChildAt(i);
          Object localObject;
          if (localView != null)
          {
            localObject = localView.getTag();
            if ((localObject != null) && ((localObject instanceof LeftPopupMenuDialog.MenuItem)))
            {
              localObject = (LeftPopupMenuDialog.MenuItem)localObject;
              if (((LeftPopupMenuDialog.MenuItem)localObject).jdField_a_of_type_JavaLangObject != null) {
                break label120;
              }
            }
          }
          label120:
          do
          {
            do
            {
              i += 1;
              break;
              if (!(((LeftPopupMenuDialog.MenuItem)localObject).jdField_a_of_type_JavaLangObject instanceof SubAccountInfo)) {
                break label152;
              }
            } while (!TextUtils.equals(paramString, ((SubAccountInfo)((LeftPopupMenuDialog.MenuItem)localObject).jdField_a_of_type_JavaLangObject).subuin));
            return localView;
          } while ((!(((LeftPopupMenuDialog.MenuItem)localObject).jdField_a_of_type_JavaLangObject instanceof SimpleAccount)) || (!TextUtils.equals(paramString, ((SimpleAccount)((LeftPopupMenuDialog.MenuItem)localObject).jdField_a_of_type_JavaLangObject).getUin())));
          label152:
          return localView;
        }
      }
    }
    return null;
  }
  
  private void a(View paramView, LeftPopupMenuDialog.MenuItem paramMenuItem)
  {
    if ((!AppSetting.b) || (paramView == null) || (paramMenuItem == null)) {
      return;
    }
    if (paramMenuItem.jdField_b_of_type_Int > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramMenuItem.jdField_b_of_type_Int == 1) {
        localStringBuilder.append(" 有一条未读");
      }
      for (;;)
      {
        paramView.setContentDescription(paramMenuItem.jdField_b_of_type_JavaLangString + localStringBuilder.toString());
        return;
        if (paramMenuItem.jdField_b_of_type_Int == 2) {
          localStringBuilder.append(" 有两条未读");
        } else if (paramMenuItem.jdField_b_of_type_Int > 0) {
          localStringBuilder.append(" 有").append(paramMenuItem.jdField_b_of_type_Int).append("条未读");
        }
      }
    }
    paramView.setContentDescription(paramMenuItem.jdField_b_of_type_JavaLangString);
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountOptPopBar", 2, "loadMenuItemList activity==null or app==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountOptPopBar", 2, "loadMenuItemList");
    }
    ArrayList localArrayList1 = new ArrayList();
    if (AppSetting.b) {}
    for (Object localObject1 = " " + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131437109);; localObject1 = "")
    {
      Object localObject4 = new ArrayList();
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getApplication().getAllAccounts();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        ((List)localObject4).addAll((Collection)localObject2);
      }
      ArrayList localArrayList2 = ((SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(60)).b();
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountOptPopBar", 2, "loadMenuItemList subAccounts.size() = " + localArrayList2.size());
      }
      int i = 1;
      Object localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a();
      Object localObject6 = new ArrayList();
      Object localObject7 = localArrayList2.iterator();
      SubAccountInfo localSubAccountInfo;
      Object localObject3;
      if (((Iterator)localObject7).hasNext())
      {
        localSubAccountInfo = (SubAccountInfo)((Iterator)localObject7).next();
        j = i;
        LeftPopupMenuDialog.MenuItem localMenuItem;
        if (localSubAccountInfo != null)
        {
          j = i;
          if (!TextUtils.isEmpty(localSubAccountInfo.subuin))
          {
            localMenuItem = new LeftPopupMenuDialog.MenuItem();
            localMenuItem.jdField_a_of_type_Int = i;
            localObject3 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, localSubAccountInfo.subuin, false);
            localObject2 = localObject3;
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              localObject2 = localSubAccountInfo.subuin;
            }
            localMenuItem.jdField_a_of_type_JavaLangString = ((String)localObject2);
            localMenuItem.c = 0;
            if (localSubAccountInfo.status != 1) {
              break label507;
            }
            localMenuItem.jdField_b_of_type_Int = ((ConversationFacade)localObject5).a(localSubAccountInfo.subuin, 7000);
          }
        }
        for (localMenuItem.d = 0;; localMenuItem.d = 1)
        {
          localMenuItem.jdField_a_of_type_JavaLangObject = localSubAccountInfo;
          if (AppSetting.b) {
            localMenuItem.jdField_b_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436399, new Object[] { localMenuItem.jdField_a_of_type_JavaLangString }) + (String)localObject1);
          }
          localMenuItem.jdField_a_of_type_Long = localSubAccountInfo.lasttime;
          ((List)localObject6).add(localMenuItem);
          i += 1;
          j = i;
          if (QLog.isColorLevel())
          {
            QLog.d("AssociatedAccountOptPopBar", 1, "loadMenuItemList subAccount uin:" + localSubAccountInfo.subuin + " showName:" + (String)localObject2);
            j = i;
          }
          i = j;
          break;
          label507:
          localMenuItem.jdField_b_of_type_Int = 0;
        }
      }
      if (((List)localObject6).size() > 1) {
        Collections.sort((List)localObject6);
      }
      localArrayList1.addAll((Collection)localObject6);
      this.jdField_a_of_type_Int = ((List)localObject6).size();
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountOptPopBar", 2, "loadMenuItemList after add subaccount item.size() = " + localArrayList1.size());
      }
      localObject2 = new ArrayList();
      int j = i;
      if (localObject4 != null)
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.c();
        localObject5 = ((List)localObject4).iterator();
      }
      label1824:
      label1825:
      for (;;)
      {
        j = i;
        if (((Iterator)localObject5).hasNext())
        {
          localObject6 = (SimpleAccount)((Iterator)localObject5).next();
          if ((localObject6 == null) || (((String)localObject3).equals(((SimpleAccount)localObject6).getUin()))) {
            continue;
          }
          localObject7 = localArrayList2.iterator();
          j = 0;
          label687:
          if (((Iterator)localObject7).hasNext())
          {
            localSubAccountInfo = (SubAccountInfo)((Iterator)localObject7).next();
            if ((localSubAccountInfo == null) || (!((SimpleAccount)localObject6).getUin().equals(localSubAccountInfo.subuin))) {
              break label1824;
            }
            j = 1;
          }
        }
        for (;;)
        {
          break label687;
          if (j != 0) {
            break label1825;
          }
          localObject7 = new LeftPopupMenuDialog.MenuItem();
          ((LeftPopupMenuDialog.MenuItem)localObject7).jdField_a_of_type_Int = i;
          ((LeftPopupMenuDialog.MenuItem)localObject7).jdField_a_of_type_JavaLangString = SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, (SimpleAccount)localObject6);
          ((LeftPopupMenuDialog.MenuItem)localObject7).c = 1;
          ((LeftPopupMenuDialog.MenuItem)localObject7).d = 0;
          ((LeftPopupMenuDialog.MenuItem)localObject7).jdField_b_of_type_Int = SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, ((SimpleAccount)localObject6).getUin());
          ((LeftPopupMenuDialog.MenuItem)localObject7).jdField_a_of_type_JavaLangObject = localObject6;
          if (AppSetting.b) {
            ((LeftPopupMenuDialog.MenuItem)localObject7).jdField_b_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436400, new Object[] { ((LeftPopupMenuDialog.MenuItem)localObject7).jdField_a_of_type_JavaLangString }) + (String)localObject1);
          }
          ((LeftPopupMenuDialog.MenuItem)localObject7).jdField_a_of_type_Long = SubAccountControll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, ((SimpleAccount)localObject6).getUin());
          ((List)localObject2).add(localObject7);
          j = i + 1;
          i = j;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AssociatedAccountOptPopBar", 1, "loadMenuItemList thirdAccount uin:" + ((SimpleAccount)localObject6).getUin() + " showName:" + ((LeftPopupMenuDialog.MenuItem)localObject7).jdField_a_of_type_JavaLangString);
          i = j;
          break;
          if (((List)localObject2).size() > 1) {
            Collections.sort((List)localObject2);
          }
          if (((List)localObject2).size() > 0)
          {
            localArrayList1.addAll((Collection)localObject2);
            this.jdField_a_of_type_Int += 1;
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("loadMenuItemList allAccounts=[size:").append(((List)localObject4).size()).append(";uins:");
            localObject3 = ((List)localObject4).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((StringBuilder)localObject2).append(((SimpleAccount)((Iterator)localObject3).next()).getUin()).append(";");
            }
            ((StringBuilder)localObject2).append("] mainUin:").append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.c());
            ((StringBuilder)localObject2).append("; displayUin:[");
            localObject3 = localArrayList1.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (LeftPopupMenuDialog.MenuItem)((Iterator)localObject3).next();
              if (localObject4 != null) {
                if ((((LeftPopupMenuDialog.MenuItem)localObject4).jdField_a_of_type_JavaLangObject instanceof SimpleAccount)) {
                  ((StringBuilder)localObject2).append(((SimpleAccount)((LeftPopupMenuDialog.MenuItem)localObject4).jdField_a_of_type_JavaLangObject).getUin()).append("thd;");
                } else if ((((LeftPopupMenuDialog.MenuItem)localObject4).jdField_a_of_type_JavaLangObject instanceof SubAccountInfo)) {
                  ((StringBuilder)localObject2).append(((SubAccountInfo)((LeftPopupMenuDialog.MenuItem)localObject4).jdField_a_of_type_JavaLangObject).subuin).append("sub;");
                }
              }
            }
            ((StringBuilder)localObject2).append("]");
            QLog.i("AssociatedAccountOptPopBar", 2, ((StringBuilder)localObject2).toString());
          }
          if (QLog.isColorLevel()) {
            QLog.d("AssociatedAccountOptPopBar", 2, "loadMenuItemList after add third account item.size() = " + localArrayList1.size());
          }
          if (localArrayList1.size() > 0)
          {
            localObject2 = new LeftPopupMenuDialog.MenuItem();
            ((LeftPopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_Int = 0;
            ((LeftPopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131434519);
            ((LeftPopupMenuDialog.MenuItem)localObject2).c = 3;
            ((LeftPopupMenuDialog.MenuItem)localObject2).d = 0;
            ((LeftPopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_JavaLangObject = null;
            if (AppSetting.b) {
              ((LeftPopupMenuDialog.MenuItem)localObject2).jdField_b_of_type_JavaLangString = ((LeftPopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_JavaLangString;
            }
            localArrayList1.add(0, localObject2);
            if (localArrayList1.size() <= 8)
            {
              localObject2 = new LeftPopupMenuDialog.MenuItem();
              ((LeftPopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_Int = j;
              ((LeftPopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436394);
              ((LeftPopupMenuDialog.MenuItem)localObject2).c = 2;
              ((LeftPopupMenuDialog.MenuItem)localObject2).d = 0;
              ((LeftPopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_JavaLangObject = null;
              if (AppSetting.b) {
                ((LeftPopupMenuDialog.MenuItem)localObject2).jdField_b_of_type_JavaLangString = (((LeftPopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_JavaLangString + (String)localObject1);
              }
              localArrayList1.add(localObject2);
            }
          }
          for (;;)
          {
            if ((AudioHelper.d()) && (AudioHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)))
            {
              localObject1 = new LeftPopupMenuDialog.MenuItem();
              i = j + 1;
              ((LeftPopupMenuDialog.MenuItem)localObject1).jdField_a_of_type_Int = i;
              ((LeftPopupMenuDialog.MenuItem)localObject1).jdField_a_of_type_JavaLangString = "退出(release下看到请立即联系soongao)";
              ((LeftPopupMenuDialog.MenuItem)localObject1).c = 100;
              ((LeftPopupMenuDialog.MenuItem)localObject1).d = 0;
              localArrayList1.add(localObject1);
              localObject1 = new LeftPopupMenuDialog.MenuItem();
              ((LeftPopupMenuDialog.MenuItem)localObject1).jdField_a_of_type_Int = (i + 1);
              ((LeftPopupMenuDialog.MenuItem)localObject1).jdField_a_of_type_JavaLangString = "显示音视频debug页面";
              ((LeftPopupMenuDialog.MenuItem)localObject1).c = 101;
              ((LeftPopupMenuDialog.MenuItem)localObject1).d = 0;
              localArrayList1.add(localObject1);
            }
            if (QLog.isColorLevel()) {
              QLog.d("AssociatedAccountOptPopBar", 2, "loadMenuItemList end item.size() = " + localArrayList1.size());
            }
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
            return;
            localObject2 = new LeftPopupMenuDialog.MenuItem();
            ((LeftPopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_Int = j;
            ((LeftPopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436402);
            ((LeftPopupMenuDialog.MenuItem)localObject2).c = 4;
            ((LeftPopupMenuDialog.MenuItem)localObject2).d = 0;
            ((LeftPopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_JavaLangObject = null;
            if (AppSetting.b) {
              ((LeftPopupMenuDialog.MenuItem)localObject2).jdField_b_of_type_JavaLangString = (((LeftPopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_JavaLangString + (String)localObject1);
            }
            localArrayList1.add(localObject2);
            continue;
            localObject2 = new LeftPopupMenuDialog.MenuItem();
            ((LeftPopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_Int = j;
            ((LeftPopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436394);
            ((LeftPopupMenuDialog.MenuItem)localObject2).c = 2;
            ((LeftPopupMenuDialog.MenuItem)localObject2).d = 0;
            ((LeftPopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_JavaLangObject = null;
            if (AppSetting.b) {
              ((LeftPopupMenuDialog.MenuItem)localObject2).jdField_b_of_type_JavaLangString = (((LeftPopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_JavaLangString + (String)localObject1);
            }
            localArrayList1.add(localObject2);
          }
        }
      }
    }
  }
  
  public int a(LeftPopupMenuDialog.MenuItem paramMenuItem, int paramInt1, int paramInt2)
  {
    if (paramInt2 > 1)
    {
      if (paramInt1 >= 1) {
        return PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131559370);
      }
      return PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131559371);
    }
    return PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131559372);
  }
  
  public View a(View paramView, LeftPopupMenuDialog.MenuItem paramMenuItem, int paramInt1, int paramInt2)
  {
    View localView;
    FixSizeImageView localFixSizeImageView;
    Object localObject;
    DragTextView localDragTextView;
    if (paramInt2 > 1) {
      switch (paramMenuItem.c)
      {
      default: 
        paramView = null;
        return paramView;
      case 0: 
      case 1: 
        localView = paramView;
        if (paramView == null) {
          localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130971556, null);
        }
        localView.setBackgroundResource(2130838682);
        localFixSizeImageView = (FixSizeImageView)localView.findViewById(2131362701);
        localObject = (ImageView)localView.findViewById(2131374998);
        paramView = (TextView)localView.findViewById(2131363360);
        localDragTextView = (DragTextView)localView.findViewById(2131363189);
        paramView.setText(paramMenuItem.jdField_a_of_type_JavaLangString);
        if (paramMenuItem.c == 0)
        {
          ((ImageView)localObject).setVisibility(0);
          if (!(paramMenuItem.jdField_a_of_type_JavaLangObject instanceof SubAccountInfo)) {
            break label659;
          }
        }
        break;
      }
    }
    label261:
    label274:
    label659:
    for (paramView = (SubAccountInfo)paramMenuItem.jdField_a_of_type_JavaLangObject;; paramView = null)
    {
      if (paramView != null)
      {
        FaceDrawable localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, 1, paramView.subuin);
        localFixSizeImageView.setTag(paramView.subuin);
        localFixSizeImageView.setImageDrawable(localFaceDrawable);
      }
      if (paramMenuItem.jdField_b_of_type_Int > 0)
      {
        CustomWidgetUtil.a(localDragTextView, 3, paramMenuItem.jdField_b_of_type_Int, 2130845927, 99, null);
        if (paramMenuItem.d != 0) {
          break label316;
        }
        ((ImageView)localObject).setBackgroundDrawable(null);
      }
      for (;;)
      {
        paramView = localView;
        if (!AppSetting.b) {
          break;
        }
        paramView = localView;
        if (TextUtils.isEmpty(paramMenuItem.jdField_b_of_type_JavaLangString)) {
          break;
        }
        a(localView, paramMenuItem);
        return localView;
        localDragTextView.setVisibility(8);
        break label261;
        label316:
        ((ImageView)localObject).setBackgroundResource(2130845980);
      }
      ((ImageView)localObject).setVisibility(8);
      if ((paramMenuItem.jdField_a_of_type_JavaLangObject instanceof SimpleAccount)) {}
      for (paramView = (SimpleAccount)paramMenuItem.jdField_a_of_type_JavaLangObject;; paramView = null)
      {
        if (paramView != null)
        {
          localObject = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, 1, paramView.getUin());
          localFixSizeImageView.setTag(paramView.getUin());
          localFixSizeImageView.setImageDrawable((Drawable)localObject);
        }
        if (paramMenuItem.jdField_b_of_type_Int > 0)
        {
          CustomWidgetUtil.a(localDragTextView, 3, paramMenuItem.jdField_b_of_type_Int, 2130845928, 99, null);
          break label274;
        }
        localDragTextView.setVisibility(8);
        break label274;
        localView = paramView;
        if (paramView == null) {
          localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130971557, null);
        }
        ((TextView)localView.findViewById(2131363360)).setText(paramMenuItem.jdField_a_of_type_JavaLangString);
        localView.setBackgroundResource(2130838681);
        paramView = localView;
        if (!AppSetting.b) {
          break;
        }
        paramView = localView;
        if (TextUtils.isEmpty(paramMenuItem.jdField_b_of_type_JavaLangString)) {
          break;
        }
        localView.setContentDescription(paramMenuItem.jdField_b_of_type_JavaLangString);
        return localView;
        localView = paramView;
        if (paramView == null) {
          localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130971559, null);
        }
        ((TextView)localView.findViewById(2131363360)).setText(paramMenuItem.jdField_a_of_type_JavaLangString);
        localView.setBackgroundDrawable(null);
        paramView = localView;
        if (!AppSetting.b) {
          break;
        }
        paramView = localView;
        if (TextUtils.isEmpty(paramMenuItem.jdField_b_of_type_JavaLangString)) {
          break;
        }
        localView.setContentDescription(paramMenuItem.jdField_b_of_type_JavaLangString);
        return localView;
        localView = paramView;
        if (paramView == null) {
          localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130971558, null);
        }
        localView.setBackgroundResource(2130845977);
        paramView = localView;
        if (!AppSetting.b) {
          break;
        }
        paramView = localView;
        if (TextUtils.isEmpty(paramMenuItem.jdField_b_of_type_JavaLangString)) {
          break;
        }
        localView.setContentDescription(paramMenuItem.jdField_b_of_type_JavaLangString);
        return localView;
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountOptPopBar", 2, "initOptionBar");
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    g();
    this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog = LeftPopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaUtilList, this, this, this);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    }
    if (paramInt > 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131435053);
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountOptPopBar", 2, "leak test show() xOffset=" + paramInt1 + " yOffset=" + paramInt2);
    }
    this.jdField_a_of_type_Boolean = true;
    this.b = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog == null) {
      a();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = null;
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.getContentView() != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.getContentView().getVisibility() != 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.getContentView().setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.showAsDropDown(paramView, paramInt1, paramInt2);
      this.jdField_a_of_type_AndroidOsHandler.post(new ahwd(this));
      paramView = new Intent("before_account_change");
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.sendBroadcast(paramView);
      return;
      g();
      this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void a(LeftPopupMenuDialog.MenuItem paramMenuItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountOptPopBar", 2, "onClickAction");
    }
    if ((paramMenuItem == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null)) {}
    while (!PhoneNumLoginImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountOptPopBar", 2, "onClickAction item.type = " + paramMenuItem.c);
    }
    SubAccountInfo localSubAccountInfo;
    switch (paramMenuItem.c)
    {
    default: 
      return;
    case 0: 
      if ((paramMenuItem.jdField_a_of_type_JavaLangObject != null) && ((paramMenuItem.jdField_a_of_type_JavaLangObject instanceof SubAccountInfo)))
      {
        localSubAccountInfo = (SubAccountInfo)paramMenuItem.jdField_a_of_type_JavaLangObject;
        paramMenuItem = new ArrayList();
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getApplication().getAllAccounts();
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          paramMenuItem.addAll((Collection)localObject);
        }
        if (paramMenuItem != null)
        {
          localObject = paramMenuItem.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            paramMenuItem = (SimpleAccount)((Iterator)localObject).next();
          } while (!paramMenuItem.getUin().equalsIgnoreCase(localSubAccountInfo.subuin));
        }
      }
      break;
    }
    for (;;)
    {
      if (paramMenuItem == null)
      {
        paramMenuItem = new Intent("before_account_change");
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.sendBroadcast(paramMenuItem);
        paramMenuItem = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SubAccountUgActivity.class);
        paramMenuItem.putExtra("subAccount", localSubAccountInfo.subuin);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramMenuItem);
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X80072D2", "0X80072D2", 0, 0, "", "", "", "");
        return;
        a(paramMenuItem);
      }
      if ((paramMenuItem.jdField_a_of_type_JavaLangObject != null) && ((paramMenuItem.jdField_a_of_type_JavaLangObject instanceof SimpleAccount))) {
        a((SimpleAccount)paramMenuItem.jdField_a_of_type_JavaLangObject);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X80072D3", "0X80072D3", 0, 0, "", "", "", "");
      return;
      paramMenuItem = new Intent();
      paramMenuItem.setPackage(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getPackageName());
      paramMenuItem.setClass(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AddAccountActivity.class);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramMenuItem);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2131034134, 2131034131);
      SubAccountAssistantForward.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X80072D4", "0X80072D4", 0, 0, "", "", "", "");
      return;
      paramMenuItem = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AccountManageActivity.class);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramMenuItem);
      return;
      AccountManageActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      return;
      paramMenuItem = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, PstnCardTestActivity.class);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramMenuItem);
      return;
      paramMenuItem = null;
    }
  }
  
  public void a(SimpleAccount paramSimpleAccount)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131432992), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountOptPopBar", 2, "switchAccount toAccount=" + paramSimpleAccount);
    }
    a(0);
    this.jdField_a_of_type_JavaLangString = paramSimpleAccount.getUin();
    Intent localIntent = new Intent("before_account_change");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.sendBroadcast(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.switchAccount(paramSimpleAccount, null);
    SubAccountAssistantForward.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    AlbumUtil.b();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountOptPopBar", 2, "dismiss()");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null)) {}
    while (!a()) {
      return;
    }
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.getContentView() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.getContentView().setVisibility(4);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.dismiss();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.isShowing());
  }
  
  public int b(LeftPopupMenuDialog.MenuItem paramMenuItem, int paramInt1, int paramInt2)
  {
    if (paramInt2 > 1) {
      return PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131559369);
    }
    return PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131559374);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.a();
    }
    if ((!a()) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_JavaUtilList.clear();
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.getContentView() != null))
      {
        View localView = this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.getContentView().findViewById(2131363039);
        if ((localView != null) && ((localView instanceof ViewGroup))) {
          ((ViewGroup)localView).removeAllViews();
        }
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountOptPopBar", 2, "leak test onDestroy()");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
      }
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountOptPopBar", 2, "onAccountChanged");
    }
    d();
    this.jdField_a_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.getContentView() != null))
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.getContentView().findViewById(2131363039);
      if ((localView != null) && ((localView instanceof ViewGroup))) {
        ((ViewGroup)localView).removeAllViews();
      }
    }
    a(false);
    SubAccountAssistantForward.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountOptPopBar", 2, "onAccoutChangeFailed");
    }
    d();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436403)).setMessage(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436404));
    localQQCustomDialog.setPositiveButton(2131432400, new ahwe(this));
    localQQCustomDialog.setCancelable(true);
    localQQCustomDialog.show();
  }
  
  public void onDismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountOptPopBar", 2, "leak test onDismiss()");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.AssociatedAccountOptPopBar
 * JD-Core Version:    0.7.0.1
 */