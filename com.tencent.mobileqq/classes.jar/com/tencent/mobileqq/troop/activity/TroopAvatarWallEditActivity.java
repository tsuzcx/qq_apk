package com.tencent.mobileqq.troop.activity;

import aihi;
import aihn;
import aiho;
import aihp;
import aihr;
import aihs;
import aiht;
import aihu;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.logic.TroopAvatarWallEditCtrl;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troop.widget.TroopAvatarWallGalleryAdapter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Gallery;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopAvatarWallEditActivity
  extends BaseActivity
  implements View.OnClickListener
{
  protected float a;
  public int a;
  protected long a;
  protected View a;
  protected Button a;
  protected ImageButton a;
  protected ImageView a;
  protected RelativeLayout a;
  public TroopAvatarWallEditCtrl a;
  public TroopAvatarWallGalleryAdapter a;
  public CookieManager a;
  public Gallery a;
  public String a;
  public List a;
  public boolean a;
  protected int b;
  public String b;
  public boolean b;
  protected int c;
  public String c;
  public boolean c;
  protected boolean d;
  
  public TroopAvatarWallEditActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl = new TroopAvatarWallEditCtrl();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetGallery == null)
    {
      QQToast.a(this, getString(2131435531), 0).a();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
    if (localObject == null)
    {
      QQToast.a(this, getString(2131435531), 0).a();
      return;
    }
    localObject = ((ImageView)((View)localObject).findViewById(2131361846)).getDrawable();
    if ((localObject == null) || (!(localObject instanceof URLDrawable)))
    {
      QQToast.a(this, getString(2131435531), 0).a();
      return;
    }
    localObject = (URLDrawable)localObject;
    if (((URLDrawable)localObject).getStatus() != 1)
    {
      QQToast.a(this, getString(2131435531), 0).a();
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    if (this.jdField_c_of_type_Boolean)
    {
      localActionSheet.a(2131435854, 1);
      localActionSheet.a(2131435860, 1);
      if (!getIntent().getBooleanExtra("from_photo_wall", false)) {
        ThreadManager.executeOnFileThread(new aihp(this, (URLDrawable)localObject, localActionSheet));
      }
    }
    localActionSheet.c(2131432998);
    localActionSheet.a(new aihr(this, localActionSheet, (URLDrawable)localObject));
    localActionSheet.show();
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_save", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    }
    if (paramURLDrawable.getStatus() != 1) {}
    String str;
    for (;;)
    {
      return;
      new File(AppConstants.aP).mkdirs();
      str = AppConstants.aP + this.jdField_a_of_type_JavaLangString + Utils.Crc64String(paramURLDrawable.getURL().toString());
      File localFile = new File(str);
      if (!localFile.exists()) {
        try
        {
          if (localFile.createNewFile())
          {
            b(paramURLDrawable, localFile.getPath());
            return;
          }
        }
        catch (IOException paramURLDrawable)
        {
          QQToast.a(this, getString(2131434566), 0).a();
          return;
        }
      }
    }
    DialogUtil.a(this, 230).setTitle(getString(2131434569)).setMessage(getString(2131434571)).setPositiveButton(getString(2131434570), new aiht(this, paramURLDrawable, str)).setNegativeButton(getString(2131432995), new aihs(this)).show();
  }
  
  private boolean a(AvatarWallAdapter.AvatarInfo paramAvatarInfo)
  {
    return (!paramAvatarInfo.jdField_a_of_type_Boolean) && (!paramAvatarInfo.jdField_b_of_type_Boolean) && (!TextUtils.equals(AvatarWallAdapter.AvatarInfo.jdField_a_of_type_JavaLangString, paramAvatarInfo.c)) && (!TextUtils.equals(paramAvatarInfo.d, "PLUS"));
  }
  
  /* Error */
  private boolean a(File paramFile)
  {
    // Byte code:
    //   0: iconst_2
    //   1: iconst_0
    //   2: ldc_w 307
    //   5: ldc_w 309
    //   8: invokestatic 314	com/tencent/qbar/QbarNativeImpl:a	(IILjava/lang/String;Ljava/lang/String;)I
    //   11: pop
    //   12: iconst_2
    //   13: newarray int
    //   15: astore 5
    //   17: aload 5
    //   19: iconst_0
    //   20: iconst_2
    //   21: iastore
    //   22: aload 5
    //   24: iconst_1
    //   25: iconst_0
    //   26: iastore
    //   27: aload 5
    //   29: aload 5
    //   31: arraylength
    //   32: invokestatic 317	com/tencent/qbar/QbarNativeImpl:a	([II)I
    //   35: pop
    //   36: new 193	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 319
    //   46: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 322	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   53: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 328	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   62: astore_1
    //   63: iconst_m1
    //   64: istore_3
    //   65: aload_0
    //   66: invokevirtual 332	com/tencent/mobileqq/troop/activity/TroopAvatarWallEditActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   69: astore 7
    //   71: new 334	android/graphics/BitmapFactory$Options
    //   74: dup
    //   75: invokespecial 335	android/graphics/BitmapFactory$Options:<init>	()V
    //   78: astore 6
    //   80: aload 6
    //   82: iconst_1
    //   83: putfield 338	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   86: aload 7
    //   88: aload_1
    //   89: invokevirtual 344	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   92: astore 5
    //   94: aload 5
    //   96: aconst_null
    //   97: aload 6
    //   99: invokestatic 350	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   102: pop
    //   103: aload 5
    //   105: invokevirtual 355	java/io/InputStream:close	()V
    //   108: aload 6
    //   110: getfield 358	android/graphics/BitmapFactory$Options:outWidth	I
    //   113: istore_2
    //   114: aload 6
    //   116: getfield 361	android/graphics/BitmapFactory$Options:outHeight	I
    //   119: istore 4
    //   121: aload 6
    //   123: iconst_0
    //   124: putfield 338	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   127: iload_2
    //   128: iload 4
    //   130: imul
    //   131: ldc_w 362
    //   134: if_icmple +160 -> 294
    //   137: aload 6
    //   139: iload_2
    //   140: iload 4
    //   142: imul
    //   143: i2d
    //   144: invokestatic 368	java/lang/Math:sqrt	(D)D
    //   147: ldc2_w 369
    //   150: ddiv
    //   151: invokestatic 373	java/lang/Math:ceil	(D)D
    //   154: d2i
    //   155: putfield 376	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   158: aload 7
    //   160: aload_1
    //   161: invokevirtual 344	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   164: astore_1
    //   165: aload_1
    //   166: aconst_null
    //   167: aload 6
    //   169: invokestatic 350	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   172: astore 6
    //   174: aload_1
    //   175: invokevirtual 355	java/io/InputStream:close	()V
    //   178: aload 6
    //   180: invokevirtual 381	android/graphics/Bitmap:getWidth	()I
    //   183: istore_2
    //   184: aload 6
    //   186: invokevirtual 384	android/graphics/Bitmap:getHeight	()I
    //   189: istore 4
    //   191: iload_2
    //   192: iload 4
    //   194: imul
    //   195: newarray int
    //   197: astore 5
    //   199: aload 6
    //   201: aload 5
    //   203: iconst_0
    //   204: iload_2
    //   205: iconst_0
    //   206: iconst_0
    //   207: iload_2
    //   208: iload 4
    //   210: invokevirtual 388	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   213: aload 6
    //   215: invokevirtual 391	android/graphics/Bitmap:recycle	()V
    //   218: iload_2
    //   219: iload 4
    //   221: imul
    //   222: newarray byte
    //   224: astore 6
    //   226: aload 5
    //   228: aload 6
    //   230: iload_2
    //   231: iload 4
    //   233: invokestatic 396	com/tencent/imageboost/ImgProcessScan:a	([I[BII)I
    //   236: pop
    //   237: aload 6
    //   239: iload_2
    //   240: iload 4
    //   242: iconst_0
    //   243: invokestatic 399	com/tencent/qbar/QbarNativeImpl:a	([BIII)I
    //   246: istore_2
    //   247: invokestatic 401	com/tencent/qbar/QbarNativeImpl:a	()I
    //   250: pop
    //   251: iload_2
    //   252: iconst_1
    //   253: if_icmpne +138 -> 391
    //   256: invokestatic 406	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   259: ifeq +13 -> 272
    //   262: ldc_w 408
    //   265: iconst_2
    //   266: ldc_w 410
    //   269: invokestatic 413	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: iconst_1
    //   273: ireturn
    //   274: astore_1
    //   275: invokestatic 406	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq +14 -> 292
    //   281: ldc_w 408
    //   284: iconst_2
    //   285: aload_1
    //   286: invokevirtual 414	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   289: invokestatic 417	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: iconst_0
    //   293: ireturn
    //   294: aload 6
    //   296: iconst_1
    //   297: putfield 376	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   300: goto -142 -> 158
    //   303: astore_1
    //   304: iload_3
    //   305: istore_2
    //   306: invokestatic 406	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq -62 -> 247
    //   312: ldc_w 408
    //   315: iconst_2
    //   316: aload_1
    //   317: invokevirtual 418	java/io/IOException:toString	()Ljava/lang/String;
    //   320: invokestatic 417	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: iload_3
    //   324: istore_2
    //   325: goto -78 -> 247
    //   328: astore_1
    //   329: aload 5
    //   331: astore_1
    //   332: aload_1
    //   333: invokevirtual 355	java/io/InputStream:close	()V
    //   336: iconst_m1
    //   337: istore_2
    //   338: goto -91 -> 247
    //   341: astore_1
    //   342: iload_3
    //   343: istore_2
    //   344: invokestatic 406	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq -100 -> 247
    //   350: ldc_w 408
    //   353: iconst_2
    //   354: aload_1
    //   355: invokevirtual 419	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   358: invokestatic 417	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: iload_3
    //   362: istore_2
    //   363: goto -116 -> 247
    //   366: astore_1
    //   367: iload_3
    //   368: istore_2
    //   369: invokestatic 406	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   372: ifeq -125 -> 247
    //   375: ldc_w 408
    //   378: iconst_2
    //   379: aload_1
    //   380: invokevirtual 414	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   383: invokestatic 417	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: iload_3
    //   387: istore_2
    //   388: goto -141 -> 247
    //   391: invokestatic 406	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +13 -> 407
    //   397: ldc_w 408
    //   400: iconst_2
    //   401: ldc_w 421
    //   404: invokestatic 413	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   407: iconst_0
    //   408: ireturn
    //   409: astore 5
    //   411: goto -79 -> 332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	414	0	this	TroopAvatarWallEditActivity
    //   0	414	1	paramFile	File
    //   113	275	2	i	int
    //   64	323	3	j	int
    //   119	122	4	k	int
    //   15	315	5	localObject1	Object
    //   409	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   78	217	6	localObject2	Object
    //   69	90	7	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   0	17	274	java/lang/UnsatisfiedLinkError
    //   27	36	274	java/lang/UnsatisfiedLinkError
    //   65	127	303	java/io/IOException
    //   137	158	303	java/io/IOException
    //   158	165	303	java/io/IOException
    //   165	247	303	java/io/IOException
    //   294	300	303	java/io/IOException
    //   332	336	303	java/io/IOException
    //   158	165	328	java/lang/OutOfMemoryError
    //   65	127	341	java/lang/RuntimeException
    //   137	158	341	java/lang/RuntimeException
    //   158	165	341	java/lang/RuntimeException
    //   165	247	341	java/lang/RuntimeException
    //   294	300	341	java/lang/RuntimeException
    //   332	336	341	java/lang/RuntimeException
    //   65	127	366	java/lang/UnsatisfiedLinkError
    //   137	158	366	java/lang/UnsatisfiedLinkError
    //   158	165	366	java/lang/UnsatisfiedLinkError
    //   165	247	366	java/lang/UnsatisfiedLinkError
    //   294	300	366	java/lang/UnsatisfiedLinkError
    //   332	336	366	java/lang/UnsatisfiedLinkError
    //   165	247	409	java/lang/OutOfMemoryError
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall", 2, "updateSetAvatarBtnState index=" + paramInt);
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl.a.a().size();
    Button localButton;
    if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (i > paramInt))
    {
      AvatarWallAdapter.AvatarInfo localAvatarInfo = this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl.a.a(paramInt);
      localButton = this.jdField_a_of_type_AndroidWidgetButton;
      if ((localAvatarInfo == null) || (localAvatarInfo.jdField_a_of_type_Boolean) || (localAvatarInfo.jdField_b_of_type_Boolean)) {
        break label148;
      }
    }
    label148:
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      if ((i > 0) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetImageButton != null) && (this.jdField_a_of_type_AndroidWidgetImageButton.getVisibility() == 8)) {
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
      return;
    }
  }
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    new aihu(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private void c(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.getCount() - 1)) {}
    AvatarWallAdapter.AvatarInfo localAvatarInfo;
    do
    {
      return;
      localAvatarInfo = this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl.a.a(paramInt);
      if (localAvatarInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "currentAvatarInfo = null");
    return;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl.a.a();
    int j;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      int i = 0;
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label119;
      }
      if (!a((AvatarWallAdapter.AvatarInfo)((Iterator)localObject).next())) {
        break label197;
      }
      i += 1;
    }
    label197:
    for (;;)
    {
      break;
      j = 0;
      label119:
      if ((j > 1) || ((j == 1) && (!a(localAvatarInfo))))
      {
        if (!NetworkUtil.g(this))
        {
          QQToast.a(this, 0, getString(2131435586), 0).b(getTitleBarHeight());
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl.b(paramInt);
        return;
      }
      QQToast.a(this, getString(2131430211), 1).b(getTitleBarHeight());
      return;
    }
  }
  
  void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall", 2, "index=" + paramInt);
    }
    if ((paramInt < 0) && (paramInt > this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.getCount() - 1)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl.a.c(paramInt);
  }
  
  public void a(URLDrawable paramURLDrawable, String paramString)
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_share", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    paramString = new File(AppConstants.bz);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    String str = AppConstants.bz + this.jdField_a_of_type_JavaLangString + Utils.Crc64String(paramURLDrawable.getURL().toString());
    paramString = str;
    if (!new File(str).exists()) {}
    try
    {
      paramString = paramURLDrawable.saveTo(str);
      localBundle.putString("forward_filepath", paramString);
      localBundle.putString("forward_thumb", paramString);
      paramURLDrawable = new Intent();
      paramURLDrawable.putExtras(localBundle);
      ForwardBaseOption.a(this, paramURLDrawable, 21);
      return;
    }
    catch (IOException paramURLDrawable)
    {
      for (;;)
      {
        paramString = str;
        if (QLog.isColorLevel())
        {
          QLog.e("foward", 2, "IOException", paramURLDrawable);
          paramString = str;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent(this, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString);
    startActivity(localIntent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
      paramMotionEvent.setLocation(f1, this.jdField_a_of_type_Float);
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Float = f2;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
    case 13: 
      do
      {
        do
        {
          return;
        } while (AvatarWallAdapter.a == null);
        paramIntent = ImageUtil.b(this, AvatarWallAdapter.a);
      } while (TextUtils.isEmpty(paramIntent));
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl.a(localArrayList);
      return;
    }
    a(paramIntent.getExtras());
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    if ((this.app == null) || (TextUtils.isEmpty(this.app.getAccount())))
    {
      finish();
      return false;
    }
    setContentView(2130969851);
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131364774));
    this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetGallery.setContentDescription("大图预览区域");
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362727);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364773));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131362722));
    this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription("删除");
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("IS_EDIT");
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter = new TroopAvatarWallGalleryAdapter(this, this.app, getResources().getDisplayMetrics().widthPixels, getResources().getDimensionPixelSize(2131558786));
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("troop_uin");
      this.jdField_a_of_type_Boolean = paramBundle.getBoolean("troop_info_is_member");
      this.jdField_a_of_type_JavaUtilList = paramBundle.getStringArrayList("seqNum");
      this.jdField_a_of_type_Int = paramBundle.getInt("index", 0);
      this.jdField_a_of_type_Long = paramBundle.getLong("troop_flag_ext", 0L);
      this.jdField_c_of_type_Int = paramBundle.getInt("troop_auth_submit_time", 0);
      this.jdField_c_of_type_Boolean = paramBundle.getBoolean("is_show_action", true);
      this.d = paramBundle.getBoolean("is_new_troop_without_pic", false);
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
      }
      ThreadManager.post(new aihi(this, paramBundle), 8, null, true);
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl.a(this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_c_of_type_Int, this.app, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl.a.a(this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl.a.b(paramBundle.getBoolean("can_add_image", true));
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl.a(this.jdField_a_of_type_JavaUtilList, this.d);
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl.a(new aihn(this));
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131368248));
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      }
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364664));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("返回");
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (this.d)
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      return true;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl.a();
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl.a(paramIntent);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368248: 
      a(this.jdField_a_of_type_Int);
      finish();
      return;
    case 2131362722: 
      paramView = (ActionSheet)ActionSheetHelper.a(this, null);
      paramView.a(2131435868, 3);
      paramView.c(2131432998);
      paramView.a(new aiho(this, paramView));
      paramView.show();
      return;
    case 2131364776: 
      a();
      return;
    }
    finish();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      a();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), false);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  protected void onResume()
  {
    super.onResume();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), true);
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity
 * JD-Core Version:    0.7.0.1
 */