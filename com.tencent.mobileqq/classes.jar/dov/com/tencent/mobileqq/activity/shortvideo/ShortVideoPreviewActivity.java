package dov.com.tencent.mobileqq.activity.shortvideo;

import ajya;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import apei;
import aptt;
import aptx;
import axqy;
import bbbr;
import bbdj;
import bbdx;
import bbfj;
import bbgu;
import bcql;
import bfnz;
import bktz;
import bkua;
import bkub;
import bkuc;
import bkud;
import bkue;
import bkuf;
import bkug;
import bkuh;
import bkui;
import bkuj;
import bkuk;
import bkul;
import bkum;
import bkun;
import bkuo;
import bkup;
import bkuq;
import blbh;
import blcu;
import bldi;
import bldj;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import dov.com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class ShortVideoPreviewActivity
  extends BaseActivity
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, View.OnClickListener, Runnable
{
  public static int j;
  public int a;
  public long a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bktz(this);
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public MediaPlayer a;
  SurfaceHolder.Callback jdField_a_of_type_AndroidViewSurfaceHolder$Callback = new bkuj(this);
  public SurfaceView a;
  public Button a;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new bkug(this);
  public SeekBar a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public Runnable a;
  String jdField_a_of_type_JavaLangString;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  public final MqqHandler a;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  public long b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public TextView b;
  String jdField_b_of_type_JavaLangString;
  public boolean b;
  int c;
  public ImageView c;
  public TextView c;
  public String c;
  public boolean c;
  int jdField_d_of_type_Int;
  public TextView d;
  public String d;
  boolean jdField_d_of_type_Boolean;
  public int e;
  boolean e;
  public int f;
  boolean f;
  public int g;
  public int h;
  public int i;
  int k;
  
  public ShortVideoPreviewActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = new bkuf(this);
    this.jdField_a_of_type_JavaLangRunnable = new ShortVideoPreviewActivity.17(this);
  }
  
  public static HashMap<String, String> a(String paramString, Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    String str1 = ShortVideoUtils.b(paramString, paramString.substring(paramString.lastIndexOf(".") + 1));
    Object localObject1 = ShortVideoTrimmer.a(paramString);
    Object localObject2;
    int m;
    boolean bool;
    int n;
    if ((localObject1 != null) && (((blcu)localObject1).jdField_a_of_type_Boolean)) {
      if (Build.VERSION.SDK_INT >= 18)
      {
        localObject2 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject2).setDataSource(paramString);
        String str2 = ((MediaMetadataRetriever)localObject2).extractMetadata(9);
        long l1 = 0L;
        try
        {
          long l2 = Long.parseLong(str2);
          l1 = l2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("ShortVideoPreviewActivity", 1, "duration is NaN", localException);
            ((MediaMetadataRetriever)localObject2).release();
          }
        }
        finally
        {
          ((MediaMetadataRetriever)localObject2).release();
        }
        m = blbh.a(paramContext);
        if (((m & 0x1) > 0) && ((m & 0x2) > 0))
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("VideoCompressTask", 2, "CompressTask, step: isHWCodecSupported = " + bool);
          }
          if (!bool) {
            break label373;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoCompressTask", 2, "CompressTask, step: Try to compress using MediaCodec");
          }
          localObject2 = new File(paramString);
          localObject1 = new bkup(str1, (int)(((blcu)localObject1).jdField_b_of_type_Long * 1024L), (int)((blcu)localObject1).jdField_a_of_type_Long, 0L, l1);
          if ((!new bldi().a((File)localObject2, (bldj)localObject1, true)) || (((bkup)localObject1).a != null)) {
            break label359;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoCompressTask", 2, "CompressTask, step: compress completed using MediaCodec");
          }
          n = 0;
          label250:
          m = n;
          localObject1 = str1;
          if (n != 0)
          {
            m = n;
            localObject1 = str1;
            if (!TextUtils.isEmpty(str1))
            {
              if (QLog.isColorLevel()) {
                QLog.d("VideoCompressTask", 2, "CompressTask, step: Try to compress using ShortVideoTrimmer.compressVideo");
              }
              m = ShortVideoTrimmer.a(paramContext, paramString, str1);
              localObject1 = str1;
            }
          }
        }
      }
    }
    for (;;)
    {
      localHashMap.put("outputPath", localObject1);
      localHashMap.put("ret", String.valueOf(m));
      return localHashMap;
      bool = false;
      break;
      label359:
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressTask", 2, "CompressTask, step: compress failed using MediaCodecr");
      }
      label373:
      n = -1;
      break label250;
      if ((localObject1 != null) && (!((blcu)localObject1).jdField_a_of_type_Boolean))
      {
        m = 0;
        localObject1 = paramString;
      }
      else
      {
        m = -1;
        localObject1 = str1;
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    bbdj.a(paramContext, 232, null, paramContext.getString(paramInt), new bkue(), null).show();
  }
  
  private void h()
  {
    this.jdField_a_of_type_Long = new File(this.jdField_d_of_type_JavaLangString).length();
    if ((bbfj.g(this)) && (!bbfj.h(this)) && (this.jdField_a_of_type_Long > apei.a()))
    {
      aptt.a(this, 2131692673, 2131692678, new bkud(this));
      return;
    }
    i();
    setResult(-1);
  }
  
  private void i()
  {
    Intent localIntent = getIntent();
    String str2 = localIntent.getStringExtra("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME");
    Object localObject = localIntent.getStringExtra("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME");
    String str1 = str2;
    if (str2 == null)
    {
      str2 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      localObject = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      str1 = str2;
      if (str2 == null)
      {
        bcql.a(this, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
        return;
      }
    }
    localIntent.setClassName((String)localObject, str1);
    localIntent.putExtra("file_send_path", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("file_send_duration", this.jdField_b_of_type_Long);
    localIntent.putExtra("file_send_size", this.jdField_a_of_type_Long);
    localIntent.putExtra("uin", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_b_of_type_Int);
    localIntent.putExtra("file_source", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("start_init_activity_after_sended", true);
    if (!this.jdField_d_of_type_Boolean) {
      axqy.b(null, "CliOper", "", "", "0X8006130", "0X8006130", 0, 0, "", "", "", "");
    }
    localObject = getIntent();
    if ((localObject != null) && (((Intent)localObject).hasExtra("custom_shortvideopreview_sendbtn_reportActionName")))
    {
      str2 = ((Intent)localObject).getStringExtra("custom_shortvideopreview_sendbtn_reportActionName");
      str1 = ((Intent)localObject).getStringExtra("custom_shortvideopreview_sendbtn_reportReverse2");
      localObject = str1;
      if (str1 == null) {
        localObject = "";
      }
      if (str2 != null) {
        axqy.b(null, "CliOper", "", "", str2, str2, 0, 0, (String)localObject, "", "", "");
      }
    }
    startActivity(localIntent);
  }
  
  public String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "null";
    case 0: 
      return " idle ";
    case 1: 
      return " playing ";
    case 2: 
      return " pause ";
    }
    return " error ";
  }
  
  /* Error */
  public String a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 5
    //   12: new 179	java/io/File
    //   15: dup
    //   16: new 158	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   23: getstatic 395	ahvy:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   26: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 397
    //   32: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore 6
    //   43: aload 6
    //   45: invokevirtual 400	java/io/File:exists	()Z
    //   48: ifne +9 -> 57
    //   51: aload 6
    //   53: invokevirtual 403	java/io/File:mkdirs	()Z
    //   56: pop
    //   57: invokestatic 408	java/lang/System:currentTimeMillis	()J
    //   60: lstore_2
    //   61: aload_1
    //   62: ifnull +97 -> 159
    //   65: new 179	java/io/File
    //   68: dup
    //   69: aload 6
    //   71: new 158	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   78: lload_2
    //   79: invokestatic 411	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   82: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 413
    //   88: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokespecial 416	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   97: astore 6
    //   99: aload 6
    //   101: invokevirtual 419	java/io/File:createNewFile	()Z
    //   104: ifeq +227 -> 331
    //   107: aload 6
    //   109: invokevirtual 422	java/io/File:getPath	()Ljava/lang/String;
    //   112: astore 4
    //   114: new 424	java/io/FileOutputStream
    //   117: dup
    //   118: aload 6
    //   120: invokevirtual 422	java/io/File:getPath	()Ljava/lang/String;
    //   123: invokespecial 425	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   126: astore 5
    //   128: aload_1
    //   129: getstatic 431	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   132: bipush 100
    //   134: aload 5
    //   136: invokevirtual 437	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   139: pop
    //   140: aload 4
    //   142: astore_1
    //   143: aload_1
    //   144: astore 4
    //   146: aload 5
    //   148: ifnull +11 -> 159
    //   151: aload 5
    //   153: invokevirtual 440	java/io/FileOutputStream:close	()V
    //   156: aload_1
    //   157: astore 4
    //   159: aload 4
    //   161: areturn
    //   162: astore 6
    //   164: aconst_null
    //   165: astore 5
    //   167: aload 7
    //   169: astore_1
    //   170: aload 5
    //   172: astore 4
    //   174: aload 6
    //   176: invokevirtual 443	java/lang/OutOfMemoryError:printStackTrace	()V
    //   179: aload_1
    //   180: astore 4
    //   182: aload 5
    //   184: ifnull -25 -> 159
    //   187: aload 5
    //   189: invokevirtual 440	java/io/FileOutputStream:close	()V
    //   192: aload_1
    //   193: areturn
    //   194: astore 4
    //   196: aload_1
    //   197: areturn
    //   198: astore 6
    //   200: aconst_null
    //   201: astore 5
    //   203: aload 8
    //   205: astore_1
    //   206: aload 5
    //   208: astore 4
    //   210: ldc 156
    //   212: iconst_1
    //   213: new 158	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   220: ldc_w 445
    //   223: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload 6
    //   228: invokevirtual 448	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 450	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload_1
    //   238: astore 4
    //   240: aload 5
    //   242: ifnull -83 -> 159
    //   245: aload 5
    //   247: invokevirtual 440	java/io/FileOutputStream:close	()V
    //   250: aload_1
    //   251: areturn
    //   252: astore 4
    //   254: aload_1
    //   255: areturn
    //   256: astore_1
    //   257: aconst_null
    //   258: astore 4
    //   260: aload 4
    //   262: ifnull +8 -> 270
    //   265: aload 4
    //   267: invokevirtual 440	java/io/FileOutputStream:close	()V
    //   270: aload_1
    //   271: athrow
    //   272: astore 4
    //   274: aload_1
    //   275: areturn
    //   276: astore 4
    //   278: goto -8 -> 270
    //   281: astore_1
    //   282: aload 5
    //   284: astore 4
    //   286: goto -26 -> 260
    //   289: astore_1
    //   290: goto -30 -> 260
    //   293: astore 6
    //   295: aload 4
    //   297: astore_1
    //   298: aconst_null
    //   299: astore 5
    //   301: goto -95 -> 206
    //   304: astore 6
    //   306: aload 4
    //   308: astore_1
    //   309: goto -103 -> 206
    //   312: astore 6
    //   314: aload 4
    //   316: astore_1
    //   317: aconst_null
    //   318: astore 5
    //   320: goto -150 -> 170
    //   323: astore 6
    //   325: aload 4
    //   327: astore_1
    //   328: goto -158 -> 170
    //   331: aconst_null
    //   332: astore 4
    //   334: aload 5
    //   336: astore_1
    //   337: aload 4
    //   339: astore 5
    //   341: goto -198 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	ShortVideoPreviewActivity
    //   0	344	1	paramBitmap	Bitmap
    //   60	19	2	l	long
    //   1	180	4	localObject1	Object
    //   194	1	4	localException1	Exception
    //   208	31	4	localObject2	Object
    //   252	1	4	localException2	Exception
    //   258	8	4	localObject3	Object
    //   272	1	4	localException3	Exception
    //   276	1	4	localException4	Exception
    //   284	54	4	localObject4	Object
    //   10	330	5	localObject5	Object
    //   41	78	6	localFile	File
    //   162	13	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   198	29	6	localException5	Exception
    //   293	1	6	localException6	Exception
    //   304	1	6	localException7	Exception
    //   312	1	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   323	1	6	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   4	164	7	localObject6	Object
    //   7	197	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   99	114	162	java/lang/OutOfMemoryError
    //   187	192	194	java/lang/Exception
    //   99	114	198	java/lang/Exception
    //   245	250	252	java/lang/Exception
    //   99	114	256	finally
    //   114	128	256	finally
    //   151	156	272	java/lang/Exception
    //   265	270	276	java/lang/Exception
    //   128	140	281	finally
    //   174	179	289	finally
    //   210	237	289	finally
    //   114	128	293	java/lang/Exception
    //   128	140	304	java/lang/Exception
    //   114	128	312	java/lang/OutOfMemoryError
    //   128	140	323	java/lang/OutOfMemoryError
  }
  
  @TargetApi(10)
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetButton.getText().toString().endsWith(getResources().getString(2131694329)))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131694328);
      m = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(m);
      this.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845268);
      b(1);
      this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-2130706433);
      return null;
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845267);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131694329);
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    Bitmap localBitmap = localMediaMetadataRetriever.getFrameAtTime(this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition() * 1000, 3);
    this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
    int m = localBitmap.getWidth();
    int n = localBitmap.getHeight();
    int i1 = Math.max(m, n);
    paramString = localBitmap;
    if (i1 > 512)
    {
      float f1 = 512.0F / i1;
      paramString = Bitmap.createScaledBitmap(localBitmap, Math.round(m * f1), Math.round(n * f1), true);
    }
    paramString = a(paramString);
    localMediaMetadataRetriever.release();
    return paramString;
  }
  
  void a()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      switch (this.k)
      {
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131694794);
      }
    }
    for (;;)
    {
      if (this.jdField_f_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719421);
        }
      }
      return;
      StringBuilder localStringBuilder = new StringBuilder(ajya.a(2131714055));
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        localStringBuilder.append("(").append(this.jdField_a_of_type_JavaUtilArrayList.size()).append(")");
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localStringBuilder);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131694794);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131697534);
      continue;
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719245);
      }
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131692603);
        this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(false);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-2130706433);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (!bbdx.b(this.jdField_d_of_type_JavaLangString))
    {
      bcql.a(this, 2131719581, 0).a();
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "#play#, msec=" + paramInt);
      }
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
      if ((!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDisplay(this.jdField_a_of_type_AndroidViewSurfaceView.getHolder());
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new bkuk(this, paramInt));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreviewActivity", 2, "#play#, msec=" + paramInt, localException);
      }
      e();
      bbdj.a(this, 232, null, getString(2131719608), new bkul(this), null).show();
    }
  }
  
  void a(Intent paramIntent)
  {
    this.jdField_d_of_type_JavaLangString = paramIntent.getExtras().getString("file_send_path");
    this.jdField_b_of_type_Long = paramIntent.getExtras().getLong("file_send_duration");
    this.jdField_a_of_type_Long = paramIntent.getExtras().getLong("file_send_size");
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("file_width", 0);
    this.jdField_d_of_type_Int = paramIntent.getIntExtra("file_height", 0);
    paramIntent.removeExtra("file_width");
    paramIntent.removeExtra("file_height");
    this.jdField_b_of_type_JavaLangString = paramIntent.getExtras().getString("uin");
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("file_source");
    this.jdField_f_of_type_Boolean = paramIntent.getBooleanExtra("preview_only", false);
    this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("from_mobile_mp", false);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("preview", false);
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("cutImage", false);
    this.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("is_from_system_media", true);
    this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    }
    boolean bool1 = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_BAR", false);
    boolean bool2 = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_REWARD", false);
    boolean bool3 = paramIntent.getBooleanExtra("from_health", false);
    paramIntent = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    if ((paramIntent.contains("SplashActivity")) || (paramIntent.contains("ChatActivity"))) {
      this.k = 0;
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || ((this.k != 2) && (this.k != 6) && (!bool3) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) || (!bbdx.b(this.jdField_d_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoPreviewActivity", 2, "ShortVideoPreviewActivity initData(),mVideoPath or mUin is empty or mVideoPath not exits, just finish.");
        }
        bcql.a(this, 2131719581, 0).a();
        super.finish();
      }
      return;
      if (paramIntent.contains("QZonePublishMoodTabActivity")) {
        this.k = 1;
      } else if (paramIntent.contains("QZoneUploadPhotoActivity")) {
        this.k = 1;
      } else if (bool1) {
        this.k = 2;
      } else if (bool2) {
        this.k = 5;
      } else if (paramIntent.contains("TrimVideoActivity")) {
        this.k = 3;
      } else if (paramIntent.contains("LiteActivity")) {
        this.k = 4;
      } else if ((paramIntent.contains("QQBrowserActivity")) || (paramIntent.contains("PublicAccountBrowser"))) {
        this.k = 6;
      } else if (bool3) {
        this.k = 7;
      } else if (this.jdField_c_of_type_Boolean) {
        this.k = 8;
      } else {
        this.k = 0;
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    b(0);
  }
  
  public void b(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {}
    for (;;)
    {
      return;
      this.jdField_e_of_type_Int = paramInt;
      if (paramInt == 1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845268);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ShortVideoPreviewActivity", 2, "changePlayState, playState => " + a(paramInt));
        return;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845267);
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "#pause#");
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) && (this.jdField_e_of_type_Int == 1))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      b(2);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "#resume#");
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_e_of_type_Int == 2))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      b(1);
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
        this.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    a(super.getIntent());
    if (paramBundle != null)
    {
      this.i = paramBundle.getInt("state_play_state");
      this.h = paramBundle.getInt("state_play_position");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "onCreate(), mSavedCurPosition : " + this.h + ",mSavedPlayState : " + a(this.i));
      }
    }
    super.setContentView(2131561105);
    this.jdField_a_of_type_AndroidViewSurfaceView = ((SurfaceView)findViewById(2131376721));
    this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().setType(3);
    this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().addCallback(this.jdField_a_of_type_AndroidViewSurfaceHolder$Callback);
    this.jdField_a_of_type_AndroidViewSurfaceView.getViewTreeObserver().addOnGlobalLayoutListener(new bkuh(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364798));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363852));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375834));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371129));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364878));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370892));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372003));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377625));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371130));
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845268);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131375777));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364878));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnGlobalLayoutListener(new bkui(this));
    a();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      a(0);
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.app.setHandler(ShortVideoPreviewActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
      }
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "doOnDestroy");
    }
    b();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      if (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  void e()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    }
    b(0);
  }
  
  public void f()
  {
    int m = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoWidth();
    int n = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoHeight();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "adjustVideoRatio, videoWith:" + m + ",videoHeight:" + n);
    }
    if ((this.g == 0) || (this.jdField_f_of_type_Int == 0) || (m == 0) || (n == 0)) {
      return;
    }
    if (this.g / this.jdField_f_of_type_Int > n / m)
    {
      f1 = this.jdField_f_of_type_Int;
      m = (int)(n * f1 / m);
      m = (int)((this.g - m) / 2.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.setMargins(0, m, 0, m);
      this.jdField_a_of_type_AndroidViewSurfaceView.setLayoutParams(localLayoutParams);
      return;
    }
    float f1 = this.g;
    m = (int)(m * f1 / n);
    m = (int)((this.jdField_f_of_type_Int - m) / 2.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(m, 0, m, 0);
    this.jdField_a_of_type_AndroidViewSurfaceView.setLayoutParams(localLayoutParams);
  }
  
  void g()
  {
    if (bbbr.b() > 512000L)
    {
      if (bbfj.b(this))
      {
        this.jdField_a_of_type_Long = new File(this.jdField_d_of_type_JavaLangString).length();
        String str = ShortVideoUtils.a(this, this.jdField_a_of_type_Long);
        bbdj.a(this, 232, null, String.format(getResources().getString(2131719574), new Object[] { str }), new bkub(this), new bkuc(this)).show();
        return;
      }
      i();
      return;
    }
    a(this, 2131719599);
  }
  
  @TargetApi(11)
  public void onClick(View paramView)
  {
    Object localObject2 = null;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363852: 
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      super.finish();
      return;
    case 2131371129: 
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "handleClick: mPlayState = " + a(this.jdField_e_of_type_Int));
      }
      if ((this.i == 2) && (this.h > 0))
      {
        a(this.h);
        this.i = 0;
        this.h = 0;
        return;
      }
      switch (this.jdField_e_of_type_Int)
      {
      default: 
        return;
      case 0: 
        if (this.app.c())
        {
          bcql.a(this, 0, 2131719587, 0).a();
          return;
        }
        a(0);
        return;
      case 1: 
        c();
        return;
      case 2: 
        d();
        return;
      }
      a(0);
      return;
    case 2131371130: 
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "handleClick: mPlayState = " + a(this.jdField_e_of_type_Int));
      }
      if ((this.i == 2) && (this.h > 0))
      {
        a(this.h);
        this.i = 0;
        this.h = 0;
        return;
      }
      switch (this.jdField_e_of_type_Int)
      {
      default: 
        return;
      case 0: 
        if (this.app.c())
        {
          bcql.a(this, 0, 2131719587, 0).a();
          return;
        }
        a(0);
        return;
      case 1: 
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845267);
        c();
        return;
      case 2: 
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845268);
        d();
        return;
      }
      a(0);
      return;
    case 2131364878: 
      this.jdField_a_of_type_JavaLangString = a(this.jdField_d_of_type_JavaLangString);
      return;
    }
    Object localObject1;
    switch (this.k)
    {
    case 6: 
    default: 
      return;
    case 0: 
      g();
      return;
    case 4: 
      h();
      return;
    case 1: 
    case 3: 
      paramView = super.getIntent();
      paramView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
      paramView.putExtra("PhotoConst.VIDEO_SIZE", this.jdField_a_of_type_Long);
      paramView.putExtra("file_send_duration", this.jdField_b_of_type_Long);
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(this.jdField_d_of_type_JavaLangString);
      PhotoUtils.a(this, paramView, (ArrayList)localObject1, 2, false);
      return;
    case 5: 
      paramView = super.getIntent();
      paramView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
      paramView.putExtra("PhotoConst.VIDEO_SIZE", this.jdField_a_of_type_Long);
      paramView.putExtra("file_send_duration", this.jdField_b_of_type_Long);
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(this.jdField_d_of_type_JavaLangString);
      bbdj.a(this, 232, null, getString(2131697989, new Object[] { String.format("%.2fMB", new Object[] { Double.valueOf(this.jdField_a_of_type_Long / 1024.0D / 1024.0D) }) }), new bkum(this, paramView, (ArrayList)localObject1), new bkun(this)).show();
      return;
    case 2: 
      bbdj.a(this, 232, null, getString(2131697989, new Object[] { String.format("%.2fMB", new Object[] { Double.valueOf(this.jdField_a_of_type_Long / 1024.0D / 1024.0D) }) }), new bkuo(this), new bkua(this)).show();
      paramView = new Intent("key_video_select_apply_click");
      paramView.putExtra("className", super.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
      sendBroadcast(paramView);
      return;
    case 7: 
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "ldStart Compress");
      }
      j = -1;
      new bkuq(this, this).execute(new String[] { this.jdField_d_of_type_JavaLangString });
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("file_send_path", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("file_send_duration", this.jdField_b_of_type_Long);
    localIntent.putExtra("file_send_size", this.jdField_a_of_type_Long);
    MediaMetadataRetriever localMediaMetadataRetriever;
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      if (!bbdx.b(this.jdField_d_of_type_JavaLangString)) {
        break label1197;
      }
      this.jdField_a_of_type_JavaLangString = a(ShortVideoUtils.a(this, this.jdField_d_of_type_JavaLangString));
      localMediaMetadataRetriever = new MediaMetadataRetriever();
    }
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(this.jdField_d_of_type_JavaLangString);
        localObject1 = localMediaMetadataRetriever.extractMetadata(18);
        paramView = localMediaMetadataRetriever.extractMetadata(19);
        localMediaMetadataRetriever.release();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPreviewActivity", 2, "width is" + (String)localObject1 + "\n height is " + paramView);
        }
        if (this.jdField_a_of_type_JavaLangString != null)
        {
          localIntent.putExtra("video_cover", this.jdField_a_of_type_JavaLangString);
          localIntent.putExtra("file_width", (String)localObject1);
          localIntent.putExtra("file_height", paramView);
          localIntent.putExtra("retCode", 0);
          if ((this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
          {
            this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
            if (this.jdField_a_of_type_JavaLangString == null) {
              break label1213;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoPreviewActivity", 2, "输出的裁剪图位置为" + this.jdField_a_of_type_JavaLangString);
            }
            localIntent.putExtra("video_cover", this.jdField_a_of_type_JavaLangString);
            localIntent.putExtra("retCode", 0);
          }
          setResult(-1, localIntent);
          finish();
          return;
        }
      }
      catch (Exception paramView)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPreviewActivity", 2, "get height and width error");
        }
        localObject1 = null;
        paramView = localObject2;
        continue;
        localIntent.putExtra("retCode", 1);
        continue;
      }
      label1197:
      aptx.a(ajya.a(2131714079));
      super.finish();
      continue;
      label1213:
      localIntent.putExtra("retCode", 1);
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "mMediaPlayer onCompletion");
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      if ((this.jdField_e_of_type_Int == 1) || (this.jdField_e_of_type_Int == 0))
      {
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
        a(0);
      }
      return;
    }
    b(0);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPreviewActivity", 2, "mMediaPlayer onError what=" + paramInt1 + ",extra=" + paramInt2);
    }
    b(3);
    e();
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "mMediaPlayer onPrepared");
    }
    f();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
    b(1);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (((this.jdField_e_of_type_Int == 1) || (this.jdField_e_of_type_Int == 2)) && (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)) {
      this.h = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
    }
    this.i = this.jdField_e_of_type_Int;
    paramBundle.putInt("state_play_state", this.jdField_e_of_type_Int);
    paramBundle.putInt("state_play_position", this.h);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "onSaveInstanceState: mSavedCurPosition: " + this.h + " ,playState = " + a(this.jdField_e_of_type_Int));
    }
  }
  
  public void onStart()
  {
    if (bfnz.b()) {
      ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
    super.onStart();
  }
  
  public void onStop()
  {
    if (bfnz.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    }
    super.onStop();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void run()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = ShortVideoUtils.a(this, this.jdField_d_of_type_JavaLangString);
    runOnUiThread(new ShortVideoPreviewActivity.15(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */