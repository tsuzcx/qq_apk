package com.tencent.mobileqq.facetoface;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class Face2FaceAddFriendActivity$9
  extends FriendObserver
{
  private int jdField_a_of_type_Int;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new Face2FaceAddFriendActivity.9.1(this);
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new Face2FaceAddFriendActivity.9.3(this);
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  DialogInterface.OnClickListener b = new Face2FaceAddFriendActivity.9.2(this);
  
  Face2FaceAddFriendActivity$9(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_Int != 0))
    {
      Object localObject1 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertTitle", 147, this.jdField_a_of_type_Int);
      if (localObject1 != null) {
        localObject1 = ((Bundle)localObject1).getString("AlertTitle");
      } else {
        localObject1 = null;
      }
      Object localObject2 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertText", 147, this.jdField_a_of_type_Int);
      Object localObject4;
      if (localObject2 != null) {
        localObject4 = ((Bundle)localObject2).getString("AlertText");
      } else {
        localObject4 = null;
      }
      localObject2 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertLeftBtnText", 147, this.jdField_a_of_type_Int);
      if (localObject2 != null) {
        localObject2 = ((Bundle)localObject2).getString("AlertLeftBtnText");
      } else {
        localObject2 = null;
      }
      Object localObject3 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertRightBtnText", 147, this.jdField_a_of_type_Int);
      if (localObject3 != null) {
        localObject3 = ((Bundle)localObject3).getString("AlertRightBtnText");
      } else {
        localObject3 = null;
      }
      Object localObject5 = localObject1;
      int i;
      if (localObject1 == null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity;
        if (this.jdField_a_of_type_Int == 1) {
          i = 2131718638;
        } else {
          i = 2131718642;
        }
        localObject5 = ((Face2FaceAddFriendActivity)localObject1).getString(i);
      }
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        i = this.jdField_a_of_type_Int;
        if (i == 1)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getString(2131718639);
        }
        else if (i == 2)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getString(2131718637);
        }
        else if (i == 3)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getString(2131718641);
        }
        else
        {
          localObject1 = localObject4;
          if (i == 4) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getString(2131718640);
          }
        }
      }
      if (localObject2 == null)
      {
        if (this.jdField_a_of_type_Int == 1)
        {
          this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
          localObject4 = localObject2;
        }
        else
        {
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getString(2131718634);
        }
      }
      else
      {
        localObject4 = localObject2;
        if (TextUtils.isEmpty(((String)localObject2).trim()))
        {
          this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
          localObject4 = localObject2;
        }
      }
      if (localObject3 == null)
      {
        if (this.jdField_a_of_type_Int == 1) {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getString(2131718633);
        } else {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getString(2131718632);
        }
      }
      else
      {
        localObject2 = localObject3;
        if (TextUtils.isEmpty(((String)localObject3).trim()))
        {
          this.b = null;
          localObject2 = localObject3;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle((String)localObject5);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage((CharSequence)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton((String)localObject4, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton((String)localObject2, this.b);
      if ((this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null) || (this.b == null)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131363829).setVisibility(8);
      }
    }
  }
  
  protected void onGetAutoInfo(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.f, paramString1)) {
      return;
    }
    if (paramBoolean) {
      if (!this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1)) {
        this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.jdField_a_of_type_AndroidWidgetEditText.setText(paramString2);
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    }
    catch (IndexOutOfBoundsException paramString2)
    {
      label72:
      Face2FaceAddFriendActivity localFace2FaceAddFriendActivity;
      break label72;
    }
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetAutoInfo | IndexOutOfBoundsException");
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString1))
    {
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity;
      paramString2.l = paramInt;
      paramString2 = paramString2.jdField_b_of_type_AndroidWidgetTextView;
      localFace2FaceAddFriendActivity = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity;
      paramString2.setText(localFace2FaceAddFriendActivity.a(localFace2FaceAddFriendActivity.l));
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.jdField_b_of_type_JavaUtilHashMap.put(paramString1, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.l));
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString1))
      {
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity;
        paramString2.l = 0;
        paramString2 = paramString2.jdField_b_of_type_AndroidWidgetTextView;
        localFace2FaceAddFriendActivity = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity;
        paramString2.setText(localFace2FaceAddFriendActivity.a(localFace2FaceAddFriendActivity.l));
        this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.jdField_b_of_type_JavaUtilHashMap.put(paramString1, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.l));
      }
    }
  }
  
  protected void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onQueryUinSafetyFlag isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("status=");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramInt != 0))
    {
      this.jdField_a_of_type_Int = paramInt;
      AntiFraudConfigFileUtil.a().a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.app, "SecWarningCfg");
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity, 230, "", "", this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.b);
        a();
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    Face2FaceAddFriendActivity.e(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity);
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    super.onUpdateAddFriend(paramBoolean1, paramBoolean2, paramBoolean3, paramString, paramBundle);
    int i = paramBundle.getInt("friend_setting");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateAddFriend请求加好友回调 isSuccess= ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("addSuccess=");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append("reqestUin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append("friendSetting");
      localStringBuilder.append(i);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramBoolean2)
    {
      paramString = paramBundle.getString("remark");
      paramBundle = paramBundle.getString("uin");
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.jdField_a_of_type_JavaUtilHashMap.put(paramBundle, paramString);
      if (i == 0)
      {
        paramString = Face2FaceAddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity).obtainMessage();
        paramString.what = 2;
        paramString.arg1 = 2;
        paramString.obj = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.f;
        Face2FaceAddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity).sendMessage(paramString);
        paramString = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity;
        Face2FaceAddFriendActivity.a(paramString, 2, paramString.f);
        return;
      }
      paramString = Face2FaceAddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity).obtainMessage();
      paramString.what = 2;
      paramString.arg1 = 4;
      paramString.obj = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.f;
      Face2FaceAddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity).sendMessage(paramString);
      paramString = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity;
      Face2FaceAddFriendActivity.a(paramString, 4, paramString.f);
      return;
    }
    paramBundle = paramBundle.getString("ErrorString");
    if (QLog.isColorLevel())
    {
      paramString = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("add friend response error and ErroString = ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
    }
    paramString = paramBundle;
    if (TextUtils.isEmpty(paramBundle)) {
      paramString = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getString(2131692139);
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity, 0, paramString, 0).b(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getTitleBarHeight());
  }
  
  protected void onUpdateAddFriendSetting(boolean paramBoolean, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("uin");
    int i = paramBundle.getInt("friend_setting");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str2 = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateAddFriendSetting请求加好友设置 isSuccess= ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("friendSetting=");
      localStringBuilder.append(i);
      QLog.d(str2, 2, localStringBuilder.toString());
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    byte b1 = (byte)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.l;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.f)) {
      return;
    }
    ((IFriendHandlerService)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.app.getRuntimeService(IFriendHandlerService.class)).requestAddFriend(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.f, null, i, b1, "", 3021, 0, true, null, true, str2, "");
    if (QLog.isColorLevel())
    {
      str2 = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("请求加好友");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.f);
      QLog.d(str2, 2, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.f.equals(str1)) {
      return;
    }
    if (paramBoolean)
    {
      paramBundle.getStringArrayList("user_question");
      paramBundle.getBoolean("contact_bothway");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.9
 * JD-Core Version:    0.7.0.1
 */