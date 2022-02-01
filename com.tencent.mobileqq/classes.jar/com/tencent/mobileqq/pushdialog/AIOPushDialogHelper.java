package com.tencent.mobileqq.pushdialog;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.UniteEntity;
import com.tencent.mobileqq.graytip.UniteEntity.Note;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.NumberUtil;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AIOPushDialogHelper
  implements ILifeCycleHelper
{
  private int jdField_a_of_type_Int = 14;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  @Nullable
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  @Nullable
  private SafeBlowObserver jdField_a_of_type_ComTencentMobileqqPushdialogSafeBlowObserver;
  public QQCustomDialog a;
  
  public AIOPushDialogHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    if (paramBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getEntityManagerFactory().createEntityManager();
    }
  }
  
  private UniteEntity a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = UniteGrayTipUtil.a(new String(paramArrayOfByte, "utf-8"));
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  private void a(EntityManager paramEntityManager, long paramLong)
  {
    PushDialogDbUtil.a().a(paramEntityManager, paramLong, new AIOPushDialogHelper.1(this));
  }
  
  private void a(PushDialogTemplate paramPushDialogTemplate, int paramInt)
  {
    if ((paramInt == 103) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)) {
      PushDialogDbUtil.a().a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, paramPushDialogTemplate);
    }
  }
  
  private void a(QQCustomDialog paramQQCustomDialog, UniteEntity paramUniteEntity, PushDialogTemplate paramPushDialogTemplate)
  {
    paramUniteEntity = paramUniteEntity.a();
    if (paramUniteEntity.a() != 6) {
      return;
    }
    paramUniteEntity = paramUniteEntity.a();
    if (paramUniteEntity != null)
    {
      if (paramUniteEntity.size() == 0) {
        return;
      }
      paramUniteEntity = paramUniteEntity.iterator();
      while (paramUniteEntity.hasNext())
      {
        Object localObject1 = (UniteEntity.Note)paramUniteEntity.next();
        Object localObject3 = ((UniteEntity.Note)localObject1).a();
        Object localObject2 = ((UniteEntity.Note)localObject1).a();
        if (((UniteEntity.Note)localObject1).a() == 7)
        {
          localObject1 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            paramQQCustomDialog.setTitle((String)localObject1);
          }
        }
        else
        {
          int j = ((UniteEntity.Note)localObject1).a();
          int i = 0;
          if (j == 8)
          {
            localObject1 = (String)((HashMap)localObject3).get(Integer.valueOf(1));
            if ((localObject2 != null) && (((List)localObject2).size() != 0))
            {
              localObject1 = new SpannableStringBuilder();
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                Object localObject4 = (UniteEntity.Note)((Iterator)localObject2).next();
                localObject3 = ((UniteEntity.Note)localObject4).a();
                String str1;
                if (((UniteEntity.Note)localObject4).a() == 2)
                {
                  if (localObject3 != null)
                  {
                    localObject4 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
                    str1 = (String)((HashMap)localObject3).get(Integer.valueOf(3));
                    localObject3 = (String)((HashMap)localObject3).get(Integer.valueOf(5));
                    if (!TextUtils.isEmpty((CharSequence)localObject4))
                    {
                      localObject3 = new SpannableString((CharSequence)localObject4);
                      ((SpannableString)localObject3).setSpan(Integer.valueOf(Color.parseColor("#03081A")), 0, ((SpannableString)localObject3).length(), 33);
                      ((SpannableStringBuilder)localObject1).append((CharSequence)localObject3);
                    }
                  }
                }
                else if ((((UniteEntity.Note)localObject4).a() == 3) && (localObject3 != null))
                {
                  localObject4 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
                  str1 = (String)((HashMap)localObject3).get(Integer.valueOf(4));
                  String str2 = (String)((HashMap)localObject3).get(Integer.valueOf(3));
                  localObject3 = (String)((HashMap)localObject3).get(Integer.valueOf(5));
                  SpannableString localSpannableString = new SpannableString((CharSequence)localObject4);
                  localSpannableString.setSpan(new AIOPushDialogHelper.2(this, str1, (String)localObject3, str2), 0, ((String)localObject4).length(), 33);
                  ((SpannableStringBuilder)localObject1).append(localSpannableString);
                }
              }
              paramQQCustomDialog.setMessageWithoutAutoLink((CharSequence)localObject1);
            }
          }
          else if ((((UniteEntity.Note)localObject1).a() == 9) && (localObject2 != null))
          {
            localObject1 = ((List)localObject2).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (UniteEntity.Note)((Iterator)localObject1).next();
              if (((UniteEntity.Note)localObject2).a() == 10)
              {
                localObject3 = ((UniteEntity.Note)localObject2).a();
                localObject2 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
                localObject3 = (String)((HashMap)localObject3).get(Integer.valueOf(4));
                if (i == 0) {
                  paramQQCustomDialog.setNegativeButton((String)localObject2, new AIOPushDialogHelper.3(this, (String)localObject3, paramPushDialogTemplate));
                } else if (i == 1) {
                  paramQQCustomDialog.setPositiveButton((String)localObject2, new AIOPushDialogHelper.4(this, (String)localObject3));
                }
                i += 1;
              }
            }
          }
        }
      }
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOPushDialogHelper", 2, "onCreate");
    }
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPushdialogSafeBlowObserver == null) {
        this.jdField_a_of_type_ComTencentMobileqqPushdialogSafeBlowObserver = new SafeBlowObserver();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqPushdialogSafeBlowObserver);
    }
  }
  
  private void b(PushDialogTemplate paramPushDialogTemplate, int paramInt)
  {
    if ((paramInt == 102) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)) {
      PushDialogDbUtil.a().b(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, paramPushDialogTemplate);
    }
    paramPushDialogTemplate = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (paramPushDialogTemplate != null) {
      paramPushDialogTemplate.dismiss();
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOPushDialogHelper", 2, "onDestroy");
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      SafeBlowObserver localSafeBlowObserver = this.jdField_a_of_type_ComTencentMobileqqPushdialogSafeBlowObserver;
      if (localSafeBlowObserver != null)
      {
        localQQAppInterface.removeObserver(localSafeBlowObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject != null)
      {
        localObject = (SafeBlowHandler)((QQAppInterface)localObject).getBusinessHandler(SafeBlowHandler.a);
        long l = NumberUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        if ((localObject == null) || (l == 0L)) {
          return;
        }
        ((SafeBlowHandler)localObject).a(l);
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mChatPie == null ? = ");
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    boolean bool2 = false;
    if (localBaseChatPie == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(", mApp == null ? = ");
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      bool1 = true;
    }
    ((StringBuilder)localObject).append(bool1);
    QLog.e("AIOPushDialogHelper", 1, ((StringBuilder)localObject).toString());
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject != null)
    {
      localObject = ((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, Long.valueOf((String)localObject).longValue());
          return;
        }
        catch (Exception localException)
        {
          QLog.e("AIOPushDialogHelper", 1, "db search error: ", localException);
        }
      }
    }
  }
  
  public void a(PushDialogTemplate paramPushDialogTemplate, int paramInt1, int paramInt2)
  {
    if ((paramPushDialogTemplate != null) && (paramPushDialogTemplate.templ_content != null))
    {
      UniteEntity localUniteEntity = a(paramPushDialogTemplate.templ_content);
      if (localUniteEntity != null)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
        if (localObject == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = new QQCustomDialog(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131756189);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setContentView(2131558978);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
          localObject = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131363688);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
          localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, 30.0F);
          localLayoutParams.rightMargin = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, 30.0F);
          ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
        }
        else
        {
          ((QQCustomDialog)localObject).dismiss();
        }
        a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog, localUniteEntity, paramPushDialogTemplate);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        if (this.jdField_a_of_type_Int == 5)
        {
          a(paramPushDialogTemplate, paramInt2);
          if (paramPushDialogTemplate.isFriendBanned()) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "dc00898", "", "", "0X800A4B9", "0X800A4B9", 0, 0, "", "", "", "");
          } else {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "dc00898", "", "", "0X800A4B8", "0X800A4B8", 0, 0, "", "", "", "");
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B9A1", "0X800B9A1", 0, 0, "", "", "", "");
          return;
        }
        b(paramPushDialogTemplate, paramInt1);
      }
    }
  }
  
  public void a(List<PushDialogTemplate> paramList, int paramInt1, int paramInt2)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      int i = 0;
      while (i < paramList.size())
      {
        a((PushDialogTemplate)paramList.get(i), paramInt1, paramInt2);
        i += 1;
      }
    }
  }
  
  public String getTag()
  {
    return "AIOPushDialogHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 12, 5, 9, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 5)
      {
        if (paramInt != 9)
        {
          if (paramInt != 12)
          {
            if (paramInt != 15) {
              return;
            }
            c();
            return;
          }
          this.jdField_a_of_type_Int = 12;
          QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
          if (localQQCustomDialog != null) {
            localQQCustomDialog.dismiss();
          }
        }
        else
        {
          a();
        }
      }
      else {
        this.jdField_a_of_type_Int = 5;
      }
    }
    else {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.AIOPushDialogHelper
 * JD-Core Version:    0.7.0.1
 */