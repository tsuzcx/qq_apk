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
  ShareActionSheetBuilder b = null;
  Context c;
  QQAppInterface d;
  Activity e;
  Bitmap f;
  ShareHelper.OnUseResListener g;
  
  public ShareHelper(Context paramContext, QQAppInterface paramQQAppInterface, Activity paramActivity, ShareHelper.OnUseResListener paramOnUseResListener)
  {
    this.c = paramContext;
    this.d = paramQQAppInterface;
    this.e = paramActivity;
    this.g = paramOnUseResListener;
  }
  
  @Nullable
  private String a()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("temp_qrcode_share_");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      ((StringBuilder)localObject).append(this.d.getCurrentAccountUin());
      ((StringBuilder)localObject).append(".png");
      localObject = ((StringBuilder)localObject).toString();
      localObject = QRUtils.a(this.e, (String)localObject, this.f);
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
    localActionSheetItem.label = paramContext.getString(2131894171);
    localActionSheetItem.icon = 2130839221;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894185);
    localActionSheetItem.icon = 2130839222;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894192);
    localActionSheetItem.icon = 2130839225;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894174);
    localActionSheetItem.icon = 2130839219;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Object localObject;
    if (this.b == null)
    {
      localObject = new ShareHelper.1(this);
      paramOnDismissListener = new ShareHelper.2(this, paramOnDismissListener);
      this.b = new ShareActionSheetBuilder((Activity)this.c);
      this.b.setActionSheetTitle(this.c.getString(2131916565));
      this.b.setActionSheetItems(a(this.c));
      this.b.setItemClickListener((AdapterView.OnItemClickListener)localObject);
      this.b.setOnDismissListener(paramOnDismissListener);
    }
    try
    {
      if (!this.b.getActionSheet().isShowing())
      {
        this.b.show();
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
    this.f = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper
 * JD-Core Version:    0.7.0.1
 */