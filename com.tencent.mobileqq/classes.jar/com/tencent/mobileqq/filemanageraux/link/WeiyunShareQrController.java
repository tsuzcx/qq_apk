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
  private final IShareRouter a;
  private final View b;
  private final MqqHandler c;
  private final MqqHandler d;
  private QQProgressDialog e;
  private Bitmap f;
  private volatile boolean g;
  
  WeiyunShareQrController(IShareRouter paramIShareRouter, ViewGroup paramViewGroup)
  {
    this.a = paramIShareRouter;
    this.b = paramIShareRouter.getBaseActivity().getLayoutInflater().inflate(2131627074, paramViewGroup, false);
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.b.measure(i, i);
    TextView localTextView1 = (TextView)this.b.findViewById(2131442843);
    TextView localTextView2 = (TextView)this.b.findViewById(2131442841);
    paramViewGroup = (AsyncImageView)this.b.findViewById(2131442842);
    String str = paramIShareRouter.d();
    int j = paramIShareRouter.f();
    localTextView1.setText(FileManagerUtil.a(str, true, localTextView1.getMeasuredWidth(), localTextView1.getPaint(), 2));
    localTextView2.setText(FileUtil.a(paramIShareRouter.e()));
    paramViewGroup.setImageResource(FileManagerUtil.i(str));
    if ((j == 5) || (j == 0))
    {
      paramIShareRouter = paramIShareRouter.g();
      if (FileUtil.b(paramIShareRouter)) {
        if (j == 5) {
          paramViewGroup.setApkIconAsyncImage(paramIShareRouter);
        } else {
          paramViewGroup.setAsyncImage(paramIShareRouter);
        }
      }
    }
    paramViewGroup.setSupportMaskView(false);
    ((AsyncImageView)this.b.findViewById(2131442819)).setSupportMaskView(false);
    this.b.measure(i, i);
    paramIShareRouter = this.b;
    paramIShareRouter.layout(0, 0, paramIShareRouter.getMeasuredWidth(), this.b.getMeasuredHeight());
    this.c = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.d = new MqqWeakReferenceHandler(ThreadManagerV2.getFileThreadLooper(), this, false);
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
    Object localObject = this.a.getBaseActivity();
    if (localObject != null)
    {
      if (((BaseActivity)localObject).isFinishing()) {
        return;
      }
      QQProgressDialog localQQProgressDialog = this.e;
      if (localQQProgressDialog != null) {
        localQQProgressDialog.dismiss();
      }
      if ("".equals(paramString))
      {
        LinkUtils.a(1, 2131894252, true);
        return;
      }
      if (paramString == null)
      {
        if (i == 39) {
          i = 2131914169;
        } else {
          i = 2131894251;
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
            LinkUtils.a(2, ((BaseActivity)localObject).getString(2131914171, new Object[] { paramString }), true);
            return;
          }
          paramActionSheetItem = this.a.i();
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
        QZoneHelper.forwardToPublishMood((Activity)localObject, paramActionSheetItem, paramString, ((BaseActivity)localObject).getString(2131889086), ((BaseActivity)localObject).getString(2131896158, new Object[] { "" }), 2);
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
      this.c.sendMessage(localMessage);
      return;
    }
    throw new IllegalArgumentException("handleSaveBitmap: args are invalid");
  }
  
  /* Error */
  private Bitmap b(Bitmap paramBitmap, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: getfield 47	com/tencent/mobileqq/filemanageraux/link/WeiyunShareQrController:b	Landroid/view/View;
    //   10: ldc 125
    //   12: invokevirtual 64	android/view/View:findViewById	(I)Landroid/view/View;
    //   15: checkcast 70	com/tencent/mobileqq/filemanager/widget/AsyncImageView
    //   18: astore 4
    //   20: aload 4
    //   22: aload_1
    //   23: invokevirtual 415	com/tencent/mobileqq/filemanager/widget/AsyncImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   26: aload_0
    //   27: getfield 47	com/tencent/mobileqq/filemanageraux/link/WeiyunShareQrController:b	Landroid/view/View;
    //   30: ldc_w 416
    //   33: invokevirtual 64	android/view/View:findViewById	(I)Landroid/view/View;
    //   36: checkcast 66	android/widget/TextView
    //   39: astore 5
    //   41: getstatic 185	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   44: astore 6
    //   46: aload_3
    //   47: invokestatic 422	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifeq +83 -> 133
    //   53: new 159	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   60: astore_1
    //   61: aload_1
    //   62: getstatic 185	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   65: ldc_w 423
    //   68: invokevirtual 424	com/tencent/common/app/BaseApplicationImpl:getString	(I)Ljava/lang/String;
    //   71: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_1
    //   76: ldc_w 426
    //   79: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: getstatic 185	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   86: astore_3
    //   87: iload_2
    //   88: iconst_1
    //   89: if_icmpne +10 -> 99
    //   92: ldc_w 427
    //   95: istore_2
    //   96: goto +19 -> 115
    //   99: iload_2
    //   100: iconst_2
    //   101: if_icmpne +10 -> 111
    //   104: ldc_w 428
    //   107: istore_2
    //   108: goto +7 -> 115
    //   111: ldc_w 429
    //   114: istore_2
    //   115: aload_1
    //   116: aload_3
    //   117: iload_2
    //   118: invokevirtual 424	com/tencent/common/app/BaseApplicationImpl:getString	(I)Ljava/lang/String;
    //   121: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_1
    //   126: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: astore_1
    //   130: goto +44 -> 174
    //   133: new 159	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   140: astore_1
    //   141: aload_1
    //   142: getstatic 185	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   145: ldc_w 430
    //   148: invokevirtual 424	com/tencent/common/app/BaseApplicationImpl:getString	(I)Ljava/lang/String;
    //   151: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_1
    //   156: ldc_w 426
    //   159: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_1
    //   164: aload_3
    //   165: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_1
    //   170: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: astore_1
    //   174: aload 5
    //   176: aload 6
    //   178: ldc_w 366
    //   181: iconst_1
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload_1
    //   188: aastore
    //   189: invokevirtual 431	com/tencent/common/app/BaseApplicationImpl:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   192: invokevirtual 92	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   195: aload_0
    //   196: getfield 47	com/tencent/mobileqq/filemanageraux/link/WeiyunShareQrController:b	Landroid/view/View;
    //   199: invokevirtual 126	android/view/View:getMeasuredWidth	()I
    //   202: aload_0
    //   203: getfield 47	com/tencent/mobileqq/filemanageraux/link/WeiyunShareQrController:b	Landroid/view/View;
    //   206: invokevirtual 129	android/view/View:getMeasuredHeight	()I
    //   209: getstatic 437	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   212: invokestatic 441	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   215: astore_1
    //   216: aload_0
    //   217: getfield 47	com/tencent/mobileqq/filemanageraux/link/WeiyunShareQrController:b	Landroid/view/View;
    //   220: new 443	android/graphics/Canvas
    //   223: dup
    //   224: aload_1
    //   225: invokespecial 445	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   228: invokevirtual 449	android/view/View:draw	(Landroid/graphics/Canvas;)V
    //   231: aload 4
    //   233: aconst_null
    //   234: invokevirtual 453	com/tencent/mobileqq/filemanager/widget/AsyncImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   237: aload_1
    //   238: areturn
    //   239: astore_1
    //   240: goto +22 -> 262
    //   243: astore_1
    //   244: ldc 192
    //   246: iconst_2
    //   247: ldc_w 455
    //   250: aload_1
    //   251: invokestatic 457	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   254: aload 4
    //   256: aconst_null
    //   257: invokevirtual 453	com/tencent/mobileqq/filemanager/widget/AsyncImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   260: aconst_null
    //   261: areturn
    //   262: aload 4
    //   264: aconst_null
    //   265: invokevirtual 453	com/tencent/mobileqq/filemanager/widget/AsyncImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   268: aload_1
    //   269: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	WeiyunShareQrController
    //   0	270	1	paramBitmap	Bitmap
    //   0	270	2	paramInt	int
    //   0	270	3	paramString	String
    //   18	245	4	localAsyncImageView	AsyncImageView
    //   39	136	5	localTextView	TextView
    //   44	133	6	localBaseApplicationImpl	BaseApplicationImpl
    // Exception table:
    //   from	to	target	type
    //   195	231	239	finally
    //   244	254	239	finally
    //   195	231	243	java/lang/Throwable
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
    //   14: invokevirtual 460	android/graphics/Bitmap:isRecycled	()Z
    //   17: ifne +379 -> 396
    //   20: new 462	com/tencent/mm/vfs/VFSFile
    //   23: dup
    //   24: getstatic 467	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   27: invokespecial 468	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   30: astore 5
    //   32: aload 5
    //   34: invokevirtual 471	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
    //   37: pop
    //   38: aload 5
    //   40: invokevirtual 474	com/tencent/mm/vfs/VFSFile:canWrite	()Z
    //   43: ifeq +353 -> 396
    //   46: invokestatic 171	java/lang/System:currentTimeMillis	()J
    //   49: invokestatic 478	java/lang/Long:toString	(J)Ljava/lang/String;
    //   52: astore 5
    //   54: new 159	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   61: astore 7
    //   63: aload 7
    //   65: getstatic 467	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   68: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 7
    //   74: ldc_w 480
    //   77: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 7
    //   83: invokestatic 171	java/lang/System:currentTimeMillis	()J
    //   86: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 7
    //   92: ldc_w 482
    //   95: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: new 462	com/tencent/mm/vfs/VFSFile
    //   102: dup
    //   103: aload 7
    //   105: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokespecial 468	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   111: astore 7
    //   113: iconst_2
    //   114: istore_1
    //   115: aload 7
    //   117: invokevirtual 485	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   120: ifeq +91 -> 211
    //   123: iload_1
    //   124: ldc_w 486
    //   127: if_icmpge +84 -> 211
    //   130: new 159	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   137: astore 7
    //   139: aload 7
    //   141: getstatic 467	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   144: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 7
    //   150: ldc_w 480
    //   153: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 7
    //   159: aload 5
    //   161: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 7
    //   167: ldc_w 488
    //   170: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 7
    //   176: iload_1
    //   177: invokevirtual 491	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 7
    //   183: ldc_w 493
    //   186: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: new 462	com/tencent/mm/vfs/VFSFile
    //   193: dup
    //   194: aload 7
    //   196: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokespecial 468	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
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
    //   216: new 495	java/io/BufferedOutputStream
    //   219: dup
    //   220: new 497	com/tencent/mm/vfs/VFSFileOutputStream
    //   223: dup
    //   224: aload 7
    //   226: invokespecial 500	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   229: invokespecial 503	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   232: astore 5
    //   234: aload 5
    //   236: astore 6
    //   238: aload_0
    //   239: getstatic 509	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   242: bipush 100
    //   244: aload 5
    //   246: invokevirtual 513	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   249: istore_2
    //   250: aload 5
    //   252: invokevirtual 516	java/io/BufferedOutputStream:close	()V
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
    //   295: ldc 192
    //   297: iconst_2
    //   298: ldc_w 518
    //   301: aload_0
    //   302: invokestatic 457	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   333: ldc 192
    //   335: iconst_2
    //   336: ldc_w 518
    //   339: aload 5
    //   341: invokestatic 200	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   344: aload_0
    //   345: ifnull +7 -> 352
    //   348: aload_0
    //   349: invokevirtual 516	java/io/BufferedOutputStream:close	()V
    //   352: ldc 202
    //   354: astore_0
    //   355: iload 4
    //   357: istore_2
    //   358: iload_2
    //   359: ifne +19 -> 378
    //   362: aload 7
    //   364: invokevirtual 485	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   367: ifeq +11 -> 378
    //   370: aload 7
    //   372: invokevirtual 521	com/tencent/mm/vfs/VFSFile:delete	()Z
    //   375: pop
    //   376: aload_0
    //   377: areturn
    //   378: aload 7
    //   380: invokevirtual 524	com/tencent/mm/vfs/VFSFile:getAbsolutePath	()Ljava/lang/String;
    //   383: areturn
    //   384: aload 6
    //   386: ifnull +8 -> 394
    //   389: aload 6
    //   391: invokevirtual 516	java/io/BufferedOutputStream:close	()V
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
    Bitmap localBitmap = this.f;
    if (localBitmap != null)
    {
      if (!localBitmap.isRecycled()) {
        this.f.recycle();
      }
      this.f = null;
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
    this.g = true;
    b();
    QQProgressDialog localQQProgressDialog = this.e;
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.dismiss();
      this.e = null;
    }
    this.c.removeCallbacksAndMessages(null);
    this.d.removeCallbacksAndMessages(null);
  }
  
  void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    int i = paramActionSheetItem.action;
    boolean bool = false;
    if ((i != 39) && (!NetworkUtil.isNetSupport(this.a.getBaseActivity())))
    {
      LinkUtils.a(0, 2131889169, false);
      if (QLog.isColorLevel()) {
        QLog.i("WeiyunShareQrController<FileAssistant>", 2, "toShare: net is not supported");
      }
      return;
    }
    if ((i == 2) || (i == 3) || (i == 9) || (i == 10) || (i == 72) || (i == 39))
    {
      if (this.e == null)
      {
        this.e = new QQProgressDialog(this.a.getBaseActivity());
        this.e.c(2131892360);
      }
      if (!this.e.isShowing()) {
        this.e.show();
      }
      Message localMessage = new Message();
      localMessage.what = 1;
      Bitmap localBitmap = this.f;
      if (i != 39) {
        bool = true;
      }
      localMessage.obj = new Object[] { paramActionSheetItem, localBitmap, Boolean.valueOf(bool) };
      this.d.sendMessage(localMessage);
    }
  }
  
  boolean a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    paramBitmap = b(paramBitmap, paramInt, paramString);
    if (paramBitmap == null)
    {
      LinkUtils.a(1, BaseApplicationImpl.sApplication.getResources().getString(2131896152, new Object[] { Integer.valueOf(-2) }), true);
      return false;
    }
    this.a.a(paramBitmap);
    if (paramBitmap != this.f) {
      b();
    }
    this.f = paramBitmap;
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
    if (this.g) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.link.WeiyunShareQrController
 * JD-Core Version:    0.7.0.1
 */