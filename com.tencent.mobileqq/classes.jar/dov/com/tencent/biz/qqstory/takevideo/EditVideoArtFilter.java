package dov.com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import azqs;
import bmkq;
import bmkr;
import bmkt;
import bmnh;
import bmnj;
import bmor;
import bnaz;
import bnbf;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterItemView;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import wxk;
import xcz;

@TargetApi(11)
public class EditVideoArtFilter
  extends bmnh
  implements View.OnClickListener, View.OnTouchListener, AdapterView.OnItemClickListener, Runnable
{
  public static final String a;
  public int a;
  long jdField_a_of_type_Long;
  public Context a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bmkr jdField_a_of_type_Bmkr;
  private bmkt jdField_a_of_type_Bmkt;
  public HorizontalListView a;
  public ArtFilterItemView a;
  public AtomicInteger a;
  public boolean a;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  int c;
  public String c;
  public boolean c;
  int jdField_d_of_type_Int = -1;
  public String d;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = 0;
  String jdField_e_of_type_JavaLangString;
  boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int = -1;
  String jdField_f_of_type_JavaLangString = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = ArtFilterManager.jdField_b_of_type_JavaLangString + "artfiltertemp/";
  }
  
  public EditVideoArtFilter(@NonNull bmnj parambmnj)
  {
    super(parambmnj);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
  }
  
  private Bitmap.Config a(Bitmap paramBitmap)
  {
    Bitmap.Config localConfig = paramBitmap.getConfig();
    paramBitmap = localConfig;
    if (localConfig == null) {
      paramBitmap = Bitmap.Config.ARGB_8888;
    }
    return paramBitmap;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Bmkr.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Bmkr.notifyDataSetChanged();
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(false);
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(0.5F);
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
    } while (Build.VERSION.SDK_INT < 11);
    this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(1.0F);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmor.getActivity();
    this.jdField_a_of_type_Bmkr = new bmkr(this, this.jdField_a_of_type_AndroidContentContext);
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
    this.jdField_a_of_type_Bmkt = new bmkt(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView = ((ArtFilterItemView)a(2131362852));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.findViewById(2131362845));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.findViewById(2131362846));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.findViewById(2131362853));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    if ((this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null) && (this.jdField_a_of_type_Bmkr != null)) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.postDelayed(this, 10L);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.findViewById(2131362847));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnTouchListener(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.setHandler(this.jdField_a_of_type_Bmkt, this.jdField_c_of_type_JavaLangString);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 666) && (paramInt2 == -1)) {
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void a(int paramInt, @NonNull bnaz parambnaz)
  {
    if (b())
    {
      bnbf localbnbf = parambnaz.jdField_a_of_type_Bnbf;
      localbnbf.jdField_a_of_type_Int += 1;
      azqs.b(null, "dc00898", "", "", "0X8007551", "0X8007551", 0, 0, "", "", "", "");
      azqs.b(null, "dc00898", "", "", "0X8007552", "0X8007552", this.jdField_d_of_type_Int, 0, "", "", "", "");
      parambnaz.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("5");
      parambnaz.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves7 = (this.jdField_d_of_type_Int + "");
      wxk.b("0X80075EF", wxk.jdField_a_of_type_Int);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    xcz localxcz = this.jdField_a_of_type_Bmkr.a(paramInt);
    if (localxcz == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "submitFilterTask:position:" + paramInt + "FilterTemplate" + localxcz);
    }
    a(paramInt);
    if ((this.jdField_d_of_type_JavaLangString.endsWith(".gif")) && (!paramBoolean))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690295), 0).a();
      return;
    }
    if (paramInt == 0)
    {
      a(null, -1);
      this.jdField_f_of_type_Int = -1;
      return;
    }
    this.jdField_f_of_type_Int = localxcz.jdField_a_of_type_Int;
    Object localObject = jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Long + "_" + localxcz.jdField_a_of_type_Int + ".png";
    if (new File((String)localObject).exists())
    {
      a((String)localObject, localxcz.jdField_a_of_type_Int);
      return;
    }
    paramInt = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "submitFilterTask: timeStamp:" + this.jdField_a_of_type_Long + " currentTaskId:" + paramInt + " compressedFilePath:" + this.jdField_d_of_type_JavaLangString);
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.a(paramInt);
    localObject = this.jdField_a_of_type_Bmkt.obtainMessage(35);
    ((Message)localObject).obj = Integer.valueOf(paramInt);
    this.jdField_a_of_type_Bmkt.sendMessageDelayed((Message)localObject, 20000L);
    b(true);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("param_art_filter_style_id", localxcz.jdField_a_of_type_Int);
    ((Bundle)localObject).putString("param_art_filter_style_name", localxcz.jdField_b_of_type_JavaLangString);
    ((Bundle)localObject).putLong("param_art_filter_file_name", this.jdField_a_of_type_Long);
    ((Bundle)localObject).putString("param_art_filter_resource_path", this.jdField_d_of_type_JavaLangString);
    ((Bundle)localObject).putInt("param_art_filter_task_id", paramInt);
    QIPCClientHelper.getInstance().callServer("ArtFilterModule", "action_get_art_filter_path", (Bundle)localObject, new bmkq(this, localxcz));
  }
  
  /* Error */
  public void a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 12
    //   9: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +46 -> 58
    //   15: ldc_w 300
    //   18: iconst_2
    //   19: new 38	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   26: ldc_w 451
    //   29: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 453	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   36: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   39: ldc_w 375
    //   42: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 314	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   49: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: aload_1
    //   59: invokevirtual 456	android/graphics/Bitmap:isRecycled	()Z
    //   62: ifeq +4 -> 66
    //   65: return
    //   66: aload_0
    //   67: getfield 453	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   70: ifnonnull +17 -> 87
    //   73: aload_0
    //   74: aload_1
    //   75: aload_0
    //   76: aload_1
    //   77: invokespecial 458	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap$Config;
    //   80: iconst_1
    //   81: invokevirtual 462	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   84: putfield 453	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   87: aload_0
    //   88: getfield 314	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   91: invokestatic 468	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   94: ifne +20 -> 114
    //   97: new 359	java/io/File
    //   100: dup
    //   101: aload_0
    //   102: getfield 314	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   105: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: invokevirtual 365	java/io/File:exists	()Z
    //   111: ifne -46 -> 65
    //   114: aload_0
    //   115: invokestatic 474	android/os/SystemClock:uptimeMillis	()J
    //   118: putfield 350	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_Long	J
    //   121: new 38	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   128: getstatic 57	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   131: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_0
    //   135: getfield 350	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_Long	J
    //   138: invokevirtual 353	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   141: ldc_w 476
    //   144: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: astore 13
    //   152: aload_0
    //   153: getfield 453	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   156: invokevirtual 479	android/graphics/Bitmap:getHeight	()I
    //   159: istore_3
    //   160: aload_0
    //   161: getfield 453	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   164: invokevirtual 482	android/graphics/Bitmap:getWidth	()I
    //   167: istore 5
    //   169: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +41 -> 213
    //   175: ldc_w 300
    //   178: iconst_2
    //   179: new 38	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   186: ldc_w 484
    //   189: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: iload_3
    //   193: invokevirtual 278	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: ldc_w 486
    //   199: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: iload 5
    //   204: invokevirtual 278	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   207: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: iload_3
    //   214: iload 5
    //   216: invokestatic 492	java/lang/Math:max	(II)I
    //   219: istore 4
    //   221: iload 4
    //   223: aload_0
    //   224: getfield 493	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_Int	I
    //   227: if_icmple +459 -> 686
    //   230: aload_0
    //   231: getfield 493	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_Int	I
    //   234: i2f
    //   235: iload 4
    //   237: i2f
    //   238: fdiv
    //   239: fstore_2
    //   240: iload 5
    //   242: i2f
    //   243: fload_2
    //   244: fmul
    //   245: invokestatic 497	java/lang/Math:round	(F)I
    //   248: istore 4
    //   250: iload_3
    //   251: i2f
    //   252: fload_2
    //   253: fmul
    //   254: invokestatic 497	java/lang/Math:round	(F)I
    //   257: istore_3
    //   258: aload_1
    //   259: iload 4
    //   261: iload_3
    //   262: iconst_0
    //   263: invokestatic 501	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   266: astore 7
    //   268: aload 7
    //   270: astore 9
    //   272: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq +45 -> 320
    //   278: ldc_w 300
    //   281: iconst_2
    //   282: new 38	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   289: ldc_w 503
    //   292: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: iload 4
    //   297: invokevirtual 278	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: ldc_w 505
    //   303: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: iload_3
    //   307: invokevirtual 278	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   310: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: aload 7
    //   318: astore 9
    //   320: aload 9
    //   322: ifnull +729 -> 1051
    //   325: new 507	java/io/FileOutputStream
    //   328: dup
    //   329: new 359	java/io/File
    //   332: dup
    //   333: aload 13
    //   335: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   338: invokespecial 510	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   341: astore 7
    //   343: new 512	java/io/BufferedOutputStream
    //   346: dup
    //   347: aload 7
    //   349: invokespecial 515	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   352: astore 8
    //   354: aload 9
    //   356: getstatic 521	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   359: bipush 90
    //   361: aload 8
    //   363: invokevirtual 525	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   366: istore 6
    //   368: aload 9
    //   370: invokevirtual 528	android/graphics/Bitmap:recycle	()V
    //   373: iload 6
    //   375: ifeq +50 -> 425
    //   378: aload_0
    //   379: aload 13
    //   381: putfield 314	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   384: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq +33 -> 420
    //   390: ldc_w 300
    //   393: iconst_2
    //   394: new 38	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   401: ldc_w 530
    //   404: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload_0
    //   408: getfield 314	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   411: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   420: aload_0
    //   421: iconst_0
    //   422: putfield 77	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_Boolean	Z
    //   425: aload 8
    //   427: astore 10
    //   429: aload 7
    //   431: astore 8
    //   433: aload 10
    //   435: ifnull +8 -> 443
    //   438: aload 10
    //   440: invokevirtual 533	java/io/BufferedOutputStream:close	()V
    //   443: aload 8
    //   445: astore 9
    //   447: aload 10
    //   449: astore 7
    //   451: aload 8
    //   453: ifnull +16 -> 469
    //   456: aload 8
    //   458: invokevirtual 534	java/io/FileOutputStream:close	()V
    //   461: aload 10
    //   463: astore 7
    //   465: aload 8
    //   467: astore 9
    //   469: aload_0
    //   470: getfield 314	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   473: ifnonnull -408 -> 65
    //   476: new 507	java/io/FileOutputStream
    //   479: dup
    //   480: new 359	java/io/File
    //   483: dup
    //   484: aload 13
    //   486: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   489: invokespecial 510	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   492: astore 8
    //   494: new 512	java/io/BufferedOutputStream
    //   497: dup
    //   498: aload 8
    //   500: invokespecial 515	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   503: astore 9
    //   505: aload_1
    //   506: getstatic 521	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   509: bipush 90
    //   511: aload 9
    //   513: invokevirtual 525	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   516: ifeq +50 -> 566
    //   519: aload_0
    //   520: aload 13
    //   522: putfield 314	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   525: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   528: ifeq +33 -> 561
    //   531: ldc_w 300
    //   534: iconst_2
    //   535: new 38	java/lang/StringBuilder
    //   538: dup
    //   539: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   542: ldc_w 536
    //   545: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload_0
    //   549: getfield 314	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   552: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: aload_0
    //   562: iconst_0
    //   563: putfield 77	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_Boolean	Z
    //   566: aload 9
    //   568: ifnull +8 -> 576
    //   571: aload 9
    //   573: invokevirtual 533	java/io/BufferedOutputStream:close	()V
    //   576: aload 8
    //   578: ifnull +8 -> 586
    //   581: aload 8
    //   583: invokevirtual 534	java/io/FileOutputStream:close	()V
    //   586: aload_0
    //   587: getfield 314	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   590: ifnonnull -525 -> 65
    //   593: aload_0
    //   594: aload_0
    //   595: getfield 177	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   598: putfield 314	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   601: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   604: ifeq +33 -> 637
    //   607: ldc_w 300
    //   610: iconst_2
    //   611: new 38	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   618: ldc_w 538
    //   621: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: aload_0
    //   625: getfield 314	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   628: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   637: aload_0
    //   638: iconst_1
    //   639: putfield 77	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_Boolean	Z
    //   642: return
    //   643: astore_1
    //   644: aload_1
    //   645: invokevirtual 541	java/lang/OutOfMemoryError:printStackTrace	()V
    //   648: return
    //   649: astore 7
    //   651: aload 7
    //   653: invokevirtual 541	java/lang/OutOfMemoryError:printStackTrace	()V
    //   656: iconst_0
    //   657: ifeq +11 -> 668
    //   660: new 543	java/lang/NullPointerException
    //   663: dup
    //   664: invokespecial 544	java/lang/NullPointerException:<init>	()V
    //   667: athrow
    //   668: iconst_0
    //   669: ifeq -604 -> 65
    //   672: new 543	java/lang/NullPointerException
    //   675: dup
    //   676: invokespecial 544	java/lang/NullPointerException:<init>	()V
    //   679: athrow
    //   680: astore_1
    //   681: aload_1
    //   682: invokevirtual 545	java/io/IOException:printStackTrace	()V
    //   685: return
    //   686: aload_1
    //   687: aload_0
    //   688: aload_1
    //   689: invokespecial 458	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap$Config;
    //   692: iconst_1
    //   693: invokevirtual 462	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   696: astore 9
    //   698: goto -378 -> 320
    //   701: astore 7
    //   703: aload 7
    //   705: invokevirtual 541	java/lang/OutOfMemoryError:printStackTrace	()V
    //   708: iconst_0
    //   709: ifeq +11 -> 720
    //   712: new 543	java/lang/NullPointerException
    //   715: dup
    //   716: invokespecial 544	java/lang/NullPointerException:<init>	()V
    //   719: athrow
    //   720: iconst_0
    //   721: ifeq -656 -> 65
    //   724: new 543	java/lang/NullPointerException
    //   727: dup
    //   728: invokespecial 544	java/lang/NullPointerException:<init>	()V
    //   731: athrow
    //   732: astore_1
    //   733: aload_1
    //   734: invokevirtual 545	java/io/IOException:printStackTrace	()V
    //   737: return
    //   738: astore 7
    //   740: aload 7
    //   742: invokevirtual 545	java/io/IOException:printStackTrace	()V
    //   745: aload 8
    //   747: astore 9
    //   749: aload 10
    //   751: astore 7
    //   753: goto -284 -> 469
    //   756: astore 7
    //   758: aconst_null
    //   759: astore 8
    //   761: aload 7
    //   763: invokevirtual 546	java/lang/Exception:printStackTrace	()V
    //   766: aload 10
    //   768: ifnull +8 -> 776
    //   771: aload 10
    //   773: invokevirtual 533	java/io/BufferedOutputStream:close	()V
    //   776: aload 8
    //   778: astore 9
    //   780: aload 10
    //   782: astore 7
    //   784: aload 8
    //   786: ifnull -317 -> 469
    //   789: aload 8
    //   791: invokevirtual 534	java/io/FileOutputStream:close	()V
    //   794: aload 8
    //   796: astore 9
    //   798: aload 10
    //   800: astore 7
    //   802: goto -333 -> 469
    //   805: astore 7
    //   807: aload 7
    //   809: invokevirtual 545	java/io/IOException:printStackTrace	()V
    //   812: aload 8
    //   814: astore 9
    //   816: aload 10
    //   818: astore 7
    //   820: goto -351 -> 469
    //   823: astore_1
    //   824: aconst_null
    //   825: astore 8
    //   827: aload 11
    //   829: astore 7
    //   831: aload 8
    //   833: ifnull +8 -> 841
    //   836: aload 8
    //   838: invokevirtual 533	java/io/BufferedOutputStream:close	()V
    //   841: aload 7
    //   843: ifnull +8 -> 851
    //   846: aload 7
    //   848: invokevirtual 534	java/io/FileOutputStream:close	()V
    //   851: aload_1
    //   852: athrow
    //   853: astore 7
    //   855: aload 7
    //   857: invokevirtual 545	java/io/IOException:printStackTrace	()V
    //   860: goto -9 -> 851
    //   863: astore_1
    //   864: aload_1
    //   865: invokevirtual 545	java/io/IOException:printStackTrace	()V
    //   868: goto -282 -> 586
    //   871: astore 8
    //   873: aload 9
    //   875: astore_1
    //   876: aload 8
    //   878: invokevirtual 546	java/lang/Exception:printStackTrace	()V
    //   881: aload 7
    //   883: ifnull +8 -> 891
    //   886: aload 7
    //   888: invokevirtual 533	java/io/BufferedOutputStream:close	()V
    //   891: aload_1
    //   892: ifnull -306 -> 586
    //   895: aload_1
    //   896: invokevirtual 534	java/io/FileOutputStream:close	()V
    //   899: goto -313 -> 586
    //   902: astore_1
    //   903: aload_1
    //   904: invokevirtual 545	java/io/IOException:printStackTrace	()V
    //   907: goto -321 -> 586
    //   910: astore_1
    //   911: aload 9
    //   913: astore 8
    //   915: aload 7
    //   917: ifnull +8 -> 925
    //   920: aload 7
    //   922: invokevirtual 533	java/io/BufferedOutputStream:close	()V
    //   925: aload 8
    //   927: ifnull +8 -> 935
    //   930: aload 8
    //   932: invokevirtual 534	java/io/FileOutputStream:close	()V
    //   935: aload_1
    //   936: athrow
    //   937: astore 7
    //   939: aload 7
    //   941: invokevirtual 545	java/io/IOException:printStackTrace	()V
    //   944: goto -9 -> 935
    //   947: astore_1
    //   948: goto -33 -> 915
    //   951: astore_1
    //   952: aload 9
    //   954: astore 7
    //   956: goto -41 -> 915
    //   959: astore 9
    //   961: aload_1
    //   962: astore 8
    //   964: aload 9
    //   966: astore_1
    //   967: goto -52 -> 915
    //   970: astore 9
    //   972: aload 8
    //   974: astore_1
    //   975: aload 9
    //   977: astore 8
    //   979: goto -103 -> 876
    //   982: astore 10
    //   984: aload 8
    //   986: astore_1
    //   987: aload 9
    //   989: astore 7
    //   991: aload 10
    //   993: astore 8
    //   995: goto -119 -> 876
    //   998: astore_1
    //   999: aconst_null
    //   1000: astore 8
    //   1002: goto -171 -> 831
    //   1005: astore_1
    //   1006: goto -175 -> 831
    //   1009: astore_1
    //   1010: aload 8
    //   1012: astore 7
    //   1014: aload 10
    //   1016: astore 8
    //   1018: goto -187 -> 831
    //   1021: astore 9
    //   1023: aload 7
    //   1025: astore 8
    //   1027: aload 9
    //   1029: astore 7
    //   1031: goto -270 -> 761
    //   1034: astore 9
    //   1036: aload 8
    //   1038: astore 10
    //   1040: aload 7
    //   1042: astore 8
    //   1044: aload 9
    //   1046: astore 7
    //   1048: goto -287 -> 761
    //   1051: aconst_null
    //   1052: astore 8
    //   1054: aload 12
    //   1056: astore 10
    //   1058: goto -625 -> 433
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1061	0	this	EditVideoArtFilter
    //   0	1061	1	paramBitmap	Bitmap
    //   239	14	2	f1	float
    //   159	148	3	i	int
    //   219	77	4	j	int
    //   167	74	5	k	int
    //   366	8	6	bool	boolean
    //   266	198	7	localObject1	Object
    //   649	3	7	localOutOfMemoryError1	OutOfMemoryError
    //   701	3	7	localOutOfMemoryError2	OutOfMemoryError
    //   738	3	7	localIOException1	java.io.IOException
    //   751	1	7	localObject2	Object
    //   756	6	7	localException1	java.lang.Exception
    //   782	19	7	localObject3	Object
    //   805	3	7	localIOException2	java.io.IOException
    //   818	29	7	localObject4	Object
    //   853	68	7	localIOException3	java.io.IOException
    //   937	3	7	localIOException4	java.io.IOException
    //   954	93	7	localObject5	Object
    //   352	485	8	localObject6	Object
    //   871	6	8	localException2	java.lang.Exception
    //   913	140	8	localObject7	Object
    //   270	683	9	localObject8	Object
    //   959	6	9	localObject9	Object
    //   970	18	9	localException3	java.lang.Exception
    //   1021	7	9	localException4	java.lang.Exception
    //   1034	11	9	localException5	java.lang.Exception
    //   1	816	10	localObject10	Object
    //   982	33	10	localException6	java.lang.Exception
    //   1038	19	10	localObject11	Object
    //   4	824	11	localObject12	Object
    //   7	1048	12	localObject13	Object
    //   150	371	13	str	String
    // Exception table:
    //   from	to	target	type
    //   73	87	643	java/lang/OutOfMemoryError
    //   258	268	649	java/lang/OutOfMemoryError
    //   660	668	680	java/io/IOException
    //   672	680	680	java/io/IOException
    //   686	698	701	java/lang/OutOfMemoryError
    //   712	720	732	java/io/IOException
    //   724	732	732	java/io/IOException
    //   438	443	738	java/io/IOException
    //   456	461	738	java/io/IOException
    //   152	213	756	java/lang/Exception
    //   213	258	756	java/lang/Exception
    //   258	268	756	java/lang/Exception
    //   272	316	756	java/lang/Exception
    //   325	343	756	java/lang/Exception
    //   651	656	756	java/lang/Exception
    //   686	698	756	java/lang/Exception
    //   703	708	756	java/lang/Exception
    //   771	776	805	java/io/IOException
    //   789	794	805	java/io/IOException
    //   152	213	823	finally
    //   213	258	823	finally
    //   258	268	823	finally
    //   272	316	823	finally
    //   325	343	823	finally
    //   651	656	823	finally
    //   686	698	823	finally
    //   703	708	823	finally
    //   836	841	853	java/io/IOException
    //   846	851	853	java/io/IOException
    //   571	576	863	java/io/IOException
    //   581	586	863	java/io/IOException
    //   476	494	871	java/lang/Exception
    //   886	891	902	java/io/IOException
    //   895	899	902	java/io/IOException
    //   476	494	910	finally
    //   920	925	937	java/io/IOException
    //   930	935	937	java/io/IOException
    //   494	505	947	finally
    //   505	561	951	finally
    //   561	566	951	finally
    //   876	881	959	finally
    //   494	505	970	java/lang/Exception
    //   505	561	982	java/lang/Exception
    //   561	566	982	java/lang/Exception
    //   343	354	998	finally
    //   354	373	1005	finally
    //   378	420	1005	finally
    //   420	425	1005	finally
    //   761	766	1009	finally
    //   343	354	1021	java/lang/Exception
    //   354	373	1034	java/lang/Exception
    //   378	420	1034	java/lang/Exception
    //   420	425	1034	java/lang/Exception
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject1;
    for (;;)
    {
      Bitmap localBitmap;
      Object localObject2;
      label337:
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "before LoadUp: lastFilePath:" + this.jdField_f_of_type_JavaLangString + " lastOriginalBitmap:" + this.jdField_e_of_type_Boolean + " fileOutputPath:" + paramString);
        }
        if ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists())) {
          break label423;
        }
        this.jdField_e_of_type_Int = this.jdField_c_of_type_Int;
        boolean bool = paramString.equals(this.jdField_f_of_type_JavaLangString);
        if (bool) {
          return;
        }
        localObject1 = null;
      }
      finally {}
      try
      {
        localBitmap = BitmapFactory.decodeFile(paramString);
        localObject2 = localBitmap;
        localObject1 = localBitmap;
        if (this.jdField_d_of_type_Boolean)
        {
          localObject2 = localBitmap;
          localObject1 = localBitmap;
          if (this.jdField_a_of_type_Bmnj.jdField_b_of_type_Int != 0)
          {
            localObject2 = localBitmap;
            localObject1 = localBitmap;
            if (this.jdField_a_of_type_Bmnj.jdField_b_of_type_Int % 90 == 0)
            {
              localObject1 = localBitmap;
              if (QLog.isColorLevel())
              {
                localObject1 = localBitmap;
                QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "load bitmap has exif rotate " + this.jdField_a_of_type_Bmnj.jdField_b_of_type_Int);
              }
              localObject1 = localBitmap;
              int i = localBitmap.getWidth();
              localObject1 = localBitmap;
              int j = localBitmap.getHeight();
              localObject1 = localBitmap;
              localObject2 = new Matrix();
              localObject1 = localBitmap;
              ((Matrix)localObject2).postRotate(this.jdField_a_of_type_Bmnj.jdField_b_of_type_Int, i / 2.0F, j / 2.0F);
              localObject1 = localBitmap;
              localObject2 = Bitmap.createBitmap(localBitmap, 0, 0, i, j, (Matrix)localObject2, true);
              localObject1 = localBitmap;
              localBitmap.recycle();
            }
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("Q.qqstory.publish.edit.EditVideoArtFilter", 1, "load oom");
        Object localObject3 = localObject1;
        continue;
      }
      if (localObject2 != null)
      {
        this.jdField_a_of_type_Bmnj.a((Bitmap)localObject2, true);
        this.jdField_f_of_type_JavaLangString = paramString;
        this.jdField_d_of_type_Int = paramInt;
        this.jdField_e_of_type_Boolean = false;
        if (!QLog.isColorLevel()) {
          break label477;
        }
        QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "before LoadUp: lastFilePath:" + this.jdField_f_of_type_JavaLangString + " lastOriginalBitmap:" + this.jdField_e_of_type_Boolean + " fileOutputPath:" + paramString);
      }
    }
    label423:
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      if (!this.jdField_e_of_type_Boolean)
      {
        localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap.copy(a(this.jdField_a_of_type_AndroidGraphicsBitmap), true);
        this.jdField_a_of_type_Bmnj.a((Bitmap)localObject1, true);
      }
    }
    for (;;)
    {
      this.jdField_f_of_type_JavaLangString = "";
      this.jdField_e_of_type_Boolean = true;
      break label337;
      label477:
      break;
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_Bmnj.a().copy(a(this.jdField_a_of_type_Bmnj.a()), true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "initState:isProcessing:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      c();
      if (paramBoolean) {
        a(this.jdField_e_of_type_Int);
      }
    }
    this.jdField_f_of_type_Int = -1;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_Int == 12)
    {
      if (a(this.jdField_b_of_type_Int))
      {
        a(false);
        a(this.jdField_b_of_type_Int, true);
        this.jdField_a_of_type_Bmnj.a(0);
      }
      return true;
    }
    return false;
  }
  
  boolean a(int paramInt)
  {
    if (this.jdField_d_of_type_JavaLangString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "compressedFilePath has not generated");
      }
    }
    do
    {
      long l;
      do
      {
        return false;
        l = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "mLastItemClickTime:" + this.jdField_b_of_type_Long + " mLastItemClickPosition:" + this.jdField_c_of_type_Int + " ClickTime:" + l + " ClickPosition:" + paramInt);
        }
      } while (l - this.jdField_b_of_type_Long < 300L);
      this.jdField_b_of_type_Long = l;
    } while ((this.jdField_c_of_type_Int == paramInt) && (this.jdField_a_of_type_Boolean));
    this.jdField_c_of_type_Int = paramInt;
    if (this.jdField_c_of_type_Int != 0) {
      azqs.b(null, "dc00898", "", "", "0X8007550", "0X8007550", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "editVideoState Change:" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.getVisibility() == 0) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.a(this);
      }
      return;
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Bmkr.jdField_c_of_type_Int;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.b();
    azqs.b(null, "dc00898", "", "", "0X800754F", "0X800754F", 0, 0, "", "", "", "");
  }
  
  public boolean b()
  {
    return (this.jdField_b_of_type_Boolean) || (!this.jdField_e_of_type_Boolean);
  }
  
  public void c()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.a();
    this.jdField_a_of_type_Bmkt.removeCallbacksAndMessages(null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "CancelFilterTaskId:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    b(false);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "updateCropImg");
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_e_of_type_Boolean = true;
    if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (new File(this.jdField_d_of_type_JavaLangString).exists()))
    {
      new File(this.jdField_d_of_type_JavaLangString).delete();
      this.jdField_d_of_type_JavaLangString = null;
    }
    a(0);
    this.jdField_e_of_type_Int = 0;
    if (b()) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_Bmkt.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Bmkt = null;
    if (this.jdField_c_of_type_Boolean) {
      QIPCClientHelper.getInstance().callServer("ArtFilterModule", "action_exit_art_filter", null, null);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131362845: 
      do
      {
        return;
      } while (!a(this.jdField_b_of_type_Int));
      a(false);
      a(this.jdField_b_of_type_Int, true);
      this.jdField_a_of_type_Bmnj.a(0);
      return;
    }
    this.jdField_a_of_type_Bmnj.a(0);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (a(paramInt))
    {
      if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3) {
        LpReportInfo_pf00064.report(615, 7);
      }
      a(false);
      a(paramInt, false);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (paramView.getId() == 2131362847))
    {
      if (this.jdField_a_of_type_Boolean) {
        return true;
      }
      onClick(this.jdField_b_of_type_AndroidWidgetTextView);
      return true;
    }
    return false;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 677	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4: invokestatic 468	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +237 -> 244
    //   10: new 271	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 678	java/util/ArrayList:<init>	()V
    //   17: astore_2
    //   18: new 680	org/json/JSONArray
    //   21: dup
    //   22: aload_0
    //   23: getfield 677	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   26: invokespecial 681	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   29: astore_3
    //   30: iconst_0
    //   31: istore_1
    //   32: iload_1
    //   33: aload_3
    //   34: invokevirtual 684	org/json/JSONArray:length	()I
    //   37: if_icmpge +71 -> 108
    //   40: aload_3
    //   41: iload_1
    //   42: invokevirtual 688	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   45: astore 4
    //   47: aload_2
    //   48: new 347	xcz
    //   51: dup
    //   52: aload 4
    //   54: ldc_w 690
    //   57: invokevirtual 696	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   60: aload 4
    //   62: ldc_w 698
    //   65: invokevirtual 701	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   68: aload 4
    //   70: ldc_w 703
    //   73: invokevirtual 696	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   76: aload 4
    //   78: ldc_w 705
    //   81: invokevirtual 701	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   84: aload 4
    //   86: ldc_w 707
    //   89: invokevirtual 701	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   92: invokespecial 710	xcz:<init>	(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   95: invokeinterface 713 2 0
    //   100: pop
    //   101: iload_1
    //   102: iconst_1
    //   103: iadd
    //   104: istore_1
    //   105: goto -73 -> 32
    //   108: aload_2
    //   109: invokeinterface 717 1 0
    //   114: astore_3
    //   115: aload_3
    //   116: invokeinterface 722 1 0
    //   121: ifeq +132 -> 253
    //   124: new 359	java/io/File
    //   127: dup
    //   128: aload_3
    //   129: invokeinterface 726 1 0
    //   134: checkcast 347	xcz
    //   137: getfield 727	xcz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   140: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   143: astore 4
    //   145: aload 4
    //   147: invokevirtual 365	java/io/File:exists	()Z
    //   150: ifeq +11 -> 161
    //   153: aload 4
    //   155: invokevirtual 730	java/io/File:isFile	()Z
    //   158: ifne -43 -> 115
    //   161: aload_3
    //   162: invokeinterface 733 1 0
    //   167: goto -52 -> 115
    //   170: astore_3
    //   171: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +13 -> 187
    //   177: ldc_w 300
    //   180: iconst_2
    //   181: ldc_w 735
    //   184: invokestatic 585	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +35 -> 225
    //   193: ldc_w 300
    //   196: iconst_2
    //   197: new 38	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 737
    //   207: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_2
    //   211: invokeinterface 740 1 0
    //   216: invokevirtual 278	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload_0
    //   226: getfield 113	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_Bmkr	Lbmkr;
    //   229: aload_2
    //   230: invokevirtual 743	bmkr:a	(Ljava/util/List;)V
    //   233: aload_0
    //   234: getfield 206	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_ComTencentWidgetHorizontalListView	Lcom/tencent/widget/HorizontalListView;
    //   237: aload_0
    //   238: getfield 113	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_Bmkr	Lbmkr;
    //   241: invokevirtual 747	com/tencent/widget/HorizontalListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   244: aload_0
    //   245: getfield 206	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_ComTencentWidgetHorizontalListView	Lcom/tencent/widget/HorizontalListView;
    //   248: aload_0
    //   249: invokevirtual 210	com/tencent/widget/HorizontalListView:setOnItemClickListener	(Landroid/widget/AdapterView$OnItemClickListener;)V
    //   252: return
    //   253: aload_2
    //   254: invokestatic 752	java/util/Collections:sort	(Ljava/util/List;)V
    //   257: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq +35 -> 295
    //   263: ldc_w 300
    //   266: iconst_2
    //   267: new 38	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   274: ldc_w 737
    //   277: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_2
    //   281: invokeinterface 740 1 0
    //   286: invokevirtual 278	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   289: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: aload_0
    //   296: getfield 113	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_Bmkr	Lbmkr;
    //   299: aload_2
    //   300: invokevirtual 743	bmkr:a	(Ljava/util/List;)V
    //   303: goto -70 -> 233
    //   306: astore_3
    //   307: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq +35 -> 345
    //   313: ldc_w 300
    //   316: iconst_2
    //   317: new 38	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 737
    //   327: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_2
    //   331: invokeinterface 740 1 0
    //   336: invokevirtual 278	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   339: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: aload_0
    //   346: getfield 113	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_Bmkr	Lbmkr;
    //   349: aload_2
    //   350: invokevirtual 743	bmkr:a	(Ljava/util/List;)V
    //   353: aload_3
    //   354: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	this	EditVideoArtFilter
    //   31	74	1	i	int
    //   17	333	2	localArrayList	ArrayList
    //   29	133	3	localObject1	Object
    //   170	1	3	localJSONException	org.json.JSONException
    //   306	48	3	localObject2	Object
    //   45	109	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   18	30	170	org/json/JSONException
    //   32	101	170	org/json/JSONException
    //   108	115	170	org/json/JSONException
    //   115	161	170	org/json/JSONException
    //   161	167	170	org/json/JSONException
    //   253	257	170	org/json/JSONException
    //   18	30	306	finally
    //   32	101	306	finally
    //   108	115	306	finally
    //   115	161	306	finally
    //   161	167	306	finally
    //   171	187	306	finally
    //   253	257	306	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter
 * JD-Core Version:    0.7.0.1
 */