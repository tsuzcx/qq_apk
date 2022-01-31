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
import aoaz;
import aoba;
import aobc;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager;
import com.tencent.biz.qqstory.takevideo.artfilter.FilterTemplate;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterItemView;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(11)
public class EditVideoArtFilter
  extends EditVideoPart
  implements View.OnClickListener, View.OnTouchListener, AdapterView.OnItemClickListener, Runnable
{
  public static final String a;
  public int a;
  long jdField_a_of_type_Long;
  public Context a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aoba jdField_a_of_type_Aoba;
  private aobc jdField_a_of_type_Aobc;
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
  
  public EditVideoArtFilter(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
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
    this.jdField_a_of_type_Aoba.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Aoba.notifyDataSetChanged();
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
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
    this.jdField_a_of_type_Aoba = new aoba(this, this.jdField_a_of_type_AndroidContentContext);
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
    this.jdField_a_of_type_Aobc = new aobc(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView = ((ArtFilterItemView)a(2131364382));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.findViewById(2131365547));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.findViewById(2131365548));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.findViewById(2131365546));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    if ((this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null) && (this.jdField_a_of_type_Aoba != null)) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.postDelayed(this, 10L);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.findViewById(2131365549));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnTouchListener(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.setHandler(this.jdField_a_of_type_Aobc, this.jdField_c_of_type_JavaLangString);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 666) && (paramInt2 == -1)) {
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    if (b())
    {
      GeneratePicArgs localGeneratePicArgs = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs;
      localGeneratePicArgs.jdField_a_of_type_Int += 1;
      ReportController.b(null, "dc00898", "", "", "0X8007551", "0X8007551", 0, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X8007552", "0X8007552", this.jdField_d_of_type_Int, 0, "", "", "", "");
      paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("5");
      paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves7 = (this.jdField_d_of_type_Int + "");
      VideoEditReport.b("0X80075EF", VideoEditReport.jdField_a_of_type_Int);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    FilterTemplate localFilterTemplate = this.jdField_a_of_type_Aoba.a(paramInt);
    if (localFilterTemplate == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "submitFilterTask:position:" + paramInt + "FilterTemplate" + localFilterTemplate);
    }
    a(paramInt);
    if ((this.jdField_d_of_type_JavaLangString.endsWith(".gif")) && (!paramBoolean))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131438747), 0).a();
      return;
    }
    if (paramInt == 0)
    {
      a(null, -1);
      this.jdField_f_of_type_Int = -1;
      return;
    }
    this.jdField_f_of_type_Int = localFilterTemplate.jdField_a_of_type_Int;
    Object localObject = jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Long + "_" + localFilterTemplate.jdField_a_of_type_Int + ".png";
    if (new File((String)localObject).exists())
    {
      a((String)localObject, localFilterTemplate.jdField_a_of_type_Int);
      return;
    }
    paramInt = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "submitFilterTask: timeStamp:" + this.jdField_a_of_type_Long + " currentTaskId:" + paramInt + " compressedFilePath:" + this.jdField_d_of_type_JavaLangString);
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.a(paramInt);
    localObject = this.jdField_a_of_type_Aobc.obtainMessage(35);
    ((Message)localObject).obj = Integer.valueOf(paramInt);
    this.jdField_a_of_type_Aobc.sendMessageDelayed((Message)localObject, 20000L);
    b(true);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("param_art_filter_style_id", localFilterTemplate.jdField_a_of_type_Int);
    ((Bundle)localObject).putString("param_art_filter_style_name", localFilterTemplate.jdField_b_of_type_JavaLangString);
    ((Bundle)localObject).putLong("param_art_filter_file_name", this.jdField_a_of_type_Long);
    ((Bundle)localObject).putString("param_art_filter_resource_path", this.jdField_d_of_type_JavaLangString);
    ((Bundle)localObject).putInt("param_art_filter_task_id", paramInt);
    QIPCClientHelper.getInstance().callServer("ArtFilterModule", "action_get_art_filter_path", (Bundle)localObject, new aoaz(this, localFilterTemplate));
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
    //   7: astore 8
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
    //   150: astore 12
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
    //   227: if_icmple +455 -> 682
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
    //   322: ifnull +725 -> 1047
    //   325: new 507	java/io/FileOutputStream
    //   328: dup
    //   329: new 359	java/io/File
    //   332: dup
    //   333: aload 12
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
    //   379: aload 12
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
    //   425: aload 7
    //   427: astore 10
    //   429: aload 8
    //   431: ifnull +8 -> 439
    //   434: aload 8
    //   436: invokevirtual 533	java/io/BufferedOutputStream:close	()V
    //   439: aload 10
    //   441: astore 9
    //   443: aload 8
    //   445: astore 7
    //   447: aload 10
    //   449: ifnull +16 -> 465
    //   452: aload 10
    //   454: invokevirtual 534	java/io/FileOutputStream:close	()V
    //   457: aload 8
    //   459: astore 7
    //   461: aload 10
    //   463: astore 9
    //   465: aload_0
    //   466: getfield 314	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   469: ifnonnull -404 -> 65
    //   472: new 507	java/io/FileOutputStream
    //   475: dup
    //   476: new 359	java/io/File
    //   479: dup
    //   480: aload 12
    //   482: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   485: invokespecial 510	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   488: astore 8
    //   490: new 512	java/io/BufferedOutputStream
    //   493: dup
    //   494: aload 8
    //   496: invokespecial 515	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   499: astore 9
    //   501: aload_1
    //   502: getstatic 521	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   505: bipush 90
    //   507: aload 9
    //   509: invokevirtual 525	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   512: ifeq +50 -> 562
    //   515: aload_0
    //   516: aload 12
    //   518: putfield 314	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   521: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   524: ifeq +33 -> 557
    //   527: ldc_w 300
    //   530: iconst_2
    //   531: new 38	java/lang/StringBuilder
    //   534: dup
    //   535: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   538: ldc_w 536
    //   541: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload_0
    //   545: getfield 314	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   548: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   557: aload_0
    //   558: iconst_0
    //   559: putfield 77	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_Boolean	Z
    //   562: aload 9
    //   564: ifnull +8 -> 572
    //   567: aload 9
    //   569: invokevirtual 533	java/io/BufferedOutputStream:close	()V
    //   572: aload 8
    //   574: ifnull +8 -> 582
    //   577: aload 8
    //   579: invokevirtual 534	java/io/FileOutputStream:close	()V
    //   582: aload_0
    //   583: getfield 314	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   586: ifnonnull -521 -> 65
    //   589: aload_0
    //   590: aload_0
    //   591: getfield 177	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   594: putfield 314	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   597: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   600: ifeq +33 -> 633
    //   603: ldc_w 300
    //   606: iconst_2
    //   607: new 38	java/lang/StringBuilder
    //   610: dup
    //   611: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   614: ldc_w 538
    //   617: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: aload_0
    //   621: getfield 314	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   624: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   633: aload_0
    //   634: iconst_1
    //   635: putfield 77	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_Boolean	Z
    //   638: return
    //   639: astore_1
    //   640: aload_1
    //   641: invokevirtual 541	java/lang/OutOfMemoryError:printStackTrace	()V
    //   644: return
    //   645: astore 7
    //   647: aload 7
    //   649: invokevirtual 541	java/lang/OutOfMemoryError:printStackTrace	()V
    //   652: iconst_0
    //   653: ifeq +11 -> 664
    //   656: new 543	java/lang/NullPointerException
    //   659: dup
    //   660: invokespecial 544	java/lang/NullPointerException:<init>	()V
    //   663: athrow
    //   664: iconst_0
    //   665: ifeq -600 -> 65
    //   668: new 543	java/lang/NullPointerException
    //   671: dup
    //   672: invokespecial 544	java/lang/NullPointerException:<init>	()V
    //   675: athrow
    //   676: astore_1
    //   677: aload_1
    //   678: invokevirtual 545	java/io/IOException:printStackTrace	()V
    //   681: return
    //   682: aload_1
    //   683: aload_0
    //   684: aload_1
    //   685: invokespecial 458	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap$Config;
    //   688: iconst_1
    //   689: invokevirtual 462	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   692: astore 9
    //   694: goto -374 -> 320
    //   697: astore 7
    //   699: aload 7
    //   701: invokevirtual 541	java/lang/OutOfMemoryError:printStackTrace	()V
    //   704: iconst_0
    //   705: ifeq +11 -> 716
    //   708: new 543	java/lang/NullPointerException
    //   711: dup
    //   712: invokespecial 544	java/lang/NullPointerException:<init>	()V
    //   715: athrow
    //   716: iconst_0
    //   717: ifeq -652 -> 65
    //   720: new 543	java/lang/NullPointerException
    //   723: dup
    //   724: invokespecial 544	java/lang/NullPointerException:<init>	()V
    //   727: athrow
    //   728: astore_1
    //   729: aload_1
    //   730: invokevirtual 545	java/io/IOException:printStackTrace	()V
    //   733: return
    //   734: astore 7
    //   736: aload 7
    //   738: invokevirtual 545	java/io/IOException:printStackTrace	()V
    //   741: aload 10
    //   743: astore 9
    //   745: aload 8
    //   747: astore 7
    //   749: goto -284 -> 465
    //   752: astore 7
    //   754: aconst_null
    //   755: astore 8
    //   757: aload 7
    //   759: invokevirtual 546	java/lang/Exception:printStackTrace	()V
    //   762: aload 10
    //   764: ifnull +8 -> 772
    //   767: aload 10
    //   769: invokevirtual 533	java/io/BufferedOutputStream:close	()V
    //   772: aload 8
    //   774: astore 9
    //   776: aload 10
    //   778: astore 7
    //   780: aload 8
    //   782: ifnull -317 -> 465
    //   785: aload 8
    //   787: invokevirtual 534	java/io/FileOutputStream:close	()V
    //   790: aload 8
    //   792: astore 9
    //   794: aload 10
    //   796: astore 7
    //   798: goto -333 -> 465
    //   801: astore 7
    //   803: aload 7
    //   805: invokevirtual 545	java/io/IOException:printStackTrace	()V
    //   808: aload 8
    //   810: astore 9
    //   812: aload 10
    //   814: astore 7
    //   816: goto -351 -> 465
    //   819: astore_1
    //   820: aconst_null
    //   821: astore 8
    //   823: aload 11
    //   825: astore 7
    //   827: aload 8
    //   829: ifnull +8 -> 837
    //   832: aload 8
    //   834: invokevirtual 533	java/io/BufferedOutputStream:close	()V
    //   837: aload 7
    //   839: ifnull +8 -> 847
    //   842: aload 7
    //   844: invokevirtual 534	java/io/FileOutputStream:close	()V
    //   847: aload_1
    //   848: athrow
    //   849: astore 7
    //   851: aload 7
    //   853: invokevirtual 545	java/io/IOException:printStackTrace	()V
    //   856: goto -9 -> 847
    //   859: astore_1
    //   860: aload_1
    //   861: invokevirtual 545	java/io/IOException:printStackTrace	()V
    //   864: goto -282 -> 582
    //   867: astore 8
    //   869: aload 9
    //   871: astore_1
    //   872: aload 8
    //   874: invokevirtual 546	java/lang/Exception:printStackTrace	()V
    //   877: aload 7
    //   879: ifnull +8 -> 887
    //   882: aload 7
    //   884: invokevirtual 533	java/io/BufferedOutputStream:close	()V
    //   887: aload_1
    //   888: ifnull -306 -> 582
    //   891: aload_1
    //   892: invokevirtual 534	java/io/FileOutputStream:close	()V
    //   895: goto -313 -> 582
    //   898: astore_1
    //   899: aload_1
    //   900: invokevirtual 545	java/io/IOException:printStackTrace	()V
    //   903: goto -321 -> 582
    //   906: astore_1
    //   907: aload 9
    //   909: astore 8
    //   911: aload 7
    //   913: ifnull +8 -> 921
    //   916: aload 7
    //   918: invokevirtual 533	java/io/BufferedOutputStream:close	()V
    //   921: aload 8
    //   923: ifnull +8 -> 931
    //   926: aload 8
    //   928: invokevirtual 534	java/io/FileOutputStream:close	()V
    //   931: aload_1
    //   932: athrow
    //   933: astore 7
    //   935: aload 7
    //   937: invokevirtual 545	java/io/IOException:printStackTrace	()V
    //   940: goto -9 -> 931
    //   943: astore_1
    //   944: goto -33 -> 911
    //   947: astore_1
    //   948: aload 9
    //   950: astore 7
    //   952: goto -41 -> 911
    //   955: astore 9
    //   957: aload_1
    //   958: astore 8
    //   960: aload 9
    //   962: astore_1
    //   963: goto -52 -> 911
    //   966: astore 9
    //   968: aload 8
    //   970: astore_1
    //   971: aload 9
    //   973: astore 8
    //   975: goto -103 -> 872
    //   978: astore 10
    //   980: aload 8
    //   982: astore_1
    //   983: aload 9
    //   985: astore 7
    //   987: aload 10
    //   989: astore 8
    //   991: goto -119 -> 872
    //   994: astore_1
    //   995: aconst_null
    //   996: astore 8
    //   998: goto -171 -> 827
    //   1001: astore_1
    //   1002: goto -175 -> 827
    //   1005: astore_1
    //   1006: aload 8
    //   1008: astore 7
    //   1010: aload 10
    //   1012: astore 8
    //   1014: goto -187 -> 827
    //   1017: astore 9
    //   1019: aload 7
    //   1021: astore 8
    //   1023: aload 9
    //   1025: astore 7
    //   1027: goto -270 -> 757
    //   1030: astore 9
    //   1032: aload 8
    //   1034: astore 10
    //   1036: aload 7
    //   1038: astore 8
    //   1040: aload 9
    //   1042: astore 7
    //   1044: goto -287 -> 757
    //   1047: aconst_null
    //   1048: astore 10
    //   1050: goto -621 -> 429
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1053	0	this	EditVideoArtFilter
    //   0	1053	1	paramBitmap	Bitmap
    //   239	14	2	f1	float
    //   159	148	3	i	int
    //   219	77	4	j	int
    //   167	74	5	k	int
    //   366	8	6	bool	boolean
    //   266	194	7	localObject1	Object
    //   645	3	7	localOutOfMemoryError1	OutOfMemoryError
    //   697	3	7	localOutOfMemoryError2	OutOfMemoryError
    //   734	3	7	localIOException1	java.io.IOException
    //   747	1	7	localObject2	Object
    //   752	6	7	localException1	java.lang.Exception
    //   778	19	7	localObject3	Object
    //   801	3	7	localIOException2	java.io.IOException
    //   814	29	7	localObject4	Object
    //   849	68	7	localIOException3	java.io.IOException
    //   933	3	7	localIOException4	java.io.IOException
    //   950	93	7	localObject5	Object
    //   7	826	8	localObject6	Object
    //   867	6	8	localException2	java.lang.Exception
    //   909	130	8	localObject7	Object
    //   270	679	9	localObject8	Object
    //   955	6	9	localObject9	Object
    //   966	18	9	localException3	java.lang.Exception
    //   1017	7	9	localException4	java.lang.Exception
    //   1030	11	9	localException5	java.lang.Exception
    //   1	812	10	localObject10	Object
    //   978	33	10	localException6	java.lang.Exception
    //   1034	15	10	localObject11	Object
    //   4	820	11	localObject12	Object
    //   150	367	12	str	String
    // Exception table:
    //   from	to	target	type
    //   73	87	639	java/lang/OutOfMemoryError
    //   258	268	645	java/lang/OutOfMemoryError
    //   656	664	676	java/io/IOException
    //   668	676	676	java/io/IOException
    //   682	694	697	java/lang/OutOfMemoryError
    //   708	716	728	java/io/IOException
    //   720	728	728	java/io/IOException
    //   434	439	734	java/io/IOException
    //   452	457	734	java/io/IOException
    //   152	213	752	java/lang/Exception
    //   213	258	752	java/lang/Exception
    //   258	268	752	java/lang/Exception
    //   272	316	752	java/lang/Exception
    //   325	343	752	java/lang/Exception
    //   647	652	752	java/lang/Exception
    //   682	694	752	java/lang/Exception
    //   699	704	752	java/lang/Exception
    //   767	772	801	java/io/IOException
    //   785	790	801	java/io/IOException
    //   152	213	819	finally
    //   213	258	819	finally
    //   258	268	819	finally
    //   272	316	819	finally
    //   325	343	819	finally
    //   647	652	819	finally
    //   682	694	819	finally
    //   699	704	819	finally
    //   832	837	849	java/io/IOException
    //   842	847	849	java/io/IOException
    //   567	572	859	java/io/IOException
    //   577	582	859	java/io/IOException
    //   472	490	867	java/lang/Exception
    //   882	887	898	java/io/IOException
    //   891	895	898	java/io/IOException
    //   472	490	906	finally
    //   916	921	933	java/io/IOException
    //   926	931	933	java/io/IOException
    //   490	501	943	finally
    //   501	557	947	finally
    //   557	562	947	finally
    //   872	877	955	finally
    //   490	501	966	java/lang/Exception
    //   501	557	978	java/lang/Exception
    //   557	562	978	java/lang/Exception
    //   343	354	994	finally
    //   354	373	1001	finally
    //   378	420	1001	finally
    //   420	425	1001	finally
    //   757	762	1005	finally
    //   343	354	1017	java/lang/Exception
    //   354	373	1030	java/lang/Exception
    //   378	420	1030	java/lang/Exception
    //   420	425	1030	java/lang/Exception
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
          if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_c_of_type_Int != 0)
          {
            localObject2 = localBitmap;
            localObject1 = localBitmap;
            if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_c_of_type_Int % 90 == 0)
            {
              localObject1 = localBitmap;
              if (QLog.isColorLevel())
              {
                localObject1 = localBitmap;
                QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "load bitmap has exif rotate " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_c_of_type_Int);
              }
              localObject1 = localBitmap;
              int i = localBitmap.getWidth();
              localObject1 = localBitmap;
              int j = localBitmap.getHeight();
              localObject1 = localBitmap;
              localObject2 = new Matrix();
              localObject1 = localBitmap;
              ((Matrix)localObject2).postRotate(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_c_of_type_Int, i / 2.0F, j / 2.0F);
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
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a((Bitmap)localObject2, true);
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
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a((Bitmap)localObject1, true);
      }
    }
    for (;;)
    {
      this.jdField_f_of_type_JavaLangString = "";
      this.jdField_e_of_type_Boolean = true;
      break label337;
      label477:
      break;
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().copy(a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()), true);
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
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_Int == 12)
    {
      if (a(this.jdField_b_of_type_Int))
      {
        a(false);
        a(this.jdField_b_of_type_Int, true);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
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
      ReportController.b(null, "dc00898", "", "", "0X8007550", "0X8007550", 0, 0, "", "", "", "");
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
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Aoba.jdField_c_of_type_Int;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.b();
    ReportController.b(null, "dc00898", "", "", "0X800754F", "0X800754F", 0, 0, "", "", "", "");
  }
  
  public boolean b()
  {
    return (this.jdField_b_of_type_Boolean) || (!this.jdField_e_of_type_Boolean);
  }
  
  public void c()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.a();
    this.jdField_a_of_type_Aobc.removeCallbacksAndMessages(null);
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
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_Aobc.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Aobc = null;
    if (this.jdField_c_of_type_Boolean) {
      QIPCClientHelper.getInstance().callServer("ArtFilterModule", "action_exit_art_filter", null, null);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131365547: 
      do
      {
        return;
      } while (!a(this.jdField_b_of_type_Int));
      a(false);
      a(this.jdField_b_of_type_Int, true);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (a(paramInt))
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3) {
        LpReportInfo_pf00064.report(615, 7);
      }
      a(false);
      a(paramInt, false);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (paramView.getId() == 2131365549))
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
    //   1: getfield 675	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4: invokestatic 468	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +237 -> 244
    //   10: new 271	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 676	java/util/ArrayList:<init>	()V
    //   17: astore_2
    //   18: new 678	org/json/JSONArray
    //   21: dup
    //   22: aload_0
    //   23: getfield 675	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   26: invokespecial 679	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   29: astore_3
    //   30: iconst_0
    //   31: istore_1
    //   32: iload_1
    //   33: aload_3
    //   34: invokevirtual 682	org/json/JSONArray:length	()I
    //   37: if_icmpge +71 -> 108
    //   40: aload_3
    //   41: iload_1
    //   42: invokevirtual 686	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   45: astore 4
    //   47: aload_2
    //   48: new 347	com/tencent/biz/qqstory/takevideo/artfilter/FilterTemplate
    //   51: dup
    //   52: aload 4
    //   54: ldc_w 688
    //   57: invokevirtual 694	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   60: aload 4
    //   62: ldc_w 696
    //   65: invokevirtual 699	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   68: aload 4
    //   70: ldc_w 701
    //   73: invokevirtual 694	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   76: aload 4
    //   78: ldc_w 703
    //   81: invokevirtual 699	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   84: aload 4
    //   86: ldc_w 705
    //   89: invokevirtual 699	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   92: invokespecial 708	com/tencent/biz/qqstory/takevideo/artfilter/FilterTemplate:<init>	(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   95: invokeinterface 711 2 0
    //   100: pop
    //   101: iload_1
    //   102: iconst_1
    //   103: iadd
    //   104: istore_1
    //   105: goto -73 -> 32
    //   108: aload_2
    //   109: invokeinterface 715 1 0
    //   114: astore_3
    //   115: aload_3
    //   116: invokeinterface 720 1 0
    //   121: ifeq +132 -> 253
    //   124: new 359	java/io/File
    //   127: dup
    //   128: aload_3
    //   129: invokeinterface 724 1 0
    //   134: checkcast 347	com/tencent/biz/qqstory/takevideo/artfilter/FilterTemplate
    //   137: getfield 725	com/tencent/biz/qqstory/takevideo/artfilter/FilterTemplate:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   140: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   143: astore 4
    //   145: aload 4
    //   147: invokevirtual 365	java/io/File:exists	()Z
    //   150: ifeq +11 -> 161
    //   153: aload 4
    //   155: invokevirtual 728	java/io/File:isFile	()Z
    //   158: ifne -43 -> 115
    //   161: aload_3
    //   162: invokeinterface 731 1 0
    //   167: goto -52 -> 115
    //   170: astore_3
    //   171: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +13 -> 187
    //   177: ldc_w 300
    //   180: iconst_2
    //   181: ldc_w 733
    //   184: invokestatic 585	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +35 -> 225
    //   193: ldc_w 300
    //   196: iconst_2
    //   197: new 38	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 735
    //   207: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_2
    //   211: invokeinterface 738 1 0
    //   216: invokevirtual 278	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload_0
    //   226: getfield 113	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_Aoba	Laoba;
    //   229: aload_2
    //   230: invokevirtual 741	aoba:a	(Ljava/util/List;)V
    //   233: aload_0
    //   234: getfield 206	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_ComTencentWidgetHorizontalListView	Lcom/tencent/widget/HorizontalListView;
    //   237: aload_0
    //   238: getfield 113	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_Aoba	Laoba;
    //   241: invokevirtual 745	com/tencent/widget/HorizontalListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   244: aload_0
    //   245: getfield 206	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_ComTencentWidgetHorizontalListView	Lcom/tencent/widget/HorizontalListView;
    //   248: aload_0
    //   249: invokevirtual 210	com/tencent/widget/HorizontalListView:setOnItemClickListener	(Landroid/widget/AdapterView$OnItemClickListener;)V
    //   252: return
    //   253: aload_2
    //   254: invokestatic 750	java/util/Collections:sort	(Ljava/util/List;)V
    //   257: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq +35 -> 295
    //   263: ldc_w 300
    //   266: iconst_2
    //   267: new 38	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   274: ldc_w 735
    //   277: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_2
    //   281: invokeinterface 738 1 0
    //   286: invokevirtual 278	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   289: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: aload_0
    //   296: getfield 113	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_Aoba	Laoba;
    //   299: aload_2
    //   300: invokevirtual 741	aoba:a	(Ljava/util/List;)V
    //   303: goto -70 -> 233
    //   306: astore_3
    //   307: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq +35 -> 345
    //   313: ldc_w 300
    //   316: iconst_2
    //   317: new 38	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 735
    //   327: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_2
    //   331: invokeinterface 738 1 0
    //   336: invokevirtual 278	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   339: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: aload_0
    //   346: getfield 113	dov/com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_Aoba	Laoba;
    //   349: aload_2
    //   350: invokevirtual 741	aoba:a	(Ljava/util/List;)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter
 * JD-Core Version:    0.7.0.1
 */