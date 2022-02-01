package com.tencent.mobileqq.fragment;

import albs;
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
import anni;
import aumj;
import aumk;
import auml;
import aumm;
import aumn;
import awnf;
import awnh;
import awnr;
import awnx;
import awob;
import awof;
import awoi;
import awol;
import awoq;
import awor;
import awqo;
import awqu;
import bgmg;
import biau;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupJniProxy;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;
import zkh;

public class MsgBackupSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public static int a;
  public static awof a;
  public static String a;
  long jdField_a_of_type_Long;
  private awnf jdField_a_of_type_Awnf;
  private awnh jdField_a_of_type_Awnh = new aumm(this);
  private awob jdField_a_of_type_Awob;
  private awoi jdField_a_of_type_Awoi;
  private awol jdField_a_of_type_Awol;
  private biau jdField_a_of_type_Biau;
  MsgBackupJniProxy jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy;
  private Integer jdField_a_of_type_JavaLangInteger = new Integer(0);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[10];
  private int jdField_b_of_type_Int;
  private Integer jdField_b_of_type_JavaLangInteger = new Integer(0);
  private String jdField_b_of_type_JavaLangString;
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  private String[] jdField_b_of_type_ArrayOfJavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = anni.a(2131705696);
  private final int jdField_e_of_type_Int = 0;
  private String jdField_e_of_type_JavaLangString = anni.a(2131705713);
  private final int jdField_f_of_type_Int = 1;
  private String jdField_f_of_type_JavaLangString;
  private final int jdField_g_of_type_Int = 2;
  private String jdField_g_of_type_JavaLangString;
  private final int h = 3;
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof awoi))
    {
      paramObject = (awoi)paramObject;
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
          localObject1 = new File(paramString).listFiles(new aumn(this));
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
              zkh.a(localBitmap, str);
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
      a(anni.a(2131705717));
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
    str2 = awqo.jdField_a_of_type_JavaLangString + "test/" + str2;
    awqu.a("qqdb copy fromPath = %s,toPath = %s,result = %b", str1, new Object[] { str2, Boolean.valueOf(bgmg.d(str1, str2)) });
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
      if (this.jdField_a_of_type_Biau == null) {
        this.jdField_a_of_type_Biau = new biau(getActivity(), getActivity().getTitleBarHeight());
      }
      this.jdField_a_of_type_Biau.a(paramString);
      this.jdField_a_of_type_Biau.c(false);
      this.jdField_a_of_type_Biau.show();
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
      if ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing())) {
        this.jdField_a_of_type_Biau.dismiss();
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
    this.jdField_a_of_type_Awnf = ((awnf)getActivity().app.a(162));
    getActivity().app.addObserver(this.jdField_a_of_type_Awnh);
    this.vg.setRightButton(anni.a(2131705715));
    this.vg.setLeftButton(anni.a(2131705716));
    ((Button)this.mContentView.findViewById(2131370185)).setOnClickListener(this);
    ((Button)this.mContentView.findViewById(2131376408)).setOnClickListener(this);
    ((Button)this.mContentView.findViewById(2131364911)).setOnClickListener(this);
    this.mContentView.findViewById(2131376350).setOnClickListener(this);
    this.mContentView.findViewById(2131374698).setOnClickListener(this);
    this.mContentView.findViewById(2131378974).setOnClickListener(this);
    this.mContentView.findViewById(2131366129).setOnClickListener(this);
    this.mContentView.findViewById(2131373992).setOnClickListener(this);
    this.mContentView.findViewById(2131365219).setOnClickListener(this);
    this.mContentView.findViewById(2131364524).setOnClickListener(this);
    this.mContentView.findViewById(2131364523).setOnClickListener(this);
    this.mContentView.findViewById(2131365090).setOnClickListener(this);
    this.mContentView.findViewById(2131377796).setOnClickListener(this);
    this.mContentView.findViewById(2131364912).setOnClickListener(this);
    this.mContentView.findViewById(2131364916).setOnClickListener(this);
    this.mContentView.findViewById(2131368122).setOnClickListener(this);
    this.mContentView.findViewById(2131366017).setOnClickListener(this);
    this.mContentView.findViewById(2131377221).setOnClickListener(this);
    this.mContentView.findViewById(2131376407).setOnClickListener(this);
    this.mContentView.findViewById(2131376406).setOnClickListener(this);
    this.mContentView.findViewById(2131380331).setOnClickListener(this);
    this.mContentView.findViewById(2131380330).setOnClickListener(this);
    this.mContentView.findViewById(2131377222).setOnClickListener(this);
    this.mContentView.findViewById(2131371352).setOnClickListener(this);
    this.mContentView.findViewById(2131371370).setOnClickListener(this);
    this.mContentView.findViewById(2131380327).setOnClickListener(this);
    paramLayoutInflater = (TextView)this.mContentView.findViewById(2131377221);
    paramViewGroup = (TextView)this.mContentView.findViewById(2131377222);
    ((EditText)this.mContentView.findViewById(2131368665)).addTextChangedListener(new aumj(this, paramLayoutInflater, paramViewGroup));
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
      ((EditText)this.mContentView.findViewById(2131366130)).setText(paramBundle);
      ((EditText)this.mContentView.findViewById(2131366131)).setText(String.valueOf(i));
      ((EditText)this.mContentView.findViewById(2131366588)).setText(str1);
      ((EditText)this.mContentView.findViewById(2131368665)).setText(str2);
      ((EditText)this.mContentView.findViewById(2131368746)).setText(str3);
    }
    paramLayoutInflater.requestFocus();
    this.jdField_b_of_type_ArrayOfJavaLangString = a();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), new aumk(this));
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getSubThreadLooper(), new auml(this));
  }
  
  protected int getContentLayoutId()
  {
    return 2131561524;
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    Object localObject1 = ((EditText)this.mContentView.findViewById(2131366130)).getText().toString();
    Object localObject5 = ((EditText)this.mContentView.findViewById(2131366131)).getText().toString();
    Object localObject3 = ((EditText)this.mContentView.findViewById(2131368665)).getText().toString();
    Object localObject2 = ((EditText)this.mContentView.findViewById(2131366588)).getText().toString();
    Object localObject4 = ((EditText)this.mContentView.findViewById(2131368746)).getText().toString();
    boolean bool;
    int j;
    int i;
    if ("1".equals(localObject4))
    {
      bool = true;
      j = 0;
      i = 0;
    }
    try
    {
      k = Integer.parseInt((String)localObject5);
      j = k;
    }
    catch (Exception localException1)
    {
      int k;
      label139:
      label149:
      label166:
      ArrayList localArrayList;
      break label139;
    }
    try
    {
      k = Integer.parseInt((String)localObject3);
      i = k;
    }
    catch (Exception localException2)
    {
      break label149;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      j = jdField_a_of_type_Int;
      localObject3 = awnr.a();
      localObject4 = (awnf)getActivity().app.a(162);
      localObject5 = new awoq();
      localArrayList = new ArrayList(2);
      switch (m)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      jdField_a_of_type_JavaLangString = (String)localObject1;
      jdField_a_of_type_Int = j;
      localObject5 = PreferenceManager.getDefaultGlobalPreference(getActivity());
      ((SharedPreferences)localObject5).edit().putString("msgbackup_uin", (String)localObject1).apply();
      ((SharedPreferences)localObject5).edit().putInt("msgbackup_uintype", j).apply();
      ((SharedPreferences)localObject5).edit().putString("msgbackup_picfilepath", (String)localObject2).apply();
      ((SharedPreferences)localObject5).edit().putString("msgbackup_inputcount", (String)localObject3).apply();
      ((SharedPreferences)localObject5).edit().putString("msgbackup_isNeedGeneratedStr", (String)localObject4).apply();
      break label166;
      c();
      continue;
      if ((this.jdField_b_of_type_JavaLangInteger.intValue() != 0) && (this.jdField_a_of_type_JavaLangInteger.intValue() != 0))
      {
        QQToast.a(getActivity(), -1, anni.a(2131705714), 1).a();
        ((awoq)localObject5).c(this.jdField_b_of_type_ArrayOfJavaLangString[1]);
        ((awoq)localObject5).b(this.jdField_b_of_type_ArrayOfJavaLangString[0]);
        ((awoq)localObject5).a(this.jdField_a_of_type_ArrayOfJavaLangString[0]);
        localArrayList.add(this.jdField_b_of_type_JavaLangInteger);
        localArrayList.add(this.jdField_a_of_type_JavaLangInteger);
        ((awoq)localObject5).a(localArrayList);
        ((awoq)localObject5).a(4);
        ((awnf)localObject4).a(((awoq)localObject5).a(), 3, false);
        continue;
        if ((this.jdField_b_of_type_JavaLangInteger.intValue() != 0) && (this.jdField_a_of_type_JavaLangInteger.intValue() != 0))
        {
          QQToast.a(getActivity(), -1, anni.a(2131705711), 1).a();
          if (jdField_a_of_type_Awof != null)
          {
            ((awoq)localObject5).c(this.jdField_b_of_type_ArrayOfJavaLangString[1]);
            ((awoq)localObject5).b(this.jdField_b_of_type_ArrayOfJavaLangString[0]);
            ((awoq)localObject5).a(this.jdField_a_of_type_ArrayOfJavaLangString[0]);
            localArrayList.add(this.jdField_b_of_type_JavaLangInteger);
            localArrayList.add(this.jdField_a_of_type_JavaLangInteger);
            ((awoq)localObject5).a(localArrayList);
            ((awoq)localObject5).a(4);
            ((awnf)localObject4).a(((awoq)localObject5).a(), jdField_a_of_type_Awof.a(), 3);
          }
          else
          {
            QLog.d("MsgBackup", 1, "case confirmQR qrResponse is null!");
            continue;
            if (jdField_a_of_type_Awof != null)
            {
              ((awnf)localObject4).a(jdField_a_of_type_Awof.a(), 3);
            }
            else
            {
              QLog.d("MsgBackup", 1, "case rejectQR qrResponse is null!");
              continue;
              if (jdField_a_of_type_Awof != null)
              {
                ((awnf)localObject4).c(jdField_a_of_type_Awof.a());
              }
              else
              {
                QLog.d("MsgBackup", 1, "case queryQRState qrResponse is null!");
                continue;
                if (this.jdField_a_of_type_Awob != null)
                {
                  ((awnf)localObject4).a(this.jdField_a_of_type_Awob.a());
                }
                else
                {
                  QLog.d("MsgBackup", 1, "case tokenConfirm qrConfirmReponse is null!");
                  continue;
                  ((awnr)localObject3).jdField_a_of_type_JavaUtilHashSet.clear();
                  getActivity().app.a().a();
                  localObject1 = albs.a((String)localObject1, j);
                  localObject1 = albs.a().a((String)localObject1);
                  if (localObject1 != null)
                  {
                    ((awnr)localObject3).jdField_a_of_type_JavaUtilHashSet.add(localObject1);
                    localObject1 = new awnx();
                    ((awnx)localObject1).jdField_a_of_type_JavaUtilHashSet = awnr.a().jdField_a_of_type_JavaUtilHashSet;
                    ((awnx)localObject1).jdField_a_of_type_Int = 0;
                    ((awnr)localObject3).a((awnx)localObject1);
                  }
                  else
                  {
                    QLog.d("MsgBackup", 1, "test export submit,recentBaseData is null");
                    continue;
                    awnr.a().c(null);
                    continue;
                    localObject2 = new SessionInfo();
                    ((SessionInfo)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
                    ((SessionInfo)localObject2).jdField_a_of_type_Int = j;
                    if (i > 0) {}
                    for (;;)
                    {
                      ThreadManager.newFreeThread(new MsgBackupSettingFragment.4(this, i, (SessionInfo)localObject2), "msgbackup_testSendMsg", 1).start();
                      break;
                      i = 0;
                    }
                    a((String)localObject1, j, (String)localObject2, i, bool);
                    continue;
                    a((String)localObject1, j, (String)localObject2, i);
                    continue;
                    getActivity().app.a().a((String)localObject1, j);
                    continue;
                    ((awnr)localObject3).f();
                    continue;
                    a();
                    continue;
                    d();
                    continue;
                    a(this.jdField_a_of_type_Awoi);
                    continue;
                    a(this.jdField_a_of_type_Awoi);
                    continue;
                    QQToast.a(getActivity(), -1, anni.a(2131705710), 1).a();
                    continue;
                    localObject1 = MsgBackupJniProxy.encryptFromString("i am a hero!!!", "1111111111111111");
                    awqu.a("MsgBackup", anni.a(2131705718), new Object[] { "i am a hero!!!", localObject1 });
                    localObject2 = MsgBackupJniProxy.decryptFromString((String)localObject1, "1111111111111111");
                    awqu.a("MsgBackup", anni.a(2131705702), new Object[] { localObject1, localObject2 });
                    localObject2 = new byte[12];
                    Object tmp1330_1328 = localObject2;
                    tmp1330_1328[0] = 73;
                    Object tmp1336_1330 = tmp1330_1328;
                    tmp1336_1330[1] = 32;
                    Object tmp1342_1336 = tmp1336_1330;
                    tmp1342_1336[2] = 65;
                    Object tmp1348_1342 = tmp1342_1336;
                    tmp1348_1342[3] = 77;
                    Object tmp1354_1348 = tmp1348_1342;
                    tmp1354_1348[4] = 32;
                    Object tmp1360_1354 = tmp1354_1348;
                    tmp1360_1354[5] = 65;
                    Object tmp1366_1360 = tmp1360_1354;
                    tmp1366_1360[6] = 32;
                    Object tmp1373_1366 = tmp1366_1360;
                    tmp1373_1366[7] = 72;
                    Object tmp1380_1373 = tmp1373_1366;
                    tmp1380_1373[8] = 69;
                    Object tmp1387_1380 = tmp1380_1373;
                    tmp1387_1380[9] = 82;
                    Object tmp1394_1387 = tmp1387_1380;
                    tmp1394_1387[10] = 79;
                    Object tmp1401_1394 = tmp1394_1387;
                    tmp1401_1394[11] = 33;
                    tmp1401_1394;
                    localObject1 = MsgBackupJniProxy.encryptFromByteArray((byte[])localObject2, "1111111111111111");
                    awqu.a("MsgBackup", anni.a(2131705704), new Object[] { Integer.valueOf(localObject2.length), Integer.valueOf(localObject1.length) });
                    localObject2 = MsgBackupJniProxy.decryptFromByteArray((byte[])localObject1, "1111111111111111");
                    awqu.a("MsgBackup", anni.a(2131705689), new Object[] { Integer.valueOf(localObject1.length), Integer.valueOf(localObject2.length) });
                    continue;
                    this.jdField_a_of_type_Awnf.a();
                    continue;
                    if (!TextUtils.isEmpty(awnr.jdField_a_of_type_JavaLangString))
                    {
                      this.jdField_a_of_type_Awnf.b(awnr.jdField_a_of_type_JavaLangString);
                      continue;
                      this.jdField_c_of_type_JavaLangString = Uri.encode("111111111111111111");
                      awqu.a("IphoneTitleBarFragment", "编码之后的value = %s", new Object[] { this.jdField_c_of_type_JavaLangString });
                      continue;
                      if (this.jdField_c_of_type_JavaLangString != null)
                      {
                        awqu.a("IphoneTitleBarFragment", "解码之后的value = %s", new Object[] { Uri.decode(this.jdField_c_of_type_JavaLangString) });
                        continue;
                        awor.a(getActivity().app);
                        continue;
                        if (i > 0) {}
                        for (;;)
                        {
                          localObject2 = awor.a(null, i, (String)localObject1, j, getActivity().app.c());
                          if (((List)localObject2).size() > 0) {
                            awor.a(getActivity().app, (List)localObject2);
                          }
                          localObject1 = MessageRecord.getTableName((String)localObject1, j);
                          i = getActivity().app.a().a((String)localObject1, 0L, 9223372036854775807L, false);
                          ((TextView)getActivity().findViewById(2131371369)).setText("result:msgSize =  " + i);
                          break;
                          i = 0;
                        }
                        c();
                        localObject1 = awqu.a("http://10.71.161.35:8001/4EFF91728050FE643749C167C73EBCDA6CD8EE193B8636D01B445730BB8A31EE1374186F5611658FD9217AB6FF9BC857DE9D9A8DFA5CFF3C8E063D3B2FA3BB0B1B0EDC7D8B162F850C0A375A45E4CE3B70846A812C626CB5ED09EB107556EECB765BCF39A41BACA755747BE723749A26655D46D004D3DBA34C374CA622B8B0F3E3B2F0E582BA37B4", "10.71.161.35", 8001, "'U}MXig2f9zi:$?_");
                        QLog.e("MsgBackupSettingFragment", 1, "RESULT = " + (String)localObject1);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (getActivity() != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_Awnh);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment
 * JD-Core Version:    0.7.0.1
 */