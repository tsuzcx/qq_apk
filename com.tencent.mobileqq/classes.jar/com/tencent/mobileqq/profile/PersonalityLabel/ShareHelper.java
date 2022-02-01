package com.tencent.mobileqq.profile.PersonalityLabel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.widget.AdapterView.OnItemClickListener;
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
  public static String a = "https://ti.qq.com/specialtag/share.html?id=%s";
  Activity jdField_a_of_type_AndroidAppActivity;
  Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ShareHelper.OnUseResListener jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$OnUseResListener;
  ShareActionSheetBuilder jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = null;
  
  public ShareHelper(Context paramContext, QQAppInterface paramQQAppInterface, Activity paramActivity, ShareHelper.OnUseResListener paramOnUseResListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$OnUseResListener = paramOnUseResListener;
  }
  
  @Nullable
  private String a()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("temp_qrcode_share_");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject).append(".png");
      localObject = ((StringBuilder)localObject).toString();
      localObject = QRUtils.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject, this.jdField_a_of_type_AndroidGraphicsBitmap);
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShareHelper", 2, localOutOfMemoryError.getMessage());
      }
    }
    return null;
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696399);
    localActionSheetItem.icon = 2130839067;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696413);
    localActionSheetItem.icon = 2130839068;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696420);
    localActionSheetItem.icon = 2130839071;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696402);
    localActionSheetItem.icon = 2130839065;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      localObject = new ShareHelper.1(this);
      paramOnDismissListener = new ShareHelper.2(this, paramOnDismissListener);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder((Activity)this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131719029));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a(this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener((AdapterView.OnItemClickListener)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(paramOnDismissListener);
    }
    try
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.getActionSheet().isShowing())
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
        return;
      }
    }
    catch (Exception paramOnDismissListener)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("actionSheet.show exception=");
        ((StringBuilder)localObject).append(paramOnDismissListener);
        QLog.d("ShareActionSheet", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper
 * JD-Core Version:    0.7.0.1
 */