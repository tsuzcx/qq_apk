package com.tencent.mobileqq.fragment;

import ahnl;
import ajya;
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
import aqhy;
import aqhz;
import aqia;
import aqib;
import aqic;
import asku;
import askw;
import aslg;
import aslm;
import aslq;
import aslu;
import aslx;
import asma;
import asmf;
import asmg;
import asoc;
import asoi;
import bbdx;
import bcqf;
import bcql;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
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
import vxv;

public class MsgBackupSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public static int a;
  public static aslu a;
  public static String a;
  long jdField_a_of_type_Long;
  private asku jdField_a_of_type_Asku;
  private askw jdField_a_of_type_Askw = new aqib(this);
  private aslq jdField_a_of_type_Aslq;
  private aslx jdField_a_of_type_Aslx;
  private asma jdField_a_of_type_Asma;
  private bcqf jdField_a_of_type_Bcqf;
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
  private String jdField_d_of_type_JavaLangString = ajya.a(2131706921);
  private final int jdField_e_of_type_Int = 0;
  private String jdField_e_of_type_JavaLangString = ajya.a(2131706938);
  private final int jdField_f_of_type_Int = 1;
  private String jdField_f_of_type_JavaLangString;
  private final int jdField_g_of_type_Int = 2;
  private String jdField_g_of_type_JavaLangString;
  private final int h = 3;
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof aslx))
    {
      paramObject = (aslx)paramObject;
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
          localObject1 = new File(paramString).listFiles(new aqic(this));
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
              vxv.a(localBitmap, str);
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
      a(ajya.a(2131706942));
      return;
    }
    b();
  }
  
  private void c()
  {
    ThreadManager.getSubThreadHandler().post(new MsgBackupSettingFragment.5(this));
  }
  
  private void d()
  {
    ThreadManager.getSubThreadHandler().post(new MsgBackupSettingFragment.6(this));
  }
  
  private void e()
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
      new SendPhotoTask(getActivity(), localIntent, null).run();
      i += 1;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 0L);
  }
  
  public void a()
  {
    String str1 = getActivity().app.c();
    String str2 = str1 + ".db";
    str1 = getActivity().getDatabasePath(str2).getAbsolutePath();
    str2 = asoc.jdField_a_of_type_JavaLangString + "test/" + str2;
    asoi.a("qqdb copy fromPath = %s,toPath = %s,result = %b", str1, new Object[] { str2, Boolean.valueOf(bbdx.d(str1, str2)) });
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
    e();
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Bcqf == null) {
        this.jdField_a_of_type_Bcqf = new bcqf(getActivity(), getActivity().getTitleBarHeight());
      }
      this.jdField_a_of_type_Bcqf.a(paramString);
      this.jdField_a_of_type_Bcqf.c(false);
      this.jdField_a_of_type_Bcqf.show();
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
      if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
        this.jdField_a_of_type_Bcqf.dismiss();
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
    this.jdField_a_of_type_Asku = ((asku)getActivity().app.a(162));
    getActivity().app.addObserver(this.jdField_a_of_type_Askw);
    this.vg.setRightButton(ajya.a(2131706940));
    this.vg.setLeftButton(ajya.a(2131706941));
    ((Button)this.mContentView.findViewById(2131369475)).setOnClickListener(this);
    ((Button)this.mContentView.findViewById(2131375150)).setOnClickListener(this);
    ((Button)this.mContentView.findViewById(2131364612)).setOnClickListener(this);
    this.mContentView.findViewById(2131375094).setOnClickListener(this);
    this.mContentView.findViewById(2131373473).setOnClickListener(this);
    this.mContentView.findViewById(2131377538).setOnClickListener(this);
    this.mContentView.findViewById(2131365788).setOnClickListener(this);
    this.mContentView.findViewById(2131372802).setOnClickListener(this);
    this.mContentView.findViewById(2131364894).setOnClickListener(this);
    this.mContentView.findViewById(2131364243).setOnClickListener(this);
    this.mContentView.findViewById(2131364242).setOnClickListener(this);
    this.mContentView.findViewById(2131364777).setOnClickListener(this);
    this.mContentView.findViewById(2131376437).setOnClickListener(this);
    this.mContentView.findViewById(2131364613).setOnClickListener(this);
    this.mContentView.findViewById(2131364617).setOnClickListener(this);
    this.mContentView.findViewById(2131367665).setOnClickListener(this);
    this.mContentView.findViewById(2131365689).setOnClickListener(this);
    this.mContentView.findViewById(2131375879).setOnClickListener(this);
    this.mContentView.findViewById(2131375149).setOnClickListener(this);
    this.mContentView.findViewById(2131375148).setOnClickListener(this);
    this.mContentView.findViewById(2131378729).setOnClickListener(this);
    this.mContentView.findViewById(2131378728).setOnClickListener(this);
    this.mContentView.findViewById(2131375880).setOnClickListener(this);
    this.mContentView.findViewById(2131370466).setOnClickListener(this);
    this.mContentView.findViewById(2131370484).setOnClickListener(this);
    this.mContentView.findViewById(2131378725).setOnClickListener(this);
    paramLayoutInflater = (TextView)this.mContentView.findViewById(2131375879);
    paramViewGroup = (TextView)this.mContentView.findViewById(2131375880);
    ((EditText)this.mContentView.findViewById(2131368200)).addTextChangedListener(new aqhy(this, paramLayoutInflater, paramViewGroup));
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
      ((EditText)this.mContentView.findViewById(2131365789)).setText(paramBundle);
      ((EditText)this.mContentView.findViewById(2131365790)).setText(String.valueOf(i));
      ((EditText)this.mContentView.findViewById(2131366246)).setText(str1);
      ((EditText)this.mContentView.findViewById(2131368200)).setText(str2);
      ((EditText)this.mContentView.findViewById(2131368282)).setText(str3);
    }
    paramLayoutInflater.requestFocus();
    this.jdField_a_of_type_ArrayOfJavaLangString = a();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), new aqhz(this));
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getSubThreadLooper(), new aqia(this));
  }
  
  protected int getContentLayoutId()
  {
    return 2131561089;
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    paramView = ((EditText)this.mContentView.findViewById(2131365789)).getText().toString();
    Object localObject4 = ((EditText)this.mContentView.findViewById(2131365790)).getText().toString();
    Object localObject2 = ((EditText)this.mContentView.findViewById(2131368200)).getText().toString();
    Object localObject1 = ((EditText)this.mContentView.findViewById(2131366246)).getText().toString();
    Object localObject3 = ((EditText)this.mContentView.findViewById(2131368282)).getText().toString();
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
      localObject2 = aslg.a();
      localObject3 = (asku)getActivity().app.a(162);
      localObject4 = new asmf();
      localArrayList = new ArrayList(2);
    }
    switch (m)
    {
    case 2131372802: 
    default: 
    case 2131369475: 
    case 2131375150: 
    case 2131364612: 
    case 2131375094: 
    case 2131373473: 
    case 2131377538: 
    case 2131365788: 
    case 2131364894: 
    case 2131375879: 
    case 2131375880: 
    case 2131375877: 
    case 2131364243: 
    case 2131364242: 
    case 2131364777: 
    case 2131376437: 
    case 2131364613: 
    case 2131364617: 
    case 2131367665: 
    case 2131365689: 
    case 2131375149: 
    case 2131375148: 
    case 2131378729: 
    case 2131378728: 
      do
      {
        do
        {
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
              c();
              return;
            } while ((this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint == null) || (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint == null));
            bcql.a(getActivity(), -1, ajya.a(2131706939), 1).a();
            ((asmf)localObject4).c(this.jdField_a_of_type_ArrayOfJavaLangString[1]);
            ((asmf)localObject4).b(this.jdField_a_of_type_ArrayOfJavaLangString[0]);
            ((asmf)localObject4).a(asoi.a(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4));
            localArrayList.add(Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port));
            localArrayList.add(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port));
            ((asmf)localObject4).a(localArrayList);
            ((asmf)localObject4).a(4);
            ((asku)localObject3).a(((asmf)localObject4).a(), 3, false);
            return;
          } while ((this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint == null) || (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint == null));
          bcql.a(getActivity(), -1, ajya.a(2131706936), 1).a();
          if (jdField_a_of_type_Aslu != null)
          {
            ((asmf)localObject4).c(this.jdField_a_of_type_ArrayOfJavaLangString[1]);
            ((asmf)localObject4).b(this.jdField_a_of_type_ArrayOfJavaLangString[0]);
            ((asmf)localObject4).a(asoi.a(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4));
            localArrayList.add(Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port));
            localArrayList.add(Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port));
            ((asmf)localObject4).a(localArrayList);
            ((asmf)localObject4).a(4);
            ((asku)localObject3).a(((asmf)localObject4).a(), jdField_a_of_type_Aslu.a(), 3);
            return;
          }
          QLog.d("MsgBackup", 1, "case confirmQR qrResponse is null!");
          return;
          if (jdField_a_of_type_Aslu != null)
          {
            ((asku)localObject3).a(jdField_a_of_type_Aslu.a(), 3);
            return;
          }
          QLog.d("MsgBackup", 1, "case rejectQR qrResponse is null!");
          return;
          if (jdField_a_of_type_Aslu != null)
          {
            ((asku)localObject3).c(jdField_a_of_type_Aslu.a());
            return;
          }
          QLog.d("MsgBackup", 1, "case queryQRState qrResponse is null!");
          return;
          if (this.jdField_a_of_type_Aslq != null)
          {
            ((asku)localObject3).a(this.jdField_a_of_type_Aslq.a());
            return;
          }
          QLog.d("MsgBackup", 1, "case tokenConfirm qrConfirmReponse is null!");
          return;
          ((aslg)localObject2).jdField_a_of_type_JavaUtilHashSet.clear();
          getActivity().app.a().a();
          paramView = ahnl.a(paramView, j);
          paramView = ahnl.a().a(paramView);
          if (paramView != null)
          {
            ((aslg)localObject2).jdField_a_of_type_JavaUtilHashSet.add(paramView);
            paramView = new aslm();
            paramView.jdField_a_of_type_JavaUtilHashSet = aslg.a().jdField_a_of_type_JavaUtilHashSet;
            paramView.jdField_a_of_type_Int = 0;
            ((aslg)localObject2).a(paramView);
            return;
          }
          QLog.d("MsgBackup", 1, "test export submit,recentBaseData is null");
          return;
          aslg.a().c(null);
          return;
          localObject1 = new SessionInfo();
          ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString = paramView;
          ((SessionInfo)localObject1).jdField_a_of_type_Int = j;
          if (i > 0) {}
          for (;;)
          {
            ThreadManager.newFreeThread(new MsgBackupSettingFragment.4(this, i, (SessionInfo)localObject1), "msgbackup_testSendMsg", 1).start();
            return;
            i = 0;
          }
          a(paramView, j, (String)localObject1, i, bool);
          return;
          a(paramView, j, (String)localObject1, i);
          return;
          getActivity().app.a().a(paramView, j);
          return;
          ((aslg)localObject2).f();
          return;
          a();
          return;
          d();
          return;
          a(this.jdField_a_of_type_Aslx);
          return;
          a(this.jdField_a_of_type_Aslx);
          return;
          bcql.a(getActivity(), -1, ajya.a(2131706935), 1).a();
          return;
          paramView = MsgBackupJniProxy.encryptFromString("i am a hero!!!", "1111111111111111");
          asoi.a("MsgBackup", ajya.a(2131706943), new Object[] { "i am a hero!!!", paramView });
          localObject1 = MsgBackupJniProxy.decryptFromString(paramView, "1111111111111111");
          asoi.a("MsgBackup", ajya.a(2131706927), new Object[] { paramView, localObject1 });
          localObject1 = new byte[12];
          Object tmp1273_1271 = localObject1;
          tmp1273_1271[0] = 73;
          Object tmp1279_1273 = tmp1273_1271;
          tmp1279_1273[1] = 32;
          Object tmp1285_1279 = tmp1279_1273;
          tmp1285_1279[2] = 65;
          Object tmp1291_1285 = tmp1285_1279;
          tmp1291_1285[3] = 77;
          Object tmp1297_1291 = tmp1291_1285;
          tmp1297_1291[4] = 32;
          Object tmp1303_1297 = tmp1297_1291;
          tmp1303_1297[5] = 65;
          Object tmp1309_1303 = tmp1303_1297;
          tmp1309_1303[6] = 32;
          Object tmp1316_1309 = tmp1309_1303;
          tmp1316_1309[7] = 72;
          Object tmp1323_1316 = tmp1316_1309;
          tmp1323_1316[8] = 69;
          Object tmp1330_1323 = tmp1323_1316;
          tmp1330_1323[9] = 82;
          Object tmp1337_1330 = tmp1330_1323;
          tmp1337_1330[10] = 79;
          Object tmp1344_1337 = tmp1337_1330;
          tmp1344_1337[11] = 33;
          tmp1344_1337;
          paramView = MsgBackupJniProxy.encryptFromByteArray((byte[])localObject1, "1111111111111111");
          asoi.a("MsgBackup", ajya.a(2131706929), new Object[] { Integer.valueOf(localObject1.length), Integer.valueOf(paramView.length) });
          localObject1 = MsgBackupJniProxy.decryptFromByteArray(paramView, "1111111111111111");
          asoi.a("MsgBackup", ajya.a(2131706914), new Object[] { Integer.valueOf(paramView.length), Integer.valueOf(localObject1.length) });
          return;
          this.jdField_a_of_type_Asku.a();
          return;
        } while (TextUtils.isEmpty(aslg.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_Asku.b(aslg.jdField_a_of_type_JavaLangString);
        return;
        this.jdField_c_of_type_JavaLangString = Uri.encode("111111111111111111");
        asoi.a("IphoneTitleBarFragment", "编码之后的value = %s", new Object[] { this.jdField_c_of_type_JavaLangString });
        return;
      } while (this.jdField_c_of_type_JavaLangString == null);
      asoi.a("IphoneTitleBarFragment", "解码之后的value = %s", new Object[] { Uri.decode(this.jdField_c_of_type_JavaLangString) });
      return;
    case 2131370466: 
      asmg.a(getActivity().app);
      return;
    case 2131370484: 
      if (i > 0) {}
      for (;;)
      {
        localObject1 = asmg.a(null, i, paramView, j, getActivity().app.c());
        if (((List)localObject1).size() > 0) {
          asmg.a(getActivity().app, (List)localObject1);
        }
        paramView = MessageRecord.getTableName(paramView, j);
        i = getActivity().app.a().a(paramView, 0L, 9223372036854775807L, false);
        ((TextView)getActivity().findViewById(2131370483)).setText("result:msgSize =  " + i);
        return;
        i = 0;
      }
    }
    c();
    paramView = asoi.a("http://10.71.161.35:8001/4EFF91728050FE643749C167C73EBCDA6CD8EE193B8636D01B445730BB8A31EE1374186F5611658FD9217AB6FF9BC857DE9D9A8DFA5CFF3C8E063D3B2FA3BB0B1B0EDC7D8B162F850C0A375A45E4CE3B70846A812C626CB5ED09EB107556EECB765BCF39A41BACA755747BE723749A26655D46D004D3DBA34C374CA622B8B0F3E3B2F0E582BA37B4", asoi.a("10.71.161.35"), 8001, "'U}MXig2f9zi:$?_");
    QLog.e("MsgBackupSettingFragment", 1, "RESULT = " + paramView);
  }
  
  public void onDestroy()
  {
    if (getActivity() != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_Askw);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment
 * JD-Core Version:    0.7.0.1
 */