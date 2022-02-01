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
  public QQCustomDialog a;
  private int b = 14;
  private EntityManager c;
  private BaseChatPie d;
  @Nullable
  private SafeBlowObserver e;
  @Nullable
  private QQAppInterface f;
  
  public AIOPushDialogHelper(BaseChatPie paramBaseChatPie)
  {
    this.d = paramBaseChatPie;
    if (paramBaseChatPie != null) {
      this.c = this.d.i().getEntityManagerFactory().createEntityManager();
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
    if ((paramInt == 103) && (this.c != null)) {
      PushDialogDbUtil.a().a(this.c, paramPushDialogTemplate);
    }
  }
  
  private void a(QQCustomDialog paramQQCustomDialog, UniteEntity paramUniteEntity, PushDialogTemplate paramPushDialogTemplate)
  {
    paramUniteEntity = paramUniteEntity.a();
    if (paramUniteEntity.d() != 6) {
      return;
    }
    paramUniteEntity = paramUniteEntity.e();
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
        Object localObject2 = ((UniteEntity.Note)localObject1).e();
        if (((UniteEntity.Note)localObject1).d() == 7)
        {
          localObject1 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            paramQQCustomDialog.setTitle((String)localObject1);
          }
        }
        else
        {
          int j = ((UniteEntity.Note)localObject1).d();
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
                if (((UniteEntity.Note)localObject4).d() == 2)
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
                else if ((((UniteEntity.Note)localObject4).d() == 3) && (localObject3 != null))
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
          else if ((((UniteEntity.Note)localObject1).d() == 9) && (localObject2 != null))
          {
            localObject1 = ((List)localObject2).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (UniteEntity.Note)((Iterator)localObject1).next();
              if (((UniteEntity.Note)localObject2).d() == 10)
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
    BaseChatPie localBaseChatPie = this.d;
    if (localBaseChatPie != null) {
      this.f = localBaseChatPie.d;
    }
    if (this.f != null)
    {
      if (this.e == null) {
        this.e = new SafeBlowObserver();
      }
      this.f.addObserver(this.e);
    }
  }
  
  private void b(PushDialogTemplate paramPushDialogTemplate, int paramInt)
  {
    if ((paramInt == 102) && (this.c != null)) {
      PushDialogDbUtil.a().b(this.c, paramPushDialogTemplate);
    }
    paramPushDialogTemplate = this.a;
    if (paramPushDialogTemplate != null) {
      paramPushDialogTemplate.dismiss();
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOPushDialogHelper", 2, "onDestroy");
    }
    QQAppInterface localQQAppInterface = this.f;
    if (localQQAppInterface != null)
    {
      SafeBlowObserver localSafeBlowObserver = this.e;
      if (localSafeBlowObserver != null)
      {
        localQQAppInterface.removeObserver(localSafeBlowObserver);
        this.f = null;
      }
    }
  }
  
  private void d()
  {
    if (this.d != null)
    {
      localObject = this.f;
      if (localObject != null)
      {
        localObject = (SafeBlowHandler)((QQAppInterface)localObject).getBusinessHandler(SafeBlowHandler.a);
        long l = NumberUtil.b(this.d.ah.b);
        if ((localObject == null) || (l == 0L)) {
          return;
        }
        ((SafeBlowHandler)localObject).a(l);
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mChatPie == null ? = ");
    BaseChatPie localBaseChatPie = this.d;
    boolean bool2 = false;
    if (localBaseChatPie == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(", mApp == null ? = ");
    boolean bool1 = bool2;
    if (this.f == null) {
      bool1 = true;
    }
    ((StringBuilder)localObject).append(bool1);
    QLog.e("AIOPushDialogHelper", 1, ((StringBuilder)localObject).toString());
  }
  
  public void a()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((BaseChatPie)localObject).ah.b;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          a(this.c, Long.valueOf((String)localObject).longValue());
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
        Object localObject = this.a;
        if (localObject == null)
        {
          this.a = new QQCustomDialog(this.d.e, 2131953338);
          this.a.setContentView(2131624611);
          this.a.setCanceledOnTouchOutside(false);
          localObject = (LinearLayout)this.a.findViewById(2131429603);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
          localLayoutParams.leftMargin = DisplayUtil.a(this.d.e, 30.0F);
          localLayoutParams.rightMargin = DisplayUtil.a(this.d.e, 30.0F);
          ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
        }
        else
        {
          ((QQCustomDialog)localObject).dismiss();
        }
        a(this.a, localUniteEntity, paramPushDialogTemplate);
        this.a.show();
        if (this.b == 5)
        {
          a(paramPushDialogTemplate, paramInt2);
          if (paramPushDialogTemplate.isFriendBanned()) {
            ReportController.b(this.d.i(), "dc00898", "", "", "0X800A4B9", "0X800A4B9", 0, 0, "", "", "", "");
          } else {
            ReportController.b(this.d.i(), "dc00898", "", "", "0X800A4B8", "0X800A4B8", 0, 0, "", "", "", "");
          }
          ReportController.b(this.f, "dc00898", "", "", "0X800B9A1", "0X800B9A1", 0, 0, "", "", "", "");
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
          this.b = 12;
          QQCustomDialog localQQCustomDialog = this.a;
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
        this.b = 5;
      }
    }
    else {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.AIOPushDialogHelper
 * JD-Core Version:    0.7.0.1
 */