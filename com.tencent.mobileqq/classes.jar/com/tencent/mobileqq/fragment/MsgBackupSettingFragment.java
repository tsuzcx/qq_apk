package com.tencent.mobileqq.fragment;

import ajjj;
import alud;
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
import asfw;
import asfx;
import asfy;
import asfz;
import asga;
import augc;
import auge;
import augo;
import augu;
import augy;
import auhc;
import auhf;
import auhi;
import auhn;
import auho;
import aujk;
import aujq;
import bdhb;
import bety;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupJniProxy;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;
import xqw;

public class MsgBackupSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public static int a;
  public static auhc a;
  public static String a;
  long jdField_a_of_type_Long;
  private augc jdField_a_of_type_Augc;
  private auge jdField_a_of_type_Auge = new asfz(this);
  private augy jdField_a_of_type_Augy;
  private auhf jdField_a_of_type_Auhf;
  private auhi jdField_a_of_type_Auhi;
  private bety jdField_a_of_type_Bety;
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
  private String jdField_d_of_type_JavaLangString = alud.a(2131707305);
  private final int jdField_e_of_type_Int = 0;
  private String jdField_e_of_type_JavaLangString = alud.a(2131707322);
  private final int jdField_f_of_type_Int = 1;
  private String jdField_f_of_type_JavaLangString;
  private final int jdField_g_of_type_Int = 2;
  private String jdField_g_of_type_JavaLangString;
  private final int h = 3;
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof auhf))
    {
      paramObject = (auhf)paramObject;
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
          localObject1 = new File(paramString).listFiles(new asga(this));
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
              xqw.a(localBitmap, str);
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
      a(alud.a(2131707326));
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
    str2 = aujk.jdField_a_of_type_JavaLangString + "test/" + str2;
    aujq.a("qqdb copy fromPath = %s,toPath = %s,result = %b", str1, new Object[] { str2, Boolean.valueOf(bdhb.d(str1, str2)) });
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
      if (this.jdField_a_of_type_Bety == null) {
        this.jdField_a_of_type_Bety = new bety(getActivity(), getActivity().getTitleBarHeight());
      }
      this.jdField_a_of_type_Bety.a(paramString);
      this.jdField_a_of_type_Bety.c(false);
      this.jdField_a_of_type_Bety.show();
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
      if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
        this.jdField_a_of_type_Bety.dismiss();
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
    this.jdField_a_of_type_Augc = ((augc)getActivity().app.a(162));
    getActivity().app.addObserver(this.jdField_a_of_type_Auge);
    this.vg.setRightButton(alud.a(2131707324));
    this.vg.setLeftButton(alud.a(2131707325));
    ((Button)this.mContentView.findViewById(2131369754)).setOnClickListener(this);
    ((Button)this.mContentView.findViewById(2131375682)).setOnClickListener(this);
    ((Button)this.mContentView.findViewById(2131364691)).setOnClickListener(this);
    this.mContentView.findViewById(2131375625).setOnClickListener(this);
    this.mContentView.findViewById(2131373976).setOnClickListener(this);
    this.mContentView.findViewById(2131378129).setOnClickListener(this);
    this.mContentView.findViewById(2131365877).setOnClickListener(this);
    this.mContentView.findViewById(2131373292).setOnClickListener(this);
    this.mContentView.findViewById(2131364983).setOnClickListener(this);
    this.mContentView.findViewById(2131364310).setOnClickListener(this);
    this.mContentView.findViewById(2131364309).setOnClickListener(this);
    this.mContentView.findViewById(2131364860).setOnClickListener(this);
    this.mContentView.findViewById(2131376992).setOnClickListener(this);
    this.mContentView.findViewById(2131364692).setOnClickListener(this);
    this.mContentView.findViewById(2131364696).setOnClickListener(this);
    this.mContentView.findViewById(2131367804).setOnClickListener(this);
    this.mContentView.findViewById(2131365775).setOnClickListener(this);
    this.mContentView.findViewById(2131376432).setOnClickListener(this);
    this.mContentView.findViewById(2131375681).setOnClickListener(this);
    this.mContentView.findViewById(2131375680).setOnClickListener(this);
    this.mContentView.findViewById(2131379405).setOnClickListener(this);
    this.mContentView.findViewById(2131379404).setOnClickListener(this);
    this.mContentView.findViewById(2131376433).setOnClickListener(this);
    this.mContentView.findViewById(2131370791).setOnClickListener(this);
    this.mContentView.findViewById(2131370809).setOnClickListener(this);
    this.mContentView.findViewById(2131379401).setOnClickListener(this);
    paramLayoutInflater = (TextView)this.mContentView.findViewById(2131376432);
    paramViewGroup = (TextView)this.mContentView.findViewById(2131376433);
    ((EditText)this.mContentView.findViewById(2131368357)).addTextChangedListener(new asfw(this, paramLayoutInflater, paramViewGroup));
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
      ((EditText)this.mContentView.findViewById(2131365878)).setText(paramBundle);
      ((EditText)this.mContentView.findViewById(2131365879)).setText(String.valueOf(i));
      ((EditText)this.mContentView.findViewById(2131366336)).setText(str1);
      ((EditText)this.mContentView.findViewById(2131368357)).setText(str2);
      ((EditText)this.mContentView.findViewById(2131368439)).setText(str3);
    }
    paramLayoutInflater.requestFocus();
    this.jdField_a_of_type_ArrayOfJavaLangString = a();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), new asfx(this));
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getSubThreadLooper(), new asfy(this));
  }
  
  protected int getContentLayoutId()
  {
    return 2131561294;
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    paramView = ((EditText)this.mContentView.findViewById(2131365878)).getText().toString();
    Object localObject4 = ((EditText)this.mContentView.findViewById(2131365879)).getText().toString();
    Object localObject2 = ((EditText)this.mContentView.findViewById(2131368357)).getText().toString();
    Object localObject1 = ((EditText)this.mContentView.findViewById(2131366336)).getText().toString();
    Object localObject3 = ((EditText)this.mContentView.findViewById(2131368439)).getText().toString();
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
      localObject2 = augo.a();
      localObject3 = (augc)getActivity().app.a(162);
      localObject4 = new auhn();
      localArrayList = new ArrayList(2);
    }
    switch (m)
    {
    case 2131373292: 
    default: 
    case 2131369754: 
    case 2131375682: 
    case 2131364691: 
    case 2131375625: 
    case 2131373976: 
    case 2131378129: 
    case 2131365877: 
    case 2131364983: 
    case 2131376432: 
    case 2131376433: 
    case 2131376430: 
    case 2131364310: 
    case 2131364309: 
    case 2131364860: 
    case 2131376992: 
    case 2131364692: 
    case 2131364696: 
    case 2131367804: 
    case 2131365775: 
    case 2131375681: 
    case 2131375680: 
    case 2131379405: 
    case 2131379404: 
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
            QQToast.a(getActivity(), -1, alud.a(2131707323), 1).a();
            ((auhn)localObject4).c(this.jdField_a_of_type_ArrayOfJavaLangString[1]);
            ((auhn)localObject4).b(this.jdField_a_of_type_ArrayOfJavaLangString[0]);
            ((auhn)localObject4).a(aujq.a(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4));
            localArrayList.add(Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port));
            localArrayList.add(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port));
            ((auhn)localObject4).a(localArrayList);
            ((auhn)localObject4).a(4);
            ((augc)localObject3).a(((auhn)localObject4).a(), 3, false);
            return;
          } while ((this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint == null) || (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint == null));
          QQToast.a(getActivity(), -1, alud.a(2131707320), 1).a();
          if (jdField_a_of_type_Auhc != null)
          {
            ((auhn)localObject4).c(this.jdField_a_of_type_ArrayOfJavaLangString[1]);
            ((auhn)localObject4).b(this.jdField_a_of_type_ArrayOfJavaLangString[0]);
            ((auhn)localObject4).a(aujq.a(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4));
            localArrayList.add(Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port));
            localArrayList.add(Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port));
            ((auhn)localObject4).a(localArrayList);
            ((auhn)localObject4).a(4);
            ((augc)localObject3).a(((auhn)localObject4).a(), jdField_a_of_type_Auhc.a(), 3);
            return;
          }
          QLog.d("MsgBackup", 1, "case confirmQR qrResponse is null!");
          return;
          if (jdField_a_of_type_Auhc != null)
          {
            ((augc)localObject3).a(jdField_a_of_type_Auhc.a(), 3);
            return;
          }
          QLog.d("MsgBackup", 1, "case rejectQR qrResponse is null!");
          return;
          if (jdField_a_of_type_Auhc != null)
          {
            ((augc)localObject3).c(jdField_a_of_type_Auhc.a());
            return;
          }
          QLog.d("MsgBackup", 1, "case queryQRState qrResponse is null!");
          return;
          if (this.jdField_a_of_type_Augy != null)
          {
            ((augc)localObject3).a(this.jdField_a_of_type_Augy.a());
            return;
          }
          QLog.d("MsgBackup", 1, "case tokenConfirm qrConfirmReponse is null!");
          return;
          ((augo)localObject2).jdField_a_of_type_JavaUtilHashSet.clear();
          getActivity().app.a().a();
          paramView = ajjj.a(paramView, j);
          paramView = ajjj.a().a(paramView);
          if (paramView != null)
          {
            ((augo)localObject2).jdField_a_of_type_JavaUtilHashSet.add(paramView);
            paramView = new augu();
            paramView.jdField_a_of_type_JavaUtilHashSet = augo.a().jdField_a_of_type_JavaUtilHashSet;
            paramView.jdField_a_of_type_Int = 0;
            ((augo)localObject2).a(paramView);
            return;
          }
          QLog.d("MsgBackup", 1, "test export submit,recentBaseData is null");
          return;
          augo.a().c(null);
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
          ((augo)localObject2).f();
          return;
          a();
          return;
          d();
          return;
          a(this.jdField_a_of_type_Auhf);
          return;
          a(this.jdField_a_of_type_Auhf);
          return;
          QQToast.a(getActivity(), -1, alud.a(2131707319), 1).a();
          return;
          paramView = MsgBackupJniProxy.encryptFromString("i am a hero!!!", "1111111111111111");
          aujq.a("MsgBackup", alud.a(2131707327), new Object[] { "i am a hero!!!", paramView });
          localObject1 = MsgBackupJniProxy.decryptFromString(paramView, "1111111111111111");
          aujq.a("MsgBackup", alud.a(2131707311), new Object[] { paramView, localObject1 });
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
          aujq.a("MsgBackup", alud.a(2131707313), new Object[] { Integer.valueOf(localObject1.length), Integer.valueOf(paramView.length) });
          localObject1 = MsgBackupJniProxy.decryptFromByteArray(paramView, "1111111111111111");
          aujq.a("MsgBackup", alud.a(2131707298), new Object[] { Integer.valueOf(paramView.length), Integer.valueOf(localObject1.length) });
          return;
          this.jdField_a_of_type_Augc.a();
          return;
        } while (TextUtils.isEmpty(augo.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_Augc.b(augo.jdField_a_of_type_JavaLangString);
        return;
        this.jdField_c_of_type_JavaLangString = Uri.encode("111111111111111111");
        aujq.a("IphoneTitleBarFragment", "编码之后的value = %s", new Object[] { this.jdField_c_of_type_JavaLangString });
        return;
      } while (this.jdField_c_of_type_JavaLangString == null);
      aujq.a("IphoneTitleBarFragment", "解码之后的value = %s", new Object[] { Uri.decode(this.jdField_c_of_type_JavaLangString) });
      return;
    case 2131370791: 
      auho.a(getActivity().app);
      return;
    case 2131370809: 
      if (i > 0) {}
      for (;;)
      {
        localObject1 = auho.a(null, i, paramView, j, getActivity().app.c());
        if (((List)localObject1).size() > 0) {
          auho.a(getActivity().app, (List)localObject1);
        }
        paramView = MessageRecord.getTableName(paramView, j);
        i = getActivity().app.a().a(paramView, 0L, 9223372036854775807L, false);
        ((TextView)getActivity().findViewById(2131370808)).setText("result:msgSize =  " + i);
        return;
        i = 0;
      }
    }
    c();
    paramView = aujq.a("http://10.71.161.35:8001/4EFF91728050FE643749C167C73EBCDA6CD8EE193B8636D01B445730BB8A31EE1374186F5611658FD9217AB6FF9BC857DE9D9A8DFA5CFF3C8E063D3B2FA3BB0B1B0EDC7D8B162F850C0A375A45E4CE3B70846A812C626CB5ED09EB107556EECB765BCF39A41BACA755747BE723749A26655D46D004D3DBA34C374CA622B8B0F3E3B2F0E582BA37B4", aujq.a("10.71.161.35"), 8001, "'U}MXig2f9zi:$?_");
    QLog.e("MsgBackupSettingFragment", 1, "RESULT = " + paramView);
  }
  
  public void onDestroy()
  {
    if (getActivity() != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_Auge);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment
 * JD-Core Version:    0.7.0.1
 */