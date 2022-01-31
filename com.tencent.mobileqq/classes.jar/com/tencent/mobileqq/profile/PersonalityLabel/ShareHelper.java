package com.tencent.mobileqq.profile.PersonalityLabel;

import agas;
import agaz;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.List;

public class ShareHelper
{
  public static String a;
  public Activity a;
  Context a;
  public Bitmap a;
  public QQAppInterface a;
  public ShareHelper.OnUseResListener a;
  public ShareActionSheetBuilder a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://ti.qq.com/specialtag/share.html?id=%s";
  }
  
  public ShareHelper(Context paramContext, QQAppInterface paramQQAppInterface, Activity paramActivity, ShareHelper.OnUseResListener paramOnUseResListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$OnUseResListener = paramOnUseResListener;
  }
  
  @Nullable
  private String a()
  {
    Object localObject = null;
    try
    {
      String str = "temp_qrcode_share_" + System.currentTimeMillis() + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + ".png";
      str = QRUtils.a(this.jdField_a_of_type_AndroidAppActivity, str, this.jdField_a_of_type_AndroidGraphicsBitmap);
      localObject = str;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("ShareHelper", 2, localOutOfMemoryError.getMessage());
    }
    return localObject;
    return null;
  }
  
  private List[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430091);
    localActionSheetItem.jdField_b_of_type_Int = 2130838332;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.c = 2;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430097);
    localActionSheetItem.jdField_b_of_type_Int = 2130838333;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.c = 3;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430109);
    localActionSheetItem.jdField_b_of_type_Int = 2130838336;
    localActionSheetItem.c = 9;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430110);
    localActionSheetItem.jdField_b_of_type_Int = 2130838330;
    localActionSheetItem.c = 10;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      agas localagas = new agas(this);
      paramOnDismissListener = new agaz(this, paramOnDismissListener);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder((Activity)this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(this.jdField_a_of_type_AndroidContentContext.getString(2131433083));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(a(this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(localagas);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(paramOnDismissListener);
    }
    try
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a().isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a();
      }
      return;
    }
    catch (Exception paramOnDismissListener)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + paramOnDismissListener);
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper
 * JD-Core Version:    0.7.0.1
 */