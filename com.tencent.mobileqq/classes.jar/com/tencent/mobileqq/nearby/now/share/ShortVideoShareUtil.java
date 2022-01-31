package com.tencent.mobileqq.nearby.now.share;

import aewt;
import aewu;
import aewv;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.List;

public class ShortVideoShareUtil
{
  static URLDrawable a;
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    Bitmap localBitmap = Bitmap.createBitmap(120, 120, Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!TextUtils.isEmpty(paramString5))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseAutoScaleParams = false;
      if (a != null) {
        a.cancelDownload();
      }
      a = URLDrawable.getDrawable(paramString5, localURLDrawableOptions);
      paramBaseActivity = (QQAppInterface)paramBaseActivity.getAppRuntime();
      if (a.getStatus() == 1)
      {
        SLog.c("ShortVideoShareUtil", "URLDrawable's status is SUCCESSED.");
        b(paramBaseActivity, paramString1, paramString2, paramString3, paramString4, a(a));
      }
    }
    else
    {
      return;
    }
    if (a.getStatus() == 2)
    {
      b(paramBaseActivity, paramString1, paramString2, paramString3, paramString4, null);
      a.downloadImediatly();
      return;
    }
    SLog.c("ShortVideoShareUtil", "start load URLDrawable.");
    a.setURLDrawableListener(new aewu(paramBaseActivity, paramString1, paramString2, paramString3, paramString4));
    a.downloadImediatly();
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    paramString1 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(1).a(paramString2).a("web", paramString4, null, null, null).a();
    paramString4 = StructMsgElementFactory.a(2);
    paramString4.a(paramString5, paramString2, paramString3, 0);
    paramString1.addItem(paramString4);
    paramString2 = new Intent();
    paramString2.putExtra("forward_type", -3);
    paramString2.putExtra("stuctmsg_bytes", paramString1.getBytes());
    ForwardBaseOption.a(paramBaseActivity, paramString2, 123);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, URLDrawable paramURLDrawable, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    paramQQAppInterface = new ShareActionSheetBuilder(paramBaseActivity);
    paramQQAppInterface.a(paramBaseActivity.getString(2131433100));
    paramQQAppInterface.a(a(paramBaseActivity));
    paramQQAppInterface.a(paramOnDismissListener);
    paramQQAppInterface.a(new aewt(paramQQAppInterface, paramBaseActivity, paramString3, paramString1, paramString4, paramString2, paramString5, paramString6));
    try
    {
      paramQQAppInterface.a();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + paramQQAppInterface);
    }
  }
  
  public static List[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430108);
    localActionSheetItem.jdField_b_of_type_Int = 2130838336;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.c = 2;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430114);
    localActionSheetItem.jdField_b_of_type_Int = 2130838337;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.c = 3;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430126);
    localActionSheetItem.jdField_b_of_type_Int = 2130838340;
    localActionSheetItem.c = 9;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430127);
    localActionSheetItem.jdField_b_of_type_Int = 2130838334;
    localActionSheetItem.c = 10;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public static void b(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    String str = String.valueOf(System.currentTimeMillis());
    if (!TextUtils.isEmpty(paramString5))
    {
      paramString1 = URLDrawable.URLDrawableOptions.obtain();
      paramString1.mUseAutoScaleParams = false;
      if (a != null) {
        a.cancelDownload();
      }
      a = URLDrawable.getDrawable(paramString5, paramString1);
      paramString5 = (QQAppInterface)paramBaseActivity.getAppRuntime();
      if (a.getStatus() == 1)
      {
        SLog.c("ShortVideoShareUtil", "URLDrawable's status is SUCCESSED.");
        paramString1 = a(a);
        paramBaseActivity = paramString1;
        if (paramString1 == null) {
          paramBaseActivity = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130842645);
        }
        WXShareHelper.a().a(str, paramString2, paramBaseActivity, paramString3, paramString4);
        new NowVideoReporter().h("video").i("playpage_fw_suc").a().a(paramString5);
      }
    }
    else
    {
      return;
    }
    if (a.getStatus() == 2)
    {
      paramString1 = a(a);
      paramBaseActivity = paramString1;
      if (paramString1 == null) {
        paramBaseActivity = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130842645);
      }
      WXShareHelper.a().a(str, paramString2, paramBaseActivity, paramString3, paramString4);
      a.downloadImediatly();
      new NowVideoReporter().h("video").i("playpage_fw_suc").a().a(paramString5);
      return;
    }
    SLog.c("ShortVideoShareUtil", "start load URLDrawable.");
    a.setURLDrawableListener(new aewv(str, paramString2, paramString3, paramString4, paramString5));
    a.startDownload();
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, Bitmap paramBitmap)
  {
    long l = System.currentTimeMillis();
    if (paramBitmap == null) {}
    for (paramString1 = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130842645);; paramString1 = paramBitmap)
    {
      WXShareHelper.a().b(String.valueOf(l), paramString2, paramString1, paramString3, paramString4);
      new NowVideoReporter().h("video").i("playpage_fw_suc").a().a(paramQQAppInterface);
      return;
    }
  }
  
  private static void d(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = (QQAppInterface)paramBaseActivity.getAppRuntime();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString5);
    paramString5 = new Bundle();
    paramString5.putString("title", paramString2);
    paramString5.putString("desc", paramString3);
    paramString5.putString("summary", paramString3);
    paramString5.putString("detail_url", paramString4);
    paramString5.putString("url", paramString4);
    paramString5.putStringArrayList("image_url", localArrayList);
    paramString5.putString("targetUrl", paramString4);
    paramString5.putInt("cflag", 1);
    QZoneShareManager.a(paramString1, paramBaseActivity, paramString5, null);
    new NowVideoReporter().h("video").i("playpage_fw_suc").a().a(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil
 * JD-Core Version:    0.7.0.1
 */