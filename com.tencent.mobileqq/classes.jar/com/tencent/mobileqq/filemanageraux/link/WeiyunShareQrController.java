package com.tencent.mobileqq.filemanageraux.link;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

final class WeiyunShareQrController
  implements Handler.Callback
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final View jdField_a_of_type_AndroidViewView;
  private final IShareRouter jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private volatile boolean jdField_a_of_type_Boolean;
  private final MqqHandler b;
  
  WeiyunShareQrController(IShareRouter paramIShareRouter, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter = paramIShareRouter;
    this.jdField_a_of_type_AndroidViewView = paramIShareRouter.getBaseActivity().getLayoutInflater().inflate(2131560816, paramViewGroup, false);
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.jdField_a_of_type_AndroidViewView.measure(i, i);
    TextView localTextView1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374662);
    TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374660);
    paramViewGroup = (AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374661);
    String str = paramIShareRouter.a();
    int j = paramIShareRouter.a();
    localTextView1.setText(FileManagerUtil.a(str, true, localTextView1.getMeasuredWidth(), localTextView1.getPaint(), 2));
    localTextView2.setText(FileUtil.a(paramIShareRouter.a()));
    paramViewGroup.setImageResource(FileManagerUtil.b(str));
    if ((j == 5) || (j == 0))
    {
      paramIShareRouter = paramIShareRouter.b();
      if (FileUtil.a(paramIShareRouter)) {
        if (j == 5) {
          paramViewGroup.setApkIconAsyncImage(paramIShareRouter);
        } else {
          paramViewGroup.setAsyncImage(paramIShareRouter);
        }
      }
    }
    paramViewGroup.setSupportMaskView(false);
    ((AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374642)).setSupportMaskView(false);
    this.jdField_a_of_type_AndroidViewView.measure(i, i);
    paramIShareRouter = this.jdField_a_of_type_AndroidViewView;
    paramIShareRouter.layout(0, 0, paramIShareRouter.getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.b = new MqqWeakReferenceHandler(ThreadManagerV2.getFileThreadLooper(), this, false);
  }
  
  /* Error */
  private Bitmap a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: getfield 42	com/tencent/mobileqq/filemanageraux/link/WeiyunShareQrController:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   10: ldc 119
    //   12: invokevirtual 59	android/view/View:findViewById	(I)Landroid/view/View;
    //   15: checkcast 65	com/tencent/mobileqq/filemanager/widget/AsyncImageView
    //   18: astore 4
    //   20: aload 4
    //   22: aload_1
    //   23: invokevirtual 155	com/tencent/mobileqq/filemanager/widget/AsyncImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   26: aload_0
    //   27: getfield 42	com/tencent/mobileqq/filemanageraux/link/WeiyunShareQrController:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   30: ldc 156
    //   32: invokevirtual 59	android/view/View:findViewById	(I)Landroid/view/View;
    //   35: checkcast 61	android/widget/TextView
    //   38: astore 5
    //   40: getstatic 162	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   43: astore 6
    //   45: aload_3
    //   46: invokestatic 168	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifeq +78 -> 127
    //   52: new 170	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   59: astore_1
    //   60: aload_1
    //   61: getstatic 162	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   64: ldc 172
    //   66: invokevirtual 176	com/tencent/common/app/BaseApplicationImpl:getString	(I)Ljava/lang/String;
    //   69: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_1
    //   74: ldc 182
    //   76: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: getstatic 162	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   83: astore_3
    //   84: iload_2
    //   85: iconst_1
    //   86: if_icmpne +9 -> 95
    //   89: ldc 183
    //   91: istore_2
    //   92: goto +17 -> 109
    //   95: iload_2
    //   96: iconst_2
    //   97: if_icmpne +9 -> 106
    //   100: ldc 184
    //   102: istore_2
    //   103: goto +6 -> 109
    //   106: ldc 185
    //   108: istore_2
    //   109: aload_1
    //   110: aload_3
    //   111: iload_2
    //   112: invokevirtual 176	com/tencent/common/app/BaseApplicationImpl:getString	(I)Ljava/lang/String;
    //   115: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_1
    //   120: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: astore_1
    //   124: goto +42 -> 166
    //   127: new 170	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   134: astore_1
    //   135: aload_1
    //   136: getstatic 162	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   139: ldc 189
    //   141: invokevirtual 176	com/tencent/common/app/BaseApplicationImpl:getString	(I)Ljava/lang/String;
    //   144: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_1
    //   149: ldc 182
    //   151: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_1
    //   156: aload_3
    //   157: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_1
    //   162: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: astore_1
    //   166: aload 5
    //   168: aload 6
    //   170: ldc 190
    //   172: iconst_1
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload_1
    //   179: aastore
    //   180: invokevirtual 193	com/tencent/common/app/BaseApplicationImpl:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   183: invokevirtual 87	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   186: aload_0
    //   187: getfield 42	com/tencent/mobileqq/filemanageraux/link/WeiyunShareQrController:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   190: invokevirtual 120	android/view/View:getMeasuredWidth	()I
    //   193: aload_0
    //   194: getfield 42	com/tencent/mobileqq/filemanageraux/link/WeiyunShareQrController:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   197: invokevirtual 123	android/view/View:getMeasuredHeight	()I
    //   200: getstatic 199	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   203: invokestatic 205	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   206: astore_1
    //   207: aload_0
    //   208: getfield 42	com/tencent/mobileqq/filemanageraux/link/WeiyunShareQrController:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   211: new 207	android/graphics/Canvas
    //   214: dup
    //   215: aload_1
    //   216: invokespecial 209	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   219: invokevirtual 213	android/view/View:draw	(Landroid/graphics/Canvas;)V
    //   222: aload 4
    //   224: aconst_null
    //   225: invokevirtual 217	com/tencent/mobileqq/filemanager/widget/AsyncImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   228: aload_1
    //   229: areturn
    //   230: astore_1
    //   231: goto +21 -> 252
    //   234: astore_1
    //   235: ldc 219
    //   237: iconst_2
    //   238: ldc 221
    //   240: aload_1
    //   241: invokestatic 227	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   244: aload 4
    //   246: aconst_null
    //   247: invokevirtual 217	com/tencent/mobileqq/filemanager/widget/AsyncImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   250: aconst_null
    //   251: areturn
    //   252: aload 4
    //   254: aconst_null
    //   255: invokevirtual 217	com/tencent/mobileqq/filemanager/widget/AsyncImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   258: aload_1
    //   259: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	WeiyunShareQrController
    //   0	260	1	paramBitmap	Bitmap
    //   0	260	2	paramInt	int
    //   0	260	3	paramString	String
    //   18	235	4	localAsyncImageView	AsyncImageView
    //   38	129	5	localTextView	TextView
    //   43	126	6	localBaseApplicationImpl	BaseApplicationImpl
    // Exception table:
    //   from	to	target	type
    //   186	222	230	finally
    //   235	244	230	finally
    //   186	222	234	java/lang/Throwable
  }
  
  private static String a(Bitmap paramBitmap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("qfile_qrcode_share_");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(".png");
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      paramBitmap = QRUtils.a(BaseApplicationImpl.sApplication, (String)localObject, paramBitmap);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      QLog.w("WeiyunShareQrController<FileAssistant>", 2, "saveTemp error", paramBitmap);
    }
    return "";
  }
  
  private void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, Bitmap paramBitmap, String paramString)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    int i = paramActionSheetItem.action;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.getBaseActivity();
    if (localObject != null)
    {
      if (((BaseActivity)localObject).isFinishing()) {
        return;
      }
      QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if (localQQProgressDialog != null) {
        localQQProgressDialog.dismiss();
      }
      if ("".equals(paramString))
      {
        LinkUtils.a(1, 2131696480, true);
        return;
      }
      if (paramString == null)
      {
        if (i == 39) {
          i = 2131716705;
        } else {
          i = 2131696479;
        }
        LinkUtils.a(1, i, true);
        return;
      }
      if (i != 2)
      {
        if (i != 3)
        {
          if ((i != 9) && (i != 10))
          {
            if (i != 39)
            {
              if (i != 72) {
                return;
              }
              paramBitmap = new Bundle();
              paramBitmap.putInt("key_req", 1);
              paramBitmap.putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
              paramBitmap.putString("key_direct_show_uin", paramActionSheetItem.uin);
              paramActionSheetItem = new Intent();
              paramActionSheetItem.putExtra("isFromShare", true);
              paramActionSheetItem.putExtra("forward_type", 1);
              paramActionSheetItem.putExtra("forward_filepath", paramString);
              paramActionSheetItem.putExtra("forward_thumb", paramString);
              paramActionSheetItem.putExtra("forward_urldrawable_big_url", paramString);
              paramActionSheetItem.putExtra("forward_extra", paramString);
              paramActionSheetItem.putExtras(paramBitmap);
              ForwardBaseOption.a((Activity)localObject, paramActionSheetItem, ForwardRecentTranslucentActivity.class, 1, -1, "");
              return;
            }
            paramActionSheetItem = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            paramBitmap = new StringBuilder();
            paramBitmap.append("file://");
            paramBitmap.append(paramString);
            paramActionSheetItem.setData(Uri.parse(paramBitmap.toString()));
            ((BaseActivity)localObject).sendBroadcast(paramActionSheetItem);
            LinkUtils.a(2, ((BaseActivity)localObject).getString(2131716707, new Object[] { paramString }), true);
            return;
          }
          paramActionSheetItem = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.c();
          localObject = WXShareHelper.a();
          if (i == 9) {
            i = 0;
          } else {
            i = 1;
          }
          ((WXShareHelper)localObject).a(paramString, paramBitmap, i, true, paramActionSheetItem);
          return;
        }
        paramActionSheetItem = QZoneHelper.UserInfo.getInstance();
        paramBitmap = ((BaseActivity)localObject).getAppInterface();
        paramActionSheetItem.qzone_uin = paramBitmap.getAccount();
        if ((paramBitmap instanceof VideoAppInterface)) {
          paramActionSheetItem.nickname = ((VideoAppInterface)paramBitmap).a(0, paramBitmap.getCurrentAccountUin(), null);
        } else {
          paramActionSheetItem.nickname = null;
        }
        QZoneHelper.forwardToPublishMood((Activity)localObject, paramActionSheetItem, paramString, ((BaseActivity)localObject).getString(2131692105), ((BaseActivity)localObject).getString(2131698257, new Object[] { "" }), 2);
        return;
      }
      paramActionSheetItem = new Intent();
      paramActionSheetItem.putExtra("isFromShare", true);
      paramActionSheetItem.putExtra("forward_type", 1);
      paramActionSheetItem.putExtra("forward_filepath", paramString);
      paramActionSheetItem.putExtra("forward_thumb", paramString);
      paramActionSheetItem.putExtra("forward_urldrawable_big_url", paramString);
      paramActionSheetItem.putExtra("forward_extra", paramString);
      ForwardBaseOption.a((Activity)localObject, paramActionSheetItem, 1, -1);
    }
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)paramArrayOfObject[0];
      Bitmap localBitmap = (Bitmap)paramArrayOfObject[1];
      if (((Boolean)paramArrayOfObject[2]).booleanValue()) {
        paramArrayOfObject = a(localBitmap);
      } else {
        paramArrayOfObject = b(localBitmap);
      }
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = new Object[] { localActionSheetItem, localBitmap, paramArrayOfObject };
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
    }
    throw new IllegalArgumentException("handleSaveBitmap: args are invalid");
  }
  
  /* Error */
  private static String b(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: aload_0
    //   10: ifnull +386 -> 396
    //   13: aload_0
    //   14: invokevirtual 456	android/graphics/Bitmap:isRecycled	()Z
    //   17: ifne +379 -> 396
    //   20: new 458	com/tencent/mm/vfs/VFSFile
    //   23: dup
    //   24: getstatic 463	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   27: invokespecial 464	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   30: astore 5
    //   32: aload 5
    //   34: invokevirtual 467	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
    //   37: pop
    //   38: aload 5
    //   40: invokevirtual 470	com/tencent/mm/vfs/VFSFile:canWrite	()Z
    //   43: ifeq +353 -> 396
    //   46: invokestatic 237	java/lang/System:currentTimeMillis	()J
    //   49: invokestatic 474	java/lang/Long:toString	(J)Ljava/lang/String;
    //   52: astore 5
    //   54: new 170	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   61: astore 7
    //   63: aload 7
    //   65: getstatic 463	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   68: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 7
    //   74: ldc_w 476
    //   77: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 7
    //   83: invokestatic 237	java/lang/System:currentTimeMillis	()J
    //   86: invokevirtual 240	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 7
    //   92: ldc_w 478
    //   95: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: new 458	com/tencent/mm/vfs/VFSFile
    //   102: dup
    //   103: aload 7
    //   105: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokespecial 464	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   111: astore 7
    //   113: iconst_2
    //   114: istore_1
    //   115: aload 7
    //   117: invokevirtual 481	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   120: ifeq +91 -> 211
    //   123: iload_1
    //   124: ldc_w 482
    //   127: if_icmpge +84 -> 211
    //   130: new 170	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   137: astore 7
    //   139: aload 7
    //   141: getstatic 463	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   144: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 7
    //   150: ldc_w 476
    //   153: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 7
    //   159: aload 5
    //   161: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 7
    //   167: ldc_w 484
    //   170: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 7
    //   176: iload_1
    //   177: invokevirtual 487	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 7
    //   183: ldc_w 489
    //   186: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: new 458	com/tencent/mm/vfs/VFSFile
    //   193: dup
    //   194: aload 7
    //   196: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokespecial 464	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   202: astore 7
    //   204: iload_1
    //   205: iconst_1
    //   206: iadd
    //   207: istore_1
    //   208: goto -93 -> 115
    //   211: iconst_0
    //   212: istore 4
    //   214: iconst_0
    //   215: istore_3
    //   216: new 491	java/io/BufferedOutputStream
    //   219: dup
    //   220: new 493	com/tencent/mm/vfs/VFSFileOutputStream
    //   223: dup
    //   224: aload 7
    //   226: invokespecial 496	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   229: invokespecial 499	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   232: astore 5
    //   234: aload 5
    //   236: astore 6
    //   238: aload_0
    //   239: getstatic 505	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   242: bipush 100
    //   244: aload 5
    //   246: invokevirtual 509	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   249: istore_2
    //   250: aload 5
    //   252: invokevirtual 512	java/io/BufferedOutputStream:close	()V
    //   255: aload 8
    //   257: astore_0
    //   258: goto +100 -> 358
    //   261: aload 8
    //   263: astore_0
    //   264: goto +94 -> 358
    //   267: astore_0
    //   268: goto +23 -> 291
    //   271: astore 6
    //   273: aload 5
    //   275: astore_0
    //   276: aload 6
    //   278: astore 5
    //   280: goto +50 -> 330
    //   283: astore_0
    //   284: goto +100 -> 384
    //   287: astore_0
    //   288: aconst_null
    //   289: astore 5
    //   291: aload 5
    //   293: astore 6
    //   295: ldc 219
    //   297: iconst_2
    //   298: ldc_w 514
    //   301: aload_0
    //   302: invokestatic 227	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   305: aload 8
    //   307: astore_0
    //   308: iload 4
    //   310: istore_2
    //   311: aload 5
    //   313: ifnull +45 -> 358
    //   316: iload_3
    //   317: istore_2
    //   318: goto -68 -> 250
    //   321: astore_0
    //   322: goto +62 -> 384
    //   325: astore 5
    //   327: aload 9
    //   329: astore_0
    //   330: aload_0
    //   331: astore 6
    //   333: ldc 219
    //   335: iconst_2
    //   336: ldc_w 514
    //   339: aload 5
    //   341: invokestatic 252	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   344: aload_0
    //   345: ifnull +7 -> 352
    //   348: aload_0
    //   349: invokevirtual 512	java/io/BufferedOutputStream:close	()V
    //   352: ldc 254
    //   354: astore_0
    //   355: iload 4
    //   357: istore_2
    //   358: iload_2
    //   359: ifne +19 -> 378
    //   362: aload 7
    //   364: invokevirtual 481	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   367: ifeq +11 -> 378
    //   370: aload 7
    //   372: invokevirtual 517	com/tencent/mm/vfs/VFSFile:delete	()Z
    //   375: pop
    //   376: aload_0
    //   377: areturn
    //   378: aload 7
    //   380: invokevirtual 520	com/tencent/mm/vfs/VFSFile:getAbsolutePath	()Ljava/lang/String;
    //   383: areturn
    //   384: aload 6
    //   386: ifnull +8 -> 394
    //   389: aload 6
    //   391: invokevirtual 512	java/io/BufferedOutputStream:close	()V
    //   394: aload_0
    //   395: athrow
    //   396: aconst_null
    //   397: areturn
    //   398: astore_0
    //   399: goto -138 -> 261
    //   402: astore_0
    //   403: goto -51 -> 352
    //   406: astore 5
    //   408: goto -14 -> 394
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	paramBitmap	Bitmap
    //   114	94	1	i	int
    //   249	110	2	bool1	boolean
    //   215	102	3	bool2	boolean
    //   212	144	4	bool3	boolean
    //   30	282	5	localObject1	Object
    //   325	15	5	localOutOfMemoryError1	OutOfMemoryError
    //   406	1	5	localThrowable	java.lang.Throwable
    //   7	230	6	localObject2	Object
    //   271	6	6	localOutOfMemoryError2	OutOfMemoryError
    //   293	97	6	localObject3	Object
    //   61	318	7	localObject4	Object
    //   4	302	8	localObject5	Object
    //   1	327	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   238	250	267	java/lang/Throwable
    //   238	250	271	java/lang/OutOfMemoryError
    //   216	234	283	finally
    //   333	344	283	finally
    //   216	234	287	java/lang/Throwable
    //   238	250	321	finally
    //   295	305	321	finally
    //   216	234	325	java/lang/OutOfMemoryError
    //   250	255	398	java/lang/Throwable
    //   348	352	402	java/lang/Throwable
    //   389	394	406	java/lang/Throwable
  }
  
  private void b()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null)
    {
      if (!localBitmap.isRecycled()) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  private void b(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
    {
      a((ShareActionSheetBuilder.ActionSheetItem)paramArrayOfObject[0], (Bitmap)paramArrayOfObject[1], (String)paramArrayOfObject[2]);
      return;
    }
    throw new IllegalArgumentException("handleShareRelay: args are invalid");
  }
  
  List<ShareActionSheetBuilder.ActionSheetItem> a(Context paramContext)
  {
    paramContext = new ArrayList();
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    return paramContext;
  }
  
  void a()
  {
    this.jdField_a_of_type_Boolean = true;
    b();
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.b.removeCallbacksAndMessages(null);
  }
  
  void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    int i = paramActionSheetItem.action;
    boolean bool = false;
    if ((i != 39) && (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.getBaseActivity())))
    {
      LinkUtils.a(0, 2131692183, false);
      if (QLog.isColorLevel()) {
        QLog.i("WeiyunShareQrController<FileAssistant>", 2, "toShare: net is not supported");
      }
      return;
    }
    if ((i == 2) || (i == 3) || (i == 9) || (i == 10) || (i == 72) || (i == 39))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.getBaseActivity());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694668);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      Message localMessage = new Message();
      localMessage.what = 1;
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (i != 39) {
        bool = true;
      }
      localMessage.obj = new Object[] { paramActionSheetItem, localBitmap, Boolean.valueOf(bool) };
      this.b.sendMessage(localMessage);
    }
  }
  
  boolean a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    paramBitmap = a(paramBitmap, paramInt, paramString);
    if (paramBitmap == null)
    {
      LinkUtils.a(1, BaseApplicationImpl.sApplication.getResources().getString(2131698251, new Object[] { Integer.valueOf(-2) }), true);
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxLinkIShareRouter.a(paramBitmap);
    if (paramBitmap != this.jdField_a_of_type_AndroidGraphicsBitmap) {
      b();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    return true;
  }
  
  List<ShareActionSheetBuilder.ActionSheetItem> b(Context paramContext)
  {
    paramContext = new ArrayList();
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
    return paramContext;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return true;
      }
      b((Object[])paramMessage.obj);
      return true;
    }
    a((Object[])paramMessage.obj);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.link.WeiyunShareQrController
 * JD-Core Version:    0.7.0.1
 */