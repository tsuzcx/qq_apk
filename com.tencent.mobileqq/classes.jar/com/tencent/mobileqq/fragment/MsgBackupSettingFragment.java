package com.tencent.mobileqq.fragment;

import ahay;
import ajjy;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import apoi;
import apoj;
import apok;
import apol;
import apom;
import aroo;
import aroq;
import arpa;
import arpg;
import arpk;
import arpo;
import arpr;
import arpu;
import arpz;
import arqa;
import arrw;
import arsc;
import bace;
import bbms;
import bbmy;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity.sendPhotoTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupJniProxy;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;
import vlc;

public class MsgBackupSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public static int a;
  public static arpo a;
  public static String a;
  long jdField_a_of_type_Long;
  private aroo jdField_a_of_type_Aroo;
  private aroq jdField_a_of_type_Aroq = new apol(this);
  private arpk jdField_a_of_type_Arpk;
  private arpr jdField_a_of_type_Arpr;
  private arpu jdField_a_of_type_Arpu;
  private bbms jdField_a_of_type_Bbms;
  private MsgBackupEndPoint jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint;
  MsgBackupJniProxy jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int;
  private MsgBackupEndPoint jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint;
  private String jdField_b_of_type_JavaLangString;
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = ajjy.a(2131641125);
  private final int jdField_e_of_type_Int = 0;
  private String jdField_e_of_type_JavaLangString = ajjy.a(2131641142);
  private final int jdField_f_of_type_Int = 1;
  private String jdField_f_of_type_JavaLangString;
  private final int jdField_g_of_type_Int = 2;
  private String jdField_g_of_type_JavaLangString;
  private final int h = 3;
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof arpr))
    {
      paramObject = (arpr)paramObject;
      this.jdField_c_of_type_Int = paramObject.a();
      this.jdField_b_of_type_JavaLangString = paramObject.a();
      QLog.d("MsgBackup", 1, "onProcessPush0x11b confirmQrRsp = " + paramObject);
      ThreadManager.getSubThreadHandler().post(new MsgBackupSettingFragment.8(this));
    }
    while (!(paramObject instanceof Integer)) {
      return;
    }
    QLog.d("MsgBackup", 1, "onProcessPush0x11b data = " + paramObject);
  }
  
  private void a(String paramString, int paramInt)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    int m;
    int j;
    Bitmap localBitmap;
    Canvas localCanvas;
    Paint localPaint;
    int k;
    int n;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = new File(paramString).listFiles(new apom(this));
        } while ((localObject1 == null) || (localObject1.length <= 0));
        localObject2 = localObject1[0];
        localObject1 = BitmapFactory.decodeFile(((File)localObject2).getAbsolutePath());
        m = ((Bitmap)localObject1).getWidth();
        j = ((Bitmap)localObject1).getHeight();
      } while (localObject1 == null);
      localBitmap = Bitmap.createBitmap(m, j, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      localPaint = new Paint();
      localPaint.setColor(-16777216);
      k = j / 4;
      localPaint.setTextSize(k);
      localCanvas.save();
      localCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
      localCanvas.restore();
      m /= 2;
      n = j / 2;
      localObject2 = ((File)localObject2).getName().split("\\.");
    } while ((localObject2 == null) || (localObject2.length < 1));
    Object localObject2 = localObject2[0];
    for (;;)
    {
      if (i < paramInt)
      {
        n = localCanvas.save();
        localCanvas.drawText(String.valueOf(i), m, j - k, localPaint);
        String str = paramString + File.separator + (String)localObject2 + "_" + i;
        File localFile = new File(str);
        if (!localFile.exists()) {}
        try
        {
          localFile.createNewFile();
        }
        catch (IOException localIOException)
        {
          try
          {
            for (;;)
            {
              vlc.a(localBitmap, str);
              localCanvas.restoreToCount(n);
              i += 1;
              break;
              localIOException = localIOException;
              localIOException.printStackTrace();
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
        }
      }
    }
    localBitmap.recycle();
    ((Bitmap)localObject1).recycle();
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean)
  {
    this.jdField_f_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_g_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0).sendToTarget();
    if (paramBoolean)
    {
      paramString1 = this.jdField_b_of_type_MqqOsMqqHandler.obtainMessage(2);
      paramString1.arg1 = paramInt2;
      paramString1.obj = paramString2;
      paramString1.sendToTarget();
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
  }
  
  private void b(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      a(ajjy.a(2131641146));
      return;
    }
    b();
  }
  
  private void c()
  {
    ThreadManager.getSubThreadHandler().post(new MsgBackupSettingFragment.6(this));
  }
  
  private void d()
  {
    if (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {}
    File[] arrayOfFile;
    do
    {
      return;
      arrayOfFile = new File(this.jdField_g_of_type_JavaLangString).listFiles();
    } while ((arrayOfFile == null) || (arrayOfFile.length <= 0));
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      String str1 = arrayOfFile[i].getAbsolutePath();
      int k = this.jdField_d_of_type_Int;
      String str2 = this.jdField_f_of_type_JavaLangString;
      Intent localIntent = new Intent();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(str1);
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      localIntent.putExtra("uin", str2);
      localIntent.putExtra("uintype", k);
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      localIntent.putExtra("send_in_background", true);
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
      localIntent.putExtra("PicContants.NEED_COMPRESS", false);
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1031);
      new SendPhotoActivity.sendPhotoTask(getActivity(), localIntent).run();
      i += 1;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 0L);
  }
  
  public void a()
  {
    String str1 = getActivity().app.c();
    String str2 = str1 + ".db";
    str1 = getActivity().getDatabasePath(str2).getAbsolutePath();
    str2 = arrw.jdField_b_of_type_JavaLangString + "test/" + str2;
    arsc.a("qqdb copy fromPath = %s,toPath = %s,result = %b", str1, new Object[] { str2, Boolean.valueOf(bace.d(str1, str2)) });
  }
  
  public void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 2: 
      a((String)paramMessage.obj, paramMessage.arg1);
      return;
    }
    d();
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Bbms == null) {
        this.jdField_a_of_type_Bbms = new bbms(getActivity(), getActivity().getTitleBarHeight());
      }
      this.jdField_a_of_type_Bbms.a(paramString);
      this.jdField_a_of_type_Bbms.c(false);
      this.jdField_a_of_type_Bbms.show();
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("IphoneTitleBarFragment", 2, paramString.toString());
    }
  }
  
  public String[] a()
  {
    String[] arrayOfString = new String[2];
    Object localObject = (WifiManager)getActivity().getApplicationContext().getSystemService("wifi");
    if (localObject != null)
    {
      localObject = ((WifiManager)localObject).getConnectionInfo();
      arrayOfString[0] = ((WifiInfo)localObject).getSSID();
      arrayOfString[1] = ((WifiInfo)localObject).getBSSID();
    }
    return arrayOfString;
  }
  
  public void b()
  {
    try
    {
      if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
        this.jdField_a_of_type_Bbms.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("IphoneTitleBarFragment", 2, localException.toString());
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Aroo = ((aroo)getActivity().app.a(162));
    getActivity().app.addObserver(this.jdField_a_of_type_Aroq);
    this.vg.setRightButton(ajjy.a(2131641144));
    this.vg.setLeftButton(ajjy.a(2131641145));
    ((Button)this.mContentView.findViewById(2131303801)).setOnClickListener(this);
    ((Button)this.mContentView.findViewById(2131309401)).setOnClickListener(this);
    ((Button)this.mContentView.findViewById(2131299053)).setOnClickListener(this);
    this.mContentView.findViewById(2131309346).setOnClickListener(this);
    this.mContentView.findViewById(2131307757).setOnClickListener(this);
    this.mContentView.findViewById(2131311724).setOnClickListener(this);
    this.mContentView.findViewById(2131300190).setOnClickListener(this);
    this.mContentView.findViewById(2131307088).setOnClickListener(this);
    this.mContentView.findViewById(2131299331).setOnClickListener(this);
    this.mContentView.findViewById(2131298686).setOnClickListener(this);
    this.mContentView.findViewById(2131298685).setOnClickListener(this);
    this.mContentView.findViewById(2131299215).setOnClickListener(this);
    this.mContentView.findViewById(2131310642).setOnClickListener(this);
    this.mContentView.findViewById(2131299054).setOnClickListener(this);
    this.mContentView.findViewById(2131299058).setOnClickListener(this);
    this.mContentView.findViewById(2131302047).setOnClickListener(this);
    this.mContentView.findViewById(2131300093).setOnClickListener(this);
    this.mContentView.findViewById(2131310113).setOnClickListener(this);
    this.mContentView.findViewById(2131309400).setOnClickListener(this);
    this.mContentView.findViewById(2131309399).setOnClickListener(this);
    this.mContentView.findViewById(2131312899).setOnClickListener(this);
    this.mContentView.findViewById(2131312898).setOnClickListener(this);
    this.mContentView.findViewById(2131310114).setOnClickListener(this);
    this.mContentView.findViewById(2131304805).setOnClickListener(this);
    this.mContentView.findViewById(2131304820).setOnClickListener(this);
    paramLayoutInflater = (TextView)this.mContentView.findViewById(2131310113);
    paramViewGroup = (TextView)this.mContentView.findViewById(2131310114);
    ((EditText)this.mContentView.findViewById(2131302579)).addTextChangedListener(new apoi(this, paramLayoutInflater, paramViewGroup));
    paramLayoutInflater.setText(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { "10000" }));
    paramViewGroup.setText(String.format(this.jdField_e_of_type_JavaLangString, new Object[] { "1000" }));
    paramViewGroup = PreferenceManager.getDefaultGlobalPreference(getActivity());
    paramBundle = paramViewGroup.getString("msgbackup_uin", "");
    String str1 = paramViewGroup.getString("msgbackup_picfilepath", "");
    String str2 = paramViewGroup.getString("msgbackup_inputcount", "");
    String str3 = paramViewGroup.getString("msgbackup_isNeedGeneratedStr", "");
    if (!TextUtils.isEmpty(paramBundle))
    {
      int i = paramViewGroup.getInt("msgbackup_uintype", 0);
      ((EditText)this.mContentView.findViewById(2131300191)).setText(paramBundle);
      ((EditText)this.mContentView.findViewById(2131300192)).setText(String.valueOf(i));
      ((EditText)this.mContentView.findViewById(2131300644)).setText(str1);
      ((EditText)this.mContentView.findViewById(2131302579)).setText(str2);
      ((EditText)this.mContentView.findViewById(2131302660)).setText(str3);
    }
    paramLayoutInflater.requestFocus();
    this.jdField_a_of_type_ArrayOfJavaLangString = a();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), new apoj(this));
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getSubThreadLooper(), new apok(this));
  }
  
  protected int getContentLayoutId()
  {
    return 2131495502;
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    paramView = ((EditText)this.mContentView.findViewById(2131300191)).getText().toString();
    Object localObject4 = ((EditText)this.mContentView.findViewById(2131300192)).getText().toString();
    Object localObject2 = ((EditText)this.mContentView.findViewById(2131302579)).getText().toString();
    Object localObject1 = ((EditText)this.mContentView.findViewById(2131300644)).getText().toString();
    Object localObject3 = ((EditText)this.mContentView.findViewById(2131302660)).getText().toString();
    boolean bool;
    int j;
    int i;
    if ("1".equals(localObject3))
    {
      bool = true;
      j = 0;
      i = 0;
    }
    try
    {
      k = Integer.parseInt((String)localObject4);
      j = k;
    }
    catch (Exception localException1)
    {
      int k;
      label138:
      label148:
      label163:
      ArrayList localArrayList;
      break label138;
    }
    try
    {
      k = Integer.parseInt((String)localObject2);
      i = k;
    }
    catch (Exception localException2)
    {
      break label148;
    }
    if (TextUtils.isEmpty(paramView))
    {
      paramView = jdField_a_of_type_JavaLangString;
      j = jdField_a_of_type_Int;
      localObject2 = arpa.a();
      localObject3 = (aroo)getActivity().app.a(162);
      localObject4 = new arpz();
      localArrayList = new ArrayList(2);
    }
    switch (m)
    {
    case 2131307088: 
    default: 
    case 2131303801: 
    case 2131309401: 
    case 2131299053: 
    case 2131309346: 
    case 2131307757: 
    case 2131311724: 
    case 2131300190: 
    case 2131299331: 
    case 2131310113: 
    case 2131310114: 
    case 2131310111: 
    case 2131298686: 
    case 2131298685: 
    case 2131299215: 
    case 2131310642: 
    case 2131299054: 
    case 2131299058: 
    case 2131302047: 
    case 2131300093: 
    case 2131309400: 
    case 2131309399: 
    case 2131312899: 
    case 2131312898: 
      do
      {
        do
        {
          return;
          bool = false;
          break;
          jdField_a_of_type_JavaLangString = paramView;
          jdField_a_of_type_Int = j;
          localObject4 = PreferenceManager.getDefaultGlobalPreference(getActivity());
          ((SharedPreferences)localObject4).edit().putString("msgbackup_uin", paramView).apply();
          ((SharedPreferences)localObject4).edit().putInt("msgbackup_uintype", j).apply();
          ((SharedPreferences)localObject4).edit().putString("msgbackup_picfilepath", (String)localObject1).apply();
          ((SharedPreferences)localObject4).edit().putString("msgbackup_inputcount", (String)localObject2).apply();
          ((SharedPreferences)localObject4).edit().putString("msgbackup_isNeedGeneratedStr", (String)localObject3).apply();
          break label163;
          ThreadManager.getSubThreadHandler().post(new MsgBackupSettingFragment.4(this));
          return;
          bbmy.a(getActivity(), -1, ajjy.a(2131641143), 1).a();
          ((arpz)localObject4).c(this.jdField_a_of_type_ArrayOfJavaLangString[1]);
          ((arpz)localObject4).b(this.jdField_a_of_type_ArrayOfJavaLangString[0]);
          ((arpz)localObject4).a(arsc.a(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4));
          localArrayList.add(Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port));
          localArrayList.add(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port));
          ((arpz)localObject4).a(localArrayList);
          ((arpz)localObject4).a(4);
          ((aroo)localObject3).a(((arpz)localObject4).a(), 3, false);
          return;
          bbmy.a(getActivity(), -1, ajjy.a(2131641140), 1).a();
          if (jdField_a_of_type_Arpo != null)
          {
            ((arpz)localObject4).c(this.jdField_a_of_type_ArrayOfJavaLangString[1]);
            ((arpz)localObject4).b(this.jdField_a_of_type_ArrayOfJavaLangString[0]);
            ((arpz)localObject4).a(arsc.a(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4));
            localArrayList.add(Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port));
            localArrayList.add(Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port));
            ((arpz)localObject4).a(localArrayList);
            ((arpz)localObject4).a(4);
            ((aroo)localObject3).a(((arpz)localObject4).a(), jdField_a_of_type_Arpo.a(), 3);
            return;
          }
          QLog.d("MsgBackup", 1, "case confirmQR qrResponse is null!");
          return;
          if (jdField_a_of_type_Arpo != null)
          {
            ((aroo)localObject3).a(jdField_a_of_type_Arpo.a(), 3);
            return;
          }
          QLog.d("MsgBackup", 1, "case rejectQR qrResponse is null!");
          return;
          if (jdField_a_of_type_Arpo != null)
          {
            ((aroo)localObject3).c(jdField_a_of_type_Arpo.a());
            return;
          }
          QLog.d("MsgBackup", 1, "case queryQRState qrResponse is null!");
          return;
          if (this.jdField_a_of_type_Arpk != null)
          {
            ((aroo)localObject3).a(this.jdField_a_of_type_Arpk.a());
            return;
          }
          QLog.d("MsgBackup", 1, "case tokenConfirm qrConfirmReponse is null!");
          return;
          ((arpa)localObject2).jdField_a_of_type_JavaUtilHashSet.clear();
          getActivity().app.a().a();
          paramView = ahay.a(paramView, j);
          paramView = ahay.a().a(paramView);
          if (paramView != null)
          {
            ((arpa)localObject2).jdField_a_of_type_JavaUtilHashSet.add(paramView);
            paramView = new arpg();
            paramView.jdField_a_of_type_JavaUtilHashSet = arpa.a().jdField_a_of_type_JavaUtilHashSet;
            paramView.jdField_a_of_type_Int = 0;
            ((arpa)localObject2).a(paramView);
            return;
          }
          QLog.d("MsgBackup", 1, "test export submit,recentBaseData is null");
          return;
          arpa.a().c(null);
          return;
          localObject1 = new SessionInfo();
          ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString = paramView;
          ((SessionInfo)localObject1).jdField_a_of_type_Int = j;
          if (i > 0) {}
          for (;;)
          {
            ThreadManager.newFreeThread(new MsgBackupSettingFragment.5(this, i, (SessionInfo)localObject1), "msgbackup_testSendMsg", 1).start();
            return;
            i = 0;
          }
          a(paramView, j, (String)localObject1, i, bool);
          return;
          a(paramView, j, (String)localObject1, i);
          return;
          getActivity().app.a().a(paramView, j);
          return;
          ((arpa)localObject2).f();
          return;
          a();
          return;
          c();
          return;
          a(this.jdField_a_of_type_Arpr);
          return;
          a(this.jdField_a_of_type_Arpr);
          return;
          bbmy.a(getActivity(), -1, ajjy.a(2131641139), 1).a();
          return;
          paramView = MsgBackupJniProxy.encryptFromString("i am a hero!!!", "1111111111111111");
          arsc.a("MsgBackup", ajjy.a(2131641147), new Object[] { "i am a hero!!!", paramView });
          localObject1 = MsgBackupJniProxy.decryptFromString(paramView, "1111111111111111");
          arsc.a("MsgBackup", ajjy.a(2131641131), new Object[] { paramView, localObject1 });
          localObject1 = new byte[12];
          Object tmp1248_1246 = localObject1;
          tmp1248_1246[0] = 73;
          Object tmp1254_1248 = tmp1248_1246;
          tmp1254_1248[1] = 32;
          Object tmp1260_1254 = tmp1254_1248;
          tmp1260_1254[2] = 65;
          Object tmp1266_1260 = tmp1260_1254;
          tmp1266_1260[3] = 77;
          Object tmp1272_1266 = tmp1266_1260;
          tmp1272_1266[4] = 32;
          Object tmp1278_1272 = tmp1272_1266;
          tmp1278_1272[5] = 65;
          Object tmp1284_1278 = tmp1278_1272;
          tmp1284_1278[6] = 32;
          Object tmp1291_1284 = tmp1284_1278;
          tmp1291_1284[7] = 72;
          Object tmp1298_1291 = tmp1291_1284;
          tmp1298_1291[8] = 69;
          Object tmp1305_1298 = tmp1298_1291;
          tmp1305_1298[9] = 82;
          Object tmp1312_1305 = tmp1305_1298;
          tmp1312_1305[10] = 79;
          Object tmp1319_1312 = tmp1312_1305;
          tmp1319_1312[11] = 33;
          tmp1319_1312;
          paramView = MsgBackupJniProxy.encryptFromByteArray((byte[])localObject1, "1111111111111111");
          arsc.a("MsgBackup", ajjy.a(2131641133), new Object[] { Integer.valueOf(localObject1.length), Integer.valueOf(paramView.length) });
          localObject1 = MsgBackupJniProxy.decryptFromByteArray(paramView, "1111111111111111");
          arsc.a("MsgBackup", ajjy.a(2131641118), new Object[] { Integer.valueOf(paramView.length), Integer.valueOf(localObject1.length) });
          return;
          this.jdField_a_of_type_Aroo.a();
          return;
        } while (TextUtils.isEmpty(arpa.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_Aroo.b(arpa.jdField_a_of_type_JavaLangString);
        return;
        this.jdField_c_of_type_JavaLangString = Uri.encode("111111111111111111");
        arsc.a("IphoneTitleBarFragment", "编码之后的value = %s", new Object[] { this.jdField_c_of_type_JavaLangString });
        return;
      } while (this.jdField_c_of_type_JavaLangString == null);
      arsc.a("IphoneTitleBarFragment", "解码之后的value = %s", new Object[] { Uri.decode(this.jdField_c_of_type_JavaLangString) });
      return;
    case 2131304805: 
      arqa.a(getActivity().app);
      return;
    }
    if (i > 0) {}
    for (;;)
    {
      localObject1 = arqa.a(null, i, paramView, j, getActivity().app.c());
      if (((List)localObject1).size() > 0) {
        arqa.a(getActivity().app, (List)localObject1);
      }
      paramView = MessageRecord.getTableName(paramView, j);
      i = getActivity().app.a().a(paramView, 0L, 9223372036854775807L, false);
      ((TextView)getActivity().findViewById(2131304819)).setText("result:msgSize =  " + i);
      return;
      i = 0;
    }
  }
  
  public void onDestroy()
  {
    if (getActivity() != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_Aroq);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment
 * JD-Core Version:    0.7.0.1
 */