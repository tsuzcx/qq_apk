package com.tencent.mobileqq.troop.widget;

import ajyz;
import ajzb;
import ajzc;
import ajzd;
import ajzf;
import ajzh;
import ajzi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.utils.UITools;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopUploadingTask;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.UploadItem;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.GridView;
import cooperation.zebra.ZebraPluginProxy;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import java.util.Set;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.util.WeakReference;

public class AvatarWallAdapter
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public static Uri a;
  public static String a;
  public static int g;
  protected static int j;
  protected int a;
  public Bitmap a;
  public Handler a;
  public SparseArray a;
  public QQAppInterface a;
  public TroopAvatarManger a;
  protected AvatarWallAdapter.AddButtonStatusListener a;
  public FaceDecoder a;
  public GridView a;
  protected List a;
  Observer a;
  public WeakReference a;
  protected boolean a;
  public int[] a;
  protected String[] a;
  public int b;
  protected Handler b;
  public String b;
  protected boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public boolean d;
  protected int e;
  protected boolean e;
  public int f;
  protected boolean f;
  public boolean g;
  public int h;
  public boolean h;
  protected final int i;
  public boolean i;
  protected boolean j;
  
  static
  {
    jdField_a_of_type_JavaLangString = "AvatarWallAdapter";
    jdField_j_of_type_Int = 7;
  }
  
  public AvatarWallAdapter(WeakReference paramWeakReference, GridView paramGridView, QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean1, Handler paramHandler, boolean paramBoolean2, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_h_of_type_Boolean = true;
    this.jdField_e_of_type_Int = 2;
    this.jdField_f_of_type_Int = 6;
    this.jdField_a_of_type_JavaUtilObserver = new ajyz(this);
    this.jdField_i_of_type_Int = 10;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeakReference;
    this.jdField_a_of_type_ComTencentWidgetGridView = paramGridView;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_e_of_type_Boolean = paramBoolean1;
    a(paramBoolean2);
    if ((paramWeakReference == null) || (paramWeakReference.get() == null) || (paramQQAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "AvatarWallAdapter Construct error, Activity or QQAppInterface is null !!!!");
      }
      throw new NullPointerException("AvatarWallAdapter Construct error, Activity or QQAppInterface is null !!!!");
    }
    paramWeakReference = (Activity)paramWeakReference.get();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramWeakReference, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    paramQQAppInterface = paramWeakReference.getResources();
    paramString1 = new DisplayMetrics();
    paramWeakReference.getWindowManager().getDefaultDisplay().getMetrics(paramString1);
    int k = paramQQAppInterface.getDimensionPixelSize(2131558788);
    this.jdField_c_of_type_Int = ((paramString1.widthPixels - paramQQAppInterface.getDimensionPixelSize(2131558789) * 2 - k * 3) / 4);
    paramGridView.setColumnWidth(this.jdField_c_of_type_Int);
    paramGridView.setVerticalSpacing(k);
    paramGridView.setHorizontalSpacing(k);
    paramWeakReference = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger = new TroopAvatarManger(this.jdField_b_of_type_JavaLangString, TroopUploadingTask.class, paramWeakReference);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(this.jdField_a_of_type_JavaUtilObserver);
    paramGridView.setAdapter(this);
  }
  
  public static int a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {}
    for (;;)
    {
      return -1;
      Object localObject = new File(paramString1);
      BitmapFactory.Options localOptions = ImageUtil.a(((File)localObject).getPath(), 100);
      try
      {
        localObject = ImageUtil.a(((File)localObject).getPath(), localOptions);
        paramString2 = new File(paramString2);
        if (paramString2.exists()) {
          return 0;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        paramString1.printStackTrace();
        return -1;
      }
      try
      {
        int k = TroopUtils.a(paramString1);
        paramString1 = (String)localObject;
        if (k != 0) {
          paramString1 = ImageUtil.b((Bitmap)localObject, k);
        }
        if (paramString1 != null)
        {
          ImageUtil.a(paramString1, paramString2);
          return 0;
        }
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return -1;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    if (paramInt == 1) {
      return paramContext.getString(2131430220);
    }
    if (paramInt == 2) {
      return paramContext.getString(2131430221);
    }
    if (paramInt == 3) {
      return paramContext.getString(2131430222);
    }
    if (paramInt == 5) {
      return paramContext.getString(2131430223);
    }
    if (paramInt == 100) {
      return paramContext.getString(2131430235);
    }
    if (paramInt == 101) {
      return paramContext.getString(2131430236);
    }
    if (paramInt == 102) {
      return paramContext.getString(2131430230);
    }
    if (paramInt == 103) {
      return paramContext.getString(2131430237);
    }
    return paramContext.getString(2131430219);
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList);
    localBundle.putInt("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("PhotoConst.IS_SINGLE_MODE", bool);
      localBundle.putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
      localBundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localBundle.putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      paramActivity.overridePendingTransition(2131034123, 2131034121);
      ZebraPluginProxy.startPhotoList(paramActivity, localBundle);
      return;
    }
  }
  
  /* Error */
  public static int b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: iconst_0
    //   7: istore_2
    //   8: new 325	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 326	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: astore_0
    //   17: new 328	java/io/FileOutputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 329	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   25: astore 4
    //   27: sipush 8192
    //   30: newarray byte
    //   32: astore_1
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 335	java/io/InputStream:read	([B)I
    //   38: istore_3
    //   39: iload_3
    //   40: ifle +44 -> 84
    //   43: aload 4
    //   45: aload_1
    //   46: iconst_0
    //   47: iload_3
    //   48: invokevirtual 341	java/io/OutputStream:write	([BII)V
    //   51: goto -18 -> 33
    //   54: astore_1
    //   55: aload_0
    //   56: astore_1
    //   57: aload 4
    //   59: astore_0
    //   60: iconst_m1
    //   61: istore_3
    //   62: aload_1
    //   63: ifnull +7 -> 70
    //   66: aload_1
    //   67: invokevirtual 344	java/io/InputStream:close	()V
    //   70: iload_3
    //   71: istore_2
    //   72: aload_0
    //   73: ifnull +9 -> 82
    //   76: aload_0
    //   77: invokevirtual 345	java/io/OutputStream:close	()V
    //   80: iload_3
    //   81: istore_2
    //   82: iload_2
    //   83: ireturn
    //   84: aload_0
    //   85: ifnull +7 -> 92
    //   88: aload_0
    //   89: invokevirtual 344	java/io/InputStream:close	()V
    //   92: aload 4
    //   94: ifnull -12 -> 82
    //   97: aload 4
    //   99: invokevirtual 345	java/io/OutputStream:close	()V
    //   102: iconst_0
    //   103: ireturn
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   109: iconst_0
    //   110: ireturn
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   116: goto -24 -> 92
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   124: goto -54 -> 70
    //   127: astore_0
    //   128: aload_0
    //   129: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   132: iconst_m1
    //   133: ireturn
    //   134: astore_1
    //   135: aconst_null
    //   136: astore_0
    //   137: aload 5
    //   139: astore 4
    //   141: aload_0
    //   142: ifnull +7 -> 149
    //   145: aload_0
    //   146: invokevirtual 344	java/io/InputStream:close	()V
    //   149: aload 4
    //   151: ifnull +8 -> 159
    //   154: aload 4
    //   156: invokevirtual 345	java/io/OutputStream:close	()V
    //   159: aload_1
    //   160: athrow
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   166: goto -17 -> 149
    //   169: astore_0
    //   170: aload_0
    //   171: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   174: goto -15 -> 159
    //   177: astore_1
    //   178: aload 5
    //   180: astore 4
    //   182: goto -41 -> 141
    //   185: astore_1
    //   186: goto -45 -> 141
    //   189: astore_0
    //   190: aconst_null
    //   191: astore_0
    //   192: aload 4
    //   194: astore_1
    //   195: goto -135 -> 60
    //   198: astore_1
    //   199: aconst_null
    //   200: astore 4
    //   202: aload_0
    //   203: astore_1
    //   204: aload 4
    //   206: astore_0
    //   207: goto -147 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	paramString1	String
    //   0	210	1	paramString2	String
    //   7	76	2	k	int
    //   38	43	3	m	int
    //   4	201	4	localObject1	Object
    //   1	178	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   27	33	54	java/lang/Exception
    //   33	39	54	java/lang/Exception
    //   43	51	54	java/lang/Exception
    //   97	102	104	java/io/IOException
    //   88	92	111	java/io/IOException
    //   66	70	119	java/io/IOException
    //   76	80	127	java/io/IOException
    //   8	17	134	finally
    //   145	149	161	java/io/IOException
    //   154	159	169	java/io/IOException
    //   17	27	177	finally
    //   27	33	185	finally
    //   33	39	185	finally
    //   43	51	185	finally
    //   8	17	189	java/lang/Exception
    //   17	27	198	java/lang/Exception
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
      return ((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131558791);
    }
    return 0;
  }
  
  public AvatarWallAdapter.AvatarInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount()) && (paramInt >= 0)) {
      return (AvatarWallAdapter.AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  protected String a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramInt = 2131430224;
    }
    for (;;)
    {
      if (paramInt != -1) {
        if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
          break label81;
        }
      }
      label81:
      for (Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();; localActivity = null)
      {
        if (localActivity != null)
        {
          return localActivity.getString(paramInt);
          if (paramInt == 1)
          {
            paramInt = 2131430225;
            break;
          }
          if (paramInt < 4)
          {
            paramInt = 2131430226;
            break;
          }
          if (paramInt < 4) {
            break label86;
          }
          paramInt = 2131430227;
          break;
          return null;
        }
        return null;
      }
      label86:
      paramInt = -1;
    }
  }
  
  public ArrayList a(ArrayList paramArrayList, int paramInt, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, AccountObserver paramAccountObserver)
  {
    if (paramArrayList == null) {
      return null;
    }
    if ((paramInt == 2) || (paramInt == 3) || (paramInt == 4))
    {
      localObject = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, localOptions);
        if ((localOptions.outWidth < 100) || (localOptions.outHeight < 100)) {
          ((ArrayList)localObject).add(str);
        }
      }
      if (((ArrayList)localObject).size() > 0) {
        QQToast.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), 2131430586, 1).a();
      }
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramArrayList.remove((String)((Iterator)localObject).next());
      }
      if (paramArrayList.size() == 0) {
        return null;
      }
    }
    Object localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      b((String)((Iterator)localObject).next());
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_moredata", "upload_head", 0, 0, paramString1, "", "", "");
    }
    paramString1 = (AccountManager)paramQQAppInterface.getManager(0);
    localObject = TroopUtils.a(paramQQAppInterface);
    if (localObject == null)
    {
      paramString1.updateSKey(paramAccountObserver);
      return paramArrayList;
    }
    TroopUtils.a((String)localObject, paramQQAppInterface.getCurrentAccountUin(), paramString2, paramArrayList, this);
    return paramArrayList;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((TroopManager)localObject1).a(String.valueOf(this.jdField_b_of_type_JavaLangString));
      localObject2 = new TroopInfoData();
      ((TroopInfoData)localObject2).updateForTroopInfo((TroopInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    for (boolean bool = ((TroopInfoData)localObject2).isHideTroop();; bool = false)
    {
      if (bool) {
        if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
          break label149;
        }
      }
      label149:
      for (localObject1 = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();; localObject1 = null)
      {
        if (localObject1 != null) {
          localObject1 = ((Activity)localObject1).getString(2131430363);
        }
        for (;;)
        {
          if ((localObject1 != null) && (this.jdField_b_of_type_AndroidOsHandler != null))
          {
            localObject2 = new Message();
            ((Message)localObject2).what = 11;
            ((Message)localObject2).obj = localObject1;
            this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
          }
          return;
          localObject1 = a(this.jdField_b_of_type_Int, this.jdField_d_of_type_Boolean);
          continue;
          localObject1 = null;
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = a(paramInt2);
    if (localObject != null) {
      ((AvatarWallAdapter.AvatarInfo)localObject).jdField_a_of_type_Int = paramInt1;
    }
    paramInt1 -= this.jdField_h_of_type_Int;
    while (paramInt1 > 0)
    {
      localObject = this.jdField_a_of_type_AndroidOsHandler;
      ajzb localajzb = new ajzb(this, paramInt2);
      int k = g;
      g = k + 1;
      ((Handler)localObject).postDelayed(localajzb, k * 10);
      paramInt1 -= 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_d_of_type_Int <= 0) {}
    for (;;)
    {
      return;
      this.jdField_d_of_type_Int -= 1;
      Object localObject1 = a(paramInt1);
      if (localObject1 != null)
      {
        ((AvatarWallAdapter.AvatarInfo)localObject1).jdField_a_of_type_Boolean = false;
        ((AvatarWallAdapter.AvatarInfo)localObject1).d = "AVATAR_URL_STR";
        if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
          this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt1);
        }
        ((AvatarWallAdapter.AvatarInfo)localObject1).jdField_b_of_type_Boolean = false;
        Object localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_b_of_type_JavaLangString);
        if ((localObject2 != null) && ((((TroopInfo)localObject2).troopTypeExt == 2) || (((TroopInfo)localObject2).troopTypeExt == 4)) && (((TroopInfo)localObject2).isAdmin()))
        {
          ((AvatarWallAdapter.AvatarInfo)localObject1).jdField_b_of_type_Boolean = true;
          if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("has_shown_same_city_picture_uploaded_dialog", false)) && (this.jdField_a_of_type_MqqUtilWeakReference != null))
          {
            localObject2 = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
            if (localObject2 != null)
            {
              DialogUtil.a((Context)localObject2, 230, null, ((Activity)localObject2).getString(2131430239), null, ((Activity)localObject2).getString(2131430240), new DialogUtil.DialogOnClickAdapter(), null).show();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("has_shown_same_city_picture_uploaded_dialog", true).commit();
            }
          }
        }
        paramInt3 = 0x7FFFFFFF & paramInt3;
        if ((paramInt3 < 0) || (paramInt3 > 1))
        {
          this.jdField_i_of_type_Boolean = true;
          a(paramInt2, paramInt1, ((AvatarWallAdapter.AvatarInfo)localObject1).jdField_b_of_type_Boolean);
          notifyDataSetChanged();
          return;
        }
        if ((this.jdField_h_of_type_Boolean) && (paramInt3 >= 0) && (paramInt3 <= 1))
        {
          this.jdField_i_of_type_Boolean = true;
          if (this.jdField_a_of_type_MqqUtilWeakReference != null) {}
          for (localObject1 = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(); localObject1 != null; localObject1 = null)
          {
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(this.jdField_b_of_type_JavaLangString);
            return;
          }
        }
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    int k = 0;
    Object localObject2;
    String str;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AvatarWallAdapter.AvatarInfo)((Iterator)localObject1).next();
      if (localObject2 != null) {
        str = ((AvatarWallAdapter.AvatarInfo)localObject2).jdField_c_of_type_JavaLangString;
      }
    }
    label361:
    label363:
    for (;;)
    {
      try
      {
        m = Integer.parseInt(str);
        if ((str == null) || (m < 0)) {
          break label363;
        }
        if (((AvatarWallAdapter.AvatarInfo)localObject2).d.equals("AVATAR_URL_STR"))
        {
          localArrayList.add(str);
          if (((AvatarWallAdapter.AvatarInfo)localObject2).jdField_b_of_type_Boolean) {
            localHashSet.add(str);
          }
          if (!str.equals(String.valueOf(paramInt1))) {
            break label363;
          }
          k = 1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int m = -1;
        continue;
        if ((localArrayList.size() != 0) || (!((AvatarWallAdapter.AvatarInfo)localObject2).d.equals("SYSTEM_PHOTO"))) {
          continue;
        }
        localArrayList.add(str);
        continue;
      }
      if (k != 0) {
        b(paramInt2);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break label361;
        }
        localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if (localObject1 == null) {
          break;
        }
        localObject2 = ((TroopManager)localObject1).a(String.valueOf(this.jdField_b_of_type_JavaLangString));
        if ((localObject2 == null) || (localArrayList.size() <= 0)) {
          break;
        }
        ((TroopInfo)localObject2).mTroopPicList = localArrayList;
        ((TroopInfo)localObject2).mTroopVerifyingPics = localHashSet;
        ThreadManager.post(new ajzc(this, (TroopManager)localObject1, (TroopInfo)localObject2), 8, null, false);
        return;
        localObject1 = a(paramInt2);
        if (localObject1 == null) {
          break;
        }
        ((AvatarWallAdapter.AvatarInfo)localObject1).jdField_c_of_type_JavaLangString = String.valueOf(paramInt1);
        ((AvatarWallAdapter.AvatarInfo)localObject1).d = "AVATAR_URL_STR";
        ((AvatarWallAdapter.AvatarInfo)localObject1).jdField_a_of_type_Boolean = false;
        localArrayList.add(((AvatarWallAdapter.AvatarInfo)localObject1).jdField_c_of_type_JavaLangString);
        if (paramBoolean) {
          localHashSet.add(((AvatarWallAdapter.AvatarInfo)localObject1).jdField_c_of_type_JavaLangString);
        }
      }
      break;
    }
  }
  
  protected void a(AvatarWallAdapter.ViewHolder paramViewHolder, Context paramContext, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    BorderURLImageView localBorderURLImageView = paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetBorderURLImageView;
    localBorderURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    ImageView localImageView;
    if (paramBoolean)
    {
      localBorderURLImageView.setBorderWidth(DisplayUtil.a(paramContext, 2.0F));
      localBorderURLImageView.setBorderColor(paramContext.getResources().getColor(2131493079));
      localImageView = paramViewHolder.jdField_a_of_type_AndroidWidgetImageView;
      localImageView.setVisibility(8);
      if (paramInt1 != 1) {
        break label184;
      }
      if (localBorderURLImageView.getDrawable() != null) {
        localBorderURLImageView.setImageDrawable(null);
      }
      paramString = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
      paramViewHolder = paramString;
      if (paramString == null) {
        paramViewHolder = new FrameLayout.LayoutParams(this.jdField_c_of_type_Int, this.jdField_c_of_type_Int);
      }
      paramViewHolder.gravity = 17;
      if (this.jdField_e_of_type_Int != 1) {
        break label154;
      }
      localImageView.setBackgroundResource(2130841532);
      label132:
      localImageView.setLayoutParams(paramViewHolder);
      localImageView.setVisibility(0);
    }
    label154:
    label184:
    label343:
    label370:
    do
    {
      do
      {
        for (;;)
        {
          return;
          localBorderURLImageView.setBorderWidth(0);
          break;
          localImageView.setBackgroundResource(2130841531);
          paramInt1 = (int)UITools.a(paramContext, 30.0F);
          paramViewHolder.width = paramInt1;
          paramViewHolder.height = paramInt1;
          break label132;
          if (paramInt1 == 0)
          {
            if (paramString == null) {
              continue;
            }
            try
            {
              paramViewHolder = URLDrawable.getDrawable(NearbyImgDownloader.a(paramString));
              paramViewHolder.setTag(URLDrawableDecodeHandler.a(this.jdField_c_of_type_Int, this.jdField_c_of_type_Int, this.jdField_f_of_type_Int));
              paramViewHolder.setDecodeHandler(URLDrawableDecodeHandler.b);
              localBorderURLImageView.setImageDrawable(paramViewHolder);
              return;
            }
            catch (MalformedURLException paramViewHolder)
            {
              return;
            }
          }
          if (paramInt1 != 2) {
            break label370;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "viewFactory: AVATAR_LOCAL, path=" + paramString);
          }
          if (paramString != null) {
            try
            {
              paramViewHolder = a(paramInt2);
              if (paramViewHolder != null)
              {
                if (paramViewHolder.jdField_a_of_type_AndroidGraphicsBitmap != null) {
                  break label343;
                }
                ThreadManager.post(new ajzd(this, paramString, this.jdField_c_of_type_Int, paramViewHolder, localBorderURLImageView), 8, null, true);
                return;
              }
            }
            catch (OutOfMemoryError paramViewHolder) {}
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, paramViewHolder.getMessage());
      return;
      if (!paramViewHolder.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())
      {
        localBorderURLImageView.setImageBitmap(paramViewHolder.jdField_a_of_type_AndroidGraphicsBitmap);
        return;
      }
      localBorderURLImageView.setImageDrawable(null);
      return;
    } while (paramInt1 != 3);
    ThreadManager.post(new ajzf(this, localBorderURLImageView, paramString), 8, null, false);
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    } while (localActivity == null);
    QQToast.a(localActivity, paramString, 1).b(b());
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_d_of_type_Int <= 0) {
      return;
    }
    this.jdField_d_of_type_Int -= 1;
    if (!a(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(this.jdField_b_of_type_JavaLangString);
      this.jdField_d_of_type_Boolean = false;
      a();
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    }
    b(paramInt);
    a(paramString);
  }
  
  public void a(ArrayList paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    if ((paramArrayList == null) || (paramString1 == null) || (paramString3 == null)) {
      return;
    }
    this.jdField_d_of_type_Int += paramArrayList.size();
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(TroopUploadingThread.class, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList, paramString1, paramString2, paramString3, null);
    a();
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if (this.jdField_f_of_type_Boolean) {
      return;
    }
    Object localObject = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
    ((Message)localObject).what = 14;
    this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    int k;
    if (paramBoolean)
    {
      localObject = new AvatarWallAdapter.AvatarInfo();
      ((AvatarWallAdapter.AvatarInfo)localObject).d = "SYSTEM_PHOTO";
      ((AvatarWallAdapter.AvatarInfo)localObject).jdField_c_of_type_JavaLangString = AvatarWallAdapter.AvatarInfo.jdField_a_of_type_JavaLangString;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      this.jdField_a_of_type_JavaUtilList = localArrayList;
      this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
      a(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_Int);
      k = 0;
    }
    for (;;)
    {
      label116:
      int m;
      label129:
      int n;
      label190:
      int i1;
      if ((!paramBoolean) && (k == 0))
      {
        m = 0;
        k = 0;
        if (m < this.jdField_b_of_type_Int)
        {
          localObject = (AvatarWallAdapter.AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(m);
          n = k;
          if (localObject == null) {
            break label412;
          }
          if ((!((AvatarWallAdapter.AvatarInfo)localObject).jdField_a_of_type_Boolean) || (((AvatarWallAdapter.AvatarInfo)localObject).d.equals("AVATAR_URL_STR"))) {
            break label407;
          }
        }
        m = 0;
        n = 0;
        if (m < paramList.size())
        {
          localObject = (AvatarWallAdapter.AvatarInfo)paramList.get(m);
          i1 = n;
          if (localObject == null) {
            break label430;
          }
          if ((!((AvatarWallAdapter.AvatarInfo)localObject).jdField_a_of_type_Boolean) || (((AvatarWallAdapter.AvatarInfo)localObject).d.equals("AVATAR_URL_STR"))) {
            break label424;
          }
        }
        if (a(this.jdField_a_of_type_JavaUtilList, paramList, k, n)) {
          break label443;
        }
        paramList = new ArrayList(this.jdField_a_of_type_JavaUtilList.subList(0, k));
        if (!a(paramList, k)) {
          break;
        }
        this.jdField_a_of_type_JavaUtilList = paramList;
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
        c();
        if (this.jdField_c_of_type_Boolean) {
          a();
        }
        notifyDataSetChanged();
        paramList = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
        paramList.what = 14;
        this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramList);
        return;
        if (paramList == null) {
          break;
        }
        if ((this.jdField_b_of_type_Int <= getCount()) && (this.jdField_a_of_type_JavaUtilList != null)) {
          break label462;
        }
        this.jdField_a_of_type_JavaUtilList = paramList;
        this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
        a(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_Int);
        k = 1;
        break label116;
        label407:
        n = k + 1;
        label412:
        m += 1;
        k = n;
        break label129;
        label424:
        i1 = n + 1;
        label430:
        m += 1;
        n = i1;
        break label190;
        label443:
        this.jdField_a_of_type_JavaUtilList = paramList;
        a(this.jdField_a_of_type_JavaUtilList, n);
      }
      label462:
      k = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  protected void a(int[] paramArrayOfInt, Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      this.jdField_a_of_type_ArrayOfJavaLangString = paramActivity.getResources().getStringArray(2131296278);
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramActivity, null);
    int k = 0;
    if (k < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[k] == 16) {
        localActionSheet.d(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[k]]);
      }
      for (;;)
      {
        k += 1;
        break;
        if ((paramArrayOfInt[k] >= 0) && (paramArrayOfInt[k] < this.jdField_a_of_type_ArrayOfJavaLangString.length)) {
          localActionSheet.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[k]], 1);
        }
      }
    }
    localActionSheet.a(new ajzh(this, paramActivity, localActionSheet));
    localActionSheet.show();
  }
  
  public boolean a(int paramInt)
  {
    AvatarWallAdapter.AvatarInfo localAvatarInfo = a(paramInt);
    if (localAvatarInfo != null) {
      return localAvatarInfo.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_d_of_type_Int != 0;
  }
  
  protected boolean a(List paramList, int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 8)) {
      return false;
    }
    int k;
    Object localObject;
    Iterator localIterator;
    if (paramInt == 8)
    {
      k = 1;
      localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList();
      }
      paramList = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a();
      if (paramList != null) {
        localIterator = paramList.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label170;
        }
        UploadItem localUploadItem = (UploadItem)localIterator.next();
        if (localUploadItem != null)
        {
          if (paramInt == 8) {
            k = 1;
          }
          if (k == 0)
          {
            AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
            localAvatarInfo.jdField_b_of_type_JavaLangString = localUploadItem.jdField_a_of_type_JavaLangString;
            localAvatarInfo.jdField_a_of_type_Int = localUploadItem.jdField_a_of_type_Int;
            localAvatarInfo.d = "AVATAR_LOCAL_STR";
            localAvatarInfo.jdField_a_of_type_Boolean = true;
            ((List)localObject).add(paramInt, localAvatarInfo);
            paramInt += 1;
            continue;
            k = 0;
            break;
          }
          localIterator.remove();
        }
      }
      label170:
      this.jdField_d_of_type_Int = paramList.size();
    }
    return paramList != null;
  }
  
  protected boolean a(List paramList1, List paramList2, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2) {
      return true;
    }
    paramInt2 = 0;
    while (paramInt2 < paramInt1)
    {
      AvatarWallAdapter.AvatarInfo localAvatarInfo1 = (AvatarWallAdapter.AvatarInfo)paramList1.get(paramInt2);
      AvatarWallAdapter.AvatarInfo localAvatarInfo2 = (AvatarWallAdapter.AvatarInfo)paramList2.get(paramInt2);
      String str1;
      String str2;
      if (localAvatarInfo1 != null)
      {
        str1 = localAvatarInfo1.jdField_c_of_type_JavaLangString;
        if (localAvatarInfo2 != null)
        {
          str2 = localAvatarInfo2.jdField_c_of_type_JavaLangString;
          if (str1 != null) {
            break label78;
          }
          return true;
        }
      }
      else
      {
        return true;
      }
      return false;
      label78:
      if (((str2 != null) && (!str2.equals(str1))) || (localAvatarInfo1.jdField_b_of_type_Boolean != localAvatarInfo2.jdField_b_of_type_Boolean)) {
        return true;
      }
      paramInt2 += 1;
    }
    return false;
  }
  
  protected int b()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
      return 0;
    }
    Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localActivity != null) {
      return localActivity.getResources().getDimensionPixelSize(2131558448);
    }
    return 0;
  }
  
  public void b()
  {
    this.jdField_f_of_type_Boolean = true;
    int k = 0;
    while (k < this.jdField_b_of_type_Int)
    {
      AvatarWallAdapter.AvatarInfo localAvatarInfo = a(k);
      if ((localAvatarInfo != null) && (localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      k += 1;
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.b(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a();
    this.jdField_a_of_type_JavaUtilObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_AndroidOsHandler = null;
    this.jdField_b_of_type_Int = 0;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    AvatarWallAdapter.AvatarInfo localAvatarInfo;
    do
    {
      return;
      localAvatarInfo = a(paramInt);
    } while (localAvatarInfo == null);
    if ((localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AddButtonStatusListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AddButtonStatusListener.a(false);
    }
    for (;;)
    {
      this.jdField_b_of_type_Int -= 1;
      if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 4)) {
        a();
      }
      notifyDataSetChanged();
      return;
      localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
      if (this.jdField_b_of_type_Int == 8)
      {
        localAvatarInfo.d = "PLUS";
        this.jdField_a_of_type_JavaUtilList.add(localAvatarInfo);
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt2;
    AvatarWallAdapter.AvatarInfo localAvatarInfo = a(paramInt1);
    if (localAvatarInfo != null)
    {
      if (paramInt1 >= paramInt2) {
        break label57;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramInt2 + 1, (AvatarWallAdapter.AvatarInfo)localAvatarInfo);
      this.jdField_a_of_type_JavaUtilList.remove(paramInt1);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      notifyDataSetChanged();
      return;
      label57:
      this.jdField_a_of_type_JavaUtilList.add(paramInt2, (AvatarWallAdapter.AvatarInfo)localAvatarInfo);
      this.jdField_a_of_type_JavaUtilList.remove(paramInt1 + 1);
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_f_of_type_Boolean) {}
    while (paramString == null) {
      return;
    }
    AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
    localAvatarInfo.jdField_b_of_type_JavaLangString = paramString;
    localAvatarInfo.d = "AVATAR_LOCAL_STR";
    localAvatarInfo.jdField_a_of_type_Boolean = true;
    localAvatarInfo.jdField_c_of_type_JavaLangString = "-1";
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_Int, localAvatarInfo);
    this.jdField_b_of_type_Int += 1;
    if ((this.jdField_b_of_type_Int == 8) && (this.jdField_a_of_type_JavaUtilList.size() == 9)) {
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_b_of_type_Int);
    }
    notifyDataSetChanged();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  protected void c()
  {
    if ((this.jdField_b_of_type_Int >= 0) && (this.jdField_b_of_type_Int < 8)) {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        k = this.jdField_a_of_type_JavaUtilList.size() - 1;
        while (k >= 0)
        {
          localAvatarInfo = (AvatarWallAdapter.AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(k);
          if ((localAvatarInfo != null) && (localAvatarInfo.d.equals("PLUS"))) {
            this.jdField_a_of_type_JavaUtilList.remove(localAvatarInfo);
          }
          k -= 1;
        }
        this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AddButtonStatusListener == null) {
          break label119;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AddButtonStatusListener.a(false);
      }
    }
    label119:
    while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AddButtonStatusListener == null)
    {
      AvatarWallAdapter.AvatarInfo localAvatarInfo;
      do
      {
        int k;
        return;
        localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
      } while ((!this.jdField_c_of_type_Boolean) || (!this.jdField_j_of_type_Boolean));
      localAvatarInfo.d = "PLUS";
      this.jdField_a_of_type_JavaUtilList.add(localAvatarInfo);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AddButtonStatusListener.a(false);
  }
  
  public void c(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < getCount()))
    {
      b(paramInt, 0);
      d();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void d()
  {
    if (this.jdField_f_of_type_Boolean) {}
    while (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        AvatarWallAdapter.AvatarInfo localAvatarInfo = (AvatarWallAdapter.AvatarInfo)localIterator.next();
        if ((localAvatarInfo == null) || (!localAvatarInfo.d.equals("AVATAR_URL_STR"))) {
          continue;
        }
        try
        {
          k = Integer.parseInt(localAvatarInfo.jdField_c_of_type_JavaLangString);
          localArrayList.add(Integer.valueOf(k));
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            int m = -1;
            int k = m;
            if (QLog.isColorLevel())
            {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "seqNum is error");
              k = m;
            }
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(this.jdField_b_of_type_JavaLangString, 0, localArrayList);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", this.jdField_c_of_type_JavaLangString, "drag_head", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
  }
  
  public void d(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams;
    if (paramInt != this.jdField_a_of_type_ComTencentWidgetGridView.c())
    {
      localLayoutParams = this.jdField_a_of_type_ComTencentWidgetGridView.getLayoutParams();
      localLayoutParams.width = (this.jdField_a_of_type_ComTencentWidgetGridView.e() * paramInt + (paramInt - 1) * this.jdField_a_of_type_ComTencentWidgetGridView.c_() + this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingLeft() + this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingRight());
      localLayoutParams.height = -2;
      if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        break label123;
      }
      ((RelativeLayout.LayoutParams)localLayoutParams).addRule(14);
      if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
        break label141;
      }
    }
    label141:
    for (Activity localActivity = null;; localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get())
    {
      if ((localActivity == null) || (Thread.currentThread() == localActivity.getMainLooper().getThread())) {
        break label155;
      }
      localActivity.runOnUiThread(new ajzi(this, paramInt, localLayoutParams));
      return;
      label123:
      if (!(localLayoutParams instanceof LinearLayout.LayoutParams)) {
        break;
      }
      ((LinearLayout.LayoutParams)localLayoutParams).gravity = 1;
      break;
    }
    label155:
    this.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(paramInt);
    this.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams(localLayoutParams);
  }
  
  public void d(boolean paramBoolean)
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    QQCustomDialog localQQCustomDialog = DialogUtil.a(localActivity, 230);
    localQQCustomDialog.setTitle(null);
    if (paramBoolean) {
      localQQCustomDialog.setMessage(localActivity.getResources().getString(2131435766));
    }
    for (;;)
    {
      localQQCustomDialog.setPositiveButton(localActivity.getResources().getString(2131430558), new DialogUtil.DialogOnClickAdapter());
      localQQCustomDialog.setPositiveButtonContentDescription(localActivity.getResources().getString(2131430558));
      localQQCustomDialog.show();
      return;
      localQQCustomDialog.setMessage(localActivity.getResources().getString(2131435765));
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ArrayOfInt == null) {
      this.jdField_a_of_type_ArrayOfInt = new int[jdField_j_of_type_Int];
    }
    this.jdField_a_of_type_ArrayOfInt[0] = 13;
    this.jdField_a_of_type_ArrayOfInt[1] = 14;
    this.jdField_a_of_type_ArrayOfInt[2] = 16;
    int k = 3;
    while (k < jdField_j_of_type_Int)
    {
      this.jdField_a_of_type_ArrayOfInt[k] = -1;
      k += 1;
    }
    a(this.jdField_a_of_type_ArrayOfInt, (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get());
  }
  
  public void e(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public int getCount()
  {
    int m = 4;
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int k = this.jdField_a_of_type_JavaUtilList.size();; k = 0)
    {
      if (k < 4) {
        m = k;
      }
      d(m);
      return k;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {}
    for (Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();; localActivity = null)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        if (localActivity != null) {}
      }
      int k;
      AvatarWallAdapter.AvatarInfo localAvatarInfo;
      do
      {
        return paramView;
        paramViewGroup = LayoutInflater.from(localActivity).inflate(2130969424, null);
        k = -1;
        localAvatarInfo = a(paramInt);
        paramView = paramViewGroup;
      } while (localAvatarInfo == null);
      Object localObject2 = localAvatarInfo.d;
      if (((String)localObject2).equals("PLUS"))
      {
        k = 1;
        paramView = (View)localObject1;
        if (paramViewGroup.getTag() != null) {
          break label601;
        }
        localObject2 = new AvatarWallAdapter.ViewHolder(this);
        ((AvatarWallAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131366463));
        ((AvatarWallAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131361845));
        if (localActivity == null) {}
      }
      for (;;)
      {
        try
        {
          ((AvatarWallAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(localActivity.getResources().getDrawable(2130841304));
          ((AvatarWallAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqTroopWidgetBorderURLImageView = ((BorderURLImageView)paramViewGroup.findViewById(2131362772));
          localObject1 = (AbsListView.LayoutParams)paramViewGroup.getLayoutParams();
          if (localObject1 == null)
          {
            localObject1 = new AbsListView.LayoutParams(this.jdField_c_of_type_Int, this.jdField_c_of_type_Int);
            paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            paramViewGroup.setTag(localObject2);
            localObject1 = localObject2;
            if (localActivity != null)
            {
              paramViewGroup.setContentDescription("图片" + paramInt);
              if (k == 1) {
                paramViewGroup.setContentDescription("上传头像");
              }
              a((AvatarWallAdapter.ViewHolder)localObject1, localActivity, k, paramView, paramInt, localAvatarInfo.jdField_c_of_type_Boolean);
            }
            paramView = ((AvatarWallAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar;
            if (!localAvatarInfo.jdField_a_of_type_Boolean) {
              break label613;
            }
            if (paramView.getVisibility() != 0) {
              paramView.setVisibility(0);
            }
            paramView.setProgress(localAvatarInfo.jdField_a_of_type_Int);
            this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
            paramView.setProgress(100);
            if (!localAvatarInfo.jdField_b_of_type_Boolean) {
              break label622;
            }
            if (((AvatarWallAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView == null)
            {
              ((AvatarWallAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView = ((ViewStub)paramViewGroup.findViewById(2131366464)).inflate();
              paramViewGroup.setTag(localObject1);
            }
            ((AvatarWallAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
            if ((!this.jdField_a_of_type_Boolean) || (paramInt != this.jdField_a_of_type_Int) || (this.jdField_b_of_type_Boolean)) {
              break label643;
            }
            paramViewGroup.setVisibility(8);
            return paramViewGroup;
            if ((((String)localObject2).equals("AVATAR_URL_STR")) && ((localAvatarInfo.jdField_b_of_type_JavaLangString == null) || (!new File(localAvatarInfo.jdField_b_of_type_JavaLangString).exists())))
            {
              paramView = AvatarTroopUtil.a(AvatarTroopUtil.a(localAvatarInfo.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 1));
              k = 0;
              break;
            }
            if ((((String)localObject2).equals("AVATAR_LOCAL_STR")) || ((localAvatarInfo.jdField_b_of_type_JavaLangString != null) && (new File(localAvatarInfo.jdField_b_of_type_JavaLangString).exists())))
            {
              paramView = localAvatarInfo.jdField_b_of_type_JavaLangString;
              k = 2;
              break;
            }
            paramView = (View)localObject1;
            if (!((String)localObject2).equals("SYSTEM_PHOTO")) {
              break;
            }
            paramView = AvatarTroopUtil.a(AvatarTroopUtil.a(localAvatarInfo.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 0));
            k = 3;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 2, localOutOfMemoryError, new Object[0]);
          continue;
          localOutOfMemoryError.height = this.jdField_c_of_type_Int;
          localOutOfMemoryError.width = this.jdField_c_of_type_Int;
          continue;
        }
        label601:
        AvatarWallAdapter.ViewHolder localViewHolder = (AvatarWallAdapter.ViewHolder)paramViewGroup.getTag();
        continue;
        label613:
        paramView.setVisibility(8);
        continue;
        label622:
        if (localViewHolder.jdField_a_of_type_AndroidViewView != null) {
          localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
      }
      label643:
      paramViewGroup.setVisibility(0);
      return paramViewGroup;
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarWallAdapter
 * JD-Core Version:    0.7.0.1
 */